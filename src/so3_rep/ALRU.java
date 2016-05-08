package so3_rep;

public class ALRU
{
	ReferenceString referenceString = new ReferenceString();
	Memory memory = new Memory();
	
	public ALRU(ReferenceString referenceString, Memory memory)
	{
		this.referenceString = referenceString;
		this.memory = memory;
	}
	
	public int alru()
	{
		int errorCounter = 0;
        boolean isDone = false;
        for(int i=0; i < referenceString.size(); i++)
        {
            for(int j = 0; j < memory.size() && !isDone; j++)
            {
                if(memory.get(j).value == referenceString.get(i))
                {
                    Frame f = new Frame(referenceString.get(i));
                    f.age = 1;
                    memory.memory.set(j, f);
                    isDone = true;
                }
                if(memory.get(j).value == 0)
                {
                    Frame f = new Frame(referenceString.get(i));
                    f.age = 0;
                    memory.memory.set(j, f);
                    errorCounter++;
                    isDone = true;
                }
            }
            if(isDone == false)
            {
                boolean isInserted = false;
                while(isInserted == false)
                {
                    for(int k = 0; k < memory.size();k++)
                    {
                        if(memory.get(k).age == 1)
                        {
                            Frame fr = new Frame(memory.get(k).value);
                            fr.age = 0;
                            memory.memory.set(k, fr);
                        }
                        else
                        {
                            memory.memory.remove(k);
                            Frame fr2 = new Frame(referenceString.get(i));
                            fr2.age = 0;
                            memory.memory.add(fr2);
                            errorCounter++;
                            isInserted = true;
                            break;
                        }
                    }
                }
            } 
            isDone=false;
        }
        return errorCounter;
	}
}
