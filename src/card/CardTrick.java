/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 
package card;

import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Harmanpreet Kaur 
 * @studentNumber 991720020 
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];

       
        for (int i = 0; i < magicHand.length; i++) {
           Card c = new Card();
           c.setValue(generateRandomNumber(1, 13));
           c.setSuit(Card.SUITS[generateRandomNumber(0, 3)]);
           magicHand[i] = c;
           System.out.println(c.getSuit() + " " + c.getValue());
        }

        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of card  in the range (1-13): ");
        int user_Card_Value = scanner.nextInt();
        System.out.print("Enter a suit index (0-Hearts, 1-Diamonds, 2-Clubs, 3-Spades): ");
        int user_Suit_Index = scanner.nextInt();

       
        Card user_Card = new Card();
        user_Card.setValue(user_Card_Value);
        user_Card.setSuit(Card.SUITS[user_Suit_Index]);

       
        boolean isUser_CardInMagicHand = false;
        for (Card c : magicHand) {
            if (c.getValue() == user_Card.getValue() && c.getSuit().equalsIgnoreCase(user_Card.getSuit())) {
                isUser_CardInMagicHand = true;
                break;
            }
        }

        
        if (isUser_CardInMagicHand) {
            System.out.println("Well done! Your chosen card is part of the magic hand!");
        } else {
            System.out.println("Unfortunately, your selected card is not among the magic hand's cards.");
        }
    }

   
    private static int generateRandomNumber(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}