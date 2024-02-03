package org.macnonline.student_project.validator.register;

import org.macnonline.student_project.exception.TransportException;
import org.macnonline.student_project.register.CityRegisterResponse;
import org.macnonline.student_project.domain.Person;
import org.macnonline.student_project.exception.CityRegisterException;

public interface CityRegisterChecker {
    CityRegisterResponse checkPerson(Person person)throws CityRegisterException, TransportException;
}
