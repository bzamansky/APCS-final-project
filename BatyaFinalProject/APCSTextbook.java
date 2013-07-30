import java.io.*;
import java.util.*;

public class APCSTextbook extends Item{

    public APCSTextbook(Room m){
	super(m);
	name = "APCS_Textbook";
	takeable = true;
    }

    public void use(){
	System.out.println("You pick up the APCS Textbook.  It would be very good for hitting people over the head if there was anyone in here.  But since there isn't anyone in here with you right now you put down the textbook and open it.  It looks like a textbook.  How unexciting.");
    }


}