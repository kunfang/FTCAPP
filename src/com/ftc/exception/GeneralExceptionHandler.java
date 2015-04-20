package com.ftc.exception;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

import java.io.IOException;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.BatchUpdateException;

import com.ftc.constant.SystemMessage;


/**
 * Creation date: (2003-2-21)
 * @author: windy
 */

public class GeneralExceptionHandler {

  public static GeneralException handle(Throwable eThrow){
    return handle("",eThrow);
  }

  /**
    * 将Throwable转换为GeneralException
    * @param eThrow Throwable
    */
   public static GeneralException handle(String message,Throwable eThrow)
   {
        GeneralException eGenenal;
        Exception eExc;
        if (eThrow instanceof GeneralException)
        {
                eGenenal = (GeneralException) eThrow;
        }
        else if (eThrow instanceof ArrayIndexOutOfBoundsException)
        {
                eGenenal = new GeneralException(SystemMessage.ArrayIndexOutOfBoundsException);
        }
        else if (eThrow instanceof ArrayStoreException)
        {
                eGenenal = new GeneralException(SystemMessage.ArrayStoreException);
        }
        else if (eThrow instanceof ClassCastException)
        {
                eGenenal = new GeneralException(SystemMessage.ClassCastException);
        }
        else if (eThrow instanceof NumberFormatException)
        {
                eGenenal = new GeneralException(SystemMessage.NumberFormatException);
        }
        else if (eThrow instanceof NullPointerException)
        {
                eGenenal = new GeneralException(SystemMessage.NullPointerException);
        }
        else if (eThrow instanceof FileNotFoundException)
        {
                eGenenal = new GeneralException(SystemMessage.FileNotFoundException);
        }
        else if (eThrow instanceof IOException)
        {
                eGenenal = new GeneralException(SystemMessage.IOException);
        }
        else if (eThrow instanceof IndexOutOfBoundsException)
        {
                eGenenal = new GeneralException(SystemMessage.IndexOutOfBoundsException);
        }
        else if (eThrow instanceof ClassNotFoundException)
        {
                eGenenal = new GeneralException(SystemMessage.ClassNotFoundException);
        }
        else if (eThrow instanceof NoSuchMethodException)
        {
                eGenenal = new GeneralException(SystemMessage.NoSuchMethodException);
        }
        else if (eThrow instanceof SecurityException)
        {
                eGenenal = new GeneralException(SystemMessage.SecurityException);
        }
        else if (eThrow instanceof SQLException)
        {
                eGenenal = new GeneralException(SystemMessage.SQLException);
        }
        else if (eThrow instanceof SQLWarning)
        {
                eGenenal = new GeneralException(SystemMessage.SQLWarning,AbstractException.WARNING);
        }
        else if (eThrow instanceof BatchUpdateException)
        {
                eGenenal = new GeneralException(SystemMessage.BatchUpdateException);
        }
        else
        {
                eGenenal = new GeneralException(SystemMessage.UnkownException);
        }

        return eGenenal;
   }


   /**
    * 检测GeneralException的错误级别，IsSevere()检测严重级别
    * @param exception GeneralException
    */
   public static boolean IsSevere(GeneralException exception){
        return (exception.getErrorLevel() == AbstractException.ERROR);
   }

   /**
    * 检测GeneralException的错误级别，IsWarning()检测警告级别
    * @param exception GeneralException
    */
   public static boolean IsWarning(GeneralException exception)
   {
        return (exception.getErrorLevel() == AbstractException.WARNING);
   }


}
