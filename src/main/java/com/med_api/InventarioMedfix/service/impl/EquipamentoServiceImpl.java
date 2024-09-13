package com.med_api.InventarioMedfix.service.impl;

import com.med_api.InventarioMedfix.dto.EquipamentoDTO;
import com.med_api.InventarioMedfix.mapper.DepartamentoMapper;
import com.med_api.InventarioMedfix.mapper.EquipamentoMapper;
import com.med_api.InventarioMedfix.mapper.FornecedorMapper;
import com.med_api.InventarioMedfix.mapper.UsuarioMapper;
import com.med_api.InventarioMedfix.models.Departamento;
import com.med_api.InventarioMedfix.models.Equipamento;
import com.med_api.InventarioMedfix.models.Fornecedor;
import com.med_api.InventarioMedfix.models.Usuario;
import com.med_api.InventarioMedfix.repository.DepartamentoRepository;
import com.med_api.InventarioMedfix.repository.EquipamentoRepository;
import com.med_api.InventarioMedfix.repository.FornecedorRepository;
import com.med_api.InventarioMedfix.repository.UsuarioRepository;
import com.med_api.InventarioMedfix.service.EquipamentoService;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EquipamentoServiceImpl implements EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;



    @Override
    public Page<Equipamento> findAll(Specification<Equipamento> spec, Pageable page) {
        return equipamentoRepository.findAll(spec, page);
    }

    @Override
    public EquipamentoDTO save(EquipamentoDTO equipamentoDTO) {
        // Recuperar o Departamento, Fornecedor e Usuario pelos seus IDs
        Departamento departamento = departamentoRepository.findById(equipamentoDTO.getId_departamento())
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Departamento não encontrado"));

        Fornecedor fornecedor = fornecedorRepository.findById(equipamentoDTO.getId_fornecedor())
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Fornecedor não encontrado"));

        Usuario usuario = usuarioRepository.findById(equipamentoDTO.getId_usuario())
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Usuário não encontrado"));


        Equipamento equipamento = EquipamentoMapper.toModel(equipamentoDTO,
                DepartamentoMapper.toDTO(departamento),
                FornecedorMapper.toDTO(fornecedor),
                UsuarioMapper.toDTO(usuario));

        // Salvar o equipamento
        equipamento = equipamentoRepository.save(equipamento);

        // Converter de volta para DTO e retornar
        return EquipamentoMapper.toDTO(equipamento);
    }

    @Override
    public Optional<EquipamentoDTO> findById(UUID id) {
        return equipamentoRepository.findById(id)
                .map(EquipamentoMapper::toDTO);
    }

    @Override
    public Optional<EquipamentoDTO> update(UUID id, EquipamentoDTO equipamentoDTO) {
        // Verifica se o equipamento com o ID fornecido existe
        if (equipamentoRepository.existsById(id)) {

            // Recuperar o Departamento, Fornecedor e Usuario pelos seus IDs
            Departamento departamento = departamentoRepository.findById(equipamentoDTO.getId_departamento())
                    .orElseThrow(() -> new OpenApiResourceNotFoundException("Departamento não encontrado"));

            Fornecedor fornecedor = fornecedorRepository.findById(equipamentoDTO.getId_fornecedor())
                    .orElseThrow(() -> new OpenApiResourceNotFoundException("Fornecedor não encontrado"));

            Usuario usuario = usuarioRepository.findById(equipamentoDTO.getId_usuario())
                    .orElseThrow(() -> new OpenApiResourceNotFoundException("Usuário não encontrado"));

            // Converter o DTO para Model, passando os objetos relacionados
            Equipamento equipamento = EquipamentoMapper.toModel(equipamentoDTO,
                    DepartamentoMapper.toDTO(departamento),
                    FornecedorMapper.toDTO(fornecedor),
                    UsuarioMapper.toDTO(usuario));

            // Setar o ID para garantir que estamos atualizando o equipamento existente
            equipamento.setId(id);

            // Salvar o equipamento atualizado no banco de dados
            equipamentoRepository.save(equipamento);

            // Retornar o DTO do equipamento atualizado
            return Optional.of(EquipamentoMapper.toDTO(equipamento));
        }

        // Retorna vazio caso o equipamento com o ID fornecido não seja encontrado
        return Optional.empty();
    }


    @Override
    public boolean deleteById(UUID id) {
        if (equipamentoRepository.existsById(id)) {
            equipamentoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}