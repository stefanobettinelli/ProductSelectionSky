package com.stefanobettinelli.productselectionsky.model;

import com.stefanobettinelli.productselectionsky.exceptions.InvalidSkyIdException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerSkyIdTest {

    private SkyId skyIdA;
    private SkyId skyIdB;
    private SkyId skyIdC;
    private SkyId skyIdD;

    @Before
    public void setUp() throws Exception, InvalidSkyIdException {
        skyIdA = IntegerSkyId.getNewId(23);
        skyIdB = IntegerSkyId.getNewId(23);
        skyIdC = skyIdA;
        skyIdD = IntegerSkyId.getNewId(25);
    }

    @Test(expected = InvalidSkyIdException.class)
    public void testInvadIdCreation() throws InvalidSkyIdException {
        SkyId invalidID = IntegerSkyId.getNewId(-1);
    }

    @Test
    public void getId() throws Exception {
        assertNotNull(skyIdA.getId());
        assertNotNull(skyIdB.getId());
        assertNotNull(skyIdC.getId());
        assertNotNull(skyIdD.getId());
    }

    @Test
    public void equals() throws Exception {
        assertEquals(skyIdA,skyIdB);
        assertEquals(skyIdA,skyIdC);
        assertNotEquals(skyIdA,skyIdD);
        assertNotEquals(skyIdB,skyIdD);
        assertNotEquals(skyIdC,skyIdD);
    }

}