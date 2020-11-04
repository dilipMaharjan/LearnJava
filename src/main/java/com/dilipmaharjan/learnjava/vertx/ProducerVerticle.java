package com.dilipmaharjan.learnjava.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;

public class ProducerVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        JsonObject message = new JsonObject();
        message.put("name", "Dilip");
        vertx.eventBus().send("consumer", message, handler -> {
            if (handler.succeeded()) {
                System.out.println("Got the ACK");
                System.out.println(handler.result().body());
            } else {
                System.out.println("Failed to deliver");
            }
        });
    }
}
