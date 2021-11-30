package com.softserve.academy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PgDataStorage implements DataStorage{

    private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/appdb";
    private static final String userName = "app";
    private static final String psw = "app";

    private Connection connection;
    {
        final String insertSQL = "INSERT INTO person"
            + " (id, name, birthday, sex)"
            + "VALUES (?, ?, ?, ?);";

        try {
            connection = DriverManager.getConnection(jdbcUrl, userName, psw);
            Statement stm = connection.createStatement();
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(insertSQL);
            DataUtils.generate().forEach(p -> {
                try {
                    ps.setInt(1, p.getId());
                    ps.setString(2, p.getName());
                    ps.setDate(3, p.getBirthday());
                    ps.setString(4, p.getSex());
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            throw new RuntimeException("Problem:" + e.getMessage());
        }
    }

    @Override
    public Person findOldestPerson(String sex) {
        String sql = "SELECT * FROM person WHERE sex = ? ORDER BY birthday DESC";
        try {
            ResultSet rs = getResultSet(sql, sex);
            if (rs.next()) {
                return new Person(rs.getInt("id"),
                    rs.getDate("birthday"),
                    rs.getString("name"),
                    rs.getString("sex"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("findAll returns error:" + e.getMessage());
        }

    }

    @Override
    public List<Person> findAll(String sex) {
        String sql = "SELECT * FROM person" + (sex == null ? "" : " WHERE sex = ?");
        try {
            ResultSet rs = getResultSet(sql, sex);
            List<Person> result = new ArrayList<>();
            while (rs.next()) {
                result.add(new Person(rs.getInt("id"),
                    rs.getDate("birthday"),
                    rs.getString("name"),
                    rs.getString("sex")));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("findAll returns error:" + e.getMessage());
        }

    }

    private ResultSet getResultSet(String sql, String sex) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        //Comment: apply parameters
        if (sex != null) {
            ps.setString(1, sex);
        }
        return ps.executeQuery();
    }
}
