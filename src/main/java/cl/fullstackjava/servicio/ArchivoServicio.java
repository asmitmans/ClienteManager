package cl.fullstackjava.servicio;

import cl.fullstackjava.modelo.CategoriaEnum;
import cl.fullstackjava.modelo.Cliente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArchivoServicio extends Exportador{
    @Override
    public void exportar(String fileName, List<Cliente> listaClientes) {

    }

    public ArrayList<Cliente> cargarDatos(String pathFile) {

        File archivo = new File(pathFile);
        if(!archivo.exists()) {
            System.out.println("No existe el archivo en la ruta ingresada");
            return null;
        }

        // Lectura de datos desde archivo
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            String[] arrLinea;
            while ((linea = br.readLine()) != null) {
                arrLinea = linea.split(",");
                if(arrLinea.length==5) {
                    String runCliente = arrLinea[0];
                    String nombreCliente = arrLinea[1];
                    String apellidoCliente = arrLinea[2];
                    String aniosCliente = arrLinea[3].split(" ")[0];
                    CategoriaEnum nombreCategoria = CategoriaEnum.valueOf(arrLinea[4]);

                    listaClientes.add(new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, nombreCategoria));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null) {
                    br.close();
                }
                if(fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return listaClientes;
    }
}
