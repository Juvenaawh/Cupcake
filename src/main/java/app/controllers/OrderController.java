package app.controllers;

import app.entities.User;
import app.exceptions.DatabaseException;
import app.persistence.CartMapper;
import app.persistence.ConnectionPool;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

public class OrderController {

    public static void addRoutes(Javalin app, ConnectionPool connectionPool) {
        //app.post("additem", ctx -> addItem(ctx, connectionPool));
        //app.post("checkout", ctx -> checkout(ctx, connectionPool));
        app.get("payment", ctx ->completePayment(ctx));
    }

    /*private static void addItem(Context ctx, ConnectionPool connectionPool) {
        try {
            int userId = Integer.parseInt(ctx.formParam("userId"));
            int toppingId = Integer.parseInt(ctx.formParam("top-id"));
            int bottomId = Integer.parseInt(ctx.formParam("bot-id"));
            int quantity = Integer.parseInt(ctx.formParam("quantity"));

            User user = ctx.sessionAttribute("currentUser");
            if (user != null) {
                CartMapper.addItem(user.getId(userId), bottomId, toppingId, quantity, connectionPool);
                ctx.redirect("/cart");
            } else {
                ctx.redirect("/login");
            }
        } catch (NumberFormatException e) {
            ctx.attribute("error", "Invalid input format. Please try again.");
            ctx.redirect("/order");
        } catch (DatabaseException e) {
            ctx.attribute("error", "Database error: " + e.getMessage());
            ctx.redirect("/order");
        }
    }*/

    /*public static void checkout(Context ctx, ConnectionPool connectionPool) {
        User user = ctx.sessionAttribute("currentUser");

        try {
            if (user == null) {
                ctx.attribute("error", "Du skal være logget ind for at gennemføre købet.");
                ctx.redirect("/login");
                return;
            }
            int orderId = CartMapper.createOrder(user.getUserId(), connectionPool);
            CartMapper.saveOrderItems(orderId, user.getUserId(), connectionPool);
            CartMapper.clearCart(user.getUserId(), connectionPool);
            ctx.sessionAttribute("cart", null);
            ctx.redirect("/order_success");
        } catch (DatabaseException e) {
            ctx.attribute("error", "Der opstod en fejl under oprettelsen af din bestilling: " + e.getMessage());
            ctx.redirect("/checkout_error");
        }
    }*/

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