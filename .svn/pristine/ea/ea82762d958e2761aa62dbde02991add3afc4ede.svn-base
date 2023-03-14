inherited FRecluEstadoProceso: TFRecluEstadoProceso
  Left = 193
  Top = 69
  Width = 770
  Caption = 'Estados de Procesos'
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
        DataSource = DSTRecluEstadoProceso
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRecluEstadoProceso
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpEstadoProceso
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpEstadoProceso
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpEstadoProceso
      end
      inherited Panel2: TPanel
        Left = 713
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTRecluEstadoProceso
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
      Height = 165
      object Label1: TLabel
        Left = 40
        Top = 24
        Width = 33
        Height = 13
        Caption = 'Codigo'
      end
      object Label2: TLabel
        Left = 40
        Top = 64
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object DBECodigo: TsnDBEdit
        Left = 124
        Top = 20
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTRecluEstadoProceso
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object DBEDescripcion: TsnDBEdit
        Left = 124
        Top = 60
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTRecluEstadoProceso
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 273
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 123
        Top = 97
        Caption = 'Iniciar el o los siguientes procesos'
        DataBinding.DataField = 'iniciar_prox_proc'
        DataBinding.DataSource = DSTRecluEstadoProceso
        TabOrder = 2
        Width = 198
      end
      object snDBCheckEdit2: TsnDBCheckEdit
        Left = 123
        Top = 129
        Caption = 'Debe cargar la fecha de Planificaci'#243'n'
        DataBinding.DataField = 'fec_planif_oblig'
        DataBinding.DataSource = DSTRecluEstadoProceso
        TabOrder = 3
        Width = 238
      end
    end
    inherited PCuerpo: TPanel
      Top = 217
      Width = 754
      Height = 229
      BorderWidth = 10
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerRecluEstadoProceso'
    OperGrabarObjeto = 'SaveRecluEstadoProceso'
    CargaDataSets = <
      item
        DataSet = TRecluEstadoProceso
        TableName = 'TRecluEstadoProceso'
      end>
    BajaLogica = <
      item
        DataSet = TRecluEstadoProceso
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TRecluEstadoProceso
    Left = 512
    Top = 24
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TRecluEstadoProceso: TsnTable [3]
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
    Left = 632
    Top = 59
    object TRecluEstadoProcesooid_est_proc_sel: TIntegerField
      FieldName = 'oid_est_proc_sel'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRecluEstadoProcesocodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TRecluEstadoProcesodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TRecluEstadoProcesoiniciar_prox_proc: TBooleanField
      FieldName = 'iniciar_prox_proc'
    end
    object TRecluEstadoProcesofec_planif_oblig: TBooleanField
      FieldName = 'fec_planif_oblig'
    end
    object TRecluEstadoProcesoactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTRecluEstadoProceso: TDataSource [4]
    DataSet = TRecluEstadoProceso
    Left = 664
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
        TableName = 'TRecluEstadoProceso'
        FieldName = 'codigo'
        Source.Strings = (
          'program validar;'
          'begin'
          '  ValidadorEstadoProceso.Value := Sender.AsString;'
          '  ValidadorEstadoProceso.Validar();'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TRecluEstadoProceso'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end>
    Left = 320
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 296
    Top = 224
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 280
    Top = 68
  end
  inherited ImageListItemsPopUp: TImageList
    Top = 195
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 632
    Top = 107
  end
  object HelpEstadoProceso: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluEstadoProceso'
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
    Titulo = 'Estado de Procesos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 202
    Top = 68
  end
  object ValidadorEstadoProceso: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluEstadoProceso'
    WhenRaiseException = teFound
    MensajeException = 'Codigo de Proceso Existente'
    NroQuery = 0
    Cache = False
    Left = 240
    Top = 67
  end
end
