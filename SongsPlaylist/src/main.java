import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class main {
	   private static ArrayList<Album> albums = new ArrayList<Album>();
	public static void main(String[] args) {
		
		Album Firstalbum = new Album("Evil Returns 2", "atif aslam");
		Firstalbum.addSong("Shamat", 5.23);
		Firstalbum.addSong("Galiyan", 4.23);
		Firstalbum.addSong("Headlights", 3.23);
		Firstalbum.addSong("On the way", 5.11);
		Firstalbum.addSong("Faded", 1.23);
		Firstalbum.addSong("Deadline", 9.23);
		Firstalbum.addSong("Halloween", 2.23);
		
		albums.add(Firstalbum);  
		
		Album Secondalbum = new Album("Loyal" , "Ap Dhillon");
		
		Secondalbum = new Album("Loyal", "Ap dhillon");
		Secondalbum.addSong("Excuses", 3.45);
		Secondalbum.addSong("Summer high", 4.45);		
		Secondalbum.addSong("Insane", 3.21);
		Secondalbum.addSong("Brown munde", 5.45);
		Secondalbum.addSong("Night", 3.45);
		albums.add(Secondalbum);
		
		
		LinkedList<Song> playlist = new LinkedList<Song>();
		albums.get(0).addToPlayList("Long Drive", playlist);                                            //fristalbum
		albums.get(0).addToPlayList("On the way", playlist); 
		albums.get(0).addToPlayList("Halloween", playlist); 
		
		albums.get(1).addToPlayList(5, playlist);
		albums.get(1).addToPlayList(2, playlist);
		albums.get(1).addToPlayList(3, playlist);
		albums.get(1).addToPlayList(25, playlist);
		
		
		
		play(playlist);
		
	}
	private static void play(LinkedList<Song> playlist) {
		Scanner scanner =new Scanner (System.in);
		boolean quit = false;        //loop remians continue 
		boolean forward = true;     //when we start playlist we have to go forward
		ListIterator<Song> listIterator = playlist.listIterator();
		if(playlist.size()==0) {
			System.out.println("No song in playlist");
			return;
			
		}
		else {
		System.out.println("Now playing "+listIterator.next().toString());
		printMenu();
		}
		while(!quit) {
			int action = scanner.nextInt();
			scanner.nextLine();
			switch(action) {
			case 0:
				System.out.println("Playlist has ended");
				quit = true;
				break;
			case 1:    //to go forward in the playlist
				if(!forward) {
					if(listIterator.hasNext()) {
						listIterator.next();
					}
					forward = true;
				}
				if(listIterator.hasNext()) {
					
					System.out.println("Now playing "+listIterator.next().toString());
				}
				else {
					System.out.println("we have reached the end of list");
					forward=false;
				}
				break;
			case 2:        //to go backward in the playlist
				if(forward){    //if we currently going forward
					if(listIterator.hasPrevious()) {    //if there are previous entries , we need to change 
						listIterator.previous();        //direction, and go back to previous
					}
					forward = false;
				
				}
				if(listIterator.hasPrevious()) {
					System.out.println("Now playing "+listIterator.previous().toString());
					
				}
				else {
					System.out.println("we have reached at the start of the list");
					forward = true;
				}
				break;
			case 3:    //to replay current song; (if we were going forward, we are just after the current song,we have to replay that song, so we need to go backward
				if(forward) {
					if(listIterator.hasPrevious()) {
						System.out.println("Now replayig "+listIterator.previous().toString());
						forward = false;  //we have to go backward to reply that song
					}
					else {
						System.out.println("we are at the start of the list");
					}
					
				}
				else {  //if we are going backward, and reply current song, we need to go forward
					if(listIterator.hasNext()) {
						System.out.println("Now replaying "+listIterator.next().toString());
						forward = true;  // we have to go forward to reply song
					}
					else {
						System.out.println("we are the end of the list");
					}
				}
				break;
			case 4:
				printList(playlist);
				break;
			case 5:
				printMenu();
				break;
			case 6:   // to remove a current song 
				if(playlist.size() >0) {
				listIterator.remove();  //current song removed
				if(listIterator.hasNext()) {   //list iterator after removing a song will give "Exception error"
				                               // so we immediately need to go forward or backward to remove this exception. and to make our program run
				System.out.println("Now playing "+listIterator.next());
				
			}
				else if(listIterator.hasPrevious()) {
					System.out.println("Now playing "+listIterator.previous());
					
				}
				}
				break;
		
	
		}
		}
	}
		private static void printMenu() {
			System.out.println("Available actions:\npress");
			System.out.println("0 - to quit \n"+
			          "1 - to play next song \n"+
					  "2 - to play previous song \n"+
			          "3 - to replay current song \n"+
					  "4 - list songs in playlist \n"+
			          "5 - to print available actions\n"+
					  "6 - to remove current song \n");
					
			
		}
		private static void printList(LinkedList<Song> playlist) {    // tp print songs list, normal iterator
		 Iterator<Song> iterator = playlist.iterator();
		 System.out.println("################");
		 while(iterator.hasNext()) {
			 System.out.println(iterator.next().toString());
		 }
		 System.out.println("####################");
		
		
	}
	

}
