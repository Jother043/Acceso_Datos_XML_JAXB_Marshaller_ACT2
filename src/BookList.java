import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Catalog")
public class BookList {

    private List<Libro> books;

    public BookList(List<Libro> books) {
        this.books = new ArrayList<>();
    }

    public BookList() {
    }

    @XmlElement(name = "Book")
    public List<Libro> getBooks() {
        return books;
    }

    public void insertBooks(Libro l) {
        books.add(l);
    }
}
