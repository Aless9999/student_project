package org.macnonline.student_project;

import org.macnonline.student_project.dao.DictionaryDaoImpl;
import org.macnonline.student_project.domain.*;
import org.macnonline.student_project.exception.DaoException;

import java.sql.*;
import java.time.LocalDate;

public class SaveStudentOrder {


    public static void main(String[] args) throws DaoException {

        DictionaryDaoImpl dao=new DictionaryDaoImpl();
        dao.findStreets("гороховая").stream()
                .map(Street::getStreetName)
                .forEach(System.out::println);
        dao.findPassportOffice("010020000000").stream()
                .map(PassportOffice::getOfficeName)
                .forEach(System.out::println);

        dao.findRegisterOffice("020010010001").stream()
                .map(RegisterOffice::getOfficeName)
                .forEach(System.out::println);

    }

    public static Long saveStudentOrder(StudentOrder studentOrder) {
        long answer;
        answer = 123;
        System.out.println("Save student order ");
        return answer;
    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        RegisterOffice registerOffice=new RegisterOffice();
        so.setStudentOrderId(id);
        so.setMarriageCertificated("" + 123456000 + id);
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        so.setMarriageOffice(registerOffice);

        Street street = new Street(1, "Stavanger");

        Address address = new Address("195000", street, "12", "", "142");
        // husband
        Adult husband = new Adult("Virodov", "Ivan", "Alekseevich", LocalDate.of(1990, 4, 5));
        husband.setPasswordNumber("" + 100 + id);
        husband.setPasswordSerial("" + 100000 + id);
        husband.setIssueDate(LocalDate.of(2013, 3, 5));
        husband.setPassportOffice(new PassportOffice(1,"2","Отдел полиции № " + id));
        husband.setStudentId("" + 100000 + id);
        husband.setAddress(address);

        // wife
        Adult wife = new Adult("Virodova", "Angelina", "Sergeevna", LocalDate.of(1996, 8, 4));
        wife.setPasswordNumber("" + 200 + id);
        wife.setPasswordSerial("" + 200000 + id);
        wife.setIssueDate(LocalDate.of(2006, 6, 9));
//        wife.setPassportOffice("Отдел полиции № " + id);
        wife.setStudentId("" + 200000 + id);
        wife.setAddress(address);

        //children
        Child child1 = new Child("Virodova", "Elena", "Ivanovna", LocalDate.of(2017, 9, 4));
        child1.setCertificateNumber("" + 3000 + id);
        child1.setIssueDate(LocalDate.of(2017, 10, 4));
//        child1.setRegisterOffice("Отдел ЗАГС");
        child1.setAddress(address);


        Child child2 = new Child("Virodova", "Мария", "Ivanovna", LocalDate.of(2017, 9, 4));
        child2.setCertificateNumber("" + 4000 + id);
        child2.setIssueDate(LocalDate.of(2018, 9, 4));
//        child2.setRegisterOffice("Отдел ЗАГС");
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);

        return so;
    }
}
