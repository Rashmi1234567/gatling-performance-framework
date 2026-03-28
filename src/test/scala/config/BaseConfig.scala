package config
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object BaseConfig {
  val httpProtocol=http.baseUrl("https://restful-booker.herokuapp.com/")
    .contentTypeHeader("application/json")
}
