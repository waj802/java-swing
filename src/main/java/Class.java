import com.opencsv.bean.CsvBindByName;

import java.util.*;

public class Class {

    @CsvBindByName
    private String nameOfGroup;

    private List<Student> studentsList = new ArrayList<>();

    @CsvBindByName
    private double maxNumberOfStudents;

    public Class(String firstName, String lastName, StudentCondition studentCondition, Integer yearOfBirth, double numberOfPoints, String nameOfGroup, double maxNumberOfStudents) {
//        super(firstName, lastName, studentCondition, yearOfBirth, numberOfPoints);
        this.nameOfGroup = nameOfGroup;
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public Class() {
    }

    public Class(String nameOfGroup, double maxNumberOfStudents) {
        this.nameOfGroup = nameOfGroup;
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    @Override
    public String toString() {
        return "Class{" +
                "nameOfGroup='" + nameOfGroup + '\'' +
                ", studentsList=" + studentsList +
                ", maxNumberOfStudents=" + maxNumberOfStudents +
                '}';
    }

    public void setMaxNumberOfStudents(double maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public double getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void addStudent(Student s){
        if(studentsList.contains(s)){
            System.out.println("Ten student już istnieje na liscie!");
        }
        else {
            if(studentsList.size()<maxNumberOfStudents){
                studentsList.add(s);
            }
            else {
                System.err.println("Pojemnosc grupy zostala przekroczona, student nie zostal dodany!");
            }
        }
    }
    public void addPoints(Student s, double points){
        s.setNumberOfPoints(s.getNumberOfPoints() + points);
        System.out.println("Dodana ilosc punktow: " + points + " Ilosc wszystkich punktow posiadana przez studenta: " +s.getNumberOfPoints());
    }

    public void getStudent(Student s){
        if(s.getNumberOfPoints() == 0){
            studentsList.remove(s);
            System.out.println("Student " + s.getFirstName() + " " + s.getLastName() + " zostal usuniety!");
        }
        else {
            System.out.println("Ilosc punktow studenta jest wieksza od 0, student nie zostal usuniety!");
        }
    }

    public void changeCondiction(Student s, StudentCondition sCondition){
        s.setStudentCondition(sCondition);
        System.out.println("Stan studenta zostal zmieniony na: " + sCondition);
    }

    public void removePoints(Student s, double points){
        s.setNumberOfPoints(s.getNumberOfPoints() - points);
        if(s.getNumberOfPoints() == 0){
            s.setNumberOfPoints(0);
        }
        System.out.println("Liczba posiadanych punktow przez studenta: " + s.getNumberOfPoints());
    }

//    public Student search(String lastName){
////        Student s = Collections.max(studentsList, lastName, new Comparator<Student>() {
////            //@Override
////            public int compare(Student s, String lastName) {
////                return String.compare(s.getLastName().equals(lastName));
////            }
////        });
//
//        Student s = Collections.max(studentsList, (s1) -> {
//            return s1.getLastName().equals(lastName);
//        });
//        return null;
//    }

    public Student search(String lastName){
        for (Student s : studentsList) {
            if(s.getLastName().equals(lastName)){
                return s;
            }
        }
        return null;
    }

    public void setNameOfGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public List<Student> searchPartial(String lastName){
        List<Student> studentsList2 = new ArrayList<>();
        for (Student s : studentsList) {
            if(s.getLastName().startsWith(lastName)){
                studentsList2.add(s);
            }
        }
        return studentsList2;
    }
    public Integer countByCondition(StudentCondition sCondition){
        Integer occurs = 0;
        for (Student s: studentsList) {
            if(s.getStudentCondition().equals(sCondition)){
                occurs++;
            }
        }
        return occurs;
    }
    public void summary(){
        for (Student s: studentsList) {
            System.out.println(s);
        }
    }
    public List<Student> sortByLastName(){
        //List<Student> studentsListSorted = new ArrayList<>();
        //Collections.sort(list, Comparator.comparingInt(ActiveAlarm ::getterMethod));
        //Collections.sort(studentsList, Comparator.comparing(Student::getLastName));
        //studentsList.sort(Comparator.comparing(a -> a.getEmail));
        //return studentsList;
        Collections.sort(studentsList, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
        return studentsList;
    }

    public List<Student> sortByPoints(){
        Collections.sort(studentsList, new PointsComparator());
        return studentsList;
    }

    public Student max(){
        //return Collections.max(studentsList, (o1, o2) -> o1.getNumberOfPoints())
        return studentsList.stream().max(Comparator.comparing(Student::getNumberOfPoints)).get();
    }

}
