
package br.com.CadastroFuncionario.Control;

import br.com.CadastroFuncionario.Model.Funcionarios;
import br.com.CadastroFuncionario.Repositorio.FuncionariosRepositorio;
import br.com.CadastroFuncionario.Repositorio.IFuncionarios;
import java.util.List;

/**
 *
 * @author Esdras Alves
 */
public class FuncionarioControl implements IFuncionarioControl {

    private static IFuncionarioControl instancia;
    private static IFuncionarios repositorio;
    
    public FuncionarioControl() {
		repositorio = FuncionariosRepositorio.getInstance();
	}

	public static IFuncionarioControl getInstance() {
		if (instancia == null) {
			return instancia = new FuncionarioControl();
		}
		return instancia;
	}
    
public void create(Funcionarios F){

}

public void update(Funcionarios F){

}

public void delete(Funcionarios F){
}

public List<Funcionarios> read(){
        return null;

}
}
