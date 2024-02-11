/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act1.ejercicios;

import com.mycompany.psp_ud04_act1.view.Vista;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;

/**
 *
 * @author manuelmsni
 */
/**
 * Ejercicio Formulario PHP
 *   • Verificar instalación XAMPP o similar y localizar carpeta htdocs
 *   • Crear una carpeta nueva llamada php y dentro los archivos index.html y ejemplo.php
 *   • Copiar y entender el html y el php siguientes.
 * 
 * Abrir en el navegador la ubicación en el host local del servidor index.html
 */
public class Ej6 {
    
    private static final Logger log = Logger.getLogger(Ej6.class.getName());
    
    private static String[] rutasComunes = {
        "C:\\xampp",
        "D:\\xampp",
        "E:\\xampp",
        "F:\\xampp",
        "/Applications/XAMPP",
        "/opt/lampp"
    };
    
    Vista v;
    
    public Ej6(Vista v){
        this.v = v;
        
        File htcdocs = localizaHtdocs();
        if(htcdocs==null) return;
        
        File phpDir = crearDirectorioPhp(htcdocs);
        if(phpDir==null) return;
        
        crearHtml(phpDir);
        crearPhp(phpDir);
        abrirEnNavegador();
    }
    
    private File localizaRuta(){
        for (String path : rutasComunes) {
            File xamppFolder = new File(path);
            File ruta = comprobarRuta(xamppFolder);
            if(ruta!=null) return ruta;
        }
        return null;
    }
    
    private File comprobarRuta(File path){
        if (path.exists() && path.isDirectory()) {
            File htdocsFolder = new File(path, "htdocs");
            if (htdocsFolder.exists() && htdocsFolder.isDirectory()) {
                return htdocsFolder;
            }
        }
        return null;
    }
    
    private File localizaHtdocs(){
        File ruta = localizaRuta();
        if(ruta == null) ruta = comprobarRuta(v.solicitaDirectorio());
        return ruta;
    }
    
    private File crearDirectorioPhp(File parentFolder){
        return new File(parentFolder, "\\php");
    }
    
    private static String htmlContent = """
    <html>
        <body>
            <form action="ejemplo.php" method="post">
                <p>Introduce Nombre: <input name="nombre" type="txt" size="15"></p>
                <p>Introduce Apellidos: <input name="apellidos" type="txt" size="15"></p>
                <p>
                    <input type="submit" name="ver" value="ver">
                    <input type="reset" value="reset">
                </p>
            </form>
        </body>
    </html>
    """; 
    
    private void crearHtml(File parentFolder){
        writeFile(parentFolder.getPath() + "\\index.html", htmlContent);
    }
    
    String phpContent = """
    <?php
        \t$nom=$_POST["nombre"];
        \t$ape=$_POST["apellidos"];
        \techo "Bienvenido $nom de apellido: $ape";
    ?>
    """;
    
    private void crearPhp(File parentFolder){
        writeFile(parentFolder.getPath() + "\\ejemplo.php", phpContent);
    }
    
    private void writeFile(String filePath, String content) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(content);
            writer.close();
            v.imprime("Archivo creado: " + filePath);
        } catch (IOException e) {
            log.warning("Ocurrió un error al escribir en el archivo: " + filePath);
            e.printStackTrace();
        }
    }
    
    public void abrirEnNavegador() {
        if (Desktop.isDesktopSupported()) {
            try {
                String url = "http://localhost/php/index.html";
                Desktop.getDesktop().browse(new URI(url));
                v.imprime("Navegador abierto en: " + url);
            } catch (Exception e) {
                e.printStackTrace();
                log.warning("No se pudo abrir el navegador: " + e.getMessage());
            }
        } else {
            v.imprime("La funcionalidad de escritorio no es compatible.");
        }
    }

}
