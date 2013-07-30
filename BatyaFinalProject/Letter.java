import java.io.*;
import java.util.*;

public class Letter extends Item{

    public Letter(Room m){
	super(m);
	name = "Letter";
	takeable = true;
    }

    public void use(){
	System.out.println("It is a letter.  Your name is written in cursive on the outside of the envelope.  You open it and read the letter.\n\n\tDear Seymour,\n\tYou probably don't remember me but my name is Hugh Jazz and I am your uncle.  I have been taken hostage and am being held somewhere in the house.  I need your help.  Come find me please.\n\tLove, Your Uncle.\n\n You stare at the letter for a moment and the laugh at your uncle's name and then stare at it again.  You decide that it is worth your time to try to find your uncle.");
    }


}