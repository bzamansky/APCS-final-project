import java.io.*;
import java.util.*;

public class Matches extends Item{

    public Matches(Room m){
	super(m);
	name = "Matches";
	takeable = true;
    }

    public void use(){
	if (holder.getRoom().hasItem("Torch"))
	    System.out.println("You take a match and use it to light the torch.  The room is now more illuminated, but the torch quickly goes out.  Obviously someone doused water over the torch recently.  It figures.");
	else
	    System.out.println("You take a match and light it.  It is bright.  Until the fire licks down the wood and gets really close to your fingers.  And then touches your fingers.  You drop the match and step on it, sticking your burnt fingers in your mouth.  How stupid of you.");
    }


}