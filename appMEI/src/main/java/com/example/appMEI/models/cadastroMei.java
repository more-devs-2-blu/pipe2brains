package com.example.appMEI.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity(name = "TB_CADASTRO_MEI")
public class cadastroMei implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private UUID id;
    private String nome;
    private String cpf;
    private String statusCpf;   //Contém a situação do CPF, Regular, Cancelada por Multiplicidade, Nulo
    private String dataNascimento;
    private String email;
    private String telefone1;
    private String telefone2;

    private String cnaePrimario;
    private String cnaePrimarioOcupacao; //Descrição da ocupação relacionada ao CNAE

    private boolean eFuncPublico;
    private boolean eSocio;
    private boolean eMeiAtivo;
    private boolean temAposentadoriaInvalidez;
    private boolean temAuxilioDoenca;
    private boolean temSalarioMaternidade;
    private boolean temSegDesemprego;
    private boolean temBpcLoas;
    private boolean temProuni;
    private boolean temFies;
    private boolean temBolsaFamilia;

    private boolean temFiliais;
    private long previsaoFaturamento;
    private long previsaoCustos;
    private int nrFuncionarios;

    private String nrCadastroIPTU;  //Contém o número de 6 digitos na página frontal do carne de IPTU
    private String enderecoIPTU;    //Contém o endereço cadastrado no nr IPTU
    private Integer areaEmpreendimento; //Contém a área do empreendimento

    private Date dataConsulta;  //Data de realização da consulta
    private boolean statusConsultaMEI;  //Contem o resultado final da consulta. Dados (true Apto) (false Inapto)
    private boolean statusConsultaIPTU; //Contém o status da consulta de viabilidade do Imovel obtida pelo nr cadastro IPTU

    public cadastroMei (){}

    public cadastroMei(UUID id, String nome, String cpf, String statusCpf, String dataNascimento, String email, String telefone1, String telefone2, String cnaePrimario, String cnaePrimarioOcupacao, boolean eFuncPublico, boolean eSocio, boolean eMeiAtivo, boolean temAposentadoriaInvalidez, boolean temAuxilioDoenca, boolean temSalarioMaternidade, boolean temSegDesemprego, boolean temBpcLoas, boolean temProuni, boolean temFies, boolean temBolsaFamilia, boolean temFiliais, long previsaoFaturamento, long previsaoCustos, int nrFuncionarios, String nrCadastroIPTU, String enderecoIPTU, Integer areaEmpreendimento, Date dataConsulta, boolean statusConsultaMEI, boolean statusConsultaIPTU) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.statusCpf = statusCpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.cnaePrimario = cnaePrimario;
        this.cnaePrimarioOcupacao = cnaePrimarioOcupacao;
        this.eFuncPublico = eFuncPublico;
        this.eSocio = eSocio;
        this.eMeiAtivo = eMeiAtivo;
        this.temAposentadoriaInvalidez = temAposentadoriaInvalidez;
        this.temAuxilioDoenca = temAuxilioDoenca;
        this.temSalarioMaternidade = temSalarioMaternidade;
        this.temSegDesemprego = temSegDesemprego;
        this.temBpcLoas = temBpcLoas;
        this.temProuni = temProuni;
        this.temFies = temFies;
        this.temBolsaFamilia = temBolsaFamilia;
        this.temFiliais = temFiliais;
        this.previsaoFaturamento = previsaoFaturamento;
        this.previsaoCustos = previsaoCustos;
        this.nrFuncionarios = nrFuncionarios;
        this.nrCadastroIPTU = nrCadastroIPTU;
        this.enderecoIPTU = enderecoIPTU;
        this.areaEmpreendimento = areaEmpreendimento;
        this.dataConsulta = dataConsulta;
        this.statusConsultaMEI = statusConsultaMEI;
        this.statusConsultaIPTU = statusConsultaIPTU;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getStatusCpf() {
        return statusCpf;
    }

    public void setStatusCpf(String statusCpf) {
        this.statusCpf = statusCpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getCnaePrimario() {
        return cnaePrimario;
    }

    public void setCnaePrimario(String cnaePrimario) {
        this.cnaePrimario = cnaePrimario;
    }

    public String getCnaePrimarioOcupacao() {
        return cnaePrimarioOcupacao;
    }

    public void setCnaePrimarioOcupacao(String cnaePrimarioOcupacao) {
        this.cnaePrimarioOcupacao = cnaePrimarioOcupacao;
    }

    public boolean iseFuncPublico() {
        return eFuncPublico;
    }

    public void seteFuncPublico(boolean eFuncPublico) {
        this.eFuncPublico = eFuncPublico;
    }

    public boolean iseSocio() {
        return eSocio;
    }

    public void seteSocio(boolean eSocio) {
        this.eSocio = eSocio;
    }

    public boolean iseMeiAtivo() {
        return eMeiAtivo;
    }

    public void seteMeiAtivo(boolean eMeiAtivo) {
        this.eMeiAtivo = eMeiAtivo;
    }

    public boolean isTemAposentadoriaInvalidez() {
        return temAposentadoriaInvalidez;
    }

    public void setTemAposentadoriaInvalidez(boolean temAposentadoriaInvalidez) {
        this.temAposentadoriaInvalidez = temAposentadoriaInvalidez;
    }

    public boolean isTemAuxilioDoenca() {
        return temAuxilioDoenca;
    }

    public void setTemAuxilioDoenca(boolean temAuxilioDoenca) {
        this.temAuxilioDoenca = temAuxilioDoenca;
    }

    public boolean isTemSalarioMaternidade() {
        return temSalarioMaternidade;
    }

    public void setTemSalarioMaternidade(boolean temSalarioMaternidade) {
        this.temSalarioMaternidade = temSalarioMaternidade;
    }

    public boolean isTemSegDesemprego() {
        return temSegDesemprego;
    }

    public void setTemSegDesemprego(boolean temSegDesemprego) {
        this.temSegDesemprego = temSegDesemprego;
    }

    public boolean isTemBpcLoas() {
        return temBpcLoas;
    }

    public void setTemBpcLoas(boolean temBpcLoas) {
        this.temBpcLoas = temBpcLoas;
    }

    public boolean isTemProuni() {
        return temProuni;
    }

    public void setTemProuni(boolean temProuni) {
        this.temProuni = temProuni;
    }

    public boolean isTemFies() {
        return temFies;
    }

    public void setTemFies(boolean temFies) {
        this.temFies = temFies;
    }

    public boolean isTemBolsaFamilia() {
        return temBolsaFamilia;
    }

    public void setTemBolsaFamilia(boolean temBolsaFamilia) {
        this.temBolsaFamilia = temBolsaFamilia;
    }

    public boolean isTemFiliais() {
        return temFiliais;
    }

    public void setTemFiliais(boolean temFiliais) {
        this.temFiliais = temFiliais;
    }

    public long getPrevisaoFaturamento() {
        return previsaoFaturamento;
    }

    public void setPrevisaoFaturamento(long previsaoFaturamento) {
        this.previsaoFaturamento = previsaoFaturamento;
    }

    public long getPrevisaoCustos() {
        return previsaoCustos;
    }

    public void setPrevisaoCustos(long previsaoCustos) {
        this.previsaoCustos = previsaoCustos;
    }

    public int getNrFuncionarios() {
        return nrFuncionarios;
    }

    public void setNrFuncionarios(int nrFuncionarios) {
        this.nrFuncionarios = nrFuncionarios;
    }

    public String getNrCadastroIPTU() {
        return nrCadastroIPTU;
    }

    public void setNrCadastroIPTU(String nrCadastroIPTU) {
        this.nrCadastroIPTU = nrCadastroIPTU;
    }

    public String getEnderecoIPTU() {
        return enderecoIPTU;
    }

    public void setEnderecoIPTU(String enderecoIPTU) {
        this.enderecoIPTU = enderecoIPTU;
    }

    public Integer getAreaEmpreendimento() {
        return areaEmpreendimento;
    }

    public void setAreaEmpreendimento(Integer areaEmpreendimento) {
        this.areaEmpreendimento = areaEmpreendimento;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public boolean isStatusConsultaMEI() {
        return statusConsultaMEI;
    }

    public void setStatusConsultaMEI(boolean statusConsultaMEI) {
        this.statusConsultaMEI = statusConsultaMEI;
    }

    public boolean isStatusConsultaIPTU() {
        return statusConsultaIPTU;
    }

    public void setStatusConsultaIPTU(boolean statusConsultaIPTU) {
        this.statusConsultaIPTU = statusConsultaIPTU;
    }
}
