package views;

import controller.ControllerFrame;

import java.io.*;
import java.util.*;
import java.util.Arrays;
public class ViewDefault {
    String view;
    ControllerFrame frame;
    boolean firstFrame =true;
    public ViewDefault(String view) {

        this.view = view;

        getView(view);
        //getViewAll();
        //getParams(view);

    }

    private void getViewAll() {
        // TODO Auto-generated method stub
        File folder = new File("src/system");
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }

    void getView(String view) {
        // TODO Auto-generated method stub
        try {

            BufferedReader fichier = new BufferedReader(new FileReader("src/system/"+view+".csv"));
            String ligne = new String();

            String[] ligneInside;
            Integer lon  ;
            Integer lat ;
            Integer width  ;
            Integer height ;
            while ((ligne) != null) {
                ligne = fichier.readLine();
                if(ligne != null){
                    ligneInside = ligne.split(";");
                    if(ligneInside[0].equals("Frame")){
                        width=Integer.parseInt(ligneInside[2]);
                        height=Integer.parseInt(ligneInside[3]);
                        frame=new ControllerFrame(ligneInside[1],width,height);
                        firstFrame=false;
                    }
                    else if(ligneInside[0].equals("BLinkV")){
                        lon=Integer.parseInt(ligneInside[2]);
                        lat=Integer.parseInt(ligneInside[3]);
                        width=Integer.parseInt(ligneInside[4]);
                        height=Integer.parseInt(ligneInside[5]);
                        frame.createBLinkV(this,ligneInside[1],lon,lat,width, height,ligneInside[6]);
                    }
                    else if(ligneInside[0].equals("List")){
                        lon=Integer.parseInt(ligneInside[2]);
                        lat=Integer.parseInt(ligneInside[3]);
                        width=Integer.parseInt(ligneInside[4]);
                        height=Integer.parseInt(ligneInside[5]);
                        frame.createJTableV(this, ligneInside[1],lon,lat,width, height, ligneInside[6]);
                    }
                    else if(ligneInside[0].equals("BWin")){
                        lon=Integer.parseInt(ligneInside[2]);
                        lat=Integer.parseInt(ligneInside[3]);
                        width=Integer.parseInt(ligneInside[4]);
                        height=Integer.parseInt(ligneInside[5]);
                        frame.createBWin(ligneInside[1],lon,lat,width, height,ligneInside[6]);
                    }
                    else if(ligneInside[0].equals("Form")){
                        frame.createForm(this,ligneInside[1],ligneInside[2],ligneInside[3],ligneInside[4], ligneInside[5],ligneInside[6],ligneInside[7],ligneInside[8],ligneInside[9],ligneInside[10],ligneInside[11]);
                    }
                }
            }
            fichier.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public String getView() {
        return this.view;
    }
    private String[] getParams(String view) {
        int i;
        ArrayList params = null;
        try {
            BufferedReader fichier = new BufferedReader(new FileReader("src/system/" + view + ".csv"));

            String line = new String();

            String[] lineSplited;
            params = new ArrayList();
            i = 0;
            while ((line) != null) {
                System.out.println(line);
                lineSplited = line.split(";");System.out.println(lineSplited);
                params.add(lineSplited);
                line = fichier.readLine();
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(params.get(0));
        return new String[0];
    }
}
