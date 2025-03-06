import javax.swing.*;
import java.awt.*;

public class Card {
    private String rank;
    private String suit;
    private int value;
    private Image card;
    private boolean isFaceDown;

    public Card(String rank, String suit, int value, Image card) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
        this.card = card;
        this.isFaceDown = false; // cards are always face down by default


    }

    public void drawcard(Graphics g, int x, int y, GameViewer viewer, Image cardBack) {
        if (isFaceDown) {
            g.drawImage(cardBack, x, y, 75, 125, viewer);
        } else {
            g.drawImage(card, x, y, 75, 125, viewer);  // draws the cards 
        }
    }

    // Getters and Setters
    public String getRank() {
        return rank;
    }

    public void setFaceDown(boolean faceDown){
        this.isFaceDown = faceDown;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

   
    public String toString() {
        return rank + " of " + suit;
    }
}

