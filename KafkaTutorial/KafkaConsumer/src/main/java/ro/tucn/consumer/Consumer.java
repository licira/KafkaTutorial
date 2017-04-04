package ro.tucn.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created by Liviu on 4/1/2017.
 */
public class Consumer {

    private static final String producerHost = "172.31.31.123";
    private static final String producerPort = ":9092";

    public Consumer() { }

    public void run() {
        Properties props = getConsumerProperties();

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        String topic = "test";
        consumer.subscribe(Arrays.asList(topic));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.println(record.offset() + " " + record.key() + " " + record.value());
        }
    }

    public static Properties getConsumerProperties() {
        Properties props = new Properties();
        props.put("bootstrap.servers", producerHost + producerPort);
        props.put("group.id", "test");
        //props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("enable.auto.commit", "false");
        props.put("auto.offset.reset", "earliest");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return props;
    }
}
