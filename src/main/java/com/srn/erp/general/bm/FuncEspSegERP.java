package com.srn.erp.general.bm;

// local

public class FuncEspSegERP {
	
	// CONTROL DE INGRESO DE PERSONAL
	
	public static final int SEG_1000 = 1000; // TFACCESOPORLEGAJO =  Activar boton refresco datos legajo
	public static final int SEG_1001 = 1001; // TFACCESOPORLEGAJO =  Permite ingresar / salir proximo antipassback
	public static final int SEG_1002 = 1002; // TFACCESOPORLEGAJO =  Habilitar pase de Ingreso
	public static final int SEG_1003 = 1003; // TFACCESOPORLEGAJO =  Habilitar pase de Egreso
	public static final int SEG_1004 = 1004; // TFACCESOPORLEGAJO =  Habilitar Novedad de Ingreso
	public static final int SEG_1005 = 1005; // TFACCESOPORLEGAJO =  Habilitar Novedad de Egreso
	public static final int SEG_1006 = 1006; // TFACCESOPORLEGAJO =  Habilitar Novedad de Ingreso / Egreso
	public static final int SEG_1007 = 1007; // TFACCESOPORLEGAJO =  Inhabilitar Novedad Ingreso
	public static final int SEG_1008 = 1008; // TFACCESOPORLEGAJO =  Inhabilitar Novedad Egreso
	public static final int SEG_1009 = 1009; // TFACCESOPORLEGAJO =  Inhabilitar Novedad Egreso / Ingreso
	public static final int SEG_1010 = 1010; // TFACCESOPORLEGAJO =  Eliminar Novedad Externa
	public static final int SEG_1011 = 1011; // TFACCESOPORLEGAJO =  Eliminar Novedad manual
	
	public static final int SEG_1012 = 1012; // TFTABCONTROLCIP =  Activar / Desactivar Antipassback
	public static final int SEG_1013 = 1013; // TFTABCONTROLCIP =  Activar / Desactivar Logs Mensajes Aplicacion
	public static final int SEG_1014 = 1014; // TFTABCONTROLCIP =  Visualizar Tablero Tecnico CIP
	public static final int SEG_1015 = 1015; // TFTABCONTROLCIP =  Reiniciar Placa
	public static final int SEG_1016 = 1016; // TFTABCONTROLCIP =  Habilitar Entrada Generica
	public static final int SEG_1017 = 1017; // TFTABCONTROLCIP =  Habilitar Salida Generica
	public static final int SEG_1018 = 1018; // TFTABCONTROLCIP =  Prearmado de Lista Blanca
	public static final int SEG_1019 = 1019; // TFTABCONTROLCIP =  Actualizar Novedades CAS
	
	// FORMULARIO DE EXCLUIDOS
	public static final int SEG_1100 = 1100; // TFIndividuoExcluido =  Activar Marca Actualizacion Estado
	public static final int SEG_1101 = 1101; // TFIndividuoExcluido =  Alta Datos Principales
	public static final int SEG_1102 = 1102; // TFIndividuoExcluido =  Modif Datos Principales
	public static final int SEG_1103 = 1103; // TFIndividuoExcluido =  Alta Caracteristicas
	public static final int SEG_1104 = 1104; // TFIndividuoExcluido =  Modif Caracteristicas
	public static final int SEG_1105 = 1105; // TFIndividuoExcluido =  Alta Datos Legajo
	public static final int SEG_1106 = 1106; // TFIndividuoExcluido =  Modif Datos Legajo
	public static final int SEG_1107 = 1107; // TFIndividuoExcluido =  Alta de Imagenes
	public static final int SEG_1108 = 1108; // TFIndividuoExcluido =  Modificacion de Imagenes
	public static final int SEG_1109 = 1109; // TFIndividuoExcluido =  Alta Dif Importes 
	public static final int SEG_1110 = 1110; // TFIndividuoExcluido =  Modif Dif Importes
	public static final int SEG_1111 = 1111; // TFIndividuoExcluido =  Baja Dif Importes
	public static final int SEG_1112 = 1112; // TFIndividuoExcluido =  Alta Vehiculos
	public static final int SEG_1113 = 1113; // TFIndividuoExcluido =  Modif Vehiculos
	public static final int SEG_1114 = 1114; // TFIndividuoExcluido =  Baja Vehiculos
	public static final int SEG_1115 = 1115; // TFIndividuoExcluido =  Alta Obs Generales
	public static final int SEG_1116 = 1116; // TFIndividuoExcluido =  Modif Obs Generales
	public static final int SEG_1117 = 1117; // TFIndividuoExcluido =  Baja Obs Generales
	public static final int SEG_1118 = 1118; // TFIndividuoExcluido =  Alta Novedad
	public static final int SEG_1119 = 1119; // TFIndividuoExcluido =  Modif Novedad
	public static final int SEG_1120 = 1120; // TFIndividuoExcluido =  Baja Novedad
	public static final int SEG_1121 = 1121; // TFIndividuoExcluido =  Alta de Relaciones
	public static final int SEG_1122 = 1122; // TFIndividuoExcluido =  Modificacion de Relaciones
	public static final int SEG_1123 = 1123; // TFIndividuoExcluido =  Alta de Adjunto
	public static final int SEG_1124 = 1124; // TFIndividuoExcluido =  Eliminar Adjunto
	public static final int SEG_1125 = 1125; // TFIndividuoExcluido =  Visualizar Adjunto
	public static final int SEG_1126 = 1126; // TFIndividuoExcluido =  Consulta Legajos
	public static final int SEG_1127 = 1127; // TFIndividuoExcluido =  Consulta Clientes
	
	
	public static final int SEG_2000 = 2000; // TFIndividuoExcluido =  Visualizar Adjuntos
	public static final int SEG_2001 = 2001; //  =  Visualizar Cacheos en Novedades
	
	public static final int SEG_16500 = 16500; //  =  Importacion archivo de POSNET
	public static final int SEG_16501 = 16501; //  =  Importacion archivo de Tarjetas
	public static final int SEG_16502 = 16502; //  =  Marcar Cupon POSNET como presentado
	public static final int SEG_16503 = 16503; //  =  Marcar Cupon para conciliar
	public static final int SEG_16504 = 16504; //  =  Conciliacion registros Marcados
	public static final int SEG_16505 = 16505; //  =  Conciliacion automatica
	public static final int SEG_16506 = 16506; //  =  Confirmacion de registros conciliados
	public static final int SEG_16507 = 16507; //  =  Marcar / Desmarcar Asiento Cobranza
	public static final int SEG_16508 = 16508; //  =  Marcar / Desmarcar Asiento Liquidacion
	public static final int SEG_16509 = 16509; //  =  Alta Movimiento POSNET
	public static final int SEG_16510 = 16510; //  =  Baja Movimiento POSNET
	public static final int SEG_16511 = 16511; //  =  Modificacion Movimiento POSNET
	public static final int SEG_16512 = 16512; //  =  Alta Movimiento Tarjeta
	public static final int SEG_16513 = 16513; //  =  Baja Movimiento Tarjeta
	public static final int SEG_16514 = 16514; //  =  Modificacion Movimiento Tarjeta
	public static final int SEG_16515 = 16515; //  =  Ejecutar Consulta de Tarjetas
	public static final int SEG_16516 = 16516; //  =  Anulación Conciliacion de Movimiento
	public static final int SEG_16517 = 16517; //  =  Anulación Confirmacion de Movimiento
	public static final int SEG_16518 = 16518; //  =  Anulación Conciliacion Automatica
	public static final int SEG_16519 = 16519; //  =  Marcar / Desmarcar Cupon como Perdido
	public static final int SEG_16520 = 16520; //  =  Generar Asiento Cobranza
	public static final int SEG_16521 = 16521; //  =  Anular Asiento Cobranza
	public static final int SEG_16522 = 16522; //  =  Generar Asiento Liquidación
	public static final int SEG_16523 = 16523; //  =  Anular Asiento Liquidación
	public static final int SEG_16524 = 16524; //  =  Importar ALL archivos POSNETS
	
	// Legajos
	
	public static final int SEG_20000 = 20000; //  =  TFLegajos = Visualizar Solapa Clasificador
	public static final int SEG_20001 = 20001; //  =  TFLegajos = Modificar Solapa Clasificador
	public static final int SEG_20002 = 20002; //  =  TFLegajos = Visualizar Solapa Tarjetas
	public static final int SEG_20003 = 20003; //  =  TFLegajos = Modificar Solapa Tarjetas
	public static final int SEG_20004 = 20004; //  =  TFLegajos = Visualizar Solapa Control Acceso
	public static final int SEG_20005 = 20005; //  =  TFLegajos = Modificar Solapa Control Acceso
	public static final int SEG_20006 = 20006; //  =  TFLegajos = Visualizar Solapa Personales
	public static final int SEG_20007 = 20007; //  =  TFLegajos = Modificar Solapa Personales
	public static final int SEG_20008 = 20008; //  =  TFLegajos = Visualizar Solapa Empresas
	public static final int SEG_20009 = 20009; //  =  TFLegajos = Modificar Solapa Empresas
	public static final int SEG_20010 = 20010; //  =  TFLegajos = Visualizar Solapa Sanciones
	public static final int SEG_20011 = 20011; //  =  TFLegajos = Modificar Solapa Sanciones
	public static final int SEG_20012 = 20012; //  =  TFLegajos = Visualizar Solapa Servicio Medico
	public static final int SEG_20013 = 20013; //  =  TFLegajos = Modificar Solapa Servicio Medico
	public static final int SEG_20014 = 20014; //  =  TFLegajos = Visualizar Solapa Evaluacion
	public static final int SEG_20015 = 20015; //  =  TFLegajos = Modificar Solapa Evaluacion
	public static final int SEG_20016 = 20016; //  =  TFLegajos = Modificar Datos Principales
	public static final int SEG_20017 = 20017; //  =  TFLegajos = Navegar a Evaluacion
	public static final int SEG_20018 = 20018; //  =  TFLegajos = Modificar Datos Legales
	public static final int SEG_20019 = 20019; //  =  TFLegajos = Visualizar Datos Legales
	public static final int SEG_20020 = 20020; //  =  TFLegajos = Modificar Datos Desarrollo
	public static final int SEG_20021 = 20021; //  =  TFLegajos = Visualizar Datos Desarrollo
	public static final int SEG_20022 = 20022; //  =  TFLegajos = Visualizar Datos Novedades
	public static final int SEG_20023 = 20023; //  =  TFLegajos = Modificar Datos Novedades
	public static final int SEG_20024 = 20024; //  =  TFLegajos = Visualizar Datos Obs. Leg.
	public static final int SEG_20025 = 20025; //  =  TFLegajos = Modificar Datos Obs. Leg
	
	
	
	
	
	
	
	
	
	
	
	
}
