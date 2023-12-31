import com.sun.org.apache.xml.internal.serialize.LineSeparator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class XmlToTxt {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        boolean salir = false;
        //Menu
        do {
            try {
                menu();
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:

                            System.out.println("Introduce el nombre del fichero XML: ");
                            String fileName = sc.next();
                            System.out.println("Introduce el nombre del fichero txt: ");
                            String destiFile = sc.next();
                            xmlToTxt(fileName, destiFile);

                        break;
                    case 2:
                        System.out.println("Saliendo...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                        break;
                }
            } catch (JAXBException | XmlException | IOException e ) {
                System.err.println(e.getMessage());
            }catch (NumberFormatException | InputMismatchException e){
                System.err.println("Error, introduce un número");
                sc.nextLine();
            }
        } while (!salir);

    }

    /**
     * Recupera un coche de un fichero XML y lo pasa a un fichero txt
     *
     * @throws JAXBException;
     * @throws IOException;
     * @throws XmlException;  Excepción propia.
     */
    public static void xmlToTxt(String fileName, String destiFile) throws JAXBException, IOException, XmlException {
        File file = new File(fileName);
        validacionXml(file);
        JAXBContext jaxbContext = JAXBContext.newInstance(BookList.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        BookList bookList = (BookList) jaxbUnmarshaller.unmarshal(file);
        //Try with resources para cerrar el FileWriter al finalizar.

        try (FileWriter fw = new FileWriter(destiFile)) {
            for (Book book : bookList.getBooks()) {
                fw.write("id: " + book.getId() + "\n");
                fw.write("titulo: " + book.getTitulo() + "\n");
                fw.write("autor: " + book.getAutor() + "\n");
                fw.write("Genero: " + book.getGenre() + "\n");
                fw.write("Descripción: " + book.getDescription() + "\n");
                fw.write("Precio: " + book.getPrice() + "\n");
                fw.write("Fecha de publicación: " + book.getPublishDate() + "\n");
                fw.write("-----------------------------\n");
                System.out.println(book);

                if (!book.getId().isEmpty()) {
                    System.out.println("-----------------------------");
                    System.out.println("El book con id (" + book.getId() + ") se ha añadido al fichero Catalogo.txt");
                    System.out.println(LineSeparator.Windows);
                } else {
                    throw new XmlException("El book no tiene id");
                }
            }
        }
    }

    /**
     * Valida si el fichero xml pasado por parámetro existe.
     *
     * @param file;
     * @throws XmlException Excepción propia.
     */
    public static void validacionXml(File file) throws XmlException {
        if (file.exists()) {
            System.out.println("El fichero existe y se va a proceder a convertirlo a txt");
        } else {
            throw new XmlException("El fichero xml especificado no existe o no se encuentra en la ruta especificada");
        }
    }

    /**
     * Muestra el menú
     */
    public static void menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("1. Convertir XML a TXT\n");
        sb.append("2. Salir\n");
        sb.append("Elige una opción: ");
        System.out.println(sb.toString());
    }

}
