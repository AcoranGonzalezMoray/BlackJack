package BlackJack;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class BlackJackMain {
    
    public static void main(String[] args) {
        System.out.println("##Casos");
        posibleCase(1);
        System.out.println("\n");
        posibleCase(2);
    }
    
    
    private static void posibleCase(int cases){
        Player player_1 = new Player("Player 1"), player_2 = new Player("Player 2"), player_3 = new Player("Player 3"), croupier = new Player("Croupier");
        ArrayList<Card> deck = new ArrayList<>();
        
        System.out.println("###Caso "+cases);
        InitPlayers init = new InitPlayers(player_1, player_2, player_3, croupier, deck);
        
        switch(cases){
            case 1:init.initTest1();break;
            case 2:init.initTest2();break;
        }
        
        List<Player> winners = BlackJack.getWinners(player_1, player_2, player_3, croupier, deck);
        String winner_out = "[";
        for (Player winner : winners) {
            winner_out += winner.getName();
            if(winners.get(winners.size()-1)!=winner) winner_out+=',';
        }
       
        for (int i = 0; i <= 3; i++) {
            String blackjack="";
            if (init.getPlayers().get(i).gotBlackJack())blackjack=" Black Jack";
            System.out.println(init.getPlayers().get(i).toString() + 
                    "(" + BlackJack.getSumHand(init.getPlayers().get(i).getHand()) + blackjack +")");
        }
        
        System.out.println("Deck: " + deck.toString() + "\n");
        System.out.println("getWinners(...) -----> " + winner_out+ "]");
    }
    
    
    
  
}
