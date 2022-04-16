package ru.geekbrains.less2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.less2.Config.AppConfig;
import ru.geekbrains.less2.Repository.CartInMemoryRepository;
import ru.geekbrains.less2.Service.ProductService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService = context.getBean(ProductService.class);
        CartInMemoryRepository cartInMemoryRepository = context.getBean(CartInMemoryRepository.class);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String check = scanner.nextLine();

            if (check.equals("/add")) {
                System.out.println("Введите ID продукта");
                Long id = scanner.nextLong();
                cartInMemoryRepository.addedToId(id);
                System.out.println("Продукт добавлен!");
            } else if (check.equals("/delete")) {
                System.out.println("Введите ID продукта для удаления");
                int id = scanner.nextInt();
                id = id - 1;
                cartInMemoryRepository.deleteToId(id);
                System.out.println("Продукт удален!");
            } else if (check.equals("/cart")) {
                System.out.println("Корзина:");
                cartInMemoryRepository.cartAllProd();
            } else if (check.equals("/size")) {
                System.out.println("В корзине элементов");
                cartInMemoryRepository.cartSize();
            } else if (check.equals("/end")) {
                System.out.println("Завершение работы!");
                break;
            }
        }

        //System.out.println("Вывод продуктов по ID");
        //System.out.println(productService.getProductId(2l));
//
        //System.out.println("Вывод продуктов по имени");
        //System.out.println(productService.getProductName("Apple"));
//
        //System.out.println("Добавление элемента в корзину");
        //cartInMemoryRepository.addedToId(2L);
        ////productService.addedToCart(2L);
//
        //System.out.println("Удаление элемента из корзины");
        //cartInMemoryRepository.deleteToId(0);
    }
}