//package FashionBlog.Controller;
//
//import FashionBlog.Dto.APIResponse;
//import FashionBlog.Exception.CategoryException.CategoryNotFoundException;
//import FashionBlog.Exception.ProductException.ProductNotFoundException;
//import FashionBlog.Service.Interface.IProductService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//@Validated
//@RestController
//@RequestMapping("/api/v1/products")
//public class ProductController {
//    private final IProductService productService;
//
//    public ProductController(IProductService productService) {
//        this.productService = productService;
//    }
//
//    @PostMapping("/")
//    public ResponseEntity<APIResponse> createProduct(@RequestBody ProductDto productDto) throws CategoryNotFoundException {
//        productService.addProduct(productDto);
//        return new ResponseEntity<>(new APIResponse("Success",true),HttpStatus.CREATED);
//    }
//
//    @GetMapping("/")
//    public ResponseEntity<List<ProductDto>> getAllProduct() throws ProductNotFoundException {
//        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
//    }
//    @GetMapping("/{proId}")
//    public ResponseEntity<ProductDto> getProduct(@PathVariable("proId") int proId) throws ProductNotFoundException {
//       return new ResponseEntity<>(productService.getProductById(proId),HttpStatus.OK);
//    }
//    @PutMapping("/{proId}")
//    public ResponseEntity<APIResponse> updateProduct(@RequestBody ProductDto productDto,@PathVariable int proId) throws CategoryNotFoundException, ProductNotFoundException {
//        productService.updateProduct(productDto,proId);
//        return new ResponseEntity<>(new APIResponse("Update Successfully",true),HttpStatus.OK);
//    }
//    @DeleteMapping("/{proId}")
//    public ResponseEntity<APIResponse> deleteProduct(@PathVariable int proId){
//        productService.deleteProduct(proId);
//        return new ResponseEntity<>(new APIResponse("Product deleted successfully",true),HttpStatus.OK);
//    }
//
//}
