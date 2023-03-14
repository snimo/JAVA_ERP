inherited FEstadoAccesoCIP: TFEstadoAccesoCIP
  Left = 197
  Top = 104
  Width = 748
  Caption = 'Estados de Acceso'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 732
    inherited PPie: TPanel
      Width = 732
      inherited StatusBarABM: TStatusBar
        Left = 627
      end
      inherited StatusBar2: TStatusBar
        Width = 627
      end
    end
    inherited PMenu: TPanel
      Width = 732
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTEstadoCIP
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTEstadoCIP
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpEstados
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpEstados
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpEstados
      end
      inherited Panel2: TPanel
        Left = 691
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTEstadoCIP
        Leyendas = <
          item
            Titulo = 'Inactivo'
            ColorTitulo = clWhite
            ValorEstado = 'false'
            Visible = True
            ColorPanel = clRed
          end>
      end
    end
    inherited POpcionesMenu: TPanel
      Width = 732
    end
    inherited PCabecera: TPanel
      Width = 732
      Height = 253
      object Label1: TLabel
        Left = 40
        Top = 24
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 40
        Top = 64
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object snLabel1: TsnLabel
        Left = 40
        Top = 104
        Width = 74
        Height = 13
        Caption = 'Tipo de Ingreso'
      end
      object snLabel2: TsnLabel
        Left = 40
        Top = 176
        Width = 72
        Height = 13
        Caption = 'Tipo de Egreso'
      end
      object snLabel3: TsnLabel
        Left = 304
        Top = 104
        Width = 94
        Height = 13
        Caption = 'Leyenda no Ingresa'
      end
      object snLabel4: TsnLabel
        Left = 304
        Top = 176
        Width = 92
        Height = 13
        Caption = 'Leyenda no Egresa'
      end
      object snLabel5: TsnLabel
        Left = 128
        Top = 140
        Width = 107
        Height = 13
        Caption = 'Minutos Entrada Antes'
      end
      object snLabel6: TsnLabel
        Left = 328
        Top = 140
        Width = 122
        Height = 13
        Caption = 'Minutos Entrada Despu'#233's'
      end
      object DBECodigo: TsnDBEdit
        Left = 124
        Top = 20
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTEstadoCIP
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 197
      end
      object snDBEdit1: TsnDBEdit
        Left = 124
        Top = 60
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTEstadoCIP
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object snDBLookup1: TsnDBLookup
        Left = 124
        Top = 101
        DataBinding.DataField = 'tipo_ingreso'
        DataBinding.DataSource = DSTEstadoCIP
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposPermisos
        TabOrder = 2
        Width = 145
      end
      object snDBLookup2: TsnDBLookup
        Left = 124
        Top = 173
        DataBinding.DataField = 'tipo_egreso'
        DataBinding.DataSource = DSTEstadoCIP
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposPermisos
        TabOrder = 6
        Width = 145
      end
      object snDBEdit2: TsnDBEdit
        Left = 408
        Top = 100
        DataBinding.DataField = 'ley_ing_denegado'
        DataBinding.DataSource = DSTEstadoCIP
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 3
        Width = 305
      end
      object snDBEdit3: TsnDBEdit
        Left = 408
        Top = 172
        DataBinding.DataField = 'ley_egr_denegado'
        DataBinding.DataSource = DSTEstadoCIP
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 7
        Width = 305
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 37
        Top = 208
        Caption = 'Controlar Antipassback?'
        DataBinding.DataField = 'act_anti_pass_back'
        DataBinding.DataSource = DSTEstadoCIP
        TabOrder = 8
        Width = 172
      end
      object snDBCheckEdit2: TsnDBCheckEdit
        Left = 213
        Top = 207
        Caption = 'Susceptible de ir a cacheo'
        DataBinding.DataField = 'es_suscep_cacheo'
        DataBinding.DataSource = DSTEstadoCIP
        TabOrder = 9
        Width = 172
      end
      object snDBEdit4: TsnDBEdit
        Left = 248
        Top = 136
        DataBinding.DataField = 'min_ent_ant_ent'
        DataBinding.DataSource = DSTEstadoCIP
        TabOrder = 4
        Width = 65
      end
      object snDBEdit5: TsnDBEdit
        Left = 464
        Top = 136
        DataBinding.DataField = 'min_ent_des_ent'
        DataBinding.DataSource = DSTEstadoCIP
        TabOrder = 5
        Width = 65
      end
    end
    inherited PCuerpo: TPanel
      Top = 305
      Width = 732
      Height = 286
      BorderWidth = 10
      object PageControlSN1: TPageControlSN
        Left = 10
        Top = 10
        Width = 712
        Height = 266
        ActivePage = TabSheet2
        Align = alClient
        TabOrder = 0
        object TabSheet2: TTabSheet
          Caption = 'Habilitar Motivos Accesos al Predio'
          ImageIndex = 1
          object dxDBGridSN2: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 704
            Height = 238
            Align = alClient
            BorderWidth = 5
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object cxGridDBTableView2: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSTMotAccesosIntermedios
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.AlwaysShowEditor = True
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsCustomize.ColumnFiltering = False
              OptionsCustomize.ColumnSorting = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsData.Inserting = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object cxGridDBTableView2habilitado: TcxGridDBColumn
                Caption = 'Habilitado'
                DataBinding.FieldName = 'habilitado'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 83
              end
              object cxGridDBTableView2desc_motivo: TcxGridDBColumn
                Caption = 'Motivo'
                DataBinding.FieldName = 'desc_motivo'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Width = 310
              end
            end
            object cxGridLevel2: TcxGridLevel
              GridView = cxGridDBTableView2
            end
          end
        end
        object TabSheet3: TTabSheet
          Caption = 'Habilitar Accesos Internos'
          ImageIndex = 2
          object dxDBGridSN1: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 704
            Height = 287
            Align = alClient
            BorderWidth = 5
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object cxGridDBTableView3: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSTCatAccesoEstado
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.AlwaysShowEditor = True
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsCustomize.ColumnFiltering = False
              OptionsCustomize.ColumnSorting = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsData.Inserting = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object cxGridDBTableView3ACTIVO: TcxGridDBColumn
                Caption = 'Habilitar'
                DataBinding.FieldName = 'activo'
                HeaderAlignmentHorz = taCenter
                HeaderAlignmentVert = vaCenter
                Width = 80
              end
              object cxGridDBTableView3DESC_CATEG_ACCESO: TcxGridDBColumn
                Caption = 'Categor'#237'a de Acceso'
                DataBinding.FieldName = 'desc_categ_acceso'
                HeaderAlignmentHorz = taCenter
                HeaderAlignmentVert = vaCenter
                Width = 301
              end
            end
            object cxGridLevel3: TcxGridLevel
              GridView = cxGridDBTableView3
            end
          end
        end
        object TabSheet1: TTabSheet
          Caption = 'Equivalencias Externas de C'#243'digos'
          object dxDBGridSN3: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 704
            Height = 287
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object dxDBGridSN3DBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSTEquivalenciaEstadoCIP
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.AlwaysShowEditor = True
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object dxDBGridSN3DBTableView1Column1: TcxGridDBColumn
                DataBinding.FieldName = 'orden'
                Visible = False
                SortIndex = 0
                SortOrder = soAscending
              end
              object dxDBGridCodPuerta: TcxGridDBColumn
                Caption = 'C'#243'digo'
                DataBinding.FieldName = 'codigo_externo'
                HeaderAlignmentHorz = taCenter
                Width = 177
              end
              object dxDBGridSN3DBTableView1Column2: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 53
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
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerEstadoCIP'
    OperGrabarObjeto = 'SaveEstadoCIP'
    CargaDataSets = <
      item
        DataSet = TEstadoCIP
        TableName = 'TEstadoCIP'
      end
      item
        DataSet = TEquivalenciaEstadoCIP
        TableName = 'TEquivalenciaEstadoCIP'
      end
      item
        DataSet = TTiposPermisos
        TableName = 'TTiposPermisos'
      end
      item
        DataSet = TMotAccesosIntermedios
        TableName = 'TMotAccesosIntermedios'
      end
      item
        DataSet = TCatAccesoEstado
        TableName = 'TCatAccesoEstado'
      end>
    BajaLogica = <
      item
        DataSet = TEstadoCIP
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TEstadoCIP
    DataSetDet1 = TEquivalenciaEstadoCIP
    DataSetDet2 = TMotAccesosIntermedios
    DataSetDet3 = TCatAccesoEstado
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TEstadoCIP: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_estado'
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
        Size = 50
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'tipo_ingreso'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'tipo_egreso'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'ley_ing_denegado'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'ley_egr_denegado'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'act_anti_pass_back'
        DataType = ftBoolean
      end
      item
        Name = 'es_suscep_cacheo'
        DataType = ftBoolean
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
    Left = 608
    Top = 67
    object TEstadoCIPoid_estado: TIntegerField
      FieldName = 'oid_estado'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TEstadoCIPcodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TEstadoCIPdescripcion: TStringField
      DisplayWidth = 50
      FieldName = 'descripcion'
      Size = 50
    end
    object TEstadoCIPactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TEstadoCIPtipo_ingreso: TStringField
      FieldName = 'tipo_ingreso'
    end
    object TEstadoCIPtipo_egreso: TStringField
      FieldName = 'tipo_egreso'
    end
    object TEstadoCIPley_ing_denegado: TStringField
      FieldName = 'ley_ing_denegado'
      Size = 50
    end
    object TEstadoCIPley_egr_denegado: TStringField
      FieldName = 'ley_egr_denegado'
      Size = 50
    end
    object TEstadoCIPact_anti_pass_back: TBooleanField
      FieldName = 'act_anti_pass_back'
    end
    object TEstadoCIPes_suscep_cacheo: TBooleanField
      FieldName = 'es_suscep_cacheo'
    end
    object TEstadoCIPmin_ent_ant_ent: TIntegerField
      FieldName = 'min_ent_ant_ent'
    end
    object TEstadoCIPmin_ent_des_ent: TIntegerField
      FieldName = 'min_ent_des_ent'
    end
  end
  object DSTEstadoCIP: TDataSource [4]
    DataSet = TEstadoCIP
    Left = 640
    Top = 67
  end
  inherited TOidObjSave: TsnTable
    Left = 608
  end
  inherited TOpcHabPrograma: TsnTable
    Top = 16
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
    OnValidate = <
      item
        TableName = 'TEstadoCIP'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorEstado.Value := Sender.AsString;'
          '  ValidadorEstado.Validar;'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TEquivalenciaEstadoCIP'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'codigo_externo'#39').AsString='#39#39')'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el c'#243'digo' +
            ' externo'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TEquivalenciaEstadoCIP'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_estado'#39').AsInteger :='
          '    TEstadoCIP.FieldName('#39'oid_estado'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TraerTiposPermisos();'
          '  TMotAccInter.loadFromHelp('#39'HelpMotAccInter'#39');'
          '  TCategAccesos.loadFromHelp('#39'HelpCategAccesos'#39');'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerTiposPermisos();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTiposPermisosCIP'#39');'
          '  operacion.execute();  '
          'end;'
          ''
          'procedure AltaMotivosEntInter();'
          'var'
          '  i : integer;'
          'begin'
          '  i:= -1;'
          '  TMotAccInter.First;'
          '  while (not TMotAccInter.eof) do'
          '    begin'
          ''
          '    TMotAccesosIntermedios.AppendRecord;'
          '    TMotAccesosIntermedios.FieldName('#39'secu'#39').AsInteger := i;'
          
            '    TMotAccesosIntermedios.FieldName('#39'oid_estado'#39').AsInteger := ' +
            'TEstadoCIP.FieldName('#39'oid_estado'#39').AsInteger;'
          
            '    TMotAccesosIntermedios.FieldName('#39'habilitado'#39').AsBoolean := ' +
            'false;'
          
            '    TMotAccesosIntermedios.FieldName('#39'oid_motivo'#39').AsInteger := ' +
            'TMotAccInter.FieldName('#39'oid'#39').AsInteger;'
          
            '    TMotAccesosIntermedios.FieldName('#39'desc_motivo'#39').AsString := ' +
            'TMotAccInter.FieldName('#39'descripcion'#39').AsString; '
          '    TMotAccesosIntermedios.PostRecord;'
          ' '
          '    TMotAccInter.next;'
          '    i := i + 1; '
          '    end;'
          'end;'
          ''
          ''
          'procedure InicializarAltaAccesosInternos();'
          'var'
          '  secu : integer;'
          'begin'
          ''
          '  secu := 1;'
          ''
          '  TCatAccesoEstado.Close;'
          '  TCatAccesoEstado.Open;'
          ''
          '  TCategAccesos.First;'
          '  while (not TCategAccesos.EOF) do'
          '  begin'
          ''
          '    secu := secu + 1;'
          ''
          '    TCatAccesoEstado.AppendRecord; '
          '    TCatAccesoEstado.FieldName('#39'oid_acc_est'#39').AsInteger := secu;'
          
            '    TCatAccesoEstado.FieldName('#39'oid_estado'#39').AsInteger := TEstad' +
            'oCIP.FieldName('#39'oid_estado'#39').AsInteger;'
          
            '    TCatAccesoEstado.FieldName('#39'oid_categ_acceso'#39').AsInteger := ' +
            'TCategAccesos.FieldName('#39'oid'#39').AsInteger;'
          
            '    TCatAccesoEstado.FieldName('#39'desc_categ_acceso'#39').AsString := ' +
            'TCategAccesos.FieldName('#39'descripcion'#39').AsString;'
          '    TCatAccesoEstado.FieldName('#39'activo'#39').AsBoolean := false;'
          '    TCatAccesoEstado.PostRecord;   '
          ''
          '    TCategAccesos.next;'
          '  end;'
          ''
          'end;'
          '')
      end>
    OnAfterNuevo = <
      item
        Source.Strings = (
          'begin'
          '  AltaMotivosEntInter();'
          '  InicializarAltaAccesosInternos();'
          'end.')
      end>
  end
  inherited SaveArchivo: TSaveDialog
    Left = 384
    Top = 104
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 312
    Top = 240
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 472
    Top = 59
  end
  object HelpEstados: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.EstadoCIP'
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
    Titulo = 'Estados CIP'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorEstado: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.EstadoCIP'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Estado duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
  object TEquivalenciaEstadoCIP: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_equiv_estado'
        DataType = ftInteger
      end
      item
        Name = 'oid_estado'
        DataType = ftInteger
      end
      item
        Name = 'codigo_externo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_estado;orden'
    IndexDefs = <
      item
        Name = 'TMotivosEquivCIPIndex2'
        Fields = 'oid_estado;orden'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_estado'
    MasterSource = DSTEstadoCIP
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 568
    Top = 108
    object TEquivalenciaEstadoCIPoid_equiv_estado: TIntegerField
      FieldName = 'oid_equiv_estado'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TEquivalenciaEstadoCIPoid_estado: TIntegerField
      FieldName = 'oid_estado'
    end
    object TEquivalenciaEstadoCIPcodigo_externo: TStringField
      FieldName = 'codigo_externo'
      Size = 50
    end
    object TEquivalenciaEstadoCIPactivo: TBooleanField
      FieldName = 'activo'
    end
    object TEquivalenciaEstadoCIPorden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
  end
  object DSTEquivalenciaEstadoCIP: TDataSource
    DataSet = TEquivalenciaEstadoCIP
    Left = 600
    Top = 108
  end
  object TTiposPermisos: TsnTable
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
    Left = 520
    Top = 164
    object TTiposPermisoscodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTiposPermisosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTiposPermisos: TDataSource
    DataSet = TTiposPermisos
    Left = 552
    Top = 164
  end
  object TMotAccInter: TsnTable
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
    Left = 104
    Top = 383
    object IntegerField1: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField1: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField2: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpMotAccInter: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.MotivoEntIntermedias'
    NroHelp = 6
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
    Titulo = 'Motivos Entradas Intermedias'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 134
    Top = 384
  end
  object TMotAccesosIntermedios: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'secu'
        DataType = ftInteger
      end
      item
        Name = 'oid_estado'
        DataType = ftInteger
      end
      item
        Name = 'habilitado'
        DataType = ftBoolean
      end
      item
        Name = 'oid_motivo'
        DataType = ftInteger
      end
      item
        Name = 'desc_motivo'
        DataType = ftString
        Size = 100
      end>
    IndexFieldNames = 'oid_estado'
    IndexDefs = <
      item
        Name = 'TMotAccesosIntermediosIndex2'
        Fields = 'oid_estado'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_estado'
    MasterSource = DSTEstadoCIP
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 102
    Top = 426
    object TMotAccesosIntermediossecu: TIntegerField
      FieldName = 'secu'
    end
    object TMotAccesosIntermediosoid_estado: TIntegerField
      FieldName = 'oid_estado'
    end
    object TMotAccesosIntermedioshabilitado: TBooleanField
      FieldName = 'habilitado'
    end
    object TMotAccesosIntermediosoid_motivo: TIntegerField
      FieldName = 'oid_motivo'
    end
    object TMotAccesosIntermediosdesc_motivo: TStringField
      FieldName = 'desc_motivo'
      Size = 100
    end
  end
  object DSTMotAccesosIntermedios: TDataSource
    DataSet = TMotAccesosIntermedios
    Left = 134
    Top = 426
  end
  object TCatAccesoEstado: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_acc_est'
        DataType = ftInteger
      end
      item
        Name = 'oid_estado'
        DataType = ftInteger
      end
      item
        Name = 'oid_categ_acceso'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_estado'
    IndexDefs = <
      item
        Name = 'TCatAccesoEstadoIndex1'
        Fields = 'oid_estado'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterSource = DSTEstadoCIP
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 648
    Top = 112
    object TCatAccesoEstadooid_acc_est: TIntegerField
      FieldName = 'oid_acc_est'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCatAccesoEstadooid_estado: TIntegerField
      FieldName = 'oid_estado'
    end
    object TCatAccesoEstadooid_categ_acceso: TIntegerField
      FieldName = 'oid_categ_acceso'
    end
    object TCatAccesoEstadodesc_categ_acceso: TStringField
      FieldName = 'desc_categ_acceso'
      Size = 100
    end
    object TCatAccesoEstadoactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTCatAccesoEstado: TDataSource
    DataSet = TCatAccesoEstado
    Left = 680
    Top = 108
  end
  object TCategAccesos: TsnTable
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
    Left = 104
    Top = 470
    object IntegerField2: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField3: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField4: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpCategAccesos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.CategAccesoCIP'
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
    Titulo = 'Categor'#237'as Accesos Internos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 134
    Top = 471
  end
end
