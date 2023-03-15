//Rota: /viabilidadeMei         Tabela: TB_CADASTRO_MEI
//Opções:   POST - / - armazena objeto ViabilidadeMEIDto como registro na tabela
//          GET - / -   retora a lista com todos os registros da tabela
//          GET - /(id) - retorna o registro correspondente ao id informado
//          PUT - /(id) - atualiza o registro correspondente ao id informado
//          DEL - /(id) - remove o registro correspondente ao id informado

package com.example.appMEI.controllers;

import com.example.appMEI.dtos.ViabilidadeMeiDto;
import com.example.appMEI.models.EmailModel;
import com.example.appMEI.models.ViabilidadeMeiModel;
import com.example.appMEI.repositories.ViabilidadeMeiRepository;
import com.example.appMEI.services.EmailService;
import com.example.appMEI.services.ViabilidadeMeiService;
import jakarta.validation.Valid;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/viabilidadeMei")
public class ViabilidadeMeiController {
    final ViabilidadeMeiService viabilidadeMeiService;
    private final ViabilidadeMeiRepository viabilidadeMeiRepository;

    //Concatena todos os dados do objeto ViabilidadeMeiModel que irão compor o corpo da mensagem de email
    public String FormataTextoMensagemEmail(ViabilidadeMeiModel viabilidadeMeiModelAux){
        String textoEmail = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatadaBR = viabilidadeMeiModelAux.getDataConsulta().format(formatter);

        textoEmail = "DADOS GERADOS NA CONSULTA DE VIABILIDADE MEI\n";
        textoEmail += "\nData Consulta - " + dataFormatadaBR;
        textoEmail += "\nNome - " + viabilidadeMeiModelAux.getNome();
        textoEmail += "\nCPF - " + viabilidadeMeiModelAux.getCpf();
        textoEmail += "\nStatus CPF - " + viabilidadeMeiModelAux.getStatusCpf();
        textoEmail += "\nData Nascimento - " + viabilidadeMeiModelAux.getDataNascimento();
        textoEmail += "\nEmail - " + viabilidadeMeiModelAux.getEmail();
        textoEmail += "\nTelefone 1 - " + viabilidadeMeiModelAux.getTelefone1();
        textoEmail += "\nTelefone 2 - " + viabilidadeMeiModelAux.getTelefone2();

        textoEmail += "\n\nCNAE Primário - " + viabilidadeMeiModelAux.getCnaePrimario();
        textoEmail += "\nOcupação CNAE Primário - " + viabilidadeMeiModelAux.getCnaePrimarioOcupacao();

        textoEmail += "\n\nFuncionário Público Federal - ".concat((viabilidadeMeiModelAux.iseFuncPublico()) ? "SIM" : "NAO");
        textoEmail += "\nSócio de Empresa - ".concat((viabilidadeMeiModelAux.iseSocio()) ? "SIM" : "NAO");
        textoEmail += "\nMEI Ativo - ".concat((viabilidadeMeiModelAux.iseMeiAtivo()) ? "SIM" : "NAO");
        textoEmail += "\nAuxílio Doença - ".concat((viabilidadeMeiModelAux.isTemAuxilioDoenca()) ? "SIM" : "NAO");
        textoEmail += "\nSalário Maternidade - ".concat((viabilidadeMeiModelAux.isTemSalarioMaternidade()) ? "SIM" : "NAO");
        textoEmail += "\nSeguro Desemprego - ".concat((viabilidadeMeiModelAux.isTemSegDesemprego()) ? "SIM" : "NAO");
        textoEmail += "\nBPC LOAS - ".concat((viabilidadeMeiModelAux.isTemBpcLoas()) ? "SIM" : "NAO");
        textoEmail += "\nProuni - ".concat((viabilidadeMeiModelAux.isTemProuni()) ? "SIM" : "NAO");
        textoEmail += "\nFies - ".concat((viabilidadeMeiModelAux.isTemFies()) ? "SIM" : "NAO");
        textoEmail += "\nBolsa Familia - ".concat((viabilidadeMeiModelAux.isTemBolsaFamilia()) ? "SIM" : "NAO");

        String valorMoedaBR;
        valorMoedaBR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(viabilidadeMeiModelAux.getPrevisaoFaturamento());
        textoEmail += "\n\nPrevisão de Faturamento - " + valorMoedaBR;
        valorMoedaBR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(viabilidadeMeiModelAux.getPrevisaoCustos());
        textoEmail += "\nPrevisão de Custos - " + valorMoedaBR;
        textoEmail += "\nNúmero de Funcionários - " + viabilidadeMeiModelAux.getNrFuncionarios();
        textoEmail += "\nPrecisa ter filiais - ".concat((viabilidadeMeiModelAux.isTemFiliais()) ? "SIM" : "NAO");

        textoEmail += "\n\nNúmero Cadastro IPTU - " + viabilidadeMeiModelAux.getNrCadastroIPTU();
        textoEmail += "\nEndereço Empreendimento - " + viabilidadeMeiModelAux.getEnderecoIPTU();
        textoEmail += "\nÁrea Empreendimento - " + viabilidadeMeiModelAux.getAreaEmpreend() + "m2";
        String restricaoPMB = "";
        switch (viabilidadeMeiModelAux.getCodStatusConsultaIPTU()){
            case 1: restricaoPMB = "Imóvel com restrições"; break;
            case 2: restricaoPMB = "Atividade não permitida para o local"; break;
            case 3: restricaoPMB = "Código Imóvel Inválido ou Inexistente"; break;
        }
        textoEmail += "\nStatus Consulta Estabelecer PMB - ".concat((viabilidadeMeiModelAux.isStatusConsultaIPTU()) ? "Apto" : "Inapto - (" + restricaoPMB + ")");

        textoEmail += "\n\nStatus Consulta Viabilidade MEI - ".concat((viabilidadeMeiModelAux.isStatusConsultaMEI()) ? "Apto" : "Inapto");

        return textoEmail;
    }

    @Autowired
    EmailService emailService;

    public ViabilidadeMeiController(ViabilidadeMeiService viabilidadeMeiService, ViabilidadeMeiRepository viabilidadeMeiRepository){
        this.viabilidadeMeiService = viabilidadeMeiService;
        this.viabilidadeMeiRepository = viabilidadeMeiRepository;
    }
    @PostMapping
    public ResponseEntity<Object> saveViabilidadeMei(@RequestBody @Valid ViabilidadeMeiDto viabilidadeMeiDto){

        if(viabilidadeMeiService.existsByCpf(viabilidadeMeiDto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Viabilidade MEI já cadastrada!");
        }

        var viabilidadeMeiModel =  new ViabilidadeMeiModel();
        BeanUtils.copyProperties(viabilidadeMeiDto, viabilidadeMeiModel);
        viabilidadeMeiModel.setDataConsulta(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));

        ResponseEntity<Object> cadastroViabilidadeMeiResponse = ResponseEntity.status(HttpStatus.CREATED).body(viabilidadeMeiService.save(viabilidadeMeiModel));
        if (cadastroViabilidadeMeiResponse.getStatusCode().value()==201) {
            EmailModel emailModel = new EmailModel();
            emailModel.setEmailFrom("cristianofreese@gmail.com");
            emailModel.setEmailTo("cristianofreese@terra.com.br");
            emailModel.setOwnerRef("Pipe2Brains");
            emailModel.setSubject("Notificação de Consulta MEI - " + viabilidadeMeiModel.getCpf() + " - " + viabilidadeMeiModel.getNome());
            String textoViabilidadeEmail = FormataTextoMensagemEmail(viabilidadeMeiModel);
            emailModel.setText(textoViabilidadeEmail);
            emailService.sendEmail(emailModel);
        }
        return cadastroViabilidadeMeiResponse;
    }

    @GetMapping
    public ResponseEntity<List<ViabilidadeMeiModel>> getViabilidadesMei(){
        return ResponseEntity.status(HttpStatus.OK).body(viabilidadeMeiService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getViabilidadeMei(@PathVariable (value = "id") UUID id){

        Optional<ViabilidadeMeiModel> viabilidadeMeiModelOptional = viabilidadeMeiService.findById(id);

        if(!viabilidadeMeiModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta de Viabilidade MEI não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(viabilidadeMeiModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteViabilidadeMei(@PathVariable(value = "id") UUID id){
        Optional<ViabilidadeMeiModel> viabilidadeMeiModelOptional = viabilidadeMeiService.findById(id);

        if(!viabilidadeMeiModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta de Viabilidade MEI não encontrada!");
        }

        viabilidadeMeiService.delete(viabilidadeMeiModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Consulta de Viabilidade MEI removida com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateViabilidadeMei(@PathVariable(value = "id") UUID id,
                                              @RequestBody @Valid ViabilidadeMeiDto viabilidadeMeiDto){

        Optional<ViabilidadeMeiModel> viabilidadeMeiModelOptional = viabilidadeMeiService.findById(id);

        if(!viabilidadeMeiModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta de Viabilidade MEI não encontrada!");
        }

        var viabilidadeMeiModel = viabilidadeMeiModelOptional.get();

        BeanUtils.copyProperties(viabilidadeMeiDto, viabilidadeMeiModel);
        viabilidadeMeiModel.setId(viabilidadeMeiModelOptional.get().getId());
        viabilidadeMeiModel.setDataConsulta(viabilidadeMeiModelOptional.get().getDataConsulta());
        ResponseEntity<Object> viabilidadeMeiResponse = ResponseEntity.status(HttpStatus.OK).body(viabilidadeMeiService.save(viabilidadeMeiModel));
        return viabilidadeMeiResponse;
    }
}