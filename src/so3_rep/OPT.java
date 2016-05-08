package so3_rep;

public class OPT
{
	ReferenceString referenceString = new ReferenceString();
	Memory memory = new Memory();
	
	public OPT(ReferenceString referenceString, Memory memory)
	{
		this.referenceString = referenceString;
		this.memory = memory;
	}
	
	public int opt()
	{
		int errorCounter = 0;
		boolean isDone = false;
		
		for(int i = 0; i < referenceString.numberOfReferences; i++)
		{
			for(Frame frame: memory.memory)
			{
				frame.age++;
			}
			for(int j=0; j < memory.size() && !isDone; j++)
            {
                if(memory.get(j).value == referenceString.get(i))
                {
                    isDone=true;
                }
                if(memory.memory.get(j).value == -1)
                {
                    Frame mem = new Frame(referenceString.get(i));
                    mem.timeUntilUsed = 0;
                    memory.memory.set(j, mem);
                    errorCounter++;
                    isDone = true;
                }
            }
			 if(isDone == false)
	            {
	                int temp = 0;
	                for(int j = 0; j < memory.size(); j++)
	                {
	                    for(int k = i; k < referenceString.size(); k++)
	                    {
	                        if(memory.get(j).value != referenceString.get(k))
	                        {
	                            temp++;
	                        }
	                        else
	                        {
	                            Frame f = new Frame(memory.get(j).value);
	                            f.timeUntilUsed = temp;
	                            memory.memory.set(j, f);
	                            break;
	                        }
	                    }
	                    temp = 0;
	                }
	                temp = 0;
	                int index = 0;
	                for(int l = 0; l < memory.size(); l++)
	                {
	                    if(memory.get(l).timeUntilUsed > temp)
	                    {
	                        temp = memory.get(l).timeUntilUsed;
	                        index = l;
	                    }
	                }
	                memory.memory.remove(index);
	                Frame memr = new Frame(referenceString.get(i));
	                memr.timeUntilUsed = 0;
	                memory.memory.add(memr);
	                errorCounter++;
	            }
	            isDone=false;
	        }
		return errorCounter;
	}
	
	/*public static void main(String[] args)
	{
		OPT o = new OPT();
		System.out.println(o.referenceString.toString());
		System.out.println("braki stron: "+o.opt());
	}*/
}
