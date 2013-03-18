package com.tengen;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created with IntelliJ IDEA.
 * User: musatov
 * Date: 3/18/13
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldSparkStyle {
    public static void main(String[] args) {
        Spark.get(new Route("/hello") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World from Spark!";
            }
        });
    }
}
