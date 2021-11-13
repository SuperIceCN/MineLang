import me.minelang.launcher.InfoCollector;
import org.junit.Test;

public class TestCollector {
    @Test
    public void testGraalVMInfo() {
        System.out.println(new InfoCollector().GraalPath);
    }
}
