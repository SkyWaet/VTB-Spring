package shop;

import employees.AbstractEmployee;
import employees.impl.RegularEmployee;
import products.Product;
import services.CustomerService;
import services.HRService;
import services.SalesService;
import services.Storage;

import java.util.List;

public class Shop {
    private final Storage storage;
    private final CustomerService customerService;
    private final HRService hrService;
    private final SalesService salesService;


    public Shop(Storage storage, CustomerService customerService, HRService hrService, SalesService salesService) {
        this.storage = storage;
        this.customerService = customerService;
        this.hrService = hrService;
        this.salesService = salesService;
    }

    public List<Product> getProducts() {
        return storage.get();
    }

    public List<AbstractEmployee> getStaff() {
        return hrService.getStaff();
    }

    public boolean addProduct(Product product) {
        return storage.add(product);
    }

    public void removeProduct(Product product) {
        storage.remove(product);
    }

    public AbstractEmployee hire(String name, String surname) {
        AbstractEmployee e = new RegularEmployee(name, surname, 20.0);
        hrService.hire(e);
        return e;
    }

    public void fire(AbstractEmployee e) {
        hrService.fire(e);
    }

    public void raiseSalary(AbstractEmployee e) {
        hrService.raiseSalary(e, 10);
    }

    public boolean sell(Product product) {
        return salesService.sell(product);
    }

    public void help() {
        customerService.help();
    }
}
