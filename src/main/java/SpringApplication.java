import config.Locales;
import employees.AbstractEmployee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import products.Book;
import products.Product;
import services.Logger;
import services.impl.ConsoleLogger;
import shop.Shop;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class SpringApplication {


    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("Config.xml");
        Shop shop = ctx.getBean(Shop.class);
        for (int i = 0; i < 6; i++) {
            Product book = new Book("name" + i, 1.0);
            shop.addProduct(book);
        }
        Product book1 = new Book("дешевая книга", 20);
        shop.addProduct(book1);
        Product book2 = new Book("дорогая книга", 1000);
        Logger log = ctx.getBean(ConsoleLogger.class);

        try {
            log.log(shop.getProducts());
            shop.sell(book1);
            shop.sell(book2);
            log.log( shop.getProducts());
            for (int i = 1; i < 5; i++) {
                AbstractEmployee e = shop.hire("John" + i, "Johnson" + i);
            }
            List<AbstractEmployee> staff = shop.getStaff();
            log.log(staff);
            shop.fire(staff.get(0));
            shop.raiseSalary(staff.get(0));
            shop.help();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
