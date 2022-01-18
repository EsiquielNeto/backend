package br.com.cpqd.backendchalenge.core.domain;

import java.math.BigDecimal;

public class InformeDiarioTotal {
    private String cnpj;
    private BigDecimal captacaoDia;

    public InformeDiarioTotal(String cnpj, BigDecimal captacaoDia) {
        this.cnpj = cnpj;
        this.captacaoDia = captacaoDia;
    }

    public InformeDiarioTotal(final String csvLine) {

        final String[] line = csvLine.split(";");

        this.cnpj = line[0];
        this.captacaoDia = BigDecimal.valueOf(Double.parseDouble(line[1]));
    }

    public String getCnpj() {
        return cnpj;
    }

    public BigDecimal getCaptacaoDia() {
        return captacaoDia;
    }
}
