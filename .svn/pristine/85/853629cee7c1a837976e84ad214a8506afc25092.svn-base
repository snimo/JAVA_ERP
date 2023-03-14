package com.srn.erp.rrhh.op;

import com.srn.erp.general.bm.ClasificadorEntidad;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerLeyendasRepEval extends Operation {

  public TraerLeyendasRepEval() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  IDataSet dsLeyendas = this.getDataSetLeyendas();
	  cargarRegistro(dsLeyendas, 
			  getTitulo1(), getTitulo2(), getTitulo3() , 
			  getClasificadorEmpresa(this.getSesion()), 
			  getClasificadorSector(this.getSesion()), 
			  getClasificadorPuesto(this.getSesion()),
			  getClasificadorEstado(this.getSesion())
			  );
	  writeCliente(dsLeyendas);
  }

  private IDataSet getDataSetLeyendas() {
    IDataSet dataset = new TDataSet();
    dataset.create("TLeyendasReporte");
    dataset.fieldDef(new Field("titulo_1", Field.STRING, 100));
    dataset.fieldDef(new Field("titulo_2", Field.STRING, 100));
    dataset.fieldDef(new Field("titulo_3", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_clasif_empresa", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_clasif_sector", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_clasif_puesto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_clasif_empresa", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_clasif_sector", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_clasif_puesto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_clasif_estado", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_clasif_estado", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                         String titulo1,
                         String titulo2,
                         String titulo3,
                         ClasificadorEntidad clasifEmpresa,
                         ClasificadorEntidad clasifSector,
                         ClasificadorEntidad clasifPuesto,
                         ClasificadorEntidad clasifEstado
                         ) throws BaseException {
    dataset.append();
    dataset.fieldValue("titulo_1", titulo1);
    dataset.fieldValue("titulo_2", titulo2);
    dataset.fieldValue("titulo_3", titulo3);
    dataset.fieldValue("oid_clasif_empresa", clasifEmpresa.getOIDInteger());
    dataset.fieldValue("oid_clasif_sector", clasifSector.getOIDInteger());
    dataset.fieldValue("oid_clasif_puesto", clasifPuesto.getOIDInteger());
    dataset.fieldValue("nro_clasif_empresa", clasifEmpresa.getNroClasif());
    dataset.fieldValue("nro_clasif_sector", clasifSector.getNroClasif());
    dataset.fieldValue("nro_clasif_puesto", clasifPuesto.getNroClasif());
    dataset.fieldValue("oid_clasif_estado", clasifEstado.getOIDInteger());
    dataset.fieldValue("nro_clasif_estado", clasifEstado.getNroClasif());
    
    
  }
  
  private String getTitulo1() throws BaseException {
	  try {
	  	return ValorParametro.findByCodigoParametro("TIT_1_FORM_EVAL", this.getSesion()).getValorCadena();
	  }
	  catch(Exception e) {
		  return "";
	  }
  }
  
  private String getTitulo2() throws BaseException {
	  try {
	  	return ValorParametro.findByCodigoParametro("TIT_2_FORM_EVAL", this.getSesion()).getValorCadena();
	  }
	  catch(Exception e) {
		  return "";
	  }
  }
  
  private String getTitulo3() throws BaseException {
	  try {
	  	return ValorParametro.findByCodigoParametro("TIT_3_FORM_EVAL", this.getSesion()).getValorCadena();
	  }
	  catch(Exception e) {
		  return "";
	  }
  }
  
  public static ClasificadorEntidad getClasificadorEmpresa(ISesion aSesion)
	throws BaseException {
		Integer oidClasif = ValorParametro.findByCodigoParametro(
				"CLASIF_EMP_EVAL_RH", aSesion).getOidObjNeg();
		return ClasificadorEntidad.findByOid(oidClasif, aSesion);
  }
  
  public static ClasificadorEntidad getClasificadorSector(ISesion aSesion)
	throws BaseException {
		Integer oidClasif = ValorParametro.findByCodigoParametro(
				"CLASIF_SECTOR_EVAL_RH", aSesion).getOidObjNeg();
		return ClasificadorEntidad.findByOid(oidClasif, aSesion);
  }
  
  public static ClasificadorEntidad getClasificadorPuesto(ISesion aSesion)
	throws BaseException {
		Integer oidClasif = ValorParametro.findByCodigoParametro(
				"CLASIF_PUESTO_EVAL_RH", aSesion).getOidObjNeg();
		return ClasificadorEntidad.findByOid(oidClasif, aSesion);
  }
  
  public static ClasificadorEntidad getClasificadorEstado(ISesion aSesion)
	throws BaseException {
		Integer oidClasif = ValorParametro.findByCodigoParametro(
				"CLASIF_ESTADO_EVAL_RH", aSesion).getOidObjNeg();
		return ClasificadorEntidad.findByOid(oidClasif, aSesion);
}
  
}
