package structure;

/**
 * Created by iclee141 on 5/10/17.
 */
public class ImageId {

    private int index;
    private int id;
    private String imagePath;

    public ImageId() {
    }

    public ImageId(int index, int id, String path) {
        this.index = index;
        this.id = id;
        this.imagePath = path;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
