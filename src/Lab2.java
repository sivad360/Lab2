//Name: Davis Tyler 
//Class: Cs 145
//Date:1/15/24
//Assignment: Lab 2
//Reference Materials: W3Schools.com
//Purpose: Creates and shuffles a deck of cards

import java.util.Random;
import java.util.Scanner;
//import java.util.ArrayList;

public class Lab2 {
    public static void main(String[] args) {
        while(true) {
        Menu Menu = new Menu();// this could be static?

        Menu.mainMenu(); // call main menu which gives option to quit or to start new game 
        }
    }

}

class Game {

    public void newGame(){ // function which contains functions for one single game
        
        //int[] gameParameters = new int[5];
        Objects MyObjects = new Objects(); // initialize objects Cards, decks, etc...
        MyObjects.initialize();

        Menu.sub1Menu(MyObjects); // call sub1Menu which gives players the options for game setup returns array of chars for setup values

    }

}

class Menu { // contains menu functions which control user interactions outside the actual game funcitons

    String[] mainMenuStrings = {"Welcome to _____ to continue please select an option","Options:" // strings which contain menu strings to print out
    ,"Press (N) to start a new game", "Press (Q) to quit"};
    
    String[] gameOptionsMenuStrings = {"Welcome to _____ to continue please select an option","Options:"
    ,"Press (N) to start a new game", "Press (Q) to quit"};

    public char genericMenu(String[] menuArray){ // generic menu can be formatted by string array parameter.

        Scanner input = new Scanner(System.in);

        for(int i=0;i<menuArray.length; i++){

            System.out.println(menuArray[i]);

        }

        String inputString = input.nextLine().toLowerCase(); 

        char inputChar = inputString.charAt(0);

        return inputChar;

    }

    public void mainMenu() { // main entrance menu option to start new game or quit
        boolean cont = false;

        char inputChar = 'q';

        while( cont == false) { // check if input is valid 

            inputChar = genericMenu(mainMenuStrings);
        
            if(inputChar == 'n'| inputChar == 'q'){

                cont = true;

            }

        }

        if (inputChar == 'n') { // create new game and call game functions 

            Game Game = new Game();
            Game.newGame();

        } else if (inputChar == 'q') { 

            System. exit(0);

        }

    }

    // public Objects setupMenu(Objects MyObjects) {

    //     return MyObjects;
    // }

    static public void sub1Menu(Objects MyObjects){ // controls print out and shuffle functions calls will eventually contain options setup

        System.out.printf("%n%s%n%n","Ordered deck:");
        
        MyObjects.printDeck(MyObjects.deck);
        System.out.printf("%n%s%n%n","Shuffled deck:");

        MyObjects.deck = MyObjects.shuffleDeck(MyObjects.deck);

        MyObjects.printDeck(MyObjects.deck);

    }

}

class Objects { // class which contains current hands deck setups and discard piles.

    class Card { // generic card class contains int values for logic
        String face;
        String suit;
        int faceInt;
        int suitInt;
    }

    // class Parameters {
    //     int players;
    //     String gametype;
    //     int numberOfGames;
    //     int numberOfRounds;
    // }

    // public void setParameters(int[] givenParameters) {

    //     //Parameters.players = givenParameters[1];
    // }

    public void printDeck(Card[] deck){ // print out current deck configuration
        Card current = new Card();

        for(int i = 0; i < deck.length; i++) {

            current = deck[i];

            System.out.printf("%s%s%s%n", current.face, " ", current.suit);
            
        }
    }

    public Card[] shuffleDeck(Card[] deck) { // shuffle deck which is passed to it. Could be for discard or for 

        Card[] shuffledDeck = new Card[52];

        Random rand = new Random();

        for(int i = 0; i < deck.length; i ++) { // take random card out of unshuffled deck and assign it to iterated index of shuffled deck

            int currentCardIndex;

            Card currentCard = null;

            while(currentCard == null) { // check that there is a valid card at the index in unshuffled deck if not generate new index
            
                currentCardIndex = rand.nextInt(52);
                currentCard = deck[currentCardIndex];
                deck[currentCardIndex] = null;

                shuffledDeck[i] = currentCard;

            }
        }

        return shuffledDeck;

    }

    Card hand[] = new Card[5]; // generic card array setup

    Card deck[] = new Card[52];

    Card discardDeck[] = new Card[52];
    
    public void initialize() { // create all the cards

        String suits[] = new String[4];
        suits[0] = "Spades";
        suits[1] = "Hearts";
        suits[2] = "Diamonds";
        suits[3] = "Clubs";

        String faces[] = new String[13];
        faces[0] = "Ace";
        faces[1] = "2";
        faces[2] = "3";
        faces[3] = "4";
        faces[4] = "5";
        faces[5] = "6";
        faces[6] = "7";
        faces[7] = "8";
        faces[8] = "9";
        faces[9] = "10";
        faces[10] = "Jack";
        faces[11] = "Queen";
        faces[12] = "King";

        for(int i = 0; i< faces.length; i++) { // iterate and combine all card options into 52 unique cards.

            for(int j = 0; j< suits.length; j++) {
                
                Card currentCard = new Card();
                currentCard.face = faces[i];
                currentCard.suit = suits[j];
                currentCard.faceInt = j;
                currentCard.suitInt = i;
                deck[j+i*4] = currentCard;

            }
        }

    }

    

    
}



