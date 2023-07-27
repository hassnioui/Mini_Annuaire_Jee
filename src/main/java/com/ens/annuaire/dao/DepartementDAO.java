package com.ens.annuaire.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ens.annuaire.bean.Departement;

public class DepartementDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/annuairedb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    private String jdbcDriver = "com.mysql.jdbc.Driver";

    private static final String SELECT_ALL_DEPARTEMENTS = "SELECT * FROM departement";
    private static final String INSERT_DEPARTEMENT = "INSERT INTO departement (nom) VALUES (?)";
    private static final String SELECT_BY_NOM = "SELECT * FROM departement WHERE nom = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Departement> selectAllDepartements() {
        List<Departement> departements = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DEPARTEMENTS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                departements.add(new Departement(id, nom));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return departements;
    }

    public List<Departement> selectByNom(String nom) {
        List<Departement> departements = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NOM)) {
            preparedStatement.setString(1, nom);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String departementNom = rs.getString("nom");
                departements.add(new Departement(id, departementNom));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return departements;
    }

    public void insertDepartement(Departement departement) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DEPARTEMENT)) {
            preparedStatement.setString(1, departement.getNom());
            preparedStatement.executeUpdate();
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
