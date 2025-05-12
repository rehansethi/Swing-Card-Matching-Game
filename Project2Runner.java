
import javax.swing.JButton;
import javax.swing.JFrame;

public class Project2Runner {
    
    /*
     * Name: <Rehan Sethi>
     * Student ID: <501310139>
     * 
     ******** Project Description ********
     * 
     * Describe in plain English the overall program/program in a paragraph or 2.
    
     Description:
     
     This program is a “Card Matching Memory” game built using Java Swing. 
     It features a 4x4 grid of cards, each hiding one of four emotion-based faces: “Happy,” “Sad,” “Angry,” and “Surprised.”
     The objective is to find sets of four matching faces by clicking on 4 different cards to reveal them. If all four selected cards match, they stay revealed; if not, they flip back over after a short delay.

     The game is won when all cards  are successfully matched and all 16 cards are revealed. After winning, a pop-up message announces “Winner!”. 
     Additionaly, a “Reset” button is available to reshuffle the cards and restart the game at any time. 
     The interface uses a combination of 2D graphics to draw the cards and face expressions, and employs both mouse and action listeners to handle interactions.

     
     ******** Swing Requirement ********
     
     Swing Requirement:
    My program satisfies the Swing requirement by using three unique components: a JFrame, a JButton, and a custom JPanel. 
    The JFrame is created in Project2Runner.java (line 58) and serves as the main window for the game. A JButton labeled “Reset” is defined in Project2Runner.java at (line 69) 
    and allows the user to reshuffle and restart the game. Lastly, a custom JPanel called MemoryGamePanel is defined in MemoryGamePanel.java at line 14, which is used as the main canvas to draw the cards and handle user interaction. 
    Each of these components plays a meaningful role in the user interface and game functionality.
    
    
    ******** 2D Graphics Requirement ********
    
     2D Graphics Requirement:
     My program meets the 2D graphics requirement by using a custom JPanel called MemoryGamePanel defined in MemoryGamePanel.java at (line 14), 
     which acts as the main drawing area for the game. Inside this panel, the paintComponent method is overridden (starting at line 53) to draw all 16 cards. 
     Each card appears as a white rectangle, and when revealed, it shows a face like “Happy,” “Sad,” “Angry,” or “Surprised.” 
     These faces are drawn using basic 2D shapes such as ovals, arcs, and lines in the drawFace method in Cards.java (starting at line 80).



     ******** Event Listener Requirement ********

     Event Listener Requirement:

     My program satisfies the event listener requirement by including an ActionListener and a MouseListener. 
     The ActionListener is implemented in the ResetButton class ResetButton.java, (line 10), and it is used to reset the game when the user clicks the "Reset" button. 
     This listener is attached to the button in Project2Runner.java (line 75). 
     A MouseListener is also implemented in the MemoryGamePanel class (MemoryGamePanel.java, starting at line 31), where the mouseClicked method (line 84) is used to detect when the user clicks on cards. 

     */

    public static void main(String[] args) {
        //Create new JFrame Window
        JFrame frame = new JFrame("Matching Game");

        frame.setSize(700,700); //Set the size of the window

        frame.setLayout(null);
        frame.setVisible(true);

        MemoryGamePanel memoryGamePanel = new MemoryGamePanel();// Create the custom game panel that contains all the cards and game logic
        memoryGamePanel.setBounds(25, 50, 650, 700);
        frame.add(memoryGamePanel);

        JButton resetButton = new JButton(); // Create a Reset button to restart the game
        resetButton.setText("Reset");
        resetButton.setBounds(250, 20, 200, 30);
        frame.add(resetButton);//Adds it to the JFrame

        //Add an ActionListener to the Reset button so it can restart the game when clicked
        resetButton.addActionListener(new ResetButton(memoryGamePanel));

        
    }
}
