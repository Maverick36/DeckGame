package Deck.Challenge;

public class Cards {

    private int rank;
    private int suit;
    private String rankName;
    private String suitName;


    public Cards(int rank, int suit, String rankName,String suitName) {
        this.rank = rank;
        this.suit = suit;
        this.rankName = rankName;
        this.suitName = suitName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public String getSuitName() {
        return suitName;
    }

    public void setSuitName(String suitName) {
        this.suitName = suitName;
    }

    public void PrintCard(){
     //   System.out.println("Rank - Suit");
        System.out.println(this.getRankName()+" - "+this.getSuitName());
       // System.out.println("----------END--------------");
    }
}
