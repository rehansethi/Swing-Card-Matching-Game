import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JPanel;

/*
 MemoryGamePanel is the main panel where the memory matching game is drawn and played.
 It extends JPanel to allow custom drawing and implements MouseListener to handle when the card is clicked
 */


public class MemoryGamePanel extends JPanel implements java.awt.event.MouseListener{ //explain why JPanel is

    //Defining instance variables

    private ArrayList<Cards> cards;//variable that holds all 16 cards
    private ArrayList<Cards> Flippedcards = new ArrayList<>(); //Arraylist that will be used to store the cards that are clicked on
    private static final int Card_Width = 120;//width of each card
    private static final int Card_Height = 150;//height of each card


    public MemoryGamePanel(){ // MemoryGamePanel constructor
        //formats the panel by adding background colour and dimensions
        setBackground(Color.BLACK); 
        setPreferredSize(new java.awt.Dimension(650, 700));
        
        
        initializeCards(); // Initializes the cards and shuffles their positions on the board
        addMouseListener(this); // Enables the panel to respond to mouse clicks by setting it as its own MouseListener
        

    }

    public void initializeCards() {
        cards = new ArrayList<>();//Arraylist that will be used to store the different "faces" --> 4 of each emotion
        String[] faces = {"Happy", "Sad", "Angry", "Surprised"};
        for (String face : faces) { //iterates to the Array (with string) arguments --> the different emotions


            for (int count=0; count<4 ; count++){ //goes through the array 4 times
                 cards.add(new Cards(face, 0, 0)); //adds the emotion to the arraylist

        }
    }

        Collections.shuffle(cards); //shuffle the arrayList labeled "cards" to mix up the location of the "faces"
        repaint();  //Triggers a redraw of the panel
    }

    @Override
    protected void paintComponent(Graphics g2d){ //paintComponent is called whenever the panel needs to be redrawn. It clears the screen and draws all cards
        super.paintComponent(g2d);
        drawCards(g2d);
    }

    private void drawCards(Graphics g2d){ //Draws the 4x4 grid of cards and positions them on the screen


        int width = 130;
        int height = 140;
        int border = 15;
    
        int startX = (getWidth() - (4 * width + 3 * border)) / 2;
        int startY = (getHeight() - (4 * height + 3 * 25)) / 2-10;
    
        for (int i = 0; i < cards.size(); i++) { //gets the x and y positions of the white cards
            int xPosition = startX + (i % 4) * (width + border);
            int yPosition = startY + (i / 4) * (height + 25); 
            

            Cards card = cards.get(i);
            card.setPosition(xPosition, yPosition); //sets cards position on the grid
    
  
            card.draw(g2d); //draws the white card. Depending on its state, the card is drawn with or without the fac
        }
    }


    //MouseListener method that reveals the face on the card when the card is clicked on. Checks if 4 consectutive cards clicked on match

    @Override
    public void mouseClicked(MouseEvent e) {
        //Gets the x and y position on the JPanel that is clicked and assigns it to different cariables
        int mousex= e.getX();
        int mousey= e.getY();

        for (Cards card : cards) {
            if (!card.isRevealed() && !card.isMatched()) {
                int x = card.getX();
                int y = card.getY();
                    if ((mousex >= x && mousex <= x+Card_Width) && (mousey >=y && mousey <= y+Card_Height)){//checks if the position the user clicks on is within card boundries
                       if (!Flippedcards.contains(card)){
                        checkmatch(card); // Passes the clicked card to checkmatch()
                       }
                       break;
                    }
                }
            }
        }
    
    /* 
    Reveals the clicked card and checks whether the 4 selected cards match.
    If they do, mark them as matched, otherwise, hide them after a delay.
    */

    private void checkmatch(Cards ClickeCard){
        ClickeCard.setRevealed(true);
        repaint();

        Flippedcards.add(ClickeCard);

        if (Flippedcards.size()==4){
            
            boolean setdone = true;
            String firstclick = Flippedcards.get(0).getFace();

            for (Cards c : Flippedcards){ //iterates through the emotions in the "Flippedcards" arraylist
                if (!c.getFace().equals(firstclick)) {//logic if cards do not match
                    setdone = false;
                    break;

            }
        }

        if (setdone){
            for (Cards c : Flippedcards) {
                c.setMatched(true); //flag it as matched if the 4 cards match
            }
                Flippedcards.clear();//clear the FlippedCards list

                CheckWin();//Passes to the CheckWin method to see if the player has won
            } 
            else {
            //Use a Timer with an ActionListener that waits 1 second before hiding the unmatched cards and repainting the board
                javax.swing.Timer flipBack = new javax.swing.Timer(1000, new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        for (Cards c : Flippedcards) {
                            c.setRevealed(false);//Hide faces again
                        }
                        Flippedcards.clear();
                        repaint();
                    }
                });
                flipBack.setRepeats(false);
                flipBack.start();
            }
        }
    }

    private void CheckWin(){ //Checks if all cards are matched
        boolean completed = true;

        if (completed){
            for (Cards c : cards){
                if(!c.isMatched()){
                    completed = false;
                    break;
                }
            }

            if (completed) {
                javax.swing.JOptionPane.showMessageDialog(this, " Winner! "); // If all the cards are revealed prints a message showing the message "Winner!"
            }
        }
    }
    
    
    //MouseListener methods (required for interface), however don't require any logic and are unused.
    @Override 
    public void mousePressed(MouseEvent e) {}
    @Override 
    public void mouseReleased(MouseEvent e) {}
    @Override 
    public void mouseEntered(MouseEvent e) {}
    @Override 
    public void mouseExited(MouseEvent e) {}
}