package org.macnonline.student_project.domain;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentOrder {
    private long studentOrderId;
    private Adult husband;
    private Adult wife;
    private List<Child> children;
    private String marriageCertificated;
    private LocalDate marriageDate;
    private RegisterOffice marriageOffice;

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public RegisterOffice getMarriageOffice() {
        return marriageOffice;
    }

    public void setMarriageOffice(RegisterOffice marriageOffice) {
        this.marriageOffice = marriageOffice;
    }

    public String getMarriageCertificated() {
        return marriageCertificated;
    }

    public void setMarriageCertificated(String marriageCertificated) {
        this.marriageCertificated = marriageCertificated;
    }

    public LocalDate getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(LocalDate marriageDate) {
        this.marriageDate = marriageDate;
    }

    public long getStudentOrderId() {
        return studentOrderId;
    }

    public void setStudentOrderId(long studentOrderId) {
        this.studentOrderId = studentOrderId;
    }

    public Adult getHusband() {
        return husband;
    }

    public void setHusband(Adult husband) {
        this.husband = husband;
    }

    public Adult getWife() {
        return wife;
    }

    public void setWife(Adult wife) {
        this.wife = wife;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void addChild(Child child) {
        if (children == null) {
            children = new ArrayList<Child>(5);
        }
        children.add(child);
    }
}
