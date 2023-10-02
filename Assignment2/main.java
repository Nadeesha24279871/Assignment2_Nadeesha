
/**
 *  This program is developed to compute statistics of students' marks in an assignment.
 *
 * @author (Nadeesha)
 * @version (24/09/2023)
 */
import java.io.*;
import java.util.*;
import java.io.BufferedReader;

class students{
    private String firstName;
    private String lastName;
    private String unitName;
    private String studentId;
    private double a1;
    private double a2;
    private double a3;

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName= firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName= lastName;
    }

    public String getUnitName(){
        return unitName;
    }

    public void setUnitName(String unitName){
        this.unitName=unitName;
    }

    public String getStudentId(){
        return studentId;
    }

    public void setStudentId(String studentId){
        this.studentId= studentId;
    }

    public double getA1(){
        return a1;

    }

    public void setA1(double a1){
        this.a1= a1;
    }

    public double getA2(){
        return a2;

    }

    public void setA2(double a2){
        this.a2= a2;
    }

    public double getA3(){
        return a3;

    }

    public void setA3(double a3){
        this.a3= a3;
    }

}

class studentsStatics{

    void calculateTotalMarks(List<students> value) {

        for (students stu: value) {
            System.out.println("Name:"+ stu.getFirstName().trim()+(" ")+(stu.getLastName().trim()));
            System.out.println("Student Id:"+ stu.getStudentId());
            System.out.println("A1:"+ stu.getA1());
            System.out.println("A2:"+ stu.getA2());
            System.out.println("A3:"+ stu.getA3());
            double total = stu.getA1()+stu.getA2()+stu.getA3();
            System.out.println("Total Mark:"+ total);

            System.out.println();

        }

    }

    List<students> initializeData(List<String> value){

        List<students> studentList = new ArrayList<>();
        String unitName = "";

        for (int i=0;i<value.size();i++) {
            students st =new students();
            if(i==0) {
                unitName = value.get(0);

            }else if(i>=2) {

                String[] val = value.get(i).split(",");

                if(val[0].startsWith("#")) {
                    continue;

                }

                st.setFirstName(val[0]);
                st.setLastName(val[1]);
                st.setUnitName(unitName);
                st.setStudentId(val[2]);

                if(val.length > 3)  {
                    if(!(val[3].isEmpty())) {
                        st.setA1(Double.parseDouble(val[3].trim()));
                    } else {
                        st.setA1(0);
                    }

                }
                if(val.length > 4)  {
                    if(!(val[4].isEmpty())) {
                        st.setA2(Double.parseDouble(val[4].trim()));
                    } else {
                        st.setA2(0);
                    }
                }
                if(val.length > 5)  {
                    if(!(val[5].isEmpty())) {
                        st.setA3(Double.parseDouble(val[5].trim()));
                    } else {
                        st.setA3(0);
                    }
                }

                studentList.add(st);

            }

        }
        return studentList;

    }

    void readFromFile(List<students> value){

        

        for (students stu:value) {
        String unitName =  value.get(0).getUnitName();
        System.out.println("Unit Name:"+ unitName);
        System.out.println();

            System.out.println("Name:"+ stu.getFirstName().trim()+(" ")+(stu.getLastName().trim()));
            System.out.println("Student Id:"+ stu.getStudentId());
            System.out.println("A1:"+ stu.getA1());
            System.out.println("A2:"+ stu.getA2());
            System.out.println("A3:"+ stu.getA3());
            System.out.println();

        }

    }

    void listStudentsBelowThreshold(double d, List<students> value){
        int i = 0;
        

        for (students stu:value) {

            double total = stu.getA1()+ stu.getA2()+ stu.getA3();
            if(total<d) {
                ++i;
                System.out.println("The students who scored marks below the threshold value :");

                System.out.println("Name:"+ stu.getFirstName().trim()+(" ")+(stu.getLastName().trim()));

            }
        }
        
        if(i==0){
            System.out.println("No students below that mark");
        }
    }

    void showStudentsWithLowestAndHighestMarks(List<students> value){
        String[] val ;
        String[] high= {"0","0","0","0","0"};
        double[] d1 = {0,0,0,0,0};
        String[] low= {"0","0","0","0","0"};
        double[] d2 = {1000,1000,1000,1000,1000};

        for (students stu:value) {

            double total = stu.getA1()+stu.getA2()+stu.getA3();

            if(d1[0]<total) {
                d1[0]=total;
                high[0] = "Name:"+ stu.getFirstName().trim()+(" ")+(stu.getLastName()).trim()+("         Total Mark")+(Double.toString(total));
            } else if(d1[1]<total) {
                d1[1] = total;
                high[1] = "Name:"+stu.getFirstName().trim()+(" ")+(stu.getLastName()).trim()+("         Total Mark")+(Double.toString(total));
            }else if(d1[2]<total) {
                d1[2] = total;
                high[2] = "Name:"+stu.getFirstName().trim()+(" ")+(stu.getLastName()).trim()+("          Total Mark")+(Double.toString(total));
            }else if(d1[3]<total) {
                d1[3] = total;
                high[3] = "Name:"+stu.getFirstName().trim()+(" ")+(stu.getLastName()).trim()+("          Total Mark")+(Double.toString(total));
            }else if(d1[4]<total) {
                d1[4] = total;
                high[4] = "Name:"+stu.getFirstName().trim()+(" ")+(stu.getLastName()).trim()+("          Total Mark")+(Double.toString(total));
            }

            if(d2[0]>total) {
                d2[0]=total;
                low[0] = "Name:"+stu.getFirstName().trim()+(" ")+(stu.getLastName()).trim()+("          Total Mark")+(Double.toString(total));
            } else if(d2[1]>total) {
                d2[1] = total;
                low[1] = "Name:"+stu.getFirstName().trim()+(" ")+(stu.getLastName()).trim()+("          Total Mark")+(Double.toString(total));
            }else if(d2[2]>total) {
                d2[2] = total;
                low[2] = "Name:"+stu.getFirstName().trim()+(" ")+(stu.getLastName()).trim()+("          Total Mark")+(Double.toString(total));
            }else if(d2[3]>total) {
                d2[3] = total;
                low[3] = "Name:"+stu.getFirstName().trim()+(" ")+(stu.getLastName()).trim()+("          Total Mark")+(Double.toString(total));
            }else if(d2[4]>total) {
                d2[4] = total;
                low[4] = "Name:"+stu.getFirstName().trim()+(" ")+(stu.getLastName()).trim()+("          Total Mark")+(Double.toString(total));
            }

        }
        System.out.println("Top 5 Highest Mark Students");
        System.out.println();
        for(String s:high) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println();
        System.out.println("Top 5 Lowest Mark Students");
        System.out.println();
        for(String l:low) {
            System.out.println(l);
        }

    }

}
public class main{
    public static void main (String[] args){
        System.out.println("This program is developed to compute statistics of students' marks in an assignment from a given file ");
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPlease enter the file name");
        String fileName = sc.next();
        studentStatistics obj = new studentStatistics();

        List<String> values = new ArrayList<>();
        String row;
        try{
            File csvFile = new File("C:\\Users\\nadee\\OneDrive\\Desktop\\UNI\\PF\\Assignment2_Nadeesha\\Documents\\"+ fileName);
            FileReader fileReader= new FileReader(csvFile);
            BufferedReader br = new BufferedReader(fileReader);

            while((row = br.readLine()) != null) {
                values.add(row);

            } 
            menu(values);

        }
        catch(IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } 
    }

    static void menu(List<String> values) {

        Scanner sc = new Scanner(System.in);
        studentStatistics obj = new studentStatistics();

        List<students> studentsList = new ArrayList<>();
        studentsList = obj.initializeData(values);
        if (!studentsList.isEmpty()) {
            System.out.println("\n  This file contains the marks of  " + studentsList.get(0).getUnitName());
        }
            System.out.println("\n  You can choose an option from the menu below"); 
    

        try{
        int option = 0;
        
        while(option!=5){
            
            
            System.out.println("\nMenu");
            System.out.println();
            System.out.println("\n1. Read students data");
            System.out.println("\n2. Calculate the total marks for each student ");
            System.out.println("\n3. list the students with total marks less than a threshold");
            System.out.println("\n4. Show five students with highest marks and lowest marks "); 
            System.out.println("\n5. Exit the program");
            System.out.println("\nPlease enter your choice ( 1- 5) ");

            option = sc.nextInt();

            switch(option){
                case 1:
                    System.out.println("Enter the file name ");
                    obj.readFromFile(studentsList);
                    continue;
                case 2:
                    obj.calculateTotalMarks(studentsList);
                    continue;
                case 3:
                    System.out.println("Enter the threshold value ");
                    double t = sc.nextDouble();
                    obj.listStudentsBelowThreshold(t,studentsList);
                    continue;
                case 4:
                    obj.showStudentsWithLowestAndHighestMarks(studentsList);
                    continue;
                case 5:
                    System.out.println("Exit the program ");
                    System.exit(0);

                default:
                    System.out.println("Invalid option entered."); 
                    

            }
        }
    }catch(InputMismatchException e){
        System.out.println("Invalid option entered.");
        System.out.println("\nPlease select the option from the menu and enter a number from 1 to 5");
        menu(values);
    }
}
}

