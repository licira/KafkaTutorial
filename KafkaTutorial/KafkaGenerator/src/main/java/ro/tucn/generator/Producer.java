package ro.tucn.generator;

import org.I0Itec.zkclient.ZkClient;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Liviu on 4/1/2017.
 */
public class Producer {

    private static final String host = "54.87.160.43";
    private static final String port = ":9092";

    public Producer() { }

    public void run() {
        Properties props = getProducerProperties();

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

        String topic = "test";

        for(int i = 0; i < 100; i++) {
            producer.send(new ProducerRecord<String, String>(topic, Integer.toString(i), Integer.toString(i)));
        }

        producer.close();
    }

    public static Properties getProducerProperties() {
        Properties props = new Properties();
        props.put("bootstrap.servers", host + port);
        props.put("metadata.broker.list", host + port);
        props.put("group.id", "test");
        /*
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        */
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }
}
