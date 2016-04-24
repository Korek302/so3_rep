package so3_rep;

import java.util.Random;

public class RAND
{
	ReferenceString referenceString = new ReferenceString();
	Memory memory = new Memory();
	
	public RAND(ReferenceString referenceString, Memory memory)
	{
		this.referenceString = referenceString;
		this.memory = memory;
	}
	
	public Frame empty()
	{
		if(!memory.memory.isEmpty())
		{
			Frame out = null;
			for(Frame frame: memory.memory)
			{
				if(frame.value == -1)
				{
					out = frame;
					break;
				}
			}
			return out;
		}
		else
		{
			return null;
		}
	}
	
	public boolean isInMemory(int value)
	{
		boolean out = false;
		for(Frame frame: memory.memory)
		{
			if(frame.value == value)
			{
				out = true;
				break;
			}
		}
		return out;
	}
	
	public Frame max()
	{
		if(!memory.memory.isEmpty())
		{
			Random rand = new Random();
			return memory.memory.get(rand.nextInt(memory.memory.size()));
		}
		else
		{
			return null;
		}
	}
	
	public int rand()
	{
		int errorCounter = 0;
		for(int i = 0; i < referenceString.numberOfReferences; i++)
		{	
			if(isInMemory(referenceString.referenceString.get(i)) == true)
			{
				;
			}
			else
			{
				Frame temp = null;
				if(empty() == null)
				{
					temp = max();
				}
				else
				{
					temp = empty();
				}
				temp.value = referenceString.referenceString.get(i);
				temp.age = 0;
				errorCounter++;
			}
			for(Frame frame: memory.memory)
			{
				frame.age++;
			}
			/*for(Frame f: memory.memory)
			{
				System.out.print(f.toString());
			}
			System.out.println("");*/
		}
		return errorCounter;
	}
}
