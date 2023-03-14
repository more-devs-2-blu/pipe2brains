package com.example.appMEI.services;

import com.example.appMEI.models.ViabilidadeMeiModel;
import com.example.appMEI.repositories.ViabilidadeMeiRepository;
import jakarta.transaction.Transactional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ViabilidadeMeiService {
    final ViabilidadeMeiRepository viabilidadeMeiRepository;

    public ViabilidadeMeiService(ViabilidadeMeiRepository viabilidadeMeiRepository) {
        this.viabilidadeMeiRepository = viabilidadeMeiRepository;
    }

    @Transactional
    public ViabilidadeMeiModel save(ViabilidadeMeiModel viabilidadeMeiModel) {
        return viabilidadeMeiRepository.save(viabilidadeMeiModel);
    }

    public boolean existsByCpf(String cpf) {
        return viabilidadeMeiRepository.existsByCpf(cpf);
    }

    public List<ViabilidadeMeiModel> findAll() {
        return viabilidadeMeiRepository.findAll();
    }

    public Optional<ViabilidadeMeiModel> findById(UUID id) {
        return viabilidadeMeiRepository.findById(id);
    }

    @Transactional
    public void delete(ViabilidadeMeiModel viabilidadeMeiModel) {
        viabilidadeMeiRepository.delete(viabilidadeMeiModel);
    }
}
