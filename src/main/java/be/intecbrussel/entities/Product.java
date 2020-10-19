package be.intecbrussel.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {

    @Id
    private String productCode;
    private String productName;
    @ManyToOne
    @JoinColumn(name = "productLine")
    private ProductLine productLine;
    private String productScale;
    private String productVendor;
    @Column(columnDefinition = "text")
    private String productDescription;
    @Column(columnDefinition = "smallint")
    private int quantityInStock;
    private BigDecimal buyPrice;
    private BigDecimal MSRP;

    public Product() {
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getMSRP() {
        return MSRP;
    }

    public void setMSRP(BigDecimal MSRP) {
        this.MSRP = MSRP;
    }

    @Override
    public String toString() {
        return "[Product]" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productScale='" + productScale + '\'' +
                ", productVendor='" + productVendor + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", buyPrice=" + buyPrice +
                ", MSRP=" + MSRP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return quantityInStock == product.quantityInStock &&
                Objects.equals(productCode, product.productCode) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(productLine, product.productLine) &&
                Objects.equals(productScale, product.productScale) &&
                Objects.equals(productVendor, product.productVendor) &&
                Objects.equals(productDescription, product.productDescription) &&
                Objects.equals(buyPrice, product.buyPrice) &&
                Objects.equals(MSRP, product.MSRP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP);
    }
}
