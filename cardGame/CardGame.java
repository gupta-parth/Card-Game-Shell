/*
    Author: Parth
    Date: March 22, 2021
    Program: Card game shell
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CardGame extends JFrame implements ActionListener             // this is how you create an application in a window
{

    /* this sets up the applet with a felt table in the centre
     * a control bar at the bottom (with two buttons for now)
     * a score bar at the top 
     * and the current bet.
       Use JPanels to make it all neat:
     */
         
    JPanel feltTable = new JPanel();        
    JPanel controlBar = new JPanel();       
    JPanel scoreBar = new JPanel();         
    JPanel currentBet = new JPanel();       
    
    /*  Panels arranged like this:
     
     * ---------------------------------------------
     *        score Panel    |    Bet Panel
     * ---------------------------------------------
     * 
     * 
     *                Felt Panel
     *                 
     * ---------------------------------------------
     *                control Panel
     *----------------------------------------------
     */
    
        
    // buttons:
    JButton shuffleButton = new JButton("Shuffle");
    JButton quitButton = new JButton("Quit");
    JLabel scoreLabel = new JLabel("Score:");
    JLabel betLabel = new JLabel ("Current Bet:");
    JButton splayDeckButton = new JButton("Splay");
    JButton dealButton = new JButton("Deal");
    JButton discardButton = new JButton("Discard");
    JButton faceButton = new JButton("Face");
    JButton pileButton = new JButton("Pile");
    JButton splayHandButton =  new JButton("Splay Hand!!");
    JButton pileHandButton = new JButton("Pile hand");
    

    
    Deck deck = new Deck(100, 100);     // Creates a deck and a hand
    Hand hand = new Hand(100, 400);
 
    public CardGame()
    {
        super ("Blah Blah Blah");      
      
        Container pane = getContentPane(); 
        pane.setLayout(new BorderLayout());         
        
        pane.add(feltTable, BorderLayout.CENTER);   // put felt in middle   
        Color feltGreen = new Color(10,100,10);
        feltTable.setBackground(feltGreen);    
        
        pane.add("South", controlBar);
        pane.add(controlBar, BorderLayout.SOUTH);   // put button bar at bottom
        Color grey = new Color(140,160,160);

        // Adds all the buttons
        controlBar.setBackground(grey);
        controlBar.add(shuffleButton);
        controlBar.add(quitButton);
        controlBar.add(dealButton);
        controlBar.add(splayDeckButton);
        controlBar.add(discardButton);
        controlBar.add(faceButton);
        controlBar.add(pileButton);
        
        splayHandButton.setForeground(Color.BLUE);
        pileHandButton.setForeground(Color.BLUE);
        controlBar.add(splayHandButton);
        controlBar.add(pileHandButton);
        
        // Adds action listeneres for all the buttons
        splayDeckButton.addActionListener(this);
        faceButton.addActionListener(this);
        pileButton.addActionListener(this);
        shuffleButton.addActionListener(this);
        discardButton.addActionListener(this);
        quitButton.addActionListener(this);
        dealButton.addActionListener(this);
        splayHandButton.addActionListener(this);
        pileHandButton.addActionListener(this);
        
        pane.add(scoreBar, BorderLayout.NORTH);     // put score at top
        scoreBar.setBackground(grey);
        scoreBar.setLayout(new GridLayout(1,2));    // make one row, two columns
        scoreBar.add(scoreLabel);                   
        scoreBar.add(betLabel);
        
        Font font = new Font("Comic Sans MS", Font.PLAIN, 18);
        scoreLabel.setFont(font);
        betLabel.setFont(font);
        Font font2 = new Font("Comic Sans MS", Font.PLAIN, 14);
        shuffleButton.setFont(font2);
        quitButton.setFont(font2);
        splayDeckButton.setFont(font2);
        dealButton.setFont(font2);
        discardButton.setFont(font2);
        faceButton.setFont(font2);
        pileButton.setFont(font2);
        
             
        setSize (900,600);
        setVisible(true);
        repaint();       
        
    }
    
    
    public void actionPerformed(ActionEvent e) {
        // Call the respective methods if buttons are pressed
        if (e.getSource() == splayDeckButton) {
           deck.splay();
        }
        else if (e.getSource() == faceButton) {
            deck.flip();
        }
        else if (e.getSource() == pileButton) {
            deck.pile();
        }
        else if (e.getSource() == shuffleButton) {
            deck.shuffle();
        }
        else if (e.getSource() == quitButton) {
            System.exit(0);
        }
        else if (e.getSource() == dealButton) {
            deck.deal(hand);
        }
        else if (e.getSource() == splayHandButton) {
            hand.splay();
        }
        else if (e.getSource() == pileHandButton) {
            hand.pile();
        }
        else if (e.getSource() == discardButton) {
            hand.deal(deck);
        }
        repaint();      // Always repaint after something has happened
    }
    
    public void paint(Graphics g)
    {
       
        super.paint(g);
        

        deck.draw(feltTable, g);       // Draw the hand and the deck on the green felt
        hand.draw(feltTable, g);

    }
    
    public static void main( String args[])    // This is how you set up an application (not applet)
    {
        CardGame game = new CardGame();        // construct the card game (call the constructor)
        game.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);     // allows you to hit the X button to close
    }
    
}