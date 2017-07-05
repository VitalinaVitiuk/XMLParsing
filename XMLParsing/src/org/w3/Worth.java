
package org.w3;

public class Worth {

    public String value;
    public String price;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String value) {
        this.price = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Worth{");
        sb.append("price='").append(price).append('\'');
        sb.append(", value='").append(value).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
