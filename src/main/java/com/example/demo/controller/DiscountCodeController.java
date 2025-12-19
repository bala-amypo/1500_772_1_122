package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/discountcodes")
public class DiscountCodeController {

    private final DiscountCodeService service;

    public DiscountCodeController(DiscountCodeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DiscountCode> create(@RequestBody DiscountCode discountCode) {
        return ResponseEntity.ok(service.create(discountCode));
    }

    @GetMapping
    public ResponseEntity<List<DiscountCode>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountCode> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountCode> update(@PathVariable Long id, @RequestBody DiscountCode discountCode) {
        return ResponseEntity.ok(service.update(id, discountCode));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
