package org.example;

import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        System.out.println("Привет!\nБудешь угадывать? (да/нет)");
        while (true) {
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine().toLowerCase();
            if (answer.equals("нет")) {
                System.out.println("(×﹏×)");
                return;
            } else if (!answer.equals("да")) {
                System.out.println("(︶︹︺)\nВведено непонятное значение");
                return;
            }

            PlayGame playGame = new PlayGame();
            playGame.playGame(sc);

            System.out.println("Будешь угадывать еще раз? (да/нет)");
        }
    }


}