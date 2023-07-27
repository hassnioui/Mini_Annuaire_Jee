package com.ens.annuaire.web;

import com.ens.annuaire.bean.Departement;
import com.ens.annuaire.bean.Etudiant;
import com.ens.annuaire.bean.Filiere;
import com.ens.annuaire.dao.DepartementDAO;
import com.ens.annuaire.dao.EtudiantDAO;
import com.ens.annuaire.dao.FiliereDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnnuaireServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EtudiantDAO etudiantDAO;
    private FiliereDAO filiereDAO;
    private DepartementDAO departementDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        etudiantDAO = new EtudiantDAO();
        filiereDAO = new FiliereDAO();
        departementDAO = new DepartementDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/newE":
                    showNewEtudiantForm(request, response);
                    break;
                case "/insertE":
                    insertEtudiant(request, response);
                    break;
                case "/searchE":
                    searchEtudiant(request, response);
                    break;
                case "/listE":
                    listEtudiants(request, response);
                    break;
                case "/newF":
                    showNewFiliereForm(request, response);
                    break;
                case "/insertF":
                    insertFiliere(request, response);
                    break;
                case "/searchF":
                    searchFiliere(request, response);
                    break;
                case "/listF":
                    listFilieres(request, response);
                    break;
                case "/newD":
                    showNewDepartementForm(request, response);
                    break;
                case "/insertD":
                    insertDepartement(request, response);
                    break;
                case "/searchD":
                    searchDepartement(request, response);
                    break;
                case "/listD":
                    listDepartements(request, response);
                    break;
                default:
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    // EtudiantServlet methods
    private void showNewEtudiantForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Filiere> filieres = filiereDAO.selectAllFilieres();
        request.setAttribute("filieres", filieres);
        List<Departement> departements = departementDAO.selectAllDepartements();
        request.setAttribute("departements", departements);
        request.getRequestDispatcher("InserEtudiant.jsp").forward(request, response);
    }

    private void insertEtudiant(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int CNE = Integer.parseInt(request.getParameter("CNE"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String filiere = request.getParameter("filiere");
        String departement = request.getParameter("departement");
        String telephone = request.getParameter("telephone");

        Etudiant etudiant = new Etudiant(CNE, nom, prenom, filiere, departement, telephone);
        etudiantDAO.insertEtudiant(etudiant);
        request.setAttribute("successMessage", "Étudiant ajouté avec succès !");
        request.getRequestDispatcher("SuccesEtudiant.jsp").forward(request, response);
    }

    private void searchEtudiant(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String nom = request.getParameter("nom");
        List<Etudiant> etudiants = etudiantDAO.selectByNom(nom);
        request.setAttribute("etudiants", etudiants);
        request.getRequestDispatcher("ListeEtudiant.jsp").forward(request, response);
    }

    private void listEtudiants(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Etudiant> etudiants = etudiantDAO.selectAllEtudiants();
        request.setAttribute("etudiants", etudiants);
        request.getRequestDispatcher("ListeEtudiant.jsp").forward(request, response);
    }

    // FiliereServlet methods
    private void showNewFiliereForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Departement> departements = departementDAO.selectAllDepartements();
        request.setAttribute("departements", departements);
        request.getRequestDispatcher("InsertFiliere.jsp").forward(request, response);
    }

    private void insertFiliere(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String nom = request.getParameter("nom");
        int departementId = Integer.parseInt(request.getParameter("departementId"));

        Filiere filiere = new Filiere(nom, departementId);
        filiereDAO.insertFiliere(filiere);
        request.setAttribute("successMessage", "Filière ajouté avec succès !");
        request.getRequestDispatcher("SuccesFiliere.jsp").forward(request, response);
    }

    private void searchFiliere(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String nom = request.getParameter("nom");
        List<Filiere> filieres = filiereDAO.selectByNom(nom);
        request.setAttribute("filieres", filieres);
        List<Departement> departements = departementDAO.selectAllDepartements();
        request.setAttribute("departements", departements);
        request.getRequestDispatcher("ListeFiliere.jsp").forward(request, response);
    }

    private void listFilieres(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Filiere> filieres = filiereDAO.selectAllFilieres();
        request.setAttribute("filieres", filieres);
        List<Departement> departements = departementDAO.selectAllDepartements();
        request.setAttribute("departements", departements);
        request.getRequestDispatcher("ListeFiliere.jsp").forward(request, response);
    }

    // DepartementServlet methods
    private void showNewDepartementForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("InsertDepartement.jsp").forward(request, response);
    }

    private void insertDepartement(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String nom = request.getParameter("nom");

        Departement departement = new Departement(nom);
        departementDAO.insertDepartement(departement);
        request.setAttribute("successMessage", "Département ajouté avec succès !");
        request.getRequestDispatcher("SuccesDepartement.jsp").forward(request, response);
    }

    private void searchDepartement(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String nom = request.getParameter("nom");
        List<Departement> departements = departementDAO.selectByNom(nom);
        request.setAttribute("departements", departements);
        request.getRequestDispatcher("ListeDepartement.jsp").forward(request, response);
    }

    private void listDepartements(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Departement> departements = departementDAO.selectAllDepartements();
        request.setAttribute("departements", departements);
        request.getRequestDispatcher("ListeDepartement.jsp").forward(request, response);
    }
}
