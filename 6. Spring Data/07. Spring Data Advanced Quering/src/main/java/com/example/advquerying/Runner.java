package com.example.advquerying;

import com.example.advquerying.Repositories.ShampooRepository;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private final ShampooRepository shampooRepository;

    private final ShampooService shampooService;

    private final IngredientService ingredientService;

    @Autowired
    public Runner(
            ShampooRepository shampooRepository,
            ShampooService shampooService,
            IngredientService ingredientService) {
        this.shampooRepository = shampooRepository;
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) {

        // 1. Select Shampoos by Size

        //this.shampooService.selectBySize(Size.MEDIUM)
        //        .forEach(System.out::println);

        // 2. Select Shampoos by Size or Label

        //this.shampooService.selectBySizeOrLabelId(Size.MEDIUM, 10)
        //        .forEach(System.out::println);

        // 3. Select Shampoos by Price

        //this.shampooService.selectMoreExpensiveThan(BigDecimal.valueOf(5))
        //        .forEach(System.out::println);

        // 4. Select Ingredients by Name

        //this.ingredientService.selectNameStartsWith("M")
        //        .forEach(System.out::println);

        // 5. Select Ingredients by Names

        //this.ingredientService.selectInNames(List.of("Lavender", "Herbs", "Apple"))
        //        .forEach(System.out::println);

        // 6. Count Shampoos by Price

        //int count = this.shampooService.counPriceLowerThan(BigDecimal.valueOf(8.5));
        //System.out.println(count);

        // 7. Select Shampoos by Ingredients

        // 8. Select Shampoos by Ingredients Count

        //this.shampooRepository.findBySizeOrderById(size).forEach(System.out::println);

        // 9. Delete Ingredients by Name

        //this.ingredientService.deleteByName("Nettle");

        // 10. Update Ingredients by Price
        //this.ingredientService.increasePriceByPercentage(1.1);


        // this.shampooRepository
        //        .findByBrand("Cotton Fresh")
        //        .forEach(s -> System.out.println(s.getId()));

        //this.shampooRepository
        //       .findAllByBrandAndSize("Cotton Fresh", Size.SMALL)
        //        .forEach(s -> System.out.println(s.getId()));

        //Scanner scanner = new Scanner(System.in);

        //String first = scanner.nextLine();
        //String second = scanner.nextLine();

        //Set<String> names = Set.of(first, second);

        //this.shampooRepository.findByIngredientsNames(names)
        //        .forEach(System.out::println);


        //String sizeName = scanner.nextLine();
        //Size size = Size.valueOf(sizeName);


    }
}
