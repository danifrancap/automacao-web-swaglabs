package com.automacao.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResumoPage {

     private WebDriver navegador;
    public ResumoPage(WebDriver navegador){
        this.navegador = navegador;
    }
    

    private By nomeProdutoFinal = By.className("inventory_item_name");
    private By botaoFinalizar = By.id("finish");
    private By mensagemFinal = By.className("complete-header");

    public String validaProdutoFinal(){
        return navegador.findElement(nomeProdutoFinal).getText();
    }
    public void clicaBotaoFinalizar(){
        navegador.findElement(botaoFinalizar).click();
    }
    public String validaMensagemFinal(){
        return navegador.findElement(mensagemFinal).getText();
    }

}
