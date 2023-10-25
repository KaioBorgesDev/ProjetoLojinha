package comandos;

import conexao.ConectaMySQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ComandosClientes {
    public boolean inserirBD(String nome, String cpf, String data_NASC){
        //comando utilizado no banco de dadinhos
        String comando = "insert into tb_cliente values(null, ?, ?, ?);";

        //cria a conexao
        ConectaMySQL conexao = new ConectaMySQL();
        //pega o conexao, guarda na variavel conecta
        Connection conecta = conexao.startConnection();

        //preparar a conexao que sera executado nela
        try {
            //Preparar a conexao com o comando que sera executado nela
            PreparedStatement preparedStatement = conecta.prepareStatement(comando);

            //formata a data para o padrao br
            java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd/mm/yyyy");
            java.util.Date data = null;

            //transformar a data
            data = format.parse(data_NASC);
            //passa a data para milisegundos pro msql poder pegar, ja que ele nao utiliza esse padrao ddmmmyyyy e sim mmddyyyy
            long milisegundo = data.getTime();

            //e transforma a data pra tchablau, usar com força
            //assim o SQL pode salvar a parada;
            Date sqlDate = new Date(milisegundo);

            //pasagem de valores para cada ? do comando INSERT
            preparedStatement.setString(1,nome);
            preparedStatement.setString(2,cpf);
            preparedStatement.setDate(3, sqlDate);

            //EXECUCAO DO COMANDO NO BANCO DE DADOS E TESTE DO QUE FOI RETORNADO
            if (preparedStatement.executeUpdate() != 0){
                System.out.println("insert deu certo");
                conexao.close();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

}
