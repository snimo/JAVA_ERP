inherited FEmpresasCIP: TFEmpresasCIP
  Left = 54
  Top = 43
  Caption = 'Empresas del Sistema de Control de Ingresos'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTEmpresaCIP
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTEmpresaCIP
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpEmpresasCIP
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpEmpresasCIP
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpEmpresasCIP
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTEmpresaCIP
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
      object Label2: TLabel
        Left = 48
        Top = 8
        Width = 63
        Height = 13
        Caption = 'Raz'#243'n Social'
      end
      object snDBEdit1: TsnDBEdit
        Left = 144
        Top = 4
        DataBinding.DataField = 'razon_social'
        DataBinding.DataSource = DSTEmpresaCIP
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 497
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerEmpresaCIP'
    OperGrabarObjeto = 'SaveEmpresaCIP'
    CargaDataSets = <
      item
        DataSet = TEmpresaCIP
        TableName = 'TEmpresaCIP'
      end>
    BajaLogica = <
      item
        DataSet = TEmpresaCIP
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TEmpresaCIP
    ControlFocoAlta = snDBEdit1
    ControlFocoModif = snDBEdit1
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TEmpresaCIP: TsnTable [3]
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
    object TEmpresaCIPoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TEmpresaCIPrazon_social: TStringField
      FieldName = 'razon_social'
      Size = 100
    end
    object TEmpresaCIPactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTEmpresaCIP: TDataSource [4]
    DataSet = TEmpresaCIP
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
        TableName = 'TEmpresaCIP'
        FieldName = 'razon_social'
        Source.Strings = (
          'begin'
          '  ValidadorRazonSocial.Value := Sender.AsString;'
          '  ValidadorRazonSocial.Validar;'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object HelpEmpresasCIP: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.EmpresaCIP'
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
    Titulo = 'Empresas del C.I.P.'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorRazonSocial: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.EmpresaCIP'
    WhenRaiseException = teFound
    MensajeException = 'Raz'#243'n Social duplicada'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
end
