package be.intecbrussel.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "productlines", schema = "classicmodels", catalog = "")
public class Productline {
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private byte[] image;
    private Collection<Product> products;

    @Id
    @Column(name = "productLine", nullable = false, length = 50)
    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    @Basic
    @Column(name = "textDescription", nullable = true, length = 4000)
    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    @Basic
    @Column(name = "htmlDescription", nullable = true, length = -1)
    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    @Basic
    @Column(name = "image", nullable = true)
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Productline that = (Productline) o;
        return Objects.equals(productLine, that.productLine) &&
                Objects.equals(textDescription, that.textDescription) &&
                Objects.equals(htmlDescription, that.htmlDescription) &&
                Arrays.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productLine, textDescription, htmlDescription);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @Override
    public String toString() {
        return "[Productline]" +
                "productLine='" + productLine + '\'' +
                ", textDescription='" + textDescription;
    }

    @OneToMany(mappedBy = "productline")
    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
