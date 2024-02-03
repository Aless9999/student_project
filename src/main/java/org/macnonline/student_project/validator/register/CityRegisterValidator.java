package org.macnonline.student_project.validator.register;

import org.macnonline.student_project.domain.Child;
import org.macnonline.student_project.domain.Person;
import org.macnonline.student_project.domain.StudentOrder;
import org.macnonline.student_project.exception.TransportException;
import org.macnonline.student_project.register.AnswerCityRegister;
import org.macnonline.student_project.exception.CityRegisterException;
import org.macnonline.student_project.register.AnswerCityRegisterItem;
import org.macnonline.student_project.register.CityRegisterResponse;

import java.util.List;

public class CityRegisterValidator {
    private final static String IN_CODE = "NO_GRN";
    public String hostName;
    public String login;
    public String password;
    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }


    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        try {
            personChecker.checkPerson(studentOrder.getHusband());
            personChecker.checkPerson(studentOrder.getWife());
            List<Child> childList = studentOrder.getChildren();
            for (Child child : childList) {
                personChecker.checkPerson(child);
            }

        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
        } catch (TransportException e) {
            e.printStackTrace(System.out);
        }


        AnswerCityRegister answerCityRegister = new AnswerCityRegister();
        return answerCityRegister;
    }

    private AnswerCityRegisterItem checkPerson(Person person) {
        AnswerCityRegisterItem.CityStatus status = null;
        AnswerCityRegisterItem.CityError error = null;
        try {
            CityRegisterResponse registerResponse = personChecker.checkPerson(person);
            status = registerResponse.isExisting() ?      // если есть такой объект
                    AnswerCityRegisterItem.CityStatus.YES :
                    AnswerCityRegisterItem.CityStatus.NO;

        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(ex.getCode(), ex.getMessage());

        } catch (TransportException e) {
            e.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, e.getMessage());

        } catch (Exception e) {
            e.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, e.getMessage());
        }


        AnswerCityRegisterItem answerCityRegisterItem =
                new AnswerCityRegisterItem(status, person, error);
        return answerCityRegisterItem;
    }


}
