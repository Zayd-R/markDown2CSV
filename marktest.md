# Scala Study Notes

## What is Scala?
Scala is a programming language that combines object-oriented and functional programming paradigms. It runs on the JVM and is statically typed.

## What does the name "Scala" mean?
It comes from "scalable language" - designed to grow with the demands of its users.

## Basic Concepts

## What is immutability?
Immutability means that once a value is created, it cannot be changed. In Scala, this is achieved using `val` instead of `var`.

## Why use immutable data structures?

Benefits include:
- Thread safety without locks
- Easier to reason about code
- Prevention of unexpected side effects
- Better support for functional programming

Multiple paragraphs work too!


## Code Examples

## How do you define a case class?
```scala
case class Person(name: String, age: Int)
val john = Person("John", 30)
```

Case classes automatically get apply, unapply, copy, equals, hashCode, and toString methods.

## What is pattern matching in Scala?
```scala
value match {
  case Some(x) => println(s"Got $x")
  case None => println("Got nothing")
}
```

It's similar to switch statements but much more powerful.

## Advanced Topics

## What is a monad?
A monad is a type class with two operations: `flatMap` (or `bind`) and `pure` (or `unit`). It represents computations as a series of steps.

Common monads include Option, List, Future, and Either.

## Q&A Format Section

Q: What is the difference between `map` and `flatMap`?
A: `map` transforms the value inside a wrapper, while `flatMap` transforms and flattens nested wrappers. For example, `List(1,2,3).map(x => List(x, x*2))` gives `List(List(1,2), List(2,4), List(3,6))`, but with `flatMap` it gives `List(1,2,2,4,3,6)`.

Q: What is a higher-order function?
A: A function that takes other functions as parameters or returns a function as a result.

Q: How do you handle errors in functional programming?

A: Using types like Option, Either, or Try instead of exceptions:
```scala
def divide(a: Int, b: Int): Option[Int] = 
  if (b == 0) None else Some(a / b)
```

## Edge Cases

## What about questions with quotes?
She said "Hello world!" and he replied "Hi there!" - quotes should be escaped in CSV.

## What if there's a comma, in the question?
The answer also has commas, semicolons; and other punctuation: that needs proper CSV escaping!

## Empty answers are valid too

## Questions with "special" characters: <, >, &, etc.?
These need to be handled properly: 5 < 10, x > y, this & that.

## What about very long answers that span multiple paragraphs?

This is the first paragraph of a long answer.

This is the second paragraph. Some flashcard systems handle this fine.

And here's a third paragraph for good measure.

## Multi-line code blocks
```scala
object Example {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    
    val numbers = List(1, 2, 3, 4, 5)
    val doubled = numbers.map(_ * 2)
    
    doubled.foreach(println)
  }
}
```

Code blocks can have empty lines and indentation that should be preserved.

## Mixed Q&A Format

Q: Can you mix header and Q: formats in the same document?
A: Yes! A good parser should handle both.

## What about inline `code` in questions?
Inline code like `flatMap` or `Option[T]` should work in both questions and answers.

Q: Does inline `code` work in Q:/A: format too?
A: Yes, like `map`, `filter`, and `reduce` - all should be preserved.

## Tricky Edge Cases

## What if ## appears in the answer text?
The answer might reference markdown syntax like "use ## for headers" - this shouldn't be treated as a new question!

##What if there's no space after the hash?
This should probably still be recognized as a question (user error).

##     What about extra spaces?
     This answer has weird indentation but should still work.

## Questions without answers?

## Another question without an answer?

## Final question with answer
This is the last card in the deck.

Q: What about trailing Q: without A:?

Q: Last Q: format question
A: Last answer!

## Special formatting

## What is **bold** and *italic* text?
Markdown allows **bold** with double asterisks and *italic* with single asterisks. These might get preserved or stripped depending on your parser.

Q: How about lists in answers?
A: Lists work like this:
- First item
- Second item
- Third item

## Unicode and special characters

## What about émojis 🚀 and ünïcödé?
Modern flashcard tools should handle UTF-8: café, naïve, 日本語, 你好, مرحبا

## Code without language specified
```
// Code block without language tag
function hello() {
  return "world";
}
```

## Nested markdown structures

## What about nested lists?
- Top level
    - Nested level
        - Deep nested
- Back to top

Q: Do nested code blocks work?
A: Code in code might be tricky:
```
outer code
  inner code
    very nested
```

## Tab characters and weird whitespace

##	Question with tab character
Answer with		multiple	tabs	inside.

## End of document edge case

## Last question
Last answer - make sure this gets captured even at EOF!