package org.macnonline.student_project.domain;

import java.time.LocalDate;

public class Marriage {
    private String marriageCertificated;
    private LocalDate marriageDate;
    private String marriageOffice;

    public Marriage(String marriageCertificated, LocalDate marriageDate, String marriageOffice) {
        this.marriageCertificated = marriageCertificated;
        this.marriageDate = marriageDate;
        this.marriageOffice = marriageOffice;
    }

    public Marriage() {

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

    public String getMarriageOffice() {
        return marriageOffice;
    }

    public void setMarriageOffice(String marriageOffice) {
        this.marriageOffice = marriageOffice;
    }
}
