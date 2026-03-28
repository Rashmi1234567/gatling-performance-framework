package simulations
import io.gatling.core.Predef._
import scala.concurrent.duration._
import config.BaseConfig._
import scenarios.BookingScenario._

class BookingSimulation extends Simulation {
   setUp(
     scn.inject(
       rampUsers(50).during(30.seconds),
       constantUsersPerSec(10).during(1.minute)
     )
   ).protocols(httpProtocol)
}
