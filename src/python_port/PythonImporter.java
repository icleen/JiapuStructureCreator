package python_port;

import structure.Image;
import structure.Images;

import javax.management.relation.InvalidRelationIdException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by iclee141 on 5/18/17.
 */
public class PythonImporter {

    private static final String SPOUSE = "Couple";
    private static final String CHILD = "ParentChild";
    private static final String FEMALE = "Unknown";

    Images images;

    public Images importToStructure(String peopleInfo, String relationshipInfo, String imageFolder) throws InvalidRelationIdException {
        images = new Images();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(peopleInfo)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String id = null, name = null, imagePath = null, gender = null, id2 = null, line = null;
        String[] parts;
        int index = 0;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            parts = line.split("\\s+");
            id = parts[0];
            name = parts[1];
            imagePath = parts[2];
            gender = parts[3];
            parts = imagePath.split("/");
            imagePath = parts[parts.length - 1];
            imagePath = imagePath.replace(":", "-");
            index = Integer.parseInt(id.substring(1));
            Image image = new Image(index, id, imagePath, name);
            image.setGender(gender);
            images.addImage( image );
        }

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(relationshipInfo)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image parent, child;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            parts = line.split("\\s+");
            id = parts[0];
            name = parts[1];
            id2 = parts[2];
            parent = images.getImageById(id);
            child = images.getImageById(id2);
            if (parent != null && child != null) {
                if (name.equals(SPOUSE)) {
                    parent.addSpouseId("" + child.getIndex());
                    parent.addSpouseName(child.getName());
                    child.addSpouseId("" + parent.getIndex());
                    child.addSpouseName(parent.getName());
                }else if (name.equals(CHILD)) {
                    parent.addChildId("" + child.getIndex());
                    child.addParentId("" + parent.getIndex());
                }else {
                    throw new InvalidRelationIdException("The relationship specified is unknown: " + name);
                }
            }
        }

        return images;
    }

}
