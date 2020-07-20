package rewe.test.das.kafka;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Context;

import javax.inject.Singleton;
import java.util.UUID;

@Singleton
@Context
@KafkaListener(offsetReset = OffsetReset.EARLIEST)
public class Consumer {

  @Topic("micronaut")
  public void receive(@KafkaKey UUID brandUUID, String value) {
    System.out.println("Got message: " + brandUUID + " " + value);
  }
}
