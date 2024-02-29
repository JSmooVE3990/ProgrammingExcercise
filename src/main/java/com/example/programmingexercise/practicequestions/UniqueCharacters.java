package com.example.programmingexercise.practicequestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UniqueCharacters {
    public static void main(String[] args) {
        String[] sample = {"aaryanna", "aayanna", "airianna", "alassandra", "allanna", "allannah", "allessandra", "allianna",
                "allyanna", "anastaisa", "anastashia", "anastasia", "annabella", "annabelle", "annebelle"};

        List<String> doubleANames = new ArrayList<>();
        for(String name: sample){
            if(name.contains("aa")){
                doubleANames.add(name);
            }
        }

        for(String name: doubleANames){
            HashSet<Character> map = new HashSet<>();

            for(int i= 0; i < name.length(); i++){
                char curr = name.charAt(i);
                map.add(curr);
            }

            System.out.println("The number of unique characters in the name \"" + name + "\" is: " + map.size());
        }
    }
}
