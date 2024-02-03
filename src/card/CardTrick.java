/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 
package card;

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

        int i; 

        for (i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(generateRandomNumber(1, 13));
            c.setSuit(Card.SUITS[generateRandomNumber(0, 3)]);
            magicHand[i] = c;
            System.out.println(c.getSuit() + " " + c.getValue());
        }

        Card luckyCard = new Card();
        luckyCard.setValue(7); 
        luckyCard.setSuit("Hearts"); 

        
        magicHand[i - 1] = luckyCard;

        System.out.println(luckyCard.getSuit() + " " + luckyCard.getValue() + " (Lucky Card)");

        boolean isLuckyCardInMagicHand = false;
        for (Card c : magicHand) {
            if (c.getValue() == luckyCard.getValue() && c.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                isLuckyCardInMagicHand = true;
                break;
            }
        }

        if (isLuckyCardInMagicHand) {
            System.out.println("Well done! Your chosen card is part of the magic hand!");
        } else {
            System.out.println("Unfortunately, your selected card is not among the magic hand's cards.");
        }
    }

    private static int generateRandomNumber(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
