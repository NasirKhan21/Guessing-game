import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

class Guessing{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ArrayList<String> cards = new ArrayList<>();

        cards.add("King");
        cards.add("King");
        cards.add("Queen");
        cards.add("Queen");
        cards.add("Ace");
        cards.add("Ace");
        cards.add("Joker");
        cards.add("Joker");
        cards.add("Spade");
        cards.add("Spade");

        
         
        //Shuflling the card list
       
       

        //The board is an array of strings that represents the state of the game board at any given time.
        String board[] = new String[cards.size()];

         //Flipped is a boolean array that keeps track of which cards have been flipped over.
        boolean flipped[] = new boolean[cards.size()];

        int pair_found = 0;

        while(pair_found<5){

            //Printing the board elements initially all the elements are null
            print_board_elemnts(board);
            
            //When a player flips a card, we replace the corresponding element of the board array with the value of the card.
            int first_index = get_card_index(sc,board,flipped, "Enter index of first card to flip:");
            board[first_index] = cards.get(first_index);

           // Flipped is a boolean array that keeps track of which cards have been flipped over.
            flipped[first_index] = true;
            print_board_elemnts(board);
            
            System.out.println();

            int second_index = get_card_index(sc, board, flipped,"Enter index of second  card to flip:");
            board[second_index] = cards.get(second_index);
            flipped[second_index] = true;
        // print_board_elemnts(board);


            if(cards.get(first_index).equals(cards.get(second_index))){
                System.out.println("You found a pair!");
                pair_found++;
            }else {
                System.out.println("Sorry, those cards don't match.");
                board[first_index] = " ";
                board[second_index] = " ";
                flipped[first_index] = false;
                flipped[second_index] = false;
            }
          
          System.out.println();

        }
        System.out.println("Congratulations all the cards are flipped correctly.");
        System.out.println("You Won!");


    } 

    static int get_card_index(Scanner scan, String[] board, boolean[] flipped,String prompt){
      
        int index = 0;

        while(true){
            System.out.println(prompt);

            index = scan.nextInt();
            if(index < 0 || index >=board.length){
                System.out.println("Invalid Index ,try again!");
            }else if(flipped[index]){
                System.out.println("Card Already flipped ,select any other card");
            }else{
                break;
            }
            
        }
        return index;
    }
    
    static void print_board_elemnts(String[] board){
        for(int i=0; i<board.length; i++){
            System.out.print("|" + board[i] + " ");
        }
        System.out.println("|");
    }
        
}