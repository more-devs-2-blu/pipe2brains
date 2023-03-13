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
    private String telefoneFixo;
    private String telefoneMovel;
    private String enderecoEmpresa;
    private String cnaePrimario;

    private boolean eFuncPublico;
    private boolean eSocio;
    private boolean eMeiAtivo;
    private boolean pretendeAbrirFiliais;
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

    public cadastroMei(){}

    public cadastroMei(UUID id, String nome, String cpf, String dataNascimento, String email, String telefoneFixo, String telefoneMovel, String enderecoEmpresa, String cnaePrimario, boolean eFuncPublico, boolean eSocio, boolean eMeiAtivo, boolean pretendeAbrirFiliais, boolean temAposentadoriaInvalidez, boolean temAuxilioDoenca, boolean temSalarioMaternidade, boolean temSegDesemprego, boolean temBpcLoas, boolean temProuni, boolean temFies, boolean temBolsaFamilia, long previsaoFaturamento, long previsaoCustos, int nrFuncionarios) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefoneFixo = telefoneFixo;
        this.telefoneMovel = telefoneMovel;
        this.enderecoEmpresa = enderecoEmpresa;
        this.cnaePrimario = cnaePrimario;
        this.eFuncPublico = eFuncPublico;
        this.eSocio = eSocio;
        this.eMeiAtivo = eMeiAtivo;
        this.pretendeAbrirFiliais = pretendeAbrirFiliais;
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

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneMovel() {
        return telefoneMovel;
    }

    public void setTelefoneMovel(String telefoneMovel) {
        this.telefoneMovel = telefoneMovel;
    }

    public String getEnderecoEmpresa() {
        return enderecoEmpresa;
    }

    public void setEnderecoEmpresa(String enderecoEmpresa) {
        this.enderecoEmpresa = enderecoEmpresa;
    }

    public String getCnaePrimario() {
        return cnaePrimario;
    }

    public void setCnaePrimario(String cnaePrimario) {
        this.cnaePrimario = cnaePrimario;
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

    public boolean isPretendeAbrirFiliais() {
        return pretendeAbrirFiliais;
    }

    public void setPretendeAbrirFiliais(boolean pretendeAbrirFiliais) {
        this.pretendeAbrirFiliais = pretendeAbrirFiliais;
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
