import java.io.*;
import java.util.*;

public class LoafOfBread extends Item{

    public LoafOfBread(Room m){
	super(m);
	name = "Loaf_of_Bread";
	takeable = true;
    }

    public void use(){
	//if you are in a room with a person you hit the person
	System.out.println("You look at the loaf of bread.  You can't decide whether to eat it or hit something with it.  So you put it back in your inventory.");
    }

    public void eat(){
	System.out.println("You eat the loaf of bread.  A bit plain, but you couldn't find any butter.");
	holder.removeItem(name);
	holder = null;
    }


}