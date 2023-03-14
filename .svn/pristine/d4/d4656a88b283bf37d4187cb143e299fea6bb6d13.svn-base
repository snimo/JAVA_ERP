package com.srn.erp.conciTarjeta.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.bm.TarjetaConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerResumenPOSNET extends Operation {

	int secu = 0;

	public TraerResumenPOSNET() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsResumenPOSNET = this.getDSResumenPOSNET();

		HashTableDatos condiciones = new HashTableDatos();

		Integer oidEmpresa = mapaDatos.getInteger("oid_empresa");
		EmpresaConciTar empresa = EmpresaConciTar.findByOidProxy(oidEmpresa, this.getSesion());
		if (empresa == null)
			throw new ExceptionValidation(null, "Debe seleccionar una empresa");
		condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		boolean pendConci = false;

		IDataSet ds = mapaDatos.getDataSet("TInput");
		ds.first();
		while (!ds.EOF()) {

			java.util.Date fecOperDesde = ds.getDate("fec_oper_desde");
			if (fecOperDesde != null)
				condiciones.put("FEC_OPER_DESDE", fecOperDesde);
			java.util.Date fecOperHasta = ds.getDate("fec_oper_hasta");
			if (fecOperHasta != null)
				condiciones.put("FEC_OPER_HASTA", fecOperHasta);
			java.util.Date fecCierreDesde = ds.getDate("fec_cie_desde");
			if (fecCierreDesde != null)
				condiciones.put("FEC_CIERRE_DESDE", fecCierreDesde);
			java.util.Date fecCierreHasta = ds.getDate("fec_cie_hasta");
			if (fecCierreHasta != null)
				condiciones.put("FEC_CIERRE_HASTA", fecCierreHasta);
			String cupoPresentado = ds.getString("cupo_presentado");
			if (cupoPresentado != null)
				condiciones.put("CUPO_PRESENTADO", cupoPresentado);

			java.util.Date fecPresenDesde = ds.getDate("fec_des_presen");
			if (fecPresenDesde != null)
				condiciones.put("FEC_PRESEN_DESDE", fecPresenDesde);

			java.util.Date fecPresenHasta = ds.getDate("fec_has_presen");
			if (fecPresenHasta != null)
				condiciones.put("FEC_PRESEN_HASTA", fecPresenHasta);

			TarjetaConciTar tarjeta = TarjetaConciTar.findByOidProxy(ds.getInteger("oid_tarjeta"), this.getSesion());
			if (tarjeta != null)
				condiciones.put(TarjetaConciTar.NICKNAME, tarjeta);

			pendConci = ds.getBoolean("pend_conci");
			if (pendConci == true)
				condiciones.put("PEND_CONCI", "");

			boolean conciSinConfirmar = ds.getBoolean("conci_sin_confirmar");
			if (conciSinConfirmar == true)
				condiciones.put("CONCI_SIN_CONF", "");

			boolean conciConfirmado = ds.getBoolean("conci_confirmado");
			if (conciConfirmado == true)
				condiciones.put("CONCI_CONF", "");

			java.util.Date fecDesdePendConci = ds.getDate("fec_desde_pend_conci");
			if (fecDesdePendConci != null)
				condiciones.put("FEC_DESDE_PEND_CONCI", fecDesdePendConci);

			java.util.Date fecHastaPendConci = ds.getDate("fec_hasta_pend_conci");
			if (fecHastaPendConci != null)
				condiciones.put("FEC_HASTA_PEND_CONCI", fecHastaPendConci);

			java.util.Date fecDesdeConciSinConf = ds.getDate("fec_desde_conci_sin_conf");
			if (fecDesdeConciSinConf != null)
				condiciones.put("FEC_DESDE_CONCI_SIN_CONF", fecDesdeConciSinConf);

			java.util.Date fecHastaConciSinConf = ds.getDate("fec_hasta_conci_sin_conf");
			if (fecHastaConciSinConf != null)
				condiciones.put("FEC_HASTA_CONCI_SIN_CONF", fecHastaConciSinConf);

			java.util.Date fecDesdeConfirmado = ds.getDate("fec_desde_confirmado");
			if (fecDesdeConfirmado != null)
				condiciones.put("FEC_DESDE_CONF", fecDesdeConfirmado);

			java.util.Date fecHastaConfirmado = ds.getDate("fec_hasta_confirmado");
			if (fecHastaConfirmado != null)
				condiciones.put("FEC_HASTA_CONF", fecHastaConfirmado);

			int nroConci = -1;

			List cuponesPOSNET = new ArrayList();
			List cuponesTARJ = new ArrayList();

			Iterator iterDetCupo = ArchLoteConciDet.getAllByCondiciones(condiciones, this.getSesion()).iterator();
			while (iterDetCupo.hasNext()) {
				ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterDetCupo.next();
				String descNeg = "";
				String conciliado = "NO";
				String confirmado = "NO";
				
				if (archLoteConciDet.isPreconci())
					conciliado = "SI";
				if (archLoteConciDet.isConciliado())
					confirmado = "SI";
				
				descNeg = archLoteConciDet.getUnidad_negocio().getDescripcion();
				cargarRegistro(
						dsResumenPOSNET, 
						++secu, 
						archLoteConciDet.getTipo_operacion(), 
						descNeg,
						archLoteConciDet.getNro_terminal(),
						archLoteConciDet.getFecCierre(),
						archLoteConciDet.getFecOperDate(), 
						archLoteConciDet.getTarjeta(),
						archLoteConciDet.getNro_lote(),
						archLoteConciDet.getTicket(),
						archLoteConciDet.getUltimosNrosTarjeta(),
						archLoteConciDet.getMonto(),
						conciliado,
						confirmado);
				
			}
			break;
		}
		
		writeCliente(dsResumenPOSNET);
	}

	private IDataSet getDSResumenPOSNET() {
		IDataSet dataset = new TDataSet();
		dataset.create("TResumenPOSNET");
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_operacion", Field.STRING, 50));
		dataset.fieldDef(new Field("unidad_negocio", Field.STRING, 50));
		dataset.fieldDef(new Field("posnet", Field.STRING, 50));
		dataset.fieldDef(new Field("fec_lote", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_origen", Field.DATE, 0));
		dataset.fieldDef(new Field("tarjeta", Field.STRING, 50));
		dataset.fieldDef(new Field("lote", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cupon", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_tarjeta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("conciliado", Field.STRING, 2));
		dataset.fieldDef(new Field("confirmado", Field.STRING, 2));
		
		return dataset;
	}

	private void cargarRegistro(
			IDataSet dataset, Integer secu, String tipoOperacion, String unidadNegocio, String posnet,
			java.util.Date fecLote, java.util.Date fecOrigen, String tarjeta, Integer lote, 
			String cupon, Integer nroTarjeta,
			double importe,
			String conciliado,
			String confirmado
			) throws BaseException {
		dataset.append();
		dataset.fieldValue("secu", secu);
		dataset.fieldValue("tipo_operacion", tipoOperacion);
		dataset.fieldValue("unidad_negocio", unidadNegocio);
		dataset.fieldValue("posnet", posnet);
		dataset.fieldValue("fec_lote", fecLote);
		dataset.fieldValue("fec_origen", fecOrigen);
		dataset.fieldValue("tarjeta", tarjeta);
		dataset.fieldValue("lote", lote);
		dataset.fieldValue("cupon", cupon);
		dataset.fieldValue("nro_tarjeta", nroTarjeta);
		dataset.fieldValue("importe", importe);
		dataset.fieldValue("conciliado", conciliado);
		dataset.fieldValue("confirmado", confirmado);

	}
}
