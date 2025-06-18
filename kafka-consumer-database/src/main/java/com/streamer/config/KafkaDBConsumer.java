package com.streamer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.streamer.entity.Wikimedia;
import com.streamer.entity.repository.WikimediaRepository;

@Service
public class KafkaDBConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDBConsumer.class);

    private WikimediaRepository dataRepository;

    public KafkaDBConsumer(WikimediaRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(topics = "wikimedia_recentchange", groupId = "myGroup")
    public void consume(String eventMessage) {
        LOGGER.info(String.format("Event message received -> %s", eventMessage));

        Wikimedia wikimedia = new Wikimedia();
        wikimedia.setWikiEventData(eventMessage);

        dataRepository.save(wikimedia);
    }
}
