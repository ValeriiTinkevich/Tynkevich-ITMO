package managers;

import collections.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileManager {
    public String fileName;
    private final XStream xStream;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileManager(String fileName) {
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
        if (!fileName.equals("")) {
            File file = new File(fileName);
            try (FileInputStream fis = new FileInputStream(file)) {
                BufferedInputStream bis = new BufferedInputStream(fis);
                xStream.setMode(XStream.NO_REFERENCES);
                xStream.addPermission(AnyTypePermission.ANY);
                xStream.allowTypeHierarchy(List.class);
                xStream.allowTypeHierarchy(String.class);
                xStream.ignoreUnknownElements();
                StringBuilder xml = new StringBuilder();
                while (bis.available() > 0) {
                    xml.append((char) bis.read());
                }
                ArrayList<Organization> orglist = (ArrayList<Organization>) xStream.fromXML(xml.toString());
                Validator validator = new Validator(orglist);
                return validator.validate();
            } catch (FileNotFoundException e) {
                Console.println(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ConversionException e) {
                Console.printError("File has unmatched types!");
            }
        }
        return new ArrayList<>();
    }

    public void writeCollection(ArrayList<Organization> collection) {
        if (!fileName.equals("")) {
            try (FileOutputStream collectionFileWriter = new FileOutputStream(fileName)) {

                String xml = xStream.toXML(new ArrayList<>(collection));
                byte[] b = xml.getBytes();
                collectionFileWriter.write(b);

                Console.println("Collection was successfully added to the file!");
            } catch (IOException exception) {
                Console.printError("File is a directory or can't be opened!");
            }
        } else Console.printError("Filename is wrong or corrupted!");
    }
}
