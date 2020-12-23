package ru.geekbrains.lesson.store.controllers.rest;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.lesson.store.data.CustomerData;
import ru.geekbrains.lesson.store.entities.Customer;
import ru.geekbrains.lesson.store.entities.views.CustomerView;
import ru.geekbrains.lesson.store.facade.CustomerFacade;
import ru.geekbrains.lesson.store.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer/api/v1")
public class CustomerRestController {

    private CustomerService customerService;
    private CustomerFacade customerFacade;

    public CustomerRestController(CustomerService customerService, CustomerFacade customerFacade) {
        this.customerService = customerService;
        this.customerFacade = customerFacade;
    }

    @GetMapping(value = "jsonData")
    public List<CustomerData> allCustomersDataToJson(){
        return customerFacade.getAllCustomerData();
                //getAllCustomerDataFromRepository();
    }

    @GetMapping(value = "/jsonData/{id}")
    public CustomerData customerDataToJson(
            @PathVariable Long id
    ) {
        return customerFacade.getCustomerById(id);
    }

    @GetMapping(value = "json")
    @JsonView(CustomerView.IdNameOrders.class)
    public List<Customer> allCustomersToJson(){
        return customerService.findAll();
    }

    @GetMapping(value = "json/{id}")
    @JsonView(CustomerView.IdNameOrders.class)
    public Customer customerToJson(
            @PathVariable Long id
    ){
        return customerService.findById(id).get();
    }

}
