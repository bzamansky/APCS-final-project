import java.io.*;
import java.util.*;

public class WoodenSpatula extends Item{

    public WoodenSpatula(Room m){
	super(m);
	name = "Wooden_Spoon";
	takeable = true;
    }

    public void use(){
	//if there is someone in the room you can hit them with it.
	System.out.println("It's a wooden spoon.  You can hit people with it.");
    }


}