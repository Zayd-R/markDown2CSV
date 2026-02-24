# md2cards

Convert markdown notes to Anki flashcards (CSV format).

## Features

- Parse `## Header` format as questions
- Parse `Q: / A:` format
- Preserve code blocks and formatting
- Auto-tag questions by section headers
- Export to Anki-compatible CSV

## Installation

### Linux

Download the binary from [Releases](https://github.com/Zayd-R/markDown2CSV/edit/main/README.md):
```bash
# Download
wget https://github.com/Zayd-R/markDown2CSV/releases/download/v0.1.0/md2cards-linux

# Make executable
chmod +x md2cards-linux

# Move to your PATH (optional)
sudo mv md2cards-linux /usr/local/bin/md2cards
```

### macOS
```bash
# Download
curl -L -o md2cards-macos https://github.com/Zayd-R/markDown2CSV/releases/download/v0.1.0/md2cards-linux

# Make executable
chmod +x md2cards-macos

# Move to your PATH (optional)
sudo mv md2cards-macos /usr/local/bin/md2cards
```

## Usage
```bash
md2cards notes.md flashcards
```

Then import `flashcards.csv` into Anki (File → Import).

## Example Input
```markdown
## Scala Basics

## What is Scala?
A programming language that combines OOP and FP.

## What is immutability?
Values that cannot be changed after creation.
```

## Example Output
```csv
"Front","Back","Tags"
"What is Scala?","A programming language that combines OOP and FP.","scala-basics"
"What is immutability?","Values that cannot be changed after creation.","scala-basics"
```

## Building from Source

Requires Scala Native toolchain:
```bash
# Install dependencies (Ubuntu)
sudo apt install clang libunwind-dev libgc-dev

# Build
sbt nativeLink

# Binary will be at: target/scala-3.3.1/md2cards-out
```

## License
MIT
```
---

