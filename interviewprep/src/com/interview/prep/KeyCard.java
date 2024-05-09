package com.interview.prep;

import java.util.*;

public class KeyCard {
    public static void main(String[] args) {
        String[] keyName = new String[]{"daniel","daniel","daniel","daniel","luis","luis","luis","luis"};
        String[] keyTime = new String[]{"9:00","10:30","10:40","11:00","09:00","11:00","13:00","15:00"};
        List<String> stringList = alertNames(keyName, keyTime);
        System.out.println(stringList);
        // Input: keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
    }
        public static List<String> alertNames(String[] keyName, String[] keyTime) {
            Map<String, List<Integer>> map = new HashMap<>();
            List<String> res = new ArrayList<>();
            for (int i = 0; i < keyName.length; i++) { // cache all visits for same person.
                String k = keyName[i];
                map.computeIfAbsent(k, g -> new ArrayList<>());
                map.get(k).add(getTime(keyTime[i]));
            }

            for (String k : map.keySet()) {
                List<Integer> l = map.get(k);
                Collections.sort(l);  // sort to find the connective checkins
                for (int i = 2; i < l.size(); i++)
                    if (l.get(i) - l.get(i - 2) <= 60) {  // connective 3 within 60 mins.
                        res.add(k);
                        break;
                    }
            }

            Collections.sort(res);
            return res;
        }

        private static int getTime(String t) {  // transfer stirng to relative mins.
            String[] ss = t.split(":");
            return Integer.parseInt(ss[1]) + 60 * Integer.parseInt(ss[0]);
        }

}
