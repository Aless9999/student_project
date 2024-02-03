package org.macnonline.student_project.validator.register;

import org.macnonline.student_project.domain.Adult;
import org.macnonline.student_project.domain.Child;
import org.macnonline.student_project.exception.TransportException;
import org.macnonline.student_project.register.CityRegisterResponse;
import org.macnonline.student_project.domain.Person;
import org.macnonline.student_project.exception.CityRegisterException;

public class FakeCityRegisterChecker implements CityRegisterChecker {
    private static final String GOOD_1 = "1000";
    private static final String GOOD_2 = "2000";
    private static final String BAD_1 = "1001";
    private static final String BAD_2 = "2001";
    private static final String ERROR_1 = "1002";
    private static final String ERROR_2 = "2002";
    private static final String ERROR_T1 = "1003";
    private static final String ERROR_T2 = "2003";

    public CityRegisterResponse checkPerson(Person person) throws CityRegisterException, TransportException {
        CityRegisterResponse checkedResponse = new CityRegisterResponse();
        if (person instanceof Adult element) {
            String serialNumber = element.getPasswordNumber();

            if (serialNumber.equals(GOOD_1) || serialNumber.equals(GOOD_2)) {
                checkedResponse.setExisting(true);
                checkedResponse.setTemporal(true);
            }
            if (serialNumber.equals(BAD_1) || serialNumber.equals(BAD_2)) {
                checkedResponse.setExisting(false);
                checkedResponse.setTemporal(false);
            }
            if (serialNumber.equals(ERROR_1) || serialNumber.equals(ERROR_2)) {
                throw new CityRegisterException("1","GRN ERROR "+serialNumber);
            }
            if(serialNumber.equals(ERROR_T1)||serialNumber.equals(ERROR_T2)){
                throw new TransportException("Transport ERROR"+serialNumber);
            }
        }
        if(person instanceof Child el){
            checkedResponse.setExisting(true);
            checkedResponse.setTemporal(true);

        }
        System.out.println(checkedResponse);

        return checkedResponse;

    }
}
