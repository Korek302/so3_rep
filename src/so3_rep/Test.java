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
		System.out.println("braki stron - FIFO: "+f.fifo());
		OPT o = new OPT(referenceString, memory2);
		System.out.println("braki stron - OPT: "+o.opt());
		LRU l = new LRU(referenceString, memory3);
		System.out.println("braki stron - LRU: " + l.lru());
		ALRU al = new ALRU(referenceString, memory4);
		System.out.println("braki stron - ALRU: " + al.alru());
		RAND r = new RAND(referenceString, memory5);
		System.out.println("braki stron - RAND: "+r.rand());
	}
}
