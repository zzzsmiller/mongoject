package com.tengen;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class CollectionUtils {
    public static void showCollection(DBCollection collection, boolean idShow) {
        DBCursor cursor = collection.find(null, new BasicDBObject("_id", idShow));
        System.out.println(String.format("\n Collection %s contains:", collection.getName()));
        System.out.println("-----------------------------");
        try {
            int order = 0;
            int count = cursor.count();
            while (count >= 10) {
                order++;
                count = count / 10;
            }
            while (cursor.hasNext()) {
                int index = cursor.numSeen()+1;
                StringBuilder str = new StringBuilder().append(index);

                while (index < Math.pow(10, order)) {
                    index = index * 10;
                    str.append(" ");
                }

                str.append(": " + cursor.next().toString());
                System.out.println(str);
            }
        } finally {
            cursor.close();
        }
        System.out.println("-----------------------------");
        System.out.println(String.format("End of collection %s . \n", collection.getFullName()));
    }

    public static void printElementByIndex(DBCollection collection, int index, boolean idShow) {
        DBCursor cursor;
        if (index == 0) {
            cursor = collection.find().limit(1);
        } else {
            cursor = collection.find(null, new BasicDBObject("_id", idShow)).skip(index-1).limit(1);
        }

        try {
            System.out.println(String.format("\n find %s element : %s \n", index, cursor.next()));
        } finally {
            cursor.close();
        }

    }

    public static void simpleCursorPrint(DBCursor cursor) {
        System.out.println("\n ----------- start of cursor -------------");
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.numSeen() + ":" + cursor.next());
            }
        } finally {
            cursor.close();
        }
        System.out.println(" ----------- end of cursor ------------- \n");

    }
}