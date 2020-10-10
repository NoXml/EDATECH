import java.util.concurrent.ThreadLocalRandom

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class EntityLoadSimulation extends Simulation {

  private val testDuration = 10
  private val users = 20000 // simultaneously connections
  private val baseURL = "http://localhost:8090" // app location
  private val baseName = "Load testing entity controller"

  private val httpConf = http
    .baseUrl(baseURL)
    .acceptHeader("text/html,application/xhtml+xml,application/json;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0") // Firefox browser

  private val scn = scenario(baseName).exec {
    val id = ThreadLocalRandom.current().nextInt(users)
    exec(
      http("Create entity")
        .post("/entities")
        .header(HttpHeaderNames.ContentType, HttpHeaderValues.ApplicationJson)
        .body(StringBody(
          s"""{"name": "name$id"}"""))
        .check(status.is(200))
        .check(jsonPath("$.status").is("Success"))
        .check(jsonPath("$.result.id").saveAs("generatedId")))
      .exec(
        http("Get entity")
          .get("/entities/${generatedId}")
          .header(HttpHeaderNames.ContentType, HttpHeaderValues.ApplicationJson)
          .check(status.is(200))
          .check(jsonPath("$.status").is("Success")))
  }

  setUp(
    scn
      .inject(rampUsers(users) during (2 minutes))
      .throttle(reachRps(10000) in (10 seconds), holdFor(testDuration minutes))
  ).protocols(httpConf)
}