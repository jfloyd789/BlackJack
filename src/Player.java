import java.awt.Graphics;
import java.awt.Image;


import java.util.ArrayList;
public class Player {
    
    private String name;
    private ArrayList<Card> hand;
    private int points;
    
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.points = 0;
    }
    
    public void drawHand(Graphics g, int startX, int startY, GameViewer viewer, Image cardBack) {
        int x = startX;
        for (Card card : hand) {
            card.drawcard(g, x, startY, viewer, cardBack);
            x += 80; // Move the next card to the right
        }
    }

    public Player(String name, ArrayList<Card> hand) {
        this.name = name;
        this.hand = hand;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void addCard(Card card) {
        hand.add(card);
    }
    public void clearHand() {
        this.hand = new ArrayList<Card>();
    }

    public String toString() {
        return name + " has " + points + " points\n " + 
        name + "has" + hand;
    }
}
