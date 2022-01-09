package ie.demo.cotroller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import ie.demo.api.model.IrisDTO;

public interface IrisController {

    /**
     * Get all irises
     * @param page
     * @param size
     * @return
     */
    public Page<IrisDTO> getAllIrises( int page, int size );

    /**
     * Get an iris by id
     * @param id
     * @return
     */
    public IrisDTO getIris( Long id );

    /**
     * Get all distinct species
     * @return
     */
    public List<IrisDTO> getAllSpecies();

    /**
     * Get irises by species
     * @param species
     * @param page
     * @param size
     * @return
     */
    public Page<IrisDTO> getIrisesBySpecies( String species, int page, int size );

    /**
     * Save an iris
     * @param iris
     * @return
     */
    public List<IrisDTO> saveIris( IrisDTO iris );

    /**
     * Delete an Iris by id
     * @param id
     * @return
     */
    public Optional<Void> deleteIris( Long id);
}