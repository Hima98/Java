package com.springbootacademy.batch7.pos.service.impl;

import com.springbootacademy.batch7.pos.dto.CustomerDTO;
import com.springbootacademy.batch7.pos.dto.request.CustomerUpdateDTO;
import com.springbootacademy.batch7.pos.entity.Customer;
import com.springbootacademy.batch7.pos.repo.CustomerRepo;
import com.springbootacademy.batch7.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public String saveCustomer(CustomerDTO customerDTO) {

        Customer customer=new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getContactNumber(),
                customerDTO.getCustomerSalary(),
                customerDTO.getNic(),
                customerDTO.isActive());
        customerRepo.save(customer);
        return customerDTO.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if(customerRepo.existsById(customerUpdateDTO.getCustomerId())){
            Customer customer=customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName() + " Updated succesful";
    }
        else {
            throw new RuntimeException("no data found");
        }
        }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if(customerRepo.existsById(customerId)){
            Customer customer=customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO= new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.isActive());
            return customerDTO;
        }
        else {
            throw new RuntimeException("No Customer");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepo.findAll();

        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for(Customer customer : getAllCustomers){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.isActive());
            customerDTOList.add(customerDTO);

        }

        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "deleted Successfully"+ customerId;
        }
        else {
            throw new RuntimeException("No Customer found in that Id");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean activeState) {
        List<Customer> getAllCustomers = customerRepo.findAllByActiveEquals(activeState);

        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for(Customer customer : getAllCustomers){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.isActive());
            customerDTOList.add(customerDTO);

        }

        return customerDTOList;
    }
}
