package com.srn.erp.bienUso.op;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.bienUso.bm.ConfColAnexoA;
import com.srn.erp.bienUso.bm.MovimientoBienUso;
import com.srn.erp.bienUso.bm.SistemaValuacion;
import com.srn.erp.general.bm.Periodo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ConsultaAnexoA extends Operation {

  Hashtable tiposMov  = null;
  List confColAnexoAIniEjer = null;
  List confColAnexoAEjerAct = null;
  
  public ConsultaAnexoA() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	Periodo periodoDesde 	 = Periodo.findByOid(mapaDatos.getInteger("oid_peri_desde"),getSesion());
	Periodo periodoHasta 	 = Periodo.findByOid(mapaDatos.getInteger("oid_peri_hasta"),getSesion());
	SistemaValuacion sistVal = SistemaValuacion.findByOid(mapaDatos.getInteger("oid_sist_val"),getSesion());
	confColAnexoAIniEjer = ConfColAnexoA.getConfColAnexoAAlIniEjer(getSesion());
	confColAnexoAEjerAct = ConfColAnexoA.getConfColAnexoAEnEjerActual(getSesion());
	
	tiposMov  = MovimientoBienUso.getTiposMovimientos(); 
	
	IDataSet dataset = getDataSetConsAnexoA();
	IDataSet datasetFiltro = getDataSerFiltro();
	
	cargarTituloFiltro(datasetFiltro,
						"Período del "+periodoDesde.getCodigo()+" al período "+periodoHasta.getCodigo()+" "+
						sistVal.getDescripcion()+" (Moneda "+sistVal.getMoneda().getDescripcion()+")");
    consultaAnexoA(dataset,periodoDesde,periodoHasta,sistVal);
    
    writeCliente(dataset);
    writeCliente(datasetFiltro);
  }

  private void consultaAnexoA(IDataSet dataset,
		  					  Periodo periodoDesde,Periodo periodoHasta,
		  					  SistemaValuacion sistemaValuacion) throws BaseException {
	  
	    // Cargar los Movimientos por los Periodos Anteriores
	  	String periodo = "Anteriores al "+periodoDesde.getCodigo();
		Iterator iterMovAnt = 
			MovimientoBienUso.getMovimientosSistValAnterioresAlPeriodo(sistemaValuacion,periodoDesde,getSesion()).iterator();
		while (iterMovAnt.hasNext()) {
			MovimientoBienUso movimientoBienUso = (MovimientoBienUso) iterMovAnt.next();
			cargarConsAnexoA(dataset,
							 movimientoBienUso.getOIDInteger(),
							 periodo,
							 getDescMovPeriAnt(movimientoBienUso.getTipo_mov()),
							 movimientoBienUso.getSub_bien().getBien_uso().getGrupo_bien_uso().getDescripcion()+" - ("+
							 movimientoBienUso.getSub_bien().getBien_uso().getGrupo_bien_uso().getCodigo()+")",
							 movimientoBienUso.getSub_bien().getBien_uso().getDescripcion()+" - ("+
							 movimientoBienUso.getSub_bien().getBien_uso().getCodigo()+")",
							 movimientoBienUso.getSub_bien().getDescripcion()+" - ("+
							 movimientoBienUso.getSub_bien().getCodigo()+")",
							 movimientoBienUso.getImporte().doubleValue()*movimientoBienUso.getSigno().intValue());
		}
		
		// Cargar los Movimientos por los Periodos del intervalo
		String periodoIntervalo = "Período del "+periodoDesde.getCodigo()+" al "+periodoHasta.getCodigo();
		Iterator iterMovIntervalo = 
			MovimientoBienUso.getMovimientosSistValEntrePeriodos(sistemaValuacion,periodoDesde,periodoHasta,getSesion()).iterator();
		while (iterMovIntervalo.hasNext()) {
			MovimientoBienUso movimientoBienUso = (MovimientoBienUso) iterMovIntervalo.next();
			cargarConsAnexoA(dataset,
							 movimientoBienUso.getOIDInteger(),
							 periodoIntervalo,
							 getDescMovIntervalo(movimientoBienUso.getTipo_mov()),
							 movimientoBienUso.getSub_bien().getBien_uso().getGrupo_bien_uso().getDescripcion()+" - ("+
							 movimientoBienUso.getSub_bien().getBien_uso().getGrupo_bien_uso().getCodigo()+")",
							 movimientoBienUso.getSub_bien().getBien_uso().getDescripcion()+" - ("+
							 movimientoBienUso.getSub_bien().getBien_uso().getCodigo()+")",
							 movimientoBienUso.getSub_bien().getDescripcion()+" - ("+
							 movimientoBienUso.getSub_bien().getCodigo()+")",
							 movimientoBienUso.getImporte().doubleValue()*movimientoBienUso.getSigno().intValue());
		}
	  
    
  }
  
  private IDataSet getDataSetConsAnexoA() {
	IDataSet dataset = new TDataSet();
	dataset.create("TConsultaAnexoA");
	dataset.fieldDef(new Field("oid_movin_bien", Field.INTEGER, 0));
	dataset.fieldDef(new Field("periodo", Field.STRING , 100));
	dataset.fieldDef(new Field("movimiento",Field.STRING , 100));
	dataset.fieldDef(new Field("grupo",Field.STRING , 100));
	dataset.fieldDef(new Field("bien",Field.STRING , 100));
	dataset.fieldDef(new Field("subbien",Field.STRING , 100));
	dataset.fieldDef(new Field("importe",Field.CURRENCY , 0));
	return dataset;
  }  
  
  private IDataSet getDataSerFiltro() {
	IDataSet dataset = new TDataSet();
	dataset.create("TFiltro");
	dataset.fieldDef(new Field("filtro", Field.STRING, 200));
	return dataset;
  }  

  private void cargarTituloFiltro(IDataSet dataset,String filtro) throws BaseException {
	dataset.append();
	dataset.fieldValue("filtro",filtro);
  }
  
  
  private void cargarConsAnexoA(IDataSet dataset,
		  						Integer oidMovimiento,
		  						String periodo,
		  						String movimiento,
		  						String grupo,
		  						String bien,
		  						String subbien,
		  						double importe) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_movin_bien", oidMovimiento);
	  dataset.fieldValue("periodo", periodo);
	  dataset.fieldValue("movimiento", movimiento);
	  dataset.fieldValue("grupo", grupo);
	  dataset.fieldValue("bien", bien);
	  dataset.fieldValue("subbien", subbien);
	  dataset.fieldValue("importe", importe);
  }
  
  private String getDescTipoMov(String codigo) throws BaseException {
	  return (String)tiposMov.get(codigo);
  }
  
  private String getDescMovPeriAnt(String tipoMov) throws BaseException {
	  String descMovimiento = null;
	  Iterator iterConfColAnexoA = confColAnexoAIniEjer.iterator();
	  while (iterConfColAnexoA.hasNext()) {
		  ConfColAnexoA confColAnexoA = (ConfColAnexoA) iterConfColAnexoA.next();
		  if (confColAnexoA.tieneEsteMovimiento(tipoMov))
			  return confColAnexoA.getNro_col().toString()+" "+confColAnexoA.getDescripcion(); 
	  }
	  if (descMovimiento == null)
		  throw new ExceptionValidation(null,"Falta configurar una columna para el tipo de Movimiento "+getDescTipoMov(tipoMov));
	  return descMovimiento;
  }
  
  private String getDescMovIntervalo(String tipoMov) throws BaseException {
	  String descMovimiento = null;
	  Iterator iterConfColAnexoA = confColAnexoAEjerAct.iterator();
	  while (iterConfColAnexoA.hasNext()) {
		  ConfColAnexoA confColAnexoA = (ConfColAnexoA) iterConfColAnexoA.next();
		  if (confColAnexoA.tieneEsteMovimiento(tipoMov))
			  return confColAnexoA.getNro_col().toString()+" "+confColAnexoA.getDescripcion(); 
	  }
	  if (descMovimiento == null)
		  throw new ExceptionValidation(null,"Falta configurar una columna para el tipo de Movimiento "+getDescTipoMov(tipoMov));
	  return descMovimiento;
  }

  
}
