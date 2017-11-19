package views;

import  javax.swing.*;

import controller.ControllerFrame;

import  java.awt.event.*;

//le listener est la classe test
public class BLinkV extends JButton implements   ActionListener
{
    public JButton bouton;
    public String nom;
    public JFrame frame;
    JPanel pan;
    ViewDefault viewDefault;
    String viewLink;
    public BLinkV(ViewDefault viewDefault, String nom, ControllerFrame controllerFrame, int lon, int lat, int width, int height, JPanel pan, String viewLink) {
        // TODO Auto-generated constructor stub
        super();
        frame= controllerFrame;
        this.setText(nom);
        this.addActionListener(this);
        controllerFrame.setLayout(null);
        this.setBounds(lon, lat, width, height);
        this.pan=pan;
        this.viewDefault=viewDefault;
        this.viewLink=viewLink;
    }

    /** Constructeur de test
     * @return */
    public  void    actionPerformed(ActionEvent e)
    {


        //new ControllerDefault.Default("1");


        pan.removeAll();
        //add your elements
        frame.revalidate();
        frame.repaint();
        viewDefault.view = "1";
        viewDefault.getView(viewLink);
    }


}