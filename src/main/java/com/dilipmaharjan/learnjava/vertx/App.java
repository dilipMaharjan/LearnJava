package com.dilipmaharjan.learnjava.vertx;

import io.vertx.core.Vertx;

public class App {
	public static void main(String[] args) {
		Vertx vertx = Vertx.factory.vertx();
		VertxApp vertxapp = new VertxApp();
		vertx.deployVerticle(vertxapp);
	}
}
