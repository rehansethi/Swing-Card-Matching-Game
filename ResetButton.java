import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
 The ResetButton class handles the action of resetting the memory game.
 It implements ActionListener and is triggered when the user clicks the "Reset" button.
 */

public class ResetButton implements ActionListener {

    private MemoryGamePanel restart;

    public ResetButton(MemoryGamePanel restart) { //Constructor takes in a MemoryGamePanel object to be reset when the button is clicked.

        this.restart = restart;
    }

    /*
     This method is called when the Reset button is clicked It reinitializes and repaints the game board to start a new round.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        restart.initializeCards();//shuffles cards
        restart.repaint();//resets the cards
    }
    
}
