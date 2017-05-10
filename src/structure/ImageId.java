package structure;

/**
 * Created by iclee141 on 5/10/17.
 */
public class ImageId {

    private int id;
    private String imagePath;

    public ImageId() {
    }

    public ImageId(int id, String path) {
        this.id = id;
        this.imagePath = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
