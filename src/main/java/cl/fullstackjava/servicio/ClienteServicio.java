package cl.fullstackjava.servicio;

import cl.fullstackjava.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteServicio {

    List<Cliente> listaClientes;

    public ClienteServicio() {
        listaClientes = new ArrayList<>();
    }

    public void listarClientes() {
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }

    public void agregarCliente(String runCliente, String nombreCliente, String apellidoCliente, int aniosCliente) {
        if(listaClientes != null) {
            listaClientes.add(new Cliente(runCliente,nombreCliente,apellidoCliente,aniosCliente));
        }
    }

    public void editarCliente(int indice, String runCliente, String nombreCliente, String apellidoCliente, int aniosCliente) {
        if(indice > 0 && indice < listaClientes.size()) {
            listaClientes.set(indice, new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente));
        }
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
}
