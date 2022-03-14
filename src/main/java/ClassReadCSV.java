import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import javax.swing.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassReadCSV {
    private String csvFileName = "data/studentData.csv";
    private List classList;
    private List<Class> classListOrg = new ArrayList<>();
    private List<Student> studentsList = new ArrayList<>();
    Map<String, Class> classMap = new HashMap<>();


    ClassReadCSV(String csvFileName) {
        this.csvFileName = csvFileName;
    }

    public Map<String, Class> ReadCSVFile()  {

        try {
            CSVReader csvReader = new CSVReader(new FileReader(csvFileName));

            CsvToBean csvToBean = new CsvToBeanBuilder(csvReader)
                    .withType(Class.class)
                    .withIgnoreLeadingWhiteSpace(true).build();

            classList = csvToBean.parse();
            System.out.println(classList);
            for (Object cl0 : classList) {
                Class cl = (Class) cl0;
                classMap.put(cl.getNameOfGroup(), cl);
                
                StudentsReadCSV studentsReadCSV = new StudentsReadCSV("data/" + cl.getNameOfGroup() + ".csv");
                List<Student> tempList = studentsReadCSV.ReadCSVFile();

                for(Student sTemp : tempList){

                    if(cl.getStudentsList().size()<cl.getMaxNumberOfStudents()) {
                        if(cl.getStudentsList().contains(cl.search(sTemp.getLastName())))
                        {
                            JOptionPane.showMessageDialog(null, "Student " + sTemp.getFirstName() + " " + sTemp.getLastName() + " already exist!", "Importing error", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            cl.addStudent(sTemp);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Class is full!", "No more space in the class", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            }
            csvReader.close();
        }catch(Exception FileNotFoundException){
            JOptionPane.showMessageDialog(null, "File do not exist!", "Error while reading from file", JOptionPane.ERROR_MESSAGE);
            System.out.println("File is not available...");
        }

        return classMap;
    }

}
