package com.interview.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CPDomains {

    public static void main(String[] args) {
        String[] cpdomains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits(cpdomains));
    }

    private static List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(String domain:cpdomains){
            String[] cpdomain = domain.split("\\s+");
            String[] frags = cpdomain[1].split("\\.");
            Integer count = Integer.valueOf(cpdomain[0]);
            String current ="";
            for(int i = frags.length-1;i >= 0;i--){
                current = frags[i] +( i<frags.length-1?".":"")+current;
                map.put(current,map.getOrDefault(current,0)+count);
            }
        }
        for(String key : map.keySet()){
            ans.add(key+ " "+ map.get(key));
        }
        return ans;
    }
}
