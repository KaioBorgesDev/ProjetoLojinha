package testa;

import comandos.ComandosProdutos;
import conexao.ConectaMySQL;

public class Conexao {
    public static void main(String[] args) {
        ConectaMySQL conectaMySQL = new ConectaMySQL();

        conectaMySQL.startConnection();


        conectaMySQL.close();

    }
}
