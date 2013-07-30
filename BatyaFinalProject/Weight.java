import java.io.*;
import java.util.*;

public class Weight extends Item{

    public Weight(Room m){
	super(m);
	name = "10lb_Weight";
	takeable = true;
    }

    public void use(){
	System.out.println("You pick up the weight.  Not a big deal.");
    }


}