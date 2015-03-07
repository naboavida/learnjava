package learnjava;

public class StringBuildTester {
	private int loops;
	private static double NANOSECONDS_TO_MILLISECONDS = 1000.0 * 1000.0;
	
	public StringBuildTester(int loops){
		this.loops = loops;
	}
	
	public void runPlus(){
		long start = System.nanoTime();
		String str = "A";

		for(int i=0; i<loops; i++){
			str += str;
		}
		long end = System.nanoTime();
//		long end = System.currentTimeMillis();
		System.out.println("took "+((end - start)/NANOSECONDS_TO_MILLISECONDS)+" miliseconds to run "+this.loops+" loops.");
//		System.out.println(str);
	}
	
	public void runStringBuffer(){
		long start = System.nanoTime();
		StringBuffer output = new StringBuffer(this.loops + 10);
		String str = "ABC";
		output.append(str);
		
		for(int i=0; i<this.loops; i++){
			output.append(str);
		}
		
		long end = System.nanoTime();
		System.out.println("took "+((end - start)/NANOSECONDS_TO_MILLISECONDS)+" miliseconds to run "+this.loops+" loops.");
		System.out.println(output.toString());
	}
}