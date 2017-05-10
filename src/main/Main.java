package main;

import import_export.ImageExporter;
import import_export.ImageImporter;
import structure.Images;

/**
 * Created by iclee141 on 5/9/17.
 */
public class Main {

    public static void main(String[] args) {
        Images images = new ImageImporter().importToStructure(args[0], args[1], args[2]);
        new ImageExporter().exportImages(args[3], images);
    }

}
