
package views;

import controller.ControllerFrame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
//le listener est la classe test      
public  class Form
{

    public String nom;
    public JFrame frame;
    JPanel pan;
    ViewDefault viewDefault;
    String viewData;
    String viewName;
    JTextField[] textField;

    String[] format;
    String[] firstData;
    public Form(ViewDefault viewDefault, JPanel pan2, ControllerFrame controllerFrame, String nom2, String lon, String lat, String width, String height, String viewName, String navF, String lonF, String latF, String widthF, String heightF) {
        // TODO Auto-generated constructor stub
        this.viewDefault=viewDefault;
        this.viewName=viewName;
        System.out.println(viewDefault.getView());
        String[] nomTab = nom2.split(",");
        String[] lonTab = lon.split(",");
        String[] latTab = lat.split(",");
        String[] widthTab= width.split(",");
        String[] heightTab = height.split(",");

        String[] navFname = navF.split(",");
        String[] lonFtab = lonF.split(",");
        String[] latFTab = latF.split(",");
        String[] widthFTab= widthF.split(",");
        String[] heightFTab = heightF.split(",");

        int tempLon;
        int tempLat;
        int tempWidth;
        int tempHeigth;
        navNext navNext;
        navPrev navPrev;
        navSave navSave;
        //creation des boutton

        for(int i = 0; i < navFname.length; i++)
        {
            if(i==0){
                navNext=new navNext(navFname[i],Integer.parseInt(lonFtab[i]),Integer.parseInt(latFTab[i]),Integer.parseInt(widthFTab[i]),Integer.parseInt(heightFTab[i]));
            }
            if(i==1){
                navPrev=new navPrev(navFname[i],Integer.parseInt(lonFtab[i]),Integer.parseInt(latFTab[i]),Integer.parseInt(widthFTab[i]),Integer.parseInt(heightFTab[i]));
            }
            if(i==2){
                navSave=new navSave(navFname[i],Integer.parseInt(lonFtab[i]),Integer.parseInt(latFTab[i]),Integer.parseInt(widthFTab[i]),Integer.parseInt(heightFTab[i]));
            }


        }


        format=new String[nomTab.length];
        getFormat(viewName,nom2);
        textField=new JTextField[nomTab.length];
        System.out.println("ici");
        for(int i = 0; i < nomTab.length; i++)
        {
            tempLon=Integer.parseInt(lonTab[i]);
            tempLat=Integer.parseInt(latTab[i]);
            tempWidth= Integer.parseInt(widthTab[i]);
            tempHeigth=Integer.parseInt(heightTab[i]);
            System.out.println(firstData[i]+"-----"+i);
            textField[i] = new JTextField(firstData[i]);

            textField[i].setBounds(tempLon,tempLat, tempWidth, tempHeigth);
            controllerFrame.add(textField[i]);

        }




        controllerFrame.setVisible(true);
        pan2.repaint();
    }















    private void getFormat(String viewName,String nom2) {

        BufferedReader fichier = null;
        try {

            fichier = new BufferedReader(new FileReader("src/donnee/"+viewName+".csv"));

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String ligne="1";
        String[] ligneInside;
        String[] format=nom2.split(",");
        int i=0;
        String[] nomTab = nom2.split(",");
        String[] firstData;
        System.out.println("ici");
        while (i<2) {
            try {
                ligne = fichier.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ligneInside=ligne.split(";");

            if(i==0){

                for(int j = 0; j < nomTab.length; j++)
                {
                    for(int k = 0; k <ligneInside.length; k++)
                    {
                        if(ligneInside[k].equals(nomTab[j])){

                            format[j]=k+"";
                            System.out.println(format[j]);
                        }
                    }

                }}
            firstData=new String[format.length];
            if(i==1){

                for(int f = 0; f < nomTab.length; f++)
                {
                    for(int l = 0; l <ligneInside.length;l++)
                    {
                        if(format[f].equals(l+"")){
                            firstData[f]=ligneInside[l];
                            System.out.println(firstData[f]);
                        }

                    }}}
            this.format=format;
            this.firstData=firstData;

            i++;

        }


    }







    Object[][] getRowData() {
        // TODO Auto-generated method stub

        DefaultTableModel model = new DefaultTableModel();
        Object[] rowData;
        Object[] columnNames;
        AbstractButton table = null;
        // set the model to the table




        BufferedReader fichier = null;
        try {
            fichier = new BufferedReader(new FileReader("donnee/"+viewData+".csv"));
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



                columnNames=new Object[ligneInside.length];
                if(i==0){

                    System.out.println(i);
                    for(int j = 0; j < ligneInside.length; j++)
                    {
                        System.out.println(ligneInside[j]);
                        System.out.println(i+"-"+j);
                        columnNames[j]=ligneInside[j];



                    }
                    model.setColumnIdentifiers(columnNames);


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


        System.out.println("Ici !");
        //new ControllerDefault.Default("1");


        pan.removeAll();
        //add your elements
        frame.revalidate();
        frame.repaint();
        viewDefault.view = "1";

    }


}