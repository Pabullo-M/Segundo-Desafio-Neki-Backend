package br.com.Neki_it.CartoesVirtuais.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.Neki_it.CartoesVirtuais.dto.PerfilCadastroDto;
import br.com.Neki_it.CartoesVirtuais.model.PerfilModel;

@Mapper(componentModel = "spring")
public interface PerfilMapper {
	
	PerfilMapper INSTANCE = Mappers.getMapper( PerfilMapper.class );

	PerfilModel PerfilCadastroDtoToPerfilModel(PerfilCadastroDto perfilCadastroDto);
}
