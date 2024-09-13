package com.med_api.InventarioMedfix.mapper;


import com.med_api.InventarioMedfix.dto.DepartamentoDTO;
import com.med_api.InventarioMedfix.dto.EquipamentoDTO;
import com.med_api.InventarioMedfix.dto.FornecedorDTO;
import com.med_api.InventarioMedfix.dto.UsuarioDTO;
import com.med_api.InventarioMedfix.models.Departamento;
import com.med_api.InventarioMedfix.models.Equipamento;
import com.med_api.InventarioMedfix.models.Fornecedor;
import com.med_api.InventarioMedfix.models.Usuario;


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
                equipamento.getObservacoes(),
                equipamento.getDepartamento().getId(),
                equipamento.getFornecedor().getId(),
                equipamento.getUsuario().getId()
        );
    }

    // Converte DTO para Model
    public static Equipamento toModel(EquipamentoDTO equipamentoDTO, DepartamentoDTO departamentoDTO, FornecedorDTO fornecedorDTO, UsuarioDTO usuarioDTO) {
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

        // Converter UsuarioDTO para Usuario
        equipamento.setUsuario(toUsuarioModel(usuarioDTO));

        //Converter DepartamentoDTO para Departamento
        equipamento.setDepartamento(toDepartamentoModel(departamentoDTO));

        //Converter Fornecedor DTO para Fornecedor
        equipamento.setFornecedor(toFornecedorModel(fornecedorDTO));

        return equipamento;
    }

    // Converte UsuarioDTO para Usuario
    private static Usuario toUsuarioModel(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNome(usuarioDTO.getNome());
        return usuario;
    }

    // Converte DepartamentoDTO para Departamento
    private static Departamento toDepartamentoModel(DepartamentoDTO departamentoDTO) {
        if (departamentoDTO == null) {
            return null;
        }
        Departamento departamento = new Departamento();
        departamento.setId(departamentoDTO.getId());
        departamento.setNome(departamentoDTO.getNome());
        return departamento;
    }

    // Converte FornecedorDTO para Fornecedor
    private static Fornecedor toFornecedorModel(FornecedorDTO fornecedorDTO) {
        if (fornecedorDTO == null) {
            return null;
        }
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(fornecedorDTO.getId());
        fornecedor.setNome(fornecedorDTO.getNome());
        return fornecedor;
    }


}


