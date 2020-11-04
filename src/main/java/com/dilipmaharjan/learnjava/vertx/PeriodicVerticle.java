package com.dilipmaharjan.learnjava.vertx;

import io.vertx.core.AbstractVerticle;

public class PeriodicVerticle  extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        vertx.setTimer(3000,handler->{
            System.out.println("Delayed by 3 second");
        });

        vertx.setPeriodic(2000,handler->{
            System.out.println("Every 2 second");
        });
    }
}
