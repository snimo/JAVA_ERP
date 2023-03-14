inherited FConsDiasRempTrans: TFConsDiasRempTrans
  Left = 192
  Top = 271
  Width = 854
  Height = 614
  Caption = 'Consulta D'#237'as Remplazos Transitorios'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 838
    Height = 75
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object ImageSalir: TImage
      Tag = 7
      Left = 694
      Top = 8
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object Label1: TLabel
      Left = 24
      Top = 16
      Width = 95
      Height = 16
      Caption = 'Per'#237'odo Desde:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label2: TLabel
      Left = 264
      Top = 16
      Width = 90
      Height = 16
      Caption = 'Per'#237'odo Hasta:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel1: TsnLabel
      Left = 24
      Top = 48
      Width = 374
      Height = 16
      Caption = 'D'#237'as acumulados reemplazos transitorios por per'#237'odo mensual'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clBlue
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object BotonConsultar: TsnButton
      Left = 514
      Top = 8
      Width = 120
      Height = 32
      Cursor = crHandPoint
      Caption = 'Consultar'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 0
      LookAndFeel.Kind = lfOffice11
    end
    object snDBEdit4: TsnDBEdit
      Left = 123
      Top = 12
      DataBinding.DataField = 'periodo_desde'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.Alignment.Horz = taLeftJustify
      Properties.ReadOnly = False
      Style.Font.Charset = ANSI_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'Verdana'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 1
      Width = 122
    end
    object snDBEdit1: TsnDBEdit
      Left = 363
      Top = 12
      DataBinding.DataField = 'periodo_hasta'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.Alignment.Horz = taLeftJustify
      Properties.ReadOnly = False
      Style.Font.Charset = ANSI_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'Verdana'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 2
      Width = 122
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 75
    Width = 838
    Height = 501
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
    object snPivotGrid1: TsnPivotGrid
      Left = 0
      Top = 0
      Width = 838
      Height = 501
      Align = alClient
      BevelInner = bvNone
      BevelOuter = bvNone
      BorderStyle = cxcbsNone
      DataSource = DSRemplazos
      Groups = <>
      OptionsView.ColumnGrandTotals = False
      OptionsView.GrandTotalWidth = 107
      OptionsView.RowTotals = False
      TabOrder = 0
      object snPivotGrid1Field1: TcxDBPivotGridField
        Area = faRow
        AreaIndex = 1
        IsCaptionAssigned = True
        Caption = 'Legajo'
        DataBinding.FieldName = 'legajo'
        TotalsVisibility = tvNone
        Visible = True
      end
      object snPivotGrid1Field2: TcxDBPivotGridField
        Area = faRow
        AreaIndex = 0
        IsCaptionAssigned = True
        Caption = 'Apellido y Nombre'
        DataBinding.FieldName = 'ape_y_nom'
        TotalsVisibility = tvNone
        Visible = True
      end
      object snPivotGrid1Field3: TcxDBPivotGridField
        Area = faColumn
        AreaIndex = 0
        IsCaptionAssigned = True
        Caption = 'Per'#237'odo'
        DataBinding.FieldName = 'periodo'
        TotalsVisibility = tvNone
        Visible = True
      end
      object snPivotGrid1Field4: TcxDBPivotGridField
        Area = faData
        AreaIndex = 0
        IsCaptionAssigned = True
        Caption = 'D'#237'as'
        DataBinding.FieldName = 'dias'
        DisplayFormat = '###,###,###,###.##'
        SummaryType = stMax
        TotalsVisibility = tvNone
        Visible = True
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TPeriodo
        TableName = 'TPeriodo'
      end
      item
        DataSet = TRemplazos
        TableName = 'TRemplazos'
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
      '  snDBEdit4.setFoco();'
      'end.')
    OnValidate = <
      item
        TableName = 'TInput'
        FieldName = 'periodo_desde'
        Source.Strings = (
          'begin'
          'end.')
      end
      item
        TableName = 'TInput'
        FieldName = 'periodo_hasta'
        Source.Strings = (
          'begin'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  varios.setImagen('#39'ImageSalir'#39',7);'
          '  TInput.Close();'
          '  TInput.Open();'
          '  TInput.AppendRecord();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure ValidarConsulta();'
          'begin'
          ''
          '  TInput.PostRecord();'
          ''
          '  if (TInput.FieldName('#39'periodo_desde'#39').AsString ='#39#39')'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el per'#237'od' +
            'o desde'#39'); '
          ''
          '  if (TInput.FieldName('#39'periodo_hasta'#39').AsString ='#39#39')'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el per'#237'od' +
            'o hasta'#39'); '
          'end;'
          ''
          ''
          'procedure ejecutarConsulta();'
          'begin'
          ''
          '   ValidarConsulta();'
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'TraerConsDiasEmpTrans'#39');'
          
            '   operacion.AddAtribute('#39'periodo_desde'#39', TInput.FieldName('#39'peri' +
            'odo_desde'#39').AsString);'
          
            '   operacion.AddAtribute('#39'periodo_hasta'#39', TInput.FieldName('#39'peri' +
            'odo_hasta'#39').AsString);'
          '   operacion.execute(); '
          ''
          '   if (TRemplazos.IsEmpty())'
          
            '       then mensaje.information('#39'No se encontraron reemplazos tr' +
            'ansitorios.'#39');'
          ''
          'end;'
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  close();'
          'end.')
      end
      item
        ButtonName = 'BotonConsultar'
        Source.Strings = (
          'begin'
          '  ejecutarConsulta();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 536
    Top = 232
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 688
    Top = 76
  end
  object TRemplazos: TsnTable
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
    Left = 392
    Top = 231
    object TRemplazoslegajo: TStringField
      FieldName = 'legajo'
      Size = 50
    end
    object TRemplazosape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TRemplazosperiodo: TStringField
      FieldName = 'periodo'
      Size = 7
    end
    object TRemplazosdias: TFloatField
      FieldName = 'dias'
      DisplayFormat = '###,###,###,###.##'
    end
  end
  object DSRemplazos: TDataSource
    DataSet = TRemplazos
    Left = 432
    Top = 231
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
    Left = 392
    Top = 295
    object TInputperiodo_desde: TStringField
      FieldName = 'periodo_desde'
      Size = 7
    end
    object TInputperiodo_hasta: TStringField
      FieldName = 'periodo_hasta'
      Size = 7
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 432
    Top = 295
  end
  object TPeriodo: TsnTable
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
    Left = 120
    Top = 231
    object TPeriodooid_peri: TIntegerField
      FieldName = 'oid_peri'
    end
    object TPeriodocodigo: TStringField
      FieldName = 'codigo'
      Size = 15
    end
    object TPeriododescripcion: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
    object TPeriodofecha_desde: TStringField
      FieldName = 'fecha_desde'
      Size = 10
    end
    object TPeriodofecha_hasta: TStringField
      FieldName = 'fecha_hasta'
      Size = 10
    end
    object TPeriodotipo: TStringField
      FieldName = 'tipo'
    end
    object TPeriodoactivo: TBooleanField
      FieldName = 'activo'
    end
  end
end
