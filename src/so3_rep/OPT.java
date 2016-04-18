package so3_rep;

public class OPT
{
	ReferenceString referenceString = new ReferenceString();
	Memory memory = new Memory();
	
	public OPT()
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
				if(frame.timeUntilUsed < out.timeUntilUsed)
					out = frame;
			}
			return out;
		}
		else
		{
			return null;
		}
	}
	
	public int opt()
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
				int j, k;
				k = 0;
				if(i < referenceString.referenceString.size()-1)
				{
					j = referenceString.referenceString.get(i + 1);
					for(;j < referenceString.referenceString.size(); j++)
					{
						k++;
						if(temp.value == referenceString.referenceString.get(j))
						{
							break;
						}	
					}
					if(j == referenceString.referenceString.size())
					{
						k = 0;
					}
					errorCounter++;
				}
				temp.timeUntilUsed = k;
				
			}
			for(Frame frame: memory.memory)
			{
				frame.timeUntilUsed--;
			}
			for(Frame frame: memory.memory)
			{
				frame.age++;
			}
			for(Frame f: memory.memory)
			{
				System.out.print(f.toString());
			}
			System.out.println("");
		}
		return errorCounter;
	}
	
	public static void main(String[] args)
	{
		OPT o = new OPT();
		System.out.println(o.referenceString.toString());
		System.out.println("braki stron: "+o.opt());
	}
}
