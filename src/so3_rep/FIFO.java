package so3_rep;

public class FIFO
{
	ReferenceString referenceString = new ReferenceString();
	Memory memory = new Memory();
	
	public FIFO()
	{
		
	}
	
	public boolean is(int value)
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
			if(is(referenceString.referenceString.get(i)) == true)
			{
				;
			}
			else
			{
				Frame temp = max();
				temp.value = referenceString.referenceString.get(i);
				temp.age = 0;
				errorCounter++;
			}
			for(Frame frame: memory.memory)
				{
					frame.age++;
				}
		}
		return errorCounter;
	}
	
	public static void main(String[] args)
	{
		FIFO f = new FIFO();
		System.out.println(f.referenceString.toString());
		System.out.println(f.fifo());
	}
}
