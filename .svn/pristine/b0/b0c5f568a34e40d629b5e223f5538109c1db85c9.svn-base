inherited FMCModifProv: TFMCModifProv
  Left = 42
  Top = 61
  Width = 1196
  Height = 681
  Caption = 'Modificación del Proveedor'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 1180
    Height = 57
    Align = alTop
    Color = clWhite
    TabOrder = 0
    object Label10: TLabel
      Left = 128
      Top = 24
      Width = 25
      Height = 13
      Caption = 'CUIT'
    end
    object Label11: TLabel
      Left = 408
      Top = 24
      Width = 63
      Height = 13
      Caption = 'Razon Social'
    end
    object snDBEdit8: TsnDBEdit
      Left = 180
      Top = 20
      DataBinding.DataField = 'cuit'
      DataBinding.DataSource = DSInput
      Properties.MaxLength = 60
      Style.BorderColor = clWindowFrame
      Style.Shadow = False
      TabOrder = 0
      Width = 181
    end
    object snDBEdit9: TsnDBEdit
      Left = 492
      Top = 20
      DataBinding.DataField = 'razon_social'
      DataBinding.DataSource = DSInput
      Properties.MaxLength = 60
      Style.BorderColor = clWindowFrame
      Style.Shadow = False
      TabOrder = 1
      Width = 333
    end
    object BotonBuscar: TsnButton
      Left = 849
      Top = 13
      Width = 105
      Height = 33
      Caption = 'Buscar'
      Default = True
      TabOrder = 2
      LookAndFeel.Kind = lfOffice11
    end
    object BotonSalir: TsnButton
      Left = 24
      Top = 8
      Width = 75
      Height = 41
      Caption = 'Salir'
      TabOrder = 3
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 57
    Width = 1180
    Height = 586
    Align = alClient
    Color = clWhite
    TabOrder = 1
    object Label9: TLabel
      Left = 499
      Top = 629
      Width = 92
      Height = 13
      Caption = 'Grupo Proveedores'
    end
    object PanelEstado1: TPanelEstado
      Left = 1
      Top = 1
      Width = 1178
      Height = 344
      Align = alTop
      TabOrder = 0
      Leyendas = <>
      object snDBTreeList2: TsnDBTreeList
        Left = 1
        Top = 1
        Width = 1176
        Height = 342
        Align = alClient
        Bands = <
          item
          end>
        BufferedPaint = False
        DataController.DataSource = DSProveedoresMaterial
        DataController.ParentField = 'oid_padre'
        DataController.KeyField = 'oid_key_unico'
        LookAndFeel.Kind = lfOffice11
        OptionsBehavior.AlwaysShowEditor = True
        OptionsBehavior.GoToNextCellOnEnter = True
        OptionsBehavior.GoToNextCellOnTab = True
        OptionsBehavior.ConfirmDelete = False
        OptionsBehavior.ExpandOnDblClick = False
        OptionsBehavior.FocusCellOnCycle = True
        OptionsBehavior.IncSearch = True
        OptionsData.Editing = False
        OptionsData.Deleting = False
        OptionsView.CellAutoHeight = True
        OptionsView.ExtPaintStyle = True
        OptionsView.Indicator = True
        RootValue = -1
        TabOrder = 0
        object snDBTreeList2cuit: TcxDBTreeListColumn
          Caption.Text = 'Cuit'
          DataBinding.FieldName = 'cuit_empresa'
          Width = 111
          Position.ColIndex = 0
          Position.RowIndex = 0
          Position.BandIndex = 0
        end
        object snDBTreeList2razon_social: TcxDBTreeListColumn
          Caption.Text = 'Razon social'
          DataBinding.FieldName = 'razon_social'
          Width = 184
          Position.ColIndex = 2
          Position.RowIndex = 0
          Position.BandIndex = 0
        end
        object snDBTreeList2direccion: TcxDBTreeListColumn
          Caption.Text = 'Direccion'
          DataBinding.FieldName = 'direccion'
          Width = 209
          Position.ColIndex = 3
          Position.RowIndex = 0
          Position.BandIndex = 0
        end
        object snDBTreeList2contacto: TcxDBTreeListColumn
          Caption.Text = 'Contacto'
          DataBinding.FieldName = 'contacto'
          Width = 100
          Position.ColIndex = 4
          Position.RowIndex = 0
          Position.BandIndex = 0
        end
        object snDBTreeList2comercial: TcxDBTreeListColumn
          Caption.Text = 'Comercial'
          DataBinding.FieldName = 'comercial'
          Width = 100
          Position.ColIndex = 5
          Position.RowIndex = 0
          Position.BandIndex = 0
        end
        object snDBTreeList2telefono: TcxDBTreeListColumn
          Caption.Text = 'Telefono'
          DataBinding.FieldName = 'telefono'
          Width = 111
          Position.ColIndex = 6
          Position.RowIndex = 0
          Position.BandIndex = 0
        end
        object snDBTreeList2email: TcxDBTreeListColumn
          Caption.Text = 'Email'
          DataBinding.FieldName = 'email'
          Width = 126
          Position.ColIndex = 7
          Position.RowIndex = 0
          Position.BandIndex = 0
        end
        object snDBTreeList2nombre_grupo: TcxDBTreeListColumn
          Caption.Text = 'Grupo Proveedor'
          DataBinding.FieldName = 'nombre_grupo'
          Width = 126
          Position.ColIndex = 8
          Position.RowIndex = 0
          Position.BandIndex = 0
        end
        object snDBTreeList2condicion_de_pago: TcxDBTreeListColumn
          Caption.Text = 'Condicion de pago'
          DataBinding.FieldName = 'condicion_de_pago'
          Width = 134
          Position.ColIndex = 9
          Position.RowIndex = 0
          Position.BandIndex = 0
        end
        object snDBTreeList2cxDBTreeListColumn1: TcxDBTreeListColumn
          Caption.Text = 'Estado'
          DataBinding.FieldName = 'estado'
          Width = 66
          Position.ColIndex = 1
          Position.RowIndex = 0
          Position.BandIndex = 0
        end
        object snDBTreeList2cxDBTreeListColumn2: TcxDBTreeListColumn
          Visible = False
          DataBinding.FieldName = 'oid_proveedor'
          Position.ColIndex = 10
          Position.RowIndex = 0
          Position.BandIndex = 0
        end
        object snDBTreeList2cxDBTreeListColumn3: TcxDBTreeListColumn
          Visible = False
          DataBinding.FieldName = 'oid_padre'
          Position.ColIndex = 11
          Position.RowIndex = 0
          Position.BandIndex = 0
        end
        object snDBTreeList2cxDBTreeListColumn4: TcxDBTreeListColumn
          Visible = False
          DataBinding.FieldName = 'oid_key_unico'
          Position.ColIndex = 12
          Position.RowIndex = 0
          Position.BandIndex = 0
        end
        object snDBTreeList2cxDBTreeListColumn5: TcxDBTreeListColumn
          Visible = False
          DataBinding.FieldName = 'oid_key_unico'
          Position.ColIndex = 13
          Position.RowIndex = 0
          Position.BandIndex = 0
        end
        object snDBTreeList2cxDBTreeListColumn6: TcxDBTreeListColumn
          Visible = False
          DataBinding.FieldName = 'oid_padre'
          Position.ColIndex = 14
          Position.RowIndex = 0
          Position.BandIndex = 0
        end
      end
    end
    object PanelEstado2: TPanelEstado
      Left = 1
      Top = 345
      Width = 1178
      Height = 336
      Align = alTop
      Color = clWhite
      TabOrder = 1
      Leyendas = <>
      object Label3: TLabel
        Left = 124
        Top = 56
        Width = 45
        Height = 13
        Caption = 'Direccion'
      end
      object Label1: TLabel
        Left = 144
        Top = 32
        Width = 25
        Height = 13
        Caption = 'CUIT'
      end
      object Label2: TLabel
        Left = 408
        Top = 24
        Width = 63
        Height = 13
        Caption = 'Razon Social'
      end
      object Label8: TLabel
        Left = 99
        Top = 188
        Width = 69
        Height = 13
        Caption = 'Plazo de Pago'
      end
      object Label7: TLabel
        Left = 142
        Top = 164
        Width = 25
        Height = 13
        Caption = 'Email'
      end
      object Label4: TLabel
        Left = 126
        Top = 139
        Width = 43
        Height = 13
        Caption = 'Contacto'
      end
      object Label6: TLabel
        Left = 544
        Top = 163
        Width = 42
        Height = 13
        Caption = 'Telefono'
      end
      object Label5: TLabel
        Left = 541
        Top = 140
        Width = 46
        Height = 13
        Caption = 'Comercial'
      end
      object Label12: TLabel
        Left = 515
        Top = 187
        Width = 81
        Height = 13
        Caption = 'Grupo Proveedor'
      end
      object snDBEdit1: TsnDBEdit
        Left = 180
        Top = 24
        DataBinding.DataField = 'cuit'
        DataBinding.DataSource = DSProveedor
        Properties.MaxLength = 60
        Properties.ReadOnly = True
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        ReadOnlyAlways = True
        Width = 181
      end
      object snDBEdit2: TsnDBEdit
        Left = 484
        Top = 24
        DataBinding.DataField = 'razon_social'
        DataBinding.DataSource = DSProveedor
        Properties.MaxLength = 60
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 413
      end
      object snDBEdit5: TsnDBEdit
        Left = 600
        Top = 136
        DataBinding.DataField = 'comercial'
        DataBinding.DataSource = DSProveedor
        Properties.MaxLength = 60
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 4
        Width = 281
      end
      object snDBEdit6: TsnDBEdit
        Left = 600
        Top = 160
        DataBinding.DataField = 'telefono'
        DataBinding.DataSource = DSProveedor
        Properties.MaxLength = 30
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 6
        Width = 281
      end
      object snDBLookup1: TsnDBLookup
        Left = 599
        Top = 184
        DataBinding.DataField = 'id_grupo_proveedor'
        DataBinding.DataSource = DSProveedor
        Properties.KeyFieldNames = 'oid_grupo_proveedor'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = SDGrupoProveedores
        TabOrder = 8
        Width = 281
      end
      object snDBCheckEdit2: TsnDBCheckEdit
        Left = 678
        Top = 213
        Caption = 'MAGIC'
        DataBinding.DataField = 'activo_magic'
        DataBinding.DataSource = DSProveedor
        TabOrder = 12
        Width = 65
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 502
        Top = 213
        Caption = 'BINBAIRES'
        DataBinding.DataField = 'activo_binbaires'
        DataBinding.DataSource = DSProveedor
        TabOrder = 11
        Width = 89
      end
      object BotonGuardar: TsnButton
        Left = 719
        Top = 64
        Width = 168
        Height = 57
        Caption = 'Guardar Modificaciones'
        TabOrder = 13
        LookAndFeel.Kind = lfOffice11
      end
      object snDBCheckEdit3: TsnDBCheckEdit
        Left = 366
        Top = 213
        Caption = 'UTE'
        DataBinding.DataField = 'activo_ute'
        DataBinding.DataSource = DSProveedor
        TabOrder = 10
        Width = 49
      end
      object snDBCheckEdit4: TsnDBCheckEdit
        Left = 198
        Top = 213
        Caption = 'ALAVERA'
        DataBinding.DataField = 'activo_alavera'
        DataBinding.DataSource = DSProveedor
        TabOrder = 9
        Width = 81
      end
      object srnDBButtonEdit1: TsrnDBButtonEdit
        Left = 181
        Top = 184
        DataBinding.DataField = 'condicion_de_pago'
        DataBinding.DataSource = DSProveedor
        Properties.Buttons = <
          item
            Default = True
            Kind = bkEllipsis
          end>
        TabOrder = 7
        Help = HelpMetodoPago
        Width = 329
      end
      object snDBEdit4: TsnDBEdit
        Left = 181
        Top = 136
        DataBinding.DataField = 'contacto'
        DataBinding.DataSource = DSProveedor
        Properties.MaxLength = 60
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 3
        Width = 333
      end
      object snDBEdit7: TsnDBEdit
        Left = 181
        Top = 160
        DataBinding.DataField = 'email'
        DataBinding.DataSource = DSProveedor
        Properties.MaxLength = 254
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 5
        Width = 341
      end
      object snDBMemo1: TsnDBMemo
        Left = 180
        Top = 54
        DataBinding.DataField = 'direccion'
        DataBinding.DataSource = DSProveedor
        TabOrder = 2
        ReadOnlyAlways = False
        Height = 79
        Width = 508
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TProveedoresMaterial
        TableName = 'TProveedoresMaterial'
      end
      item
        DataSet = TGrupoProveedores
        TableName = 'TGrupoProveedores'
      end
      item
        DataSet = TProveedor
        TableName = 'TProveedor'
      end
      item
        DataSet = TErrores
        TableName = 'TErrores'
      end>
    DataSetCab = TProveedor
    Left = 302
    Top = 2
  end
  inherited Operacion: TOperacion
    Left = 335
    Top = 2
  end
  inherited TOidObjSave: TsnTable
    Left = 531
    Top = 2
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 369
    Top = 2
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 402
    Top = 2
  end
  inherited DriverEvent: TDriverEvent
    OnKeyDown = <
      item
        Key = 13
        Shift = []
        ControlName = 'snDBEdit8'
        isNuevo = True
        isModificar = True
        isBrowse = True
        Source.Strings = (
          'Begin '
          '  buscar();'
          'End.')
      end
      item
        Key = 13
        Shift = []
        ControlName = 'snDBEdit9'
        isNuevo = False
        isModificar = False
        isBrowse = False
        Source.Strings = (
          'Begin '
          '  buscar();'
          'End.')
      end>
    OnDblClick = <
      item
        CompoName = 'snDBTreeList2'
        Source.Strings = (
          'BEGIN'
          '  mensaje.information(''a'');'
          'END.')
      end>
    OnTreeViewDBClick = <
      item
        TreeViewName = 'snDBTreeList2'
        Source.Strings = (
          'begin'
          '  Operacion.InicioOperacion();'
          '  Operacion.setOper(''TraerProveedorMaterialControl'');'
          
            '  Operacion.addAtribute(''cuit'', TProveedoresMaterial.FieldName(''' +
            'cuit'').asString);'
          
            '  Operacion.addAtribute(''cuit_empresa'', TProveedoresMaterial.Fie' +
            'ldName(''cuit_empresa'').asString);'
          '  Operacion.execute();'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          ''
          '     TInput.open;'
          '     TInput.appendRecord;'
          ''
          '     TProveedor.open;'
          '     TProveedor.appendRecord;'
          ''
          '     Operacion.inicioOperacion();'
          '     Operacion.setOper(''TraerGruposProveedores'');'
          '     Operacion.execute();'
          ''
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'Procedure buscar();'
          'Begin '
          '  TInput.postRecord();'
          '  Operacion.InicioOperacion();'
          '  Operacion.setOper(''TraerProveedorMatContByFiltros'');'
          
            '  Operacion.addAtribute(''cuit'', TInput.FieldName(''cuit'').asStrin' +
            'g);'
          
            '  Operacion.addAtribute(''razon_social'', TInput.FieldName(''razon_' +
            'social'').asString);'
          '  Operacion.execute();'
          'End;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonGuardar'
        Source.Strings = (
          'Begin '
          ''
          
            '  if (mensaje.question(''¿Desea grabar los cambios en todas las B' +
            'ases Seleccionadas?'')=false) then exit;'
          ''
          '  Operacion.InicioOperacion();'
          '  Operacion.setOper(''SaveProveedorMaterialControl'');'
          '  Operacion.AddAtribute(''MODIFICACION'','''');'
          '  Operacion.addDataset(TProveedor.getDataset());'
          '  Operacion.execute();'
          ''
          '  TErrores.first;'
          '  while (not TErrores.EOF()) do'
          '  begin'
          '  Mensaje.information(TErrores.FieldName(''mensaje'').asString);'
          '  TErrores.next();'
          '  end;'
          ''
          
            '  Mensaje.information(''El Proveedor ha sido Modificado correctam' +
            'ente'');'
          '  TProveedor.close;'
          '  TProveedor.open;'
          '  TProveedor.appendRecord;'
          ''
          '  Buscar();'
          'End.')
      end
      item
        ButtonName = 'BotonBuscar'
        Source.Strings = (
          'Begin '
          '  Buscar();'
          'End.')
      end
      item
        ButtonName = 'BotonSalir'
        Source.Strings = (
          'begin'
          '  close();'
          'end.')
      end>
    Left = 435
    Top = 2
  end
  inherited SaveArchivo: TSaveDialog
    Left = 499
    Top = 2
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 467
    Top = 2
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 563
    Top = 2
  end
  inherited TPathHelp: TsnTable
    Left = 595
    Top = 2
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
    Left = 896
    Top = 536
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
    Left = 936
    Top = 536
  end
  object SDGrupoProveedores: TDataSource
    DataSet = TGrupoProveedores
    Left = 936
    Top = 656
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
    Left = 122
    Top = 676
  end
  object ValidadorMetodoPago: TValidador
    Operacion = Operacion
    NickNameObjLog = 'ma.condicionPago'
    WhenRaiseException = teFound
    MensajeException = 'Código de Clasificador duplicado'
    NroQuery = 0
    Cache = False
    Left = 152
    Top = 675
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
    Left = 896
    Top = 659
    object TGrupoProveedoresoid_grupo_proveedor: TIntegerField
      FieldName = 'oid_grupo_proveedor'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TGrupoProveedorescodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TGrupoProveedoresdescripcion: TStringField
      DisplayWidth = 200
      FieldName = 'descripcion'
      Size = 200
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
  object TProveedoresMaterial: TsnTable
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
    Left = 736
    Top = 272
    object IntegerField1: TIntegerField
      FieldName = 'oid_proveedor'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TProveedoresMaterialoid_padre: TIntegerField
      FieldName = 'oid_padre'
    end
    object StringField1: TStringField
      FieldName = 'cuit'
      Size = 60
    end
    object TProveedoresMaterialcuit_empresa: TStringField
      FieldName = 'cuit_empresa'
      Size = 200
    end
    object TProveedoresMaterialestado: TStringField
      FieldName = 'estado'
      Size = 50
    end
    object StringField2: TStringField
      FieldName = 'razon_social'
      Size = 60
    end
    object StringField3: TStringField
      FieldName = 'direccion'
      Size = 1000
    end
    object StringField4: TStringField
      FieldName = 'contacto'
      Size = 60
    end
    object StringField5: TStringField
      FieldName = 'comercial'
      Size = 60
    end
    object StringField6: TStringField
      FieldName = 'telefono'
      Size = 30
    end
    object StringField7: TStringField
      FieldName = 'email'
      Size = 254
    end
    object IntegerField2: TIntegerField
      FieldName = 'id_grupo_proveedor'
    end
    object StringField8: TStringField
      FieldName = 'nombre_grupo'
      Size = 60
    end
    object StringField9: TStringField
      FieldName = 'condicion_de_pago'
      Size = 60
    end
    object TProveedoresMaterialoid_key_unico: TIntegerField
      FieldName = 'oid_key_unico'
    end
  end
  object DSProveedoresMaterial: TDataSource
    DataSet = TProveedoresMaterial
    Left = 776
    Top = 272
  end
  object TInput: TsnTable
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
    Left = 32
    Top = 56
    object StringField10: TStringField
      FieldName = 'cuit'
      Size = 60
    end
    object StringField13: TStringField
      FieldName = 'razon_social'
      Size = 60
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 72
    Top = 56
  end
  object TErrores: TsnTable
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
    Left = 576
    Top = 168
    object TErroresmensaje: TStringField
      FieldName = 'mensaje'
      Size = 500
    end
  end
  object DSErrores: TDataSource
    DataSet = TErrores
    Left = 608
    Top = 168
  end
end
