package com.yosephmartin;

public class Client {

    public static void main(String[] args) {
        InternetAccess internetAccessOne = new InternetAccess("Yoseph Martin Christian", "https://microsoft.com");
        internetAccessOne.grantInternetAccess();

        InternetAccess internetAccessTwo = new InternetAccess("Jacob", "https://facebook.com");
        internetAccessTwo.grantInternetAccess();

        InternetAccess internetAccessThree = new InternetAccess("Cindy", "https://twitter.com");
        internetAccessThree.grantInternetAccess();
    }

}
