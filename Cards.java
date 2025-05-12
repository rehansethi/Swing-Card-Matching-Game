import java.awt.Color;
import java.awt.Graphics;


public class Cards {

    //Instance variables for Cards class
    private String face; //face/emotion drawn on the cards
    private int x; //x position
    private int y; //y position
    private boolean isRevealed = false; //boolean flag  if cards are revealed
    private boolean isMatched = false; //boolean flag if cards are matched


    public Cards(String face, int x, int y) {
        this.face = face;
        this.x = x;
        this.y = y;
    }

    //Gettor Methods (to read/access variables outside of this class)
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    //Settor methods (These are used to update private variables from outside this class (write access))

    public String getFace() {
        return face;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isRevealed(){
        return isRevealed;
    }

    public boolean isMatched(){
        return isMatched;
    }

    public void setRevealed(boolean Revealed){  //Sets whether the card is currently revealed (face-up)
        this.isRevealed = Revealed;
    }


    public void setMatched(boolean Matched){ //Sets whether the card is currently revealed (face-up)
        this.isMatched = Matched;
    }



/*Draws a single card on the screen.
The card appears as a white rectangle with a black border.
 If the card is revealed or matched, it also displays its corresponding face.
 */
public void draw(Graphics g2d) {
    int width = 120;
    int height = 150;

    //Set color to white and draw the filled rectangle for the card background
    g2d.setColor(Color.white);
    g2d.fillRect(x, y, width, height);  //This is the face-down part of the card

    //Set color to black and draw the outline/border of the card
    g2d.setColor(Color.BLACK);
    g2d.drawRect(x, y, width, height);

    //If the card is revealed or already matched, draw the face on top of the card
    if (isRevealed || isMatched) {
        drawFace(g2d); //Calls method to draw the specific facial expression
    }
}
    
    /* 
     Draws the face of the card using simple 2D shapes,
     based on the emotion assigned to the card.
     */
    public void drawFace(Graphics g2d) {
        if (face.equals("Happy")) {//Drawing face for "Happy" emotion
            g2d.setColor(Color.YELLOW);//Head
            g2d.fillOval(x + 20, y + 25, 80, 80);
        
       
            g2d.setColor(Color.BLACK); //Eyes
            g2d.fillOval(x + 43, y + 50, 10, 10);
            g2d.fillOval(x + 70, y + 50, 10, 10); 
        
     
            g2d.setColor(Color.BLACK); //Mouth
            g2d.drawArc(x + 40, y + 70, 40, 15, 0, -180); 
        }
            
        else if (face.equals("Sad")){ //Drawing face for "Sad" emotion
            g2d.setColor(Color.blue);
            g2d.fillOval(x + 20, y + 25, 80, 80);
            
            g2d.setColor(Color.BLACK);
            g2d.fillOval(x + 43, y + 50, 10, 10);
            g2d.fillOval(x + 70, y + 50, 10, 10); 
        
            g2d.setColor(Color.BLACK);
            g2d.drawArc(x + 40, y + 75, 40, 15, 0, 180); 
    
        }
    
        else if (face.equals("Angry")) { //Drawing face for "Angry" emotion
            g2d.setColor(Color.RED); 
            g2d.fillOval(x + 20, y + 25, 80, 80);
        
            g2d.setColor(Color.BLACK);
            g2d.fillOval(x + 43, y + 55, 10, 13); 
            g2d.fillOval(x + 70, y + 55, 10, 13);
        
            g2d.setColor(Color.BLACK);
            g2d.drawLine(x+40, y+45, x+55, y+55);
            g2d.drawLine(x+70, y+55, x+85, y+45);
    
            g2d.setColor(Color.BLACK);
            g2d.fillArc(x + 40, y + 75, 40, 20, 0, 180); 
        
        }
    
        else if (face.equals("Surprised")) { //Drawing face for "Suprised" emotion
            g2d.setColor(Color.GREEN); 
            g2d.fillOval(x + 20, y + 25, 80, 80);
        
            g2d.setColor(Color.BLACK);
            g2d.fillOval(x + 43, y + 50, 10, 13); 
            g2d.fillOval(x + 70, y + 50, 10, 13);
    
            g2d.setColor(Color.BLACK); 
            g2d.fillOval(x + 50, y + 70, 20, 15);
        }
    }
}