package app.controllers;

import app.entities.Bottom;
import app.entities.Cart;
import app.entities.Topping;
import app.entities.User;
import app.persistence.ConnectionPool;
import app.persistence.CupcakeMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.sql.SQLException;

public class OrderController {

    public static void addRoutes(Javalin app, ConnectionPool connectionPool) {
        app.post("additem", ctx -> addItem(ctx, connectionPool));
        //app.post("checkout", ctx -> checkout(ctx, connectionPool));
        app.get("payment", ctx ->completePayment(ctx));
        app.get("/shop", ctx -> ctx.render("order.html"));
    }

    private static void addItem(Context ctx, ConnectionPool connectionPool) {
        try {
            int toppingId = Integer.parseInt(ctx.formParam("topping"));
            int bottomId = Integer.parseInt(ctx.formParam("bottom"));
            int quantity = Integer.parseInt(ctx.formParam("quantity"));

            User user = ctx.sessionAttribute("currentUser");
            if (user != null) {
                Topping topping = CupcakeMapper.getToppingById(toppingId, connectionPool);
                Bottom bottom = CupcakeMapper.getBottomById(bottomId, connectionPool);

                Cart cart = ctx.sessionAttribute("cart");
                if (cart == null) {
                    cart = new Cart();
                }
                cart.addItem(topping, bottom, quantity);
                ctx.sessionAttribute("cart", cart);
                ctx.render("cart.html");
            } else {
                ctx.redirect("/login");
            }
        } catch (NumberFormatException e) {
            ctx.attribute("error", "Invalid input format. Please try again.");
            ctx.redirect("/order");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void completePayment(Context ctx) {
        String cardName = ctx.formParam("cardname");
        String cardNumber = ctx.formParam("cardnumber");
        String expDate = ctx.formParam("expdate");
        String cvvNumber = ctx.formParam("cvv");

        if(cardName.isEmpty() | cardNumber.isEmpty() | expDate.isEmpty() | cvvNumber.isEmpty()) {
            ctx.attribute("message", "You must fill in all fields!");
            ctx.render("/");

        } else {
            ctx.attribute("message", "Your payment is complete!");
            ctx.redirect("order.html");
        }
    }
}