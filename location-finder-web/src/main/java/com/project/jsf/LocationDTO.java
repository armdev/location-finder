package com.project.jsf;

import java.io.Serializable;
import java.util.Objects;

public class LocationDTO implements Serializable {

    private String countryCode;
    private String countryName;
    private String city;
    private Double latitude;
    private Double longitude;

    public LocationDTO() {

    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public int hashCode() {
        int hash = 7;

        hash = 89 * hash + Objects.hashCode(this.countryCode);
        hash = 89 * hash + Objects.hashCode(this.countryName);

        hash = 89 * hash + Objects.hashCode(this.city);
        hash = 89 * hash + Objects.hashCode(this.latitude);
        hash = 89 * hash + Objects.hashCode(this.longitude);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LocationDTO other = (LocationDTO) obj;

        if (!Objects.equals(this.countryCode, other.countryCode)) {
            return false;
        }
        if (!Objects.equals(this.countryName, other.countryName)) {
            return false;
        }

        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.latitude, other.latitude)) {
            return false;
        }
        return Objects.equals(this.longitude, other.longitude);
    }

    @Override
    public String toString() {
        return "LocationModel{" + "userId=" + "" + ", countryCode=" + countryCode + ", countryName=" + countryName + ", region=" + "" + ", city=" + city + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }

}
