inherited FTipoDocumentacionCIP: TFTipoDocumentacionCIP
  Left = 133
  Top = 206
  Width = 730
  Height = 396
  Caption = 'Tipo de Documentaci'#243'n para Ingreso'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 722
    Height = 362
    inherited PPie: TPanel
      Top = 341
      Width = 722
      inherited StatusBarABM: TStatusBar
        Left = 617
      end
      inherited StatusBar2: TStatusBar
        Width = 617
      end
    end
    inherited PMenu: TPanel
      Width = 722
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTTipoDocumentacionCIP
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTTipoDocumentacionCIP
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpTipoDocumentacion
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpTipoDocumentacion
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpTipoDocumentacion
      end
      inherited Panel2: TPanel
        Left = 681
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTTipoDocumentacionCIP
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
      Width = 722
    end
    inherited PCabecera: TPanel
      Width = 722
    end
    inherited PCuerpo: TPanel
      Width = 722
      Height = 266
      object Label1: TLabel
        Left = 40
        Top = 8
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 40
        Top = 48
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object DBECodigo: TsnDBEdit
        Left = 156
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTTipoDocumentacionCIP
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBEdit1: TsnDBEdit
        Left = 156
        Top = 44
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTTipoDocumentacionCIP
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerTipoDocumentacionCIP'
    OperGrabarObjeto = 'SaveTipoDocumentacionCIP'
    CargaDataSets = <
      item
        DataSet = TTipoDocumentacionCIP
        TableName = 'TTipoDocumentacionCIP'
      end>
    BajaLogica = <
      item
        DataSet = TTipoDocumentacionCIP
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TTipoDocumentacionCIP
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TTipoDocumentacionCIP: TsnTable [3]
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
    object TTipoDocumentacionCIPoid_tipo_docu: TIntegerField
      FieldName = 'oid_tipo_docu'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TTipoDocumentacionCIPcodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TTipoDocumentacionCIPdescripcion: TStringField
      DisplayWidth = 50
      FieldName = 'descripcion'
      Size = 50
    end
    object TTipoDocumentacionCIPactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTTipoDocumentacionCIP: TDataSource [4]
    DataSet = TTipoDocumentacionCIP
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
        TableName = 'TTipoDocumentacionCIP'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorTipoDocumentacion.Value := Sender.AsString;'
          '  ValidadorTipoDocumentacion.Validar;'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object HelpTipoDocumentacion: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.TipoDocumentacionCIP'
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
    Titulo = 'Tipo de Documentaci'#243'n'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorTipoDocumentacion: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.TipoDocumentacionCIP'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Tipo de Documentaci'#243'n duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
end
