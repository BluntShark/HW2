package org.example;

import java.util.Random;
import java.util.Scanner;

public class PlayGame extends NumberGuessingGame{
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10;
    public static void playGame(Scanner sc) {
        System.out.println("(⌒‿⌒)");
        int rand = new Random().nextInt(MAX_NUMBER) + 1;
        System.out.println("Угадай число от 1 до 10");

        while (true) {
            int number = getValidNumber(sc);

            if (number == rand) {
                System.out.println("Угадал!\n╰(▔∀▔)╯");
                break;
            } else {
                giveHelp(number, rand);
            }
        }
    }
    public static int getValidNumber(Scanner sc) {
        int number;
        while (true) {
            number = sc.nextInt();
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                System.out.println("Нужно ввести число от 1 до 10");
            } else {
                break;
            }
        }
        return number;
    }


    public static void giveHelp(int number, int rand) {
        int difference = Math.abs(number - rand);
        if (difference > 5) {
            System.out.println("Холодно");
        } else if (difference > 2) {
            System.out.println("Тепло");
        } else {
            System.out.println("Жгётся!");
        }
    }

}
