import java.io.*;
import java.util.*;

public class Player{

    private String name;
    private Room location;
    private ArrayList<Item> inventory;
    private Room home;
    private Boolean won;
    private int hitpt;


    public Player(Room r, Room h){
	name = "Seymour Butts";
	location = r;
	inventory = new ArrayList<Item>();
	home = h;
	hitpt = 100;
	won = false;
    }

    public void move(Room r) {
	location = r;
    }

    public Boolean hasWon(){
	if (hitpt < 0){
	    System.out.println("You should have died...but you didn't.");
	    hitpt = 100;
	    return true;
	}
	return won;
    }

    public int getHitpts(){
	return hitpt;
    }
    public int hit(String s, Monster m){
	System.out.println("You hit the monster with " + s.length() + " damage.  It now has " + (m.getHitpts() - s.length()) + " hitpoints.");
	return s.length();
    }

    public int takeHit(int n){
	System.out.println("You have been hit with " + n + " damage.  You now have " + (getHitpts() - n) + " hitpoints.");
	hitpt -= n;
	return hitpt;
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

    public Room getRoom(){
	return location;
    }

    public void setRoom(Room d){
	location = d;
    }

    //taking and dropping items
    public void take(String r){
	Item m = location.getItem(r);
	if (inventory.size() > 9){
	    System.out.println("You are carrying too many items!  You need to drop something before taking anything new.\n");
	    return;
	}
	else if (m == null){
	    System.out.println("This item is not in this room!");
	    return;
	}
	else if (!(m.canTake())){
	    System.out.println("You cannot take that item!\n");
	    return;
	}
	else{
	    inventory.add(m);
	    System.out.println("You take the " + r + '\n');
	}
	m.setPlayer(this);
	location.dropItem(m);
    }

    public void drop(String r){
	int e = -1;
	for (int i = 0; i < inventory.size(); i++){
	    if (r.equals(inventory.get(i).getName()))
		e = i;
	    break;
	}
	if (e == -1){
	    System.out.println("You don't have the " + r + " , so you cannot drop it!\n");
	    return;
	}
	location.addItem(inventory.get(e));
	inventory.get(e).setRoom(location);
	inventory.remove(e);
	System.out.println("You drop the " + r + '\n');
    }

    public void removeItem(String r){
	int e = -1;
	for (int i = 0; i < inventory.size(); i++){
	    if(r.equals(inventory.get(i).getName()))
		e = i;
	    break;
	}
	if(e == -1)
	    return;
	inventory.remove(e);
    }
    
    //printing inventory
    public String getInventoryP(){
	String s = "";
	for (int i = 0; i < inventory.size(); i++) {
	    if (inventory.get(i) != null) 
		s += inventory.get(i).getName() + '\n';
	}
	return s;
    }

    //Going in different directions
    public void goNorth(){
	if (location.getNorth() != null){
	    location = location.getNorth();
	    System.out.println("You went North\n");
	}
	else
	    System.out.println("There is no room North!  You could walk into the wall repeatedly but I don't think it will help.  Try going in a different direction.\n");
    }

    public void goEast(){
	if (location.getEast() != null){
	    location = location.getEast();
	    System.out.println("You went East\n");
	}
	else
	    System.out.println("You go East...only to walk into a wall.  You then realize the door to the East was only painted on the wall.  How stupid.\n");
    }

    public void goSouth(){
	if (location.getSouth() != null){
	    location = location.getSouth();
	    System.out.println("You went South\n");
	}
	else
	    System.out.println("You try to go South but realize that the door leads to nowhere.  Just air.  You could walk out of it, but it looks like it leads to a bottomless pit.  Let's not go there.\n");
    }

    public void goWest(){
	if (location.getWest() != null){
	    location = location.getWest();
	    System.out.println("You went West\n");
	}
	else
	    System.out.println("You go West.  No, you actually don't, because there isn't a door leading West.  You take a chainsaw and attack the wall facing West, but that doesn't help because the builders of this crazy place foresaw this and made the wall out of something that can't be cut by chainsaws.  How silly of them.\n");
    }

    public void use(String s){
	Item p = null;
	for (int i = 0; i < inventory.size(); i++){
	    if (s.equals(inventory.get(i).getName()))
		p = inventory.get(i);
	}
	if (p == null)
	    System.out.println("You don't have this item so you cannot use it!");
	else{
	    System.out.println("You use the " + p.getName());
	    p.use();
	}
    }

    public void look(){
	System.out.println("You look around the " + location.getName());
	System.out.println(location.getDescription());
    }

    public void eat(String s){
	Item p = null;
	for (int i = 0; i < inventory.size(); i++){
	    if (s.equals(inventory.get(i).getName()))
		p = inventory.get(i);
	}
	if (p == null)
	    System.out.println("You don't have this item so you cannot eat it!");
	else{
	    p.eat();
	    inventory.remove(p);	    
	}
    }



    public void goHome(){
	location = home;
    }
    public String toString(){
	String s = "";
	s += "\nName: " + name;
	s += "\nLocation: " + location;
	s += "\nPlayer Inventory: " + getInventoryP() + '\n';
	s += "What would you like to do?\n";
	return s;
    }
}