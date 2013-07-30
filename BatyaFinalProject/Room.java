import java.io.*;
import java.util.*;

public class Room{

    //North = 0, East = 1, South = 2, West = 3

    private String name;
    private String description;
    private ArrayList<Item> inventory;
    private Room[] neighbor;

    public static int NORTH = 0;
    public static int EAST = 1;
    public static int SOUTH = 2;
    public static int WEST = 3;

    public Room(String n){
	name = n;
	description = "";
	inventory = new ArrayList<Item>();
	neighbor = new Room[4];
    }
    public void setDescription(String s){
	description = s;
    }
    public void addItem(Item n){
	inventory.add(n);
	n.setRoom(this);
    }
    public Item getItem(String s){
	Item r = null;
	for (int i = 0; i < inventory.size(); i++){
	    if (inventory.get(i).getName().equals(s)){
		r = inventory.get(i);
		break;
	    }
	}
	return r;
    }
    public Boolean hasItem(String s){
	Item r =  null;
	for (int i = 0; i < inventory.size(); i++){
	    if (inventory.get(i).getName().equals(s)){
		r = inventory.get(i);
		break;
	    }
	}
	return (r != null);
    }
    public void dropItem(Item r){
	for (int i = 0; i < inventory.size(); i++){
	    if(r.equals(inventory.get(i)))
		inventory.remove(i);
	}
    }
    public String getName(){
	return name;
    }
    public String getDescription(){
	return description;
    }
    public void setNeighbors(Room n, Room e, Room s, Room w){
	neighbor[NORTH] = n;
	neighbor[EAST] = e;
	neighbor[SOUTH] = s;
	neighbor[WEST] = w;
    }
    public void setNorth(Room n){
	neighbor[NORTH] = n;
    }
    public void setEast(Room n){
	neighbor[EAST] = n;
    }
    public void setSouth(Room n){
	neighbor[SOUTH] = n;
    }
    public void setWest(Room n){
	neighbor[WEST] = n;
    }
    public Room getNorth(){
	return neighbor[NORTH];
    }
    public Room getEast(){
	return neighbor[EAST];
    }
    public Room getSouth(){
	return neighbor[SOUTH];
    }
    public Room getWest(){
	return neighbor[WEST];
    }
    public String getRooms(){
	String s = "";
	for (int i = 0; i < neighbor.length; i++) {
	    if (neighbor[i] != null) {
		if (i == 0)
		    s += "NORTH : "+ neighbor[i].getName() + '\n';
		else if (i == 1)
		    s+= "EAST : " + neighbor[i].getName() + '\n';
		else if (i ==2)
		    s += "SOUTH : " + neighbor[i].getName() + '\n';
		else if (i == 3)
		    s += "WEST : " + neighbor[i].getName() + '\n';
	    }
	}
	return s;
    }
    public String getInventory(){
	String s = "";
	for (int i = 0; i < inventory.size(); i++) {
	    if (inventory.get(i) != null) 
		s += inventory.get(i).getName() + '\n';
	}
	return s;
    }
    public String toString(){
	String s = "";
	s += "Name: " + name;
	s += "\nDescription: " + description;
	s += "\nRooms: " + getRooms();
	s += "\nRoom Inventory: " + getInventory() + '\n';
	return s;
    }


}