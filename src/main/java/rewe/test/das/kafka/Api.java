package rewe.test.das.kafka;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import javax.inject.Inject;

import static rewe.test.das.util.CustomMediaType.APPLICATION_JSON_UTF8;

@Controller
public class Api {

  private ProducerService producerService;

  @Inject
  public Api(ProducerService producerService) {
    this.producerService = producerService;
  }

  @Get
  @Produces(APPLICATION_JSON_UTF8)
  public String KafkaController() {
    producerService.sendMessage("{\"name\":\"öäaldsfüp\"}");

    return "Message sent! Should be consumed in a moment...";
  }

  //@Get
  //@Produces(APPLICATION_JSON_UTF8)
  //public String KafkaController() {
  //  return "Message sent! Should be consumed in a moment...";
  //}
}
