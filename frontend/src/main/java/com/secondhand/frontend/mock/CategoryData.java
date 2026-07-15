package com.secondhand.frontend.mock;

import com.secondhand.frontend.model.Category;
import com.secondhand.frontend.model.Subcategory;

import java.util.List;

public class CategoryData {

    public static List<Category> getCategories() {

        return List.of(

                new Category(
                        "Real Estate",
                        List.of(
                                new Subcategory("For Sale"),
                                new Subcategory("For Rent"),
                                new Subcategory("Short-term Rental")
                        )
                ),

                new Category(
                        "Vehicles",
                        List.of(
                                new Subcategory("Cars"),
                                new Subcategory("Motorcycles"),
                                new Subcategory("Bicycles"),
                                new Subcategory("Heavy Vehicles")
                        )
                ),

                new Category(
                        "Digital Goods",
                        List.of(
                                new Subcategory("Mobile Phones & Tablets"),
                                new Subcategory("Laptops & Computers"),
                                new Subcategory("Audio & Video"),
                                new Subcategory("Accessories")
                        )
                ),

                new Category(
                        "Home & Kitchen",
                        List.of(
                                new Subcategory("Home Appliances"),
                                new Subcategory("Furniture"),
                                new Subcategory("Kitchen Appliances & Cookware"),
                                new Subcategory("Home Decoration")
                        )
                ),

                new Category(
                        "Personal Items",
                        List.of(
                                new Subcategory("Clothing"),
                                new Subcategory("Shoes & Bags"),
                                new Subcategory("Watches"),
                                new Subcategory("Accessories & Jewelry"),
                                new Subcategory("Beauty & Health"),
                                new Subcategory("Baby & Kids")
                        )
                ),

                new Category(
                        "Sports & Entertainment",
                        List.of(
                                new Subcategory("Sports Equipment"),
                                new Subcategory("Musical Instruments"),
                                new Subcategory("Books"),
                                new Subcategory("Video Games"),
                                new Subcategory("Toys & Games")
                        )
                ),

                new Category(
                        "Industrial Equipment",
                        List.of(
                                new Subcategory("Construction Materials & Equipment"),
                                new Subcategory("Tools")
                        )
                ),

                new Category(
                        "Pets",
                        List.of(
                                new Subcategory("Dogs"),
                                new Subcategory("Cats"),
                                new Subcategory("Birds"),
                                new Subcategory("Aquatic Animals"),
                                new Subcategory("Rodents & Small Pets"),
                                new Subcategory("Pet Food & Accessories")
                        )
                )

        );

    }

}