package br.com.cpqd.backendchalenge.core.domain;

import java.math.BigDecimal;

public class InformeDiarioTotal {

    private String cnpj;
    private Double captacaoDia;

    public InformeDiarioTotal() {
    }

    public InformeDiarioTotal(String cnpj, Double captacaoDia) {
        this.cnpj = cnpj;
        this.captacaoDia = captacaoDia.doubleValue();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Double getCaptacaoDia() {
        return captacaoDia;
    }

    public void setCaptacaoDia(Double captacaoDia) {
        this.captacaoDia = captacaoDia;
    }
}
