package com.dilipmaharjan.learnjava.algorithms.dynamicprogramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class CountCanConstruct {
    public static void main(String[] args) {
        CountCanConstruct countCanConstruct = new CountCanConstruct();
        System.out.println(countCanConstruct.countCanConstruct("", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(countCanConstruct.countCanConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(countCanConstruct.countCanConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(countCanConstruct.countCanConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
//        System.out.println(countCanConstruct.countCanConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eeee", "eeeee", "eeeeee", "eeeeeeeeeeeeee", "eeeeeeeeeeeeeeeeeeeeeeeee"}));
        System.out.println("After memoization ");
        System.out.println(countCanConstruct.countCanConstructWithMemoization("", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        System.out.println(countCanConstruct.countCanConstructWithMemoization("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        System.out.println(countCanConstruct.countCanConstructWithMemoization("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>()));
        System.out.println(countCanConstruct.countCanConstructWithMemoization("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>()));
        System.out.println(countCanConstruct.countCanConstructWithMemoization("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eeee", "eeeee", "eeeeee", "eeeeeeeeeeeeee", "eeeeeeeeeeeeeeeeeeeeeeeee"}, new HashMap<>()));
    }

    int countCanConstruct(String target, String[] worldBank) {
        if (target.isEmpty()) {
            return 1;
        }
        int totalCount = 0;
        for (String word : worldBank) {
            if (target.indexOf(word) == 0) {
                int count = countCanConstruct(target.substring(word.length()), worldBank);
                totalCount += count;
            }
        }

        return totalCount;
    }

    int countCanConstructWithMemoization(String target, String[] worldBank, Map<String, Integer> map) {
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
                int count = countCanConstructWithMemoization(suffix, worldBank, map);
                toalCount += count;

            }
        }
        map.put(target, toalCount);
        return toalCount;
    }
}
