package com.automacao.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class CheckoutPage {


    
    private WebDriver navegador;
    public CheckoutPage(WebDriver navegador){
        this.navegador = navegador;
    }

    private By nomeCheckout = By.id("first-name");
    private By sobreNomeCheckout = By.id("last-name");
    private By cepCheckout = By.id("postal-code");
    private By botaoContinue = By.id("continue");


    public void escreveNomeCheckout(String primeiroNome){
        navegador.findElement(nomeCheckout).sendKeys(primeiroNome);
    }
    public void escreveSobreNomeCheckout(String sobrenome){
        navegador.findElement(sobreNomeCheckout).sendKeys(sobrenome);
    }
    public void cepCheckout(String cep){
        navegador.findElement(cepCheckout).sendKeys(cep);
    }
    public void clicaBotaoContinue(){
        navegador.findElement(botaoContinue).click();
    }

    
}
