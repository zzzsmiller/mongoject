package com.tengen;

import com.mongodb.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.*;

import java.io.IOException;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: smiler
 * Date: 3/18/13
 * Time: 11:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldMongoDBSparkFreemarkerStyle {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
        final DB db = client.getDB("course");

        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                DBCollection users = db.getCollection("user");
                DBObject user = users.findOne();
                StringWriter writer = new StringWriter();
                Configuration configuration = new Configuration();
                configuration.setClassForTemplateLoading(HelloWorldMongoDBSparkFreemarkerStyle.class, "/");

                try {
                    Template template = configuration.getTemplate("hello.ftl");
                    template.process(user, writer);
                } catch (Exception e) {
                    halt(100);
                    e.printStackTrace();
                }

                return writer;
            }
        });
    }
}
