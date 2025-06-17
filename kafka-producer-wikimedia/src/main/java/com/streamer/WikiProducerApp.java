package com.streamer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.streamer.kafka.WikimediaChangesProducer;

@SpringBootApplication
public class WikiProducerApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(WikiProducerApp.class);
    }

    @Autowired
    private WikimediaChangesProducer wikimediaChangesProducer;

    @Override
    public void run(String... args) throws Exception {
        wikimediaChangesProducer.sendMessage();
    }

    /*
     * Commands to start Kafka server
     * Start the kafka server
     * 1.
     * KAFKA_CLUSTER_ID="$(bin/kafka-storage.sh random-uuid)"
     * 2.
     * bin/kafka-storage.sh format --standalone -t $KAFKA_CLUSTER_ID -c
     * config/server.properties
     * 3.
     * bin/kafka-server-start.sh config/server.properties
     * 
     * Display messages on the terminal
     * bin/kafka-console-consumer.sh --topic wikimedia_recentchange --from-beginning
     * --bootstrap-server localhost:9092
     */

}