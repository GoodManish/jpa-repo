package io.bootify.jpa_project.repos;

import io.bootify.jpa_project.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Transactional
    @Query("select c from Customer c where c.custId=:custId")
    Customer findByCustId(@Param("custId") Long custId);

//    @Transactional
//    @Query("select new com.example.demo.Customer(c.custId, c.thresholdAmt ,c.utilizedThresholdAmt) from Customer c where c.custId=:custId")
//    List<Customer> getCustWithProjection(@Param("custId") Long custId);

//    @Query("SELECT new com.thorben.janssen.spring.jpa.projections.dto.AuthorSummaryDTO(a.firstName, a.lastName) FROM Author a WHERE a.firstName = :firstName")
//    List<AuthorSummaryDTO> findByFirstName(String firstName);


}
