package com.geekbrains.springbootproject.AOP;

import com.geekbrains.springbootproject.utils.ShoppingCart;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CartAspect {

    private ShoppingCart shoppingCart;

    @Autowired
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Before("execution(public void com.geekbrains.springbootproject.utils.ShoppingCart.add(..))")
    public void tryAddProductInCart(){
        System.out.println("Попытка добавить товар в корзину");
    }
    @After("execution(public void com.geekbrains.springbootproject.utils.ShoppingCart.add(..))")
    public void fineshedAddProductInCart(){
        System.out.println("Товар добавлен");
        shoppingCart.recalculate();
    }

    // это на будущее. Пока в корзине не добавлена кнопка удаления товара во фронтенде.
    @Before("execution(public void com.geekbrains.springbootproject.utils.ShoppingCart.remove(..))")
    public void tryRemoveProductInCart(){
        System.out.println("Попытка удалить товар из корзины");
    }
    @After("execution(public void com.geekbrains.springbootproject.utils.ShoppingCart.remove(..))")
    public void fineshedRemoveProductInCart(){
        System.out.println("Товар удален");
        shoppingCart.recalculate();
    }

    @Before("execution(private void com.geekbrains.springbootproject.utils.ShoppingCart.recalculate())")
    public void tryRecalculate(){
        System.out.println("Попытка пересчитать общую стоимость");
    }
    @After("execution(private void com.geekbrains.springbootproject.utils.ShoppingCart.recalculate())")
    public void fineshedRecalculate(){
        shoppingCart.recalculate();
        System.out.println("Общая стоимость получена");
    }


}
