package ie.demo.domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IrisRepository extends JpaRepository<Iris, Long> {
    Page<Iris> findBySpecies( String species, Pageable pageable );

    @Query( "SELECT DISTINCT i.species FROM Iris i" )
    List<String> findDistinctSpecies();
}