import java.io.*;
import java.util.*;

public class Bed extends Item{

    public Bed(Room m){
	super(m);
	name = "Bed";
	takeable = false;
    }


}