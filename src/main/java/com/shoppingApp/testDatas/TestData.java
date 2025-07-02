package com.shoppingApp.testDatas;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class TestData {

    //Test Data for Signup :
    public  static  String signUpName = "Name1";
    public  static  String signUpEmail = "name9812@mail.com";
    public  static  String gender = "male";
    public  static  String password = "password123";
    public  static  String day = "10";
    public  static  String month = "August";
    public static String year = "2000";
    public  static  String firstName = "Name1";
    public  static  String lastName = "Name2";
    public  static  String company = "ABC Company";
    public  static  String address = "Line1, House Number 1";
    public  static  String state = "Karnataka";
    public  static  String city = "banglore";
    public  static  String zipcode = "654321";
    public  static  String mobileNum = "9876543210";

    //Test Data for invalid login:
    public static String invalidEmail = "admin@mail.com";
    public static String invalidPassword = "Password";

    //Test data for Add Product(s) to Cart
    public static String productToBeAdded = "Winter Top";
    public  static List<String > productsToBeAdded = Arrays.asList("Soft Stretch Jeans", "GRAPHIC DESIGN MEN T SHIRT - BLUE","Summer White Top");

    //Test data for Payment card details
    public static String cardHolderName = "admin";
    public static String cardNum = "1234 5678 9876";
    public static String cvc = "334";
    public static String expMonth = "06";
    public static String expYear = "2029";


}
