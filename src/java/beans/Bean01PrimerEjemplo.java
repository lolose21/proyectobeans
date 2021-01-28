package beans;

public class Bean01PrimerEjemplo {
// metodos para dibujar en la pagina/s

    public String getSaludo() {
        //devolveremos el codigo que deseamos dibujar
        return "<h1 style='color:red'>Saludo desde Java Beans</h1>";

    }

    public String getSaludoPersonal(String nombre) {
        return "<h1 style='color:blue'>BIENVENIDO , "
                + nombre + "</h1>";
    }
}
