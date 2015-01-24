package zuul.commands;

public enum Directions {
	EAST ("east"),
	WEST("west"),
	NORTH ("north"),
	SOUTH ("south"),
	UNKNOWN("unknown");
	
	private String name = ""; 
	
	Directions(String name){
		    this.name = name;
	}
		   
	public String toString(){
		    return name;
	}
}
