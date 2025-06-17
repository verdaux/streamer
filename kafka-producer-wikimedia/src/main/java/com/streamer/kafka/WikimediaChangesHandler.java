package com.streamer.kafka;

import com.launchdarkly.eventsource.MessageEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;

public class WikimediaChangesHandler implements EventHandler {

    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;
    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesHandler.class);

    public WikimediaChangesHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onComment(String arg0) throws Exception {

    }

    @Override
    public void onError(Throwable arg0) {

    }

    @Override
    public void onMessage(String arg0, MessageEvent arg1) throws Exception {

        LOGGER.info(String.format("event data -> %s", arg1.getData()));
        kafkaTemplate.send(topic, arg1.getData());
    }

    @Override
    public void onOpen() throws Exception {

    }
}

/*
 * extends EventListener {
 * 
 * private static final Logger LOGGER =
 * LoggerFactory.getLogger(WikimediaChangesHandler.class);
 * 
 * @Override
 * public void callStart(Call call) {
 * LOGGER.info("callStart at {}", LocalDateTime.now());
 * }
 * 
 * @Override
 * public void requestHeadersEnd(Call call, Request request) {
 * LOGGER.info("requestHeadersEnd at {} with headers {}", LocalDateTime.now(),
 * request.headers());
 * }
 * 
 * @Override
 * public void responseHeadersEnd(Call call, Response response) {
 * LOGGER.info("responseHeadersEnd at {} with headers {}", LocalDateTime.now(),
 * response.headers());
 * }
 * 
 * @Override
 * public void callEnd(Call call) {
 * LOGGER.info("callEnd at {}", LocalDateTime.now());
 * }
 * }
 */
