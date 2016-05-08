package so3_rep;

public class LRU
{
	ReferenceString referenceString = new ReferenceString();
	Memory memory = new Memory();
	
	public LRU(ReferenceString referenceString, Memory memory)
	{
		this.referenceString = referenceString;
		this.memory = memory;
	}
	
	public Frame empty()
	{
		if(!memory.isEmpty())
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
		if(!memory.isEmpty())
		{
			Frame out = memory.get(0);
			for(Frame frame: memory.memory)
			{
				if(frame.age > out.age)
				{
					out = frame;
				}
			}
			return out;
		}
		else
		{
			return null;
		}
	}
	
	public int lru()
	{
		int errorCounter = 0;
		for(int i = 0; i < referenceString.numberOfReferences; i++)
		{
			for(Frame frame: memory.memory)
			{
				frame.age++;
			}
			
			if(isInMemory(referenceString.get(i)) == true)
			{
				for(Frame f: memory.memory)
				{
					if(f.value == referenceString.get(i))
					{
						f.age = 0;
						break;
					}
				}
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
				temp.value = referenceString.get(i);
				temp.age = 0;
				errorCounter++;
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
