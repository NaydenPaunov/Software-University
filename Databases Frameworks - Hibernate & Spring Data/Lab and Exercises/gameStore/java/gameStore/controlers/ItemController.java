package gameStore.controlers;

import gameStore.AuthenticationContext;
import gameStore.Cart;
import gameStore.models.Game;
import gameStore.services.api.GameService;
import gameStore.services.api.OrderService;

public class ItemController {
    private OrderService orderService;
    private GameService gameService;
    private AuthenticationContext authenticationContext;
    private Cart cart;

    public ItemController(OrderService orderService, GameService gameService,
                          AuthenticationContext authenticationContext) {
        this.orderService = orderService;
        this.gameService = gameService;
        this.authenticationContext = authenticationContext;
    }

    public String add(String title){
        if(cart == null){
            this.cart = new Cart();
        }
        if(!this.gameService.checkIfGameExists(title)){
            return "Game does not exists!";
        }
        Game game = this.gameService.findGameByTitle(title);
        this.cart.addItem(game);
        return "Game added successfully!";
    }

    public String remove(String title){
        if(cart == null){
            return "Do not have items it the card";
        }
        if(!this.gameService.checkIfGameExists(title)){
            return "Game does not exists!";
        }
        this.cart.removeItems(title);
        return "Game removed successfully!";

    }

    public String buy(){
        try {
            this.orderService.buyItems(this.cart.getItems(),
                    this.authenticationContext.getLoggedInUser().getEmail());
        }catch (Exception e){
            return e.getMessage();
        }
        return "Successfully bought!";
    }
}
