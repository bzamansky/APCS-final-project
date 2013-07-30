import java.io.*;
import java.util.*;

public class PortalY extends Item{

    public PortalY(Room m){
	super(m);
	name = "Yellow_Portal";
	takeable = true;
    }

   public void use(){
	if (place == null)
	    System.out.println("You cannot use the portal while it's in your inventory.");
	System.out.println("You teleport to the Blue portal.");
    }

}