package fai.negocio.imp;

import org.springframework.beans.factory.annotation.Autowired;

import fai.dao.IDAO;
import fai.dao.jpa.impl.ClienteDAO;
import fai.domain.Cliente;
import fai.domain.EntidadeDominio;

public class ValidadorClienteExistente extends AbstractValidator {

	@Autowired
	IDAO<EntidadeDominio> clienteDao;

	@Override
	public String validar(EntidadeDominio entidade) {

		if (clienteDao.consultar(entidade).size() != 0) {
			return "Cliente já cadastrado";
		}
		return null;
	}

}
