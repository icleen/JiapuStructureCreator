package import_export;

import structure.Image;
import structure.ImageId;
import structure.ImageIds;
import structure.Images;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by iclee141 on 5/9/17.
 */
public class ImageImporter {

    private Images images;
    private int index;
    private int id;
    private ImageIds ids;

    public Images importToStructure(String folderPath, String heirarchy, String startNumber) {
//        System.out.println(folderPath);
        id = Integer.parseInt(startNumber);
        File file = new File(folderPath);
        String[] files = file.list();
        if (files.length <= 0) {
            System.out.println("Nothing in the folder!");
            return null;
        }
        images = new Images();
        ids = new ImageIds();
        for (int i = 0; i < files.length; i++) {
            ids.add(new ImageId(i, id + i, files[i]));
        }

        File heir = new File(heirarchy);
        try {
            Scanner scanner = new Scanner(heir);
            recurse(scanner);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return images;
    }

    private int recurse(Scanner scanner) {
        if (!scanner.hasNextLine()) {
            return -1;
        }
        String line = scanner.nextLine();
        String[] numbers = line.split(" ");
        int begin = Integer.parseInt(numbers[0]);
        int end = Integer.parseInt(numbers[1]);
        int childCount = Integer.parseInt(numbers[2]);

        ImageId iid = ids.getImageId(begin);
        if (iid == null) {
            return -1;
        }
        System.out.println(iid.getIndex());
        System.out.println(iid.getId());
        System.out.println(iid.getImagePath());
        Image image = new Image(iid.getIndex(), iid.getId(), iid.getImagePath(), iid.getId() + "_" + iid.getIndex());
        images.addImage(image);
        int index;
        while (childCount > 0) {
            index = recurse(scanner);
            image.addChild(index);
            childCount--;
        }

        return image.getIndex();
    }

}


//    private Image recurseAdd(String[] files, Scanner scanner, int number) {
//        Image root = null;
//        if (index >= files.length) {
//            return root;
//        }
//
//        String path = files[index];
//        root = new Image(path, " " + number, id + index, index++);
//        images.addImage(root);
//
//        System.out.println("\nHow many images are with " + index + "? (needs to be 1 or more) (" + (files.length - index) + " images left)");
//        int group = scanner.nextInt();
//        if (group < 1) {
//            throw new IllegalArgumentException("The input was less than 1");
//        }
//
////      adds the number of images specified to the root Image's group attribute
//        while (index < files.length && group > 1) {
//            path = files[index];
//            root.addGroupMember(new Image(path, group + " ", index, index));
//            System.out.println("Adding group member: " + index);
//            ++index;
//            --group;
//        }
//
//        System.out.println("\nHow many children does this image have? (" + (files.length - index) + " images left)");
//        int children = scanner.nextInt();
//        if (children < 0) {
//            throw new IllegalArgumentException("The input was less than 0");
//        }
//        Image child = null;
////        recursively adds children to the root image
//        while (index < files.length && children > 0) {
//            child = recurseAdd(files, scanner, children);
//            root.addChild(child);
//            --children;
//            System.out.println("Adding child: " + (children + 1) );
//        }
//        System.out.println("index: " + index);
//        return root;
//    }
