package controller;


import views.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class ControllerFrame extends JFrame {
    public JPanel pan = new JPanel();
    public ControllerFrame(String nom, int width, int height){
        this.setTitle(nom);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);

        //Instanciation d'un objet JPanel

        //Définition de sa couleur de fond
        pan.setBackground(Color.ORANGE);
        //On prévient notre JFrame que notre JPanel sera son content pane
        this.setContentPane(pan);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }




    public void createBLinkV(ViewDefault viewDefault, String nom, int lon, int lat, int width, int height, String viewLink){


        BLinkV bouton = new BLinkV(viewDefault,nom,this,lon,lat, width, height,pan, viewLink);

        this.add(bouton);

        this.setVisible(true);
        pan.repaint();
    }


    public void createJTableV(ViewDefault viewDefault,String nom,int lon,int lat,int width,int height,String view) {
        // TODO Auto-generated method stub




        JTable table = new JTableV(viewDefault,pan,this,nom, lon, lat, width, height, view);
        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setBounds(lon, lat, width, height);
        this.add(scrollPane);
        this.setVisible(true);
        pan.repaint();
    }


    public void createBWin(String nom,int lon,int lat,int width,int height,String cmd) {
        // TODO Auto-generated method stub

        BWin bouton = new BWin(nom,this,lon,lat, width, height, cmd);
        this.add(bouton);
        this.setVisible(true);
        pan.repaint();
    }

    public void createForm(ViewDefault viewDefault, String nom,String lon,String lat,String width,String height, String viewName, String navF, String lonF, String latF, String widthF, String heightF) {
        // TODO Auto-generated method stub

        Form Form = new Form(viewDefault,pan,this,nom,lon,lat, width, height,viewName, navF, lonF, latF, widthF,heightF);

    }


}