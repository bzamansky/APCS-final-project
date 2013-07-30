import java.io.*;
import java.util.*;

public class Ukulele extends Item{

    public Ukulele(Room m){
	super(m);
	name = "Ukulele";
	takeable = true;
    }

    public void use(){
	System.out.println("You take out the ukulele and begin to play a song.  It's odd, but you can't be sad when you play the ukulele.  No one can.  So weird.");
    }


}