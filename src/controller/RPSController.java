package controller;

import view.RPSFrame;
import model.Opponent;

public class RPSController 
{
	private Opponent baseOpponent;
	private RPSFrame baseFrame;
	
	public RPSController()
	{
		baseOpponent = new Opponent();
		baseFrame = new RPSFrame(this);
	}
	
	public void start()
	{
		
	}
	
	public Opponent getOpponent()
	{
		return baseOpponent;
	}
	
	
}
