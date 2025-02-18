package mud;

public class Main {
    public static void main(String[] args) {
        Room startRoom = new Room("Start Room", "A dimly lit room with stone walls.");
        Room secondRoom = new Room("Second Room", "A bright room with a wooden table.");
        Room thirdRoom = new Room("Third Room", "A cold room with a mysterious chest.");

        Item key = new Item("Key", "A rusty old key.");
        Item torch = new Item("Torch", "A wooden torch that provides light.");

        startRoom.directions(secondRoom, null, null, null, key);
        secondRoom.directions(thirdRoom, startRoom, null, null, torch);
        thirdRoom.directions(null, secondRoom, null, null, null);

        Player player = new Player(startRoom);
        MUDController game = new MUDController(player);
        game.runGameLoop();
    }
}
