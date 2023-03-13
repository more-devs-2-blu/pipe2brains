//Listas ficticias auxiliares para retorno de dados de um individuo ou cadastro imovel Prefeitura
package com.example.appMEI.classes;

import com.example.appMEI.dtos.CPFDto;
import com.example.appMEI.dtos.SituacaoDto;
import com.example.appMEI.dtos.CadIPTUDto;
import java.util.ArrayList;

public class Listas {
    private ArrayList<CPFDto> listaCpf =  new ArrayList<>();
    private ArrayList<CadIPTUDto> listaCadIPTU = new ArrayList<>();

    public Listas() {
        this.carregaListaCpf();
        this.carregaListaCadIPTU();
    }

    public ArrayList<CPFDto> getListaCpf() {
        return listaCpf;
    }

    // Carrega lista pré-definida com dados de cadastro de contribuintes.
    public void carregaListaCpf()  {
        this.listaCpf.add(new CPFDto("40442820135","Joaquim da Silva",new SituacaoDto("0", "Regular"), "14111970", "01"));

        this.listaCpf.add(new CPFDto("63017285995","Francisco Santos",new SituacaoDto("0", "Regular"),"28041979", "11"));
        this.listaCpf.add(new CPFDto("91708635203","Eduardo Fonseca",new SituacaoDto("0","Regular"),"01032006","11"));
        this.listaCpf.add(new CPFDto("40532176871","Marta Rocha",new SituacaoDto("0","Regular"),"22092002","12"));
        this.listaCpf.add(new CPFDto("10975384600","Paula Lopes",new SituacaoDto("0","Regular"),"22092002","22"));
        this.listaCpf.add(new CPFDto("01648527949","Edson Bezerra",new SituacaoDto("5","Cancelada por Multiplicidade"),"10031989","01"));
        this.listaCpf.add(new CPFDto("18025346790","Edson Bezerra",new SituacaoDto("8","Nula"),"10121999","11"));
        this.listaCpf.add(new CPFDto("52389071686","Juca Torres",new SituacaoDto("9","Cancelada de Ofício"),"15021998","11"));
        this.listaCpf.add(new CPFDto("05137518743","Patricia Antunes",new SituacaoDto("3","Titular Falecido"),"30122000","12"));
        this.listaCpf.add(new CPFDto("47123586964","José Guimarães",new SituacaoDto("2","Suspensa"),"01011954","22"));
        this.listaCpf.add(new CPFDto("64913872591","Aline Barbosa",new SituacaoDto("4","Pendente de Regularização"),"05012974","01"));
    }

    // Retorna objeto contendo dados de um registro baseado no cpf informado
    public CPFDto buscaCpf(String niAux) {
       for (int i = 0; i <= listaCpf.size()-1; i++) {
           if (listaCpf.get(i).getNi().equals(niAux)) {
               return listaCpf.get(i);
           }
       }
       return null;
    }

    // Retorna a lista pré definida de registros de contribuintes
    public ArrayList<CadIPTUDto> getListaCadIPTU() {
        return listaCadIPTU;
    }

    // Carrega lista pré-definida com dados de cadastro de imoveis.
    public void carregaListaCadIPTU() {
        this.listaCadIPTU.add(new CadIPTUDto("241500022554",new ArrayList<String>(),"Rua Governador Jorge Lacerda, 1890, Velha, 89045337",true));
        this.listaCadIPTU.add(new CadIPTUDto("241500021987",new ArrayList<String>(),"Rua 7 de Setembro, 720, Centro, 89010200", false));
        ArrayList<String> proibAux1 = new ArrayList<String>(); proibAux1.add("0159801"); proibAux1.add("2599301");
        this.listaCadIPTU.add(new CadIPTUDto("241500021666",proibAux1,"Rua Progresso, 1200, Progresso, 89026202", true));
        ArrayList<String> proibAux2 = new ArrayList<String>(); proibAux2.add("5099899"); proibAux2.add("4744099");
        this.listaCadIPTU.add(new CadIPTUDto("241500026123",proibAux2,"Rua João Pessoa, 200, Velha, 89036000", false));
    }

    // Retorna objeto contendo dados de um registro baseado no cadstro de IPTU informado
    public CadIPTUDto buscaCadIPTU(String inscrCadIPTUAux) {
        for (int i = 0; i <= listaCadIPTU.size()-1; i++) {
            if (listaCadIPTU.get(i).getCad().equals(inscrCadIPTUAux)) {
                return listaCadIPTU.get(i);
            }
        }
        return null;
    }
}
