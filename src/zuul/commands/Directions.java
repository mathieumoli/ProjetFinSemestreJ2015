package zuul.commands;

/**
 * A enum with all possibilities of directions, when the user 
 * types "go ".
 * 
 * @author user
 *
 */
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
