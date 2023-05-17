package prog2;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GUI extends JFrame {
    private JPanel mainPanel;
    private JPanel filePanel;
    private JPanel homePanel;
    private JTextField fileNameTF;
    private JTextField fileNameOutputTF;
    private JButton continueButton;
    private JButton toSubjectsBtn1;
    private JButton toSortBtn1;
    private JButton toChangeCourseBtn1;
    private JButton toEditGradesBtn1;
    private JButton toGradesBtn1;
    private JPanel menuPanel;
    private JPanel showSubjectsPanel;
    private JPanel showGradesPanel;
    private JPanel editGradesPanel;
    private JPanel changeCoursePanel;
    private JButton toSubjectsBtn2;
    private JButton toChangeCourseBtn2;
    private JButton toEditGradesBtn2;
    private JButton toGradesBtn2;
    private JButton toSubjectsBtn3;
    private JButton toChangeCourseBtn3;
    private JButton toEditGradesBtn3;
    private JButton toGradesBtn3;
    private JButton toSubjectsBtn4;
    private JButton toChangeCourseBtn4;
    private JButton toEditGradesBtn4;
    private JButton toGradesBtn4;
    private JButton toSubjectsBtn5;
    private JButton toChangeCourseBtn5;
    private JButton toEditGradesBtn5;
    private JButton toGradesBtn5;
    private JPanel showSubjectsMain;
    private JTable showSubjectsTable;
    private JScrollPane scrollPane1;
    private JTable courseTable;
    private JPanel addCoursePanel;
    private JPanel editCoursePanel;
    private JPanel removeCoursePanel;
    private JButton toSubjectsBtn6;
    private JButton toChangeCourseBtn6;
    private JButton toEditGradesBtn6;
    private JButton toGradesBtn6;
    private JButton toSubjectsBtn7;
    private JButton toChangeCourseBtn7;
    private JButton toEditGradesBtn7;
    private JButton toGradesBtn7;
    private JButton toSubjectsBtn8;
    private JButton toChangeCourseBtn8;
    private JButton toEditGradesBtn8;
    private JButton toGradesBtn8;
    private JButton toSortBtn2;
    private JButton toSortBtn3;
    private JButton toSortBtn4;
    private JButton toSortBtn5;
    private JButton toSortBtn6;
    private JButton toSortBtn7;
    private JButton toSortBtn8;
    private JPanel sortGradesPanel;
    private JButton toSubjectsBtn9;
    private JButton toSortBtn9;
    private JButton toChangeCourseBtn9;
    private JButton toEditGradesBtn9;
    private JButton toGradesBtn9;
    private JButton clickToRemoveABtn;
    private JButton clickToEditABtn;
    private JButton clickToAddABtn;
    private JComboBox<String> yearCB;
    private JButton addUpdateBtn;
    private JTextField courseTitleTF;
    private JTextField unitsTF;
    private JComboBox<String> termCB;
    private JTextField courseNoTF;
    private JTextField addProblemTF;
    private JComboBox<String> editYearCB;
    private JComboBox<String> editCourseNoCB;
    private JComboBox<String> editTermCB;
    private JTextField editCourseNoTF;
    private JTextField editCourseTitleTF;
    private JTextField editUnitsTF;
    private JTextField editCourseProblemTF;
    private JButton editUpdateBtn;
    private JComboBox<String> removeYearCB;
    private JComboBox<String> removeCourseNoCB;
    private JComboBox<String> removeTermCB;
    private JTextField currCourseTitleTF;
    private JTextField curUnitsTF;
    private JButton removeUpdateBtn;
    private JTextField removeProblemTF;
    private JComboBox<String> editGYearCB;
    private JComboBox<String> editGTermCB;
    private JComboBox<String> editGCourseNoCB;
    private JTextField editGradesTF;
    private JTextField editGCourseTitleTF;
    private JTextField editGProblemTF;
    private JButton editGUpdateBtn;
    private JTable sortGTable;
    private JTextField removeCourseTitleTF;

    private toSubjectBtnHandler toSubjectHandler;
    private toGradesBtnHandler toGradesHandler;
    private toEditGradesBtnHandler toEditGradesHandler;
    private toChangeCourseBtnHandler toChangeCourseHandler;
    private toSortGradesBtnHandler toSortHandler;
    private CardLayout cl = new CardLayout();
    private String fileName;
    private String problemDisplayer;
    private ArrayList<Course> listOfCourses = new ArrayList<>();
    List<Course> filteredCourses = listOfCourses;

    public static void main(String[] args) {
        GUI program;
        try {
            program = new GUI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public GUI() {

        /**
         * CODE FOR GET FILE MENU
         */
        continueButton.addActionListener(e -> {
            fileName = fileNameTF.getText();
            if (fileName.isEmpty()) {
                problemDisplayer = "Make sure you have entered the file name";
            } else {
                try {
                    listOfCourses = readDataFileIntoList(fileName);
                    problemDisplayer = "";
                } catch (FileNotFoundException ex1) {
                    problemDisplayer = fileName + " cannot be found.";
                } catch (IOException ex2) {
                    problemDisplayer = "There seems to be a problem with you input/output device";
                }
            }
            if (problemDisplayer.equalsIgnoreCase("")) {
                cl.show(mainPanel, "2");
            }
            else {
                fileNameOutputTF.setText(problemDisplayer);
            }
        });


        /*
         * code for filePanel/getting the file name
         */

        mainPanel.setLayout(cl);
        mainPanel.add(filePanel, "1");
        mainPanel.add(homePanel, "2");
        mainPanel.add(showSubjectsPanel, "3");
        mainPanel.add(showGradesPanel, "4");
        mainPanel.add(editGradesPanel, "5");
        mainPanel.add(changeCoursePanel, "6");
        mainPanel.add(addCoursePanel,"7");
        mainPanel.add(editCoursePanel, "8");
        mainPanel.add(removeCoursePanel, "9");
        mainPanel.add(sortGradesPanel, "10");

        cl.show(mainPanel, "1");

        /**
         * CODE FOR EDIT GRADES
         */
        editGYearCB.addItem("1 - First");
        editGYearCB.addItem("2 - Second");
        editGYearCB.addItem("3 - Third");
        editGYearCB.addItem("4 - Fourth");

        editGTermCB.addItem("1 - First");
        editGTermCB.addItem("2 - Second");
        editGTermCB.addItem("3 - Short");

        filterCourseNoCBHandlers2 editCourseNoCBHandler = new filterCourseNoCBHandlers2();
        editGYearCB.addActionListener(editCourseNoCBHandler);
        editGTermCB.addActionListener(editCourseNoCBHandler);

        editGCourseNoCB.addActionListener(e -> {
            String courseNoKey = "";
            try {
                courseNoKey = Objects.requireNonNull(editGCourseNoCB.getSelectedItem()).toString();
            } catch (NullPointerException ex){}
            if (!courseNoKey.equalsIgnoreCase("")) {
                for (int i = 0; i < filteredCourses.size(); i++)
                {
                    Course courseNos = filteredCourses.get(i);
                    if (courseNoKey.equals(courseNos.getCourseCode()))
                    {
                        String courseTitle = filteredCourses.get(i).getCourseName();
                        editGCourseTitleTF.setText(courseTitle);
                    }
                }
            }
        });

        editGUpdateBtn.addActionListener(e ->{

            int grade = 0;
            int courseIndex = 0;
            int oldGrade = 0;
            int i = 0;
            try {
                String gradeString = editGradesTF.getText();
                if (gradeString.equals("")){
                    problemDisplayer = "Make sure you have entered a grade.";
                }
                grade = Integer.parseInt(gradeString);
                if (grade < 65 || grade > 99) {
                    problemDisplayer = "Grade should only be from 65 to 99";
                } else
                    problemDisplayer = "";
            } catch (NumberFormatException ex1) {
                problemDisplayer = "Entered grade is not cannot be parsed.";
            }

            String courseNoKey = "";
            try {
                courseNoKey = Objects.requireNonNull(editGCourseNoCB.getSelectedItem()).toString();
            } catch (NullPointerException ex){}
            if (!courseNoKey.equalsIgnoreCase("")) {
                for (i = 0; i < filteredCourses.size(); i++)
                {
                    Course courseNos = filteredCourses.get(i);
                    if (courseNoKey.equals(courseNos.getCourseCode()))
                    {
                        courseIndex = i;
                        oldGrade = filteredCourses.get(i).getGrades();
                        filteredCourses.get(i).setGrades(grade);
                    }
                }
            }

            if (problemDisplayer.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Grades have successfully updated." + "\nYear: " +
                        yearInWord(filteredCourses.get(courseIndex).getYear()) + "\nTerm: " + termInWord(filteredCourses.get(courseIndex).getTerm()) +
                        "\nCourse No.: " + filteredCourses.get(courseIndex).getCourseCode() + "\nCourse Title: " + filteredCourses.get(courseIndex).getCourseName()
                        + "\nUnits: " + filteredCourses.get(courseIndex).getUnits() + "\nOld Grade: " + oldGrade + "\nUpdated Grade: " + grade);
            }
            else {
                editGProblemTF.setText(problemDisplayer);
            }
            editGradesTF.setText("");
        });


        /*
         * add button handlers to every toSubject button
         */
        toSubjectHandler = new toSubjectBtnHandler();
        toSubjectsBtn1.addActionListener(toSubjectHandler);
        toSubjectsBtn2.addActionListener(toSubjectHandler);
        toSubjectsBtn3.addActionListener(toSubjectHandler);
        toSubjectsBtn4.addActionListener(toSubjectHandler);
        toSubjectsBtn5.addActionListener(toSubjectHandler);
        toSubjectsBtn6.addActionListener(toSubjectHandler);
        toSubjectsBtn7.addActionListener(toSubjectHandler);
        toSubjectsBtn8.addActionListener(toSubjectHandler);
        toSubjectsBtn9.addActionListener(toSubjectHandler);

        /*
         * add button handlers to every toGrades button
         */
        toGradesHandler = new toGradesBtnHandler();
        toGradesBtn1.addActionListener(toGradesHandler);
        toGradesBtn2.addActionListener(toGradesHandler);
        toGradesBtn3.addActionListener(toGradesHandler);
        toGradesBtn4.addActionListener(toGradesHandler);
        toGradesBtn5.addActionListener(toGradesHandler);
        toGradesBtn6.addActionListener(toGradesHandler);
        toGradesBtn7.addActionListener(toGradesHandler);
        toGradesBtn8.addActionListener(toGradesHandler);
        toGradesBtn9.addActionListener(toGradesHandler);

        /*
         * add button handlers to every toEditGrades button
         */
        toEditGradesHandler = new toEditGradesBtnHandler();
        toEditGradesBtn1.addActionListener(toEditGradesHandler);
        toEditGradesBtn2.addActionListener(toEditGradesHandler);
        toEditGradesBtn3.addActionListener(toEditGradesHandler);
        toEditGradesBtn4.addActionListener(toEditGradesHandler);
        toEditGradesBtn5.addActionListener(toEditGradesHandler);
        toEditGradesBtn6.addActionListener(toEditGradesHandler);
        toEditGradesBtn7.addActionListener(toEditGradesHandler);
        toEditGradesBtn8.addActionListener(toEditGradesHandler);
        toEditGradesBtn9.addActionListener(toEditGradesHandler);

        /*
         * add button handlers to every toChangeCourse button
         */
        toChangeCourseHandler = new toChangeCourseBtnHandler();
        toChangeCourseBtn1.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn2.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn3.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn4.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn5.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn6.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn7.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn8.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn9.addActionListener(toChangeCourseHandler);

        /*
         * add button handlers to every toSort buttons
         */
        toSortHandler = new toSortGradesBtnHandler();
        toSortBtn1.addActionListener(toSortHandler);
        toSortBtn2.addActionListener(toSortHandler);
        toSortBtn3.addActionListener(toSortHandler);
        toSortBtn4.addActionListener(toSortHandler);
        toSortBtn5.addActionListener(toSortHandler);
        toSortBtn6.addActionListener(toSortHandler);
        toSortBtn7.addActionListener(toSortHandler);
        toSortBtn8.addActionListener(toSortHandler);
        toSortBtn9.addActionListener(toSortHandler);

        clickToAddABtn.addActionListener(e -> cl.show(mainPanel, "7"));
        clickToEditABtn.addActionListener(e-> cl.show(mainPanel, "8"));
        clickToRemoveABtn.addActionListener(e -> cl.show(mainPanel, "9"));


        /**
         * CODE FOR ADD A COURSE
         */

        yearCB.addItem("1 - First");
        yearCB.addItem("2 - Second");
        yearCB.addItem("3 - Third");
        yearCB.addItem("4 - Fourth");

        termCB.addItem("1 - First");
        termCB.addItem("2 - Second");
        termCB.addItem("3 - Short");

        addUpdateBtn.addActionListener(e -> {
            int year = yearCB.getSelectedIndex() + 1;
            int term = termCB.getSelectedIndex() + 1;

            /*
             * code to read units
             */
            int units = 1;
            try {
                units = Integer.parseInt(unitsTF.getText());
                if (units < 1 || units > 12) {
                    problemDisplayer = "Make sure that the units is from 1-12.";
                } else
                    problemDisplayer = "";
            } catch (NumberFormatException ex1) {
                problemDisplayer = "Make sure that the value for units is a number";
            }

            /*
             * code to read course title
             */
            String courseTitle = courseTitleTF.getText();
            if (courseTitle.isEmpty()){
                problemDisplayer = "Make sure you have entered a course title.";
            }

            /*
             * code to read course code
             */
            String courseNo = courseNoTF.getText();
            if (courseNo.isEmpty()){
                problemDisplayer = "Make sure you have entered a course number.";
            }

            Course addedCourse = new Course(year,term,courseNo, courseTitle, units, 0);

            if (problemDisplayer.isEmpty()) {
                // Save the course to another CSV file
                String outputFileName= "addedCourse.csv";
                try{
                    saveCourseToCSV(addedCourse, outputFileName);
                    JOptionPane.showMessageDialog(null, "Course has been successfully added to 'addedCourse.csv'." + "\nYear: " +
                            yearInWord(addedCourse.getYear()) + "\nTerm: " + termInWord(addedCourse.getTerm()) + "\nCourse No.: " + addedCourse.getCourseCode()
                            + "\nCourse Title: " + addedCourse.getCourseName() + "\nUnits: " + addedCourse.getUnits());
                }catch (IOException ex){
                    problemDisplayer= "An error occurred while saving the course.";
                    JOptionPane.showMessageDialog(null, problemDisplayer);
                }
            } else {
                addProblemTF.setText(problemDisplayer);
            }
            courseNoTF.setText("");
            courseTitleTF.setText("");
            unitsTF.setText("");
        });

        /**
         * CODE FOR EDIT A COURSE
         */
        editYearCB.addItem("1 - First");
        editYearCB.addItem("2 - Second");
        editYearCB.addItem("3 - Third");
        editYearCB.addItem("4 - Fourth");

        editTermCB.addItem("1 - First");
        editTermCB.addItem("2 - Second");
        editTermCB.addItem("3 - Short");

        filterCourseNoCBHandlers filterCBHandler = new filterCourseNoCBHandlers();
        editYearCB.addActionListener(filterCBHandler);
        editTermCB.addActionListener(filterCBHandler);

        editCourseNoCB.addActionListener(e -> {
            String courseNoKey = "";
            try {
                courseNoKey = Objects.requireNonNull(editCourseNoCB.getSelectedItem()).toString();
            } catch (NullPointerException ex){}
            if (!courseNoKey.equalsIgnoreCase("")) {
                for (int i = 0; i < filteredCourses.size(); i++)
                {
                    Course courseNos = filteredCourses.get(i);
                    if (courseNoKey.equals(courseNos.getCourseCode()))
                    {
                        String courseTitle = filteredCourses.get(i).getCourseName();
                        int units = filteredCourses.get(i).getUnits();
                        currCourseTitleTF.setText(courseTitle);
                        curUnitsTF.setText(units + "");
                    }
                }
            }
        });

        editUpdateBtn.addActionListener(e -> {
            int year = yearCB.getSelectedIndex() + 1;
            int term = termCB.getSelectedIndex() + 1;

            String unitsInString = editUnitsTF.getText();
            String courseNo = editCourseNoTF.getText();
            String courseTitle = editCourseTitleTF.getText();

            if (unitsInString.equals("") && courseNo.equals("") && courseTitle.equals("")){
                problemDisplayer = "Make sure you have added something to edit.";
            }

            /*
             * code to read units
             */
            int units = 1;
            if (!unitsInString.equals("")) {
                try {
                    units = Integer.parseInt(editUnitsTF.getText());
                    if (units < 1 || units > 12) {
                        problemDisplayer = "Make sure that the units is from 1-12.";
                    } else
                        problemDisplayer = "";
                } catch (NumberFormatException ex1) {
                    problemDisplayer = "Make sure that the value for units is a number";
                }
            }

            Course addedCourse = new Course(year,term,courseNo, courseTitle, units, 0);

            if (problemDisplayer.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Course has been successfully edited." + "\nYear: " +
                        yearInWord(addedCourse.getYear()) + "\nTerm: " + termInWord(addedCourse.getTerm()) + "\nCourse No.: " + addedCourse.getCourseCode()
                        + "\nCourse Title: " + addedCourse.getCourseName() + "\nUnits: " + addedCourse.getUnits());
            }
            else {
                editCourseProblemTF.setText(problemDisplayer);
            }
            editCourseNoTF.setText("");
            editCourseTitleTF.setText("");
            editUnitsTF.setText("");
            curUnitsTF.setText("");
            currCourseTitleTF.setText("");
        });

        /**
         * CODE FOR REMOVE A COURSE
         */

        removeYearCB.addItem("1 - First");
        removeYearCB.addItem("2 - Second");
        removeYearCB.addItem("3 - Third");
        removeYearCB.addItem("4 - Fourth");

        removeTermCB.addItem("1 - First");
        removeTermCB.addItem("2 - Second");
        removeTermCB.addItem("3 - Short");

        filterCourseNoCBHandlers1 removeCBHandlers = new filterCourseNoCBHandlers1();
        removeYearCB.addActionListener(removeCBHandlers);
        removeTermCB.addActionListener(removeCBHandlers);

        removeCourseNoCB.addActionListener(e -> {
            String courseNoKey = "";
            try {
                courseNoKey = Objects.requireNonNull(editCourseNoCB.getSelectedItem()).toString();
            } catch (NullPointerException ex){}
            if (!courseNoKey.equalsIgnoreCase("")) {
                for (int i = 0; i < filteredCourses.size(); i++)
                {
                    Course courseNos = filteredCourses.get(i);
                    if (courseNoKey.equals(courseNos.getCourseCode()))
                    {
                        String courseTitle = filteredCourses.get(i).getCourseName();
                        removeCourseTitleTF.setText(courseTitle);
                    }
                }
            }
        });

        removeUpdateBtn.addActionListener(e -> {
            /**
             * JOPTION PANE FOR REMOVE COURSE
             */
        });

        /**
         * CODE FOR SORT GRADES
         */

        setContentPane(mainPanel);
        pack();
        setTitle("BSCS Curriculum Checklist");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public class toSubjectBtnHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cl.show(mainPanel, "3");
        }
    }

    public class toGradesBtnHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cl.show(mainPanel, "4");
        }
    }

    public class toEditGradesBtnHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cl.show(mainPanel, "5");
        }
    }

    public class toChangeCourseBtnHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cl.show(mainPanel, "6");
        }
    }

    public class toSortGradesBtnHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cl.show(mainPanel, "10");
        }
    }

    public class filterCourseNoCBHandlers implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int editYear = editYearCB.getSelectedIndex() + 1;
            int editTerm = editTermCB.getSelectedIndex() + 1;

            filteredCourses = listOfCourses.stream().filter(c -> c.getYear() == editYear && c.getTerm() == editTerm).collect(Collectors.toList());
            editCourseNoCB.removeAllItems();
            for (int index = 0; index < filteredCourses.size(); index++) {
                editCourseNoCB.addItem(filteredCourses.get(index).getCourseCode());
            }
        }
    }

    public class filterCourseNoCBHandlers1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int removeYear = removeYearCB.getSelectedIndex() + 1;
            int removeTerm = removeTermCB.getSelectedIndex() + 1;

            filteredCourses = listOfCourses.stream().filter(c -> c.getYear() == removeYear && c.getTerm() == removeTerm).collect(Collectors.toList());
            removeCourseNoCB.removeAllItems();
            for (int index = 0; index < filteredCourses.size(); index++) {
                removeCourseNoCB.addItem(filteredCourses.get(index).getCourseCode());
            }
        }
    }

    public class filterCourseNoCBHandlers2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int editGYear = editGYearCB.getSelectedIndex() + 1;
            int editGTerm = editGTermCB.getSelectedIndex() + 1;

            filteredCourses = listOfCourses.stream().filter(c -> c.getYear() == editGYear && c.getTerm() == editGTerm).collect(Collectors.toList());
            editGCourseNoCB.removeAllItems();
            for (int index = 0; index < filteredCourses.size(); index++) {
                editGCourseNoCB.addItem(filteredCourses.get(index).getCourseCode());
            }
        }
    }

    private ArrayList<Course> readDataFileIntoList(String filename) throws FileNotFoundException, IOException {
        ArrayList<Course> courseList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)",-1);

            String strContent = data[3];
            String strPattern = "\"([^\"]*)\"";
            String courseName = "";

            if (strContent.charAt(0) == '\"') {
                Pattern pattern = Pattern.compile(strPattern);
                Matcher matcher = pattern.matcher(strContent);
                while (matcher.find()) {
                    courseName = matcher.group(1);
                }
            } else {
                courseName = strContent;
            }

            int grade;
            if (data[5].equals("")) {
                grade = 0;
            } else
                grade = Integer.parseInt(data[5]);

            Course course = new Course(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2], courseName, Integer.parseInt(data[4]),
                    grade);
            courseList.add(course);
        }
        reader.close();
        return courseList;
    }

    static Scanner kbd = new Scanner(System.in);
    public void showChecklistPerTerm(ArrayList<Course> courses, int y, int t){
        for (byte year = 1; year <=y; year++){
            for (byte term=1; term <=t; term++){
                System.out.println("------------------------------------------------------------------------------------------------------");
                System.out.println("Year = " + yearInWord(year) + " Term = " + termInWord(term));
                System.out.printf("%-13s%-55s%-6s%n","Course No", "Descriptive title", "Units");
                System.out.println("------------------------------------------------------------------------------------------------------");
                for (int index=0; index<courses.size(); index++){
                    if(courses.get(index).getYear()==year && courses.get(index).getTerm()==term)
                        System.out.printf("%-13s%-55s%-5.1f%n",
                                courses.get(index).getCourseCode(),courses.get(index).getCourseName(),courses.get(index).getUnits());
                }
                System.out.println();
                System.out.println("Press enter key to see courses for the next term.");
                kbd.nextLine();
            }
        }
    }

    public static String yearInWord(int year){
        String result = "";

        switch (year) {
            case 1:
                result = "First";
                break;
            case 2:
                result = "Second";
                break;
            case 3:
                result = "Third";
                break;
            case 4:
                result = "Fourth";
        }
        return result;
    }

    public static String termInWord(int term){
        String result = "";

        switch (term) {
            case 1:
                result = "First";
                break;
            case 2:
                result = "Second";
                break;
            case 3:
                result = "Short";
                break;
        }
        return result;
    }

    private void saveCourseToCSV(Course course, String fileName) throws IOException{
        try(PrintWriter writer= new PrintWriter(new FileWriter(fileName, true))){
            writer.println(course.getYear() + " , " + course.getTerm() + " , " + course.getCourseCode() + " , " + course.getUnits() + " , " + course.getGrades());
        }
    }

    private void editAndSaveCourseToCSV(int rowIndex, Course course, String fileName) throws IOException{
        List<String> lines= Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        lines.set(rowIndex, course.getYear() + " , " + course.getCourseCode() + " , " + course.getCourseName() + " , " + course.getUnits() + " , " + course.getGrades());
        Files.write(Paths.get(fileName) , lines , StandardCharsets.UTF_8);
    }



}

