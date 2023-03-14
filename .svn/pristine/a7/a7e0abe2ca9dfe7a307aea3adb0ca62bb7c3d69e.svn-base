inherited FGenAsiCobTarj: TFGenAsiCobTarj
  Left = 206
  Top = 127
  Width = 548
  Height = 406
  BorderIcons = []
  Caption = 'Generar Asiento de Cobranza'
  DragKind = dkDrag
  DragMode = dmManual
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 532
    Height = 75
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object snLabel1: TsnLabel
      Left = 9
      Top = 7
      Width = 209
      Height = 30
      Alignment = taCenter
      AutoSize = False
      Caption = 'Asiento de Cobranza'
      Color = 11796479
      Font.Charset = ANSI_CHARSET
      Font.Color = clNavy
      Font.Height = -19
      Font.Name = 'Palatino Linotype'
      Font.Style = [fsBold, fsItalic]
      ParentColor = False
      ParentFont = False
    end
    object Label1: TLabel
      Left = 16
      Top = 50
      Width = 30
      Height = 13
      Caption = 'Fecha'
    end
    object Label2: TLabel
      Left = 168
      Top = 50
      Width = 53
      Height = 13
      Caption = 'Comentario'
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 56
      Top = 46
      DataBinding.DataField = 'fecha'
      DataBinding.DataSource = DSAsientoCab
      TabOrder = 0
      ReadOnlyAlways = False
      Width = 97
    end
    object snDBEdit1: TsnDBEdit
      Left = 232
      Top = 46
      DataBinding.DataField = 'comentario'
      DataBinding.DataSource = DSAsientoCab
      Properties.MaxLength = 100
      TabOrder = 1
      Width = 265
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 327
    Width = 532
    Height = 41
    Align = alBottom
    Color = clWindow
    TabOrder = 1
    object BotonSalir: TsnButton
      Left = 24
      Top = 4
      Width = 75
      Height = 31
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
    object BotonGenerarAsiento: TsnButton
      Left = 336
      Top = 5
      Width = 161
      Height = 31
      Cursor = crHandPoint
      Caption = '&Generar Asiento'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 1
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 75
    Width = 532
    Height = 252
    Align = alClient
    Color = clWindow
    TabOrder = 2
    object dxDBGridSN1: TdxDBGridSN
      Left = 1
      Top = 1
      Width = 530
      Height = 250
      Align = alClient
      TabOrder = 0
      CriteriosPintarCelda = <>
      object dxDBGridSN1DBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSAsiento
        DataController.Summary.DefaultGroupSummaryItems = <
          item
            Kind = skSum
            Position = spFooter
            Column = dxDBGridSN1DBTableView1haber
          end
          item
            Format = '###,###,###,##0.00'
            Column = dxDBGridSN1DBTableView1haber
          end
          item
            Format = '###,###,###,##0.00'
            Position = spFooter
            Column = dxDBGridSN1DBTableView1debe
          end>
        DataController.Summary.FooterSummaryItems = <
          item
            Kind = skSum
            Column = dxDBGridSN1DBTableView1debe
          end
          item
            Kind = skSum
            Column = dxDBGridSN1DBTableView1haber
          end>
        DataController.Summary.SummaryGroups = <>
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsView.Footer = True
        OptionsView.GroupByBox = False
        object dxDBGridSN1DBTableView1orden: TcxGridDBColumn
          DataBinding.FieldName = 'orden'
          Visible = False
        end
        object dxDBGridSN1DBTableView1cuenta: TcxGridDBColumn
          Caption = 'Cuenta'
          DataBinding.FieldName = 'cuenta'
          HeaderAlignmentHorz = taCenter
          Width = 200
        end
        object dxDBGridSN1DBTableView1compo1: TcxGridDBColumn
          Caption = 'C.1.'
          DataBinding.FieldName = 'compo1'
          HeaderAlignmentHorz = taCenter
          Width = 75
        end
        object dxDBGridSN1DBTableView1compo2: TcxGridDBColumn
          Caption = 'C.2.'
          DataBinding.FieldName = 'compo2'
          HeaderAlignmentHorz = taCenter
          Width = 75
        end
        object dxDBGridSN1DBTableView1debe: TcxGridDBColumn
          Caption = 'Debe'
          DataBinding.FieldName = 'debe'
          HeaderAlignmentHorz = taCenter
          SortIndex = 0
          SortOrder = soDescending
          Width = 75
        end
        object dxDBGridSN1DBTableView1haber: TcxGridDBColumn
          Caption = 'Haber'
          DataBinding.FieldName = 'haber'
          HeaderAlignmentHorz = taCenter
          Width = 75
        end
      end
      object dxDBGridSN1Level1: TcxGridLevel
        GridView = dxDBGridSN1DBTableView1
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TDetAsiCobAGenerar
        TableName = 'TDetAsiCobAGenerar'
      end
      item
        DataSet = TAsiento
        TableName = 'TAsiento'
      end
      item
        DataSet = TAsientoCab
        TableName = 'TAsientoCab'
      end
      item
        DataSet = TAsiCobGenerado
        TableName = 'TAsiCobGenerado'
      end>
    Left = 352
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 392
    Top = 16
  end
  inherited TOidObjSave: TsnTable
    Left = 264
    Top = 16
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 432
    Top = 16
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 472
    Top = 16
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      '  proponerAsiCobTarj();'
      '  Cancelo();'
      
        '  dxDBGridSN1.setCaptionColumn('#39'compo1'#39',Varios.getValorString('#39'L' +
        'ABEL_COMP1_CONC_TARJ'#39'));'
      
        '  dxDBGridSN1.setCaptionColumn('#39'compo2'#39',Varios.getValorString('#39'L' +
        'ABEL_COMP2_CONC_TARJ'#39'));'
      'end.')
    OnPublicVariable = <
      item
        VariableName = 'oid_empresa'
      end
      item
        VariableName = 'TAcepto'
      end
      item
        VariableName = 'mis_marcados'
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure proponerAsiCobTarj();'
          'begin'
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'ProponerAsiCobTarj'#39');'
          
            '   operacion.AddAtribute('#39'oid_empresa'#39',IntToStr(variable.getInte' +
            'ger('#39'oid_empresa'#39')));'
          
            '   operacion.AddAtribute('#39'mis_marcados'#39',variable.getString('#39'mis_' +
            'marcados'#39'));'
          '   operacion.execute();'
          'end;'
          ''
          'procedure Acepto();'
          'begin'
          '  TAcepto.Close;'
          '  TAcepto.Open;'
          '  TAcepto.AppendRecord;'
          '  TAcepto.FieldName('#39'si'#39').AsBoolean := true;'
          '  TAcepto.PostRecord;'
          'end;'
          ''
          'procedure Cancelo();'
          'begin'
          '  TAcepto.Close;'
          '  TAcepto.Open;'
          '  TAcepto.AppendRecord;'
          '  TAcepto.FieldName('#39'si'#39').AsBoolean := false;'
          '  TAcepto.PostRecord;'
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonSalir'
        Source.Strings = (
          'begin'
          '  Cancelo();'
          '  close();'
          'end.')
      end
      item
        ButtonName = 'BotonGenerarAsiento'
        Source.Strings = (
          'begin'
          ''
          
            '  if (mensaje.question('#39'Confirma generaci'#243'n de Asiento?'#39')=false)' +
            ' then exit;'
          ''
          '  TAsiCobGenerado.Close;'
          '  TAsiCobGenerado.Open;'
          ''
          '  TAsientoCab.PostRecord;'
          '  TDetAsiCobAGenerar.PostRecord;'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'GenerarAsientoCobTarj'#39');'
          
            '  operacion.AddAtribute('#39'oid_empresa'#39',IntToStr(variable.getInteg' +
            'er('#39'oid_empresa'#39')));'
          
            '  operacion.AddAtribute('#39'fecha'#39', TAsientoCab.FieldName('#39'fecha'#39').' +
            'AsString);'
          
            '  operacion.AddAtribute('#39'comentario'#39', TAsientoCab.FieldName('#39'com' +
            'entario'#39').AsString);'
          '  operacion.AddDataSet(TDetAsiCobAGenerar.getDataSet()); '
          '  operacion.execute();  '
          ''
          '  if (not TAsiCobGenerado.IsEmpty())'
          
            '     then mensaje.information('#39'Se gener'#243' el asiento de cobranza ' +
            #39'+TAsiCobGenerado.FieldName('#39'referencia'#39').AsString);'
          ''
          '  Acepto();'
          '  close;'
          'end.')
      end>
    Left = 312
    Top = 19
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 48
    Top = 160
  end
  object TAsiento: TsnTable
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
    Left = 192
    Top = 181
    object TAsientoorden: TIntegerField
      FieldName = 'orden'
    end
    object TAsientocuenta: TStringField
      FieldName = 'cuenta'
      Size = 50
    end
    object TAsientocompo1: TStringField
      FieldName = 'compo1'
      Size = 50
    end
    object TAsientocompo2: TStringField
      FieldName = 'compo2'
      Size = 50
    end
    object TAsientodebe: TCurrencyField
      FieldName = 'debe'
      DisplayFormat = '###,###,###,###,###.##'
    end
    object TAsientohaber: TCurrencyField
      FieldName = 'haber'
      DisplayFormat = '###,###,###,###,###.##'
    end
  end
  object DSAsiento: TDataSource
    DataSet = TAsiento
    Left = 224
    Top = 181
  end
  object TDetAsiCobAGenerar: TsnTable
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
    Left = 248
    Top = 117
    object TDetAsiCobAGeneraroid_arch_lote_det: TIntegerField
      FieldName = 'oid_arch_lote_det'
    end
  end
  object TAcepto: TsnTable
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
    Left = 248
    Top = 245
    object TAceptosi: TBooleanField
      FieldName = 'si'
    end
  end
  object TAsientoCab: TsnTable
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
    Left = 192
    Top = 136
    object TAsientoCabfecha: TDateField
      FieldName = 'fecha'
    end
    object TAsientoCabcomentario: TStringField
      FieldName = 'comentario'
      Size = 100
    end
  end
  object DSAsientoCab: TDataSource
    DataSet = TAsientoCab
    Left = 224
    Top = 136
  end
  object TAsiCobGenerado: TsnTable
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
    Left = 472
    Top = 48
    object TAsiCobGeneradoreferencia: TStringField
      FieldName = 'referencia'
      Size = 255
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 406
    Top = 113
  end
end
