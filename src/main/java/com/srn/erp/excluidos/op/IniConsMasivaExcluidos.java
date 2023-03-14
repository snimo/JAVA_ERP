package com.srn.erp.excluidos.op;

import java.util.Iterator;

import com.srn.erp.excluidos.bm.ExcluidoConsMas;
import com.srn.erp.excluidos.bm.IndividuoExcluido;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class IniConsMasivaExcluidos extends Operation {

	public IniConsMasivaExcluidos() {
	}
	
	public void prepararConsulta(MapDatos mapaDatos) throws BaseException {

		IDataSet dsControlador = getDSControladorConsMasExc();
		
		java.util.Date fecha = Fecha.getFechaActual();
		Integer nroLote = this.getSesion().getNewOIDByKey(ExcluidoConsMas.NRO_LOTE_CONS_EXC);
		HashTableDatos condiciones = new HashTableDatos();
		int secu = 1;
		Iterator iterIndiExc =
			IndividuoExcluido.getConsultaMasiva(condiciones, this.getSesion()).iterator();
		while (iterIndiExc.hasNext()) {
			IndividuoExcluido individuo = (IndividuoExcluido) iterIndiExc.next();
			procesarIndividuo(individuo,fecha , nroLote, secu);
			++secu;
		}
		
		writeCliente(dsControlador);
		
		
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		if (mapaDatos.containsKey("preparacion"))
			prepararConsulta(mapaDatos);
		
	}
	
	private void procesarIndividuo(IndividuoExcluido individuo  , java.util.Date fecha , Integer nroLote , int secu) throws BaseException {
		ExcluidoConsMas exluidoCons =
			(ExcluidoConsMas)ExcluidoConsMas.getNew(ExcluidoConsMas.NICKNAME, this.getSesion());
		exluidoCons.setIndividuo(individuo);
		exluidoCons.setActivo(true);
		exluidoCons.setFecha(fecha);
		exluidoCons.setNro_lote(nroLote);
		exluidoCons.setNro_orden(secu);
		this.addTransaccion(exluidoCons);		
	}
	
	private IDataSet getDSControladorConsMasExc() {
		IDataSet dataset = new TDataSet();
		dataset.create("TControladorConsMas");
		dataset.fieldDef(new Field("nro_lote", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_reg_totales", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_reg_lote", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cargo_todos", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("primer_reg_lote", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ultimo_reg_lote", Field.INTEGER, 0));
		return dataset;
	}
	
	private void cargarRegControlador(
			Integer nroLote,
			Integer cantReg,
			Integer cantRegLote,
			Boolean cargo_todos, 
			Integer primerRegLote,
			Integer ultimoRegLote,
			IDataSet ds) throws BaseException {
		ds.append();
		
		ds.fieldValue("nro_lote", nroLote);
		ds.fieldValue("cant_reg_totales", cantReg);
		ds.fieldValue("cant_reg_lote", cantRegLote);
		ds.fieldValue("cargo_todos", cargo_todos);
		ds.fieldValue("primer_reg_lote", primerRegLote);
		ds.fieldValue("ultimo_reg_lote", ultimoRegLote);
		
	}

	private IDataSet getDataSetConsMasiva() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConsultaIndividuo");
		dataset.fieldDef(new Field("oid_individuo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_estado", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_tipo_docu", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_documento", Field.STRING, 50));
		dataset.fieldDef(new Field("tipo_individuo", Field.STRING, 50));
		dataset.fieldDef(new Field("apellido", Field.STRING, 100));
		dataset.fieldDef(new Field("nombre", Field.STRING, 100));
		dataset.fieldDef(new Field("apodo", Field.STRING, 100));
		dataset.fieldDef(new Field("nacionalidad", Field.STRING, 100));
		dataset.fieldDef(new Field("sexo", Field.STRING, 100));
		dataset.fieldDef(new Field("raza", Field.STRING, 100));
		dataset.fieldDef(new Field("altura", Field.STRING, 100));
		dataset.fieldDef(new Field("complexion", Field.STRING, 100));
		dataset.fieldDef(new Field("edad", Field.STRING, 100));
		dataset.fieldDef(new Field("color", Field.STRING, 100));
		dataset.fieldDef(new Field("tipo_barba", Field.STRING, 100));
		dataset.fieldDef(new Field("cabello", Field.STRING, 100));
		dataset.fieldDef(new Field("nariz", Field.STRING, 100));
		dataset.fieldDef(new Field("anteojos", Field.STRING, 100));
		dataset.fieldDef(new Field("marcas", Field.STRING, 100));
		dataset.fieldDef(new Field("rasgos", Field.STRING, 100));
		dataset.fieldDef(new Field("legajo", Field.STRING, 100));
		dataset.fieldDef(new Field("sector", Field.STRING, 100));
		dataset.fieldDef(new Field("cargo", Field.STRING, 100));
		dataset.fieldDef(new Field("condicion", Field.STRING, 100));
		return dataset;
	}
	
	

	private void cargarRegistroIndividuo(IDataSet dataset, IndividuoExcluido individuo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_individuo", individuo.getOIDInteger());
		if (individuo.getEstado() != null)
			dataset.fieldValue("desc_estado", individuo.getEstado().getDescripcion());
		else
			dataset.fieldValue("desc_estado", "");
		if (individuo.getTipo_documento() != null)
			dataset.fieldValue("desc_tipo_docu", individuo.getTipo_documento().getDescripcion());
		else
			dataset.fieldValue("desc_tipo_docu", "");
		dataset.fieldValue("nro_documento", individuo.getNro_documento());
		dataset.fieldValue("tipo_individuo", individuo.getTipo());
		dataset.fieldValue("apellido", individuo.getApellido());
		dataset.fieldValue("nombre", individuo.getNombre());
		dataset.fieldValue("apodo", individuo.getApodo());
		if (individuo.getNacionalidad() != null)
			dataset.fieldValue("nacionalidad", individuo.getNacionalidad().getDescripcion());
		else
			dataset.fieldValue("nacionalidad", "");
		dataset.fieldValue("sexo", individuo.getSexo());
		if (individuo.getRaza() != null)
			dataset.fieldValue("raza", individuo.getRaza().getDescripcion());
		else
			dataset.fieldValue("raza", "");
		if (individuo.getAltura() != null)
			dataset.fieldValue("altura", individuo.getAltura().getDescripcion());
		else
			dataset.fieldValue("altura", "");
		if (individuo.getComplexion() != null)
			dataset.fieldValue("complexion", individuo.getComplexion().getDescripcion());
		else
			dataset.fieldValue("complexion", "");
		if (individuo.getEdad() != null)
			dataset.fieldValue("edad", individuo.getEdad().getDescripcion());
		else
			dataset.fieldValue("edad", "");
		if (individuo.getColor() != null)
			dataset.fieldValue("color", individuo.getColor().getDescripcion());
		else
			dataset.fieldValue("color", "");
		if (individuo.getTipo_barba() != null)
			dataset.fieldValue("tipo_barba", individuo.getTipo_barba().getDescripcion());
		else
			dataset.fieldValue("tipo_barba", "");
		if (individuo.getTipo_cabello() != null)
			dataset.fieldValue("cabello", individuo.getTipo_cabello().getDescripcion());
		else
			dataset.fieldValue("cabello", "");
		if (individuo.getTipo_nariz() != null)
			dataset.fieldValue("nariz", individuo.getTipo_nariz().getDescripcion());
		else
			dataset.fieldValue("nariz", "");
		if (individuo.isAnteojos().booleanValue())
			dataset.fieldValue("anteojos", "SI");
		else
			dataset.fieldValue("anteojos", "NO");
		dataset.fieldValue("marcas", individuo.getMarcas());
		dataset.fieldValue("rasgos", individuo.getRasgos());
		dataset.fieldValue("legajo", individuo.getNro_legajo());
		if (individuo.getSector() != null)
			dataset.fieldValue("sector", individuo.getSector().getDescripcion());
		else
			dataset.fieldValue("sector", "");
		if (individuo.getCargo() != null)
			dataset.fieldValue("cargo", individuo.getCargo().getDescripcion());
		else
			dataset.fieldValue("cargo", "");
		dataset.fieldValue("condicion", individuo.getTipo_condicion());
	}
}
