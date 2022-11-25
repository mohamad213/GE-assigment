package org.example;

import org.example.pages.GooglePage;
import org.example.pages.Page;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import utils.GoogleSearchUtil;

import java.util.List;

public class GoogleSearchTest {
    @Test(dataProvider = "validSearchInput")
    public void testValidSearch(String input) {

        GooglePage googlePage = new GooglePage();
        Page page = new Page();
        WebDriver driver = GoogleSearchUtil.getWebDriver();

        System.out.println("Go to Google page");
        googlePage.getGooglePage(driver);

        System.out.println("Input word search to Google page");
        googlePage.getSearchInputElement().sendKeys(input);

        System.out.println("Click search button at Google page");
        googlePage.getSearchButtonElement().click();

        System.out.println("Verify search output in page body");
        page.findPageBody(driver);
        String pageBody = page.getPageBody().getText();
        List<String> resultUrls = GoogleSearchUtil.ExtractUrls(pageBody);
        driver.quit();
        boolean isJavaFound = resultUrls.get(0).toLowerCase().contains("java");
        Assert.assertEquals(isJavaFound, Boolean.TRUE,
                String.format("First search result link when searching for '%s' doesn't contains the word 'Java'!",
                        input));
    }

    @Test(dataProvider = "invalidSearchInput")
    public void testInvalidSearch(String input) {
        GooglePage googlePage = new GooglePage();
        Page page = new Page();
        WebDriver driver = GoogleSearchUtil.getWebDriver();
        System.out.println("Go to Google page");
        googlePage.getGooglePage(driver);

        System.out.println("Input word search to Google page");
        googlePage.getSearchInputElement().sendKeys(input);

        System.out.println("Click search button at Google page");
        googlePage.getSearchButtonElement().click();

        System.out.println("Verify search output in page body");
        page.findPageBody(driver);
        String pageBody = page.getPageBody().getText();
        List<String> resultUrls = GoogleSearchUtil.ExtractUrls(pageBody);
        driver.quit();
        boolean isJavaFound = resultUrls.get(0).toLowerCase().contains("java");
        Assert.assertEquals(isJavaFound, Boolean.FALSE,
                String.format("First search result link when searching for '%s' contains the word 'Java', although it's shouldn't!",
                        input));
    }

    @DataProvider(name="validSearchInput", parallel = true)
    public static Object[][] validSearchInput(){
        return new Object[][]{ {"Java"}, {"java"}, {"JAVA"}} ;
    }

    @DataProvider(name="invalidSearchInput", parallel = true)
    public static Object[][] invalidSearchInput(){
        return new Object[][]{ {"GE"}, {"bmw"}, {"python"}} ;
    }
}
