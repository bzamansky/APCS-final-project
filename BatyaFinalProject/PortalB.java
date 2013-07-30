import java.io.*;
import java.util.*;

public class PortalB extends Item{

    public PortalB(Room m){
	super(m);
	name = "Blue_Portal";
	takeable = true;
    }

    public void use(){
	if (place == null)
	    System.out.println("You cannot use the portal while it's in your inventory.");
	System.out.println("You teleport to the Yellow portal.");
    }


}