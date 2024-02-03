package org.macnonline.student_project;

import org.macnonline.student_project.domain.*;
import org.macnonline.student_project.email.MailSender;
import org.macnonline.student_project.register.AnswerCityRegister;
import org.macnonline.student_project.validator.ChildrenValidator;
import org.macnonline.student_project.validator.register.CityRegisterValidator;
import org.macnonline.student_project.validator.StudentValidator;
import org.macnonline.student_project.validator.WeddingValidator;

import java.util.LinkedList;
import java.util.List;


public class StudentOrderValidator {
    private WeddingValidator weddingValidator;
    private ChildrenValidator childrenValidator;
    private StudentValidator studentValidator;
    private CityRegisterValidator cityRegisterValidator;
    private MailSender mailSender;

    public StudentOrderValidator() {
        weddingValidator = new WeddingValidator();
        childrenValidator = new ChildrenValidator();
        studentValidator = new StudentValidator();
        cityRegisterValidator = new CityRegisterValidator();
        mailSender = new MailSender();

    }


    public static void main(String[] args) {
        StudentOrderValidator studentOrderValidator = new StudentOrderValidator();
        studentOrderValidator.checkAll();
        System.out.println("Main finish");
    }

    /*
    Комментарий большого объема
     */
    public void checkAll() {
        List<StudentOrder> soArray = readStudentOrders();
        for (StudentOrder element : soArray) {
            checkOneOrder(element);
            System.out.println();
        }

    }

    public void checkOneOrder(StudentOrder so) {
        AnswerCityRegister answerCityRegister = checkCityRegister(so);
        AnswerCheckChildren answerCheckChildren = checkChildren(so);
        AnswerStudentRegister answerStudentRegister = checkStudent(so);
        AnswerWeddingRegister answerWeddingRegister = checkWedding(so);
        sendMail(so);
    }


    public static List<StudentOrder> readStudentOrders() {
        List<StudentOrder> studentOrders = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            studentOrders.add(SaveStudentOrder.buildStudentOrder(i));
        }
        return studentOrders;
    }


    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        cityRegisterValidator.checkCityRegister(studentOrder);


        return new AnswerCityRegister();
    }

    public AnswerWeddingRegister checkWedding(StudentOrder studentOrder) {
        return weddingValidator.checkWedding(studentOrder);
    }

    public AnswerCheckChildren checkChildren(StudentOrder studentOrder) {
        return childrenValidator.checkChildren(studentOrder);
    }

    public AnswerStudentRegister checkStudent(StudentOrder studentOrder) {
        return studentValidator.checkStudent(studentOrder);
    }

    private void sendMail(StudentOrder studentOrder) {
        mailSender.sendMail(studentOrder);
    }
}
