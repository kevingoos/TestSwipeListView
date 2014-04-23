package be.drizzlyday.example.testswipelistview.app.data;

import java.util.ArrayList;
import java.util.List;

import be.drizzlyday.example.testswipelistview.app.models.ContentModel;

/**
 * Created by Kevin on 23/04/2014.
 */
public class ContentData {

    public static List<ContentModel> CreateData() {
        List<ContentModel> models = new ArrayList<ContentModel>();

        for (int i = 0; i < 1600; i++) {
            models.add(new ContentModel("Test" + i, "This is test" + i));
        }

        return models;
    }

}
