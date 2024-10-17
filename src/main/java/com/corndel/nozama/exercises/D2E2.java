package com.corndel.nozama.exercises;

import io.javalin.Javalin;

public class D2E2 {
  /**
   * Creates a Javalin app with two endpoints:
   * <p>
   * - GET /sumup responds with the sum of the integers from 1 to n, where n is
   * provided as a query parameter. If n is not provided, it responds with 0.
   * <p>
   * - GET /multiply/{x}/{y} responds with the product of x and y.
   *
   * @return a configured Javalin instance
   * @see https://tech-docs.corndel.com/javalin/query-params.html
   * @see https://tech-docs.corndel.com/javalin/url-params.html
   */
  public static Javalin createApp() {
    var app = Javalin.create();
    app.get(
      "/sumup",
      ctx -> {
        if (ctx.queryParam("n") == null) {
          ctx.result("0");
          return;
        }
        int n = Integer.parseInt(ctx.queryParam("n"));
        int sum = 0;
        for (int i = 1; i < n + 1; i++) {
          sum += i;
        }
        ctx.result(Integer.toString(sum));
      });

    app.get(
      "/multiply/{x}/{y}",
      ctx -> {
        int x = Integer.parseInt(ctx.pathParam("x"));
        int y = Integer.parseInt(ctx.pathParam("y"));
        ctx.result(Integer.toString(x * y));
      });

    return app;
  }
}
