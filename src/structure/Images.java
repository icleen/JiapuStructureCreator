package structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iclee141 on 5/9/17.
 */
public class Images {

    private List<Image> images;

    public Images() {
        images = new ArrayList<>();
    }

    public Images(List<Image> images) {
        this.images = images;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("staticData = {\n");
        output.append("\"0\": {"
            + "\n\t\"ascBranchIds\": [1, 2, 3, 4, 5],"
            + "\n\t\"data\": {"
                        + "\n\t\t\"name\": \"number\","
                        + "\n\t\t\"id\": 0"
                + "\n\t}"
        + "\n},");
        for (int i = 0; i < images.size(); i++) {
            output.append(images.get(i).toString());
        }
        output.append("\n}");
        return output.toString();
    }

    public void addImage(Image image) {
        images.add(image);
    }

    public void addImage(String imagePath, String name) {
        images.add(new Image(imagePath, name, images.size() + 1));
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public static void main(String[] args) {
        Images images = new Images();
        images.addImage(new Image(
                "test_images//record-image_3QSQ-G9SF-K9BM-8.jpg",
                "parent", 0));
        images.addImage(new Image(
                "test_images//record-image_3QSQ-G9SF-K9BM-8.jpg",
                "child", 1));
        images.addImage(new Image(
                "test_images//record-image_3QSQ-G9SF-K9BM-8.jpg",
                "child", 2));
        System.out.println(images.toString());
    }

}
//staticData = {
//        "0": {
//        "ascBranchIds": [1, 2, 3],
//        "data": {
//        "image": "test_images//record-image_3QSQ-G9SF-K9BM-8.jpg",
//        "name": "parent", "id": 0}
//        },
//        "1": {
//        "ascBranchIds": [4, 5, 6],
//        "data": {
//        "image": "test_images//record-image_3QS7-89SF-K9TC-T.jpg",
//        "name": "child_1", "id": 1}
//        },
//        "2": {
//        "ascBranchIds": [7, 8, 9],
//        "data": {
//        "image": "test_images//record-image_3QSQ-G9SF-K9BS-Y.jpg",
//        "name": "child_2", "id": 2}
//        }
//        }