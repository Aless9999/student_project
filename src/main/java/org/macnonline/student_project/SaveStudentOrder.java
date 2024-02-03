package org.macnonline.student_project;

import org.macnonline.student_project.domain.Address;
import org.macnonline.student_project.domain.Adult;
import org.macnonline.student_project.domain.Child;
import org.macnonline.student_project.domain.StudentOrder;

import java.time.LocalDate;

public class SaveStudentOrder {


    public static void main(String[] args) {
        StudentOrder studentOrder;
        studentOrder = new StudentOrder();
        long ans = saveStudentOrder(studentOrder);
        System.out.println(ans);

    }

    public static Long saveStudentOrder(StudentOrder studentOrder) {
        long answer;
        answer = 123;
        System.out.println("Save student order ");
        return answer;
    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificated("" + 123456000 + id);
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        so.setMarriageOffice("Отдел ЗАГС");

        Address address = new Address("195000", "Заневский пр.", "12", "", "142");
        // husband
        Adult husband = new Adult("Virodov", "Ivan", "Alekseevich", LocalDate.of(1990, 4, 5));
        husband.setPasswordNumber("" + 100 + id);
        husband.setPasswordSerial("" + 100000 + id);
        husband.setIssueDate(LocalDate.of(2013, 3, 5));
        husband.setIssueDepartment("Отдел полиции № " + id);
        husband.setStudentId("" + 100000 + id);
        husband.setAddress(address);

        // wife
        Adult wife = new Adult("Virodova", "Angelina", "Sergeevna", LocalDate.of(1996, 8, 4));
        wife.setPasswordNumber("" + 200 + id);
        wife.setPasswordSerial("" + 200000 + id);
        wife.setIssueDate(LocalDate.of(2006, 6, 9));
        wife.setIssueDepartment("Отдел полиции № " + id);
        wife.setStudentId("" + 200000 + id);
        wife.setAddress(address);

        //children
        Child child1 = new Child("Virodova", "Elena", "Ivanovna", LocalDate.of(2017, 9, 4));
        child1.setCertificateNumber("" + 3000 + id);
        child1.setIssueDate(LocalDate.of(2017, 10, 4));
        child1.setIssueDepartment("Отдел ЗАГС");
        child1.setAddress(address);


        Child child2= new Child("Virodova", "Мария", "Ivanovna", LocalDate.of(2017, 9, 4));
        child2.setCertificateNumber("" + 4000 + id);
        child2.setIssueDate(LocalDate.of(2018, 9, 4));
        child2.setIssueDepartment("Отдел ЗАГС");
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);

        return so;
    }
}
