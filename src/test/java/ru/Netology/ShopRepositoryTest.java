package ru.Netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {

    @Test

    public void testRemoveWhenProductExist() {

        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "Телефон", 30000);
        Product product2 = new Product(22, "Книга", 2000);
        Product product3 = new Product(33, "Стол", 5000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(22);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void testRemoveWhenProductNonExist() {

        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "Телефон", 30000);
        Product product2 = new Product(22, "Книга", 2000);
        Product product3 = new Product(33, "Стол", 5000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class,
                ()-> repo.remove(44)
        );
    }
}
