inherited FProcPlanifCacheo: TFProcPlanifCacheo
  Left = 76
  Top = 136
  Width = 833
  Height = 520
  Caption = 'Proceso Planificaci'#243'n de Cacheos'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 825
    Height = 41
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object ImageSalir: TImage
      Tag = 7
      Left = 18
      Top = 5
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 41
    Width = 825
    Height = 445
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object snLabel1: TsnLabel
      Left = 80
      Top = 56
      Width = 80
      Height = 16
      Caption = 'Fecha desde'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel2: TsnLabel
      Left = 80
      Top = 16
      Width = 409
      Height = 16
      Caption = 
        'Realizar planificaci'#243'n de cacheos para el siguiente rango de Fec' +
        'has'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clNavy
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel3: TsnLabel
      Left = 360
      Top = 56
      Width = 74
      Height = 16
      Caption = 'Fecha hasta'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel4: TsnLabel
      Left = 80
      Top = 96
      Width = 107
      Height = 16
      Caption = 'Tipo Planificaci'#243'n'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 208
      Top = 52
      DataBinding.DataField = 'fec_desde'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      ReadOnlyAlways = False
      Width = 121
    end
    object snDBDateEdit2: TsnDBDateEdit
      Left = 448
      Top = 52
      DataBinding.DataField = 'fec_hasta'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 1
      ReadOnlyAlways = False
      Width = 121
    end
    object snDBLookup1: TsnDBLookup
      Left = 208
      Top = 92
      DataBinding.DataField = 'tipo'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.KeyFieldNames = 'codigo'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSTipoPlanif
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 2
      Width = 241
    end
    object BotonEjecutar: TsnButton
      Left = 432
      Top = 136
      Width = 169
      Height = 25
      Caption = 'Ejecutar proceso'
      TabOrder = 3
      LookAndFeel.Kind = lfOffice11
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TTipoPlanif
        TableName = 'TTipoPlanif'
      end>
    Top = 152
  end
  inherited Operacion: TOperacion
    Top = 152
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Top = 152
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Top = 152
  end
  inherited DriverEvent: TDriverEvent
    OnNuevoRegistro = <
      item
        TableName = 'TInput'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'tipo'#39').AsString := '#39'PLANIF'#39';'
          '  DataSet.FieldName('#39'fec_desde'#39').Value := varios.getFecha();'
          '  DataSet.FieldName('#39'fec_hasta'#39').Value := varios.getFecha();'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  CargarTiposPlanif();'
          '  '
          '  TInput.Close;'
          '  TInput.Open;'
          '  TInput.AppendRecord;'
          ''
          '   varios.setImagen('#39'ImageSalir'#39',7); '
          ''
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure CargarTiposPlanif();'
          'begin'
          '  TTipoPlanif.Close;'
          '  TTipoPlanif.Open;'
          '  TTipoPlanif.AppendRecord;'
          '  TTipoPlanif.FieldName('#39'codigo'#39').AsString := '#39'PLANIF'#39';'
          
            '  TTipoPlanif.FieldName('#39'descripcion'#39').AsString := '#39'Planificaci'#243 +
            'n de Cacheos'#39';'
          '  TTipoPlanif.PostRecord;'
          '  TTipoPlanif.AppendRecord;'
          '  TTipoPlanif.FieldName('#39'codigo'#39').AsString := '#39'ANU'#39';'
          
            '  TTipoPlanif.FieldName('#39'descripcion'#39').AsString := '#39'Anulaci'#243'n de' +
            ' Cacheos'#39';'
          '  TTipoPlanif.PostRecord;'
          'end;')
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
        ButtonName = 'BotonEjecutar'
        Source.Strings = (
          'begin'
          ''
          '  TInput.PostRecord;'
          ''
          '  if (TInput.FieldName('#39'fec_desde'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha d' +
            'esde'#39');'
          ''
          '  if (TInput.FieldName('#39'fec_hasta'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha h' +
            'asta'#39');'
          ''
          '  if (TInput.FieldName('#39'tipo'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el tipo de' +
            ' planificaci'#243'n'#39');'
          ''
          
            '  if (mensaje.question('#39'Desea ejecutar el proceso?'#39')=false) then' +
            ' exit;'
          ''
          ' operacion.InicioOperacion();'
          ' operacion.setOper('#39'SaveProcPlanifCacheo'#39');'
          ' operacion.AddDataSet(TInput.getDataSet()); '
          ' operacion.execute(); '
          ''
          ' mensaje.information('#39'Proceso realizado con '#233'xito'#39');'
          ''
          'close;'
          ''
          'end.')
      end>
    Left = 384
    Top = 203
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TPathHelp: TsnTable
    Left = 528
    Top = 277
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 376
    Top = 9
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
    Left = 40
    Top = 105
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object TInputtipo: TStringField
      FieldName = 'tipo'
      Size = 10
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 72
    Top = 105
  end
  object TTipoPlanif: TsnTable
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
    Top = 225
    object TTipoPlanifcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTipoPlanifdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTipoPlanif: TDataSource
    DataSet = TTipoPlanif
    Left = 216
    Top = 225
  end
end
