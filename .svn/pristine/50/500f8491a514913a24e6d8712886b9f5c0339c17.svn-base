inherited FUniNegConciTar: TFUniNegConciTar
  Left = 154
  Top = 167
  Height = 438
  Caption = 'Unidades de Negocios'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Height = 404
    inherited PPie: TPanel
      Top = 383
    end
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTUniNegConciTar
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTUniNegConciTar
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpUnidadNegocios
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpUnidadNegocios
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpUnidadNegocios
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTUniNegConciTar
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
    inherited PCabecera: TPanel
      Height = 65
      object Label1: TLabel
        Left = 40
        Top = 16
        Width = 92
        Height = 13
        Caption = 'Unidad de Negocio'
      end
      object Label2: TLabel
        Left = 40
        Top = 48
        Width = 41
        Height = 13
        Caption = 'Empresa'
      end
      object DBECodigo: TsnDBEdit
        Left = 157
        Top = 12
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTUniNegConciTar
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 316
      end
      object DBEmpresa: TsnDBLookup
        Left = 156
        Top = 44
        DataBinding.DataField = 'oid_empresa'
        DataBinding.DataSource = DSTUniNegConciTar
        Properties.KeyFieldNames = 'oid_empresa'
        Properties.ListColumns = <
          item
            FieldName = 'razon_social'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSEmpresas
        TabOrder = 1
        Width = 317
      end
    end
    inherited PCuerpo: TPanel
      Top = 117
      Height = 266
      BorderWidth = 10
      object PageControlSN1: TPageControlSN
        Left = 10
        Top = 10
        Width = 709
        Height = 246
        ActivePage = TabSheet1
        Align = alClient
        TabOrder = 0
        object TabSheet1: TTabSheet
          Caption = 'Cuentas Contables'
          object Label8: TLabel
            Left = 56
            Top = 40
            Width = 3
            Height = 13
          end
          object snLabel1: TsnLabel
            Left = 56
            Top = 56
            Width = 34
            Height = 13
            Caption = 'Cuenta'
          end
          object snLabel2: TsnLabel
            Left = 256
            Top = 32
            Width = 69
            Height = 13
            Caption = 'Componente 1'
          end
          object snLabel3: TsnLabel
            Left = 408
            Top = 32
            Width = 69
            Height = 13
            Caption = 'Componente 2'
          end
          object snLabel4: TsnLabel
            Left = 24
            Top = 14
            Width = 155
            Height = 13
            Caption = 'Utilizar en asiento a Cobrar'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clNavy
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = [fsBold]
            ParentFont = False
          end
          object snDBEdit5: TsnDBEdit
            Left = 101
            Top = 53
            DataBinding.DataField = 'acob_cta_tarj'
            DataBinding.DataSource = DSTUniNegConciTar
            TabOrder = 0
            Width = 140
          end
          object snDBEdit6: TsnDBEdit
            Left = 253
            Top = 53
            DataBinding.DataField = 'acob_cta_tarj_c1'
            DataBinding.DataSource = DSTUniNegConciTar
            TabOrder = 1
            Width = 140
          end
          object snDBEdit7: TsnDBEdit
            Left = 405
            Top = 53
            DataBinding.DataField = 'acob_cta_tarj_c2'
            DataBinding.DataSource = DSTUniNegConciTar
            TabOrder = 2
            Width = 140
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerUniNegConciTar'
    OperGrabarObjeto = 'SaveUniNegConciTar'
    CargaDataSets = <
      item
        DataSet = TUniNegConciTar
        TableName = 'TUniNegConciTar'
      end
      item
        DataSet = TEmpresaConciTar
        TableName = 'TEmpresaConciTar'
      end
      item
        DataSet = TEmpresaConciTar
        TableName = 'TEmpresaConciTar'
      end>
    BajaLogica = <
      item
        DataSet = TUniNegConciTar
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TUniNegConciTar
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 520
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TUniNegConciTar: TsnTable [3]
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
    object TUniNegConciTaroid_uni_neg: TIntegerField
      FieldName = 'oid_uni_neg'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TUniNegConciTardescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
    object TUniNegConciTaroid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TUniNegConciTaractivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TUniNegConciTaracob_cta_tarj: TStringField
      FieldName = 'acob_cta_tarj'
      Size = 50
    end
    object TUniNegConciTaracob_cta_tarj_c1: TStringField
      FieldName = 'acob_cta_tarj_c1'
      Size = 50
    end
    object TUniNegConciTaracob_cta_tarj_c2: TStringField
      FieldName = 'acob_cta_tarj_c2'
      Size = 50
    end
  end
  object DSTUniNegConciTar: TDataSource [4]
    DataSet = TUniNegConciTar
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
    OnShow.Strings = (
      'begin'
      
        '  snLabel2.setCaption(Varios.getValorString('#39'LABEL_COMP1_CONC_TA' +
        'RJ'#39'));'
      
        '  snLabel3.setCaption(Varios.getValorString('#39'LABEL_COMP2_CONC_TA' +
        'RJ'#39'));'
      'end.')
    OnValidate = <
      item
        TableName = 'TUniNegConciTar'
        FieldName = 'descripcion'
        Source.Strings = (
          'begin'
          '  ValidadorUniNeg.Value := Sender.AsString;'
          '  ValidadorUniNeg.Validar;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerEmpresasConciTar'#39');'
          ' operacion.execute();  '
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 264
  end
  object HelpUnidadNegocios: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ctar.UniNegConciTar'
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
    Titulo = 'Unidades de Negocios'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorUniNeg: TValidador
    Operacion = Operacion
    NickNameObjLog = 'ctar.UniNegConciTar'
    WhenRaiseException = teFound
    MensajeException = 'Unidad de Negocio Duplicada'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
  object TEmpresaConciTar: TsnTable
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
    Left = 384
    Top = 251
    object TEmpresaConciTaroid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TEmpresaConciTarrazon_social: TStringField
      FieldName = 'razon_social'
      Size = 100
    end
    object TEmpresaConciTarcuit: TStringField
      FieldName = 'cuit'
      Size = 50
    end
    object TEmpresaConciTaractivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSEmpresas: TDataSource
    DataSet = TEmpresaConciTar
    Left = 416
    Top = 251
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 536
    Top = 260
  end
end
