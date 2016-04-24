package so3_rep;

import java.util.ArrayList;
import java.util.List;

public class Memory
{
	int numberOfFrames = 3;
	List<Frame> memory = new ArrayList<Frame>(numberOfFrames);
	
	public Memory()
	{
		for(int i = 0; i < numberOfFrames; i++)
		{
			memory.add(new Frame(-1));
		}
	}
	
	public Memory getMemory()
	{
		return (Memory) memory;
	}
	
	public Frame get(int index)
	{
		return memory.get(index);
	}
	
	public boolean isEmpty()
	{
		return memory.isEmpty();
	}
}
