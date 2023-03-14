package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.List;

import framework.request.bl.Utils.BaseException;

public class RenglonesStock {

  List renglones = new ArrayList();

  public RenglonesStock() {
  }

  public RenglonMovStock addRenglonMovStock() throws BaseException {
    RenglonMovStock renglonMovStock = new RenglonMovStock();
    renglones.add(renglonMovStock);
    return renglonMovStock;
  }

  public List getListaRenglones() throws BaseException {
    return renglones;
  }



}
