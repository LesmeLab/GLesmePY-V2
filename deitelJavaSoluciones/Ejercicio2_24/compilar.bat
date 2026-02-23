@echo off
REM Cambia al directorio del propio .bat
cd /d "%~dp0"

REM Compila todos los archivos .java en esta carpeta
javac *.java

echo.
echo Compilacion terminada. Ahora puedes ejecutar tus clases con:
echo java NombreDeClase
echo.

REM Mantener la consola abierta sin salir
cmd /k
