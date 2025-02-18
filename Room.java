package mud;

public class Room {
    private String roomName;
    private String description;
    private Room forward;
    private Room backward;
    private Room left;
    private Room right;
    private Item item;

    public Room(String roomName, String description) {
        this.roomName = roomName;
        this.description = description;
    }

    public void directions(Room forward, Room backward, Room left, Room right, Item item) {
        this.forward = forward;
        this.backward = backward;
        this.left = left;
        this.right = right;
        this.item = item;
    }

    public Room getDirection(String direction) {
        switch (direction) {
            case "forward":
                return forward;
            case "backward":
                return backward;
            case "left":
                return left;
            case "right":
                return right;
            default:
                return null;
        }
    }

    public String getRoomName() {
        return roomName;
    }

    public String getDescription() {
        return description;
    }

    public Item getItem(String itemName) {
        if (item != null && item.getName().equalsIgnoreCase(itemName)) {
            return item;
        }
        return null;
    }

    public void removeItem(Item item) {
        this.item = null;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String displayRoomItems(){
        if (item != null && item.getName() != null) {
            return "In the room (" + roomName + "), you'll find: " + item.getName();
        } else {
            return "The room (" + roomName + ") has no items.";
        }
    }
}
