package com.ftc.service;
import java.util.List;
import com.ftc.vo.CategoryVO;
import com.ftc.vo.ProductPageVO;
import com.ftc.vo.ProductVO;
import com.ftc.vo.StatusVO;

public interface ProductService {
	
    public List<ProductVO> queryListOfProdInfo(ProductVO pvo) throws Exception;
	
	public List<CategoryVO> getAllCategory() throws Exception;
	
	public void deleteProdById(ProductVO pvo) throws Exception;
	
	public ProductPageVO queryProductByPid(String productId) throws Exception;
	
	public List<StatusVO> getStatusnameByType(String type) throws Exception;
	
	public void insertProduct(ProductPageVO productPageVO) throws Exception;
	
    public void updateProduct(ProductPageVO productPageVO) throws Exception;
	
	public ProductPageVO queryProductByPid(ProductPageVO productPageVO) throws Exception;

}
