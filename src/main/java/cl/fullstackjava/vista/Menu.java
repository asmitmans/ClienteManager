package cl.fullstackjava.vista;

import cl.fullstackjava.servicio.ArchivoServicio;
import cl.fullstackjava.servicio.ClienteServicio;
import cl.fullstackjava.servicio.ExportadorCsv;
import cl.fullstackjava.servicio.ExportadorTxt;

import java.util.Scanner;

public class Menu {

    private ClienteServicio clienteServicio;
    private ArchivoServicio archivoServicio;
    private ExportadorCsv exportadorCsv;
    private ExportadorTxt exportadorTxt;
    private String fileName;
    private String fileName1;
    private Scanner scanner;

    public Menu() {
        fileName = "Clientes";
        fileName1 = "DBClientes.csv";
        scanner = new Scanner(System.in);
    }

    public void iniciarMenu() {

    }

    public void listarCliente(){

    }

    public void agregarCliente() {

    }

    public void editarCliente() {

    }

    public void importarDatos() {

    }

    public void exportarDatos() {

    }

    public void terminarPrograma() {

    }

}
