package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controller.RPSController;

public class RPSPanel extends JPanel
{
	private RPSController baseController;
	private JTextField playerInput;
	private SpringLayout baseLayout;
	private Button submitButton;
	private JLabel playerResults;
	private JLabel computerResults;
	private JLabel winResults;
	private JLabel instructions;
	private String userChoice;
	private String computerChoice;
	private int losses;
	private int wins;
	private int tie;
	private JLabel winInfo;
	private JLabel loseInfo;
	private JLabel tieInfo;
	private Button quitButton;
	
	
	public RPSPanel(RPSController baseController)
	{
		this.baseController = baseController;
		playerInput = new JTextField(10);
		baseLayout = new SpringLayout();
		submitButton = new Button("Submit");
		playerResults = new JLabel("  ");
		computerResults = new JLabel("  ");
		winResults = new JLabel("   ");
		instructions = new JLabel("Choose R for rock, P for paper, and S for scissors.");
		winInfo = new JLabel("Wins: ");
		loseInfo = new JLabel("Losses: ");
		tieInfo = new JLabel("Ties: ");
		quitButton = new Button("Quit");
		
		setupLayout();
		setupPanel();
		setupListeners();
	}

	private void setupListeners()
	{
		
		submitButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent click)
			{
				
				if(!playerInput.getText().equalsIgnoreCase("R") && !playerInput.getText().equalsIgnoreCase("P") && !playerInput.getText().equalsIgnoreCase("S"))
				{
					JOptionPane.showMessageDialog(null, "Only submit the characters R, P, or S");
				}
				else
				{
					computerChoice = baseController.getOpponent().chooseAnswer();
					userChoice = playerInput.getText();
					playerResults.setText(userChoice);
					computerResults.setText(computerChoice);
					String result = compareChoices(computerChoice);
					winResults.setText(result);
				}
			}

			
		});
		
	}

	private void setupLayout() 
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, playerInput, -12, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, -131, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 225, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -189, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, instructions, 11, SpringLayout.SOUTH, submitButton);
		baseLayout.putConstraint(SpringLayout.EAST, instructions, -107, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, playerInput, 195, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, playerInput, -161, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, playerResults, -24, SpringLayout.NORTH, playerInput);
		baseLayout.putConstraint(SpringLayout.EAST, playerResults, -230, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, winResults, 21, SpringLayout.SOUTH, computerResults);
		baseLayout.putConstraint(SpringLayout.SOUTH, winResults, -29, SpringLayout.NORTH, playerResults);
		baseLayout.putConstraint(SpringLayout.SOUTH, computerResults, -293, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, computerResults, -219, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, winResults, 0, SpringLayout.WEST, submitButton);
		baseLayout.putConstraint(SpringLayout.EAST, winResults, 0, SpringLayout.EAST, playerInput);
		baseLayout.putConstraint(SpringLayout.NORTH, winInfo, 127, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, winInfo, 79, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, tieInfo, 127, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, tieInfo, -26, SpringLayout.EAST, submitButton);
		baseLayout.putConstraint(SpringLayout.EAST, tieInfo, 60, SpringLayout.EAST, submitButton);
		baseLayout.putConstraint(SpringLayout.EAST, winInfo, -6, SpringLayout.WEST, loseInfo);
		baseLayout.putConstraint(SpringLayout.NORTH, loseInfo, 127, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, loseInfo, 183, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, loseInfo, 281, SpringLayout.WEST, this);
	}

	private void setupPanel()
	{
		
		this.setSize(500, 500);
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(baseLayout);
		this.add(playerInput);
		this.add(submitButton);
		this.add(playerResults);
		this.add(computerResults);
		this.add(winResults);
		this.add(instructions);
		this.add(winInfo);
		this.add(loseInfo);
		this.add(tieInfo);
		this.add(quitButton);
		
		
	}
	private String compareChoices(String computerChoice) 
	{
		String result = "";
		
		if(userChoice.equalsIgnoreCase("R"))
		{
			if(computerChoice.equalsIgnoreCase("R"))
			{
				
				result = "Tie!";
				winResults.setText(result);
				tie++;
				tieInfo.setText("Ties: " + tie );
			}
			else if(computerChoice.equalsIgnoreCase("P"))
			{
				result = "You Lose :(";
				winResults.setText(result);
				losses++;
				loseInfo.setText("Losses: " + losses );
			}
			else if(computerChoice.equalsIgnoreCase("S"))
			{
				result = "You WIN!!!";
				winResults.setText(result);
				wins++;
				winInfo.setText("Wins: " + wins );
			}
		}
		else if(userChoice.equalsIgnoreCase("P"))
		{
			if(computerChoice.equalsIgnoreCase("R"))
			{
				
				result = "You WIN!!!";
				winResults.setText(result);
				wins++;
				winInfo.setText("Wins: " + wins );
			}
			else if(computerChoice.equalsIgnoreCase("P"))
			{
				result = "Tie!";
				winResults.setText(result);
				tie++;
				tieInfo.setText("Ties: " + tie );
			}
			else if(computerChoice.equalsIgnoreCase("S"))
			{
				result = "You Lose :(";
				winResults.setText(result);
				losses++;
				loseInfo.setText("Losses: " + losses );
			}
		}
		else if(userChoice.equalsIgnoreCase("S"))
		{
			if(computerChoice.equalsIgnoreCase("R"))
			{
				
				result = "You Lose :(";
				winResults.setText(result);
				losses++;
				loseInfo.setText("Losses: " + losses );
			}
			else if(computerChoice.equalsIgnoreCase("P"))
			{
				result = "You WIN!!!";
				winResults.setText(result);
				wins++;
				winInfo.setText("Wins: " + wins );
			}
			else if(computerChoice.equalsIgnoreCase("S"))
			{
				result = "Tie!!";
				winResults.setText(result);
				tie++;
				tieInfo.setText("Ties: " + tie );
			}
		}
		return result;
		
	}
}
