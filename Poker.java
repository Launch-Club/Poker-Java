import acm.program.*;
import java.util.Scanner;

public class Poker extends ConsoleProgram
{
  
  Scanner scanner = new Scanner(System.in);
  int card1n, card2n, cpu1n;
  String card1s, card2s, cpu1s, cpu2s;
  int userMoney = 1000;
  int cpuMoney = 1000;
  int[] main = new int[2];
  
  public void run() {
    main[1] = userMoney;
    System.out.println("Welcome!");
    while(true) {
      while(true) {
        card1n = getNum();
        checkNum(card1n);
        card1s = getSuit();
        card2s = getSuit();
        card2n= getNum();
        
        System.out.print("your cards are: " + card1n + " of " + card1s + " and " + card2n + " of " + card2s);
        System.out.println("\nDo you check, raise, or fold? (Type c, r, f respectively)");
        int[] pf = preflop();
        if(pf[0] == 1) {
          break;
        }
        System.out.println("You have " + pf[1] + " left.");
      }
    }
    
  }
  
  public void checkNum(int num) {
    if(num == 1) {
      
    }
  }
  
  public int[] preflop() {
    String input = scanner.nextLine();
    char in = input.charAt(0);
    while(true) {
      if(in == 'c') {
        System.out.println("Checked\nMoney Left: " + userMoney);
        break;
      }
      else if(in == 'r') {
        System.out.println("Raise");
        System.out.println("How much do you raise? (Type an interger)");
        int inputInt = scanner.nextInt();
        System.out.println("You raised " + inputInt);
        userMoney -= inputInt;
        main[1] = userMoney;
        break;
      }
      else if(in == 'f') {
        System.out.println("You fold");
        main[0] = 1;
      }
      else {
        System.out.println("Type one of the following: c, r or f");
      }
      
    }
    main[0] = 0;
    return main;
  }
  
  public int getNum() {
    int tmp = (int)(Math.random()*11 + 1);
    while(tmp == card1n && card2s == card1s) {
      tmp = (int)(Math.random()*11 + 1);
    }
    return tmp;
  }
  
  public String getSuit() {
    int tmp = (int)(Math.random()*4 + 1);
    if(tmp == 1) {
      return "Hearts";
    }
    else if(tmp == 2) {
      return "Spades";
    }
    else if(tmp == 3) {
      return "Clubs";
    }
    else return "Diamonds";
  }
  
}
