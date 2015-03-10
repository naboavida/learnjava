package learnjava.names;

public class FullNameComparable extends FullName implements Comparable<FullNameComparable> {
	

	public FullNameComparable(String first, String last){
		super(first, last);
	}

	public String getFirst(){
		return super.getFirst();
	}

	public String getLast(){
		return super.getLast();
	}

	public String getFullName(){
		return super.getFullName();
	}

	public FullName copy(){
		FullName ret = super.copy();
		return ret;
	}


	public int compareTo(FullNameComparable other) {
		int comp = this.getFirst().compareToIgnoreCase(other.getFirst());
		if(comp == 0){
			return this.getLast().compareToIgnoreCase(other.getLast());
		} else {
			return comp;			
		}
	}
	
}
