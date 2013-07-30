import java.io.*;
import java.util.*;

public class SaltShaker extends Item{

    public SaltShaker(Room m){
	super(m);
	name = "Salt_Shaker";
	takeable = true;
    }

    public void use(){
	System.out.println("You pick up the salt shaker.  It has salt in it.  You shake some onto the table.  Now the table has a pile of salt on it.");
    }


}