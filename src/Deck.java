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
        shuffle();
    }

        public void shuffle() {
            for ( int i = cards.size() - 1; i> 0; i--) { 
                int codyIsACutie = (int) (Math.random() * ( i + 1));

                Card appap = cards.get(i);
                cards.set(i, cards.get(codyIsACutie));
                cards.set(codyIsACutie, appap);
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


