# 🛒 Automação E2E - E-commerce Swag Labs

![Demonstração da Automação](evidencias.AutomacaoBasicSelenium.gif)
## 🎯 Sobre o Projeto
Este projeto é um framework de automação de testes End-to-End (E2E) desenvolvido para validar o fluxo completo de compras do e-commerce [Swag Labs](https://www.saucedemo.com/). O teste simula o comportamento de um usuário real, passando por todas as etapas críticas do sistema.

**Fluxo Automatizado:**
1. Login seguro no sistema.
2. Navegação na vitrine e validação do produto.
3. Adição de itens ao carrinho de compras.
4. Preenchimento do formulário de Checkout com dados dinâmicos.
5. Validação da tela de resumo e confirmação final da compra.

## 🏗️ Arquitetura e Padrões de Projeto
O projeto foi estruturado utilizando o padrão **Page Object Model (POM)**. 
Essa escolha arquitetural garante:
* **Manutenibilidade:** Separação clara entre as regras de negócio (Testes) e o mapeamento de elementos da interface (Páginas).
* **Reusabilidade:** Métodos e mapeamentos podem ser reaproveitados em múltiplos cenários de teste.
* **Código Limpo:** Scripts de teste legíveis, sem a exposição de seletores (`By.id`, `By.className`) na classe principal.

## 🚀 Tecnologias Utilizadas
* **Java:** Linguagem de programação base.
* **Selenium WebDriver:** Ferramenta para interação e automação do navegador web.
* **JUnit 5:** Framework para estruturação e validação (Assertions) dos testes.
* **Maven:** Gerenciador de dependências e build do projeto.
* **Datafaker:** Biblioteca para geração dinâmica de massa de dados realista (Nomes, Sobrenomes e CEPs) a cada execução do teste.
* **WebDriverManager:** Gerenciamento automatizado dos binários do navegador (ChromeDriver).

## ⚙️ Estrutura de Diretórios
```text
📂 src/test/java/com/automacao
 ┣ 📂 pages
 ┃ ┣ ☕ LoginPages.java
 ┃ ┣ ☕ VitrinePage.java
 ┃ ┣ ☕ CarrinhoPage.java
 ┃ ┣ ☕ CheckoutPage.java
 ┃ ┗ ☕ ResumoPage.java
 ┗ ☕ TesteSwab.java (Classe Executora)
