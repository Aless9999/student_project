package org.macnonline.student_project.validator;

import org.macnonline.student_project.domain.StudentOrder;
import org.macnonline.student_project.domain.AnswerStudentRegister;

public class StudentValidator {
    public static AnswerStudentRegister checkStudent(StudentOrder studentOrder) {
        System.out.println("CheckStudent is running");
        AnswerStudentRegister answerStudentRegister=new AnswerStudentRegister();
        return answerStudentRegister;
    }
}
