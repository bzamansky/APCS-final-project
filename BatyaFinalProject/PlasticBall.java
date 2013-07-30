import java.io.*;
import java.util.*;

public class PlasticBall extends Item{

    public PlasticBall(Room m){
	super(m);
	name = "Plastic_Ball_Pit_Ball";
	takeable = true;
    }

    public void use(){
	System.out.println("You pick up the ball.  It's purple.  You don't know why you took it from the ball pit in the first place.");
    }


}