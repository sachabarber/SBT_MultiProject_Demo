package sacha.server

import sacha.common.ILogger

class Logger extends  ILogger{
  override def Log(input: String): Unit = {
    Console.println(s"Input was : $input")
  }
}

