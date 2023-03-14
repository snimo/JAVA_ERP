inherited FTabControlCIP: TFTabControlCIP
  Left = 42
  Top = 140
  Caption = 'Tablero de control T'#233'cnico'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 1016
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
    Width = 1016
    Height = 633
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object Panel3: TPanel
      Left = 1
      Top = 1
      Width = 1014
      Height = 40
      Align = alTop
      BevelOuter = bvNone
      Color = clWindow
      TabOrder = 0
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 24
        Top = 16
        Caption = 'Logs de Mensajes Activos?'
        DataBinding.DataField = 'logs_mens_activos'
        DataBinding.DataSource = DSInput
        Properties.ImmediatePost = True
        TabOrder = 0
        Width = 161
      end
      object snDBCheckEdit2: TsnDBCheckEdit
        Left = 200
        Top = 16
        Caption = 'Activar Antipassback?'
        DataBinding.DataField = 'act_anti_pass_back'
        DataBinding.DataSource = DSInput
        Properties.ImmediatePost = True
        TabOrder = 1
        Width = 137
      end
      object snDBActivarCacheo: TsnDBCheckEdit
        Left = 360
        Top = 16
        Caption = 'Activar Cacheo?'
        DataBinding.DataField = 'activar_cacheo'
        DataBinding.DataSource = DSInput
        Properties.ImmediatePost = True
        TabOrder = 2
        Width = 113
      end
    end
    object Panel4: TPanel
      Left = 1
      Top = 41
      Width = 1014
      Height = 591
      Align = alClient
      BorderWidth = 5
      Color = clWindow
      TabOrder = 1
      object PageControlSN1: TPageControlSN
        Left = 6
        Top = 6
        Width = 1002
        Height = 579
        ActivePage = TabSheet1
        Align = alClient
        TabOrder = 0
        object TabSheet1: TTabSheet
          Caption = 'Tablero T'#233'cnico'
          object Panel5: TPanel
            Left = 0
            Top = 0
            Width = 994
            Height = 11
            Align = alTop
            BevelOuter = bvNone
            Color = clWindow
            TabOrder = 0
          end
          object Panel6: TPanel
            Left = 0
            Top = 11
            Width = 994
            Height = 540
            Align = alClient
            BevelOuter = bvNone
            BevelWidth = 5
            BorderWidth = 5
            Color = clWindow
            TabOrder = 1
            object dxDBGridSN1: TdxDBGridSN
              Left = 5
              Top = 5
              Width = 984
              Height = 530
              Align = alClient
              TabOrder = 0
              CriteriosPintarCelda = <>
              object dxDBGridSN1DBTableView1: TcxGridDBTableView
                NavigatorButtons.ConfirmDelete = False
                DataController.DataSource = DSTableroTecnico
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsCustomize.ColumnFiltering = False
                OptionsData.Deleting = False
                OptionsData.Inserting = False
                OptionsView.GroupByBox = False
                object dxDBGridSN1DBTableView1cod_puerta: TcxGridDBColumn
                  Caption = 'Puerta'
                  DataBinding.FieldName = 'cod_puerta'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 59
                end
                object dxDBGridSN1DBTableView1desc_puerta: TcxGridDBColumn
                  Caption = 'Descripci'#243'n Puerta'
                  DataBinding.FieldName = 'desc_puerta'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 112
                end
                object dxDBGridSN1DBTableView1ip: TcxGridDBColumn
                  Caption = 'Direcci'#243'n IP'
                  DataBinding.FieldName = 'ip'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 127
                end
                object dxDBGridSN1DBTableView1puerto: TcxGridDBColumn
                  Caption = 'Puerto'
                  DataBinding.FieldName = 'puerto'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 49
                end
                object dxDBGridSN1DBTableView1fec_hor_inicio_ol: TcxGridDBColumn
                  Caption = 'Fec / Hor Inicio ONLINE'
                  DataBinding.FieldName = 'fec_hor_inicio_ol'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 131
                end
                object dxDBGridSN1DBTableView1fec_hor_ult_status: TcxGridDBColumn
                  Caption = 'Fec / Hor Ult. Status'
                  DataBinding.FieldName = 'fec_hor_ult_status'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 120
                end
                object dxDBGridSN1DBTableView1Column1: TcxGridDBColumn
                  Caption = 'Fec. Hor. Armado L.B.'
                  DataBinding.FieldName = 'fec_hot_act_lb'
                  Options.Editing = False
                  Width = 108
                end
                object dxDBGridSN1DBTableView1Column2: TcxGridDBColumn
                  Caption = 'Fec. Hor. Carga en Placa L.B.'
                  DataBinding.FieldName = 'fec_hot_car_lb'
                  Options.Editing = False
                  Width = 145
                end
                object dxDBGridSN1DBTableView1Column3: TcxGridDBColumn
                  Caption = 'Cant. Elem. L.B.'
                  DataBinding.FieldName = 'cant_elementos_lb'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 80
                end
                object dxDBGridSN1DBTableView1reiniciar: TcxGridDBColumn
                  Caption = 'Reiniciar'
                  DataBinding.FieldName = 'reiniciar'
                  PropertiesClassName = 'TcxButtonEditProperties'
                  Properties.Buttons = <
                    item
                      Default = True
                      Kind = bkEllipsis
                    end>
                  Properties.ReadOnly = True
                  HeaderAlignmentHorz = taCenter
                  Width = 89
                end
                object DBColEntrada: TcxGridDBColumn
                  Caption = 'Entrada'
                  DataBinding.FieldName = 'hab_entrada'
                  PropertiesClassName = 'TcxButtonEditProperties'
                  Properties.Buttons = <
                    item
                      Default = True
                      Kind = bkEllipsis
                    end>
                  Properties.ReadOnly = True
                  HeaderAlignmentHorz = taCenter
                  Width = 80
                end
                object DBColSalida: TcxGridDBColumn
                  Caption = 'Salida'
                  DataBinding.FieldName = 'hab_salida'
                  PropertiesClassName = 'TcxButtonEditProperties'
                  Properties.Buttons = <
                    item
                      Default = True
                      Kind = bkEllipsis
                    end>
                  Properties.ReadOnly = True
                  HeaderAlignmentHorz = taCenter
                  Width = 80
                end
              end
              object dxDBGridSN1Level1: TcxGridLevel
                GridView = dxDBGridSN1DBTableView1
              end
            end
          end
        end
        object TabSheet2: TTabSheet
          Caption = 'Lista Blanca para contingencia'
          ImageIndex = 1
          object snLabel1: TsnLabel
            Left = 16
            Top = 22
            Width = 82
            Height = 13
            Caption = 'Punto de Acceso'
          end
          object snLabel2: TsnLabel
            Left = 112
            Top = 48
            Width = 497
            Height = 13
            Caption = 
              'Prepara la lista blanca con la '#250'ltima informaci'#243'n de Legajos y T' +
              'arjetas, para que sea tomada por la placa .'
          end
          object snLabel3: TsnLabel
            Left = 112
            Top = 72
            Width = 296
            Height = 13
            Caption = 'Se puede seleccionar un punto de Acceso espec'#237'fico o todos.'
          end
          object snDBLookup1: TsnDBLookup
            Left = 112
            Top = 18
            DataBinding.DataField = 'oid_puerta'
            DataBinding.DataSource = DSInput
            Properties.KeyFieldNames = 'oid'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSPuertas
            TabOrder = 0
            Width = 145
          end
          object BotonPrepararLB: TsnButton
            Left = 112
            Top = 96
            Width = 145
            Height = 25
            Caption = 'Preparar Lista Blanca'
            TabOrder = 1
            LookAndFeel.Kind = lfOffice11
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TTableroTecnico
        TableName = 'TTableroTecnico'
      end
      item
        DataSet = TLogsMensAct
        TableName = 'TLogsMensAct'
      end
      item
        DataSet = TActAntiPassBack
        TableName = 'TActAntiPassBack'
      end
      item
        DataSet = TActCacheo
        TableName = 'TActCacheo'
      end>
    Top = 128
  end
  inherited Operacion: TOperacion
    Top = 128
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Top = 128
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Top = 128
  end
  inherited DriverEvent: TDriverEvent
    OnChangeField = <
      item
        TableName = 'TInput'
        FieldName = 'logs_mens_activos'
        Source.Strings = (
          'begin'
          '  if (Sender.AsBoolean)'
          '      then activarLogsMensajes()'
          '      else desactivarLogsMensajes();'
          'end.')
      end
      item
        TableName = 'TInput'
        FieldName = 'act_anti_pass_back'
        Source.Strings = (
          'begin'
          '  if (Sender.AsBoolean)'
          '      then activarAntiPassBack()'
          '      else desactivarAntiPassBack();'
          'end.')
      end
      item
        TableName = 'TInput'
        FieldName = 'activar_cacheo'
        Source.Strings = (
          'begin'
          '  if (Sender.AsBoolean)'
          '      then activarCacheo()'
          '      else desactivarCacheo();'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  varios.setImagen('#39'ImageSalir'#39',7);'
          '  cargarPuntosDeAcceso();'
          '  TraerTableroTecnicoCIP();'
          '  TraerLogsMensActivos();'
          '  TraerActAntiPassBack();'
          '  TraerActCacheo();'
          '  Init();'
          '  setOpcionesSeguridad();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure activarLogsMensajes();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveActLogsMensajes'#39');'
          ' operacion.AddAtribute('#39'activa'#39','#39#39');  '
          '  operacion.execute;'
          'end;'
          ''
          'procedure activarAntiPassBack();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveActAntiPassBack'#39');'
          ' operacion.AddAtribute('#39'activa'#39','#39#39');  '
          '  operacion.execute;'
          'end;'
          ''
          'procedure activarCacheo();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveActCacheo'#39');'
          ' operacion.AddAtribute('#39'activa'#39','#39#39');  '
          '  operacion.execute;'
          'end;'
          ''
          'procedure desactivarCacheo();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveActCacheo'#39');'
          '  operacion.execute;'
          'end;'
          ''
          ''
          'procedure desactivarLogsMensajes();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveActLogsMensajes'#39');'
          '  operacion.execute;'
          'end;'
          ''
          'procedure desactivarAntiPassBack();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveActAntiPassBack'#39');'
          '  operacion.execute;'
          'end;'
          ''
          'procedure TraerLogsMensActivos();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerActLogsMens'#39');'
          '  operacion.execute();'
          'end;'
          ''
          'procedure TraerActCacheo();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerActCacheo'#39');'
          '  operacion.execute();'
          'end;'
          ''
          ''
          'procedure TraerActAntiPassBack();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerActAntiPassBack'#39');'
          '  operacion.execute();'
          'end;'
          ''
          ''
          ''
          'procedure prepararListaBlanca(OidPuerta : integer);'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'PrepararListaBlancaNegra'#39');'
          '  operacion.AddAtribute('#39'oid_puerta'#39',IntToStr(OidPuerta));'
          '  operacion.execute(); '
          'end;'
          ''
          'procedure AbrirPuertaEntrada(OidPuerta : integer);'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'AbrirPuertaEntrada'#39');'
          '  operacion.AddAtribute('#39'oid_puerta'#39',IntToStr(OidPuerta));'
          '  operacion.execute(); '
          'end;'
          ''
          'procedure AbrirPuertaSalida(OidPuerta : integer);'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'AbrirPuertaSalida'#39');'
          '  operacion.AddAtribute('#39'oid_puerta'#39',IntToStr(OidPuerta));'
          '  operacion.execute(); '
          'end;'
          ''
          'procedure Init();'
          'begin'
          '  TInput.close;'
          '  TInput.Open;'
          '  TInput.AppendRecord;'
          
            '  TInput.FieldName('#39'logs_mens_activos'#39').AsBoolean :=  TLogsMensA' +
            'ct.FieldName('#39'activo'#39').AsBoolean;'
          
            '  TInput.FieldName('#39'act_anti_pass_back'#39').AsBoolean :=  TActAntiP' +
            'assBack.FieldName('#39'activo'#39').AsBoolean;'
          
            '  TInput.FieldName('#39'activar_cacheo'#39').AsBoolean := TActCacheo.Fie' +
            'ldName('#39'activo'#39').AsBoolean;'
          'end;'
          ''
          'procedure cargarPuntosDeAcceso();'
          'begin'
          '  TPuertas.loadFromHelp('#39'HelpPuertas'#39');'
          '  TPuertas.append;'
          '  TPuertas.FieldName('#39'oid'#39').AsInteger := 0;'
          '  TPuertas.FieldName('#39'codigo'#39').AsString := '#39'0'#39';'
          
            '  TPuertas.FieldName('#39'descripcion'#39').AsString := '#39'Todas los Punto' +
            's'#39';'
          '  TPuertas.PostRecord;'
          'end;'
          ''
          'procedure TraerTableroTecnicoCIP();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTableroTecnicoCIP'#39');'
          '  operacion.execute();'
          'end;'
          ''
          'procedure ReiniciarPuerta(OidPuerta : integer);'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'ReiniciarPlaca'#39');'
          ' operacion.AddAtribute('#39'oid_puerta'#39',IntToStr(OidPuerta));'
          ' operacion.execute();'
          'end;'
          ''
          'procedure setOpcionesSeguridad();'
          'begin'
          ''
          '   if (Varios.isFuncionSeguridadHabilitada(1012,'#39#39',false))'
          '       then snDBCheckEdit2.setEnable(true) '
          '       else snDBCheckEdit2.setEnable(false);'
          ''
          '   if (Varios.isFuncionSeguridadHabilitada(1013,'#39#39',false))'
          '       then snDBCheckEdit1.setEnable(true) '
          '       else snDBCheckEdit1.setEnable(false);'
          ''
          ''
          '   if (Varios.isFuncionSeguridadHabilitada(1015,'#39#39',false))'
          '       then dxDBGridSN1.setColumnaVisible('#39'reiniciar'#39',true)'
          '       else dxDBGridSN1.setColumnaVisible('#39'reiniciar'#39',false);'
          ''
          '   if (Varios.isFuncionSeguridadHabilitada(1016,'#39#39',false))'
          '       then dxDBGridSN1.setColumnaVisible('#39'hab_entrada'#39',true)'
          '       else dxDBGridSN1.setColumnaVisible('#39'hab_entrada'#39',false);'
          ''
          '   if (Varios.isFuncionSeguridadHabilitada(1017,'#39#39',false))'
          '       then dxDBGridSN1.setColumnaVisible('#39'hab_salida'#39',true)'
          '       else dxDBGridSN1.setColumnaVisible('#39'hab_salida'#39',false);'
          ''
          '   if (Varios.isFuncionSeguridadHabilitada(1018,'#39#39',false))'
          '       then PageControlSN1.setTabVisible('#39'TabSheet2'#39',true)'
          '       else PageControlSN1.setTabVisible('#39'TabSheet2'#39',false);'
          '   if (Varios.isFuncionSeguridadHabilitada(1014,'#39#39',false))'
          '       then PageControlSN1.setTabVisible('#39'TabSheet1'#39',true)'
          '       else PageControlSN1.setTabVisible('#39'TabSheet1'#39',false);'
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
        ButtonName = 'BotonPrepararLB'
        Source.Strings = (
          'begin'
          
            '  if (mensaje.question('#39'Desea realizar la preparaci'#243'n de la List' +
            'a Blanca?'#39'))'
          '     then begin'
          
            '             prepararListaBlanca(TInput.FieldName('#39'oid_puerta'#39').' +
            'AsInteger);'
          '             mensaje.information('#39'Lista preparada'#39');'
          '             end;'
          'end.')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'dxDBGridSN1DBTableView1reiniciar'
        Source.Strings = (
          'begin'
          '  if (mensaje.question('#39'Desea reiniciar la placa?'#39'))'
          
            '     then ReiniciarPuerta(TTableroTecnico.FieldName('#39'oid_puerta'#39 +
            ').AsInteger);'
          'end.')
      end
      item
        ColumnName = 'DBColEntrada'
        Source.Strings = (
          'begin'
          '  if (mensaje.question('#39'Desea HABILITAR la ENTRADA?'#39'))'
          
            '     then AbrirPuertaEntrada(TTableroTecnico.FieldName('#39'oid_puer' +
            'ta'#39').AsInteger);'
          'end.')
      end
      item
        ColumnName = 'DBColSalida'
        Source.Strings = (
          'begin'
          '  if (mensaje.question('#39'Desea HABILITAR la SALIDA?'#39'))'
          
            '     then AbrirPuertaSalida(TTableroTecnico.FieldName('#39'oid_puert' +
            'a'#39').AsInteger);'
          'end.')
      end>
    Top = 131
  end
  inherited SaveArchivo: TSaveDialog
    Left = 336
    Top = 184
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
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
    Top = 16
    object TInputoid_puerta: TIntegerField
      FieldName = 'oid_puerta'
    end
    object TInputlogs_mens_activos: TBooleanField
      FieldName = 'logs_mens_activos'
    end
    object TInputact_anti_pass_back: TBooleanField
      FieldName = 'act_anti_pass_back'
    end
    object TInputactivar_cacheo: TBooleanField
      FieldName = 'activar_cacheo'
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 136
    Top = 16
  end
  object HelpPuertas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.Puerta'
    TipoHelp = thCustom
    NroHelp = 5
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
    Titulo = 'Puertas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 319
    Top = 246
  end
  object TPuertas: TsnTable
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
    Left = 351
    Top = 246
    object TPuertasoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPuertascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TPuertasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSPuertas: TDataSource
    DataSet = TPuertas
    Left = 386
    Top = 244
  end
  object TTableroTecnico: TsnTable
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
    Left = 131
    Top = 223
    object TTableroTecnicooid_puerta: TIntegerField
      FieldName = 'oid_puerta'
    end
    object TTableroTecnicocod_puerta: TStringField
      FieldName = 'cod_puerta'
      Size = 50
    end
    object TTableroTecnicodesc_puerta: TStringField
      FieldName = 'desc_puerta'
      Size = 100
    end
    object TTableroTecnicoip: TStringField
      FieldName = 'ip'
      Size = 50
    end
    object TTableroTecnicopuerto: TIntegerField
      FieldName = 'puerto'
    end
    object TTableroTecnicoping: TStringField
      FieldName = 'ping'
      Size = 10
    end
    object TTableroTecnicofec_hor_inicio_ol: TStringField
      FieldName = 'fec_hor_inicio_ol'
      Size = 50
    end
    object TTableroTecnicofec_hor_ult_status: TStringField
      FieldName = 'fec_hor_ult_status'
      Size = 50
    end
    object TTableroTecnicoreiniciar: TStringField
      FieldName = 'reiniciar'
      Size = 50
    end
    object TTableroTecnicohab_entrada: TStringField
      FieldName = 'hab_entrada'
      Size = 50
    end
    object TTableroTecnicohab_salida: TStringField
      FieldName = 'hab_salida'
      Size = 50
    end
    object TTableroTecnicofec_hot_act_lb: TStringField
      FieldName = 'fec_hot_act_lb'
      Size = 50
    end
    object TTableroTecnicofec_hot_car_lb: TStringField
      FieldName = 'fec_hot_car_lb'
      Size = 50
    end
    object TTableroTecnicocant_elementos_lb: TIntegerField
      FieldName = 'cant_elementos_lb'
    end
  end
  object DSTableroTecnico: TDataSource
    DataSet = TTableroTecnico
    Left = 171
    Top = 223
  end
  object TLogsMensAct: TsnTable
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
    Left = 203
    Top = 163
    object TLogsMensActactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object TActAntiPassBack: TsnTable
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
    Left = 529
    Top = 58
    object TActAntiPassBackactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object TActCacheo: TsnTable
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
    Left = 307
    Top = 379
    object TActCacheoactivo: TBooleanField
      FieldName = 'activo'
    end
  end
end
