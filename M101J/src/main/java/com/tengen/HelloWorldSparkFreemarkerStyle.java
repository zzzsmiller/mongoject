package com.tengen;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: smiler
 * Date: 3/18/13
 * Time: 10:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldSparkFreemarkerStyle {
    public static void main(String[] args) {

        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                Configuration configuration = new Configuration();
                configuration.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");
                final StringWriter writer = new StringWriter();
                HashMap<String, Object> helloMap = new HashMap<String, Object>();
                helloMap.put("name", "John Smith");
                try {
                    Template template = configuration.getTemplate("hello.ftl");
                    template.process(helloMap, writer);
                } catch (Exception e) {
//                    halt(500);
                    e.printStackTrace();
                }
                return writer;
            }
        });
    }
}
