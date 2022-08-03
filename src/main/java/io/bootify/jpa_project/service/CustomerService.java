package io.bootify.jpa_project.service;

import io.bootify.jpa_project.domain.Customer;
import io.bootify.jpa_project.domain.Usr;
import io.bootify.jpa_project.model.CustomerDTO;
import io.bootify.jpa_project.repos.CustomerRepository;
import io.bootify.jpa_project.repos.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    public CustomerService(final CustomerRepository customerRepository,
            final UserRepository userRepository) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
    }

    public List<CustomerDTO> findAll() {
        return customerRepository.findAll(Sort.by("id"))
                .stream()
                .map(customer -> mapToDTO(customer, new CustomerDTO()))
                .collect(Collectors.toList());
    }

    public CustomerDTO get(final Long id) {
        return customerRepository.findById(id)
                .map(customer -> mapToDTO(customer, new CustomerDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final CustomerDTO customerDTO) {
        final Customer customer = new Customer();
        mapToEntity(customerDTO, customer);
        return customerRepository.save(customer).getId();
    }

    public void update(final Long id, final CustomerDTO customerDTO) {
        final Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(customerDTO, customer);
        customerRepository.save(customer);
    }

    public void delete(final Long id) {
        customerRepository.deleteById(id);
    }

    private CustomerDTO mapToDTO(final Customer customer, final CustomerDTO customerDTO) {
        customerDTO.setId(customer.getId());
        customerDTO.setCustId(customer.getCustId());
        customerDTO.setThresholdAmt(customer.getThresholdAmt());
        customerDTO.setUtilizedThresholdAmt(customer.getUtilizedThresholdAmt());
        customerDTO.setCreatedDate(customer.getCreatedDate());
        customerDTO.setLastUpdated(customer.getLastUpdatedDate());
        customerDTO.setUsr(Long.valueOf(customer.getUsr() == null ? null : customer.getUsr().getId()));
        return customerDTO;
    }

    private Customer mapToEntity(final CustomerDTO customerDTO, final Customer customer) {
        customer.setCustId(customerDTO.getCustId());
        customer.setThresholdAmt(customerDTO.getThresholdAmt());
        customer.setUtilizedThresholdAmt(customerDTO.getUtilizedThresholdAmt());
        customer.setCreatedDate(customerDTO.getCreatedDate());
        customer.setLastUpdatedDate(customerDTO.getLastUpdated());
        final Usr user = customerDTO.getUsr() == null ? null : userRepository.findById(customerDTO.getUsr())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
        customer.setUsr(user);
        return customer;
    }

}
