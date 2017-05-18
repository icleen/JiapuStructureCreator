package main;

import import_export.ImageExporter;
import import_export.ImageImporter;
import python_port.PythonImporter;
import structure.Images;

import javax.management.relation.InvalidRelationIdException;

/**
 * Created by iclee141 on 5/9/17.
 */
public class Main {

    public static void main(String[] args) {
        Images images = null;
        try {
            images = new PythonImporter().importToStructure(args[0], args[1], args[2]);
        } catch (InvalidRelationIdException e) {
            e.printStackTrace();
        }
        new ImageExporter().exportImages(args[3], images);
    }

}
