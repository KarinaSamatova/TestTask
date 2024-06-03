package APITests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class FakeStoreTests {

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI="https://fakestoreapi.com";
    }

    private Product getTestProduct(){
        return Product.builder()
                .title("testTitle")
                .price(5900)
                .description("bag")
                .image("first")
                .category("bags")
                .build();
    }

    @Test
    public void authUserTest(){
        Map<String, String> userAuth = new HashMap<>();
        userAuth.put("username", "mor_2314");
        userAuth.put("password", "83r5^_");
        given().contentType(ContentType.JSON)
                .body(userAuth)
                .post("/auth/login")
                .then().log().all()
                .statusCode(200)
                .body("token", notNullValue());
    }

    @Test
    public void getAllProductsTest(){
        given().get("/products")
                .then()
                .log().all()
                .statusCode(200);
    };

    @Test
    public void getSingleProductTest(){
        int productId = 5;
        given().pathParam("productId", productId)
                .get("/products/{productId}")
                .then().log().all()
                .statusCode(200)
                .body("id", equalTo(productId));
    }

    @Test
    public void getSingleProductNegativeTest(){
        int productId = 5645;
        given().pathParam("productId", productId)
                .get("/products/{productId}")
                .then().log().all()
                .statusCode(404)
                .body("error", equalTo("Product not found"));
    }

    @Test
    public void addNewProductTest(){
        Product product = getTestProduct();

        given().body(product)
                .post("/products")
                .then().log().all()
                .statusCode(200)
                .body("id", notNullValue());
    }

    @Test
    public void addNewProductNegativeTest(){
        Product product = getTestProduct();

        given().body(product)
                .post("/products")
                .then().log().all()
                .statusCode(404)
                .body("error", equalTo("Price is required"));
    }

    @Test
    public void invalidJSONRequestNegativeTest(){
        String invalidJson = "{ \"name\": \"Invalid JSON\" }";

        given().body(invalidJson)
                .post("/products")
                .then().log().all()
                .statusCode(400)
                .body("error", equalTo("BadRequest"));
    }

    @Test
    public void updateProductTest(){
        Product product = getTestProduct();
        Integer oldPrice = (Integer) product.getPrice();

        product.setPrice(6500);
        given().body(product)
                .put("/products/" + product.getId())
                .then().log().all()
                .body("price", not(equalTo(oldPrice)));
    }

    @Test
    public void deleteProductTest(){
        int productId = 6;
        given().pathParam("productId", productId)
                .delete("/products/{productID}")
                .then().log().all()
                .statusCode(200);

        given().pathParam("productId", productId)
                .get("/products/{productId}")
                .then().log().all()
                .statusCode(404)
                .body("error", equalTo("Product not found"));
    }
}
