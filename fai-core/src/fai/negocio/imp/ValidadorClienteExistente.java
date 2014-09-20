package fai.negocio.imp;

import fai.dao.IDAO;
import fai.dao.jpa.impl.ClienteDAO;
import fai.domain.EntidadeDominio;

public class ValidadorClienteExistente extends AbstractValidator {

	@Override
	public String validar(EntidadeDominio entidade) {
//		IDAO dao = new ClienteDAO();
//
//		if (dao.consulta(entidade).size() != 0) {
//			return "Cliente já cadastrado";
//		}
		return null;
	}

}
