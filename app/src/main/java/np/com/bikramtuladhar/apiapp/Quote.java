package np.com.bikramtuladhar.apiapp;

public class Quote {
    private String id;
    private String name;
    private String brewery_type;
    private String address_1;
    private String address_2;
    private String address_3;
    private String city;
    private String state_province;
    private String postal_code;
    private String country;
    private String longitude;
    private String latitude;
    private String phone;
    private String website_url;
    private String state;
    private String street;

    public String getQuote() {
        return name + ' ' +
                brewery_type + ' ' +
                address_1 + ' ' +
                address_2 + ' ' +
                address_3 + ' ' +
                city + ' ' +
                state_province + ' ' +
                postal_code + ' ' +
                country + ' ' +
                longitude + ' ' +
                latitude + ' ' +
                phone + ' ' +
                website_url + ' ' +
                state + ' ' +
                street;
    }

    public String getCountry() {
        return country;
    }

    public String getWebsiteUrl() {
        return website_url;
    }
}