package com.med_api.InventarioMedfix.mapper;


import com.med_api.InventarioMedfix.dto.FornecedorDTO;
import com.med_api.InventarioMedfix.models.Fornecedor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FornecedorMapper {
    FornecedorMapper INSTANCE = Mappers.getMapper(FornecedorMapper.class);
    FornecedorDTO fornecedorToDTO(Fornecedor fornecedor);
    Fornecedor DTOtoFornecedor(FornecedorDTO fornecedorDTO);
}
