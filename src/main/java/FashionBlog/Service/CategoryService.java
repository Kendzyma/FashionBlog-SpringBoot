//package FashionBlog.Service;
//
//import FashionBlog.Dto.CategoryDto;
//import FashionBlog.Exception.CategoryException.CategoryExistException;
//import FashionBlog.Exception.CategoryException.CategoryNotFoundException;
//import FashionBlog.Model.Category;
//import FashionBlog.Repository.CategoryRepository;
//import FashionBlog.Service.Interface.ICategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CategoryService implements ICategoryService {
//    private final CategoryRepository categoryRepository;
//
//    public CategoryService(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//    }
//
//    @Override
//    public String addCategory(CategoryDto categoryDto) throws CategoryExistException {
//      Optional<Category> categoryRepository1 = categoryRepository.findCategoriesByTitle(categoryDto.getTitle());
//      if(categoryRepository1.isPresent()){
//          throw new CategoryExistException(categoryDto.getTitle());
//      }
//      Category category = new Category(categoryDto.getTitle(),categoryDto.getDescription(),categoryDto.getImageUrl());
//      categoryRepository.save(category);
//      return "Category saved successfully";
//    }
//
//    public List<Category> getAllCategory() throws CategoryNotFoundException {
//       List<Category> allCategories = categoryRepository.findAll();
//       if(allCategories.isEmpty()){
//           throw new CategoryNotFoundException("No category was found");
//       }
//       return allCategories;
//    }
//
//    @Override
//    public Category getCategoryById(int id) throws CategoryNotFoundException {
//        return categoryRepository.findById(id)
//                .orElseThrow(()->new CategoryNotFoundException("Category not found"));
//    }
//
//    @Override
//    public String deleteCategory(int id) throws CategoryNotFoundException {
//        Category tmpCategory = categoryRepository.findById(id)
//                .orElseThrow(()->new CategoryNotFoundException("Category not found"));
//        categoryRepository.deleteById(id);
//        return "Category deleted successfully";
//    }
//
//    @Override
//    public String updateCategory(CategoryDto categoryDto, int id) throws CategoryNotFoundException {
//        Category tmpCategory = categoryRepository.findById(id)
//                .orElseThrow(()->new CategoryNotFoundException("Category not found"));
//
//        tmpCategory.setTitle(categoryDto.getTitle());
//        tmpCategory.setDescription(categoryDto.getDescription());
//        tmpCategory.setImageUrl(categoryDto.getImageUrl());
//        categoryRepository.save(tmpCategory);
//
//        return "Category updated successfully";
//    }
//}
