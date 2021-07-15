package com.project.simple.cart.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.project.simple.cart.vo.CartVO;
import com.project.simple.product.vo.ProductVO;

public interface CartDAO {

	public List<CartVO> selectCartList(CartVO cartVO) throws DataAccessException;

	public List<ProductVO> selectProductList(List<CartVO> cartList) throws DataAccessException;

    public boolean selectCountInCart(CartVO cartVO) throws DataAccessException;
    
	public void insertProductInCart(CartVO cartVO) throws DataAccessException;

	public void deleteCartProduct(String productNum) throws DataAccessException;

	

}
