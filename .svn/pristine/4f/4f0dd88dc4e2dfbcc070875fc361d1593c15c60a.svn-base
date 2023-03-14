package com.srn.erp.turnos.bm;

import java.util.List;

import com.srn.erp.turnos.da.DBReservaTableroTurno;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Util;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class ReservaTableroTurno extends ObjetoLogico {

	public static final String TIPO_RES_MOT = "RESMOT"; // RESERVA POR MOTIVO
	public static final String TIPO_RES_TUR = "RESTUR"; // RESERVA POR TURNO

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ReservaTableroTurno() {
	}

	public static String NICKNAME = "tu.ReservaTableroTurno";

	private TableroTurnos tablero;
	private TableroEntidadTurnos entidad_tablero;
	private TableroHorarioTurnos horario_tablero;
	private MotivoReservaTurno motivo;
	private Sujeto sujeto1;
	private Sujeto sujeto2;
	private Sujeto sujeto3;
	private Sujeto sujeto4;
	private String compo_tipo_res;
	private String desc_1;
	private String desc_2;
	private String desc_3;
	private String desc_4;
	private String comentario;
	private boolean invitado1;
	private boolean invitado2;
	private boolean invitado3;
	private boolean invitado4;
	private boolean autoriz1;
	private boolean autoriz2;
	private boolean autoriz3;
	private boolean autoriz4;
	private boolean reglaAct1;
	private boolean reglaAct2;
	private boolean reglaAct3;
	private boolean reglaAct4;

	public TableroTurnos getTablero() throws BaseException {
		supportRefresh();
		return tablero;
	}

	public void setTablero(TableroTurnos aTablero) {
		this.tablero = aTablero;
	}
	
	public boolean isAutorizado1() throws BaseException {
		supportRefresh();
		return this.autoriz1;
	}

	public void setAutorizado1(Boolean aAutorizado1) {
		this.autoriz1 = aAutorizado1;
	}
	
	public boolean isReglaAct1() throws BaseException {
		supportRefresh();
		return this.reglaAct1;
	}

	public void setReglaAct1(Boolean aReglaAct1) {
		this.reglaAct1 = aReglaAct1;
	}
	
	public boolean isReglaAct2() throws BaseException {
		supportRefresh();
		return this.reglaAct2;
	}

	public void setReglaAct2(Boolean aReglaAct2) {
		this.reglaAct2 = aReglaAct2;
	}
	
	public boolean isReglaAct3() throws BaseException {
		supportRefresh();
		return this.reglaAct3;
	}

	public void setReglaAct3(Boolean aReglaAct3) {
		this.reglaAct3 = aReglaAct3;
	}
	
	public boolean isReglaAct4() throws BaseException {
		supportRefresh();
		return this.reglaAct4;
	}

	public void setReglaAct4(Boolean aReglaAct4) {
		this.reglaAct4 = aReglaAct4;
	}
	
	public boolean isAutorizado2() throws BaseException {
		supportRefresh();
		return this.autoriz2;
	}

	public void setAutorizado2(Boolean aAutorizado2) {
		this.autoriz2 = aAutorizado2;
	}
	
	public boolean isAutorizado3() throws BaseException {
		supportRefresh();
		return this.autoriz3;
	}

	public void setAutorizado3(Boolean aAutorizado3) {
		this.autoriz3 = aAutorizado3;
	}
	
	public boolean isAutorizado4() throws BaseException {
		supportRefresh();
		return this.autoriz4;
	}

	public void setAutorizado4(Boolean aAutorizado4) {
		this.autoriz4 = aAutorizado4;
	}
	
	public boolean isInvitado1() throws BaseException {
		supportRefresh();
		return this.invitado1;
	}

	public void setInvitado1(Boolean aInvitado1) {
		this.invitado1 = aInvitado1;
	}

	public boolean isInvitado2() throws BaseException {
		supportRefresh();
		return this.invitado2;
	}

	public void setInvitado2(Boolean aInvitado2) {
		this.invitado2 = aInvitado2;
	}

	public boolean isInvitado3() throws BaseException {
		supportRefresh();
		return this.invitado3;
	}

	public void setInvitado3(Boolean aInvitado3) {
		this.invitado3 = aInvitado3;
	}

	public boolean isInvitado4() throws BaseException {
		supportRefresh();
		return this.invitado4;
	}

	public void setInvitado4(Boolean aInvitado4) {
		this.invitado4 = aInvitado4;
	}

	public TableroEntidadTurnos getEntidad_tablero() throws BaseException {
		supportRefresh();
		return entidad_tablero;
	}

	public void setEntidad_tablero(TableroEntidadTurnos aEntidad_tablero) {
		this.entidad_tablero = aEntidad_tablero;
	}

	public TableroHorarioTurnos getHorario_tablero() throws BaseException {
		supportRefresh();
		return horario_tablero;
	}

	public void setHorario_tablero(TableroHorarioTurnos aHorario_tablero) {
		this.horario_tablero = aHorario_tablero;
	}

	public MotivoReservaTurno getMotivo() throws BaseException {
		supportRefresh();
		return motivo;
	}

	public void setMotivo(MotivoReservaTurno aMotivo) {
		this.motivo = aMotivo;
	}

	public Sujeto getSujeto1() throws BaseException {
		supportRefresh();
		return sujeto1;
	}

	public void setSujeto1(Sujeto aSujeto1) {
		this.sujeto1 = aSujeto1;
	}

	public Sujeto getSujeto2() throws BaseException {
		supportRefresh();
		return sujeto2;
	}

	public void setSujeto2(Sujeto aSujeto2) {
		this.sujeto2 = aSujeto2;
	}

	public Sujeto getSujeto3() throws BaseException {
		supportRefresh();
		return sujeto3;
	}

	public void setSujeto3(Sujeto aSujeto3) {
		this.sujeto3 = aSujeto3;
	}

	public Sujeto getSujeto4() throws BaseException {
		supportRefresh();
		return sujeto4;
	}

	public void setSujeto4(Sujeto aSujeto4) {
		this.sujeto4 = aSujeto4;
	}

	public String getCompo_tipo_res() throws BaseException {
		supportRefresh();
		return compo_tipo_res;
	}

	public void setCompo_tipo_res(String aCompo_tipo_res) {
		this.compo_tipo_res = aCompo_tipo_res;
	}

	public String getDesc_1() throws BaseException {
		supportRefresh();
		return desc_1;
	}

	public void setDesc_1(String aDesc_1) {
		this.desc_1 = aDesc_1;
	}

	public String getDesc_2() throws BaseException {
		supportRefresh();
		return desc_2;
	}

	public void setDesc_2(String aDesc_2) {
		this.desc_2 = aDesc_2;
	}

	public String getDesc_3() throws BaseException {
		supportRefresh();
		return desc_3;
	}

	public void setDesc_3(String aDesc_3) {
		this.desc_3 = aDesc_3;
	}

	public String getDesc_4() throws BaseException {
		supportRefresh();
		return desc_4;
	}

	public void setDesc_4(String aDesc_4) {
		this.desc_4 = aDesc_4;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ReservaTableroTurno findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ReservaTableroTurno) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ReservaTableroTurno findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (ReservaTableroTurno) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {

		Validar.noNulo(tablero, "Debe ingresar el Tablero de Turnos");
		Validar.noNulo(entidad_tablero, "Debe ingresar la Entidad");
		Validar.noNulo(horario_tablero, "Debe ingresar el Horario");
		Validar.noNulo(compo_tipo_res, "Debe ingresar el comportamiento");

		StringBuffer detalleErrores = new StringBuffer();
		
		if (this.getSujeto1() != null)
			this.getTablero().validarPonerTurno(this.getSujeto1().getCodigo(),
					this.getEntidad_tablero(), this.getHorario_tablero(),this.isAutorizado1(),detalleErrores);
		if (this.getSujeto2() != null)
			this.getTablero().validarPonerTurno(this.getSujeto2().getCodigo(),
					this.getEntidad_tablero(), this.getHorario_tablero(),this.isAutorizado2(),detalleErrores);
		if (this.getSujeto3() != null)
			this.getTablero().validarPonerTurno(this.getSujeto3().getCodigo(),
					this.getEntidad_tablero(), this.getHorario_tablero(),this.isAutorizado3(),detalleErrores);
		if (this.getSujeto4() != null)
			this.getTablero().validarPonerTurno(this.getSujeto4().getCodigo(),
					this.getEntidad_tablero(), this.getHorario_tablero(),this.isAutorizado4(),detalleErrores);
		
		if (detalleErrores.length()>0)
			throw new ExceptionValidation(null,detalleErrores.toString());

		if (this.getSujeto1() != null)
			setInvitado1(this.getSujeto1().isCategoriaInvitado());
		else
			setInvitado1(false);

		if (this.getSujeto2() != null)
			setInvitado2(this.getSujeto2().isCategoriaInvitado());
		else
			setInvitado2(false);

		if (this.getSujeto3() != null)
			setInvitado3(this.getSujeto3().isCategoriaInvitado());
		else
			setInvitado3(false);

		if (this.getSujeto4() != null)
			setInvitado4(this.getSujeto4().isCategoriaInvitado());
		else
			setInvitado4(false);
		
		if (this.getTablero().isReglamentoActivo().booleanValue()==false) {
			setReglaAct1(new Boolean(false));
			setReglaAct2(new Boolean(false));
			setReglaAct3(new Boolean(false));
			setReglaAct4(new Boolean(false));
		}
		
		
		

	}

	public static List getReservasTablero(TableroTurnos tablero, ISesion aSesion)
			throws BaseException {
		return DBReservaTableroTurno.getReservasTablero(tablero, aSesion);
	}

	public static List getReservasTableroEnEntidad(TableroTurnos tablero,
			TableroEntidadTurnos tableroEntidad, ISesion aSesion)
			throws BaseException {
		return DBReservaTableroTurno.getReservasTableroEnEntidad(tablero,
				tableroEntidad, aSesion);
	}

	public static ReservaTableroTurno getReserva(TableroTurnos tablero,
			TableroEntidadTurnos tableroEntidad,
			TableroHorarioTurnos tableroHorarios, ISesion aSesion)
			throws BaseException {
		return DBReservaTableroTurno.getReserva(tablero, tableroEntidad,
				tableroHorarios, aSesion);
	}

	private String getDescTurnosIntegranes() throws BaseException {
		StringBuffer integrantes = new StringBuffer();
		if (this.getSujeto1() != null) {
			if (integrantes.length() > 0)
				integrantes.append(Util.ENTER());
			integrantes.append(this.getSujeto1().getCodigo() + " - "
					+ this.getSujeto1().getRazon_social());
		}
		if (this.getSujeto2() != null) {
			if (integrantes.length() > 0)
				integrantes.append(Util.ENTER());
			integrantes.append(this.getSujeto2().getCodigo() + " - "
					+ this.getSujeto2().getRazon_social());
		}
		if (this.getSujeto3() != null) {
			if (integrantes.length() > 0)
				integrantes.append(Util.ENTER());
			integrantes.append(this.getSujeto3().getCodigo() + " - "
					+ this.getSujeto3().getRazon_social());
		}
		if (this.getSujeto4() != null) {
			if (integrantes.length() > 0)
				integrantes.append(Util.ENTER());
			integrantes.append(this.getSujeto4().getCodigo() + " - "
					+ this.getSujeto4().getRazon_social());
		}

		return integrantes.toString();
	}

	public String getPresentacion() throws BaseException {
		StringBuffer presentacion = new StringBuffer("");
		presentacion.append(getDescTurnosIntegranes());
		if (this.getMotivo() != null) {
			if (presentacion.length() > 0)
				presentacion.append(Util.ENTER());
			presentacion.append(this.getMotivo().getDescripcion());
		}

		if ((this.getComentario() != null)
				&& (this.getComentario().length() > 0)) {
			if (presentacion.length() > 0)
				presentacion.append(Util.ENTER());
			presentacion.append(this.getComentario());
		}

		return presentacion.toString();
	}

	public void asignar(ReservaTableroTurno aReserva) throws BaseException {
		this.setSujeto1(aReserva.getSujeto1());
		this.setSujeto2(aReserva.getSujeto2());
		this.setSujeto3(aReserva.getSujeto3());
		this.setSujeto4(aReserva.getSujeto4());
		this.setMotivo(aReserva.getMotivo());
		this.setComentario(aReserva.getComentario());
		this.setCompo_tipo_res(aReserva.getCompo_tipo_res());
		this.setDesc_1(aReserva.getDesc_1());
		this.setDesc_2(aReserva.getDesc_2());
		this.setDesc_3(aReserva.getDesc_3());
		this.setDesc_4(aReserva.getDesc_4());
	}

	public static List getReservasActivasSujeto(TableroTurnos tablero,
			Sujeto sujeto, ISesion aSesion) throws BaseException {
		return DBReservaTableroTurno.getReservasActivasSujeto(tablero, sujeto,
				aSesion);
	}

	public static List getReservasActivasSujetoMenosReserva(
			TableroTurnos tablero, Sujeto sujeto, ReservaTableroTurno reserva,
			ISesion aSesion) throws BaseException {
		return DBReservaTableroTurno.getReservasActivasSujetoMenosReserva(
				tablero, sujeto, reserva, aSesion);
	}

	public static List getEstadisticas(java.util.Date fechaDesde,
			java.util.Date fechaHasta, String comportamiento, ISesion aSesion)
			throws BaseException {
		return DBReservaTableroTurno.getEstadisticas(fechaDesde, fechaHasta,
				comportamiento, aSesion);
	}

	public boolean isTiene1Sujeto() throws BaseException {
		int cantJug = 0;
		if (this.getSujeto1() != null)
			++cantJug;
		if (this.getSujeto2() != null)
			++cantJug;
		if (this.getSujeto3() != null)
			++cantJug;
		if (this.getSujeto4() != null)
			++cantJug;
		if (cantJug == 1)
			return true;
		else
			return false;
	}

	public boolean isTiene2Sujetos() throws BaseException {
		int cantJug = 0;
		if (this.getSujeto1() != null)
			++cantJug;
		if (this.getSujeto2() != null)
			++cantJug;
		if (this.getSujeto3() != null)
			++cantJug;
		if (this.getSujeto4() != null)
			++cantJug;
		if (cantJug == 2)
			return true;
		else
			return false;
	}

	public boolean isTiene3Sujetos() throws BaseException {
		int cantJug = 0;
		if (this.getSujeto1() != null)
			++cantJug;
		if (this.getSujeto2() != null)
			++cantJug;
		if (this.getSujeto3() != null)
			++cantJug;
		if (this.getSujeto4() != null)
			++cantJug;
		if (cantJug == 3)
			return true;
		else
			return false;
	}
	
	public boolean isTieneAlgunSujeto() throws BaseException {
		if (this.getSujeto1() != null)
			return true;
		if (this.getSujeto2() != null)
			return true;
		if (this.getSujeto3() != null)
			return true;
		if (this.getSujeto4() != null)
			return true;
		return false;
	}
	
	public String getDescMotivoTurno() throws BaseException {
		if (this.isTieneAlgunSujeto())
			return "Turno";
		else if (this.getMotivo()!=null)
				return this.getMotivo().getDescripcion();
		else
			if (this.getComentario()!=null)
				return this.getComentario();
			else
				return "?";
	}

	public boolean isTiene4Sujetos() throws BaseException {
		int cantJug = 0;
		if (this.getSujeto1() != null)
			++cantJug;
		if (this.getSujeto2() != null)
			++cantJug;
		if (this.getSujeto3() != null)
			++cantJug;
		if (this.getSujeto4() != null)
			++cantJug;
		if (cantJug == 4)
			return true;
		else
			return false;
	}

	public static List getReservasSujeto(TableroTurnos tablero, Sujeto sujeto,
			ISesion aSesion) throws BaseException {
		return DBReservaTableroTurno
				.getReservasSujeto(tablero, sujeto, aSesion);
	}

}
