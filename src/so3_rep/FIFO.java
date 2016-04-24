package so3_rep;

public class FIFO
{
	ReferenceString referenceString;
	Memory memory;
	
	public FIFO(ReferenceString referenceString, Memory memory)
	{
		this.referenceString = referenceString;
		this.memory = memory;
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
	
	public Frame max()
	{
		if(!memory.memory.isEmpty())
		{
			Frame out = memory.memory.get(0);
			for(Frame frame: memory.memory)
			{
				if(frame.age > out.age)
					out = frame;
			}
			return out;
		}
		else
		{
			return null;
		}
	}
	
	public int fifo()
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
