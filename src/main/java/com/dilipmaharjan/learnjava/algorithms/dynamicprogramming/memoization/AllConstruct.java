package com.dilipmaharjan.learnjava.algorithms.dynamicprogramming.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AllConstruct {
    public static void main(String[] args) {
        AllConstruct allConstruct = new AllConstruct();
        System.out.println(allConstruct.allConstruct("", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(allConstruct.allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(allConstruct.allConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(allConstruct.allConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
//        System.out.println(allConstruct.allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eeee", "eeeee", "eeeeee", "eeeeeeeeeeeeee", "eeeeeeeeeeeeeeeeeeeeeeeee"}));
        System.out.println("After memoization ");
        System.out.println(allConstruct.allConstructWithMemoization("", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        System.out.println(allConstruct.allConstructWithMemoization("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        System.out.println(allConstruct.allConstructWithMemoization("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>()));
        System.out.println(allConstruct.allConstructWithMemoization("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>()));
        System.out.println(allConstruct.allConstructWithMemoization("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eeee", "eeeee", "eeeeee", "eeeeeeeeeeeeee", "eeeeeeeeeeeeeeeeeeeeeeeee"}, new HashMap<>()));
    }

    ArrayList allConstruct(String target, String[] worldBank) {
        if (target.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<String> allconstructWays = new ArrayList<>();
        for (String word : worldBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                allconstructWays = allConstruct(suffix, worldBank);
                allconstructWays.stream().map(s -> word.concat(s)).collect(Collectors.toList());
            }
        }

        return allconstructWays;
    }

    int allConstructWithMemoization(String target, String[] worldBank, Map<String, Integer> map) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target.isEmpty()) {
            return 1;
        }
        int toalCount = 0;
        for (String word : worldBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                int count = allConstructWithMemoization(suffix, worldBank, map);
                toalCount += count;

            }
        }
        map.put(target, toalCount);
        return toalCount;
    }
}
