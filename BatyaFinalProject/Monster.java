import java.io.*;
import java.util.*;

public class Monster{

    protected String name;
    protected Room location;
    protected int hitpt = 50;


    public Monster(Room m){
	name = "Monster";
	location = m;
    }
    public String getName(){
	return name;
    }

    public int getHitpts(){
	return hitpt;
    }
    public Boolean isAlive(){
	return hitpt > 0;
    }

    public int takeHit(String s){
	hitpt = hitpt - s.length();
	if (getHitpts() <= 0)
	    System.out.println("The " + name + " has died.");
	return s.length();
    }

    public int hit(){
	return (int)(Math.random() * 10);
    }

}