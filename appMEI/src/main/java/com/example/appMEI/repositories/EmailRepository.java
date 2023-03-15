//Repositório EmailRepository
package com.example.appMEI.repositories;


import com.example.appMEI.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {
}
