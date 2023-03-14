inherited FHelpLiqTar: TFHelpLiqTar
  Left = 136
  Top = 131
  Width = 772
  Height = 508
  BorderIcons = [biSystemMenu]
  Caption = 'Liquidaci'#243'n de Tarjetas'
  DragKind = dkDrag
  DragMode = dmManual
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  inherited PanelCabecera: TPanel
    Width = 764
    Height = 103
    object Label4: TLabel [0]
      Left = 16
      Top = 16
      Width = 54
      Height = 13
      Caption = 'Nro. Desde'
    end
    object Label5: TLabel [1]
      Left = 280
      Top = 16
      Width = 51
      Height = 13
      Caption = 'Nro. Hasta'
    end
    object Label8: TLabel [2]
      Left = 280
      Top = 48
      Width = 61
      Height = 13
      Caption = 'Fecha Hasta'
    end
    object Label6: TLabel [3]
      Left = 16
      Top = 48
      Width = 64
      Height = 13
      Caption = 'Fecha Desde'
    end
    object Label9: TLabel [4]
      Left = 16
      Top = 80
      Width = 46
      Height = 13
      Caption = 'Concepto'
    end
    inherited botonBuscar: TsnButton
      Left = 568
      Top = 73
      Hint = '<F5> Buscar Clientes'
    end
    object DBNroDesde: TsnDBMaskEdit
      Left = 92
      Top = 11
      DataBinding.DataField = 'nro_ext_desde'
      DataBinding.DataSource = DSInput
      TabOrder = 1
      Width = 157
    end
    object snDBMaskEdit2: TsnDBMaskEdit
      Left = 356
      Top = 11
      DataBinding.DataField = 'nro_ext_hasta'
      DataBinding.DataSource = DSInput
      TabOrder = 2
      Width = 157
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 92
      Top = 44
      DataBinding.DataField = 'fec_desde'
      DataBinding.DataSource = DSInput
      TabOrder = 3
      ReadOnlyAlways = False
      Width = 119
    end
    object snDBDateEdit2: TsnDBDateEdit
      Left = 356
      Top = 43
      DataBinding.DataField = 'fec_hasta'
      DataBinding.DataSource = DSInput
      TabOrder = 4
      ReadOnlyAlways = False
      Width = 119
    end
    object snDBLookup1: TsnDBLookup
      Left = 93
      Top = 77
      DataBinding.DataField = 'oid_conc_liq_tar'
      DataBinding.DataSource = DSInput
      Properties.KeyFieldNames = 'oid_conc_liq_tar'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSConceptoLiqTarjeta
      TabOrder = 5
      Width = 380
    end
  end
  inherited PanelDetalle: TPanel
    Top = 433
    Width = 764
    TabOrder = 2
    inherited snAceptar: TsnButton
      Left = 468
      Hint = '<ENTER> Aceptar'
    end
    inherited snButton3: TsnButton
      Left = 564
    end
  end
  inherited PanelCuerpo: TPanel
    Top = 103
    Width = 764
    Height = 330
    BorderWidth = 5
    TabOrder = 1
    object Grilla: TdxDBGridSN
      Left = 5
      Top = 5
      Width = 754
      Height = 320
      Align = alClient
      TabOrder = 0
      LookAndFeel.Kind = lfFlat
      AllowInsert = False
      CriteriosPintarCelda = <
        item
          TipoPintadaCelda = tpcTodasLasColumnas
          FieldName1 = 'activo'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'false'
          TipoCondFiltro2 = tcfIgual
          Color = clRed
        end>
      object GrillaDBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSHelpLiquidacionTarjetas
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.GoToNextCellOnEnter = True
        OptionsCustomize.ColumnFiltering = False
        OptionsCustomize.ColumnSorting = False
        OptionsData.CancelOnExit = False
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsSelection.InvertSelect = False
        OptionsView.GroupByBox = False
        object GrillaDBTableView1comprobante: TcxGridDBColumn
          Caption = 'Comprobante'
          DataBinding.FieldName = 'comprobante'
          HeaderAlignmentHorz = taCenter
          Width = 208
        end
        object GrillaDBTableView1fec_emision: TcxGridDBColumn
          Caption = 'Fec. Emisi'#243'n'
          DataBinding.FieldName = 'fec_emision'
          HeaderAlignmentHorz = taCenter
          Width = 109
        end
        object GrillaDBTableView1Column1: TcxGridDBColumn
          Caption = 'Activo'
          DataBinding.FieldName = 'activo'
          Visible = False
        end
        object GrillaDBTableView1Column2: TcxGridDBColumn
          Caption = 'Concepto Liquidaci'#243'n'
          DataBinding.FieldName = 'concepto'
          HeaderAlignmentHorz = taCenter
          Width = 395
        end
      end
      object GrillaLevel1: TcxGridLevel
        GridView = GrillaDBTableView1
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = THelpLiquidacionTarjetas
        TableName = 'THelpLiquidacionTarjetas'
      end
      item
        DataSet = TConceptoLiqTarjeta
        TableName = 'TConceptoLiqTarjeta'
      end>
    Left = 208
    Top = 8
  end
  inherited Operacion: TOperacion
    Left = 240
    Top = 8
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
      '')
    OnInicializar = <
      item
        Source.Strings = (
          'begin '
          '  Grilla.ActivarEventoPintarCeldas();'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerConcLiqTarjeta'#39');'
          '  operacion.execute();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure ValidarAceptar();'
          'begin'
          '  if (not THelpLiquidacionTarjetas.Active) then abort();'
          '  if (THelpLiquidacionTarjetas.IsEmpty) then abort();'
          '  THelpLiquidacionTarjetas.PostRecord;'
          'end;'
          ''
          'procedure Aceptar();'
          'begin'
          '  ValidarAceptar();'
          'end;')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited DriverHelp: TDriverHelp
    campoCodigo = THelpLiquidacionTarjetascomprobante
    campoOID = THelpLiquidacionTarjetasoid_cco
    OnSearch.Strings = (
      'begin'
      ''
      '  TInput.PostRecord();'
      '  Operacion.inicioOperacion;'
      '  Operacion.setOper('#39'TraerHelpLiquidacionTarjetas'#39');'
      '  if (not TInput.IsEmpty)'
      '     then begin'
      '          if (TInput.FieldName('#39'nro_ext_desde'#39').AsInteger<>0)'
      
        '             then Operacion.addAtribute('#39'nro_ext_desde'#39',TInput.F' +
        'ieldName('#39'nro_ext_desde'#39').AsString);'
      '          if (TInput.FieldName('#39'nro_ext_hasta'#39').AsInteger<>0)'
      
        '             then Operacion.addAtribute('#39'nro_ext_hasta'#39',TInput.F' +
        'ieldName('#39'nro_ext_hasta'#39').AsString);'
      '          if (not TInput.FieldName('#39'fec_desde'#39').IsNull)'
      
        '             then Operacion.addAtribute('#39'fec_desde'#39',TInput.Field' +
        'Name('#39'fec_desde'#39').AsString);'
      '          if (not TInput.FieldName('#39'fec_hasta'#39').IsNull)'
      
        '             then Operacion.addAtribute('#39'fec_hasta'#39',TInput.Field' +
        'Name('#39'fec_hasta'#39').AsString);'
      '          if (TInput.FieldName('#39'oid_conc_liq_tar'#39').AsInteger<>0)'
      
        '             then Operacion.addAtribute('#39'oid_conc_liq_tar'#39',IntTo' +
        'Str(TInput.FieldName('#39'oid_conc_liq_tar'#39').AsInteger));'
      '          end;'
      '  Operacion.execute;'
      ''
      '  if (THelpLiquidacionTarjetas.IsEmpty)'
      
        '     then mensaje.information('#39'No se encontraron Liquidaciones d' +
        'e Tarjetas para la selecci'#243'n realizada'#39');'
      ''
      ''
      'end.'
      '')
    OnInicializar.Strings = (
      'begin'
      ''
      '  TInput.Open;'
      '  TInput.AppendRecord;'
      ''
      'end.')
    OnShow.Strings = (
      'begin'
      '  compo.exec('#39'DBNroDesde'#39','#39'SetFocus'#39');'
      'end.')
    OnEjecutar.Strings = (
      'begin'
      '  showModal();'
      'end.')
    OnAceptar.Strings = (
      'begin'
      '  Aceptar();'
      'end.')
  end
  object TClientes: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_sujeto'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 50
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
    Left = 128
    Top = 152
    object TClientesoid_sujeto: TIntegerField
      FieldName = 'oid_sujeto'
    end
    object TClientescodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TClientesrazon_social_cliente: TStringField
      FieldName = 'razon_social_cliente'
      Size = 100
    end
    object TClientescuit_cliente: TStringField
      FieldName = 'cuit_cliente'
    end
    object TClientesactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSClientes: TDataSource
    DataSet = TClientes
    Left = 168
    Top = 152
  end
  object cxEditRepository1: TcxEditRepository
    Left = 336
    Top = 177
    object cxCodigoValor: TcxEditRepositoryButtonItem
      Properties.Buttons = <
        item
          Default = True
          Kind = bkEllipsis
        end>
      Properties.ClickKey = 112
    end
  end
  object TInput: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid'
        DataType = ftInteger
      end
      item
        Name = 'nro_ext_desde'
        DataType = ftInteger
      end
      item
        Name = 'nro_ext_hasta'
        DataType = ftInteger
      end
      item
        Name = 'fec_desde'
        DataType = ftDate
      end
      item
        Name = 'fec_hasta'
        DataType = ftDate
      end
      item
        Name = 'oid_cliente'
        DataType = ftInteger
      end
      item
        Name = 'codigo_cliente'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'rz_social'
        DataType = ftString
        Size = 100
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
    Left = 104
    Top = 16
    object TInputoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TInputnro_ext_desde: TIntegerField
      FieldName = 'nro_ext_desde'
    end
    object TInputnro_ext_hasta: TIntegerField
      FieldName = 'nro_ext_hasta'
    end
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
      EditMask = '!99/99/0099;1;_'
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
      EditMask = '!99/99/0099;1;_'
    end
    object TInputoid_conc_liq_tar: TIntegerField
      FieldName = 'oid_conc_liq_tar'
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 136
    Top = 16
  end
  object THelpLiquidacionTarjetas: TsnTable
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
    Left = 296
    Top = 237
    object THelpLiquidacionTarjetasoid: TIntegerField
      FieldName = 'oid'
    end
    object THelpLiquidacionTarjetasoid_cco: TIntegerField
      FieldName = 'oid_cco'
    end
    object THelpLiquidacionTarjetascomprobante: TStringField
      FieldName = 'comprobante'
      Size = 50
    end
    object THelpLiquidacionTarjetasfec_emision: TDateField
      FieldName = 'fec_emision'
    end
    object THelpLiquidacionTarjetasconcepto: TStringField
      FieldName = 'concepto'
      Size = 200
    end
    object THelpLiquidacionTarjetasactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSHelpLiquidacionTarjetas: TDataSource
    DataSet = THelpLiquidacionTarjetas
    Left = 328
    Top = 237
  end
  object TConceptoLiqTarjeta: TsnTable
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
    Left = 128
    Top = 303
    object TConceptoLiqTarjetaoid_conc_liq_tar: TIntegerField
      FieldName = 'oid_conc_liq_tar'
    end
    object TConceptoLiqTarjetacodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TConceptoLiqTarjetadescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TConceptoLiqTarjetaactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSConceptoLiqTarjeta: TDataSource
    DataSet = TConceptoLiqTarjeta
    Left = 168
    Top = 303
  end
end
