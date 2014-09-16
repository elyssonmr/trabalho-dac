package fai.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fai.dao.IDAO;
import fai.domain.EntidadeDominio;
import fai.domain.TipoCliente;

public class TipoClienteDAO<T extends TipoCliente> implements IDAO<T> {


	private JdbcTemplate jdbcTemplate;

	@Override
	public void salvar(T entidade) {
		PreparedStatement pst = null;
		TipoCliente tipo = (TipoCliente) entidade;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_tipocliente(descricao, dt_cadastro) ");
		sql.append("VALUES (?, ?)");



		Timestamp time = new Timestamp(tipo.getDtCadastro().getTime());

		jdbcTemplate.update(sql.toString(), new Object[] { tipo.getDescricao(), time });

	}

	@Override
	public void alterar(T entidade) {
	}

	@Override
	public List<T> consultar(T entidade) {
	
	/*	PreparedStatement pst = null;
		String sql = "SELECT * FROM tb_tipocliente";
		try {
			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> tipos = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				TipoCliente t = new TipoCliente();
				t.setId(rs.getInt("id"));
				t.setDescricao(rs.getString("descricao"));
				tipos.add(t);
			}
			return tipos;
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		return null;
	}

	/** 
	 * TODO Descrição do Método
	 * @param entidade
	 * @see fai.dao.IDAO#excluir(fai.domain.EntidadeDominio)
	 */
	@Override
	public void excluir(T entidade) {
		// TODO Auto-generated method stub
		
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

}
