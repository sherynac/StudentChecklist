package prog2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        mainPanel.setLayout(cl);
        mainPanel.add(filePanel, "1");
        mainPanel.add(homePanel, "2");
        mainPanel.add(showSubjectsPanel, "3");
        mainPanel.add(showGradesPanel, "4");
        mainPanel.add(editGradesPanel, "5");
        mainPanel.add(editCoursePanel, "6");

        cl.show(mainPanel, "1");

        continueButton.addActionListener(e -> {
            cl.show(mainPanel, "2");
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
}

