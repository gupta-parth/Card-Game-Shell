import javax.swing.*;
import java.awt.*;
import java.util.*;


public class Deck {
    Card cards[] = new Card[52];              // Creating a deck of cards
    Random rand = new Random();               // Random object
    int x;                                    // Positions
    int y;
    int index;                                // Keep track of the card
    protected boolean isSplay = false;        // Flags for actions (protected so that hand class can access)
    protected boolean pile = true;
    protected int numCards = 52;
    protected boolean changeFace = false;     // To know which side of the card to draw
    
    public Deck(int posX, int posY) {         // Deck constructor takes in the x and y coordinates
        x = posX;
        y = posY;

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 14; j++) {
                cards[index] = new Card(i, j); // Constructs card and puts it in the array
                index++;
            }
        }
    }
    
        
    public void splay() {  
        isSplay = true;
        pile = false;
    }
    
    public void pile() {
        pile = true;
        isSplay = false;
    }
    
    // Flips the cards, tells the computer to draw the other side of the card by using a flag
   public void flip() {
       if (changeFace == false) changeFace = true;
       else changeFace = false;
    }
    
    public void shuffle() {
        int num1, num2;
        for (int i = 0; i < 1000; i++) {        // Shuffles the cards 1000 times
            num1 = rand.nextInt(52);            // Three-way shuffle
            num2 = rand.nextInt(52);
            Card temp = cards[num1];
            cards[num1] = cards[num2];
            cards[num2] = temp;
        }
    }
    
    public void deal(Deck x) {
        if (this.numCards >= 1) {       // If the current deck has at least 1 card
            this.numCards--;            // Remove the card
            x.cards[x.numCards] = this.cards[this.numCards];    // Give the card to the deck that was in the parameter
            x.numCards++;       // Increase the card counter for the other deck
        }
    }
    
    public void draw(Container c, Graphics g) {
        if (isSplay) {
            for (int i = 0; i < numCards; i++) {
                cards[i].draw(c, g, x + i*12, y, changeFace);  // Draw with some offset for splaying
            } 
        }
        else if (pile) {
            for (int i = 0; i < numCards; i++) {
                cards[i].draw(c, g, x, y, changeFace);      // Draw with no offset for piling
            }
        }
        
    }
    
}
