import java.io.*;
import java.util.*;

public class CoffeeTable extends Item{

    public CoffeeTable(Room m){
	super(m);
	name = "Coffee_Table";
	takeable = false;
    }


}