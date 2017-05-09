package import_export;

import structure.Images;

import java.io.*;

/**
 * Created by iclee141 on 5/9/17.
 */
public class ImageExporter {

    public void exportImages(String fileName, Images images) {
        Writer writer = null;
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer.write(images.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
