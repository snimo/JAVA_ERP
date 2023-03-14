inherited FCtasBcoTarj: TFCtasBcoTarj
  Left = 141
  Top = 197
  Height = 438
  Caption = 'Cuentas Bancarias Tarjetas'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Height = 400
    inherited PPie: TPanel
      Top = 379
    end
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTCtaBancoLiqTarj
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTCtaBancoLiqTarj
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpCtas
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpCtas
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpCtas
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTCtaBancoLiqTarj
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
      Height = 304
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
        Width = 71
        Height = 13
        Caption = 'C'#243'digo Interfaz'
      end
      object Label4: TLabel
        Left = 40
        Top = 127
        Width = 41
        Height = 13
        Caption = 'Empresa'
      end
      object DBECodigo: TsnDBEdit
        Left = 157
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTCtaBancoLiqTarj
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 164
      end
      object snDBEdit1: TsnDBEdit
        Left = 157
        Top = 44
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTCtaBancoLiqTarj
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 252
      end
      object snDBEdit2: TsnDBEdit
        Left = 157
        Top = 84
        DataBinding.DataField = 'cod_interfaz'
        DataBinding.DataSource = DSTCtaBancoLiqTarj
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 2
        Width = 252
      end
      object snDBLookup1: TsnDBLookup
        Left = 157
        Top = 123
        DataBinding.DataField = 'oid_empresa'
        DataBinding.DataSource = DSTCtaBancoLiqTarj
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSEmpresas
        TabOrder = 3
        Width = 252
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerCtaBancoLiqTarj'
    OperGrabarObjeto = 'SaveCtaBancoLiqTarj'
    CargaDataSets = <
      item
        DataSet = TCtaBancoLiqTarj
        TableName = 'TCtaBancoLiqTarj'
      end>
    BajaLogica = <
      item
        DataSet = TCtaBancoLiqTarj
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TCtaBancoLiqTarj
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 520
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TCtaBancoLiqTarj: TsnTable [3]
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
    object TCtaBancoLiqTarjoid_cta_banco: TIntegerField
      FieldName = 'oid_cta_banco'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCtaBancoLiqTarjcodigo: TStringField
      FieldName = 'codigo'
    end
    object TCtaBancoLiqTarjdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
    object TCtaBancoLiqTarjcod_interfaz: TStringField
      FieldName = 'cod_interfaz'
      Size = 50
    end
    object TCtaBancoLiqTarjactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TCtaBancoLiqTarjoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
  end
  object DSTCtaBancoLiqTarj: TDataSource [4]
    DataSet = TCtaBancoLiqTarj
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
        TableName = 'TCtaBancoLiqTarj'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorCta.Value := Sender.AsString;'
          '  ValidadorCta.Validar;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerEmpresasConciTar'#39');'
          ' operacion.execute();  '
          ' TEmpresas.loadFromHelp('#39'HelpEmpresas'#39'); '
          'end.')
      end>
  end
  inherited SaveArchivo: TSaveDialog
    Left = 400
    Top = 128
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 264
    Top = 187
  end
  object HelpCtas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ctar.CtaBancoLiqTarj'
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
    Titulo = 'Cuentas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorCta: TValidador
    Operacion = Operacion
    NickNameObjLog = 'ctar.CtaBancoLiqTarj'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Cuenta Duplicada'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
  object HelpEmpresas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ctar.EmpresaConciTar'
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
    Titulo = 'Empresas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 487
    Top = 158
  end
  object TEmpresas: TsnTable
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
    Left = 519
    Top = 158
    object TEmpresasoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TEmpresascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TEmpresasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSEmpresas: TDataSource
    DataSet = TEmpresas
    Left = 552
    Top = 163
  end
end
