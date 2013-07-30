import java.io.*;
import java.util.*;

public class Dictionary extends Item{

    public Dictionary(Room m){
	super(m);
	name = "Dictionary";
	takeable = true;
    }

    public void use(){
	System.out.println("You flip open the dictionary to a random word.  Cunctation: delay, tardiness.  What an interesting word.");
    }


}