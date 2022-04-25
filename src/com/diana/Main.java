package com.diana;
/*Ejercicio B7 - Estadísticas
        Implementa un programa que lea un documento de texto y muestre por pantalla algunos datos
        estadísticos: nº de líneas, nº de palabras, nº de caracteres y cuáles son las 10 palabras más
        comunes (y cuántas veces aparecen). Prueba el programa con los archivos de la carpeta ‘Libros’.*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static HashMap<String, Integer> cuentaPalabras(String texto) throws FileNotFoundException {
        String saltador = " .,;\n\r\t";
        HashMap<String, Integer> letras = new HashMap<String, Integer>();
        java.util.Scanner teclado = new java.util.Scanner(new File(texto));
        String p;

        for (; teclado.hasNextLine();) {

            StringTokenizer linea = new StringTokenizer(teclado.nextLine(), saltador);

            for (; linea.hasMoreTokens();) {

                p = linea.nextToken();

                if (!letras.containsKey(p)) {
                    letras.put(p, 1);

                } else {
                    letras.put(p, letras.get(p) + 1);
                }
            }
        }
        return letras;
    }

    public static void main(String[] args) {
        Scanner sc = null;

        try {
        //el archivo que queremos leer
        File archivo = new File("C:\\Users\\diana\\OneDrive\\Desktop\\learnProgramming\\B7\\Documentos\\Libros\\lazarillo.txt");
        sc = new Scanner(archivo);
        //declaramos variables
        int palabras = 0;
        int lineas = 0;
        int caracteres = 0;
        String p;
        //Creamos un objeto de tipo HashMap
        Map<String, Integer> letras = new HashMap<String,Integer>();


            while (sc.hasNextLine()) {//mientras hay mas lineas del archivo para leer
                lineas++;//contamos lineas
                String line = sc.nextLine();//leemos y guardamos en un String cada linea del archivo
                caracteres += line.length();//contamos caracteres (nr de caracteres es la longitud de la linea)
                String saltador = " .,;\"\n\r\t"; //Las palabras van separadas por carácteres en blanco, comas, puntos, punto y coma, salto de línea y tabuladores.
                palabras += new StringTokenizer(line, saltador).countTokens();//contamos palabras

                StringTokenizer linea = new StringTokenizer(sc.nextLine(), saltador);

                for (; linea.hasMoreTokens();) {

                    p = linea.nextToken();

                    if (!letras.containsKey(p)) {
                        letras.put(p, 1);

                    } else {
                        letras.put(p, letras.get(p) + 1);
                    }
                }
            }

          /*  SortedMap map = new TreeMap(java.util.Collections.reverseOrder());
            map.putAll(letras);
            // Lee el TreeMap y te muestra los resultados en orden Descendente
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                Object key = iterator.next();
                System.out.println("Clave : " + key + " Valor :" + map.get(key));
            }*/



           //ValueComparator bvc =  new ValueComparator(letras);
          SortedMap map = new TreeMap(java.util.Collections.reverseOrder());
           // Map<String, Integer> map = new TreeMap<>();
            map.putAll(letras);
            System.out.println("After Sorting: ");
            Set set2 = map.entrySet();
            Iterator iterate2 = set2.iterator();
            while(iterate2.hasNext())
            {
                Map.Entry me2 = (Map.Entry)iterate2.next();
                System.out.print(me2.getValue() + ": ");
                System.out.println(me2.getKey());
            }

            //imprimimos numero de lenies, palabras y caracteres
            System.out.println("Numero de lineas: " + lineas);
            System.out.println("Numero de palabras: " + palabras);
            System.out.println("Numero de caracteres: " + caracteres);

           // System.out.println(cuentaPalabras("C:\\Users\\diana\\OneDrive\\Desktop\\learnProgramming\\B7\\Documentos\\Libros\\lazarillo.txt"));

        } catch (Exception e) {  //manejamos excepciones
            e.printStackTrace();
        } finally {
            sc.close();  //cerramos el scanner
        }
    }
}
