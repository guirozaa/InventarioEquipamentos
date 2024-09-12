package com.med_api.InventarioMedfix.service.impl;

import com.med_api.InventarioMedfix.dto.UsuarioDTO;
import com.med_api.InventarioMedfix.mapper.UsuarioMapper;
import com.med_api.InventarioMedfix.models.Usuario;
import com.med_api.InventarioMedfix.repository.UsuarioRepository;
import com.med_api.InventarioMedfix.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Page<Usuario> findAll(Specification<Usuario> spec, Pageable page) {
        return usuarioRepository.findAll(spec, page);
    }

    @Override
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.toModel(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return UsuarioMapper.toDTO(usuario);
    }

    @Override
    public Optional<UsuarioDTO> findById(UUID id) {
        return usuarioRepository.findById(id)
                .map(UsuarioMapper::toDTO);
    }

    @Override
    public Optional<UsuarioDTO> update(UUID id, UsuarioDTO usuarioDTO) {
        if (usuarioRepository.existsById(id)) {
            Usuario usuario = UsuarioMapper.toModel(usuarioDTO);
            usuario.setId(id);
            usuarioRepository.save(usuario);
            return Optional.of(UsuarioMapper.toDTO(usuario));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
