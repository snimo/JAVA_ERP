inherited FImpMasArchPOSNETS: TFImpMasArchPOSNETS
  Left = 83
  Top = 99
  Width = 837
  BorderIcons = []
  Caption = 'Importaci'#243'n Masiva de archivos de POSNETS'
  DragKind = dkDrag
  DragMode = dmManual
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 829
    Height = 33
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object snLabel1: TsnLabel
      Left = 8
      Top = 8
      Width = 404
      Height = 16
      Caption = 'Resultado de la Importaci'#243'n Masiva de Archivos de POSNETS'
      Font.Charset = ANSI_CHARSET
      Font.Color = clNavy
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
      ParentFont = False
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 440
    Width = 829
    Height = 41
    Align = alBottom
    Color = clWindow
    TabOrder = 1
    object BotonSalir: TsnButton
      Left = 705
      Top = 6
      Width = 99
      Height = 29
      Cursor = crHandPoint
      Caption = '&Salir'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 0
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 33
    Width = 829
    Height = 407
    Align = alClient
    Color = clWindow
    TabOrder = 2
    object dxDBGridSN1: TdxDBGridSN
      Left = 1
      Top = 1
      Width = 827
      Height = 405
      Align = alClient
      TabOrder = 0
      CriteriosPintarCelda = <
        item
          TipoPintadaCelda = tpcTodasLasColumnas
          FieldName1 = 'color_reg'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 1
          TipoCondFiltro2 = tcfIgual
          Color = clRed
        end>
      object dxDBGridSN1DBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = dsTResImpAutLOTEIP
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsData.CancelOnExit = False
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsView.CellAutoHeight = True
        object dxDBGridSN1DBTableView1unidad_negocio: TcxGridDBColumn
          Caption = 'Unidad Negocio'
          DataBinding.FieldName = 'unidad_negocio'
          Visible = False
          GroupIndex = 0
          HeaderAlignmentHorz = taCenter
          Width = 30
        end
        object dxDBGridSN1DBTableView1archivo: TcxGridDBColumn
          DataBinding.FieldName = 'archivo'
          HeaderAlignmentHorz = taCenter
          HeaderAlignmentVert = vaCenter
          Width = 144
        end
        object dxDBGridSN1DBTableView1path: TcxGridDBColumn
          Caption = 'Path'
          DataBinding.FieldName = 'path'
          HeaderAlignmentHorz = taCenter
          Width = 201
        end
        object dxDBGridSN1DBTableView1cant_reg_imp: TcxGridDBColumn
          Caption = 'Cant. Reg.'
          DataBinding.FieldName = 'cant_reg_imp'
          HeaderAlignmentHorz = taCenter
          Width = 70
        end
        object dxDBGridSN1DBTableView1errores: TcxGridDBColumn
          Caption = 'Estado'
          DataBinding.FieldName = 'errores'
          HeaderAlignmentHorz = taCenter
          Width = 332
        end
        object dxDBGridSN1DBTableView1color_reg: TcxGridDBColumn
          DataBinding.FieldName = 'color_reg'
          Visible = False
          Width = 30
        end
        object dxDBGridSN1DBTableView1Column1: TcxGridDBColumn
          Caption = 'Terminal'
          DataBinding.FieldName = 'terminal'
          Visible = False
          GroupIndex = 1
          HeaderAlignmentHorz = taCenter
        end
      end
      object dxDBGridSN1Level1: TcxGridLevel
        GridView = dxDBGridSN1DBTableView1
      end
    end
  end
  inherited DriverABM: TDriverABM
    Left = 48
    Top = 192
  end
  inherited Operacion: TOperacion
    Left = 80
    Top = 192
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 112
    Top = 192
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 144
    Top = 192
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      
        '  TResImpAutLOTEIP.LoadDataSet(variable.getTable('#39'TResImpAutLOTE' +
        'IP'#39'));'
      '  end.')
    OnPublicVariable = <
      item
        VariableName = 'TResImpAutLOTEIP'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  dxDBGridSN1.ActivarEventoPintarCeldas();'
          'end.')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonSalir'
        Source.Strings = (
          'begin'
          '  close();'
          'end.')
      end>
    Left = 176
    Top = 195
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object TResImpAutLOTEIP: TsnTable
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
    Left = 110
    Top = 120
    object TResImpAutLOTEIPunidad_negocio: TStringField
      FieldName = 'unidad_negocio'
      Size = 255
    end
    object TResImpAutLOTEIPterminal: TStringField
      FieldName = 'terminal'
      Size = 255
    end
    object TResImpAutLOTEIPpath: TStringField
      FieldName = 'path'
      Size = 255
    end
    object TResImpAutLOTEIParchivo: TStringField
      FieldName = 'archivo'
      Size = 255
    end
    object TResImpAutLOTEIPcant_reg_imp: TIntegerField
      FieldName = 'cant_reg_imp'
    end
    object TResImpAutLOTEIPerrores: TStringField
      FieldName = 'errores'
      Size = 255
    end
    object TResImpAutLOTEIPcolor_reg: TIntegerField
      FieldName = 'color_reg'
    end
  end
  object dsTResImpAutLOTEIP: TDataSource
    DataSet = TResImpAutLOTEIP
    Left = 144
    Top = 123
  end
end
