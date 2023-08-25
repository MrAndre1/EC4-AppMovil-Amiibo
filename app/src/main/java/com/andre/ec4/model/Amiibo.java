package com.andre.ec4.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Amiibo implements Parcelable{
    private String image;
    private String amiiboSeries;
    private String name;
    private String character;
    private String tail;
    private String type;

    public Amiibo(){}
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAmiiboSeries() {
        return amiiboSeries;
    }

    public void setAmiiboSeries(String amiiboSeries) {
        this.amiiboSeries = amiiboSeries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Amiibo(Amiibo other) {
        this.image = other.image;
        this.amiiboSeries = other.amiiboSeries;
        this.name = other.name;
        this.character = other.character;
        this.tail = other.tail;
        this.type = other.type;
    }
    protected Amiibo(Parcel in) {
        image = in.readString();
        amiiboSeries = in.readString();
        name = in.readString();
        character = in.readString();
        tail = in.readString();
        type = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image);
        dest.writeString(amiiboSeries);
        dest.writeString(name);
        dest.writeString(character);
        dest.writeString(tail);
        dest.writeString(type);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Amiibo> CREATOR = new Creator<Amiibo>() {
        @Override
        public Amiibo createFromParcel(Parcel in) {
            return new Amiibo(in);
        }

        @Override
        public Amiibo[] newArray(int size) {
            return new Amiibo[size];
        }
    };
}
