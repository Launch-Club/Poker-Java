import acm.program.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Poker2 extends ConsoleProgram
{
  
  Scanner scanner = new Scanner(System.in);
  HashMap<Integer, Hand> used = new HashMap<Integer, Hand>();
  Integer userMoney = 1000;
  Hand user1, user2, cpu1, cpu2;
  Integer pot = 0;
  Integer cpuMoney = 1000;
  
  public void run() {
    while(true) {
      while(true) {
        System.out.println("Game Begins");
        
        user1 = getNum();
        user2 = getNum();
        cpu1 = getNum();
        cpu2 = getNum();
        cpuMoney -= 10;
        userMoney -= 10;
        pot = 20;
        System.out.println("You currently have " + userMoney);
        System.out.println("Your hands are " + user1+" and "+user2);
        int cpu = decide();
        if(cpu == 1) {
          System.out.println("CPU folds");
          break;
        }
        Hand flop1 = getNum();
        Hand flop2 = getNum();
        Hand flop3 = getNum();
        System.out.println("Flops are " + flop1 + ", " + flop2 + " and " + flop3);
        cpu = decide();
        if(cpu == 1) {
          System.out.println("CPU folds");
          break;
        }
        Hand turn = getNum();
        System.out.println("Turn is " + turn);
        cpu = decide();
        if(cpu == 1) {
          System.out.println("CPU folds");
          break;
        }
        Hand river = getNum();
        System.out.println("River is " + river);
        cpu = decide();
        if(cpu == 1) {
          break;
        }
        System.out.println("CPU has " + cpu1 + " and " + cpu2);
        System.out.println("Did you win? (Type y or no)");
        String yes = scanner.nextLine();
        if(yes.charAt(0) == 'y') {
          userMoney += pot;
          System.out.println("Congradulations, you won " + pot + "\nYou now have " + userMoney);
          break;
        }
      }
      System.out.println("Playagain? (Type y or n)");
      String no = scanner.nextLine();
      if(no.charAt(0) == 'n') break;
    }
    
  }
  
  public int decide() {
    while(true) {
      System.out.println("Do you bet or check (Type b or c)");
      String input = scanner.nextLine();
      if(input.charAt(0) == 'b') {
        System.out.println("How much do you want to bet?");
        int in = scanner.nextInt();
        userMoney -= in;
        pot += in;
        System.out.println("You bet " + in + "\nYou have " + userMoney + " left");
        int cpuChoice = cpuReaction(in);
        return cpuChoice;
      }
      else if(input.charAt(0) == 'c') {
        return 0;
      }
      else {
        System.out.println("Type either b or c");
      }
    }
    
  }
  
  public int cpuReaction(int size) {
    if(cpu1.getNumber() + cpu2.getNumber() >= 18) {
      int prob = (int)(Math.random() * 10);
      if(prob >= 8) {
        System.out.println("Cpu calls");
        pot += size;
        return 0;
      }
      else {
        System.out.println("Cpu folds");
        return 1;
      }
    }
    else {
      pot += size;
      return 0;
    }
  }
  
  public Hand getNum() {
    String suit;
    int tmp;
    int num = (int)(Math.random()*52 + 1);
    
    while(used.containsKey(num)) {
      num = (int)(Math.random()*52) + 1;
    }
    
    if(num < 14) {
      suit = "Heats";
    }
    else if(14 <= num && num < 27) {
      suit = "Spades";
    }
    else if(27 <= num && num < 40) {
      suit = "Diamonds";
    }
    else suit = "Clubs";
    
    tmp = num % 13 + 1;
    
    Hand h = new Hand(tmp, suit);
    used.put(num, h);
    return h;
  }
  

}
