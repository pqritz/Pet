@echo off
setlocal

set "BatchPath=%~dp0"
set "JarFile=Pet.jar"
set "FullPath=%BatchPath%%JarFile%"

cd /d "%BatchPath%"

"C:\Program Files\Java\jdk-16.0.2\bin\java.exe" -jar %FullPath%

endlocal