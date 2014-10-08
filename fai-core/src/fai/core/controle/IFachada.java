
package fai.core.controle;

import fai.domain.EntidadeDominio;
import fai.domain.Resultado;


public interface IFachada<E extends EntidadeDominio> {
    public Resultado<E> salvar(E entidade);
    public Resultado<E> alterar(E entidade);
    public Resultado<E> consultar(E entidade);
    public Resultado<E> excluir(E entidade);
}
