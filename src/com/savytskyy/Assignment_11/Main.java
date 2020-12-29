package com.savytskyy.Assignment_11;

public class Main {

    public static void main(String[] args) {
        String testString = "Я иду по парку, иду один и вижу как по воде пробегает луч солнца";
        WordProcessor.countWords(testString);

        System.out.println("---------------------------");

        String testString2 = "ехал Грека через реку сунул греКа руку в реку, рак за руку грека цап";
        WordProcessor.countWords(testString2);
    }
}
