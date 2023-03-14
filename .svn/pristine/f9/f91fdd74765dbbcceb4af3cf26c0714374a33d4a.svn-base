inherited FPuertaMaqVis: TFPuertaMaqVis
  Left = 133
  Top = 206
  Width = 730
  Height = 396
  Caption = 'Asignaci'#243'n por Defecto de puertas para Visitas por M'#225'quina'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 714
    Height = 358
    inherited PPie: TPanel
      Top = 337
      Width = 714
      inherited StatusBarABM: TStatusBar
        Left = 609
      end
      inherited StatusBar2: TStatusBar
        Width = 609
      end
    end
    inherited PMenu: TPanel
      Width = 714
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTMaqPuertasVisita
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTMaqPuertasVisita
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpMaquinas
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpMaquinas
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpMaquinas
      end
      inherited Panel2: TPanel
        Left = 673
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTMaqPuertasVisita
        Leyendas = <
          item
            Titulo = 'Inactivo'
            ColorTitulo = clWhite
            ValorEstado = 'false'
            Visible = True
            ColorPanel = clRed
          end>
      end
    end
    inherited POpcionesMenu: TPanel
      Width = 714
    end
    inherited PCabecera: TPanel
      Width = 714
    end
    inherited PCuerpo: TPanel
      Width = 714
      Height = 262
      object Label2: TLabel
        Left = 40
        Top = 8
        Width = 41
        Height = 13
        Caption = 'M'#225'quina'
      end
      object Label4: TLabel
        Left = 71
        Top = 88
        Width = 71
        Height = 13
        Caption = 'Puerta Entrada'
      end
      object Label5: TLabel
        Left = 71
        Top = 128
        Width = 63
        Height = 13
        Caption = 'Puerta Salida'
      end
      object snLabel1: TsnLabel
        Left = 40
        Top = 48
        Width = 340
        Height = 13
        Caption = 
          'Puertas a utilizar al realizar movimientos de Ingresos / Egresos' +
          ' de Visitas'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlue
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentFont = False
      end
      object snLabel2: TsnLabel
        Left = 40
        Top = 160
        Width = 208
        Height = 13
        Caption = 'Grupo de Puertas a utilizar al asignar Tarjeta'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlue
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentFont = False
      end
      object Label1: TLabel
        Left = 71
        Top = 200
        Width = 83
        Height = 13
        Caption = 'Grupo de Puertas'
      end
      object snDBEdit1: TsnDBEdit
        Left = 156
        Top = 4
        DataBinding.DataField = 'maquina'
        DataBinding.DataSource = DSTMaqPuertasVisita
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 429
      end
      object DBCodCliente: TsrnDBButtonEdit
        Left = 189
        Top = 84
        Hint = 'F4 Nuevo Cliente'
        DataBinding.DataField = 'cod_puerta_ent'
        DataBinding.DataSource = DSTMaqPuertasVisita
        Properties.Buttons = <
          item
            Default = True
            Kind = bkEllipsis
          end>
        Properties.CharCase = ecUpperCase
        Properties.ClickKey = 112
        TabOrder = 1
        Help = HelpPuertaEntrada
        Width = 121
      end
      object snDBEdit3: TsnDBEdit
        Left = 307
        Top = 84
        TabStop = False
        DataBinding.DataField = 'desc_puerta_ent'
        DataBinding.DataSource = DSTMaqPuertasVisita
        Properties.ReadOnly = True
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 2
        ReadOnlyAlways = True
        Width = 310
      end
      object srnDBButtonEdit1: TsrnDBButtonEdit
        Left = 189
        Top = 124
        Hint = 'F4 Nuevo Cliente'
        DataBinding.DataField = 'cod_puerta_sal'
        DataBinding.DataSource = DSTMaqPuertasVisita
        Properties.Buttons = <
          item
            Default = True
            Kind = bkEllipsis
          end>
        Properties.CharCase = ecUpperCase
        Properties.ClickKey = 112
        TabOrder = 3
        Help = HelpPuertaSalida
        Width = 121
      end
      object snDBEdit4: TsnDBEdit
        Left = 307
        Top = 124
        TabStop = False
        DataBinding.DataField = 'desc_puerta_sal'
        DataBinding.DataSource = DSTMaqPuertasVisita
        Properties.ReadOnly = True
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 4
        ReadOnlyAlways = True
        Width = 310
      end
      object srnDBButtonEdit2: TsrnDBButtonEdit
        Left = 189
        Top = 196
        Hint = 'F4 Nuevo Cliente'
        DataBinding.DataField = 'cod_grupo_puerta'
        DataBinding.DataSource = DSTMaqPuertasVisita
        Properties.Buttons = <
          item
            Default = True
            Kind = bkEllipsis
          end>
        Properties.CharCase = ecUpperCase
        Properties.ClickKey = 112
        TabOrder = 5
        Help = HelpGrupoPuertas
        Width = 121
      end
      object snDBEdit2: TsnDBEdit
        Left = 307
        Top = 196
        TabStop = False
        DataBinding.DataField = 'desc_grupo_puerta'
        DataBinding.DataSource = DSTMaqPuertasVisita
        Properties.ReadOnly = True
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 6
        ReadOnlyAlways = True
        Width = 310
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerMaqPuertasVisita'
    OperGrabarObjeto = 'SaveMaqPuertasVisita'
    CargaDataSets = <
      item
        DataSet = TMaqPuertasVisita
        TableName = 'TMaqPuertasVisita'
      end>
    BajaLogica = <
      item
        DataSet = TMaqPuertasVisita
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TMaqPuertasVisita
    ControlFocoAlta = snDBEdit1
    ControlFocoModif = snDBEdit1
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TMaqPuertasVisita: TsnTable [3]
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
    Left = 648
    Top = 59
    object TMaqPuertasVisitaoid_maq_pue_vis: TIntegerField
      FieldName = 'oid_maq_pue_vis'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TMaqPuertasVisitamaquina: TStringField
      FieldName = 'maquina'
      Size = 50
    end
    object TMaqPuertasVisitacodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TMaqPuertasVisitadescripcion: TStringField
      DisplayWidth = 50
      FieldName = 'descripcion'
      Size = 50
    end
    object TMaqPuertasVisitaoid_grupo_categ: TIntegerField
      FieldName = 'oid_grupo_categ'
    end
    object TMaqPuertasVisitacod_grupo_categ: TStringField
      FieldName = 'cod_grupo_categ'
    end
    object TMaqPuertasVisitadesc_grupo_categ: TStringField
      FieldName = 'desc_grupo_categ'
      Size = 100
    end
    object TMaqPuertasVisitaoid_puerta_ent: TIntegerField
      FieldName = 'oid_puerta_ent'
    end
    object TMaqPuertasVisitacod_puerta_ent: TStringField
      FieldName = 'cod_puerta_ent'
      Size = 50
    end
    object TMaqPuertasVisitadesc_puerta_ent: TStringField
      FieldName = 'desc_puerta_ent'
      Size = 100
    end
    object TMaqPuertasVisitaoid_puerta_sal: TIntegerField
      FieldName = 'oid_puerta_sal'
    end
    object TMaqPuertasVisitacod_puerta_sal: TStringField
      FieldName = 'cod_puerta_sal'
      Size = 50
    end
    object TMaqPuertasVisitadesc_puerta_sal: TStringField
      FieldName = 'desc_puerta_sal'
      Size = 100
    end
    object TMaqPuertasVisitaactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TMaqPuertasVisitaoid_grupo_puerta: TIntegerField
      FieldName = 'oid_grupo_puerta'
    end
    object TMaqPuertasVisitacod_grupo_puerta: TStringField
      FieldName = 'cod_grupo_puerta'
      Size = 50
    end
    object TMaqPuertasVisitadesc_grupo_puerta: TStringField
      FieldName = 'desc_grupo_puerta'
      Size = 100
    end
  end
  object DSTMaqPuertasVisita: TDataSource [4]
    DataSet = TMaqPuertasVisita
    Left = 680
    Top = 59
  end
  inherited TOidObjSave: TsnTable
    Left = 608
  end
  inherited TOpcHabPrograma: TsnTable
    Top = 16
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
    OnValidate = <
      item
        TableName = 'TMaqPuertasVisita'
        FieldName = 'maquina'
        Source.Strings = (
          'begin'
          '  ValidadorMaquina.Value := Sender.AsString;'
          '  ValidadorMaquina.Validar;'
          'end.')
      end
      item
        TableName = 'TMaqPuertasVisita'
        FieldName = 'cod_puerta_ent'
        Source.Strings = (
          'begin'
          '  ValidadorPuertaEntrada.Value := Sender.AsString;'
          '  ValidadorPuertaEntrada.Validar();'
          'end.')
      end
      item
        TableName = 'TMaqPuertasVisita'
        FieldName = 'cod_puerta_sal'
        Source.Strings = (
          'begin'
          '  ValidadorPuertaSalida.Value := Sender.AsString;'
          '  ValidadorPuertaSalida.Validar();'
          'end.')
      end
      item
        TableName = 'TMaqPuertasVisita'
        FieldName = 'cod_grupo_puerta'
        Source.Strings = (
          'begin'
          '  ValidadorGrupoPuerta.Value := Sender.AsString;'
          '  ValidadorGrupoPuerta.Validar();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object HelpMaquinas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.MaqPuertasVisita'
    NroHelp = 0
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        KeyField = True
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Descripci'#243'n'
        FieldName = 'descripcion'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = False
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Activo'
        FieldName = 'activo'
        Tipo = ftBoolean
        Longitud = 0
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 8
        ActivarFiltro = True
      end>
    Titulo = 'M'#225'quinas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorMaquina: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.MaqPuertasVisita'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de M'#225'quina duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
  object HelpPuertaEntrada: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.Puerta'
    NroHelp = 0
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        KeyField = True
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Descripci'#243'n'
        FieldName = 'descripcion'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = True
        AsignarACampo = TMaqPuertasVisitacod_puerta_ent
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Activo'
        FieldName = 'activo'
        Tipo = ftBoolean
        Longitud = 0
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 8
        ActivarFiltro = True
      end>
    Titulo = 'Puertas Entrada'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 458
    Top = 159
  end
  object ValidadorPuertaEntrada: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.Puerta'
    MensajeException = 'C'#243'digo de Puerta Inexistente'
    CampoOID = TMaqPuertasVisitaoid_puerta_ent
    CampoDescripcion = TMaqPuertasVisitadesc_puerta_ent
    NroQuery = 0
    Cache = True
    Left = 494
    Top = 159
  end
  object HelpPuertaSalida: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.Puerta'
    NroHelp = 0
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        KeyField = True
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Descripci'#243'n'
        FieldName = 'descripcion'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = True
        AsignarACampo = TMaqPuertasVisitacod_puerta_sal
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Activo'
        FieldName = 'activo'
        Tipo = ftBoolean
        Longitud = 0
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 8
        ActivarFiltro = True
      end>
    Titulo = 'Grupos de Categor'#237'as'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 458
    Top = 205
  end
  object ValidadorPuertaSalida: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.Puerta'
    MensajeException = 'C'#243'digo de Puerta Inexistente'
    CampoOID = TMaqPuertasVisitaoid_puerta_sal
    CampoDescripcion = TMaqPuertasVisitadesc_puerta_sal
    NroQuery = 0
    Cache = True
    Left = 494
    Top = 205
  end
  object HelpGrupoPuertas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    NroHelp = 0
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        KeyField = True
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Descripci'#243'n'
        FieldName = 'descripcion'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = True
        AsignarACampo = TMaqPuertasVisitacod_grupo_puerta
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Activo'
        FieldName = 'activo'
        Tipo = ftBoolean
        Longitud = 0
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 8
        ActivarFiltro = True
      end>
    Titulo = 'Grupo de Puertas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 232
  end
  object ValidadorGrupoPuerta: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Grupo de Puertas Inexistente'
    CampoOID = TMaqPuertasVisitaoid_grupo_puerta
    CampoDescripcion = TMaqPuertasVisitadesc_grupo_puerta
    NroQuery = 0
    Cache = True
    Left = 86
    Top = 232
  end
end
