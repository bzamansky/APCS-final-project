import java.io.*;
import java.util.*;

public class TeddyBear extends Item{

    public TeddyBear(Room m){
	super(m);
	name = "Teddy_Bear";
	takeable = true;
    }

    public void use(){
	System.out.println("It's a Teddy Bear.  You have had it since you were a little boy.  Normally it sits on the edge of your bed, because of course you don't still sleep with stuffed animals, you're thirteen.  You look around to make sure no one is looking and you hug the teddy bear.  Then you quickly put it back in your inventory where no one can see it.");
    }


}