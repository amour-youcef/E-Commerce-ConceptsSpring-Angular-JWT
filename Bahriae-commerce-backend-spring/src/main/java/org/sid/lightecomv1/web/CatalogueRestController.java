package org.sid.lightecomv1.web;

import org.sid.lightecomv1.TestJson;
import org.sid.lightecomv1.dao.ProductRepository;
import org.sid.lightecomv1.entities.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin("*")
@RestController
public class CatalogueRestController {
    private ProductRepository productRepository;

    public CatalogueRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping(path="/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Product p=productRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName()));
    }
    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception{
       Product p=productRepository.findById(id).get();
       p.setPhotoName(file.getOriginalFilename());
       Files.write(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName()),file.getBytes());
       productRepository.save(p);
    }
    
    @GetMapping(value= {"/HelloWorld"})
    public TestJson getTestJson() {
    	return  new TestJson("BAHRIA", "Mohammed");
    }
    
    @GetMapping(value= {"/getJsons"})
    public List<TestJson> getListTestJson() {
    	List<TestJson> list = new ArrayList();
    	list.add(new TestJson("BAHRIA", "Mohammed"));
    	list.add(new TestJson("Youssouf", "AMOUR"));

    	return list;
    			
    }
    
//    test
//    @RequestMapping(value= {"/"})
//    public String home() {
//    	return"home";
//    }
}
