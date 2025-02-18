package mud;

import java.util.List;

public class Player {
    private String name;
    private Room currentRoom;
    private List<Item> items;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {

    }
}
