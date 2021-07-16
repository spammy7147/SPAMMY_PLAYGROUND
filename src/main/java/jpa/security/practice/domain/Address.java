package jpa.security.practice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String city;
    private String district;
    @Column(name="address_detail")
    private String detail;
    private String zipCode;


}
