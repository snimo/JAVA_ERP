inherited FRecluFuente: TFRecluFuente
  Left = 244
  Width = 770
  Caption = 'Fuentes de Reclutamiento'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 754
    inherited PPie: TPanel
      Width = 754
      inherited StatusBarABM: TStatusBar
        Left = 649
      end
      inherited StatusBar2: TStatusBar
        Width = 649
      end
    end
    inherited PMenu: TPanel
      Width = 754
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRecluFuente
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRecluFuente
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpFuente
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpFuente
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpFuente
      end
      inherited Panel2: TPanel
        Left = 713
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTRecluFuente
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
      Width = 754
    end
    inherited PCabecera: TPanel
      Width = 754
    end
    inherited PCuerpo: TPanel
      Width = 754
      object Label1: TLabel
        Left = 40
        Top = 8
        Width = 33
        Height = 13
        Caption = 'Codigo'
      end
      object Label2: TLabel
        Left = 40
        Top = 48
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object DBECodigo: TsnDBEdit
        Left = 124
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTRecluFuente
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object DBEDescripcion: TsnDBEdit
        Left = 124
        Top = 44
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTRecluFuente
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 273
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerRecluFuente'
    OperGrabarObjeto = 'SaveRecluFuente'
    CargaDataSets = <
      item
        DataSet = TRecluFuente
        TableName = 'TRecluFuente'
      end>
    BajaLogica = <
      item
        DataSet = TRecluFuente
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TRecluFuente
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 24
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TRecluFuente: TsnTable [3]
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
    Left = 640
    Top = 59
    object TRecluFuenteoid_fuente: TIntegerField
      FieldName = 'oid_fuente'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRecluFuentecodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TRecluFuentedescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TRecluFuenteactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTRecluFuente: TDataSource [4]
    DataSet = TRecluFuente
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
        TableName = 'TRecluFuente'
        FieldName = 'codigo'
        Source.Strings = (
          'program validar;'
          'begin'
          '  ValidadorFuente.Value := Sender.AsString;'
          '  ValidadorFuente.Validar();'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TRecluFuente'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end>
    Left = 320
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 280
    Top = 68
  end
  object HelpFuente: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluFuente'
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
    Titulo = 'Fuentes'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 202
    Top = 68
  end
  object ValidadorFuente: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluFuente'
    WhenRaiseException = teFound
    MensajeException = 'Codigo de Fuente Existente'
    NroQuery = 0
    Cache = False
    Left = 240
    Top = 67
  end
end
