package mud;

import java.util.List;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    private List<Item> items;
    private Map<String, Room> exits;

    public Room(String name, String description, List<Item> items, Map<String, Room> exits) {
        this.name = name;
        this.description = description;
        this.items = items;
        this.exits = exits;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItems(Item item){

    }

    public void removeItem(Item item){

    }

    public Map<String, Room> getExit(String direction) {
        return exits;
    }

    public void setExits(String direction, Room room) {

    }
}
