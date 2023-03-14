package com.srn.erp.stock.bm;

import com.srn.erp.general.bm.ComproCab;

import framework.request.bl.Utils.BaseException;

public interface IStockeable {
  public static final String ENTRADA = "ENTRADA";
  public static final String SALIDA  = "SALIDA";
  public ComproCab getComprobante() throws BaseException;
  public RenglonesStock getRenglonesStock() throws BaseException;
}
