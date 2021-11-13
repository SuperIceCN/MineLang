cd /d ./MineLauncher/target/libs

echo|set /p="%1\bin\native-image -cp " >> compile.cmd

for %%i in (*.jar) do @echo|set /p="%%i;" >> compile.cmd

for %%j in (../MineLauncher*.jar) do @echo ; -jar ../%%j >> compile.cmd

compile.cmd
