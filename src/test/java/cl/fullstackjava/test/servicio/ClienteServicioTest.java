package cl.fullstackjava.test.servicio;

import cl.fullstackjava.modelo.Cliente;
import cl.fullstackjava.servicio.ClienteServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClienteServicioTest {

    private ClienteServicio clienteServicio;

    @BeforeEach
    public void setup() {
        this.clienteServicio = new ClienteServicio();
    }

    @Test
    public void agregarClienteTest() {
        Cliente cliente = new Cliente("123456789-9","Juan","Perez","5");
        clienteServicio.agregarCliente(cliente);
        // Comprobar que la lista de clientes tiene un cliente
        assertEquals(1,clienteServicio.listarClientes().size());
        // Comprobar que la lista tiene el cliente agregado
        assertEquals(cliente,clienteServicio.obtenerClientePorRun("123456789-9"));
    }

    @Test
    public void agregarClienteNullTest() {
        // Añadir cliente null y comprobar si se genera la Exception esperada
        assertThrows(IllegalArgumentException.class, () -> clienteServicio.agregarCliente(null));
         // Comprobar que la lista de clientes sigue vacía
        assertEquals(0,clienteServicio.listarClientes().size());
    }

}
