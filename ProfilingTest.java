package learnjava;

import learnjava.algorithms.sort.Data;

public class ProfilingTest {
	public static void main(String[] args){
		final long start0 = System.currentTimeMillis();
		
		int dataLen = 10000,
			repeats = 4,
			i;
		Data d = new Data(dataLen);
		int[] data = d.getValues();

		System.out.println("Time to prep data: "+(System.currentTimeMillis() - start0)+" ms.");
		
		
		
		int accumMs = 0;
		int accumCount = 0;
		for(i=0; i<repeats; i++){
			final long start1 = System.currentTimeMillis();
			data = d.insertionSort();
			accumMs += (System.currentTimeMillis() - start1);
			accumCount++;
		}
		System.out.println("Average time to run insertion sort on "+repeats+" repeats is "+(accumMs/accumCount)+" ms.");
		
		
		
		accumMs = 0;
		accumCount = 0;
		for(i=0; i<repeats; i++){
			final long start2 = System.currentTimeMillis();
			data = d.bubbleSort();
			accumMs += (System.currentTimeMillis() - start2);
			accumCount++;
		}
		System.out.println("Average time to run bubble sort on "+repeats+" repeats is "+(accumMs/accumCount)+" ms.");
		
//		for(i=0; i<data.length; i++){
//			System.out.println(data[i]);
//		}
	}
}
