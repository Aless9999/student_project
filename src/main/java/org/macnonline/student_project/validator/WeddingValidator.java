package org.macnonline.student_project.validator;

import org.macnonline.student_project.domain.StudentOrder;
import org.macnonline.student_project.domain.AnswerWeddingRegister;

public class WeddingValidator {
    public static AnswerWeddingRegister checkWedding(StudentOrder studentOrder) {
        System.out.println("CheckWedding is running");
        AnswerWeddingRegister answerWeddingRegister=new AnswerWeddingRegister();
        return answerWeddingRegister;
    }
}
