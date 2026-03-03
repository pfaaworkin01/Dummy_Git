@echo off
REM Duck Simulator - Build and Run Script for Windows

echo.
echo ╔════════════════════════════════════════════╗
echo ║   Duck Simulator - Build ^& Run Script      ║
echo ╚════════════════════════════════════════════╝
echo.

REM Create bin directory
echo 📁 Creating build directory...
if not exist "bin" mkdir bin

REM Compile
echo 🔨 Compiling Java sources...
javac -d bin src/animals/*.java src/factories/*.java src/decorators/*.java src/composite/*.java src/observer/*.java src/Main.java 2>&1

if errorlevel 1 (
    echo ❌ Compilation failed!
    pause
    exit /b 1
)

echo ✅ Compilation successful!
echo.

REM Run
echo 🚀 Running Duck Simulator...
echo ════════════════════════════════════════════
echo.
java -cp bin Main

echo.
echo ════════════════════════════════════════════
echo ✨ Goodbye from Duck Simulator!
pause
