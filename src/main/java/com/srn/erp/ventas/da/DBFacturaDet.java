package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.FacturaDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBFacturaDet extends DBObjetoPersistente {

  public static final String OID_FACT_DET = "oid_fact_det";
  public static final String OID_CCO_FACT = "oid_cco_fact";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String CANTIDAD = "cantidad";
  public static final String OID_UM = "oid_um";
  public static final String PRECIO_LISTA = "precio_lista";
  public static final String PRECIO_INGRESADO = "precio_ingresado";
  public static final String PRECIO_SUGERIDO = "precio_sugerido";
  public static final String PORC_BONIF_1 = "porc_bonif_1";
  public static final String PORC_BONIF_2 = "porc_bonif_2";
  public static final String PORC_BONIF_3 = "porc_bonif_3";
  public static final String PRECIO_BONIFICADO = "precio_bonificado";
  public static final String IMPORTE = "importe";
  public static final String COMENTARIO = "comentario";
  public static final String DTO_RECAR = "dto_recar";
  public static final String ANULADO = "anulado";
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
  public static final String OID_CCO_PED_DET = "oid_cco_ped_det";
  public static final String OID_CCO_PED = "oid_cco_ped";
  public static final String OID_CCO_REM_DET = "oid_cco_rem_det";
  public static final String OID_CCO_REM = "oid_cco_rem";
  public static final String OID_CCO_FACT_APLIC = "oid_cco_fact_aplic";
  public static final String OID_DET_FACT_APLIC = "oid_det_fact_aplic";
  public static final String TASA_IVA = "tasa_iva";
  public static final String IVA = "iva";
  
  
  
  public static final int SELECT_BY_ITEMS_FACTURA = 100;

  public DBFacturaDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_FACT_DET = 1;
    final int OID_CCO_FACT = 2;
    final int OID_PRODUCTO = 3;
    final int CANTIDAD = 4;
    final int OID_UM = 5;
    final int PRECIO_LISTA = 6;
    final int PRECIO_INGRESADO = 7;
    final int PRECIO_SUGERIDO = 8;
    final int PORC_BONIF_1 = 9;
    final int PORC_BONIF_2 = 10;
    final int PORC_BONIF_3 = 11;
    final int PRECIO_BONIFICADO = 12;
    final int IMPORTE = 13;
    final int COMENTARIO = 14;
    final int DTO_RECAR = 15;
    final int ANULADO = 16;
    final int IMPRE_PRECIO = 17;
    final int IMPRE_BONIF = 18;
    final int IMPRE_RECAR = 19;
    final int IMPRE_PRECIO_BONIF = 20;
    final int IMPRE_IMPORTE = 21;
    final int OID_CONC_IMP_IVA = 22;
    final int OID_CONC_IMP_PIVA = 23;
    final int OID_CONC_IMP_PIB = 24;
    final int OID_CONC_IMP_INT = 25;
    final int NETO_GRAVADO = 26;
    final int NETO_NO_GRAVADO = 27;
    final int OID_CCO_PED_DET = 28;
    final int OID_CCO_PED = 29;
    final int OID_CCO_REM_DET = 30;
    final int OID_CCO_REM = 31;
    final int OID_CCO_FACT_APLIC = 32;
    final int OID_DET_FACT_APLIC = 33;
    final int TASA_IVA = 34;
    final int IVA = 35;
    

    FacturaDet pers = (FacturaDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veFacturasDet "+
                     " ( "+
                      "OID_FACT_DET,"+
                      "OID_CCO_FACT,"+
                      "OID_PRODUCTO,"+
                      "CANTIDAD,"+
                      "OID_UM,"+
                      "PRECIO_LISTA,"+
                      "PRECIO_INGRESADO,"+
                      "PRECIO_SUGERIDO,"+
                      "PORC_BONIF_1,"+
                      "PORC_BONIF_2,"+
                      "PORC_BONIF_3,"+
                      "PRECIO_BONIFICADO,"+
                      "IMPORTE,"+
                      "COMENTARIO,"+
                      "DTO_RECAR,"+
                      "ANULADO,"+
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
                      "OID_CCO_PED_DET,"+
                      "OID_CCO_PED,"+
                      "OID_CCO_REM_DET,"+
                      "OID_CCO_REM,OID_CCO_FACT_APLIC,OID_DET_FACT_APLIC,TASA_IVA,IVA"+
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_FACT_DET,pers.getOID());
    qInsert.setInt(OID_CCO_FACT,pers.getComprocab().getOID());
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qInsert.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    if (pers.getUnidad_medida()!=null)
    	qInsert.setInt(OID_UM,pers.getUnidad_medida().getOID());
    else
    	qInsert.setNull(OID_UM,Types.INTEGER);
    if (pers.getPrecio_lista()!=null)
    	qInsert.setDouble(PRECIO_LISTA,pers.getPrecio_lista().doubleValue());
    else
    	qInsert.setNull(PRECIO_LISTA,Types.DOUBLE);
    qInsert.setDouble(PRECIO_INGRESADO,pers.getPrecio_ingresado().doubleValue());
    if (pers.getPrecio_sugerido()!=null)
    	qInsert.setDouble(PRECIO_SUGERIDO,pers.getPrecio_sugerido().doubleValue());
    else
    	qInsert.setNull(PRECIO_SUGERIDO,Types.DOUBLE);
    if (pers.getPorc_bonif_1()!=null)
    	qInsert.setDouble(PORC_BONIF_1,pers.getPorc_bonif_1().doubleValue());
    else
    	qInsert.setNull(PORC_BONIF_1,Types.DOUBLE);
    if (pers.getPorc_bonif_2()!=null)
    	qInsert.setDouble(PORC_BONIF_2,pers.getPorc_bonif_2().doubleValue());
    else
    	qInsert.setNull(PORC_BONIF_2,Types.DOUBLE);
    if (pers.getPorc_bonif_3()!=null)
    	qInsert.setDouble(PORC_BONIF_3,pers.getPorc_bonif_3().doubleValue());
    else
    	qInsert.setNull(PORC_BONIF_3,Types.NULL);
    qInsert.setDouble(PRECIO_BONIFICADO,pers.getPrecio_bonificado().doubleValue());
    qInsert.setDouble(IMPORTE,pers.getImporte().doubleValue());
    if (pers.getComentario()!=null)
    	qInsert.setString(COMENTARIO,pers.getComentario());
    else
    	qInsert.setNull(COMENTARIO,Types.DOUBLE);
    if (pers.getDto_recar()!=null)
    	qInsert.setDouble(DTO_RECAR,pers.getDto_recar().doubleValue());
    else
    	qInsert.setNull(DTO_RECAR,Types.DOUBLE);
    qInsert.setBoolean(ANULADO,pers.isAnulado().booleanValue());
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
    	qInsert.setDouble(NETO_GRAVADO, Types.DOUBLE);
    
    if (pers.getNetoNoGravado()!=null)
    	qInsert.setDouble(NETO_NO_GRAVADO, pers.getNetoNoGravado().doubleValue());
    else
    	qInsert.setDouble(NETO_NO_GRAVADO, Types.DOUBLE);
    
    if (pers.getPedidoCab()!=null) 
    	qInsert.setInt(OID_CCO_PED, pers.getPedidoCab().getOID());
    else
    	qInsert.setNull(OID_CCO_PED, Types.INTEGER);
    
    if (pers.getPedidoDet()!=null) 
    	qInsert.setInt(OID_CCO_PED_DET, pers.getPedidoDet().getOID());
    else
    	qInsert.setNull(OID_CCO_PED_DET, Types.INTEGER);
    
    if (pers.getRemitoCab()!=null) 
    	qInsert.setInt(OID_CCO_REM, pers.getRemitoCab().getOID());
    else
    	qInsert.setNull(OID_CCO_REM, Types.INTEGER);
    
    if (pers.getRemitoDet()!=null) 
    	qInsert.setInt(OID_CCO_REM_DET, pers.getRemitoDet().getOID());
    else
    	qInsert.setNull(OID_CCO_REM_DET, Types.INTEGER);
    
    if (pers.getFacturaAplicada()!=null) 
    	qInsert.setInt(OID_CCO_FACT_APLIC, pers.getFacturaAplicada().getOID());
    else
    	qInsert.setNull(OID_CCO_FACT_APLIC, Types.INTEGER);
    
    if (pers.getFacturaDetAplicada()!=null) 
    	qInsert.setInt(OID_DET_FACT_APLIC, pers.getFacturaDetAplicada().getOID());
    else
    	qInsert.setNull(OID_DET_FACT_APLIC, Types.INTEGER);
    
    if (pers.getTasaIVA()!=null)
    	qInsert.setDouble(TASA_IVA, pers.getTasaIVA().doubleValue());
    else
    	qInsert.setNull(TASA_IVA, Types.DOUBLE);
    
    if (pers.getIVA()!=null)
    	qInsert.setDouble(IVA, pers.getIVA().doubleValue());
    else
    	qInsert.setNull(IVA, Types.DOUBLE);
    	
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO_FACT = 1;
    final int OID_PRODUCTO = 2;
    final int CANTIDAD = 3;
    final int OID_UM = 4;
    final int PRECIO_LISTA = 5;
    final int PRECIO_INGRESADO = 6;
    final int PRECIO_SUGERIDO = 7;
    final int PORC_BONIF_1 = 8;
    final int PORC_BONIF_2 = 9;
    final int PORC_BONIF_3 = 10;
    final int PRECIO_BONIFICADO = 11;
    final int IMPORTE = 12;
    final int COMENTARIO = 13;
    final int DTO_RECAR = 14;
    final int ANULADO = 15;
    final int IMPRE_PRECIO = 16;
    final int IMPRE_BONIF = 17;
    final int IMPRE_RECAR = 18;
    final int IMPRE_PRECIO_BONIF = 19;
    final int IMPRE_IMPORTE = 20;
    final int OID_CONC_IMP_IVA = 21;
    final int OID_CONC_IMP_PIVA = 22;
    final int OID_CONC_IMP_PIB = 23;
    final int OID_CONC_IMP_INT = 24;
    final int NETO_GRAVADO = 25;
    final int NETO_NO_GRAVADO = 26;
    final int OID_CCO_PED_DET = 27;
    final int OID_CCO_PED = 28;
    final int OID_CCO_REM_DET = 29;
    final int OID_CCO_REM = 30;
    final int OID_CCO_FACT_APLIC = 31;
    final int OID_DET_FACT_APLIC = 32;
    final int TASA_IVA = 33;
    final int IVA = 34;
    final int OID_FACT_DET = 35;

    FacturaDet pers = (FacturaDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veFacturasDet set "+
              "oid_cco_fact=?"+ 
              ",oid_producto=?"+ 
              ",cantidad=?"+ 
              ",oid_um=?"+ 
              ",precio_lista=?"+ 
              ",precio_ingresado=?"+ 
              ",precio_sugerido=?"+ 
              ",porc_bonif_1=?"+ 
              ",porc_bonif_2=?"+ 
              ",porc_bonif_3=?"+ 
              ",precio_bonificado=?"+ 
              ",importe=?"+ 
              ",comentario=?"+ 
              ",dto_recar=?"+ 
              ",anulado=?"+ 
              ",impre_precio=?"+ 
              ",impre_bonif=?"+ 
              ",impre_recar=?"+ 
              ",impre_precio_bonif=?"+ 
              ",impre_importe=?"+
              ",oid_conc_imp_iva=?,"+
              ",oid_conc_imp_piva=?"+
              ",oid_conc_imp_int=?"+
              ",oid_conc_imp_pib=?"+
              ",neto_gravado=?"+
              ",OID_CCO_PED_DET=?"+
              ",OID_CCO_PED=?"+
              ",OID_CCO_REM_DET=?,"+
              ",OID_CCO_REM=?"+
              ",neto_no_gravado=?"+              
              ",oid_cco_fact_aplic=?"+
              ",oid_det_fact_aplic=?"+
              ",tasa_iva=?"+
              ",iva=?"+
                 " where " +
                 " oid_fact_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FACT_DET,pers.getOID());
    qUpdate.setInt(OID_CCO_FACT,pers.getComprocab().getOID());
    qUpdate.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qUpdate.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    if (pers.getUnidad_medida()!=null)
    	qUpdate.setInt(OID_UM,pers.getUnidad_medida().getOID());
    else
    	qUpdate.setNull(OID_UM,Types.INTEGER);
    if (pers.getPrecio_lista()!=null)
    	qUpdate.setDouble(PRECIO_LISTA,pers.getPrecio_lista().doubleValue());
    else
    	qUpdate.setNull(PRECIO_LISTA,Types.DOUBLE);
    qUpdate.setDouble(PRECIO_INGRESADO,pers.getPrecio_ingresado().doubleValue());
    if (pers.getPrecio_sugerido()!=null)
    	qUpdate.setDouble(PRECIO_SUGERIDO,pers.getPrecio_sugerido().doubleValue());
    else
    	qUpdate.setNull(PRECIO_SUGERIDO,Types.DOUBLE);
    if (pers.getPorc_bonif_1()!=null)
    	qUpdate.setDouble(PORC_BONIF_1,pers.getPorc_bonif_1().doubleValue());
    else
    	qUpdate.setNull(PORC_BONIF_1,Types.DOUBLE);
    if (pers.getPorc_bonif_2()!=null)
    	qUpdate.setDouble(PORC_BONIF_2,pers.getPorc_bonif_2().doubleValue());
    else
    	qUpdate.setNull(PORC_BONIF_2,Types.DOUBLE);
    if (pers.getPorc_bonif_3()!=null)
    	qUpdate.setDouble(PORC_BONIF_3,pers.getPorc_bonif_3().doubleValue());
    else
    	qUpdate.setNull(PORC_BONIF_3,Types.DOUBLE);
    qUpdate.setDouble(PRECIO_BONIFICADO,pers.getPrecio_bonificado().doubleValue());
    qUpdate.setDouble(IMPORTE,pers.getImporte().doubleValue());
    if (pers.getComentario()!=null)
    	qUpdate.setString(COMENTARIO,pers.getComentario());
    else
    	qUpdate.setNull(COMENTARIO,Types.VARCHAR);
    if (pers.getDto_recar()!=null)
    	qUpdate.setDouble(DTO_RECAR,pers.getDto_recar().doubleValue());
    else
    	qUpdate.setNull(DTO_RECAR,Types.DOUBLE);
    qUpdate.setBoolean(ANULADO,pers.isAnulado().booleanValue());
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
    
    if (pers.getNetoGravado()!=null)
    	qUpdate.setDouble(NETO_GRAVADO, pers.getNetoGravado().doubleValue());
    else
    	qUpdate.setDouble(NETO_GRAVADO, Types.DOUBLE);
    
    if (pers.getNetoNoGravado()!=null)
    	qUpdate.setDouble(NETO_NO_GRAVADO, pers.getNetoNoGravado().doubleValue());
    else
    	qUpdate.setDouble(NETO_NO_GRAVADO, Types.DOUBLE);

    if (pers.getPedidoCab()!=null) 
    	qUpdate.setInt(OID_CCO_PED, pers.getPedidoCab().getOID());
    else
    	qUpdate.setNull(OID_CCO_PED, Types.INTEGER);
    
    if (pers.getPedidoDet()!=null) 
    	qUpdate.setInt(OID_CCO_PED_DET, pers.getPedidoDet().getOID());
    else
    	qUpdate.setNull(OID_CCO_PED_DET, Types.INTEGER);
    
    if (pers.getRemitoCab()!=null) 
    	qUpdate.setInt(OID_CCO_REM, pers.getRemitoCab().getOID());
    else
    	qUpdate.setNull(OID_CCO_REM, Types.INTEGER);
    
    if (pers.getRemitoDet()!=null) 
    	qUpdate.setInt(OID_CCO_REM_DET, pers.getRemitoDet().getOID());
    else
    	qUpdate.setNull(OID_CCO_REM_DET, Types.INTEGER);
    
    if (pers.getFacturaAplicada()!=null) 
    	qUpdate.setInt(OID_CCO_FACT_APLIC, pers.getFacturaAplicada().getOID());
    else
    	qUpdate.setNull(OID_CCO_FACT_APLIC, Types.INTEGER);
    
    if (pers.getFacturaDetAplicada()!=null) 
    	qUpdate.setInt(OID_DET_FACT_APLIC, pers.getFacturaDetAplicada().getOID());
    else
    	qUpdate.setNull(OID_DET_FACT_APLIC, Types.INTEGER);

    if (pers.getTasaIVA()!=null)
    	qUpdate.setDouble(TASA_IVA, pers.getTasaIVA().doubleValue());
    else
    	qUpdate.setNull(TASA_IVA, Types.DOUBLE);
    
    if (pers.getIVA()!=null)
    	qUpdate.setDouble(IVA, pers.getIVA().doubleValue());
    else
    	qUpdate.setNull(IVA, Types.DOUBLE);
    
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FACT_DET = 1; 
    FacturaDet pers = (FacturaDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veFacturasDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_fact_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FACT_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FACT_DET = 1; 
    FacturaDet pers = (FacturaDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veFacturasDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_fact_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FACT_DET, pers.getOID()); 
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
      case SELECT_BY_ITEMS_FACTURA: {
         ps = this.selectByItemsFactura(aCondiciones); 
         break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_FACT_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veFacturasDet "); 
    textSQL.append(" WHERE oid_fact_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_FACT_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByItemsFactura(Object aCondiciones) throws BaseException, SQLException { 
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  veFacturasDet "); 
	textSQL.append(" WHERE oid_cco_fact = ? and anulado=0");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	FacturaCab facturaCab = (FacturaCab) aCondiciones; 
	querySelect.setInt(1, facturaCab.getOID()); 
	return querySelect; 
  }
 
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veFacturasDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_fact_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veFacturasDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getItemsFactura(FacturaCab facturaCab,
          ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(FacturaDet.NICKNAME,
             DBFacturaDet.SELECT_BY_ITEMS_FACTURA,
             facturaCab,
             new ListObserver(),
             aSesion);
  }
  
  // Esto hace que se genere un numerados unico para dicho comprobante
  protected int getNewOID() throws BaseException {
	 int oid = getSesion().getNewOid("DetalleFactClie",getSesion().getAutoCommitShareConexion());
	 return oid;
  }
  
  
  
} 
