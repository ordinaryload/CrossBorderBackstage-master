package sugar.bean;

import java.util.Date;

public class Message {
    private Integer id;

    private String putrole;

    private String getrole;

    private String text;

    private String images;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPutrole() {
        return putrole;
    }

    public void setPutrole(String putrole) {
        this.putrole = putrole == null ? null : putrole.trim();
    }

    public String getGetrole() {
        return getrole;
    }

    public void setGetrole(String getrole) {
        this.getrole = getrole == null ? null : getrole.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}