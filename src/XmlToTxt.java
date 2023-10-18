import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CrearXML {
    public static void main(String[] args) {
        try {
            xmlToBookList();
        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void xmlToBookList() throws JAXBException, IOException {
        File file = new File("books.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(BookList.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        BookList bookList = (BookList) jaxbUnmarshaller.unmarshal(file);
        try (FileWriter fw = new FileWriter("Catalogo.txt")) {
            for (Libro libro : bookList.getBooks()) {
                fw.write("id: " + libro.getId() + "\n");
                fw.write("titulo: " + libro.getTitulo() + "\n");
                fw.write("autor: " + libro.getAutor() + "\n");
                fw.write("Genero: " + libro.getGenero() + "\n");
                fw.write("Descripción: " + libro.getDescripcion() + "\n");
                fw.write("Precio: " + libro.getPrecio() + "\n");
                fw.write("Fecha de publicación: " + libro.getPublicacion() + "\n");
                fw.write("-----------------------------\n");
            }
        }
    }

}
