import java.io.*;
import java.util.*;

public class Book extends Item{

    public Book(Room m){
	super(m);
	name = "Book";
	takeable = true;
    }

    public void use(){
	System.out.println("You pick up the book.  You read the title.  'Microbe Hunters'  You throw the book on the floor.  You pretend that you don't need to read it this summer for school.  You pick it back up and put it in your inventory.");
    }


}