package pl.ioad1.bauhinia.elementeditor;

import android.graphics.Bitmap;
import android.net.Uri;

import java.io.Serializable;

public class Element implements Serializable {
    private int id, length, width;
    private String name;
    private float height, transparent;
    private Bitmap image;

    public Element(int id, int length, int width, String name, Bitmap image, float height, float transparent) {

            this.id = id;
            this.length = length;
            this.width = width;
            this.name = name;
            this.image = image;
            this.height = height;
            this.transparent = transparent;
    }

    public Element(Element element) {

            this.id = element.id;
            this.length = element.length;
            this.width = element.width;
            this.name = element.name;
            this.image = element.image;
            this.height = element.height;
            this.transparent = element.transparent;

    }

    public Element() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getTransparent() {
        return transparent;
    }

    public void setTransparent(float transparent) {
        this.transparent = transparent;
    }

    @Override
    public String toString() {
        return ("Name: "+ name + "\nHeigth: " + height + "\nLength: " + length + "\nWidth: " + width + "\nTransparent: " + transparent);
    }
}
