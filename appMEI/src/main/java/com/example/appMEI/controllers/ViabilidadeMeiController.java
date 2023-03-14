package com.example.appMEI.controllers;

import com.example.appMEI.dtos.ViabilidadeMeiDto;
import com.example.appMEI.models.ViabilidadeMeiModel;
import com.example.appMEI.repositories.ViabilidadeMeiRepository;
import com.example.appMEI.services.ViabilidadeMeiService;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/viabilidadeMei")
public class ViabilidadeMeiController {
    final ViabilidadeMeiService viabilidadeMeiService;
    private final ViabilidadeMeiRepository viabilidadeMeiRepository;

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
        viabilidadeMeiModel.setDataConsulta(LocalDateTime.now(ZoneId.of("UCT")));
        return ResponseEntity.status(HttpStatus.CREATED).body(viabilidadeMeiService.save(viabilidadeMeiModel));
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
