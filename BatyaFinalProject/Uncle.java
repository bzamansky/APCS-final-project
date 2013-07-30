import java.io.*;
import java.util.*;

public class Uncle extends Item{

    public Uncle(Room m){
	super(m);
	name = "Uncle_Hugh";
	takeable = false;
    }

    public void use(){
	System.out.println("Your Uncle is sitting in the corner of the room in a chair with his wrists tied behind his back.  You are about to rescue him but suddenly, a Teo steps out from behind something and threatens to eat you.  What will you do?");
    }


}