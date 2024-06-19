package cl.fullstackjava.modelo;

public class Cliente {
    private String runCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String aniosCliente;
    private CategoriaEnum nombreCategoria;

    public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente) {
        this.runCliente = runCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.aniosCliente = aniosCliente;
        this.nombreCategoria = CategoriaEnum.Activo;
    }

    public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente, CategoriaEnum categoriaEnum) {
        this.runCliente = runCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.setAniosCliente(aniosCliente);
        this.nombreCategoria = categoriaEnum;
    }

    public String getRunCliente() {
        return runCliente;
    }

    public void setRunCliente(String runCliente) {
        this.runCliente = runCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getAniosCliente() {
        return aniosCliente;
    }

    public void setAniosCliente(String aniosCliente) {
        this.aniosCliente = aniosCliente;
    }

    public CategoriaEnum getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(CategoriaEnum nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public String toString() {
        String sufixAnios = " año";
        if (Integer.parseInt(aniosCliente) > 1) {
            sufixAnios = " años";
        }
        return "-------------Datos del Cliente-------------\n\n" +
                "RUN del Cliente: " + runCliente + "\n" +
                "Nombre del Cliente: " + nombreCliente + "\n" +
                "Apellido del Cliente: " + apellidoCliente + "\n" +
                "Años como Cliente: " + aniosCliente + sufixAnios + "\n" +
                "Categoría del Cliente: " + nombreCategoria + "\n\n" +
                "-------------------------------------------";
    }

}
