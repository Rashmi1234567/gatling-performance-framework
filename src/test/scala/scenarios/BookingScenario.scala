package scenarios
import feeders.BookingFeeder
import io.gatling.core.Predef._
import requests.BookingRequests._

object BookingScenario {
  val scn  = scenario("Booking Flow")
    .exec(getToken)
    .exec(createBooking)
    .exec(getBooking)
    //.feed(BookingFeeder.feeder)

}
