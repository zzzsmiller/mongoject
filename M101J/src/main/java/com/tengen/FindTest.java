package com.tengen;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.tengen.CollectionUtils.printElementByIndex;
import static com.tengen.CollectionUtils.showCollection;

/**
 * Created with IntelliJ IDEA.
 * User: musatov
 * Date: 4/3/13
 * Time: 4:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindTest {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client =  new MongoClient();
        DBCollection collection = client.getDB("course").getCollection("findTest");

        DBObject doc = new BasicDBObject();
        Random random = new Random();
        List<DBObject> docs = new ArrayList<DBObject>();

        collection.drop();

        for (int i = 0; i < 7; i++) {
            doc.removeField("_id");
            doc.put("x", random.nextInt(100));
//            docs.add(doc);
            collection.insert(doc);
        }

//        collection.insert(docs);

        System.out.println("\n findOne :"+collection.findOne());

        printElementByIndex(collection, 3, false);

        showCollection(collection, false);

        System.out.println("\n count: "+collection.count());

    }

}
