import java.io.*;
import java.util.*;

public class TV extends Item{

    public TV(Room m){
	super(m);
	name = "TV";
	takeable = false;
    }


}