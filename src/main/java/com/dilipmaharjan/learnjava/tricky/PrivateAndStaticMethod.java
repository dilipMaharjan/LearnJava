package com.dilipmaharjan.learnjava.tricky;

public class PrivateAndStaticMethod {
    public static String sayStatic() {
        return "I cannot be overriden but hidden";
    }

    private String sayPrivate() {
        return "I cannot be overriden";
    }
}
