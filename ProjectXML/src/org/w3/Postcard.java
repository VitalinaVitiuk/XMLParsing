package org.w3;

public class Postcard  {

    public TypeOfCard type;
    public String theme;
    public String country;
    public String year;
    public String author;
    public Worth worth;
    public String id;


    public TypeOfCard getType() {
        return type;
    }


    public void setType(TypeOfCard value) {
        this.type = value;
    }


    public String getTheme() {
        return theme;
    }


    public void setTheme(String value) {
        this.theme = value;
    }


    public String getCountry() {
        return country;
    }


    public void setCountry(String value) {
        this.country = value;
    }


    public String getYear() {
        return year;
    }


    public void setYear(String value) {
        this.year = value;
    }


    public String getAuthor() {
        return author;
    }


    public void setAuthor(String value) {
        this.author = value;
    }


    public Worth getWorth() {
        return worth;
    }


    public void setWorth(Worth value) {
        this.worth = value;
    }


    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Postcard{");
        sb.append("author='").append(author).append('\'');
        sb.append(", type=").append(type);
        sb.append(", theme='").append(theme).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", year='").append(year).append('\'');
        sb.append(", worth=").append(worth);
        sb.append(", id='").append(id).append('\'');
        sb.append('}');
        return sb.toString();
    }

    }



