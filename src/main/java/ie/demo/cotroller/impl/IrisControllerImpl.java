package ie.demo.cotroller.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ie.demo.api.model.IrisDTO;
import ie.demo.cotroller.IrisController;
import ie.demo.service.IrisService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/irises")
@CrossOrigin
@RequiredArgsConstructor
public class IrisControllerImpl implements IrisController {

    final IrisService irisService;

    /*
     * @see ie.demo.cotroller.IrisController#getAllIrises(int, int)
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Page<IrisDTO> getAllIrises(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size ) {
        return irisService.getAllIris( PageRequest.of( page, size ) );
    }

    /*
     * @see ie.demo.cotroller.IrisController#getIris(java.lang.Long)
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public IrisDTO getIris( @PathVariable Long id ) {
        return irisService.getIrisById( id ).get();
    }

    /*
     * @see ie.demo.cotroller.IrisController#getAllSpecies()
     */
    @GetMapping("/species")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<IrisDTO> getAllSpecies() {
        return irisService.getAllSpecies();
    }

    @GetMapping("/species/{species}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Page<IrisDTO> getIrisesBySpecies( @PathVariable String species,
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size ) {
        return irisService.getIrisBySpecies( species, PageRequest.of( page, size ) );
    }

    /*
     * @see ie.demo.cotroller.IrisController#saveIris(ie.demo.api.model.IrisDTO)
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public List<IrisDTO> saveIris( @Valid @RequestBody IrisDTO iris ) {
        return irisService.saveIrises(  List.of(iris) );
    }

    /*
     * @see ie.demo.cotroller.IrisController#deleteIris(java.lang.Long)
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Optional<Void> deleteIris( @PathVariable Long id ) {
        return irisService.deleteIris( id );
    }
}