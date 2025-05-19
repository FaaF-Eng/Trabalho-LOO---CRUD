@echo off
mkdir bin
javac -cp "lib/*" -d bin src/*.java
echo Compilação concluída.
pause