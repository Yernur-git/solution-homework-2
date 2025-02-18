package mud;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Room currentRoom;
    private List<Item> inventory;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        inventory = new ArrayList<Item>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void moveToRoom(Room newRoom) {
        currentRoom = newRoom;
    }

    public void displayInventory() {
        System.out.println("inventory: ");
        if (!inventory.isEmpty()) {
            for (Item item : inventory) {
                System.out.print(item);
            }
            System.out.println();
        }
        else {
            System.out.println("you don't have any items.");
        }
    }

    public void pickUpItem(Item item) {
        if (item != null) {
            inventory.add(item);
            System.out.println("you picked up: " + item.getName());
        } else {
            System.out.println("there is no such item here.");
        }
    }
}