#!/bin/bash

# Duck Simulator - Build and Run Script

echo "╔════════════════════════════════════════════╗"
echo "║   Duck Simulator - Build & Run Script      ║"
echo "╚════════════════════════════════════════════╝"
echo ""

# Get the directory where this script is located
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd "$SCRIPT_DIR"

# Create bin directory
echo "📁 Creating build directory..."
mkdir -p bin

# Compile
echo "🔨 Compiling Java sources..."
javac -d bin src/**/*.java src/Main.java 2>&1

if [ $? -ne 0 ]; then
    echo "❌ Compilation failed!"
    exit 1
fi

echo "✅ Compilation successful!"
echo ""

# Run
echo "🚀 Running Duck Simulator..."
echo "════════════════════════════════════════════"
echo ""
java -cp bin Main

echo ""
echo "════════════════════════════════════════════"
echo "✨ Goodbye from Duck Simulator!"
