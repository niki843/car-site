package com.carsite.carsite.respository;

import com.carsite.carsite.model.OrderGroup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Qualifier("OrderGroupRepository")
public interface OrderGroupRepository extends JpaRepository<OrderGroup, String> {

    Optional<OrderGroup> findById(@Param("orderGroupId") String orderGroupId);

}
