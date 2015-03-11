package model;

public class Opponent 
{
	private String answer;
	private int lastChosen;
	
	public Opponent()
	{
		lastChosen = -1;
	}
	
	public String chooseAnswer()
	{
		int answerChooser = -1;
		answer = "";
		answerChooser = (int) (Math.random() * 3);
		answer = findAnswer(answerChooser, lastChosen);
		lastChosen = answerChooser;
		return answer;
		
	}
	
	public String findAnswer(int choice, int lastNum)
	{
		String selection = "";
		
		if(choice == 0 /*&& lastNum != 0*/)
		{
			selection = "R";
		}
		else if(choice == 1 /*&& lastNum != 1*/)
		{
			selection = "P";
		}
		else if(choice == 2 /*&& lastNum != 2*/)
		{
			selection = "S";
		}
		
		return selection;
	}
}
