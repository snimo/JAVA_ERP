package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBMesCronoDesa;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MesCronoDesa extends ObjetoLogico {
	
	public static final String ENERO = "ENE"; 
	public static final String FEBRERO = "FEB";
	public static final String MARZO = "MAR";
	public static final String ABRIL = "ABR";
	public static final String MAYO = "MAY";
	public static final String JUNIO = "JUN";
	public static final String JULIO = "JUL";
	public static final String AGOSTO = "AGO";
	public static final String SEPTIEMBRE = "SEP";
	public static final String OCTUBRE = "OCT";
	public static final String NOVIEMBRE = "NOV";
	public static final String DICIEMBRE = "DIC";

	public MesCronoDesa() {
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static String NICKNAME = "rh.MesCronoDesa";

	private AccCronoDesa accion;
	private String mes;
	private Boolean activo;

	public AccCronoDesa getAccion() throws BaseException {
		supportRefresh();
		return accion;
	}

	public void setAccion(AccCronoDesa aAccion) {
		this.accion = aAccion;
	}

	public String getMes() throws BaseException {
		supportRefresh();
		return mes;
	}

	public void setMes(String aMes) {
		this.mes = aMes;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static MesCronoDesa findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MesCronoDesa) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MesCronoDesa findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MesCronoDesa) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(accion, "Debe ingresar la Acción");
		Validar.noNulo(mes, "Debe ingresar el mes");
	}

	public static List getMesesCronoDesa(AccCronoDesa aAccCronoDesa, ISesion aSesion) throws BaseException {
		return DBMesCronoDesa.getMesesCronoDesa(aAccCronoDesa, aSesion);
	}

	public static MesCronoDesa getMesCronoDesa(AccCronoDesa accCronoDesa, String mes, ISesion aSesion) throws BaseException {

		return DBMesCronoDesa.getMesCronoDesa(accCronoDesa, mes, aSesion);

	}
	
	public static int getNroMes(String mes) throws BaseException {
		if (mes.equals(ENERO))
			return 1;
		else
		if (mes.equals(FEBRERO))
			return 2;
		else
		if (mes.equals(MARZO))
			return 3;
		else
		if (mes.equals(ABRIL))
			return 4;
		else
		if (mes.equals(MAYO))
			return 5;
		else
		if (mes.equals(JUNIO))
			return 6;
		else
		if (mes.equals(JULIO))
			return 7;
		else
		if (mes.equals(AGOSTO))
			return 8;
		else
		if (mes.equals(SEPTIEMBRE))
			return 9;
		else
		if (mes.equals(OCTUBRE))
			return 10;
		else
		if (mes.equals(NOVIEMBRE))
			return 11;
		else
		if (mes.equals(DICIEMBRE))
			return 12;
		return -1;
	}
	
	public static String getDescMes(int mes) throws BaseException {
		if (mes==1)
			return "Enero";
		else
		if (mes==2)
			return "Febrero";
		else
		if (mes==3)
			return "Marzo";
		else
		if (mes==4)
			return "Abril";
		else
		if (mes==5)
			return "Mayo";
		else
		if (mes==6)
			return "Junio";
		else
		if (mes==7)
			return "Julio";
		else
		if (mes==8)
			return "Agosto";
		else
		if (mes==9)
			return "Septiembre";
		else
		if (mes==10)
			return "Octubre";
		else
		if (mes==11)
			return "Noviembre";
		else
		if (mes==12)
			return "Diciembre";
		else
			return "";
	}

}
