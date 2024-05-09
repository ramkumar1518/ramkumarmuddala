package com.interview.prep;

import java.util.ArrayList;
import java.util.List;

public class WrapLines {

    public static void main(String[] args) {

        String[] wraplines = new String[]{"1p3acres", "is", "a", "good", "place", "to", "communicate"};
        List<String> list1= wrapLines1(wraplines,12);
        System.out.println(list1);

    }

    private static List<String> wrapLines1(String[] words, int maxwidth) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int p =0;

        while(p<words.length){
            if(sb.isEmpty()){
                sb.append(words[p++]);
            }else if (sb.length() +1 + words[p].length()<=maxwidth){
                sb.append("-");
                sb.append(words[p++]);
            }else{
                ans.add(sb.toString());
                sb.setLength(0);
            }
        }
        if(!sb.isEmpty()) ans.add(sb.toString());

        return ans;
    }
}


