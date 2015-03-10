package learnjava.names;

public class FullName {
	String first = "";
	String last = "";

	public FullName(String first, String last){
		this.first = first;
		this.last = last;
	}

	public String getFirst(){
		return this.first;
	}

	public String getLast(){
		return this.last;
	}

	public String getFullName(){
		return (this.first + " " + this.last);
	}

	public FullName copy(){
		FullName ret = new FullName(this.first, this.last);
		return ret;
	}
} // end class
