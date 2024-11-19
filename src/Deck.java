import java.util.ArrayList;
public class Deck {
    private ArrayList<Card> cards; // list if cards
    private int cardsLeft;  // int to show how manny cards are left 

    //construct a deck of cards using a nested loop
    public Deck(String[] ranks, String[] suits, int[] values) {
        cards = new ArrayList<>();
        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards.add(new Card(ranks[i], suit, values[i]));
            }
        }
        cardsLeft = cards.size();
    }

}
