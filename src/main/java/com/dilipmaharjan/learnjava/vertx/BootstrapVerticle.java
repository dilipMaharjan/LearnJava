package com.dilipmaharjan.learnjava.vertx;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.json.JsonObject;

import javax.tools.FileObject;

public class BootstrapVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {

        ConfigStoreOptions storeOptions = new ConfigStoreOptions().setType("file").setOptional(true).setConfig(new JsonObject().put("path", "config.hocon"));
        ConfigStoreOptions sysPropsStore = new ConfigStoreOptions().setType("sys");
        ConfigRetrieverOptions retrieverOptions = new ConfigRetrieverOptions().addStore(storeOptions).addStore(sysPropsStore);

        ConfigRetriever configRetriever = ConfigRetriever.create(vertx, retrieverOptions);
        configRetriever.getConfig(json -> {
            JsonObject configs = json.result();
            int numInstances = configs.getInteger("vertical-instances");
            DeploymentOptions deploymentOptions = new DeploymentOptions();
            deploymentOptions.setInstances(numInstances);
            deploymentOptions.setWorker(false);
            vertx.deployVerticle("com.dilipmaharjan.learnjava.vertx.VertxApp");
            vertx.deployVerticle(VertxApp.class.getName());
            vertx.deployVerticle(new VertxApp());
            vertx.deployVerticle(ConsumerVerticle.class.getName(), deploymentOptions);
            vertx.deployVerticle(ProducerVerticle.class.getName(), deploymentOptions);
            vertx.deployVerticle(PeriodicVerticle.class.getName(), deploymentOptions);
        });
    }

}
