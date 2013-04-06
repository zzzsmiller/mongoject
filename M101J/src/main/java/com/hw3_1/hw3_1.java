package com.hw3_1;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.*;

import static com.tengen.CollectionUtils.showCollection;
import static com.tengen.CollectionUtils.simpleCursorPrint;

/**
 * Created with IntelliJ IDEA.
 * User: musatov
 * Date: 4/5/13
 * Time: 12:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class hw3_1 {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB db = client.getDB("school");
        DBCollection collection = db.getCollection("students");
//        QueryBuilder query = new QueryBuilder();
//        query.put("scores.type").is("homework");

        DBCursor cursor = collection.find()
                .sort(new BasicDBObject("_id", 1));


        simpleCursorPrint(cursor);


        cursor = collection.find()
                .sort(new BasicDBObject("_id", 1));

        try {
            while (cursor.hasNext()) {
                DBObject doc = cursor.next();
                List<BasicDBObject> scores = (List) doc.get("scores");
                Collections.sort(scores, new Comparator<BasicDBObject>() {
                    @Override
                    public int compare(BasicDBObject o1, BasicDBObject o2) {
                        return ((Double)o1.get("score")).compareTo((Double)o2.get("score"));
                    }
                });

                Iterator<BasicDBObject> iterator = scores.iterator();
                while (iterator.hasNext()) {
                    BasicDBObject cur = iterator.next();
                    if (cur.get("type").equals("homework")) {
                        iterator.remove();
                        break;
                    }
                }
                collection.save(cursor.curr());
            }
        }catch (Exception e){
            System.out.println(e);
        } finally {
            cursor.close();
        }

        showCollection(collection, false);
    }

}
