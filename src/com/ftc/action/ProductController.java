package com.ftc.action;
/**
 *@author     [RoseJiang]
 *@version     [1.0]
 *@createdate  [2015-04-09]
 *@since       [产品信息展示,产品新增,产品修改和产品删除]
 *@description  [产品信息展示,产品新增,产品修改和产品删除]
 */
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ftc.service.ProductService;
import com.ftc.vo.CategoryVO;
import com.ftc.vo.ProductPageVO;
import com.ftc.vo.ProductVO;
import com.ftc.vo.StatusVO;
@Controller("productController")
@RequestMapping("/productlist.do")
public class ProductController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ProductController.class);
	
	@Resource
	private ProductService productService;
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
    
	/**
     *@param  [ProductVO,Model] [查询条件信息,对象绑定]
     *@return  [返回需要跳转的页面名称]
     *@description [产品清单]
     */
	@RequestMapping(params="method=getProductbyList") 
	public String getProductbyList(ProductVO productVo,Model model) {
		if (logger.isDebugEnabled()) {
			logger.debug("getProductbyList(ProductVO) - start"); //$NON-NLS-1$
		}
		try {
			List<CategoryVO> cateList =productService.getAllCategory();//获取所有的产品类型
			List<ProductVO> list=productService.queryListOfProdInfo(productVo);
			model.addAttribute("prodList",list);
			model.addAttribute("cateList",cateList);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorInfo","Login Error!!!");
		} 
		
		if (logger.isDebugEnabled()) {
			logger.debug("getProductbyList(ProductVO) - end"); //$NON-NLS-1$
		}
		return "product/productAllList";  
	}
	
	/**
     *@param  [ProductVO,Model] [产品信息,对象绑定]
     *@return  [返回需要跳转的页面名称]
     *@description [产品删除]
     */
	@RequestMapping(params="method=toprodDelete") 
	public String toprodDelete(ProductVO productVo,Model model){
		if (logger.isDebugEnabled()) {
			logger.debug("toprodDelete(ProductVO,Model) - start"); //$NON-NLS-1$
		}
		try {
			productService.deleteProdById(productVo);
			this.getProductbyList(productVo, model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("toprodDelete(ProductVO,Model) - end"); //$NON-NLS-1$
		}
		return "product/productAllList";
	}
	
	/**
     *@param  [ProductVO,Model] [产品信息,对象绑定]
     *@return  [返回需要跳转的页面名称]
     *@description [产品查看]
     */
	@RequestMapping(params="method=toView") 
	public String toView(ProductVO productVo,Model model){
		if (logger.isDebugEnabled()) {
			logger.debug("toView(ProductVO,Model) - start"); //$NON-NLS-1$
		}
		String result="";
		try {
			ProductPageVO pPageVO=productService.queryProductByPid(productVo.getProductid());
			model.addAttribute("productPageVO", pPageVO);
			result="product/productView";
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("toView(ProductVO,Model) - end"); //$NON-NLS-1$
		}
		return result;
	}
	
	/**
     *@param  [ProductPageVO,Model] [产品信息,对象绑定]
     *@return  [返回需要跳转的页面名称]
     *@description [产品新增]
     */
	@RequestMapping(params="method=toInsertProduct") 
	public String toInsertProduct(ProductPageVO productPageVo,ProductVO productVo,Model model){
		if (logger.isDebugEnabled()) {
			logger.debug("toInsertProduct(ProductVO,Model) - start"); //$NON-NLS-1$
		}
		String result="";
		try {
			if(productPageVo.getProdName()!=null && !"".equals(productPageVo.getProdName())){
				productService.insertProduct(productPageVo);
				productVo.setProdName("");
				productVo.setCategoryId("0");
				this.getProductbyList(productVo, model);
				result="product/productAllList";
			}else{
				List<StatusVO> fileStatus= productService.getStatusnameByType("FileStatus");
				List<StatusVO> fileType=productService.getStatusnameByType("FileType");
				List<CategoryVO> cateList =productService.getAllCategory();//获取所有的产品类型
				model.addAttribute("fileStatus", fileStatus);
				model.addAttribute("fileType",fileType);
				model.addAttribute("cateList",cateList);
				result="product/productInsert";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("toInsertProduct(ProductVO,Model) - end"); //$NON-NLS-1$
		}
		return result;
	}
	
	/**
     *@param  [ProductPageVO,Model] [产品信息,对象绑定]
     *@return  [返回需要跳转的页面名称]
     *@description [产品查看(修改)]
     */
	@RequestMapping(params="method=selectProductForUpdate") 
	public String selectProductForUpdate(ProductPageVO productPageVo,Model model){
		if (logger.isDebugEnabled()) {
			logger.debug("selectProductForUpdate(ProductPageVO) - start"); //$NON-NLS-1$
		}
		try {
			List<StatusVO> fileStatus= productService.getStatusnameByType("FileStatus");
			List<StatusVO> fileType=productService.getStatusnameByType("FileType");
			List<CategoryVO> cateList =productService.getAllCategory();//获取所有的产品类型
			ProductPageVO result =productService.queryProductByPid(productPageVo);
			model.addAttribute("fileStatus", fileStatus);
			model.addAttribute("fileType",fileType);
			model.addAttribute("cateList",cateList);
			model.addAttribute("productPageVO",result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("selectProductForUpdate(ProductPageVO) - end"); //$NON-NLS-1$
		}
		return "product/productInsert";
	}
	
	/**
     *@param  [ProductPageVO,Model] [产品信息,对象绑定]
     *@return  [返回需要跳转的页面名称]
     *@description [产品修改]
     */
	@RequestMapping(params="method=toUpdateProduct") 
	public String toUpdateProduct(ProductPageVO productPageVo,Model model,HttpServletRequest request){
		if (logger.isDebugEnabled()) {
			logger.debug("toUpdateProduct(ProductPageVO,Model,HttpServletRequest) - start"); //$NON-NLS-1$
		}
		
		try {
			productService.updateProduct(productPageVo);
			request.setAttribute("msg", "保存产品信息成功");
			request.setAttribute("code", "0");
		} catch (Exception e) {
			request.setAttribute("msg", "保存产品信息失败");
			request.setAttribute("code", "1");
			e.printStackTrace();
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("toUpdateProduct(ProductPageVO,Model,HttpServletRequest) - end"); //$NON-NLS-1$
		}
		return "product/showmsg";
	}

	
}