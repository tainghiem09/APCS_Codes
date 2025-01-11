//********************************************************************
//  Die.java
//
//********************************************************************

import java.util.Random;
public class Die
{
   private final int MIN_FACES = 6;

   private static Random generator = new Random();
   private int numFaces;   // number of sides on the die
   private int faceValue;  // current value showing on the die

   /**
     Defaults to a six-sided die. Initial face value is 1.
   */
   public Die ()
   {
      numFaces = 6;
      faceValue = 1;
   }
   
   /**
        constructor
     Explicitly sets the size of the die. Defaults to a size of
     six if the parameter is invalid < MIN_FACES.
     Initial face value is random.
     @parm int number of sides of the die
   */
   public Die(int faces)
   {
       if (faces > MIN_FACES)
       {
           numFaces = MIN_FACES;
       }
       else
           numFaces = faces;
       faceValue = generator.nextInt(1,numFaces+1);
   }


   /**
           Rolls the die and returns the result.
           @return random roll
   */
   public int roll ()
   {
      faceValue = generator.nextInt(1,numFaces+1);
      return faceValue;
   }

   /**
           Returns the current die value.
           @return current face value of die
   */
   public int getFaceValue ()
   {
      return faceValue;
   }


  /**
        Returns the current number of faces the die has.
        @return current number of faces of die
  */
    public int getNumFaces()
    {
        return numFaces;
    }

  /**
          Sets the number of faces of the Die
          @param int number of faces for die
  */
  public void setFaces(int faces)
  {
      numFaces = faces;
  }


   /**
           Returns the current die value and number of sides as a String.
           @return the current die value and number of sides
   */
   public String toString()
   {
      String data ="";
      data = "Die Value: " + faceValue + "\nSides: " + numFaces;


      return data;
   }
   
}