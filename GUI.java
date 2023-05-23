package prog2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
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
    private JComboBox<String> addYearCB;
    private JButton addUpdateBtn;
    private JTextField addCourseTitleTF;
    private JTextField addUnitsTF;
    private JComboBox<String> addTermCB;
    private JTextField addCourseNoTF;
    private JTextField addProblemTF;
    private JComboBox<String> editYearCB;
    private JComboBox<String> editCourseNoCB;
    private JComboBox<String> editTermCB;
    private JTextField editCourseNoTF;
    private JTextField editCourseTitleTF;
    private JTextField editUnitsTF;
    private JTextField editCourseProblemTF;
    private JButton editUpdateBtn;
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
    private JTable showSubjectsTable;
    private JTable showGradesTable;
    private JTable removeTable;
    private JComboBox sortingGradesCB;
    private JButton updateSortBtn;
    private JTable sortingTable;
    private JTextField addPreReqTF;
    private JTextField editPreReqTF;
    private final CardLayout cl = new CardLayout();
    private String fileName;
    private String problemDisplayer;
    private ArrayList<Course> listOfCourses = new ArrayList<>();
    private List<Course> filteredCourses = listOfCourses;

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
         * Add Button Handlers to every menu panel button
         */
        toSubjectBtnHandler toSubjectHandler = new toSubjectBtnHandler();
        toSubjectsBtn1.addActionListener(toSubjectHandler);
        toSubjectsBtn2.addActionListener(toSubjectHandler);
        toSubjectsBtn3.addActionListener(toSubjectHandler);
        toSubjectsBtn4.addActionListener(toSubjectHandler);
        toSubjectsBtn5.addActionListener(toSubjectHandler);
        toSubjectsBtn6.addActionListener(toSubjectHandler);
        toSubjectsBtn7.addActionListener(toSubjectHandler);
        toSubjectsBtn8.addActionListener(toSubjectHandler);
        toSubjectsBtn9.addActionListener(toSubjectHandler);

        toGradesBtnHandler toGradesHandler = new toGradesBtnHandler();
        toGradesBtn1.addActionListener(toGradesHandler);
        toGradesBtn2.addActionListener(toGradesHandler);
        toGradesBtn3.addActionListener(toGradesHandler);
        toGradesBtn4.addActionListener(toGradesHandler);
        toGradesBtn5.addActionListener(toGradesHandler);
        toGradesBtn6.addActionListener(toGradesHandler);
        toGradesBtn7.addActionListener(toGradesHandler);
        toGradesBtn8.addActionListener(toGradesHandler);
        toGradesBtn9.addActionListener(toGradesHandler);

        toEditGradesBtnHandler toEditGradesHandler = new toEditGradesBtnHandler();
        toEditGradesBtn1.addActionListener(toEditGradesHandler);
        toEditGradesBtn2.addActionListener(toEditGradesHandler);
        toEditGradesBtn3.addActionListener(toEditGradesHandler);
        toEditGradesBtn4.addActionListener(toEditGradesHandler);
        toEditGradesBtn5.addActionListener(toEditGradesHandler);
        toEditGradesBtn6.addActionListener(toEditGradesHandler);
        toEditGradesBtn7.addActionListener(toEditGradesHandler);
        toEditGradesBtn8.addActionListener(toEditGradesHandler);
        toEditGradesBtn9.addActionListener(toEditGradesHandler);

        toChangeCourseBtnHandler toChangeCourseHandler = new toChangeCourseBtnHandler();
        toChangeCourseBtn1.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn2.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn3.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn4.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn5.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn6.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn7.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn8.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn9.addActionListener(toChangeCourseHandler);

        toSortGradesBtnHandler toSortHandler = new toSortGradesBtnHandler();
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
        clickToEditABtn.addActionListener(e -> cl.show(mainPanel, "8"));
        clickToRemoveABtn.addActionListener(e -> {
            updateTable(removeTable, listOfCourses, 5);
            removeTable.setDefaultEditor(Object.class, null);
            cl.show(mainPanel, "9");
        });

        /**
         * Code for the get file panel
         */
        continueButton.addActionListener(e -> {
            fileName = fileNameTF.getText();
            if (fileName.isEmpty()) {
                problemDisplayer = "Make sure you have entered the file name";
            } else {
                // Use a case-sensitive file check
                FileSystem fileSystem = FileSystems.getDefault();
                Path path = fileSystem.getPath(fileName);
                File file = path.toFile();
                if (!file.exists()) {
                    problemDisplayer = fileName + " does not exist.";
                } else {
                    try {
                        listOfCourses = readDataFileIntoList(fileName);
                        Collections.sort(listOfCourses);
                        problemDisplayer = "";
                    } catch (FileNotFoundException ex1) {
                        problemDisplayer = fileName + " cannot be found.";
                    } catch (IOException ex2) {
                        problemDisplayer = "There seems to be a problem with you input/output device";
                    }
                }
                if (problemDisplayer.equalsIgnoreCase("")) {
                    cl.show(mainPanel, "2");
                } else {
                    fileNameOutputTF.setText(problemDisplayer);
                }
            }
        });


        /**
         * Code for edit grades panel
         */
        setYearAndTermCB(editGYearCB, editGTermCB);

        filterEditGradesCourseNoCBHandlers editCourseNoCBHandler = new filterEditGradesCourseNoCBHandlers();
        editGYearCB.addActionListener(editCourseNoCBHandler);
        editGTermCB.addActionListener(editCourseNoCBHandler);

        editGCourseNoCB.addActionListener(e -> {
            String courseNoKey = "";

            if (editGCourseNoCB.getSelectedItem() != null) {
                courseNoKey = (editGCourseNoCB.getSelectedItem()).toString();
            }

            if (!courseNoKey.isEmpty()) {
                int index = findCourseIndex(filteredCourses, courseNoKey);
                editGCourseTitleTF.setText(filteredCourses.get(index).getCourseName());
            }
        });

        editGUpdateBtn.addActionListener(e -> {
            int grade = 0;
            int courseIndex = 0;
            int oldGrade = 0;

            // READ GRADE
            try {
                String gradeString = editGradesTF.getText();
                if (gradeString.equals("")) {
                    problemDisplayer = "Make sure you have entered a grade.";
                }
                if (Integer.parseInt(gradeString) < 65 || Integer.parseInt(gradeString) > 99) {
                    problemDisplayer = "Grade should only be from 65 to 99";
                } else {
                    problemDisplayer = "";
                    grade = Integer.parseInt(gradeString);
                }
            } catch (NumberFormatException ex1) {
                problemDisplayer = "Entered grade is not cannot be parsed.";
            } //end of try-catch method

            String courseNoKey = "";

            if (editGCourseNoCB.getSelectedItem() != null) {
                courseNoKey = (editGCourseNoCB.getSelectedItem().toString());
            }

            if (!courseNoKey.isEmpty()) {
                courseIndex = findCourseIndex(listOfCourses, courseNoKey);
                System.out.println(courseIndex);
            }

            if (!listOfCourses.get(courseIndex).getPreRequisite().isEmpty()) { // IF MAY PREREQUISITE
                // GET PRE-REQUISITES
                String[] preRequisitesArray = new String[0];
                List<String> preReqList = new ArrayList<>();
                List<Course> courseList;

                if (listOfCourses.get(courseIndex).getPreRequisite().charAt(0) == '3'){
                    courseList = listOfCourses.stream().filter(c -> c.getYear() == 1 || c.getYear() == 2).toList();
                    for (int x =0; x<courseList.size(); x++){
                        preReqList.add(courseList.get(x).getCourseCode());
                    }
                } else if (listOfCourses.get(courseIndex).getPreRequisite().charAt(0) == '4') {
                     courseList = listOfCourses.stream().filter(c -> c.getYear() == 1 || c.getYear() == 2 || c.getYear() == 3).toList();
                     for (int x = 0; x<courseList.size(); x++){
                         preReqList.add(courseList.get(x).getCourseCode());
                     }
                }

                // GET GRADES OF PRE-REQUISITES AND COMPARE
                for (int i = 0; i < preReqList.size(); i++) {
                    int preReqIndex = findCourseIndex(listOfCourses, preReqList.get(i).toString());
                    if (listOfCourses.get(preReqIndex).getGrades() == 0) {
                        problemDisplayer = "Pre-requisite course has not been taken";
                    } else if (listOfCourses.get(preReqIndex).getGrades() < 75) {
                        problemDisplayer = "Pre-requisite course has a failing grade";
                    }
                }
            }

            if (problemDisplayer.equalsIgnoreCase("")) {
                editGProblemTF.setText("");
                listOfCourses.get(courseIndex).setGrades(grade);
                JOptionPane.showMessageDialog(null, "Grades have successfully updated." + "\nYear: " +
                        yearInWord(listOfCourses.get(courseIndex).getYear()) + "\nTerm: " + termInWord(listOfCourses.get(courseIndex).getTerm()) +
                        "\nCourse No.: " + listOfCourses.get(courseIndex).getCourseCode() + "\nCourse Title: " + listOfCourses.get(courseIndex).getCourseName()
                        + "\nUnits: " + listOfCourses.get(courseIndex).getUnits() + "\nInitial Grade: " + gradeRemarks(oldGrade) + "\nUpdated Grade: " + grade);
            } else {
                editGProblemTF.setText(problemDisplayer);
                editGradesTF.setText("");
            }

            updateGradeInCSV(fileName, listOfCourses.get(courseIndex).getCourseCode(), grade);
        });

        /**
         * Code for add a course panel
         */
        setYearAndTermCB(addYearCB, addTermCB);
        addUpdateBtn.addActionListener(e -> {
            // read year and term
            int year = addYearCB.getSelectedIndex() + 1;
            int term = addTermCB.getSelectedIndex() + 1;

            // read units
            int units = 1;
            try {
                units = Integer.parseInt(addUnitsTF.getText());
                if (units < 1 || units > 12)
                    problemDisplayer = "Make sure that the units is from 1-12.";
            } catch (NumberFormatException ex1) {
                problemDisplayer = "Make sure that the value for units is a number";
            }

            // read course title
            String courseTitle = addCourseTitleTF.getText();
            if (courseTitle.equalsIgnoreCase("")) {
                problemDisplayer = "Make sure you have entered a course title.";
            }

            // read course number
            String courseNo = addCourseNoTF.getText();
            if (courseNo.equalsIgnoreCase("")) {
                problemDisplayer = "Make sure you have entered a course number.";
            }

            String preReq = addPreReqTF.getText();
            if (findCourseIndex(listOfCourses, preReq) < 0){
                problemDisplayer = "Pre-requisite is not in the list of courses";
            }

            // create new course
            Course addedCourse = new Course(year, term, courseNo, courseTitle, units, 0, preReq);
            listOfCourses.add(addedCourse);
            Collections.sort(listOfCourses);

            if (problemDisplayer.isEmpty()) {
                addProblemTF.setText("");
                try {
                    saveCourseToCSV(addedCourse, fileName);
                } catch (IOException ex) {
                    problemDisplayer = "Course cannot be saved";
                }
                JOptionPane.showMessageDialog(null, "Course has been successfully added to " + fileName + "\nYear: " +
                        yearInWord(addedCourse.getYear()) + "\nTerm: " + termInWord(addedCourse.getTerm()) + "\nCourse No.: " + addedCourse.getCourseCode()
                        + "\nCourse Title: " + addedCourse.getCourseName() + "\nUnits: " + addedCourse.getUnits() + "\nPre-requisite: " + preRequisiteRemarks(preReq));
            } else {
                addProblemTF.setText(problemDisplayer);
                addCourseNoTF.setText("");
                addCourseTitleTF.setText("");
                addUnitsTF.setText("");
                problemDisplayer = "";
            }
        });

        /**
         * Code for edit a course panel
         */
        setYearAndTermCB(editYearCB, editTermCB);

        filterEditCourseCourseNoCBHandlers filterCBHandler = new filterEditCourseCourseNoCBHandlers();
        editYearCB.addActionListener(filterCBHandler);
        editTermCB.addActionListener(filterCBHandler);

        editCourseNoCB.addActionListener(e -> {
            String courseNoKey = "";

            if (editCourseNoCB.getSelectedItem() != null) {
                courseNoKey = (editCourseNoCB.getSelectedItem()).toString();
            }

            if (!courseNoKey.equalsIgnoreCase("")) {
                int index = findCourseIndex(filteredCourses, courseNoKey);
                currCourseTitleTF.setText(filteredCourses.get(index).getCourseName());
                curUnitsTF.setText(filteredCourses.get(index).getUnits() + "");
            }
        });

        editUpdateBtn.addActionListener(e -> {
            String courseNoKey = "";

            if (editCourseNoCB.getSelectedItem() != null) {
                courseNoKey = (editCourseNoCB.getSelectedItem()).toString();
            }

            int index = findCourseIndex(listOfCourses, courseNoKey);
            String unitsInString = editUnitsTF.getText();
            String courseNo = editCourseNoTF.getText();
            String courseTitle = editCourseTitleTF.getText();
            String preReq = editPreReqTF.getText();

            if (unitsInString.isEmpty() && courseNo.isEmpty() && courseTitle.isEmpty() && preReq.isEmpty()) {
                problemDisplayer = "Make sure you have added something to edit.";
            }

            int units;
            if (!unitsInString.isEmpty()) {
                try {
                    units = Integer.parseInt(editUnitsTF.getText());
                    if (units < 1 || units > 12) {
                        problemDisplayer = "Make sure that the units is from 1-12.";
                    } else {
                        listOfCourses.get(index).setUnits(units);
                        problemDisplayer = "";
                    }
                } catch (NumberFormatException ex1) {
                    problemDisplayer = "Make sure that the value for units is a number";
                }
            }

            if (!courseTitle.isEmpty()) {
                listOfCourses.get(index).setCourseName(courseTitle);
            }

            if (!courseNo.isEmpty()) {
                listOfCourses.get(index).setCourseCode(courseNo);
            }

            if (!preReq.isEmpty()){
                if (findCourseIndex(listOfCourses, preReq) < 0){
                    problemDisplayer = "Pre-requisite is not in the list of courses";
                } else {
                    listOfCourses.get(index).setPreRequisite(preReq);
                }
            }

            try {
                editAndSaveCourseToCSV(index, listOfCourses.get(index), fileName);
            } catch (IOException ex1) {
                problemDisplayer = "Problem with saving the file";
            }

            if (problemDisplayer.equalsIgnoreCase("")) {
                editCourseProblemTF.setText("");
                JOptionPane.showMessageDialog(null, "Course has been successfully edited." + "\nYear: " +
                        yearInWord(listOfCourses.get(index).getYear()) + "\nTerm: " + termInWord(listOfCourses.get(index).getTerm()) +
                        "\nCourse No.: " + listOfCourses.get(index).getCourseCode() + "\nCourse Title: " + listOfCourses.get(index).getCourseName() +
                        "\nUnits: " + listOfCourses.get(index).getUnits() + "\nPre-requisite: " + listOfCourses.get(index).getPreRequisite());
            } else {
                editCourseProblemTF.setText(problemDisplayer);
                editCourseNoTF.setText("");
                editCourseTitleTF.setText("");
                editUnitsTF.setText("");
                curUnitsTF.setText("");
                currCourseTitleTF.setText("");
                problemDisplayer = "";
            }
        });

        /**
         * Code for remove a course panel
         */
        removeUpdateBtn.addActionListener(e -> {
            int selectedRow = removeTable.getSelectedRow();
            if (selectedRow != -1) {
                Course removedCourse = listOfCourses.get(selectedRow);

                // Remove the course from the list
                listOfCourses.remove(removedCourse);

                // Save the updated data to another CSV file
                try {
                    save(fileName, listOfCourses);
                    JOptionPane.showMessageDialog(null, " Courses have been successfully removed. ");
                } catch (IOException ex) {
                    problemDisplayer = " An error occurred while saving the updated course list.";
                    JOptionPane.showMessageDialog(null, problemDisplayer);
                }

                // Update the table
                updateTable(removeTable, listOfCourses, 5);

                // Clear the selected row and text fields
                removeTable.clearSelection();
                currCourseTitleTF.setText(" ");
                curUnitsTF.setText(" ");
                removeProblemTF.setText(" ");
            } else {
                problemDisplayer = " Please select a course to remove.";
                removeProblemTF.setText(problemDisplayer);
            }

        });


        /**
         * CODE FOR SORT GRADES
         */

        updateTable(sortingTable, listOfCourses, 6);
        setSortingGradesCB(sortingGradesCB);
        updateSortBtn.addActionListener(e -> {
            String typeOfSort = "";

            if (sortingGradesCB.getSelectedItem() != null) {
                typeOfSort = sortingGradesCB.getSelectedItem().toString();
            }

            if (typeOfSort.equalsIgnoreCase("Ascending")) {
                ArrayList<Course> sortedList = sortCourseByGrades(listOfCourses, 1);
                updateTable(sortingTable,sortedList,6);
            } else if (typeOfSort.equalsIgnoreCase("Descending")) {
                ArrayList<Course> sortedList = sortCourseByGrades(listOfCourses, 2);
                updateTable(sortingTable,sortedList,6);
            }
        });


        /**
         * Add panels to main panel
         */
        mainPanel.setLayout(cl);
        mainPanel.add(filePanel, "1");
        mainPanel.add(homePanel, "2");
        mainPanel.add(showSubjectsPanel, "3");
        mainPanel.add(showGradesPanel, "4");
        mainPanel.add(editGradesPanel, "5");
        mainPanel.add(changeCoursePanel, "6");
        mainPanel.add(addCoursePanel, "7");
        mainPanel.add(editCoursePanel, "8");
        mainPanel.add(removeCoursePanel, "9");
        mainPanel.add(sortGradesPanel, "10");
        cl.show(mainPanel, "1");

        setContentPane(mainPanel);
        pack();
        setTitle("BSCS Curriculum Checklist");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    /**
     * Method that reads a data file (.csv file) into an ArrayList
     */
    private ArrayList<Course> readDataFileIntoList(String filename) throws IOException {
        ArrayList<Course> courseList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

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

            String strContent1 = data[6];
            String preReq = "";

            if (strContent1.charAt(0) == '\"') {
                Pattern pattern = Pattern.compile(strPattern);
                Matcher matcher = pattern.matcher(strContent1);
                while (matcher.find()) {
                    preReq = matcher.group(1);
                }
            } else {
                preReq = strContent1;
            }

            int grade;
            if (data[5].equals("")) {
                grade = 0;
            } else
                grade = Integer.parseInt(data[5]);

            Course course = new Course(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2], courseName, Integer.parseInt(data[4]),
                    grade, preReq);
            courseList.add(course);
        }
        reader.close();
        return courseList;
    }

    /**
     *
     */
    public String[] preRequisitesInList(String preRequisites){
        String[] preReqsArray = preRequisites.split(",");
        return preReqsArray;
    }

    /**
     * Button Handler class for the toSubject Buttons
     */
    public class toSubjectBtnHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            updateTable(showSubjectsTable, listOfCourses,5);
            editGradesTF.setText("");
            addCourseNoTF.setText("");
            addCourseTitleTF.setText("");
            addUnitsTF.setText("");
            editCourseNoTF.setText("");
            editCourseTitleTF.setText("");
            editUnitsTF.setText("");
            cl.show(mainPanel, "3");
        }
    }

    /**
     * Button Handler class for the toGrades Buttons
     */
    public class toGradesBtnHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            updateTable(showGradesTable,listOfCourses, 6);
            editGradesTF.setText("");
            addCourseNoTF.setText("");
            addCourseTitleTF.setText("");
            addUnitsTF.setText("");
            editCourseNoTF.setText("");
            editCourseTitleTF.setText("");
            editUnitsTF.setText("");
            cl.show(mainPanel, "4");
        }
    }

    /**
     * Button Handler class for the toEditGrades Buttons
     */
    public class toEditGradesBtnHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            editGradesTF.setText("");
            addCourseNoTF.setText("");
            addCourseTitleTF.setText("");
            addUnitsTF.setText("");
            editCourseNoTF.setText("");
            editCourseTitleTF.setText("");
            editUnitsTF.setText("");
            cl.show(mainPanel, "5");
        }
    }

    /**
     * Button Handler for the toChangeCourse Buttons
     */
    public class toChangeCourseBtnHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            editGradesTF.setText("");
            addCourseNoTF.setText("");
            addCourseTitleTF.setText("");
            addUnitsTF.setText("");
            editCourseNoTF.setText("");
            editCourseTitleTF.setText("");
            editUnitsTF.setText("");
            cl.show(mainPanel, "6");
        }
    }

    /**
     * Button Handlers class for the toSortGrades Buttons
     */
    public class toSortGradesBtnHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            editGradesTF.setText("");
            addCourseNoTF.setText("");
            addCourseTitleTF.setText("");
            addUnitsTF.setText("");
            editCourseNoTF.setText("");
            editCourseTitleTF.setText("");
            editUnitsTF.setText("");
            cl.show(mainPanel, "10");
        }
    }

    /**
     * Method that adds the items inside the year combo box and term combo box
     */
    private void setYearAndTermCB(JComboBox<String> yearCB, JComboBox<String> termCB) {
        yearCB.addItem("1 - First");
        yearCB.addItem("2 - Second");
        yearCB.addItem("3 - Third");
        yearCB.addItem("4 - Fourth");

        termCB.addItem("1 - First");
        termCB.addItem("2 - Second");
        termCB.addItem("3 - Short");
    }

    /**
     * Method that add the items inside the setSortingGrades combo box
     */
    private void setSortingGradesCB(JComboBox<String> sortingGradesCB){
        sortingGradesCB.addItem("Ascending");
        sortingGradesCB.addItem("Descending");
    }

    /**
     * Method that filters the course numbers according to the given year and term. This is for the
     * editGrades panel of buttons
     */
    public class filterEditGradesCourseNoCBHandlers implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int editGYear = editGYearCB.getSelectedIndex() + 1;
            int editGTerm = editGTermCB.getSelectedIndex() + 1;

            filteredCourses = listOfCourses.stream().filter(c -> c.getYear() == editGYear && c.getTerm() == editGTerm).collect(Collectors.toList());
            editGCourseNoCB.removeAllItems();
            for (Course course : filteredCourses) {
                editGCourseNoCB.addItem(course.getCourseCode());
            }
        }
    }

    /**
     * Method that filters the course numbers according to the given year and term. This is for the edit course
     * panel of buttons
     */
    public class filterEditCourseCourseNoCBHandlers implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int editYear = editYearCB.getSelectedIndex() + 1;
            int editTerm = editTermCB.getSelectedIndex() + 1;

            filteredCourses = listOfCourses.stream().filter(c -> c.getYear() == editYear && c.getTerm() == editTerm).collect(Collectors.toList());
            editCourseNoCB.removeAllItems();
            for (Course course : filteredCourses) {
                editCourseNoCB.addItem(course.getCourseCode());
            }
        }
    }

    /**
     * Method that returns the index of a courseNo in a list of courses
     */
    public int findCourseIndex(List<Course> courses, String courseNoKey) {
        for (int i = 0; i < courses.size(); i++) {
            Course courseNos = courses.get(i);
            if (courseNoKey.equals(courseNos.getCourseCode())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Static method that converts an int year into its corresponding String
     */
    public static String yearInWord(int year) {
        return switch (year) {
            case 1 -> "First";
            case 2 -> "Second";
            case 3 -> "Third";
            case 4 -> "Fourth";
            default -> "";
        };
    }

    /**
     * Static method that converts an int term into its corresponding String
     */
    public static String termInWord(int term) {
        return switch (term) {
            case 1 -> "First";
            case 2 -> "Second";
            case 3 -> "Short";
            default -> "";
        };
    }

    /**
     * Method that appends a course to a data file (.csv file)
     */
    private void saveCourseToCSV(Course course, String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(course.getYear() + "," + course.getTerm() + "," + course.getCourseCode() + "," + "\"" +
                    course.getCourseName() + "\"" + "," + course.getUnits() + "," + course.getGrades() + "," + "\"" +
                    course.getPreRequisite() + "\"");
        }
    }

    /**
     * Method that saves all courses from an ArrayList to a data file (.csv file)
     */
    public void save(String fileName, ArrayList<Course> courses) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
        for (Course course : courses)
            pw.println(course.getYear() + "," + course.getTerm() + "," + course.getCourseCode() + "," + "\"" + course.getCourseName()
            + "\"" + "," + course.getUnits() + "," + "\"" + course.getPreRequisite() + "\"" );
        pw.close();
    }

    /**
     * Method that edits a line from a data file and saves the edited course
     */
    private void editAndSaveCourseToCSV(int rowIndex, Course course, String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        lines.set(rowIndex, course.getYear() + "," + course.getTerm() + "," + course.getCourseCode() + "," + "\"" + course.getCourseName() + "\"" + "," + course.getUnits() + "," + course.getGrades() + "," + "\"" + course.getPreRequisite() + "\"");
        Files.write(Paths.get(fileName), lines, StandardCharsets.UTF_8);
    }

    /**
     * Method that populates a JTable
     */
    private void updateTable(JTable table, ArrayList<Course> courses, int n) {
        Object[][] data = new Object[courses.size()][n];
        for (int row = 0; row < courses.size(); row++) {
            data[row][0] = yearInWord(courses.get(row).getYear());
            data[row][1] = termInWord(courses.get(row).getTerm());
            data[row][2] = courses.get(row).getCourseCode();
            data[row][3] = courses.get(row).getCourseName();
            data[row][4] = courses.get(row).getUnits();
            if (n == 6) {
                data[row][5] = gradeRemarks(courses.get(row).getGrades());
            }
        }

        if (n == 5){
            table.setModel(new DefaultTableModel(data, new String[]{"Year", "Term", "Course No.", "Course Title", "Units"}));
        } else
            table.setModel(new DefaultTableModel(data, new String[]{"Year", "Term", "Course No.", "Course Title", "Units", "Grades"}));
    }

    /**
     * Method that returns a remark if grade is equal to 0 (or the course has not been taken) else it returns the grade
     */
    private String gradeRemarks(int grade) {
        if (grade == 0) {
            return "Not yet taken";
        } else return grade + "";
    }

    /**
     * Method that sorts the courses in an ArrayList according to their grades in ascending or descending order
     */
    public static ArrayList<Course> sortCourseByGrades(ArrayList<Course> course, int type) {
        ArrayList<Course> sortedList = new ArrayList<>(course);

        if (type == 1){
            Collections.sort(sortedList, Comparator.comparingInt(Course::getGrades));
        }else if (type == 2){
            Collections.sort(sortedList, Comparator.comparingInt(Course::getGrades).reversed());
        }
        return sortedList;
    }

    /**
     * Method that updates the grade into the data file
     */
    private void updateGradeInCSV(String csvFilePath, String courseCodeToUpdate, int newGrade) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            StringBuilder updatedContent = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields[2].equals(courseCodeToUpdate)) {
                    fields[5] = String.valueOf(newGrade);
                }
                String updatedLine = String.join(",", fields);
                updatedContent.append(updatedLine).append("\n");
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
                writer.write(updatedContent.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end of updateGradeInCSV

    private String preRequisiteRemarks(String preRequisite){
        if (preRequisite.isEmpty()){
            return "No prerequisites";
        }
        else
            return preRequisite;
    }

    /**
     * Method that returns the pre-requisites in an array
     */
    private List<String> preRequisitesInList(List<Course> courseList, int index){
        String preRequisites = courseList.get(index).getPreRequisite();
        String[] preReqsArray = new String[1];
        if (preRequisites.contains(",")) {
            preReqsArray = preRequisites.split(",");
        } else
            preReqsArray[0] = preRequisites;
        List<String> preReqList = Arrays.asList(preReqsArray);
        return preReqList;
    }

}

