package managers;

import collections.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public String fileName;
    private final XStream xStream;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public FileReader(String fileName) {
        this.fileName = fileName;
        xStream = new XStream();
        xStream.alias("address", Address.class);
        xStream.alias("coordinates", Coordinates.class);
        xStream.alias("organization", Organization.class);
        xStream.alias("organizationType", OrganizationType.class);
        xStream.alias("organizations", CollectionManager.class);
        xStream.alias("town", Location.class);

        xStream.addImplicitCollection(CollectionManager.class, "organizationCollection");
        xStream.addPermission(AnyTypePermission.ANY);
        xStream.setMode(XStream.NO_REFERENCES);
        xStream.addPermission(NoTypePermission.NONE);
        xStream.addPermission(NullPermission.NULL);
        xStream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        xStream.allowTypeHierarchy(List.class);
        xStream.allowTypeHierarchy(String.class);

        xStream.ignoreUnknownElements();

    }

    public ArrayList<Organization> readCollection() {
        if(!fileName.equals("")) {
            try(Scanner collectionFileScanner = new Scanner(new File(fileName))) {
                xStream.setMode(XStream.NO_REFERENCES);
                xStream.addPermission(AnyTypePermission.ANY);
                xStream.allowTypeHierarchy(List.class);
                xStream.allowTypeHierarchy(String.class);
                xStream.ignoreUnknownElements();
                StringBuilder xml = new StringBuilder();
                while(collectionFileScanner.hasNext()){
                    xml.append(collectionFileScanner.nextLine());
                }
                return (ArrayList<Organization>) xStream.fromXML(xml.toString());
            } catch (FileNotFoundException e) {
                Console.println(e.getMessage());
            }
        }
        return new ArrayList<>();
    }

    public void writeCollection(ArrayList<Organization> collection) {
        if (!fileName.equals("")) {
            try (FileWriter collectionFileWriter = new FileWriter(fileName)) {

                String xml = xStream.toXML(new ArrayList<>(collection));
                collectionFileWriter.write(xml);

                Console.println("Collection was successfully added to the file!");
            } catch (IOException exception) {
                Console.printError("File is a directory or can't be opened!");
            }
        } else Console.printError("Filename is wrong or corrupted!");
    }
}
