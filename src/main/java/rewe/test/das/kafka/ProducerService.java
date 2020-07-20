package rewe.test.das.kafka;

import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Requires;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.UUID;

@Requires(classes = Producer.class)
@Singleton
@Context
public class ProducerService {

  private Producer kafkaProducer;

  @Inject
  public ProducerService(Producer kafkaProducer) {
    this.kafkaProducer = kafkaProducer;
  }

  public void sendMessage(String message) {
    kafkaProducer.sendMessage(UUID.randomUUID(), message);
  }
}
