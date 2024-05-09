package com.interview.prep;

import java.util.ArrayList;
import java.util.List;

public class Justification {
    public static void main(String[] args) {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};

        List<String> stringList = fullJustify(words, 16);
        System.out.println(stringList);

    }

    private static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            // get words for max width 16 or less
            List<String> currentLine = getWords(words, maxWidth, i);
            i+= currentLine.size();
            ans.add(createLine(currentLine,i,words,maxWidth));
        }
        return ans;
    }


    private static List<String> getWords(String[] words, int maxWidth, int i) {
        List<String> currentLine = new ArrayList<>();
        int currLength = 0;
        while (i < words.length && currLength + words[i].length() < maxWidth) {
            currentLine.add(words[i]);
            currLength += words[i].length() + 1;
            i++;
        }
        return currentLine;
    }

    private static String createLine(List<String> line, int i, String[] words, int maxWidth) {
        int baselength =-1;
        for(String word : line){
            baselength += word.length()+1;
        }
        // extra spaces needed cal
        int extraspaces = maxWidth-baselength;
        if (line.size() == 1 || i == words.length) {
            return String.join(" ", line) + " ".repeat(extraspaces);
        }

        int wordcount = line.size()-1;
        int wordExtraSpaces = extraspaces/wordcount;
        int needExtraSpaces = extraspaces%wordcount;

        for(int j =0;j<needExtraSpaces ;j++){
            line.set(j,line.get(j)+" ");
        }

        for(int j =0;j<wordcount ;j++){
            line.set(j,line.get(j)+" ".repeat(wordExtraSpaces));
        }

        return String.join(" ",line);
    }

}
