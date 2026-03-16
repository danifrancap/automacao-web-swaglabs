package com.automacao.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class CarrinhoPage {



     private WebDriver navegador;
    public CarrinhoPage(WebDriver navegador){
        this.navegador = navegador;
    }

    private By produtoNoCarrinho = By.className("inventory_item_name");
    private By achaCheckout = By.id("checkout");



    public String verificaProdutoNoCarrinho(){
        return navegador.findElement(produtoNoCarrinho).getText();
    }
    public void clicaCheckout(){
        navegador.findElement(achaCheckout).click();
    }
    
}
