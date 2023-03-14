package com.srn.erp.cip.op;

import java.util.Date;
import java.util.List;

import com.srn.erp.cip.bm.CIPLogPuerta;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.mail.CIPConfigMail;
import com.srn.erp.cip.mail.CIPConfigMailPuertaDesconectada;
import com.srn.erp.cip.mail.CIPMailService;
import com.srn.erp.cip.mail.FactoryCIPConfigMail;

import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class CIPMonitorearPuertas extends Operation {

	@Override
	public void execute(MapDatos mapaDatos) throws BaseException {
		
		
		try {
		Boolean activarLogger = ValorParametro.findByCodigoParametro("ACTIVAR_LOGGER_PLACA_DESC", this.getSesion()).getBoolean();
		if ((activarLogger==null) || (!activarLogger))
			return;
		
		Integer minSinConexion = ValorParametro.findByCodigoParametro("CANT_MIN_PLACA_SIN_CONEXION", this.getSesion()).getValorEntero();
		if (minSinConexion==null) return;
		
		Boolean enviarMailSop = ValorParametro.findByCodigoParametro("ENVIAR_MAIL_PLACA_DES", this.getSesion()).getBoolean();
		if (enviarMailSop==null) return;
		
		CIPConfigMail configMail = new FactoryCIPConfigMail( CIPConfigMailPuertaDesconectada.CODIGO, this.getSesion()).getConfigMail();

		List<Puerta> puertas = Puerta.getPuertasActivas(this.getSesion());
		for (Puerta puerta : puertas) {
			if (puerta.isPerdioConexion(minSinConexion)) {
				this.guardarLogPuerta(puerta, CIPLogPuerta.DESCONECT);
				if (!puerta.isDesconectada()) {
					puerta.setDesconectada(true);
					puerta.save();
				}
				if (enviarMailSop)
					this.enviarMailASoporte(puerta, configMail);
			} else {
				if (puerta.isDesconectada()) {
					this.guardarLogPuerta(puerta, CIPLogPuerta.CONECT);
					puerta.setDesconectada(false);
					puerta.save();
				}
			}

		}
		}
		catch(Exception e) {}

	}

	public void enviarMailASoporte(Puerta puerta, CIPConfigMail configMail) throws BaseException {
		CIPConfigMailPuertaDesconectada aux = (CIPConfigMailPuertaDesconectada) configMail;
		aux.setPuerta(puerta);
		CIPMailService mailService = new CIPMailService(configMail);
		mailService.enviar();
	}

	public void guardarLogPuerta(Puerta puerta, String estado) throws BaseException {
		CIPLogPuerta log = (CIPLogPuerta) CIPLogPuerta.getNew(CIPLogPuerta.NICKNAME, this.getSesion());
		log.setPuerta(puerta);
		log.setFechora(new Date());
		log.setEstado(estado);
		log.setActivo(true);
		log.save();
	}

}
