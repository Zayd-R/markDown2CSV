import Data.MarkdownParser

object App {

  def main(args: Array[String]): Unit = {
    // get file path of markdown
    // get file path/ name of output default to fileName.csv in .
    // handle parsing by a parser
    // serilaize to csv
    // wrrite to output

    println("-----------------------------------------------------------------")

    if args.length < 1 || args.length > 2
      then println("[USAGE] [markdown path] [output path]...")
    else
      val parser = MarkdownParser.parseFile(args(0))
      val stringsList = parser.map(flash => flash.serialize)
      val writing = MarkdownParser.writeto(args(1), stringsList)

    println("Bye Bye markdown tool")
  }
}
