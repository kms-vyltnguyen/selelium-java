package objects;

import data.ExcelHelper;

public class Account {
    String fullName;
    String emailAddress;
    String country;
    String phoneNumber;
    String roleType;
    String hearLocation;
    String password;
    String promoCode;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getHearLocation() {
        return hearLocation;
    }

    public void setHearLocation(String hearLocation) {
        this.hearLocation = hearLocation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public Account(String inputFullName, String inputEmailAddress, String inputCountry, String inputPhoneNumber,
                   String inputRoleType, String inputHearLocation, String inputPassword, String inputPromoCode) {
        setFullName(inputFullName);
        setEmailAddress(inputEmailAddress);
        setCountry(inputCountry);
        setPhoneNumber(inputPhoneNumber);
        setRoleType(inputRoleType);
        setHearLocation(inputHearLocation);
        setPassword(inputPassword);
        setPassword(inputPromoCode);
    }
}
