inherited FSeguEmpPredioExc: TFSeguEmpPredioExc
  Left = 108
  Top = 175
  Width = 825
  Height = 669
  Caption = 'Seguridad sobre Perfiles Funcionales'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 809
    Height = 631
    inherited PPie: TPanel
      Top = 610
      Width = 809
      inherited StatusBarABM: TStatusBar
        Left = 704
      end
      inherited StatusBar2: TStatusBar
        Width = 704
      end
    end
    inherited PMenu: TPanel
      Width = 809
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTPerfil
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTPerfil
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpPerfilesFuncionales
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpPerfilesFuncionales
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpPerfilesFuncionales
      end
      inherited Panel2: TPanel
        Left = 768
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTPerfil
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
      Width = 809
    end
    inherited PCabecera: TPanel
      Width = 809
      Height = 85
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
      object DBECodigo: TsnDBEdit
        Left = 156
        Top = 12
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTPerfil
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Properties.ReadOnly = True
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBEdit1: TsnDBEdit
        Left = 156
        Top = 52
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTPerfil
        Properties.MaxLength = 50
        Properties.ReadOnly = True
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
    end
    inherited PCuerpo: TPanel
      Top = 137
      Width = 809
      Height = 473
      BorderWidth = 10
      object PageControlSN1: TPageControlSN
        Left = 10
        Top = 10
        Width = 789
        Height = 453
        ActivePage = TabSheet1
        Align = alClient
        TabOrder = 0
        object TabSheet1: TTabSheet
          Caption = 'Perfiles espec'#237'ficos de Seguridad sobre datos de Excluidos'
          object dxDBGridSN3: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 781
            Height = 425
            Align = alClient
            TabOrder = 0
            CriteriosPintarCelda = <
              item
                TipoPintadaCelda = tpcTodasLasColumnas
                FieldName1 = 'activo'
                TipoCondFiltro1 = tcfIgual
                Valor1 = '2'
                TipoCondFiltro2 = tcfIgual
                Color = clRed
              end>
            object cxGridDBTableView3: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              NavigatorButtons.First.Enabled = False
              NavigatorButtons.First.Visible = False
              NavigatorButtons.PriorPage.Enabled = False
              NavigatorButtons.PriorPage.Visible = False
              NavigatorButtons.Prior.Enabled = False
              NavigatorButtons.Prior.Visible = False
              NavigatorButtons.Next.Enabled = False
              NavigatorButtons.Next.Visible = False
              NavigatorButtons.NextPage.Enabled = False
              NavigatorButtons.NextPage.Visible = False
              NavigatorButtons.Last.Enabled = False
              NavigatorButtons.Last.Visible = False
              NavigatorButtons.Insert.Enabled = False
              NavigatorButtons.Insert.Hint = 'Insertar Motivo'
              NavigatorButtons.Insert.Visible = False
              NavigatorButtons.Append.Hint = 'Insertar Motivo'
              NavigatorButtons.Append.Visible = True
              NavigatorButtons.Delete.Enabled = False
              NavigatorButtons.Delete.Visible = False
              NavigatorButtons.Edit.Enabled = False
              NavigatorButtons.Edit.Visible = False
              NavigatorButtons.Post.Enabled = False
              NavigatorButtons.Post.Visible = False
              NavigatorButtons.Cancel.Enabled = False
              NavigatorButtons.Cancel.Visible = False
              NavigatorButtons.Refresh.Enabled = False
              NavigatorButtons.Refresh.Visible = False
              NavigatorButtons.SaveBookmark.Enabled = False
              NavigatorButtons.SaveBookmark.Visible = False
              NavigatorButtons.GotoBookmark.Enabled = False
              NavigatorButtons.GotoBookmark.Visible = False
              NavigatorButtons.Filter.Enabled = False
              NavigatorButtons.Filter.Visible = False
              DataController.DataSource = DSTPerfFuncPerfExcluido
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.PostponedSynchronization = False
              OptionsBehavior.AlwaysShowEditor = True
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.Appending = True
              OptionsData.CancelOnExit = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsSelection.InvertSelect = False
              OptionsView.Navigator = True
              OptionsView.GroupByBox = False
              object cxGridDBTableView3OID_SEGU_PERFIL: TcxGridDBColumn
                Caption = 'Perfil de Seguridad de Excluidos'
                DataBinding.FieldName = 'OID_SEGU_PERFIL'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'oid'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListSource = DSTSeguPerfil
                Width = 361
              end
              object cxGridDBTableView3ACTIVO: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'ACTIVO'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 83
              end
            end
            object cxGridLevel3: TcxGridLevel
              GridView = cxGridDBTableView3
            end
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerSeguridadEmpresaPredio'
    OperGrabarObjeto = 'SaveSeguridadEmpresaPredio'
    CargaDataSets = <
      item
        DataSet = TPerfil
        TableName = 'TPerfil'
      end
      item
        DataSet = TSeguridadEmpresaPredio
        TableName = 'TSeguridadEmpresaPredio'
      end
      item
        DataSet = TSeguEmpresaPredioDet
        TableName = 'TSeguEmpresaPredioDet'
      end
      item
        DataSet = TPerfFuncPerfExcluido
        TableName = 'TPerfFuncPerfExcluido'
      end>
    BajaLogica = <
      item
        DataSet = TPerfil
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TPerfil
    DataSetDet1 = TSeguridadEmpresaPredio
    DataSetDet2 = TSeguEmpresaPredioDet
    DataSetDet3 = TPerfFuncPerfExcluido
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 552
    Top = 16
  end
  object TPerfil: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_perfil'
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
        Size = 50
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
    Left = 648
    Top = 59
    object TPerfiloid_perfil: TIntegerField
      FieldName = 'oid_perfil'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPerfilcodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TPerfildescripcion: TStringField
      DisplayWidth = 50
      FieldName = 'descripcion'
      Size = 50
    end
    object TPerfilactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTPerfil: TDataSource [4]
    DataSet = TPerfil
    Left = 680
    Top = 59
  end
  inherited TOidObjSave: TsnTable
    Left = 608
  end
  inherited TOpcHabPrograma: TsnTable
    Top = 16
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 168
    Top = 56
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 496
    Top = 360
  end
  inherited DriverEvent: TDriverEvent
    OnBeforePost = <
      item
        TableName = 'TSeguridadEmpresaPredio'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_empresa'#39').AsInteger = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la empresa' +
            #39');'
          'end.')
      end
      item
        TableName = 'TSeguEmpresaPredioDet'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_predio_visualiz'#39').AsInteger = 0)'
          
            '      then raiseException(erCustomError,'#39'Debe seleccionar el pre' +
            'dio'#39');'
          '  if (DataSet.FieldName('#39'oid_perfil_act'#39').AsInteger = 0)'
          
            '      then raiseException(erCustomError,'#39'Debe seleccionar el per' +
            'fil de actualizaci'#243'n'#39');  '
          'end.')
      end
      item
        TableName = 'TPerfFuncPerfExcluido'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_segu_perfil'#39').AsInteger=0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el Perfil' +
            ' de Seguridad'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TSeguridadEmpresaPredio'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_perfil'#39').AsInteger :='
          '           TPerfil.FieldName('#39'oid_perfil'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end
      item
        TableName = 'TSeguEmpresaPredioDet'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'vis_dif_importes'#39').Value := false;'
          '  DataSet.FieldName('#39'vis_vehiculos'#39').Value := false;'
          '  DataSet.FieldName('#39'vis_obs_generales'#39').Value := false;'
          '  DataSet.FieldName('#39'vis_novedades'#39').Value := false;'
          '  DataSet.FieldName('#39'vis_arch_adjuntos'#39').Value := false;'
          '  DataSet.FieldName('#39'vis_pers_rel'#39').Value := false;'
          '  DataSet.FieldName('#39'permitir_alta'#39').Value := false;'
          '  DataSet.FieldName('#39'ver_nros_de_actas'#39').Value := false;'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end
      item
        TableName = 'TPerfFuncPerfExcluido'
        Source.Strings = (
          'begin'
          '  TPerfFuncPerfExcluido.FieldName('#39'activo'#39').Value := true;'
          '  TPerfFuncPerfExcluido.FieldName('#39'OID_PERF_FUNC'#39').Value :='
          '      TPerfil.FieldName('#39'oid_perfil'#39').Value;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TEmpresas.loadFromHelp('#39'HelpEmpresas'#39');'
          '  TPredios.loadFromHelp('#39'HelpPredios'#39');'
          '  TPerfilFuncional.loadFromHelp('#39'HelpPerfilFuncional'#39');'
          '  TSeguPerfil.loadFromHelp('#39'HelpSeguPerfil'#39');'
          'end.')
      end>
    Left = 464
    Top = 363
  end
  inherited SaveArchivo: TSaveDialog
    Left = 440
    Top = 184
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 433
    Top = 360
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 584
    Top = 51
  end
  object HelpPerfilesFuncionales: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'se.PerfilFuncional'
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
    Titulo = 'Perfiles Funcionales'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorPredio: TValidador
    Operacion = Operacion
    NickNameObjLog = 'exc.PredioExcluido'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Predio duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
  object TSeguridadEmpresaPredio: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_seg_emp_predio'
        DataType = ftInteger
      end
      item
        Name = 'oid_perfil'
        DataType = ftInteger
      end
      item
        Name = 'oid_empresa'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_perfil'
    IndexDefs = <
      item
        Name = 'TSeguridadEmpresaPredioIndex1'
        Fields = 'oid_perfil'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_perfil'
    MasterSource = DSTPerfil
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 608
    Top = 108
    object TSeguridadEmpresaPrediooid_seg_emp_predio: TIntegerField
      FieldName = 'oid_seg_emp_predio'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TSeguridadEmpresaPrediooid_perfil: TIntegerField
      FieldName = 'oid_perfil'
    end
    object TSeguridadEmpresaPrediooid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TSeguridadEmpresaPredioactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTSeguridadEmpresaPredio: TDataSource
    DataSet = TSeguridadEmpresaPredio
    Left = 648
    Top = 108
  end
  object HelpEmpresas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ge.Empresa'
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
    Titulo = 'Empresas'
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 194
    Top = 217
  end
  object TEmpresas: TsnTable
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
    Left = 226
    Top = 217
    object TEmpresasoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TEmpresascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TEmpresasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSEmpresas: TDataSource
    DataSet = TEmpresas
    Left = 256
    Top = 217
  end
  object TSeguEmpresaPredioDet: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_seg_emp_pre_d'
        DataType = ftInteger
      end
      item
        Name = 'oid_seg_emp_predio'
        DataType = ftInteger
      end
      item
        Name = 'oid_predio_visualiz'
        DataType = ftInteger
      end
      item
        Name = 'oid_perfil_act'
        DataType = ftInteger
      end
      item
        Name = 'vis_dif_importes'
        DataType = ftBoolean
      end
      item
        Name = 'vis_vehiculos'
        DataType = ftBoolean
      end
      item
        Name = 'vis_obs_generales'
        DataType = ftBoolean
      end
      item
        Name = 'vis_novedades'
        DataType = ftBoolean
      end
      item
        Name = 'vis_arch_adjuntos'
        DataType = ftBoolean
      end
      item
        Name = 'vis_pers_rel'
        DataType = ftBoolean
      end
      item
        Name = 'permitir_alta'
        DataType = ftBoolean
      end
      item
        Name = 'ver_nros_de_actas'
        DataType = ftBoolean
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_seg_emp_predio'
    IndexDefs = <
      item
        Name = 'TSeguEmpresaPredioDetIndex1'
        Fields = 'oid_seg_emp_predio'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_seg_emp_predio'
    MasterSource = DSTSeguridadEmpresaPredio
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 600
    Top = 152
    object TSeguEmpresaPredioDetoid_seg_emp_pre_d: TIntegerField
      FieldName = 'oid_seg_emp_pre_d'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TSeguEmpresaPredioDetoid_seg_emp_predio: TIntegerField
      FieldName = 'oid_seg_emp_predio'
    end
    object TSeguEmpresaPredioDetoid_predio_visualiz: TIntegerField
      FieldName = 'oid_predio_visualiz'
    end
    object TSeguEmpresaPredioDetoid_perfil_act: TIntegerField
      FieldName = 'oid_perfil_act'
    end
    object TSeguEmpresaPredioDetvis_dif_importes: TBooleanField
      FieldName = 'vis_dif_importes'
    end
    object TSeguEmpresaPredioDetvis_vehiculos: TBooleanField
      FieldName = 'vis_vehiculos'
    end
    object TSeguEmpresaPredioDetvis_obs_generales: TBooleanField
      FieldName = 'vis_obs_generales'
    end
    object TSeguEmpresaPredioDetvis_novedades: TBooleanField
      FieldName = 'vis_novedades'
    end
    object TSeguEmpresaPredioDetvis_arch_adjuntos: TBooleanField
      FieldName = 'vis_arch_adjuntos'
    end
    object TSeguEmpresaPredioDetvis_pers_rel: TBooleanField
      FieldName = 'vis_pers_rel'
    end
    object TSeguEmpresaPredioDetpermitir_alta: TBooleanField
      FieldName = 'permitir_alta'
    end
    object TSeguEmpresaPredioDetver_nros_de_actas: TBooleanField
      FieldName = 'ver_nros_de_actas'
    end
    object TSeguEmpresaPredioDetactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTSeguEmpresaPredioDet: TDataSource
    DataSet = TSeguEmpresaPredioDet
    Left = 632
    Top = 153
  end
  object HelpPredios: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'exc.PredioExcluido'
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
    Titulo = 'Predios'
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 170
    Top = 315
  end
  object TPredios: TsnTable
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
    Left = 202
    Top = 315
    object IntegerField1: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField1: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField2: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSPredios: TDataSource
    DataSet = TPredios
    Left = 232
    Top = 315
  end
  object HelpPerfilFuncional: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'se.PerfilFuncional'
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
    Titulo = 'Perfil Funcional'
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 170
    Top = 352
  end
  object TPerfilFuncional: TsnTable
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
    Left = 202
    Top = 352
    object IntegerField2: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField3: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField4: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSPerfilFuncional: TDataSource
    DataSet = TPerfilFuncional
    Left = 232
    Top = 352
  end
  object TPerfFuncPerfExcluido: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'OID_EXC_PERF_FUNC'
        DataType = ftInteger
      end
      item
        Name = 'OID_PERF_FUNC'
        DataType = ftInteger
      end
      item
        Name = 'OID_SEGU_PERFIL'
        DataType = ftInteger
      end
      item
        Name = 'ACTIVO'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'OID_PERF_FUNC'
    IndexDefs = <
      item
        Name = 'TPerfFuncPerfExcluidoIndex1'
        Fields = 'OID_PERF_FUNC'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_perfil'
    MasterSource = DSTPerfil
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 456
    Top = 108
    object TPerfFuncPerfExcluidoOID_EXC_PERF_FUNC: TIntegerField
      FieldName = 'OID_EXC_PERF_FUNC'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPerfFuncPerfExcluidoOID_PERF_FUNC: TIntegerField
      FieldName = 'OID_PERF_FUNC'
    end
    object TPerfFuncPerfExcluidoOID_SEGU_PERFIL: TIntegerField
      FieldName = 'OID_SEGU_PERFIL'
    end
    object TPerfFuncPerfExcluidoACTIVO: TBooleanField
      FieldName = 'ACTIVO'
    end
  end
  object DSTPerfFuncPerfExcluido: TDataSource
    DataSet = TPerfFuncPerfExcluido
    Left = 488
    Top = 108
  end
  object HelpSeguPerfil: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'exc.SeguPerfilExcluido'
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
    Titulo = 'Seguridad'
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 170
    Top = 391
  end
  object TSeguPerfil: TsnTable
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
    Left = 202
    Top = 391
    object IntegerField3: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField5: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField6: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTSeguPerfil: TDataSource
    DataSet = TSeguPerfil
    Left = 232
    Top = 391
  end
end
