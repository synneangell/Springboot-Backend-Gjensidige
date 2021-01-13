package com.example.gjensidige.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gjensidige.model.Kunde;
import com.example.gjensidige.repository.KundeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class KundeController {
    @Autowired
    private KundeRepository kundeRepository;

    @GetMapping("/kunder")
    public List<Kunde> getAlleKunder() {
        return kundeRepository.findAll();
    }

    @GetMapping("/kunder/{id}")
    public Kunde getKundeVedId(@PathVariable(value = "id") Long kundeId) {
        return kundeRepository.findById(kundeId).get();
    }

    @PostMapping("/kunder")
    public HttpStatus opprettKunde(@RequestBody Kunde kunde) {
        kundeRepository.save(kunde);
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/kunder/{id}")
    public Map<String, Boolean> slettKunde(@PathVariable(value = "id") Long kundeId) {
        Kunde kunde = kundeRepository.findById(kundeId).get();
        kundeRepository.delete(kunde);
        Map<String, Boolean> response = new HashMap<>();
        response.put("slettet", Boolean.TRUE);
        return response;
    }

    @PutMapping("/kunder/{id}")
    public ResponseEntity<Kunde> oppdaterKunde(@PathVariable(value = "id") Long kundeId,
         @RequestBody Kunde kundeDetaljer){
        Kunde kunde = kundeRepository.findById(kundeId).get();

        kunde.setEmail(kundeDetaljer.getEmail());
        kunde.setEtternavn(kundeDetaljer.getEtternavn());
        kunde.setFornavn(kundeDetaljer.getFornavn());
        final Kunde oppdatertKunde = kundeRepository.save(kunde);
        return ResponseEntity.ok(oppdatertKunde);
    }
}