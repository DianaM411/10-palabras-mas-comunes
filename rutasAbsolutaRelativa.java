package com.diana;

import java.io.File;

public class Main {


    public static void main(String[] args) {

        String rutaRelativa = "Documentos\\frases.txt";
        String pwd = System.getProperty("user.dir");//ruta directorio actual de trabajo
        String rutaAbsoluta = pwd + File.separator + rutaRelativa;
        System.out.println("Ruta absoluta es: " + rutaAbsoluta);

        File fileConRutaRelativa = new File(rutaRelativa);
        File fileConRutaAbsoluta = new File(rutaAbsoluta);

        if (fileConRutaRelativa.exists() || fileConRutaAbsoluta.exists())
            System.out.println("El fichero existe");
        else System.out.println("El fichero NO existe");

    }
}
