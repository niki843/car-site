package com.carsite.carsite.respository;

import com.carsite.carsite.model.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("OrderRepository")
public interface OrderRepository extends JpaRepository<Order, String> {


}
