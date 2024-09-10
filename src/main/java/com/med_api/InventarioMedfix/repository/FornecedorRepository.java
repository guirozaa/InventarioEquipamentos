package com.med_api.InventarioMedfix.repository;

import com.med_api.InventarioMedfix.models.Fornecedor;
import com.med_api.InventarioMedfix.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, UUID>, JpaSpecificationExecutor<Fornecedor> {
}
