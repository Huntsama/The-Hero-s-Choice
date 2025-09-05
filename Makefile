# The Hero's Choice - Makefile

# Variables
SRC_DIR = src
BUILD_DIR = build
MAIN_CLASS = game.HeroesChoiceMain

# Default target
all: compile

# Compile all Java files
compile:
	@echo "Compiling Java files..."
	@mkdir -p $(BUILD_DIR)
	find $(SRC_DIR) -name "*.java" | xargs javac -d $(BUILD_DIR) -cp $(BUILD_DIR)
	@echo "Compilation complete!"

# Run the game
run: compile
	@echo "Starting The Hero's Choice..."
	java -cp $(BUILD_DIR) $(MAIN_CLASS)

# Clean build directory
clean:
	@echo "Cleaning build directory..."
	rm -rf $(BUILD_DIR)/*.class
	@echo "Clean complete!"

# Full clean (including build directory)
clean-all:
	@echo "Removing build directory..."
	rm -rf $(BUILD_DIR)
	@echo "Full clean complete!"

# Help target
help:
	@echo "Available targets:"
	@echo "  compile   - Compile all Java source files"
	@echo "  run       - Compile and run the game"
	@echo "  clean     - Remove compiled class files"
	@echo "  clean-all - Remove entire build directory"
	@echo "  help      - Show this help message"

.PHONY: all compile run clean clean-all help