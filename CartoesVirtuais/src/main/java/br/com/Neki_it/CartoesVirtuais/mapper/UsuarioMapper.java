package br.com.Neki_it.CartoesVirtuais.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.Neki_it.CartoesVirtuais.dto.UsuarioCadastroDto;
import br.com.Neki_it.CartoesVirtuais.model.UsuarioModel;
import br.com.Neki_it.CartoesVirtuais.model.input.UsuarioCadastroInput;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	
	UsuarioMapper INSTANCE = Mappers.getMapper( UsuarioMapper.class );
	
	UsuarioModel UsuarioCadastroInputToUsuarioModel(UsuarioCadastroDto usuarioCadastroDto);
}
