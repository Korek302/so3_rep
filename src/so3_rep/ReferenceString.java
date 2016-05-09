package so3_rep;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReferenceString
{
	int numberOfReferences = 1000;
	List<Integer> referenceString = new ArrayList<Integer>(numberOfReferences);
	
	public ReferenceString()
	{
		Random rand = new Random();
		for(int i = 0; i < numberOfReferences; i++)
		{
			referenceString.add(rand.nextInt(10));
		}
	}
	
	public int get(int index)
	{
		return referenceString.get(index);
	}
	
	public int size()
	{
		return referenceString.size();
	}
	
	public String toString()
	{
		String out = "";
		for(int s: referenceString)
		{
			out+=s+" ";
		}
		return out;
	}
}
