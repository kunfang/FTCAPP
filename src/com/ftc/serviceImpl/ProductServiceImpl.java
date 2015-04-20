package com.ftc.serviceImpl;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ftc.dao.DefaultDAO;
import com.ftc.service.ProductService;
import com.ftc.vo.CategoryVO;
import com.ftc.vo.FileVO;
import com.ftc.vo.ProductPageVO;
import com.ftc.vo.ProductVO;
import com.ftc.vo.StatusVO;

@Service("productService") 
public class ProductServiceImpl implements ProductService {
	private static final Logger logger = Logger.getLogger(ProductServiceImpl.class);
	
	@Resource
	private DefaultDAO dao;
	public DefaultDAO getDao() {
		return dao;
	}
	public void setDao(DefaultDAO dao) {
		this.dao = dao;
	}

	public List<ProductVO> queryListOfProdInfo(ProductVO pvo) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("queryListOfProdInfo(ProductVO cfg) - start"); //$NON-NLS-1$
		}
		String sqlWhere="";
		if(pvo.getProdName()!=null && !"".equals(pvo.getProdName())){
			sqlWhere=" and a.productname like '%"+pvo.getProdName().trim()+"%'";
		}
		else if(pvo.getCategoryId()!=null && !"".equals(pvo.getCategoryId()) && !pvo.getCategoryId().equals("0")){
			sqlWhere=" and a.categoryid="+pvo.getCategoryId();
		}
		
		int totalCount = dao.doTotalPageCount("product.getTotalCount", sqlWhere);
		List<ProductVO> list = dao.toList("product.getProductByAll", sqlWhere);
		
		if (logger.isDebugEnabled()) {
			logger.debug("queryListOfProdInfo(ProductVO cfg) - end"); //$NON-NLS-1$
		}
		return list;
	}

	
	@Override
	public List<CategoryVO> getAllCategory() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("getAllCategory() - start"); //$NON-NLS-1$
		}
		List<CategoryVO> catelist =dao.toList("category.getCateByPcode","");
		
		if (logger.isDebugEnabled()) {
			logger.debug("getAllCategory() - end"); //$NON-NLS-1$
		}
		return catelist;
	}
	
	@Override
	public void deleteProdById(ProductVO pvo) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("deleteProdById(ProductVO) - start"); //$NON-NLS-1$
		}
		ProductVO pro=(ProductVO)dao.toView("product.toList", pvo);
		if(pro!=null){
			try {
				dao.startTransaction();
				FileVO fileVO=new FileVO();
				fileVO.setFileId(pro.getPicture());
				dao.doDelete("fileVo.doProdDelete", fileVO);
				dao.doDelete("product.doProdDelete", pro);
			} catch (Exception e) {
				dao.endTransaction();
				e.printStackTrace();
			}finally{
				dao.commitTransation();
			}
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("deleteProdById(ProductVO) - end"); //$NON-NLS-1$
		}
		
	}
	
	@Override
	public ProductPageVO queryProductByPid(String productId) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("queryProductByPid(ProductVO) - start"); //$NON-NLS-1$
		}
		
		String sqlWhere="";
		if(productId!= null && !"".equals(productId) ){
			sqlWhere=" and a.productid ="+productId;
		}
		
		ProductPageVO pPageVo=(ProductPageVO)dao.toView("product.getProductByAll",sqlWhere);
		if (logger.isDebugEnabled()) {
			logger.debug("queryProductByPid(ProductVO) - end"); //$NON-NLS-1$
		}
		return pPageVo;
	}
	@Override
	public List<StatusVO> getStatusnameByType(String type) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("getStatusnameByType(String) - start"); //$NON-NLS-1$
		}
		StatusVO statusVO=new StatusVO();
		statusVO.setCategory(type);
		List<StatusVO> statusList =dao.toList("category.getStatusByType", statusVO);
		if (logger.isDebugEnabled()) {
			logger.debug("getStatusnameByType(String) - end"); //$NON-NLS-1$
		}
		return statusList;
	}
	
	@Override
	public void insertProduct(ProductPageVO productPageVO) throws Exception {
			if (logger.isDebugEnabled()) {
				logger.debug("insertProduct(ProductPageVO) - start"); //$NON-NLS-1$
			}
				try {
				     dao.startTransaction();
					 FileVO fileVO=new FileVO();
					 fileVO.setFileName("1234");
					 fileVO.setFileType(productPageVO.getFileType());
					 fileVO.setBeginDate(productPageVO.getBeginDate());
					 fileVO.setEndDate(productPageVO.getEndDate());
					 fileVO.setSize("10");
					 fileVO.setStatus(productPageVO.getStatus());
					 fileVO.setFileUrl("E:/upload/");
					 dao.doInsertResult("fileVo.doInsert", fileVO);
	                   List<FileVO> fileList=(List<FileVO>)dao.toList("fileVo.toFile", fileVO);
	                       if(fileList.size()>0){
								ProductVO product =new ProductVO();
								product.setProdName(productPageVO.getProdName());
								product.setPrice(productPageVO.getPrice());
								product.setStorePrice(productPageVO.getStorePrice());
								product.setCategoryId(productPageVO.getCategoryId());
								product.setPicture(fileList.get(0).getFileId());
								product.setTimeConsume(productPageVO.getTimeConsume());
								product.setTimeKeep(productPageVO.getTimeKeep());
								product.setComments(productPageVO.getComments());
								dao.doInsert("product.doInsert", product);
	                       }
	                       
				} catch (Exception e) {
					dao.endTransaction();
					e.printStackTrace();
				}finally{
					dao.commitTransation();
				}
			if (logger.isDebugEnabled()) {
				logger.debug("insertProduct(ProductPageVO) - end"); //$NON-NLS-1$
			}
		
	}
	

	@Override
	public void updateProduct(ProductPageVO productPageVO) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("updateProduct(ProductPageVO) - start"); //$NON-NLS-1$
		}
		try {
				dao.startTransaction();
				FileVO fileVo=new FileVO();
				fileVo.setFileId(productPageVO.getPicture().replace(",", ""));
				fileVo.setFileName("12323");
				fileVo.setFileType(productPageVO.getFileType());
				fileVo.setFileUrl("D://upload//");
				fileVo.setSize("11");
				fileVo.setStatus(productPageVO.getStatus());
				fileVo.setBeginDate(productPageVO.getBeginDate());
				fileVo.setEndDate(productPageVO.getEndDate());
				
				dao.doUpdate("fileVo.doUpdate", fileVo);
				
				ProductVO productVO=new ProductVO();
				productVO.setProductid(productPageVO.getProductid());
				productVO.setProdName(productPageVO.getProdName());
				productVO.setPrice(productPageVO.getPrice());
				productVO.setStorePrice(productPageVO.getStorePrice());
				productVO.setTimeConsume(productPageVO.getTimeConsume());
				productVO.setTimeKeep(productPageVO.getTimeKeep());
				productVO.setPicture(productPageVO.getPicture().replace(",", ""));
				productVO.setCategoryId(productPageVO.getCategoryId());
				productVO.setComments(productPageVO.getComments());
				
				dao.doUpdate("product.doUpdate", productVO);
				dao.commitTransation();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dao.endTransaction();
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("updateProduct(ProductPageVO) - end"); //$NON-NLS-1$
		}
		
	}
	
	@Override
	public ProductPageVO queryProductByPid(ProductPageVO productPageVO)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("queryProductByPid(ProductPageVO) - start"); //$NON-NLS-1$
		}
		String sqlWhere="";
		ProductPageVO result =new ProductPageVO();
		if(productPageVO.getProductid()!=null && !"".equals(productPageVO.getProductid())){
			sqlWhere=" and a.productid ="+productPageVO.getProductid().trim();
		}
		List<ProductPageVO> list = dao.toList("product.getProductByAll", sqlWhere);
		if(list.size()>0){
			result=list.get(0);
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("queryProductByPid(ProductPageVO) - end"); //$NON-NLS-1$
		}
		return result;
	}


}
