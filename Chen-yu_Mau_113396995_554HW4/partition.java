// partition.java
// demonstrates partitioning an array
// to run this program: C>java PartitionApp
////////////////////////////////////////////////////////////////
class ArrayPar
{
	private long[] theArray; // ref to array theArray
	private int nElems; // number of data items
//--------------------------------------------------------------
	public ArrayPar(int max) // constructor
	{
		theArray = new long[max]; // create the array
		nElems = 0; // no items yet
	}
	public long read(int max) // constructor
	{
		return(theArray[max]);
	}
	//--------------------------------------------------------------
	public void insert(long value) // put element into array
	{
		theArray[nElems] = value; // insert it
		nElems++; // increment size
	}
	//--------------------------------------------------------------
	public int size() // return number of items
	{ 
		return nElems; 
	}
	//--------------------------------------------------------------
	public void display() // displays array contents
	{
		System.out.print("A=");
		for(int j=0; j<nElems; j++) // for each element,
			System.out.print(theArray[j] + " "); // display it
		System.out.println("");
	}
	//--------------------------------------------------------------
	public int partitionIt(int left, int right)
	{
		int leftPtr = left - 1; // right of first elem
		int rightPtr = right + 1; // left of pivot
		long pivot = this.read(nElems-1);
		// System.out.print("Pivot is " + pivot);
		while(true)
		{
			while(leftPtr < right && theArray[++leftPtr] < pivot)
				; // (nop)
			while(rightPtr > left && theArray[--rightPtr] > pivot)
				; // (nop)
			if(leftPtr >= rightPtr) // if pointers cross,
				break; // partition done
			else // not crossed, so
				swap(leftPtr, rightPtr); // swap elements
		} // end while(true)
		return leftPtr; // return partition
	} // end partitionIt()
	//--------------------------------------------------------------
	public void swap(int dex1, int dex2) // swap two elements
	{
		long temp;
		temp = theArray[dex1]; // A into temp
		theArray[dex1] = theArray[dex2]; // B into A
		theArray[dex2] = temp; // temp into B
	} // end swap()
//--------------------------------------------------------------
} // end class ArrayPar
////////////////////////////////////////////////////////////////
class PartitionApp
{
	public static void main(String[] args)
	{
		System.out.println();
		int maxSize = 15; // array size
		ArrayPar arr; // reference to array
		arr = new ArrayPar(maxSize); // create the array
		for(int j=0; j<maxSize; j++) // fill array with
		{ // random numbers
			long n = (int)(java.lang.Math.random()*199);
			arr.insert(n);
		}
		arr.display(); // display unsorted array
		long pivot = arr.read(maxSize-1); // pivot value
		System.out.println("Pivot is " + pivot);
		int size = arr.size();
		// partition array
		int partDex = arr.partitionIt(0, size-1);
		System.out.println("Partition is at index " + partDex);
		arr.display(); // display partitioned array
	} // end main()
}