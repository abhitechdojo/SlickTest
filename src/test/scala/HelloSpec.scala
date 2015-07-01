import org.scalatest._
import com.example._

class HelloSpec extends FlatSpec with Matchers {
  "Hello" should "have tests" in {
  	//PeopleDAO.createTable()
  	val x = PeopleDAO.checkTable("PEOPLE")
  	println(x)
  	1 === 1
  }
}
