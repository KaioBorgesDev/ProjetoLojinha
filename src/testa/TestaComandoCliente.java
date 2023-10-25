package testa;

import comandos.ComandosClientes;
import conexao.ConectaMySQL;

public class TestaComandoCliente {
    public static void main(String[] args) {
        ComandosClientes comandosClientes = new ComandosClientes();

        comandosClientes.inserirBD("Kaio","929.202.200-26","02/02/2004");
    }
}
