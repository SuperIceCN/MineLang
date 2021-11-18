cd "${1}" || exit
mkdir "./zipped"
for file in ./*;
do
  zip -r "./zipped/$file.zip" "$file"
done