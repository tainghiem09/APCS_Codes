// student outline of Pair of Dice

import java.util.Random;

public class PairOfDice
{
    //private data-- 2 die

   private static Random generator = new Random();
   private Die die1;
   private Die die2; 

    /**---------- Default Constructor
        Creates two six-sided Die objects, both with an initial
        face value of one.
    */
   
   public PairOfDice(){ // the default constructor because it has no parameters (no int, double, etc...)
       die1 = new Die();
       die2 = new Die();
   }

    /**----------- roll()
        Rolls both dice and returns the combined result.
        @return int
    */
   
   public int roll(){
       die1.roll();
       die2.roll();
       
       return die1.getFaceValue() + die2.getFaceValue();

   }

    /**-------------- getTotal()
        Returns the current combined dice total.
        @return
    */
   
   public int getTotal(){
       int sum = die1.getFaceValue() + die2.getFaceValue();
       return sum;
   }

    /**---------------- getDie1()
        Returns the current value of the first die.
        @return
    */
   

   public int getDie1(){
       return die1.getFaceValue();
   }

    /**------------- getDie2()
        Returns the current value of the second die.
        @return
    */

   public int getDie2(){
       return die2.getFaceValue();
   }
   
    /**------------- toString()
            Returns the current data for each die
            hint: use methods in die to build the String to return
            @return
    */

   public String toString()
   {
      String data ="";
      data = "Die Value: " + die1.getFaceValue() + " and Die Value 2: " + die2.getFaceValue();

      return data;
   }


}