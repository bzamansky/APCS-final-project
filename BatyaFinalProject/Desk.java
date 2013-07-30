import java.io.*;
import java.util.*;

public class Desk extends Item{

    public Desk(Room m){
	super(m);
	name = "Desk";
	takeable = false;
    }

}