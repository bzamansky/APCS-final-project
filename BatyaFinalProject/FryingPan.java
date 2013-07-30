import java.io.*;
import java.util.*;

public class FryingPan extends Item{

    public FryingPan(Room m){
	super(m);
	name = "Frying_Pan";
	takeable = true;
    }

    public void use(){
	//if there is someone in the room you hit them on the head with a frying pan. if you are in the kitchen you cook eggs and eat them and then take the frying pan back.
	if (holder.getRoom().getName().equals("Kitchen"))
	    System.out.println("You take some eggs out of the refrigerator and oil the frying pan and place it on the stove.  You then procede to fry the eggs and then eat them.  Yum!  Then you clean the frying pan and put it back in your inventory.");
	else
	    System.out.println("You look around.  There isn't really anything to do with this frying pan right now.");
    
    }


}