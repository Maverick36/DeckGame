package Deck.Challenge;

import java.util.*;

public class Deck {

    private ArrayList<Cards> deck;

   // private ArrayList<Cards> playedCards;

    private boolean isDeckCreated = false;

    Deck(){
        this.deck = new ArrayList<Cards>();
       // this.playedCards = new ArrayList<Cards>();
    }

    public ArrayList<Cards> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Cards> deck) {
        this.deck = deck;
    }

    public boolean isDeckCreated() {
        return isDeckCreated;
    }

    public void setDeckCreated(boolean deckCreated) {
        isDeckCreated = deckCreated;
    }

    public void CreateDeck(){

        this.isDeckCreated = true;
        //create fresh deck

            for (Suits suit : Suits.values()) {
                for (Ranks rank : Ranks.values()) {
                    this.deck.add(new Cards(rank.ordinal(), suit.ordinal(), rank.name(), suit.name()));

                }
            }

    }

    public void ShuffleDeck(){
        Collections.shuffle(this.deck);
    }

    public void PrintAllCards() {
        for (int k = 0; k < this.deck.size(); k++) {
            this.deck.get(k).PrintCard();

        }
    }



    public void PrintMenu(){
        System.out.println("Deck Operations: Enter single number of operation.");
        System.out.println("1) CreateDeck()");
        System.out.println("2) ShuffleDeck()");
        System.out.println("3) SortBy()");
        System.out.println("4) DealOneCard()");
        System.out.println("5) DealCards(int count)");
        System.out.println("6) Show Cards In Deck!");
        System.out.println("7) Exist Program!");

    }

    public void SortBy(){
        System.out.println("Deck Operations: Enter single number of operation.");
        System.out.println("1) Sort by Rank.");
        System.out.println("2) Sort by Suit.");
        System.out.println("3) Quit Do not sort.");


        boolean isInputCorrect = false;
        Scanner scan = new Scanner(System.in);
        boolean isGameOn = true;
        int userInput = 0;
//loop until correct input is entered
        do {
            while (!isInputCorrect) {
                try {
                    userInput = scan.nextInt();
                    isInputCorrect = true;
                } catch (InputMismatchException ime) {
                    //Display Error message
                    System.out.println("Invalid Input found, Please enter numeric value 1, 2, or 3 !!");
                    scan.nextLine();//Advance the scanner
                }

            }
             isInputCorrect = false;


            switch (userInput) {
                case 1:
                    System.out.println("SORTING BY RANK.............");
                    Comparator<Cards> rankComparator = (c1, c2) -> (int) (c1.getRank() - c2.getRank());
                    Collections.sort(this.deck, rankComparator);
                    isGameOn = true;
                    break;
                case 2:
                    System.out.println("SORTING BY SUIT.............");
                    Comparator<Cards> suitComparator = (c1, c2) -> (int) (c1.getSuit() - c2.getSuit());
                    Collections.sort(this.deck, suitComparator);
                    isGameOn = true;
                    break;
                case 3: System.out.println("Heading back to main menu!");
                    isGameOn = true;
                    break;

                default: isGameOn = false;
                    System.out.println("Input was numeric but not 1, 2, or 3 try again!");
            }

        }while(!isGameOn);

    }

    public void DealOneCard(){

        int deckSize = this.deck.size()-1;
        if(deckSize >= 0) {
            Cards playedCard = this.deck.get(deckSize);

            this.deck.remove(playedCard);
            System.out.println("One card has been dealt!");
            System.out.println("Card Dealt: " + playedCard.getRankName() + " - " + playedCard.getSuitName());
        }
        else{
            System.out.println("Deck has no remaining cards! Create another deck!");
        }
    }

    public void TryToDealCards(){
        boolean isInputCorrect = false;
        Scanner scan = new Scanner(System.in);

        int userInput = 0;
        int numOfCards = 0;

            //loop until correct input is entered
            while (!((isInputCorrect) && (numOfCards > 0 && numOfCards < 53)) ) {
                System.out.println(" Please enter number of cards you want dealt? Enter number between 1 and 52 !!");
                try {
                    userInput = scan.nextInt();
                    numOfCards = userInput;
                    isInputCorrect = true;
                } catch (InputMismatchException ime) {
                    //Display Error message
                    System.out.println("Invalid Input found, Please enter numeric value between 1 and 52 !!");
                    scan.nextLine();//Advance the scanner
                }

            }
            DealCards(numOfCards);
    }
    private int DealCards(int count){

        int deckSizeRemaining = this.deck.size()-count;

        int deckSize = this.deck.size();
            if(deckSize == 0){
                System.out.println("Deck has no remaining cards! Create another deck!");
                return 0;
            }
        else if(deckSizeRemaining >= 0 && deckSize > 0) {

                if (deckSize > 0) {
                    //get true deck index;
                    deckSize = deckSize - 1;
                }
        }
        else {
            //get remainder of cards
            count = deckSize ;
                System.out.println(deckSize+" Remaining cards in the deck.........");
        }
            System.out.println(count+" Cards are being Dealt.........");
            for(int k = count; k > 0; k-- ) {
                Cards playedCard = this.deck.get(this.deck.size()-1);

                this.deck.remove(playedCard);

                System.out.println("Card Dealt: " + playedCard.getRankName() + " - " + playedCard.getSuitName());
            }

    return 1;

    }



}
