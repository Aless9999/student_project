package org.macnonline.student_project.validator;

import org.macnonline.student_project.domain.StudentOrder;
import org.macnonline.student_project.domain.AnswerCheckChildren;

public class ChildrenValidator {
    public static AnswerCheckChildren checkChildren(StudentOrder studentOrder) {
        System.out.println("CheckChildren is running");
        AnswerCheckChildren answerCheckChildren=new AnswerCheckChildren();
        return answerCheckChildren;
    }
}
