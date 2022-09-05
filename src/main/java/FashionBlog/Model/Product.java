//package FashionBlog.Model;
//
//import com.sun.istack.NotNull;
//import lombok.*;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int proId;
//    private @NotNull String productName;
//    private @NotNull int quantity;
//    private @NotNull double price;
//    private @NotNull String description;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "catId",nullable = false)
//    private Category category;
//
//}
