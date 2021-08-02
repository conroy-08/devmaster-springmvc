package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
