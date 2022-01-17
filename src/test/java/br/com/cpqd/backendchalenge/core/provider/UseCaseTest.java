package br.com.cpqd.backendchalenge.core.provider;


import java.util.List;

import br.com.cpqd.backendchalenge.core.domain.InformeDiarioTotal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.cpqd.backendchalenge.InformeBoundary;
import br.com.cpqd.backendchalenge.core.domain.InformeDiario;
import br.com.cpqd.backendchalenge.dataprovider.InformeProvider;


public class UseCaseTest {


	private InformeBoundary pinheiroBoundary;

	@Before
	public void setup() {	
		pinheiroBoundary = new InformeProvider();

	}

	@Test
	public void deveObterOsDadosdeInformesDiario() {

		List<InformeDiario> all = pinheiroBoundary.getAll();
		Assert.assertEquals(124080, all.size());
	}

	@Test
	public void deveObterOSDadosInformeDiarioTotalDeCadaCNPJ() {
		List<InformeDiarioTotal> total = pinheiroBoundary.getInformeDiarioTotalByCNPJ();
		Assert.assertEquals(22874, total.size());
	}


}