package cl.fullstackjava.servicio;

import cl.fullstackjava.modelo.Cliente;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExportadorCsv extends Exportador{

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
        String sufixAnios;
        try {
            archivo.createNewFile();
            fw = new FileWriter(archivo);
            pw = new PrintWriter(fw);
            for (Cliente cliente : listaClientes) {
                sufixAnios = " año";
                if (Integer.parseInt(cliente.getAniosCliente()) > 1) {
                    sufixAnios = " años";
                }
                String linea = String.join(",",cliente.getRunCliente(),cliente.getNombreCliente(),
                        cliente.getApellidoCliente(),cliente.getAniosCliente()+sufixAnios,cliente.getNombreCategoria().toString());
                pw.println(linea);
            }
            System.out.println("Datos de clientes exportados correctamente en formato csv.");
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
