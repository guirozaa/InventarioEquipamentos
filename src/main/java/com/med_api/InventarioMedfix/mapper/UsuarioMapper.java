package com.med_api.InventarioMedfix.mapper;

import com.med_api.InventarioMedfix.dto.FornecedorDTO;
import com.med_api.InventarioMedfix.dto.UsuarioDTO;
import com.med_api.InventarioMedfix.models.Fornecedor;
import com.med_api.InventarioMedfix.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    UsuarioDTO usuarioToDTO(Usuario usuario);
    Usuario DTOtoUsuario(UsuarioDTO usuarioDTO);
}
