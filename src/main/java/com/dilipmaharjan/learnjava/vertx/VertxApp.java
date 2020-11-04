package com.dilipmaharjan.learnjava.vertx;

import io.vertx.core.AbstractVerticle;

public class VertxApp extends AbstractVerticle {

	@Override
	public void start() throws Exception {
		System.out.println("---------Hello vertx world----------");
	}
}