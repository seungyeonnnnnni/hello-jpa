package jpql;

import javax.persistence.*;

@Embeddable
public class Address {

    private String city;
    private String street;
    private String zipcode;

}
