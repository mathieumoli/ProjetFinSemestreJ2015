package zuul.course;

/**
 * @author Mathieu Molinengo
 * @version 2014.11.30
 * 
 *         Class to create a LectureItem
 */
public class LectureItem extends Item {
	
	/***
	 * 
	 * Default constructor to create a LectureItem 
	 * 
	 ***/
	public LectureItem(){
		super();
	}
	
	/***
	 * 
	 * Constructor to create an LectureItem
	 * @param module the name of the module 
	 * @param number the number of the module
	 ***/
	public LectureItem(String module, int number) {
		super(module, number);
		bundleKey="";
	}
	
	/***
	 * 
	 * Constructor to create an LectureItem 
	 * @param module the name of the module
	 * @param number the number of the module
	 * @param key the bundle key of the module
	 ***/
	public LectureItem(String module, int number, String key) {
		super(module, number,key);
	}

	/***
	 * 
	 *  Indicates whether some other object is "equal to" this one.
	 *  @param object the reference object with which to compare. 
	 *  @return true if this LectureItem is the same as the object argument; false otherwise.
	 * 
	 ***/
	@Override
	public boolean equals(Object object){
		boolean equality = false;
		if(object instanceof LectureItem)
		{
			if(this.module.equals(((LectureItem) object).getModule()))
			{
				if(this.number==((LectureItem) object).getNumber())
				{
					equality=true;
				}
			}
		}
		return equality;
	}
	
	/**
	 * The toString method for class LectureItem returns a string consisting of the module and the number of the LectureItem
	 * @return a string representation of the LectureItem. 
	 */
	@Override
	public String toString() {
		return module + number;
	}
	
}
