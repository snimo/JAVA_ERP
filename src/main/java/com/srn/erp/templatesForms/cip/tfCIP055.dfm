inherited FGrupoVisitas: TFGrupoVisitas
  Left = 124
  Top = 102
  Width = 757
  Height = 625
  Caption = 'Grupos de Visitas'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 741
    Height = 587
    inherited PPie: TPanel
      Top = 566
      Width = 741
      inherited StatusBarABM: TStatusBar
        Left = 636
      end
      inherited StatusBar2: TStatusBar
        Width = 636
      end
    end
    inherited PMenu: TPanel
      Width = 741
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = dsTGrupoVisita
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = dsTGrupoVisita
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpGrupoVisitas
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpGrupoVisitas
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpGrupoVisitas
      end
      inherited Panel2: TPanel
        Left = 700
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = dsTGrupoVisita
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
      Width = 741
    end
    inherited PCabecera: TPanel
      Width = 741
      Height = 126
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
      object DBECodigo: TsnDBEdit
        Left = 156
        Top = 20
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = dsTGrupoVisita
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBEdit1: TsnDBEdit
        Left = 156
        Top = 60
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = dsTGrupoVisita
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 36
        Top = 95
        Caption = 'Controlar antipassback?'
        DataBinding.DataField = 'antipassback'
        DataBinding.DataSource = dsTGrupoVisita
        TabOrder = 2
        Width = 149
      end
    end
    inherited PCuerpo: TPanel
      Top = 178
      Width = 741
      Height = 388
      object PageControlSN1: TPageControlSN
        Left = 0
        Top = 0
        Width = 741
        Height = 388
        ActivePage = TabSheet2
        Align = alClient
        TabOrder = 0
        object TabSheet2: TTabSheet
          Caption = 'Documentaci'#243'n'
          ImageIndex = 2
          object dxDBGridSN1: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 733
            Height = 360
            Align = alClient
            BorderWidth = 5
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object cxGridDBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              NavigatorButtons.Append.Enabled = False
              NavigatorButtons.Delete.Enabled = False
              NavigatorButtons.Edit.Enabled = False
              NavigatorButtons.Post.Enabled = False
              NavigatorButtons.Cancel.Enabled = False
              NavigatorButtons.Refresh.Enabled = False
              NavigatorButtons.SaveBookmark.Enabled = False
              NavigatorButtons.GotoBookmark.Enabled = False
              NavigatorButtons.Filter.Enabled = False
              DataController.DataSource = DSDocumentacionVisita
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.AlwaysShowEditor = True
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsCustomize.ColumnSorting = False
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsSelection.InvertSelect = False
              OptionsView.Navigator = True
              OptionsView.ShowEditButtons = gsebAlways
              OptionsView.CellAutoHeight = True
              OptionsView.GroupByBox = False
              object cxGridDBTableView1oid_tipo_docu: TcxGridDBColumn
                Caption = 'Documentaci'#243'n'
                DataBinding.FieldName = 'oid_tipo_docu'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'oid'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSTipoDocumentacion
                HeaderAlignmentHorz = taCenter
                HeaderAlignmentVert = vaCenter
                Width = 122
              end
              object cxGridDBTableView1presentado: TcxGridDBColumn
                Caption = 'Presentado'
                DataBinding.FieldName = 'presentado'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'codigo'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSPresentado
                HeaderAlignmentHorz = taCenter
                Width = 73
              end
              object cxGridDBTableView1fec_present: TcxGridDBColumn
                Caption = 'Fecha Emisi'#243'n'
                DataBinding.FieldName = 'fec_emision'
                HeaderAlignmentHorz = taCenter
                Width = 86
              end
              object cxGridDBTableView1controla_fecha: TcxGridDBColumn
                Caption = 'Controlar Vto.?'
                DataBinding.FieldName = 'controla_fecha'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'codigo'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSPresentado
                HeaderAlignmentHorz = taCenter
                Width = 88
              end
              object cxGridDBTableView1fec_vto: TcxGridDBColumn
                Caption = 'Fecha Vto.'
                DataBinding.FieldName = 'fec_vto'
                HeaderAlignmentHorz = taCenter
                Width = 89
              end
              object cxGridDBTableView1observacion: TcxGridDBColumn
                Caption = 'Observaci'#243'n'
                DataBinding.FieldName = 'observacion'
                PropertiesClassName = 'TcxMemoProperties'
                Properties.MaxLength = 250
                HeaderAlignmentHorz = taCenter
                Width = 182
              end
              object cxGridDBTableView1activo: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'codigo'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSPresentado
                HeaderAlignmentHorz = taCenter
                Width = 42
              end
              object cxGridDBTableView1Column1: TcxGridDBColumn
                DataBinding.FieldName = 'oid_docu_visita'
                Visible = False
                SortIndex = 0
                SortOrder = soDescending
              end
            end
            object cxGridLevel1: TcxGridLevel
              GridView = cxGridDBTableView1
            end
          end
        end
        object TabSheet1: TTabSheet
          Caption = 'Control de Accesos'
          ImageIndex = 1
          object PageControlSN2: TPageControlSN
            Left = 0
            Top = 0
            Width = 733
            Height = 360
            ActivePage = TabSheet4
            Align = alClient
            TabOrder = 0
            object TabSheet4: TTabSheet
              Caption = 'Configuraci'#243'n'
              object snLabel8: TsnLabel
                Left = 24
                Top = 8
                Width = 255
                Height = 13
                Caption = 'Puertas por las cuales puede ingresar y salir una Visita'
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clBlue
                Font.Height = -11
                Font.Name = 'MS Sans Serif'
                Font.Style = []
                ParentFont = False
              end
              object snLabel1: TsnLabel
                Left = 48
                Top = 32
                Width = 139
                Height = 13
                Caption = 'Acceso al Predio por puertas:'
              end
              object snLabel2: TsnLabel
                Left = 48
                Top = 59
                Width = 142
                Height = 13
                Caption = 'Egreso del Predio por puertas:'
              end
              object snLabel7: TsnLabel
                Left = 24
                Top = 88
                Width = 225
                Height = 13
                Caption = 'A quien visita y quien deber'#237'a autorizar la Visita.'
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clBlue
                Font.Height = -11
                Font.Name = 'MS Sans Serif'
                Font.Style = []
                ParentFont = False
              end
              object snLabel5: TsnLabel
                Left = 48
                Top = 112
                Width = 37
                Height = 13
                Caption = 'Visita a:'
              end
              object snLabel6: TsnLabel
                Left = 48
                Top = 140
                Width = 69
                Height = 13
                Caption = 'Autoriza Visita:'
              end
              object snLabel3: TsnLabel
                Left = 24
                Top = 168
                Width = 94
                Height = 13
                Caption = 'Vigencia de Ingreso'
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clBlue
                Font.Height = -11
                Font.Name = 'MS Sans Serif'
                Font.Style = []
                ParentFont = False
              end
              object snLabel4: TsnLabel
                Left = 199
                Top = 195
                Width = 16
                Height = 13
                Caption = 'Del'
              end
              object snLabel10: TsnLabel
                Left = 351
                Top = 195
                Width = 8
                Height = 13
                Caption = 'al'
              end
              object snLabel17: TsnLabel
                Left = 24
                Top = 221
                Width = 72
                Height = 13
                Caption = 'Acceso Interno'
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clBlue
                Font.Height = -11
                Font.Name = 'MS Sans Serif'
                Font.Style = []
                ParentFont = False
              end
              object snLabel18: TsnLabel
                Left = 48
                Top = 243
                Width = 127
                Height = 13
                Caption = 'Categor'#237'a Accesos Interno'
              end
              object snDBEdit4: TsnDBEdit
                Left = 315
                Top = 57
                TabStop = False
                DataBinding.DataField = 'desc_grupo_puerta_egreso'
                DataBinding.DataSource = dsTGrupoVisita
                Properties.ReadOnly = True
                TabOrder = 0
                Width = 302
              end
              object srnDBButtonEdit2: TsrnDBButtonEdit
                Left = 197
                Top = 57
                DataBinding.DataField = 'cod_grupo_puerta_egreso'
                DataBinding.DataSource = dsTGrupoVisita
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                Properties.ClickKey = 112
                TabOrder = 1
                Help = HelpGrupoPuertas1
                Width = 121
              end
              object srnDBButtonEdit1: TsrnDBButtonEdit
                Left = 197
                Top = 30
                DataBinding.DataField = 'cod_grupo_puerta_ingreso'
                DataBinding.DataSource = dsTGrupoVisita
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                Properties.ClickKey = 112
                TabOrder = 2
                Help = HelpGrupoPuertas
                Width = 121
              end
              object srnDBButtonEdit4: TsrnDBButtonEdit
                Left = 197
                Top = 110
                DataBinding.DataField = 'cod_visita_a'
                DataBinding.DataSource = dsTGrupoVisita
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                Properties.ClickKey = 112
                TabOrder = 3
                Help = HelpVisitaA
                Width = 121
              end
              object snDBEdit2: TsnDBEdit
                Left = 315
                Top = 110
                TabStop = False
                DataBinding.DataField = 'desc_visita_a'
                DataBinding.DataSource = dsTGrupoVisita
                Properties.ReadOnly = True
                TabOrder = 4
                Width = 302
              end
              object snDBEdit3: TsnDBEdit
                Left = 315
                Top = 138
                TabStop = False
                DataBinding.DataField = 'desc_autoriza'
                DataBinding.DataSource = dsTGrupoVisita
                Properties.ReadOnly = True
                TabOrder = 5
                Width = 302
              end
              object srnDBButtonEdit5: TsrnDBButtonEdit
                Left = 197
                Top = 138
                DataBinding.DataField = 'cod_autoriza'
                DataBinding.DataSource = dsTGrupoVisita
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                Properties.ClickKey = 112
                TabOrder = 6
                Help = HelpAutoriza
                Width = 121
              end
              object snDBEdit7: TsnDBEdit
                Left = 315
                Top = 30
                TabStop = False
                DataBinding.DataField = 'desc_grupo_puerta_ingreso'
                DataBinding.DataSource = dsTGrupoVisita
                Properties.ReadOnly = True
                TabOrder = 7
                Width = 302
              end
              object snDBCheckEdit2: TsnDBCheckEdit
                Left = 48
                Top = 192
                Caption = 'Aplicar Vigencia'
                DataBinding.DataField = 'aplic_vig'
                DataBinding.DataSource = dsTGrupoVisita
                TabOrder = 8
                Width = 113
              end
              object snDBDateEdit1: TsnDBDateEdit
                Left = 221
                Top = 192
                DataBinding.DataField = 'fec_desde_vig'
                DataBinding.DataSource = dsTGrupoVisita
                TabOrder = 9
                ReadOnlyAlways = False
                Width = 121
              end
              object snDBDateEdit2: TsnDBDateEdit
                Left = 376
                Top = 192
                DataBinding.DataField = 'fec_hasta_vig'
                DataBinding.DataSource = dsTGrupoVisita
                TabOrder = 10
                ReadOnlyAlways = False
                Width = 121
              end
              object srnDBButtonEdit8: TsrnDBButtonEdit
                Left = 197
                Top = 241
                DataBinding.DataField = 'cod_categ_acc_int'
                DataBinding.DataSource = dsTGrupoVisita
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                Properties.ClickKey = 112
                TabOrder = 11
                Help = HelpCategAccesoInt
                Width = 121
              end
              object snDBEdit9: TsnDBEdit
                Left = 315
                Top = 241
                TabStop = False
                DataBinding.DataField = 'desc_categ_acc_int'
                DataBinding.DataSource = dsTGrupoVisita
                Properties.ReadOnly = True
                TabOrder = 12
                Width = 302
              end
            end
            object TabSheet5: TTabSheet
              Caption = 'Planificaci'#243'n Rotas'
              ImageIndex = 1
              object dxDBGridSN5: TdxDBGridSN
                Left = 0
                Top = 74
                Width = 725
                Height = 258
                Align = alClient
                BorderWidth = 5
                TabOrder = 0
                LookAndFeel.Kind = lfFlat
                CriteriosPintarCelda = <>
                object cxGridDBTableView5: TcxGridDBTableView
                  NavigatorButtons.ConfirmDelete = False
                  DataController.DataSource = DSTFechaRota
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
                  OptionsData.Appending = True
                  OptionsData.Deleting = False
                  OptionsData.DeletingConfirmation = False
                  OptionsSelection.InvertSelect = False
                  OptionsView.GroupByBox = False
                  object cxGridDBTableView5fecha: TcxGridDBColumn
                    Caption = 'Fecha'
                    DataBinding.FieldName = 'fecha'
                    PropertiesClassName = 'TcxDateEditProperties'
                    HeaderAlignmentHorz = taCenter
                    SortIndex = 0
                    SortOrder = soAscending
                    Width = 99
                  end
                  object cxGridDBTableView5cod_rota: TcxGridDBColumn
                    Caption = 'C'#243'd. Rota'
                    DataBinding.FieldName = 'cod_rota'
                    PropertiesClassName = 'TcxButtonEditProperties'
                    Properties.Buttons = <
                      item
                        Default = True
                        Kind = bkEllipsis
                      end>
                    HeaderAlignmentHorz = taCenter
                    Width = 100
                  end
                  object cxGridDBTableView5desc_rota: TcxGridDBColumn
                    Caption = 'Descripci'#243'n Rota'
                    DataBinding.FieldName = 'desc_rota'
                    HeaderAlignmentHorz = taCenter
                    Options.Editing = False
                    Options.Focusing = False
                    Width = 210
                  end
                  object cxGridDBTableView5activo: TcxGridDBColumn
                    Caption = 'Activo'
                    DataBinding.FieldName = 'activo'
                    PropertiesClassName = 'TcxCheckBoxProperties'
                    HeaderAlignmentHorz = taCenter
                    Width = 50
                  end
                end
                object cxGridLevel5: TcxGridLevel
                  GridView = cxGridDBTableView5
                end
              end
              object Panel1: TPanel
                Left = 0
                Top = 0
                Width = 725
                Height = 74
                Align = alTop
                Color = clWindow
                TabOrder = 1
                object snLabel9: TsnLabel
                  Left = 26
                  Top = 31
                  Width = 104
                  Height = 13
                  Caption = 'Planificaci'#243'n Semanal'
                end
                object snLabel11: TsnLabel
                  Left = 10
                  Top = 5
                  Width = 386
                  Height = 13
                  Caption = 
                    'Puede seleccionar una Planificaci'#243'n de Ingreso / Egreso seg'#250'n d'#237 +
                    'a de la semana'
                  Font.Charset = DEFAULT_CHARSET
                  Font.Color = clBlue
                  Font.Height = -11
                  Font.Name = 'MS Sans Serif'
                  Font.Style = []
                  ParentFont = False
                end
                object snLabel12: TsnLabel
                  Left = 10
                  Top = 56
                  Width = 322
                  Height = 13
                  Caption = 
                    'Se puede indicar que utilice un rota espec'#237'fica para una fecha d' +
                    'ada'
                  Font.Charset = DEFAULT_CHARSET
                  Font.Color = clBlue
                  Font.Height = -11
                  Font.Name = 'MS Sans Serif'
                  Font.Style = []
                  ParentFont = False
                end
                object srnDBButtonEdit6: TsrnDBButtonEdit
                  Left = 144
                  Top = 28
                  DataBinding.DataField = 'cod_permiso_sem'
                  DataBinding.DataSource = dsTGrupoVisita
                  Properties.Buttons = <
                    item
                      Default = True
                      Kind = bkEllipsis
                    end>
                  Properties.ClickKey = 112
                  TabOrder = 0
                  Help = HelpPlanifSemanal
                  Width = 121
                end
                object snDBEdit6: TsnDBEdit
                  Left = 262
                  Top = 28
                  TabStop = False
                  DataBinding.DataField = 'desc_permiso_sem'
                  DataBinding.DataSource = dsTGrupoVisita
                  Properties.ReadOnly = True
                  TabOrder = 1
                  Width = 382
                end
              end
            end
            object TabSheet6: TTabSheet
              Caption = 'Accesos Intermedios Habilitados'
              ImageIndex = 2
              object dxDBGridSN2: TdxDBGridSN
                Left = 0
                Top = 30
                Width = 725
                Height = 302
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
                    Caption = 'Habilitar'
                    DataBinding.FieldName = 'habilitado'
                    PropertiesClassName = 'TcxCheckBoxProperties'
                    HeaderAlignmentHorz = taCenter
                    Width = 80
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
              object Panel3: TPanel
                Left = 0
                Top = 0
                Width = 725
                Height = 30
                Align = alTop
                Color = clWindow
                TabOrder = 1
                object snLabel13: TsnLabel
                  Left = 10
                  Top = 8
                  Width = 245
                  Height = 13
                  Caption = 'Habilitar los motivos intermedios de ingreso al Predio'
                  Font.Charset = DEFAULT_CHARSET
                  Font.Color = clBlue
                  Font.Height = -11
                  Font.Name = 'MS Sans Serif'
                  Font.Style = []
                  ParentFont = False
                end
              end
            end
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerGrupoVisita'
    OperGrabarObjeto = 'SaveGrupoVisita'
    CargaDataSets = <
      item
        DataSet = TGrupoVisita
        TableName = 'TGrupoVisita'
      end
      item
        DataSet = TDocumentacionVisita
        TableName = 'TDocumentacionVisita'
      end
      item
        DataSet = TFechaRota
        TableName = 'TFechaRota'
      end
      item
        DataSet = TMotAccesosIntermedios
        TableName = 'TMotAccesosIntermedios'
      end>
    BajaLogica = <
      item
        DataSet = TGrupoVisita
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TGrupoVisita
    DataSetDet1 = TDocumentacionVisita
    DataSetDet2 = TFechaRota
    DataSetDet3 = TMotAccesosIntermedios
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TGrupoVisita: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo_visita'
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
    Left = 616
    Top = 59
    object TGrupoVisitaoid_grupo_visita: TIntegerField
      FieldName = 'oid_grupo_visita'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TGrupoVisitacodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TGrupoVisitadescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TGrupoVisitaactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TGrupoVisitaoid_grupo_puerta_egreso: TIntegerField
      FieldName = 'oid_grupo_puerta_egreso'
    end
    object TGrupoVisitacod_grupo_puerta_ingreso: TStringField
      FieldName = 'cod_grupo_puerta_ingreso'
      Size = 50
    end
    object TGrupoVisitadesc_grupo_puerta_ingreso: TStringField
      FieldName = 'desc_grupo_puerta_ingreso'
      Size = 100
    end
    object TGrupoVisitaoid_grupo_puerta_ingreso: TIntegerField
      FieldName = 'oid_grupo_puerta_ingreso'
    end
    object TGrupoVisitacod_grupo_puerta_egreso: TStringField
      FieldName = 'cod_grupo_puerta_egreso'
      Size = 50
    end
    object TGrupoVisitadesc_grupo_puerta_egreso: TStringField
      FieldName = 'desc_grupo_puerta_egreso'
      Size = 100
    end
    object TGrupoVisitaoid_visita_a: TIntegerField
      FieldName = 'oid_visita_a'
    end
    object TGrupoVisitacod_visita_a: TStringField
      FieldName = 'cod_visita_a'
      Size = 50
    end
    object TGrupoVisitadesc_visita_a: TStringField
      FieldName = 'desc_visita_a'
      Size = 100
    end
    object TGrupoVisitaoid_autoriza: TIntegerField
      FieldName = 'oid_autoriza'
    end
    object TGrupoVisitacod_autoriza: TStringField
      FieldName = 'cod_autoriza'
      Size = 50
    end
    object TGrupoVisitadesc_autoriza: TStringField
      FieldName = 'desc_autoriza'
      Size = 100
    end
    object TGrupoVisitaoid_permiso_sem: TIntegerField
      FieldName = 'oid_permiso_sem'
    end
    object TGrupoVisitacod_permiso_sem: TStringField
      FieldName = 'cod_permiso_sem'
      Size = 50
    end
    object TGrupoVisitadesc_permiso_sem: TStringField
      FieldName = 'desc_permiso_sem'
      Size = 100
    end
    object TGrupoVisitaantipassback: TBooleanField
      FieldName = 'antipassback'
    end
    object TGrupoVisitaaplic_vig: TBooleanField
      FieldName = 'aplic_vig'
    end
    object TGrupoVisitafec_desde_vig: TDateField
      FieldName = 'fec_desde_vig'
    end
    object TGrupoVisitafec_hasta_vig: TDateField
      FieldName = 'fec_hasta_vig'
    end
    object TGrupoVisitaoid_categ_acc_int: TIntegerField
      FieldName = 'oid_categ_acc_int'
    end
    object TGrupoVisitacod_categ_acc_int: TStringField
      FieldName = 'cod_categ_acc_int'
      Size = 50
    end
    object TGrupoVisitadesc_categ_acc_int: TStringField
      FieldName = 'desc_categ_acc_int'
      Size = 100
    end
  end
  object dsTGrupoVisita: TDataSource [4]
    DataSet = TGrupoVisita
    Left = 648
    Top = 59
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
        TableName = 'TGrupoVisita'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorGrupoVisita.Value := Sender.AsString;'
          '  ValidadorGrupoVisita.Validar;'
          'end.')
      end
      item
        TableName = 'TGrupoVisita'
        FieldName = 'cod_grupo_puerta_ingreso'
        Source.Strings = (
          'begin'
          '  ValidadorGrupoPuertas.Value := Sender.AsString;'
          '  ValidadorGrupoPuertas.Validar();'
          'end.')
      end
      item
        TableName = 'TGrupoVisita'
        FieldName = 'cod_grupo_puerta_egreso'
        Source.Strings = (
          'begin'
          '  ValidadorGrupoPuertas1.Value := Sender.AsString;'
          '  ValidadorGrupoPuertas1.Validar();'
          'end.')
      end
      item
        TableName = 'TGrupoVisita'
        FieldName = 'cod_visita_a'
        Source.Strings = (
          'begin'
          '  ValidadorVisitaA.Value := Sender.AsString;'
          '  ValidadorVisitaA.Validar();'
          'end.')
      end
      item
        TableName = 'TGrupoVisita'
        FieldName = 'cod_autoriza'
        Source.Strings = (
          'begin'
          '  ValidadorAutoriza.Value := Sender.AsString;'
          '  ValidadorAutoriza.Validar();'
          'end.')
      end
      item
        TableName = 'TGrupoVisita'
        FieldName = 'cod_permiso_sem'
        Source.Strings = (
          'begin'
          '  ValidadorPlanificacionSemanal.Value := Sender.AsString;'
          '  ValidadorPlanificacionSemanal.Validar();'
          'end.')
      end
      item
        TableName = 'TFechaRota'
        FieldName = 'cod_rota'
        Source.Strings = (
          'begin'
          '  ValidadorRota.Value := Sender.AsString;'
          '  ValidadorRota.Validar();'
          'end.')
      end
      item
        TableName = 'TGrupoVisita'
        FieldName = 'cod_categ_acc_int'
        Source.Strings = (
          'begin'
          '  ValidadorCategAccesoInt.Value := Sender.AsString;'
          '  ValidadorCategAccesoInt.Validar();'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TFechaRota'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_rota'#39').AsInteger = 0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la rota'#39')' +
            ';'
          '  if (DataSet.FieldName('#39'fecha'#39').IsNull )'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la fecha'#39 +
            ');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TDocumentacionVisita'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_grupo_visita'#39').AsInteger := TGrupoVisit' +
            'a.FieldName('#39'oid_grupo_visita'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TFechaRota'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_grupo_visita'#39').AsInteger := TGrupoVisit' +
            'a.FieldName('#39'oid_grupo_visita'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TGrupoVisita'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          '  DataSet.FieldName('#39'antipassback'#39').AsBoolean := False;'
          '  DataSet.FieldName('#39'aplic_vig'#39').AsBoolean := False;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TTipoDocumentacion.loadFromHelp('#39'HelpTipoDodocumentacion'#39');'
          '  CargarPresentado();'
          '  TMotAccInter.loadFromHelp('#39'HelpMotAccInter'#39');'
          '  PageControlSN1.setTabVisible('#39'TabSheet2'#39',false);'
          '  PageControlSN1.setActivePageName('#39'TabSheet1'#39');'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure CargarPresentado();'
          'begin'
          '  TPresentado.Close;'
          '  TPresentado.Open;'
          '  TPresentado.AppendRecord;'
          '  TPresentado.FieldName('#39'codigo'#39').AsBoolean := true;'
          '  TPresentado.FieldName('#39'descripcion'#39').AsString := '#39'SI'#39';'
          '  TPresentado.PostRecord;'
          '  TPresentado.AppendRecord;'
          '  TPresentado.FieldName('#39'codigo'#39').AsBoolean := false;'
          '  TPresentado.FieldName('#39'descripcion'#39').AsString := '#39'NO'#39';'
          '  TPresentado.PostRecord;'
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
          '  '
          '    TMotAccesosIntermedios.AppendRecord;'
          '    TMotAccesosIntermedios.FieldName('#39'secu'#39').AsInteger := i;'
          
            '    TMotAccesosIntermedios.FieldName('#39'oid_visita'#39').AsInteger := ' +
            '0;'
          
            '    TMotAccesosIntermedios.FieldName('#39'habilitado'#39').AsBoolean := ' +
            'false;'
          
            '    TMotAccesosIntermedios.FieldName('#39'oid_motivo'#39').AsInteger := ' +
            'TMotAccInter.FieldName('#39'oid'#39').AsInteger;'
          
            '    TMotAccesosIntermedios.FieldName('#39'desc_motivo'#39').AsString := ' +
            'TMotAccInter.FieldName('#39'descripcion'#39').AsString; '
          
            '    TMotAccesosIntermedios.FieldName('#39'oid_grupo_visita'#39').AsInteg' +
            'er := TGrupoVisita.FieldName('#39'oid_grupo_visita'#39').AsInteger;'
          '    TMotAccesosIntermedios.PostRecord;'
          ' '
          '    TMotAccInter.next;'
          '    i := i + 1; '
          '    end;'
          'end;')
      end>
    OnAfterNuevo = <
      item
        Source.Strings = (
          'begin'
          '  AltaMotivosEntInter();'
          'end.')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'cxGridDBTableView5cod_rota'
        Source.Strings = (
          'begin'
          '   HelpRotas.mostrar();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 296
    Top = 232
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Top = 88
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 472
    Top = 51
  end
  object HelpGrupoVisitas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoVisita'
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
    Titulo = 'Grupo de Visitas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorGrupoVisita: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoVisita'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Grupo de Visitas duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
  object TDocumentacionVisita: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_docu_visita'
        DataType = ftInteger
      end
      item
        Name = 'oid_visita'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_docu'
        DataType = ftInteger
      end
      item
        Name = 'controla_fecha'
        DataType = ftBoolean
      end
      item
        Name = 'fec_vto'
        DataType = ftDate
      end
      item
        Name = 'observacion'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'presentado'
        DataType = ftBoolean
      end
      item
        Name = 'fec_present'
        DataType = ftDate
      end
      item
        Name = 'fec_emision'
        DataType = ftDate
      end
      item
        Name = 'oid_grupo_visita'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_grupo_visita'
    IndexDefs = <
      item
        Name = 'TDocumentacionVisitaIndex1'
        Fields = 'oid_grupo_visita'
        Options = [ixDescending]
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_grupo_visita'
    MasterSource = dsTGrupoVisita
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 560
    Top = 100
    object TDocumentacionVisitaoid_docu_visita: TIntegerField
      FieldName = 'oid_docu_visita'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TDocumentacionVisitaoid_visita: TIntegerField
      FieldName = 'oid_visita'
    end
    object TDocumentacionVisitaoid_tipo_docu: TIntegerField
      FieldName = 'oid_tipo_docu'
    end
    object TDocumentacionVisitacontrola_fecha: TBooleanField
      FieldName = 'controla_fecha'
    end
    object TDocumentacionVisitafec_vto: TDateField
      FieldName = 'fec_vto'
    end
    object TDocumentacionVisitaobservacion: TStringField
      FieldName = 'observacion'
      Size = 255
    end
    object TDocumentacionVisitaactivo: TBooleanField
      FieldName = 'activo'
    end
    object TDocumentacionVisitapresentado: TBooleanField
      FieldName = 'presentado'
    end
    object TDocumentacionVisitafec_present: TDateField
      FieldName = 'fec_present'
    end
    object TDocumentacionVisitafec_emision: TDateField
      FieldName = 'fec_emision'
    end
    object TDocumentacionVisitaoid_grupo_visita: TIntegerField
      FieldName = 'oid_grupo_visita'
    end
  end
  object DSDocumentacionVisita: TDataSource
    DataSet = TDocumentacionVisita
    Left = 592
    Top = 100
  end
  object HelpTipoDodocumentacion: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.TipoDocumentacionCIP'
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
    Titulo = 'Tipo de Documentaci'#243'n'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 162
    Top = 379
  end
  object TTipoDocumentacion: TsnTable
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
    Left = 195
    Top = 379
    object TTipoDocumentacionoid: TIntegerField
      FieldName = 'oid'
    end
    object TTipoDocumentacioncodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTipoDocumentaciondescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTipoDocumentacion: TDataSource
    DataSet = TTipoDocumentacion
    Left = 227
    Top = 380
  end
  object TPresentado: TsnTable
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
    Left = 232
    Top = 297
    object TPresentadocodigo: TBooleanField
      FieldName = 'codigo'
    end
    object TPresentadodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 10
    end
  end
  object DSPresentado: TDataSource
    DataSet = TPresentado
    Left = 264
    Top = 297
  end
  object HelpGrupoPuertas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
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
        AsignarACampo = TGrupoVisitacod_grupo_puerta_ingreso
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
    Titulo = 'Grupos de Puertas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 394
    Top = 207
  end
  object ValidadorGrupoPuertas: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Grupo de Puerta Inexistente'
    CampoOID = TGrupoVisitaoid_grupo_puerta_ingreso
    CampoDescripcion = TGrupoVisitadesc_grupo_puerta_ingreso
    NroQuery = 0
    Cache = True
    Left = 430
    Top = 207
  end
  object HelpGrupoPuertas1: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
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
        AsignarACampo = TGrupoVisitacod_grupo_puerta_egreso
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
    Titulo = 'Grupos de Puertas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 394
    Top = 244
  end
  object ValidadorGrupoPuertas1: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Grupo de Puerta Inexistente'
    CampoOID = TGrupoVisitaoid_grupo_puerta_egreso
    CampoDescripcion = TGrupoVisitadesc_grupo_puerta_egreso
    NroQuery = 0
    Cache = True
    Left = 430
    Top = 244
  end
  object HelpVisitaA: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
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
        AsignarACampo = TGrupoVisitacod_visita_a
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
    Titulo = 'Visita a'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 570
    Top = 345
  end
  object ValidadorVisitaA: TValidador
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
    MensajeException = 'C'#243'digo de Visita Inexistente'
    CampoOID = TGrupoVisitaoid_visita_a
    CampoDescripcion = TGrupoVisitadesc_visita_a
    NroQuery = 0
    Cache = True
    Left = 606
    Top = 345
  end
  object ValidadorAutoriza: TValidador
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
    MensajeException = 'C'#243'digo de Legajo Inexistente'
    CampoOID = TGrupoVisitaoid_autoriza
    CampoDescripcion = TGrupoVisitadesc_autoriza
    NroQuery = 0
    Cache = True
    Left = 606
    Top = 377
  end
  object HelpAutoriza: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
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
        AsignarACampo = TGrupoVisitacod_autoriza
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
    Titulo = 'Autoriza'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 570
    Top = 377
  end
  object HelpPlanifSemanal: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.PermisoSemanalCIP'
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
        AsignarACampo = TGrupoVisitacod_permiso_sem
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
    Titulo = 'Planificaci'#243'n Semanal'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 418
    Top = 315
  end
  object ValidadorPlanificacionSemanal: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.PermisoSemanalCIP'
    MensajeException = 'C'#243'digo de Planificaci'#243'n Inexistente'
    CampoOID = TGrupoVisitaoid_permiso_sem
    CampoDescripcion = TGrupoVisitadesc_permiso_sem
    NroQuery = 0
    Cache = True
    Left = 454
    Top = 315
  end
  object TFechaRota: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_rota_visita'
        DataType = ftInteger
      end
      item
        Name = 'oid_visita'
        DataType = ftInteger
      end
      item
        Name = 'fecha'
        DataType = ftDate
      end
      item
        Name = 'oid_rota'
        DataType = ftInteger
      end
      item
        Name = 'cod_rota'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_rota'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'oid_grupo_visita'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_grupo_visita'
    IndexDefs = <
      item
        Name = 'TFechaRotaIndex1'
        Fields = 'oid_grupo_visita'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_grupo_visita'
    MasterSource = dsTGrupoVisita
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 654
    Top = 96
    object TFechaRotaoid_rota_visita: TIntegerField
      FieldName = 'oid_rota_visita'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TFechaRotaoid_visita: TIntegerField
      FieldName = 'oid_visita'
    end
    object TFechaRotafecha: TDateField
      FieldName = 'fecha'
    end
    object TFechaRotaoid_rota: TIntegerField
      FieldName = 'oid_rota'
    end
    object TFechaRotacod_rota: TStringField
      FieldName = 'cod_rota'
      Size = 50
    end
    object TFechaRotadesc_rota: TStringField
      FieldName = 'desc_rota'
      Size = 100
    end
    object TFechaRotaactivo: TBooleanField
      FieldName = 'activo'
    end
    object TFechaRotaoid_grupo_visita: TIntegerField
      FieldName = 'oid_grupo_visita'
    end
  end
  object DSTFechaRota: TDataSource
    DataSet = TFechaRota
    Left = 687
    Top = 96
  end
  object HelpRotas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.Rota'
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
        AsignarACampo = TFechaRotacod_rota
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
    Titulo = 'Rotas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 422
    Top = 362
  end
  object ValidadorRota: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.Rota'
    MensajeException = 'C'#243'digo de Rota Inexistente'
    CampoOID = TFechaRotaoid_rota
    CampoDescripcion = TFechaRotadesc_rota
    NroQuery = 0
    Cache = True
    Left = 458
    Top = 362
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
    Left = 24
    Top = 239
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
    Left = 54
    Top = 240
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
        Name = 'oid_visita'
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
      end
      item
        Name = 'oid_grupo_visita'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_grupo_visita'
    IndexDefs = <
      item
        Name = 'TMotAccesosIntermediosIndex1'
        Fields = 'oid_grupo_visita'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_grupo_visita'
    MasterSource = dsTGrupoVisita
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 486
    Top = 98
    object TMotAccesosIntermediossecu: TIntegerField
      FieldName = 'secu'
    end
    object TMotAccesosIntermediosoid_visita: TIntegerField
      FieldName = 'oid_visita'
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
    object TMotAccesosIntermediosoid_grupo_visita: TIntegerField
      FieldName = 'oid_grupo_visita'
    end
  end
  object DSTMotAccesosIntermedios: TDataSource
    DataSet = TMotAccesosIntermedios
    Left = 518
    Top = 98
  end
  object HelpCategAccesoInt: TsnHelp
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
        AsignarACampo = TGrupoVisitacod_categ_acc_int
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
    Titulo = 'Categor'#237'as de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 366
    Top = 506
  end
  object ValidadorCategAccesoInt: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.CategAccesoCIP'
    MensajeException = 'C'#243'digo de Categor'#237'a Inexistente'
    CampoOID = TGrupoVisitaoid_categ_acc_int
    CampoDescripcion = TGrupoVisitadesc_categ_acc_int
    NroQuery = 0
    Cache = True
    Left = 402
    Top = 506
  end
end
