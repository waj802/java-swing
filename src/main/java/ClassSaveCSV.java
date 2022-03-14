import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClassSaveCSV {

    public static void saveCSV(String path, ClassContainer cc) throws Exception {
        File file = new File(path);

        try{
            FileWriter outputfile = new FileWriter(file);

//            CSVWriter writer = new CSVWriter(outputfile, ',',
//                    CSVWriter.NO_QUOTE_CHARACTER,
//                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
//                    CSVWriter.DEFAULT_LINE_END);

            StatefulBeanToCsvBuilder<Class> builder = new StatefulBeanToCsvBuilder<>(outputfile);
            StatefulBeanToCsv<Class> beanWriter = builder.build();

//            List<String[]> data = new ArrayList<String[]>();
            List<Class> data = new ArrayList<>();

            for(Class c : cc.getMap().values()){
                data.add(new Class(c.getNameOfGroup(), c.getMaxNumberOfStudents()));
            }
            beanWriter.write(data);

            outputfile.close();

//            data.add(new String[] {"nameOfGroup", "maxNumberOfStudents"});
//            for(Class c : cc.getMap().values()){
//                data.add(new String[] {c.getNameOfGroup(), Double.toString(c.getMaxNumberOfStudents())});
//            }
//            writer.writeAll(data);
//
//            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
