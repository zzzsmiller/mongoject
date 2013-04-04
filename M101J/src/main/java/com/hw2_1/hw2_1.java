package com.hw2_1;

import com.mongodb.*;

import java.net.UnknownHostException;

import static com.tengen.CollectionUtils.simpleCursorPrint;

/**
 * Created with IntelliJ IDEA.
 * User: musatov
 * Date: 4/5/13
 * Time: 12:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class hw2_1 {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB db = client.getDB("students");
        DBCollection collection = db.getCollection("grades");
        QueryBuilder query = new QueryBuilder();
        query.put("type").is("homework");

        DBCursor cursor = collection.find(query.get())
                .sort(new BasicDBObject("student_id", 1)
                        .append("score",1));


        simpleCursorPrint(cursor);


        cursor = collection.find(query.get())
                .sort(new BasicDBObject("student_id", 1)
                        .append("score",1));

        try {
            DBObject current = null;
            DBObject next = null;
            boolean hasDeleted = false;
            while (cursor.hasNext()) {
                if (next == null) {
                    current = cursor.next();
                } else {
                    current = next;
                }
                if (cursor.hasNext()) {
                    next = cursor.next();
                    if (current.get("student_id").equals(next.get("student_id"))) {
                        if (hasDeleted) {
                            continue;
                        }
                        collection.remove(current);
                        hasDeleted = true;
                    } else {
                        hasDeleted = false;
                    }
                }

            }
        }catch (Exception e){
            System.out.println(e);
        } finally {
            cursor.close();
        }

        cursor = collection.find(query.get())
                .sort(new BasicDBObject("student_id", 1)
                        .append("score",1));


        simpleCursorPrint(cursor);
    }

}
