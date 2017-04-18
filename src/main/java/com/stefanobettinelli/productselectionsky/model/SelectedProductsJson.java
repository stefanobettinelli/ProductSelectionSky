package com.stefanobettinelli.productselectionsky.model;

import java.util.List;

//maps the received json selected product list and custemer ID to this class
public class SelectedProductsJson {

    private List<String> selectedProducts;
    private String customerID;

    public List<String> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<String> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

}
