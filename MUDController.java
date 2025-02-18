package mud;

import java.util.Scanner;

public class MUDController {

    private final Player player;
    private boolean running;

    public MUDController(Player player) {
        this.player = player;
        this.running = true;
    }

    public void runGameLoop() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome to MUD!");
        System.out.println("type 'help' to see the list of commands.");

        while (running) {
            System.out.print("> ");
            String user_input = scanner.nextLine();
            handleInput(user_input);
        }

        scanner.close();
    }

    public void handleInput(String input) {
        input = input.trim().toLowerCase();

        String command = "";
        String argument = "";

        int spaceIndex = input.indexOf(" ");

        if (spaceIndex != -1) {
            command = input.substring(0, spaceIndex);
            argument = input.substring(spaceIndex + 1).trim();
        } else {
            command = input;
        }

        switch (command){
            case "help":
                showHelp();
                break;
            case "quit":
            case "exit":
                running = false;
                break;
            case "look":
                lookAround();
                break;
            case "move":
                if (!argument.isEmpty()) {
                    move(argument);
                } else {
                    System.out.println("Please specify a direction: forward, backward, left, or right.");
                }
                break;
            case "pick":
                if (!argument.equals("")) {
                    pickUp(argument);
                }
                else {
                    System.out.println("please specify an item to pick up.");
                }
                break;
            case "inventory":
                checkInventory();
                break;
            default:
                System.out.println("invalid command. type 'help' to see the list of commands.");
                break;
        }
    }

    private void lookAround() {
        Room currentRoom = player.getCurrentRoom();
        if (currentRoom != null) {
            System.out.println(currentRoom.displayRoomItems());
        }
        else {
            System.out.println("you are not in a room.");
        }
    }

    private void move(String direction) {
        Room currentRoom = player.getCurrentRoom();
        Room nextRoom = null;

        switch (direction) {
            case "forward":
                nextRoom = currentRoom.getDirection("forward");
                break;
            case "back":
            case "backward":
                nextRoom = currentRoom.getDirection("backward");
                break;
            case "left":
                nextRoom = currentRoom.getDirection("left");
                break;
            case "right":
                nextRoom = currentRoom.getDirection("right");
                break;
            default:
                System.out.println("invalid direction. type 'help' to see the list of commands.");
                return;
            }
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            System.out.println("you moved " + direction + " to " + nextRoom.displayRoomItems());
        }
        else {
            System.out.println("you can't move in that direction. there's no room in that direction.");
        }
    }

    private void pickUp(String arg) {
        Room currentRoom = player.getCurrentRoom();
        if (currentRoom != null) {
            Item item = currentRoom.getItem(arg);
            if (item != null) {
                currentRoom.removeItem(item);
                player.pickUpItem(item);
            }
            else {
                System.out.println("item not found.");
            }
        }
        else {
            System.out.println("you are not in a room.");
        }
    }

    private void checkInventory() {
        player.displayInventory();
    }

    private void showHelp() {
        System.out.println("- look: Describes the current room, including items and NPCs.");
        System.out.println("- move <direction>: Moves the player in the specified direction (forward, back, left, right).");
        System.out.println("- pick up <item>: Picks up an item from the current room and adds it to the inventory.");
        System.out.println("- inventory: Lists all items the player is carrying.");
        System.out.println("- help: Shows this list of commands.");
        System.out.println("- quit/exit: Ends the game loop.");
    }
}
