package learnjava.algorithms.sort;

import java.util.Random;

public class Data {
	private int[] values ;
	private int length;

	public Data(int len){
		System.out.println("l: "+len);
		this.length = len;
		this.values = new int[len];
		Random rand = new Random();
		
		System.out.println("l: "+this.values.length);
		
		for(int i=0; i<this.length; i++){
			this.values[i] = rand.nextInt((length)+1);
		}
	}
	
	public int[] getValues(){
		return this.values;
	}

	public int[] insertionSort() {
		boolean sorted;
		int i, swapcount = 0;
		int[] sortedValues = new int[this.length];
		System.arraycopy(this.values, 0, sortedValues, 0, this.values.length);
		do{
			sorted = true;
			
			for(i=0; i<sortedValues.length-1; i++){
				if(sortedValues[i] > sortedValues[i+1]){
					sorted = false;
					int aux = sortedValues[i];
					sortedValues[i] = sortedValues[i+1];
					sortedValues[i+1] = aux;
					swapcount++;
				}
			}
			if(swapcount % (this.length/10) == 0)
				System.out.print('.');
		} while(!sorted);
//		System.out.println("Swap counts for insertion sort: "+swapcount);
		System.out.println('X');
		return sortedValues;
	}

	public int[] bubbleSort() {
		int[] sortedValues = new int[this.length];
		int swapcount = 0;
		
		System.arraycopy(this.values, 0, sortedValues, 0, this.values.length);
		
		for(int i=0; i<sortedValues.length-1; i++){
			for(int j=0; j<sortedValues.length-i-1; j++){
				if(sortedValues[j] > sortedValues[j+1]){
					int aux = sortedValues[j];
					sortedValues[j] = sortedValues[j+1];
					sortedValues[j+1] = aux;
					swapcount++;
				}
			}
			if(swapcount % (this.length/10) == 0)
				System.out.print('.');
		}
//		System.out.println("Swap counts for bubble sort: "+swapcount);
		System.out.println('X');
		return sortedValues;
	}
	
	
}
