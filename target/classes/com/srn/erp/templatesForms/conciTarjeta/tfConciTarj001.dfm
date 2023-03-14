inherited FEmpresaTarjeta: TFEmpresaTarjeta
  Left = 127
  Top = 57
  Height = 485
  Caption = 'Empresas que operan con Tarjetas'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Height = 451
    inherited PPie: TPanel
      Top = 430
    end
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTEmpresaConciTar
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTEmpresaConciTar
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpUnidadEmpresas
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpUnidadEmpresas
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpUnidadEmpresas
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTEmpresaConciTar
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
      Height = 355
      object Label1: TLabel
        Left = 40
        Top = 8
        Width = 63
        Height = 13
        Caption = 'Raz'#243'n Social'
      end
      object Label2: TLabel
        Left = 40
        Top = 40
        Width = 37
        Height = 13
        Caption = 'C.U.I.T.'
      end
      object Label3: TLabel
        Left = 40
        Top = 72
        Width = 80
        Height = 13
        Caption = 'C'#243'digo Comercio'
      end
      object Label4: TLabel
        Left = 40
        Top = 104
        Width = 112
        Height = 13
        Caption = 'Ultimo Nro. Conciliaci'#243'n'
      end
      object Label5: TLabel
        Left = 40
        Top = 136
        Width = 198
        Height = 13
        Caption = 'Comienzo archivo Importaci'#243'n de Tarjetas'
      end
      object Label6: TLabel
        Left = 40
        Top = 168
        Width = 107
        Height = 13
        Caption = 'Tipo Asiento Cobranza'
      end
      object Label7: TLabel
        Left = 42
        Top = 200
        Width = 87
        Height = 13
        Caption = 'C'#243'd. Emp. Interfaz'
      end
      object snLabel1: TsnLabel
        Left = 43
        Top = 236
        Width = 103
        Height = 13
        Caption = 'Asiento de Cobranzas'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clNavy
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsUnderline]
        ParentFont = False
      end
      object snLabel2: TsnLabel
        Left = 64
        Top = 272
        Width = 82
        Height = 13
        Caption = 'Tipo. Documento'
      end
      object snLabel3: TsnLabel
        Left = 64
        Top = 304
        Width = 79
        Height = 13
        Caption = 'Unidad Contable'
      end
      object snLabel4: TsnLabel
        Left = 275
        Top = 236
        Width = 107
        Height = 13
        Caption = 'Asiento de Liquidaci'#243'n'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clNavy
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsUnderline]
        ParentFont = False
      end
      object snLabel5: TsnLabel
        Left = 296
        Top = 272
        Width = 82
        Height = 13
        Caption = 'Tipo. Documento'
      end
      object snLabel6: TsnLabel
        Left = 296
        Top = 304
        Width = 79
        Height = 13
        Caption = 'Unidad Contable'
      end
      object DBECodigo: TsnDBEdit
        Left = 165
        Top = 4
        DataBinding.DataField = 'razon_social'
        DataBinding.DataSource = DSTEmpresaConciTar
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 420
      end
      object DBEDescripcion: TsnDBEdit
        Left = 165
        Top = 36
        DataBinding.DataField = 'cuit'
        DataBinding.DataSource = DSTEmpresaConciTar
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 140
      end
      object snDBEdit1: TsnDBEdit
        Left = 165
        Top = 68
        DataBinding.DataField = 'cod_comercio'
        DataBinding.DataSource = DSTEmpresaConciTar
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 2
        Width = 140
      end
      object snDBEdit2: TsnDBEdit
        Left = 165
        Top = 100
        DataBinding.DataField = 'ult_nro_conci'
        DataBinding.DataSource = DSTEmpresaConciTar
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 3
        Width = 140
      end
      object snDBEdit3: TsnDBEdit
        Left = 253
        Top = 132
        DataBinding.DataField = 'cod_emp_arch_tarj'
        DataBinding.DataSource = DSTEmpresaConciTar
        Properties.MaxLength = 10
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 4
        Width = 92
      end
      object snDBLookup1: TsnDBLookup
        Left = 167
        Top = 164
        DataBinding.DataField = 'tipo_asi_cob'
        DataBinding.DataSource = DSTEmpresaConciTar
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTipoAsiCob
        TabOrder = 5
        Width = 234
      end
      object snDBEdit4: TsnDBEdit
        Left = 167
        Top = 196
        DataBinding.DataField = 'cod_emp_interfaz'
        DataBinding.DataSource = DSTEmpresaConciTar
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 6
        Width = 140
      end
      object snDBEdit5: TsnDBEdit
        Left = 157
        Top = 268
        DataBinding.DataField = 'tipo_docu_asi_cob'
        DataBinding.DataSource = DSTEmpresaConciTar
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 7
        Width = 84
      end
      object snDBEdit6: TsnDBEdit
        Left = 157
        Top = 300
        DataBinding.DataField = 'uni_conta_asi_cob'
        DataBinding.DataSource = DSTEmpresaConciTar
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 8
        Width = 84
      end
      object snDBEdit7: TsnDBEdit
        Left = 389
        Top = 268
        DataBinding.DataField = 'tipo_docu_asi_liq'
        DataBinding.DataSource = DSTEmpresaConciTar
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 9
        Width = 84
      end
      object snDBEdit8: TsnDBEdit
        Left = 389
        Top = 300
        DataBinding.DataField = 'uni_conta_asi_liq'
        DataBinding.DataSource = DSTEmpresaConciTar
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 10
        Width = 84
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerEmpresaConciTar'
    OperGrabarObjeto = 'SaveEmpresaConciTar'
    CargaDataSets = <
      item
        DataSet = TEmpresaConciTar
        TableName = 'TEmpresaConciTar'
      end
      item
        DataSet = TTiposAsientosCob
        TableName = 'TTiposAsientosCob'
      end>
    BajaLogica = <
      item
        DataSet = TEmpresaConciTar
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TEmpresaConciTar
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TEmpresaConciTar: TsnTable [3]
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
    object TEmpresaConciTaroid_empresa: TIntegerField
      FieldName = 'oid_empresa'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
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
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TEmpresaConciTarcod_comercio: TStringField
      FieldName = 'cod_comercio'
      Size = 50
    end
    object TEmpresaConciTarult_nro_conci: TIntegerField
      FieldName = 'ult_nro_conci'
    end
    object TEmpresaConciTarcod_emp_arch_tarj: TStringField
      FieldName = 'cod_emp_arch_tarj'
      Size = 10
    end
    object TEmpresaConciTartipo_asi_cob: TStringField
      FieldName = 'tipo_asi_cob'
    end
    object TEmpresaConciTartipo_asi_liqui: TStringField
      FieldName = 'tipo_asi_liqui'
    end
    object TEmpresaConciTarcod_emp_interfaz: TStringField
      FieldName = 'cod_emp_interfaz'
    end
    object TEmpresaConciTartipo_docu_asi_cob: TStringField
      FieldName = 'tipo_docu_asi_cob'
    end
    object TEmpresaConciTaruni_conta_asi_cob: TStringField
      FieldName = 'uni_conta_asi_cob'
    end
    object TEmpresaConciTartipo_docu_asi_liq: TStringField
      FieldName = 'tipo_docu_asi_liq'
    end
    object TEmpresaConciTaruni_conta_asi_liq: TStringField
      FieldName = 'uni_conta_asi_liq'
    end
  end
  object DSTEmpresaConciTar: TDataSource [4]
    DataSet = TEmpresaConciTar
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
        TableName = 'TEmpresaConciTar'
        FieldName = 'razon_social'
        Source.Strings = (
          'begin'
          '  ValidadorEmpresa.Value := Sender.AsString;'
          '  ValidadorEmpresa.Validar;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTipoAsiCobTarj'#39');'
          ' operacion.execute();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited ImageListGruposPopUp: TImageList
    Top = 123
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 264
  end
  inherited TPathHelp: TsnTable
    Left = 576
    Top = 245
  end
  object HelpUnidadEmpresas: TsnHelp
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
    Left = 50
    Top = 28
  end
  object ValidadorEmpresa: TValidador
    Operacion = Operacion
    NickNameObjLog = 'ctar.EmpresaConciTar'
    WhenRaiseException = teFound
    MensajeException = 'Empresa Duplicada'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
  object TTiposAsientosCob: TsnTable
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
    Left = 184
    Top = 299
    object TTiposAsientosCobcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTiposAsientosCobdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTipoAsiCob: TDataSource
    DataSet = TTiposAsientosCob
    Left = 216
    Top = 299
  end
end
