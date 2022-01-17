package br.com.cpqd.backendchalenge;

import java.util.List;

import br.com.cpqd.backendchalenge.core.domain.InformeDiario;
import br.com.cpqd.backendchalenge.core.domain.InformeDiarioTotal;


public interface InformeBoundary {
	List<InformeDiario> getAll();

	List<InformeDiarioTotal> getInformeDiarioTotalByCNPJ();


}
