package main.PageObjects;

public interface LoginPageElements {

    String loginText="//h2[contains(text(),'Login Here')]";
    String userName="//input[@name='username']";
    String password="//input[@name='password']";
    String submitButton="//button[contains(text(),'Submit')]";

}
