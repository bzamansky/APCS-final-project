import java.io.*;
import java.util.*;

public class FountainPen extends Item{

    public FountainPen(Room m){
	super(m);
	name = "Fountain_Pen";
	takeable = true;
    }

    public void use(){
	System.out.println("You pick up the fountain pen.  On a nearby piece of paper you attempt to write your name but instead get your hands covered in ink.  Typical.");
    }


}