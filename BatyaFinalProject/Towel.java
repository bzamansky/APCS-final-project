import java.io.*;
import java.util.*;

public class Towel extends Item{

    public Towel(Room m){
	super(m);
	name = "Towel";
	takeable = true;
    }

    public void use(){
	System.out.println("You cover your head with the towel.  If you can't see them then they can't see you.  Right?");
    }


}