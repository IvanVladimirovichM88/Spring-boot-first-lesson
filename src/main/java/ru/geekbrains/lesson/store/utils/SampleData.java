package ru.geekbrains.lesson.store.utils;

import org.springframework.stereotype.Component;
import ru.geekbrains.lesson.store.entities.Customer;
import ru.geekbrains.lesson.store.entities.Order;
import ru.geekbrains.lesson.store.entities.Product;
import ru.geekbrains.lesson.store.repositories.CustomerRepository;
import ru.geekbrains.lesson.store.repositories.OrderRepository;
import ru.geekbrains.lesson.store.repositories.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.Calendar;

@Component
public class SampleData {

    private CustomerRepository customerRepository;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;

    public SampleData(CustomerRepository customerRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @PostConstruct
    public void init() {

        Product product1 = new Product("Orange", 50);
        Product product2 = new Product("Lemon", 70);
        Product product3 = new Product("Lime", 20);
        Product product4 = new Product("Mango", 110);
        Product product5 = new Product("Apple", 95);
        Product product6 = new Product("Pineapple", 76);
        Product product7 = new Product("Avocado", 123);
        Product product8 = new Product("Chicken", 123);

        Customer customer1 = new Customer("Alex");
        Customer customer2 = new Customer("Alena");
        Customer customer3 = new Customer("Filipp");
        Customer customer4 = new Customer("Givi");


        Order order1 = new Order();
        order1.setCurrentPrice(product1.getPrice());
        order1.setCustomer(customer1);
        order1.setProduct(product1);
        order1.setCode("0001");

        Order order2 = new Order();
        order2.setCurrentPrice(product2.getPrice());
        order2.setCustomer(customer2);
        order2.setProduct(product2);
        order2.setCode("0002");

        Order order3 = new Order();
        order3.setCurrentPrice(product3.getPrice());
        order3.setCustomer(customer3);
        order3.setProduct(product3);
        order3.setCode("0003");

        Order order4 = new Order();
        order4.setCurrentPrice(product4.getPrice());
        order4.setCustomer(customer4);
        order4.setProduct(product4);
        order4.setCode("0004");

        Order order5 = new Order();
        order5.setCurrentPrice(product5.getPrice());
        order5.setCustomer(customer1);
        order5.setProduct(product5);
        order5.setCode("0005");

        Order order6 = new Order();
        order6.setCurrentPrice(product6.getPrice());
        order6.setCustomer(customer2);
        order6.setProduct(product6);
        order6.setCode("0006");

        Order order7 = new Order();
        order7.setCurrentPrice(product7.getPrice());
        order7.setCustomer(customer3);
        order7.setProduct(product7);
        order7.setCode("0007");

        Order order8 = new Order();
        order8.setCurrentPrice(product8.getPrice());
        order8.setCustomer(customer4);
        order8.setProduct(product8);
        order8.setCode("0008");

        Order order9 = new Order();
        order9.setCurrentPrice(product1.getPrice());
        order9.setCustomer(customer1);
        order9.setProduct(product1);
        order9.setCode("0009");

        Order order10 = new Order();
        order10.setCurrentPrice(product2.getPrice());
        order10.setCustomer(customer2);
        order10.setProduct(product2);
        order10.setCode("0010");

        Order order11 = new Order();
        order11.setCurrentPrice(product3.getPrice());
        order11.setCustomer(customer3);
        order11.setProduct(product3);
        order11.setCode("0011");

        Order order12 = new Order();
        order12.setCurrentPrice(product4.getPrice());
        order12.setCustomer(customer4);
        order12.setProduct(product4);
        order12.setCode("0012");


        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product6);
        productRepository.save(product7);
        productRepository.save(product8);

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);

        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
        orderRepository.save(order4);
        orderRepository.save(order5);
        orderRepository.save(order6);
        orderRepository.save(order7);
        orderRepository.save(order8);
        orderRepository.save(order9);
        orderRepository.save(order10);
        orderRepository.save(order11);
        orderRepository.save(order12);

    }
}
