import javax.swing.*;
import java.awt.*;


public class Card {
    int suit;           // Attributes for the card
    int value;
    private ImageIcon front;
    private ImageIcon back;

    
    public Card(int s, int val) {
        suit = s;
        value = val;
        int typeCard = (s * 13) + val;      // Quick maths for determining the image number
        String type = "" + typeCard;
        front = new ImageIcon("cards/" + type + ".png");
        back = new ImageIcon("cards/back2.png");
    }

    public void draw(Container c, Graphics g, int x, int y, boolean side) {
        if (side) {     // If side varibale is true then draw the front face
            front.paintIcon(c, g, x, y);
        }
        else {
            back.paintIcon(c, g, x, y);
        }
        return;
    }
}
