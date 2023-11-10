package com.example.finalproje;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "GorevEkleServlet", value = "/gorev-ekle")
public class GorevEkleServlet extends HttpServlet {
    private GorevVeri gorevVeri = new GorevVeri();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try{
            String gorev_adi = request.getParameter("gorev_adi");
            String gorev_tanimi = request.getParameter("gorev_tanimi");
            String gorev_oncelik = request.getParameter("gorev_oncelik");
            String gorev_durum = request.getParameter("gorev_durum");

            Gorev gorev1 = new Gorev(gorev_adi,gorev_tanimi,gorev_oncelik,gorev_durum);

            gorevVeri.gorev_ekle(gorev1);

            response.sendRedirect(request.getContextPath() + "/index");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}