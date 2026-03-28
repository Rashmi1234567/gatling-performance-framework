package requests
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object BookingRequests {
val getToken=exec(http("Auth Token")
                      .post("/auth")
                      .body(StringBody(
                        """
                          {
                          "username":"admin",
                          "password":"password123"
                          }
                          """
                      )).asJson
  .check(jsonPath("$.token").saveAs("token"))
)
  val createBooking =
    exec(
      http("Create Booking")
        .post("/booking")
        .body(StringBody(
          """
          {
            "firstname": "John",
            "lastname": "Doe",
            "totalprice": 100,
            "depositpaid": true,
            "bookingdates": {
              "checkin": "2024-01-01",
              "checkout": "2024-01-05"
            },
            "additionalneeds": "Breakfast"
          }
          """
        )).asJson
        .check(jsonPath("$.bookingid").saveAs("bookingId"))
    )

  val getBooking =
    exec(
      http("Get Booking")
        .get("/booking/${bookingId}")
        .check(status.is(200))
    )


}
