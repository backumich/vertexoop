package com.vertex.arrays;

import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)){
            String line;
            int count = 0;
            while (scanner.hasNext()){
                line = scanner.nextLine();
                if("quit".equalsIgnoreCase(line)){
                    break;
                }
                count+=wordCounts(line);
            }

            System.out.println("we've got " + count + " words");
        }


    }

    private static int wordCounts(String line) {
        int result = 0;
        String[] splits = line.split("[ ,.?!]");
        for(String word : splits){
            if(word != null && !word.trim().isEmpty()){
                result++;
            }
        }
        return result;
    }
}
