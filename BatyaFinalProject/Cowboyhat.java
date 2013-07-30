import java.io.*;
import java.util.*;

public class Cowboyhat extends Item{

    public Cowboyhat(Room m){
	super(m);
	name = "Cowboy Hat";
	takeable = true;
    }

    public void use(){
	System.out.println("You put on the cowboy hat.  It's kind of scary that it still fits you.  You bought it when you were seven.  Actually it was a christmas present when you were seven.  It came with a Woody toy from ToyStory3.");
    }


}