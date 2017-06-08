package org.itglance.docsea.domain;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by sanj__000 on 6/7/2017.
 */
class AddressTest {
    Address address = new Address();
    @Test
    void setStreetAddress() {
        address.setStreetAddress("ktm");
        Assert.assertEquals("ktm", address.getStreetAddress());

    }

}