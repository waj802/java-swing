import com.opencsv.bean.CsvBindAndJoinByName;
import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;

public class Student implements Comparable{

    @CsvBindByName(column = "firstName")
    private String firstName;

    @CsvBindByName(column = "lastName")
    private String lastName;

    private StudentCondition studentCondition=StudentCondition.OCZEKUJACY;

    @CsvBindByName(column = "yearOfBirth")
    private Integer yearOfBirth;

    @CsvBindByName(column = "numberOfPoints")
    private double numberOfPoints;

    public Student() {
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public Student(String firstName, String lastName, StudentCondition studentCondition, Integer yearOfBirth, double numberOfPoints) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentCondition = studentCondition;
        this.yearOfBirth = yearOfBirth;
        this.numberOfPoints = numberOfPoints;
    }

    public Student(String firstName, String lastName, Integer yearOfBirth, double numberOfPoints) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.numberOfPoints = numberOfPoints;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentCondition=" + studentCondition +
                ", yearOfBirth=" + yearOfBirth +
                ", numberOfPoints=" + numberOfPoints +
                '}';
    }

    public void print(){
        System.out.println("Imie: " + firstName + "\nNazwisko: " + lastName + "\nStan studenta: " + studentCondition + "\nRok urodzenia: " + yearOfBirth + "\nLiczba punktow: " + numberOfPoints);
    }


    public boolean compare(Student s1, Student s2){
        if(s1.lastName.equals(s2.lastName)){
            System.out.println("Nazwiska studentow sa takie same!");
            return true;
        }
        else {
            System.out.println("Nazwiska studentow sa inne!");
            return false;
        }
    }

    public double getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(double numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setStudentCondition(StudentCondition studentCondition) {
        this.studentCondition = studentCondition;
    }

    public StudentCondition getStudentCondition() {
        return studentCondition;
    }
}
