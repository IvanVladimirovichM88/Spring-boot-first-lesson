package ru.geekbrains.lesson.store.utils;

import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;
import ru.geekbrains.lesson.store.entities.Category;
import ru.geekbrains.lesson.store.entities.Customer;
import ru.geekbrains.lesson.store.entities.Order;
import ru.geekbrains.lesson.store.entities.Product;
import ru.geekbrains.lesson.store.repositories.CategoryRepository;
import ru.geekbrains.lesson.store.repositories.CustomerRepository;
import ru.geekbrains.lesson.store.repositories.OrderRepository;
import ru.geekbrains.lesson.store.repositories.ProductRepository;

import javax.annotation.PostConstruct;

@Component
public class SampleData {

    private CustomerRepository customerRepository;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;
    private CategoryRepository categoryRepository;

    public SampleData(
            CustomerRepository customerRepository,
            ProductRepository productRepository,
            OrderRepository orderRepository,
            CategoryRepository categoryRepository
    ) {

        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    public void init() {

        Category category1 = new Category("Fruit");
        Category category2 = new Category("Meat");

        categoryRepository.save(category1);
        categoryRepository.save(category2);

        Product product1 = new Product("Orange", 50.);
        Product product2 = new Product("Lemon", 70.);
        Product product3 = new Product("Lime", 20.);
        Product product4 = new Product("Mango", 110.);
        Product product5 = new Product("Apple", 95.);
        Product product6 = new Product("Pineapple", 76.);
        Product product7 = new Product("Avocado", 123.);
        Product product8 = new Product("Chicken", 123.);


//        category1.getProducts().add(product1);
//        category1.getProducts().add(product2);
//        category1.getProducts().add(product3);


        product1.setCategory(category1);
        product2.setCategory(category1);
        product3.setCategory(category1);
        product8.setCategory(category2);


        Customer customer1 = new Customer("Alex");
        Customer customer2 = new Customer("Alena");
        Customer customer3 = new Customer("Filipp");
        Customer customer4 = new Customer("Givi");


        Order order1 = new Order();
        order1.setTotalPrice(product1.getPrice());
        order1.setCustomer(customer1);
        order1.setCode("0001");

        Order order2 = new Order();
        order2.setTotalPrice(product2.getPrice());
        order2.setCustomer(customer2);
        order2.setCode("0002");


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




    }
}
