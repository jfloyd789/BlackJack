import java.util.Scanner;
public class Game {
    private Deck deck;
    private Player player;
    private Player dealer;

    public Game() {
        final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        final String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        final int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

        deck = new Deck(ranks, suits, values);
        player = new Player("Player");
        dealer = new Player("Dealer");

    }
    
    // need a fuction to get the total value of the player/dealers hadn
    public int handValue() {
        int value = 0;
        int numberOfAces = 0;

        for (Card card : player.getHand()) {
            value += card.getValue();
            if(card.getRank().equals("A")) {
                numberOfAces++;
            }
        }
        while (value > 21 && numberOfAces > 0) {
            value -= 10;
            numberOfAces--;
        }
        return value;
    }

    public void playGame() {
       // both the player and the dealer need two cards 
        player.addCard(deck.deal());        
        player.addCard(deck.deal());
        dealer.addCard(deck.deal());
        dealer.addCard(deck.deal());

        
        System.out.println("Blackjack...");
        System.out.println(player);
        System.out.println("the dealer is showing:" + dealer.getHand().get(0)); // Only show one of the dealers cards
        
        // make stuff to run game 
    }








    public static void main(String[] args)  {
    Game g = new Game();
    g.playGame();  
    }
}
