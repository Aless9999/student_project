package org.macnonline.student_project.dao;

import org.macnonline.student_project.domain.CountryArea;
import org.macnonline.student_project.domain.PassportOffice;
import org.macnonline.student_project.domain.RegisterOffice;
import org.macnonline.student_project.domain.Street;
import org.macnonline.student_project.exception.DaoException;

import java.util.List;

public interface DictionaryDao {

    public List<Street> findStreets(String pattern) throws DaoException;

    public List<PassportOffice>findPassportOffice(String areaId)throws DaoException;
    public List<RegisterOffice>findRegisterOffice(String areaId)throws DaoException;
    public List<CountryArea>findCountryArea(String areaId)throws DaoException;
}
