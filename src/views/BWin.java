package     views;


import controller.ControllerFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//le listener est la classe test
public class BWin extends JButton implements   ActionListener
{
    public JButton bouton;
    public String nom;
    public String cmd;
    public BWin(String nom, ControllerFrame controllerFrame, int lon, int lat, int width, int height, String cmd) {
        // TODO Auto-generated constructor stub
        super();
        this.setText(nom);
        this.addActionListener(this);

        controllerFrame.setLayout(null);
        this.setBounds(lon, lat, width, height);
        this.cmd=cmd;

    }

    /** Constructeur de test
     * @return */
    public  void    actionPerformed(ActionEvent e)
    {

        String[] args = { "cmd.exe", "/c", cmd };
        try {
            ProcessBuilder pb = new ProcessBuilder(args);
            pb = pb.redirectErrorStream(true); // on mélange les sorties du processus
            Process p = pb.start();
            java.io.InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String ligne;

            while (( ligne = br.readLine()) != null) {
                // ligne contient une ligne de sortie normale ou d'erreur
                System.out.println(ligne);
            }
        } catch (IOException e1) {

        }


    }


}