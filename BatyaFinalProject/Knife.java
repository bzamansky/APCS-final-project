import java.io.*;
import java.util.*;

public class Knife extends Item{

    public Knife(Room m){
	super(m);
	name = "Knife";
	takeable = true;
    }

    public void use(){
	System.out.println("You pick up the spoon.  No, wait.  That's not a spoon, it's a knife!  I see you've played knifey-spooney before.");
    }


}