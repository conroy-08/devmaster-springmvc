package com.shopping.service;

import java.util.List;

import com.shopping.dto.CartInfoDTO;
import com.shopping.dto.OrderDTO;

public interface IOrderService {
   void saveOrder(CartInfoDTO cartInfo);
   List<OrderDTO> getAll();
}
