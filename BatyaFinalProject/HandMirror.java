import java.io.*;
import java.util.*;

public class HandMirror extends Item{

    public HandMirror(Room m){
	super(m);
	name = "Hand_Mirror";
	takeable = true;
    }

    public void use(){
	System.out.println("You look at yourself in the mirror.  You notice a speck of dirt on your nose and wipe it off.");
    }


}