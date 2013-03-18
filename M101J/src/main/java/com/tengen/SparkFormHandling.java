package com.tengen;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: smiler
 * Date: 3/19/13
 * Time: 12:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class SparkFormHandling {
    public static void main(String[] args) {
        Spark.get(new Route("/fruits") {
            @Override
            public Object handle(Request request, Response response) {
                StringWriter writer = new StringWriter();
                Map<String, Object> fruits = new HashMap<String, Object>();
                fruits.put("fruits", Arrays.asList("apple", "banana", "orange", "pie", "peach"));

                Configuration configuration = new Configuration();
                configuration.setClassForTemplateLoading(SparkFormHandling.class, "/");
                try {
                    Template template = configuration.getTemplate("fruit_picker.ftl");
                    template.process(fruits, writer);
                } catch (Exception e) {
                    halt(100);
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

                return writer;
            }
        });

        Spark.post(new Route("/favourite_fruit") {
            @Override
            public Object handle(Request request, Response response) {
                String fruit = request.queryParams("fruit");
                if (fruit == null) {
                    return "You didn't choose anything, be careful.";
                } else {
                    return String.format("You chose %s. Great chose!", fruit);
                }
            }
        });
    }
}
