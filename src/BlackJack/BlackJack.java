package BlackJack;

import java.util.ArrayList;
import java.util.List;
import model.Card;
import model.Player;

public class BlackJack {
    private final static int BJ = 21;
    private final static int MIN_CROUPIER = 17;

    public static List getWinners(Player player1, Player player2, Player player3, Player croupier, List<Card> deck){
        
        List<Player> Players = new ArrayList<>();
        Players.add(player1); Players.add(player2); Players.add(player3); 
        
        List<Player> winners = new ArrayList<>();
        
        fillCroupier(croupier, deck);
        
        //Juego individual entre jugador y croupier
        for(Player player : Players){
            List<Card> handCrourpier = croupier.getHand(); 
            List<Card> handPlayer = player.getHand(); 
        
            if(isBlackJack(handCrourpier, croupier)){
                List<Player> winnersC = new ArrayList<>();
                winnersC.add(croupier);
                return winnersC;
            }
            if(isWinner(handCrourpier, handPlayer, player))winners.add(player);
            
        }
        return winners;
    }
    
    private static boolean isWinner(List<Card> handCrourpier, List<Card> handPlayer, Player player) {   
        if(isBlackJack(handPlayer, player))return true;
        int sumCroupier = getSumHand(handCrourpier);
        int sumPlayer = getSumHand(handPlayer);
        if(sumPlayer <= BJ) if((sumCroupier > BJ) || (sumCroupier < sumPlayer)) return true;       
        return false;
    }

    public static boolean isBlackJack(List<Card> hand, Player player) {
        if((getSumHand(hand) != BJ) || (hand.size() != 2)) return false;
        if(hand.get(0).value() == 10 && hand.get(1).value() == 11) {player.setGotBlackJack(true);return true;}
        else return(hand.get(1).value() == 10);
        
    }

    public static int getSumHand(List<Card> hand) {
        int sum = 0, aces = 0;

        for (Card card : hand) { 
            sum += card.value(); 
            if(card.isAce()){aces++;}
        }
        
        if(aces != 0) while(sum>21 && aces>0){ sum -= 10; aces--; }
            
        return sum;
    }

    public static void fillCroupier(Player croupier, List<Card> deck) {
        List<Card> hand = croupier.getHand();
        int sum = getSumHand(hand);
        
        int i = 0;
        while(sum < MIN_CROUPIER){
            Card c = deck.get(i);
            
            croupier.addCard(c);
            hand = croupier.getHand();
            
            sum = getSumHand(hand);
            i++; 
        }
    }
    
    public static boolean isBust(List<Card> hand){
        if(getSumHand(hand)>21)return true;
        else return false;
    }
}
