package org.macnonline.student_project.domain;

public class CountryArea {
    private long countryId;
    private String countryName;

    public CountryArea() {
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public CountryArea(long countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }
}
