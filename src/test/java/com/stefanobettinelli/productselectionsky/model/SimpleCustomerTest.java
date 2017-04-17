package com.stefanobettinelli.productselectionsky.model;

import com.stefanobettinelli.productselectionsky.exceptions.InvalidSkyIdException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleCustomerTest {

    private Customer testingCustomer;
    private Product prodA;
    private Product prodB;
    private Product prodC;

    @Before
    public void setUp() throws InvalidSkyIdException {
        Location location = new SimpleLocation(IntegerSkyId.getNewId(10), "Zanzibar");
        testingCustomer = new SimpleCustomer("Mario", IntegerSkyId.getNewId(10), location);
        Category catA = new SimpleCategory(IntegerSkyId.getNewId(1), "CatA");
        Category catB = new SimpleCategory(IntegerSkyId.getNewId(2), "CatB");

        /* prodA and prodB have the same category for testing purpose */
        prodA = new SimpleProduct(IntegerSkyId.getNewId(1), "ProdA", catA);
        prodB = new SimpleProduct(IntegerSkyId.getNewId(2), "ProdB", catB);
        prodC = new SimpleProduct(IntegerSkyId.getNewId(3), "ProdC", catA);
    }

    private void addThreeProducts() {
        testingCustomer.addProduct(prodA);
        testingCustomer.addProduct(prodB);
        testingCustomer.addProduct(prodC);
    }

    @Test
    public void addProduct() throws Exception {
        addThreeProducts();
        assertEquals(3, testingCustomer.getSelectedProducts().size());
    }

    @Test
    public void getCategoriesOfSelectedProducts() {
        addThreeProducts();
        assertEquals(2, testingCustomer.getCategoriesOfSelectedProducts().size());
    }

    @Test
    public void removeProduct() throws Exception {
        testingCustomer.removeProduct(prodA);
        testingCustomer.removeProduct(prodB);
        testingCustomer.removeProduct(prodC);
        int numberOfProducts = testingCustomer.getSelectedProducts().size();
        assertEquals(numberOfProducts, 0);
    }

    @Test
    public void checkOut() throws Exception {
        fail();
    }

}