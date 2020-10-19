package be.intecbrussel.entities.pk;

import be.intecbrussel.entities.Order;
import be.intecbrussel.entities.Product;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailPK implements Serializable {

    @ManyToOne
    @JoinColumn(name =  "productCode")
    private Product product;
    @ManyToOne
    @JoinColumn(name =  "orderNumber")
    private Order order;

    public OrderDetailPK() {
    }

    public OrderDetailPK(Product product, Order order) {
        this.product = product;
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailPK that = (OrderDetailPK) o;
        return Objects.equals(product, that.product) &&
                Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, order);
    }
}
