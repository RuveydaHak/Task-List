package com.example.finalproje;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "GorevSilServlet", value = "/gorev-sil")
public class GorevSilServlet extends HttpServlet {
    private GorevVeri gorevVeri = new GorevVeri();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try{
            String gorevId = request.getParameter("gorevId");

            gorevVeri.gorev_sil(Integer.parseInt(gorevId));

            response.sendRedirect(request.getContextPath() + "/index");
        }
        catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void destroy() {
    }
}