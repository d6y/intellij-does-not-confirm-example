
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import cats.data.{Xor, XorT}
import cats.std.future._

class Example {

  val success: Future[String Xor Int] = Future.successful(Xor.Right(1))

  val transformer: XorT[Future, String, Int] = for {
    a <- XorT[Future, String, Int] { success }
  } yield a

}

