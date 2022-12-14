package com.spharosacademy.project.SSGBack.wishlist.service.impl;

import com.spharosacademy.project.SSGBack.product.entity.Product;
import com.spharosacademy.project.SSGBack.product.repo.ProductRepository;
import com.spharosacademy.project.SSGBack.review.dto.output.ReviewTotalDto;
import com.spharosacademy.project.SSGBack.review.repo.ReviewRepository;
import com.spharosacademy.project.SSGBack.user.entity.User;
import com.spharosacademy.project.SSGBack.user.repo.UserRepository;
import com.spharosacademy.project.SSGBack.wishlist.dto.output.ResponseWishListDto;
import com.spharosacademy.project.SSGBack.wishlist.entity.WishList;
import com.spharosacademy.project.SSGBack.wishlist.service.WishListService;
import com.spharosacademy.project.SSGBack.wishlist.dto.input.RequestWishListDto;
import com.spharosacademy.project.SSGBack.wishlist.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishListServiceImplement implements WishListService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final WishListRepository wishListRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public void addProduct(RequestWishListDto requestWishListDto, Long userId) {
        Optional<Product> product = productRepository.findById(requestWishListDto.getProductId());
        Optional<User> user = userRepository.findById(userId);

        if (product.isPresent() && user.isPresent()) {
            if (wishListRepository.findByUserIdAndProductId(userId, requestWishListDto.getProductId()) == null) {
                wishListRepository.save(WishList.builder()
                        .product(product.get())
                        .user(user.get())
                        .build());
            }

        }
    }

    @Override
    public List<ResponseWishListDto> findProductById(Long userid) {
        List<WishList> wishLists = wishListRepository.findByUserId(userid);
        List<ResponseWishListDto> responseWishListDtos = new ArrayList<>();

        for (WishList wishList : wishLists) {
            responseWishListDtos.add(ResponseWishListDto.builder()
                    .productId(wishList.getProduct().getId())
                    .productName(wishList.getProduct().getName())
                    .newPrice(wishList.getProduct().getNewPrice())
                    .oldPrice(wishList.getProduct().getOldPrice())
                    .wishId(wishList.getId())
                    .reviewTotalDto(reviewRepository.collectByProductId(wishList.getProduct().getId()))
                    .brand(wishList.getProduct().getBrand())
                    .mallTxt(wishList.getProduct().getMallText())
                    .priceTxt(wishList.getProduct().getPriceText())
                    .thumbnailImgUrl(wishList.getProduct().getThumbnailUrl())
                    .build());
        }
        return responseWishListDtos;
    }

    @Override
    public void deleteWishList(Long wishListId) {
        wishListRepository.deleteById(wishListId);
    }


}
