//package ru.geekbrains.lesson.store.services;
//
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Service;
//import ru.geekbrains.lesson.store.entities.Customer;
//import ru.geekbrains.lesson.store.entities.Product;
//import ru.geekbrains.lesson.store.repositories.CustomerRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CustomerService {
//    private CustomerRepository customerRepository;
//
//    public CustomerService(CustomerRepository customerRepository){
//        this.customerRepository = customerRepository;
//    }
//    public Optional<Customer> findById(Long id){
//        return customerRepository.findById(id);
//    }
//
//    public void deleteById(Long id){
//        customerRepository.deleteById(id);
//    }
//
//    public List<Customer> findAll(){
//        return customerRepository.findAll();
//    }
//
//    public Customer addCustomer(Customer customer){
//        return customerRepository.save(customer);
//    }
//
//    public void saveOrUpdate(Customer customer){
//        customerRepository.save(customer);
//    }
//
//}
