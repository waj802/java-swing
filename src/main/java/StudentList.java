import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student_list", schema = "java_projekt", catalog = "")
public class StudentList {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "student_id")
    private int studentId;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "condiction")
    private String studentCondition;
    @Basic
    @Column(name = "year")
    private int yearOfBirth;
    @Basic
    @Column(name = "points")
    private int numberOfPoints;
    @Basic
    @Column(name = "group_id")
    private int groupId;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false)
    private GroupList groupListByGroupId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentCondition() {
        return studentCondition;
    }

    public void setStudentCondition(String condiction) {
        this.studentCondition = condiction;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int year) {
        this.yearOfBirth = year;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int points) {
        this.numberOfPoints = points;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentList that = (StudentList) o;
        return studentId == that.studentId && yearOfBirth == that.yearOfBirth && numberOfPoints == that.numberOfPoints && groupId == that.groupId && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(studentCondition, that.studentCondition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, firstName, lastName, studentCondition, yearOfBirth, numberOfPoints, groupId);
    }

    public GroupList getGroupListByGroupId() {
        return groupListByGroupId;
    }

    public void setGroupListByGroupId(GroupList groupListByGroupId) {
        this.groupListByGroupId = groupListByGroupId;
    }

    public StudentList() {
    }


    public StudentList(String firstName, String lastName, StudentCondition studentCondition, Integer yearOfBirth, double numberOfPoints) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentCondition = studentCondition.toString();
        this.yearOfBirth = yearOfBirth;
        this.numberOfPoints = (int)numberOfPoints;
    }

    public StudentList(String firstName, String lastName, Integer yearOfBirth, double numberOfPoints) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.numberOfPoints = (int)numberOfPoints;
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


    public boolean compare(StudentList s1, StudentList s2){
        if(s1.lastName.equals(s2.lastName)){
            System.out.println("Nazwiska studentow sa takie same!");
            return true;
        }
        else {
            System.out.println("Nazwiska studentow sa inne!");
            return false;
        }
    }
}
