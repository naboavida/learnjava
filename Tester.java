package learnjava;

public class Tester {
	private static int numOf = 0;
	
	public static String cat(String a, String b){
		a += b;
		return a;
	}
	
	public static void main(String[] args){
		int i = 0;
		StringBuildTester sbt = new StringBuildTester(20000);
		
		
		int testCase = 3;
		
		if(testCase == 1){
			for(i=0; i<5; i++)
				System.out.println(cat("Try "+i+" of Hello world!", cat("Static number is ", Integer.toString(Tester.numOf)  ) ) );
		} else if(testCase == 2){
			sbt.runPlus();
		} else if(testCase == 3){
			sbt.runStringBuffer();
		} else if(testCase == 4){
			sbt.runPlus();
			sbt.runStringBuffer();
		}
		
	}
}
