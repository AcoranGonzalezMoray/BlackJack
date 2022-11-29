package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final ArrayList<Card> hand = new ArrayList<>();
    private boolean gotBlackJack = false;
    
    public Player(String name){
        this.name = name;
    }
        
    public String getName(){
        return name;
    }
    
    public List<Card> getHand(){
        return new ArrayList(hand);
    }


    public void addCard(Card card){
        hand.add(card);
    }
    
    public void addCards(List<Card> cards){
        for (Card c : cards) {addCard(c);}
    }
    
    @Override
    public String toString(){
        String string = "";
        for (Card card : hand) string += card.toString() + ", ";
        return name + ": [" + string.substring(0, string.length()-2) + "]";
    }
    
    
    public void setGotBlackJack(boolean gotBlackJack) {
        this.gotBlackJack = gotBlackJack;
    }
    
    public boolean gotBlackJack() {
        return gotBlackJack;
    }
}
