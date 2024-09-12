package com.med_api.InventarioMedfix.mapper;


import com.med_api.InventarioMedfix.dto.FornecedorDTO;
import com.med_api.InventarioMedfix.models.Fornecedor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public class FornecedorMapper {

    // Converte Model para DTO
    public static FornecedorDTO toDTO(Fornecedor fornecedor) {
        if (fornecedor == null) {
            return null;
        }
        return new FornecedorDTO(fornecedor.getId(), fornecedor.getNome());
    }

    // Converte DTO para Model
    public static Fornecedor toModel(FornecedorDTO fornecedorDTO) {
        if (fornecedorDTO == null) {
            return null;
        }
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(fornecedorDTO.getId());
        fornecedor.setNome(fornecedorDTO.getNome());
        return fornecedor;
    }
}

