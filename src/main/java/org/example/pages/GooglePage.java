package org.example.pages;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Data
@NoArgsConstructor
public class GooglePage {
    private final String googleSearchUrl = "https://www.google.com/";
    private WebElement searchInputElement, searchButtonElement;

    public void getGooglePage(WebDriver webDriver){
        webDriver.get(googleSearchUrl);
        searchInputElement = webDriver.findElement(By.xpath( "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        searchButtonElement = webDriver.findElement(By.xpath( "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
    }
}
