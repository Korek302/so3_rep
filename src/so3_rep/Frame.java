package so3_rep;

public class Frame
{
	int value;
	int age;
	int timeUntilUsed;
	
	public Frame(int value)
	{
		this.value = value;
		age = 0;
		timeUntilUsed = 0;
	}
	
	public String toString()
	{
		return " "+value+" ";
	}
}
