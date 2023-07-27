package com.ens.annuaire.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ens.annuaire.bean.Etudiant;

public class EtudiantDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/annuairedb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    private String jdbcDriver = "com.mysql.jdbc.Driver";

    private static final String INSERT_ETUDIANT = "INSERT INTO etudiant (CNE, nom, prenom, filiere, departement, telephone) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_ETUDIANTS = "SELECT * FROM etudiant";
    private static final String SELECT_BY_NOM = "SELECT * FROM etudiant WHERE nom = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertEtudiant(Etudiant etudiant) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ETUDIANT)) {
            preparedStatement.setInt(1, etudiant.getCNE());
            preparedStatement.setString(2, etudiant.getNom());
            preparedStatement.setString(3, etudiant.getPrenom());
            preparedStatement.setString(4, etudiant.getFiliere());
            preparedStatement.setString(5, etudiant.getDepartement());
            preparedStatement.setString(6, etudiant.getTelephone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public List<Etudiant> selectAllEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ETUDIANTS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int CNE = rs.getInt("CNE");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String filiere = rs.getString("filiere");
                String departement = rs.getString("departement");
                String telephone = rs.getString("telephone");
                etudiants.add(new Etudiant(CNE, nom, prenom, filiere, departement, telephone));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return etudiants;
    }

    public List<Etudiant> selectByNom(String nom) {
        List<Etudiant> etudiants = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NOM)) {
            preparedStatement.setString(1, nom);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int CNE = rs.getInt("CNE");
                String etudiantNom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String filiere = rs.getString("filiere");
                String departement = rs.getString("departement");
                String telephone = rs.getString("telephone");
                etudiants.add(new Etudiant(CNE, etudiantNom, prenom, filiere, departement, telephone));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return etudiants;
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
