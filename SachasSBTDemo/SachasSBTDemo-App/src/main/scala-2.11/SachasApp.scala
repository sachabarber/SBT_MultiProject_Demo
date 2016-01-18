
import sacha.server.Logger

object SachasApp extends App {
  val x = new Logger()
  x.Log("Its working")
  scala.io.StdIn.readLine()
}
