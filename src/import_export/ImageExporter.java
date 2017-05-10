package import_export;

import structure.Images;

import java.io.*;

/**
 * Created by iclee141 on 5/9/17.
 */
public class ImageExporter {

    public void exportImages(String fileName, Images images) {
        try {
            Writer writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            writer.write(images.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
