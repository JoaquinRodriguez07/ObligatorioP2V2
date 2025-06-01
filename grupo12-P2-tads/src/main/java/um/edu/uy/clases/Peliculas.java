package um.edu.uy.clases;
import lombok.Data;
import java.util.Date;

@Data
public class Peliculas {

    private String id;
    private String titulo;
    private String idiomaOriginal;
    private String tituloOriginal;
    private String coleccion;
    //generos
    private Double presupuesto;
    private Double ingresos;
    private Date fechaEstreno;
    private Double duracion;
    //private participantes

}
