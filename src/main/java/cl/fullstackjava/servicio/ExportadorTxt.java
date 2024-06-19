package cl.fullstackjava.servicio;

import cl.fullstackjava.modelo.Cliente;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExportadorTxt extends Exportador{
    @Override
    public void exportar(String pathFile, List<Cliente> listaClientes) {

        File archivo = new File(pathFile);
        File directorio = archivo.getParentFile();

        if (!directorio.exists()) {
            System.out.println("El directorio especificado no existe.");
            return;
        }

        if (!directorio.canWrite()) {
            System.out.println("No tienes permisos para escribir en el directorio especificado.");
            return;
        }

        PrintWriter pw = null;
        FileWriter fw = null;
        try {
            archivo.createNewFile();
            fw = new FileWriter(archivo);
            pw = new PrintWriter(fw);
            for (Cliente cliente : listaClientes) {
                pw.println(cliente.toString());
            }
            System.out.println("Datos de clientes exportados correctamente en formato txt.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}
