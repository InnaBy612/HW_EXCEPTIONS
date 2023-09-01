import org.example.NotFoundException;
import org.example.Product;
import org.example.ShopRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(13, "Учебник", 3_000);
        Product product2 = new Product(6, "Тетрадь", 200);
        Product product3 = new Product(23, "Ручка", 10);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(13);

        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(13, "Учебник", 3_000);
        Product product2 = new Product(6, "Тетрадь", 200);
        Product product3 = new Product(23, "Ручка", 10);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(13);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(666)
        );
    }
}
