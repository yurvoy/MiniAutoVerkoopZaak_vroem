package be.intecbrussel.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "classicmodels", catalog = "")
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
    private BigDecimal msrp;
    private Collection<OrderDetail> orderDetails;
    private ProductLine productline;

    public Product() {
    }

    @Id
    @Column(name = "productCode", nullable = false, length = 15)
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Basic
    @Column(name = "productName", nullable = false, length = 70)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "productScale", nullable = false, length = 10)
    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    @Basic
    @Column(name = "productVendor", nullable = false, length = 50)
    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    @Basic
    @Column(name = "productDescription", nullable = false, length = -1)
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

    @Basic
    @Column(name = "quantityInStock", nullable = false)
    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(short quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Basic
    @Column(name = "buyPrice", nullable = false, precision = 2)
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

    @Basic
    @Column(name = "MSRP", nullable = false, precision = 2)
    public BigDecimal getMsrp() {
        return msrp;
    }

    public void setMsrp(BigDecimal msrp) {
        this.msrp = msrp;
    }

    @OneToMany(mappedBy = "product")
    public Collection<OrderDetail> getOrderdetails() {
        return orderDetails;
    }

    public void setOrderdetails(Collection<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @ManyToOne
    @JoinColumn(name = "productLine", referencedColumnName = "productLine", nullable = false)
    public ProductLine getProductline() {
        return productline;
    }

    public void setProductline(ProductLine productline) {
        this.productline = productline;
    }
}
