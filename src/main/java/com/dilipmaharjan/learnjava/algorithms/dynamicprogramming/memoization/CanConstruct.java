package com.dilipmaharjan.learnjava.algorithms.dynamicprogramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    public static void main(String[] args) {
        CanConstruct canConstruct = new CanConstruct();
        System.out.println(canConstruct.canConstruct("", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(canConstruct.canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(canConstruct.canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(canConstruct.canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
//        System.out.println(canConstruct.canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eeee", "eeeee", "eeeeee", "eeeeeeeeeeeeee", "eeeeeeeeeeeeeeeeeeeeeeeee"}));
        System.out.println("After memoization ");
        System.out.println(canConstruct.canConstructWithMemoization("", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        System.out.println(canConstruct.canConstructWithMemoization("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        System.out.println(canConstruct.canConstructWithMemoization("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>()));
        System.out.println(canConstruct.canConstructWithMemoization("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>()));
        System.out.println(canConstruct.canConstructWithMemoization("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eeee", "eeeee", "eeeeee", "eeeeeeeeeeeeee", "eeeeeeeeeeeeeeeeeeeeeeeee"}, new HashMap<>()));
    }

    boolean canConstruct(String target, String[] worldBank) {
        if (target.isEmpty()) {
            return true;
        }
        for (String word : worldBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                if (canConstruct(suffix, worldBank)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean canConstructWithMemoization(String target, String[] worldBank, Map<String, Boolean> map) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target.isEmpty()) {
            return true;
        }
        for (String word : worldBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                if (canConstructWithMemoization(suffix, worldBank, map)) {
                    map.put(target, true);
                    return true;
                }
            }
        }
        map.put(target, false);
        return false;
    }
}
