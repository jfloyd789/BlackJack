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
    public int handValue(Player player) {
        int value = 0;
        int numberOfAces = 0;

        for (Card card : player.getHand()) {
            value += card.getValue();
            if(card.getRank().equals("A")) {
                numberOfAces++;
            }
        }
        while (value > 21 && numberOfAces > 0) { // this make sure aces are counted as 1 if the person goes over 21
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

        Scanner scanner = new Scanner(System.in);


        
        System.out.println("Blackjack...");
        System.out.println(player);
        System.out.println("the dealer is showing:" + dealer.getHand().get(0)); // Only show one of the dealers cards
        


        //this is the players turn 
        while (handValue(player) < 21) {
            System.out.print("Hit or stand (h/s)");
            String choice = scanner.nextLine();
            if (choice.equals("h")) {
                player.addCard(deck.deal());
                System.out.println(player);
            }
            else if (choice.equals("s")) {
                break;
            }
            else {
                System.out.println("please enter either 'h' or 's'");
            }
        }
        if (handValue(player) > 21 ){
            System.out.println("you busted you lose");

        }

        //dealers turn 
        while (handValue(dealer) < 17){
            System.out.println("dealer Hits.");
            dealer.addCard(deck.deal());
            System.out.println(dealer);
        }

        if(handValue(dealer)> 21){
            System.out.println("dealer busted");
            return;
        }

        int playerScore = handValue(player);
        int dealerScore = handValue(dealer);

        
        System.out.println("your final hand value" + playerScore );
        System.out.println("dealer final hand value" + dealerScore);

        if (playerScore > dealerScore){
            System.out.println("you win");
        }
        else if (playerScore < dealerScore){
            System.out.println("dealer wins");
        }
        else{
            System.out.println("tie");
        }

        
    }








    public static void main(String[] args)  {
    Game g = new Game();
    g.playGame();  
    }
}
