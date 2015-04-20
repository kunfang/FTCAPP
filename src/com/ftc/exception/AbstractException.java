package com.ftc.exception;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * @author 
 * @version 1.0
 */

import com.ibm.hursley.asg.ws.skeleton.command.CommandException;

/**
 * AbstractException是一个异常类，将异常信息分为四部分：
 * errorCode	错误代码
 * errorDescription 错误描述
 * errorModel 错误发生的模块
 * errorLevel 错误级别，警告或错误
 * Creation date: (2003-2-21)
 * @author: windy
 */
public class AbstractException
    extends CommandException {

  /**
   * 静态常量，表示错误级别，ERROR表示错误，WARNING表示警告
   */
  public static final String ERROR = "ERROR";
  public static final String WARNING = "WARNING";

  /**
   * 错误信息定义
   */
  private String errorCode;
  private String errorDescription = "";
  private String errorModel = null;
  private String errorLevel = WARNING;

  /**
   * 返回错误代码
   * @return java.lang.String
   */
  public String getErrorCode() {
    return errorCode;
  }

  /**
   * 返回错误描述
   * @return java.lang.String
   */
  public String getErrorDescription() {
    return errorDescription;
  }

  /**
   * 返回错误的模块
   * @return java.lang.String
   */
  public String getErrorModel() {
    return errorModel;
  }

  /**
   * 返回错误级别
   * @return java.lang.String
   */
  public String getErrorLevel() {
    return errorLevel;
  }

  /**
   * 返回错误信息
   * @return java.lang.String
   */
  @Override
public String toString() {
    return "Error code:" + errorCode +
        " Error level:" + errorLevel +
        " Error model:" + errorModel +
        " Error description:" + errorDescription;
  }

  /**
   * 构造函数
   * @param errorCode 错误代码
   */
  public AbstractException(String errorCode) {
    super(errorCode);
    this.errorCode = errorCode;
  }

  /**
   * 构造函数
   * @param errorCode 错误代码
   * @param errorLevle 错误级别
   */
  public AbstractException(String errorCode,
                           String errorLevel) {
    super(errorCode);
    this.errorCode = errorCode;
    this.errorLevel = errorLevel;
  }

  /**
   * 构造函数
   * @param errorCode 错误代码
   * @param errorModel 错误模块
   * @param errorLevle 错误级别
   */
  public AbstractException(String errorCode,
                           String errorModel,
                           String errorLevel) {
    super(errorCode);
    this.errorCode = errorCode;
    this.errorModel = errorModel;
    this.errorLevel = errorLevel;
  }

  /**
   * 构造函数
   * @param errorCode 错误代码
   * @param errorDescription 错误描述
   * @param errorModel 错误模块
   * @param errorLevle 错误级别
   */
  public AbstractException(String errorCode,
                           String errorDescription,
                           String errorModel,
                           String errorLevel) {
    super(errorCode);
    this.errorCode = errorCode;
    this.errorDescription = errorDescription;
    this.errorModel = errorModel;
    this.errorLevel = errorLevel;
  }
}
