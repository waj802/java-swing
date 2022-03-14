import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import javax.swing.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsReadCSV {

    private String csvFileName = "data/studentData.csv";
    private List stdList;
    private List<Student> studentsList = new ArrayList<>();


    StudentsReadCSV(String csvFileName) {
        this.csvFileName = csvFileName;
    }

    public List<Student> ReadCSVFile()  {

        try {
            CSVReader csvReader = new CSVReader(new FileReader(csvFileName));


            CsvToBean csvToBean = new CsvToBeanBuilder(csvReader)
                    .withType(Student.class)
                    .withIgnoreLeadingWhiteSpace(true).build();

            //This method is not recommended for large CSV File
            stdList = csvToBean.parse();
            System.out.println(" student list, new: " + stdList);
            for (Object std1 : stdList) {
                Student std = (Student) std1;
                studentsList.add((Student) std1);
            }
            csvReader.close();
        }catch(Exception FileNotFoundException){
            JOptionPane.showMessageDialog(null, "File do not exist!", "Error while reading from file", JOptionPane.ERROR_MESSAGE);
            System.out.println("File is not available...");
        }
//        }

        return studentsList;
    }

}
