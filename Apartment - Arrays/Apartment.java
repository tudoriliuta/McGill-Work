import java.util.ArrayList;

public class Apartment
{
    public static void main(String[] args)
    {
        //create a room named kitchen
        Room kitchen = new Room("Kitchen", 10, 12);
        
        System.out.println("Area of the kitchen: " + kitchen.getArea());
        
        //create more rooms
        Room living = new Room("Living", 20, 40);
        
        Room bedroom = new Room("Bedroom", 100, 3000);
        
        //an ArrayList that stores rooms
        ArrayList<Room> rooms = new ArrayList<Room>();
        rooms.add(kitchen);
        rooms.add(living);
        rooms.add(bedroom);
        
        //print out the name of all rooms
        for (int i = 0; i < rooms.size(); i++)
        {
            Room r = rooms.get(i);
            System.out.println("Room: " + r.name);
        }
        
        //sum up the area for all rooms
        float apartmentArea = 0;
        
        for (int i = 0; i < rooms.size(); i++)
        {
            Room r = rooms.get(i);
            apartmentArea += r.getArea();
        }
        
        System.out.println("Total square metres: " + apartmentArea);
        
        //print out kitchen before and after
        //connecting it to the living room
        System.out.println(kitchen);
        
        kitchen.setNorth(living);
        
        System.out.println(kitchen);
        
        //create a greenhouse with the other constructor
        Room greenhouse = new Room("greenhouse", 134973, 24783478, null, null, null, kitchen);
        
        
        
    }
}