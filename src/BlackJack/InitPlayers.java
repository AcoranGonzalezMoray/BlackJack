package BlackJack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Card;
import model.Player;

public class InitPlayers {
    
    Player player_1, player_2, player_3, croupier;
    List<Card> deck;
    
    public InitPlayers(Player p1, Player p2, Player p3, Player croupier, List<Card> deck){
        this.player_1 = p1;
        this.player_2 = p2;
        this.player_3 = p3;
        this.croupier = croupier;
        this.deck = deck;
    }
            
    public void initTest1(){
        List<Card> handP;
       
        handP = Arrays.asList(Card.Jack, Card.Ace);
        player_1.addCards(handP);

        handP = Arrays.asList(Card._10, Card._5, Card._6);
        player_2.addCards(handP);
       
        handP = Arrays.asList(Card._3, Card._6, Card.Ace, Card._3, Card.Ace, Card.King);
        player_3.addCards(handP);
        
        handP = Arrays.asList(Card._9, Card._7);
        croupier.addCards(handP);
        
        handP = Arrays.asList(Card._5, Card._4, Card.King, Card._2);
        deck.addAll(handP);
        
    }
    public void initTest2(){
        List<Card> handP;
       
        handP = Arrays.asList(Card._10, Card.King);
        player_1.addCards(handP);

        handP = Arrays.asList(Card._10, Card._2, Card._6);
        player_2.addCards(handP);
       
        handP = Arrays.asList(Card._8, Card._8, Card._5);
        player_3.addCards(handP);
        
        handP = Arrays.asList(Card._5, Card._10);
        croupier.addCards(handP);
        
        handP = Arrays.asList(Card.Ace, Card._3, Card.King, Card._2);
        deck.addAll(handP);
        
    }

    public List<Player> getPlayers(){
        List players = new ArrayList<Player>(); 
        players.add(player_1);players.add(player_2);players.add(player_3);players.add(croupier);
        return players;
    }
}
