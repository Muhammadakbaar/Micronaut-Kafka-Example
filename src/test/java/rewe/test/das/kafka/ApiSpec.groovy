package rewe.test.das.kafka

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class ApiSpec extends Specification {

  @Inject
  @Client("/")
  RxHttpClient httpClient;

  def "test, if the endpoint returns the expected JSON"() {
    given:
      def request = HttpRequest.GET("/")

    when:
      def response = httpClient.toBlocking().retrieve(request)

    then:
      "Message sent! Should be consumed in a moment..." == response
  }
}
