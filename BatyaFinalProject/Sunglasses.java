import java.io.*;
import java.util.*;

public class Sunglasses extends Item{

    public Sunglasses(Room m){
	super(m);
	name = "Sunglasses";
	takeable = true;
    }

    public void use(){
	System.out.println("You put on the sunglasses.  Now you look all gangster.  Actually not really.  But they are cool looking.");
    }


}