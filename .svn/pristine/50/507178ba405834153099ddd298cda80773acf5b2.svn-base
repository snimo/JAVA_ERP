inherited FConsArchImpConci: TFConsArchImpConci
  Left = 85
  Top = 174
  Width = 754
  Caption = 'Consulta de Archivos Importados'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 746
    Height = 77
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 8
      Top = 11
      Width = 98
      Height = 16
      Caption = 'Fec. Imp. Desde'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label2: TLabel
      Left = 260
      Top = 11
      Width = 93
      Height = 16
      Caption = 'Fec. Imp. Hasta'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel2: TsnLabel
      Left = 8
      Top = 42
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
    object snLabel1: TsnLabel
      Left = 260
      Top = 42
      Width = 95
      Height = 16
      Caption = 'Tipo de Archivo'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object ImageSalir: TImage
      Left = 496
      Top = 2
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 112
      Top = 7
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
      Left = 364
      Top = 7
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
    object snDBLookup2: TsnDBLookup
      Left = 112
      Top = 38
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
      TabOrder = 2
      Width = 137
    end
    object snDBLookup1: TsnDBLookup
      Left = 364
      Top = 38
      DataBinding.DataField = 'tipo_archivo'
      DataBinding.DataSource = dsInput
      ParentFont = False
      Properties.ImmediatePost = True
      Properties.KeyFieldNames = 'codigo'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSTipoArchivo
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 3
      Width = 213
    end
    object BotonConsulta: TsnButton
      Left = 590
      Top = 10
      Width = 108
      Height = 47
      Caption = 'Consultar'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 4
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 77
    Width = 746
    Height = 404
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object PageControl: TPageControlSN
      Left = 1
      Top = 1
      Width = 744
      Height = 402
      ActivePage = TabSheetTarjetas
      Align = alClient
      TabOrder = 0
      object TabSheetTarjetas: TTabSheet
        Caption = 'Tarjetas '
        object Splitter1: TSplitter
          Left = 0
          Top = 199
          Width = 736
          Height = 3
          Cursor = crVSplit
          Align = alTop
        end
        object dxDBGridSN1: TdxDBGridSN
          Left = 0
          Top = 1
          Width = 736
          Height = 198
          Align = alTop
          TabOrder = 0
          CriteriosPintarCelda = <>
          object dxDBGridSN1DBTableView1: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSTArchivosTarjetas
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsData.Deleting = False
            OptionsData.Editing = False
            OptionsData.Inserting = False
            OptionsView.GroupByBox = False
            object dxDBGridSN1DBTableView1fec_imp: TcxGridDBColumn
              Caption = 'Fec. Importaci'#243'n'
              DataBinding.FieldName = 'fec_imp'
              HeaderAlignmentHorz = taCenter
              Width = 97
            end
            object dxDBGridSN1DBTableView1hora_imp: TcxGridDBColumn
              Caption = 'Hora'
              DataBinding.FieldName = 'hora_imp'
              HeaderAlignmentHorz = taCenter
              Width = 43
            end
            object dxDBGridSN1DBTableView1tipo_archivo: TcxGridDBColumn
              Caption = 'Tipo Archivo'
              DataBinding.FieldName = 'tipo_archivo'
              HeaderAlignmentHorz = taCenter
              Width = 70
            end
            object dxDBGridSN1DBTableView1nom_archivo: TcxGridDBColumn
              Caption = 'Archivo'
              DataBinding.FieldName = 'nom_archivo'
              HeaderAlignmentHorz = taCenter
              Width = 116
            end
            object dxDBGridSN1DBTableView1fec_nom_arch: TcxGridDBColumn
              Caption = 'Fecha Tarjeta'
              DataBinding.FieldName = 'fec_nom_arch'
              HeaderAlignmentHorz = taCenter
              Width = 94
            end
            object dxDBGridSN1DBTableView1carpeta_archivo: TcxGridDBColumn
              Caption = 'Carpeta Origen'
              DataBinding.FieldName = 'carpeta_archivo'
              HeaderAlignmentHorz = taCenter
              Width = 102
            end
            object dxDBGridSN1DBTableView1oid_usu_alta: TcxGridDBColumn
              Caption = 'Usuario'
              DataBinding.FieldName = 'usuario'
              HeaderAlignmentHorz = taCenter
              Width = 92
            end
          end
          object dxDBGridSN1Level1: TcxGridLevel
            GridView = dxDBGridSN1DBTableView1
          end
        end
        object Panel3: TPanel
          Left = 0
          Top = 0
          Width = 736
          Height = 1
          Align = alTop
          Color = clWindow
          TabOrder = 1
        end
        object SNScrollBox1: TSNScrollBox
          Left = 0
          Top = 202
          Width = 736
          Height = 172
          Align = alClient
          TabOrder = 2
          object snDBMemo1: TsnDBMemo
            Left = 0
            Top = 0
            Align = alClient
            DataBinding.DataField = 'arch_texto'
            DataBinding.DataSource = DSTArchivosTarjetas
            Properties.ReadOnly = True
            Properties.ScrollBars = ssBoth
            Properties.WantTabs = True
            Properties.WordWrap = False
            TabOrder = 0
            ReadOnlyAlways = False
            Height = 168
            Width = 732
          end
        end
      end
      object TabSheetPOSNETS: TTabSheet
        Caption = 'POSNET'
        ImageIndex = 1
        object Splitter2: TSplitter
          Left = 0
          Top = 198
          Width = 736
          Height = 3
          Cursor = crVSplit
          Align = alTop
        end
        object dxDBGridSN2: TdxDBGridSN
          Left = 0
          Top = 0
          Width = 736
          Height = 198
          Align = alTop
          TabOrder = 0
          CriteriosPintarCelda = <>
          object cxGridDBTableView1: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = dsArchivosPOSNETS
            DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsData.Deleting = False
            OptionsData.Editing = False
            OptionsData.Inserting = False
            object cxGridDBTableView1nro_terminal: TcxGridDBColumn
              Caption = 'Terminal'
              DataBinding.FieldName = 'nro_terminal'
              Visible = False
              GroupIndex = 0
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 51
            end
            object cxGridDBTableView1fec_cierre: TcxGridDBColumn
              Caption = 'Fec. Cierre'
              DataBinding.FieldName = 'fec_cierre'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              SortIndex = 0
              SortOrder = soAscending
              Width = 101
            end
            object cxGridDBTableView1nro_lote: TcxGridDBColumn
              Caption = 'Lote'
              DataBinding.FieldName = 'nro_lote'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              SortIndex = 1
              SortOrder = soAscending
              Width = 40
            end
            object cxGridDBTableView1cant_transac: TcxGridDBColumn
              Caption = 'Cant. Transac.'
              DataBinding.FieldName = 'cant_transac'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 80
            end
            object cxGridDBTableView1archivo: TcxGridDBColumn
              Caption = 'Archivo'
              DataBinding.FieldName = 'archivo'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 174
            end
            object cxGridDBTableView1fec_creacion: TcxGridDBColumn
              Caption = 'Fec. Creaci'#243'n'
              DataBinding.FieldName = 'fec_creacion'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 91
            end
            object cxGridDBTableView1fec_importacion: TcxGridDBColumn
              Caption = 'Fec. Importaci'#243'n'
              DataBinding.FieldName = 'fec_importacion'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 86
            end
            object cxGridDBTableView1Column1: TcxGridDBColumn
              Caption = 'Tarjeta'
              DataBinding.FieldName = 'tarjeta'
              Visible = False
              GroupIndex = 1
              Options.Editing = False
              Width = 80
            end
          end
          object cxGridLevel1: TcxGridLevel
            GridView = cxGridDBTableView1
          end
        end
        object snDBMemo2: TsnDBMemo
          Left = 0
          Top = 201
          Align = alClient
          DataBinding.DataField = 'arch_texto'
          DataBinding.DataSource = dsArchivosPOSNETS
          Properties.ReadOnly = True
          Properties.ScrollBars = ssBoth
          Properties.WantTabs = True
          Properties.WordWrap = False
          TabOrder = 1
          ReadOnlyAlways = False
          Height = 173
          Width = 736
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TEmpresaConciTar
        TableName = 'TEmpresaConciTar'
      end
      item
        DataSet = TArchivosTarjetas
        TableName = 'TArchivosTarjetas'
      end
      item
        DataSet = TArchivosPOSNETS
        TableName = 'TArchivosPOSNETS'
      end>
  end
  inherited TOidObjSave: TsnTable
    Left = 608
    Top = 56
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
    OnChangeField = <
      item
        TableName = 'TInput'
        FieldName = 'tipo_archivo'
        Source.Strings = (
          'begin'
          '  if (Sender.AsString  = '#39'TARJETA'#39')'
          '     then begin'
          '             PageControl.setTabVisible('#39'TabSheetTarjetas'#39',true);'
          '             PageControl.setTabVisible('#39'TabSheetPOSNETS'#39',false);'
          '             PageControl.setActivePageName('#39'TabSheetTarjetas'#39');'
          '             end'
          '     else begin'
          
            '             PageControl.setTabVisible('#39'TabSheetTarjetas'#39',false)' +
            ';'
          '             PageControl.setTabVisible('#39'TabSheetPOSNETS'#39',true);'
          '             PageControl.setActivePageName('#39'TabSheetPOSNET'#39');'
          '             end;'
          'end.')
      end>
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
          'procedure ValidarCampos();'
          'begin'
          '  TInput.PostRecord;'
          '  if (TInput.IsEmpty)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar las datos ' +
            'para la consulta'#39');'
          '  if (TInput.FieldName('#39'fec_desde'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha D' +
            'esde'#39');'
          '  if (TInput.FieldName('#39'fec_hasta'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha H' +
            'asta'#39');'
          '  if (TInput.FieldName('#39'oid_empresa'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Empresa' +
            #39');'
          '  if (TInput.FieldName('#39'tipo_archivo'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Tipo de' +
            ' Archivo'#39');'
          'end;'
          ''
          'procedure TraerEmpresas();'
          'begin'
          '  operacion.InicioOperacion;'
          '  operacion.setOper('#39'TraerEmpresasConciTar'#39');'
          '  operacion.execute();'
          'end;'
          ''
          'procedure Inicializar();'
          'begin'
          ''
          '   Varios.setImagen('#39'ImageSalir'#39',7);'
          ''
          '  TUsuarios.loadFromHelp('#39'HelpUsuarios'#39');'
          ''
          '  TraerEmpresas();'
          ''
          '  TInput.Close;'
          '  TInput.Open;'
          '  TInput.AppendRecord;'
          ''
          '  TTipoArchivo.Close;'
          '  TTipoArchivo.Open;'
          ''
          '  TTipoArchivo.AppendRecord;'
          '  TTipoArchivo.FieldName('#39'codigo'#39').AsString := '#39'TARJETA'#39';'
          '  TTipoArchivo.FieldName('#39'descripcion'#39').AsString := '#39'Tarjeta'#39';'
          '  TTipoArchivo.PostRecord;'
          ''
          '  TTipoArchivo.AppendRecord;'
          '  TTipoArchivo.FieldName('#39'codigo'#39').AsString := '#39'POSNET'#39';'
          '  TTipoArchivo.FieldName('#39'descripcion'#39').AsString := '#39'Posnet'#39';'
          '  TTipoArchivo.PostRecord;'
          ''
          '  PageControl.setTabVisible('#39'TabSheetTarjetas'#39',false);'
          '  PageControl.setTabVisible('#39'TabSheetPOSNETS'#39',false);'
          ''
          'end;'
          ''
          'procedure TraerArchivosTarjetas();'
          'begin'
          '  TInput.PostRecord;'
          '  operacion.InicioOperacion;'
          '  operacion.setOper('#39'TraerArchivosImpTarj'#39');   '
          
            '  operacion.AddAtribute('#39'fec_desde'#39',TInput.FieldName('#39'fec_desde'#39 +
            ').AsString); '
          
            '  operacion.AddAtribute('#39'fec_hasta'#39',TInput.FieldName('#39'fec_hasta'#39 +
            ').AsString); '
          
            '  operacion.AddAtribute('#39'tipo_archivo'#39',TInput.FieldName('#39'tipo_ar' +
            'chivo'#39').AsString); '
          
            '  operacion.AddAtribute('#39'oid_empresa'#39',IntToStr(TInput.FieldName(' +
            #39'oid_empresa'#39').AsInteger)); '
          '  operacion.execute();'
          'end;'
          ''
          'procedure TraerArchivosPosnets();'
          'begin'
          '  TInput.PostRecord;'
          '  operacion.InicioOperacion;'
          '  operacion.setOper('#39'TraerArchivosImpPosnets'#39');   '
          
            '  operacion.AddAtribute('#39'fec_desde'#39',TInput.FieldName('#39'fec_desde'#39 +
            ').AsString); '
          
            '  operacion.AddAtribute('#39'fec_hasta'#39',TInput.FieldName('#39'fec_hasta'#39 +
            ').AsString); '
          
            '  operacion.AddAtribute('#39'tipo_archivo'#39',TInput.FieldName('#39'tipo_ar' +
            'chivo'#39').AsString); '
          
            '  operacion.AddAtribute('#39'oid_empresa'#39',IntToStr(TInput.FieldName(' +
            #39'oid_empresa'#39').AsInteger)); '
          '  operacion.execute();'
          'end;'
          ''
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonConsulta'
        Source.Strings = (
          'begin'
          ''
          '  ValidarCampos();'
          ''
          '  if (TInput.FieldName('#39'tipo_archivo'#39').AsString = '#39'TARJETA'#39')'
          '     then  TraerArchivosTarjetas()'
          '     else   TraerArchivosPosnets();'
          ''
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
    Left = 88
    Top = 201
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
  object dsInput: TDataSource
    DataSet = TInput
    Left = 120
    Top = 202
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
    Left = 168
    Top = 201
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
    Left = 200
    Top = 201
  end
  object TTipoArchivo: TsnTable
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
    Left = 413
    Top = 278
    object TTipoArchivocodigo: TStringField
      FieldName = 'codigo'
      Size = 10
    end
    object TTipoArchivodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTipoArchivo: TDataSource
    DataSet = TTipoArchivo
    Left = 453
    Top = 278
  end
  object TArchivosTarjetas: TsnTable
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
    Left = 77
    Top = 278
    object TArchivosTarjetasoid_tar_info_cab: TIntegerField
      FieldName = 'oid_tar_info_cab'
    end
    object TArchivosTarjetasfec_imp: TDateField
      FieldName = 'fec_imp'
    end
    object TArchivosTarjetashora_imp: TStringField
      FieldName = 'hora_imp'
      Size = 5
    end
    object TArchivosTarjetasoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TArchivosTarjetasnom_archivo: TStringField
      FieldName = 'nom_archivo'
      Size = 255
    end
    object TArchivosTarjetastipo_archivo: TStringField
      FieldName = 'tipo_archivo'
    end
    object TArchivosTarjetascarpeta_archivo: TStringField
      FieldName = 'carpeta_archivo'
      Size = 255
    end
    object TArchivosTarjetasfec_nom_arch: TDateField
      FieldName = 'fec_nom_arch'
    end
    object TArchivosTarjetasoid_usu_alta: TIntegerField
      FieldName = 'oid_usu_alta'
    end
    object TArchivosTarjetasactivo: TBooleanField
      FieldName = 'activo'
    end
    object TArchivosTarjetasusuario: TStringField
      FieldKind = fkLookup
      FieldName = 'usuario'
      LookupDataSet = TUsuarios
      LookupKeyFields = 'oid'
      LookupResultField = 'descripcion'
      KeyFields = 'oid_usu_alta'
      Size = 50
      Lookup = True
    end
    object TArchivosTarjetasarch_texto: TMemoField
      FieldName = 'arch_texto'
      BlobType = ftMemo
    end
  end
  object DSTArchivosTarjetas: TDataSource
    DataSet = TArchivosTarjetas
    Left = 109
    Top = 278
  end
  object HelpUsuarios: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'se.Usuario'
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
        Titulo = 'Descripci'#243'n'
        FieldName = 'descripcion'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
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
    Titulo = 'Usuarios'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 255
    Top = 302
  end
  object TUsuarios: TsnTable
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
    Left = 287
    Top = 302
    object TUsuariosoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TUsuarioscodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TUsuariosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSUsuarios: TDataSource
    DataSet = TUsuarios
    Left = 322
    Top = 300
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 521
    Top = 337
  end
  object TArchivosPOSNETS: TsnTable
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
    Left = 77
    Top = 316
    object TArchivosPOSNETSoid_arch_lot_cab: TIntegerField
      FieldName = 'oid_arch_lot_cab'
    end
    object TArchivosPOSNETSestado: TIntegerField
      FieldName = 'estado'
    end
    object TArchivosPOSNETSproveedor_host: TStringField
      FieldName = 'proveedor_host'
      Size = 2
    end
    object TArchivosPOSNETSnro_host: TStringField
      FieldName = 'nro_host'
    end
    object TArchivosPOSNETSnom_host: TStringField
      FieldName = 'nom_host'
      Size = 12
    end
    object TArchivosPOSNETSnro_lote: TIntegerField
      FieldName = 'nro_lote'
    end
    object TArchivosPOSNETScant_transac: TIntegerField
      FieldName = 'cant_transac'
    end
    object TArchivosPOSNETSnro_terminal: TStringField
      FieldName = 'nro_terminal'
    end
    object TArchivosPOSNETSanio: TIntegerField
      FieldName = 'anio'
    end
    object TArchivosPOSNETSmes: TIntegerField
      FieldName = 'mes'
    end
    object TArchivosPOSNETSdia: TIntegerField
      FieldName = 'dia'
    end
    object TArchivosPOSNETSarchivo: TStringField
      FieldName = 'archivo'
      Size = 100
    end
    object TArchivosPOSNETSfec_creacion: TDateField
      FieldName = 'fec_creacion'
    end
    object TArchivosPOSNETSfec_importacion: TDateField
      FieldName = 'fec_importacion'
    end
    object TArchivosPOSNETSfec_cierre: TDateField
      FieldName = 'fec_cierre'
    end
    object TArchivosPOSNETShora_importacion: TStringField
      FieldName = 'hora_importacion'
      Size = 5
    end
    object TArchivosPOSNETSoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TArchivosPOSNETSarch_texto: TMemoField
      FieldName = 'arch_texto'
      BlobType = ftMemo
    end
    object TArchivosPOSNETStarjeta: TStringField
      FieldName = 'tarjeta'
      Size = 50
    end
  end
  object dsArchivosPOSNETS: TDataSource
    DataSet = TArchivosPOSNETS
    Left = 109
    Top = 316
  end
end
