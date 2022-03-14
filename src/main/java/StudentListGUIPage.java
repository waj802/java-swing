import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class StudentListGUIPage extends ClassGUI{
    private static JTextField textFirstName;
    private static JTextField textLastName;
    private static JTextField textPoints;
    private static JTextField textYear;
    private static String textCondiction;
    private static StudentCondition textCondictionEnum;
    private Class currentClass = new Class();
    JTable table = new JTable();
    JComboBox studentCondiction;
    Object[] colums = {"First Name", "Last Name", "Condiction", "Year", "Points"};
    DefaultTableModel model = new DefaultTableModel();
    JFrame frame = new JFrame("Student List");
//    JLabel label = new JLabel("Hello");
    private String groupName;
    StudentListGUIPage(String nameOfGroup){
        frame.setLocationRelativeTo(null);
        this.groupName = nameOfGroup;
        Object[] row = new Object[5];

//        label.setBounds(0,0,100,50);
//        label.setFont(new Font(null, Font.PLAIN,25));
//        frame.add(label);



        frame.getContentPane().setBackground(new Color(0, 0, 0));
        frame.getContentPane().setForeground(Color.WHITE);
        frame.setBounds(100, 100, 690, 800);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        model.setColumnIdentifiers(colums);
        table.setModel(model);

        for (Class tab : classContainer.getMap().values()) {
            if(tab.getNameOfGroup().equals(nameOfGroup)){
                this.currentClass = tab;
                System.out.println(tab.getStudentsList());
                for (Student s : tab.getStudentsList()) {
                    row[0] = s.getFirstName();
                    row[1] = s.getLastName();
                    row[2] = s.getStudentCondition().toString();
                    row[3] = String.valueOf(s.getYearOfBirth());
                    row[4] = String.valueOf(s.getNumberOfPoints());

                    for (Object r:
                            row) {
                        System.out.println(r);
                    }

                    model.addRow(row);
                }
            }
        }

        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setSelectionBackground(Color.lightGray);
        table.setGridColor(Color.lightGray);
        table.setSelectionForeground(Color.white);
        table.setFont(new Font("Tahoma", Font.PLAIN, 17));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.lightGray);
        pane.setBackground(Color.white);
        pane.setBounds(10, 10, 650, 350);
        frame.getContentPane().add(pane);

        textFirstName = new JTextField();
        textFirstName.setBounds(120,375,180,35);
        frame.getContentPane().add(textFirstName);
        textFirstName.setColumns(10);

        textLastName = new JTextField();
        textLastName.setBounds(430,375,180,35);
        frame.getContentPane().add(textLastName);
        textLastName.setColumns(10);

        textYear = new JTextField();
        textYear.setBounds(120,420,180,35);
        frame.getContentPane().add(textYear);
        textYear.setColumns(10);

        textPoints = new JTextField();
        textPoints.setBounds(430,420,180,35);
        frame.getContentPane().add(textPoints);
        textPoints.setColumns(10);

        String[] condictions = {StudentCondition.CHORY.toString(),
                StudentCondition.NIEOBECNY.toString(),
                StudentCondition.ODRABIAJACY.toString(),
                StudentCondition.OCZEKUJACY.toString(),
                StudentCondition.PRZEPISANY.toString(),
                StudentCondition.WYPISANY.toString()};
        studentCondiction = new JComboBox(condictions);
        studentCondiction.setBounds(120, 465, 180,35);
        frame.getContentPane().add(studentCondiction);

        JButton btnSortName = new JButton("Sort By Last Name");
        btnSortName.setBounds(342, 465, 148, 35);
        frame.getContentPane().add(btnSortName);
        btnSortName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentClass.sortByLastName();
                JOptionPane.showMessageDialog(null, "Student list sorted by Last Name", "Sorting info", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        JButton btnSortPoints = new JButton("Sort By Points");
        btnSortPoints.setBounds(511, 465, 148, 35);
        frame.getContentPane().add(btnSortPoints);
        btnSortPoints.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentClass.sortByPoints();
                JOptionPane.showMessageDialog(null, "Student list sorted by number of points", "Sorting info", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        studentCondiction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==studentCondiction){
                    textCondiction=studentCondiction.getSelectedItem().toString();
                    if(textCondiction.equals(StudentCondition.CHORY.toString())){
                        textCondictionEnum = StudentCondition.CHORY;
                    }
                    if(textCondiction.equals(StudentCondition.NIEOBECNY.toString())){
                        textCondictionEnum = StudentCondition.NIEOBECNY;
                    }
                    if(textCondiction.equals(StudentCondition.ODRABIAJACY.toString())){
                        textCondictionEnum = StudentCondition.ODRABIAJACY;
                    }
                    if(textCondiction.equals(StudentCondition.WYPISANY.toString())){
                        textCondictionEnum = StudentCondition.WYPISANY;
                    }
                    if(textCondiction.equals(StudentCondition.PRZEPISANY.toString())){
                        textCondictionEnum = StudentCondition.PRZEPISANY;
                    }
                    if(textCondiction.equals(StudentCondition.OCZEKUJACY.toString())){
                        textCondictionEnum = StudentCondition.OCZEKUJACY;
                    }
                    System.out.println(textCondiction);
                }
            }
        });

        JLabel lblFirstName = new JLabel("First Name");
        lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblFirstName.setForeground(Color.white);
        lblFirstName.setBounds(10,375,100,35);
        frame.getContentPane().add(lblFirstName);

        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblLastName.setForeground(Color.white);
        lblLastName.setBounds(330,375,100,35);
        frame.getContentPane().add(lblLastName);

        JLabel lblYear = new JLabel("Year");
        lblYear.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblYear.setForeground(Color.white);
        lblYear.setBounds(10,420,100,35);
        frame.getContentPane().add(lblYear);

        JLabel lblPoints = new JLabel("Points");
        lblPoints.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblPoints.setForeground(Color.white);
        lblPoints.setBounds(330,420,100,35);
        frame.getContentPane().add(lblPoints);

        JLabel lblCondiction = new JLabel("Condiction");
        lblCondiction.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblCondiction.setForeground(Color.white);
        lblCondiction.setBounds(10,465,100,35);
        frame.getContentPane().add(lblCondiction);


        JButton btnAdd = new JButton("ADD");
        btnAdd.setBounds(10, 510, 317, 35);
        frame.getContentPane().add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currentClass.getMaxNumberOfStudents() > currentClass.getStudentsList().size()) {
                    row[0] = textFirstName.getText();
                    row[1] = textLastName.getText();
                    row[2] = textCondictionEnum.toString();
                    row[3] = textYear.getText();
                    row[4] = textPoints.getText();

                    Student newStudent = new Student(textFirstName.getText(), textLastName.getText(), textCondictionEnum, Integer.parseInt(textYear.getText()), Double.parseDouble(textPoints.getText()));
                    if(currentClass.getStudentsList().contains(currentClass.search(newStudent.getLastName())))
                    {
                        JOptionPane.showMessageDialog(null, "Student already exist!", "Adding error", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        currentClass.addStudent(newStudent);

                        System.out.println(classContainer);
                        System.out.println(currentClass.getStudentsList());

                        System.out.println("all students:");
                        for (Student s0 : classContainer.getMap().get(currentClass.getNameOfGroup()).getStudentsList())
                            System.out.println(s0);

                        model.addRow(row);

                        textFirstName.setText("");
                        textLastName.setText("");
                        textYear.setText("");
                        textPoints.setText("");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Class is full!", "No more space in the class", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });

        JButton btnDelete = new JButton("DELETE");
        btnDelete.setBounds(342, 510, 317, 35);
        frame.getContentPane().add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                if (i >= 0) {
                    String studentLastName = model.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString();
//                    List<Student> sList = new ArrayList<Student>();
//                    sList = currentClass.getStudentsList();
                    Student sRemove = currentClass.search(studentLastName);
                    currentClass.getStudentsList().remove(sRemove);
                    model.removeRow(i);
                } else {
                    JOptionPane.showMessageDialog(frame, "Delete Error");
                }
            }
        });

        JButton btnAddPoints = new JButton("ADD POINTS");
        btnAddPoints.setBounds(10, 560, 317, 35);
        frame.getContentPane().add(btnAddPoints);
        btnAddPoints.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int i = table.getSelectedRow();
                if (i >= 0) {
                    String studentLastName = model.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString();
                    Student sAddPoints = currentClass.search(studentLastName);
                    model.setValueAt((Double.parseDouble(textPoints.getText())+sAddPoints.getNumberOfPoints()), table.getSelectedRow(), table.getSelectedColumn()+3);
                    currentClass.addPoints(sAddPoints, Double.parseDouble(textPoints.getText()));
                }
                textPoints.setText("");
            }
        });

        JButton btnChangeCondiction = new JButton("CHANGE CONDICTION");
        btnChangeCondiction.setBounds(342, 560, 317, 35);
        frame.getContentPane().add(btnChangeCondiction);
        btnChangeCondiction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int i = table.getSelectedRow();
                if (i >= 0) {
                    String studentLastName = model.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString();
                    Student sChangeCondiction = currentClass.search(studentLastName);
                    model.setValueAt(studentCondiction.getSelectedItem().toString(), table.getSelectedRow(), table.getSelectedColumn()+1);
                    currentClass.changeCondiction(sChangeCondiction, textCondictionEnum);
                }
                textPoints.setText("");
            }
        });

        JButton btnRemovePoints = new JButton("REMOVE POINTS");
        btnRemovePoints.setBounds(10, 610, 317, 35);
        frame.getContentPane().add(btnRemovePoints);
        btnRemovePoints.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int i = table.getSelectedRow();
                if (i >= 0) {
                    String studentLastName = model.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString();
                    Student sAddPoints = currentClass.search(studentLastName);
                    model.setValueAt((sAddPoints.getNumberOfPoints()-Double.parseDouble(textPoints.getText())), table.getSelectedRow(), table.getSelectedColumn()+3);
                    currentClass.removePoints(sAddPoints, Double.parseDouble(textPoints.getText()));
                }
                textPoints.setText("");
            }
        });

        JButton btnCountCondiction = new JButton("COUNT BY CONDICTION");
        btnCountCondiction.setBounds(342, 610, 317, 35);
        frame.getContentPane().add(btnCountCondiction);
        btnCountCondiction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, currentClass.countByCondition(textCondictionEnum), "Counting: " + textCondictionEnum.toString(), JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton btnMaxPoints = new JButton("MAX POINTS");
        btnMaxPoints.setBounds(10, 660, 317, 35);
        frame.getContentPane().add(btnMaxPoints);
        btnMaxPoints.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student sMaxPoints = currentClass.max();
                JOptionPane.showMessageDialog(null, sMaxPoints.getFirstName() + " " + sMaxPoints.getLastName() + " " + sMaxPoints.getNumberOfPoints() + " Points", "Max number of points", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton btnSearch = new JButton("SEARCH");
        btnSearch.setBounds(342, 660, 317, 35);
        frame.getContentPane().add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student sSearch = currentClass.search(textLastName.getText());
                JOptionPane.showMessageDialog(null, sSearch.getFirstName() + " " + sSearch.getLastName(), "Student info", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton btnImport = new JButton("IMPORT");
        btnImport.setBounds(10, 710, 317, 35);
        frame.getContentPane().add(btnImport);
        btnImport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                StudentsReadCSV studentsReadCSV = new StudentsReadCSV("data/" + currentClass.getNameOfGroup() + ".csv");
                List<Student> tempList = studentsReadCSV.ReadCSVFile();

                for(Student sTemp : tempList){
                    row[0] = sTemp.getFirstName();
                    row[1] = sTemp.getLastName();
                    row[2] = StudentCondition.OCZEKUJACY;
                    row[3] = sTemp.getYearOfBirth();
                    row[4] = sTemp.getNumberOfPoints();


                    if(currentClass.getStudentsList().size()<currentClass.getMaxNumberOfStudents()) {
                        if(currentClass.getStudentsList().contains(currentClass.search(sTemp.getLastName())))
                        {
                            JOptionPane.showMessageDialog(null, "Student " + sTemp.getFirstName() + " " + sTemp.getLastName() + " already exist!", "Importing error", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            currentClass.addStudent(sTemp);
                            model.addRow(row);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Class is full!", "No more space in the class", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            }
        });

        JButton btnExport = new JButton("EXPORT");
        btnExport.setBounds(342, 710, 317, 35);
        frame.getContentPane().add(btnExport);
        btnExport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StudentsSaveCSV.saveCSV("data/" + currentClass.getNameOfGroup() + ".csv", currentClass.getStudentsList());
                    JOptionPane.showMessageDialog(null, "Data saved successfully!", "Data exported", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception g){
                    g.printStackTrace();
                }
            }
        });

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we)
            {
                String ObjButtons[] = {"Yes","No"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Are you sure you want to exit?", "Online Examination System",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                        ObjButtons,ObjButtons[1]);
                if(PromptResult==0)
                {
                    System.exit(0);
                }
            }
        });

        frame.setResizable(false);
        frame.setVisible(true);
    }
}
