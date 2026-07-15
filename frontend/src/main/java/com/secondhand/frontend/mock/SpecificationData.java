package com.secondhand.frontend.mock;

import com.secondhand.frontend.model.AttributeType;
import com.secondhand.frontend.model.SpecificationField;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecificationData {

    private static final Map<String, List<SpecificationField>> DATA = new HashMap<>();

    static {

        //------------------------
        // Real Estate
        //------------------------

        DATA.put("For Sale", List.of(
                new SpecificationField("Area", AttributeType.NUMBER),
                new SpecificationField("Rooms", AttributeType.NUMBER),
                new SpecificationField("Floor", AttributeType.NUMBER),
                new SpecificationField(
                        "Parking",
                        AttributeType.DROPDOWN,
                        List.of("Yes", "No")
                ),
                new SpecificationField(
                        "Elevator",
                        AttributeType.DROPDOWN,
                        List.of("Yes", "No")
                )
        ));

        DATA.put("For Rent", List.of(
                new SpecificationField("Area", AttributeType.NUMBER),
                new SpecificationField("Rooms", AttributeType.NUMBER),
                new SpecificationField("Floor", AttributeType.NUMBER),
                new SpecificationField(
                        "Parking",
                        AttributeType.DROPDOWN,
                        List.of("Yes", "No")
                ),
                new SpecificationField(
                        "Elevator",
                        AttributeType.DROPDOWN,
                        List.of("Yes", "No")
                ),
                new SpecificationField("Deposit", AttributeType.NUMBER),
                new SpecificationField("Monthly Rent", AttributeType.NUMBER)
        ));

        DATA.put("Short-term Rental", List.of(
                new SpecificationField("Area", AttributeType.NUMBER),
                new SpecificationField("Rooms", AttributeType.NUMBER),
                new SpecificationField("Price Per Night", AttributeType.NUMBER),
                new SpecificationField("Facilities", AttributeType.TEXT)
        ));

        //------------------------
        // Vehicles
        //------------------------

        DATA.put("Cars", List.of(
                new SpecificationField("Brand", AttributeType.TEXT),
                new SpecificationField("Model", AttributeType.TEXT),
                new SpecificationField("Year", AttributeType.NUMBER),
                new SpecificationField("Mileage", AttributeType.NUMBER),
                new SpecificationField(
                        "Transmission",
                        AttributeType.DROPDOWN,
                        List.of("Manual", "Automatic")
                ),
                new SpecificationField("Body Color", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("Excellent", "Good", "Needs Repair")
                )
        ));

        DATA.put("Motorcycles", List.of(
                new SpecificationField("Brand", AttributeType.TEXT),
                new SpecificationField("Model", AttributeType.TEXT),
                new SpecificationField("Year", AttributeType.NUMBER),
                new SpecificationField("Engine Volume", AttributeType.NUMBER),
                new SpecificationField("Mileage", AttributeType.NUMBER)
        ));

        DATA.put("Bicycles", List.of(
                new SpecificationField("Brand", AttributeType.TEXT),
                new SpecificationField("Frame Size", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("Excellent", "Good", "Needs Repair")
                )
        ));

        DATA.put("Heavy Vehicles", List.of(
                new SpecificationField("Brand", AttributeType.TEXT),
                new SpecificationField("Model", AttributeType.TEXT),
                new SpecificationField("Year", AttributeType.NUMBER),
                new SpecificationField("Mileage", AttributeType.NUMBER),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("Excellent", "Good", "Needs Repair")
                )
        ));

        //------------------------
        // Digital Goods
        //------------------------

        DATA.put("Mobile Phones & Tablets", List.of(
                new SpecificationField("Brand", AttributeType.TEXT),
                new SpecificationField("Model", AttributeType.TEXT),
                new SpecificationField("Storage", AttributeType.NUMBER),
                new SpecificationField("RAM", AttributeType.NUMBER),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New", "Used")
                )
        ));

        DATA.put("Laptops & Computers", List.of(
                new SpecificationField("Brand", AttributeType.TEXT),
                new SpecificationField("Model", AttributeType.TEXT),
                new SpecificationField("CPU", AttributeType.TEXT),
                new SpecificationField("RAM", AttributeType.NUMBER),
                new SpecificationField("Storage", AttributeType.NUMBER),
                new SpecificationField("GPU", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New", "Used")
                )
        ));

        DATA.put("Audio & Video", List.of(
                new SpecificationField("Brand", AttributeType.TEXT),
                new SpecificationField("Model", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New", "Used")
                )
        ));

        DATA.put("Accessories", List.of(
                new SpecificationField("Brand", AttributeType.TEXT),
                new SpecificationField("Model", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New", "Used")
                )
        ));

        //------------------------
        // Home & Kitchen
        //------------------------

        DATA.put("Home Appliances", List.of(
                new SpecificationField("Brand", AttributeType.TEXT),
                new SpecificationField("Model", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New", "Used")
                )
        ));

        DATA.put("Furniture", List.of(
                new SpecificationField("Type", AttributeType.TEXT),
                new SpecificationField("Material", AttributeType.TEXT),
        new SpecificationField(
                "Condition",
                AttributeType.DROPDOWN,
                List.of("New", "Used")
        )
        ));

        DATA.put("Kitchen Appliances & Cookware", List.of(
                new SpecificationField("Brand", AttributeType.TEXT),
                new SpecificationField("Model", AttributeType.TEXT),
                new SpecificationField("Material", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New", "Used")
                )
        ));

        DATA.put("Home Decoration", List.of(
                new SpecificationField("Type", AttributeType.TEXT),
                new SpecificationField("Material", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New", "Used")
                )
        ));

        //------------------------
        // Personal Items
        //------------------------

        DATA.put("Clothing", List.of(
                new SpecificationField("Brand", AttributeType.TEXT),
                new SpecificationField("Size", AttributeType.TEXT),
                new SpecificationField("Material", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New", "Used")
                )
        ));

        DATA.put("Shoes & Bags", List.of(
                new SpecificationField("Brand", AttributeType.TEXT),
                new SpecificationField("Type", AttributeType.TEXT),
                new SpecificationField("Size", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New", "Used")
                )
        ));

        DATA.put("Watches", List.of(
                new SpecificationField("Brand", AttributeType.TEXT),
                new SpecificationField("Model", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New", "Used")
                )
        ));

        DATA.put("Accessories & Jewelry", List.of(
                new SpecificationField("Type", AttributeType.TEXT),
                new SpecificationField("Material", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New", "Used")
                )
        ));

        DATA.put("Beauty & Health", List.of(
                new SpecificationField("Brand", AttributeType.TEXT),
                new SpecificationField("Product Type", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New", "Used")
                )
        ));

        DATA.put("Baby & Kids", List.of(
                new SpecificationField("Product Type", AttributeType.TEXT),
                new SpecificationField("Age Range", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New", "Used")
                )
        ));

        //------------------------
        // Sports & Entertainment
        //------------------------

        DATA.put("Sports Equipment", List.of(
                new SpecificationField("Brand", AttributeType.TEXT),
                new SpecificationField("Equipment Type", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New", "Used")
                )
        ));

        DATA.put("Musical Instruments", List.of(
                new SpecificationField("Brand", AttributeType.TEXT),
                new SpecificationField("Instrument Type", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New", "Used")
                )
        ));

        DATA.put("Books", List.of(
                new SpecificationField(
                        "Book Type",
                        AttributeType.DROPDOWN,
                        List.of("Educational","Literature","Historical","Religious","Other")
                ),
                new SpecificationField("Author", AttributeType.TEXT),
                new SpecificationField("Publisher", AttributeType.TEXT),
                new SpecificationField("Language", AttributeType.TEXT),
                new SpecificationField("Publication Year", AttributeType.NUMBER),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New", "Used")
                )
        ));

        DATA.put("Video Games", List.of(
                new SpecificationField("Platform", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New", "Used")
                )
        ));

        DATA.put("Toys & Games", List.of(
                new SpecificationField("Age Range", AttributeType.TEXT),
                new SpecificationField("Material", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New", "Used")
                )
        ));

        //------------------------
        // Industrial
        //------------------------

        DATA.put("Construction Materials & Equipment", List.of(
                new SpecificationField("Product Type", AttributeType.TEXT),
                new SpecificationField("Brand", AttributeType.TEXT),
                new SpecificationField("Material", AttributeType.TEXT)
        ));

        DATA.put("Tools", List.of(
                new SpecificationField("Brand", AttributeType.TEXT),
                new SpecificationField("Tool Type", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New", "Used")
                )
        ));

        //------------------------
        // Pets
        //------------------------

        DATA.put("Dogs", List.of(
                new SpecificationField("Breed", AttributeType.TEXT),
                new SpecificationField("Age", AttributeType.NUMBER),
                new SpecificationField(
                        "Gender",
                        AttributeType.DROPDOWN,
                        List.of("Male","Female")
                )
        ));

        DATA.put("Cats", List.of(
                new SpecificationField("Breed", AttributeType.TEXT),
                new SpecificationField("Age", AttributeType.NUMBER),
                new SpecificationField(
                        "Gender",
                        AttributeType.DROPDOWN,
                        List.of("Male","Female")
                )
        ));

        DATA.put("Birds", List.of(
                new SpecificationField("Species", AttributeType.TEXT),
                new SpecificationField("Age", AttributeType.NUMBER),
                new SpecificationField(
                        "Gender",
                        AttributeType.DROPDOWN,
                        List.of("Male","Female")
                ),
                new SpecificationField("Color", AttributeType.TEXT)
        ));

        DATA.put("Aquatic Animals", List.of(
                new SpecificationField("Species", AttributeType.TEXT),
                new SpecificationField("Age", AttributeType.NUMBER),
                new SpecificationField(
                        "Water Type",
                        AttributeType.DROPDOWN,
                        List.of("Fresh Water","Salt Water")
                )
        ));

        DATA.put("Rodents & Small Pets", List.of(
                new SpecificationField("Species", AttributeType.TEXT),
                new SpecificationField("Age", AttributeType.NUMBER),
                new SpecificationField(
                        "Gender",
                        AttributeType.DROPDOWN,
                        List.of("Male","Female")
                )
        ));

        DATA.put("Pet Food & Accessories", List.of(
                new SpecificationField("Brand", AttributeType.TEXT),
                new SpecificationField("Product Type", AttributeType.TEXT),
                new SpecificationField(
                        "Condition",
                        AttributeType.DROPDOWN,
                        List.of("New","Used")
                )
        ));

    }
    public static List<SpecificationField> getFields(String subcategory) {

        return DATA.getOrDefault(subcategory, List.of());

    }

}