package test;

import org.junit.Test;
import structure.Image;

import static org.junit.Assert.*;

/**
 * Created by iclee141 on 5/9/17.
 */
public class testImage {

    @Test
    public void testToString() {
//        "ascBranchIds": [],
//        "data": {
//            "image": "test_images//record-image_3QSQ-G9SF-K9BM-8.jpg",
//            "name": "parent",
//            "id": 0
//        }
        String expected = "\t\"ascBranchIds\": []," +
                "\n\t\"data\": {" +
                "\n\t\t\"image\": \"test_images//record-image_3QSQ-G9SF-K9BM-8.jpg\"," +
                "\n\t\t\"name\": \"parent\"," +
                "\n\t\t\"id\": 0" +
                "\n\t\t}";
        Image image = new Image(
                "test_images//record-image_3QSQ-G9SF-K9BM-8.jpg",
                "parent", 0);
        System.out.println(image.toString());
        System.out.println(expected);
        assertTrue(image.toString().equals(expected));
    }

}
