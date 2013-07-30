import java.io.*;
import java.util.*;

public class ToyTrain extends Item{

    public ToyTrain(Room m){
	super(m);
	name = "Toy_Train";
	takeable = true;
    }

    public void use(){
	System.out.println("You pick up the toy train.  You think that this would be very good for tripping someone if you placed it stealthily in their path.");
    }


}