package com.med_api.InventarioMedfix.mapper;

import com.med_api.InventarioMedfix.dto.DepartamentoDTO;
import com.med_api.InventarioMedfix.models.Departamento;
public class DepartamentoMapper {

    // Converte Model para DTO
    public static DepartamentoDTO toDTO(Departamento departamento) {
        if (departamento == null) {
            return null;
        }
        return new DepartamentoDTO(departamento.getId(), departamento.getNome());
    }

    // Converte DTO para Model
    public static Departamento toModel(DepartamentoDTO departamentoDTO) {
        if (departamentoDTO == null) {
            return null;
        }
        Departamento departamento = new Departamento();
        departamento.setId(departamentoDTO.getId());
        departamento.setNome(departamentoDTO.getNome());
        return departamento;
    }
}
