package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entity.OrderDetailsEntity;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity, Long> {

}
