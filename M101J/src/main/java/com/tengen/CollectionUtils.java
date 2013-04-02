package com.tengen;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class CollectionUtils {
    static void showCollection(DBCollection collection) {
        DBCursor cursor = collection.find();
        System.out.println(String.format("Collection %s contains:", collection.getName()));
        System.out.println();
        while (cursor.hasNext()) {
            System.out.println(cursor.next().toString());
        }
        System.out.println();
        System.out.println(String.format("End of collection %s .", collection.getFullName()));
    }
}