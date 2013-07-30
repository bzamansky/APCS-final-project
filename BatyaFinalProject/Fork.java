import java.io.*;
import java.util.*;

public class Fork extends Item{

    public Fork(Room m){
	super(m);
	name = "Fork";
	takeable = true;
    }

    public void use(){
	System.out.println("You pick up the fork.  It looks good for poking people but you don't really have anyone to poke right now.");
    }


}