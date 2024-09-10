package com.med_api.InventarioMedfix.mapper;

import com.med_api.InventarioMedfix.dto.DepartamentoDTO;
import com.med_api.InventarioMedfix.models.Departamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartamentoMapper {
    //DepartamentoMapper INSTANCE = Mappers.getMapper(DepartamentoMapper.class);
//    DepartamentoDTO departamentoToDTO(Departamento departamento);
//    Departamento DTOtoDepartamento(DepartamentoDTO departamentoDTO);
DepartamentoMapper INSTANCE = Mappers.getMapper(DepartamentoMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")  // Certifique-se de mapear o campo nome corretamente
    DepartamentoDTO departamentoToDTO(Departamento departamento);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")  // Certifique-se de mapear o campo nome corretamente
    Departamento DTOtoDepartamento(DepartamentoDTO departamentoDTO);
}
