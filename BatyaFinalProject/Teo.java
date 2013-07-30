import java.io.*;
import java.util.*;

public class Teo extends Monster{

    public Teo(Room m){
	super(m);
	name = "Teo";
	hitpt = 75;
    }

    public int getHitpts(){
	return hitpt;
    }

  public int takeHit(String s){
	hitpt = hitpt - s.length();
	if (getHitpts() <= 0){
	     System.out.println("You have gotten past the Teo and have successfully saved your uncle!  Hooray!\n\nYou and your uncle leave the roof.  The end!");
	     System.exit(0);
		}
	    
	return s.length();
    }


}