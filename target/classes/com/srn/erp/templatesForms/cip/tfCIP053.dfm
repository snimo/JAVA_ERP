inherited FEstadMovVisita: TFEstadMovVisita
  Left = 37
  Top = 42
  Width = 894
  Height = 613
  Caption = 'Estad'#237'stica de Movimientos Visitas'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 878
    Height = 95
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object ImageBuscar: TImage
      Left = 18
      Top = 5
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = '<F12> Buscar Comprobantes'
      ParentShowHint = False
      ShowHint = True
    end
    object ImageSalir: TImage
      Tag = 7
      Left = 66
      Top = 5
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object Label1: TLabel
      Left = 16
      Top = 77
      Width = 420
      Height = 16
      Caption = 
        'Ingresar las Visitas a consultar (Si se deja en blanco se asumen' +
        ' todas)'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clNavy
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label2: TLabel
      Left = 16
      Top = 48
      Width = 80
      Height = 16
      Caption = 'Fecha desde'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clNavy
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label4: TLabel
      Left = 448
      Top = 48
      Width = 71
      Height = 16
      Caption = 'Agrupar por'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clNavy
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label5: TLabel
      Left = 224
      Top = 48
      Width = 74
      Height = 16
      Caption = 'Fecha hasta'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clNavy
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object DBFechaDesde: TsnDBDateEdit
      Left = 110
      Top = 45
      DataBinding.DataField = 'fec_desde'
      DataBinding.DataSource = DSInput
      Properties.ImmediatePost = True
      TabOrder = 0
      ReadOnlyAlways = False
      Width = 89
    end
    object snDBLookup1: TsnDBLookup
      Left = 526
      Top = 45
      DataBinding.DataField = 'oid_clasif_agrupador'
      DataBinding.DataSource = DSInput
      Properties.ImmediatePost = True
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSClasifVisAct
      TabOrder = 2
      Width = 281
    end
    object DBFechaHasta: TsnDBDateEdit
      Left = 310
      Top = 45
      DataBinding.DataField = 'fec_hasta'
      DataBinding.DataSource = DSInput
      Properties.ImmediatePost = True
      TabOrder = 1
      ReadOnlyAlways = False
      Width = 89
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 556
    Width = 878
    Height = 19
    Align = alBottom
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 95
    Width = 878
    Height = 461
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 2
    object Splitter1: TSplitter
      Left = 0
      Top = 215
      Width = 878
      Height = 3
      Cursor = crVSplit
      Align = alTop
    end
    object PanelEstado1: TPanelEstado
      Left = 0
      Top = 0
      Width = 878
      Height = 215
      Align = alTop
      BorderWidth = 10
      Color = clWindow
      TabOrder = 0
      Leyendas = <>
      object dxDBGridSN1: TdxDBGridSN
        Left = 11
        Top = 11
        Width = 856
        Height = 193
        Align = alClient
        PopupMenu = snPopMenu1
        TabOrder = 0
        LookAndFeel.Kind = lfFlat
        CriteriosPintarCelda = <>
        object dxDBGridSN1DBTableView1: TcxGridDBTableView
          NavigatorButtons.ConfirmDelete = False
          DataController.DataSource = DSVisitasAPlanif
          DataController.Summary.DefaultGroupSummaryItems = <>
          DataController.Summary.FooterSummaryItems = <>
          DataController.Summary.SummaryGroups = <>
          OptionsBehavior.AlwaysShowEditor = True
          OptionsCustomize.ColumnFiltering = False
          OptionsData.Appending = True
          OptionsData.Deleting = False
          OptionsData.DeletingConfirmation = False
          OptionsSelection.InvertSelect = False
          OptionsView.GroupByBox = False
          object dxDBGridSN1DBTableView1codigo: TcxGridDBColumn
            Caption = 'Legajo'
            DataBinding.FieldName = 'codigo'
            PropertiesClassName = 'TcxButtonEditProperties'
            Properties.Buttons = <
              item
                Default = True
                Kind = bkEllipsis
              end>
            HeaderAlignmentHorz = taCenter
            Width = 147
          end
          object dxDBGridSN1DBTableView1nombre: TcxGridDBColumn
            Caption = 'Apellido y Nombre'
            DataBinding.FieldName = 'nombre'
            HeaderAlignmentHorz = taCenter
            Options.Focusing = False
            Width = 438
          end
        end
        object dxDBGridSN1Level1: TcxGridLevel
          GridView = dxDBGridSN1DBTableView1
        end
      end
    end
    object Panel4: TPanel
      Left = 0
      Top = 218
      Width = 878
      Height = 243
      Align = alClient
      BevelOuter = bvLowered
      BorderWidth = 10
      Color = clWindow
      TabOrder = 1
      object Panel5: TPanel
        Left = 11
        Top = 11
        Width = 856
        Height = 29
        Align = alTop
        BevelOuter = bvNone
        Color = clWindow
        TabOrder = 0
        object Label3: TLabel
          Left = 8
          Top = 3
          Width = 580
          Height = 16
          Caption = 
            'Seleccionar el clasificador del panel izquierda y cargar los val' +
            'ores a filtrar sobre el panel derecho'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clNavy
          Font.Height = -13
          Font.Name = 'MS Sans Serif'
          Font.Style = []
          ParentFont = False
        end
      end
      object Panel6: TPanel
        Left = 11
        Top = 40
        Width = 856
        Height = 192
        Align = alClient
        Color = clWindow
        TabOrder = 1
        object Splitter2: TSplitter
          Left = 329
          Top = 1
          Height = 190
        end
        object Panel7: TPanel
          Left = 1
          Top = 1
          Width = 328
          Height = 190
          Align = alLeft
          BevelOuter = bvNone
          Color = clWindow
          TabOrder = 0
          object dxDBGridSN2: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 328
            Height = 190
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object cxGridDBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSClasifLeg1
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.AlwaysShowEditor = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsData.Editing = False
              OptionsSelection.HideFocusRectOnExit = False
              OptionsSelection.InvertSelect = False
              OptionsSelection.UnselectFocusedRecordOnExit = False
              OptionsView.GroupByBox = False
              object cxGridDBColumn1: TcxGridDBColumn
                Caption = 'Clasificador'
                DataBinding.FieldName = 'descripcion'
                PropertiesClassName = 'TcxButtonEditProperties'
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Width = 303
              end
            end
            object cxGridLevel1: TcxGridLevel
              GridView = cxGridDBTableView1
            end
          end
        end
        object Panel8: TPanel
          Left = 332
          Top = 1
          Width = 523
          Height = 190
          Align = alClient
          BevelOuter = bvNone
          Color = clWindow
          TabOrder = 1
          object Panel9: TPanel
            Left = 0
            Top = 0
            Width = 523
            Height = 33
            Align = alTop
            BevelOuter = bvNone
            Color = clWindow
            TabOrder = 0
            object snLabel1: TsnLabel
              Left = 16
              Top = 8
              Width = 120
              Height = 13
              Caption = 'Clasificador seleccionado'
            end
            object snDBEdit1: TsnDBEdit
              Left = 144
              Top = 5
              TabStop = False
              DataBinding.DataField = 'descripcion'
              DataBinding.DataSource = DSClasifLeg1
              Properties.ReadOnly = True
              Style.Edges = []
              TabOrder = 0
              Width = 356
            end
          end
          object Panel10: TPanel
            Left = 0
            Top = 33
            Width = 523
            Height = 157
            Align = alClient
            BevelOuter = bvNone
            Color = clWindow
            TabOrder = 1
            object dxDBGridSN3: TdxDBGridSN
              Left = 0
              Top = 0
              Width = 523
              Height = 157
              Align = alClient
              PopupMenu = snPopMenu2
              TabOrder = 0
              LookAndFeel.Kind = lfFlat
              CriteriosPintarCelda = <>
              object dxDBGridSN3DBTableView1: TcxGridDBTableView
                NavigatorButtons.ConfirmDelete = False
                DataController.DataSource = DSValoresClasificador
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.AlwaysShowEditor = True
                OptionsCustomize.ColumnFiltering = False
                OptionsData.Appending = True
                OptionsData.Deleting = False
                OptionsView.GroupByBox = False
                object dxDBGridSN3DBTableView1Column1: TcxGridDBColumn
                  DataBinding.FieldName = 'orden'
                  Visible = False
                  SortIndex = 0
                  SortOrder = soAscending
                end
                object dxDBGridSN3DBTableView1cod_valor_clasif: TcxGridDBColumn
                  Caption = 'C'#243'digo'
                  DataBinding.FieldName = 'cod_valor_clasif'
                  PropertiesClassName = 'TcxButtonEditProperties'
                  Properties.Buttons = <
                    item
                      Default = True
                      Kind = bkEllipsis
                    end>
                  Properties.ClickKey = 112
                  HeaderAlignmentHorz = taCenter
                  Width = 112
                end
                object dxDBGridSN3DBTableView1desc_valor_clasif: TcxGridDBColumn
                  Caption = 'Descripci'#243'n'
                  DataBinding.FieldName = 'desc_valor_clasif'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Options.Focusing = False
                  Width = 344
                end
              end
              object dxDBGridSN3Level1: TcxGridLevel
                GridView = dxDBGridSN3DBTableView1
              end
            end
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TClasificadoresEntidad
        TableName = 'TClasificadoresEntidad'
      end
      item
        DataSet = TValorClaifEntidad
        TableName = 'TValorClaifEntidad'
      end>
    Top = 112
  end
  inherited Operacion: TOperacion
    Top = 112
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Top = 112
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Top = 112
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      'end.')
    OnValidate = <
      item
        TableName = 'TVisitasAPlanif'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorVisita.Value := Sender.AsString;'
          '  ValidadorVisita.Validar;'
          'end.')
      end
      item
        TableName = 'TValoresClasificador'
        FieldName = 'cod_valor_clasif'
        Source.Strings = (
          'begin'
          
            '   ValidarValorClasifEntidad(TClasificadoresEntidad.FieldName('#39'o' +
            'id_clasif_ent'#39').AsInteger,'
          '                                          Sender.AsString);'
          'end.'
          '')
      end>
    OnClickItemMenuPopUp = <
      item
        PopUpMenuName = 'snPopMenu1'
        ItemMenuName = 'EliminarLegajo1'
        Source.Strings = (
          'begin'
          '  TVisitasAPlanif.borrar;'
          'end.')
        HabilitadoNuevo = True
        HabilitadoModificar = True
        HabilitadoOtros = True
      end
      item
        PopUpMenuName = 'snPopMenu2'
        ItemMenuName = 'MenuItem1'
        Source.Strings = (
          'begin'
          '  TValoresClasificador.Borrar();'
          'end.')
        HabilitadoNuevo = False
        HabilitadoModificar = False
        HabilitadoOtros = False
      end>
    OnBeforePost = <
      item
        TableName = 'TValoresClasificador'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_valor_clasif'#39').AsInteger=0)'
          
            '     then RaiseException(erCustomError,'#39'Debe ingresar el Valor d' +
            'el clasificador'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TVisitasAPlanif'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid'#39').AsInteger := TInput.FieldName('#39'oid'#39').' +
            'AsInteger;'
          'end.')
      end
      item
        TableName = 'TValoresClasificador'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_clasificador'#39').AsInteger := TClasificad' +
            'oresEntidad.FieldName('#39'oid_clasif_ent'#39').AsInteger;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  varios.setImagen('#39'ImageBuscar'#39',0);'
          '  varios.setImagen('#39'ImageSalir'#39',7);'
          '  inicializarDatos();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure dumyActu();'
          'begin'
          '  TClasificadoresEntidad.First;'
          '  while (not TClasificadoresEntidad.eof) do'
          '     begin'
          '     TClasificadoresEntidad.EditRecord;'
          '     TClasificadoresEntidad.FieldName('#39'tag'#39').AsInteger :=1; '
          '     TClasificadoresEntidad.PostRecord;'
          '     TClasificadoresEntidad.next;'
          '     end;'
          'end;'
          ''
          ''
          'procedure TraerClasifVisita();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerClasificadoresNickName'#39');'
          '  operacion.addAtribute('#39'nickname'#39','#39'cip.Visita'#39');'
          '  operacion.AddAtribute('#39'SOLO_ACTIVO'#39','#39#39');'
          '  operacion.execute();'
          'end;'
          ''
          ''
          'procedure inicializarDatos();'
          'begin'
          ' THelpClasifVisAct.loadFromHelp('#39'HelpClasifVisActivos'#39'); '
          ' TInput.Close;'
          ' TInput.Open;'
          ' TraerClasifVisita();'
          '  dumyActu();'
          ' TVisitasAPlanif.Close;'
          ' TVisitasAPlanif.Open;'
          ' TValoresClasificador.Close;'
          ' TValoresClasificador.Open;'
          '  '
          'end;'
          ''
          'procedure MostrarHelpValoresClasificador();'
          'begin'
          ''
          
            '  if (TClasificadoresEntidad.FieldName('#39'nro_clasif'#39').AsInteger=0' +
            ')'
          
            '      then raiseException(erCustomError,'#39'Debe seleccionar un cla' +
            'sificador'#39');'
          ''
          '   HelpValoresClasificador.NickName   :=  '#39'cip.Visita'#39';'
          
            '   HelpValoresClasificador.NroClasificador    :=  TClasificadore' +
            'sEntidad.FieldName('#39'nro_clasif'#39').AsInteger;'
          '   HelpValoresClasificador.Mostrar();'
          'end;'
          ''
          ''
          'procedure ValidarValorClasifEntidad(OidClasifEnt : integer ;'
          
            '                                                         codigo ' +
            ': string);'
          'begin'
          ''
          '  if (codigo = '#39#39')'
          '     then begin'
          '             TValoresClasificador.EditRecord;  '
          
            '             TValoresClasificador.FieldName('#39'oid_valor_clasif'#39').' +
            'AsInteger := 0;'
          
            '             TValoresClasificador.FieldName('#39'desc_valor_clasif'#39')' +
            '.AsString := '#39#39';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifEntidad'#39');'
          
            '  operacion.addAtribute('#39'oid_clasif_ent'#39',IntToStr(OidClasifEnt))' +
            ';'
          '  operacion.addAtribute('#39'codigo'#39',codigo);'
          '  operacion.addAtribute('#39'solo_titulos'#39','#39#39');'
          '  operacion.execute;'
          ''
          '  TValoresClasificador.EditRecord; '
          
            '  TValoresClasificador.FieldName('#39'oid_valor_clasif'#39').AsInteger :' +
            '='
          
            '    TValorClaifEntidad.FieldName('#39'oid_valor_clasif_ent'#39').AsInteg' +
            'er;'
          
            '  TValoresClasificador.FieldName('#39'desc_valor_clasif'#39').AsString :' +
            '='
          '    TValorClaifEntidad.FieldName('#39'descripcion'#39').AsString;'
          ''
          'end;'
          ''
          ''
          'procedure EjecutarConsultaPlanificacion();'
          'begin'
          ''
          '  TInput.PostRecord;'
          '  TVisitasAPlanif.postRecord;'
          '  TValoresClasificador.postRecord;'
          '  '
          '  variable.newVariantArray('#39'parametros'#39',3);'
          
            '  variable.addKeyTableForArray('#39'parametros'#39',0,'#39'TInput'#39','#39'TInput'#39')' +
            ';  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',1,'#39'TVisitasAPlanif'#39',' +
            #39'TVisitasAPlanif'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',2,'#39'TValoresClasifica' +
            'dor'#39','#39'TValoresClasificador'#39');  '
          ''
          ''
          '  FormMovCIP.params :=  variable.getValue('#39'parametros'#39');'
          '  FormMovCIP.Ventana := getVentana();'
          '  FormMovCIP.Mostrar(false);'
          ''
          'end;'
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  close;'
          'end.')
      end
      item
        ButtonName = 'imageBuscar'
        Source.Strings = (
          'begin'
          '  EjecutarConsultaPlanificacion();'
          'end.')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'dxDBGridSN1DBTableView1codigo'
        Source.Strings = (
          'begin'
          '  HelpVisitas.Mostrar();'
          'end.')
      end
      item
        ColumnName = 'dxDBGridSN3DBTableView1cod_valor_clasif'
        Source.Strings = (
          'begin'
          '  MostrarHelpValoresClasificador();'
          'end.')
      end>
    OnAddAtributeHelp = <
      item
        HelpName = 'HelpClasifVisActivos'
        Source.Strings = (
          'begin'
          '  operacion.AddAtribute('#39'nickname'#39','#39'cip.Visita'#39');'
          'end.')
      end>
    Top = 115
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 504
    Top = 240
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 640
    Top = 185
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
        Name = 'fecha'
        DataType = ftDate
      end
      item
        Name = 'oid_clasif_agrupador'
        DataType = ftInteger
      end>
    IndexDefs = <>
    RecalcOnIndex = True
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
    MensajeValorDuplicadoIndice = 'Legajo ya ingresado'
    Left = 496
    Top = 104
    object TInputoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TInputoid_clasif_agrupador: TIntegerField
      FieldName = 'oid_clasif_agrupador'
    end
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 528
    Top = 105
  end
  object HelpClasifVisActivos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ge.ClasificadorEntidad'
    TipoHelp = thCustom
    NroHelp = 105
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
    Titulo = 'Clasificadores'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 599
    Top = 78
  end
  object THelpClasifVisAct: TsnTable
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
    Left = 631
    Top = 78
    object THelpClasifVisActoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object THelpClasifVisActcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object THelpClasifVisActdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSClasifVisAct: TDataSource
    DataSet = THelpClasifVisAct
    Left = 666
    Top = 76
  end
  object TVisitasAPlanif: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_leg_a_planif'
        DataType = ftInteger
      end
      item
        Name = 'oid'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'nombre'
        DataType = ftString
        Size = 255
      end>
    IndexFieldNames = 'oid;orden'
    IndexDefs = <
      item
        Name = 'TLegajosAPlanifIndex1'
        Fields = 'oid;orden'
      end
      item
        Name = 'TLegajosAPlanifIndex2'
        Fields = 'codigo'
        Options = [ixUnique]
      end>
    RecalcOnIndex = True
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterSource = DSInput
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 592
    Top = 145
    object TVisitasAPlanifoid_leg_a_planif: TIntegerField
      FieldName = 'oid_leg_a_planif'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TVisitasAPlanifoid: TIntegerField
      FieldName = 'oid'
    end
    object TVisitasAPlanifoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TVisitasAPlanifoid_visita: TIntegerField
      FieldName = 'oid_visita'
    end
    object TVisitasAPlanifcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TVisitasAPlanifnombre: TStringField
      FieldName = 'nombre'
      Size = 255
    end
    object TVisitasAPlaniforden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
    object TVisitasAPlanifoid_vis_a_planif: TIntegerField
      FieldName = 'oid_vis_a_planif'
    end
  end
  object DSVisitasAPlanif: TDataSource
    DataSet = TVisitasAPlanif
    Left = 624
    Top = 145
  end
  object HelpVisitas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.Visita'
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
        AsignarACampo = TVisitasAPlanifcodigo
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
    Titulo = 'Visitas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 218
    Top = 223
  end
  object ValidadorVisita: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.Visita'
    MensajeException = 'C'#243'digo de Visita Inexistente'
    CampoOID = TVisitasAPlanifoid_visita
    CampoDescripcion = TVisitasAPlanifnombre
    NroQuery = 0
    Cache = True
    Left = 254
    Top = 223
  end
  object TClasificadoresEntidad: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = False
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid'
        DataType = ftInteger
      end
      item
        Name = 'oid_clasif_ent'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'nro_clasif'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_input'
    IndexDefs = <>
    RecalcOnIndex = True
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    EnableVersioning = False
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid'
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 447
    Top = 155
    object TClasificadoresEntidadoid_clasif_ent: TIntegerField
      FieldName = 'oid_clasif_ent'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TClasificadoresEntidadcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TClasificadoresEntidaddescripcion: TStringField
      FieldName = 'descripcion'
      Size = 255
    end
    object TClasificadoresEntidadnro_clasif: TIntegerField
      FieldName = 'nro_clasif'
    end
    object TClasificadoresEntidadtag: TIntegerField
      FieldName = 'tag'
    end
  end
  object DSClasifLeg1: TDataSource
    DataSet = TClasificadoresEntidad
    Left = 482
    Top = 153
  end
  object snPopMenu1: TsnPopMenu
    Left = 128
    Top = 167
    object EliminarLegajo1: TMenuItem
      Caption = 'Eliminar Legajo'
    end
  end
  object TValoresClasificador: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = False
    AttachMaxCount = 1
    AutoCalcFields = False
    FieldDefs = <
      item
        Name = 'oid_renglon'
        DataType = ftInteger
      end
      item
        Name = 'oid_clasificador'
        DataType = ftInteger
      end
      item
        Name = 'oid_valor_clasif'
        DataType = ftInteger
      end
      item
        Name = 'cod_valor_clasif'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_valor_clasif'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_clasificador;orden'
    IndexDefs = <
      item
        Name = 'TValoresClasificadorIndex1'
        Fields = 'oid_clasificador;orden'
      end
      item
        Name = 'TValoresClasificadorIndex2'
        Fields = 'oid_clasificador;cod_valor_clasif'
        Options = [ixUnique]
      end>
    RecalcOnIndex = True
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    EnableVersioning = False
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterSource = DSClasifLeg1
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 408
    Top = 239
    object TValoresClasificadoroid_renglon: TIntegerField
      FieldName = 'oid_renglon'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TValoresClasificadoroid_clasificador: TIntegerField
      FieldName = 'oid_clasificador'
    end
    object TValoresClasificadoroid_valor_clasif: TIntegerField
      FieldName = 'oid_valor_clasif'
    end
    object TValoresClasificadorcod_valor_clasif: TStringField
      FieldName = 'cod_valor_clasif'
      Size = 50
    end
    object TValoresClasificadordesc_valor_clasif: TStringField
      FieldName = 'desc_valor_clasif'
      Size = 255
    end
    object TValoresClasificadororden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
  end
  object DSValoresClasificador: TDataSource
    DataSet = TValoresClasificador
    Left = 440
    Top = 239
  end
  object HelpValoresClasificador: THelpValoresClasificador
    AsignarCampoCodigo = TValoresClasificadorcod_valor_clasif
    NroClasificador = 0
    Left = 128
    Top = 217
  end
  object TValorClaifEntidad: TsnTable
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
    Left = 510
    Top = 364
    object TValorClaifEntidadoid_valor_clasif_ent: TIntegerField
      FieldName = 'oid_valor_clasif_ent'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TValorClaifEntidadcodigo: TStringField
      FieldName = 'codigo'
      Size = 30
    end
    object TValorClaifEntidaddescripcion: TStringField
      DisplayWidth = 255
      FieldName = 'descripcion'
      Size = 255
    end
    object TValorClaifEntidadoid_clasif_entidad: TIntegerField
      FieldName = 'oid_clasif_entidad'
    end
  end
  object FormMovCIP: TFormulario
    Nombre = 'TFConsMovVisCIP'
    CreateAlwaysANewForm = True
    Left = 224
    Top = 278
  end
  object snPopMenu2: TsnPopMenu
    Left = 400
    Top = 428
    object MenuItem1: TMenuItem
      Caption = 'Eliminar Valor'
    end
  end
end
