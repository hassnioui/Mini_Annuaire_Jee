package com.ens.annuaire.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ens.annuaire.bean.Filiere;

public class FiliereDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/annuairedb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    private String jdbcDriver = "com.mysql.jdbc.Driver";

    private static final String SELECT_ALL_FILIERES = "SELECT * FROM filiere";
    private static final String INSERT_FILIERE = "INSERT INTO filiere (nom, departementId) VALUES (?, ?)";
    private static final String SELECT_BY_NOM = "SELECT * FROM filiere WHERE nom = ?";

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

    public List<Filiere> selectAllFilieres() {
        List<Filiere> filieres = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FILIERES)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                int departementId = rs.getInt("departementId");
                filieres.add(new Filiere(id, nom, departementId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return filieres;
    }

    public List<Filiere> selectByNom(String nom) {
        List<Filiere> filieres = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NOM)) {
            preparedStatement.setString(1, nom);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String filiereNom = rs.getString("nom");
                int departementId = rs.getInt("departementId");
                filieres.add(new Filiere(id, filiereNom, departementId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return filieres;
    }

    public void insertFiliere(Filiere filiere) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FILIERE)) {
            preparedStatement.setString(1, filiere.getNom());
            preparedStatement.setInt(2, filiere.getDepartementId());
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
