package com.toysrus.automation.Selectors;

import java.util.ArrayList;

public class Data {

  private String user__fname;
  private String user__lname;
  private String user__address1;
  private String user__address2;
  private String user__city;
  private String user__state;
  private String user__zip;
  private String user__phone;
  private String user__email;

  public Data(String user__fname, String user__lname, String user__address1, String user__address2, String user__city, String user__state, String user__zip, String user__phone, String user__email) {
    {
      this.user__fname = user__fname;
      this.user__lname = user__lname;
      this.user__address1 = user__address1;
      this.user__address2 = user__address2;
      this.user__city = user__city;
      this.user__state = user__state;
      this.user__zip = user__zip;
      this.user__phone = user__phone;
      this.user__email = user__email;
    }
  }


  public static class user1 {
    //Shipping
    public static final String user__shipping__first_name = "John";
    public static final String user__shipping__last_name = "Doe";
    public static final String user__shipping__address1 = "1 Geoffrey Way";
    public static final String user__shipping__address2 = "";
    public static final String user__shipping__city = "Wayne";
    public static final String user__shipping__state = "NJ";
    public static final String user__shipping__zip = "07470";
    public static final String user__shipping__phone = "1234567890";

    //Pickup
    public static final String user__pickup__first_name = "John";
    public static final String user__pickup__last_name = "Doe";
    public static final String user__pickup__phone = "1234567890";
    public static final String user__pickup__email = "tru.linderman@gmail.com";

    //Billing
    public static final String user__billing__first_name = "John";
    public static final String user__billing__last_name = "Doe";
    public static final String user__billing__address1 = "1 Geoffrey Way";
    public static final String user__billing__address2 = "";
    public static final String user__billing__city = "Wayne";
    public static final String user__billing__state = "NJ";
    public static final String user__billing__zip = "07470";
    public static final String user__billing__phone = "1234567890";

    public static final String user__email = "tru.linderman@gmail.com";
  }

  public static ArrayList search_Items() {
    ArrayList<String> search_items = new ArrayList<String>();
    search_items.add("barbie");
    search_items.add("ninja turtle");
    search_items.add("batman");
    search_items.add("mickey mouse");
    search_items.add("baby doll");
    search_items.add("five nights at freddys");
    search_items.add("nerf gun");
    search_items.add("crayola");
    search_items.add("pool");
    search_items.add("swing set");
    search_items.add("play yard");
    search_items.add("crib");
    search_items.add("stroller");
    search_items.add("car seat");
    search_items.add("diapers");
    search_items.add("bib");
//    search_items.add("onesie");
    search_items.add("sippy cup");
    return search_items;
  }

  public static class credit_card__Visa{
    public static final String credit_card__number = "4111111111111111";
    public static final String credit_card__expiration_month = "01";
    public static final String credit_card__expiration_year = "2019";
    public static final String credit_card__cvv = "111";
  }

//  public static class credit_card__Visa{
//    public static final String credit_card__number = "4387751111111111";
//    public static final String credit_card__expiration_month = "01";
//    public static final String credit_card__expiration_year = "2019";
//    public static final String credit_card__cvv = "111";
//  }

  public static class credit_card__Amex{
    public static final String credit_card__number = "370000000000101";
    public static final String credit_card__expiration_month = "01";
    public static final String credit_card__expiration_year = "2019";
    public static final String credit_card__cvv = "1111";
  }

  public static class credit_card__Master_Card{
    public static final String credit_card__number = "5442981111111114";
    public static final String credit_card__expiration_month = "01";
    public static final String credit_card__expiration_year = "2019";
    public static final String credit_card__cvv = "111";
  }

  public static class credit_card__PLCC{
    public static final String credit_card__number = "6045860000000001";
    public static final String credit_card__cvv = "111";
  }


//        CREDIT CARDS
//
//        COBRANDED
//        5243636714843171
//        111
//        2019-01
//
//        COBRANDED
//        5237704245602827
//        111
//        2019-01


}


