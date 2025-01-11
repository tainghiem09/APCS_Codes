/**
 * Write a description of class Student_Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Student_Test
{
   public static void main (String[] args)
   {
    
    Address home = new Address("456 Elm St", "Naperville", "IL", 60565);
    Address home2 = new Address("456 KTH Road", "Naperville", "IL", 60531);
    Address school = new Address("440 W Aurora Ave", "Naperville","IL",60540);
    // Address myHome = new Address(home2);
    
    Object Bille = new Student("Bill", "Sand", home);
    Object place = new Address("123 Elm", "Lisle", "IL", 60550);
    
    // System.out.println(Bille.getSchool());

    Student John = new Student("John","Zhang", home2);
    Student Jill = new Student("Jill","Jones", home);
    Student Tom = new Student("Tom","Jones", home);
    Student Tiffany = new Student("Tiffany", "Zhang", home2);
    Student K = new Student ("Kevin", "Nguyen", home);
    // Student Albert = John; // aliases, two references that point to the same object/memory
    // if you change one alias, it changes the other and vice versa...

    // creating an array1!!1
    Student[] myStudents = {K, Jill, Tom, Tiffany, John};
    Sorts.insertionSort(myStudents);
    for (Student s: myStudents)
    {
        System.out.println(s);
    }
    
    //System.out.println(Student.get_pop());
    //System.out.println(John.getSchool());
    
    // Albert.change(John);
    
    // System.out.println(John);
    // System.out.println(Albert);
    
    //System.out.println(Tiffany);

    //System.out.println(Jill.compareTo(John));
    //System.out.println(Tom.compareTo(Jill));

}//end of main
}
