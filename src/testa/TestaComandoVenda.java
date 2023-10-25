package testa;

import comandos.ComandosVendas;

public class TestaComandoVenda {
    public static void main(String[] args) {
        ComandosVendas comandosVendas = new ComandosVendas();

        comandosVendas.inserirBD(6,"02/02/5122",1,7);
    }
}
