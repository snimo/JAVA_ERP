inherited FPeligrosidadExcluido: TFPeligrosidadExcluido
  Left = 108
  Top = 175
  Width = 730
  Height = 396
  Caption = 'Peligrosidad'
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
        DataSource = DSTPeligrosidadExcluido
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTPeligrosidadExcluido
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpPeligrosidad
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpPeligrosidad
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpPeligrosidad
      end
      inherited Panel2: TPanel
        Left = 673
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTPeligrosidadExcluido
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
      object Label3: TLabel
        Left = 40
        Top = 88
        Width = 29
        Height = 13
        Caption = 'Grado'
      end
      object Label4: TLabel
        Left = 256
        Top = 88
        Width = 214
        Height = 13
        Caption = '(Grado 1 representa las m'#225's alta peligrosidad)'
      end
      object Label5: TLabel
        Left = 40
        Top = 128
        Width = 24
        Height = 13
        Caption = 'Color'
      end
      object DBECodigo: TsnDBEdit
        Left = 156
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTPeligrosidadExcluido
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
        DataBinding.DataSource = DSTPeligrosidadExcluido
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object snDBEdit2: TsnDBEdit
        Left = 156
        Top = 84
        DataBinding.DataField = 'grado'
        DataBinding.DataSource = DSTPeligrosidadExcluido
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 2
        Width = 53
      end
      object snDBLookup1: TsnDBLookup
        Left = 156
        Top = 125
        DataBinding.DataField = 'color'
        DataBinding.DataSource = DSTPeligrosidadExcluido
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSColores
        TabOrder = 3
        Width = 204
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerPeligrosidadExcluido'
    OperGrabarObjeto = 'SavePeligrosidadExcluido'
    CargaDataSets = <
      item
        DataSet = TPeligrosidadExcluido
        TableName = 'TPeligrosidadExcluido'
      end
      item
        DataSet = TColores
        TableName = 'TColores'
      end>
    BajaLogica = <
      item
        DataSet = TPeligrosidadExcluido
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TPeligrosidadExcluido
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 552
    Top = 16
  end
  object TPeligrosidadExcluido: TsnTable [3]
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
    object TPeligrosidadExcluidooid_peligrosidad: TIntegerField
      FieldName = 'oid_peligrosidad'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPeligrosidadExcluidocodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TPeligrosidadExcluidodescripcion: TStringField
      DisplayWidth = 50
      FieldName = 'descripcion'
      Size = 50
    end
    object TPeligrosidadExcluidogrado: TIntegerField
      FieldName = 'grado'
    end
    object TPeligrosidadExcluidoactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TPeligrosidadExcluidocolor: TStringField
      FieldName = 'color'
    end
  end
  object DSTPeligrosidadExcluido: TDataSource [4]
    DataSet = TPeligrosidadExcluido
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
        TableName = 'TPeligrosidadExcluido'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorPeligrosidad.Value := Sender.AsString;'
          '  ValidadorPeligrosidad.Validar;'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TPeligrosidadExcluido'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerColoresEstadoExcluido'#39');'
          '  operacion.execute();'
          'end.')
      end>
    Left = 368
  end
  inherited SaveArchivo: TSaveDialog
    Left = 400
    Top = 112
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object HelpPeligrosidad: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'exc.PeligrosidadExcluido'
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
    Titulo = 'Peligrosidad'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorPeligrosidad: TValidador
    Operacion = Operacion
    NickNameObjLog = 'exc.PeligrosidadExcluido'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Peligrosidad duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
  object TColores: TsnTable
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
    Left = 528
    Top = 163
    object TColorescodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TColoresdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSColores: TDataSource
    DataSet = TColores
    Left = 560
    Top = 163
  end
end
