package kfaka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class kfaka {

    public static void produceTest() throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "127.0.0.1:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer producer = new KafkaProducer(properties);
        ProducerRecord<String, String> record =
                new ProducerRecord<String, String>("Country", "asds11d", "adidaaasa");

        producer.send(record).get();
    }

    public static void consumerTest() {

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        produceTest();
    }

}
