package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.legales.bm.Abogado;
import com.srn.erp.legales.bm.EmpresaJuicio;
import com.srn.erp.legales.bm.EstadoJuicio;
import com.srn.erp.legales.bm.EstadoProcesal;
import com.srn.erp.legales.bm.EstadoSeclo;
import com.srn.erp.legales.bm.Fuero;
import com.srn.erp.legales.bm.Juzgado;
import com.srn.erp.legales.bm.ResulProbJuicio;
import com.srn.erp.legales.bm.ResultadoJuicio;
import com.srn.erp.legales.bm.TipoReclamoLeg;
import com.srn.erp.rrhh.bm.ModeloEvalCab;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFiltrosConsJUICIOS extends Operation {

	public TraerFiltrosConsJUICIOS() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsTipoReclamo = getDataSetSelTipoReclamo();
		IDataSet dsLegajos = this.getDataSetSelLegajos();
		IDataSet dsEmpresas = getDataSetSelEmpresas();
		IDataSet dsSector = getDataSetSelSector();
		IDataSet dsPuesto = getDataSetSelPuesto();
		IDataSet dsEstado = getDataSetSelEstado();
		IDataSet dsEstSeclos = getDataSetSelEstadoSECLO();
		IDataSet dsResulProb = getDataSetResulProbJuicio();
		IDataSet dsEstadosProcesales = getDataSetEstadosProcesales();
		IDataSet dsJuzgado = getDataSetJuzgado();
		IDataSet dsEstadoJuicio = getDataSetEstadoJuicio();
		IDataSet dsResultadoJuicio = getDataSetResulJuicio();
		IDataSet dsAbogados = getDataSetAbogados();
		IDataSet dsFueros = getDataSetFueros();

		Iterator iterTiposReclamos = TipoReclamoLeg.getAllTiposReclamos(this.getSesion()).iterator();
		while (iterTiposReclamos.hasNext()) {
			TipoReclamoLeg tipoReclamo = (TipoReclamoLeg) iterTiposReclamos.next();
			cargarRegistroTipoReclamo(dsTipoReclamo, tipoReclamo);
		}
		
		Iterator iterFueros = Fuero.getAllFueros(this.getSesion()).iterator();
		while (iterFueros.hasNext()) {
			Fuero fuero = (Fuero) iterFueros.next();
			cargarRegistroFuero(dsFueros, fuero);
		}		

		Iterator iterEstadosSeclos = EstadoSeclo.getAllEstadosSeclos(this.getSesion()).iterator();
		while (iterEstadosSeclos.hasNext()) {
			EstadoSeclo estadoSeclo = (EstadoSeclo) iterEstadosSeclos.next();
			cargarRegistroEstadoSeclo(dsEstSeclos, estadoSeclo);
		}

		Iterator iterLegajos = Legajo.getAllLegajos(this.getSesion()).iterator();
		while (iterLegajos.hasNext()) {
			Legajo legajo = (Legajo) iterLegajos.next();
			if (!legajo.isActivo())
				continue;
			cargarRegistroLegajo(dsLegajos, legajo);
		}

		Iterator iterEmpresaJuicios = EmpresaJuicio.getAll(this.getSesion()).iterator();
		while (iterEmpresaJuicios.hasNext()) {
			EmpresaJuicio empresaJuicio = (EmpresaJuicio) iterEmpresaJuicios.next();
			cargarRegistroValClasifEmp(dsEmpresas, empresaJuicio);
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

		Iterator iterResulProb = ResulProbJuicio.getResultadosProbales().keySet().iterator();
		while (iterResulProb.hasNext()) {
			String codigo = (String) iterResulProb.next();
			String descripcion = (String) ResulProbJuicio.getResultadosProbales().get(codigo);
			cargarRegistroProbResulJuicio(dsResulProb, codigo, descripcion);
		}

		Iterator iterEstadosProcesales = EstadoProcesal.getEstadosProcesales(this.getSesion()).iterator();
		while (iterEstadosProcesales.hasNext()) {
			EstadoProcesal estadoProcesal = (EstadoProcesal) iterEstadosProcesales.next();
			cargarRegistroEstadoProcesal(dsEstadosProcesales, estadoProcesal);
		}

		Iterator iterJuzgados = Juzgado.getAllJuzgados(this.getSesion()).iterator();
		while (iterJuzgados.hasNext()) {
			Juzgado juzgado = (Juzgado) iterJuzgados.next();
			cargarRegistroJuzgado(dsJuzgado, juzgado);
		}

		Iterator iterEstadosJuicio = EstadoJuicio.getAllEstados(this.getSesion()).iterator();
		while (iterEstadosJuicio.hasNext()) {
			EstadoJuicio estadoJuicio = (EstadoJuicio) iterEstadosJuicio.next();
			cargarRegistroEstadoJuicio(dsEstadoJuicio, estadoJuicio);
		}

		Iterator iterResultadoJuicio = ResultadoJuicio.getAll(this.getSesion()).iterator();
		while (iterResultadoJuicio.hasNext()) {
			ResultadoJuicio resultadoJuicio = (ResultadoJuicio) iterResultadoJuicio.next();
			cargarRegistroResulJuicio(dsResultadoJuicio, resultadoJuicio);
		}
		
		Iterator iterAbogados = Abogado.getAll(this.getSesion()).iterator();
		while (iterAbogados.hasNext()) {
			Abogado abogado = (Abogado) iterAbogados.next();
			cargarRegistroAbogador(dsAbogados, abogado);
		}		

		// writeCliente(dsModEval);
		writeCliente(dsLegajos);
		writeCliente(dsEmpresas);
		writeCliente(dsSector);
		writeCliente(dsPuesto);
		writeCliente(dsEstado);
		writeCliente(dsTipoReclamo);
		writeCliente(dsEstSeclos);
		writeCliente(dsResulProb);
		writeCliente(dsEstadosProcesales);
		writeCliente(dsJuzgado);
		writeCliente(dsEstadoJuicio);
		writeCliente(dsResultadoJuicio);
		writeCliente(dsAbogados);
		writeCliente(dsFueros);

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
		dataset.fieldValue("sel", false);
		dataset.fieldValue("oid_tipo_reclamo", tipoReclamo.getOIDInteger());
		dataset.fieldValue("desc_tipo_reclamo", tipoReclamo.getDescripcion());
	}
	
	private void cargarRegistroFuero(IDataSet dataset, Fuero aFuero) throws BaseException {
		dataset.append();
		dataset.fieldValue("sel", false);
		dataset.fieldValue("oid_fuero", aFuero.getOIDInteger());
		dataset.fieldValue("descripcion", aFuero.getDescripcion());
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

	private void cargarRegistroValClasifEmp(IDataSet dataset, EmpresaJuicio empresaJuicio) throws BaseException {
		dataset.append();
		dataset.fieldValue("sel", false);
		dataset.fieldValue("oid_empresa", empresaJuicio.getOIDInteger());
		dataset.fieldValue("razon_social", empresaJuicio.getDescripcion());
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

	private IDataSet getDataSetResulProbJuicio() {
		IDataSet dataset = new TDataSet();
		dataset.create("TResulProbJuicio");
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private IDataSet getDataSetEstadosProcesales() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEstadosProcesales");
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private IDataSet getDataSetJuzgado() {
		IDataSet dataset = new TDataSet();
		dataset.create("TJuzgado");
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private IDataSet getDataSetEstadoJuicio() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEstadoJuicio");
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}
	
	private IDataSet getDataSetResulJuicio() {
		IDataSet dataset = new TDataSet();
		dataset.create("TResultadoJuicio");
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}	
	
	private IDataSet getDataSetAbogados() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAbogados");
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_abogado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}
	
	private IDataSet getDataSetFueros() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFuero");
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_fuero", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}	
	
	private void cargarRegistroAbogador(IDataSet dataset, Abogado abogado) throws BaseException {
		dataset.append();
		dataset.fieldValue("sel", false);
		dataset.fieldValue("oid_abogado", abogado.getOIDInteger());
		dataset.fieldValue("descripcion", abogado.getApeyNom());
	}	
	

	private void cargarRegistroEstadoProcesal(IDataSet dataset, EstadoProcesal estado) throws BaseException {
		dataset.append();
		dataset.fieldValue("sel", false);
		dataset.fieldValue("oid", estado.getOIDInteger());
		dataset.fieldValue("codigo", estado.getCodigo());
		dataset.fieldValue("descripcion", estado.getDescripcion());
	}

	private void cargarRegistroEstadoJuicio(IDataSet dataset, EstadoJuicio estado) throws BaseException {
		dataset.append();
		dataset.fieldValue("sel", false);
		dataset.fieldValue("oid", estado.getOIDInteger());
		dataset.fieldValue("codigo", estado.getCodigo());
		dataset.fieldValue("descripcion", estado.getDescripcion());
	}

	private void cargarRegistroJuzgado(IDataSet dataset, Juzgado aJuzgado) throws BaseException {
		dataset.append();
		dataset.fieldValue("sel", false);
		dataset.fieldValue("oid", aJuzgado.getOIDInteger());
		dataset.fieldValue("codigo", aJuzgado.getCodigo());
		dataset.fieldValue("descripcion", aJuzgado.getDireccion());
	}

	private void cargarRegistroProbResulJuicio(IDataSet dataset, String codigo, String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("sel", false);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

	private void cargarRegistroResulJuicio(IDataSet dataset, ResultadoJuicio resultadoJuicio) throws BaseException {
		dataset.append();
		dataset.fieldValue("sel", false);
		dataset.fieldValue("oid", resultadoJuicio.getOIDInteger());
		dataset.fieldValue("codigo", resultadoJuicio.getCodigo());
		dataset.fieldValue("descripcion", resultadoJuicio.getDescripcion());
	}

}
