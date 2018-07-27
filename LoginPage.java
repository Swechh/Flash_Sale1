package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginPage 
{
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@class='_2zrpKA']")
	private WebElement UnTf;
	
	
	@FindBy(xpath="//input[@class='_2zrpKA _3v41xv']")
	private WebElement PwTf;
	
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	private WebElement LoginBtn;
	
	
	
	
	
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	private WebElement close;
	
	@FindBy(xpath="//a[.='Login & Signup']")
	private WebElement signup;
	
	public void setUserName(String un) throws Exception
	{
		//Thread.sleep(2000);
		UnTf.sendKeys(Keys.CONTROL+"a");
		UnTf.sendKeys(Keys.DELETE);
		UnTf.sendKeys(un);
		
	}
	
	public void setPassword(String pw) throws Exception
	{
		//Thread.sleep(2000);
		PwTf.sendKeys(Keys.CONTROL+"a");
		PwTf.sendKeys(Keys.DELETE);
		PwTf.sendKeys(pw);
		
	}
	
	public void clickLogin()
	{
		LoginBtn.click();
	
		
	}
	
	public void  refresh() throws Exception
	{
		//Thread.sleep(2000);
		close.click();
		//Thread.sleep(2000);
		signup.click();
		
	}
	
	
	@FindBy(xpath="//span[.='Please enter valid Email ID/Mobile number'  or .='Your username or password is incorrect' or .='Please enter Password']")
	private WebElement errMsg;
	
	
	public void verifyErrMsg(String expectedMSG) {
		String actualMSG=errMsg.getText();
		System.out.println(actualMSG);
		System.out.println(expectedMSG);
		SoftAssert s= new SoftAssert();
		s.assertEquals(actualMSG,expectedMSG);
	}

}
