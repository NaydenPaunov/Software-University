package gameStore.services.impl;

import gameStore.models.Game;
import gameStore.models.Order;
import gameStore.repositories.OrderRepository;
import gameStore.services.api.OrderService;
import gameStore.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private UserService userService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    @Override
    public void buyItems(Collection<Game> products,String email) {
        Order order = new Order();
        order.setProducts(products);
        order.setBuyer(this.userService.getUserByEmail(email));
        this.orderRepository.save(order);
//        Set<Game> games = new HashSet<>();
//        games.addAll(products);
//        this.userService.getUserByEmail(email).setGames(games);
//        this.userService.setUserItemsByEmail(email,games);


    }
}
