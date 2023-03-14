inherited FFormaExtincion: TFFormaExtincion
  Left = 124
  Top = 156
  Caption = 'Forma Extinci'#243'n'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSFormaExtincion
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSFormaExtincion
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpForma
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpForma
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpForma
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSFormaExtincion
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
    inherited PCuerpo: TPanel
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
        Left = 124
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSFormaExtincion
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 173
      end
      object DBEDescripcion: TsnDBEdit
        Left = 124
        Top = 44
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSFormaExtincion
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 253
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerFormaExtincion'
    OperGrabarObjeto = 'SaveFormaExtincion'
    CargaDataSets = <
      item
        DataSet = TFormaExtincion
        TableName = 'TFormaExtincion'
      end>
    BajaLogica = <
      item
        DataSet = TFormaExtincion
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TFormaExtincion
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TFormaExtincion: TsnTable [3]
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
    object TFormaExtincionoid_forma_extincion: TIntegerField
      FieldName = 'oid_forma_extincion'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TFormaExtincioncodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TFormaExtinciondescripcion: TStringField
      DisplayWidth = 50
      FieldName = 'descripcion'
      Size = 50
    end
    object TFormaExtincionactivo: TBooleanField
      DefaultExpression = 'true'
      FieldName = 'activo'
    end
  end
  object DSFormaExtincion: TDataSource [4]
    DataSet = TFormaExtincion
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
        TableName = 'TFormaExtincion'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorForma.Value := Sender.AsString;'
          '  ValidadorForma.Validar;'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TFormaExtincion'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object HelpForma: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.FormaExtincion'
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
    Titulo = 'Forma Extinci'#243'n'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorForma: TValidador
    Operacion = Operacion
    NickNameObjLog = 'leg.FormaExtincion'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Forma duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
end
