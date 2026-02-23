# Cambia al directorio donde está el script
Set-Location $PSScriptRoot

# Compila todos los archivos .java en esta carpeta
javac *.java

Write-Host ""
Write-Host "Compilación terminada. Los archivos .class están listos."
Write-Host "Puedes ejecutar una clase con: java NombreDeClase"
Write-Host ""

# Mantener la consola abierta
powershell -NoExit
