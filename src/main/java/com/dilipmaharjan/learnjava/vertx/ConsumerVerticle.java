package com.dilipmaharjan.learnjava.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;

public class ConsumerVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        vertx.eventBus().consumer("consumer", message -> {
            System.out.println("Message Received");
            JsonObject reply = new JsonObject();
            reply.put("message", "Message Recieved ack");
            message.reply(reply);
        });
    }
}
