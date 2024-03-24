package functionalProgramming;

import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.ProductJpa;

import java.util.ArrayList;
import java.util.List;

public class StreamAPI {

    public static void main(String[] args) {

        List<ProductJpa> productList  = new ArrayList<>();

        ProductJpa product = new ProductJpa();
        product.setPrice(12.4);
        productList.add(product);


        ProductJpa product2 = new ProductJpa();
        product2.setPrice(12.4);
        productList.add(product2);

        ProductJpa product3 = new ProductJpa();
        product3.setPrice(12.4);
        productList.add(product3);

        MathFunction mathFunction = (value1 , value2 ) -> value1 * value2 ;
        int apply = mathFunction.apply(3,5);
        System.out.print(apply);


        }

    }



