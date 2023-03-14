package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.CIPFichadaOficina;
import com.srn.erp.cip.bm.MotivoFichadaCIP;
import com.srn.erp.cip.bm.PuntoFichadaCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFichadaOficina extends Operation {

	public TraerFichadaOficina() {
	}
	
	HashTableDatos cacheLegajos = new HashTableDatos();
	HashTableDatos puntoFichada = new HashTableDatos();
	HashTableDatos motivoFichada = new HashTableDatos();	

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSetFichada();
		
		java.util.Date fecDesde = mapaDatos.getDate("fec_desde");
		java.util.Date fecHasta = mapaDatos.getDate("fec_hasta");
		
		if (fecDesde==null)
			throw new ExceptionValidation(null,"Debe ingresar la fecha desde");
		
		if (fecHasta==null)
			throw new ExceptionValidation(null,"Debe ingresar la fecha hasta");		
		
		cargarCache();
		
		Legajo legajo = null;
		if (mapaDatos.containsKey("oid_legajo")) 
			legajo = Legajo.findByOidProxy(mapaDatos.getInteger("oid_legajo"), this.getSesion());
		
		Iterator iterFichadas = CIPFichadaOficina.getFichadasOficinaAsc(fecDesde, fecHasta, legajo, this.getSesion()).iterator();
		while (iterFichadas.hasNext()) {
			CIPFichadaOficina fichada = (CIPFichadaOficina) iterFichadas.next();
			cargarRegistro(ds, fichada);
		}
		
		writeCliente(ds);
	}

	private IDataSet getDataSetFichada() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFichadaOficina");
		dataset.fieldDef(new Field("oid_in_out_ofic", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("legajo", Field.STRING, 50));
		dataset.fieldDef(new Field("nombre_legajo", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_hor", Field.STRING, 30));
		dataset.fieldDef(new Field("sentido", Field.STRING, 1));
		dataset.fieldDef(new Field("oid_pto_fichada", Field.INTEGER, 0));
		dataset.fieldDef(new Field("pto_fichada", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_motivo_fichada", Field.INTEGER, 0));
		dataset.fieldDef(new Field("motivo", Field.STRING, 100));
		dataset.fieldDef(new Field("observacion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, CIPFichadaOficina fichada) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_in_out_ofic", fichada.getOIDInteger());
		dataset.fieldValue("oid_legajo", fichada.getLegajo().getOIDInteger());
		dataset.fieldValue("legajo", fichada.getLegajo().getCodigo());
		
		String nombre = (String) this.cacheLegajos.get(fichada.getLegajo().getOIDInteger());
		if (nombre==null) {
			nombre = fichada.getLegajo().getApellidoyNombre();
			this.cacheLegajos.put(fichada.getLegajo().getOIDInteger(),fichada.getLegajo().getApellidoyNombre());
		}
		
		dataset.fieldValue("nombre_legajo", nombre);
		dataset.fieldValue("fec_hor", Fecha.getFormatoFecHoraMin(fichada.getFec_hor()));
		dataset.fieldValue("sentido", fichada.getSentido());
		dataset.fieldValue("oid_pto_fichada", fichada.getOid_pto_fichada().getOID());
		dataset.fieldValue("pto_fichada", (String) this.puntoFichada.get(fichada.getOid_pto_fichada().getOIDInteger()));
		dataset.fieldValue("oid_motivo_fichada", fichada.getMotivo_fichada().getOIDInteger());
		dataset.fieldValue("motivo", (String) this.motivoFichada.get(fichada.getMotivo_fichada().getOIDInteger()));
		dataset.fieldValue("observacion", fichada.getObservacion());
		dataset.fieldValue("activo", fichada.isActivo());
	}
	
	private void cargarCache() throws BaseException {
		
		//Iterator iterLeg = Legajo.getAllLegajos(this.getSesion()).iterator();
		//while (iterLeg.hasNext()) {
		//	Legajo legajo = (Legajo) iterLeg.next();
		//	this.cacheLegajos.put(legajo.getOIDInteger(), legajo.getApellidoyNombre());
		//}
		
		Iterator iterPuntoFichadas = PuntoFichadaCIP.getAllPuntosFichada(this.getSesion()).iterator();
		while (iterPuntoFichadas.hasNext()) {
			PuntoFichadaCIP ptoFichadaCIP = (PuntoFichadaCIP) iterPuntoFichadas.next();
			this.puntoFichada.put(ptoFichadaCIP.getOIDInteger(), ptoFichadaCIP.getDescripcion());
		}
		
		
		Iterator iterMotFichadas = MotivoFichadaCIP.getMotivosFichadas(this.getSesion()).iterator();
		while (iterMotFichadas.hasNext()) {
			MotivoFichadaCIP motFichadaCIP = (MotivoFichadaCIP) iterMotFichadas.next();
			this.motivoFichada.put(motFichadaCIP.getOIDInteger(), motFichadaCIP.getDescripcion());
		}
		
	}

}
