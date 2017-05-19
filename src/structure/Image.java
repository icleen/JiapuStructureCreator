package structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iclee141 on 5/9/17.
 */
public class Image {

    private int index;
    private String id;
    private String imagePath;
    private String name;

    private List<Image> group;
    private List<Image> children;
    private List<String> childIds;
    private List<String> spouseIds;
    private List<String> parentIds;

    public Image() {
    }

    public Image(int index, String id, String imagePath, String name) {
        this.index = index;
        this.id = id;
        this.imagePath = imagePath;
        this.name = name;
        this.group = new ArrayList<>();
        this.children = new ArrayList<>();
        this.childIds = new ArrayList<>();
        this.spouseIds = new ArrayList<>();
        this.parentIds = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("\"" + index + "\": {\n");
        output.append("\t\"ascBranchIds\": [");
        for (int i = 0; i < childIds.size(); i++) {
            output.append(childIds.get(i));
            if (i < childIds.size() - 1) output.append(", ");
        }
        output.append("],");
        output.append("\n\t\"data\": {");
        output.append("\n\t\t\"image\": \"image//" + imagePath + "\",");
        output.append("\n\t\t\"name\": \"" + name + "\",");
        output.append("\n\t\t\"id\": " + index);
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public void addChild(Image child) {
        children.add(child);
    }

    public void addChild(Image child, String groupMember) {
        for (int i = 0; i < group.size(); i++) {
            if ( group.get(i).getId().equals(groupMember) ) {
                group.get(i).addChild(child);
                return;
            }
        }
    }

    public void addChildId(String id) {
        childIds.add(id);
    }

    public void addParentId(String id) {
        parentIds.add(id);
    }

    public void addSpouseId(String id) {
        childIds.add(id);
    }

    public List<String> getChildIds() {
        return childIds;
    }

    public List<String> getSpouseIds() {
        return spouseIds;
    }

    public List<String> getParentIds() {
        return parentIds;
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