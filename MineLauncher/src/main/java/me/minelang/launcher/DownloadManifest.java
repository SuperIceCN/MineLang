package me.minelang.launcher;

import com.google.gson.JsonParser;
import okhttp3.*;
import okio.*;
import org.fusesource.jansi.AnsiConsole;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static me.minelang.launcher.I18NUtil.get;
import static me.minelang.launcher.PrintUtil.*;
import static me.minelang.launcher.Utils.bytes2MB;

public final class DownloadManifest {
    public static String GRAALVM_MANIFEST_URL = "https://assets.minelang.me/graal_manifest.json";
    public static String VERSION_MANIFEST_URL = "https://assets.minelang.me/version_manifest.json";
    public static String REFERER = "https://launcher.minelang.me";

    public String GraalVersion = null;
    public String GraalURL = null;
    public String LatestMineLangVersion = null;

    final OkHttpClient client;

    public DownloadManifest(OkHttpClient client) {
        this.client = client;
        this.fetchAndParseManifest();
    }

    public DownloadManifest() {
        this(new OkHttpClient.Builder().addNetworkInterceptor(chain -> {
                    var originalResponse = chain.proceed(chain.request());
                    var previousReadBytes = new Utils.Store<>(0L);
                    var previousTime = new Utils.Store<>(System.nanoTime());
                    var looper = new Utils.Store<>(0);
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), (bytesRead, contentLength, done) -> {
                                if (done) {
                                    print("§p");
                                } else {
                                    if (contentLength != -1 && looper.get() > 100) {
                                        looper.set(0);
                                        var percent = ((float) bytesRead / contentLength);
                                        var width = AnsiConsole.getTerminalWidth();
                                        if (width == 0) width = 80;
                                        var len = Math.round((width - 48) * percent);
                                        var current = System.nanoTime();
                                        if (current == previousTime.get()) {
                                            return;
                                        }
                                        var speed = ((float)(bytesRead - previousReadBytes.get())) / (System.nanoTime() - previousTime.get()) * 1000;
                                        print(get("download_process", bytes2MB(bytesRead), bytes2MB(contentLength)
                                                , " ".repeat(len), " ".repeat(width - 48 - len), "%.2f".formatted(percent * 100), "%.2f".formatted(speed)));
                                        previousReadBytes.set(bytesRead);
                                        previousTime.set(System.nanoTime());
                                    } else {
                                        looper.set(looper.get() + 1);
                                    }
                                }
                            }))
                            .build();
                })
                .build());
    }

    public void fetchAndParseManifest() {
        var request = new Request.Builder().get()
                .url(GRAALVM_MANIFEST_URL).addHeader("Referer", REFERER).build();
        info(get("fetch_manifest_from", "GraalVM", GRAALVM_MANIFEST_URL));
        print("");
        try (var response = this.client.newCall(request).execute()) {
            var json = JsonParser.parseReader(Objects.requireNonNull(response.body()).charStream()).getAsJsonObject();
            this.GraalVersion = json.get("GraalVersion").getAsString();
            this.GraalURL = json.get("GraalURL").getAsString();
        } catch (IOException e) {
            error(get("fail_to_fetch_manifest", "GraalVM", GRAALVM_MANIFEST_URL));
            throw new FailedException();
        }

        var request2 = new Request.Builder().get()
                .url(VERSION_MANIFEST_URL).addHeader("Referer", REFERER).build();
        info(get("fetch_manifest_from", "MineLang Version", VERSION_MANIFEST_URL));
        print("");
        try (var response = this.client.newCall(request2).execute()) {
            var json = JsonParser.parseReader(Objects.requireNonNull(response.body()).charStream()).getAsJsonArray();
            var verObj = json.get(0).getAsJsonObject();
            this.LatestMineLangVersion = verObj.get("version").getAsString() + (verObj.get("beta").getAsBoolean() ? "-beta" : "");
        } catch (IOException e) {
            error(get("fail_to_fetch_manifest", "MineLang Version", VERSION_MANIFEST_URL));
            throw new FailedException();
        }
    }

    public void downloadGraalVM() {

    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void downloadLib() {
        var cacheDir = new File("./.tmp");
        cacheDir.mkdirs();
        var libURL = "https://assets.minelang.me/MineLang-" + this.LatestMineLangVersion + "/MineLangLib.zip";
        var request = new Request.Builder().url(libURL).addHeader("Referer", REFERER).build();
        info(get("download_from", get("minelang_lib"), libURL));
        print("");
        try (var response = this.client.newCall(request).execute()){
            var dest = new File("./.tmp/MineLangLib.zip");
            var sink = Okio.sink(dest);
            var bufferedSink = Okio.buffer(sink);
            bufferedSink.writeAll(Objects.requireNonNull(response.body()).source());
            bufferedSink.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void downloadMineLang() {

    }

    private static class ProgressResponseBody extends ResponseBody {

        private final ResponseBody responseBody;
        private final ProgressListener progressListener;
        private BufferedSource bufferedSource;

        ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
            this.responseBody = responseBody;
            this.progressListener = progressListener;
        }

        @Override
        public MediaType contentType() {
            return responseBody.contentType();
        }

        @Override
        public long contentLength() {
            return responseBody.contentLength();
        }

        @NotNull
        @Override
        public BufferedSource source() {
            if (bufferedSource == null) {
                bufferedSource = Okio.buffer(source(responseBody.source()));
            }
            return bufferedSource;
        }

        private Source source(Source source) {
            return new ForwardingSource(source) {
                long totalBytesRead = 0L;

                @Override
                public long read(@NotNull Buffer sink, long byteCount) throws IOException {
                    long bytesRead = super.read(sink, byteCount);
                    // read() returns the number of bytes read, or -1 if this source is exhausted.
                    totalBytesRead += bytesRead != -1 ? bytesRead : 0;
                    progressListener.update(totalBytesRead, responseBody.contentLength(), bytesRead == -1);
                    return bytesRead;
                }
            };
        }
    }

    interface ProgressListener {
        void update(long bytesRead, long contentLength, boolean done);
    }
}
