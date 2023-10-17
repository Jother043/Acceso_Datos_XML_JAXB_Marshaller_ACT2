import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Book")
public class Libro {

    private String autor;
    private String titulo;
    private String genero;
    private String precio;
    private String publicacion;
    private String descripcion;

    public Libro(String autor, String titulo, String genero, String precio, String publicacion, String descripcion) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.precio = precio;
        this.publicacion = publicacion;
        this.descripcion = descripcion;
    }

    public Libro() {
    }
    @XmlElement(name = "Author")
    public String getAutor() {
        return autor;
    }

    @XmlElement(name = "Title")
    public String getTitulo() {
        return titulo;
    }

    @XmlElement(name = "Genre")
    public String getGenero() {
        return genero;
    }

    @XmlElement(name = "Price")
    public String getPrecio() {
        return precio;
    }

    @XmlElement(name = "Publish_date")
    public String getPublicacion() {
        return publicacion;
    }
    @XmlElement(name = "Description")
    public String getDescripcion() {
        return descripcion;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", precio='" + precio + '\'' +
                ", publicacion='" + publicacion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
