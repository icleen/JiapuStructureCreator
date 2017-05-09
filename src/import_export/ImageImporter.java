package import_export;

import structure.Image;
import structure.Images;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.InputMismatchException;
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
            try {
                System.out.println("\nHow many files are in this group?");

                skip = scanner.nextInt();
                if (skip < 1) {
                    throw new IllegalArgumentException("The input was less than 1");
                }

                String path = files[index];
                images.addImage(new Image(path, skip + path, index));
                index += skip;
                skip = 0;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.err.println("You're input was not an integer!");
                scanner.nextLine();
            }
        }

        return images;
    }

}
