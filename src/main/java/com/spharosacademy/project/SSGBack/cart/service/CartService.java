package com.spharosacademy.project.SSGBack.cart.service;

import com.spharosacademy.project.SSGBack.cart.dto.Output.OrderStockOutputDto;
import com.spharosacademy.project.SSGBack.cart.dto.input.CartUpdateRequestDto;
import com.spharosacademy.project.SSGBack.cart.entity.Cart;
import com.spharosacademy.project.SSGBack.cart.dto.Output.CartOutputDto;
import com.spharosacademy.project.SSGBack.cart.dto.input.CartInputDto;
import com.spharosacademy.project.SSGBack.cart.dto.input.CartOrderRequestDto;
import com.spharosacademy.project.SSGBack.product.option.dto.output.ColorOutputDto;
import com.spharosacademy.project.SSGBack.product.option.dto.output.OptionOutputDto;
import com.spharosacademy.project.SSGBack.product.option.dto.output.SizeOutputDto;
import com.spharosacademy.project.SSGBack.product.option.entity.OptionList;

import java.util.List;

public interface CartService {

    Cart addProductToCart(CartInputDto cartInputDto, Long userId);

    List<CartOutputDto> getAllCart();

    List<CartOutputDto> getCartByUserId(Long userId);

    List<CartOutputDto> deleteCart(Long cartId, Long userId);

    List<OrderStockOutputDto> orderCart(CartOrderRequestDto cartOrderRequestDto, Long userId);

    void updateCart(CartUpdateRequestDto cartUpdateRequestDto);

    List<ColorOutputDto> getColorByCart(Long cartId);

    List<SizeOutputDto> getSizeByCart(Long cartId, Long colorId);

    void incQty(Long id, Long userId);

    void decQty(Long id, Long userId);
}
