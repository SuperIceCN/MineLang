cd "${1}" || exit
for file in ./*;
do
zip -r "$file.zip" "./zipped/$file"
done