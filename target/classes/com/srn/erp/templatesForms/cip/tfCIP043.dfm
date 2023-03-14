inherited FCategAccesoCIP: TFCategAccesoCIP
  Left = 133
  Top = 206
  Width = 730
  Height = 688
  Caption = 'Categor'#237'as de Acceso'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 714
    Height = 650
    inherited PPie: TPanel
      Top = 629
      Width = 714
      inherited StatusBarABM: TStatusBar
        Left = 609
      end
      inherited StatusBar2: TStatusBar
        Width = 609
      end
    end
    inherited PMenu: TPanel
      Width = 714
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTCategAccesoCIP
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTCategAccesoCIP
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpCategorias
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpCategorias
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpCategorias
      end
      inherited Panel2: TPanel
        Left = 673
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTCategAccesoCIP
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
      Width = 714
    end
    inherited PCabecera: TPanel
      Width = 714
      Height = 138
      object Label1: TLabel
        Left = 40
        Top = 16
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 40
        Top = 56
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object Label4: TLabel
        Left = 39
        Top = 96
        Width = 98
        Height = 13
        Caption = 'SubGrupo Categor'#237'a'
      end
      object DBECodigo: TsnDBEdit
        Left = 156
        Top = 12
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTCategAccesoCIP
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBEdit1: TsnDBEdit
        Left = 156
        Top = 52
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTCategAccesoCIP
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object DBCodCliente: TsrnDBButtonEdit
        Left = 157
        Top = 92
        Hint = 'F4 Nuevo Cliente'
        DataBinding.DataField = 'cod_sub_grupo_categ'
        DataBinding.DataSource = DSTCategAccesoCIP
        Properties.Buttons = <
          item
            Default = True
            Kind = bkEllipsis
          end>
        Properties.CharCase = ecUpperCase
        Properties.ClickKey = 112
        TabOrder = 2
        Help = HelpSubGrupoCategorias
        Width = 121
      end
      object snDBEdit3: TsnDBEdit
        Left = 275
        Top = 92
        TabStop = False
        DataBinding.DataField = 'desc_sub_grupo_categ'
        DataBinding.DataSource = DSTCategAccesoCIP
        Properties.ReadOnly = True
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 3
        ReadOnlyAlways = True
        Width = 310
      end
    end
    inherited PCuerpo: TPanel
      Top = 190
      Width = 714
      Height = 439
      BorderWidth = 10
      object PageControlSN1: TPageControlSN
        Left = 10
        Top = 10
        Width = 694
        Height = 419
        ActivePage = TabSheet1
        Align = alClient
        TabOrder = 0
        object TabSheet1: TTabSheet
          Caption = 'Puertas'
          object dxDBGridComponentesAInc: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 686
            Height = 391
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            AllowInsert = False
            CriteriosPintarCelda = <>
            object dxDBGridComponentesAIncDBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSTPuertasEnZonas
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsData.Inserting = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object dxDBGridComponentesAIncDBTableView1agrupador_plano: TcxGridDBColumn
                Caption = 'Agrupador'
                DataBinding.FieldName = 'agrupador_plano'
                Visible = False
                GroupIndex = 0
                HeaderAlignmentHorz = taCenter
                HeaderAlignmentVert = vaCenter
                Width = 100
              end
              object dxDBGridComponentesAIncDBTableView1desc_plano: TcxGridDBColumn
                Caption = 'Plano'
                DataBinding.FieldName = 'desc_plano'
                Visible = False
                GroupIndex = 1
                HeaderAlignmentHorz = taCenter
                HeaderAlignmentVert = vaCenter
                Width = 100
              end
              object dxDBGridComponentesAIncDBTableView1cod_puerta: TcxGridDBColumn
                Caption = 'C'#243'd. Puerta'
                DataBinding.FieldName = 'cod_puerta'
                HeaderAlignmentHorz = taCenter
                HeaderAlignmentVert = vaCenter
                Options.Editing = False
                Width = 100
              end
              object dxDBGridComponentesAIncDBTableView1desc_puerta: TcxGridDBColumn
                Caption = 'Puerta'
                DataBinding.FieldName = 'desc_puerta'
                HeaderAlignmentHorz = taCenter
                HeaderAlignmentVert = vaCenter
                Options.Editing = False
                Width = 332
              end
              object dxDBGridComponentesAIncDBTableView1hab_entrada: TcxGridDBColumn
                Caption = 'Entrada Habilitada'
                DataBinding.FieldName = 'hab_entrada'
                HeaderAlignmentHorz = taCenter
                HeaderAlignmentVert = vaCenter
                Width = 100
              end
              object dxDBGridComponentesAIncDBTableView1hab_salida: TcxGridDBColumn
                Caption = 'Salida Habilitada'
                DataBinding.FieldName = 'hab_salida'
                HeaderAlignmentHorz = taCenter
                HeaderAlignmentVert = vaCenter
                Width = 100
              end
            end
            object dxDBGridComponentesAIncLevel1: TcxGridLevel
              GridView = dxDBGridComponentesAIncDBTableView1
            end
          end
        end
        object TabSheet2: TTabSheet
          Caption = 'Perfiles Habilitadores de Accesos'
          ImageIndex = 1
          object dxDBGridSN1: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 686
            Height = 391
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            AllowInsert = False
            CriteriosPintarCelda = <>
            object cxGridDBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSHabilitadorCategAcc
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsData.Inserting = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object cxGridDBTableView1activo: TcxGridDBColumn
                Caption = 'Habilitar'
                DataBinding.FieldName = 'activo'
                HeaderAlignmentHorz = taCenter
                Width = 103
              end
              object cxGridDBTableView1desc_perfil_func: TcxGridDBColumn
                Caption = 'Perfil Funcional'
                DataBinding.FieldName = 'desc_perfil_func'
                HeaderAlignmentHorz = taCenter
                Width = 478
              end
            end
            object cxGridLevel1: TcxGridLevel
              GridView = cxGridDBTableView1
            end
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerCategAccesoCIP'
    OperGrabarObjeto = 'SaveCategAccesoCIP'
    CargaDataSets = <
      item
        DataSet = TCategAccesoCIP
        TableName = 'TCategAccesoCIP'
      end
      item
        DataSet = TPuertasEnZonas
        TableName = 'TPuertasEnZonas'
      end
      item
        DataSet = THabilitadorCategAcc
        TableName = 'THabilitadorCategAcc'
      end>
    BajaLogica = <
      item
        DataSet = TCategAccesoCIP
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TCategAccesoCIP
    DataSetDet1 = TPuertasEnZonas
    DataSetDet2 = THabilitadorCategAcc
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TCategAccesoCIP: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_categ_acceso'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
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
    Left = 520
    Top = 195
    object TCategAccesoCIPoid_categ_acceso: TIntegerField
      FieldName = 'oid_categ_acceso'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCategAccesoCIPcodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TCategAccesoCIPdescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TCategAccesoCIPactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TCategAccesoCIPoid_sub_grupo_categ: TIntegerField
      FieldName = 'oid_sub_grupo_categ'
    end
    object TCategAccesoCIPcod_sub_grupo_categ: TStringField
      FieldName = 'cod_sub_grupo_categ'
      Size = 50
    end
    object TCategAccesoCIPdesc_sub_grupo_categ: TStringField
      FieldName = 'desc_sub_grupo_categ'
      Size = 100
    end
  end
  object DSTCategAccesoCIP: TDataSource [4]
    DataSet = TCategAccesoCIP
    Left = 552
    Top = 195
  end
  inherited TOidObjSave: TsnTable
    Left = 608
  end
  inherited TOpcHabPrograma: TsnTable
    Top = 16
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 520
    Top = 48
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
        TableName = 'TCategAccesoCIP'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorCategoria.Value := Sender.AsString;'
          '  ValidadorCategoria.Validar;'
          'end.')
      end
      item
        TableName = 'TCategAccesoCIP'
        FieldName = 'cod_sub_grupo_categ'
        Source.Strings = (
          'begin'
          '  ValidadorSubGrupoCategoria.Value := Sender.AsString;'
          '  ValidadorSubGrupoCategoria.Validar();'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'THabilitadorCategAcc'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_categ_acceso'#39').AsInteger :='
          '     TCategAccesoCIP.FieldName('#39'oid_categ_acceso'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TPerfil.loadFromHelp('#39'HelpPerfilFuncional'#39');'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure InicializarPuertas();'
          'begin'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'InicioCategAccesoCIP'#39');'
          
            '  operacion.AddAtribute('#39'oid_categ'#39', TCategAccesoCIP.FieldName('#39 +
            'oid_categ_acceso'#39').AsString);'
          '  operacion.execute();'
          ''
          '  TPerfil.First;'
          '  while (not TPerfil.eof) do'
          '      begin'
          ''
          '      if (TPerfil.FieldName('#39'activo'#39').AsBoolean)'
          '          then begin'
          '                  THabilitadorCategAcc.AppendRecord; '
          
            '                  THabilitadorCategAcc.FieldName('#39'oid_perfil_fun' +
            'c'#39').AsInteger :='
          '                          TPerfil.FieldName('#39'oid'#39').AsInteger;'
          
            '                  THabilitadorCategAcc.FieldName('#39'cod_perfil_fun' +
            'c'#39').AsString :='
          '                          TPerfil.FieldName('#39'codigo'#39').AsString;'
          
            '                  THabilitadorCategAcc.FieldName('#39'desc_perfil_fu' +
            'nc'#39').AsString :='
          
            '                          TPerfil.FieldName('#39'descripcion'#39').AsStr' +
            'ing;'
          
            '                  THabilitadorCategAcc.FieldName('#39'activo'#39').AsBoo' +
            'lean := false;'
          '                  THabilitadorCategAcc.PostRecord;'
          '                  end;'
          ''
          '      TPerfil.next;'
          '      end;'
          ''
          'end;')
      end>
    OnAfterNuevo = <
      item
        Source.Strings = (
          'begin'
          '  InicializarPuertas();'
          'end.')
      end>
    Left = 600
    Top = 51
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Top = 240
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 536
    Top = 304
  end
  inherited PopUp: TsnPopUp
    Left = 561
    Top = 48
  end
  inherited ImageListGruposPopUp: TImageList
    Left = 200
    Top = 195
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 160
    Top = 195
  end
  object HelpCategorias: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.CategAccesoCIP'
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
    Titulo = 'Categorias de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorCategoria: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.CategAccesoCIP'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Categoria duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
  object TPuertasEnZonas: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'secu'
        DataType = ftInteger
      end
      item
        Name = 'agrupador_plano'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_plano'
        DataType = ftInteger
      end
      item
        Name = 'cod_plano'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_plano'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'oid_puerta'
        DataType = ftInteger
      end
      item
        Name = 'cod_puerta'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_puerta'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'hab_entrada'
        DataType = ftBoolean
      end
      item
        Name = 'hab_salida'
        DataType = ftBoolean
      end
      item
        Name = 'oid_categ_acceso'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_categ_acceso'
    IndexDefs = <
      item
        Name = 'TPuertasEnZonasIndex1'
        Fields = 'oid_categ_acceso'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_categ_acceso'
    MasterSource = DSTCategAccesoCIP
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 464
    Top = 233
    object TPuertasEnZonassecu: TIntegerField
      FieldName = 'secu'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPuertasEnZonasagrupador_plano: TStringField
      FieldName = 'agrupador_plano'
      Size = 100
    end
    object TPuertasEnZonasoid_plano: TIntegerField
      FieldName = 'oid_plano'
    end
    object TPuertasEnZonascod_plano: TStringField
      FieldName = 'cod_plano'
      Size = 50
    end
    object TPuertasEnZonasdesc_plano: TStringField
      FieldName = 'desc_plano'
      Size = 100
    end
    object TPuertasEnZonasorden: TIntegerField
      FieldName = 'orden'
    end
    object TPuertasEnZonasoid_puerta: TIntegerField
      FieldName = 'oid_puerta'
    end
    object TPuertasEnZonascod_puerta: TStringField
      FieldName = 'cod_puerta'
      Size = 50
    end
    object TPuertasEnZonasdesc_puerta: TStringField
      FieldName = 'desc_puerta'
      Size = 100
    end
    object TPuertasEnZonashab_entrada: TBooleanField
      FieldName = 'hab_entrada'
    end
    object TPuertasEnZonashab_salida: TBooleanField
      FieldName = 'hab_salida'
    end
    object TPuertasEnZonasoid_categ_acceso: TIntegerField
      FieldName = 'oid_categ_acceso'
    end
  end
  object DSTPuertasEnZonas: TDataSource
    DataSet = TPuertasEnZonas
    Left = 496
    Top = 233
  end
  object THabilitadorCategAcc: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_hab_categ_usu'
        DataType = ftInteger
      end
      item
        Name = 'oid_perfil_func'
        DataType = ftInteger
      end
      item
        Name = 'cod_perfil_func'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_perfil_func'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_categ_acceso'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_categ_acceso'
    IndexDefs = <
      item
        Name = 'THabilitadorCategAccIndex1'
        Fields = 'oid_categ_acceso'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_categ_acceso'
    MasterSource = DSTCategAccesoCIP
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 558
    Top = 235
    object THabilitadorCategAccoid_hab_categ_usu: TIntegerField
      FieldName = 'oid_hab_categ_usu'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object THabilitadorCategAccoid_perfil_func: TIntegerField
      FieldName = 'oid_perfil_func'
    end
    object THabilitadorCategAcccod_perfil_func: TStringField
      FieldName = 'cod_perfil_func'
      Size = 50
    end
    object THabilitadorCategAccdesc_perfil_func: TStringField
      FieldName = 'desc_perfil_func'
      Size = 100
    end
    object THabilitadorCategAccoid_categ_acceso: TIntegerField
      FieldName = 'oid_categ_acceso'
    end
    object THabilitadorCategAccactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSHabilitadorCategAcc: TDataSource
    DataSet = THabilitadorCategAcc
    Left = 590
    Top = 235
  end
  object HelpPerfilFuncional: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'se.PerfilFuncional'
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
    Titulo = 'Perfiles'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 551
    Top = 374
  end
  object TPerfil: TsnTable
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
    Left = 583
    Top = 374
    object TPerfiloid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPerfilcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TPerfildescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TPerfilactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object HelpSubGrupoCategorias: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.SubGrupoCategAcceso'
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
        AsignarACampo = TCategAccesoCIPcod_sub_grupo_categ
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
    Titulo = 'SubGrupos de Categor'#237'as'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 458
    Top = 159
  end
  object ValidadorSubGrupoCategoria: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.SubGrupoCategAcceso'
    MensajeException = 'C'#243'digo de SubGrupo de Categor'#237'a Inexistente'
    CampoOID = TCategAccesoCIPoid_sub_grupo_categ
    CampoDescripcion = TCategAccesoCIPdesc_sub_grupo_categ
    NroQuery = 0
    Cache = True
    Left = 494
    Top = 159
  end
end
