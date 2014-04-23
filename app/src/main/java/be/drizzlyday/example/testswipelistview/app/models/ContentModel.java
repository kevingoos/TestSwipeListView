package be.drizzlyday.example.testswipelistview.app.models;

import com.example.testswipelistview.app.R;

/**
 * Created by Kevin on 23/04/2014.
 */
public class ContentModel {

    private static int idCounter = 0;

    private int id;
    private String name;
    private String tempContent;
    private int image;

    public ContentModel(String name, String tempContent) {
        this.id = idCounter++;
        this.name = name;
        this.tempContent = tempContent;
        this.image = R.drawable.ic_action_email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTempContent() {
        return tempContent;
    }

    public void setTempContent(String tempContent) {
        this.tempContent = tempContent;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
