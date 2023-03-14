inherited FConsArchImpTarj: TFConsArchImpTarj
  Left = 119
  Top = 136
  Width = 850
  Caption = 'Errores en Importaci'#243'n de Archivos'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 842
    Height = 92
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 16
      Top = 38
      Width = 82
      Height = 16
      Caption = 'Fecha Desde'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label2: TLabel
      Left = 224
      Top = 38
      Width = 77
      Height = 16
      Caption = 'Fecha Hasta'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel1: TsnLabel
      Left = 320
      Top = 65
      Width = 94
      Height = 16
      Caption = 'Tipo de archivo'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel2: TsnLabel
      Left = 16
      Top = 65
      Width = 55
      Height = 16
      Caption = 'Empresa'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object ImageSalir: TImage
      Left = 440
      Top = 2
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object snLabel3: TsnLabel
      Left = 16
      Top = 8
      Width = 417
      Height = 16
      Caption = 'Archivos de POSNETS / TARJETAS importados con Errores'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clBlue
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = [fsBold]
      ParentFont = False
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 104
      Top = 36
      DataBinding.DataField = 'fec_desde'
      DataBinding.DataSource = dsInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      ReadOnlyAlways = False
      Width = 97
    end
    object snDBDateEdit2: TsnDBDateEdit
      Left = 312
      Top = 36
      DataBinding.DataField = 'fec_hasta'
      DataBinding.DataSource = dsInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 1
      ReadOnlyAlways = False
      Width = 97
    end
    object snDBLookup1: TsnDBLookup
      Left = 424
      Top = 63
      DataBinding.DataField = 'tipo_archivo'
      DataBinding.DataSource = dsInput
      ParentFont = False
      Properties.KeyFieldNames = 'codigo'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSComporTipoArch
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 2
      Width = 201
    end
    object BotonConsultar: TsnButton
      Left = 648
      Top = 43
      Width = 145
      Height = 43
      Cursor = crHandPoint
      Caption = 'Consultar'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 3
      LookAndFeel.Kind = lfOffice11
    end
    object snDBLookup2: TsnDBLookup
      Left = 104
      Top = 63
      DataBinding.DataField = 'oid_empresa'
      DataBinding.DataSource = dsInput
      ParentFont = False
      Properties.KeyFieldNames = 'oid_empresa'
      Properties.ListColumns = <
        item
          FieldName = 'razon_social'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSEmpresa
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 4
      Width = 201
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 92
    Width = 842
    Height = 389
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object dxDBGridSN1: TdxDBGridSN
      Left = 1
      Top = 1
      Width = 840
      Height = 387
      Align = alClient
      TabOrder = 0
      LookAndFeel.Kind = lfFlat
      CriteriosPintarCelda = <>
      object dxDBGridSN1DBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSErrorArch
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsData.Deleting = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsView.CellAutoHeight = True
        object dxDBGridSN1DBTableView1fecha: TcxGridDBColumn
          Caption = 'Fecha'
          DataBinding.FieldName = 'fecha'
          HeaderAlignmentHorz = taCenter
          Width = 68
        end
        object dxDBGridSN1DBTableView1hora: TcxGridDBColumn
          Caption = 'Hora'
          DataBinding.FieldName = 'hora'
          HeaderAlignmentHorz = taCenter
          Width = 45
        end
        object dxDBGridSN1DBTableView1terminal: TcxGridDBColumn
          Caption = 'Terminal'
          DataBinding.FieldName = 'terminal'
          HeaderAlignmentHorz = taCenter
          Width = 98
        end
        object dxDBGridSN1DBTableView1tipo_arch: TcxGridDBColumn
          Caption = 'Tipo Archivo'
          DataBinding.FieldName = 'tipo_arch'
          Visible = False
          GroupIndex = 1
          HeaderAlignmentHorz = taCenter
          Width = 90
        end
        object dxDBGridSN1DBTableView1problema: TcxGridDBColumn
          Caption = 'Problema'
          DataBinding.FieldName = 'problema'
          HeaderAlignmentHorz = taCenter
          Width = 209
        end
        object dxDBGridSN1DBTableView1carpeta: TcxGridDBColumn
          Caption = 'Carpeta'
          DataBinding.FieldName = 'carpeta'
          HeaderAlignmentHorz = taCenter
          Width = 251
        end
        object dxDBGridSN1DBTableView1nombre_archivo: TcxGridDBColumn
          Caption = 'Archivo'
          DataBinding.FieldName = 'nombre_archivo'
          HeaderAlignmentHorz = taCenter
          HeaderGlyphAlignmentHorz = taCenter
          Width = 107
        end
        object dxDBGridSN1DBTableView1empresa: TcxGridDBColumn
          Caption = 'Empresa'
          DataBinding.FieldName = 'empresa'
          Visible = False
          GroupIndex = 0
          HeaderAlignmentHorz = taCenter
          Width = 78
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
        DataSet = TErrorArch
        TableName = 'TErrorArch'
      end
      item
        DataSet = TComporTipoArch
        TableName = 'TComporTipoArch'
      end
      item
        DataSet = TEmpresaConciTar
        TableName = 'TEmpresaConciTar'
      end>
    Left = 72
    Top = 272
  end
  inherited Operacion: TOperacion
    Left = 104
    Top = 272
  end
  inherited TOidObjSave: TsnTable
    Left = 600
    Top = 64
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 136
    Top = 272
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Top = 48
  end
  inherited DriverEvent: TDriverEvent
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  Inicializar();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerTiposArchivos();'
          'begin'
          '    operacion.InicioOperacion;'
          '    operacion.setOper('#39'TraerTipoArchConciTar'#39');'
          '    operacion.execute();'
          '    TComporTipoArch.AppendRecord;'
          '    TComporTipoArch.FieldName('#39'codigo'#39').AsString := '#39'POSNET'#39';'
          
            '    TComporTipoArch.FieldName('#39'descripcion'#39').AsString := '#39'POSNET' +
            #39';'
          '    TComporTipoArch.PostRecord;'
          'end;'
          ''
          ''
          'procedure TraerEmpresas();'
          'begin'
          '  operacion.InicioOperacion;'
          '  operacion.setOper('#39'TraerEmpresasConciTar'#39');'
          '  operacion.execute();'
          'end;'
          ''
          ''
          'procedure Inicializar();'
          'begin'
          '  Varios.setImagen('#39'ImageSalir'#39',7);'
          '  TraerEmpresas();'
          '  TraerTiposArchivos();'
          '  TInput.Close;'
          '  TInput.Open;'
          '  TInput.AppendRecord;'
          'end;'
          ''
          'procedure TraerLogsErroresImp();'
          'begin'
          ' TInput.PostRecord; '
          ' operacion.InicioOperacion();'
          ' operacion.setOper('#39'TraerErrorImpArchTarj'#39');'
          ' if (not TInput.FieldName('#39'fec_desde'#39').IsNull) '
          
            '    then operacion.AddAtribute('#39'fec_desde'#39', TInput.FieldName('#39'fe' +
            'c_desde'#39').AsString);'
          ' if (not TInput.FieldName('#39'fec_hasta'#39').IsNull) '
          
            '    then operacion.AddAtribute('#39'fec_hasta'#39', TInput.FieldName('#39'fe' +
            'c_hasta'#39').AsString);'
          ' if (TInput.FieldName('#39'tipo_archivo'#39').AsString<>'#39#39')'
          
            '    then operacion.AddAtribute('#39'tipo_archivo'#39', TInput.FieldName(' +
            #39'tipo_archivo'#39').AsString);'
          ' if (TInput.FieldName('#39'oid_empresa'#39').AsInteger<>0)'
          
            '    then operacion.AddAtribute('#39'oid_empresa'#39', TInput.FieldName('#39 +
            'oid_empresa'#39').AsString);'
          ' operacion.execute();'
          ''
          ' if (TErrorArch.IsEmpty)'
          
            '    then mensaje.information('#39'No se encontraron archivos con err' +
            'ores para la selecci'#243'n realizada.'#39');'
          'end;'
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonConsultar'
        Source.Strings = (
          'begin'
          '  TraerLogsErroresImp();'
          'end.')
      end
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  close;'
          'end.')
      end>
    Left = 176
    Top = 275
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
    Left = 160
    Top = 137
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object TInputtipo_archivo: TStringField
      FieldName = 'tipo_archivo'
      Size = 10
    end
    object TInputoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
  end
  object TErrorArch: TsnTable
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
    Left = 176
    Top = 217
    object TErrorArchoid_error_imp: TIntegerField
      FieldName = 'oid_error_imp'
    end
    object TErrorArchtipo_arch: TStringField
      FieldName = 'tipo_arch'
    end
    object TErrorArchfecha: TDateField
      FieldName = 'fecha'
    end
    object TErrorArchhora: TStringField
      FieldName = 'hora'
      Size = 5
    end
    object TErrorArchcarpeta: TStringField
      FieldName = 'carpeta'
      Size = 255
    end
    object TErrorArchnombre_archivo: TStringField
      FieldName = 'nombre_archivo'
      Size = 255
    end
    object TErrorArchoid_terminal: TIntegerField
      FieldName = 'oid_terminal'
    end
    object TErrorArchoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TErrorArchterminal: TStringField
      FieldName = 'terminal'
      Size = 100
    end
    object TErrorArchempresa: TStringField
      FieldName = 'empresa'
      Size = 100
    end
    object TErrorArchproblema: TStringField
      FieldName = 'problema'
      Size = 255
    end
    object TErrorArchactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSErrorArch: TDataSource
    DataSet = TErrorArch
    Left = 208
    Top = 217
  end
  object dsInput: TDataSource
    DataSet = TInput
    Left = 192
    Top = 138
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
    Left = 320
    Top = 345
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
    object TEmpresaConciTarcod_comercio: TStringField
      FieldName = 'cod_comercio'
      Size = 50
    end
    object TEmpresaConciTaractivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSEmpresa: TDataSource
    DataSet = TEmpresaConciTar
    Left = 352
    Top = 345
  end
  object TComporTipoArch: TsnTable
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
    Left = 152
    Top = 353
    object TComporTipoArchcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TComporTipoArchdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSComporTipoArch: TDataSource
    DataSet = TComporTipoArch
    Left = 184
    Top = 353
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 521
    Top = 337
  end
end
