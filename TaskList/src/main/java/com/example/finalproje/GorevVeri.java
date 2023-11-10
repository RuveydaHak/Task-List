package com.example.finalproje;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GorevVeri {

    public List<Gorev> gorevListele() {

        List<Gorev> gorevler = new ArrayList<>();

        Connection baglanti = null;
        Statement ifade = null;
        ResultSet sonuc = null;

        try {
            baglanti = Veritabani.veritabaniBaslat();
            String sorgu = "SELECT * FROM gorev";
            ifade = baglanti.createStatement();
            sonuc = ifade.executeQuery(sorgu);

            while (sonuc.next()) {
                int id = sonuc.getInt("id");
                String gorev_adi = sonuc.getString("gorev_adi");
                String gorev_tanimi = sonuc.getString("gorev_tanimi");
                String gorev_oncelik = sonuc.getString("gorev_oncelik");
                String gorev_durum = sonuc.getString("gorev_durum");

                Gorev gorev1 = new Gorev(id, gorev_adi, gorev_tanimi, gorev_oncelik, gorev_durum);
                gorevler.add(gorev1);
            }
            return gorevler;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            kapat(baglanti, ifade, sonuc);
        }
    }

    private void kapat(Connection baglanti, Statement ifade, ResultSet sonuc) {
        try {
            if (sonuc != null) {
                sonuc.close();
            }
            if (ifade != null) {
                ifade.close();
            }

            if (baglanti != null) {
                baglanti.close();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void gorev_ekle(Gorev gorev) {
        Connection baglanti = null;
        PreparedStatement ifade = null;
        ResultSet sonuc = null;

        try {
            baglanti = Veritabani.veritabaniBaslat();
            String sql = "INSERT INTO gorev (gorev_adi,gorev_tanimi,gorev_oncelik,gorev_durum) VALUES(?,?,?,?)";

            ifade = baglanti.prepareStatement(sql);
            ifade.setString(1,gorev.getGorev_adi());
            ifade.setString(2,gorev.getGorev_tanimi());
            ifade.setString(3,gorev.getGorev_oncelik());
            ifade.setString(4,gorev.getGorev_durum());
            ifade.execute();


        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void gorev_sil(int gorevId) {
        Connection baglanti = null;
        PreparedStatement ifade = null;
        ResultSet sonuc = null;

        try {
            baglanti = Veritabani.veritabaniBaslat();

            String sql = "DELETE FROM gorev WHERE id=?";
            ifade = baglanti.prepareStatement(sql);
            ifade.setInt(1, gorevId);
            ifade.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void durum_guncelle(int gorevId, String yeniDurum) {
        Connection baglanti = null;
        PreparedStatement ifade = null;
        ResultSet sonuc = null;

        try {
            baglanti = Veritabani.veritabaniBaslat();
            String sql = "UPDATE gorev SET gorev_durum=? WHERE id=?";

            ifade = baglanti.prepareStatement(sql);
            ifade.setString(1, yeniDurum);
            ifade.setInt(2, gorevId);

            ifade.executeUpdate();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
