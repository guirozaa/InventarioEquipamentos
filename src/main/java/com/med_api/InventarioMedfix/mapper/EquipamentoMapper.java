package com.med_api.InventarioMedfix.mapper;

import com.med_api.InventarioMedfix.dto.EquipamentoDTO;
import com.med_api.InventarioMedfix.dto.FornecedorDTO;
import com.med_api.InventarioMedfix.models.Equipamento;
import com.med_api.InventarioMedfix.models.Fornecedor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public class EquipamentoMapper {

    // Converte Model para DTO
    public static EquipamentoDTO toDTO(Equipamento equipamento) {
        if (equipamento == null) {
            return null;
        }
        return new EquipamentoDTO(
                equipamento.getId(),
                equipamento.getNome(),
                equipamento.getDescricao(),
                equipamento.getTipo(),
                equipamento.getMemoria(),
                equipamento.getProcessador(),
                equipamento.getHd(),
                equipamento.getSistemaOperacional(),
                equipamento.getMonitor(),
                equipamento.getObservacoes()
        );
    }

    // Converte DTO para Model
    public static Equipamento toModel(EquipamentoDTO equipamentoDTO) {
        if (equipamentoDTO == null) {
            return null;
        }
        Equipamento equipamento = new Equipamento();
        equipamento.setId(equipamentoDTO.getId());
        equipamento.setNome(equipamentoDTO.getNome());
        equipamento.setDescricao(equipamentoDTO.getDescricao());
        equipamento.setTipo(equipamentoDTO.getTipo());
        equipamento.setMemoria(equipamentoDTO.getMemoria());
        equipamento.setProcessador(equipamentoDTO.getProcessador());
        equipamento.setHd(equipamentoDTO.getHd());
        equipamento.setSistemaOperacional(equipamentoDTO.getSistemaOperacional());
        equipamento.setMonitor(equipamentoDTO.getMonitor());
        equipamento.setObservacoes(equipamentoDTO.getObservacoes());
        return equipamento;
    }
}

