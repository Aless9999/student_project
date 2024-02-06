package org.macnonline.student_project.dao;

import org.macnonline.student_project.domain.Street;
import org.macnonline.student_project.exception.DaoException;

import java.util.List;

public interface DictionaryDao {

    public List<Street> findStreets(String pattern) throws DaoException;
}
