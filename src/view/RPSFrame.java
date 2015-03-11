package view;

import javax.swing.JFrame;

import controller.RPSController;

public class RPSFrame extends JFrame
{
	private RPSController baseController;
	private RPSPanel basePanel;
	
	public RPSFrame(RPSController baseController)
	{
		this.baseController = baseController;
		basePanel = new RPSPanel(baseController);
		
		setupFrame();
	}

	private void setupFrame() 
	{
		
		this.setSize(500, 500);
		this.setResizable(false);
		this.setEnabled(true);
		this.setVisible(true);
		this.setContentPane(basePanel);
		
	}
}
