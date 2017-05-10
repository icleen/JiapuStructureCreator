package structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iclee141 on 5/10/17.
 */
public class ImageIds {

    List<ImageId> ids;

    public ImageIds() {
        ids = new ArrayList<>();
    }

    public void add(ImageId id) {
        ids.add(id);
    }

    public ImageId getIdByIndex(int index) {
        return ids.get(index);
    }

    public ImageId getId(int id) {
        for (ImageId imageId : ids) {
            if (imageId.getId() == id) {
                return imageId;
            }
        }
        return null;
    }

}
