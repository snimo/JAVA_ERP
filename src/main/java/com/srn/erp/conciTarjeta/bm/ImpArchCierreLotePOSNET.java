package com.srn.erp.conciTarjeta.bm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.UtilCIP;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class ImpArchCierreLotePOSNET extends ImpArchCierreLote {

	RegCabPOSNET regCabPOSNET = new RegCabPOSNET();
	List listaDetalles = new ArrayList();
	private Integer oidArchLoteCab = new Integer(0);
	
	public void importar() throws BaseException {

		int nroLinea = 1;
		// Abrir el archivo de texto
		try {
		    BufferedReader in = new BufferedReader(new FileReader(this.getArchivo()));
		    String str;
		    while ((str = in.readLine()) != null) {
		    	if (nroLinea == 1) {
		    		lineaCabera(str);
		    	}
		    	else {
		    		lineaDetalle(str);
		    	}
		        ++nroLinea;
		    }
		    in.close();
		} catch (IOException e) {
		}
		grabarEnBD();
		
	}	
	
	public RegCabPOSNET getRegCabecera() {
		return this.regCabPOSNET;
	}
	
	public List getRegDetalles() {
		return this.listaDetalles;
	}
	
	private void lineaCabera(String linea) {
		String[] campos = linea.split("\\,");
		for (int i=0;i<=campos.length-1;++i) {
			if (i==0)
				regCabPOSNET.setEstado(campos[i]);
			else
			if (i==1)
				regCabPOSNET.setNroHost(campos[i]);
			else
			if (i==2)
				regCabPOSNET.setNombreHost(campos[i]);			
			else
			if (i==3) {
				//regCabPOSNET.setNroLote(new Integer(campos[i]));
				regCabPOSNET.setNroLote(this.getNroLote());
			}
			else
			if (i==4)
				regCabPOSNET.setCantTransacciones(new Integer(campos[i]));			
			else
			if (i==5)
				regCabPOSNET.setFechaCierre(campos[i]);
			else
			if (i==6)
				regCabPOSNET.setNroTerminal(campos[i]);			
		}
	}
	
	private void lineaDetalle(String linea) throws BaseException {
		RegDetPOSNET regDetPOSNET = new RegDetPOSNET();
		String[] campos = linea.split("\\,");
		for (int i=0;i<=campos.length-1;++i) {
			if (i==0)
				regDetPOSNET.setModoTransmision(campos[i]);
			else
			if (i==1)
				regDetPOSNET.setTipoTransaccion(campos[i]);
			else
			if (i==2)
				regDetPOSNET.setFechaOperativa(campos[i]);
			else
			if (i==3)
				regDetPOSNET.setHoraOperativa(campos[i]);			
			else
			if (i==4)
				regDetPOSNET.setTipoTarjeta(campos[i].trim());			
			else
			if (i==5)
				regDetPOSNET.setTarjeta(campos[i]);			
			else
			if (i==6)
				regDetPOSNET.setNroTarjeta(campos[i]);			
			else
			if (i==7)
				regDetPOSNET.setBandaManual(campos[i]);			
			else
			if (i==8)
				regDetPOSNET.setCodAutoriz(campos[i]);			
			else
			if (i==9)
				regDetPOSNET.setTicket(campos[i]);			
			else
			if (i==10)
				regDetPOSNET.setMoneda(campos[i]);
			else
			if (i==11) {
				String montoCaracter = campos[i];
				CalculadorMoney calcMonto = new CalculadorMoney(new Money(montoCaracter));
				calcMonto.dividirPor(new Money(100));
				regDetPOSNET.setMonto(calcMonto.getResultMoney());
			}
			else
			if (i==12)
				regDetPOSNET.setTipoCtaDebito(campos[i]);
			else			
			if (i==13)
				regDetPOSNET.setPlanycuota(campos[i]);
			else			
			if (i==14)
				regDetPOSNET.setCodComercio(campos[i]);
			else			
			if (i==15)
				regDetPOSNET.setNroTerminal(campos[i]);
			else			
			if (i==16)
				regDetPOSNET.setTicketSec(campos[i]);			
			else			
			if (i==17)
				regDetPOSNET.setCodLista(campos[i]);
			else
			if (i==18) {
				String montoCaracterSec = campos[i];
				CalculadorMoney calcMontoSec = new CalculadorMoney(new Money(0));
				if (!montoCaracterSec.equals(""))
					calcMontoSec.sumar(new Money(montoCaracterSec));
				calcMontoSec.dividirPor(new Money(100));
				regDetPOSNET.setMontoSec(calcMontoSec.getResultMoney());
			}			
			else			
			if (i==19)
				regDetPOSNET.setFechaSec(campos[i]);			
			else			
			if (i==20)
				regDetPOSNET.setFactura(campos[i]);			
			else			
			if (i==21)
				regDetPOSNET.setNroHost(campos[i]);			
			else			
			if (i==22) {
				//regDetPOSNET.setNroLote(campos[i]);
				regDetPOSNET.setNroLote(this.getNroLote().toString());
			}
		}
		
		/*EmpresaConciTar empValCodComer = EmpresaConciTar.getEmpresa(regDetPOSNET.getCodComercio(), this.getSesion());
		if (empValCodComer == null)
			throw new ExceptionValidation(null,"El código de comercio "+regDetPOSNET.getCodComercio()+" no corresponde a una empresa.");
		
		if (empValCodComer.getOID()!=this.getOidEmpresa())
			throw new ExceptionValidation(
					null,
					"El archivo a importar no corresponde a la empresa "+EmpresaConciTar.findByOid(this.getOidEmpresa(), this.getSesion()).getRazon_social());*/
		
		listaDetalles.add(regDetPOSNET);
		
	}	
	
	private void grabarEnBD() throws BaseException {
		
		
		// Grabar la Cabecera
		ArchLoteConciCab archLoteConciCab = (ArchLoteConciCab)ArchLoteConciCab.getNew(ArchLoteConciCab.NICKNAME, this.getSesion());
		archLoteConciCab.setEstado(new Integer(this.getRegCabecera().getEstado()));
		archLoteConciCab.setProveedor_host("PO");
		archLoteConciCab.setNro_host(this.getRegCabecera().getNroHost());
		archLoteConciCab.setNom_host(this.getRegCabecera().getNombreHost());
		archLoteConciCab.setNro_lote(this.getRegCabecera().getNroLote());
		archLoteConciCab.setCant_transac(this.getRegCabecera().getCantTransacciones());
		archLoteConciCab.setNro_terminal(this.getRegCabecera().getNroTerminal());
		archLoteConciCab.setAnio(this.getRegCabecera().getAnio());
		archLoteConciCab.setMes(this.getRegCabecera().getMes());
		archLoteConciCab.setDia(this.getRegCabecera().getDia());
		int sep = this.getArchivo().lastIndexOf("\\");
		String archivo = this.getArchivo().substring(sep + 1, this.getArchivo().length() );			
		archLoteConciCab.setArchivo(archivo);
		archLoteConciCab.setFec_creacion(Fecha.getFechaActual());
		archLoteConciCab.setFec_importacion(Fecha.getFechaActual());
		archLoteConciCab.setFec_cierre(this.getRegCabecera().getDateFechaCierre());
		archLoteConciCab.setHora_importacion(Fecha.getHoraActual());
		archLoteConciCab.setActivo(1);
		
		TerminalConciTar terminal =
			TerminalConciTar.findByCodigo(archLoteConciCab.getNro_terminal(), this.getSesion());
		if (terminal == null)
			throw new ExceptionValidation(null,"Nro. de terminal "+archLoteConciCab.getNro_terminal()+" desconocido.");		
		
		if (terminal.getUni_neg()!=null)
			archLoteConciCab.setEmpresaConciTar(terminal.getUni_neg().getEmpresa());
		if (terminal.getUni_neg()==null)
			throw new ExceptionValidation(null,"Debe ingresar la Unidad de Negocios de la Terminal");
		if (terminal.getUni_neg().getEmpresa()==null)
			throw new ExceptionValidation(null,"Debe ingresar la Empresa.");		
		
		
		ArchLoteConciCab archLoteExistente = 
			ArchLoteConciCab.getArchivoCabecera(this.getRegCabecera().getNroLote(),
												this.getRegCabecera().getNroTerminal(),
												this.getRegCabecera().getAnio(),
												this.getRegCabecera().getMes(),
												archivo,
												this.getSesion());
											
		if (archLoteExistente!=null)
			throw new ExceptionValidation(null,"Ya se encuentra importado el Lote. Nro. "+this.getRegCabecera().getNroLote()+
					" de la terminal "+this.getRegCabecera().getNroTerminal()+" del período "+this.getRegCabecera().getAnio()+"."+
					this.getRegCabecera().getMes()
					);
		
		archLoteConciCab.save();
		
		oidArchLoteCab = archLoteConciCab.getOIDInteger(); 
		
		Iterator iterDet = 
			this.getRegDetalles().iterator();
		int signo = 1;
		while (iterDet.hasNext()) {
			RegDetPOSNET regDetPOSNET = (RegDetPOSNET) iterDet.next();
			signo = 1;
			ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet)ArchLoteConciDet.getNew(ArchLoteConciDet.NICKNAME, this.getSesion());
			archLoteConciDet.setArch_lot_cab(archLoteConciCab);
			archLoteConciDet.setModo_transmision(regDetPOSNET.getModoTransmision());
			archLoteConciDet.setTipo_operacion(regDetPOSNET.getTipoTransaccion());
			
			if (!archLoteConciDet.getTipo_operacion().trim().equals("COMPRA"))
				signo = -1;
			
			archLoteConciDet.setFecha_oper(regDetPOSNET.getFechaOperativa());
			archLoteConciDet.setHora_oper(regDetPOSNET.getHoraOperativa());
			archLoteConciDet.setTipo_tarjeta(regDetPOSNET.getTipoTarjeta());
			
			archLoteConciDet.setTarjetaOri(regDetPOSNET.getTarjeta());
			
			// Obtener el Nro. de Tarjeta
			TarjetaConciTar tarjConci = TarjetaConciTar.getTarjetaConciliacion(regDetPOSNET.getTarjeta(), this.getSesion());
			if (tarjConci==null)
				throw new ExceptionValidation(null,"No se encuentra definida Tarjeta para el código de POSNET:"+regDetPOSNET.getTarjeta());

			String tarjeta = TarjetaConciTar.getEquivAutTarjConi(tarjConci.getIdentif_tarj());
			archLoteConciDet.setTarjeta(tarjeta);
			
			if ( (tarjConci!=null) && (tarjConci.isIgnorarMovPOSNET()!=null) && (tarjConci.isIgnorarMovPOSNET()))
				continue;
			
			archLoteConciDet.setTarjetaConciliacion(tarjConci);
			archLoteConciDet.setNro_tarjeta(regDetPOSNET.getNroTarjeta());
			archLoteConciDet.setBanda_manual(regDetPOSNET.getBandaManual());
			archLoteConciDet.setCod_autoriz(regDetPOSNET.getCodAutoriz());
			archLoteConciDet.setTicket(regDetPOSNET.getTicket());
			archLoteConciDet.setMoneda(regDetPOSNET.getMoneda());
			
			CalculadorMoney importe = new CalculadorMoney(regDetPOSNET.getMonto());
			importe.multiplicarPor(new Money(signo));
			
			archLoteConciDet.setMonto(importe.getResult());
			archLoteConciDet.setTipo_cta_deb(regDetPOSNET.getTipoCtaDebito());
			archLoteConciDet.setPlan_y_cuota(regDetPOSNET.getPlanycuota());
			archLoteConciDet.setCod_comercio(regDetPOSNET.getCodComercio());
			archLoteConciDet.setNro_terminal(regDetPOSNET.getNroTerminal());
			archLoteConciDet.setTicket_sec(regDetPOSNET.getTicketSec());
			archLoteConciDet.setCodigo_lista(regDetPOSNET.getCodLista());
			archLoteConciDet.setMonto_sec(regDetPOSNET.getMontoSec().doubleValue());
			archLoteConciDet.setFecha_sec(regDetPOSNET.getFechaSec());
			archLoteConciDet.setFactura(regDetPOSNET.getFactura());
			archLoteConciDet.setNro_host(regDetPOSNET.getNroHost());
			if ((regDetPOSNET.getNroLote()!=null) && (!regDetPOSNET.getNroLote().trim().equals("")))
				archLoteConciDet.setNro_lote(new Integer(regDetPOSNET.getNroLote()));
			else
				archLoteConciDet.setNro_lote(null);
			archLoteConciDet.setActivo(true);
			archLoteConciDet.setPresentado(false);

			archLoteConciDet.setEmpresa(terminal.getUni_neg().getEmpresa());
			archLoteConciDet.setUnidad_negocio(terminal.getUni_neg());
			archLoteConciDet.setFecOperDate(regDetPOSNET.getFechaOperDate());
			archLoteConciDet.setFecCierre(this.getRegCabecera().getDateFechaCierre());
			archLoteConciDet.setPresentado(false);
			archLoteConciDet.setConciliado(false);
			archLoteConciDet.setLiquidado(false);
			archLoteConciDet.setPreContabilizado(false);
			archLoteConciDet.setContabilizado(false);
			archLoteConciDet.setContaAsiACobrar(false);
			archLoteConciDet.setContaAsiLiq(false);			
			archLoteConciDet.setUltimosNrosTarjeta(new Integer(archLoteConciDet.getNro_tarjeta().substring(archLoteConciDet.getNro_tarjeta().length()-4,archLoteConciDet.getNro_tarjeta().length())));
			archLoteConciDet.save();	
			
			incCantRegImp();
			
		}
		
	}
	
	protected void grabarErrorArchivo(String error) throws BaseException {
		
		ArcImpErrorPOSNET arcImpErrorPOSNET = (ArcImpErrorPOSNET) ArcImpErrorPOSNET.getNew(ArcImpErrorPOSNET.NICKNAME, this.getSesion());
		arcImpErrorPOSNET.setTipo_arch(ArcImpErrorPOSNET.TIPO_ARCH_POSNET);
		java.util.Date fecha = UtilCIP.getFechaHoraActual(this.getSesion());
		arcImpErrorPOSNET.setFecha(fecha);
		arcImpErrorPOSNET.setHora(UtilCIP.getHHMM(fecha));
		
		
		File f = new File(this.getArchivo());	
		
		arcImpErrorPOSNET.setCarpeta(f.getParent());
		arcImpErrorPOSNET.setNombre_archivo(f.getName());
		arcImpErrorPOSNET.setTerminal(this.getTerminal());
		arcImpErrorPOSNET.setEmpresa(EmpresaConciTar.findByOidProxy(this.getOidEmpresa(), this.getSesion()));
		arcImpErrorPOSNET.setProblema(error);
		arcImpErrorPOSNET.setActivo(true);
		arcImpErrorPOSNET.save();
		
	}
	
	public Integer getOidArchLoteCab() {
		return oidArchLoteCab;
	}
	
}
