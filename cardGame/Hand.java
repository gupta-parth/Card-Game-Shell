import javax.swing.*;
import java.awt.*;


public class Hand extends Deck{ 
    public Hand(int x, int y) {
        super(x, y);        // Calls the superclass constructor which in our case is deck
        numCards = 0;
    }
}
