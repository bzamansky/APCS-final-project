import java.io.*;
import java.util.*;

public class Driver{

    private InputStreamReader isr;
    private BufferedReader br;
    private Scanner sc;
    private static ArrayList<Room> rooms = new ArrayList<Room>();
    private static Player bob;
    private int counter = 1;
    private static Monster teo, mon;



    public Driver(){
	isr = new InputStreamReader(System.in);
	br = new BufferedReader(isr);
	sc = new Scanner(System.in);
    }

    public String read(){
	String d = "";
	try{
	    d = br.readLine();
	}
	catch(IOException x) { }
	return d;
    }


    public String[] read3(){
	String d = read();
	String[] what = d.split("[ \t]+");
	what[0] = what[0].toLowerCase();
	return what;
    }
	

    public static void wait (int n){
        n = n * 100;
        long t0, t1;

        t0 =  System.currentTimeMillis();

        do{
            t1 = System.currentTimeMillis();
        }
        while (t1 - t0 < n);
    }

    public String readMe(){
	String s = "";
	s += "Welcome to MansionStuck.\n\n";
	s += "This is how to play.\n\n\n";
	s += "To go between rooms, type 'go direction', with direction being North, South, East, or West.  If there is a room in that direction you will move in that direction.  If there is not you will recieve an error.\n\n";
	s += "To pick up an item in a room, type 'get item_name' or 'take item_name'.  If the item cannot be taken for whatever reason you will recieve an error message.\n\n";
	s += "To drop an item, type 'drop item_name'.  To drop or get an item you must type the name exactly as it is seen in either your or the room's inventory.  You can only carry 10 items in your inventory at once.\n\n";
	s += "To use an item, type 'use item_name'.  You must type the item name exactly as seen.  Some items will have different uses in different rooms.\n\n";
	s += "To eat an item, type 'eat item_name'.  Only food-items can be eaten.\n\n";
	s += "To attack a monster, type 'hit with item_name'.  You can only attack with items in your inventory.  If you want to run away you can type 'run'.\n\n";
	s += "To look around the room type 'look'.\n\n\n";
	s += "To ask for help if you need a reminder of the rules, type 'help'.";
	s += "And that's it!  Enjoy the game!\n\n";
	return s;
    }

    public Room portal(String s, Player p){
	Room b = null;
	if(p.hasItem(s)){
	    System.out.println("You cannot use the portal while you are holding it.");
	    return p.getRoom();
	}
	if (s.equals("Blue_Portal")){
	    for(int i = 0; i < rooms.size(); i++){
		if (rooms.get(i).hasItem("Yellow_Portal")){
		    b = rooms.get(i);
		    break;
		}
	    }
	}
	else if(s.equals("Yellow_Portal")){
	    for(int i = 0; i < rooms.size(); i++){
		if (rooms.get(i).hasItem("Blue_Portal")){
		    b = rooms.get(i);
		    break;
		}
	    }
	}
	else
	    return p.getRoom();
	return b;
	    
    }

    public void attack(Player p, Monster m){
	String[] reading = read3();
	if (reading[0].equals("run")){
	    System.out.println("You run away.");
	    p.goWest();
	    return;
	}
	while(m.getHitpts() > 0 && p.getHitpts() > 0){
	    System.out.println("You have " + p.getHitpts() + " hitpoints.  The "+ m.getName() + " has " + m.getHitpts() + " hitpoints.");
	    if (reading[0].equals("run")){
		System.out.println("You run away.");
		p.goNorth();
		return;
	    }	
	    if (m.getHitpts() <= 0){
		if (m != teo)
		    System.out.println("You have defeated the monster.");
		else{
		    System.out.println("You have gotten past the Teo and have successfully saved your uncle!  Hooray!\n\nYou and your uncle leave the house.  The end!");
		    System.exit(0);
		}
		    
		return;
	    }
	    if (p.getHitpts() <= 0){
		System.out.println("You died.");
		return;
	    }
	    else if (reading[0].equals("hit")){
		if (p.hasItem(reading[2])){
		    p.hit(reading[2], m);
		    m.takeHit(reading[2]);
		    p.takeHit(m.hit());
		}
		else{
		    System.out.println("You don't have that item so you can't attack with it!");
		    p.takeHit(m.hit());
		}
	    }
	    if (m.getHitpts() >= 0 && p.getHitpts() >= 0){
		System.out.println("What would you like to do?");
		reading = read3();
	    }
	}
    }

    public void play(Player p){
	System.out.println(readMe());
	wait(60);
	System.out.println("MansionStuck\n\n\nYou are a thirteen year old boy.  What is your name?\nEnter Name: ");
	read();
	System.out.println("What?  That's a stupid name.  Your name is Seymour Butts.\n");
	wait(25);
	System.out.println(p);

	String[] reading = read3();
	if (reading[0].equals("quit")){
	    System.out.println("End");
	    return;
	}
	while (reading[0] != "quit" && !(p.hasWon())){
	    if (reading[0].equals("quit")){
		System.out.println("Game Over");
		return;
	    }
	    else if (reading[0].equals("look"))
		System.out.println(p.getRoom().getDescription());
	    else if (reading[0].equals("go")){
		reading[1] = reading[1].toLowerCase();
		if (reading[1].equals("north"))
		    p.goNorth();
		else if (reading[1].equals("east"))
		    p.goEast();
		else if (reading[1].equals("south"))
		    p.goSouth();
		else if (reading[1].equals("west"))
		    p.goWest();
		else
		    System.out.println("Direction is not recognized.  Try again.");
	    }
	    else if (reading[0].equals("get") || reading[0].equals("take")){
		if (reading[1].equals("Uncle_Hugh")){
		    System.out.println("Teo comes at you to eat you!  What will you do?");
		    attack(p, teo);
		}
		else
		    p.take(reading[1]);
	    }
	    else if (reading[0].equals("drop"))
		p.drop(reading[1]);
	    else if (reading[0].equals("use")){
		if (reading[1].equals("Blue_Portal") || reading[1].equals("Yellow_Portal"))
		    p.setRoom(this.portal(reading[1], bob));
		else
		    p.use(reading[1]);
	    }
	    else if (reading[0].equals("eat"))
		p.eat(reading[1]);
	    else if (reading[0].equals("help"))
		System.out.println(readMe());
	    else
		System.out.println("Unknown Command");

	    if (counter % 10 == 0){
		System.out.println("A monster comes out of nowhere!  What will you do?");
		attack(p, mon);
	    }
	    wait(20);
	    counter++;
	    System.out.println(p);
	    reading = read3();
	}
    }


    public static void main(String[] args){
	Driver d = new Driver();

	Room Bedroom, Bathroom, Kitchen, DiningRoom, PlayRoom, LivingRoom, HallwayA, MirrorRoom, GameRoom, Study, Parlour, WalkInWardrobe, Sauna, TortureChamber, Theater, Basement, Attic, Pool, Roof, Bar, MusicRoom, ExerciseRoom, Dungeon, BallPitRoom, Greenhouse, Library;
	Item Bed, APCSTextbook, TeddyBear, Letter, RubberDuck, LoafOfBread, FryingPan, WoodenSpatula,Torch, HandMirror, Mirror, SaltShaker, Chair, Table, Fork, Knife, ToyTrain, BoxOfLegos, BoxOfStuffedAnimals, TV, Couch, CoffeeTable, Book, Matches, Desk, FountainPen, Dictionary, FancyChair, FancyTable, FancyLamp, Cowboyhat, Sunglasses, FakeMoustache, RustyScalpel, BloodStainedScalpel, CleanScalpel, ChineseWaterTorture, BoxOfPhotoAlbums, DustyTV, Towel, InflatableTube, PottedPlant, Hose, BottleOfWine, BottleOfCider, Ukulele, Guitar, Piano, Weight10, Weight15, Weight40, RustyChains, PlasticBall, PottedParsley, PottedSage, FancyBook, Teleporter, PortalB, PortalY, Uncle;


	Bedroom = new Room("Bedroom");
	Bathroom = new Room("Bathroom");
	Kitchen = new Room("Kitchen");
	DiningRoom = new Room("Dining_Room");
	PlayRoom = new Room("Play_Room");
	LivingRoom = new Room("Living_Room");
	HallwayA = new Room("HallwayA");
	MirrorRoom = new Room("Mirror_Room");
	GameRoom = new Room("Game_Room");
	/**/
	Study = new Room("Study");
	Parlour = new Room("Parlour");
	WalkInWardrobe = new Room("Walk_In_Wardrobe");
	Sauna = new Room("Sauna");
	TortureChamber = new Room("Torture_Chamber");
	Theater = new Room("Theater");
	Basement = new Room("Basement");
	Attic = new Room("Attic");
	Pool = new Room("Pool");
	Roof = new Room("Roof");
	Bar = new Room("Bar");
	MusicRoom = new Room("Music_Room");
	ExerciseRoom = new Room("Exercise_Room");
	Dungeon = new Room("Dungeon");
	BallPitRoom = new Room("Ball_Pit_Room");
	Greenhouse = new Room("Greenhouse");
	Library = new Room("Library");


	rooms.add(Bedroom);
	rooms.add(Bathroom);
	rooms.add(Kitchen);
	rooms.add(DiningRoom);
	rooms.add(PlayRoom);
	rooms.add(LivingRoom);
	rooms.add(HallwayA);
	rooms.add(MirrorRoom);
	rooms.add(GameRoom);
	rooms.add(Study);
	rooms.add(Parlour);
	rooms.add(WalkInWardrobe);
	rooms.add(Sauna);
	rooms.add(TortureChamber);
	rooms.add(Theater);
	rooms.add(Basement);
	rooms.add(Attic);
	rooms.add(Pool);
	rooms.add(Roof);
	rooms.add(Bar);
	rooms.add(MusicRoom);
	rooms.add(ExerciseRoom);
	rooms.add(Dungeon);
	rooms.add(BallPitRoom);
	rooms.add(Greenhouse);
	rooms.add(Library);

	Bedroom.setNeighbors(Bathroom, Kitchen, PlayRoom, HallwayA);
	Bathroom.setNeighbors(WalkInWardrobe, MirrorRoom, Bedroom, GameRoom);
	Kitchen.setNeighbors(MirrorRoom, Basement, DiningRoom, Bedroom);
	DiningRoom.setNeighbors(Kitchen, Attic, Bar, PlayRoom);
	PlayRoom.setNeighbors(Bedroom, DiningRoom, MusicRoom, LivingRoom);
	LivingRoom.setNeighbors(HallwayA, PlayRoom, ExerciseRoom, Dungeon);
	HallwayA.setNeighbors(GameRoom, Bedroom, LivingRoom, Greenhouse);
	MirrorRoom.setNeighbors(Sauna, Theater, Kitchen, Bathroom);
	GameRoom.setNeighbors(Parlour, Bathroom, HallwayA, Library);
	/**/
	Study.setNeighbors(null, Parlour, Library, null);
	Parlour.setNeighbors(null, WalkInWardrobe, GameRoom, Study);
	WalkInWardrobe.setNeighbors(null, Sauna, Bathroom, Parlour);
	Sauna.setNeighbors(null, TortureChamber, MirrorRoom, WalkInWardrobe);
	TortureChamber.setNeighbors(null, null, Theater, Sauna);
	Theater.setNeighbors(TortureChamber, null, Basement, MirrorRoom);
	Basement.setNeighbors(Theater, null, Attic, Kitchen);
	Attic.setNeighbors(Basement, null, Pool, DiningRoom);
	Pool.setNeighbors(Attic, Roof, null, Bar);
	Roof.setNeighbors(null, null, null, Pool);
	Bar.setNeighbors(DiningRoom, Pool, null, MusicRoom);
	MusicRoom.setNeighbors(PlayRoom, Bar, null, ExerciseRoom);
	ExerciseRoom.setNeighbors(LivingRoom, MusicRoom, null, Dungeon);
	Dungeon.setNeighbors(BallPitRoom, ExerciseRoom, null, null);
	BallPitRoom.setNeighbors(Greenhouse, LivingRoom, Dungeon, null);
	Greenhouse.setNeighbors(Library, HallwayA, BallPitRoom, null);
	Library.setNeighbors(Study, GameRoom, Greenhouse, null);

	Bedroom.setDescription("You are in your bedroom.  It is a nice room with blue wallpaper and windows that don't actually open to anywhere.  In the bedroom is a bed which has a Teddy Bear sitting on it.  The Teddy Bear is old and well used, but you're a teenager now and don't sleep with stuffed animals, of course.  There is also a desk in the room, and on the floor next to your desk is a AP Computer Science textbook.  You have actually never opened it, but that's okay, you get to return it soon.  On top of your desk is a letter in an envelope.");
	Bathroom.setDescription("You are in the bathroom.  You realize for the first time that there are four doors leading from the bathroom.  What kind of moron has four doors leading to the bathroom?");
	Kitchen.setDescription("You are in the kitchen.  Which is good because it means you can have something to eat. But there isn't anyone in here!  More ribs for me!  There is a refrigerator in here, and a stove.  On the stove there is a frying pan, and besides the stove a wooden spoon lies on the counter.  A loaf of bread is sitting on the opposite counter.");
	HallwayA.setDescription("You are in HallwayA.  It is a dark and dreary place with a torch.");
	MirrorRoom.setDescription("You are in the mirror room.  There are mirrors on the walls.  Well, what did you expect?  There is also a hand mirror on the floor.");
	DiningRoom.setDescription("You are in the dining room.  There is a big table in the center of the room and it is surrounded by chairs.  The table is set for dinner.");
	PlayRoom.setDescription("This is the playroom, where you spent many days when you were younger.  There is a toy train lying on the floor besides a box of legos and a box of stuffed animals, all forgotten.");
	LivingRoom.setDescription("You are in the living room.  Nothing special.  There is a couch with a coffee table in front of it, with a book resting on the coffee table.  Across the room from the couch is the TV.");
	GameRoom.setDescription("You are in the game room.  There are video arcade games in here, as well as a Wii.  You spend a lot more time in here than you spend in the PlayRoom nowadays.");
	Study.setDescription("You are in the Study.  It's actually your uncle's study.  Despite the fact that you don't see your uncle much he does live here.  You really don't see many people, the house is rather large.  But that is besides the point.  There is a desk in the corner and book shelves on the walls.");
	Parlour.setDescription("You are in the parlour.  That's a funny word, parlour.  The room has lots of stuffed chairs and fancy furniture.");
	WalkInWardrobe.setDescription("You are in your walk-in-wardrobe.  There is a lot of clothing in here.");
	Sauna.setDescription("You are in the sauna.  It is very foggy and you can't see anything.");
	TortureChamber.setDescription("You are in the Torture Chamber.  From the nature of your uncle's letter which you may or may not have read, you half expected him to be trapped in here, but all you see are rusty torture implements.");
	Theater.setDescription("You are in the theater.  The room is dark and there are plush seats leading down to a large screen.  There isn't anything showing right now.");
	Attic.setDescription("You are in the attic.  Because it totally makes sense to have the attic next to the basement.");
	Pool.setDescription("You are at the pool.  Which is next door to the bar for some reason.  It goes from 3ft to 8ft with a diving board at the end.  A floaty device lays on the side of the pool.");
	Roof.setDescription("You walk up a flight of stairs and come out on the roof.  The ground is graveled and a couple of plants are on the sides.");
	Bar.setDescription("You are in the bar.  You're not quite sure why your parents have a bar here.  It's within walking distance of your bedroom.");
	MusicRoom.setDescription("You are in the Music Room.  A grand piano sits in the middle of the room.  A few other instruments sit on stands.  Once again, a badly placed room, right next to the bar.  At least you can lock that door.");
	ExerciseRoom.setDescription("You are in the exercise room.  There are dumbells and exercise machines in here.  Your dad says you are old enough to start doing weights but you really don't come in here much except to use the exercise ball.  But really that's just for playing with the exercise ball.");
	Dungeon.setDescription("You are in the dungeon.  Chains hang from the walls and the floor is damp and moldy.  You must remember to talk to your parents about getting it cleaned.");
	BallPitRoom.setDescription("You are in the ball pit room.  You begged for one of these just like those in the fast food restaurants when you were younger.  Not it seems sort of stupid.  Not stupid enough to keep yourself from swimming through the ball pit, of course.");
	Greenhouse.setDescription("You are in the greenhouse.  Your mom likes growing plants in here.  Parsley, Sage, Rosemary and Thyme grow in a row on one wall.  For some reason it was important that the last plant in the row be Thyme rather than strawberries.");
	Library.setDescription("You are in the library.  It has a lot of books, but they're really for your parents.  There aren't any comic books in here, so it's useless in your mind.");
				 


	Bed = new Bed(Bedroom);
	APCSTextbook = new APCSTextbook(Bedroom);
	TeddyBear = new TeddyBear(Bedroom);
	Letter = new Letter(Bedroom);
	RubberDuck = new RubberDuck(Bathroom);
	LoafOfBread = new LoafOfBread(Kitchen);
        FryingPan = new FryingPan(Kitchen);
	WoodenSpatula = new WoodenSpatula(Kitchen);
	Torch = new Torch(HallwayA);
	HandMirror = new HandMirror(MirrorRoom);
	Mirror = new Mirror(MirrorRoom);
	SaltShaker = new SaltShaker(DiningRoom);
	Chair = new Chair(DiningRoom);
	Table = new Table(DiningRoom);
	Fork = new Fork(DiningRoom);
	Knife = new Knife(DiningRoom);
	ToyTrain = new ToyTrain(PlayRoom);
	BoxOfLegos = new BoxOfLegos(PlayRoom);
	BoxOfStuffedAnimals = new BoxOfStuffedAnimals(PlayRoom);
	TV = new TV(LivingRoom);
	Couch = new Couch(LivingRoom);
	CoffeeTable = new CoffeeTable(LivingRoom);
	Book = new Book(LivingRoom);
	Matches = new Matches(Kitchen);
	Desk = new Desk(Study);
	FountainPen = new FountainPen(Study);
	Dictionary = new Dictionary(Study);
	FancyChair = new FancyChair(Parlour);
	FancyTable = new FancyTable(Parlour);
	FancyLamp = new FancyLamp(Parlour);
	FakeMoustache = new FakeMoustache(WalkInWardrobe);
	Cowboyhat = new Cowboyhat(WalkInWardrobe);
	Sunglasses = new Sunglasses(WalkInWardrobe);
	RustyScalpel = new Scalpel(TortureChamber);
	RustyScalpel.setName("Rusty_Scalpel");
	BloodStainedScalpel = new Scalpel(TortureChamber);
	BloodStainedScalpel.setName("Blood_Stained_Scalpel");
	CleanScalpel = new Scalpel(TortureChamber);
	CleanScalpel.setName("Clean_Scalpel");
	ChineseWaterTorture = new ChineseWaterTortureDevice(TortureChamber);
	BoxOfPhotoAlbums = new BoxOfPhotoAlbums(Attic);
	DustyTV = new DustyTV(Attic);
	Towel = new Towel(Pool);
	InflatableTube = new InflatableTube(Pool);
	PottedPlant = new PottedPlant(Roof);
	Hose = new Hose(Roof);
	BottleOfWine = new Bottle(Bar);
	BottleOfCider = new Bottle(Bar);
	BottleOfCider.setName("Bottle_Of_Cider");
	Ukulele = new Ukulele(MusicRoom);
	Guitar = new Guitar(MusicRoom);
	Piano = new Piano(MusicRoom);
	Weight10 = new Weight(ExerciseRoom);
	Weight15 = new Weight(ExerciseRoom);
	Weight15.setName("15lb_Weight");
	Weight40 = new Weight40(ExerciseRoom);
	RustyChains = new RustyChains(Dungeon);
	PlasticBall = new PlasticBall(BallPitRoom);
	PottedParsley = new PottedPlant(Greenhouse);
	PottedParsley.setName("Parsley");
	PottedSage = new PottedPlant(Greenhouse);
	PottedSage.setName("Sage");
	FancyBook = new Book(Greenhouse);
	FancyBook.setName("Fancy_Book");
	Teleporter = new Teleporter(Library);
	PortalB = new PortalB(MirrorRoom);
	PortalY = new PortalY(Bedroom);
	Uncle = new Uncle(Roof);


	

	Bedroom.addItem(Bed);
	Bedroom.addItem(APCSTextbook);
	Bedroom.addItem(TeddyBear);
	Bedroom.addItem(Letter);
	Bathroom.addItem(RubberDuck);
	Kitchen.addItem(LoafOfBread);
	Kitchen.addItem(FryingPan);
	Kitchen.addItem(WoodenSpatula);
	Kitchen.addItem(Matches);
	HallwayA.addItem(Torch);
	MirrorRoom.addItem(HandMirror);
	MirrorRoom.addItem(Mirror);
	DiningRoom.addItem(SaltShaker);
	DiningRoom.addItem(Chair);
	DiningRoom.addItem(Table);
	DiningRoom.addItem(Fork);
	DiningRoom.addItem(Knife);
	PlayRoom.addItem(ToyTrain);
	PlayRoom.addItem(BoxOfLegos);
	PlayRoom.addItem(BoxOfStuffedAnimals);
	LivingRoom.addItem(Couch);
	LivingRoom.addItem(TV);
	LivingRoom.addItem(Book);
	LivingRoom.addItem(CoffeeTable);
	Study.addItem(Desk);
	Study.addItem(FountainPen);
	Study.addItem(Dictionary);
	Parlour.addItem(FancyChair);
	Parlour.addItem(FancyTable);
	Parlour.addItem(FancyLamp);
	TortureChamber.addItem(RustyScalpel);
	TortureChamber.addItem(BloodStainedScalpel);
	TortureChamber.addItem(CleanScalpel);
	TortureChamber.addItem(ChineseWaterTorture);
	Attic.addItem(BoxOfPhotoAlbums);
	Attic.addItem(DustyTV);
	Pool.addItem(Towel);
	Pool.addItem(InflatableTube);
	Roof.addItem(PottedPlant);
	Roof.addItem(Hose);
	MusicRoom.addItem(Ukulele);
	MusicRoom.addItem(Guitar);
	MusicRoom.addItem(Piano);
	ExerciseRoom.addItem(Weight10);
	ExerciseRoom.addItem(Weight15);
	ExerciseRoom.addItem(Weight40);
	Dungeon.addItem(RustyChains);
	BallPitRoom.addItem(PlasticBall);
	Greenhouse.addItem(PottedParsley);
	Greenhouse.addItem(PottedSage);
	Library.addItem(FancyBook);
	Library.addItem(Teleporter);
	Bedroom.addItem(PortalY);
	MirrorRoom.addItem(PortalB);
	Roof.addItem(Uncle);

	teo = new Teo(Roof);
	mon = new Monster(null);

	bob = new Player(Bedroom, Bedroom);
	d.play(bob);
 

    }


}