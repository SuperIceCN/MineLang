cd "${1}" || exit
for file in ./*;
do
zip -r "./zipped/$file.zip" "$file"
done