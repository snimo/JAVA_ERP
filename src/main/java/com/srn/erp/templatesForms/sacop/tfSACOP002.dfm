inherited FEstadSACOP: TFEstadSACOP
  Left = 81
  Top = 179
  Width = 967
  Height = 548
  Caption = 'Estadistica del Comedor'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 951
    Height = 41
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 24
      Top = 11
      Width = 80
      Height = 19
      Caption = 'Fecha desde:'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'Times New Roman'
      Font.Style = []
      ParentFont = False
    end
    object Label2: TLabel
      Left = 320
      Top = 11
      Width = 75
      Height = 19
      Caption = 'Fecha hasta:'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'Times New Roman'
      Font.Style = []
      ParentFont = False
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 112
      Top = 7
      DataBinding.DataField = 'fec_desde'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = ANSI_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'Times New Roman'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      ReadOnlyAlways = False
      Width = 121
    end
    object snDBDateEdit2: TsnDBDateEdit
      Left = 400
      Top = 7
      DataBinding.DataField = 'fec_hasta'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = ANSI_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'Times New Roman'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 1
      ReadOnlyAlways = False
      Width = 121
    end
    object BotonConsultar: TsnButton
      Left = 568
      Top = 5
      Width = 113
      Height = 30
      Caption = 'Consultar'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'Times New Roman'
      Font.Style = []
      ParentFont = False
      TabOrder = 2
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 41
    Width = 951
    Height = 469
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object snPivotGrid1: TsnPivotGrid
      Left = 1
      Top = 1
      Width = 949
      Height = 467
      Align = alClient
      DataSource = DSTEstadisticaRaciones
      Groups = <>
      TabOrder = 0
      object snPivotGrid1Field1: TcxDBPivotGridField
        Area = faColumn
        AreaIndex = 0
        IsCaptionAssigned = True
        Caption = 'A'#241'o'
        DataBinding.FieldName = 'ANIO'
        Visible = True
      end
      object snPivotGrid1Field2: TcxDBPivotGridField
        Area = faData
        AreaIndex = 0
        IsCaptionAssigned = True
        Caption = 'Cantidad'
        DataBinding.FieldName = 'CANTIDAD'
        DisplayFormat = '###,###,###,###'
        Visible = True
      end
      object snPivotGrid1Field3: TcxDBPivotGridField
        AreaIndex = 0
        IsCaptionAssigned = True
        Caption = 'D'#237'a'
        DataBinding.FieldName = 'DIA'
        Visible = True
      end
      object snPivotGrid1Field4: TcxDBPivotGridField
        AreaIndex = 1
        IsCaptionAssigned = True
        Caption = 'Empresa'
        DataBinding.FieldName = 'EMPRESA'
        Visible = True
      end
      object snPivotGrid1Field5: TcxDBPivotGridField
        AreaIndex = 3
        IsCaptionAssigned = True
        Caption = 'Fecha'
        DataBinding.FieldName = 'FECHA'
        Visible = True
      end
      object snPivotGrid1Field6: TcxDBPivotGridField
        Area = faColumn
        AreaIndex = 1
        IsCaptionAssigned = True
        Caption = 'Mes'
        DataBinding.FieldName = 'MES'
        Visible = True
      end
      object snPivotGrid1Field7: TcxDBPivotGridField
        AreaIndex = 2
        IsCaptionAssigned = True
        Caption = 'Cliente'
        DataBinding.FieldName = 'TIPO'
        Visible = True
      end
      object snPivotGrid1Field8: TcxDBPivotGridField
        Area = faRow
        AreaIndex = 0
        IsCaptionAssigned = True
        Caption = 'Raci'#243'n'
        DataBinding.FieldName = 'TIPO_RACION'
        Visible = True
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TEstadisticaRaciones
        TableName = 'TEstadisticaRaciones'
      end>
  end
  inherited TOidObjSave: TsnTable
    Left = 624
    Top = 80
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
      '  snDBDateEdit1.setFoco;'
      'end.')
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TInput.Close;'
          '  TInput.Open;'
          '  TInput.AppendRecord;'
          'end.')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonConsultar'
        Source.Strings = (
          'begin'
          '  Tinput.PostRecord;'
          ''
          '  if (TInput.FieldName('#39'fec_desde'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha d' +
            'esde'#39');'
          ''
          '  if (TInput.FieldName('#39'fec_hasta'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha h' +
            'asta'#39');'
          ''
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerEstadisticaRaciones'#39');'
          
            '  operacion.AddAtribute('#39'fecha_desde'#39',TInput.FieldName('#39'fec_desd' +
            'e'#39').AsString);'
          
            '  operacion.AddAtribute('#39'fecha_hasta'#39',Tinput.FieldName('#39'fec_hast' +
            'a'#39').AsString);'
          '  operacion.execute();'
          ''
          '  mensaje.information('#39'Consulta finalizada!!!'#39');'
          ''
          ''
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TPathHelp: TsnTable
    Top = 365
  end
  object TEstadisticaRaciones: TsnTable
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
    Left = 96
    Top = 193
    object TEstadisticaRacionesEMPRESA: TStringField
      FieldName = 'EMPRESA'
      Size = 100
    end
    object TEstadisticaRacionesFECHA: TDateField
      FieldName = 'FECHA'
    end
    object TEstadisticaRacionesTIPO_RACION: TStringField
      FieldName = 'TIPO_RACION'
      Size = 50
    end
    object TEstadisticaRacionesTIPO: TStringField
      FieldName = 'TIPO'
      Size = 50
    end
    object TEstadisticaRacionesCANTIDAD: TIntegerField
      FieldName = 'CANTIDAD'
      DisplayFormat = '###,###,###,###'
    end
    object TEstadisticaRacionesANIO: TIntegerField
      FieldName = 'ANIO'
    end
    object TEstadisticaRacionesMES: TIntegerField
      FieldName = 'MES'
    end
    object TEstadisticaRacionesDIA: TStringField
      FieldName = 'DIA'
      Size = 2
    end
  end
  object DSTEstadisticaRaciones: TDataSource
    DataSet = TEstadisticaRaciones
    Left = 128
    Top = 193
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
    Left = 360
    Top = 241
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 392
    Top = 241
  end
end
