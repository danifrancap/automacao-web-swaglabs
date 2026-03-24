package com.automacao;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.datafaker.Faker;
import java.util.Locale;
import org.openqa.selenium.chrome.ChromeOptions;
import com.automacao.pages.VitrinePage;
import com.automacao.pages.CarrinhoPage;
import com.automacao.pages.CheckoutPage;
import com.automacao.pages.LoginPages;
import com.automacao.pages.ResumoPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TesteSwab {
  WebDriver navegador;
  WebDriverWait espera;
        
  @BeforeEach
    public void abrirNav(){
      ChromeOptions opcoes = new ChromeOptions();
        opcoes.addArguments("--disable-features=PasswordLeakDetection");
        opcoes.addArguments("--incognito");
        navegador = new ChromeDriver(opcoes);
        WebDriverManager.chromedriver().setup();
        espera = new WebDriverWait(navegador, Duration.ofSeconds(10));
        navegador.get("https://www.saucedemo.com/");
        navegador.manage().window().maximize();
        espera.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("user-name")));

    }
    @AfterEach
    public void fecharNav(){
      navegador.quit();
    }
    @Test
    public void validaLoginErrado(){
       LoginPages paginaLogin = new LoginPages(navegador);
        paginaLogin.escreverNomeLogin("visual_us1er");
        paginaLogin.digitarSenha("secret_sa1uce");
        paginaLogin.cliqueBotaoLogin();
        String validaErro = paginaLogin.validaErro();
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", validaErro);

    }

    @Test
    public void validarPrimeiroProduto() throws InterruptedException {

        // encontra o elemento do username e da senha e o send keys envia o texto
        LoginPages paginaLogin = new LoginPages(navegador);
        paginaLogin.escreverNomeLogin("visual_user");
        paginaLogin.digitarSenha("secret_sauce");
        paginaLogin.cliqueBotaoLogin();
       

       VitrinePage paginaVitrine = new VitrinePage(navegador);

       String nomeProduto = paginaVitrine.acharMochila();
      //valida o produto
      Assertions.assertEquals("Sauce Labs Backpack", nomeProduto);
//adiciona no carrinho e cliqua no Carrinho
      paginaVitrine.adicionarAoCarrinho();
      paginaVitrine.cliqueIconeCarrinho();


        espera.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("inventory_item_name")));
        
        //verifica se o produto é o mesmo que foi selecionado
        CarrinhoPage paginaCarrinho = new CarrinhoPage(navegador);

        String nomeProdutoCarrinho = paginaCarrinho.verificaProdutoNoCarrinho();
        Assertions.assertEquals("Sauce Labs Backpack", nomeProdutoCarrinho);
        paginaCarrinho.clicaCheckout();


        espera.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("first-name")));
        //cria o objeto para massa de dados fake para teste
        Faker gerador = new Faker(new Locale("pt", "BR"));
        String nomeA = gerador.name().firstName();
        String nomeB = gerador.name().lastName();
        String cep = gerador.address().zipCode();
        
        //seleciona e preenche os campos para teste
       CheckoutPage paginaCheckout = new CheckoutPage(navegador);

       paginaCheckout.escreveNomeCheckout(nomeA);
       paginaCheckout.escreveSobreNomeCheckout(nomeB);
       paginaCheckout.cepCheckout(cep);
       paginaCheckout.clicaBotaoContinue();

        // finaliza a compra
      espera.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("inventory_item_name")));
      ResumoPage paginaResumo = new ResumoPage(navegador);

      String nomeProdutoNoResumo = paginaResumo.validaProdutoFinal();
      Assertions.assertEquals("Sauce Labs Backpack", nomeProdutoNoResumo);

      paginaResumo.clicaBotaoFinalizar();

      String mensagemFinal = paginaResumo.validaMensagemFinal();
      Assertions.assertEquals("Thank you for your order!", mensagemFinal);
        


        
        
    }
      
}
