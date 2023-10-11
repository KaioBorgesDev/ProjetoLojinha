package testa;

import comandos.ComandosProdutos;

public class TestaComandoProduto {
    public static void main(String[] args) {
        ComandosProdutos comandosProdutos = new ComandosProdutos();
        comandosProdutos.inserirBD("Candida","Limpeza", 5);
    }
}
