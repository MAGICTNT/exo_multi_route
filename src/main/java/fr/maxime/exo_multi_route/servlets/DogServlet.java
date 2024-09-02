package fr.maxime.exo_multi_route.servlets;

import fr.maxime.exo_multi_route.entity.Chien;
import fr.maxime.exo_multi_route.repository.ChienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "dogservlet", value = "/dog/*")
public class DogServlet extends HttpServlet {

    private ChienRepository chienRepository;
    private List<Chien> chiensList;

    @Override
    public void init() {
        chienRepository = new ChienRepository();
        chiensList = chienRepository.findAll();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        System.out.println(pathInfo);

        switch (pathInfo) {
            case "/ajouter" -> req.getRequestDispatcher("/WEB-INF/ajouter.jsp").forward(req, resp);
            case "/afficher" -> afficher(req, resp);
            case "/detail" -> detail(req, resp);
            default -> req.getRequestDispatcher("/WEB-INF/ajouter.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        System.out.println("post " + pathInfo);
        if ("/ajouter".equals(pathInfo)) {
            Chien chien = new Chien();
            chien.setNomChien(req.getParameter("nom"));
            chien.setRace(req.getParameter("race"));
            System.out.println(req.getParameter("nom"));
            System.out.println(req.getParameter("race"));
            System.out.println(req.getParameter("dateDeNaissance"));
            chien.setDateNaissance(LocalDate.parse(req.getParameter("dateDeNaissance")));

            chienRepository.createOrUpdate(chien);
            chiensList.add(chien);

            req.setAttribute("message", "Chien ajouté avec succès !");
            doGet(req, resp);
        }
    }

    private void afficher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        chiensList = chienRepository.findAll();
        req.setAttribute("chiens", chiensList);
        req.getRequestDispatcher("/WEB-INF/afficher.jsp").forward(req, resp);
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idChienParam = req.getParameter("idChien");
        System.out.println("id param detail " + idChienParam);
        if (idChienParam != null) {
            int idChien = Integer.parseInt(idChienParam);
            Chien chienTrouve = chienRepository.findById(idChien);

            if (chienTrouve != null) {
                req.setAttribute("chien", chienTrouve);
            }
        }else {
            req.setAttribute("chien", null);
        }
        req.getRequestDispatcher("/WEB-INF/detail.jsp").forward(req, resp);

    }
}
