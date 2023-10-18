import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "book")
public class Book {

    @XmlAttribute(name = "id")
    private String id;
    @XmlElement(name = "Author")
    private String author;
    @XmlElement(name = "Title")
    private String title;
    @XmlElement(name = "Genre")
    private String genre;
    @XmlElement(name = "Price")
    private String price;
    @XmlElement(name = "PublishDate")
    private Date publishDate;
    @XmlElement(name = "Description")
    private String description;

    public Book() {
    }

    public String getId() {
        return id;
    }

    public String getAutor() {
        return author;
    }

    public String getTitulo() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getPrice() {
        return price;
    }

    public Date getPublishDate() {
        return publishDate;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Libro " + "\n" +
                "   id: " + id + "\n" +
                "   autor: " + author + "\n" +
                "   titulo: " + title + "\n" +
                "   genero: " + genre + "\n" +
                "   precio: " + price + "\n" +
                "   publicacion: " + publishDate + "\n" +
                "   descripcion: " + description + "\n";
    }
}
