package workingWithAbstractionExercise.E03CardsWithPower;

public class Card {
    CardRank cardRank;
    CardSuits cardSuits;


    public Card(CardRank cardRank, CardSuits cardSuits) {
        this.cardRank = cardRank;
        this.cardSuits = cardSuits;
    }

    public  int getCardPower(){
        return cardRank.getPower()+cardSuits.getPower();
    }
}
