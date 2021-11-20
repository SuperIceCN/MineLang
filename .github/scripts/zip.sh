cd "${1}" || exit
mkdir "./zipped"
for file in ./*;
do
  if [ "$file" != "zipped" ]; then
      zip -r "./zipped/$file.zip" "$file/*"
  fi
done