package com.espinal.players;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 * Assignment 1 - Main driver class.
 * CSC 311
 * Due 9/24/2021 @ 9:25am
 * @author Jonathan Espinal
 */
public class Main {
    /**
     * main function
     * @param args 
     */
    public static void main(String[] args){
        List<Player> players = new ArrayList<>();
        FileWriter fileWriter;
        FileReader fileReader;
        String openedFile = "NONAME";
        String outFile;
        Gson gson = new Gson();
        String json;
        Scanner keyboard = new Scanner(System.in);
        
        int choice;
        boolean running = true;          
        while(running){
            // print menu
            System.out.println("Player UI (File: " + openedFile + ")");
            System.out.println("1 - Open");
            System.out.println("2 - Save");
            System.out.println("3 - Save As");
            System.out.println("4 - Add new player");
            System.out.println("5 - Show all players");
            System.out.println("6 - Show all players in reverse");
            System.out.println("7 - Find player score");
            System.out.println("8 - Sort players by score");
            System.out.println("9 - Exit");
            System.out.println("Enter choice: ");
            
            // take choice and execute
            choice = keyboard.nextInt();
            switch(choice){
                case 1:
                    System.out.println("File to open: ");
                    openedFile = keyboard.next();
                    try {
                        fileReader = new FileReader (openedFile);
                        players.clear();
                        players = gson.fromJson(fileReader, new TypeToken<ArrayList<Player>>(){}.getType());  
                    } catch (FileNotFoundException ex) {
                        System.out.println("File not found.");
                    }               
                    break;    
                case 2: 
                    outFile = openedFile;
                    json = gson.toJson(players);
                    try {
                        fileWriter = new FileWriter(outFile);
                        fileWriter.write(json);
                        fileWriter.close();
                        System.out.println("File saved: " + outFile);
                    }catch (IOException e){
                            System.err.println("Error saving file.");
                    }
                    break;
                case 3:
                    System.out.println("Save as: ");
                    outFile = keyboard.next();
                    json = gson.toJson(players);
                    try {
                        fileWriter = new FileWriter(outFile);
                        fileWriter.write(json);
                        fileWriter.close();
                        System.out.println("File saved: " + outFile);
                    }catch (IOException e){
                            System.err.println("Error creating file.");
                    }
                    openedFile = outFile;
                    break; 
                case 4:
                    System.out.println("Enter first: ");
                    String first = keyboard.next();
                    System.out.println("Enter last: ");
                    String last = keyboard.next();
                    System.out.println("Enter score: ");
                    int score = keyboard.nextInt();
                    players.add(new Player(first,last,score));
                    break;
                case 5:
                    print(players);
                    System.out.println();
                    break;
                case 6:
                    printReversed(players);
                    System.out.println();
                    break;
                case 7: 
                    System.out.println("Enter First");
                    String fname = keyboard.next();
                    System.out.println("Enter Last");
                    String lname = keyboard.next();
                    try{
                        System.out.println("Score: " + search(players,fname,lname).getScore());
                    }catch (PlayerNotFoundException ex){
                        System.out.println("Player not found.");
                    }
                    break;
                case 8:
                    Collections.sort(players);
                    print(players);
                    break;
                case 9: 
                    running = false;
                    break;
            }
            System.out.println();
        }
    }
    
    /**
     * Prints the collection.
     * @param collection The collection to be printed.
     */
    static void print(Collection<Player> collection){
        for (Player player: collection){
            System.out.println(player.toString());
        }
    }
    
    /**
     * Prints the list in reverse order.
     * @param list The list to be printed.
     */
    static void printReversed(List<Player> list){
        String reversed = "";
        for (Player player: list){
            reversed = "\n" + player.toString() + reversed;
        }
        System.out.println(reversed);
    }
    
    /**
     * Searches the collection for a player with the specified first and last 
     * name.
     * @param collection Collection to be searched
     * @param first The first name of the player to be searched for.
     * @param last The last name of the player to be searched for.
     * @return Returns the player when found.
     * @throws PlayerNotFoundException Thrown when player not found in the collection.
     */
    static Player search(Collection<Player> collection, String first, String last) throws PlayerNotFoundException{  
        for (Player player: collection){
            if (player.getFirstName().equals(first) && player.getLastName().equals(last)) {
                return player;
            }
        }
        throw new PlayerNotFoundException(first,last);
    }
}   
    
