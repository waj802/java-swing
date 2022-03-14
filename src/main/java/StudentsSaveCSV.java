import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentsSaveCSV {

    public static void saveCSV(String path, List<Student> sList) throws Exception {
        File file = new File(path);

        try{
            FileWriter outputfile = new FileWriter(file);
//
//            CSVWriter writer = new CSVWriter(outputfile, ',',
//                    CSVWriter.NO_QUOTE_CHARACTER,
//                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
//                    CSVWriter.DEFAULT_LINE_END);

            StatefulBeanToCsvBuilder<Student> builder = new StatefulBeanToCsvBuilder<>(outputfile);
            StatefulBeanToCsv<Student> beanWriter = builder.build();

            List<Student> data = new ArrayList<>();
//            List<String[]> data = new ArrayList<String[]>();
//            data.add(new String[] {"firstName", "lastName", "yearOfBirth", "numberOfPoints"});
            for(Student s : sList){
                data.add(new Student(s.getFirstName(), s.getLastName(), s.getYearOfBirth(), s.getNumberOfPoints()));
            }
            System.out.println(data);
            beanWriter.write(data);

            outputfile.close();

//            for(Student s : sList){
//                data.add(new String[] {s.getFirstName(), s.getLastName(), s.getYearOfBirth().toString(), Double.toString(s.getNumberOfPoints())});
//            }
//            writer.writeAll(data);
//
//            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
