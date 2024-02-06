package org.macnonline.student_project.dao;

import org.macnonline.student_project.config.Config;
import org.macnonline.student_project.domain.Street;
import org.macnonline.student_project.exception.DaoException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl {
    private String GET_STREET = "select street_code," +
            " street_name from st_street" +
            " where upper(street_name) like upper(?)";


    public List<Street> findStreets(String pattern) throws DaoException {
        List<Street> streets = new LinkedList<>();

        try (Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(GET_STREET);) {
            stmt.setString(1, "%" + pattern + "%");
            ResultSet resultSet = stmt.executeQuery();


            while (resultSet.next()) {

                Street street = new Street(resultSet.getLong("street_code"),
                        resultSet.getString("street_name"));

                streets.add(street);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return streets;
    }

    private Connection getConnection() throws SQLException {

        Connection connection = DriverManager.getConnection(
                Config.getProperties(Config.DB_URL),
                Config.getProperties(Config.DB_LOGIN),
                Config.getProperties(Config.DB_PASSWORD));

        return connection;
    }
}
