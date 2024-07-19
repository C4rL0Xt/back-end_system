package com.bbraun.documentos.compra.servicecompra.controllers;

import com.bbraun.documentos.compra.servicecompra.models.dto.SolicitudCompraDto;
import com.bbraun.documentos.compra.servicecompra.models.entity.SolicitudCompra;
import com.bbraun.documentos.compra.servicecompra.services.ISolicitudCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitud")
public class SolicitudController {

    @Autowired
    private ISolicitudCompraService solicitudCompraService;

    @GetMapping("/listar")
    public List<SolicitudCompra> listar(){
        return solicitudCompraService.findAll();
    }

    @GetMapping("/lastcode")
    public String getLastCode(){
        return solicitudCompraService.findLastCode();
    }

    @GetMapping("/listarconestado")
    public List<SolicitudCompraDto> listarConEstado(){
        return solicitudCompraService.findSolicitudWithEstado();
    }

    @PostMapping("/guardar")
    public ResponseEntity<SolicitudCompra> guardar(@RequestBody SolicitudCompraDto solicitudCompraDto){
        SolicitudCompra solicitudCompra = solicitudCompraService.save(solicitudCompraDto);
        return ResponseEntity.ok(solicitudCompra);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<SolicitudCompra> actualizar(@RequestBody SolicitudCompraDto dto){
        SolicitudCompra solicitudCompra = solicitudCompraService.updateSolicitudCompra(dto);
        return ResponseEntity.ok(solicitudCompra);

    }

    @GetMapping("/listarpendientes")
    public List<SolicitudCompraDto> listarPendientes(){
        return solicitudCompraService.findSolicitudPendiente();
    }

    @PutMapping("/actualizarestado/{idSolicitud}/{estado}")
    public ResponseEntity<SolicitudCompra> actualizarEstado(@PathVariable String idSolicitud, @PathVariable Integer estado){
        SolicitudCompra solicitudCompra = solicitudCompraService.updateState(idSolicitud, estado);
        return ResponseEntity.ok(solicitudCompra);
    }
}
