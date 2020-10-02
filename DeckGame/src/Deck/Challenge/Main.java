package Deck.Challenge;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Deck deck = new Deck();

        deck.PrintMenu();
        boolean isGameOn = true;
        boolean isInputCorrect = false;
        Scanner scan = new Scanner(System.in);

        int userInput = 6;
         do {

             while(!isInputCorrect) {
                try {
                    userInput = scan.nextInt();
                    isInputCorrect = true;
                } catch (InputMismatchException ime) {
                    //Display Error message
                    System.out.println("Invalid Input found, Please enter numeric values only between 1 and 6 !!");
                    scan.nextLine();//Advance the scanner
                }

            }
             isInputCorrect = false;


            switch (userInput){
                case 1:
                    if(!(deck.isDeckCreated() && deck.getDeck().size() > 0)) {
                        deck.CreateDeck();

                        System.out.println("Deck has been created!");
                    }else{
                        System.out.println("Deck already Exist, Try another operation!");
                    }
                    break;
                case 2:
                    if(deck.isDeckCreated()) {
                        deck.ShuffleDeck();
                        System.out.println("SHUFFLING.............");
                        deck.PrintAllCards();
                        deck.PrintMenu();
                    }
                    else{
                        System.out.println("Deck has not been created yet, create deck first.");
                    }
                    break;
                case 3:
                    if(deck.isDeckCreated()) {
                        deck.SortBy();
                        deck.PrintAllCards();
                        deck.PrintMenu();
                    }else{
                        System.out.println("Deck has not been created yet, create deck first.");
                    }
                    break;
                case 4:
                    if(deck.isDeckCreated()) {
                        deck.DealOneCard();

                        deck.PrintMenu();
                    }else{
                        System.out.println("Deck has not been created yet, create deck first.");
                    }
                    break;
                case 5:
                    if(deck.isDeckCreated()){
                        deck.TryToDealCards();
                        deck.PrintMenu();
                    }else{
                        System.out.println("Deck has not been created yet, create deck first.");
                    }
                    break;
                case 6:
                    if(deck.isDeckCreated()) {
                        System.out.println("Printing Remaining Cards In Deck.........");
                        System.out.println("Rank - Suit");
                        deck.PrintAllCards();
                        System.out.println("----------END--------------");
                        deck.PrintMenu();
                    }else{
                        System.out.println("Deck has not been created yet, create deck first.");
                    }
                    break;
                case 7: isGameOn = false;
                    System.out.println("GOODBYE!");
                    break;

                    default: System.out.println("Incorrect Input something went wrong. Try again!");
                    break;
            }

        } while(isGameOn);

    }
}
