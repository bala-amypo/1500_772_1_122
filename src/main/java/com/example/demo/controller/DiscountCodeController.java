package com.example.demo.controller; // <-- package added

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discountcodes")
@Tag(name = "DiscountCode", description = "APIs related to DiscountCode") // Swagger heading
public class DiscountCodeController {

    @Autowired
    private DiscountCodeService discountCodeService;

    @GetMapping
    public ResponseEntity<List<DiscountCode>> getAllDiscountCodes() {
        return ResponseEntity.ok(discountCodeService.getAllDiscountCodes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountCode> getDiscountCodeById(@PathVariable Long id) {
        DiscountCode code = discountCodeService.getDiscountCodeById(id);
        if (code == null) code = new DiscountCode();
        return ResponseEntity.ok(code);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountCode> updateDiscountCode(@PathVariable Long id, @RequestBody DiscountCode discountCode) {
        DiscountCode updated = discountCodeService.updateDiscountCode(id, discountCode);
        if (updated == null) updated = new DiscountCode();
        return ResponseEntity.ok(updated);
    }
}
