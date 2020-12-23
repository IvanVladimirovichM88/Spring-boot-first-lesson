package ru.geekbrains.lesson.store.facade;

import org.springframework.stereotype.Service;
import ru.geekbrains.lesson.store.data.CustomerData;
import ru.geekbrains.lesson.store.entities.Customer;
import ru.geekbrains.lesson.store.populators.CustomerPopulator;
import ru.geekbrains.lesson.store.repositories.CustomerDataRepository;
import ru.geekbrains.lesson.store.services.CustomerService;

import java.util.List;

@Service
public class CustomerFacade {

    private CustomerPopulator customerPopulator;
    private CustomerService customerService;
    private CustomerDataRepository customerDataRepository;

    public CustomerFacade(CustomerPopulator customerPopulator, CustomerService customerService, CustomerDataRepository customerDataRepository) {
        this.customerPopulator = customerPopulator;
        this.customerService = customerService;
        this.customerDataRepository = customerDataRepository;
    }

    public CustomerData getCustomerById(Long id){
        Customer customer = customerService.findById(id).get();
        return new CustomerData(customer);
    }

    public List<CustomerData> getAllCustomerData(){
        return customerPopulator.convertAll(customerService.findAll());
    }

    public List<CustomerData> getAllCustomerDataFromRepository(){
        return customerDataRepository.findAllProductData();
    }
}
