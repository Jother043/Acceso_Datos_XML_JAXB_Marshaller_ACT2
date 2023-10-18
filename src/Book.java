import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "book")
public class Libro {

    @XmlAttribute(name = "id")
    private String id;
    @XmlElement(name = "Author")
    private String autor;
    @XmlElement(name = "Title")
    private String titulo;
    @XmlElement(name = "Genre")
    private String genero;
    @XmlElement(name = "Price")
    private String precio;
    @XmlElement(name = "PublishDate")
    private Date publicacion;
    @XmlElement(name = "Description")
    private String descripcion;

    public Libro() {
    }

    public String getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getPrecio() {
        return precio;
    }

    public Date getPublicacion() {
        return publicacion;
    }
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id='" + id + '\'' +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", precio='" + precio + '\'' +
                ", publicacion='" + publicacion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
