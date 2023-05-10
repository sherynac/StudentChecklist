package prog2;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUI extends JFrame{
    private JPanel mainPanel;
    private JPanel filePanel;
    private JPanel homePanel;
    private JTextField fileNameTF;
    private JTextField fileNameOutputTF;
    private JButton continueButton;
    private JButton toSubjectsBtn1;
    private JButton toGradesBtn1;
    private JButton toEditGradesBtn1;
    private JButton toChangeCourseBtn1;
    private JButton exitBtn;
    private JPanel menuPanel;
    private JPanel showSubjectsPanel;
    private JPanel showGradesPanel;
    private JPanel editGradesPanel;
    private JPanel editCoursePanel;
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
    private toSubjectBtnHandler toSubjectHandler;
    private toGradesBtnHandler toGradesHandler;
    private toEditGradesBtnHandler toEditGradesHandler;
    private toChangeCourseBtnHandler toChangeCourseHandler;
    private CardLayout cl = new CardLayout();
    private String fileName;
    private ArrayList<Course> listOfCourse= new ArrayList<>();
    private String problemDisplayer;
    public static void main(String[] args) {
        GUI program;

        try{
            program = new GUI();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public GUI(){

        /*
         * code for filePanel/getting the file name
         */
        continueButton.addActionListener(e -> {
            fileName = fileNameTF.getText();
            if (fileName.isEmpty()) {
                problemDisplayer = "Make sure you have entered the file name";
            } else {
                try {
                    listOfCourse = readDataFileIntoList(fileName);
                    problemDisplayer = "";
                } catch (FileNotFoundException ex1) {
                    problemDisplayer = fileName + " cannot be found.";
                } catch (IOException ex2) {
                    problemDisplayer = "There seems to be a problem with you input/output device";
                } catch (ArrayIndexOutOfBoundsException ex3){
                    problemDisplayer = "There seems to be a problem with reading your file";
                }
            }
            if (problemDisplayer.equalsIgnoreCase("")) {
                cl.show(mainPanel, "2");
            }
            else {
                fileNameOutputTF.setText(problemDisplayer);
            }
        });

        mainPanel.setLayout(cl);
        mainPanel.add(filePanel, "1");
        mainPanel.add(homePanel, "2");
        mainPanel.add(showSubjectsPanel, "3");
        mainPanel.add(showGradesPanel, "4");
        mainPanel.add(editGradesPanel, "5");
        mainPanel.add(editCoursePanel, "6");

        cl.show(mainPanel, "1");

        /*
         * add button handlers to every toSubject button
         */
        toSubjectHandler = new toSubjectBtnHandler();
        toSubjectsBtn1.addActionListener(toSubjectHandler);
        toSubjectsBtn2.addActionListener(toSubjectHandler);
        toSubjectsBtn3.addActionListener(toSubjectHandler);
        toSubjectsBtn4.addActionListener(toSubjectHandler);
        toSubjectsBtn5.addActionListener(toSubjectHandler);

        /*
         * add button handlers to every toGrades button
         */
        toGradesHandler = new toGradesBtnHandler();
        toGradesBtn1.addActionListener(toGradesHandler);
        toGradesBtn2.addActionListener(toGradesHandler);
        toGradesBtn3.addActionListener(toGradesHandler);
        toGradesBtn4.addActionListener(toGradesHandler);
        toGradesBtn5.addActionListener(toGradesHandler);

        /*
         * add button handlers to every toEditGrades button
         */
        toEditGradesHandler = new toEditGradesBtnHandler();
        toEditGradesBtn1.addActionListener(toEditGradesHandler);
        toEditGradesBtn2.addActionListener(toEditGradesHandler);
        toEditGradesBtn3.addActionListener(toEditGradesHandler);
        toEditGradesBtn4.addActionListener(toEditGradesHandler);
        toEditGradesBtn5.addActionListener(toEditGradesHandler);

        /*
         * add button handlers to every toChangeCourse button
         */
        toChangeCourseHandler = new toChangeCourseBtnHandler();
        toChangeCourseBtn1.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn2.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn3.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn4.addActionListener(toChangeCourseHandler);
        toChangeCourseBtn5.addActionListener(toChangeCourseHandler);

        setContentPane(mainPanel);
        pack();
        setTitle("BSCS Curriculum Checklist");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public class toSubjectBtnHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            cl.show(mainPanel, "3");
        }
    }

    public class toGradesBtnHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            cl.show(mainPanel, "4");
        }
    }

    public class toEditGradesBtnHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            cl.show(mainPanel, "5");
        }
    }

    public class toChangeCourseBtnHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            cl.show(mainPanel, "6");
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
}

