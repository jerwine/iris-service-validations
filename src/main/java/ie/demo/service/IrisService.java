package ie.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ie.demo.api.model.IrisDTO;

public interface IrisService {

	/**
	 * Retrieve an Iris by id
	 * @param id
	 * @return
	 */
	Optional<IrisDTO> getIrisById( Long id );

	/**
	 * Retrieve all irises with pageable parameters
	 * @param pageable
	 * @return
	 */
	Page<IrisDTO> getAllIris( Pageable pageable );

	/**
	 * Retrieve all distinct species
	 * @return
	 */
	List<IrisDTO> getAllSpecies();

	/**
	 * Retrieve all irises for the species with pageable parameters
	 * @param species
	 * @param pageable
	 * @return
	 */
	Page<IrisDTO> getIrisBySpecies( String species, Pageable pageable );

	/**
	 * Persist irises
	 * @param irises
	 * @return
	 */
	List<IrisDTO> saveIrises( List<IrisDTO> irises );

	/**
	 * Delete an iris by id
	 * @param id
	 * @return
	 */
	Optional<Void> deleteIris( Long id );
}