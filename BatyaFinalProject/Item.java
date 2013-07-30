import java.io.*;
import java.util.*;

public class Item{

    protected String name;
    protected Room place;
    protected Player holder;
    protected boolean takeable;

    public Item(){
	name = "";
	place = null;
	holder = null;
	takeable = false;
    }
    public Item(Room m){
	name = "";
	place = m;
	holder = null;
	takeable = false;
    }
    public Item(String n, Boolean take){
	name = n;
	place = null;
	holder = null;
	takeable = take;
    }
    public Boolean canTake(){
	return takeable;
    }
    public void setRoom(Room p){
	place = p;
	holder = null;
    }
    public void setPlayer(Player p){
	holder = p;
	place = null;
    }
    public void setName(String n){
	name = n;
    }
    public String getName(){
	return name;
    }
    public Room getRoom(){
	return place;
    }
    public void use(){

    }

    public void eat(){
	System.out.println("You cannot eat this item!");
    }


}