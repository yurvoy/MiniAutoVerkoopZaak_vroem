package be.intecbrussel.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "productlines")
public class ProductLine {

    @Id
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private String image;

    public ProductLine() {
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "[ProductLine]" +
                "productLine='" + productLine + '\'' +
                ", textDescription='" + textDescription + '\'' +
                ", htmlDescription='" + htmlDescription + '\'' +
                ", image='" + image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductLine that = (ProductLine) o;
        return Objects.equals(productLine, that.productLine) &&
                Objects.equals(textDescription, that.textDescription) &&
                Objects.equals(htmlDescription, that.htmlDescription) &&
                Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productLine, textDescription, htmlDescription, image);
    }
}
