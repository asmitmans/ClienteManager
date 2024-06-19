package cl.fullstackjava.servicio;

import cl.fullstackjava.modelo.CategoriaEnum;
import cl.fullstackjava.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteServicio {

    List<Cliente> listaClientes;

    public ClienteServicio() {
        listaClientes = new ArrayList<>();
    }

    public List<Cliente> listarClientes() {
        return listaClientes;
    }

    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public Cliente obtenerClientePorRun(String run) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getRunCliente().equals(run)) {
                return cliente;
            }
        }
        return null;
    }

    public void cambiarCategoriaCliente(Cliente cliente, CategoriaEnum nuevaCategoria) {
        cliente.setNombreCategoria(nuevaCategoria);
    }

    public void actualizarRunCliente(Cliente cliente, String nuevoRun) {
        cliente.setRunCliente(nuevoRun);
    }

    public void actualizarNombreCliente(Cliente cliente, String nuevoNombre) {
        cliente.setNombreCliente(nuevoNombre);
    }

    public void actualizarApellidoCliente(Cliente cliente, String nuevoApellido) {
        cliente.setApellidoCliente(nuevoApellido);
    }

    public void actualizarAniosCliente(Cliente cliente, String nuevoAnios) {
        cliente.setAniosCliente(nuevoAnios);
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
}
