
public class Hand
{

  public int number;
  private String suit;
  public String sTmp;
  
  public Hand(int hnd, String s) {
    number = hnd;
    suit = s;
  }
  
  public int getNumber() {
    return number;
  }
  
  public String getSuit() {
    return suit;
  }
  
  public String toString() {
    
    if(number >= 10) {
      if(number == 13) {
        sTmp = "Ace";
      }
      else if(number == 12) {
        sTmp = "King";
      }
      else if(number == 11) {
        sTmp = "Queen";
      }
      else if(number == 10) {
        sTmp = "Jack";
      }
      return (sTmp + " of " + suit);
    }
    else return (number + " of " + suit);
    
  }
  
}
