package com.ftc.jsonvo;

import org.apache.log4j.Logger;

import java.util.*;

import com.ftc.constant.*;
import com.ftc.exception.*;

import javax.servlet.http.*;

/**
 * <p>Title: 系统配置</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c)</p>
 * @author
 * @version 1.0
 */
public class SystemConfig {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SystemConfig.class);

  private ResourceBundle myResource = null;
  private String resourceName = null;
  public SystemConfig() {
    this.resourceName = "system";
  }

  public SystemConfig(String resourceName) {
    this.resourceName = resourceName;
  }

  private void getResourceBundle() throws GeneralException {
		if (logger.isDebugEnabled()) {
			logger.debug("getResourceBundle() - start"); //$NON-NLS-1$
		}

    try {
      myResource = ResourceBundle.getBundle(resourceName);
    }
    catch (Exception e) {
			logger.error("getResourceBundle()", e); //$NON-NLS-1$

      throw GeneralExceptionHandler.handle(e);
    }

		if (logger.isDebugEnabled()) {
			logger.debug("getResourceBundle() - end"); //$NON-NLS-1$
		}
  }
  //知识库
  public String getUploadPath() throws GeneralException {
		if (logger.isDebugEnabled()) {
			logger.debug("getUploadPath() - start"); //$NON-NLS-1$
		}

    try {
      if (myResource == null)
        getResourceBundle();
			String returnString = myResource.getString("uploadPath");
			if (logger.isDebugEnabled()) {
				logger.debug("getUploadPath() - end"); //$NON-NLS-1$
			}
      return returnString;
    }
    catch (Exception e) {
			logger.error("getUploadPath()", e); //$NON-NLS-1$

      throw GeneralExceptionHandler.handle(e);
    }
  }
  //版本
  public String getDirectoryPath() throws GeneralException {
		if (logger.isDebugEnabled()) {
			logger.debug("getDirectoryPath() - start"); //$NON-NLS-1$
		}

	    try {
	      if (myResource == null)
	        getResourceBundle();
			String returnString = myResource.getString("directoryPath");
			if (logger.isDebugEnabled()) {
				logger.debug("getDirectoryPath() - end"); //$NON-NLS-1$
			}
	      return returnString;
	    }
	    catch (Exception e) {
			logger.error("getDirectoryPath()", e); //$NON-NLS-1$

	      throw GeneralExceptionHandler.handle(e);
	    }
	  }
  /**
   * 理赔图片资料路径
   * @return
   * @throws GeneralException
   */
  public String getImageDataPath() throws GeneralException {
		if (logger.isDebugEnabled()) {
			logger.debug("getImageDataPath() - start"); //$NON-NLS-1$
		}

	    try {
	      if (myResource == null)
	        getResourceBundle();
			String returnString = myResource.getString("imageDataPath");
			if (logger.isDebugEnabled()) {
				logger.debug("getImageDataPath() - end"); //$NON-NLS-1$
			}
	      return returnString;
	    }
	    catch (Exception e) {
			logger.error("getImageDataPath()", e); //$NON-NLS-1$

	      throw GeneralExceptionHandler.handle(e);
	    }
	  }

  
  public String getUploadPathByCache(HttpServletRequest request) throws
      GeneralException {
		if (logger.isDebugEnabled()) {
			logger.debug("getUploadPathByCache(HttpServletRequest) - start"); //$NON-NLS-1$
		}

    try {
      Object obj = request.getSession().getServletContext().getAttribute(
          WebConstants.SYSTEM_PARAMETER);
			String returnString = ((Properties) obj).getProperty("uploadPath");
			if (logger.isDebugEnabled()) {
				logger.debug("getUploadPathByCache(HttpServletRequest) - end"); //$NON-NLS-1$
			}
      return returnString;
    }
    catch (Exception ex) {
			logger.error("getUploadPathByCache(HttpServletRequest)", ex); //$NON-NLS-1$

      throw GeneralExceptionHandler.handle(ex);
    }
  }

  /*  功能：获取配置得内部文件目录
   *  编写者：
   */
  public String getNbwjPath() throws GeneralException {
		if (logger.isDebugEnabled()) {
			logger.debug("getNbwjPath() - start"); //$NON-NLS-1$
		}

    try {
      if (myResource == null)
        getResourceBundle();
			String returnString = myResource.getString("intermanage.nbwj.path");
			if (logger.isDebugEnabled()) {
				logger.debug("getNbwjPath() - end"); //$NON-NLS-1$
			}
      return returnString;
    }
    catch (Exception e) {
			logger.error("getNbwjPath()", e); //$NON-NLS-1$

      throw GeneralExceptionHandler.handle(e);
    }

  }

  /*  功能：获取每页显示记录数
   *  编写者：
   */
  public String getRowsPerPage() throws GeneralException {
		if (logger.isDebugEnabled()) {
			logger.debug("getRowsPerPage() - start"); //$NON-NLS-1$
		}

    try {
      if (myResource == null)
        getResourceBundle();
			String returnString = myResource.getString("page.rowsPerPage");
			if (logger.isDebugEnabled()) {
				logger.debug("getRowsPerPage() - end"); //$NON-NLS-1$
			}
      return returnString;
    }
    catch (Exception e) {
			logger.error("getRowsPerPage()", e); //$NON-NLS-1$

      throw GeneralExceptionHandler.handle(e);
    }
  }

  /**
   * 获取外部资源定义的值
   * @param resourceName String  外部资源名称
   * @return String
   * @throws GeneralException
   */
  public String getResourceValue(String resourceName) throws GeneralException {
		if (logger.isDebugEnabled()) {
			logger.debug("getResourceValue(String) - start"); //$NON-NLS-1$
		}

    try {
      if (myResource == null)
        getResourceBundle();
			String returnString = myResource.getString(resourceName);
			if (logger.isDebugEnabled()) {
				logger.debug("getResourceValue(String) - end"); //$NON-NLS-1$
			}
      return returnString;
    }
    catch (Exception e) {
			logger.error("getResourceValue(String)", e); //$NON-NLS-1$

      throw GeneralExceptionHandler.handle(e);
    }
  }

  public static void main(String args[]) throws Exception {
//    SystemConfig fig = new SystemConfig();
//    Logger.getLogger(this.getClass()).info(fig.getRowsPerPage());
//    Logger.getLogger(this.getClass()).info("this.osName = " + fig.getResourceValue("osName"));
  }
}
