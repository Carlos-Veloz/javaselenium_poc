package utils.data;

import org.apache.commons.lang3.RandomStringUtils;

public class ShippingInformation {

    private String firstname;
    private String lastname;
    private String zipcode;

    public static ShippingInformation createShippingDetails() {
        ShippingInformation shippingInformation = new ShippingInformation();
        shippingInformation.firstname = RandomStringUtils.randomAlphabetic(8);
        shippingInformation.lastname = RandomStringUtils.randomAlphabetic(8);
        shippingInformation.zipcode = RandomStringUtils.randomNumeric(6);
        return shippingInformation;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getZipcode() {
        return zipcode;
    }
}
