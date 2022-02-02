package pojo;

import java.util.Arrays;

public class ArticlePojo {
    private String title,about,description;
    private String[] tags;

    public ArticlePojo(){

    }
    public ArticlePojo(String title, String about, String description, String[] tags) {
        this.title = title;
        this.about = about;
        this.description = description;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", about='" + about + '\'' +
                ", description='" + description + '\'' +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }


}
