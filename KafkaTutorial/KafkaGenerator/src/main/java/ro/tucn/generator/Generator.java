package ro.tucn.generator;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Properties;

/**
 * abstract class of data generator
 * Created by jun on 08/01/16.
 */
public abstract class Generator {

    protected Properties properties;

    public Generator() {
        properties = new Properties();
        String configFile = this.getClass().getSimpleName() + ".properties";
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream(configFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static KafkaProducer<String, String> createSmallBufferProducer() {
        Properties props = Producer.getProducerProperties();
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        return producer;
    }
}
