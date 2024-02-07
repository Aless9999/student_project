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
    private String GET_COUNTRY_OFFICE = "select * from st_country_struct " +
            "where area_id like ? and area_id <>?";


    public List<Street> findStreets(String pattern) throws DaoException {
        List<Street> streets = new LinkedList<>();

        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(GET_STREET);) {

            st.setString(1, "%" + pattern + "%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Street street = new Street(rs.getLong("street_code"),
                        rs.getString("street_name"));

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

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(GET_PASSPORT_OFFICE);) {

            ps.setString(1, areaId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PassportOffice passportOffice = new PassportOffice(
                        rs.getLong("p_office_id"),
                        rs.getString("p_office_area_id"),
                        rs.getString("p_office_name"));

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

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(GET_REGISTER_OFFICE)) {

            ps.setString(1, areaId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RegisterOffice registerOffice = new RegisterOffice(
                        rs.getLong("r_office_id"),
                        rs.getString("r_office_area_id"),
                        rs.getString("r_office_name"));
                offices.add(registerOffice);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return offices;
    }

    @Override
    public List<CountryArea> findCountryArea(String areaId) throws DaoException {
        List<CountryArea> countryAreas = new LinkedList<>();

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(GET_COUNTRY_OFFICE)) {

            String param1 = buildParam(areaId);
            String param2 = areaId;
            ps.setString(1, param1);
            ps.setString(2, param2);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CountryArea countryArea = new CountryArea(
                        rs.getLong("area_id"),
                        rs.getString("area_name")
                );
                countryAreas.add(countryArea);
            }

        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return countryAreas;
    }

    private String buildParam(String areaId) throws SQLException{
        if (areaId == null || areaId.trim().isEmpty()) {
            return "__0000000000";
        } else if (areaId.endsWith("0000000000")) {
            return areaId.substring(0,2)+"___0000000";
        } else if (areaId.endsWith("0000000")) {
            return areaId.substring(0,5)+"___0000";

        } else if (areaId.endsWith("0000")) {
            return areaId.substring(0,8)+"____";
        }
        throw new SQLException("Invalid areaId "+areaId);
    }

    private Connection getConnection() throws SQLException {

        Connection connection = DriverManager.getConnection(
                Config.getProperties(Config.DB_URL),
                Config.getProperties(Config.DB_LOGIN),
                Config.getProperties(Config.DB_PASSWORD));

        return connection;
    }
}
