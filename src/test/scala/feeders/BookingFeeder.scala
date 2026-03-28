package feeders
import io.gatling.core.Predef._


object BookingFeeder {
  val feeder =csv("data.csv").circular
}
