package com.interview.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Karatdomains {

    public static void main(String[] args) {

        String[] cpdomains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        String[] wraplines = new String[]{"1p3acres", "is", "a", "good", "place", "to", "communicate"};

        //["1p3acres", "is", "a", "good", "place", "to", "communicate"]
        List<String> list= subdomainVisits(cpdomains);
        List<String> list1= wrapLines1(wraplines,12);
        System.out.println(list1);

    }

    private static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();
        for (String domain: cpdomains) {
            String[] cpinfo = domain.split("\\s+");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.valueOf(cpinfo[0]);
            String cur = "";
            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                counts.put(cur, counts.getOrDefault(cur, 0) + count);
            }
        }
        List<String> ans = new ArrayList<>();
        for (String dom: counts.keySet())
            ans.add("" + counts.get(dom) + " " + dom);
        return ans;
    }

    public static List<String> wrapLines1(String[] words, int maxLength){
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int p = 0;
        while(p < words.length){
            if(sb.isEmpty())
                // assume all words length no exceed to maxLength
                sb.append(words[p++]);

            else if(sb.length() + 1 + words[p].length() <= maxLength){
                sb.append('-');
                sb.append(words[p++]);
            }
            else{
                ans.add(sb.toString());
                sb.setLength(0);
            }
        }
        if(!sb.isEmpty()) ans.add(sb.toString());
        return ans;
    }


}
