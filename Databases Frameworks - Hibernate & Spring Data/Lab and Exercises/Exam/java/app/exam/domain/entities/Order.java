package app.exam.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "customer",nullable = false)
    private String customer;

    @NotNull
    @Column(name = "date",nullable = false)
    private Date date;

    @NotNull
    @Column(name = "order_type")
    @Enumerated
    private OrderType type;

    @NotNull
    @Transient
    private BigDecimal totalprice;

    @NotNull
    @ManyToOne(targetEntity = Employee.class,optional = false,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Employee employee;

    @OneToMany(mappedBy = "order" ,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<OrderItem> orderItems;

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

}
