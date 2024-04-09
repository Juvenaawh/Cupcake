package app.controllers;

import app.entities.User;
import app.exceptions.DatabaseException;
import app.persistence.ConnectionPool;
import app.persistence.UserMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class UserController {

    public static void addRoutes (Javalin app, ConnectionPool connectionPool){
        app.post("login", ctx -> login(ctx, connectionPool));
        app.get("logout", ctx -> logout(ctx));
        app.get("register", ctx -> ctx.render("register.html"));
        app.post("register", ctx -> createUser(ctx, connectionPool));
    }

    private static void createUser(Context ctx, ConnectionPool connectionPool){
        // Hent form parametre
        String firstname = ctx.formParam("firstname");
        String lastname = ctx.formParam("lastname");
        String username = ctx.formParam("username");
        String password1 = ctx.formParam("password1");
        String password2 = ctx.formParam("password2");
        String email = ctx.formParam("email");

        if(password1.equals(password2)){
            try {
                UserMapper.createUser(firstname, lastname, username, password1, email, connectionPool);
                ctx.attribute("message", "Du er hermed oprettet med brugernavn: " + username +
                        ". Nu kan du logge på.");
                ctx.render("index.html");

            } catch (DatabaseException e) {
                ctx.attribute("message", "Det brugernavn findes allerede. Prøv igen, eller log ind.");
                ctx.render("register.html");
            }
        } else {
            ctx.attribute("message", "Dine to passwords er ikke ens! Prøv igen.");
            ctx.render("register.html");
        }
    }

    private static void logout(Context ctx) {
        ctx.req().getSession().invalidate();
        ctx.redirect("/");
    }

    public static void login (Context ctx, ConnectionPool connectionPool){
        // Hent form parametre
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");

        // Tjek om bruger findes i DB med de angivne username + password
        try {
            User user = UserMapper.login(username, password, connectionPool);
            ctx.sessionAttribute("currentUser", user);

            // Hvis ja, Send videre til order siden
            ctx.render("order.html");

        } catch (DatabaseException e) {
            // Hvis nej, send tilbage til login side med fejl besked
            ctx.attribute("message", e.getMessage());
            ctx.render("index.html");
        }
    }

}
