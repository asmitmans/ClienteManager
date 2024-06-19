package cl.fullstackjava.vista;

import cl.fullstackjava.modelo.CategoriaEnum;
import cl.fullstackjava.modelo.Cliente;
import cl.fullstackjava.servicio.*;

import java.io.File;
import java.util.List;
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
        clienteServicio = new ClienteServicio();
        archivoServicio = new ArchivoServicio();
        exportadorCsv = new ExportadorCsv();
        exportadorTxt = new ExportadorTxt();
        fileName = "Clientes";
        fileName1 = "DBClientes.csv";
        scanner = new Scanner(System.in);
    }

    public void iniciarMenu() {

        int command = 0;
        do {
            mostrarMenu();
            command = leerCommandInt();

            if (command == 1) {
                listarCliente();
            } else if (command == 2) {
                agregarCliente();
            } else if (command == 3) {
                editarCliente();
            } else if (command == 4) {
                importarDatos();
            } else if (command == 5) {
                exportarDatos();
            } else if (command == 6) {
                terminarPrograma();
            }

        } while (command != 6);

    }

    public void mostrarMenu() {
        String menu =
                "1. Listar Clientes\n" +
                        "2. Agregar Cliente\n" +
                        "3. Editar Cliente\n" +
                        "4. Cargar Datos\n" +
                        "5. Exportar Datos\n" +
                        "6. Salir\n" +
                        "Ingrese una opción: ";
        System.out.print(menu);
    }

    public int leerCommandInt() {
        try {
            return Integer.valueOf(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opcion ingresada invalida");
        }
        return 0;
    }

    public void listarCliente() {
        for(Cliente cliente : clienteServicio.listarClientes()) {
            System.out.println(cliente);
        }
        System.out.println();
    }

    public void agregarCliente() {

        System.out.println("-------------Crear Cliente-------------\n");

        System.out.println("Ingresa RUN del Cliente:");
        String runCliente = scanner.nextLine();
        System.out.println("Ingresa Nombre del Cliente:");
        String nombreCliente = scanner.nextLine();
        System.out.println("Ingresa Apellido del Cliente:");
        String apellidoCliente = scanner.nextLine();
        System.out.println("Ingresa años como Cliente:");
        String aniosCliente = scanner.nextLine();
        if (aniosCliente.split(" ").length > 1) {
            aniosCliente = aniosCliente.split(" ")[0];
        }
        Cliente cliente = new Cliente(runCliente,nombreCliente,apellidoCliente,aniosCliente);
        clienteServicio.agregarCliente(cliente);

        System.out.println("---------------------------------------");
    }

    public void editarCliente() {

        int command = 0;
        int op = 0;

        menuEditarCliente();
        command = leerCommandInt();
        if (command == 1) {
            Cliente cliente = obtenerClientePorRun();
            menuCambiarEstado(cliente);
            op = leerCommandInt();
            cambiarCategoriaCliente(cliente,op);
        } else if (command == 2) {
            Cliente cliente = obtenerClientePorRun();
            menuModificarDatos(cliente);
            op = leerCommandInt();
            modificarDatosCliente(cliente, op);
        } else {
            System.out.println("opcion ingresada invalida");
        }
    }

    public Cliente obtenerClientePorRun() {

        System.out.println("Ingrese RUN del Cliente a editar:");
        String runCliente = scanner.nextLine();
        Cliente cliente = clienteServicio.obtenerClientePorRun(runCliente);
        if (cliente == null) {
            System.out.println("RUN ingresado no encontrado");
            return null;
        }

        return cliente;
    }

    public void menuEditarCliente() {
        System.out.println("-------------Editar Cliente-------------");
        System.out.println("Seleccione qué desea hacer:");
        System.out.println("1.-Cambiar el estado del Cliente");
        System.out.println("2.-Editar los datos ingresados del Cliente\n");
        System.out.println("Ingrese opcion:");
    }

    public void menuCambiarEstado(Cliente cliente) {
        System.out.println("-----Actualizando estado del Cliente----");
        System.out.println("El estado actual es: " + cliente.getNombreCategoria());
        if (cliente.getNombreCategoria().equals(CategoriaEnum.Activo)) {
            System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo");
        } else {
            System.out.println("1.-Si desea cambiar el estado del Cliente a Activo");
        }
        System.out.println("2.-Si desea mantener el estado del cliente " + cliente.getNombreCategoria());
        System.out.println();
        System.out.println("Ingrese opcion: ");
    }

    public void cambiarCategoriaCliente(Cliente cliente, int op) {
        if (op == 1) {
            if (cliente.getNombreCategoria().equals(CategoriaEnum.Activo)) {
                clienteServicio.cambiarCategoriaCliente(cliente, CategoriaEnum.Inactivo);
            } else {
                clienteServicio.cambiarCategoriaCliente(cliente, CategoriaEnum.Activo);
            }
        } else if (op!=2) {
            System.out.println("opcion ingresada invalida");
        }
    }

    public void menuModificarDatos(Cliente cliente) {
        System.out.println("----Actualizando datos del Cliente-----");
        System.out.println("1.-El RUN del Cliente es: " + cliente.getRunCliente());
        System.out.println("2.-El Nombre del Cliente es: " + cliente.getNombreCliente());
        System.out.println("3.-El Apellido del Cliente es: " + cliente.getApellidoCliente());
        System.out.println("4.-Los años como Cliente son: " + cliente.getAniosCliente() + " años");
        System.out.println();
        System.out.print("Ingrese opcion a editar de los datos del cliente:");
    }

    public void modificarDatosCliente(Cliente cliente, int op) {
        if (op == 1) {
            System.out.println("Ingrese nuevo RUN del Cliente: ");
            String nuevoRun = scanner.nextLine();
            clienteServicio.actualizarRunCliente(cliente, nuevoRun);
        } else if (op == 2) {
            System.out.println("Ingrese nuevo Nombre del Cliente: ");
            String nuevoNombre = scanner.nextLine();
            clienteServicio.actualizarNombreCliente(cliente, nuevoNombre);
        } else if (op == 3) {
            System.out.println("Ingrese nuevo Apellido del Cliente: ");
            String nuevoApellido = scanner.nextLine();
            clienteServicio.actualizarApellidoCliente(cliente, nuevoApellido);
        } else if (op == 4) {
            System.out.println("Ingrese años como Cliente: ");
            String nuevoAnios = scanner.nextLine();
            clienteServicio.actualizarAniosCliente(cliente, nuevoAnios);
        } else {
            System.out.println("opcion ingresada invalida");
        }
    }

    public void importarDatos() {
        System.out.println("----------------Cargar Datos-------------------\n");
        System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:\n");
        String pathArchivo = scanner.nextLine();
        pathArchivo += File.separator + fileName1;
        System.out.println("-----------------------------------------------\n");

        List<Cliente> clientesImportados = archivoServicio.cargarDatos(pathArchivo);
        if (clientesImportados != null && !clientesImportados.isEmpty()) {
            clienteServicio.setListaClientes(clientesImportados);
            System.out.println("Datos cargados correctamente en la lista");
        } else {
            System.out.println("No se encontraron datos para importar o hubo un error al cargar los datos.");
        }
    }

    public void exportarDatos() {
        System.out.println("---------Exportar Datos-----------\n");
        System.out.println("Seleccione el formato a exportar: \n");
        System.out.println("1.-Formato csv");
        System.out.println("2.-Formato txt");
        System.out.println();
        System.out.println("Ingrese una opción para exportar:");
        int op = leerCommandInt();
        System.out.println("-----------------------------------------------\n");
        System.out.println("---------Exportar Datos-----------\n");
        if (op==1) {
            System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.csv:");
            String pathFile = scanner.nextLine();
            pathFile += File.separator + fileName.toLowerCase() + ".csv";
            exportadorCsv.exportar(pathFile,clienteServicio.listarClientes());
        } else if (op==2) {
            System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.txt:");
            String pathFile = scanner.nextLine();
            pathFile += File.separator + fileName.toLowerCase() + ".txt";
            exportadorTxt.exportar(pathFile,clienteServicio.listarClientes());
        }
    }

    public void terminarPrograma() {
        System.out.println("Cerrando...");
    }

}

