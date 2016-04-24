package so3_rep;

public class Test
{
	public static void main(String[] args)
	{
		ReferenceString referenceString = new ReferenceString();
		Memory memory1 = new Memory();
		Memory memory2 = new Memory();
		Memory memory3 = new Memory();
		Memory memory4 = new Memory();
		Memory memory5 = new Memory();
		System.out.println(referenceString.toString());
		FIFO f = new FIFO(referenceString, memory1);
		System.out.println("braki stron: "+f.fifo());
		OPT o = new OPT();
		System.out.println("braki stron: "+o.opt());
		RAND r = new RAND(referenceString, memory2);
		System.out.println("braki stron: "+r.rand());
	}
}
