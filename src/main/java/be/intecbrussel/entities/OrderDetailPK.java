package be.intecbrussel.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OrderDetailPK implements Serializable {
    private int orderNumber;
    private String productCode;

    public OrderDetailPK(int orderNumber, String productCode) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
    }

    @Column(name = "orderNumber", nullable = false)
    @Id
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Column(name = "productCode", nullable = false, length = 15)
    @Id
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailPK that = (OrderDetailPK) o;
        return orderNumber == that.orderNumber &&
                Objects.equals(productCode, that.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, productCode);
    }
}
