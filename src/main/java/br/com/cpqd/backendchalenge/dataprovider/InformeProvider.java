package br.com.cpqd.backendchalenge.dataprovider;


import br.com.cpqd.backendchalenge.InformeBoundary;
import br.com.cpqd.backendchalenge.core.domain.InformeDiario;
import br.com.cpqd.backendchalenge.core.domain.InformeDiarioTotal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class InformeProvider implements InformeBoundary {

    private static final int HEADER_LINE = 1;

    @Override
    public List<InformeDiario> getAll() {
        try (BufferedReader reader = getInformeDiarioCSV()) {
            return reader
                    .lines()
                    .skip(HEADER_LINE)
                    .map(InformeDiario::new)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("Erro ao realizar leitura do arquivo CSV");
        }
    }


    @Override
    public List<InformeDiarioTotal> getInformeDiarioTotalByCNPJ() {
        try (BufferedReader reader = getInformeDiarioCSV()) {
            return reader
                    .lines()
                    .skip(HEADER_LINE)
                    .map(InformeDiarioTotal::new)
                    .collect(Collectors.groupingBy(InformeDiarioTotal::getCnpj, Collectors.reducing(BigDecimal.ZERO, InformeDiarioTotal::getCaptacaoDia, BigDecimal::add)))
                    .entrySet()
                    .stream()
                    .map(e -> new InformeDiarioTotal(e.getKey(), e.getValue()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("Erro ao realizar leitura do arquivo CSV");
        }
    }

    private BufferedReader getInformeDiarioCSV() {
        try {
            final Path path = Paths.get("src/main/resources/informes", "informe_diario.csv");
            Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);

            return new BufferedReader(reader);
        } catch (IOException ex) {
            throw new IllegalArgumentException("Arquivo não encontrado");
        }
    }

}
