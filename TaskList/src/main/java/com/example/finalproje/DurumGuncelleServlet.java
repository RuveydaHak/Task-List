package com.example.finalproje;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DurumGuncelleServlet", value = "/durum-guncelle")
public class DurumGuncelleServlet extends HttpServlet {
    private GorevVeri gorevVeri = new GorevVeri();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try{
            int gorevId = Integer.parseInt(request.getParameter("gorevId"));
            String yeniDurum = request.getParameter("yeniDurum");

            gorevVeri.durum_guncelle(gorevId, yeniDurum);

            response.sendRedirect(request.getContextPath()+"/index");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}