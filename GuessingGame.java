import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;//text field for the user's guess
	private JLabel lblOutput;	//label for too high/too low outcome
	private int theNumber; // the number we are trying to guess
	private int triesLeft = 7;//the number of tries given to guess

	public void checkGuess(){
		//method check too high too low
		//get the user's guess
		String guessText = txtGuess.getText();
		String message = "";
		
		try {
			//check the users guess for too high/low
			int guess = Integer.parseInt(guessText);
			
			//count this as one try
			triesLeft--;
			
			//too high
			if (guess > theNumber) {
				message = guess + " was too high.";
				message += "You have " + triesLeft + " tries left.";
				lblOutput.setText(message);
			}
			//too low
			else if (guess < theNumber) {
				message = guess + " was too low.";
				message += "You have " + triesLeft + " tries left.";
				lblOutput.setText(message);
			}
			//correct guess
			else {
				message = guess + " was correct! Lets play again.";
				lblOutput.setText(message);
				newGame();
			}
			
		}
	
		catch(Exception e) {
			lblOutput.setText("Please use only numbers between 1-100!");
		}
		finally{
		txtGuess.requestFocus();
		txtGuess.setText("");
		}
		if (triesLeft == 0) {
			javax.swing.JOptionPane.showConfirmDialog(null, 
					"Sorry, you ran out of tries. The number was " + theNumber + ". Play again?");
			lblOutput.setText("New game. Can you beat your previous score?");
			
			//message = "You ran out of tries! Game over.";
			//lblOutput.setText(message);		
			newGame();
		}
	}
	
	public void newGame() {//create a new random number between 1-100
		//randomize the users number to guess
		theNumber = (int)(Math.random()*100+1);
		triesLeft = 7;
		
	}
	
	public GuessingGame() {
		setTitle("Angelo's Hi-Lo Guessing Game");
		setBackground(SystemColor.textHighlight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(SystemColor.textHighlight);
		getContentPane().setLayout(null);
		
		JLabel lblAngelosHiloGuessing = new JLabel("Angelos Hi-Lo Guessing Game");
		lblAngelosHiloGuessing.setForeground(Color.WHITE);
		lblAngelosHiloGuessing.setBounds(155, 71, 810, 50);
		lblAngelosHiloGuessing.setFont(new Font("Alien Encounters", Font.BOLD, 35));
		lblAngelosHiloGuessing.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblAngelosHiloGuessing);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 5), null));
		panel.setBounds(181, 189, 758, 50);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Guess a number between 1 and 100:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 27));
		lblNewLabel.setBounds(52, 8, 496, 33);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtGuess = new JTextField();
		txtGuess.setFont(new Font("Tahoma", Font.PLAIN, 31));
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuess.setBounds(574, 5, 73, 39);
		panel.add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.setFont(new Font("Cracked Johnnie", Font.PLAIN, 27));
		btnGuess.setBounds(475, 307, 171, 41);
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnGuess.setToolTipText("");
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above and click Guess! You have 7 tries.");
		lblOutput.setFont(new Font("Good Times", Font.PLAIN, 24));
		lblOutput.setBounds(26, 416, 1068, 33);
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(1130, 730));
		theGame.setVisible(true);
		
	}
}
