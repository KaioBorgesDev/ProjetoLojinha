package testa;

import comandos.ComandosProdutos;

public class TestaComandoProduto {
    public static void main(String[] args) {
        ComandosProdutos comandosProdutos = new ComandosProdutos();
        //inserindo ao BD
        comandosProdutos.inserirBD("Candida","Limpeza", 5);

        //Alterando o BD
        //comandosProdutos.alterarProdutos("UPDATE tb_produto SET nome_produto = 'Cerveja Quente' , categoria_produto = 'Bebidas' WHERE id_produto =6;");

        //Pesquisando ao BD
        comandosProdutos.pesquisarProduto("select * from tb_produto");

        comandosProdutos.deletarProduto("Delete from tb_produto where id_produto = 32");
    }
}
