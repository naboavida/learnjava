package learnjava.algorithms.sort;

import java.util.Random;

public class SortableData {
	private int[] values ;
	private int length;

	public SortableData(int len, String type){
		System.out.println("l: "+len);
		this.length = len;
		this.values = new int[len];
		
		
		
		switch(type){
			case "random":
				Random rand = new Random();
				System.out.println("l: "+this.values.length);
				for(int i=0; i<this.length; i++){
					this.values[i] = rand.nextInt((length)+1);
				}
				break;
			case "inverted":
				System.out.println("l: "+this.values.length);
				for(int i=0, j=this.values.length; i<this.length; i++, --j){
					this.values[i] = j;
				}
				break;
			default:
				
				break;
		}
//		
//		Random rand = new Random();
//		
//		System.out.println("l: "+this.values.length);
//		
//		for(int i=0; i<this.length; i++){
//			this.values[i] = rand.nextInt((length)+1);
//		}
	}
	

	// this method will swap the value of a into the variable b, and vice-versa
	private void swapInt(int a, int b){
		int aux = a;
		a = b;
		b = aux;
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
	
	
	
	public int[] bubbleSortOriginal(){
		int[] sortedValues = new int[this.values.length];
		
		for(int i=this.values.length; --i>=0; ){
			boolean swapped = false;
			for(int j=0; j<i; j++){
				if(this.values[j] > this.values[j+1]){
					swapInt(this.values[j], this.values[j+1]);
					swapped = true;
				}
			}
			if(!swapped)
				break;
			
			if(i % (this.length/10) == 0)
				System.out.print('.');
		}
		System.out.println('X');
		return sortedValues;
	}
	
	
}