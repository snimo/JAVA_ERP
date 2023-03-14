inherited FMCAltaNuevoProvMaterial: TFMCAltaNuevoProvMaterial
  Left = 223
  Top = 138
  Width = 864
  Height = 633
  Caption = 'Alta de un Nuevo Proveedor'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 848
    Height = 41
    Align = alTop
    Color = clWhite
    TabOrder = 0
    object snLabel1: TsnLabel
      Left = 15
      Top = 11
      Width = 636
      Height = 16
      Caption = 
        'Cargue los Datos de un Nuevo Proveedor y seleccione las empresas' +
        ' donde se encontrará activo'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
      ParentFont = False
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 41
    Width = 848
    Height = 554
    Align = alClient
    Color = clWhite
    TabOrder = 1
    object Label1: TLabel
      Left = 40
      Top = 40
      Width = 25
      Height = 13
      Caption = 'CUIT'
    end
    object Label2: TLabel
      Left = 40
      Top = 80
      Width = 63
      Height = 13
      Caption = 'Razon Social'
    end
    object Label3: TLabel
      Left = 40
      Top = 120
      Width = 45
      Height = 13
      Caption = 'Direccion'
    end
    object Label4: TLabel
      Left = 40
      Top = 216
      Width = 43
      Height = 13
      Caption = 'Contacto'
    end
    object Label5: TLabel
      Left = 360
      Top = 216
      Width = 46
      Height = 13
      Caption = 'Comercial'
    end
    object Label6: TLabel
      Left = 40
      Top = 256
      Width = 42
      Height = 13
      Caption = 'Telefono'
    end
    object Label7: TLabel
      Left = 40
      Top = 296
      Width = 25
      Height = 13
      Caption = 'Email'
    end
    object Label8: TLabel
      Left = 40
      Top = 384
      Width = 90
      Height = 13
      Caption = 'Condicion de Pago'
    end
    object Label9: TLabel
      Left = 40
      Top = 336
      Width = 92
      Height = 13
      Caption = 'Grupo Proveedores'
    end
    object Label10: TLabel
      Left = 296
      Top = 40
      Width = 142
      Height = 13
      Caption = 'Ejemplo carga 22-23032122-3'
    end
    object snDBEdit1: TsnDBEdit
      Left = 140
      Top = 36
      DataBinding.DataField = 'cuit'
      DataBinding.DataSource = DSProveedor
      Properties.MaxLength = 60
      Style.BorderColor = clWindowFrame
      Style.Shadow = False
      TabOrder = 0
      Width = 149
    end
    object snDBEdit2: TsnDBEdit
      Left = 140
      Top = 76
      DataBinding.DataField = 'razon_social'
      DataBinding.DataSource = DSProveedor
      Properties.MaxLength = 60
      Style.BorderColor = clWindowFrame
      Style.Shadow = False
      TabOrder = 1
      Width = 501
    end
    object snDBEdit4: TsnDBEdit
      Left = 140
      Top = 212
      DataBinding.DataField = 'contacto'
      DataBinding.DataSource = DSProveedor
      Properties.MaxLength = 60
      Style.BorderColor = clWindowFrame
      Style.Shadow = False
      TabOrder = 3
      Width = 205
    end
    object snDBEdit5: TsnDBEdit
      Left = 416
      Top = 212
      DataBinding.DataField = 'comercial'
      DataBinding.DataSource = DSProveedor
      Properties.MaxLength = 60
      Style.BorderColor = clWindowFrame
      Style.Shadow = False
      TabOrder = 4
      Width = 225
    end
    object snDBEdit6: TsnDBEdit
      Left = 140
      Top = 252
      DataBinding.DataField = 'telefono'
      DataBinding.DataSource = DSProveedor
      Properties.MaxLength = 30
      Style.BorderColor = clWindowFrame
      Style.Shadow = False
      TabOrder = 5
      Width = 285
    end
    object snDBEdit7: TsnDBEdit
      Left = 140
      Top = 292
      DataBinding.DataField = 'email'
      DataBinding.DataSource = DSProveedor
      Properties.MaxLength = 254
      Style.BorderColor = clWindowFrame
      Style.Shadow = False
      TabOrder = 6
      Width = 389
    end
    object BotonGuardar: TsnButton
      Left = 129
      Top = 485
      Width = 105
      Height = 33
      Caption = 'Guardar'
      TabOrder = 8
      LookAndFeel.Kind = lfOffice11
    end
    object snButton1: TsnButton
      Left = 281
      Top = 485
      Width = 105
      Height = 33
      Caption = 'Cancelar'
      TabOrder = 9
      LookAndFeel.Kind = lfOffice11
    end
    object snDBCheckEdit2: TsnDBCheckEdit
      Left = 568
      Top = 430
      Caption = 'MAGIC'
      DataBinding.DataField = 'activo_magic'
      DataBinding.DataSource = DSProveedor
      TabOrder = 10
      Width = 65
    end
    object snDBCheckEdit1: TsnDBCheckEdit
      Left = 416
      Top = 430
      Caption = 'BINBAIRES'
      DataBinding.DataField = 'activo_binbaires'
      DataBinding.DataSource = DSProveedor
      TabOrder = 11
      Width = 89
    end
    object snDBCheckEdit3: TsnDBCheckEdit
      Left = 288
      Top = 430
      Caption = 'UTE'
      DataBinding.DataField = 'activo_ute'
      DataBinding.DataSource = DSProveedor
      TabOrder = 12
      Width = 49
    end
    object snDBCheckEdit4: TsnDBCheckEdit
      Left = 136
      Top = 430
      Caption = 'ALAVERA'
      DataBinding.DataField = 'activo_alavera'
      DataBinding.DataSource = DSProveedor
      TabOrder = 13
      Width = 81
    end
    object snDBLookup1: TsnDBLookup
      Left = 141
      Top = 332
      DataBinding.DataField = 'id_grupo_proveedor'
      DataBinding.DataSource = DSProveedor
      Properties.KeyFieldNames = 'oid_grupo_proveedor'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListSource = SDGrupoProveedores
      TabOrder = 7
      Width = 332
    end
    object srnDBButtonEdit1: TsrnDBButtonEdit
      Left = 142
      Top = 380
      DataBinding.DataField = 'condicion_de_pago'
      DataBinding.DataSource = DSProveedor
      Properties.Buttons = <
        item
          Default = True
          Kind = bkEllipsis
        end>
      TabOrder = 14
      Help = HelpMetodoPago
      Width = 329
    end
    object BotonSalir: TsnButton
      Left = 480
      Top = 24
      Width = 75
      Height = 41
      Caption = 'Salir'
      TabOrder = 15
      LookAndFeel.Kind = lfOffice11
    end
    object snDBMemo1: TsnDBMemo
      Left = 140
      Top = 112
      DataBinding.DataField = 'direccion'
      DataBinding.DataSource = DSProveedor
      TabOrder = 2
      ReadOnlyAlways = False
      Height = 89
      Width = 505
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
      end
      item
        DataSet = TGrupoProveedores
        TableName = 'TGrupoProveedores'
      end>
    DataSetCab = TProveedor
    Left = 294
    Top = 122
  end
  inherited Operacion: TOperacion
    Left = 327
    Top = 122
  end
  inherited TOidObjSave: TsnTable
    Left = 523
    Top = 122
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 361
    Top = 122
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 394
    Top = 122
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TProveedor'
        FieldName = 'cuit'
        Source.Strings = (
          'Begin '
          '  Operacion.InicioOperacion();'
          '  Operacion.setOper(''ValidarCUITProveedorMaterialControl'');'
          
            '  Operacion.addAtribute(''cuit'', TProveedor.FieldName(''cuit'').asS' +
            'tring);'
          '  Operacion.execute();'
          'End.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '     TProveedor.open;'
          '     TProveedor.appendRecord;'
          ''
          '    Operacion.inicioOperacion();'
          '    Operacion.setOper(''TraerGruposProveedores'');'
          '    Operacion.execute();'
          ''
          'end.')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonGuardar'
        Source.Strings = (
          'Begin '
          '  Operacion.InicioOperacion();'
          '  Operacion.setOper(''SaveProveedorMaterialControl'');'
          '  Operacion.AddAtribute(''ALTA'','''');'
          '  Operacion.addDataset(TProveedor.getDataset());'
          '  Operacion.execute();'
          ''
          '  mensaje.information(''Alta de proveedor exitoso!!!'');  '
          ''
          '  TProveedor.close;'
          '  TProveedor.open;'
          '  TProveedor.AppendRecord;'
          ''
          'End.')
      end
      item
        ButtonName = 'BotonSalir'
        Source.Strings = (
          'begin'
          '  close();'
          'end.')
      end>
    Left = 427
    Top = 122
  end
  inherited SaveArchivo: TSaveDialog
    Left = 491
    Top = 122
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 459
    Top = 122
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 555
    Top = 122
  end
  inherited TPathHelp: TsnTable
    Left = 587
    Top = 122
  end
  object TProveedor: TsnTable
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
    Left = 744
    Top = 160
    object TProveedoroid_proveedor: TIntegerField
      FieldName = 'oid_proveedor'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TProveedorcuit: TStringField
      FieldName = 'cuit'
      Size = 60
    end
    object TProveedorrazon_social: TStringField
      FieldName = 'razon_social'
      Size = 60
    end
    object TProveedordireccion: TStringField
      FieldName = 'direccion'
      Size = 1000
    end
    object TProveedorcontacto: TStringField
      FieldName = 'contacto'
      Size = 60
    end
    object TProveedorcomercial: TStringField
      FieldName = 'comercial'
      Size = 60
    end
    object TProveedortelefono: TStringField
      FieldName = 'telefono'
      Size = 30
    end
    object TProveedoremail: TStringField
      FieldName = 'email'
      Size = 254
    end
    object TProveedorid_grupo_proveedor: TIntegerField
      FieldName = 'id_grupo_proveedor'
    end
    object TProveedornombre_grupo: TStringField
      FieldName = 'nombre_grupo'
      Size = 60
    end
    object TProveedorcondicion_de_pago: TStringField
      FieldName = 'condicion_de_pago'
      Size = 60
    end
    object TProveedoractivo_ute: TBooleanField
      FieldName = 'activo_ute'
    end
    object TProveedoractivo_alavera: TBooleanField
      FieldName = 'activo_alavera'
    end
    object TProveedoractivo_binbaires: TBooleanField
      FieldName = 'activo_binbaires'
    end
    object TProveedoractivo_magic: TBooleanField
      FieldName = 'activo_magic'
    end
  end
  object DSProveedor: TDataSource
    DataSet = TProveedor
    Left = 784
    Top = 160
  end
  object SDGrupoProveedores: TDataSource
    DataSet = TGrupoProveedores
    Left = 576
    Top = 312
  end
  object HelpMetodoPago: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ma.condicionPago'
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
        Titulo = 'Descripción'
        FieldName = 'descripcion'
        Tipo = ftString
        Longitud = 30
        Visible = True
        AsignarACampo = TProveedorcondicion_de_pago
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'Código'
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
    Titulo = 'Clasificadores'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 530
    Top = 356
  end
  object ValidadorMetodoPago: TValidador
    Operacion = Operacion
    NickNameObjLog = 'ma.condicionPago'
    WhenRaiseException = teFound
    MensajeException = 'Código de Clasificador duplicado'
    NroQuery = 0
    Cache = False
    Left = 568
    Top = 355
  end
  object TGrupoProveedores: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo_proveedor'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_grupo_ute'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo_binbaires'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo_alavera'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo_magic'
        DataType = ftInteger
      end
      item
        Name = 'acrivo'
        DataType = ftBoolean
      end>
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
    Left = 536
    Top = 315
    object TGrupoProveedoresoid_grupo_proveedor: TIntegerField
      FieldName = 'oid_grupo_proveedor'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TGrupoProveedorescodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TGrupoProveedoresdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TGrupoProveedoresoid_grupo_ute: TIntegerField
      FieldName = 'oid_grupo_ute'
    end
    object TGrupoProveedoresoid_grupo_binbaires: TIntegerField
      FieldName = 'oid_grupo_binbaires'
    end
    object TGrupoProveedoresoid_grupo_alavera: TIntegerField
      FieldName = 'oid_grupo_alavera'
    end
    object TGrupoProveedoresoid_grupo_magic: TIntegerField
      FieldName = 'oid_grupo_magic'
    end
    object TGrupoProveedoresactivo: TBooleanField
      FieldName = 'activo'
    end
  end
end
