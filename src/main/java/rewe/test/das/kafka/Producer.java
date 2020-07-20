package rewe.test.das.kafka;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;

import java.util.UUID;

@KafkaClient
public interface Producer {

  @Topic("micronaut")
  void sendMessage(@KafkaKey UUID brandUUID, String value);
}
