import java.io.*;
import java.util.*;

public class Teleporter extends Item{

    public Teleporter(Room m){
	super(m);
	name = "Teleporter";
	takeable = true;
    }

    public void use(){
	System.out.println("You use the teleporter.  You don't really know how to use it so you just press the green button in the middle.  And you get teleported back to your bedroom.");
	holder.goHome();
    }


}