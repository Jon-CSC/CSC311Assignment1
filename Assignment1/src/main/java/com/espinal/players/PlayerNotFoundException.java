package com.espinal.players;

/**
 * Exception class for when a player is not found after searching a collection.
 * @author Jonathan
 */
public class PlayerNotFoundException extends Exception{
    
    /**
     *  Constructor. PlayerNotFoundException should be thrown when you search a 
     * collection for a given player and it is not found
     * @param first First name of the player.
     * @param last  Last name of the player.
     */
    public PlayerNotFoundException(String first, String last){
        super("Player " + first + " " + last + " not found!");
    }
}
