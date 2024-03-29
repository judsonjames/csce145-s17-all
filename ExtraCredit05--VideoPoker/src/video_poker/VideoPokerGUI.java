package video_poker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.util.Random;

public class VideoPokerGUI implements ActionListener {
  // Miscellaneous J-Items
  private JFrame frame;
  private JTextArea money;
  
  // Buttons for Cards
  private JButton card01;
  private JButton card02;
  private JButton card03;
  private JButton card04;
  private JButton card05;
  
  // Buttons for Wagers
  private JButton wager10;
  private JButton wager20;
  private JButton wager50;
  private JButton wager100;
  private JButton wagerContinue;

  // Instance variables for earnings
  private int earnings;
  
  // Instance variables for dimensions
  private int bWidth = 50;
  private int bHeight = 100;
  private int bXBase = 50;
  private int bYBase = 50;
  private int bDX = 70;
  private int bDY = 70;
  
  // Default Constructor
  public VideoPokerGUI () {
    // Initialize variables
    this.frame = new JFrame("CSCE 145 -- Video Poker");
    this.earnings = getEarnings();
    this.money = new JTextArea(earnings + "");
    
    this.card01 = new JButton();
    changeCard(1);
    this.card02 = new JButton();
    changeCard(2);
    this.card03 = new JButton();
    changeCard(3);
    this.card04 = new JButton();
    changeCard(4);
    this.card05 = new JButton();
    changeCard(5);

    this.wager10 = new JButton("$10");
    this.wager20 = new JButton("$20");
    this.wager50 = new JButton("$50");
    this.wager100 = new JButton("$100");
    this.wagerContinue = new JButton("GO!!");
    
    // Set Boundaries
    this.card01.setBounds(bXBase, bYBase, bWidth*6, bHeight);
    this.card02.setBounds(bXBase, bYBase + bDY*2, bWidth*6, bHeight);
    this.card03.setBounds(bXBase, bYBase + bDY*4, bWidth*6, bHeight);
    this.card04.setBounds(bXBase, bYBase + bDY*6, bWidth*6, bHeight);
    this.card05.setBounds(bXBase, bYBase + bDY*8, bWidth*6, bHeight);

    this.wager10.setBounds(bXBase, bYBase + bDY*10, bWidth, bHeight/2);
    this.wager20.setBounds(bXBase + bDX, bYBase + bDY*10, bWidth, bHeight/2);
    this.wager50.setBounds(bXBase + bDX*2, bYBase + bDY*10, bWidth, bHeight/2);
    this.wager100.setBounds(bXBase + bDX*3, bYBase + bDY*10, bWidth, bHeight/2);
    this.wagerContinue.setBounds(bXBase + bDX*4, bYBase + bDY*10, bWidth, bHeight/2);

    this.money.setBounds(bXBase + bDX*5, bYBase + bDY*10, bWidth, bHeight/2);
    
    // Add Buttons
    this.frame.add(card01);
    this.frame.add(card02);
    this.frame.add(card03);
    this.frame.add(card04);
    this.frame.add(card05);
    this.frame.add(wager10);
    this.frame.add(wager20);
    this.frame.add(wager50);
    this.frame.add(wager100);
    this.frame.add(wagerContinue);
    this.frame.add(money);
    
    
    // Set Frame Settings
    this.frame.setLayout(null);
    this.frame.setVisible(true);
    this.frame.setSize(money.getX() + bWidth + bDX, money.getY() + bHeight/2 + bDY);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.setResizable(false);  
    
    // Set Button Response
    this.card01.addActionListener(this);
    this.card02.addActionListener(this);
    this.card03.addActionListener(this);
    this.card04.addActionListener(this);
    this.card05.addActionListener(this);
    this.wager10.addActionListener(this);
    this.wager20.addActionListener(this);
    this.wager50.addActionListener(this);
    this.wager100.addActionListener(this);
    this.wagerContinue.addActionListener(this);
  } // end of Constructor
  
  // File I/O to receive ONE number
  public int getEarnings() {
    return 0;
  }
  // Print ONE integer to the file
  public void setEarnings() {
    
  }

  public void changeCard(int index) {
    Random random = new Random();
    int caseInt = random.nextInt(3);
    int valueInt = random.nextInt(13);
    String[] casesArray = {"Spades", "Clubs", "Diamonds", "Hearts"};
    String cases = casesArray[caseInt];
    String value = "";
    String cardInfo = "";
    
    switch (valueInt) {
      case 0:
        value = "A";
        break;
      case 11:
        value = "J";
        break;
      case 12:
        value = "Q";
        break;
      case 13:
        value = "K";
        break;
      default:
        value = "" + valueInt;
        break;
    }
    cardInfo = "Card " + index + " -->   " + cases + "   " + value;
    
    switch (index) {
      case 1:
        card01.setText(cardInfo);
        break;
      case 2:
        card02.setText(cardInfo);
        break;
      case 3:
        card03.setText(cardInfo);
        break;
      case 4:
        card04.setText(cardInfo);
        break;
      case 5:
        card05.setText(cardInfo);
        break;
      default:
        money.setText("Error");
        break;
    }
  } // end of changeCard(int)
  
  public void checkForWinnings() {
    // Checks for different cases listed within the description
  }
  
  public void resetGame() {
    // Reset all of the Cards
  }
  
  public void actionPerformed(ActionEvent e) {
    
  }
  
  
} // end of VideoPokerGUI