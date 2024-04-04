package edu.escuelaing.arep;

import static spark.Spark.*;

public class App {
    public static void main(String... args) {
        staticFiles.location("/public");
        port(getPort());
        get("hello", (req, res) -> "Hello Docker!");
        get("linealSearch", (req, res) -> HttpConection.invoke("linealSearch", req.queryParams("list"), req.queryParams("value")));
        get("binarySearch", (req, res) -> HttpConection.invoke("binarySearch", req.queryParams("list"), req.queryParams("value")));
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}

