package org.itglance.docsea.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotNull;

import javax.persistence.CascadeType;

/**
 * Created by Mahesh on 5/8/2017.
 */

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull(message = "Hospital street address should not be null")
    private String streetAddress;

    @NotNull(message = "Address's cityId should not be null (foreign key)")
    @ManyToOne
    private City city;
    @NotNull(message = "Address's districtId should not be null (foreign key)")
    @ManyToOne
    private District district;
    @NotNull(message = "Address's ZoneId should not be null (foreign key)")
    @ManyToOne
    private Zone zone;
    @NotNull(message = "Address's countryId should not be null (foreign key)")
    @ManyToOne
    private Country country;

    public Long getId() {
        return id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", streetAddress='" + streetAddress + '\'' +
                ", city=" + city +
                ", district=" + district +
                ", zone=" + zone +
                ", country=" + country +
                '}';
    }
}
