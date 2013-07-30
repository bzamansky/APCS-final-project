import java.io.*;
import java.util.*;

public class FakeMoustache extends Item{

    public FakeMoustache(Room m){
	super(m);
	name = "Fake_Moustache";
	takeable = true;
    }

    public void use(){
	System.out.println("You put on the fake Moustache.  It is the perfect disguise.  No one will recognize you now.");
    }


}