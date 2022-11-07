package main.PageObjects;

public interface LoginPageElements {

    String loginText="//h2[contains(text(),'Login Here')]";
    String userName="//*[@type='email']";
    String password="//*[@type='password']";
    String submitButton="//*[@value='Log In']";
    String loginButton = "//*[text()='Log in']";

}
