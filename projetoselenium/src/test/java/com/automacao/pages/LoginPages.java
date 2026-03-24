package com.automacao.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPages {

     private WebDriver navegador;
    public LoginPages(WebDriver navegador){
        this.navegador = navegador;
    }
    

        private By acharNome = By.id("user-name");
        private By senhaCorreta = By.id("password");
        private By botaoLogin = By.id("login-button");
        private By mensagemErro = By.xpath("//h3[@data-test='error']");


        public void escreverNomeLogin(String nomeLogin){
            navegador.findElement(acharNome).sendKeys(nomeLogin);
        }
        public void digitarSenha(String senha){
            navegador.findElement(senhaCorreta).sendKeys(senha);
        }
        public void cliqueBotaoLogin(){
            navegador.findElement(botaoLogin).click();
        }
        public String validaErro(){
            return navegador.findElement(mensagemErro).getText();

        }
    
    }


