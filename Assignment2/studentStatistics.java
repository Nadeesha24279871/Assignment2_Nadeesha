
/**
 *  This program is developed to compute statistics of students' marks in an assignment.
 *
 * @author (Nadeesha)
 * @version (24/09/2023)
 */
import java.io.*;
import java.util.*;
import java.io.BufferedReader;

public class studentStatistics
{ 
    public static void main (String[] args){

        System.out.println("This program is developed to compute statistics of students' marks in an assignment");
        Scanner scanner = new Scanner(System.in);
        Methods obj = new Methods();

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
    }
    class Methods{
        void totalMarks(List<Student> students) {

            for (int i=2;i<students.size();i++) {
                String[] val = students.get(i).split(",");

                if(val[0].startsWith("#")) {
                    continue;

                }

                double a1 =0.0;
                double a2 =0.0;
                double a3 =0.0;

                System.out.println("Name:"+ val[0].concat(" ").concat(val[1]));
                System.out.println("Student Id:"+ val[2]);
                if(val.length > 3)  {
                    if(!(val[3].isEmpty())) {
                        a1 = Double.parseDouble(val[3]);
                    } else {
                        a1 = 0;
                    }

                }
                if(val.length > 4)  {
                    if(!(val[4].isEmpty())) {
                        a2 = Double.parseDouble(val[4]);
                    } else {
                        a2 = 0;
                    }
                }
                if(val.length > 5)  {
                    if(!(val[5].isEmpty())) {
                        a3 = Double.parseDouble(val[5]);
                    } else {
                        a3 = 0;
                    }
                }

                System.out.println("A1:"+ a1);
                System.out.println("A2:"+ a2);
                System.out.println("A3:"+ a3);
                double total = a1+a2+a3;
                System.out.println("Total Marks:"+ total);

        
            }
        }
        void threshold(double threshold, List<Student> students){
            
            System.out.println("Students who have scored marks lesser than " + threshold);
            for (int i=2;i<students.size();i++) {
                if(students.getTotalMarks()<threshold){
                  System.out.println("Name:" +students.getName() + "Total marks scored: " +students.getTotalMarks()); 
                }
                
            }
        }
        
        void showTop5Students(List<Student> students){
            
        
        }
        
        
            public void readFromFile() {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter the file name ");
                String fileName = sc.next();

                List<Student> students = new ArrayList<>();
                String row;
                try{
                    File csvFile = new File(""+ fileName);
                    FileReader fileReader= new FileReader(csvFile);
                    BufferedReader br = new BufferedReader(fileReader);

                    while ((row = br.readLine()) != null){
                        students.add(new Student());

                        System.out.println("Data read successfully.");
                    } 
                }
                catch(IOException e) {
                    System.err.println("Error reading the file: " + e.getMessage());
                }

            
            return students;
        }


    
        public class Student{
            private String firstName;
            private String lastName;
            private double[] marks;

            public Student(String name, String id, double[] marks) {
                this.name = name;
                this.id = id;
                this.marks = marks;

            }
            public String getName(){
                return name;
            }
            public String getId(){
                return id;
            }
            public double[] getMarks(){
                return marks;
            }
            public double[] getTotalMarks(){
                return totalMarks;
            }
            
        }
