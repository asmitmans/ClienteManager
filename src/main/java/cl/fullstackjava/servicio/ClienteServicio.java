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

    // Nota: modificado para gestionar toda la interaccion con el usuario en Menu
    // esto ademas reemplaza el getListaClientes.
    public List<Cliente> listarClientes() {
        return listaClientes;
    }

    public void agregarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente no puede ser nulo");
        }
        validarCliente(cliente);
        if(obtenerClientePorRun(cliente.getRunCliente())!=null) {
            throw new IllegalArgumentException("Ya existe un cliente con el RUN ingresado");
        }
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

    //Nota: En vez de crear el metodo editarCliente se considero mas eficiente y adecuado
    //crear un metodo por atributo.
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

    public void validarCliente(Cliente cliente) {
        if(cliente.getRunCliente() == null || cliente.getRunCliente().trim().isEmpty() ) {
            throw new IllegalArgumentException("El run no puede ser nulo o vacio");
        }
        if(cliente.getNombreCliente() == null || cliente.getNombreCliente().trim().isEmpty() ) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacio");
        }
        if(cliente.getApellidoCliente() == null || cliente.getApellidoCliente().trim().isEmpty() ) {
            throw new IllegalArgumentException("El apellido no puede ser nulo o vacio");
        }
        if(cliente.getAniosCliente() == null || cliente.getAniosCliente().trim().isEmpty() ) {
            throw new IllegalArgumentException("Los años como cliente no pueden ser nulos o vacios");
        }
        if(cliente.getNombreCategoria() == null) {
            throw new IllegalArgumentException("La categoria no puede ser nula");
        }
    }

}
