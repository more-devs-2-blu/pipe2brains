package com.example.appMEI.models;

import jakarta.persistence.*;

import java.io.Serializable;
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
    private String dataNascimento;
    private String email;
    private String telefone1;
    private String telefone2;

    private String enderecoResPais;
    private String enderecoResCep;
    private String enderecoResEstado;
    private String enderecoResCidade;
    private String enderecoResLogradouro;
    private String enderecoResNumero;
    private String enderecoResComplemento;
    private String enderecoResBairro;

    private String enderecoEmpPais;
    private String enderecoEmpCep;
    private String enderecoEmpEstado;
    private String enderecoEmpCidade;
    private String enderecoEmpLogradouro;
    private String enderecoEmpNumero;
    private String enderecoEmpComplemento;
    private String enderecoEmpBairro;
    private String cnaePrimario;
    private String cnaesSecundarios;

    private boolean eFuncPublico;
    private boolean eSocio;
    private boolean eMeiAtivo;
    private boolean temFiliais;
    private boolean temAposentadoriaInvalidez;
    private boolean temAuxilioDoenca;
    private boolean temSalarioMaternidade;
    private boolean temSegDesemprego;
    private boolean temBpcLoas;
    private boolean temProuni;
    private boolean temFies;
    private boolean temBolsaFamilia;

    private long previsaoFaturamento;
    private long previsaoCustos;
    private int nrFuncionarios;

    public cadastroMei (){}

    public cadastroMei(UUID id, String nome, String cpf, String dataNascimento, String email, String telefone1, String telefone2, String enderecoResPais, String enderecoResCep, String enderecoResEstado, String enderecoResCidade, String enderecoResLogradouro, String enderecoResNumero, String enderecoResComplemento, String enderecoResBairro, String enderecoEmpPais, String enderecoEmpCep, String enderecoEmpEstado, String enderecoEmpCidade, String enderecoEmpLogradouro, String enderecoEmpNumero, String enderecoEmpComplemento, String enderecoEmpBairro, String cnaePrimario, String cnaesSecundarios, boolean eFuncPublico, boolean eSocio, boolean eMeiAtivo, boolean temFiliais, boolean temAposentadoriaInvalidez, boolean temAuxilioDoenca, boolean temSalarioMaternidade, boolean temSegDesemprego, boolean temBpcLoas, boolean temProuni, boolean temFies, boolean temBolsaFamilia, long previsaoFaturamento, long previsaoCustos, int nrFuncionarios) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.enderecoResPais = enderecoResPais;
        this.enderecoResCep = enderecoResCep;
        this.enderecoResEstado = enderecoResEstado;
        this.enderecoResCidade = enderecoResCidade;
        this.enderecoResLogradouro = enderecoResLogradouro;
        this.enderecoResNumero = enderecoResNumero;
        this.enderecoResComplemento = enderecoResComplemento;
        this.enderecoResBairro = enderecoResBairro;
        this.enderecoEmpPais = enderecoEmpPais;
        this.enderecoEmpCep = enderecoEmpCep;
        this.enderecoEmpEstado = enderecoEmpEstado;
        this.enderecoEmpCidade = enderecoEmpCidade;
        this.enderecoEmpLogradouro = enderecoEmpLogradouro;
        this.enderecoEmpNumero = enderecoEmpNumero;
        this.enderecoEmpComplemento = enderecoEmpComplemento;
        this.enderecoEmpBairro = enderecoEmpBairro;
        this.cnaePrimario = cnaePrimario;
        this.cnaesSecundarios = cnaesSecundarios;
        this.eFuncPublico = eFuncPublico;
        this.eSocio = eSocio;
        this.eMeiAtivo = eMeiAtivo;
        this.temFiliais = temFiliais;
        this.temAposentadoriaInvalidez = temAposentadoriaInvalidez;
        this.temAuxilioDoenca = temAuxilioDoenca;
        this.temSalarioMaternidade = temSalarioMaternidade;
        this.temSegDesemprego = temSegDesemprego;
        this.temBpcLoas = temBpcLoas;
        this.temProuni = temProuni;
        this.temFies = temFies;
        this.temBolsaFamilia = temBolsaFamilia;
        this.previsaoFaturamento = previsaoFaturamento;
        this.previsaoCustos = previsaoCustos;
        this.nrFuncionarios = nrFuncionarios;
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

    public String getEnderecoResPais() {
        return enderecoResPais;
    }

    public void setEnderecoResPais(String enderecoResPais) {
        this.enderecoResPais = enderecoResPais;
    }

    public String getEnderecoResCep() {
        return enderecoResCep;
    }

    public void setEnderecoResCep(String enderecoResCep) {
        this.enderecoResCep = enderecoResCep;
    }

    public String getEnderecoResEstado() {
        return enderecoResEstado;
    }

    public void setEnderecoResEstado(String enderecoResEstado) {
        this.enderecoResEstado = enderecoResEstado;
    }

    public String getEnderecoResCidade() {
        return enderecoResCidade;
    }

    public void setEnderecoResCidade(String enderecoResCidade) {
        this.enderecoResCidade = enderecoResCidade;
    }

    public String getEnderecoResLogradouro() {
        return enderecoResLogradouro;
    }

    public void setEnderecoResLogradouro(String enderecoResLogradouro) {
        this.enderecoResLogradouro = enderecoResLogradouro;
    }

    public String getEnderecoResNumero() {
        return enderecoResNumero;
    }

    public void setEnderecoResNumero(String enderecoResNumero) {
        this.enderecoResNumero = enderecoResNumero;
    }

    public String getEnderecoResComplemento() {
        return enderecoResComplemento;
    }

    public void setEnderecoResComplemento(String enderecoResComplemento) {
        this.enderecoResComplemento = enderecoResComplemento;
    }

    public String getEnderecoResBairro() {
        return enderecoResBairro;
    }

    public void setEnderecoResBairro(String enderecoResBairro) {
        this.enderecoResBairro = enderecoResBairro;
    }

    public String getEnderecoEmpPais() {
        return enderecoEmpPais;
    }

    public void setEnderecoEmpPais(String enderecoEmpPais) {
        this.enderecoEmpPais = enderecoEmpPais;
    }

    public String getEnderecoEmpCep() {
        return enderecoEmpCep;
    }

    public void setEnderecoEmpCep(String enderecoEmpCep) {
        this.enderecoEmpCep = enderecoEmpCep;
    }

    public String getEnderecoEmpEstado() {
        return enderecoEmpEstado;
    }

    public void setEnderecoEmpEstado(String enderecoEmpEstado) {
        this.enderecoEmpEstado = enderecoEmpEstado;
    }

    public String getEnderecoEmpCidade() {
        return enderecoEmpCidade;
    }

    public void setEnderecoEmpCidade(String enderecoEmpCidade) {
        this.enderecoEmpCidade = enderecoEmpCidade;
    }

    public String getEnderecoEmpLogradouro() {
        return enderecoEmpLogradouro;
    }

    public void setEnderecoEmpLogradouro(String enderecoEmpLogradouro) {
        this.enderecoEmpLogradouro = enderecoEmpLogradouro;
    }

    public String getEnderecoEmpNumero() {
        return enderecoEmpNumero;
    }

    public void setEnderecoEmpNumero(String enderecoEmpNumero) {
        this.enderecoEmpNumero = enderecoEmpNumero;
    }

    public String getEnderecoEmpComplemento() {
        return enderecoEmpComplemento;
    }

    public void setEnderecoEmpComplemento(String enderecoEmpComplemento) {
        this.enderecoEmpComplemento = enderecoEmpComplemento;
    }

    public String getEnderecoEmpBairro() {
        return enderecoEmpBairro;
    }

    public void setEnderecoEmpBairro(String enderecoEmpBairro) {
        this.enderecoEmpBairro = enderecoEmpBairro;
    }

    public String getCnaePrimario() {
        return cnaePrimario;
    }

    public void setCnaePrimario(String cnaePrimario) {
        this.cnaePrimario = cnaePrimario;
    }

    public String getCnaesSecundarios() {
        return cnaesSecundarios;
    }

    public void setCnaesSecundarios(String cnaesSecundarios) {
        this.cnaesSecundarios = cnaesSecundarios;
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

    public boolean isTemFiliais() {
        return temFiliais;
    }

    public void setTemFiliais(boolean temFiliais) {
        this.temFiliais = temFiliais;
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
}
