package com.tengen;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: musatov
 * Date: 3/18/13
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldMongoDBStyle {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
        DB db = client.getDB("course");
        DBCollection user = db.getCollection("user");
        DBObject document = user.findOne();
        System.out.println(document);
    }
}
