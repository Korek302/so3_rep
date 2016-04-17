package so3_rep;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReferenceString
{
	int numberOfReferences = 10;
	List<Integer> referenceString = new ArrayList<Integer>(numberOfReferences);
	
	public ReferenceString()
	{
		Random rand = new Random();
		for(int i = 0; i < numberOfReferences; i++)
		{
			referenceString.add(rand.nextInt(10));
		}
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
