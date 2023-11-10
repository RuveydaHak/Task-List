package com.example.finalproje;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GorevlerServlet", value = "/index")
public class GorevlerServlet extends HttpServlet {
    private GorevVeri gorevVeri = new GorevVeri();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        response.setContentType("text/html");

        List<Gorev> gorevler = gorevVeri.gorevListele();

        request.setAttribute("gorev_listesi",gorevler);

        RequestDispatcher rs = request.getRequestDispatcher("/anasayfa.jsp");

        try {
            rs.forward(request, response);
        }
        catch (ServletException e) {
            throw  new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}