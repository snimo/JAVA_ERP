inherited FCaracterExcluido: TFCaracterExcluido
  Left = 108
  Top = 175
  Width = 730
  Height = 396
  Caption = 'Caracter'
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
        DataSource = DSCaracter
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSCaracter
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpCaracter
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpCaracter
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpCaracter
      end
      inherited Panel2: TPanel
        Left = 681
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSCaracter
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
        DataBinding.DataSource = DSCaracter
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
        DataBinding.DataSource = DSCaracter
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerCaracterExcluido'
    OperGrabarObjeto = 'SaveCaracterExcluido'
    CargaDataSets = <
      item
        DataSet = TCaracterExcluido
        TableName = 'TCaracterExcluido'
      end>
    BajaLogica = <
      item
        DataSet = TCaracterExcluido
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TCaracterExcluido
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 552
    Top = 16
  end
  object TCaracterExcluido: TsnTable [3]
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
    object TCaracterExcluidooid_caracter: TIntegerField
      FieldName = 'oid_caracter'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCaracterExcluidocodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TCaracterExcluidodescripcion: TStringField
      DisplayWidth = 50
      FieldName = 'descripcion'
      Size = 50
    end
    object TCaracterExcluidoactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSCaracter: TDataSource [4]
    DataSet = TCaracterExcluido
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
    Left = 168
    Top = 56
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 400
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TCaracterExcluido'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorCaracter.Value := Sender.AsString;'
          '  ValidadorCaracter.Validar;'
          'end.')
      end>
    Left = 368
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object HelpCaracter: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'exc.CaracterExcluido'
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
    Titulo = 'Caracter'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorCaracter: TValidador
    Operacion = Operacion
    NickNameObjLog = 'exc.CaracterExcluido'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Caracter duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
end
