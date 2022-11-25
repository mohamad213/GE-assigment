package org.example.pages;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Data
@NoArgsConstructor
public class Page {

    private WebElement pageBody ;

    public void findPageBody(WebDriver webDriver){
        pageBody = webDriver.findElement(By.xpath("/html/body"));
    }
}
