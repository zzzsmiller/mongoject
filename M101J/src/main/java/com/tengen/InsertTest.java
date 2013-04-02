package com.tengen;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: musatov
 * Date: 4/2/13
 * Time: 8:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class InsertTest {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB course = client.getDB("course");
        DBCollection collection = course.getCollection("insertTest");

        CollectionUtils.showCollection(collection);

        collection.drop();

        BasicDBObject doc = new BasicDBObject("name", "James")
                .append("family", Arrays.asList(
                        new BasicDBObject("relationship", "wife").append("name", "Lora"),
                        new BasicDBObject("relationship", "daughter").append("name", "Sara")
                            .append("age","4")));

        collection.insert(doc);

        CollectionUtils.showCollection(collection);
    }

}
