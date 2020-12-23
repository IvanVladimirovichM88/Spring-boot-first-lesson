package ru.geekbrains.lesson.store.populators;

import org.springframework.stereotype.Service;
import ru.geekbrains.lesson.store.data.CustomerData;
import ru.geekbrains.lesson.store.entities.Customer;

import java.util.stream.Collectors;

@Service
public class CustomerPopulator implements Populator<Customer, CustomerData>{
    @Override
    public CustomerData populate(Customer customer, CustomerData customerData) {
        if (customer == null || customerData == null)
            return null;
        customerData.setId(customer.getId());
        customerData.setName(customer.getName());
        customerData.setOrdersCode(customer.getOrders().stream().map(orders->
                orders.getCode()).collect(Collectors.toList()));
        customerData.setCreateDate(customer.getCreateDate());
        customerData.setModifyDate(customer.getModifyDate());
        return customerData;
    }

    @Override
    public CustomerData populate(Customer customer) {
        return populate(customer, new CustomerData());
    }
}
