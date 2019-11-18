import org.junit.jupiter.api.Test;
import ru.rosbank.javaschool.domain.dto.AbstractProductDto;
import ru.rosbank.javaschool.domain.dto.BurgerDto;
import ru.rosbank.javaschool.domain.dto.ProductDto;
import ru.rosbank.javaschool.domain.model.AbstractProduct;
import ru.rosbank.javaschool.domain.model.Burger;
import ru.rosbank.javaschool.domain.model.Drink;
import ru.rosbank.javaschool.domain.model.Potatoes;
import ru.rosbank.javaschool.domain.sale.Check;
import ru.rosbank.javaschool.domain.sale.Sale;
import ru.rosbank.javaschool.exception.InvalidDataException;
import ru.rosbank.javaschool.repository.CheckRepository;
import ru.rosbank.javaschool.repository.CheckRepositoryImpl;
import ru.rosbank.javaschool.repository.ProductRepository;
import ru.rosbank.javaschool.repository.ProductRepositoryImpl;
import ru.rosbank.javaschool.service.ProductService;
import ru.rosbank.javaschool.service.ProductServiceInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    ProductRepository product = new ProductRepositoryImpl();
    CheckRepository check = new CheckRepositoryImpl();

    public ProductServiceTest() {
        AbstractProduct bigMak = new Burger(0, "BigMak", 150, "BigMak", "beef");
        AbstractProduct cheesBurger = new Burger(0, "CheesBurger", 100, "CheesBurger", "beef");
        AbstractProduct chickBurger = new Burger(0, "ChickBurger", 120, "ChickBurger", "chicken");
        AbstractProduct colaStandart = new Drink(0, "Coca-cola", 50, "Coca-cola st", "Standart");
        AbstractProduct colaBig = new Drink(0, "Coca-cola", 100, "Coca-cola big", "Big");
        AbstractProduct fantaStandart = new Drink(0, "Fanta", 50, "Fanta st", "Standart");
        AbstractProduct fantaBig = new Drink(0, "Fanta", 100, "Fanta big", "Big");
        AbstractProduct frieStandart = new Potatoes(0, "French Fries", 60, "French Fries st", "Standart");
        AbstractProduct frieBig = new Potatoes(0, "French Fries", 100, "French Fries big", "Big");
        product.create(bigMak);
        product.create(cheesBurger);
        product.create(chickBurger);
        product.create(colaStandart);
        product.create(colaBig);
        product.create(fantaStandart);
        product.create(fantaBig);
        product.create(frieStandart);
        product.create(frieBig);
        List<Sale> sales1 = new ArrayList<>();
        sales1.add(new Sale(bigMak, 1));
        sales1.add(new Sale(colaBig, 1));
        sales1.add(new Sale(frieBig, 1));
        List<Sale> sales2 = new ArrayList<>();
        sales2.add(new Sale(cheesBurger, 2));
        sales2.add(new Sale(colaStandart, 2));
        sales2.add(new Sale(frieStandart, 2));
        List<Sale> sales3 = new ArrayList<>();
        sales3.add(new Sale(chickBurger, 3));
        sales3.add(new Sale(fantaStandart, 3));
        sales3.add(new Sale(frieStandart, 3));
        check.create(new Check(0, sales1));
        check.create(new Check(0, sales2));
        check.create(new Check(0, sales3));
    }

    @Test
    void saveProductNegativeId(){

        ProductServiceInterface service = new ProductService(product, check);
        AbstractProductDto bigMakDto = new BurgerDto(-1, "BigMak", 150, "BigMak", "beef");
        InvalidDataException trow = assertThrows(InvalidDataException.class,() -> service.saveProduct(bigMakDto));
        assertTrue(trow.getMessage().contains("Id incorrect"));

    }
    @Test
    void saveProductCreate(){

        ProductServiceInterface service = new ProductService(product, check);
        AbstractProductDto bigMakDto = new BurgerDto(0, "BigMak", 150, "BigMak", "beef");
        AbstractProduct bigMak = new Burger(0,"BigMak", 150, "BigMak", "beef");
        assertEquals(bigMak, service.saveProduct(bigMakDto));

    }

    @Test
    void saveProductUpdate(){

        ProductServiceInterface service = new ProductService(product, check);
        AbstractProductDto bigMakDto = new BurgerDto(1, "BigMak", 150, "BigMak", "beef");
        AbstractProduct bigMak = new Burger(0,"BigMak", 150, "BigMak", "beef");
        assertEquals(bigMak, service.saveProduct(bigMakDto));

    }

    @Test
    void saveCheckNegativeId(){

        ProductServiceInterface service = new ProductService(product, check);
        AbstractProduct bigMak = new Burger(0, "BigMak", 150, "BigMak", "beef");
        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale(bigMak, 1));
        Check check = new Check(-1, sales);
        InvalidDataException trow = assertThrows(InvalidDataException.class,() -> service.saveCheck(check));
        assertTrue(trow.getMessage().contains("Id incorrect"));

    }

    @Test
    void saveCheckCreate(){

        ProductServiceInterface service = new ProductService(product, check);
        AbstractProduct bigMak = new Burger(0, "BigMak", 150, "BigMak", "beef");
        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale(bigMak, 1));
        Check check = new Check(0, sales);
        assertEquals(check, service.saveCheck(check));

    }

    @Test
    void saveCheckUpdate(){

        ProductServiceInterface service = new ProductService(product, check);
        AbstractProduct bigMak = new Burger(0, "BigMak", 150, "BigMak", "beef");
        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale(bigMak, 1));
        Check check = new Check(1, sales);
        assertEquals(check, service.saveCheck(check));

    }

    @Test
    void searchProduct(){

        ProductServiceInterface service = new ProductService(product, check);
        String product = "Mak";
        List<ProductDto> list = new ArrayList<>();
        ProductDto bigMakDto = new ProductDto(1, "BigMak", 150);
        list.add(bigMakDto);
        Collection<ProductDto> result = service.searchProduct(product);
        assertEquals(list, result);

    }

    @Test
    void removeProductById(){
        ProductServiceInterface service = new ProductService(product, check);
        int id = 1;
        assertEquals(true, service.removeProductById(id));

    }

    @Test
    void removeCheckById(){
        ProductServiceInterface service = new ProductService(product, check);
        int id = 1;
        assertEquals(true, service.removeCheckById(id));

    }


}
