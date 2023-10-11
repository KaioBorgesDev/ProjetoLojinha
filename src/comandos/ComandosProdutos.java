package comandos;

import conexao.ConectaMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ComandosProdutos {
        public boolean inserirBD(String produto, String categoria, float preco){
            String comando = "insert into tb_produto values(null, ?, ?, ?);";

            //cria a conexao
            ConectaMySQL conexao = new ConectaMySQL();
            //pega o conexao, guarda na variavel conecta
            Connection conecta = conexao.startConnection();

            //preparar a conexao que sera executado nela
            try {
                //Preparar a conexao com o comando que sera executado nela
                PreparedStatement preparedStatement = conecta.prepareStatement(comando);

                //pasagem de valores para cada ? do comando INSERT

                preparedStatement.setString(1,produto);
                preparedStatement.setString(2,categoria);
                preparedStatement.setFloat(3, preco);

                //EXECUCAO DO COMANDO NO BANCO DE DADOS E TESTE DO QUE FOI RETORNADO
                if (preparedStatement.executeUpdate() != 0){
                    System.out.println("insert deu certo");
                    conexao.close();
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return true;
        }

        public boolean updateBD(String produto, String categoria, float preco){
            return true;
        }
}
