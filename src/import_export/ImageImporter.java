package import_export;

import structure.Images;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

/**
 * Created by iclee141 on 5/9/17.
 */
public class ImageImporter {

    public Images importToStructure(String folderPath) {

        File file = new File(folderPath);
        String[] files = file.list();
        if (files.length <= 0) {
            System.out.println("Nothing in the folder!");
            return null;
        }
        Images images = new Images();

        Scanner scanner = new Scanner(System.in);
        int skip = 0;
        String read = "0";
        int index = 0;
        while(index < files.length) {
            if (skip == 0) {

                System.out.println("\nHow many files are in this group?");

                skip = scanner.nextInt();

                String path = files[index];
                images.addImage(path, index + path);

            }else {
                System.out.print(" skip: " + skip + ", index: " + index);
                skip--;
            }
            index++;
        }

        return images;
    }

}
