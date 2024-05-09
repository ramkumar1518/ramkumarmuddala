package com.interview.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterviewPratice {

    public static void main(String[] args) {
        String[] cpdomains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        String[] wraplines = new String[]{"1p3acres", "is", "a", "good", "place", "for", "communicate"};
        String[] justify = new String[]{"The Earth is",
                "the only world",
                "known so far",
                "to harbor life"};
        List<String> stringList = subDomainsVisit(cpdomains);
        System.out.println(stringList);
        List<String> list1= wrapLines(wraplines,12);
        System.out.println(list1);

        List<String> list2= justify(justify,18);
        System.out.println(list2);
    }

    private static List<String> subDomainsVisit(String[] cpdomains) {

        Map<String, Integer> map = new HashMap<>();

        for (String domains : cpdomains) {
            String[] cpdms = domains.split("\\s+");
            String[] frags = cpdms[1].split("\\.");
            int count = Integer.parseInt(cpdms[0]);
            String current = "";
            for (int i = frags.length - 1; i >= 0; --i) {
                current = frags[i] + (i < frags.length - 1 ? "." : "") + current;
                map.put(current, map.getOrDefault(current, 0) + count);
            }
        }
        List<String> answer = new ArrayList<>();
        for (String domains : map.keySet()) {
            answer.add(map.get(domains) + " " + domains);
        }

        return answer;
    }

    private static List<String> wrapLines(String[] words, int maxlength) {
        List<String> ans = new ArrayList<>();
        int p = 0;
        StringBuilder sb = new StringBuilder();

        while (p < words.length) {
            if (sb.isEmpty()) {
                sb.append(words[p++]);
            } else if (sb.length() + 1 + words[p].length() <=maxlength) {
                sb.append("-");
                sb.append(words[p++]);
            } else {
                ans.add(sb.toString());
                sb.setLength(0);
            }

        }
        if(!sb.isEmpty()) ans.add(sb.toString());
        return ans;
    }


  /*  # input
    text = [ "The Earth is",
            "the only world",
            "known so far",
            "to harbor life" ]
    lineLength = 18

            # Return:
            [ "The  Earth  is the",
            "only  world  known",
            "so  far  to harbor",
            "life" ]*/
    private static List<String> justify(String[] words, int maxlength) {
        List<String> ans = new ArrayList<>();
        int i =0;
        while(i< words.length){
            List<String> currentLine = getWords(i, words, maxlength);
            i += currentLine.size();
            ans.add(createLine(currentLine, i, words, maxlength));
        }

        return ans;
    }

    private static List<String> getWords(int i, String[] words, int maxWidth) {
        List<String> currentLine = new ArrayList<>();
        int currLength = 0;

        while (i < words.length && currLength + words[i].length() <= maxWidth) {
            currentLine.add(words[i]);
            currLength += words[i].length() + 1;
            i++;
        }

        return currentLine;
    }

    private static String createLine(List<String> line, int i, String[] words, int maxWidth) {
        int baseLength = -1;
        for (String word : line) {
            baseLength += word.length() + 1;
        }
        int extraSpaces = maxWidth - baseLength;
        if (line.size() == 1 || i == words.length) {
            return String.join(" ", line) + " ".repeat(extraSpaces);
        }
        int wordCount = line.size() - 1;
        int spacesPerWord = extraSpaces / wordCount;
        int needsExtraSpace = extraSpaces % wordCount;

        for (int j = 0; j < needsExtraSpace; j++) {
            line.set(j, line.get(j) + " ");
        }

        for (int j = 0; j < wordCount; j++) {
            line.set(j, line.get(j) + " ".repeat(spacesPerWord));
        }

        return String.join(" ", line);
    }


}

