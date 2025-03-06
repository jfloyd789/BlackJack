import javax.swing.*;
import java.awt.*;

import javax.swing.ImageIcon;

import java.util.ArrayList;
public class Deck {
    private ArrayList<Card> cards; // list if cards
    private int cardsLeft;  // int to show how manny cards are left 

    //construct a deck of cards using a nested loop
    public Deck(String[] ranks, String[] suits, int[] values) {
        cards = new ArrayList<>();
        
        int index = 1;  // Start at 1 to match your image filenames (1.png, 2.png, ...)
    
        for (int i = 0; i < ranks.length; i++) {  // Loop through ranks first
            for (String suit : suits) {  // Then loop through suits
                String imagePath = "Resources/Cards (1)/" + index + ".png";
            
                cards.add(new Card(ranks[i], suit, values[i], new ImageIcon(imagePath).getImage()));
                index++; 
            }
        }
        cardsLeft = cards.size();
        shuffle(); 
    }
    

        public void shuffle() {
            for ( int i = cards.size() - 1; i> 0; i--) { 
                int randomIndex = (int) (Math.random() * ( i + 1));

                Card temp = cards.get(i);
                cards.set(i, cards.get(randomIndex));
                cards.set(randomIndex, temp);
            }

            cardsLeft = cards.size();
        }

        public int getCardsLeft() {
            return cardsLeft;
        }

        public boolean isEmpty() {
            return cardsLeft == 0; 
        }

        public Card deal() {
            if (isEmpty()) {
                return null;
            }
            cardsLeft--;
            return cards.get(cardsLeft);
        }
    }


