package com.simpletest;

/**
 * Created with IntelliJ IDEA.
 * User: musatov
 * Date: 4/2/13
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class MathCheck {
    public static void main(String[] args) {
        int i = 10;
        System.out.println("i = " + i);
        i = i++;
        System.out.println("i = " + i);

        i = 10;
        System.out.println("i = " + i);
        i = ++i;
        System.out.println("i = " + i);

    }
}
