package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.EmpresaCIP;
import com.srn.erp.cip.bm.MotivoVisita;
import com.srn.erp.cip.bm.PermisoVisita;
import com.srn.erp.cip.bm.TarjetaCIP;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.cip.bm.Visita;
import com.srn.erp.sueldos.bm.Legajo;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class AsignarTarjVisita extends Operation {

	String computerName = "";
	String nroTarjeta = null;
	TarjetaCIP tarjeta = null;
	Integer oidTipoDocu = null;
	TipoDocumento tipoDocu = null;
	String nroDocu = null;
	String apeynom = null;
	
	public AsignarTarjVisita() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dsAsigTarjA = this.getDataSetAsignoTarjA();
		
		computerName = mapaDatos.getString("computer_name");
		
		
		IDataSet dataset = mapaDatos.getDataSet("TEntradaVisita");
		procesarRegistros(dataset, dsAsigTarjA);
		writeCliente(dsAsigTarjA);
	}
	

	private void procesarRegistros(IDataSet dataset, IDataSet dsAsignoTarjA) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {

			validarDatos(dataset);	

			Visita buscarVisita = Visita.getVisita(tipoDocu, nroDocu, this.getSesion());

			if (buscarVisita != null) {
				if (buscarVisita.isTieneTarjetaAsignada())
					throw new ExceptionValidation(null, "La visita ya tiene asignada la tarjeta Nro. " + buscarVisita.getTarjetaAsignada().getNro_tarjeta());
				if (!buscarVisita.isActivo())
					throw new ExceptionValidation(null, "La visita se encuentra dada de baja.");

				// Actualizar los Datos de la Visita
				buscarVisita.setApeyNom(apeynom);
				if (buscarVisita.getVisitaA()!=null)
					buscarVisita.setVisitaA(Legajo.findByOidProxy(dataset.getInteger("oid_visita_a"), this.getSesion()));
				if (buscarVisita.getAutoriza()!=null)
					buscarVisita.setAutoriza(Legajo.findByOidProxy(dataset.getInteger("oid_autoriza"), this.getSesion()));
				
				String empresa = dataset.getString("empresa");
				EmpresaCIP empresaCIP = null;
				if ((empresa != null) && (empresa.trim().length()>0)) {
					empresaCIP = EmpresaCIP.getEmpresaCIP(empresa, this.getSesion());
					if (empresaCIP == null) {
						empresaCIP = (EmpresaCIP) EmpresaCIP.getNew(EmpresaCIP.NICKNAME, this.getSesion());
						empresaCIP.setRazon_social(empresa);
						empresaCIP.setActivo(true);
						empresaCIP.save();
					}
				}
				buscarVisita.setEmpresaCIP(empresaCIP);
				
				
				// Asignar a la Tarjeta la Visita
				tarjeta.setVisita(buscarVisita);
				buscarVisita.addTarjetaCIP(tarjeta);
				buscarVisita.save();
				cargarRegistroAsignoTarjA(dsAsignoTarjA, buscarVisita);

			} else {
				// Dar de alta la Visita

				Visita newVisita = (Visita) Visita.getNew(Visita.NICKNAME, this.getSesion());
				newVisita.setApeyNom(apeynom);
				newVisita.setActivo(true);
				newVisita.setFecIngreso(null);
				newVisita.setFecRetiro(null);
				newVisita.setTipoDocumento(tipoDocu);
				newVisita.setNroDocumento(nroDocu);
				newVisita.setGrupoPuertaIngreso(null);
				newVisita.setGrupoPuertaEgreso(null);
				newVisita.setVisitaA(Legajo.findByOidProxy(dataset.getInteger("oid_visita_a"), this.getSesion()));
				newVisita.setAutoriza(Legajo.findByOidProxy(dataset.getInteger("oid_autoriza"), this.getSesion()));
				newVisita.setMotivoVisita(MotivoVisita.findByOidProxy(dataset.getInteger("oid_motivo"), this.getSesion()));

				String empresa = dataset.getString("empresa");
				EmpresaCIP empresaCIP = null;
				if ((empresa != null) && (empresa.trim().length()>0)) {
					empresaCIP = EmpresaCIP.getEmpresaCIP(empresa, this.getSesion());
					if (empresaCIP == null) {
						empresaCIP = (EmpresaCIP) EmpresaCIP.getNew(EmpresaCIP.NICKNAME, this.getSesion());
						empresaCIP.setRazon_social(empresa);
						empresaCIP.setActivo(true);
						empresaCIP.save();
					}
				}
				newVisita.setEmpresaCIP(empresaCIP);
				newVisita.setZonaActual(null);

				// Asignar a la Tarjeta la Visita
				tarjeta.setVisita(newVisita);
				newVisita.addTarjetaCIP(tarjeta);
				newVisita.save();
				cargarRegistroAsignoTarjA(dsAsignoTarjA, newVisita);
			}
			
			
			// Habilitar Pemiso Visita
			if (tarjeta.isTipoVisitaDia()) {
				PermisoVisita permisoVisita = (PermisoVisita) PermisoVisita.getNew(PermisoVisita.NICKNAME, this.getSesion());
				permisoVisita.setActivo(true);
				permisoVisita.setPrioridad(PermisoVisita.PRIO_ASIG_TARJ);
				permisoVisita.setVisita(tarjeta.getVisita());
				permisoVisita.setPermiso(Visita.HAB_PERMI);
				permisoVisita.setGrupo_puerta(tarjeta.getVisita().getGrupoPuertas(computerName));
				java.util.Date fecIngDesde = UtilCIP.getFechaHoraActual(this.getSesion());
				java.util.Date fecIngHasta = Fecha.getFechaMasMinutos(fecIngDesde,getToleracionEntMinutos(tarjeta));
				permisoVisita.setFec_hor_desde(fecIngDesde);
				permisoVisita.setFec_hor_hasta(fecIngHasta);
				permisoVisita.setSentido(PermisoVisita.SENTIDO_E);
				permisoVisita.setTarjeta(tarjeta);
				permisoVisita.setVisitaA(Legajo.findByOidProxy(dataset.getInteger("oid_visita_a"), this.getSesion()));
				permisoVisita.setAutoriza(Legajo.findByOidProxy(dataset.getInteger("oid_autoriza"), this.getSesion()));
				permisoVisita.save();
			}
			
			dataset.next();
		}
	}
	
	private int getToleracionEntMinutos(TarjetaCIP tarjeta) throws BaseException {
		if (tarjeta.getToleranciaIngVisMin().intValue() != 0)
			return tarjeta.getToleranciaIngVisMin();
		else return Visita.getToleranciaMinEntVisita(this.getSesion());
	}
	
	private void validarDatos(IDataSet dataset) throws BaseException {
		
		nroTarjeta = dataset.getString("nro_tarjeta");
		if (nroTarjeta == null)
			throw new ExceptionValidation(null, "Debe ingresar el Nro. de Tarjeta");

		tarjeta = TarjetaCIP.getTarjetaCIP(nroTarjeta, this.getSesion());
		if (tarjeta == null)
			throw new ExceptionValidation(null, "Nro. de Tarjeta inexistente");

		if (!tarjeta.isParaVisita())
			throw new ExceptionValidation(null, "La tarjeta ingresada no corresponde a una tarjeta de Visita.");

		if (tarjeta.isTarjetaDesHabilitada())
			throw new ExceptionValidation(null, "La tarjeta ingresada se encuentra deshabilitada");

		if (!tarjeta.isVigentaAFecHora(UtilCIP.getFechaHoraActual(this.getSesion())))
			throw new ExceptionValidation(null, "La tarjeta no se encuentra vigente");

		if (tarjeta.isTarjetaAsignada())
			throw new ExceptionValidation(null, "La tarjeta ya se encuentra asignada.");

		oidTipoDocu = dataset.getInteger("oid_tipo_docu");
		if (oidTipoDocu == null)
			throw new ExceptionValidation(null, "Debe ingresar el tipo de documento.");
		tipoDocu = TipoDocumento.findByOidProxy(oidTipoDocu, this.getSesion());
		if (tipoDocu == null)
			throw new ExceptionValidation(null, "Debe ingresar el tipo de documento.");

		nroDocu = dataset.getString("nro_documento");
		if (nroDocu == null)
			throw new ExceptionValidation(null, "Debe ingresar el Nro. de Documento");
		
		apeynom = dataset.getString("ape_y_nom");
		if (apeynom == null)
			throw new ExceptionValidation(null, "Debe ingresar el Apellido y Nombre");
		if (apeynom.trim().length() == 0)
			throw new ExceptionValidation(null, "Debe ingresar el Apellido y Nombre");
		
		
	}
	

	private IDataSet getDataSetAsignoTarjA() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAsignoTarjA");
		dataset.fieldDef(new Field("oid_visita", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistroAsignoTarjA(IDataSet dataset, Visita aVisita) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_visita", aVisita.getOIDInteger());

	}

}
