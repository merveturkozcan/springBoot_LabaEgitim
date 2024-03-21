package com.merveturk.springBootLaba.functionalProgramming;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgramming {

    public static void main(String[] args) {
        String sentence = "Bu bir test cumlesi ve bazi kelimeler silinecek.";
        List<String> wordsToRemove = Arrays.asList("bir", "ve", "bazi");
        removeWords(sentence,wordsToRemove);
        removeWords(sentence,wordsToRemove);
        sum();
        sumFunctional();

    }

    public static void removeWordsNonFunction (
            String sentence , List <String> wordsToRemove)
    {
        String newSentence = "";
        List <String> words = Arrays.asList( sentence.split("\\s+"));
        for (String word : words) {
             if ( !wordsToRemove.contains(word)){
                 newSentence += word + " ";
             }
             System.out.print(newSentence);
        }
    }

    public static String removeWords ( String sentence , List <String> wordsToRemove)
    {
        List <String> words = Arrays.asList( sentence.split("\\s+"));
        return words.stream()
                .filter(word -> !wordsToRemove.contains(word))
                .collect(Collectors.joining(" ")); // joining birlestirme yapar.

    }

    public static int sum (){
        List <Integer> integerList = Arrays.asList(1,3,5,6,7);
        int  sum = 0 ;
        for (Integer i : integerList) {
            sum += i ;

        }
        return sum ;
    }

    public static int sumFunctional () {
        List <Integer> numbers = Arrays.asList(1,3,5,6,7);
        List<Integer> numberList = numbers.stream().map(num -> num + num).collect(Collectors.toList());
        Integer sum =  numbers.stream().reduce(0,Integer::sum);
        return sum;
    }

}
