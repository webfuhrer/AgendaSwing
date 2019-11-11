/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agendaventanas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CDMFP
 */
class AccesoFichero {
//private static String ruta="C:\\cuentacorriente\\agenda2.csv";
private static String separador=";";
    public static boolean grabarContacto(String ruta, Contacto c)
    {
        boolean correcto=true;
    try {
        FileWriter fw=new FileWriter(ruta, true);
        String linea=c.getNombre()+separador+c.getEmail()+separador+c.getTelefono()+"\n";
        fw.write(linea);
        fw.close();
    } catch (IOException ex) {
      correcto=false;
    }
       return correcto;
    }

    static ArrayList<Contacto> recuperarContactos(String ruta) {
        ArrayList<Contacto> lista=new ArrayList();
        
    try {
        FileReader fr=new FileReader(ruta);
        BufferedReader br=new BufferedReader(fr);
        String linea=br.readLine();
        while(linea!=null)
        {
            String[] datos=linea.split(separador);
            Contacto c=new Contacto(datos[0], datos[2],datos[1]);
            lista.add(c);
            linea=br.readLine();
        }
                
        
    } catch (FileNotFoundException ex) {
        Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
    }
    return lista;
    }

    
}
