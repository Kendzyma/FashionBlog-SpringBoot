//package FashionBlog.Controller;
//
//
//import FashionBlog.Exception.CategoryException.CategoryExistException;
//import FashionBlog.Exception.CategoryException.CategoryNotFoundException;
//import FashionBlog.Model.Category;
//import FashionBlog.Service.CategoryService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Api(tags = "Category end point")
//@Validated
//@RestController
//@RequestMapping("/api/v1/category")
//public class CategoryController {
//private final CategoryService categoryService;
//
//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }
//
//
//    @ApiOperation(value = "Create new Category",response = ResponseEntity.class)
//    @PostMapping(value = "/",produces = "application/json")
//    public ResponseEntity<String> createCategory(@RequestBody CategoryDto categoryDto) throws CategoryExistException {
//       return new ResponseEntity<>(categoryService.addCategory(categoryDto), HttpStatus.CREATED);
//    }
//
//
//    @ApiOperation(value = "Gets all Categories",response = ResponseEntity.class)
//    @GetMapping(value = "/",produces = "application/json")
//    public ResponseEntity<List<Category>> getAllCategories() throws CategoryNotFoundException {
//       return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.OK);
//    }
//
//
//    @ApiOperation(value = "Gets Category by Id",response = ResponseEntity.class)
//    @GetMapping(value = "{catId}",produces = "application/json")
//    public ResponseEntity<Category> getCategoryById(@PathVariable("catId") int id) throws CategoryNotFoundException {
//       return new ResponseEntity<>(categoryService.getCategoryById(id),HttpStatus.OK);
//    }
//
//
//    @ApiOperation(value = "Delete Category by Id",response = ResponseEntity.class)
//    @DeleteMapping(value = "/{catId}",produces = "application/json")
//    public ResponseEntity<String> deleteCategory(@PathVariable("catId") int id) throws CategoryNotFoundException {
//       return new ResponseEntity<>(categoryService.deleteCategory(id),HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Update category by Id",response = ResponseEntity.class)
//    @PutMapping(value = "/{catId}",produces = "application/json")
//    public ResponseEntity<String> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable("catId") int id) throws CategoryNotFoundException {
//        return new ResponseEntity<>(categoryService.updateCategory(categoryDto,id),HttpStatus.CREATED);
//    }
//
//}
