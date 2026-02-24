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

Download the binary from [Releases](https://github.com/YOUR_USERNAME/md2cards/releases):
```bash
# Download
wget https://github.com/YOUR_USERNAME/md2cards/releases/download/v0.1.0/md2cards-linux

# Make executable
chmod +x md2cards-linux

# Move to your PATH (optional)
sudo mv md2cards-linux /usr/local/bin/md2cards
```

### macOS
```bash
# Download
curl -L -o md2cards-macos https://github.com/YOUR_USERNAME/md2cards/releases/download/v0.1.0/md2cards-macos

# Make executable
chmod +x md2cards-macos

# Move to your PATH (optional)
sudo mv md2cards-macos /usr/local/bin/md2cards
```

## Usage
```bash
md2cards notes.md -o flashcards.csv
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

## **4. Create a GitHub Release**

**On GitHub website:**

1. Go to your repo → "Releases" → "Create a new release"
2. Tag: `v0.1.0`
3. Title: `v0.1.0 - Initial Release`
4. Description:
```
First release of md2cards!

Features:
- Parse ## headers and Q:/A: format
- Preserve code blocks
- Auto-tagging by sections
- Export to Anki CSV

Download the binary for your platform below.
