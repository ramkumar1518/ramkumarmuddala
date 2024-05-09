package com.interview.prep;

public class Main {

    public static void main(String[] args) {

        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        WordSearch wordSearch = new WordSearch();
        wordSearch.exist(board,word);

    }
}
