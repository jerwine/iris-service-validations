package ie.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ie.demo.api.mapper.IrisMapper;
import ie.demo.api.model.IrisDTO;
import ie.demo.domain.IrisRepository;
import ie.demo.service.IrisService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IrisServiceImpl implements IrisService {

    final IrisMapper irisMapper;
    final IrisRepository irisRepository;

    /*
     * @see ie.demo.service.IrisService#getIrisById(java.lang.Long)
     */
    @Override
    public Optional<IrisDTO> getIrisById( Long id ) {
        return irisRepository.findById( id ).map( irisMapper :: toIrisDTO );
    }

    /*
     * @see ie.demo.service.IrisService#getAllIris(org.springframework.data.domain.Pageable)
     */
    @Override
    public Page<IrisDTO> getAllIris( Pageable pageable ) {
        return irisRepository.findAll( pageable ).map( irisMapper :: toIrisDTO );
    }

    /*
     * @see ie.demo.service.IrisService#getAllSpecies()
     */
    @Override
    public List<IrisDTO> getAllSpecies() {
        return irisRepository.findDistinctSpecies().stream()
            .map( species -> IrisDTO.builder().species(species).build() )
            .collect( Collectors.toList() );
    }

    /*
     * @see ie.demo.service.IrisService#getIrisBySpecies(java.lang.String, org.springframework.data.domain.Pageable)
     */
    @Override
    public Page<IrisDTO> getIrisBySpecies( String species, Pageable pageable ) {
        return irisRepository.findBySpecies( species, pageable ).map( irisMapper :: toIrisDTO );
    }

    /*
     * @see ie.demo.service.IrisService#saveIrises(java.util.List)
     */
    @Override
    public List<IrisDTO> saveIrises( List<IrisDTO> irises ) {
        return irisRepository.saveAll(
                irises.stream()
                .map( irisMapper :: toIris )
                .collect( Collectors.toList() ) )
                    .stream()
                    .map( irisMapper :: toIrisDTO )
                    .collect( Collectors.toList() );
    }

    /*
     * @see ie.demo.service.IrisService#deleteIris(java.lang.Long)
     */
    @Override
    public Optional<Void> deleteIris( Long id ) {
        irisRepository.deleteById( id );
        return Optional.empty();
    }
}
