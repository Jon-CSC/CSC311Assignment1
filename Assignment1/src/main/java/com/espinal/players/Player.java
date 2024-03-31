package com.espinal.players;

import java.util.Objects;

/**
 * The Player class. This class holds a first name, last name, and player score.
 * Methods for comparing scores and player names are available.
 * @author Jonathan
 */
public class Player implements Comparable<Player>{
    // It should hold a first name, last name, and score.    
    // The class should exhibit data hiding.
    private String firstName;
    private String lastName;
    private int score;
    
    /**
     * Default constructor. Initializes variable members to their defaults
     * according to type.
     */
    public Player(){
        firstName = null;
        lastName = null;
        score = 0;
    }
    
    /**
     * Parameterized constructor. Creates an object of type Player with the
     * given first name, last name, and score.
     * @param first First name of the player.
     * @param last Last name of the player.
     * @param score The player's score.
     */
    public Player(String first, String last, int score){
        firstName = first;
        lastName = last;
        this.score = score;
    }
    
    /**
     * Returns player first name.
     * @return String with player first name.
     */
    public String getFirstName(){
        return firstName;
    }
    
    /**
     * Returns player last name.
     * @return String with player last name.
     */
    public String getLastName(){
        return lastName;
    }
    
    /**
     * Returns player score.
     * @return Integer value of player score.
     */
    public int getScore(){
        return score;
    }
    
    /**
     * Compares the score of this player to the score of the specified player.
     * @param player The specified player.
     * @return Returns a -1, 0, or 1 as this player's score is less than, equal 
     * to, or greater than the specified player's score.
     */
    @Override
    public int compareTo(Player player) {
        if (this.score < player.score){
            return -1;
        }else if(this.score == player.score){
            return 0;
        }else{
            return 1;
        }
    }
    
    /**
     * Compares the first and last names of this player against those of the 
     * specified player to determine if they are equal.
     * @param obj The specified player.
     * @return Returns true if first and last names of the specified player 
     * are equal to this player. Will return false if the specified object is
     * not a player or if the names are not equal.
     */
    @Override
    public boolean equals(Object obj){
        if ( !(obj instanceof Player) ){
            return false;
        }
        Player player = (Player) obj;
        return (this.firstName.compareTo( player.firstName) == 0) && (this.lastName.compareTo(player.lastName) == 0);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.firstName);
        hash = 89 * hash + Objects.hashCode(this.lastName);
        return hash;
    }
    
    /**
     * Creates a string representation of the current state of this Player 
     * object.
     * @return A string representation of the Player object.
     */
    @Override
    public String toString(){
        return ("Name: " + firstName + " " + lastName + ", Score: " + score);
    }
}
