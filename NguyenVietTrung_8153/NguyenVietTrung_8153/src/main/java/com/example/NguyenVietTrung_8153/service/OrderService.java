package com.example.NguyenVietTrung_8153.service;

import com.example.NguyenVietTrung_8153.model.CartItem;
import com.example.NguyenVietTrung_8153.model.Order;
import com.example.NguyenVietTrung_8153.model.OrderDetail;
import com.example.NguyenVietTrung_8153.repository.OrderDetailRepository;
import com.example.NguyenVietTrung_8153.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private CartService cartService; // Assuming you have a CartService
    @Transactional
    public Order createOrder(String customerName, List<CartItem> cartItems) {
        Order order = new Order();
        order.setCustomerName(customerName);
        order = orderRepository.save(order);
        for (CartItem item : cartItems) {
            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);
            detail.setProduct(item.getProduct());
            detail.setQuantity(item.getQuantity());
            orderDetailRepository.save(detail);
        }
        cartService.clearCart();
        return order;
    }
}
