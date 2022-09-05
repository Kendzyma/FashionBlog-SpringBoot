//package FashionBlog.Service;
//
//import FashionBlog.Dto.ProductDto;
//import FashionBlog.Exception.CategoryException.CategoryNotFoundException;
//import FashionBlog.Exception.ProductException.ProductNotFoundException;
//import FashionBlog.Model.Category;
//import FashionBlog.Model.Product;
//import FashionBlog.Repository.CategoryRepository;
//import FashionBlog.Repository.ProductRepository;
//import FashionBlog.Service.Interface.IProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class ProductService implements IProductService {
//    @Autowired
//  private ProductRepository productRepository;
//    @Autowired
//    private CategoryRepository categoryRepository;
//    @Override
//    public void addProduct(ProductDto productDto) throws CategoryNotFoundException {
//      Category category = categoryRepository.findById(productDto.getCategoryId())
//                .orElseThrow(()-> new CategoryNotFoundException("Category not found"));
//        Product product = new Product();
//        product.setProductName(productDto.getProductName());
//        product.setCategory(category);
//        product.setDescription(productDto.getDescription());
//        product.setPrice(productDto.getPrice());
//        product.setQuantity(productDto.getQuantity());
//        productRepository.save(product);
//    }
//
//    @Override
//    public List<ProductDto> getAllProducts() throws ProductNotFoundException {
//        List<Product> product = productRepository.findAll();
//        if(product.isEmpty()){
//            throw new ProductNotFoundException("Product Not found");
//        }
//        List<ProductDto> productDto = new ArrayList<>();
//        product.forEach((product1 -> {
//            ProductDto productDto1 = new ProductDto();
//            productDto1.setCategoryId(product1.getCategory().getCatId());
//            productDto1.setProductName(product1.getProductName());
//            productDto1.setDescription(product1.getDescription());
//            productDto1.setQuantity(product1.getQuantity());
//            productDto1.setPrice(product1.getPrice());
//        }));
//        return productDto;
//    }
//
//    @Override
//    public ProductDto getProductById(int proId) throws ProductNotFoundException {
//       Product product = productRepository.findById(proId).orElseThrow(()->new ProductNotFoundException("Product not found"));
//       ProductDto productDto = new ProductDto();
//        productDto.setProductName(product.getProductName());
//        productDto.setCategoryId(product.getCategory().getCatId());
//        productDto.setDescription(product.getDescription());
//        productDto.setPrice(product.getPrice());
//        productDto.setQuantity(product.getQuantity());
//       return productDto;
//    }
//
//    @Override
//    public void updateProduct(ProductDto productDto, int proId) throws CategoryNotFoundException, ProductNotFoundException {
//        Category category = categoryRepository.findById(productDto.getCategoryId())
//                .orElseThrow(()->new CategoryNotFoundException("Category not found"));
//        Product product = productRepository.findById(proId).orElseThrow(()-> new ProductNotFoundException("Product not found"));
//        product.setQuantity(productDto.getQuantity());
//        product.setProductName(productDto.getProductName());
//        product.setCategory(category);
//        product.setDescription(productDto.getDescription());
//        product.setPrice(productDto.getPrice());
//        product.setQuantity(productDto.getQuantity());
//        productRepository.save(product);
//    }
//
//    @Override
//    public void deleteProduct(int proId) {
//        productRepository.deleteById(proId);
//    }
//}
