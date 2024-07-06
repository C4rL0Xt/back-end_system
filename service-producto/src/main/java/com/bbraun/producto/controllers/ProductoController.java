package com.bbraun.producto.controllers;



import com.bbraun.producto.exception.InvalidDataException;
import com.bbraun.producto.exception.ResourceNotFoundException;
import com.bbraun.producto.models.dto.ProductoDTO;
import com.bbraun.producto.models.dto.ProductoPresentationDto;
import com.bbraun.producto.models.entity.Categoria;
import com.bbraun.producto.models.entity.FormaFarmaceutica;
import com.bbraun.producto.models.entity.Lote;
import com.bbraun.producto.models.entity.Producto;
import com.bbraun.producto.service.ICategoriaService;
import com.bbraun.producto.service.IFormaFarmaceuticaService;
import com.bbraun.producto.service.ILoteService;
import com.bbraun.producto.service.IProductoService;
import com.bbraun.producto.util.LoteConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private ILoteService loteService;

    @Autowired
    private ICategoriaService categoriaService;
    @Autowired
    private IFormaFarmaceuticaService formaFarmaceuticaService;

    @Autowired
    private LoteConverter loteConverter;

    @GetMapping("/")
    public String hello(){
        return "Hola";
    }
    @GetMapping("/listar")
    public List<Producto> listarProductos(){
        return (List<Producto>) productoService.findAll();
    }

    @GetMapping("/buscar-categoria/{idcategoria}")
    public List<Producto> listarProductosPorCategoria(@PathVariable("idcategoria") String idcategoria){
        Categoria categoria = new Categoria();
        categoria.setId_categoria(idcategoria);
        return productoService.findByIdCategoria(categoria);
    }

    @GetMapping("/buscar-id/{idproducto}")
    public Producto verProductoPorId(@PathVariable("idproducto") String idproducto){
        return productoService.findById(idproducto);
    }

    @GetMapping("/buscar-nombre/{nombreproducto}")
    public List<Producto> verProductoPorNombre(@PathVariable("nombreproducto") String nombreproducto){
        return (List<Producto>)productoService.findByNombre(nombreproducto);
    }

    @GetMapping("/ver-lotes-dis/{idproducto}")
    public ProductoDTO getLotesDisponiblesPorLote(@PathVariable("idproducto") String idproducto){

        return  productoService.findLotesDisponibles(idproducto);
    }
    @GetMapping("/buscar-producto")
    public ProductoPresentationDto findProductoByNombreAndConcentracion(
            @RequestParam("nombre") String nombre,
            @RequestParam("concentracion") String concentracion) {
        return productoService.findByNombreAndAndConcentracion(nombre, concentracion);
    }

    @GetMapping("/pro-lot")
    public List<ProductoPresentationDto> getProductWithLots(){
        return productoService.findAllWithLots();
    }


    @GetMapping("/last-code")
    public String getLastCodeProducto(){
        return productoService.getLastCodeProducto();
    }

    @GetMapping("/buscar-producto/{id}")
    public ProductoPresentationDto findProductoWithLots(@PathVariable("id") String id){
        return productoService.findProductoWithLots(id);
    }


    @PostMapping("/guardar-p")
    public ResponseEntity<Producto> createProductoWithLots(@RequestBody ProductoPresentationDto dto){
        try{
            Producto producto = productoService.createProductoWithLots(dto);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/buscar-id/{idproducto}")
                    .buildAndExpand(producto.getIdProducto())
                    .toUri();
            return ResponseEntity.created(location).body(producto);
        }catch (ResourceNotFoundException e){
            return ResponseEntity.notFound().build();
        }catch (InvalidDataException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/actualizar-p")
    public ResponseEntity<Producto> updateProductoWithLots(@RequestBody ProductoPresentationDto dto){
        try{
            Producto producto = productoService.updateProductoWithLots(dto);
            return ResponseEntity.ok(producto);
        }catch (ResourceNotFoundException e){
            return ResponseEntity.notFound().build();
        }catch (InvalidDataException e){
            return ResponseEntity.badRequest().build();
        }
    }





}
