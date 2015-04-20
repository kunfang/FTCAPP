package com.ftc.exception;

/**
 * <p>Title:一般的例外 </p>
 * <p>Description: GeneralException是AbstractException的子类</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * @author 
 * @version 1.0
 */

public class GeneralException extends AbstractException{

  /**
   * 构造函数
   * @param errorCode 错误代码
   */
  public GeneralException(String errorCode) {
    super(errorCode);
  }

  /**
   * 构造函数
   * @param errorCode 错误代码
   * @param errorLevle 错误级别
   */
  public GeneralException(String errorCode,
                          String errorLevel) {
    super(errorCode, errorLevel);
  }

  /**
   * 构造函数
   * @param errorCode 错误代码
   * @param errorModel 错误模块
   * @param errorLevle 错误级别
   */
  public GeneralException(String errorCode,
                          String errorModel,
                          String errorLevel) {
    super(errorCode, errorModel, errorLevel);
  }

  /**
   * 构造函数
   * @param errorCode 错误代码
   * @param errorDescription 错误描述
   * @param errorModel 错误模块
   * @param errorLevle 错误级别
   */
  public GeneralException(String errorCode,
                          String errorDescription,
                          String errorModel,
                          String errorLevel) {
    super(errorCode, errorDescription, errorModel, errorLevel);
  }
}