inherited FMostrarAyuda: TFMostrarAyuda
  Left = 56
  Top = 115
  Width = 1187
  Height = 714
  Caption = 'Ayuda'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 1179
    Height = 49
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object ImageSalir: TImage
      Left = 15
      Top = 11
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object snDBEdit1: TsnDBEdit
      Left = 56
      Top = 3
      TabStop = False
      DataBinding.DataField = 'titulo'
      DataBinding.DataSource = DSTElementoAyuda
      ParentFont = False
      Properties.ReadOnly = True
      Style.Edges = []
      Style.Font.Charset = ANSI_CHARSET
      Style.Font.Color = clNavy
      Style.Font.Height = -32
      Style.Font.Name = 'Verdana'
      Style.Font.Style = [fsBold]
      Style.IsFontAssigned = True
      TabOrder = 0
      Width = 1094
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 49
    Width = 1179
    Height = 631
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
    object Splitter1: TSplitter
      Left = 0
      Top = 313
      Width = 1179
      Height = 3
      Cursor = crVSplit
      Align = alTop
    end
    object Panel3: TPanel
      Left = 0
      Top = 0
      Width = 1179
      Height = 313
      Align = alTop
      BevelOuter = bvNone
      Color = clWindow
      TabOrder = 0
      object Splitter2: TSplitter
        Left = 780
        Top = 0
        Height = 313
      end
      object PanelEstado1: TPanelEstado
        Left = 783
        Top = 0
        Width = 396
        Height = 313
        Align = alClient
        BorderWidth = 10
        Color = clWindow
        TabOrder = 0
        Leyendas = <>
        object dxDBGridSN1: TdxDBGridSN
          Left = 11
          Top = 11
          Width = 374
          Height = 291
          Cursor = crHandPoint
          Align = alClient
          TabOrder = 0
          CriteriosPintarCelda = <>
          object dxDBGridSN1DBTableView1: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSTElementoRelAyuda
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsData.Editing = False
            OptionsData.Inserting = False
            OptionsView.ScrollBars = ssNone
            OptionsView.CellAutoHeight = True
            OptionsView.ColumnAutoWidth = True
            OptionsView.GroupByBox = False
            OptionsView.Header = False
            Styles.Content = cxStyle1
            object dxDBGridSN1DBTableView1desc_sug_ayuda: TcxGridDBColumn
              DataBinding.FieldName = 'desc_sug_ayuda'
              Width = 500
            end
          end
          object dxDBGridSN1Level1: TcxGridLevel
            GridView = dxDBGridSN1DBTableView1
          end
        end
      end
      object PanelEstado2: TPanelEstado
        Left = 0
        Top = 0
        Width = 780
        Height = 313
        Align = alLeft
        BorderWidth = 10
        Color = clWindow
        TabOrder = 1
        Leyendas = <>
        object snDBMemo1: TsnDBMemo
          Left = 11
          Top = 11
          Align = alClient
          DataBinding.DataField = 'objetivo'
          DataBinding.DataSource = DSTElementoAyuda
          TabOrder = 0
          ReadOnlyAlways = False
          Height = 291
          Width = 758
        end
      end
    end
    object Panel4: TPanel
      Left = 0
      Top = 316
      Width = 1179
      Height = 315
      Align = alClient
      BevelOuter = bvNone
      Color = clWindow
      TabOrder = 1
      object Splitter3: TSplitter
        Left = 292
        Top = 0
        Height = 315
      end
      object Splitter4: TSplitter
        Left = 779
        Top = 0
        Height = 315
        Align = alRight
      end
      object Panel5: TPanel
        Left = 0
        Top = 0
        Width = 292
        Height = 315
        Align = alLeft
        BorderWidth = 10
        Color = clWindow
        TabOrder = 0
        object dxDBGridSN2: TdxDBGridSN
          Left = 11
          Top = 11
          Width = 270
          Height = 293
          Cursor = crHandPoint
          Align = alClient
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clNavy
          Font.Height = -19
          Font.Name = 'MS Sans Serif'
          Font.Style = []
          ParentFont = False
          TabOrder = 0
          CriteriosPintarCelda = <>
          object cxGridDBTableView1: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSTSubElementoAyuda
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsData.Deleting = False
            OptionsData.Editing = False
            OptionsData.Inserting = False
            OptionsSelection.HideFocusRectOnExit = False
            OptionsSelection.UnselectFocusedRecordOnExit = False
            OptionsView.CellAutoHeight = True
            OptionsView.ColumnAutoWidth = True
            OptionsView.GroupByBox = False
            OptionsView.Header = False
            Styles.Content = cxStyle1
            object cxGridDBColumn1: TcxGridDBColumn
              DataBinding.FieldName = 'orden'
              Visible = False
              SortIndex = 0
              SortOrder = soAscending
            end
            object cxGridDBColumn2: TcxGridDBColumn
              DataBinding.FieldName = 'titulo'
              Width = 500
            end
          end
          object cxGridLevel1: TcxGridLevel
            GridView = cxGridDBTableView1
          end
        end
      end
      object Panel6: TPanel
        Left = 782
        Top = 0
        Width = 397
        Height = 315
        Align = alRight
        BevelOuter = bvNone
        BorderWidth = 10
        Color = clWindow
        TabOrder = 1
        object dxDBGridSN3: TdxDBGridSN
          Left = 10
          Top = 10
          Width = 377
          Height = 295
          Cursor = crHandPoint
          Align = alClient
          TabOrder = 0
          CriteriosPintarCelda = <>
          object cxGridDBTableView2: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = dsTSubElementoRelAyuda
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsData.Editing = False
            OptionsData.Inserting = False
            OptionsView.CellAutoHeight = True
            OptionsView.GroupByBox = False
            OptionsView.Header = False
            object cxGridDBColumn3: TcxGridDBColumn
              DataBinding.FieldName = 'orden'
              Visible = False
              SortIndex = 0
              SortOrder = soAscending
            end
            object cxGridDBColumn4: TcxGridDBColumn
              DataBinding.FieldName = 'desc_sug_ayuda'
              Styles.Content = cxStyle1
              Width = 500
            end
          end
          object cxGridLevel2: TcxGridLevel
            GridView = cxGridDBTableView2
          end
        end
      end
      object Panel7: TPanel
        Left = 295
        Top = 0
        Width = 484
        Height = 315
        Align = alClient
        BorderWidth = 10
        Color = clWindow
        TabOrder = 2
        object snDBMemo2: TsnDBMemo
          Left = 11
          Top = 11
          Align = alClient
          DataBinding.DataField = 'cuerpo'
          DataBinding.DataSource = DSTSubElementoAyuda
          TabOrder = 0
          ReadOnlyAlways = False
          Height = 293
          Width = 462
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TElementoAyuda
        TableName = 'TElementoAyuda'
      end
      item
        DataSet = TSubElementoAyuda
        TableName = 'TSubElementoAyuda'
      end
      item
        DataSet = TElementoRelAyuda
        TableName = 'TElementoRelAyuda'
      end
      item
        DataSet = TSubElementoRelAyuda
        TableName = 'TSubElementoRelAyuda'
      end>
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
      '  operacion.InicioOperacion();'
      '  operacion.setOper('#39'TraerElementoAyuda'#39'); '
      
        '  operacion.AddAtribute('#39'oid'#39',inttostr(variable.getInteger('#39'oid_' +
        'elemento'#39')));'
      '  operacion.execute();'
      'end.')
    OnPublicVariable = <
      item
        VariableName = 'oid_elemento'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  Varios.setImagen('#39'ImageSalir'#39',7);'
          'end.')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  close;'
          'end.')
      end>
    OnClickCellGrid = <
      item
        NombreGrilla = 'dxDBGridSN1'
        Source.Strings = (
          'begin'
          
            '  FormMostrarAyuda.setInteger('#39'oid_elemento'#39',TElementoRelAyuda.F' +
            'ieldName('#39'oid_elemento_ayuda'#39').AsInteger);'
          '  FormMostrarAyuda.Ventana := getVentana();'
          '  FormMostrarAyuda.ShowInVentana();'
          'end.')
      end
      item
        NombreGrilla = 'dxDBGridSN3'
        Source.Strings = (
          'begin  '
          
            '  FormMostrarAyuda.setInteger('#39'oid_elemento'#39',TSubElementoRelAyud' +
            'a.FieldName('#39'oid_elemento_ayuda'#39').AsInteger);'
          '  FormMostrarAyuda.Ventana := getVentana();'
          '  FormMostrarAyuda.ShowInVentana();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object TElementoAyuda: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_elemento'
        DataType = ftInteger
      end
      item
        Name = 'cod_ayuda'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'titulo'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'objetivo'
        DataType = ftString
        Size = 5000
      end
      item
        Name = 'oid_modulo'
        DataType = ftInteger
      end
      item
        Name = 'cod_modulo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'desc_modulo'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'activo'
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
    Left = 136
    Top = 44
    object TElementoAyudaoid_elemento: TIntegerField
      FieldName = 'oid_elemento'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TElementoAyudacod_ayuda: TStringField
      FieldName = 'cod_ayuda'
      Size = 100
    end
    object TElementoAyudatitulo: TStringField
      FieldName = 'titulo'
      Size = 255
    end
    object TElementoAyudaobjetivo: TStringField
      FieldName = 'objetivo'
      Size = 5000
    end
    object TElementoAyudaoid_modulo: TIntegerField
      FieldName = 'oid_modulo'
    end
    object TElementoAyudacod_modulo: TStringField
      FieldName = 'cod_modulo'
      Size = 100
    end
    object TElementoAyudadesc_modulo: TStringField
      FieldName = 'desc_modulo'
      Size = 255
    end
    object TElementoAyudaactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTElementoAyuda: TDataSource
    DataSet = TElementoAyuda
    Left = 168
    Top = 45
  end
  object TSubElementoAyuda: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_subelemento'
        DataType = ftInteger
      end
      item
        Name = 'oid_elemento'
        DataType = ftInteger
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'titulo'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'cuerpo'
        DataType = ftString
        Size = 8000
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_elemento'
    IndexDefs = <
      item
        Name = 'TSubElementoAyudaIndex1'
        Fields = 'oid_elemento'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_elemento'
    MasterSource = DSTElementoAyuda
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 112
    Top = 83
    object TSubElementoAyudaoid_subelemento: TIntegerField
      FieldName = 'oid_subelemento'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TSubElementoAyudaoid_elemento: TIntegerField
      FieldName = 'oid_elemento'
    end
    object TSubElementoAyudaorden: TIntegerField
      FieldName = 'orden'
    end
    object TSubElementoAyudatitulo: TStringField
      FieldName = 'titulo'
      Size = 255
    end
    object TSubElementoAyudacuerpo: TStringField
      FieldName = 'cuerpo'
      Size = 8000
    end
    object TSubElementoAyudaactivo: TBooleanField
      DefaultExpression = 'true'
      FieldName = 'activo'
    end
  end
  object DSTSubElementoAyuda: TDataSource
    DataSet = TSubElementoAyuda
    Left = 144
    Top = 83
  end
  object TElementoRelAyuda: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_ele_rel'
        DataType = ftInteger
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'oid_elemento'
        DataType = ftInteger
      end
      item
        Name = 'oid_sug_ayuda'
        DataType = ftInteger
      end
      item
        Name = 'desc_sug_ayuda'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_elemento'
    IndexDefs = <
      item
        Name = 'TElementoRelAyudaIndex1'
        Fields = 'oid_elemento'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_elemento'
    MasterSource = DSTElementoAyuda
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 208
    Top = 76
    object TElementoRelAyudaoid_ele_rel: TIntegerField
      FieldName = 'oid_ele_rel'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TElementoRelAyudaorden: TIntegerField
      FieldName = 'orden'
    end
    object TElementoRelAyudaoid_elemento: TIntegerField
      FieldName = 'oid_elemento'
    end
    object TElementoRelAyudaoid_sug_ayuda: TIntegerField
      FieldName = 'oid_sug_ayuda'
    end
    object TElementoRelAyudacod_sug_ayuda: TStringField
      FieldName = 'cod_sug_ayuda'
      Size = 50
    end
    object TElementoRelAyudadesc_sug_ayuda: TStringField
      FieldName = 'desc_sug_ayuda'
      Size = 255
    end
    object TElementoRelAyudaactivo: TBooleanField
      FieldName = 'activo'
    end
    object TElementoRelAyudaoid_elemento_ayuda: TIntegerField
      FieldName = 'oid_elemento_ayuda'
    end
  end
  object DSTElementoRelAyuda: TDataSource
    DataSet = TElementoRelAyuda
    Left = 240
    Top = 76
  end
  object TSubElementoRelAyuda: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_sub_ele_rel'
        DataType = ftInteger
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'oid_subelemento'
        DataType = ftInteger
      end
      item
        Name = 'oid_sug_ayuda'
        DataType = ftInteger
      end
      item
        Name = 'desc_sug_ayuda'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_subelemento'
    IndexDefs = <
      item
        Name = 'TSubElementoRelAyudaIndex1'
        Fields = 'oid_subelemento'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_subelemento'
    MasterSource = DSTSubElementoAyuda
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 64
    Top = 116
    object TSubElementoRelAyudaoid_sub_ele_rel: TIntegerField
      FieldName = 'oid_sub_ele_rel'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TSubElementoRelAyudaorden: TIntegerField
      FieldName = 'orden'
    end
    object TSubElementoRelAyudaoid_subelemento: TIntegerField
      FieldName = 'oid_subelemento'
    end
    object TSubElementoRelAyudaoid_sug_ayuda: TIntegerField
      FieldName = 'oid_sug_ayuda'
    end
    object TSubElementoRelAyudacod_sug_ayuda: TStringField
      FieldName = 'cod_sug_ayuda'
      Size = 50
    end
    object TSubElementoRelAyudadesc_sug_ayuda: TStringField
      FieldName = 'desc_sug_ayuda'
      Size = 255
    end
    object TSubElementoRelAyudaactivo: TBooleanField
      FieldName = 'activo'
    end
    object TSubElementoRelAyudaoid_elemento_ayuda: TIntegerField
      FieldName = 'oid_elemento_ayuda'
    end
  end
  object dsTSubElementoRelAyuda: TDataSource
    DataSet = TSubElementoRelAyuda
    Left = 96
    Top = 116
  end
  object cxStyleRepository1: TcxStyleRepository
    Left = 8
    Top = 88
    PixelsPerInch = 96
    object cxStyle1: TcxStyle
      AssignedValues = [svColor, svFont, svTextColor]
      Color = clWindow
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clNavy
      Font.Height = -19
      Font.Name = 'Verdana'
      Font.Style = [fsBold]
      TextColor = clNavy
    end
  end
  object FormMostrarAyuda: TFormulario
    AutoLiberar = True
    Nombre = 'TFMostrarAyuda'
    CreateAlwaysANewForm = True
    Left = 128
    Top = 403
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 136
    Top = 180
  end
end
