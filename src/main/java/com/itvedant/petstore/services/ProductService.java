package com.itvedant.petstore.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itvedant.petstore.FileStorageProperties;
import com.itvedant.petstore.entities.Product;
import com.itvedant.petstore.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    private final Path rootLocation;

    public ProductService(FileStorageProperties properties) {
        this.rootLocation = Paths.get(properties.getUploadDir());

        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Could create the directory to upload and download");
        }
    }

    public String storeFile(Integer id, MultipartFile file) {
        // 1. File is coming in the request which we need
        // to add in the uploads
        Path destinationFile = this.rootLocation.resolve(Paths.get(file.getOriginalFilename()));

        try {
            InputStream inputStream = file.getInputStream();
            Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Could not save the file");
        }

        // 2. Create the URL that will be used to download
        // the file and we will be updating for all the products

        // "http://localhost:8080" to get this part of the url =>
        // ServletUriComponentsBuilder.fromCurrentContextPath()
        String uploadedFileUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/products/download/")
                .path(file.getOriginalFilename())
                .toUriString();

        Product product = this.repository.findById(id).get();
        product.setId(id);
        product.setImageUrl(uploadedFileUrl);
        this.repository.save(product);
        return "File Uploaded Successfully";
    }

    public Resource downloadFile(String filename){
        Path file = rootLocation.resolve(filename);

        try{
            Resource resource = new UrlResource(file.toUri());

            return resource;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                                              "Could not download the file");
        }
    }

    // // private Map<Integer, Product> productMap = new HashMap<>();
    // // private AtomicInteger atomic = new AtomicInteger();

    // // public ProductService() {
    // // Product product1 = new Product();
    // // product1.setId(atomic.incrementAndGet());
    // // product1.setName("Dog-shoes - Blue");
    // // product1.setPrice(500.35);
    // // product1.setDescription("Beutifull");
    // // productMap.put(product1.getId(), product1);

    // // Product product2 = new Product();
    // // product2.setId(atomic.incrementAndGet());
    // // product2.setName("Dog-Harness");
    // // product2.setPrice(750.35);
    // // product2.setDescription("Strong Harness");
    // // productMap.put(product2.getId(), product2);

    // // Product product3 = new Product();
    // // product3.setId(atomic.incrementAndGet());
    // // product3.setName("German shefard");
    // // product3.setPrice(460.76);
    // // product3.setDescription("Strong and rude");
    // // productMap.put(product3.getId(), product3);
    // // }

    // public Iterable<Product> getProducts() {
    // return prod.findAll();
    // }

    // public Product add(Product p) {
    // // p.setId(atomic.incrementAndGet());
    // // productMap.put(p.getId(), p);
    // // return ("Product object added successfully.");
    // return prod.save(p);
    // }

    // public Product getProductById(Integer id) {
    // return prod.findById(id).orElse(null);
    // }

    // public String deleteProduct(Integer id) {
    // prod.deleteById(id);
    // return "Product Object Deleted Successfully";
    // }

    // public Product updateProduct(Integer id, Product p) {
    // p.setId(id);
    // return prod.save(p);
    // }
}
