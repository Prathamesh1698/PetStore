package com.itvedant.petstore.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itvedant.petstore.entities.Product;
import com.itvedant.petstore.services.ProductService;
import com.itvedant.petstore.services.UserService;

import jakarta.validation.Valid;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PutMapping("/products/{id}/upload")
    public ResponseEntity<?> upload(@PathVariable Integer id,
            @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(productService.storeFile(id, file));

    }

    @GetMapping("/products/download/{filename}")
    public ResponseEntity<?> download(@PathVariable String filename) {
        Resource resource = this.productService.downloadFile(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + filename + "\"")
                .body(resource);
    }
    // @GetMapping("/products")

    // public ResponseEntity<?> getAllProducts() {
    // return ResponseEntity.ok(productservice.getProducts());
    // }

    // @PostMapping("/products")

    // public ResponseEntity<?> addProduct(@RequestBody @Valid Product p) {
    // return ResponseEntity.status(HttpStatus.CREATED).body(productservice.add(p));
    // }

    // @GetMapping("/products/{id}")
    // public ResponseEntity<?> getProduct(@PathVariable("id") Integer pid) {
    // Product found = productservice.getProductById(pid);
    // if (found == null) {
    // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product with this
    // ID does not exits");
    // } else {
    // return ResponseEntity.ok(found);
    // }
    // }

    // @DeleteMapping("/products/{id}")
    // public ResponseEntity<?> delete(@PathVariable Integer id) {
    // Product found = productservice.getProductById(id);
    // if (found == null) {
    // return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    // .body("Product with this id does not exists");
    // } else {
    // return ResponseEntity.ok(productservice.deleteProduct(id));
    // }
    // }

    // @PutMapping("/products/{id}")
    // public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody
    // Product p) {
    // Product found = productservice.getProductById(id);
    // if (found == null) {
    // return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    // .body("Product with this id does not exists");
    // } else {
    // p.setCreationTime(found.getCreationTime());
    // return ResponseEntity.ok(productservice.updateProduct(id, p));
    // }
    // }
}
