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
        while (running) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("welcome to MUD!");
            System.out.println("write 'help' to see the list of commands.");
            System.out.print("> ");
            String user_input = scanner.next();
            handleInput(user_input);
        }
    }

    public void handleInput(String input) {
        // TODO:
        // 1) Parse the input into a command and optionally an argument
        // 2) Use a switch/case (or if/else) to call the correct method below
        //    based on the command word


    }

    private void lookAround() {
        // TODO: Print information about the player's current room

    }

    private void move(String direction) {
        // TODO: Attempt to move to the next room in the given direction
        //       If there's no room in that direction, print an error message
        //       If successfully moved, describe the new room

    }

    private void pickUp(String arg) {
        // TODO:
        // 1) Parse out the item name if 'arg' starts with "up "
        // 2) Check if that item exists in the current room
        // 3) Remove from room, add to player's inventory


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