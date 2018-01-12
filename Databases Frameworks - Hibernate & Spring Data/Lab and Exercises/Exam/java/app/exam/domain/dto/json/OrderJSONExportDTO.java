package app.exam.domain.dto.json;


import com.google.gson.annotations.Expose;

import java.util.Set;

public class OrderJSONExportDTO {

    @Expose
    private String customer;

    @Expose
    private Set<ItemJSONExportDTO> items;

    private Double totalPrice;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Set<ItemJSONExportDTO> getItems() {
        return items;
    }

    public void setItems(Set<ItemJSONExportDTO> items) {
        this.items = items;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
