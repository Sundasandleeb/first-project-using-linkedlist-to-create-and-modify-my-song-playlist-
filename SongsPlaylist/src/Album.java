import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
	private String name;
	private String artist;
	private ArrayList <Song> songs;
	public Album(String name, String artist) {
		super();
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList <Song>();
		
		
	}
	public String getName() {
		return name;
	}
	public String getArtist() {
		return artist;
	}
	public ArrayList<Song> getSongs() {
		return songs;
	}
	public boolean addSong(String title, double duration) {
	if(findSong(title) != null) {
		System.out.println("Song already in album");
		return false;
		
	}
	Song newSong = new Song(title, duration);       //new object, new instance of song class
	songs.add(newSong);
	
	return true;
	}
	private Song findSong(String title) {
		for(int i=0; i<songs.size() ; i++) {
			Song match = this.songs.get(i);
			if(match.getTitle().equals(title)) {
				return match;
			}
		}
		return null;
	}
		public boolean addToPlayList(String title, LinkedList<Song> thePlaylist) {
			Song song = findSong(title);
				if(song == null) {
					System.out.println("Song not in album");
					return false;
				}
				thePlaylist.add(song);
				return true;
			}
		
	   public boolean addToPlayList(int trackNo, LinkedList<Song> thePlaylist) {
		   int index = trackNo -1;     //because songs track no starts from 1, and linkedlist starts from 0
		   if((index >= 0) && (index <= this.songs.size())) {      //making sure if there is actually a song in this entry track no
			                                    //if there is a song at that index position of arraylist then add it 
			   
		   
		
		thePlaylist.add(this.songs.get(index));
		return true;
		   }
		   System.out.println("this album does not have a track "+trackNo);
		return false;
		
		
		
		
		
		
		
		
		
	}
	   }

