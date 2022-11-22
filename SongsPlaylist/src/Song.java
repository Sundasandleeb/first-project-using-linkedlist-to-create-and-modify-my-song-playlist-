
public class Song {
    private String title;
    private double duration;
	public Song(String title, double duration) {
		super();
		this.title = title;
		this.duration = duration;
	}
	public String getTitle() {
		return title;
	}
	public double getDuration() {
		return duration;
	}
	@Override
	public String toString() {     //toString is part of java infrastructure for all objects.we print out actual
		                          //contents of class, the various fields, to print out what a particular class
		                            //is actually set to. here this class song is actually set to instances/objecst
		                           //title and duration, which we got from toString override method
		return this.title+":"+this.duration;
	}
   
    	
    	
    }

