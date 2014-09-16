
package fai.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import fai.domain.Endereco;
import fai.domain.EntidadeDominio;



public class EnderecoJdbcDAO extends AbstractJdbcDAO {

	
	protected EnderecoJdbcDAO(String table, String idTable) {
		super("tb_endereco", "id_end");	
	}
	
	public EnderecoJdbcDAO(){
		super("tb_endereco", "id_end");			
	}
	
	public void salvar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst=null;
		Endereco end = (Endereco)entidade;
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO tb_endereco(cidade, estado, ");
		sql.append("logradouro, numero, cep, dt_cadastro) ");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?)");	
		try {
			connection.setAutoCommit(false);
			
					
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, end.getCidade());
			pst.setString(2, end.getEstado());
			pst.setString(3, end.getLogradouro());
			pst.setString(4, end.getNumero());
			pst.setInt(5, end.getCep());			
			Timestamp time = new Timestamp(end.getDtCadastro().getTime());
			pst.setTimestamp(6, time);
			pst.executeUpdate();		
					
			ResultSet rs = pst.getGeneratedKeys();
			int idEnd=0;
			if(rs.next())
				idEnd = rs.getInt(1);
			end.setId(idEnd);
			
			connection.commit();					
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}finally{
			try {
				pst.close();
				if(ctrlTransaction)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	@Override
	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

	/** 
	 * TODO Descrição do Método
	 * @param entidade
	 * @return
	 * @see fai.dao.IDAO#consulta(fai.domain.EntidadeDominio)
	 */
	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
