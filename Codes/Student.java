public class Student implements Comparable
{
    //private static int population;
    public static int population;

   private String firstName, lastName;
   private Address homeAddress; 

   private static Address schoolAddress;


   /**
   //  Sets up this Student object with the specified initial values.
   */
   public Student (String first, String last, Address home)
   {
       //static var increase pop for ever student created in that school
      population ++; //System.out.println(population + " Scon"  );
      schoolAddress = new Address("440 W Aurora Ave", "Naperville", "IL", 60540);

      firstName = first;
      lastName = last;
      homeAddress = home;

   }

// returns the population = to the amount of student objects created
// for static methods don't have to put object.method, (CAN USE CLASS, but don't have to??)

   public static int get_pop ()
   {
       return population;
   }


    public Address getSchool()
    {
        return schoolAddress;
    }

    
    public void change(Student other)
    {
        other.firstName = "Andrea"; // can access private data when inside of the same class
        // this other. is passed by reference (and also changed)
        // everytime you pass a method through an object it creates an alias
    }

    /**
      //  implement Comparable by make the compareTo method
   */

   public int compareTo(Object obj)
   {
        int result = 0;
       Student temp = (Student) obj;
       result = this.firstName.compareTo(temp.firstName);
       
       return result;
   }




  public String get_name()
  {
       return firstName;

   }





    /*returns the amount of studnet obj created
   public static int get_pop()
   {
       return population;

   }
*/


   /**
   //  Returns this Student object as a string.
       @return ________
   */
   public String toString()
   {
      String result;

      result = firstName + " " + lastName + "\n";
      result += "Home Address:\n" + homeAddress + "\n";
      //result += "School Address:\n" + schoolAddress;

      return result;
   }
}//end of Student
