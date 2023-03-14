package com.srn.erp.contabilidad.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.da.DBAnuladorAsientoManualDet;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class AnuladorAsientoManual extends ComproCab implements IContabilizable {

	public ComproCab getComprobante() throws BaseException {
		// TODO Auto-generated method stub
		return this;
	}

	public Date getImputacion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getImputac();
	}

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AnuladorAsientoManual() {
	}
	
  private List detalles = new ArrayList();
  private boolean readDetalles = true;
	

	public static String	NICKNAME	= "cg.AnuladorAsientoManual";

	private AsientoManual	asiento_manual;

	public AsientoManual getAsiento_manual() throws BaseException {
		supportRefresh();
		return asiento_manual;
	}

	public void setAsiento_manual(AsientoManual aAsiento_manual) {
		this.asiento_manual = aAsiento_manual;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuladorAsientoManual findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AnuladorAsientoManual) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnuladorAsientoManual findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AnuladorAsientoManual) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getDetallesAnuladosAsiento(
			AnuladorAsientoManual anuladorAsientoManual, 
			ISesion aSesion)
			throws BaseException {
		return DBAnuladorAsientoManualDet.getDetallesAnuladosAsiento(anuladorAsientoManual, aSesion);
	}
	
  public List getDetallesAnulados() throws BaseException {
    if (this.readDetalles) {
      List listaDetalles = AnuladorAsientoManual.getDetallesAnuladosAsiento(this,getSesion());
      detalles.addAll(listaDetalles);
      this.readDetalles = false;
    }
    return detalles;
  }

  public void addDetalleAnulador(AnuladorAsientoManualDet anuladorAsientoManualDet) throws BaseException {
  	anuladorAsientoManualDet.setAnulador_asiento_manual(this);
    detalles.add(anuladorAsientoManualDet);
  }

	public void generarComproAnulacion() throws BaseException {

		// Set datos del comrobante
		setContabiliza(true);
		Talonario talonarioAnulacion = this.getAsiento_manual().getTalonario().getTalonarioAnulacion();
		if (talonarioAnulacion == null)
			throw new ExceptionValidation(null, "No existe talonario de anulación para el talonario "
					+ this.getAsiento_manual().getTalonario().getDescripcion());
		setTalonario(talonarioAnulacion);
		setTipoCompro(talonarioAnulacion.getTipo_comprobante());
		setLetra(talonarioAnulacion.getLetra());
		setLugarEmision(talonarioAnulacion.getLugar_emision());
		setNroext(new Integer(0));
		setEmision(Fecha.getFechaActual());
		setImputac(Fecha.getFechaActual());
		setComentario("Anulación Asiento " + this.getAsiento_manual().getCodigo());
		setActivo(new Boolean(true));
		
		// Recorrer los detalles del asiento
		Iterator iterAsientoManual = 
			this.getAsiento_manual().getDetalles().iterator();
		while (iterAsientoManual.hasNext()) {
			AsientoManualDet asiManDet = (AsientoManualDet) iterAsientoManual.next();
			AnuladorAsientoManualDet anuAsiManDet = 
				(AnuladorAsientoManualDet) AnuladorAsientoManualDet.getNew(AnuladorAsientoManualDet.NICKNAME,this.getSesion());
			anuAsiManDet.setAnulador_asiento_manual(this);
			anuAsiManDet.setDet_asiento_manual(asiManDet);
			this.addDetalleAnulador(anuAsiManDet);
		}
		

	}
	
	public void beforeSave() throws BaseException {
		Validar.noNulo(this.asiento_manual, "Debe ingresar el Comprobante Asiento");
		beforeSaveComprobante(this);
		if (this.isNew())
			this.setEstado(ComproCab.ESTADO_ALTA);
	}
	
	public void afterSave() throws BaseException {

		afterSaveComprobante(this);

		anularComprobante(this.getAsiento_manual());

    Iterator iterDetallesAnulados = detalles.iterator();
    while (iterDetallesAnulados.hasNext()) {
      AnuladorAsientoManualDet anuladorAsientoDet = (AnuladorAsientoManualDet) iterDetallesAnulados.next();
      anuladorAsientoDet.save();
      anuladorAsientoDet = null;
    }
    iterDetallesAnulados = null;
		

	}
	
  
	

}
