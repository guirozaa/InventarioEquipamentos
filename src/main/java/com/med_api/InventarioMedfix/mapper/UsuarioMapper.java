package com.med_api.InventarioMedfix.mapper;

import com.med_api.InventarioMedfix.dto.FornecedorDTO;
import com.med_api.InventarioMedfix.dto.UsuarioDTO;
import com.med_api.InventarioMedfix.models.Fornecedor;
import com.med_api.InventarioMedfix.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public class UsuarioMapper {

    // Converte Model para DTO
    public static UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        return new UsuarioDTO(usuario.getId(), usuario.getNome());
    }

    // Converte DTO para Model
    public static Usuario toModel(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNome(usuarioDTO.getNome());
        return usuario;
    }
}


