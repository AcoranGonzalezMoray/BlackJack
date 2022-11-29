package test;

import org.junit.Test;
import model.*;
import BlackJack.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class BlackJackTest{
         
    @Test
    public void test_hand_value_with_one_card() {
        List<Card> cards = new ArrayList<>();
        cards.add(Card._3);
        assertEquals(3, BlackJack.getSumHand(cards));
        cards.clear();cards.add(Card._10);
        assertEquals(10, BlackJack.getSumHand(cards));
        cards.clear();cards.add(Card.Jack);
        assertEquals(10, BlackJack.getSumHand(cards));
        cards.clear();cards.add(Card.Queen);
        assertEquals(10, BlackJack.getSumHand(cards));
        cards.clear();cards.add(Card.King);
        assertEquals(10, BlackJack.getSumHand(cards));
        cards.clear();cards.add(Card.Ace);
        assertEquals(11, BlackJack.getSumHand(cards));
    }
    
    @Test
    public void test_hand_value_with_two_cards() {
        List<Card> cards = new ArrayList<>();
        cards.add(Card._5);cards.add(Card._3);
        assertEquals(8, BlackJack.getSumHand(cards));        
    }
    
    @Test
    public void test_hand_is_black_jack() {
        List<Card> cards = new ArrayList<>();
        Player player = new Player("Test Player");

        cards.add(Card._5);cards.add(Card._3);
        assertEquals(false, BlackJack.isBlackJack(cards, player));  

        cards.clear();cards.add(Card.Ace);cards.add(Card._10);
        assertEquals(true, BlackJack.isBlackJack(cards, player));

        cards.clear();cards.add(Card.Ace);cards.add(Card.King);
        assertEquals(true, BlackJack.isBlackJack(cards, player));

        cards.clear();cards.add(Card.Ace);cards.add(Card.Jack);
        assertEquals(true, BlackJack.isBlackJack(cards, player));

        cards.clear();cards.add(Card.Ace);cards.add(Card.Queen);
        assertEquals(true, BlackJack.isBlackJack(cards, player));        
    }
    
    @Test 
    public void given_two_cards_should_determine_if_is_black_jack() {
        List<Card> cards = new ArrayList<>();
        Player player = new Player("Test Player");
        
        cards.add(Card._5);cards.add(Card._6);
        assertEquals(false,  BlackJack.isBlackJack(cards, player)); 
        
        cards.clear();cards.add(Card.Ace);cards.add(Card.Queen);
        assertEquals(true, BlackJack.isBlackJack(cards, player));               
    }

    @Test 
    public void given_three_cards_should_determine_that_is_not_black_jack() {
        List<Card> cards = new ArrayList<>();
        Player player = new Player("Test Player");
        
        cards.add(Card._5);cards.add(Card._6);cards.add(Card.Queen);
        assertEquals(false,  BlackJack.isBlackJack(cards, player));               
    }
    
    @Test 
    public void given_two_cards_should_determine_that_is_not_bust() {
        List<Card> cards = new ArrayList<>();
        Player player = new Player("Test Player");
        
        cards.add(Card._5);cards.add(Card._6);
        assertEquals(false, BlackJack.isBust(cards));               
    }
    
    @Test 
    public void given_three_cards_should_determine_that_is_bust_or_not() {
        List<Card> cards = new ArrayList<>();
        Player player = new Player("Test Player");
        
        cards.add(Card._4);cards.add(Card.Jack);cards.add(Card.King);
        assertEquals(true,  BlackJack.isBust(cards)); 
        cards.clear();cards.add(Card._4);cards.add(Card._2);cards.add(Card._3);
        assertEquals(false,  BlackJack.isBust(cards));               
    }

    @Test 
    public void case_1_only_win_one_player_with_blackjack_vs_croupier(){
        Player player_1 = new Player("Player 1"), player_2 = new Player("Player 2"), player_3 = new Player("Player 3"), croupier = new Player("Croupier");
        ArrayList<Card> deck = new ArrayList<>();
        
        InitPlayers init = new InitPlayers(player_1, player_2, player_3, croupier, deck);    
        init.initTest1();//Prueba 1 inicializa hand
        
        List<Player> winners = BlackJack.getWinners(player_1, player_2, player_3, croupier, deck);
        
        assertEquals(1,  winners.size());  
        assertEquals("Player 1",  winners.get(0).getName()); 
        assertEquals(true,  BlackJack.isBlackJack(winners.get(0).getHand(), winners.get(0))); 
        assertEquals(21,  BlackJack.getSumHand(winners.get(0).getHand()));
        assertEquals(2,  winners.get(0).getHand().size());
    }
    
    @Test 
    public void case_2_win_two_players_without_blackjack_vs_croupier(){
        Player player_1 = new Player("Player 1"), player_2 = new Player("Player 2"), player_3 = new Player("Player 3"), croupier = new Player("Croupier");
        ArrayList<Card> deck = new ArrayList<>();
        
        InitPlayers init = new InitPlayers(player_1, player_2, player_3, croupier, deck);    
        init.initTest2();//Prueba 2 inicializa hand
        
        List<Player> winners = BlackJack.getWinners(player_1, player_2, player_3, croupier, deck);
        
        assertEquals(2,  winners.size());  
        assertEquals("Player 1",  winners.get(0).getName()); 
        assertEquals(false,  BlackJack.isBlackJack(winners.get(0).getHand(),winners.get(0))); 
        assertEquals(20,  BlackJack.getSumHand(winners.get(0).getHand()));
        assertEquals(2,  winners.get(0).getHand().size());
        assertEquals("Player 3",  winners.get(1).getName()); 
        assertEquals(false,  BlackJack.isBlackJack(winners.get(1).getHand(),winners.get(1))); 
        assertEquals(21,  BlackJack.getSumHand(winners.get(1).getHand()));
        assertEquals(3,  winners.get(1).getHand().size());
     
    }
}
