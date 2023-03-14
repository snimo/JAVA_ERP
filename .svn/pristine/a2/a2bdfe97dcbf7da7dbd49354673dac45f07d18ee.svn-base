inherited FImpresorEvaluacion: TFImpresorEvaluacion
  Left = 434
  Top = 278
  Width = 619
  Height = 378
  Caption = 'Impresor de Evaluaciones'
  PixelsPerInch = 96
  TextHeight = 13
  object Label1: TLabel [0]
    Left = 88
    Top = 280
    Width = 56
    Height = 13
    Caption = 'acum_bruto'
  end
  inherited PanelImpresion: TPanel [1]
    Top = 76
    Width = 603
    Height = 264
    inherited GroupBox1: TGroupBox
      Top = 6
      Width = 561
      inherited Label4: TLabel
        Top = 21
      end
      inherited Label5: TLabel
        Top = 53
      end
      inherited Label11: TLabel
        Visible = False
      end
      object snLabel1: TsnLabel [3]
        Left = 320
        Top = 21
        Width = 45
        Height = 13
        Caption = 'Impresi'#243'n'
        Visible = False
      end
      inherited snDBEdit3: TsnDBEdit
        Top = 49
        TabOrder = 4
      end
      inherited snDBLookup5: TsnDBLookup
        Visible = False
      end
      inherited DBImpresoraComun: TsnDBLookup
        Top = 17
        TabOrder = 2
      end
      inherited DBImpresoraFiscal: TsnDBLookup
        Left = 32
        Top = 89
        Properties.KeyFieldNames = 'oid_imp_fiscal'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSImpresoraFiscal
        TabOrder = 3
        Visible = False
      end
      object snDBLookup1: TsnDBLookup
        Left = 371
        Top = 17
        DataBinding.DataField = 'tipo_impresion'
        DataBinding.DataSource = DSImpresor
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTipoImpresion
        Properties.ReadOnly = False
        TabOrder = 1
        Visible = False
        Width = 166
      end
    end
    inherited GroupBox2: TGroupBox
      Width = 561
      inherited snDBLookup4: TsnDBLookup
        Properties.ListSource = DSTiposArchivos
      end
      inherited srnDBButtonEdit2: TsrnDBButtonEdit
        Width = 427
      end
    end
  end
  inherited Panel1: TPanel [2]
    Width = 603
    Height = 40
    inherited Label3: TLabel
      Width = 53
      Caption = 'Evaluaci'#243'n'
    end
    inherited ImagenSalir: TImage
      Picture.Data = {00}
    end
    inherited snDBEdit2: TsnDBEdit
      Width = 416
    end
  end
  inherited Panel2: TPanel [3]
    Top = 40
    Width = 603
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TEvaluacionCAB
        TableName = 'TEvaluacionCAB'
      end
      item
        DataSet = TTipoImpresora
        TableName = 'TTipoImpresora'
      end
      item
        DataSet = TComproCab
        TableName = 'TComproCab'
      end
      item
        DataSet = TImpresoraComun
        TableName = 'TImpresoraComun'
      end
      item
        DataSet = TTiposOrientacionPapel
        TableName = 'TTiposOrientacionPapel'
      end
      item
        DataSet = TTiposArchivos
        TableName = 'TTiposArchivos'
      end
      item
        DataSet = TImpresoraFiscal
        TableName = 'TImpresoraFiscal'
      end
      item
        DataSet = TCompetenciasEval
        TableName = 'TCompetenciasEval'
      end
      item
        DataSet = TLabels
        TableName = 'TLabels'
      end
      item
        DataSet = TTipoImpDefFact
        TableName = 'TTipoImpDefFact'
      end
      item
        DataSet = TLeyendasReporte
        TableName = 'TLeyendasReporte'
      end
      item
        DataSet = TCompetenciasEval
        TableName = 'TCompetenciasEval'
      end
      item
        DataSet = TAspectosDestacados
        TableName = 'TAspectosDestacados'
      end
      item
        DataSet = TAspectosAMejorar
        TableName = 'TAspectosAMejorar'
      end
      item
        DataSet = TComentarioEvaluado
        TableName = 'TComentarioEvaluado'
      end
      item
        DataSet = TEvaluadores
        TableName = 'TEvaluadores'
      end
      item
        DataSet = TObsGenRRHH
        TableName = 'TObsGenRRHH'
      end
      item
        DataSet = TFirmas
        TableName = 'TFirmas'
      end>
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      '  TraerDatosCompro(variable.getInteger('#39'oid_cco'#39'));'
      '  TraerTiposImpresoras();'
      '  AsignarValores();'
      'end.'
      '')
    OnDataChangeDS = <
      item
        DataSourceName = 'DSImpresor'
        Source.Strings = (
          'begin'
          ''
          'end.')
      end>
    OnPublicVariable = <
      item
        VariableName = 'oid_cco'
      end>
    OnExternalCall = <
      item
        ExternalCall = 'ImpresionDirecta'
        Source.Strings = (
          'begin'
          '  setDefaultTipoImpresionImpDirecta();'
          '  BotonImprimir.Click();'
          'end.')
      end
      item
        ExternalCall = 'VistaPreliminar'
        Source.Strings = (
          'begin'
          '  BotonVistaPreliminar.Click();'
          'end.')
      end
      item
        ExternalCall = 'afterPrint'
        Source.Strings = (
          'begin'
          ''
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  varios.setImagen('#39'ImagenSalir'#39',7);'
          '  TraerImpresorasComunes();'
          
            '  Impresor.CarpetaRepositorio := varios.getValorString('#39'CARPETA_' +
            'REPO_RTM_EVAL'#39');'
          '  TraerLeyendasReporte();'
          '  TraerTiposArchivos();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerImagenLegajo();'
          'var'
          '  mensajeError  : string;'
          '  nomTempFile : string;'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'DownLoadImageLegajo'#39');'
          
            '  nomTempFile := operacion.DownLoadFile(TEvaluacionCAB.FieldName' +
            '('#39'cod_legajo'#39').AsString, mensajeError);'
          ''
          '  TEvaluacionCAB.EditRecord;'
          
            '  TEvaluacionCAB.FieldName('#39'path_logo'#39').AsString :=  nomTempFile' +
            ';'
          ''
          'end;'
          ''
          'function getTipoImpresionDefault(Oid : integer) : string;'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTipoImpresionFact'#39');'
          ' operacion.addAtribute('#39'oid_cco'#39',inttostr(Oid));'
          '  operacion.execute(); '
          
            '  result := TTipoImpDefFact.FieldName('#39'tipo_impresion'#39').AsString' +
            ';'
          'end;'
          ''
          'function getNombreArchivoPlantilla(Prefijo : string) : string;'
          'var'
          '  archivo   : string;'
          '  mensaje  : string;'
          '  carpeta   : string;'
          'begin'
          '  archivo := prefijo+'
          '             TTalonario.FieldName('#39'archivo_rtm'#39').AsString;'
          '  carpeta := varios.getValorString('#39'CARPETA_REPO_RTM_EVAL'#39');'
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'DownLoadArchRepoPlantImp'#39');'
          '  result := operacion.DownloadFile(carpeta+'#39'\'#39'+archivo,mensaje);'
          'end;'
          ''
          'procedure cargarPathLogo();'
          'var'
          '     mensajeError : string;'
          '     nomTempFile : string;'
          'begin'
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'DownLoadImageLogoSucursal'#39');'
          '   nomTempFile := operacion.DownLoadFile('#39#39', mensajeError);'
          ''
          ' // TFacturaCab.EditRecord;'
          
            ' // TFacturaCab.FieldName('#39'path_logo_sucursal'#39').AsString := nomT' +
            'empFile;'
          ' // TFacturaCab.PostRecord();'
          ''
          'end;'
          ''
          ''
          'procedure TraerDatosCompro(oid_cco : integer);'
          'begin'
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'BuscarEvaluacion'#39');'
          '  operacion.addAtribute('#39'BUSCAR_POR'#39','#39'OID_CCO'#39');'
          '  operacion.addAtribute('#39'oid_cco'#39',IntToStr(oid_cco));'
          '  operacion.execute;'
          'end;'
          ''
          'procedure TraerTiposImpresoras();'
          'begin'
          '  operacion.inicioOperacion();'
          '  operacion.setOper('#39'TraerTiposImpresoras'#39');'
          '  operacion.execute;'
          'end;'
          ''
          'procedure TraerDatosTalonario(OidTalonario : integer);'
          'begin'
          '    operacion.inicioOperacion;'
          '    operacion.setOper('#39'TraerTalonario'#39');'
          '    operacion.addAtribute('#39'oid'#39',IntToStr(OidTalonario));'
          '    operacion.execute;'
          'end;'
          ''
          'procedure TraerImpresorasComunes();'
          'begin'
          '    operacion.inicioOperacion;'
          '    operacion.setOper('#39'TraerImpresoraComun'#39');'
          '    operacion.execute;'
          'end;'
          ''
          
            'function getDescImpresoraSistema(OidImpComun : integer) : string' +
            ';'
          'begin'
          '  result := '#39#39';'
          '  TImpresoraComun.First;'
          '  if (TImpresoraComun.Locate('#39'oid_imp_comun'#39',OidImpComun,[]))'
          
            '     then result := TImpresoraComun.FieldName('#39'impresora_sistema' +
            #39').AsString;'
          'end;'
          ''
          ''
          ''
          'procedure AsignarValores();'
          'begin'
          '   TImpresor.Close;'
          '   TImpresor.Open;'
          '   TImpresor.AppendRecord;'
          '   TImpresor.FieldName('#39'comprobante'#39').AsString :='
          '         TComproCab.FieldName('#39'comprobante'#39').AsString;'
          ''
          ''
          'end;'
          ''
          'procedure TraerTiposOrientacion();'
          'begin'
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerTiposOrientacionPapel'#39');'
          '  operacion.execute;'
          'end;'
          ''
          'procedure TraerTiposArchivos();'
          'begin'
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerTiposArchExpReporte'#39');'
          '  operacion.execute;'
          'end;'
          ''
          ''
          'procedure TraerDatosImpresion();'
          'begin'
          ''
          '  TImpresor.postRecord;'
          ' '
          ''
          '  operacion.InicioOperacion;'
          '  operacion.setOper('#39'ImpresionEvaluacionLegajo'#39');'
          
            '  operacion.addAtribute('#39'oid'#39',IntToStr(variable.getInteger('#39'oid_' +
            'cco'#39')));'
          '  operacion.execute;'
          ''
          '  TraerImagenLegajo();'
          ''
          'end;'
          ''
          ''
          'function getPlantillaImpresion() : string;'
          'begin'
          '  result :='
          
            '      getNombreArchivoPlantilla(TTalonario.FieldName('#39'identif_ar' +
            'ch_im'#39').AsString);'
          'end;'
          ''
          'function getPlantillaVistaPreliminar() : string;'
          'begin'
          '  result :='
          
            '      getNombreArchivoPlantilla(TTalonario.FieldName('#39'identif_ar' +
            'ch_vp'#39').AsString);'
          'end;'
          ''
          'function getPlantillaGeneracionArchivo() : string;'
          'begin'
          '  result :='
          
            '      getNombreArchivoPlantilla(TTalonario.FieldName('#39'identif_ar' +
            'ch_ga'#39').AsString);'
          'end;'
          ''
          ''
          'procedure TraerLeyendasReporte();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerLeyendasRepEval'#39');'
          '  operacion.execute();'
          'end;'
          ''
          ''
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImagenSalir'
        Source.Strings = (
          'begin'
          '  close();'
          'end.')
      end
      item
        ButtonName = 'BotonVistaPreliminar'
        Source.Strings = (
          'begin'
          '  TraerDatosImpresion();'
          '  TImpresor.PostRecord;'
          '   Impresor.setPlantilla(getPlantillaVistaPreliminar());'
          
            '   Impresor.setImpresora(TImpresor.FieldName('#39'impresora'#39').AsStri' +
            'ng);'
          
            '   Impresor.setCantCopias(TImpresor.FieldName('#39'nro_copias'#39').AsIn' +
            'teger);'
          '   Impresor.VistaPreliminar();'
          'end.')
      end
      item
        ButtonName = 'BotonImprimir'
        Source.Strings = (
          'begin'
          '  TraerDatosImpresion();'
          '  TImpresor.PostRecord;'
          '  Impresor.setPlantilla(getPlantillaImpresion());'
          
            '  Impresor.setImpresora(TImpresor.FieldName('#39'impresora'#39').AsStrin' +
            'g);'
          
            '  Impresor.setCantCopias(TImpresor.FieldName('#39'nro_copias'#39').AsInt' +
            'eger);    '
          '  Impresor.Imprimir();'
          'end.')
      end
      item
        ButtonName = 'BotonGenerarArchivo'
        Source.Strings = (
          'begin'
          ''
          '  TImpresor.PostRecord;'
          '  TraerDatosImpresion();  '
          '  '
          '  if (TImpresor.FieldName('#39'tipo_archivo'#39').AsString  = '#39'PDF'#39')'
          '     then begin'
          
            '             impresor.setPlantilla(getPlantillaGeneracionArchivo' +
            '());'
          
            '             Impresor.GenerarArchivoPDFEn(TImpresor.FieldName('#39'd' +
            'irectorio'#39').AsString);'
          '             end'
          
            '     else  if (TImpresor.FieldName('#39'tipo_archivo'#39').AsString  = '#39 +
            'PLA'#39')'
          
            '                 then Impresor.GenerarArchivoPlantillaEn(TImpres' +
            'or.FieldName('#39'directorio'#39').AsString);'
          ''
          'end.'
          '')
      end>
    Left = 381
    Top = 53
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TImpresor: TsnTable
    Left = 302
    Top = 20
    object TImpresortipo_impresion: TStringField
      FieldName = 'tipo_impresion'
    end
  end
  inherited DSImpresor: TDataSource
    Left = 334
    Top = 20
  end
  object TComproCab: TsnTable [20]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 350
    Top = 180
    object TComproCaboid_cco: TIntegerField
      FieldName = 'oid_cco'
    end
    object TComproCaboid_tc: TIntegerField
      FieldName = 'oid_tc'
    end
    object TComproCabtc_ext: TStringField
      FieldName = 'tc_ext'
    end
    object TComproCabletra: TStringField
      FieldName = 'letra'
      Size = 1
    end
    object TComproCabnro_ext: TIntegerField
      FieldName = 'nro_ext'
    end
    object TComproCablug_emi: TIntegerField
      FieldName = 'lug_emi'
    end
    object TComproCabemision: TDateField
      FieldName = 'emision'
    end
    object TComproCaboid_lug_emi: TIntegerField
      FieldName = 'oid_lug_emi'
    end
    object TComproCabcomentario: TStringField
      FieldName = 'comentario'
      Size = 255
    end
    object TComproCabfec_alta: TDateField
      FieldName = 'fec_alta'
    end
    object TComproCaboid_usuario: TIntegerField
      FieldName = 'oid_usuario'
    end
    object TComproCabestado: TStringField
      FieldName = 'estado'
      Size = 10
    end
    object TComproCabactivo: TBooleanField
      FieldName = 'activo'
    end
    object TComproCaboid_talonario: TIntegerField
      FieldName = 'oid_talonario'
    end
    object TComproCaboid_sucursal: TIntegerField
      FieldName = 'oid_sucursal'
    end
    object TComproCabimputac: TDateField
      FieldName = 'imputac'
    end
    object TComproCaboid_motivo_compro: TIntegerField
      FieldName = 'oid_motivo_compro'
    end
    object TComproCabcomprobante: TStringField
      FieldName = 'comprobante'
      Size = 100
    end
  end
  object TTalonario: TsnTable [21]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_talonario'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 30
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'tipo_imp_asoc'
        DataType = ftString
        Size = 15
      end
      item
        Name = 'oid_imp_fiscal'
        DataType = ftInteger
      end
      item
        Name = 'oid_imp_comun'
        DataType = ftInteger
      end
      item
        Name = 'oid_tc'
        DataType = ftInteger
      end
      item
        Name = 'letra'
        DataType = ftString
        Size = 1
      end
      item
        Name = 'oid_lug_emi'
        DataType = ftInteger
      end
      item
        Name = 'nom_arch_imp'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'primer_nro'
        DataType = ftInteger
      end
      item
        Name = 'nro_actual'
        DataType = ftInteger
      end
      item
        Name = 'ultimo_nro'
        DataType = ftInteger
      end
      item
        Name = 'nro_automatica'
        DataType = ftBoolean
      end
      item
        Name = 'fec_vto'
        DataType = ftDate
      end
      item
        Name = 'cai'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_uni_org'
        DataType = ftInteger
      end>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 350
    Top = 135
    object TTalonariooid_talonario: TIntegerField
      FieldName = 'oid_talonario'
    end
    object TTalonariocodigo: TStringField
      FieldName = 'codigo'
      Size = 30
    end
    object TTalonariodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
    object TTalonariotipo_imp_asoc: TStringField
      FieldName = 'tipo_imp_asoc'
      Size = 15
    end
    object TTalonariooid_imp_fiscal: TIntegerField
      FieldName = 'oid_imp_fiscal'
    end
    object TTalonariooid_imp_comun: TIntegerField
      FieldName = 'oid_imp_comun'
    end
    object TTalonariooid_tc: TIntegerField
      FieldName = 'oid_tc'
    end
    object TTalonariocod_tc: TStringField
      FieldName = 'cod_tc'
      Size = 30
    end
    object TTalonarioletra: TStringField
      FieldName = 'letra'
      Size = 1
    end
    object TTalonariooid_lug_emi: TIntegerField
      FieldName = 'oid_lug_emi'
    end
    object TTalonarionro_lug_emi: TIntegerField
      FieldName = 'nro_lug_emi'
    end
    object TTalonarionom_arch_imp: TStringField
      FieldName = 'nom_arch_imp'
      Size = 100
    end
    object TTalonarioprimer_nro: TIntegerField
      FieldName = 'primer_nro'
    end
    object TTalonarionro_actual: TIntegerField
      FieldName = 'nro_actual'
    end
    object TTalonarioultimo_nro: TIntegerField
      FieldName = 'ultimo_nro'
    end
    object TTalonarionro_automatica: TBooleanField
      FieldName = 'nro_automatica'
    end
    object TTalonariofec_vto: TDateField
      FieldName = 'fec_vto'
    end
    object TTalonariocai: TStringField
      FieldName = 'cai'
      Size = 100
    end
    object TTalonariooid_uni_org: TIntegerField
      FieldName = 'oid_uni_org'
    end
    object TTalonarioactivo: TBooleanField
      FieldName = 'activo'
    end
    object TTalonariocant_copias: TIntegerField
      FieldName = 'cant_copias'
    end
    object TTalonariointercalar: TBooleanField
      FieldName = 'intercalar'
    end
    object TTalonarioorientacion: TStringField
      FieldName = 'orientacion'
    end
    object TTalonariogenerar_archivo: TBooleanField
      FieldName = 'generar_archivo'
    end
    object TTalonariotipo_archivo: TStringField
      FieldName = 'tipo_archivo'
    end
    object TTalonarioidentif_arch_vp: TStringField
      FieldName = 'identif_arch_vp'
    end
    object TTalonarioidentif_arch_im: TStringField
      FieldName = 'identif_arch_im'
    end
    object TTalonarioidentif_arch_ga: TStringField
      FieldName = 'identif_arch_ga'
    end
    object TTalonarioarchivo_rtm: TStringField
      FieldName = 'archivo_rtm'
      Size = 500
    end
    object TTalonariopath_gen_arch_imp: TStringField
      FieldName = 'path_gen_arch_imp'
      Size = 255
    end
  end
  object DSTalonarios: TDataSource [22]
    DataSet = TTalonario
    Left = 382
    Top = 135
  end
  object TImpresoraComun: TsnTable [23]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 352
    Top = 376
    object TImpresoraComunoid_imp_comun: TIntegerField
      FieldName = 'oid_imp_comun'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TImpresoraComuncodigo: TStringField
      DisplayWidth = 30
      FieldName = 'codigo'
      Size = 30
    end
    object TImpresoraComundescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TImpresoraComunimpresora_sistema: TStringField
      DisplayWidth = 250
      FieldName = 'impresora_sistema'
      Size = 250
    end
    object TImpresoraComunactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TImpresoraComunoid_uni_org: TIntegerField
      FieldName = 'oid_uni_org'
    end
    object TImpresoraComuncod_uni_org: TStringField
      FieldName = 'cod_uni_org'
      Size = 50
    end
    object TImpresoraComundesc_uni_org: TStringField
      FieldName = 'desc_uni_org'
      Size = 100
    end
  end
  object TTiposOrientacionPapel: TsnTable [26]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 350
    Top = 300
    object TTiposOrientacionPapeloid: TIntegerField
      FieldName = 'oid'
    end
    object TTiposOrientacionPapelcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTiposOrientacionPapeldescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTipoOrientacion: TDataSource [27]
    DataSet = TTiposOrientacionPapel
    Left = 382
    Top = 300
  end
  object TTiposArchivos: TsnTable [28]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 430
    Top = 297
    object TTiposArchivosoid: TIntegerField
      FieldName = 'oid'
    end
    object TTiposArchivoscodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTiposArchivosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTiposArchivos: TDataSource [29]
    DataSet = TTiposArchivos
    Left = 462
    Top = 297
  end
  object TImpresoraFiscal: TsnTable [30]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 209
    Top = 29
    object TImpresoraFiscaloid_imp_fiscal: TIntegerField
      FieldName = 'oid_imp_fiscal'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TImpresoraFiscalcodigo: TStringField
      DisplayWidth = 30
      FieldName = 'codigo'
      Size = 30
    end
    object TImpresoraFiscaldescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TImpresoraFiscalcompo_imp_fiscal: TStringField
      FieldName = 'compo_imp_fiscal'
      Size = 15
    end
    object TImpresoraFiscalactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TImpresoraFiscaloid_uni_org: TIntegerField
      FieldName = 'oid_uni_org'
    end
    object TImpresoraFiscalcod_uni_org: TStringField
      FieldName = 'cod_uni_org'
      Size = 50
    end
    object TImpresoraFiscaldesc_uni_org: TStringField
      FieldName = 'desc_uni_org'
      Size = 100
    end
  end
  object DSImpresoraFiscal: TDataSource [31]
    DataSet = TImpresoraFiscal
    Left = 241
    Top = 29
  end
  inherited Reporte: TppReport
    AutoStop = False
    DataPipeline = EvaluacionesCab
    OutlineSettings.Visible = False
    PreviewFormSettings.WindowState = wsMaximized
    PreviewFormSettings.ZoomPercentage = 100
    Top = 286
    DataPipelineName = 'EvaluacionesCab'
    object ppHeaderBand1: TppHeaderBand
      mmBottomOffset = 0
      mmHeight = 115888
      mmPrintPosition = 0
      object ppShape3: TppShape
        UserName = 'Shape3'
        mmHeight = 75142
        mmLeft = 529
        mmTop = 40217
        mmWidth = 193411
        BandType = 0
      end
      object ppDBText1: TppDBText
        UserName = 'DBText1'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        DataField = 'modelo'
        DataPipeline = EvaluacionesCab
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 9
        Font.Style = []
        Transparent = True
        DataPipelineName = 'EvaluacionesCab'
        mmHeight = 6879
        mmLeft = 4233
        mmTop = 55563
        mmWidth = 77258
        BandType = 0
      end
      object ImagenLogo: TppImage
        UserName = 'ImagenLogo'
        MaintainAspectRatio = True
        Stretch = True
        Transparent = True
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        mmHeight = 49477
        mmLeft = 142346
        mmTop = 52123
        mmWidth = 49477
        BandType = 0
      end
      object ppDBText33: TppDBText
        UserName = 'VendedorNombreApellido1'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        DataField = 'titulo_1'
        DataPipeline = LeyendasReportes
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 9
        Font.Style = [fsBold]
        ParentDataPipeline = False
        TextAlignment = taCentered
        Transparent = True
        DataPipelineName = 'LeyendasReportes'
        mmHeight = 4763
        mmLeft = 529
        mmTop = 16140
        mmWidth = 193675
        BandType = 0
      end
      object ppDBText32: TppDBText
        UserName = 'DBText32'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        DataField = 'titulo_2'
        DataPipeline = LeyendasReportes
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 9
        Font.Style = [fsBold]
        ParentDataPipeline = False
        TextAlignment = taCentered
        Transparent = True
        DataPipelineName = 'LeyendasReportes'
        mmHeight = 4784
        mmLeft = 529
        mmTop = 24342
        mmWidth = 193675
        BandType = 0
      end
      object ppDBText34: TppDBText
        UserName = 'DBText34'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        DataField = 'titulo_3'
        DataPipeline = LeyendasReportes
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 9
        Font.Style = [fsBold]
        ParentDataPipeline = False
        TextAlignment = taCentered
        Transparent = True
        DataPipelineName = 'LeyendasReportes'
        mmHeight = 4784
        mmLeft = 794
        mmTop = 32808
        mmWidth = 193411
        BandType = 0
      end
      object ppSystemVariable1: TppSystemVariable
        UserName = 'SystemVariable1'
        AutoSize = False
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        VarType = vtPageNo
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlack
        Font.Name = 'Verdana'
        Font.Size = 8
        Font.Style = []
        TextAlignment = taRightJustified
        Transparent = True
        mmHeight = 3440
        mmLeft = 184150
        mmTop = 2381
        mmWidth = 3969
        BandType = 0
      end
      object ppLabel1: TppLabel
        UserName = 'Label1'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        Caption = '/'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlack
        Font.Name = 'Verdana'
        Font.Size = 8
        Font.Style = []
        Transparent = True
        mmHeight = 3440
        mmLeft = 188384
        mmTop = 2117
        mmWidth = 1323
        BandType = 0
      end
      object ppSystemVariable2: TppSystemVariable
        UserName = 'SystemVariable2'
        AutoSize = False
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        VarType = vtPageCount
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlack
        Font.Name = 'Verdana'
        Font.Size = 8
        Font.Style = []
        Transparent = True
        mmHeight = 3440
        mmLeft = 189971
        mmTop = 2381
        mmWidth = 3704
        BandType = 0
      end
      object ppShape2: TppShape
        UserName = 'Shape2'
        Brush.Color = 10801663
        mmHeight = 7408
        mmLeft = 529
        mmTop = 40217
        mmWidth = 193411
        BandType = 0
      end
      object ppLabel2: TppLabel
        UserName = 'Label2'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        Caption = 'EVALUACION Y GESTION DE DESEMPE'#209'O'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 9
        Font.Style = [fsBold]
        TextAlignment = taCentered
        Transparent = True
        mmHeight = 3969
        mmLeft = 7408
        mmTop = 42069
        mmWidth = 183357
        BandType = 0
      end
      object ppLabel3: TppLabel
        UserName = 'Label3'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        Caption = 'Hoja'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 8
        Font.Style = []
        TextAlignment = taRightJustified
        Transparent = True
        mmHeight = 3440
        mmLeft = 173832
        mmTop = 2117
        mmWidth = 9260
        BandType = 0
      end
      object ppShape6: TppShape
        UserName = 'Shape6'
        Brush.Color = 10801663
        mmHeight = 8467
        mmLeft = 3969
        mmTop = 1852
        mmWidth = 22225
        BandType = 0
      end
      object ppLabel4: TppLabel
        UserName = 'Label4'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        Caption = 'RRHH'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlack
        Font.Name = 'Verdana'
        Font.Size = 14
        Font.Style = []
        Transparent = True
        mmHeight = 6085
        mmLeft = 8202
        mmTop = 2910
        mmWidth = 14288
        BandType = 0
      end
      object ppLabel5: TppLabel
        UserName = 'Label5'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        Caption = 'EVALUACION'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 10
        Font.Style = [fsBold]
        Transparent = True
        mmHeight = 4233
        mmLeft = 4498
        mmTop = 51594
        mmWidth = 25993
        BandType = 0
      end
      object ppLabel6: TppLabel
        UserName = 'Label6'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        Caption = 'VERSION'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 10
        Font.Style = [fsBold]
        Transparent = True
        mmHeight = 4233
        mmLeft = 82815
        mmTop = 51594
        mmWidth = 18203
        BandType = 0
      end
      object ppDBText2: TppDBText
        UserName = 'DBText2'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        DataField = 'version_eval'
        DataPipeline = EvaluacionesCab
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 9
        Font.Style = []
        TextAlignment = taCentered
        Transparent = True
        DataPipelineName = 'EvaluacionesCab'
        mmHeight = 6879
        mmLeft = 82021
        mmTop = 55563
        mmWidth = 19050
        BandType = 0
      end
      object ppDBText3: TppDBText
        UserName = 'DBText3'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        DataField = 'fec_eval'
        DataPipeline = EvaluacionesCab
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 9
        Font.Style = []
        TextAlignment = taCentered
        Transparent = True
        DataPipelineName = 'EvaluacionesCab'
        mmHeight = 6879
        mmLeft = 101600
        mmTop = 55563
        mmWidth = 38894
        BandType = 0
      end
      object ppLabel7: TppLabel
        UserName = 'Label7'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        Caption = 'FECHA'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 10
        Font.Style = [fsBold]
        Transparent = True
        mmHeight = 4233
        mmLeft = 113506
        mmTop = 51329
        mmWidth = 12965
        BandType = 0
      end
      object ppLabel8: TppLabel
        UserName = 'Label8'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        Caption = 'LEGAJO'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 10
        Font.Style = [fsBold]
        Transparent = True
        mmHeight = 4233
        mmLeft = 4233
        mmTop = 64823
        mmWidth = 15155
        BandType = 0
      end
      object ppDBText4: TppDBText
        UserName = 'DBText5'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        DataField = 'cod_legajo'
        DataPipeline = EvaluacionesCab
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 9
        Font.Style = []
        Transparent = True
        DataPipelineName = 'EvaluacionesCab'
        mmHeight = 6858
        mmLeft = 3969
        mmTop = 68792
        mmWidth = 34396
        BandType = 0
      end
      object ppLabel9: TppLabel
        UserName = 'Label9'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        Caption = 'APELLIDO Y NOMBRE'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 10
        Font.Style = [fsBold]
        Transparent = True
        mmHeight = 4233
        mmLeft = 38365
        mmTop = 64823
        mmWidth = 42122
        BandType = 0
      end
      object ppDBText5: TppDBText
        UserName = 'DBText6'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        DataField = 'ape_nom_legajo'
        DataPipeline = EvaluacionesCab
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 9
        Font.Style = []
        Transparent = True
        DataPipelineName = 'EvaluacionesCab'
        mmHeight = 6858
        mmLeft = 37571
        mmTop = 68792
        mmWidth = 102923
        BandType = 0
      end
      object ppLabel10: TppLabel
        UserName = 'Label10'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        Caption = 'EMPRESA'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 10
        Font.Style = [fsBold]
        Transparent = True
        mmHeight = 4233
        mmLeft = 4233
        mmTop = 78317
        mmWidth = 18711
        BandType = 0
      end
      object ppDBText6: TppDBText
        UserName = 'DBText7'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        DataField = 'desc_empresa'
        DataPipeline = EvaluacionesCab
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 9
        Font.Style = []
        Transparent = True
        DataPipelineName = 'EvaluacionesCab'
        mmHeight = 6858
        mmLeft = 3969
        mmTop = 82286
        mmWidth = 136261
        BandType = 0
      end
      object ppLabel11: TppLabel
        UserName = 'Label101'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        Caption = 'SECTOR'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 10
        Font.Style = [fsBold]
        Transparent = True
        mmHeight = 4233
        mmLeft = 4233
        mmTop = 91281
        mmWidth = 15621
        BandType = 0
      end
      object ppDBText7: TppDBText
        UserName = 'DBText4'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        DataField = 'desc_sector'
        DataPipeline = EvaluacionesCab
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 9
        Font.Style = []
        Transparent = True
        DataPipelineName = 'EvaluacionesCab'
        mmHeight = 6858
        mmLeft = 3969
        mmTop = 95250
        mmWidth = 136261
        BandType = 0
      end
      object ppLabel12: TppLabel
        UserName = 'Label12'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        Caption = 'PUESTO'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 10
        Font.Style = [fsBold]
        Transparent = True
        mmHeight = 4233
        mmLeft = 3969
        mmTop = 103981
        mmWidth = 15748
        BandType = 0
      end
      object ppDBText8: TppDBText
        UserName = 'DBText8'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        DataField = 'desc_puesto'
        DataPipeline = EvaluacionesCab
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 9
        Font.Style = []
        Transparent = True
        DataPipelineName = 'EvaluacionesCab'
        mmHeight = 6858
        mmLeft = 3704
        mmTop = 107950
        mmWidth = 136261
        BandType = 0
      end
      object ppShape4: TppShape
        UserName = 'Shape4'
        mmHeight = 12700
        mmLeft = 142611
        mmTop = 101865
        mmWidth = 48948
        BandType = 0
      end
      object ppLabel13: TppLabel
        UserName = 'Label13'
        AutoSize = False
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        Caption = 'PUNTAJE OBTENIDO'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 8
        Font.Style = [fsBold]
        TextAlignment = taCentered
        Transparent = True
        mmHeight = 3440
        mmLeft = 144198
        mmTop = 103188
        mmWidth = 46038
        BandType = 0
      end
      object ppDBText11: TppDBText
        UserName = 'DBText101'
        Border.BorderPositions = []
        Border.Color = clBlack
        Border.Style = psSolid
        Border.Visible = False
        Border.Weight = 1.000000000000000000
        DataField = 'puntaje'
        DataPipeline = EvaluacionesCab
        DisplayFormat = '###.##'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = -2147483640
        Font.Name = 'Verdana'
        Font.Size = 14
        Font.Style = [fsBold, fsItalic]
        TextAlignment = taCentered
        Transparent = True
        DataPipelineName = 'EvaluacionesCab'
        mmHeight = 6615
        mmLeft = 152400
        mmTop = 107156
        mmWidth = 30427
        BandType = 0
      end
    end
    object ppDetailBand1: TppDetailBand
      PrintHeight = phDynamic
      mmBottomOffset = 0
      mmHeight = 91811
      mmPrintPosition = 0
      object DetallesPedido: TppSubReport
        UserName = 'DetallesPedido'
        ExpandAll = False
        KeepTogether = True
        NewPrintJob = False
        OutlineSettings.CreateNode = True
        TraverseAllData = True
        DataPipelineName = 'Competencias'
        mmHeight = 10848
        mmLeft = 0
        mmTop = 0
        mmWidth = 197300
        BandType = 4
        mmBottomOffset = 0
        mmOverFlowOffset = 0
        mmStopPosition = 0
        object ppChildReport1: TppChildReport
          AutoStop = False
          DataPipeline = Competencias
          PrinterSetup.BinName = 'Default'
          PrinterSetup.DocumentName = 'Report'
          PrinterSetup.PaperName = 'A4'
          PrinterSetup.PrinterName = 'Default'
          PrinterSetup.mmMarginBottom = 6350
          PrinterSetup.mmMarginLeft = 6350
          PrinterSetup.mmMarginRight = 6350
          PrinterSetup.mmMarginTop = 6350
          PrinterSetup.mmPaperHeight = 297000
          PrinterSetup.mmPaperWidth = 210000
          PrinterSetup.PaperSize = 9
          Version = '10.02'
          mmColumnWidth = 0
          DataPipelineName = 'Competencias'
          object ppTitleBand1: TppTitleBand
            mmBottomOffset = 0
            mmHeight = 9260
            mmPrintPosition = 0
            object ppLabel14: TppLabel
              UserName = 'Label14'
              Border.BorderPositions = []
              Border.Color = clBlack
              Border.Style = psSolid
              Border.Visible = False
              Border.Weight = 1.000000000000000000
              Caption = 'COMPETENCIA'
              Font.Charset = DEFAULT_CHARSET
              Font.Color = -2147483640
              Font.Name = 'Verdana'
              Font.Size = 9
              Font.Style = [fsBold]
              Transparent = True
              mmHeight = 3852
              mmLeft = 2117
              mmTop = 3440
              mmWidth = 25993
              BandType = 1
            end
            object ppLabel27: TppLabel
              UserName = 'Label27'
              Border.BorderPositions = []
              Border.Color = clBlack
              Border.Style = psSolid
              Border.Visible = False
              Border.Weight = 1.000000000000000000
              Caption = 'GRADO / %'
              Font.Charset = DEFAULT_CHARSET
              Font.Color = -2147483640
              Font.Name = 'Verdana'
              Font.Size = 9
              Font.Style = [fsBold]
              Transparent = True
              mmHeight = 3852
              mmLeft = 59796
              mmTop = 3440
              mmWidth = 21294
              BandType = 1
            end
            object ppLabel28: TppLabel
              UserName = 'Label28'
              Border.BorderPositions = []
              Border.Color = clBlack
              Border.Style = psSolid
              Border.Visible = False
              Border.Weight = 1.000000000000000000
              Caption = 'DESCRIPCION GRADO'
              Font.Charset = DEFAULT_CHARSET
              Font.Color = -2147483640
              Font.Name = 'Verdana'
              Font.Size = 9
              Font.Style = [fsBold]
              Transparent = True
              mmHeight = 3852
              mmLeft = 84667
              mmTop = 3440
              mmWidth = 39285
              BandType = 1
            end
          end
          object ppDetailBand2: TppDetailBand
            PrintHeight = phDynamic
            mmBottomOffset = 0
            mmHeight = 9525
            mmPrintPosition = 0
            object ppRegion1: TppRegion
              UserName = 'Region1'
              KeepTogether = True
              Brush.Style = bsClear
              Caption = 'Region1'
              Pen.Style = psClear
              Stretch = True
              Transparent = True
              mmHeight = 9525
              mmLeft = 1058
              mmTop = 0
              mmWidth = 195527
              BandType = 4
              mmBottomOffset = 0
              mmOverFlowOffset = 0
              mmStopPosition = 0
              object ppDBText13: TppDBText
                UserName = 'DBText13'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                DataField = 'nro_grado'
                DataPipeline = Competencias
                DisplayFormat = '###,###,###,###,###.####'
                Font.Charset = DEFAULT_CHARSET
                Font.Color = -2147483640
                Font.Name = 'Verdana'
                Font.Size = 8
                Font.Style = []
                TextAlignment = taRightJustified
                Transparent = True
                DataPipelineName = 'Competencias'
                mmHeight = 4763
                mmLeft = 62177
                mmTop = 2646
                mmWidth = 7673
                BandType = 4
              end
              object ppDBCodigoProducto: TppDBMemo
                UserName = 'DBCodigoProducto'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                CharWrap = False
                DataField = 'desc_competencia'
                DataPipeline = Competencias
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clBlack
                Font.Name = 'Verdana'
                Font.Size = 8
                Font.Style = []
                Stretch = True
                Transparent = True
                DataPipelineName = 'Competencias'
                mmHeight = 4763
                mmLeft = 3175
                mmTop = 2646
                mmWidth = 58208
                BandType = 4
                mmBottomOffset = 0
                mmOverFlowOffset = 0
                mmStopPosition = 0
                mmLeading = 0
              end
              object ppLine16: TppLine
                UserName = 'Line16'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                ParentHeight = True
                Position = lpLeft
                Visible = False
                Weight = 0.750000000000000000
                mmHeight = 9525
                mmLeft = 194469
                mmTop = 0
                mmWidth = 13229
                BandType = 4
              end
              object ppLine17: TppLine
                UserName = 'Line17'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                ParentHeight = True
                Position = lpLeft
                Visible = False
                Weight = 0.750000000000000000
                mmHeight = 9525
                mmLeft = 1323
                mmTop = 0
                mmWidth = 13229
                BandType = 4
              end
              object ppDBText10: TppDBText
                UserName = 'DBText10'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                DataField = 'porc_cump'
                DataPipeline = Competencias
                DisplayFormat = '###,###,###,###,###.####'
                Font.Charset = DEFAULT_CHARSET
                Font.Color = -2147483640
                Font.Name = 'Verdana'
                Font.Size = 8
                Font.Style = []
                TextAlignment = taRightJustified
                Transparent = True
                DataPipelineName = 'Competencias'
                mmHeight = 4763
                mmLeft = 70644
                mmTop = 2646
                mmWidth = 9260
                BandType = 4
              end
              object ppDBMemo1: TppDBMemo
                UserName = 'DBCodigoProducto1'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                CharWrap = False
                DataField = 'descripcion'
                DataPipeline = Competencias
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clBlack
                Font.Name = 'Verdana'
                Font.Size = 7
                Font.Style = []
                Stretch = True
                Transparent = True
                DataPipelineName = 'Competencias'
                mmHeight = 4763
                mmLeft = 84402
                mmTop = 2646
                mmWidth = 108479
                BandType = 4
                mmBottomOffset = 0
                mmOverFlowOffset = 0
                mmStopPosition = 0
                mmLeading = 0
              end
            end
          end
          object ppFooterBand2: TppFooterBand
            mmBottomOffset = 0
            mmHeight = 0
            mmPrintPosition = 0
          end
          object ppSummaryBand1: TppSummaryBand
            PrintHeight = phDynamic
            mmBottomOffset = 0
            mmHeight = 0
            mmPrintPosition = 0
          end
          object ppGroup1: TppGroup
            BreakName = 'oid_compe_eval'
            DataPipeline = Competencias
            KeepTogether = True
            OutlineSettings.CreateNode = True
            UserName = 'Group1'
            mmNewColumnThreshold = 0
            mmNewPageThreshold = 0
            DataPipelineName = 'Competencias'
            object ppGroupHeaderBand1: TppGroupHeaderBand
              mmBottomOffset = 0
              mmHeight = 0
              mmPrintPosition = 0
            end
            object ppGroupFooterBand1: TppGroupFooterBand
              mmBottomOffset = 0
              mmHeight = 0
              mmPrintPosition = 0
            end
          end
        end
      end
      object DetalleAspectosDestacados: TppSubReport
        UserName = 'DetallesAspectosDestacados'
        ExpandAll = False
        KeepTogether = True
        NewPrintJob = False
        OutlineSettings.CreateNode = True
        ShiftRelativeTo = DetallesPedido
        TraverseAllData = True
        DataPipelineName = 'AspectosDestacados'
        mmHeight = 10848
        mmLeft = 0
        mmTop = 11906
        mmWidth = 197300
        BandType = 4
        mmBottomOffset = 0
        mmOverFlowOffset = 0
        mmStopPosition = 0
        object ppChildReport2: TppChildReport
          AutoStop = False
          DataPipeline = AspectosDestacados
          PrinterSetup.BinName = 'Default'
          PrinterSetup.DocumentName = 'Report'
          PrinterSetup.PaperName = 'A4'
          PrinterSetup.PrinterName = 'Default'
          PrinterSetup.mmMarginBottom = 6350
          PrinterSetup.mmMarginLeft = 6350
          PrinterSetup.mmMarginRight = 6350
          PrinterSetup.mmMarginTop = 6350
          PrinterSetup.mmPaperHeight = 297000
          PrinterSetup.mmPaperWidth = 210000
          PrinterSetup.PaperSize = 9
          Version = '10.02'
          mmColumnWidth = 0
          DataPipelineName = 'AspectosDestacados'
          object ppTitleBand2: TppTitleBand
            mmBottomOffset = 0
            mmHeight = 9260
            mmPrintPosition = 0
            object ppLabel15: TppLabel
              UserName = 'Label15'
              Border.BorderPositions = []
              Border.Color = clBlack
              Border.Style = psSolid
              Border.Visible = False
              Border.Weight = 1.000000000000000000
              Caption = 'ASPECTOS DESTACADOS'
              Font.Charset = DEFAULT_CHARSET
              Font.Color = -2147483640
              Font.Name = 'Verdana'
              Font.Size = 9
              Font.Style = [fsBold]
              Transparent = True
              mmHeight = 3852
              mmLeft = 1852
              mmTop = 2910
              mmWidth = 43646
              BandType = 1
            end
          end
          object ppDetailBand3: TppDetailBand
            PrintHeight = phDynamic
            mmBottomOffset = 0
            mmHeight = 9525
            mmPrintPosition = 0
            object ppRegion2: TppRegion
              UserName = 'Region1'
              KeepTogether = True
              Brush.Style = bsClear
              Caption = 'Region1'
              Pen.Style = psClear
              Stretch = True
              Transparent = True
              mmHeight = 9525
              mmLeft = 1058
              mmTop = 0
              mmWidth = 195527
              BandType = 4
              mmBottomOffset = 0
              mmOverFlowOffset = 0
              mmStopPosition = 0
              object ppDBMemo2: TppDBMemo
                UserName = 'DBCodigoProducto'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                CharWrap = False
                DataField = 'ASPECTO'
                DataPipeline = AspectosDestacados
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clBlack
                Font.Name = 'Verdana'
                Font.Size = 8
                Font.Style = []
                Stretch = True
                Transparent = True
                DataPipelineName = 'AspectosDestacados'
                mmHeight = 4763
                mmLeft = 3175
                mmTop = 2646
                mmWidth = 189442
                BandType = 4
                mmBottomOffset = 0
                mmOverFlowOffset = 0
                mmStopPosition = 0
                mmLeading = 0
              end
              object ppLine1: TppLine
                UserName = 'Line16'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                ParentHeight = True
                Position = lpLeft
                Visible = False
                Weight = 0.750000000000000000
                mmHeight = 9525
                mmLeft = 194469
                mmTop = 0
                mmWidth = 13229
                BandType = 4
              end
              object ppLine2: TppLine
                UserName = 'Line17'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                ParentHeight = True
                Position = lpLeft
                Visible = False
                Weight = 0.750000000000000000
                mmHeight = 9525
                mmLeft = 1323
                mmTop = 0
                mmWidth = 13229
                BandType = 4
              end
            end
          end
          object ppFooterBand3: TppFooterBand
            mmBottomOffset = 0
            mmHeight = 0
            mmPrintPosition = 0
          end
          object ppSummaryBand2: TppSummaryBand
            PrintHeight = phDynamic
            mmBottomOffset = 0
            mmHeight = 0
            mmPrintPosition = 0
          end
          object ppGroup2: TppGroup
            BreakName = 'OID_EVAL_ASP'
            DataPipeline = AspectosDestacados
            KeepTogether = True
            OutlineSettings.CreateNode = True
            UserName = 'Group1'
            mmNewColumnThreshold = 0
            mmNewPageThreshold = 0
            DataPipelineName = 'AspectosDestacados'
            object ppGroupHeaderBand2: TppGroupHeaderBand
              mmBottomOffset = 0
              mmHeight = 0
              mmPrintPosition = 0
            end
            object ppGroupFooterBand2: TppGroupFooterBand
              mmBottomOffset = 0
              mmHeight = 0
              mmPrintPosition = 0
            end
          end
        end
      end
      object ppSubReportAspAMejorar: TppSubReport
        UserName = 'AspectosAMejorar1'
        ExpandAll = False
        KeepTogether = True
        NewPrintJob = False
        OutlineSettings.CreateNode = True
        ShiftRelativeTo = DetalleAspectosDestacados
        TraverseAllData = True
        DataPipelineName = 'AspectosAMejorar'
        mmHeight = 10848
        mmLeft = 0
        mmTop = 24077
        mmWidth = 197300
        BandType = 4
        mmBottomOffset = 0
        mmOverFlowOffset = 0
        mmStopPosition = 0
        object ppChildReport3: TppChildReport
          AutoStop = False
          DataPipeline = AspectosAMejorar
          PrinterSetup.BinName = 'Default'
          PrinterSetup.DocumentName = 'Report'
          PrinterSetup.PaperName = 'A4'
          PrinterSetup.PrinterName = 'Default'
          PrinterSetup.mmMarginBottom = 6350
          PrinterSetup.mmMarginLeft = 6350
          PrinterSetup.mmMarginRight = 6350
          PrinterSetup.mmMarginTop = 6350
          PrinterSetup.mmPaperHeight = 297000
          PrinterSetup.mmPaperWidth = 210000
          PrinterSetup.PaperSize = 9
          Version = '10.02'
          mmColumnWidth = 0
          DataPipelineName = 'AspectosAMejorar'
          object ppTitleBand3: TppTitleBand
            mmBottomOffset = 0
            mmHeight = 9260
            mmPrintPosition = 0
            object ppLabel16: TppLabel
              UserName = 'Label15'
              Border.BorderPositions = []
              Border.Color = clBlack
              Border.Style = psSolid
              Border.Visible = False
              Border.Weight = 1.000000000000000000
              Caption = 'ASPECTOS A MEJORAR'
              Font.Charset = DEFAULT_CHARSET
              Font.Color = -2147483640
              Font.Name = 'Verdana'
              Font.Size = 9
              Font.Style = [fsBold]
              Transparent = True
              mmHeight = 3969
              mmLeft = 1852
              mmTop = 3175
              mmWidth = 40217
              BandType = 1
            end
          end
          object ppDetailBand4: TppDetailBand
            PrintHeight = phDynamic
            mmBottomOffset = 0
            mmHeight = 9525
            mmPrintPosition = 0
            object ppRegion3: TppRegion
              UserName = 'Region1'
              KeepTogether = True
              Brush.Style = bsClear
              Caption = 'Region1'
              Pen.Style = psClear
              Stretch = True
              Transparent = True
              mmHeight = 9525
              mmLeft = 1058
              mmTop = 0
              mmWidth = 195527
              BandType = 4
              mmBottomOffset = 0
              mmOverFlowOffset = 0
              mmStopPosition = 0
              object ppDBMemo3: TppDBMemo
                UserName = 'DBCodigoProducto'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                CharWrap = False
                DataField = 'ASPECTO'
                DataPipeline = AspectosAMejorar
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clBlack
                Font.Name = 'Verdana'
                Font.Size = 8
                Font.Style = []
                Stretch = True
                Transparent = True
                DataPipelineName = 'AspectosAMejorar'
                mmHeight = 4763
                mmLeft = 3175
                mmTop = 2646
                mmWidth = 189442
                BandType = 4
                mmBottomOffset = 0
                mmOverFlowOffset = 0
                mmStopPosition = 0
                mmLeading = 0
              end
              object ppLine3: TppLine
                UserName = 'Line16'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                ParentHeight = True
                Position = lpLeft
                Visible = False
                Weight = 0.750000000000000000
                mmHeight = 9525
                mmLeft = 194469
                mmTop = 0
                mmWidth = 13229
                BandType = 4
              end
              object ppLine4: TppLine
                UserName = 'Line17'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                ParentHeight = True
                Position = lpLeft
                Visible = False
                Weight = 0.750000000000000000
                mmHeight = 9525
                mmLeft = 1323
                mmTop = 0
                mmWidth = 13229
                BandType = 4
              end
            end
          end
          object ppFooterBand4: TppFooterBand
            mmBottomOffset = 0
            mmHeight = 0
            mmPrintPosition = 0
          end
          object ppSummaryBand3: TppSummaryBand
            PrintHeight = phDynamic
            mmBottomOffset = 0
            mmHeight = 0
            mmPrintPosition = 0
          end
          object ppGroup3: TppGroup
            BreakName = 'OID_EVAL_ASP'
            DataPipeline = AspectosAMejorar
            KeepTogether = True
            OutlineSettings.CreateNode = True
            UserName = 'Group1'
            mmNewColumnThreshold = 0
            mmNewPageThreshold = 0
            DataPipelineName = 'AspectosAMejorar'
            object ppGroupHeaderBand3: TppGroupHeaderBand
              mmBottomOffset = 0
              mmHeight = 0
              mmPrintPosition = 0
            end
            object ppGroupFooterBand3: TppGroupFooterBand
              mmBottomOffset = 0
              mmHeight = 0
              mmPrintPosition = 0
            end
          end
        end
      end
      object SubComenEvaluado: TppSubReport
        UserName = 'ComentarioEvaluado1'
        ExpandAll = False
        KeepTogether = True
        NewPrintJob = False
        OutlineSettings.CreateNode = True
        ShiftRelativeTo = ppSubReportAspAMejorar
        TraverseAllData = True
        DataPipelineName = 'ComentarioEvaluado'
        mmHeight = 10848
        mmLeft = 0
        mmTop = 36248
        mmWidth = 197300
        BandType = 4
        mmBottomOffset = 0
        mmOverFlowOffset = 0
        mmStopPosition = 0
        object ppChildReport4: TppChildReport
          AutoStop = False
          DataPipeline = ComentarioEvaluado
          PrinterSetup.BinName = 'Default'
          PrinterSetup.DocumentName = 'Report'
          PrinterSetup.PaperName = 'A4'
          PrinterSetup.PrinterName = 'Default'
          PrinterSetup.mmMarginBottom = 6350
          PrinterSetup.mmMarginLeft = 6350
          PrinterSetup.mmMarginRight = 6350
          PrinterSetup.mmMarginTop = 6350
          PrinterSetup.mmPaperHeight = 297000
          PrinterSetup.mmPaperWidth = 210000
          PrinterSetup.PaperSize = 9
          Version = '10.02'
          mmColumnWidth = 0
          DataPipelineName = 'ComentarioEvaluado'
          object ppTitleBand4: TppTitleBand
            mmBottomOffset = 0
            mmHeight = 9260
            mmPrintPosition = 0
            object ppLabel17: TppLabel
              UserName = 'Label15'
              Border.BorderPositions = []
              Border.Color = clBlack
              Border.Style = psSolid
              Border.Visible = False
              Border.Weight = 1.000000000000000000
              Caption = 'COMENTARIOS EVALUADO'
              Font.Charset = DEFAULT_CHARSET
              Font.Color = -2147483640
              Font.Name = 'Verdana'
              Font.Size = 9
              Font.Style = [fsBold]
              Transparent = True
              mmHeight = 3852
              mmLeft = 1852
              mmTop = 3175
              mmWidth = 47202
              BandType = 1
            end
          end
          object ppDetailBand5: TppDetailBand
            PrintHeight = phDynamic
            mmBottomOffset = 0
            mmHeight = 9525
            mmPrintPosition = 0
            object ppRegion4: TppRegion
              UserName = 'Region1'
              KeepTogether = True
              Brush.Style = bsClear
              Caption = 'Region1'
              Pen.Style = psClear
              Stretch = True
              Transparent = True
              mmHeight = 9525
              mmLeft = 1058
              mmTop = 0
              mmWidth = 195527
              BandType = 4
              mmBottomOffset = 0
              mmOverFlowOffset = 0
              mmStopPosition = 0
              object ppDBMemo4: TppDBMemo
                UserName = 'DBCodigoProducto'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                CharWrap = False
                DataField = 'comentario'
                DataPipeline = ComentarioEvaluado
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clBlack
                Font.Name = 'Verdana'
                Font.Size = 8
                Font.Style = []
                Stretch = True
                Transparent = True
                DataPipelineName = 'ComentarioEvaluado'
                mmHeight = 4763
                mmLeft = 3175
                mmTop = 2646
                mmWidth = 189442
                BandType = 4
                mmBottomOffset = 0
                mmOverFlowOffset = 0
                mmStopPosition = 0
                mmLeading = 0
              end
              object ppLine5: TppLine
                UserName = 'Line16'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                ParentHeight = True
                Position = lpLeft
                Visible = False
                Weight = 0.750000000000000000
                mmHeight = 9525
                mmLeft = 194469
                mmTop = 0
                mmWidth = 13229
                BandType = 4
              end
              object ppLine6: TppLine
                UserName = 'Line17'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                ParentHeight = True
                Position = lpLeft
                Visible = False
                Weight = 0.750000000000000000
                mmHeight = 9525
                mmLeft = 1323
                mmTop = 0
                mmWidth = 13229
                BandType = 4
              end
            end
          end
          object ppFooterBand5: TppFooterBand
            mmBottomOffset = 0
            mmHeight = 0
            mmPrintPosition = 0
          end
          object ppSummaryBand4: TppSummaryBand
            PrintHeight = phDynamic
            mmBottomOffset = 0
            mmHeight = 0
            mmPrintPosition = 0
          end
          object ppGroup4: TppGroup
            BreakName = 'oid_eval_cab'
            DataPipeline = ComentarioEvaluado
            KeepTogether = True
            OutlineSettings.CreateNode = True
            UserName = 'Group1'
            mmNewColumnThreshold = 0
            mmNewPageThreshold = 0
            DataPipelineName = 'ComentarioEvaluado'
            object ppGroupHeaderBand4: TppGroupHeaderBand
              mmBottomOffset = 0
              mmHeight = 0
              mmPrintPosition = 0
            end
            object ppGroupFooterBand4: TppGroupFooterBand
              mmBottomOffset = 0
              mmHeight = 0
              mmPrintPosition = 0
            end
          end
        end
      end
      object ppSubReportEvaluadores: TppSubReport
        UserName = 'SubReportEvaluadores'
        ExpandAll = False
        KeepTogether = True
        NewPrintJob = False
        OutlineSettings.CreateNode = True
        ShiftRelativeTo = ppSubReportObsGenRRHH
        TraverseAllData = True
        DataPipelineName = 'Evaluadores'
        mmHeight = 10848
        mmLeft = 0
        mmTop = 60590
        mmWidth = 197300
        BandType = 4
        mmBottomOffset = 0
        mmOverFlowOffset = 0
        mmStopPosition = 0
        object ppChildReport5: TppChildReport
          AutoStop = False
          DataPipeline = Evaluadores
          PrinterSetup.BinName = 'Default'
          PrinterSetup.DocumentName = 'Report'
          PrinterSetup.PaperName = 'A4'
          PrinterSetup.PrinterName = 'Default'
          PrinterSetup.mmMarginBottom = 6350
          PrinterSetup.mmMarginLeft = 6350
          PrinterSetup.mmMarginRight = 6350
          PrinterSetup.mmMarginTop = 6350
          PrinterSetup.mmPaperHeight = 297000
          PrinterSetup.mmPaperWidth = 210000
          PrinterSetup.PaperSize = 9
          Version = '10.02'
          mmColumnWidth = 0
          DataPipelineName = 'Evaluadores'
          object ppTitleBand5: TppTitleBand
            mmBottomOffset = 0
            mmHeight = 7673
            mmPrintPosition = 0
            object ppLabel18: TppLabel
              UserName = 'Label15'
              Border.BorderPositions = []
              Border.Color = clBlack
              Border.Style = psSolid
              Border.Visible = False
              Border.Weight = 1.000000000000000000
              Caption = 'EVALUADORES'
              Font.Charset = DEFAULT_CHARSET
              Font.Color = -2147483640
              Font.Name = 'Verdana'
              Font.Size = 9
              Font.Style = [fsBold]
              Transparent = True
              mmHeight = 3852
              mmLeft = 1852
              mmTop = 3175
              mmWidth = 26331
              BandType = 1
            end
            object ppLabel19: TppLabel
              UserName = 'Label19'
              Border.BorderPositions = []
              Border.Color = clBlack
              Border.Style = psSolid
              Border.Visible = False
              Border.Weight = 1.000000000000000000
              Caption = 'FIRMADO'
              Font.Charset = DEFAULT_CHARSET
              Font.Color = -2147483640
              Font.Name = 'Verdana'
              Font.Size = 9
              Font.Style = [fsBold]
              Transparent = True
              mmHeight = 3852
              mmLeft = 87048
              mmTop = 3175
              mmWidth = 17103
              BandType = 1
            end
            object ppLabel20: TppLabel
              UserName = 'Label20'
              Border.BorderPositions = []
              Border.Color = clBlack
              Border.Style = psSolid
              Border.Visible = False
              Border.Weight = 1.000000000000000000
              Caption = 'FEC. FIRMA'
              Font.Charset = DEFAULT_CHARSET
              Font.Color = -2147483640
              Font.Name = 'Verdana'
              Font.Size = 9
              Font.Style = [fsBold]
              TextAlignment = taCentered
              Transparent = True
              mmHeight = 3852
              mmLeft = 106892
              mmTop = 3175
              mmWidth = 20532
              BandType = 1
            end
            object ppLabel21: TppLabel
              UserName = 'Label201'
              Border.BorderPositions = []
              Border.Color = clBlack
              Border.Style = psSolid
              Border.Visible = False
              Border.Weight = 1.000000000000000000
              Caption = 'PUESTO'
              Font.Charset = DEFAULT_CHARSET
              Font.Color = -2147483640
              Font.Name = 'Verdana'
              Font.Size = 9
              Font.Style = [fsBold]
              TextAlignment = taCentered
              Transparent = True
              mmHeight = 3852
              mmLeft = 130704
              mmTop = 3175
              mmWidth = 14182
              BandType = 1
            end
          end
          object ppDetailBand6: TppDetailBand
            PrintHeight = phDynamic
            mmBottomOffset = 0
            mmHeight = 9525
            mmPrintPosition = 0
            object ppRegion5: TppRegion
              UserName = 'Region1'
              KeepTogether = True
              Brush.Style = bsClear
              Caption = 'Region1'
              Pen.Style = psClear
              Stretch = True
              Transparent = True
              mmHeight = 9525
              mmLeft = 1058
              mmTop = 0
              mmWidth = 195527
              BandType = 4
              mmBottomOffset = 0
              mmOverFlowOffset = 0
              mmStopPosition = 0
              object ppDBMemo5: TppDBMemo
                UserName = 'DBCodigoProducto'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                CharWrap = False
                DataField = 'desc_legajo'
                DataPipeline = Evaluadores
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clBlack
                Font.Name = 'Verdana'
                Font.Size = 8
                Font.Style = []
                Stretch = True
                Transparent = True
                DataPipelineName = 'Evaluadores'
                mmHeight = 4763
                mmLeft = 3175
                mmTop = 2646
                mmWidth = 83873
                BandType = 4
                mmBottomOffset = 0
                mmOverFlowOffset = 0
                mmStopPosition = 0
                mmLeading = 0
              end
              object ppLine7: TppLine
                UserName = 'Line16'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                ParentHeight = True
                Position = lpLeft
                Visible = False
                Weight = 0.750000000000000000
                mmHeight = 9525
                mmLeft = 194469
                mmTop = 0
                mmWidth = 13229
                BandType = 4
              end
              object ppLine8: TppLine
                UserName = 'Line17'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                ParentHeight = True
                Position = lpLeft
                Visible = False
                Weight = 0.750000000000000000
                mmHeight = 9525
                mmLeft = 1323
                mmTop = 0
                mmWidth = 13229
                BandType = 4
              end
              object ppDBMemo6: TppDBMemo
                UserName = 'DBCodigoProducto2'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                CharWrap = False
                DataField = 'desc_firmado'
                DataPipeline = Evaluadores
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clBlack
                Font.Name = 'Verdana'
                Font.Size = 8
                Font.Style = []
                Stretch = True
                TextAlignment = taCentered
                Transparent = True
                DataPipelineName = 'Evaluadores'
                mmHeight = 4763
                mmLeft = 87577
                mmTop = 2646
                mmWidth = 15610
                BandType = 4
                mmBottomOffset = 0
                mmOverFlowOffset = 0
                mmStopPosition = 0
                mmLeading = 0
              end
              object ppDBMemo7: TppDBMemo
                UserName = 'DBMemo7'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                CharWrap = False
                DataField = 'fec_firmado'
                DataPipeline = Evaluadores
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clBlack
                Font.Name = 'Verdana'
                Font.Size = 8
                Font.Style = []
                Stretch = True
                TextAlignment = taCentered
                Transparent = True
                DataPipelineName = 'Evaluadores'
                mmHeight = 4763
                mmLeft = 103981
                mmTop = 2646
                mmWidth = 26458
                BandType = 4
                mmBottomOffset = 0
                mmOverFlowOffset = 0
                mmStopPosition = 0
                mmLeading = 0
              end
              object ppDBMemo8: TppDBMemo
                UserName = 'DBMemo8'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                CharWrap = False
                DataField = 'puesto'
                DataPipeline = Evaluadores
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clBlack
                Font.Name = 'Verdana'
                Font.Size = 8
                Font.Style = []
                Stretch = True
                Transparent = True
                DataPipelineName = 'Evaluadores'
                mmHeight = 4763
                mmLeft = 130969
                mmTop = 2646
                mmWidth = 62177
                BandType = 4
                mmBottomOffset = 0
                mmOverFlowOffset = 0
                mmStopPosition = 0
                mmLeading = 0
              end
            end
          end
          object ppFooterBand6: TppFooterBand
            mmBottomOffset = 0
            mmHeight = 0
            mmPrintPosition = 0
          end
          object ppSummaryBand5: TppSummaryBand
            PrintHeight = phDynamic
            mmBottomOffset = 0
            mmHeight = 0
            mmPrintPosition = 0
          end
          object ppGroup5: TppGroup
            BreakName = 'oid_eval_evaluador'
            DataPipeline = Evaluadores
            KeepTogether = True
            OutlineSettings.CreateNode = True
            UserName = 'Group1'
            mmNewColumnThreshold = 0
            mmNewPageThreshold = 0
            DataPipelineName = 'Evaluadores'
            object ppGroupHeaderBand5: TppGroupHeaderBand
              mmBottomOffset = 0
              mmHeight = 0
              mmPrintPosition = 0
            end
            object ppGroupFooterBand5: TppGroupFooterBand
              mmBottomOffset = 0
              mmHeight = 0
              mmPrintPosition = 0
            end
          end
        end
      end
      object ppSubReportObsGenRRHH: TppSubReport
        UserName = 'SubReportObsGenRRHH'
        ExpandAll = False
        KeepTogether = True
        NewPrintJob = False
        OutlineSettings.CreateNode = True
        ShiftRelativeTo = SubComenEvaluado
        TraverseAllData = True
        DataPipelineName = 'ppDBObsGenRRHH'
        mmHeight = 10848
        mmLeft = 0
        mmTop = 48419
        mmWidth = 197300
        BandType = 4
        mmBottomOffset = 0
        mmOverFlowOffset = 0
        mmStopPosition = 0
        object ppChildReport6: TppChildReport
          AutoStop = False
          DataPipeline = ppDBObsGenRRHH
          PrinterSetup.BinName = 'Default'
          PrinterSetup.DocumentName = 'Report'
          PrinterSetup.PaperName = 'A4'
          PrinterSetup.PrinterName = 'Default'
          PrinterSetup.mmMarginBottom = 6350
          PrinterSetup.mmMarginLeft = 6350
          PrinterSetup.mmMarginRight = 6350
          PrinterSetup.mmMarginTop = 6350
          PrinterSetup.mmPaperHeight = 297000
          PrinterSetup.mmPaperWidth = 210000
          PrinterSetup.PaperSize = 9
          Version = '10.02'
          mmColumnWidth = 0
          DataPipelineName = 'ppDBObsGenRRHH'
          object ppTitleBand6: TppTitleBand
            mmBottomOffset = 0
            mmHeight = 9260
            mmPrintPosition = 0
            object ppLabel22: TppLabel
              UserName = 'Label15'
              Border.BorderPositions = []
              Border.Color = clBlack
              Border.Style = psSolid
              Border.Visible = False
              Border.Weight = 1.000000000000000000
              Caption = 'OBSERVACIONES GENERALES RRHH'
              Font.Charset = DEFAULT_CHARSET
              Font.Color = -2147483640
              Font.Name = 'Verdana'
              Font.Size = 9
              Font.Style = [fsBold]
              Transparent = True
              mmHeight = 3852
              mmLeft = 1852
              mmTop = 3175
              mmWidth = 64262
              BandType = 1
            end
          end
          object ppDetailBand7: TppDetailBand
            PrintHeight = phDynamic
            mmBottomOffset = 0
            mmHeight = 9525
            mmPrintPosition = 0
            object ppRegion6: TppRegion
              UserName = 'Region1'
              KeepTogether = True
              Brush.Style = bsClear
              Caption = 'Region1'
              Pen.Style = psClear
              Stretch = True
              Transparent = True
              mmHeight = 9525
              mmLeft = 1058
              mmTop = 0
              mmWidth = 195527
              BandType = 4
              mmBottomOffset = 0
              mmOverFlowOffset = 0
              mmStopPosition = 0
              object ppDBMemo9: TppDBMemo
                UserName = 'DBCodigoProducto'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                CharWrap = False
                DataField = 'observacion'
                DataPipeline = ppDBObsGenRRHH
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clBlack
                Font.Name = 'Verdana'
                Font.Size = 8
                Font.Style = []
                Stretch = True
                Transparent = True
                DataPipelineName = 'ppDBObsGenRRHH'
                mmHeight = 4763
                mmLeft = 3175
                mmTop = 2646
                mmWidth = 189442
                BandType = 4
                mmBottomOffset = 0
                mmOverFlowOffset = 0
                mmStopPosition = 0
                mmLeading = 0
              end
              object ppLine9: TppLine
                UserName = 'Line16'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                ParentHeight = True
                Position = lpLeft
                Visible = False
                Weight = 0.750000000000000000
                mmHeight = 9525
                mmLeft = 194469
                mmTop = 0
                mmWidth = 13229
                BandType = 4
              end
              object ppLine10: TppLine
                UserName = 'Line17'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                ParentHeight = True
                Position = lpLeft
                Visible = False
                Weight = 0.750000000000000000
                mmHeight = 9525
                mmLeft = 1323
                mmTop = 0
                mmWidth = 13229
                BandType = 4
              end
            end
          end
          object ppFooterBand7: TppFooterBand
            mmBottomOffset = 0
            mmHeight = 0
            mmPrintPosition = 0
          end
          object ppSummaryBand6: TppSummaryBand
            PrintHeight = phDynamic
            mmBottomOffset = 0
            mmHeight = 0
            mmPrintPosition = 0
          end
          object ppGroup6: TppGroup
            BreakName = 'oid_obs_gen'
            DataPipeline = ppDBObsGenRRHH
            KeepTogether = True
            OutlineSettings.CreateNode = True
            UserName = 'Group1'
            mmNewColumnThreshold = 0
            mmNewPageThreshold = 0
            DataPipelineName = 'ppDBObsGenRRHH'
            object ppGroupHeaderBand6: TppGroupHeaderBand
              mmBottomOffset = 0
              mmHeight = 0
              mmPrintPosition = 0
            end
            object ppGroupFooterBand6: TppGroupFooterBand
              mmBottomOffset = 0
              mmHeight = 0
              mmPrintPosition = 0
            end
          end
        end
      end
      object ppSubReportFirmas: TppSubReport
        UserName = 'SubReportFirmas'
        ExpandAll = False
        KeepTogether = True
        NewPrintJob = False
        OutlineSettings.CreateNode = True
        ShiftRelativeTo = ppSubReportEvaluadores
        TraverseAllData = True
        DataPipelineName = 'ppDBFirmas'
        mmHeight = 10848
        mmLeft = 0
        mmTop = 73025
        mmWidth = 197300
        BandType = 4
        mmBottomOffset = 0
        mmOverFlowOffset = 0
        mmStopPosition = 0
        object ppChildReport7: TppChildReport
          AutoStop = False
          DataPipeline = ppDBFirmas
          PrinterSetup.BinName = 'Default'
          PrinterSetup.DocumentName = 'Report'
          PrinterSetup.PaperName = 'A4'
          PrinterSetup.PrinterName = 'Default'
          PrinterSetup.mmMarginBottom = 6350
          PrinterSetup.mmMarginLeft = 6350
          PrinterSetup.mmMarginRight = 6350
          PrinterSetup.mmMarginTop = 6350
          PrinterSetup.mmPaperHeight = 297000
          PrinterSetup.mmPaperWidth = 210000
          PrinterSetup.PaperSize = 9
          Version = '10.02'
          mmColumnWidth = 0
          DataPipelineName = 'ppDBFirmas'
          object ppTitleBand7: TppTitleBand
            mmBottomOffset = 0
            mmHeight = 7673
            mmPrintPosition = 0
            object ppLabel23: TppLabel
              UserName = 'Label15'
              Border.BorderPositions = []
              Border.Color = clBlack
              Border.Style = psSolid
              Border.Visible = False
              Border.Weight = 1.000000000000000000
              Caption = 'FIRMAS'
              Font.Charset = DEFAULT_CHARSET
              Font.Color = -2147483640
              Font.Name = 'Verdana'
              Font.Size = 9
              Font.Style = [fsBold]
              Transparent = True
              mmHeight = 3852
              mmLeft = 1852
              mmTop = 3175
              mmWidth = 14012
              BandType = 1
            end
            object ppLabel24: TppLabel
              UserName = 'Label19'
              Border.BorderPositions = []
              Border.Color = clBlack
              Border.Style = psSolid
              Border.Visible = False
              Border.Weight = 1.000000000000000000
              Caption = 'FIRMADO'
              Font.Charset = DEFAULT_CHARSET
              Font.Color = -2147483640
              Font.Name = 'Verdana'
              Font.Size = 9
              Font.Style = [fsBold]
              Transparent = True
              mmHeight = 3852
              mmLeft = 87048
              mmTop = 3175
              mmWidth = 17103
              BandType = 1
            end
            object ppLabel25: TppLabel
              UserName = 'Label20'
              Border.BorderPositions = []
              Border.Color = clBlack
              Border.Style = psSolid
              Border.Visible = False
              Border.Weight = 1.000000000000000000
              Caption = 'FEC. FIRMA'
              Font.Charset = DEFAULT_CHARSET
              Font.Color = -2147483640
              Font.Name = 'Verdana'
              Font.Size = 9
              Font.Style = [fsBold]
              TextAlignment = taCentered
              Transparent = True
              mmHeight = 3852
              mmLeft = 106892
              mmTop = 3175
              mmWidth = 20532
              BandType = 1
            end
            object ppLabel26: TppLabel
              UserName = 'Label201'
              Border.BorderPositions = []
              Border.Color = clBlack
              Border.Style = psSolid
              Border.Visible = False
              Border.Weight = 1.000000000000000000
              Caption = 'PUESTO'
              Font.Charset = DEFAULT_CHARSET
              Font.Color = -2147483640
              Font.Name = 'Verdana'
              Font.Size = 9
              Font.Style = [fsBold]
              TextAlignment = taCentered
              Transparent = True
              mmHeight = 3852
              mmLeft = 130704
              mmTop = 3175
              mmWidth = 14182
              BandType = 1
            end
          end
          object ppDetailBand8: TppDetailBand
            PrintHeight = phDynamic
            mmBottomOffset = 0
            mmHeight = 9525
            mmPrintPosition = 0
            object ppRegion7: TppRegion
              UserName = 'Region1'
              KeepTogether = True
              Brush.Style = bsClear
              Caption = 'Region1'
              Pen.Style = psClear
              Stretch = True
              Transparent = True
              mmHeight = 9525
              mmLeft = 1058
              mmTop = 0
              mmWidth = 195527
              BandType = 4
              mmBottomOffset = 0
              mmOverFlowOffset = 0
              mmStopPosition = 0
              object ppDBMemo10: TppDBMemo
                UserName = 'DBCodigoProducto'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                CharWrap = False
                DataField = 'desc_legajo_firma'
                DataPipeline = ppDBFirmas
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clBlack
                Font.Name = 'Verdana'
                Font.Size = 8
                Font.Style = []
                Stretch = True
                Transparent = True
                DataPipelineName = 'ppDBFirmas'
                mmHeight = 4763
                mmLeft = 3175
                mmTop = 2646
                mmWidth = 83873
                BandType = 4
                mmBottomOffset = 0
                mmOverFlowOffset = 0
                mmStopPosition = 0
                mmLeading = 0
              end
              object ppLine11: TppLine
                UserName = 'Line16'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                ParentHeight = True
                Position = lpLeft
                Visible = False
                Weight = 0.750000000000000000
                mmHeight = 9525
                mmLeft = 194469
                mmTop = 0
                mmWidth = 13229
                BandType = 4
              end
              object ppLine12: TppLine
                UserName = 'Line17'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                ParentHeight = True
                Position = lpLeft
                Visible = False
                Weight = 0.750000000000000000
                mmHeight = 9525
                mmLeft = 1323
                mmTop = 0
                mmWidth = 13229
                BandType = 4
              end
              object ppDBMemo11: TppDBMemo
                UserName = 'DBCodigoProducto2'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                CharWrap = False
                DataField = 'desc_firmado'
                DataPipeline = ppDBFirmas
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clBlack
                Font.Name = 'Verdana'
                Font.Size = 8
                Font.Style = []
                Stretch = True
                TextAlignment = taCentered
                Transparent = True
                DataPipelineName = 'ppDBFirmas'
                mmHeight = 4763
                mmLeft = 87577
                mmTop = 2646
                mmWidth = 15610
                BandType = 4
                mmBottomOffset = 0
                mmOverFlowOffset = 0
                mmStopPosition = 0
                mmLeading = 0
              end
              object ppDBMemo12: TppDBMemo
                UserName = 'DBMemo7'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                CharWrap = False
                DataField = 'fec_firma'
                DataPipeline = ppDBFirmas
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clBlack
                Font.Name = 'Verdana'
                Font.Size = 8
                Font.Style = []
                Stretch = True
                TextAlignment = taCentered
                Transparent = True
                DataPipelineName = 'ppDBFirmas'
                mmHeight = 4763
                mmLeft = 103981
                mmTop = 2646
                mmWidth = 26458
                BandType = 4
                mmBottomOffset = 0
                mmOverFlowOffset = 0
                mmStopPosition = 0
                mmLeading = 0
              end
              object ppDBMemo13: TppDBMemo
                UserName = 'DBMemo8'
                Border.BorderPositions = []
                Border.Color = clBlack
                Border.Style = psSolid
                Border.Visible = False
                Border.Weight = 1.000000000000000000
                CharWrap = False
                DataField = 'puesto'
                DataPipeline = ppDBFirmas
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clBlack
                Font.Name = 'Verdana'
                Font.Size = 8
                Font.Style = []
                Stretch = True
                Transparent = True
                DataPipelineName = 'ppDBFirmas'
                mmHeight = 4763
                mmLeft = 130969
                mmTop = 2646
                mmWidth = 62177
                BandType = 4
                mmBottomOffset = 0
                mmOverFlowOffset = 0
                mmStopPosition = 0
                mmLeading = 0
              end
            end
          end
          object ppFooterBand8: TppFooterBand
            mmBottomOffset = 0
            mmHeight = 0
            mmPrintPosition = 0
          end
          object ppSummaryBand7: TppSummaryBand
            PrintHeight = phDynamic
            mmBottomOffset = 0
            mmHeight = 0
            mmPrintPosition = 0
          end
          object ppGroup7: TppGroup
            BreakName = 'oid_firma_eval'
            DataPipeline = ppDBFirmas
            KeepTogether = True
            OutlineSettings.CreateNode = True
            UserName = 'Group1'
            mmNewColumnThreshold = 0
            mmNewPageThreshold = 0
            DataPipelineName = 'ppDBFirmas'
            object ppGroupHeaderBand7: TppGroupHeaderBand
              mmBottomOffset = 0
              mmHeight = 0
              mmPrintPosition = 0
            end
            object ppGroupFooterBand7: TppGroupFooterBand
              mmBottomOffset = 0
              mmHeight = 0
              mmPrintPosition = 0
            end
          end
        end
      end
    end
    object ppFooterBand1: TppFooterBand
      mmBottomOffset = 0
      mmHeight = 0
      mmPrintPosition = 0
    end
    object ppParameterList1: TppParameterList
    end
  end
  inherited Impresor: TComponenteImpresor
    Logo = 'ImagenLogo'
    FieldPathLogo = TEvaluacionCABpath_logo
    Top = 248
  end
  object Varios: TsnVarios [35]
    Operacion = Operacion
    Left = 256
    Top = 121
  end
  object TLabels: TsnTable [36]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 200
    Top = 259
    object TLabelsetiqueta: TStringField
      FieldName = 'etiqueta'
      Size = 100
    end
    object TLabelsdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 8000
    end
  end
  object DSLabels: TDataSource [37]
    DataSet = TLabels
    Left = 232
    Top = 259
  end
  inherited OpenDialog: TOpenDialog
    Top = 240
  end
  inherited Designer: TppDesigner
    Left = 120
    Top = 246
  end
  object TTipoImpresion: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 352
    Top = 90
    object TTipoImpresioncodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTipoImpresiondescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTipoImpresion: TDataSource
    DataSet = TTipoImpresion
    Left = 384
    Top = 90
  end
  object TTipoImpDefFact: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 496
    Top = 194
    object TTipoImpDefFacttipo_impresion: TStringField
      FieldName = 'tipo_impresion'
      Size = 100
    end
  end
  object TEvaluacionCAB: TsnTable
    Active = True
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_eval_cab'
        DataType = ftInteger
      end
      item
        Name = 'version_eval'
        DataType = ftInteger
      end
      item
        Name = 'oid_mod_eval_cab'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'cod_legajo'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'ape_nom_legajo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'fec_eval'
        DataType = ftDate
      end
      item
        Name = 'fec_puntuacion'
        DataType = ftDate
      end
      item
        Name = 'oid_usu_carga'
        DataType = ftInteger
      end
      item
        Name = 'fec_alta_carga'
        DataType = ftDate
      end
      item
        Name = 'oid_usu_modif'
        DataType = ftInteger
      end
      item
        Name = 'fec_ult_modif'
        DataType = ftDate
      end
      item
        Name = 'puntaje'
        DataType = ftCurrency
      end
      item
        Name = 'firmado'
        DataType = ftBoolean
      end
      item
        Name = 'fec_firmado'
        DataType = ftDate
      end
      item
        Name = 'comen_del_evaluado'
        DataType = ftMemo
        Size = 4000
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'oid_empresa'
        DataType = ftInteger
      end
      item
        Name = 'cod_empresa'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_empresa'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_sector'
        DataType = ftInteger
      end
      item
        Name = 'cod_sector'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'desc_sector'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_puesto'
        DataType = ftInteger
      end
      item
        Name = 'cod_puesto'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'desc_puesto'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_cond_mod_eval'
        DataType = ftInteger
      end
      item
        Name = 'oid_estado'
        DataType = ftInteger
      end
      item
        Name = 'cod_estado'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_estado'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'vigente'
        DataType = ftString
        Size = 2
      end
      item
        Name = 'modelo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'path_logo'
        DataType = ftString
        Size = 500
      end
      item
        Name = 'oid'
        DataType = ftInteger
      end>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 80
    Top = 65531
    object TEvaluacionCABoid_eval_cab: TIntegerField
      FieldName = 'oid_eval_cab'
    end
    object TEvaluacionCABversion_eval: TIntegerField
      FieldName = 'version_eval'
    end
    object TEvaluacionCABoid_mod_eval_cab: TIntegerField
      FieldName = 'oid_mod_eval_cab'
    end
    object TEvaluacionCABoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TEvaluacionCABcod_legajo: TStringField
      FieldName = 'cod_legajo'
    end
    object TEvaluacionCABape_nom_legajo: TStringField
      FieldName = 'ape_nom_legajo'
      Size = 100
    end
    object TEvaluacionCABfec_eval: TDateField
      FieldName = 'fec_eval'
    end
    object TEvaluacionCABfec_puntuacion: TDateField
      FieldName = 'fec_puntuacion'
    end
    object TEvaluacionCABoid_usu_carga: TIntegerField
      FieldName = 'oid_usu_carga'
    end
    object TEvaluacionCABfec_alta_carga: TDateField
      FieldName = 'fec_alta_carga'
    end
    object TEvaluacionCABoid_usu_modif: TIntegerField
      FieldName = 'oid_usu_modif'
    end
    object TEvaluacionCABfec_ult_modif: TDateField
      FieldName = 'fec_ult_modif'
    end
    object TEvaluacionCABpuntaje: TCurrencyField
      FieldName = 'puntaje'
      DisplayFormat = '###,###,###.##'
    end
    object TEvaluacionCABfirmado: TBooleanField
      FieldName = 'firmado'
    end
    object TEvaluacionCABfec_firmado: TDateField
      FieldName = 'fec_firmado'
    end
    object TEvaluacionCABcomen_del_evaluado: TMemoField
      FieldName = 'comen_del_evaluado'
      BlobType = ftMemo
      Size = 4000
    end
    object TEvaluacionCABactivo: TBooleanField
      FieldName = 'activo'
    end
    object TEvaluacionCABoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TEvaluacionCABcod_empresa: TStringField
      FieldName = 'cod_empresa'
      Size = 50
    end
    object TEvaluacionCABdesc_empresa: TStringField
      FieldName = 'desc_empresa'
      Size = 100
    end
    object TEvaluacionCABoid_sector: TIntegerField
      FieldName = 'oid_sector'
    end
    object TEvaluacionCABcod_sector: TStringField
      FieldName = 'cod_sector'
    end
    object TEvaluacionCABdesc_sector: TStringField
      FieldName = 'desc_sector'
      Size = 100
    end
    object TEvaluacionCABoid_puesto: TIntegerField
      FieldName = 'oid_puesto'
    end
    object TEvaluacionCABcod_puesto: TStringField
      FieldName = 'cod_puesto'
    end
    object TEvaluacionCABdesc_puesto: TStringField
      FieldName = 'desc_puesto'
      Size = 100
    end
    object TEvaluacionCABoid_cond_mod_eval: TIntegerField
      FieldName = 'oid_cond_mod_eval'
    end
    object TEvaluacionCABoid_estado: TIntegerField
      FieldName = 'oid_estado'
    end
    object TEvaluacionCABcod_estado: TStringField
      FieldName = 'cod_estado'
      Size = 50
    end
    object TEvaluacionCABdesc_estado: TStringField
      FieldName = 'desc_estado'
      Size = 100
    end
    object TEvaluacionCABvigente: TStringField
      FieldName = 'vigente'
      Size = 2
    end
    object TEvaluacionCABmodelo: TStringField
      FieldName = 'modelo'
      Size = 100
    end
    object TEvaluacionCABpath_logo: TStringField
      FieldName = 'path_logo'
      Size = 500
    end
    object TEvaluacionCABoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
  end
  object dsEVALUCIONCAB: TDataSource
    DataSet = TEvaluacionCAB
    Left = 112
    Top = 65531
  end
  object EvaluacionesCab: TppDBPipeline
    DataSource = dsEVALUCIONCAB
    UserName = 'EvaluacionesCab1'
    Left = 144
    Top = 65528
    object EvaluacionesCabppField1: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_eval_cab'
      FieldName = 'oid_eval_cab'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 0
      Position = 0
    end
    object EvaluacionesCabppField2: TppField
      Alignment = taRightJustify
      FieldAlias = 'version_eval'
      FieldName = 'version_eval'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 1
    end
    object EvaluacionesCabppField3: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_mod_eval_cab'
      FieldName = 'oid_mod_eval_cab'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 2
    end
    object EvaluacionesCabppField4: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_legajo'
      FieldName = 'oid_legajo'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 3
    end
    object EvaluacionesCabppField5: TppField
      FieldAlias = 'cod_legajo'
      FieldName = 'cod_legajo'
      FieldLength = 20
      DisplayWidth = 20
      Position = 4
    end
    object EvaluacionesCabppField6: TppField
      FieldAlias = 'ape_nom_legajo'
      FieldName = 'ape_nom_legajo'
      FieldLength = 100
      DisplayWidth = 100
      Position = 5
    end
    object EvaluacionesCabppField7: TppField
      FieldAlias = 'fec_eval'
      FieldName = 'fec_eval'
      FieldLength = 0
      DataType = dtDate
      DisplayWidth = 10
      Position = 6
    end
    object EvaluacionesCabppField8: TppField
      FieldAlias = 'fec_puntuacion'
      FieldName = 'fec_puntuacion'
      FieldLength = 0
      DataType = dtDate
      DisplayWidth = 10
      Position = 7
    end
    object EvaluacionesCabppField9: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_usu_carga'
      FieldName = 'oid_usu_carga'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 8
    end
    object EvaluacionesCabppField10: TppField
      FieldAlias = 'fec_alta_carga'
      FieldName = 'fec_alta_carga'
      FieldLength = 0
      DataType = dtDate
      DisplayWidth = 10
      Position = 9
    end
    object EvaluacionesCabppField11: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_usu_modif'
      FieldName = 'oid_usu_modif'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 10
    end
    object EvaluacionesCabppField12: TppField
      FieldAlias = 'fec_ult_modif'
      FieldName = 'fec_ult_modif'
      FieldLength = 0
      DataType = dtDate
      DisplayWidth = 10
      Position = 11
    end
    object EvaluacionesCabppField13: TppField
      FieldAlias = 'puntaje'
      FieldName = 'puntaje'
      FieldLength = 0
      DataType = dtCurrency
      DisplayWidth = 10
      Position = 12
    end
    object EvaluacionesCabppField14: TppField
      FieldAlias = 'firmado'
      FieldName = 'firmado'
      FieldLength = 0
      DataType = dtBoolean
      DisplayWidth = 5
      Position = 13
    end
    object EvaluacionesCabppField15: TppField
      FieldAlias = 'fec_firmado'
      FieldName = 'fec_firmado'
      FieldLength = 0
      DataType = dtDate
      DisplayWidth = 10
      Position = 14
    end
    object EvaluacionesCabppField16: TppField
      FieldAlias = 'comen_del_evaluado'
      FieldName = 'comen_del_evaluado'
      FieldLength = 4000
      DataType = dtMemo
      DisplayWidth = 10
      Position = 15
      Searchable = False
      Sortable = False
    end
    object EvaluacionesCabppField17: TppField
      FieldAlias = 'activo'
      FieldName = 'activo'
      FieldLength = 0
      DataType = dtBoolean
      DisplayWidth = 5
      Position = 16
    end
    object EvaluacionesCabppField18: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_empresa'
      FieldName = 'oid_empresa'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 17
    end
    object EvaluacionesCabppField19: TppField
      FieldAlias = 'cod_empresa'
      FieldName = 'cod_empresa'
      FieldLength = 50
      DisplayWidth = 50
      Position = 18
    end
    object EvaluacionesCabppField20: TppField
      FieldAlias = 'desc_empresa'
      FieldName = 'desc_empresa'
      FieldLength = 100
      DisplayWidth = 100
      Position = 19
    end
    object EvaluacionesCabppField21: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_sector'
      FieldName = 'oid_sector'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 20
    end
    object EvaluacionesCabppField22: TppField
      FieldAlias = 'cod_sector'
      FieldName = 'cod_sector'
      FieldLength = 20
      DisplayWidth = 20
      Position = 21
    end
    object EvaluacionesCabppField23: TppField
      FieldAlias = 'desc_sector'
      FieldName = 'desc_sector'
      FieldLength = 100
      DisplayWidth = 100
      Position = 22
    end
    object EvaluacionesCabppField24: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_puesto'
      FieldName = 'oid_puesto'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 23
    end
    object EvaluacionesCabppField25: TppField
      FieldAlias = 'cod_puesto'
      FieldName = 'cod_puesto'
      FieldLength = 20
      DisplayWidth = 20
      Position = 24
    end
    object EvaluacionesCabppField26: TppField
      FieldAlias = 'desc_puesto'
      FieldName = 'desc_puesto'
      FieldLength = 100
      DisplayWidth = 100
      Position = 25
    end
    object EvaluacionesCabppField27: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_cond_mod_eval'
      FieldName = 'oid_cond_mod_eval'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 26
    end
    object EvaluacionesCabppField28: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_estado'
      FieldName = 'oid_estado'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 27
    end
    object EvaluacionesCabppField29: TppField
      FieldAlias = 'cod_estado'
      FieldName = 'cod_estado'
      FieldLength = 50
      DisplayWidth = 50
      Position = 28
    end
    object EvaluacionesCabppField30: TppField
      FieldAlias = 'desc_estado'
      FieldName = 'desc_estado'
      FieldLength = 100
      DisplayWidth = 100
      Position = 29
    end
    object EvaluacionesCabppField31: TppField
      FieldAlias = 'vigente'
      FieldName = 'vigente'
      FieldLength = 2
      DisplayWidth = 2
      Position = 30
    end
    object EvaluacionesCabppField32: TppField
      FieldAlias = 'modelo'
      FieldName = 'modelo'
      FieldLength = 100
      DisplayWidth = 100
      Position = 31
    end
    object EvaluacionesCabppField33: TppField
      FieldAlias = 'path_logo'
      FieldName = 'path_logo'
      FieldLength = 500
      DisplayWidth = 500
      Position = 32
    end
    object EvaluacionesCabppField34: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid'
      FieldName = 'oid'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 33
    end
  end
  object TCompetenciasEval: TsnTable
    Active = True
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_compe_eval'
        DataType = ftInteger
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'oid_eval_cab'
        DataType = ftInteger
      end
      item
        Name = 'oid_competencia'
        DataType = ftInteger
      end
      item
        Name = 'desc_competencia'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'nro_grado'
        DataType = ftInteger
      end
      item
        Name = 'porc_cump'
        DataType = ftCurrency
      end
      item
        Name = 'descripcion'
        DataType = ftMemo
      end>
    IndexFieldNames = 'oid_eval_cab'
    IndexName = 'TCompetenciasEvalIndex1'
    IndexDefs = <
      item
        Name = 'TCompetenciasEvalIndex1'
        Fields = 'oid_eval_cab;orden'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_eval_cab'
    MasterSource = dsEVALUCIONCAB
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 80
    Top = 37
    object TCompetenciasEvaloid_compe_eval: TIntegerField
      FieldName = 'oid_compe_eval'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCompetenciasEvalorden: TIntegerField
      FieldName = 'orden'
    end
    object TCompetenciasEvaloid_eval_cab: TIntegerField
      FieldName = 'oid_eval_cab'
    end
    object TCompetenciasEvaloid_competencia: TIntegerField
      FieldName = 'oid_competencia'
    end
    object TCompetenciasEvaldesc_competencia: TStringField
      FieldName = 'desc_competencia'
      Size = 255
    end
    object TCompetenciasEvalnro_grado: TIntegerField
      FieldName = 'nro_grado'
      DisplayFormat = '#####'
    end
    object TCompetenciasEvalporc_cump: TCurrencyField
      FieldName = 'porc_cump'
      DisplayFormat = '###,###.##'
    end
    object TCompetenciasEvaldescripcion: TMemoField
      FieldName = 'descripcion'
      BlobType = ftMemo
    end
  end
  object DSTCompetenciasEval: TDataSource
    DataSet = TCompetenciasEval
    Left = 113
    Top = 39
  end
  object Competencias: TppDBPipeline
    DataSource = DSTCompetenciasEval
    UserName = 'Competencias'
    Left = 144
    Top = 41
    MasterDataPipelineName = 'EvaluacionesCab'
    object CompetenciasppField1: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_compe_eval'
      FieldName = 'oid_compe_eval'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 0
      Position = 0
    end
    object CompetenciasppField2: TppField
      Alignment = taRightJustify
      FieldAlias = 'orden'
      FieldName = 'orden'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 1
    end
    object CompetenciasppField3: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_eval_cab'
      FieldName = 'oid_eval_cab'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 2
    end
    object CompetenciasppField4: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_competencia'
      FieldName = 'oid_competencia'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 3
    end
    object CompetenciasppField5: TppField
      FieldAlias = 'desc_competencia'
      FieldName = 'desc_competencia'
      FieldLength = 255
      DisplayWidth = 255
      Position = 4
    end
    object CompetenciasppField6: TppField
      Alignment = taRightJustify
      FieldAlias = 'nro_grado'
      FieldName = 'nro_grado'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 5
    end
    object CompetenciasppField7: TppField
      FieldAlias = 'porc_cump'
      FieldName = 'porc_cump'
      FieldLength = 0
      DataType = dtCurrency
      DisplayWidth = 10
      Position = 6
    end
    object CompetenciasppField8: TppField
      FieldAlias = 'descripcion'
      FieldName = 'descripcion'
      FieldLength = 0
      DataType = dtMemo
      DisplayWidth = 10
      Position = 7
      Searchable = False
      Sortable = False
    end
    object CompetenciasppMasterFieldLink1: TppMasterFieldLink
      MasterFieldName = 'oid_eval_cab'
      GuidCollationType = gcString
      DetailFieldName = 'oid_eval_cab'
      DetailSortOrder = soAscending
    end
  end
  object TLeyendasReporte: TsnTable
    Active = True
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'titulo_1'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'titulo_2'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'titulo_3'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_clasif_empresa'
        DataType = ftInteger
      end
      item
        Name = 'oid_clasif_sector'
        DataType = ftInteger
      end
      item
        Name = 'oid_clasif_puesto'
        DataType = ftInteger
      end
      item
        Name = 'nro_clasif_empresa'
        DataType = ftInteger
      end
      item
        Name = 'nro_clasif_sector'
        DataType = ftInteger
      end
      item
        Name = 'nro_clasif_puesto'
        DataType = ftInteger
      end
      item
        Name = 'oid_cond_modelo'
        DataType = ftInteger
      end
      item
        Name = 'oid_clasif_estado'
        DataType = ftInteger
      end
      item
        Name = 'nro_clasif_estado'
        DataType = ftInteger
      end>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 200
    Top = 291
    object TLeyendasReportetitulo_1: TStringField
      FieldName = 'titulo_1'
      Size = 100
    end
    object TLeyendasReportetitulo_2: TStringField
      FieldName = 'titulo_2'
      Size = 100
    end
    object TLeyendasReportetitulo_3: TStringField
      FieldName = 'titulo_3'
      Size = 100
    end
    object TLeyendasReporteoid_clasif_empresa: TIntegerField
      FieldName = 'oid_clasif_empresa'
    end
    object TLeyendasReporteoid_clasif_sector: TIntegerField
      FieldName = 'oid_clasif_sector'
    end
    object TLeyendasReporteoid_clasif_puesto: TIntegerField
      FieldName = 'oid_clasif_puesto'
    end
    object TLeyendasReportenro_clasif_empresa: TIntegerField
      FieldName = 'nro_clasif_empresa'
    end
    object TLeyendasReportenro_clasif_sector: TIntegerField
      FieldName = 'nro_clasif_sector'
    end
    object TLeyendasReportenro_clasif_puesto: TIntegerField
      FieldName = 'nro_clasif_puesto'
    end
    object TLeyendasReporteoid_cond_modelo: TIntegerField
      FieldName = 'oid_cond_modelo'
    end
    object TLeyendasReporteoid_clasif_estado: TIntegerField
      FieldName = 'oid_clasif_estado'
    end
    object TLeyendasReportenro_clasif_estado: TIntegerField
      FieldName = 'nro_clasif_estado'
    end
  end
  object DSTLeyendasReporte: TDataSource
    DataSet = TLeyendasReporte
    Left = 232
    Top = 291
  end
  object LeyendasReportes: TppDBPipeline
    DataSource = DSTLeyendasReporte
    UserName = 'Competencias1'
    Left = 264
    Top = 289
    object LeyendasReportesppField1: TppField
      FieldAlias = 'titulo_1'
      FieldName = 'titulo_1'
      FieldLength = 0
      DisplayWidth = 0
      Position = 0
    end
    object LeyendasReportesppField2: TppField
      FieldAlias = 'titulo_2'
      FieldName = 'titulo_2'
      FieldLength = 100
      DisplayWidth = 100
      Position = 1
    end
    object LeyendasReportesppField3: TppField
      FieldAlias = 'titulo_3'
      FieldName = 'titulo_3'
      FieldLength = 100
      DisplayWidth = 100
      Position = 2
    end
    object LeyendasReportesppField4: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_clasif_empresa'
      FieldName = 'oid_clasif_empresa'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 3
    end
    object LeyendasReportesppField5: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_clasif_sector'
      FieldName = 'oid_clasif_sector'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 4
    end
    object LeyendasReportesppField6: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_clasif_puesto'
      FieldName = 'oid_clasif_puesto'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 5
    end
    object LeyendasReportesppField7: TppField
      Alignment = taRightJustify
      FieldAlias = 'nro_clasif_empresa'
      FieldName = 'nro_clasif_empresa'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 6
    end
    object LeyendasReportesppField8: TppField
      Alignment = taRightJustify
      FieldAlias = 'nro_clasif_sector'
      FieldName = 'nro_clasif_sector'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 7
    end
    object LeyendasReportesppField9: TppField
      Alignment = taRightJustify
      FieldAlias = 'nro_clasif_puesto'
      FieldName = 'nro_clasif_puesto'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 8
    end
    object LeyendasReportesppField10: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_cond_modelo'
      FieldName = 'oid_cond_modelo'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 9
    end
    object LeyendasReportesppField11: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_clasif_estado'
      FieldName = 'oid_clasif_estado'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 10
    end
    object LeyendasReportesppField12: TppField
      Alignment = taRightJustify
      FieldAlias = 'nro_clasif_estado'
      FieldName = 'nro_clasif_estado'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 11
    end
    object ppMasterFieldLink1: TppMasterFieldLink
      MasterFieldName = 'oid_eval_cab'
      GuidCollationType = gcString
      DetailFieldName = 'oid_eval_cab'
      DetailSortOrder = soAscending
    end
  end
  object TAspectosDestacados: TsnTable
    Active = True
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'OID_EVAL_ASP'
        DataType = ftInteger
      end
      item
        Name = 'OID_EVAL_CAB'
        DataType = ftInteger
      end
      item
        Name = 'TIPO_ASPECTO'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'ACTIVO'
        DataType = ftBoolean
      end
      item
        Name = 'ORDEN'
        DataType = ftInteger
      end
      item
        Name = 'ASPECTO'
        DataType = ftMemo
      end>
    IndexFieldNames = 'OID_EVAL_CAB;ORDEN'
    IndexName = 'TAspectosDestacadosIndex1'
    IndexDefs = <
      item
        Name = 'TAspectosDestacadosIndex1'
        Fields = 'OID_EVAL_CAB;ORDEN'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_eval_cab'
    MasterSource = dsEVALUCIONCAB
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 80
    Top = 79
    object TAspectosDestacadosOID_EVAL_ASP: TIntegerField
      FieldName = 'OID_EVAL_ASP'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAspectosDestacadosOID_EVAL_CAB: TIntegerField
      FieldName = 'OID_EVAL_CAB'
    end
    object TAspectosDestacadosTIPO_ASPECTO: TStringField
      FieldName = 'TIPO_ASPECTO'
      Size = 10
    end
    object TAspectosDestacadosACTIVO: TBooleanField
      FieldName = 'ACTIVO'
    end
    object TAspectosDestacadosORDEN: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'ORDEN'
    end
    object TAspectosDestacadosASPECTO: TMemoField
      FieldName = 'ASPECTO'
      BlobType = ftMemo
    end
  end
  object DSAspectosDestacados: TDataSource
    DataSet = TAspectosDestacados
    Left = 112
    Top = 79
  end
  object AspectosDestacados: TppDBPipeline
    DataSource = DSAspectosDestacados
    UserName = 'AspectosDestacados'
    Left = 144
    Top = 80
    MasterDataPipelineName = 'EvaluacionesCab'
    object AspectosDestacadosppField1: TppField
      Alignment = taRightJustify
      FieldAlias = 'OID_EVAL_ASP'
      FieldName = 'OID_EVAL_ASP'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 0
      Position = 0
    end
    object AspectosDestacadosppField2: TppField
      Alignment = taRightJustify
      FieldAlias = 'OID_EVAL_CAB'
      FieldName = 'OID_EVAL_CAB'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 1
    end
    object AspectosDestacadosppField3: TppField
      FieldAlias = 'TIPO_ASPECTO'
      FieldName = 'TIPO_ASPECTO'
      FieldLength = 10
      DisplayWidth = 10
      Position = 2
    end
    object AspectosDestacadosppField4: TppField
      FieldAlias = 'ACTIVO'
      FieldName = 'ACTIVO'
      FieldLength = 0
      DataType = dtBoolean
      DisplayWidth = 5
      Position = 3
    end
    object AspectosDestacadosppField5: TppField
      Alignment = taRightJustify
      FieldAlias = 'ORDEN'
      FieldName = 'ORDEN'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 4
    end
    object AspectosDestacadosppField6: TppField
      FieldAlias = 'ASPECTO'
      FieldName = 'ASPECTO'
      FieldLength = 0
      DataType = dtMemo
      DisplayWidth = 10
      Position = 5
      Searchable = False
      Sortable = False
    end
    object ppMasterFieldLink2: TppMasterFieldLink
      MasterFieldName = 'oid_eval_cab'
      GuidCollationType = gcString
      DetailFieldName = 'oid_eval_cab'
      DetailSortOrder = soAscending
    end
  end
  object TAspectosAMejorar: TsnTable
    Active = True
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'OID_EVAL_ASP'
        DataType = ftInteger
      end
      item
        Name = 'OID_EVAL_CAB'
        DataType = ftInteger
      end
      item
        Name = 'TIPO_ASPECTO'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'ACTIVO'
        DataType = ftBoolean
      end
      item
        Name = 'ASPECTO'
        DataType = ftMemo
      end
      item
        Name = 'ORDEN'
        DataType = ftInteger
      end>
    IndexFieldNames = 'OID_EVAL_CAB;ORDEN'
    IndexName = 'TAspectosAMejorarIndex1'
    IndexDefs = <
      item
        Name = 'TAspectosAMejorarIndex1'
        Fields = 'OID_EVAL_CAB;ORDEN'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_eval_cab'
    MasterSource = dsEVALUCIONCAB
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 80
    Top = 115
    object TAspectosAMejorarOID_EVAL_ASP: TIntegerField
      FieldName = 'OID_EVAL_ASP'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAspectosAMejorarOID_EVAL_CAB: TIntegerField
      FieldName = 'OID_EVAL_CAB'
    end
    object TAspectosAMejorarTIPO_ASPECTO: TStringField
      FieldName = 'TIPO_ASPECTO'
      Size = 10
    end
    object TAspectosAMejorarACTIVO: TBooleanField
      FieldName = 'ACTIVO'
    end
    object TAspectosAMejorarASPECTO: TMemoField
      FieldName = 'ASPECTO'
      BlobType = ftMemo
    end
    object TAspectosAMejorarORDEN: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'ORDEN'
    end
  end
  object DSAspectosAMejorar: TDataSource
    DataSet = TAspectosAMejorar
    Left = 112
    Top = 115
  end
  object AspectosAMejorar: TppDBPipeline
    DataSource = DSAspectosAMejorar
    UserName = 'AspectosAMejorar'
    Left = 144
    Top = 118
    MasterDataPipelineName = 'EvaluacionesCab'
    object AspectosAMejorarppField1: TppField
      Alignment = taRightJustify
      FieldAlias = 'OID_EVAL_ASP'
      FieldName = 'OID_EVAL_ASP'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 0
      Position = 0
    end
    object AspectosAMejorarppField2: TppField
      Alignment = taRightJustify
      FieldAlias = 'OID_EVAL_CAB'
      FieldName = 'OID_EVAL_CAB'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 1
    end
    object AspectosAMejorarppField3: TppField
      FieldAlias = 'TIPO_ASPECTO'
      FieldName = 'TIPO_ASPECTO'
      FieldLength = 10
      DisplayWidth = 10
      Position = 2
    end
    object AspectosAMejorarppField4: TppField
      FieldAlias = 'ACTIVO'
      FieldName = 'ACTIVO'
      FieldLength = 0
      DataType = dtBoolean
      DisplayWidth = 5
      Position = 3
    end
    object AspectosAMejorarppField5: TppField
      FieldAlias = 'ASPECTO'
      FieldName = 'ASPECTO'
      FieldLength = 0
      DataType = dtMemo
      DisplayWidth = 10
      Position = 4
      Searchable = False
      Sortable = False
    end
    object AspectosAMejorarppField6: TppField
      Alignment = taRightJustify
      FieldAlias = 'ORDEN'
      FieldName = 'ORDEN'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 5
    end
  end
  object TComentarioEvaluado: TsnTable
    Active = True
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'comentario'
        DataType = ftMemo
      end
      item
        Name = 'oid_eval_cab'
        DataType = ftInteger
      end>
    IndexFieldNames = 'OID_EVAL_CAB'
    IndexName = 'TAspectosAMejorarIndex1'
    IndexDefs = <
      item
        Name = 'TAspectosAMejorarIndex1'
        Fields = 'OID_EVAL_CAB'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_eval_cab'
    MasterSource = dsEVALUCIONCAB
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 80
    Top = 148
    object TComentarioEvaluadocomentario: TMemoField
      FieldName = 'comentario'
      BlobType = ftMemo
    end
    object TComentarioEvaluadooid_eval_cab: TIntegerField
      FieldName = 'oid_eval_cab'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
  end
  object DSComentarioEvaluado: TDataSource
    DataSet = TComentarioEvaluado
    Left = 112
    Top = 146
  end
  object ComentarioEvaluado: TppDBPipeline
    DataSource = DSComentarioEvaluado
    UserName = 'ComentarioEvaluado'
    Left = 144
    Top = 148
    MasterDataPipelineName = 'EvaluacionesCab'
    object ComentarioEvaluadoppField1: TppField
      FieldAlias = 'comentario'
      FieldName = 'comentario'
      FieldLength = 0
      DataType = dtMemo
      DisplayWidth = 10
      Position = 0
      Searchable = False
      Sortable = False
    end
    object ComentarioEvaluadoppField2: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_eval_cab'
      FieldName = 'oid_eval_cab'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 1
    end
    object ppMasterFieldLink4: TppMasterFieldLink
      MasterFieldName = 'oid_eval_cab'
      GuidCollationType = gcString
      DetailFieldName = 'oid_eval_cab'
      DetailSortOrder = soAscending
    end
  end
  object TEvaluadores: TsnTable
    Active = True
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_eval_evaluador'
        DataType = ftInteger
      end
      item
        Name = 'oid_eval_cab'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'cod_legajo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_legajo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'firmado'
        DataType = ftBoolean
      end
      item
        Name = 'fec_firmado'
        DataType = ftDate
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'puesto'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'desc_firmado'
        DataType = ftString
        Size = 2
      end>
    IndexFieldNames = 'oid_eval_cab'
    IndexName = 'TEvaluadoresIndex1'
    IndexDefs = <
      item
        Name = 'TEvaluadoresIndex1'
        Fields = 'oid_eval_cab'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_eval_cab'
    MasterSource = dsEVALUCIONCAB
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 80
    Top = 184
    object TEvaluadoresoid_eval_evaluador: TIntegerField
      FieldName = 'oid_eval_evaluador'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TEvaluadoresoid_eval_cab: TIntegerField
      FieldName = 'oid_eval_cab'
    end
    object TEvaluadoresoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TEvaluadorescod_legajo: TStringField
      FieldName = 'cod_legajo'
      Size = 50
    end
    object TEvaluadoresdesc_legajo: TStringField
      FieldName = 'desc_legajo'
      Size = 100
    end
    object TEvaluadoresfirmado: TBooleanField
      FieldName = 'firmado'
    end
    object TEvaluadoresfec_firmado: TDateField
      FieldName = 'fec_firmado'
    end
    object TEvaluadoresactivo: TBooleanField
      FieldName = 'activo'
    end
    object TEvaluadorespuesto: TStringField
      FieldName = 'puesto'
      Size = 100
    end
    object TEvaluadoresdesc_firmado: TStringField
      FieldName = 'desc_firmado'
      Size = 2
    end
  end
  object DSEvaluadores: TDataSource
    DataSet = TEvaluadores
    Left = 112
    Top = 184
  end
  object Evaluadores: TppDBPipeline
    DataSource = DSEvaluadores
    UserName = 'Evaluadores'
    Left = 144
    Top = 185
    object EvaluadoresppField1: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_eval_evaluador'
      FieldName = 'oid_eval_evaluador'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 0
      Position = 0
    end
    object EvaluadoresppField2: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_eval_cab'
      FieldName = 'oid_eval_cab'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 1
    end
    object EvaluadoresppField3: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_legajo'
      FieldName = 'oid_legajo'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 2
    end
    object EvaluadoresppField4: TppField
      FieldAlias = 'cod_legajo'
      FieldName = 'cod_legajo'
      FieldLength = 50
      DisplayWidth = 50
      Position = 3
    end
    object EvaluadoresppField5: TppField
      FieldAlias = 'desc_legajo'
      FieldName = 'desc_legajo'
      FieldLength = 100
      DisplayWidth = 100
      Position = 4
    end
    object EvaluadoresppField6: TppField
      FieldAlias = 'firmado'
      FieldName = 'firmado'
      FieldLength = 0
      DataType = dtBoolean
      DisplayWidth = 5
      Position = 5
    end
    object EvaluadoresppField7: TppField
      FieldAlias = 'fec_firmado'
      FieldName = 'fec_firmado'
      FieldLength = 0
      DataType = dtDate
      DisplayWidth = 10
      Position = 6
    end
    object EvaluadoresppField8: TppField
      FieldAlias = 'activo'
      FieldName = 'activo'
      FieldLength = 0
      DataType = dtBoolean
      DisplayWidth = 5
      Position = 7
    end
    object EvaluadoresppField9: TppField
      FieldAlias = 'puesto'
      FieldName = 'puesto'
      FieldLength = 100
      DisplayWidth = 100
      Position = 8
    end
    object EvaluadoresppField10: TppField
      FieldAlias = 'desc_firmado'
      FieldName = 'desc_firmado'
      FieldLength = 2
      DisplayWidth = 2
      Position = 9
    end
    object ppMasterFieldLink5: TppMasterFieldLink
      MasterFieldName = 'oid_eval_cab'
      GuidCollationType = gcString
      DetailFieldName = 'oid_eval_cab'
      DetailSortOrder = soAscending
    end
  end
  object TObsGenRRHH: TsnTable
    Active = True
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_obs_gen'
        DataType = ftInteger
      end
      item
        Name = 'oid_eval_cab'
        DataType = ftInteger
      end
      item
        Name = 'observacion'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_eval_cab;orden'
    IndexName = 'TObsGenRRHHIndex1'
    IndexDefs = <
      item
        Name = 'TObsGenRRHHIndex1'
        Fields = 'oid_eval_cab;orden'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_eval_cab'
    MasterSource = dsEVALUCIONCAB
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 80
    Top = 217
    object TObsGenRRHHoid_obs_gen: TIntegerField
      FieldName = 'oid_obs_gen'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TObsGenRRHHoid_eval_cab: TIntegerField
      FieldName = 'oid_eval_cab'
    end
    object TObsGenRRHHobservacion: TStringField
      FieldName = 'observacion'
      Size = 4000
    end
    object TObsGenRRHHactivo: TBooleanField
      FieldName = 'activo'
    end
    object TObsGenRRHHorden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
  end
  object dsTObsGenRRHH: TDataSource
    DataSet = TObsGenRRHH
    Left = 112
    Top = 217
  end
  object ppDBObsGenRRHH: TppDBPipeline
    DataSource = dsTObsGenRRHH
    UserName = 'ObsGenRRHH'
    Left = 144
    Top = 219
    MasterDataPipelineName = 'EvaluacionesCab'
    object ppDBPipeline1ppField1: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_obs_gen'
      FieldName = 'oid_obs_gen'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 0
      Position = 0
    end
    object ppDBPipeline1ppField2: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_eval_cab'
      FieldName = 'oid_eval_cab'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 1
    end
    object ppDBPipeline1ppField3: TppField
      FieldAlias = 'observacion'
      FieldName = 'observacion'
      FieldLength = 4000
      DisplayWidth = 4000
      Position = 2
    end
    object ppDBPipeline1ppField4: TppField
      FieldAlias = 'activo'
      FieldName = 'activo'
      FieldLength = 0
      DataType = dtBoolean
      DisplayWidth = 5
      Position = 3
    end
    object ppDBPipeline1ppField5: TppField
      Alignment = taRightJustify
      FieldAlias = 'orden'
      FieldName = 'orden'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 4
    end
    object ppMasterFieldLink6: TppMasterFieldLink
      MasterFieldName = 'oid_eval_cab'
      GuidCollationType = gcString
      DetailFieldName = 'oid_eval_cab'
      DetailSortOrder = soAscending
    end
  end
  object TFirmas: TsnTable
    Active = True
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_firma_eval'
        DataType = ftInteger
      end
      item
        Name = 'oid_eval_cab'
        DataType = ftInteger
      end
      item
        Name = 'nro_firma'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo_firma'
        DataType = ftInteger
      end
      item
        Name = 'cod_legajo_firma'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_legajo_firma'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'firmo'
        DataType = ftBoolean
      end
      item
        Name = 'fec_firma'
        DataType = ftDate
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'puesto'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'desc_firmado'
        DataType = ftString
        Size = 2
      end>
    IndexFieldNames = 'oid_eval_cab'
    IndexName = 'TFirmasIndex1'
    IndexDefs = <
      item
        Name = 'TFirmasIndex1'
        Fields = 'oid_eval_cab'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_eval_cab'
    MasterSource = dsEVALUCIONCAB
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 80
    Top = 252
    object TFirmasoid_firma_eval: TIntegerField
      FieldName = 'oid_firma_eval'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TFirmasoid_eval_cab: TIntegerField
      FieldName = 'oid_eval_cab'
    end
    object TFirmasnro_firma: TIntegerField
      FieldName = 'nro_firma'
    end
    object TFirmasoid_legajo_firma: TIntegerField
      FieldName = 'oid_legajo_firma'
    end
    object TFirmascod_legajo_firma: TStringField
      FieldName = 'cod_legajo_firma'
      Size = 50
    end
    object TFirmasdesc_legajo_firma: TStringField
      FieldName = 'desc_legajo_firma'
      Size = 100
    end
    object TFirmasfirmo: TBooleanField
      FieldName = 'firmo'
    end
    object TFirmasfec_firma: TDateField
      FieldName = 'fec_firma'
    end
    object TFirmasactivo: TBooleanField
      FieldName = 'activo'
    end
    object TFirmaspuesto: TStringField
      FieldName = 'puesto'
      Size = 100
    end
    object TFirmasdesc_firmado: TStringField
      FieldName = 'desc_firmado'
      Size = 2
    end
  end
  object DSFirmas: TDataSource
    DataSet = TFirmas
    Left = 112
    Top = 256
  end
  object ppDBFirmas: TppDBPipeline
    DataSource = DSFirmas
    UserName = 'Firmas'
    Left = 144
    Top = 254
    MasterDataPipelineName = 'EvaluacionesCab'
    object ppDBFirmasppField1: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_firma_eval'
      FieldName = 'oid_firma_eval'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 0
      Position = 0
    end
    object ppDBFirmasppField2: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_eval_cab'
      FieldName = 'oid_eval_cab'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 1
    end
    object ppDBFirmasppField3: TppField
      Alignment = taRightJustify
      FieldAlias = 'nro_firma'
      FieldName = 'nro_firma'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 2
    end
    object ppDBFirmasppField4: TppField
      Alignment = taRightJustify
      FieldAlias = 'oid_legajo_firma'
      FieldName = 'oid_legajo_firma'
      FieldLength = 0
      DataType = dtInteger
      DisplayWidth = 10
      Position = 3
    end
    object ppDBFirmasppField5: TppField
      FieldAlias = 'cod_legajo_firma'
      FieldName = 'cod_legajo_firma'
      FieldLength = 50
      DisplayWidth = 50
      Position = 4
    end
    object ppDBFirmasppField6: TppField
      FieldAlias = 'desc_legajo_firma'
      FieldName = 'desc_legajo_firma'
      FieldLength = 100
      DisplayWidth = 100
      Position = 5
    end
    object ppDBFirmasppField7: TppField
      FieldAlias = 'firmo'
      FieldName = 'firmo'
      FieldLength = 0
      DataType = dtBoolean
      DisplayWidth = 5
      Position = 6
    end
    object ppDBFirmasppField8: TppField
      FieldAlias = 'fec_firma'
      FieldName = 'fec_firma'
      FieldLength = 0
      DataType = dtDate
      DisplayWidth = 10
      Position = 7
    end
    object ppDBFirmasppField9: TppField
      FieldAlias = 'activo'
      FieldName = 'activo'
      FieldLength = 0
      DataType = dtBoolean
      DisplayWidth = 5
      Position = 8
    end
    object ppDBFirmasppField10: TppField
      FieldAlias = 'puesto'
      FieldName = 'puesto'
      FieldLength = 100
      DisplayWidth = 100
      Position = 9
    end
    object ppDBFirmasppField11: TppField
      FieldAlias = 'desc_firmado'
      FieldName = 'desc_firmado'
      FieldLength = 2
      DisplayWidth = 2
      Position = 10
    end
    object ppMasterFieldLink7: TppMasterFieldLink
      MasterFieldName = 'oid_eval_cab'
      GuidCollationType = gcString
      DetailFieldName = 'oid_eval_cab'
      DetailSortOrder = soAscending
    end
  end
end
