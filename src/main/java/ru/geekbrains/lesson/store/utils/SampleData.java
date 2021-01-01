package ru.geekbrains.lesson.store.utils;

import org.springframework.stereotype.Component;
import ru.geekbrains.lesson.store.entities.*;
import ru.geekbrains.lesson.store.repositories.*;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class SampleData {

    private UserRepository userRepository;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;
    private CategoryRepository categoryRepository;
    private RoleRepository roleRepository;

    public SampleData(
            UserRepository userRepository,
            ProductRepository productRepository,
            OrderRepository orderRepository,
            CategoryRepository categoryRepository,
            RoleRepository roleRepository
    ) {

        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void init() {

        Category category1 = new Category("Red Fruit");
        Category category2 = new Category("Yellow Fruit");
        Category category3 = new Category("Other");


        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);

        Product product1 = new Product("Orange", 50.);
        Product product2 = new Product("Lemon", 70.);
        Product product3 = new Product("Lime", 20.);
        Product product4 = new Product("Mango", 110.);
        Product product5 = new Product("Apple", 95.);
        Product product6 = new Product("Pineapple", 76.);
        Product product7 = new Product("Avocado", 123.);
        Product product8 = new Product("Chicken", 123.);



//
//
        product1.setCategory(category1);
        product2.setCategory(category2);
        product3.setCategory(category3);
        product4.setCategory(category1);
        product5.setCategory(category2);
        product6.setCategory(category3);
        product7.setCategory(category1);
        product8.setCategory(category2);

        Role role1 = new Role("ROLE_USER");
        Role role2 = new Role("ROLE_ADMIN");
        Role role3 = new Role("ROLE_SUPER_ADMIN");
        Role role4 = new Role("ROLE_MANAGER");

        User user1 = new User("Alex");
        user1.setUsername("alex");
        //user1.setPassword("{bcrypt}$2y$12$kppL/79H63sx3NoXlZhY/uDW2EiB18ByX8YeENyFwyxAnHjrCT4pK");
        user1.setPassword("$2y$12$XKU8JtljcLQlWaJM1mloweHz/RVUPCOLUAOtM1cDlgSlM4/Ndf6dO"); // 1
        user1.getRoles().add(role1);
        user1.getRoles().add(role2);
        user1.getRoles().add(role3);

        User user2 = new User("Alena");
        user2.setUsername("alena");
        //user2.setPassword("{bcrypt}$2y$12$kppL/79H63sx3NoXlZhY/uDW2EiB18ByX8YeENyFwyxAnHjrCT4pK");
        user2.setPassword("$2y$12$XKU8JtljcLQlWaJM1mloweHz/RVUPCOLUAOtM1cDlgSlM4/Ndf6dO");
        user2.getRoles().add(role1);
        user2.getRoles().add(role4);

        User user3 = new User();
        user3.setUsername("anonymousUser");
        user3.setName("anonymousUser");
        user3.getRoles().add(role1);

        Order order1 = new Order();
        order1.setTotalPrice(product1.getPrice());
        order1.setUser(user1);
        order1.setCode("0001");

        Order order2 = new Order();
        order2.setTotalPrice(product2.getPrice());
        order2.setUser(user2);
        order2.setCode("0002");

        OrderEntry orderEntry1 = new OrderEntry(product1, order1);
        OrderEntry orderEntry2 = new OrderEntry(product2, order1);
        OrderEntry orderEntry3 = new OrderEntry(product3, order1);
        OrderEntry orderEntry4 = new OrderEntry(product4, order2);
        OrderEntry orderEntry5 = new OrderEntry(product5, order2);

//
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product6);
        productRepository.save(product7);
        productRepository.save(product8);
//
        roleRepository.save(role1);
        roleRepository.save(role2);
        roleRepository.save(role3);
        roleRepository.save(role4);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        orderRepository.save(order1);
        orderRepository.save(order2);
//
//


    }
}
