package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.legales.bm.EstadoSeclo;
import com.srn.erp.legales.bm.TipoReclamoLeg;
import com.srn.erp.rrhh.bm.ModeloEvalCab;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFiltrosConsSECLOS extends Operation {

	public TraerFiltrosConsSECLOS() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet dsTipoReclamo = getDataSetSelTipoReclamo();
		IDataSet dsLegajos = this.getDataSetSelLegajos();
		IDataSet dsEmpresas = getDataSetSelEmpresas();
		IDataSet dsSector = getDataSetSelSector();
		IDataSet dsPuesto = getDataSetSelPuesto();
		IDataSet dsEstado = getDataSetSelEstado();
		IDataSet dsEstSeclos = getDataSetSelEstadoSECLO();
		
		
		Iterator iterTiposReclamos = TipoReclamoLeg.getAllTiposReclamos(this.getSesion()).iterator();
		while (iterTiposReclamos.hasNext()) {
			TipoReclamoLeg tipoReclamo = (TipoReclamoLeg) iterTiposReclamos.next();
			cargarRegistroTipoReclamo(dsTipoReclamo, tipoReclamo);
		}
		
		Iterator iterEstadosSeclos = EstadoSeclo.getAllEstadosSeclos(this.getSesion()).iterator();
		while (iterEstadosSeclos.hasNext()) {
			EstadoSeclo estadoSeclo = (EstadoSeclo) iterEstadosSeclos.next();
			cargarRegistroEstadoSeclo(dsEstSeclos, estadoSeclo);
		}		
		
		Iterator iterLegajos = Legajo.getAllLegajos(this.getSesion()).iterator();
		while (iterLegajos.hasNext()) {
			Legajo legajo = (Legajo) iterLegajos.next();
			if (!legajo.isActivo()) continue;
			cargarRegistroLegajo(dsLegajos, legajo);
		}
		
		ClasificadorEntidad clasifEmp = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		Iterator iterValClasifEmp = ValorClasificadorEntidad.getValoresClasifEntidad(clasifEmp, this.getSesion()).iterator();
		while (iterValClasifEmp.hasNext()) {
			ValorClasificadorEntidad valClasifEmp = (ValorClasificadorEntidad) iterValClasifEmp.next();
			cargarRegistroValClasifEmp(dsEmpresas, valClasifEmp);
		}
		
		ClasificadorEntidad clasifSec = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		Iterator iterValClasifSec = ValorClasificadorEntidad.getValoresClasifEntidad(clasifSec, this.getSesion()).iterator();
		while (iterValClasifSec.hasNext()) {
			ValorClasificadorEntidad valClasifSec = (ValorClasificadorEntidad) iterValClasifSec.next();
			cargarRegistroValClasifSec(dsSector, valClasifSec);
		}
		
		ClasificadorEntidad clasifPue = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		Iterator iterValClasifPue = ValorClasificadorEntidad.getValoresClasifEntidad(clasifPue, this.getSesion()).iterator();
		while (iterValClasifPue.hasNext()) {
			ValorClasificadorEntidad valClasifPue = (ValorClasificadorEntidad) iterValClasifPue.next();
			cargarRegistroValClasifPue(dsPuesto, valClasifPue);
		}
		
		ClasificadorEntidad clasifEst = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());
		Iterator iterValClasifEst = ValorClasificadorEntidad.getValoresClasifEntidad(clasifEst, this.getSesion()).iterator();
		while (iterValClasifEst.hasNext()) {
			ValorClasificadorEntidad valClasifEst = (ValorClasificadorEntidad) iterValClasifEst.next();
			cargarRegistroValClasifEst(dsEstado, valClasifEst);
		}
		
		
		
		//writeCliente(dsModEval);
		writeCliente(dsLegajos);
		writeCliente(dsEmpresas);
		writeCliente(dsSector);
		writeCliente(dsPuesto);
		writeCliente(dsEstado);
		writeCliente(dsTipoReclamo);
		writeCliente(dsEstSeclos);
		
	}

	private IDataSet getDataSetSelModEval() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSelEvaluaciones");
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_mod_eval", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_mod_eval", Field.STRING, 100));
		return dataset;
	}
	
	private IDataSet getDataSetSelEmpresas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSelEmpresas");
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("razon_social", Field.STRING, 100));
		return dataset;
	}
	
	private IDataSet getDataSetSelSector() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSelSector");
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_sector", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}
	
	private IDataSet getDataSetSelPuesto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSelPuesto");
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_puesto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}
	
	private IDataSet getDataSetSelEstado() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSelEstado");
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}
	
	
	
	private IDataSet getDataSetSelLegajos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSelLegajos");
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_legajo", Field.STRING, 50));
		dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
		return dataset;
	}
	
	
	
	private IDataSet getDataSetSelEstadoSECLO() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSelEstadoSECLO");
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_estado_seclo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_estado_seclo", Field.STRING, 250));
		return dataset;
	}	
	
	private IDataSet getDataSetSelTipoReclamo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSelTipoReclamo");
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_tipo_reclamo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_tipo_reclamo", Field.STRING, 250));
		return dataset;
	}	
	
	
	
	private void cargarRegistroTipoReclamo(IDataSet dataset, TipoReclamoLeg tipoReclamo) throws BaseException {
		dataset.append();
		dataset.fieldValue("sel",false);
		dataset.fieldValue("oid_tipo_reclamo", tipoReclamo.getOIDInteger());
		dataset.fieldValue("desc_tipo_reclamo", tipoReclamo.getDescripcion());
	}
	
	private void cargarRegistroEstadoSeclo(IDataSet dataset, EstadoSeclo estadoSeclo) throws BaseException {
		dataset.append();
		dataset.fieldValue("sel", false);
		dataset.fieldValue("oid_estado_seclo", estadoSeclo.getOIDInteger());
		dataset.fieldValue("desc_estado_seclo", estadoSeclo.getDescripcion());
	}	
	
	
	private void cargarRegistroLegajo(IDataSet dataset, Legajo legajo) throws BaseException {
		dataset.append();
		dataset.fieldValue("sel", false);
		dataset.fieldValue("oid_legajo", legajo.getOIDInteger());
		dataset.fieldValue("nro_legajo", legajo.getNro_legajo());
		dataset.fieldValue("ape_y_nom", legajo.getApellidoyNombre());
	}
	
	

	private void cargarRegistroSelEval(IDataSet dataset, ModeloEvalCab aModeloEvalCab) throws BaseException {
		dataset.append();
		dataset.fieldValue("sel", false);
		dataset.fieldValue("oid_mod_eval", aModeloEvalCab.getOIDInteger());
		dataset.fieldValue("desc_mod_eval", aModeloEvalCab.getTitulo());
	}
	
	private void cargarRegistroValClasifEmp(IDataSet dataset, ValorClasificadorEntidad valorClasifEnt) throws BaseException {
		dataset.append();
		dataset.fieldValue("sel", false);
		dataset.fieldValue("oid_empresa", valorClasifEnt.getOIDInteger());
		dataset.fieldValue("razon_social", valorClasifEnt.getDescripcion());
	}
	
	private void cargarRegistroValClasifSec(IDataSet dataset, ValorClasificadorEntidad valorClasifEnt) throws BaseException {
		dataset.append();
		dataset.fieldValue("sel", false);
		dataset.fieldValue("oid_sector", valorClasifEnt.getOIDInteger());
		dataset.fieldValue("descripcion", valorClasifEnt.getDescripcion());
	}
	
	private void cargarRegistroValClasifPue(IDataSet dataset, ValorClasificadorEntidad valorClasifEnt) throws BaseException {
		dataset.append();
		dataset.fieldValue("sel", false);
		dataset.fieldValue("oid_puesto", valorClasifEnt.getOIDInteger());
		dataset.fieldValue("descripcion", valorClasifEnt.getDescripcion());
	}
	
	private void cargarRegistroValClasifEst(IDataSet dataset, ValorClasificadorEntidad valorClasifEnt) throws BaseException {
		dataset.append();
		dataset.fieldValue("sel", false);
		dataset.fieldValue("oid_estado", valorClasifEnt.getOIDInteger());
		dataset.fieldValue("descripcion", valorClasifEnt.getDescripcion());
	}
	
	

}
