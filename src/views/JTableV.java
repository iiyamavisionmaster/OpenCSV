package views;

import  javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.ControllerFrame;

import  java.awt.*;
import  java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//le listener est la classe test
public class JTableV extends JTable implements   ActionListener
{
    public JButton bouton;
    public String nom;
    public JFrame frame;
    JPanel pan;
    ViewDefault viewDefault;
    String viewData;

    Object[] rowData;

    Object[] columnNames;
    JTable table;
    public JTableV(ViewDefault viewDefault, JPanel pan, ControllerFrame controllerFrame, String nom, int lon, int lat, int width, int height, String viewData) {
        // TODO Auto-generated constructor stub
        super();
        frame= controllerFrame;
        this.viewData=viewData;
        // create JFrame and JTable

        table = this;

        // create a table model and set a Column Identifiers to this model
        getRowData();

        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setRowHeight(30);

        this.setBounds(lon, lat, width, height);
        this.pan=pan;
        this.viewDefault=viewDefault;

    }

    Object[] getColumnNames() {
        // TODO Auto-generated method stub

        return null;
    }











    Object[][] getRowData() {
        // TODO Auto-generated method stub

        DefaultTableModel model = new DefaultTableModel();


        // set the model to the table




        BufferedReader fichier = null;
        try {
            fichier = new BufferedReader(new FileReader("src/donnee/"+viewData+".csv"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String ligne="1";
        String[] ligneInside;

        int i=0;

        while (ligne != null) {
            try {
                ligne = fichier.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if(ligne != null){
                ligneInside = ligne.split(";");


                rowData=new Object[ligneInside.length];

                columnNames=new Object[ligneInside.length];
                if(i==0){


                    for(int j = 0; j < ligneInside.length; j++)
                    {

                        columnNames[j]=ligneInside[j];



                    }
                    model.setColumnIdentifiers(columnNames);
                    table.setModel(model);
                }
                if(i!=0){

                    rowData =ligneInside;

                    model.addRow(rowData);
                }
            }
            i++;
        }



        return null;
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

    }


}