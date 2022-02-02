package interfaces;

import utilities.ReadJson;
import pageobjects.*;


/**
 * Created by rjoshi on Jan, 2022
 */
public interface ClassObject  {

Loginpage loginpage = new Loginpage();
Homepage homePage = new Homepage();

SignIn signIn = new SignIn();
SignUp signUp = new SignUp();
Article article = new Article();
ReadJson readJson = new ReadJson();

}
