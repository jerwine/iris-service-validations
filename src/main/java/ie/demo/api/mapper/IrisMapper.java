package ie.demo.api.mapper;

import org.mapstruct.Mapper;

import ie.demo.api.model.IrisDTO;
import ie.demo.domain.Iris;

@Mapper(componentModel = "spring")
public interface IrisMapper {

    IrisDTO toIrisDTO(Iris iris);

    Iris toIris(IrisDTO irisDTO);
}