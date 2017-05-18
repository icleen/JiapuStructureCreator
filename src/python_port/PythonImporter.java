package python_port;

import structure.Image;
import structure.Images;

import javax.management.relation.InvalidRelationIdException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by iclee141 on 5/18/17.
 */
public class PythonImporter {

    private static final String SPOUSE = "Couple";
    private static final String CHILD = "ParentChild";

    Images images;

    public Images importToStructure(String peopleInfo, String relationshipInfo, String imageFolder) throws InvalidRelationIdException {
        File persons = new File(peopleInfo);
        File relations = new File(relationshipInfo);
        File imageFold = new File(imageFolder);
        images = new Images();
        Scanner scanner = null;
        try {
            scanner = new Scanner(persons);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String id = null, name = null, imagePath = null, id2 = null;
        int index = 0;
        while (scanner.hasNextLine()) {
            id = scanner.next();
            name = scanner.next();
            imagePath = scanner.next();
            index = Integer.parseInt(id.substring(1));
            images.addImage( new Image(index, id, name, imagePath) );
        }

        try {
            scanner = new Scanner(relations);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image parent, child;
        while (scanner.hasNextLine()) {
            id = scanner.next();
            name = scanner.next();
            id2 = scanner.next();
            parent = images.getImageById(id);
            child = images.getImageById(id2);
            try {
                if (name.equals(SPOUSE)) {
                    parent.addSpouseId(id2);
                    child.addSpouseId(id);
                }else if (name.equals(CHILD)) {
                    parent.addChildId(id2);
                    child.addParentId(id);
                }else {
                    throw new InvalidRelationIdException("The relationship specified is unknown: " + name);
                }
            } catch (NullPointerException e) {
                if (images.getImageById(id) == null) {
                    id2 = id;
                }
                System.err.println("One of the id's specified does not have a corresponding person: " + id2);
            }

        }

        return images;
    }

}
