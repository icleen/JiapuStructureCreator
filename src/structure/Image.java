package structure;

/**
 * Created by iclee141 on 5/9/17.
 */
public class Image {

    private String imagePath;
    private String name;
    private int id;

    public Image() {
    }

    public Image(String imagePath, String name, int id) {
        this.imagePath = imagePath;
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("\"" + id + "\": {\n");
        output.append("\t\"ascBranchIds\": [],");
        output.append("\n\t\"data\": {");
        output.append("\n\t\t\"image\": \"" + imagePath + "\",");
        output.append("\n\t\t\"name\": \"" + name + "\",");
        output.append("\n\t\t\"id\": " + id);
        output.append("\n\t}");
        output.append("\n},");
        return output.toString();
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
//staticData = {
//        "0": {
//        "ascBranchIds": [1, 2, 3],
//        "data": {
//        "image": "test_images//record-image_3QSQ-G9SF-K9BM-8.jpg",
//        "name": "parent",
//        "id": 0
//        }
//        },
//        "1": {"ascBranchIds": [4, 5, 6],
//        "data": {
//        "image": "test_images//record-image_3QS7-89SF-K9TC-T.jpg",
//        "name": "child_1", "id": 1}
//        },
//        "2": {"ascBranchIds": [7, 8, 9],
//        "data": {
//        "image": "test_images//record-image_3QSQ-G9SF-K9BS-Y.jpg",
//        "name": "child_2", "id": 2}
//        }
//        }