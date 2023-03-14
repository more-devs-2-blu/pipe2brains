package com.example.appMEI.repositories;

import com.example.appMEI.models.ViabilidadeMeiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ViabilidadeMeiRepository extends JpaRepository<ViabilidadeMeiModel, UUID> {
    boolean existsByCpf(String cpf);
}


