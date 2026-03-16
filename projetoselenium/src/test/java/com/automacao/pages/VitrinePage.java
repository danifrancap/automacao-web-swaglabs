package com.automacao.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VitrinePage {


    private WebDriver navegador;
    public VitrinePage(WebDriver navegador){
        this.navegador = navegador;
    }
    
        private By produtoMochila = By.className("inventory_item_name");
        private By botaoAdicionarAoCarrinho = By.id("add-to-cart-sauce-labs-backpack");
        private By iconeCarrinho = By.className("shopping_cart_link");
        

       public String acharMochila(){  
           return navegador.findElement(produtoMochila).getText();
            }
        public void  adicionarAoCarrinho(){
            navegador.findElement(botaoAdicionarAoCarrinho).click();
        }
         public void  cliqueIconeCarrinho(){
            navegador.findElement(iconeCarrinho).click();
        }
        




}
