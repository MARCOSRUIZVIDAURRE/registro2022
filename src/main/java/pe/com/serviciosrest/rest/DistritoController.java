
package pe.com.serviciosrest.rest;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.serviciosrest.entity.Distrito;
import pe.com.serviciosrest.service.DistritoService;


@RestController
@RequestMapping("/distrito")
public class DistritoController {

    // LISTAR TODOS LOS PRODUCTOS
    @Autowired
    private DistritoService distritoService;

    @GetMapping
    public List<Distrito> findAll() {
        return distritoService.findAll();

    }

    
    @PostMapping
    public Distrito add(@RequestBody Distrito p) {
        return distritoService.add(p);
    }

    // BUSCAR PRODUCTO POR ID
    @GetMapping("/{id}")
    public Optional<Distrito> findById(@PathVariable long id) {
        return distritoService.findById(id);
    }

    // ACTUALIZAR PRODUCTO
    @PutMapping("/{id}")
    public Distrito update(@PathVariable long id, @RequestBody Distrito d) {
        d.setCodigo(id);
        return distritoService.update(d);
    }
    @DeleteMapping("/{id}")
    public Distrito delete(@PathVariable long id) {
        Distrito objcategoria = new Distrito();
        objcategoria.setCodigo(id);
        return distritoService.delete(Distrito.builder().codigo(id).build());
    }

}
