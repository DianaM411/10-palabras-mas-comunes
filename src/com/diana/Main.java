package com.diana;
/*Ejercicio B7 - Estadísticas
        Implementa un programa que lea un documento de texto y muestre por pantalla algunos datos
        estadísticos: nº de líneas, nº de palabras, nº de caracteres y cuáles son las 10 palabras más
        comunes (y cuántas veces aparecen). Prueba el programa con los archivos de la carpeta ‘Libros’.*/

import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            //el archivo que queremos leer
            String pwd = System.getProperty("user.dir");//ruta directorio actual de trabajo
            File archivo = new File(pwd + File.separator + "Documentos" + File.separator + "frases.txt");
            sc = new Scanner(archivo);
            //declaramos variables
            int palabras = 0;
            int lineas = 0;
            int caracteres = 0;
            //donde almacenamos top 10 palabras
            LinkedHashMap<String, Integer> wordcount = new LinkedHashMap<String, Integer>();


            while (sc.hasNextLine()) {//mientras hay mas lineas del archivo para leer
                lineas++;//contamos lineas
                String line = sc.nextLine();//leemos y guardamos en un String cada linea del archivo
                caracteres += line.length();//contamos caracteres (nr de caracteres es la longitud de la linea)
                String saltador = " .,;\"\n\r\t"; //Las palabras van separadas por carácteres en blanco, comas, puntos, punto y coma, salto de línea y tabuladores.
                palabras += new StringTokenizer(line, saltador).countTokens();//contamos palabras

                line = line.toLowerCase(); // convert to lower case
                String[] words = line.split("\\s+"); //split the line on whitespace, would return an array of words
ñ
                for (String word : words) {
                    if (word.length() == 0) {
                        continue;
                    }

                    Integer occurences = wordcount.get(word);

                    if (occurences == null) {
                        occurences = 1;
                    } else {
                        occurences++;
                    }

                    wordcount.put(word, occurences);
                }

            }

            //imprimimos numero de lineas, palabras y caracteres
            System.out.println(" ");
            System.out.println("Numero de lineas: " + lineas);
            System.out.println("Numero de palabras: " + palabras);
            System.out.println("Numero de caracteres: " + caracteres);
            System.out.println("Top 10 palabras: ");

            ArrayList<Integer> values = new ArrayList<Integer>();
            values.addAll(wordcount.values());

            Collections.sort(values, Collections.reverseOrder());

            int last_i = -1;


            for (Integer i : values.subList(0, 9)) {
                if (last_i == i) // without duplicates
                    continue;
                last_i = i;


                for (String s : wordcount.keySet()) {

                    if (wordcount.get(s) == i) // which have this value
                        System.out.println(s + " " + i);
                }
            }

        } catch (Exception e) {  //manejamos excepciones
            e.printStackTrace();
        } finally {
            sc.close();  //cerramos el scanner
        }
    }
}
