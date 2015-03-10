package learnjava;

import learnjava.algorithms.sort.SortableData;

public class ProfilingTest {
	
	private static int[] launchTest(String testType, SortableData data, int repeats){
		int accumMs = 0;
		int accumCount = 0;
		int[] retData = new int[(data.getValues()).length];
		
		for(int i=0; i<repeats; i++){
			final long startTime = System.currentTimeMillis();
			switch(testType){
				case "insertion_sort":					
					retData = data.insertionSort();					
					break;
				case "bubble_sort":
					retData = data.bubbleSort();
					break;
				case "bubble_sort_original":
					retData = data.bubbleSortOriginal();
					break;
				default:
					break;
			}
			accumMs += (System.currentTimeMillis() - startTime);
			accumCount++;
		}
		System.out.println("Average time to run "+testType+" on "+repeats+" repeats is "+(accumMs/accumCount)+" ms.");
		return retData;
	}
	
	
	
	public static void main(String[] args){
		final long start0 = System.currentTimeMillis();
		
		// Prepare the test
		int dataLen = 5000,
			repeats = 10,
			i;
		SortableData d = new SortableData(dataLen, "inverted");
		int[] data = d.getValues();

		System.out.println("Time to prep data: "+(System.currentTimeMillis() - start0)+" ms.");
		
		
		
		data = launchTest("insertion_sort", d, repeats);
		
		data = launchTest("bubble_sort", d, repeats);
		
		data = launchTest("bubble_sort_original", d, repeats);
		
		
	}
}
