inherited FConsMayorTarjDebCre: TFConsMayorTarjDebCre
  Left = 125
  Top = 153
  Width = 864
  Caption = 'Consulta de Mayor'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 856
    Height = 42
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 216
      Top = 15
      Width = 34
      Height = 13
      Caption = 'Cuenta'
    end
    object Label2: TLabel
      Left = 379
      Top = 15
      Width = 67
      Height = 13
      Caption = 'Fecha Desde:'
    end
    object Label3: TLabel
      Left = 541
      Top = 15
      Width = 64
      Height = 13
      Caption = 'Fecha Hasta:'
    end
    object ImageBuscar: TImage
      Left = 719
      Top = 5
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Buscar Asientos'
      ParentShowHint = False
      ShowHint = True
    end
    object ImageSalir: TImage
      Left = 766
      Top = 5
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object Label4: TLabel
      Left = 8
      Top = 15
      Width = 41
      Height = 13
      Caption = 'Empresa'
    end
    object snDBEdit1: TsnDBEdit
      Left = 256
      Top = 11
      DataBinding.DataField = 'cuenta'
      DataBinding.DataSource = DSInput
      TabOrder = 1
      Width = 113
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 448
      Top = 11
      DataBinding.DataField = 'fec_desde'
      DataBinding.DataSource = DSInput
      TabOrder = 2
      ReadOnlyAlways = False
      Width = 89
    end
    object snDBDateEdit2: TsnDBDateEdit
      Left = 606
      Top = 11
      DataBinding.DataField = 'fec_hasta'
      DataBinding.DataSource = DSInput
      TabOrder = 3
      ReadOnlyAlways = False
      Width = 89
    end
    object snDBLookup1: TsnDBLookup
      Left = 56
      Top = 11
      DataBinding.DataField = 'oid_empresa'
      DataBinding.DataSource = DSInput
      Properties.KeyFieldNames = 'oid_empresa'
      Properties.ListColumns = <
        item
          FieldName = 'razon_social'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSEmpresasConciTar
      TabOrder = 0
      Width = 145
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 475
    Width = 856
    Height = 6
    Align = alBottom
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 42
    Width = 856
    Height = 433
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 2
    object dxDBGridSN1: TdxDBGridSN
      Left = 0
      Top = 0
      Width = 856
      Height = 433
      Align = alClient
      TabOrder = 0
      CriteriosPintarCelda = <>
      object dxDBGridSN1DBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSMovConsMayor
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <
          item
            Format = '###,###,###,###,###.##'
            Kind = skSum
            Column = dxDBGridSN1DBTableView1debe
          end
          item
            Format = '###,###,###,###,###.##'
            Kind = skSum
            Column = dxDBGridSN1DBTableView1haber
          end>
        DataController.Summary.SummaryGroups = <>
        OptionsData.CancelOnExit = False
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsView.CellAutoHeight = True
        OptionsView.Footer = True
        OptionsView.GroupByBox = False
        object dxDBGridSN1DBTableView1Column1: TcxGridDBColumn
          DataBinding.FieldName = 'secu'
          Visible = False
          SortIndex = 1
          SortOrder = soAscending
        end
        object dxDBGridSN1DBTableView1fecha: TcxGridDBColumn
          Caption = 'Fecha'
          DataBinding.FieldName = 'fecha'
          HeaderAlignmentHorz = taCenter
          SortIndex = 0
          SortOrder = soAscending
          Width = 90
        end
        object dxDBGridSN1DBTableView1referencia: TcxGridDBColumn
          Caption = 'Referencia'
          DataBinding.FieldName = 'referencia'
          HeaderAlignmentHorz = taCenter
          Width = 165
        end
        object dxDBGridSN1DBTableView1compo1: TcxGridDBColumn
          DataBinding.FieldName = 'compo1'
          Width = 102
        end
        object dxDBGridSN1DBTableView1compo2: TcxGridDBColumn
          DataBinding.FieldName = 'compo2'
          Width = 91
        end
        object dxDBGridSN1DBTableView1comentario: TcxGridDBColumn
          Caption = 'Comentario'
          DataBinding.FieldName = 'comentario'
          HeaderAlignmentHorz = taCenter
          Width = 194
        end
        object dxDBGridSN1DBTableView1debe: TcxGridDBColumn
          Caption = 'Debe'
          DataBinding.FieldName = 'debe'
          HeaderAlignmentHorz = taCenter
          Width = 90
        end
        object dxDBGridSN1DBTableView1haber: TcxGridDBColumn
          Caption = 'Haber'
          DataBinding.FieldName = 'haber'
          HeaderAlignmentHorz = taCenter
          Width = 90
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
        DataSet = TMovConsMayor
        TableName = 'TMovConsMayor'
      end
      item
        DataSet = TEmpresaConciTar
        TableName = 'TEmpresaConciTar'
      end>
  end
  inherited TOidObjSave: TsnTable
    Left = 568
    Top = 248
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
      
        '  dxDBGridSN1.setCaptionColumn('#39'compo1'#39',Varios.getValorString('#39'L' +
        'ABEL_COMP1_CONC_TARJ'#39'));'
      
        '  dxDBGridSN1.setCaptionColumn('#39'compo2'#39',Varios.getValorString('#39'L' +
        'ABEL_COMP2_CONC_TARJ'#39'));'
      'end.')
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  Inicializar();'
          '  InicializarEmpresas();'
          '  Varios.setImagen('#39'ImageBuscar'#39',0);'
          '  Varios.setImagen('#39'ImageSalir'#39',7);'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure Inicializar();'
          'begin'
          '  TInput.Close;'
          '  TInput.Open;'
          '  TInput.AppendRecord;'
          'end;'
          ''
          ''
          'procedure TraerMayor();'
          'begin'
          ''
          '  TInput.PostRecord;'
          ''
          '  if (TInput.FieldName('#39'oid_empresa'#39').AsInteger = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Empresa' +
            #39');'
          ''
          ''
          '  if (TInput.FieldName('#39'cuenta'#39').AsString = '#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la cuenta'#39 +
            ');'
          ''
          '  if (TInput.FieldName('#39'fec_desde'#39').IsNull)'#9
          
            '     then  raiseException(erCustomError,'#39'Debe ingresar la fecha ' +
            'desde'#39');'
          ''
          '  if (TInput.FieldName('#39'fec_hasta'#39').IsNull)'#9
          
            '     then  raiseException(erCustomError,'#39'Debe ingresar la fecha ' +
            'hasta'#39');'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerConsMayorTarjDebCre'#39');'
          
            '  operacion.AddAtribute('#39'oid_empresa'#39', TInput.FieldName('#39'oid_emp' +
            'resa'#39').AsString);'
          
            '  operacion.AddAtribute('#39'cuenta'#39', TInput.FieldName('#39'cuenta'#39').AsS' +
            'tring);'
          
            '  operacion.AddAtribute('#39'fec_desde'#39', TInput.FieldName('#39'fec_desde' +
            #39').AsString);'
          
            '  operacion.AddAtribute('#39'fec_hasta'#39', TInput.FieldName('#39'fec_hasta' +
            #39').AsString);'
          '  operacion.execute();'
          ''
          'end;'
          ''
          'procedure InicializarEmpresas();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerEmpresasConciTar'#39');'
          '  operacion.execute();'
          'end;'
          ''
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageBuscar'
        Source.Strings = (
          'begin'
          '  TraerMayor();'
          'end.')
      end
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  close();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
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
    Left = 120
    Top = 89
    object TInputcuenta: TStringField
      FieldName = 'cuenta'
      Size = 50
    end
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object TInputoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 152
    Top = 93
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 416
    Top = 65
  end
  object TMovConsMayor: TsnTable
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
    Top = 197
    object TMovConsMayorsecu: TIntegerField
      FieldName = 'secu'
    end
    object TMovConsMayorfecha: TDateField
      FieldName = 'fecha'
    end
    object TMovConsMayorreferencia: TStringField
      FieldName = 'referencia'
      Size = 100
    end
    object TMovConsMayorcompo1: TStringField
      FieldName = 'compo1'
      Size = 50
    end
    object TMovConsMayorcompo2: TStringField
      FieldName = 'compo2'
      Size = 50
    end
    object TMovConsMayorcomentario: TStringField
      FieldName = 'comentario'
      Size = 255
    end
    object TMovConsMayordebe: TCurrencyField
      FieldName = 'debe'
      DisplayFormat = '###,###,###,###,###.##'
    end
    object TMovConsMayorhaber: TCurrencyField
      FieldName = 'haber'
      DisplayFormat = '###,###,###,###,###.##'
    end
  end
  object DSMovConsMayor: TDataSource
    DataSet = TMovConsMayor
    Left = 152
    Top = 197
  end
  object TEmpresaConciTar: TsnTable
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
    Left = 616
    Top = 168
    object TEmpresaConciTaroid_empresa: TIntegerField
      FieldName = 'oid_empresa'
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
      FieldName = 'activo'
    end
  end
  object DSEmpresasConciTar: TDataSource
    DataSet = TEmpresaConciTar
    Left = 648
    Top = 168
  end
end
