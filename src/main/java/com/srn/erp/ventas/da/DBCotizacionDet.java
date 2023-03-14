package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.ventas.bm.CotizacionCab;
import com.srn.erp.ventas.bm.CotizacionDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCotizacionDet extends DBObjetoPersistente {

  public static final String OID_PRESU_DET = "OID_PRESU_DET";
  public static final String OID_CCO_PRESU = "OID_CCO_PRESU";
  public static final String OID_PRODUCTO = "OID_PRODUCTO";
  public static final String OID_UM_ORI = "OID_UM_ORI";
  public static final String OID_UM_GES = "OID_UM_GES";
  public static final String CANT_UM_ORI = "CANT_UM_ORI";
  public static final String CANT_UM_GES = "CANT_UM_GES";
  public static final String CANT_UM_ORI_RES = "CANT_UM_ORI_RES";
  public static final String CANT_UM_GES_RES = "CANT_UM_GES_RES";
  public static final String CANT_UM_ORI_SEP = "CANT_UM_ORI_SEP";
  public static final String CANT_UM_GES_SEP = "CANT_UM_GES_SEP";
  public static final String CANT_UM_ORI_DESP = "CANT_UM_ORI_DESP";
  public static final String CANT_UM_GES_DESP = "CANT_UM_GES_DESP";
  public static final String CANT_UM_ORI_ENT = "CANT_UM_ORI_ENT";
  public static final String CANT_UM_GES_ENT = "CANT_UM_GES_ENT";
  public static final String CANT_UM_ORI_FACT = "CANT_UM_ORI_FACT";
  public static final String CANT_UM_GES_FACT = "CANT_UM_GES_FACT";
  public static final String PRECIO = "PRECIO";
  public static final String PRECIO_BONIF = "PRECIO_BONIF";
  public static final String PRECIO_LISTA = "PRECIO_LISTA";
  public static final String OID_MONEDA = "OID_MONEDA";
  public static final String ANULADO = "ANULADO";
  public static final String BONIF1 = "bonif1";
  public static final String BONIF2 = "bonif2";
  public static final String BONIF3 = "bonif3";
  public static final String BONIF4 = "bonif4";
  public static final String BONIF5 = "bonif5";
  public static final String BONIF6 = "bonif6";
  public static final String BONIF7 = "bonif7";
  public static final String BONIF8 = "bonif8";
  public static final String BONIF9 = "bonif9";
  public static final String FEC_ENTREGA = "fec_entrega";
  public static final String COMENTARIO = "comentario";
  public static final String CANT_CONV_UM_LP = "cant_conv_um_lp";
  public static final String CANT_LP = "cant_lp";
  public static final String OID_UM_LP = "oid_um_lp";
  public static final String PEND_ENT = "pend_ent";
  public static final String PEND_DESP = "pend_desp";
  public static final String NRO_RENGLON = "nro_renglon";
  
  public static final String IMPORTE = "importe";
  public static final String DTO_RECAR = "dto_recar";
  public static final String IMPRE_PRECIO = "impre_precio";
  public static final String IMPRE_BONIF = "impre_bonif";
  public static final String IMPRE_RECAR = "impre_recar";
  public static final String IMPRE_PRECIO_BONIF = "impre_precio_bonif";
  public static final String IMPRE_IMPORTE = "impre_importe";
  public static final String OID_CONC_IMP_IVA = "oid_conc_imp_iva";
  public static final String OID_CONC_IMP_PIVA = "oid_conc_imp_piva";
  public static final String OID_CONC_IMP_INT = "oid_conc_imp_int";
  public static final String OID_CONC_IMP_PIB = "oid_conc_imp_pib";
  public static final String NETO_GRAVADO = "neto_gravado";
  public static final String NETO_NO_GRAVADO = "neto_no_gravado";
  public static final String PEND_FACT = "pend_fact";
  public static final String DIAS_ENTREGA = "dias_entrega";
    
  public static final int SELECT_BY_COTIZACION = 100;
  public static final int SELECT_BY_COTIZACION_ACTIVOS = 101;
  

  public DBCotizacionDet() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PRESU_DET = 1;
    final int OID_CCO_PRESU = 2;
    final int OID_PRODUCTO = 3;
    final int OID_UM_ORI = 4;
    final int CANT_UM_ORI = 5;
    final int CANT_UM_ORI_RES = 6;
    final int CANT_UM_ORI_SEP = 7;
    final int CANT_UM_ORI_DESP = 8;
    final int CANT_UM_ORI_ENT = 9;
    final int CANT_UM_ORI_FACT = 10;
    final int PRECIO = 11;
    final int PRECIO_BONIF = 12;
    final int PRECIO_LISTA = 13;
    final int OID_MONEDA = 14;
    final int ANULADO = 15;
    final int BONIF1 = 16;
    final int BONIF2 = 17;
    final int BONIF3 = 18;
    final int BONIF4 = 19;
    final int BONIF5 = 20;
    final int BONIF6 = 21;
    final int BONIF7 = 22;
    final int BONIF8 = 23;
    final int BONIF9 = 24;
    final int FEC_ENTREGA = 25;
    final int COMENTARIO = 26;
    final int PEND_ENT = 27;
    final int PEND_DESP = 28;
    final int NRO_RENGLON = 29;
    
    final int IMPORTE = 30;
    final int DTO_RECAR = 31;
    final int IMPRE_PRECIO = 32;
    final int IMPRE_BONIF = 33;
    final int IMPRE_RECAR = 34;
    final int IMPRE_PRECIO_BONIF = 35;
    final int IMPRE_IMPORTE = 36;
    final int OID_CONC_IMP_IVA = 37;
    final int OID_CONC_IMP_PIVA = 38;
    final int OID_CONC_IMP_PIB = 39;
    final int OID_CONC_IMP_INT = 40;
    final int NETO_GRAVADO = 41;
    final int NETO_NO_GRAVADO = 42;
    
    final int PEND_FACT = 43;
    final int DIAS_ENTREGA = 44;
    


    CotizacionDet pers = (CotizacionDet) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into VEPRESUDET "+
                     " ( "+
                      "OID_PRESU_DET,"+
                      "OID_CCO_PRESU,"+
                      "OID_PRODUCTO,"+
                      "OID_UM_ORI,"+
                      "CANT_UM_ORI,"+
                      "CANT_UM_ORI_RES,"+
                      "CANT_UM_ORI_SEP,"+
                      "CANT_UM_ORI_DESP,"+
                      "CANT_UM_ORI_ENT,"+
                      "CANT_UM_ORI_FACT,"+
                      "PRECIO,"+
                      "PRECIO_BONIF,"+
                      "PRECIO_LISTA,"+
                      "OID_MONEDA,"+
                      "ANULADO,"+
                      "BONIF1,"+
                      "BONIF2,"+
                      "BONIF3,"+
                      "BONIF4,"+
                      "BONIF5,"+
                      "BONIF6,"+
                      "BONIF7,"+
                      "BONIF8,"+
                      "BONIF9,"+
                      "FEC_ENTREGA,"+
                      "COMENTARIO,"+
                      "PEND_ENT,"+
                      "PEND_DESP,"+
                      "NRO_RENGLON,"+
                      "IMPORTE,"+
                      "DTO_RECAR,"+
                      "IMPRE_PRECIO,"+
                      "IMPRE_BONIF,"+
                      "IMPRE_RECAR,"+
                      "IMPRE_PRECIO_BONIF,"+
                      "IMPRE_IMPORTE,"+
                      "OID_CONC_IMP_IVA,"+
                      "OID_CONC_IMP_PIVA,"+
                      "OID_CONC_IMP_INT,"+
                      "OID_CONC_IMP_PIB,"+
                      "NETO_GRAVADO,"+
                      "NETO_NO_GRAVADO,"+
                      "PEND_FACT,"+
                      "DIAS_ENTREGA"+
                      ")"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_PRESU_DET,pers.getOID());
    qInsert.setInt(OID_CCO_PRESU,pers.getCotizacion().getOID());
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qInsert.setInt(OID_UM_ORI,pers.getUni_med_ori().getOID());
    qInsert.setDouble(CANT_UM_ORI,pers.getCant_um_ori().doubleValue());
    qInsert.setDouble(CANT_UM_ORI_RES,pers.getCant_um_ori_res().doubleValue());
    qInsert.setDouble(CANT_UM_ORI_SEP,pers.getCant_um_ori_sep().doubleValue());
    qInsert.setDouble(CANT_UM_ORI_DESP,pers.getCant_um_ori_desp().doubleValue());
    qInsert.setDouble(CANT_UM_ORI_ENT,pers.getCant_um_ori_ent().doubleValue());
    qInsert.setDouble(CANT_UM_ORI_FACT,pers.getCant_um_ori_fact().doubleValue());
    qInsert.setDouble(PRECIO,pers.getPrecio().doubleValue());
    qInsert.setDouble(PRECIO_BONIF,pers.getPrecio_bonif().doubleValue());
    qInsert.setDouble(PRECIO_LISTA,pers.getPrecio_lista().doubleValue());
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qInsert.setBoolean(ANULADO,pers.isAnulado().booleanValue());
    if (pers.getBonif1()!=null)
      qInsert.setDouble(BONIF1,pers.getBonif1().doubleValue());
    else
      qInsert.setNull(BONIF1,java.sql.Types.INTEGER);
    if (pers.getBonif2()!=null)
      qInsert.setDouble(BONIF2,pers.getBonif2().doubleValue());
    else
      qInsert.setNull(BONIF2,java.sql.Types.INTEGER);
    if (pers.getBonif3()!=null)
      qInsert.setDouble(BONIF3,pers.getBonif3().doubleValue());
    else
      qInsert.setNull(BONIF3,java.sql.Types.INTEGER);
    if (pers.getBonif4()!=null)
      qInsert.setDouble(BONIF4,pers.getBonif4().doubleValue());
    else
      qInsert.setNull(BONIF4,java.sql.Types.INTEGER);
    if (pers.getBonif5()!=null)
      qInsert.setDouble(BONIF5,pers.getBonif5().doubleValue());
    else
      qInsert.setNull(BONIF5,java.sql.Types.INTEGER);
    if (pers.getBonif6()!=null)
      qInsert.setDouble(BONIF6,pers.getBonif6().doubleValue());
    else
      qInsert.setNull(BONIF6,java.sql.Types.INTEGER);
    if (pers.getBonif7()!=null)
      qInsert.setDouble(BONIF7,pers.getBonif7().doubleValue());
    else
      qInsert.setNull(BONIF7,java.sql.Types.INTEGER);
    if (pers.getBonif8()!=null)
      qInsert.setDouble(BONIF8,pers.getBonif8().doubleValue());
    else
      qInsert.setNull(BONIF8,java.sql.Types.INTEGER);
    if (pers.getBonif9()!=null)
      qInsert.setDouble(BONIF9,pers.getBonif9().doubleValue());
    else
      qInsert.setNull(BONIF9,java.sql.Types.INTEGER);
    if (pers.getFechaEntrega()!=null)
    	qInsert.setDate(FEC_ENTREGA,new java.sql.Date(pers.getFechaEntrega().getTime()));
    else
    	qInsert.setNull(FEC_ENTREGA,java.sql.Types.DATE);
    qInsert.setString(COMENTARIO,pers.getComentario());
    qInsert.setBoolean(PEND_ENT,pers.isPendEnt().booleanValue());
    qInsert.setBoolean(PEND_DESP,pers.isPendDesp().booleanValue());
    qInsert.setBoolean(PEND_FACT, pers.isPendFact().booleanValue());
    qInsert.setInt(NRO_RENGLON,pers.getNroRenglon().intValue());
    
    if (pers.getImporte()!=null)
    	qInsert.setDouble(IMPORTE,pers.getImporte().doubleValue());
    else
    	qInsert.setNull(IMPORTE,Types.DOUBLE);
    if (pers.getDto_recar()!=null)
    	qInsert.setDouble(DTO_RECAR,pers.getDto_recar().doubleValue());
    else
    	qInsert.setNull(DTO_RECAR,Types.DOUBLE);
    if (pers.getImpre_precio()!=null)
    	qInsert.setDouble(IMPRE_PRECIO,pers.getImpre_precio().doubleValue());
    else
    	qInsert.setNull(IMPRE_PRECIO,Types.DOUBLE);
    if (pers.getImpre_bonif()!=null)
      qInsert.setDouble(IMPRE_BONIF,pers.getImpre_bonif().doubleValue());
    else
      qInsert.setNull(IMPRE_BONIF,Types.DOUBLE);
    if (pers.getImpre_recar()!=null)
    	qInsert.setDouble(IMPRE_RECAR,pers.getImpre_recar().doubleValue());
    else
    	qInsert.setNull(IMPRE_RECAR,Types.DOUBLE);
    if (pers.getImpre_precio_bonif()!=null)
    	qInsert.setDouble(IMPRE_PRECIO_BONIF,pers.getImpre_precio_bonif().doubleValue());
    else
    	qInsert.setNull(IMPRE_PRECIO_BONIF,Types.DOUBLE);
    if (pers.getImpre_importe()!=null)
    	qInsert.setDouble(IMPRE_IMPORTE,pers.getImpre_importe().doubleValue());
    else
    	qInsert.setNull(IMPRE_IMPORTE,Types.DOUBLE);
    if (pers.getConcImpuIVA()!=null)
    	qInsert.setInt(OID_CONC_IMP_IVA,pers.getConcImpuIVA().getOID());
    else
    	qInsert.setNull(OID_CONC_IMP_IVA,Types.INTEGER);
    if (pers.getConcImpuPercIVA()!=null)
    	qInsert.setInt(OID_CONC_IMP_PIVA,pers.getConcImpuPercIVA().getOID());
    else
    	qInsert.setNull(OID_CONC_IMP_PIVA,Types.INTEGER);
    if (pers.getConcImpuInt()!=null)
    	qInsert.setInt(OID_CONC_IMP_INT,pers.getConcImpuInt().getOID());
    else
    	qInsert.setNull(OID_CONC_IMP_INT,Types.INTEGER);
    if (pers.getConcImpuPercIB()!=null)
    	qInsert.setInt(OID_CONC_IMP_PIB,pers.getConcImpuPercIB().getOID());
    else
    	qInsert.setNull(OID_CONC_IMP_PIB,Types.INTEGER);    
    if (pers.getConcImpuPercIB()!=null)
    	qInsert.setInt(OID_CONC_IMP_PIB,pers.getConcImpuPercIB().getOID());
    else
    	qInsert.setNull(OID_CONC_IMP_PIB,Types.INTEGER);
    
    if (pers.getNetoGravado()!=null)
    	qInsert.setDouble(NETO_GRAVADO, pers.getNetoGravado().doubleValue());
    else
    	qInsert.setNull(NETO_GRAVADO, Types.DOUBLE);
    
    if (pers.getNetoNoGravado()!=null)
    	qInsert.setDouble(NETO_NO_GRAVADO, pers.getNetoNoGravado().doubleValue());
    else
    	qInsert.setNull(NETO_NO_GRAVADO, Types.DOUBLE);
    
    if (pers.getDiasEntrega()!=null)
    	qInsert.setDouble(DIAS_ENTREGA, pers.getDiasEntrega().intValue());
    else
    	qInsert.setInt(DIAS_ENTREGA, 0);
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO_PRESU = 1;
    final int OID_PRODUCTO = 2;
    final int OID_UM_ORI = 3;
    final int CANT_UM_ORI = 4;
    final int CANT_UM_ORI_RES = 5;
    final int CANT_UM_ORI_SEP = 6;
    final int CANT_UM_ORI_DESP = 7;
    final int CANT_UM_ORI_ENT = 8;
    final int CANT_UM_ORI_FACT = 9;
    final int PRECIO = 10;
    final int PRECIO_BONIF = 11;
    final int PRECIO_LISTA = 12;
    final int OID_MONEDA = 13;
    final int ANULADO = 14;
    final int BONIF1 = 15;
    final int BONIF2 = 16;
    final int BONIF3 = 17;
    final int BONIF4 = 18;
    final int BONIF5 = 19;
    final int BONIF6 = 20;
    final int BONIF7 = 21;
    final int BONIF8 = 22;
    final int BONIF9 = 23;
    final int FEC_ENTREGA = 24;
    final int COMENTARIO = 25;
    final int PEND_ENT = 26;
    final int PEND_DESP = 27;
    final int NRO_RENGLON = 28;
    
    final int IMPORTE = 29;
    final int DTO_RECAR = 30;
    final int IMPRE_PRECIO = 31;
    final int IMPRE_BONIF = 32;
    final int IMPRE_RECAR = 33;
    final int IMPRE_PRECIO_BONIF = 34;
    final int IMPRE_IMPORTE = 35;
    final int OID_CONC_IMP_IVA = 36;
    final int OID_CONC_IMP_PIVA = 37;
    final int OID_CONC_IMP_PIB = 38;
    final int OID_CONC_IMP_INT = 39;
    final int NETO_GRAVADO = 40;
    final int NETO_NO_GRAVADO = 41;
    
    final int PEND_FACT = 42;
    final int DIAS_ENTREGA = 43;
    final int OID_PRESU_DET = 44;


    CotizacionDet pers = (CotizacionDet) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vePresuDET set "+
              "OID_CCO_PRESU=?"+
              ",OID_PRODUCTO=?"+
              ",OID_UM_ORI=?"+
              ",CANT_UM_ORI=?"+
              ",CANT_UM_ORI_RES=?"+
              ",CANT_UM_ORI_SEP=?"+
              ",CANT_UM_ORI_DESP=?"+
              ",CANT_UM_ORI_ENT=?"+
              ",CANT_UM_ORI_FACT=?"+
              ",PRECIO=?"+
              ",PRECIO_BONIF=?"+
              ",PRECIO_LISTA=?"+
              ",OID_MONEDA=?"+
              ",ANULADO=?"+
              ",bonif1=?"+
              ",bonif2=?"+
              ",bonif3=?"+
              ",bonif4=?"+
              ",bonif5=?"+
              ",bonif6=?"+
              ",bonif7=?"+
              ",bonif8=?"+
              ",bonif9=?"+
              ",fec_entrega=?"+
              ",comentario=?"+
              ",pend_ent=?"+
              ",pend_desp=?"+
              ",nro_renglon=?,"+
              "IMPORTE=?,"+
              "DTO_RECAR=?,"+
              "IMPRE_PRECIO=?,"+
              "IMPRE_BONIF=?,"+
              "IMPRE_RECAR=?,"+
              "IMPRE_PRECIO_BONIF=?,"+
              "IMPRE_IMPORTE=?,"+
              "OID_CONC_IMP_IVA=?,"+
              "OID_CONC_IMP_PIVA=?,"+
              "OID_CONC_IMP_INT=?,"+
              "OID_CONC_IMP_PIB=?,"+
              "NETO_GRAVADO=?,"+
              "NETO_NO_GRAVADO=?,"+
              "PEND_FACT=?,"+
              "DIAS_ENTREGA=?"+
                 " where " +
                 " oid_presu_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PRESU_DET,pers.getOID());
    qUpdate.setInt(OID_CCO_PRESU,pers.getCotizacion().getOID());
    qUpdate.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qUpdate.setInt(OID_UM_ORI,pers.getUni_med_ori().getOID());
    qUpdate.setDouble(CANT_UM_ORI,pers.getCant_um_ori().doubleValue());
    qUpdate.setDouble(CANT_UM_ORI_RES,pers.getCant_um_ori_res().doubleValue());
    qUpdate.setDouble(CANT_UM_ORI_SEP,pers.getCant_um_ori_sep().doubleValue());
    qUpdate.setDouble(CANT_UM_ORI_DESP,pers.getCant_um_ori_desp().doubleValue());
    qUpdate.setDouble(CANT_UM_ORI_ENT,pers.getCant_um_ori_ent().doubleValue());
    qUpdate.setDouble(CANT_UM_ORI_FACT,pers.getCant_um_ori_fact().doubleValue());
    qUpdate.setDouble(PRECIO,pers.getPrecio().doubleValue());
    qUpdate.setDouble(PRECIO_BONIF,pers.getPrecio_bonif().doubleValue());
    qUpdate.setDouble(PRECIO_LISTA,pers.getPrecio_lista().doubleValue());
    qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qUpdate.setBoolean(ANULADO,pers.isAnulado().booleanValue());
    if (pers.getBonif1()!=null)
      qUpdate.setDouble(BONIF1,pers.getBonif1().doubleValue());
    else
      qUpdate.setNull(BONIF1,java.sql.Types.INTEGER);
    if (pers.getBonif2()!=null)
      qUpdate.setDouble(BONIF2,pers.getBonif2().doubleValue());
    else
      qUpdate.setNull(BONIF2,java.sql.Types.INTEGER);
    if (pers.getBonif3()!=null)
      qUpdate.setDouble(BONIF3,pers.getBonif3().doubleValue());
    else
      qUpdate.setNull(BONIF3,java.sql.Types.INTEGER);
    if (pers.getBonif4()!=null)
      qUpdate.setDouble(BONIF4,pers.getBonif4().doubleValue());
    else
      qUpdate.setNull(BONIF4,java.sql.Types.INTEGER);
    if (pers.getBonif5()!=null)
      qUpdate.setDouble(BONIF5,pers.getBonif5().doubleValue());
    else
      qUpdate.setNull(BONIF5,java.sql.Types.INTEGER);
    if (pers.getBonif6()!=null)
      qUpdate.setDouble(BONIF6,pers.getBonif6().doubleValue());
    else
      qUpdate.setNull(BONIF6,java.sql.Types.INTEGER);
    if (pers.getBonif7()!=null)
      qUpdate.setDouble(BONIF7,pers.getBonif7().doubleValue());
    else
      qUpdate.setNull(BONIF7,java.sql.Types.INTEGER);
    if (pers.getBonif8()!=null)
      qUpdate.setDouble(BONIF8,pers.getBonif8().doubleValue());
    else
      qUpdate.setNull(BONIF8,java.sql.Types.INTEGER);
    if (pers.getBonif9()!=null)
      qUpdate.setDouble(BONIF9,pers.getBonif9().doubleValue());
    else
      qUpdate.setNull(BONIF9,java.sql.Types.INTEGER);
    
    if (pers.getFechaEntrega()!=null)
    	qUpdate.setDate(FEC_ENTREGA,new java.sql.Date(pers.getFechaEntrega().getTime()));
    else
    	qUpdate.setNull(FEC_ENTREGA,java.sql.Types.DATE);
    
    qUpdate.setString(COMENTARIO,pers.getComentario());
    qUpdate.setBoolean(PEND_ENT,pers.isPendEnt().booleanValue());
    qUpdate.setBoolean(PEND_DESP,pers.isPendDesp().booleanValue());
    qUpdate.setInt(NRO_RENGLON,pers.getNroRenglon().intValue());
    
    if (pers.getImporte()!=null)
    	qUpdate.setDouble(IMPORTE,pers.getImporte().doubleValue());
    else
    	qUpdate.setNull(IMPORTE,Types.DOUBLE);

    if (pers.getDto_recar()!=null)
    	qUpdate.setDouble(DTO_RECAR,pers.getDto_recar().doubleValue());
    else
    	qUpdate.setNull(DTO_RECAR,Types.DOUBLE);
    if (pers.getImpre_precio()!=null)
    	qUpdate.setDouble(IMPRE_PRECIO,pers.getImpre_precio().doubleValue());
    else
    	qUpdate.setNull(IMPRE_PRECIO,Types.DOUBLE);
    if (pers.getImpre_bonif()!=null)
    	qUpdate.setDouble(IMPRE_BONIF,pers.getImpre_bonif().doubleValue());
    else
    	qUpdate.setNull(IMPRE_BONIF,Types.DOUBLE);
    if (pers.getImpre_recar()!=null)
    	qUpdate.setDouble(IMPRE_RECAR,pers.getImpre_recar().doubleValue());
    else
    	qUpdate.setNull(IMPRE_RECAR,Types.DOUBLE);
    if (pers.getImpre_precio_bonif()!=null)
    	qUpdate.setDouble(IMPRE_PRECIO_BONIF,pers.getImpre_precio_bonif().doubleValue());
    else
    	qUpdate.setNull(IMPRE_PRECIO_BONIF,Types.DOUBLE);
    if (pers.getImpre_importe()!=null)
    	qUpdate.setDouble(IMPRE_IMPORTE,pers.getImpre_importe().doubleValue());
    else
    	qUpdate.setNull(IMPRE_IMPORTE,Types.DOUBLE);
    if (pers.getConcImpuIVA()!=null)
    	qUpdate.setInt(OID_CONC_IMP_IVA,pers.getConcImpuIVA().getOID());
    else
    	qUpdate.setNull(OID_CONC_IMP_IVA,Types.INTEGER);
    if (pers.getConcImpuPercIVA()!=null)
    	qUpdate.setInt(OID_CONC_IMP_PIVA,pers.getConcImpuPercIVA().getOID());
    else
    	qUpdate.setNull(OID_CONC_IMP_PIVA,Types.INTEGER);
    if (pers.getConcImpuInt()!=null)
    	qUpdate.setInt(OID_CONC_IMP_INT,pers.getConcImpuInt().getOID());
    else
    	qUpdate.setNull(OID_CONC_IMP_INT,Types.INTEGER);
    if (pers.getConcImpuPercIB()!=null)
    	qUpdate.setInt(OID_CONC_IMP_PIB,pers.getConcImpuPercIB().getOID());
    else
    	qUpdate.setNull(OID_CONC_IMP_PIB,Types.INTEGER);    
    if (pers.getConcImpuPercIB()!=null)
    	qUpdate.setInt(OID_CONC_IMP_PIB,pers.getConcImpuPercIB().getOID());
    else
    	qUpdate.setNull(OID_CONC_IMP_PIB,Types.INTEGER);
    
    if (pers.getNetoGravado()!=null)
    	qUpdate.setDouble(NETO_GRAVADO, pers.getNetoGravado().doubleValue());
    else
    	qUpdate.setNull(NETO_GRAVADO, Types.DOUBLE);
    
    if (pers.getNetoNoGravado()!=null)
    	qUpdate.setDouble(NETO_NO_GRAVADO, pers.getNetoNoGravado().doubleValue());
    else
    	qUpdate.setNull(NETO_NO_GRAVADO, Types.DOUBLE);
    
    if (pers.getDiasEntrega()!=null)
    	qUpdate.setInt(DIAS_ENTREGA, pers.getDiasEntrega().intValue());
    else
    	qUpdate.setInt(DIAS_ENTREGA, 0);
    
    qUpdate.setBoolean(PEND_FACT, pers.isPendFact().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    CotizacionDet pers = (CotizacionDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update vePresuDet "+
                     " set anulado=1 " +
                     " where " +
                     " oid_presu_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(1, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    CotizacionDet pers = (CotizacionDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update vePresuDet "+
                     " set activo=1 " +
                     " where " +
                     " oid_presu_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(1, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
    PreparedStatement ps = null;
    switch (aSelect) {
      case IDBObjetoPersistente.SELECT_BY_OID: {
        ps = this.selectByOID(aCondiciones);
        break;
      }
      case IDBObjetoPersistente.SELECT_BY_CODIGO: {
        ps = this.selectByCodigo(aCondiciones);
        break;
      }
      case IDBObjetoPersistente.SELECT_ALL_HELP: {
        ps = this.selectAllHelp(aCondiciones);
        break;
      }
      case SELECT_BY_COTIZACION: {
        ps = this.selectByPedido(aCondiciones);
        break;
      }
      case SELECT_BY_COTIZACION_ACTIVOS: {
          ps = this.selectByPedidoActivos(aCondiciones);
          break;
        }
      
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vePresuDet ");
    textSQL.append(" WHERE oid_presu_det = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(1, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vePresuDet ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByPedido(Object aCondiciones) throws BaseException, SQLException {
    CotizacionCab cotizacion = (CotizacionCab) aCondiciones;
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vePresuDet ");
    textSQL.append(" WHERE  OID_CCO_PRESU = ? order by nro_renglon, oid_presu_det ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,cotizacion.getOID());
    return querySelect;
  }
  
  private PreparedStatement selectByPedidoActivos(Object aCondiciones) throws BaseException, SQLException {
	    CotizacionCab cotizacion = (CotizacionCab) aCondiciones;
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  vePresuDet ");
	    textSQL.append(" WHERE  OID_CCO_PRESU = ? and anulado=0 order by nro_renglon, oid_presu_det ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setInt(1,cotizacion.getOID());
	    return querySelect;
	  }
  

  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT OID_PRESU_DET oid, codigo,  descripcion ,activo ");
    textSQL.append(" from vePresuDet ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  


  public static List getDetallesByCotizacion(CotizacionCab cotizacion,
                                         ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(CotizacionDet.NICKNAME,
                                          DBCotizacionDet.SELECT_BY_COTIZACION,
                                          cotizacion,
                                          new ListObserver(),
                                          aSesion);
  }
  
  public static List getDetallesByCotizacionActivos(CotizacionCab cotizacion,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(CotizacionDet.NICKNAME,
           DBCotizacionDet.SELECT_BY_COTIZACION_ACTIVOS,
           cotizacion,
           new ListObserver(),
           aSesion);
  }
  


}
