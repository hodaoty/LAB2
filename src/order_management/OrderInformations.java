/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order_management;

public class OrderInformations {
    private String orderCode;
    private String orderInfo;
    private String orderDate;
    private int orderTotalPrice;

    public OrderInformations(String orderCode, String orderInfo, String orderDate, int orderTotalPrice) {
        this.orderCode = orderCode;
        this.orderInfo = orderInfo;
        this.orderDate = orderDate;
        this.orderTotalPrice = orderTotalPrice;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(int orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }
    
    @Override
    public String toString(){
        return "Code :"+ orderCode+" Info : "+orderInfo+" Date : "+orderDate+ "Total Price :"+ orderTotalPrice;
    }
    
}
