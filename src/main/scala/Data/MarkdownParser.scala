package Data
import os.*
import serializer.Serializer

final case class FlashCard(question: String, answer: String = "", tags: List[String] = List.empty)
object FlashCard {
  given Serializer[FlashCard] with {
    override def stringfy(value: FlashCard): String = {
      value.question + "," + value.answer + ", " + value.tags.mkString("\"" , " ", "\"")
    }
  }

  extension (flashcard: FlashCard)
    def serialize(using serlialier: Serializer[FlashCard]): String = {
      serlialier.stringfy(flashcard)
    }
}
final case class State (
                       completed: List[FlashCard] = List.empty,
                       question: Option[String] = None,
                       answer: List[String] = List.empty,
                       currentSection: List[String] = List.empty
                       )


object MarkdownParser {

  private def handleDublicateQ(state: State, question: String): State = {
    // there is no current flashcard in state
    if (state.question.isEmpty)
      state.copy(question = Option(question))
    // TODO: the prev header is treated as tag and next header is the question
    else if (state.answer.isEmpty) state.copy(question = Option(question), currentSection = List(state.question.get))
    else state.copy(completed = state.completed.appended(FlashCard(state.question.get.trim, state.answer.mkString("\"" , "\n", "\""), state.currentSection)),
      question = Option(question), answer = List.empty)
  }
  def parseFile(filePath: String): List[FlashCard] = {
    val path = os.pwd / filePath
    val headerQuestionRegex = "^##\\s+(.+)$".r
    val questionRegex = "^Q:\\s*(.+)$".r
    val aRegex = "^A:\\s*(.+)$".r

    val content = os.read.lines.stream(path)
    val res = content.foldLeft( State() )( (acc, line) => {
      line match {
        // if line is [## ....]
        case headerQuestionRegex(line) =>  handleDublicateQ(acc, line)
        case questionRegex(line) => handleDublicateQ(acc, line)
        case aRegex(line) => acc.copy(answer = acc.answer.appended(line))
        case any =>  if any.trim.isEmpty && acc.answer.isEmpty
                     then acc
                     else acc.copy(answer = acc.answer.appended(any))
      }
    })
    res.completed.appended(FlashCard(res.question.get, res.answer.mkString("\"" , "\n", "\""), res.currentSection))
  }

  def writeto(filePath: String, content: List[String]): Unit = {
    val path = os.pwd / (filePath + ".csv")
    os.write.over(path, content.mkString("\n"))
  }
}



