package org.macnonline.student_project.dao;

import org.macnonline.student_project.config.Config;
import org.macnonline.student_project.domain.CountryArea;
import org.macnonline.student_project.domain.PassportOffice;
import org.macnonline.student_project.domain.RegisterOffice;
import org.macnonline.student_project.domain.Street;
import org.macnonline.student_project.exception.DaoException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao {
    private String GET_STREET = "select street_code," +
            " street_name from st_street" +
            " where upper(street_name) like upper(?)";

    private String GET_PASSPORT_OFFICE =
            "select*from st_passport_office where upper(p_office_area_id)=?";
    private String GET_REGISTER_OFFICE
            = "select*from st_register_office where upper(r_office_area_id)=?";
    private String GET_COUNTRY_OFFICE="select * from st_country_struct where area_id like ? and area_id <>?";


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

    @Override
    public List<PassportOffice> findPassportOffice(String areaId) throws DaoException {

        List<PassportOffice> offices = new LinkedList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_PASSPORT_OFFICE);) {

            statement.setString(1, areaId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                PassportOffice passportOffice = new PassportOffice(
                        resultSet.getLong("p_office_id"),
                        resultSet.getString("p_office_area_id"),
                        resultSet.getString("p_office_name"));

                offices.add(passportOffice);
            }

        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return offices;
    }

    @Override
    public List<RegisterOffice> findRegisterOffice(String areaId) throws DaoException {
        List<RegisterOffice> offices = new LinkedList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_REGISTER_OFFICE)) {
            preparedStatement.setString(1, areaId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                RegisterOffice registerOffice = new RegisterOffice(
                        resultSet.getLong("r_office_id"),
                        resultSet.getString("r_office_area_id"),
                        resultSet.getString("r_office_name"));
                offices.add(registerOffice);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return offices;
    }

    @Override
    public List<CountryArea> findCountryArea(String areaId) throws DaoException {
        List<CountryArea>countryAreas=new LinkedList<>();
        try(Connection connection=getConnection();
        PreparedStatement statement=connection.prepareStatement(GET_COUNTRY_OFFICE)){
            statement.setString(1,areaId);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                CountryArea countryArea=new CountryArea(
                        resultSet.getLong("area_id"),
                        resultSet.getString("area_name")
                );
                countryAreas.add(countryArea);
            }

        }catch (SQLException ex){
            throw new DaoException(ex);
        }
        return null;
    }

    private Connection getConnection() throws SQLException {

        Connection connection = DriverManager.getConnection(
                Config.getProperties(Config.DB_URL),
                Config.getProperties(Config.DB_LOGIN),
                Config.getProperties(Config.DB_PASSWORD));

        return connection;
    }
}
