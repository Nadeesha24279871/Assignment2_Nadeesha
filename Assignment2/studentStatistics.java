
/**
 *  This program is developed to compute statistics of students' marks in an assignment.
 *
 * @author (Nadeesha)
 * @version (24/09/2023)
 */
import java.io.*;
import java.util.*;
public class studentStatistics
{ 
    public static void main (String[] args){
        
    
    System.out.println("This program is developed to compute statistics of students' marks in an assignment");
    Scanner scanner = new Scanner(System.in);
    
   
    while (true)
    {
        System.out.println("\nMenu");
        System.out.println("\n1. Read students data");
        System.out.println("\n2. Calculate the total marks for each student ");
        System.out.println("\n3. list the students with total marks less than a the threshold");
        System.out.println("\n4. Show five students with highest marks and lowest marks "); 
        System.out.println("\n5. Exit the program");
        System.out.println("\nPlease enter your choice ( 1- 5) ");
        
        int option = scanner.nextInt();
        scanner.nextLine();
        
        switch(option){
            case 1:
                System.out.println("Enter the file name ");
                break;
            case 2:
                calculateTotalMarks();
                break;
            case 3:
                threshold();
                break;
            case 4:
                showStudents();
                break;
            case 5:
                System.out.println("Exit the program ");
                break;
            default:
                break;
                
                
                
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    


    
}
}
