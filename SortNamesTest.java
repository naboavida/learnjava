package learnjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import learnjava.names.FullName;






public class SortNamesTest {
	public static void printAllFullNames(FullName[] fullNames){
		System.out.println("--- Full Names ---");
		for(int i=0; i<fullNames.length; i++){
			System.out.println(fullNames[i].getFullName());
		}
		System.out.println("------------------");
	}
	
	
	

	public static FullName[] sortByFirstName(FullName[] fullNames){
		FullName[] names = new FullName[fullNames.length];
		System.arraycopy(fullNames, 0, names , 0, fullNames.length);

		for(int i=0; i<names.length; i++){
			for(int j=0; j<names.length-i-1; j++){
				if( names[j].getFirst().compareTo(names[j+1].getFirst() ) > 0 ){
					FullName aux = names[j].copy();
					names[j] = names[j+1].copy();
					names[j+1] = aux.copy();
				}
			}
		}
		return names;
	}
	
	
	private static FullName[] sortByLastNameAux(FullName[] fullNames, int start, int end){
		FullName[] names = new FullName[fullNames.length];
		System.arraycopy(fullNames, 0, names , 0, fullNames.length);
		
		for(int i=start; i<end; i++){
			for(int j=start; j<end-1; j++){
				
				if( names[j].getLast().compareTo(names[j+1].getLast()) > 0 ){
					FullName aux = names[j].copy();
					names[j] = names[j+1].copy();
					names[j+1] = aux.copy();
				}
			}
		}
		return names;
	}


	public static FullName[] sortByLastName(FullName[] fullNames){
		String curr = fullNames[0].getFirst();
		int lastI = 0;
		for(int i=1; i<fullNames.length; i++){
			if( !( (fullNames[i].getFirst()).compareTo(curr) == 0 ) ){
				curr = fullNames[i].getFirst();
				if(i - lastI > 1){
					// more than one element, we need to try sort
					fullNames = sortByLastNameAux(fullNames, lastI, i);
				}
				lastI = i;
			}
		}
		return fullNames;
	}
	
	
	
	
	/*
	 * 
	 * Methods for 2nd approach
	 * 
	 */
	
	public static void printAllFullNamesList(List<FullName> list){
		Iterator<FullName> it = list.listIterator();
		while(it.hasNext()){
			System.out.println(it.next().getFullName());
		}
	}
	
	
	public static void sortFullNames(List<FullName> fullNames){
		Collections.sort(fullNames, new Comparator<FullName>(){
			public int compare(FullName n1, FullName n2){
				int res = n1.getFirst().compareToIgnoreCase(n2.getFirst());
				if(res != 0)
					return res;
				return n1.getLast().compareToIgnoreCase(n2.getLast());
			}
		});
	}
	
	

	public static void main(String[] args){
		FullName[] fullNames = new FullName[10];
	
		fullNames[0] = new FullName("John", "Lewis");
		fullNames[1] = new FullName("Ann", "Levitt");
		fullNames[2] = new FullName("Peter", "Drucker");
		fullNames[3] = new FullName("John", "Laws");
		fullNames[4] = new FullName("Jason", "Lewis");
	
		fullNames[5] = new FullName("Mark", "Zuckie");
		fullNames[6] = new FullName("Mark", "Anders");
		fullNames[7] = new FullName("Johnathan", "Davies");
		fullNames[8] = new FullName("John", "Carrot");
		fullNames[9] = new FullName("John", "Abbot");
		
		// START TEST 1
		
		FullName[] namesTest1 = new FullName[10];
		System.arraycopy(fullNames, 0, namesTest1, 0, fullNames.length);
	
		// sort full names, first sort order is the first name, then second sort order is last name.
		// sort by first name
		namesTest1 = sortByFirstName(namesTest1);
		
	
		// then another full loop to detect a first name change
		// sort all names before that by last name
		// continue
		namesTest1 = sortByLastName(namesTest1);
	
		printAllFullNames(namesTest1);
		
		// END TEST 1
		
		
		// START TEST 2
		
		List<FullName> namesList = new ArrayList<FullName>();
		namesList.add( new FullName("John", "Lewis"));
		namesList.add( new FullName("Ann", "Levitt"));
		namesList.add( new FullName("Peter", "Drucker"));
		namesList.add( new FullName("John", "Laws"));
		namesList.add( new FullName("Jason", "Lewis"));
	
		namesList.add( new FullName("Mark", "Zuckie"));
		namesList.add( new FullName("Mark", "Anders"));
		namesList.add( new FullName("Johnathan", "Davies"));
		namesList.add( new FullName("John", "Carrot"));
		namesList.add( new FullName("John", "Abbot"));
		
		sortFullNames(namesList);
		
		printAllFullNamesList(namesList);
		
		// END TEST 2
	}
	
}
