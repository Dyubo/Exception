package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.exceptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    Product item1 = new Product(1,"Honor",12000);
    Product item2 = new Product(2, "game of Thrones", 1500);
    Product item3 = new Product(3,"Samsung", 8000);
    Product item4 = new Product(4, "Dot com testing", 800);
@BeforeEach
    public void setup(){
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
    }
    @Test
    public void shouldRemoveProduct(){
        repository.removeById(3);
        Product[] expected = new Product[]{item1,item2,item4};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldThrow(){
    assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }



}
