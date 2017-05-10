package structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iclee141 on 5/9/17.
 */
public class Image {

    private String imagePath;
    private String name;
    private int id;
    private int index;

    private List<Image> group;
    private List<Image> children;

    public Image() {
    }

    public Image(String imagePath, String name, int id, int index) {
        this.imagePath = imagePath;
        this.name = name;
        this.id = id;
        this.index = index;
        this.group = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("\"" + id + "\": {\n");
        output.append("\t\"ascBranchIds\": [");
        for (int i = 0; i < children.size(); i++) {
            output.append(children.get(i).getId());
        }
        output.append("],");
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Image> getGroup() {
        return group;
    }

    public void setGroup(List<Image> group) {
        this.group = group;
    }

    public List<Image> getChildren() {
        return children;
    }

    public void setChildren(List<Image> children) {
        this.children = children;
    }

    public void addChild(Image child) {
        children.add(child);
    }

    public void addChild(Image child, int groupMember) {
        for (int i = 0; i < group.size(); i++) {
            if (group.get(i).getId() == groupMember) {
                group.get(i).addChild(child);
                return;
            }
        }
    }

    public void addGroupMember(Image member) {
        group.add(member);
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