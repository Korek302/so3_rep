package so3_rep;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class ALRU
{
	ReferenceString referenceString;
	Memory memory;
	
	public ALRU(ReferenceString referenceString, Memory memory)
	{
		this.referenceString = referenceString;
		this.memory = memory;
	}
	
	public Frame isInMemory(int value)
	{
		Frame out = null;
		for(Frame frame: memory.memory)
		{
			if(frame.value == value)
			{
				out = frame;
				break;
			}
		}
		return out;
	}
	
	public Frame empty()
	{
		Frame out = null;
		if(!memory.memory.isEmpty())
		{
			for(Frame frame: memory.memory)
			{
				if(frame.value == -1)
				{
					out = frame;
					break;
				}
			}
			
		}
		return out;
	}
	
	public int alru()
	{
		int errorCounter = 0;
		for(int i = 0; i < referenceString.numberOfReferences; i++)
		{	
			if(isInMemory(referenceString.referenceString.get(i)) != null)
			{
				isInMemory(referenceString.referenceString.get(i)).timeUntilUsed = 1;
			}
			else
			{
				Frame temp = null;
				if(empty() == null)
				{
					
					ArrayList<Frame> list = new ArrayList<Frame>(memory.memory);
					sort(list);
					Deque<Frame> deque = new ArrayDeque<Frame>(list);
					boolean isDone = false;
					for(int l = 0; l < deque.size() + 1 && !isDone; l++)
					{
						if(deque.peekLast().timeUntilUsed == 1)
						{
							deque.peekLast().timeUntilUsed = 0;
							deque.addFirst(deque.pollLast());
						}
						else
						{
							temp = deque.peekLast();
							isDone = true;
						}
					}
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
			for(Frame f: memory.memory)
			{
				System.out.print(f.toString() + "["+f.timeUntilUsed+"]");
			}
			System.out.println("");
		}
		return errorCounter;
	}
	
	public ArrayList<Frame> sort(ArrayList<Frame> list)
	{
		for(int i = 1; i < list.size(); i++)
			for(int left = 0; left < list.size()-i; left++)
			{
				int right = left + 1;
				if((list.get(left).age - list.get(right).age) > 0)
				{
					swap(list, left, right);
				}
			}
		return list;
	}
	
	public void swap(ArrayList<Frame> list, int left, int right)
	{
        Frame temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }
}
