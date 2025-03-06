import javax.swing.*;
import java.awt.*;


public class GameViewer extends JFrame {

    private Game game;
    private Image backround;
    private Image cardBack;
   
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    
    public GameViewer(Game game){

        this.game = game;
        this.backround = new ImageIcon("Resources/Cards (1)/blackjackbackround.png").getImage();
        this.cardBack = new ImageIcon("Resources/Cards (1)/back.png").getImage();

        
        this.setTitle("Blackjack");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }

    public void paint(Graphics g){
        g.drawImage(backround, 0,0,WINDOW_WIDTH,WINDOW_HEIGHT, this);
       

        game.getPlayer().drawHand(g, 300, 500, this, cardBack);
        game.getDealer().drawHand(g, 320, 200, this, cardBack);
        g.drawImage(cardBack, 400, 200, 75, 125, this);



        g.setColor(Color.WHITE);  // Set text color
        g.setFont(new Font("Arial", Font.BOLD, 24)); // Set font
        g.drawString("Player Score: " + game.getPlayer().getPoints(), 50, 50);  // Display score
        g.drawString("Dealer Score: " + game.getDealer().getPoints(), 50, 80); // Display dealer score
    }







   
    
}
