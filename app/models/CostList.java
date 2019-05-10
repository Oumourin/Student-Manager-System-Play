package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CostList extends Model {
    private String stuId;
    private Double price;
    @Id
    private String orderId;
    private Boolean isPay;

    public CostList(String stuId, Double price, String orderId, Boolean isPay) {
        this.stuId = stuId;
        this.price = price;
        this.orderId = orderId;
        this.isPay = isPay;
    }

    public String getStuId() {
        return stuId;
    }

    public Double getPrice() {
        return price;
    }

    public String getOrderId() {
        return orderId;
    }

    public Boolean getPay() {
        return isPay;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setPay(Boolean pay) {
        isPay = pay;
    }
}
