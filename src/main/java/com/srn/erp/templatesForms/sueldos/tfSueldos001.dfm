inherited FLegajos: TFLegajos
  Left = 17
  Top = 18
  Width = 1167
  Height = 610
  Caption = 'Legajos'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 1151
    Height = 572
    inherited PPie: TPanel
      Top = 551
      Width = 1151
      inherited StatusBarABM: TStatusBar
        Left = 1046
      end
      inherited StatusBar2: TStatusBar
        Width = 1046
      end
    end
    inherited PMenu: TPanel
      Width = 1151
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSLegajos
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSLegajos
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpLegajos
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpLegajos
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpLegajos
      end
      inherited Panel2: TPanel
        Left = 1110
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSLegajos
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
      Width = 1151
    end
    inherited PCabecera: TPanel
      Width = 1151
      Height = 171
      object Label1: TLabel
        Left = 25
        Top = 29
        Width = 32
        Height = 13
        Caption = 'Legajo'
      end
      object Label2: TLabel
        Left = 25
        Top = 61
        Width = 37
        Height = 13
        Caption = 'Apellido'
      end
      object Label3: TLabel
        Left = 25
        Top = 93
        Width = 37
        Height = 13
        Caption = 'Nombre'
      end
      object Label4: TLabel
        Left = 25
        Top = 125
        Width = 67
        Height = 13
        Caption = 'Fecha ingreso'
      end
      object Label5: TLabel
        Left = 229
        Top = 125
        Width = 65
        Height = 13
        Caption = 'Fecha egreso'
      end
      object ImagenLegajo: TsnImage
        Left = 427
        Top = 1
        Width = 242
        Height = 170
        Proportional = True
        Stretch = True
      end
      object DBText1: TDBText
        Left = 110
        Top = 141
        Width = 187
        Height = 17
        DataField = 'ant_fec_ingreso'
        DataSource = DSLegajos
      end
      object DBText3: TDBText
        Left = 298
        Top = 141
        Width = 128
        Height = 17
        DataField = 'ant_fec_retiro'
        DataSource = DSLegajos
      end
      object DBECodigo: TsnDBEdit
        Left = 109
        Top = 25
        DataBinding.DataField = 'nro_legajo'
        DataBinding.DataSource = DSLegajos
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 165
      end
      object DBEDescripcion: TsnDBEdit
        Left = 109
        Top = 57
        DataBinding.DataField = 'apellido'
        DataBinding.DataSource = DSLegajos
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 289
      end
      object snDBEdit1: TsnDBEdit
        Left = 109
        Top = 89
        DataBinding.DataField = 'nombre'
        DataBinding.DataSource = DSLegajos
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 2
        Width = 289
      end
      object snDBDateEdit1: TsnDBDateEdit
        Left = 109
        Top = 121
        DataBinding.DataField = 'fec_ingreso'
        DataBinding.DataSource = DSLegajos
        TabOrder = 3
        ReadOnlyAlways = False
        Width = 101
      end
      object snDBDateEdit2: TsnDBDateEdit
        Left = 297
        Top = 121
        DataBinding.DataField = 'fec_retiro'
        DataBinding.DataSource = DSLegajos
        TabOrder = 4
        ReadOnlyAlways = False
        Width = 101
      end
    end
    inherited PCuerpo: TPanel
      Top = 223
      Width = 1151
      Height = 328
      BorderWidth = 5
      object PageControlSN1: TPageControlSN
        Left = 5
        Top = 5
        Width = 1141
        Height = 318
        ActivePage = TabSheet1
        Align = alClient
        TabOrder = 0
        object TabSheet1: TTabSheet
          Caption = 'Clasificadores      '
          object dxDBGridSN4: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 1133
            Height = 290
            Align = alClient
            BorderWidth = 5
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            AllowInsert = False
            CriteriosPintarCelda = <>
            object cxGridDBTableView4: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSValoresClasificadores
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
              OptionsData.Inserting = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object cxGridDBTableView4desc_grupo_clasif: TcxGridDBColumn
                Caption = 'Tipo'
                DataBinding.FieldName = 'desc_grupo_clasif'
                Visible = False
                GroupIndex = 0
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Width = 106
              end
              object cxGridDBTableView4desc_clasificador: TcxGridDBColumn
                Caption = 'Clasificador'
                DataBinding.FieldName = 'desc_clasificador'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Width = 144
              end
              object cxGridDBCodValClasif: TcxGridDBColumn
                Caption = 'C'#243'd. Valor'
                DataBinding.FieldName = 'cod_valor'
                PropertiesClassName = 'TcxButtonEditProperties'
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                HeaderAlignmentHorz = taCenter
                Width = 101
              end
              object cxGridDBTableView4desc_valor: TcxGridDBColumn
                Caption = 'Descripci'#243'n Valor'
                DataBinding.FieldName = 'desc_valor'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Width = 242
              end
            end
            object cxGridLevel4: TcxGridLevel
              GridView = cxGridDBTableView4
            end
          end
        end
        object TabSheet2: TTabSheet
          Caption = 'Tarjetas Legajos      '
          ImageIndex = 1
          object dxDBGridSN1: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 988
            Height = 404
            Align = alClient
            BorderWidth = 5
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object cxGridDBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSTarjetaLegajo
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
              object cxGridDBTableView1Column1: TcxGridDBColumn
                Caption = 'Orden'
                DataBinding.FieldName = 'orden'
                HeaderAlignmentHorz = taCenter
                Width = 40
              end
              object cxGridDBTableView1tipo_tarjeta: TcxGridDBColumn
                Caption = 'Tipo de Tarjeta'
                DataBinding.FieldName = 'tipo_tarjeta'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'codigo'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSTiposTarjetas
                HeaderAlignmentHorz = taCenter
                Width = 194
              end
              object cxGridDBTableView1nro_tarjeta: TcxGridDBColumn
                Caption = 'Nro. de Tarjeta'
                DataBinding.FieldName = 'nro_tarjeta'
                HeaderAlignmentHorz = taCenter
                Width = 214
              end
              object cxGridDBTableView1activo: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 44
              end
            end
            object cxGridLevel1: TcxGridLevel
              GridView = cxGridDBTableView1
            end
          end
        end
        object TabSheet3: TTabSheet
          Caption = 'Control de Acceso     '
          ImageIndex = 2
          object Panel1: TPanel
            Left = 0
            Top = 0
            Width = 1133
            Height = 242
            Align = alTop
            BevelOuter = bvNone
            Color = clWindow
            TabOrder = 0
            object snLabel1: TsnLabel
              Left = 32
              Top = 63
              Width = 133
              Height = 13
              Caption = 'Puertas de acceso al Predio'
            end
            object snLabel2: TsnLabel
              Left = 32
              Top = 95
              Width = 136
              Height = 13
              Caption = 'Puertas de egreso del Predio'
            end
            object snLabel3: TsnLabel
              Left = 32
              Top = 127
              Width = 107
              Height = 13
              Caption = 'Estado Control Ingreso'
            end
            object snLabel4: TsnLabel
              Left = 32
              Top = 159
              Width = 104
              Height = 13
              Caption = 'Planificaci'#243'n Semanal'
            end
            object snLabel5: TsnLabel
              Left = 32
              Top = 223
              Width = 89
              Height = 13
              Caption = 'Fecha Ultimo Pase'
            end
            object snLabel6: TsnLabel
              Left = 304
              Top = 223
              Width = 82
              Height = 13
              Caption = 'Hora Ultimo Pase'
            end
            object snLabel7: TsnLabel
              Left = 471
              Top = 222
              Width = 36
              Height = 13
              Caption = 'Sentido'
            end
            object Label7: TLabel
              Left = 352
              Top = 194
              Width = 79
              Height = 13
              Caption = 'Se encuentra en'
            end
            object Label6: TLabel
              Left = 33
              Top = 9
              Width = 77
              Height = 13
              Caption = 'ID Identificaci'#243'n'
            end
            object srnDBButtonEdit1: TsrnDBButtonEdit
              Left = 173
              Top = 61
              DataBinding.DataField = 'cod_grupo_puerta_ingreso'
              DataBinding.DataSource = DSLegajos
              Properties.Buttons = <
                item
                  Default = True
                  Kind = bkEllipsis
                end>
              Properties.ClickKey = 112
              TabOrder = 3
              Help = HelpGrupoPuertas
              Width = 121
            end
            object snDBEdit3: TsnDBEdit
              Left = 291
              Top = 61
              TabStop = False
              DataBinding.DataField = 'desc_grupo_puerta_ingreso'
              DataBinding.DataSource = DSLegajos
              Properties.ReadOnly = True
              TabOrder = 4
              Width = 382
            end
            object snDBEdit4: TsnDBEdit
              Left = 291
              Top = 93
              TabStop = False
              DataBinding.DataField = 'desc_grupo_puerta_egreso'
              DataBinding.DataSource = DSLegajos
              Properties.ReadOnly = True
              TabOrder = 5
              Width = 382
            end
            object srnDBButtonEdit2: TsrnDBButtonEdit
              Left = 173
              Top = 93
              DataBinding.DataField = 'cod_grupo_puerta_egreso'
              DataBinding.DataSource = DSLegajos
              Properties.Buttons = <
                item
                  Default = True
                  Kind = bkEllipsis
                end>
              Properties.ClickKey = 112
              TabOrder = 6
              Help = HelpGrupoPuertas1
              Width = 121
            end
            object srnDBButtonEdit3: TsrnDBButtonEdit
              Left = 173
              Top = 125
              DataBinding.DataField = 'cod_estado'
              DataBinding.DataSource = DSLegajos
              Properties.Buttons = <
                item
                  Default = True
                  Kind = bkEllipsis
                end>
              Properties.ClickKey = 112
              TabOrder = 7
              Help = HelpEstados
              Width = 121
            end
            object snDBEdit5: TsnDBEdit
              Left = 291
              Top = 125
              TabStop = False
              DataBinding.DataField = 'desc_estado'
              DataBinding.DataSource = DSLegajos
              Properties.ReadOnly = True
              TabOrder = 8
              Width = 382
            end
            object snDBEdit6: TsnDBEdit
              Left = 291
              Top = 157
              TabStop = False
              DataBinding.DataField = 'cod_perm_semenal'
              DataBinding.DataSource = DSLegajos
              Properties.ReadOnly = True
              TabOrder = 9
              Width = 382
            end
            object srnDBButtonEdit4: TsrnDBButtonEdit
              Left = 173
              Top = 157
              DataBinding.DataField = 'cod_perm_semenal'
              DataBinding.DataSource = DSLegajos
              Properties.Buttons = <
                item
                  Default = True
                  Kind = bkEllipsis
                end>
              Properties.ClickKey = 112
              TabOrder = 10
              Help = HelpPlanifSemanal
              Width = 121
            end
            object snDBCheckEdit1: TsnDBCheckEdit
              Left = 28
              Top = 191
              Caption = 'Activar Antipassback?'
              DataBinding.DataField = 'act_anti_pass_back'
              DataBinding.DataSource = DSLegajos
              TabOrder = 11
              Width = 133
            end
            object snDBCheckEdit2: TsnDBCheckEdit
              Left = 170
              Top = 191
              Caption = 'Ignorar pr'#243'ximo Antipassback?'
              DataBinding.DataField = 'ignorar_prox_apb'
              DataBinding.DataSource = DSLegajos
              TabOrder = 12
              Width = 173
            end
            object snDBDateEdit3: TsnDBDateEdit
              Left = 174
              Top = 219
              DataBinding.DataField = 'fec_ult_paso'
              DataBinding.DataSource = DSLegajos
              Enabled = False
              Properties.ReadOnly = True
              TabOrder = 13
              ReadOnlyAlways = True
              Width = 121
            end
            object snDBMaskEdit1: TsnDBMaskEdit
              Left = 392
              Top = 219
              DataBinding.DataField = 'hor_ult_paso'
              DataBinding.DataSource = DSLegajos
              Enabled = False
              Properties.MaxLength = 0
              Properties.ReadOnly = True
              TabOrder = 14
              ReadOnlyAlways = True
              Width = 70
            end
            object snDBLookup1: TsnDBLookup
              Left = 512
              Top = 218
              DataBinding.DataField = 'sentido_paso'
              DataBinding.DataSource = DSLegajos
              Properties.KeyFieldNames = 'sentido'
              Properties.ListColumns = <
                item
                  FieldName = 'descripcion'
                end>
              Properties.ListOptions.ShowHeader = False
              Properties.ListSource = DSSentidos
              TabOrder = 15
              Width = 81
            end
            object snDBEdit7: TsnDBEdit
              Left = 439
              Top = 190
              TabStop = False
              DataBinding.DataField = 'desc_zona_actual'
              DataBinding.DataSource = DSLegajos
              Properties.ReadOnly = True
              TabOrder = 16
              ReadOnlyAlways = True
              Width = 234
            end
            object snDBCheckEdit4: TsnDBCheckEdit
              Left = 28
              Top = 31
              Caption = 'Liberar ingreso al Predio'
              DataBinding.DataField = 'lib_ing_al_predio'
              DataBinding.DataSource = DSLegajos
              TabOrder = 1
              Width = 141
            end
            object snDBCheckEdit3: TsnDBCheckEdit
              Left = 172
              Top = 32
              Caption = 'Susceptible de Cacheo'
              DataBinding.DataField = 'circuito_chequeo'
              DataBinding.DataSource = DSLegajos
              TabOrder = 2
              Width = 149
            end
            object snDBCheckEdit5: TsnDBCheckEdit
              Left = 316
              Top = 32
              Caption = 'Prohibir Acceso'
              DataBinding.DataField = 'prohibir_acceso'
              DataBinding.DataSource = DSLegajos
              TabOrder = 17
              Width = 149
            end
            object snDBEdit2: TsnDBEdit
              Left = 117
              Top = 5
              DataBinding.DataField = 'id_identificacion'
              DataBinding.DataSource = DSLegajos
              Properties.MaxLength = 100
              Style.BorderColor = clWindowFrame
              Style.Shadow = False
              TabOrder = 0
              Width = 173
            end
          end
          object Panel4: TPanel
            Left = 0
            Top = 242
            Width = 1133
            Height = 48
            Align = alClient
            BevelOuter = bvNone
            BorderWidth = 10
            Color = clWindow
            TabOrder = 1
            object PageControlSN2: TPageControlSN
              Left = 10
              Top = 10
              Width = 1113
              Height = 28
              ActivePage = TabSheet7
              Align = alClient
              TabOrder = 0
              object TabSheet7: TTabSheet
                Caption = 
                  'Planificaci'#243'n Diaria                                            ' +
                  '  '
                ImageIndex = 2
                object dxDBGridSN5: TdxDBGridSN
                  Left = 0
                  Top = 0
                  Width = 973
                  Height = 272
                  Align = alClient
                  BorderWidth = 5
                  TabOrder = 0
                  LookAndFeel.Kind = lfFlat
                  CriteriosPintarCelda = <>
                  object cxGridDBTableView5: TcxGridDBTableView
                    NavigatorButtons.ConfirmDelete = False
                    DataController.DataSource = DSFechaRota
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
              end
              object TabSheet5: TTabSheet
                Caption = 
                  'Habilitar Motivos Accesos al Predio                             ' +
                  '     '
                object dxDBGridSN2: TdxDBGridSN
                  Left = 0
                  Top = 0
                  Width = 845
                  Height = 118
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
              end
              object TabSheet6: TTabSheet
                Caption = 
                  'Habilitar Accesos Internos                                      ' +
                  '                    '
                ImageIndex = 1
                object dxDBGridSN3: TdxDBGridSN
                  Left = 0
                  Top = 0
                  Width = 845
                  Height = 118
                  Align = alClient
                  BorderWidth = 5
                  TabOrder = 0
                  LookAndFeel.Kind = lfFlat
                  CriteriosPintarCelda = <>
                  object cxGridDBTableView3: TcxGridDBTableView
                    NavigatorButtons.ConfirmDelete = False
                    DataController.DataSource = DSCatAccInternos
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
                      DataBinding.FieldName = 'ACTIVO'
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 80
                    end
                    object cxGridDBTableView3DESC_CATEG_ACCESO: TcxGridDBColumn
                      Caption = 'Categor'#237'a de Acceso'
                      DataBinding.FieldName = 'DESC_CATEG_ACCESO'
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
            end
          end
        end
        object TabSheetPesonal: TTabSheet
          Caption = 'Personales     '
          ImageIndex = 3
          object snLabel8: TsnLabel
            Left = 8
            Top = 24
            Width = 24
            Height = 13
            Caption = 'CUIL'
          end
          object snLabel9: TsnLabel
            Left = 8
            Top = 56
            Width = 24
            Height = 13
            Caption = 'Sexo'
          end
          object snLabel10: TsnLabel
            Left = 8
            Top = 88
            Width = 45
            Height = 13
            Caption = 'Direcci'#243'n'
          end
          object snLabel11: TsnLabel
            Left = 8
            Top = 120
            Width = 55
            Height = 13
            Caption = 'Estado Civil'
          end
          object snLabel12: TsnLabel
            Left = 8
            Top = 152
            Width = 86
            Height = 13
            Caption = 'Fecha Nacimiento'
          end
          object snLabel13: TsnLabel
            Left = 8
            Top = 184
            Width = 79
            Height = 13
            Caption = 'Tipo Documento'
          end
          object snLabel14: TsnLabel
            Left = 352
            Top = 184
            Width = 93
            Height = 13
            Caption = 'Nro. de Documento'
          end
          object snLabel15: TsnLabel
            Left = 8
            Top = 216
            Width = 42
            Height = 13
            Caption = 'Telefono'
          end
          object snLabel16: TsnLabel
            Left = 352
            Top = 216
            Width = 77
            Height = 13
            Caption = 'Telefono Celular'
          end
          object DBText2: TDBText
            Left = 230
            Top = 152
            Width = 435
            Height = 17
            DataField = 'edad'
            DataSource = DSLegajos
          end
          object snDBEdit8: TsnDBEdit
            Left = 101
            Top = 20
            DataBinding.DataField = 'CUIL'
            DataBinding.DataSource = DSLegajos
            Properties.MaxLength = 50
            Style.BorderColor = clWindowFrame
            Style.Shadow = False
            TabOrder = 0
            Width = 228
          end
          object snDBLookup2: TsnDBLookup
            Left = 101
            Top = 52
            DataBinding.DataField = 'SEXO'
            DataBinding.DataSource = DSLegajos
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSSexo
            TabOrder = 1
            Width = 145
          end
          object snDBEdit9: TsnDBEdit
            Left = 101
            Top = 84
            DataBinding.DataField = 'direccion'
            DataBinding.DataSource = DSLegajos
            Properties.MaxLength = 80
            Style.BorderColor = clWindowFrame
            Style.Shadow = False
            TabOrder = 2
            Width = 564
          end
          object snDBLookup3: TsnDBLookup
            Left = 101
            Top = 116
            DataBinding.DataField = 'oid_estado_civil'
            DataBinding.DataSource = DSLegajos
            Properties.KeyFieldNames = 'oid'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSEstadoCivil
            TabOrder = 3
            Width = 228
          end
          object snDBDateEdit4: TsnDBDateEdit
            Left = 101
            Top = 148
            DataBinding.DataField = 'fec_nacimiento'
            DataBinding.DataSource = DSLegajos
            TabOrder = 4
            ReadOnlyAlways = False
            Width = 121
          end
          object snDBLookup4: TsnDBLookup
            Left = 101
            Top = 180
            DataBinding.DataField = 'oid_tipo_docu'
            DataBinding.DataSource = DSLegajos
            Properties.KeyFieldNames = 'oid'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSTipoDocu
            TabOrder = 5
            Width = 228
          end
          object snDBEdit10: TsnDBEdit
            Left = 453
            Top = 180
            DataBinding.DataField = 'nro_documento'
            DataBinding.DataSource = DSLegajos
            Properties.MaxLength = 50
            Style.BorderColor = clWindowFrame
            Style.Shadow = False
            TabOrder = 6
            Width = 228
          end
          object snDBEdit11: TsnDBEdit
            Left = 101
            Top = 212
            DataBinding.DataField = 'telefono'
            DataBinding.DataSource = DSLegajos
            Properties.MaxLength = 50
            Style.BorderColor = clWindowFrame
            Style.Shadow = False
            TabOrder = 7
            Width = 228
          end
          object snDBEdit12: TsnDBEdit
            Left = 453
            Top = 212
            DataBinding.DataField = 'telefono_celular'
            DataBinding.DataSource = DSLegajos
            Properties.MaxLength = 50
            Style.BorderColor = clWindowFrame
            Style.Shadow = False
            TabOrder = 8
            Width = 228
          end
        end
        object TabSheet4: TTabSheet
          Caption = 'Empresa       '
          ImageIndex = 4
          object Panel3: TPanel
            Left = 0
            Top = 0
            Width = 1133
            Height = 241
            Align = alTop
            Color = clWindow
            TabOrder = 0
            object snLabel18: TsnLabel
              Left = 8
              Top = 24
              Width = 139
              Height = 13
              Caption = 'Fec. Antiguedad Reconocida'
            end
            object snLabel17: TsnLabel
              Left = 8
              Top = 56
              Width = 73
              Height = 13
              Caption = 'Clase Sindicato'
            end
            object snLabel19: TsnLabel
              Left = 8
              Top = 88
              Width = 68
              Height = 13
              Caption = 'Motivo Egreso'
            end
            object snLabel20: TsnLabel
              Left = 8
              Top = 120
              Width = 136
              Height = 13
              Caption = 'Fec. Vencimiento Protecci'#243'n'
            end
            object snLabel21: TsnLabel
              Left = 8
              Top = 152
              Width = 84
              Height = 13
              Caption = 'Fec. Ingreso UTE'
            end
            object snLabel22: TsnLabel
              Left = 8
              Top = 183
              Width = 29
              Height = 13
              Caption = 'Juego'
            end
            object DBText4: TDBText
              Left = 294
              Top = 152
              Width = 435
              Height = 17
              DataField = 'ant_fec_ing_ute'
              DataSource = DSLegajos
            end
            object DBText5: TDBText
              Left = 294
              Top = 24
              Width = 435
              Height = 17
              DataField = 'ant_fec_ant_rec'
              DataSource = DSLegajos
            end
            object snLabel25: TsnLabel
              Left = 8
              Top = 215
              Width = 28
              Height = 13
              Caption = 'Tarea'
            end
            object snDBDateEdit5: TsnDBDateEdit
              Left = 165
              Top = 20
              DataBinding.DataField = 'fec_ant_rec'
              DataBinding.DataSource = DSLegajos
              TabOrder = 0
              ReadOnlyAlways = False
              Width = 121
            end
            object snDBLookup5: TsnDBLookup
              Left = 165
              Top = 52
              DataBinding.DataField = 'oid_clase_sind'
              DataBinding.DataSource = DSLegajos
              Properties.KeyFieldNames = 'oid'
              Properties.ListColumns = <
                item
                  FieldName = 'descripcion'
                end>
              Properties.ListOptions.ShowHeader = False
              Properties.ListSource = DSSindicatos
              TabOrder = 1
              Width = 316
            end
            object snDBLookup6: TsnDBLookup
              Left = 165
              Top = 84
              DataBinding.DataField = 'oid_mot_egreso'
              DataBinding.DataSource = DSLegajos
              Properties.KeyFieldNames = 'oid'
              Properties.ListColumns = <
                item
                  FieldName = 'descripcion'
                end>
              Properties.ListOptions.ShowHeader = False
              Properties.ListSource = DSMotivoEgresos
              TabOrder = 2
              Width = 316
            end
            object snDBDateEdit6: TsnDBDateEdit
              Left = 165
              Top = 116
              DataBinding.DataField = 'fec_venc_prot'
              DataBinding.DataSource = DSLegajos
              TabOrder = 3
              ReadOnlyAlways = False
              Width = 121
            end
            object snDBDateEdit7: TsnDBDateEdit
              Left = 165
              Top = 148
              DataBinding.DataField = 'fec_ing_ute'
              DataBinding.DataSource = DSLegajos
              TabOrder = 4
              ReadOnlyAlways = False
              Width = 121
            end
            object srnDBButtonEdit5: TsrnDBButtonEdit
              Left = 165
              Top = 181
              DataBinding.DataField = 'cod_grado_leg'
              DataBinding.DataSource = DSLegajos
              Properties.Buttons = <
                item
                  Default = True
                  Kind = bkEllipsis
                end>
              Properties.ClickKey = 112
              TabOrder = 5
              Help = HelpGradosLeg
              Width = 121
            end
            object snDBEdit13: TsnDBEdit
              Left = 283
              Top = 181
              TabStop = False
              DataBinding.DataField = 'desc_grado_leg'
              DataBinding.DataSource = DSLegajos
              Properties.ReadOnly = True
              TabOrder = 6
              Width = 382
            end
            object srnDBButtonEdit7: TsrnDBButtonEdit
              Left = 165
              Top = 213
              DataBinding.DataField = 'cod_tarea_desemp'
              DataBinding.DataSource = DSLegajos
              Properties.Buttons = <
                item
                  Default = True
                  Kind = bkEllipsis
                end>
              Properties.ClickKey = 112
              TabOrder = 7
              Help = HelpTareaDesemp
              Width = 121
            end
            object snDBEdit15: TsnDBEdit
              Left = 283
              Top = 213
              TabStop = False
              DataBinding.DataField = 'desc_tarea_desemp'
              DataBinding.DataSource = DSLegajos
              Properties.ReadOnly = True
              TabOrder = 8
              Width = 382
            end
          end
          object Panel5: TPanel
            Left = 0
            Top = 241
            Width = 1133
            Height = 49
            Align = alClient
            Caption = 'Panel5'
            Color = clWindow
            TabOrder = 1
            object PageControlSN3: TPageControlSN
              Left = 1
              Top = 1
              Width = 1131
              Height = 47
              ActivePage = TabSheet8
              Align = alClient
              TabOrder = 0
              object TabSheet8: TTabSheet
                Caption = 'Puestos'
                object dxDBGridSN6: TdxDBGridSN
                  Left = 0
                  Top = 0
                  Width = 991
                  Height = 291
                  Align = alClient
                  TabOrder = 0
                  LookAndFeel.Kind = lfFlat
                  CriteriosPintarCelda = <>
                  object dxDBGridSN6DBTableView1: TcxGridDBTableView
                    NavigatorButtons.ConfirmDelete = False
                    DataController.DataSource = DSHistPuestos
                    DataController.Summary.DefaultGroupSummaryItems = <>
                    DataController.Summary.FooterSummaryItems = <>
                    DataController.Summary.SummaryGroups = <>
                    OptionsBehavior.FocusCellOnTab = True
                    OptionsBehavior.FocusFirstCellOnNewRecord = True
                    OptionsBehavior.GoToNextCellOnEnter = True
                    OptionsBehavior.FocusCellOnCycle = True
                    OptionsData.Appending = True
                    OptionsData.Deleting = False
                    OptionsSelection.InvertSelect = False
                    OptionsView.GroupByBox = False
                    object dxDBGridSN6DBTableView1fec_desde: TcxGridDBColumn
                      Caption = 'Fecha Asumi'#243
                      DataBinding.FieldName = 'fec_desde'
                      HeaderAlignmentHorz = taCenter
                      SortIndex = 0
                      SortOrder = soDescending
                      Width = 105
                    end
                    object dxDBGridSN6DBTableView1Column2: TcxGridDBColumn
                      Caption = 'Antiguedad'
                      DataBinding.FieldName = 'ant_fec_desde'
                      HeaderAlignmentHorz = taCenter
                      Options.Editing = False
                      Options.Focusing = False
                      Width = 120
                    end
                    object dxDBGridSN6DBTableView1Column1: TcxGridDBColumn
                      Caption = 'C'#243'd. Puesto'
                      DataBinding.FieldName = 'cod_val_clasif_pue'
                      PropertiesClassName = 'TcxButtonEditProperties'
                      Properties.Buttons = <
                        item
                          Default = True
                          Kind = bkEllipsis
                        end>
                      Properties.ClickKey = 112
                      HeaderAlignmentHorz = taCenter
                      Width = 88
                    end
                    object dxDBGridSN6DBTableView1desc_val_clasif_pue: TcxGridDBColumn
                      Caption = 'Puesto'
                      DataBinding.FieldName = 'desc_val_clasif_pue'
                      HeaderAlignmentHorz = taCenter
                      Options.Editing = False
                      Options.Focusing = False
                      Width = 235
                    end
                    object dxDBGridSN6DBTableView1Column5: TcxGridDBColumn
                      Caption = 'C'#243'd. Sector'
                      DataBinding.FieldName = 'cod_val_clasif_sec'
                      PropertiesClassName = 'TcxButtonEditProperties'
                      Properties.Buttons = <
                        item
                          Default = True
                          Kind = bkEllipsis
                        end>
                      HeaderAlignmentHorz = taCenter
                      Width = 50
                    end
                    object dxDBGridSN6DBTableView1Column6: TcxGridDBColumn
                      Caption = 'Sector'
                      DataBinding.FieldName = 'desc_val_clasif_sec'
                      HeaderAlignmentHorz = taCenter
                      Width = 200
                    end
                    object dxDBGridSN6DBTableView1Column3: TcxGridDBColumn
                      Caption = 'Cod. Empresa'
                      DataBinding.FieldName = 'cod_val_clasif_emp'
                      PropertiesClassName = 'TcxButtonEditProperties'
                      Properties.Buttons = <
                        item
                          Default = True
                          Kind = bkEllipsis
                        end>
                      Properties.ClickKey = 112
                      HeaderAlignmentHorz = taCenter
                      Width = 74
                    end
                    object dxDBGridSN6DBTableView1Column4: TcxGridDBColumn
                      Caption = 'Empresa'
                      DataBinding.FieldName = 'desc_val_clasif_emp'
                      HeaderAlignmentHorz = taCenter
                      Width = 200
                    end
                    object dxDBGridSN6DBTableView1activo: TcxGridDBColumn
                      Caption = 'Activo'
                      DataBinding.FieldName = 'activo'
                      PropertiesClassName = 'TcxCheckBoxProperties'
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 51
                    end
                  end
                  object dxDBGridSN6Level1: TcxGridLevel
                    GridView = dxDBGridSN6DBTableView1
                  end
                end
              end
            end
          end
        end
        object TabSheet9: TTabSheet
          Caption = 'Sanciones       '
          ImageIndex = 5
          object dxDBGridSN7: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 1001
            Height = 562
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object cxGridDBTableView6: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSSancionesLegajo
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object cxGridDBTableView6fecha: TcxGridDBColumn
                Caption = 'Fecha'
                DataBinding.FieldName = 'fecha'
                HeaderAlignmentHorz = taCenter
                SortIndex = 0
                SortOrder = soAscending
                Width = 91
              end
              object cxGridDBTableView6nro_sancion: TcxGridDBColumn
                Caption = 'Nro. Sanci'#243'n'
                DataBinding.FieldName = 'nro_sancion'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Options.Focusing = False
                Width = 78
              end
              object cxGridDBTableView6oid_mot_falta: TcxGridDBColumn
                Caption = 'Falta'
                DataBinding.FieldName = 'oid_mot_falta'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'oid'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSHelpMotivosFaltas
                HeaderAlignmentHorz = taCenter
                Width = 200
              end
              object cxGridDBTableView6oid_mot_sancion: TcxGridDBColumn
                Caption = 'Sanci'#243'n'
                DataBinding.FieldName = 'oid_mot_sancion'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'oid'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSTHelpMotivosSanc
                HeaderAlignmentHorz = taCenter
                Width = 200
              end
              object cxGridDBTableView6fec_susp_desde: TcxGridDBColumn
                Caption = 'Susp. Desde'
                DataBinding.FieldName = 'fec_susp_desde'
                HeaderAlignmentHorz = taCenter
                Width = 110
              end
              object cxGridDBTableView6fec_reintegro: TcxGridDBColumn
                Caption = 'Reintegro'
                DataBinding.FieldName = 'fec_reintegro'
                HeaderAlignmentHorz = taCenter
                Width = 110
              end
              object cxGridDBTableView6activo: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 48
              end
            end
            object cxGridLevel6: TcxGridLevel
              GridView = cxGridDBTableView6
            end
          end
        end
        object TabSheet10: TTabSheet
          Caption = 'Servicio M'#233'dico       '
          ImageIndex = 6
          object Panel6: TPanel
            Left = 0
            Top = 0
            Width = 1133
            Height = 10
            Align = alTop
            BevelOuter = bvNone
            Color = clWindow
            TabOrder = 0
          end
          object Panel7: TPanel
            Left = 0
            Top = 10
            Width = 1133
            Height = 280
            Align = alClient
            Color = clWindow
            TabOrder = 1
            object PageControlSN4: TPageControlSN
              Left = 1
              Top = 1
              Width = 1131
              Height = 278
              ActivePage = TabSheet11
              Align = alClient
              TabOrder = 0
              object TabSheet11: TTabSheet
                Caption = 'Pedidos M'#233'dicos      '
                object dxDBGridSN8: TdxDBGridSN
                  Left = 0
                  Top = 0
                  Width = 991
                  Height = 522
                  Align = alClient
                  TabOrder = 0
                  LookAndFeel.Kind = lfFlat
                  CriteriosPintarCelda = <>
                  object cxGridDBTableView7: TcxGridDBTableView
                    NavigatorButtons.ConfirmDelete = False
                    DataController.DataSource = DSPedidosMedicos
                    DataController.Summary.DefaultGroupSummaryItems = <>
                    DataController.Summary.FooterSummaryItems = <>
                    DataController.Summary.SummaryGroups = <>
                    OptionsBehavior.FocusCellOnTab = True
                    OptionsBehavior.FocusFirstCellOnNewRecord = True
                    OptionsBehavior.GoToNextCellOnEnter = True
                    OptionsBehavior.FocusCellOnCycle = True
                    OptionsData.Appending = True
                    OptionsData.Deleting = False
                    OptionsSelection.InvertSelect = False
                    OptionsView.CellAutoHeight = True
                    OptionsView.GroupByBox = False
                    object cxGridDBTableView7nro_nov_sist_ext: TcxGridDBColumn
                      Caption = 'ID Nov.'
                      DataBinding.FieldName = 'nro_nov_sist_ext'
                      HeaderAlignmentHorz = taCenter
                      Options.Editing = False
                      Options.Focusing = False
                    end
                    object cxGridDBTableView7fec_inicio: TcxGridDBColumn
                      Caption = 'Fec. Inicio'
                      DataBinding.FieldName = 'fec_inicio'
                      HeaderAlignmentHorz = taCenter
                      Width = 85
                    end
                    object cxGridDBTableView7fec_final: TcxGridDBColumn
                      Caption = 'Fec. Final'
                      DataBinding.FieldName = 'fec_final'
                      HeaderAlignmentHorz = taCenter
                      Width = 82
                    end
                    object cxGridDBTableView7dias: TcxGridDBColumn
                      Caption = 'D'#237'as'
                      DataBinding.FieldName = 'dias'
                      HeaderAlignmentHorz = taCenter
                    end
                    object cxGridDBTableView7oid_aparato: TcxGridDBColumn
                      Caption = 'Aparato'
                      DataBinding.FieldName = 'oid_aparato'
                      PropertiesClassName = 'TcxLookupComboBoxProperties'
                      Properties.KeyFieldNames = 'oid'
                      Properties.ListColumns = <
                        item
                          FieldName = 'descripcion'
                        end>
                      Properties.ListOptions.ShowHeader = False
                      Properties.ListSource = DSAparatos
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 126
                    end
                    object cxGridDBTableView7oid_enfermedad: TcxGridDBColumn
                      Caption = 'Enfermedad'
                      DataBinding.FieldName = 'oid_enfermedad'
                      PropertiesClassName = 'TcxLookupComboBoxProperties'
                      Properties.KeyFieldNames = 'oid'
                      Properties.ListColumns = <
                        item
                          FieldName = 'descripcion'
                        end>
                      Properties.ListOptions.ShowHeader = False
                      Properties.ListSource = DSEnfermedad
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 97
                    end
                    object cxGridDBTableView7oid_prest_med: TcxGridDBColumn
                      Caption = 'Prestador M'#233'dico'
                      DataBinding.FieldName = 'oid_prest_med'
                      PropertiesClassName = 'TcxLookupComboBoxProperties'
                      Properties.KeyFieldNames = 'oid'
                      Properties.ListColumns = <
                        item
                          FieldName = 'descripcion'
                        end>
                      Properties.ListOptions.ShowHeader = False
                      Properties.ListSource = DSTPrestadorMedico
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 116
                    end
                    object cxGridDBTableView7Column1: TcxGridDBColumn
                      Caption = 'Fec. Control'
                      DataBinding.FieldName = 'fec_control'
                      HeaderAlignmentHorz = taCenter
                      Width = 86
                    end
                    object cxGridDBTableView7oid_mot_vis_fall: TcxGridDBColumn
                      Caption = 'Mot. Visita Fallida'
                      DataBinding.FieldName = 'oid_mot_vis_fall'
                      PropertiesClassName = 'TcxLookupComboBoxProperties'
                      Properties.KeyFieldNames = 'oid'
                      Properties.ListColumns = <
                        item
                          FieldName = 'descripcion'
                        end>
                      Properties.ListOptions.ShowHeader = False
                      Properties.ListSource = DSTMotVisitaFallida
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 121
                    end
                    object cxGridDBTableView7sintoma: TcxGridDBColumn
                      Caption = 'S'#237'ntoma'
                      DataBinding.FieldName = 'sintoma'
                      PropertiesClassName = 'TcxMemoProperties'
                      Properties.WantTabs = True
                      HeaderAlignmentHorz = taCenter
                      Width = 200
                    end
                    object cxGridDBTableView7observacion: TcxGridDBColumn
                      Caption = 'Observaci'#243'n'
                      DataBinding.FieldName = 'observacion'
                      PropertiesClassName = 'TcxMemoProperties'
                      Properties.WantTabs = True
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 200
                    end
                    object cxGridDBTableView7justifica: TcxGridDBColumn
                      Caption = 'Justifica'
                      DataBinding.FieldName = 'justifica'
                      PropertiesClassName = 'TcxCheckBoxProperties'
                      HeaderAlignmentHorz = taCenter
                      Width = 59
                    end
                    object cxGridDBTableView7activo: TcxGridDBColumn
                      Caption = 'Activo'
                      DataBinding.FieldName = 'activo'
                      PropertiesClassName = 'TcxCheckBoxProperties'
                      HeaderAlignmentHorz = taCenter
                    end
                  end
                  object cxGridLevel7: TcxGridLevel
                    GridView = cxGridDBTableView7
                  end
                end
              end
              object TabSheet12: TTabSheet
                Caption = 'Atenci'#243'n M'#233'dica       '
                ImageIndex = 1
                object dxDBGridSN9: TdxDBGridSN
                  Left = 0
                  Top = 0
                  Width = 951
                  Height = 368
                  Align = alClient
                  TabOrder = 0
                  LookAndFeel.Kind = lfFlat
                  CriteriosPintarCelda = <>
                  object cxGridDBTableView8: TcxGridDBTableView
                    NavigatorButtons.ConfirmDelete = False
                    DataController.DataSource = DSTAtencionMedica
                    DataController.Summary.DefaultGroupSummaryItems = <>
                    DataController.Summary.FooterSummaryItems = <>
                    DataController.Summary.SummaryGroups = <>
                    OptionsBehavior.FocusCellOnTab = True
                    OptionsBehavior.FocusFirstCellOnNewRecord = True
                    OptionsBehavior.GoToNextCellOnEnter = True
                    OptionsBehavior.FocusCellOnCycle = True
                    OptionsData.Appending = True
                    OptionsData.Deleting = False
                    OptionsSelection.InvertSelect = False
                    OptionsView.CellAutoHeight = True
                    OptionsView.GroupByBox = False
                    object cxGridDBColumn1: TcxGridDBColumn
                      Caption = 'ID Nov.'
                      DataBinding.FieldName = 'nro_nov_sist_ext'
                      HeaderAlignmentHorz = taCenter
                      Options.Editing = False
                      Options.Focusing = False
                    end
                    object cxGridDBTableView8Column1: TcxGridDBColumn
                      Caption = 'Fecha'
                      DataBinding.FieldName = 'fec_ate_med'
                      HeaderAlignmentHorz = taCenter
                    end
                    object cxGridDBColumn2: TcxGridDBColumn
                      Caption = 'Inicio Lic.'
                      DataBinding.FieldName = 'fec_inicio'
                      HeaderAlignmentHorz = taCenter
                      Width = 85
                    end
                    object cxGridDBColumn3: TcxGridDBColumn
                      Caption = 'Final Lic.'
                      DataBinding.FieldName = 'fec_final'
                      HeaderAlignmentHorz = taCenter
                      Width = 82
                    end
                    object cxGridDBColumn4: TcxGridDBColumn
                      Caption = 'D'#237'as'
                      DataBinding.FieldName = 'dias'
                      HeaderAlignmentHorz = taCenter
                    end
                    object cxGridDBColumn5: TcxGridDBColumn
                      Caption = 'Aparato'
                      DataBinding.FieldName = 'oid_aparato'
                      PropertiesClassName = 'TcxLookupComboBoxProperties'
                      Properties.KeyFieldNames = 'oid'
                      Properties.ListColumns = <
                        item
                          FieldName = 'descripcion'
                        end>
                      Properties.ListOptions.ShowHeader = False
                      Properties.ListSource = DSAparatos
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 126
                    end
                    object cxGridDBColumn6: TcxGridDBColumn
                      Caption = 'Enfermedad'
                      DataBinding.FieldName = 'oid_enfermedad'
                      PropertiesClassName = 'TcxLookupComboBoxProperties'
                      Properties.KeyFieldNames = 'oid'
                      Properties.ListColumns = <
                        item
                          FieldName = 'descripcion'
                        end>
                      Properties.ListOptions.ShowHeader = False
                      Properties.ListSource = DSEnfermedad
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 97
                    end
                    object cxGridDBColumn7: TcxGridDBColumn
                      Caption = 'M'#233'dico'
                      DataBinding.FieldName = 'oid_medico'
                      PropertiesClassName = 'TcxLookupComboBoxProperties'
                      Properties.KeyFieldNames = 'oid'
                      Properties.ListColumns = <
                        item
                          FieldName = 'descripcion'
                        end>
                      Properties.ListOptions.ShowHeader = False
                      Properties.ListSource = DSMedicos
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 116
                    end
                    object cxGridDBTableView8Column2: TcxGridDBColumn
                      Caption = 'Fec. Control'
                      DataBinding.FieldName = 'fec_control'
                      HeaderAlignmentHorz = taCenter
                      Width = 81
                    end
                    object cxGridDBColumn9: TcxGridDBColumn
                      Caption = 'S'#237'ntoma'
                      DataBinding.FieldName = 'sintoma'
                      PropertiesClassName = 'TcxMemoProperties'
                      Properties.WantTabs = True
                      HeaderAlignmentHorz = taCenter
                      Width = 200
                    end
                    object cxGridDBColumn10: TcxGridDBColumn
                      Caption = 'Observaci'#243'n'
                      DataBinding.FieldName = 'observacion'
                      PropertiesClassName = 'TcxMemoProperties'
                      Properties.WantTabs = True
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 200
                    end
                    object cxGridDBColumn12: TcxGridDBColumn
                      Caption = 'Activo'
                      DataBinding.FieldName = 'activo'
                      PropertiesClassName = 'TcxCheckBoxProperties'
                      HeaderAlignmentHorz = taCenter
                    end
                  end
                  object cxGridLevel8: TcxGridLevel
                    GridView = cxGridDBTableView8
                  end
                end
              end
              object TabSheet13: TTabSheet
                Caption = 'Enfermedades Familiar      '
                ImageIndex = 2
                object dxDBGridSN10: TdxDBGridSN
                  Left = 0
                  Top = 0
                  Width = 951
                  Height = 368
                  Align = alClient
                  TabOrder = 0
                  LookAndFeel.Kind = lfFlat
                  CriteriosPintarCelda = <>
                  object cxGridDBTableView9: TcxGridDBTableView
                    NavigatorButtons.ConfirmDelete = False
                    DataController.DataSource = DSEnfermedadesFam
                    DataController.Summary.DefaultGroupSummaryItems = <>
                    DataController.Summary.FooterSummaryItems = <>
                    DataController.Summary.SummaryGroups = <>
                    OptionsBehavior.FocusCellOnTab = True
                    OptionsBehavior.FocusFirstCellOnNewRecord = True
                    OptionsBehavior.GoToNextCellOnEnter = True
                    OptionsBehavior.FocusCellOnCycle = True
                    OptionsData.Appending = True
                    OptionsData.Deleting = False
                    OptionsSelection.InvertSelect = False
                    OptionsView.CellAutoHeight = True
                    OptionsView.GroupByBox = False
                    object cxGridDBColumn8: TcxGridDBColumn
                      Caption = 'ID Nov.'
                      DataBinding.FieldName = 'nro_nov_sist_ext'
                      HeaderAlignmentHorz = taCenter
                      Options.Editing = False
                      Options.Focusing = False
                    end
                    object cxGridDBColumn13: TcxGridDBColumn
                      Caption = 'Inicio'
                      DataBinding.FieldName = 'fec_inicio'
                      HeaderAlignmentHorz = taCenter
                      Width = 85
                    end
                    object cxGridDBColumn14: TcxGridDBColumn
                      Caption = 'Final'
                      DataBinding.FieldName = 'fec_final'
                      HeaderAlignmentHorz = taCenter
                      Width = 82
                    end
                    object cxGridDBColumn15: TcxGridDBColumn
                      Caption = 'D'#237'as'
                      DataBinding.FieldName = 'dias'
                      HeaderAlignmentHorz = taCenter
                    end
                    object cxGridDBColumn18: TcxGridDBColumn
                      Caption = 'Familiar'
                      DataBinding.FieldName = 'oid_familiar'
                      PropertiesClassName = 'TcxLookupComboBoxProperties'
                      Properties.KeyFieldNames = 'oid'
                      Properties.ListColumns = <
                        item
                          FieldName = 'descripcion'
                        end>
                      Properties.ListOptions.ShowHeader = False
                      Properties.ListSource = DSFamiliares
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 116
                    end
                    object cxGridDBColumn16: TcxGridDBColumn
                      Caption = 'Aparato'
                      DataBinding.FieldName = 'oid_aparato'
                      PropertiesClassName = 'TcxLookupComboBoxProperties'
                      Properties.KeyFieldNames = 'oid'
                      Properties.ListColumns = <
                        item
                          FieldName = 'descripcion'
                        end>
                      Properties.ListOptions.ShowHeader = False
                      Properties.ListSource = DSAparatos
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 126
                    end
                    object cxGridDBColumn17: TcxGridDBColumn
                      Caption = 'Enfermedad'
                      DataBinding.FieldName = 'oid_enfermedad'
                      PropertiesClassName = 'TcxLookupComboBoxProperties'
                      Properties.KeyFieldNames = 'oid'
                      Properties.ListColumns = <
                        item
                          FieldName = 'descripcion'
                        end>
                      Properties.ListOptions.ShowHeader = False
                      Properties.ListSource = DSEnfermedad
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 97
                    end
                    object cxGridDBColumn19: TcxGridDBColumn
                      Caption = 'S'#237'ntoma'
                      DataBinding.FieldName = 'sintoma'
                      PropertiesClassName = 'TcxMemoProperties'
                      Properties.WantTabs = True
                      HeaderAlignmentHorz = taCenter
                      Width = 200
                    end
                    object cxGridDBTableView9Column1: TcxGridDBColumn
                      Caption = 'Just.'
                      DataBinding.FieldName = 'justifica'
                      PropertiesClassName = 'TcxCheckBoxProperties'
                      HeaderAlignmentHorz = taCenter
                      Width = 40
                    end
                    object cxGridDBColumn20: TcxGridDBColumn
                      Caption = 'Observaci'#243'n'
                      DataBinding.FieldName = 'observacion'
                      PropertiesClassName = 'TcxMemoProperties'
                      Properties.WantTabs = True
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 200
                    end
                    object cxGridDBColumn21: TcxGridDBColumn
                      Caption = 'Activo'
                      DataBinding.FieldName = 'activo'
                      PropertiesClassName = 'TcxCheckBoxProperties'
                      HeaderAlignmentHorz = taCenter
                    end
                  end
                  object cxGridLevel9: TcxGridLevel
                    GridView = cxGridDBTableView9
                  end
                end
              end
              object TabSheet14: TTabSheet
                Caption = 'Accidentes Laborales      '
                ImageIndex = 3
                object dxDBGridSN11: TdxDBGridSN
                  Left = 0
                  Top = 0
                  Width = 951
                  Height = 368
                  Align = alClient
                  TabOrder = 0
                  LookAndFeel.Kind = lfFlat
                  CriteriosPintarCelda = <>
                  object cxGridDBTableView10: TcxGridDBTableView
                    NavigatorButtons.ConfirmDelete = False
                    DataController.DataSource = DSAccidenteLaboral
                    DataController.Summary.DefaultGroupSummaryItems = <>
                    DataController.Summary.FooterSummaryItems = <>
                    DataController.Summary.SummaryGroups = <>
                    OptionsBehavior.FocusCellOnTab = True
                    OptionsBehavior.FocusFirstCellOnNewRecord = True
                    OptionsBehavior.GoToNextCellOnEnter = True
                    OptionsBehavior.FocusCellOnCycle = True
                    OptionsData.Appending = True
                    OptionsData.Deleting = False
                    OptionsSelection.InvertSelect = False
                    OptionsView.CellAutoHeight = True
                    OptionsView.GroupByBox = False
                    object cxGridDBColumn11: TcxGridDBColumn
                      Caption = 'ID Nov.'
                      DataBinding.FieldName = 'nro_nov_sist_ext'
                      HeaderAlignmentHorz = taCenter
                      Options.Editing = False
                      Options.Focusing = False
                    end
                    object cxGridDBColumn22: TcxGridDBColumn
                      Caption = 'Inicio'
                      DataBinding.FieldName = 'fec_inicio'
                      HeaderAlignmentHorz = taCenter
                      Width = 85
                    end
                    object cxGridDBColumn23: TcxGridDBColumn
                      Caption = 'Final'
                      DataBinding.FieldName = 'fec_final'
                      HeaderAlignmentHorz = taCenter
                      Width = 82
                    end
                    object cxGridDBColumn24: TcxGridDBColumn
                      Caption = 'D'#237'as'
                      DataBinding.FieldName = 'dias'
                      HeaderAlignmentHorz = taCenter
                    end
                    object cxGridDBColumn26: TcxGridDBColumn
                      Caption = 'Aparato'
                      DataBinding.FieldName = 'oid_aparato'
                      PropertiesClassName = 'TcxLookupComboBoxProperties'
                      Properties.KeyFieldNames = 'oid'
                      Properties.ListColumns = <
                        item
                          FieldName = 'descripcion'
                        end>
                      Properties.ListOptions.ShowHeader = False
                      Properties.ListSource = DSAparatos
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 126
                    end
                    object cxGridDBColumn27: TcxGridDBColumn
                      Caption = 'Enfermedad'
                      DataBinding.FieldName = 'oid_enfermedad'
                      PropertiesClassName = 'TcxLookupComboBoxProperties'
                      Properties.KeyFieldNames = 'oid'
                      Properties.ListColumns = <
                        item
                          FieldName = 'descripcion'
                        end>
                      Properties.ListOptions.ShowHeader = False
                      Properties.ListSource = DSEnfermedad
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 97
                    end
                    object cxGridDBTableView10Column2: TcxGridDBColumn
                      Caption = 'Fec. Control'
                      DataBinding.FieldName = 'fec_control'
                      HeaderAlignmentHorz = taCenter
                      Width = 96
                    end
                    object cxGridDBColumn28: TcxGridDBColumn
                      Caption = 'S'#237'ntoma'
                      DataBinding.FieldName = 'sintoma'
                      PropertiesClassName = 'TcxMemoProperties'
                      Properties.WantTabs = True
                      HeaderAlignmentHorz = taCenter
                      Width = 200
                    end
                    object cxGridDBColumn30: TcxGridDBColumn
                      Caption = 'Observaci'#243'n'
                      DataBinding.FieldName = 'observacion'
                      PropertiesClassName = 'TcxMemoProperties'
                      Properties.WantTabs = True
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 200
                    end
                    object cxGridDBTableView10Column1: TcxGridDBColumn
                      Caption = 'Desc. Accidente'
                      DataBinding.FieldName = 'desc_accidente'
                      PropertiesClassName = 'TcxMemoProperties'
                      Properties.WantTabs = True
                      HeaderAlignmentHorz = taCenter
                      Width = 250
                    end
                    object cxGridDBColumn31: TcxGridDBColumn
                      Caption = 'Activo'
                      DataBinding.FieldName = 'activo'
                      PropertiesClassName = 'TcxCheckBoxProperties'
                      HeaderAlignmentHorz = taCenter
                      Width = 38
                    end
                  end
                  object cxGridLevel10: TcxGridLevel
                    GridView = cxGridDBTableView10
                  end
                end
              end
            end
          end
        end
        object TabSheet23: TTabSheet
          Caption = 'Novedades'
          ImageIndex = 9
          object dxDBGridSN19: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 1001
            Height = 562
            Align = alClient
            BorderWidth = 5
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object cxGridDBTableView18: TcxGridDBTableView
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
              NavigatorButtons.Insert.Visible = False
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
              DataController.DataSource = DSNovedadLegajo
              DataController.KeyFieldNames = 'oid_novedad'
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsData.Appending = True
              OptionsData.CancelOnExit = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsSelection.InvertSelect = False
              OptionsView.Navigator = True
              OptionsView.CellAutoHeight = True
              OptionsView.GroupByBox = False
              object cxGridDBTableView18oid_tipo_novedad: TcxGridDBColumn
                Caption = 'Tipo Novedad'
                DataBinding.FieldName = 'oid_tipo_novedad'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.DropDownWidth = 250
                Properties.KeyFieldNames = 'oid'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSTipoNovedad
                HeaderAlignmentHorz = taCenter
                Width = 150
              end
              object cxGridDBTableView18nro_ext: TcxGridDBColumn
                Caption = 'Nro. Ext.'
                DataBinding.FieldName = 'nro_ext'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Options.Focusing = False
                Width = 63
              end
              object cxGridDBTableView18Column1: TcxGridDBColumn
                Caption = 'C'#243'd. Motivo'
                DataBinding.FieldName = 'cod_mot_tipo_nov'
                PropertiesClassName = 'TcxButtonEditProperties'
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                HeaderAlignmentHorz = taCenter
                Width = 76
              end
              object cxGridDBTableView18oid_mot_tipo_nov: TcxGridDBColumn
                Caption = 'Motivo'
                DataBinding.FieldName = 'desc_mot_tipo_nov'
                HeaderAlignmentHorz = taCenter
                Width = 115
              end
              object cxGridDBTableView18fecha: TcxGridDBColumn
                Caption = 'Fecha'
                DataBinding.FieldName = 'fecha'
                HeaderAlignmentHorz = taCenter
                SortIndex = 1
                SortOrder = soDescending
                Width = 75
              end
              object cxGridDBTableView18hora_desde: TcxGridDBColumn
                Caption = 'Hora Desde'
                DataBinding.FieldName = 'hora_desde'
                HeaderAlignmentHorz = taCenter
                Width = 85
              end
              object cxGridDBTableView18hora_hasta: TcxGridDBColumn
                Caption = 'Hora Hasta'
                DataBinding.FieldName = 'hora_hasta'
                HeaderAlignmentHorz = taCenter
                Width = 101
              end
              object cxGridDBTableView18observacion: TcxGridDBColumn
                Caption = 'Observaci'#243'n'
                DataBinding.FieldName = 'observacion'
                HeaderAlignmentHorz = taCenter
                Width = 207
              end
              object cxGridDBTableView18activo: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                HeaderAlignmentHorz = taCenter
                Width = 50
              end
              object cxGridDBTableView18Column2: TcxGridDBColumn
                DataBinding.FieldName = 'orden'
                Visible = False
                SortIndex = 0
                SortOrder = soAscending
              end
            end
            object cxGridLevel18: TcxGridLevel
              GridView = cxGridDBTableView18
            end
          end
        end
        object TabSheet15: TTabSheet
          Caption = 'Evaluaciones'
          ImageIndex = 7
          object dxDBGridSN12: TdxDBGridSN
            Left = 0
            Top = 32
            Width = 1001
            Height = 530
            Align = alClient
            BorderWidth = 5
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object cxGridDBTableView11: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSEvaluaciones
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
            end
            object dxDBGridSN12DBBandedTableView1: TcxGridDBBandedTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSEvaluaciones
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.CancelOnExit = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsData.Editing = False
              OptionsData.Inserting = False
              OptionsSelection.InvertSelect = False
              OptionsView.CellAutoHeight = True
              OptionsView.GroupByBox = False
              Bands = <
                item
                  Caption = 'Evaluaciones'
                  FixedKind = fkLeft
                end
                item
                  Caption = 'Porcentaje cumplimiento Competencias'
                  HeaderAlignmentHorz = taLeftJustify
                end>
              object dxDBGridSN12DBBandedTableView1Column1: TcxGridDBBandedColumn
                Caption = 'Empresa'
                DataBinding.FieldName = 'empresa'
                Visible = False
                GroupIndex = 0
                HeaderAlignmentHorz = taCenter
                Width = 149
                Position.BandIndex = 0
                Position.ColIndex = 2
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1Column2: TcxGridDBBandedColumn
                Caption = 'Sector'
                DataBinding.FieldName = 'sector'
                Visible = False
                GroupIndex = 1
                HeaderAlignmentHorz = taCenter
                Width = 138
                Position.BandIndex = 0
                Position.ColIndex = 3
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1Column3: TcxGridDBBandedColumn
                Caption = 'Puesto'
                DataBinding.FieldName = 'puesto'
                HeaderAlignmentHorz = taCenter
                Width = 172
                Position.BandIndex = 0
                Position.ColIndex = 4
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1desc_evaluacion: TcxGridDBBandedColumn
                Caption = 'Evaluaci'#243'n'
                DataBinding.FieldName = 'desc_evaluacion'
                Width = 89
                Position.BandIndex = 0
                Position.ColIndex = 1
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1fec_desde: TcxGridDBBandedColumn
                Caption = 'Del'
                DataBinding.FieldName = 'fec_desde'
                HeaderAlignmentHorz = taCenter
                Position.BandIndex = 0
                Position.ColIndex = 5
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1fec_hasta: TcxGridDBBandedColumn
                Caption = 'Al'
                DataBinding.FieldName = 'fec_hasta'
                HeaderAlignmentHorz = taCenter
                Position.BandIndex = 0
                Position.ColIndex = 6
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1fec_evaluacion: TcxGridDBBandedColumn
                Caption = 'Fec. Eval.'
                DataBinding.FieldName = 'fec_evaluacion'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                SortIndex = 0
                SortOrder = soDescending
                Width = 65
                Position.BandIndex = 0
                Position.ColIndex = 0
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1vigente: TcxGridDBBandedColumn
                Caption = 'Vigente'
                DataBinding.FieldName = 'vigente'
                HeaderAlignmentHorz = taCenter
                Width = 47
                Position.BandIndex = 0
                Position.ColIndex = 7
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1puntaje: TcxGridDBBandedColumn
                Caption = 'Puntaje'
                DataBinding.FieldName = 'puntaje'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '######.##'
                HeaderAlignmentHorz = taCenter
                Position.BandIndex = 0
                Position.ColIndex = 8
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_1: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_1'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 0
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_2: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_2'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 1
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_3: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_3'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 2
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_4: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_4'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 3
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_5: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_5'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 4
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_6: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_6'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 5
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_7: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_7'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 6
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_8: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_8'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 7
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_9: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_9'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 8
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_10: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_10'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 9
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_11: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_11'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 10
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_12: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_12'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 11
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_13: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_13'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 12
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_14: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_14'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 13
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_15: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_15'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 14
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_16: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_16'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 15
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_17: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_17'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 16
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_18: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_18'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 17
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_19: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_19'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 18
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_20: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_20'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 19
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_21: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_21'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 20
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_22: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_22'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 21
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_23: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_23'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 22
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_24: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_24'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 23
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_25: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_25'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 24
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_26: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_26'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 25
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_27: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_27'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 26
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_28: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_28'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 27
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_29: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_29'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 28
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_30: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_30'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 29
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_31: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_31'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 30
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_32: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_32'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 31
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_33: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_33'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 32
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_34: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_34'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 33
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_35: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_35'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 34
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_36: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_36'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 35
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_37: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_37'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 36
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_38: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_38'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 37
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_39: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_39'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 38
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_40: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_40'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 39
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_41: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_41'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 40
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_42: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_42'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 41
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_43: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_43'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 42
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_44: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_44'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 43
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_45: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_45'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 44
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_46: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_46'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 45
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_47: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_47'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 46
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_48: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_48'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 47
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_49: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_49'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 48
                Position.RowIndex = 0
              end
              object dxDBGridSN12DBBandedTableView1compe_50: TcxGridDBBandedColumn
                DataBinding.FieldName = 'compe_50'
                PropertiesClassName = 'TcxCurrencyEditProperties'
                Properties.DisplayFormat = '% ###.##'
                Width = 75
                Position.BandIndex = 1
                Position.ColIndex = 49
                Position.RowIndex = 0
              end
            end
            object cxGridLevel11: TcxGridLevel
              GridView = dxDBGridSN12DBBandedTableView1
            end
          end
          object PanelEstado1: TPanelEstado
            Left = 0
            Top = 0
            Width = 1001
            Height = 32
            Align = alTop
            BevelOuter = bvNone
            ParentColor = True
            TabOrder = 1
            Leyendas = <>
            object snLabel23: TsnLabel
              Left = 32
              Top = 8
              Width = 317
              Height = 13
              Caption = 
                'Al hacer doble click sobre la grilla se puede consultar la Evalu' +
                'aci'#243'n'
            end
          end
        end
        object TabSheet24: TTabSheet
          Caption = 'Desarrollo'
          ImageIndex = 10
          object Panel12: TPanel
            Left = 0
            Top = 0
            Width = 1001
            Height = 48
            Align = alTop
            BevelOuter = bvNone
            Color = clWindow
            TabOrder = 0
            object snLabel24: TsnLabel
              Left = 16
              Top = 19
              Width = 83
              Height = 13
              Caption = 'Estado Desarrollo'
            end
            object srnDBButtonEdit6: TsrnDBButtonEdit
              Left = 117
              Top = 16
              DataBinding.DataField = 'cod_est_desa'
              DataBinding.DataSource = DSLegajos
              Properties.Buttons = <
                item
                  Default = True
                  Kind = bkEllipsis
                end>
              Properties.ClickKey = 112
              TabOrder = 0
              Help = HelpEstadoDesa
              Width = 121
            end
            object snDBEdit14: TsnDBEdit
              Left = 235
              Top = 16
              TabStop = False
              DataBinding.DataField = 'desc_est_desa'
              DataBinding.DataSource = DSLegajos
              Properties.ReadOnly = True
              TabOrder = 1
              Width = 382
            end
          end
          object Panel13: TPanel
            Left = 0
            Top = 48
            Width = 1001
            Height = 514
            Align = alClient
            Color = clWindow
            TabOrder = 1
            object dxDBGridSN20: TdxDBGridSN
              Left = 1
              Top = 1
              Width = 999
              Height = 512
              Align = alClient
              BorderWidth = 5
              TabOrder = 0
              LookAndFeel.Kind = lfFlat
              CriteriosPintarCelda = <>
              object cxGridDBTableView19: TcxGridDBTableView
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
                NavigatorButtons.Insert.Visible = False
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
                DataController.DataSource = DSTCategPosibleLeg
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.FocusCellOnTab = True
                OptionsBehavior.FocusFirstCellOnNewRecord = True
                OptionsBehavior.GoToNextCellOnEnter = True
                OptionsBehavior.FocusCellOnCycle = True
                OptionsData.Appending = True
                OptionsData.CancelOnExit = False
                OptionsData.Deleting = False
                OptionsData.DeletingConfirmation = False
                OptionsSelection.InvertSelect = False
                OptionsView.Navigator = True
                OptionsView.CellAutoHeight = True
                OptionsView.GroupByBox = False
                object cxGridDBTableView19cod_categ_posible: TcxGridDBColumn
                  Caption = 'Categor'#237'a'
                  DataBinding.FieldName = 'cod_categ_posible'
                  PropertiesClassName = 'TcxButtonEditProperties'
                  Properties.Buttons = <
                    item
                      Default = True
                      Kind = bkEllipsis
                    end>
                  HeaderAlignmentHorz = taCenter
                  Width = 115
                end
                object cxGridDBTableView19desc_categ_posible: TcxGridDBColumn
                  Caption = 'Posible Categor'#237'a'
                  DataBinding.FieldName = 'desc_categ_posible'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Options.Focusing = False
                  Width = 358
                end
                object cxGridDBTableView19fec_desde: TcxGridDBColumn
                  Caption = 'Fec. Desde'
                  DataBinding.FieldName = 'fec_desde'
                  PropertiesClassName = 'TcxDateEditProperties'
                  HeaderAlignmentHorz = taCenter
                  SortIndex = 0
                  SortOrder = soAscending
                  Width = 84
                end
                object cxGridDBTableView19fec_hasta: TcxGridDBColumn
                  Caption = 'Fec. Hasta'
                  DataBinding.FieldName = 'fec_hasta'
                  PropertiesClassName = 'TcxDateEditProperties'
                  HeaderAlignmentHorz = taCenter
                  Width = 90
                end
                object cxGridDBTableView19Column1: TcxGridDBColumn
                  Caption = 'Rankear'
                  DataBinding.FieldName = 'oid_rankear'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'oid'
                  Properties.ListColumns = <
                    item
                      FieldName = 'descripcion'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSHelpRankear
                  HeaderAlignmentHorz = taCenter
                  Width = 106
                end
                object cxGridDBTableView19activo: TcxGridDBColumn
                  Caption = 'Activo'
                  DataBinding.FieldName = 'activo'
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  HeaderAlignmentHorz = taCenter
                  Width = 42
                end
              end
              object cxGridLevel19: TcxGridLevel
                GridView = cxGridDBTableView19
              end
            end
          end
        end
        object TabSheet16: TTabSheet
          Caption = 'Legales       '
          ImageIndex = 8
          object Panel8: TPanel
            Left = 0
            Top = 0
            Width = 1133
            Height = 18
            Align = alTop
            BevelOuter = bvNone
            Color = clWindow
            TabOrder = 0
            object snDBCheckEdit6: TsnDBCheckEdit
              Left = 8
              Top = 1
              Caption = 'Seguimiento Legales'
              DataBinding.DataField = 'segui_legales'
              DataBinding.DataSource = DSLegajos
              TabOrder = 0
              Width = 137
            end
            object snDBCheckEdit7: TsnDBCheckEdit
              Left = 152
              Top = 1
              Caption = 'Seguimiento Cartas'
              DataBinding.DataField = 'segui_cartas_docu'
              DataBinding.DataSource = DSLegajos
              TabOrder = 1
              Width = 137
            end
          end
          object Panel9: TPanel
            Left = 0
            Top = 18
            Width = 1133
            Height = 272
            Align = alClient
            BorderWidth = 5
            Color = clWindow
            TabOrder = 1
            object PageControlSN5: TPageControlSN
              Left = 6
              Top = 6
              Width = 1121
              Height = 260
              ActivePage = TabSheet25
              Align = alClient
              TabOrder = 0
              object TabSheet17: TTabSheet
                Caption = 'Cartas Documentos Remitidas          '
                object PanelEstado2: TPanelEstado
                  Left = 0
                  Top = 0
                  Width = 1113
                  Height = 2
                  Align = alTop
                  BevelOuter = bvNone
                  Color = clWindow
                  TabOrder = 0
                  Leyendas = <>
                end
                object PageControlSN6: TPageControlSN
                  Left = 0
                  Top = 2
                  Width = 1113
                  Height = 230
                  Align = alClient
                  TabOrder = 1
                end
                object dxDBGridSN13: TdxDBGridSN
                  Left = 0
                  Top = 2
                  Width = 1113
                  Height = 230
                  Align = alClient
                  BorderWidth = 5
                  TabOrder = 2
                  LookAndFeel.Kind = lfFlat
                  CriteriosPintarCelda = <>
                  object cxGridDBTableView12: TcxGridDBTableView
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
                    NavigatorButtons.Insert.Visible = False
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
                    DataController.DataSource = DSCartasDocRemitidas
                    DataController.Summary.DefaultGroupSummaryItems = <>
                    DataController.Summary.FooterSummaryItems = <>
                    DataController.Summary.SummaryGroups = <>
                    OptionsBehavior.FocusCellOnTab = True
                    OptionsBehavior.FocusFirstCellOnNewRecord = True
                    OptionsBehavior.GoToNextCellOnEnter = True
                    OptionsBehavior.FocusCellOnCycle = True
                    OptionsData.Appending = True
                    OptionsData.CancelOnExit = False
                    OptionsData.Deleting = False
                    OptionsData.DeletingConfirmation = False
                    OptionsSelection.InvertSelect = False
                    OptionsView.Navigator = True
                    OptionsView.CellAutoHeight = True
                    OptionsView.GroupByBox = False
                    object cxGridDBTableView12nro_orden: TcxGridDBColumn
                      Caption = 'Nro. Orden'
                      DataBinding.FieldName = 'nro_orden'
                      Visible = False
                      HeaderAlignmentHorz = taCenter
                    end
                    object cxGridDBTableView12nro_carta_doc: TcxGridDBColumn
                      Caption = 'Nro. Carta Documento'
                      DataBinding.FieldName = 'nro_carta_doc'
                      HeaderAlignmentHorz = taCenter
                      Width = 145
                    end
                    object cxGridDBTableView12fecha: TcxGridDBColumn
                      Caption = 'Fecha'
                      DataBinding.FieldName = 'fecha'
                      HeaderAlignmentHorz = taCenter
                      Width = 70
                    end
                    object cxGridDBTableView12oid_tipo_causa: TcxGridDBColumn
                      Caption = 'Tipo Causa'
                      DataBinding.FieldName = 'oid_tipo_causa'
                      PropertiesClassName = 'TcxLookupComboBoxProperties'
                      Properties.KeyFieldNames = 'oid'
                      Properties.ListColumns = <
                        item
                          FieldName = 'descripcion'
                        end>
                      Properties.ListOptions.ShowHeader = False
                      Properties.ListSource = DSTTipoCausaCartaRem
                      HeaderAlignmentHorz = taCenter
                      Width = 185
                    end
                    object cxGridDBTableView12Column1: TcxGridDBColumn
                      Caption = 'Causa'
                      DataBinding.FieldName = 'causa'
                      PropertiesClassName = 'TcxMemoProperties'
                      HeaderAlignmentHorz = taCenter
                      Width = 341
                    end
                    object cxGridDBTableView12recibido: TcxGridDBColumn
                      Caption = 'Recibida'
                      DataBinding.FieldName = 'recibido'
                      HeaderAlignmentHorz = taCenter
                      Width = 72
                    end
                    object cxGridDBTableView12observaciones: TcxGridDBColumn
                      Caption = 'Observaciones'
                      DataBinding.FieldName = 'observaciones'
                      PropertiesClassName = 'TcxMemoProperties'
                      Properties.MaxLength = 4000
                      HeaderAlignmentHorz = taCenter
                      Width = 287
                    end
                    object cxGridDBTableView12activo: TcxGridDBColumn
                      Caption = 'Activo'
                      DataBinding.FieldName = 'activo'
                      PropertiesClassName = 'TcxCheckBoxProperties'
                      HeaderAlignmentHorz = taCenter
                      Width = 47
                    end
                  end
                  object cxGridLevel12: TcxGridLevel
                    GridView = cxGridDBTableView12
                  end
                end
              end
              object TabSheet18: TTabSheet
                BorderWidth = 5
                Caption = 'Seclos/Acuerdos/MTSS'
                ImageIndex = 1
                object Splitter1: TSplitter
                  Left = 0
                  Top = 105
                  Width = 1103
                  Height = 3
                  Cursor = crVSplit
                  Align = alTop
                end
                object Panel10: TPanel
                  Left = 0
                  Top = 0
                  Width = 1103
                  Height = 105
                  Align = alTop
                  Color = clWindow
                  TabOrder = 0
                  object dxDBGridSN14: TdxDBGridSN
                    Left = 1
                    Top = 1
                    Width = 1101
                    Height = 103
                    Align = alClient
                    TabOrder = 0
                    LookAndFeel.Kind = lfFlat
                    CriteriosPintarCelda = <>
                    object cxGridDBTableView13: TcxGridDBTableView
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
                      NavigatorButtons.Insert.Visible = False
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
                      DataController.DataSource = DSSeclos
                      DataController.Summary.DefaultGroupSummaryItems = <>
                      DataController.Summary.FooterSummaryItems = <>
                      DataController.Summary.SummaryGroups = <>
                      OptionsBehavior.FocusCellOnTab = True
                      OptionsBehavior.FocusFirstCellOnNewRecord = True
                      OptionsBehavior.GoToNextCellOnEnter = True
                      OptionsBehavior.FocusCellOnCycle = True
                      OptionsData.Appending = True
                      OptionsData.CancelOnExit = False
                      OptionsData.Deleting = False
                      OptionsData.DeletingConfirmation = False
                      OptionsSelection.InvertSelect = False
                      OptionsView.Navigator = True
                      OptionsView.CellAutoHeight = True
                      OptionsView.GroupByBox = False
                      object cxGridDBTableView13Column4: TcxGridDBColumn
                        Caption = 'Tipo'
                        DataBinding.FieldName = 'tipo'
                        PropertiesClassName = 'TcxLookupComboBoxProperties'
                        Properties.KeyFieldNames = 'codigo'
                        Properties.ListColumns = <
                          item
                            FieldName = 'descripcion'
                          end>
                        Properties.ListOptions.ShowHeader = False
                        Properties.ListSource = DSTipoSeclo
                        HeaderAlignmentHorz = taCenter
                        Width = 73
                      end
                      object cxGridDBTableView13fec_recepcion: TcxGridDBColumn
                        Caption = 'Fec. Recepci'#243'n'
                        DataBinding.FieldName = 'fec_recepcion'
                        HeaderAlignmentHorz = taCenter
                        HeaderAlignmentVert = vaCenter
                        SortIndex = 0
                        SortOrder = soAscending
                        Width = 105
                      end
                      object cxGridDBTableView13oid_tipo_reclamo: TcxGridDBColumn
                        Caption = 'Forma Reclamo'
                        DataBinding.FieldName = 'oid_tipo_reclamo'
                        PropertiesClassName = 'TcxLookupComboBoxProperties'
                        Properties.KeyFieldNames = 'oid'
                        Properties.ListColumns = <
                          item
                            FieldName = 'descripcion'
                          end>
                        Properties.ListOptions.ShowHeader = False
                        Properties.ListSource = DSTiposReclamos
                        HeaderAlignmentHorz = taCenter
                        HeaderAlignmentVert = vaCenter
                        Width = 105
                      end
                      object cxGridDBTableView13oid_estado_seclo: TcxGridDBColumn
                        Caption = 'Estado'
                        DataBinding.FieldName = 'oid_estado_seclo'
                        PropertiesClassName = 'TcxLookupComboBoxProperties'
                        Properties.KeyFieldNames = 'oid'
                        Properties.ListColumns = <
                          item
                            FieldName = 'descripcion'
                          end>
                        Properties.ListOptions.ShowHeader = False
                        Properties.ListSource = DSEstadosSeclos
                        HeaderAlignmentHorz = taCenter
                        HeaderAlignmentVert = vaCenter
                        Width = 110
                      end
                      object cxGridDBTableView13Column5: TcxGridDBColumn
                        Caption = 'Fec. Novedad'
                        DataBinding.FieldName = 'fec_novedad'
                        HeaderAlignmentHorz = taCenter
                        Width = 100
                      end
                      object cxGridDBTableView13monto_reclamo: TcxGridDBColumn
                        Caption = 'Monto Reclamo'
                        DataBinding.FieldName = 'monto_reclamo'
                        HeaderAlignmentHorz = taCenter
                        HeaderAlignmentVert = vaCenter
                        Width = 90
                      end
                      object cxGridDBTableView13monto_acuerdo: TcxGridDBColumn
                        Caption = 'Acuerdo'
                        DataBinding.FieldName = 'monto_acuerdo'
                        HeaderAlignmentHorz = taCenter
                        HeaderAlignmentVert = vaCenter
                        Width = 76
                      end
                      object cxGridDBTableView13hono_letrado: TcxGridDBColumn
                        Caption = 'H. Letrado'
                        DataBinding.FieldName = 'hono_letrado'
                        HeaderAlignmentHorz = taCenter
                        HeaderAlignmentVert = vaCenter
                        Width = 70
                      end
                      object cxGridDBTableView13hono_conciliado: TcxGridDBColumn
                        Caption = 'H. Conciliador'
                        DataBinding.FieldName = 'hono_conciliado'
                        HeaderAlignmentHorz = taCenter
                        HeaderAlignmentVert = vaCenter
                        Width = 76
                      end
                      object cxGridDBTableView13otros_hono: TcxGridDBColumn
                        Caption = 'Otros H.'
                        DataBinding.FieldName = 'otros_hono'
                        HeaderAlignmentHorz = taCenter
                        HeaderAlignmentVert = vaCenter
                        Width = 71
                      end
                      object cxGridDBTableView13Column1: TcxGridDBColumn
                        Caption = 'Tot. a Pagar'
                        DataBinding.FieldName = 'a_pagar'
                        HeaderAlignmentHorz = taCenter
                        Options.Editing = False
                        Options.Focusing = False
                        Width = 87
                      end
                      object cxGridDBTableView13pagado: TcxGridDBColumn
                        Caption = 'Pagado'
                        DataBinding.FieldName = 'pagado'
                        HeaderAlignmentHorz = taCenter
                        HeaderAlignmentVert = vaCenter
                        Options.Editing = False
                        Options.Focusing = False
                        Width = 76
                      end
                      object cxGridDBTableView13Column2: TcxGridDBColumn
                        Caption = 'Saldo'
                        DataBinding.FieldName = 'saldo'
                        HeaderAlignmentHorz = taCenter
                        Options.Editing = False
                        Width = 84
                      end
                      object cxGridDBTableView13Column6: TcxGridDBColumn
                        Caption = 'Forma Extinci'#243'n'
                        DataBinding.FieldName = 'oid_forma_exti'
                        PropertiesClassName = 'TcxLookupComboBoxProperties'
                        Properties.KeyFieldNames = 'oid'
                        Properties.ListColumns = <
                          item
                            FieldName = 'descripcion'
                          end>
                        Properties.ListOptions.ShowHeader = False
                        Properties.ListSource = DSFormaExtincion
                        HeaderAlignmentHorz = taCenter
                        Width = 152
                      end
                      object cxGridDBTableView13Column7: TcxGridDBColumn
                        Caption = 'Causal Acuerdo'
                        DataBinding.FieldName = 'causal_acuerdo'
                        PropertiesClassName = 'TcxBlobEditProperties'
                        Properties.BlobEditKind = bekMemo
                        Properties.BlobPaintStyle = bpsText
                        HeaderAlignmentHorz = taCenter
                        Width = 248
                      end
                      object cxGridDBTableView13observaciones: TcxGridDBColumn
                        Caption = 'Obs.'
                        DataBinding.FieldName = 'observaciones'
                        PropertiesClassName = 'TcxBlobEditProperties'
                        Properties.BlobEditKind = bekMemo
                        Properties.BlobPaintStyle = bpsText
                        HeaderAlignmentHorz = taCenter
                        HeaderAlignmentVert = vaCenter
                        Width = 250
                      end
                      object cxGridDBTableView13activo: TcxGridDBColumn
                        Caption = 'Activo'
                        DataBinding.FieldName = 'activo'
                        HeaderAlignmentHorz = taCenter
                        HeaderAlignmentVert = vaCenter
                        Width = 45
                      end
                      object cxGridDBTableView13Column3: TcxGridDBColumn
                        Caption = 'C'#243'd. Interno'
                        DataBinding.FieldName = 'codigo_interno'
                        HeaderAlignmentHorz = taCenter
                        Width = 100
                      end
                    end
                    object cxGridLevel13: TcxGridLevel
                      GridView = cxGridDBTableView13
                    end
                  end
                end
                object Panel11: TPanel
                  Left = 0
                  Top = 108
                  Width = 1103
                  Height = 114
                  Align = alClient
                  BorderWidth = 5
                  Color = clWindow
                  TabOrder = 1
                  object PageControlSN7: TPageControlSN
                    Left = 6
                    Top = 6
                    Width = 1091
                    Height = 102
                    ActivePage = TabSheet22
                    Align = alClient
                    TabOrder = 0
                    object TabSheet22: TTabSheet
                      Caption = 'Requeridos     '
                      ImageIndex = 3
                      object dxDBGridSN18: TdxDBGridSN
                        Left = 0
                        Top = 0
                        Width = 1083
                        Height = 74
                        Align = alClient
                        TabOrder = 0
                        LookAndFeel.Kind = lfFlat
                        CriteriosPintarCelda = <>
                        object cxGridDBTableView17: TcxGridDBTableView
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
                          NavigatorButtons.Insert.Visible = False
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
                          DataController.DataSource = DSTRequeridos
                          DataController.Summary.DefaultGroupSummaryItems = <>
                          DataController.Summary.FooterSummaryItems = <>
                          DataController.Summary.SummaryGroups = <>
                          OptionsBehavior.FocusCellOnTab = True
                          OptionsBehavior.FocusFirstCellOnNewRecord = True
                          OptionsBehavior.GoToNextCellOnEnter = True
                          OptionsBehavior.FocusCellOnCycle = True
                          OptionsData.Appending = True
                          OptionsData.CancelOnExit = False
                          OptionsData.Deleting = False
                          OptionsData.DeletingConfirmation = False
                          OptionsSelection.InvertSelect = False
                          OptionsView.Navigator = True
                          OptionsView.CellAutoHeight = True
                          OptionsView.GroupByBox = False
                          object cxGridDBTableView17cod_val_clasif_emp: TcxGridDBColumn
                            Caption = 'Empresa'
                            DataBinding.FieldName = 'cod_val_clasif_emp'
                            PropertiesClassName = 'TcxButtonEditProperties'
                            Properties.Buttons = <
                              item
                                Default = True
                                Kind = bkEllipsis
                              end>
                            Properties.ClickKey = 112
                            HeaderAlignmentHorz = taCenter
                            Width = 109
                          end
                          object cxGridDBTableView17desc_val_clasif_emp: TcxGridDBColumn
                            Caption = 'Raz'#243'n Social'
                            DataBinding.FieldName = 'desc_val_clasif_emp'
                            HeaderAlignmentHorz = taCenter
                            Options.Editing = False
                            Width = 300
                          end
                          object cxGridDBTableView17activo: TcxGridDBColumn
                            Caption = 'Activo'
                            DataBinding.FieldName = 'activo'
                            PropertiesClassName = 'TcxCheckBoxProperties'
                            HeaderAlignmentHorz = taCenter
                            Width = 58
                          end
                        end
                        object cxGridLevel17: TcxGridLevel
                          GridView = cxGridDBTableView17
                        end
                      end
                    end
                    object TabSheet19: TTabSheet
                      Caption = 'Audiencias                    '
                      object dxDBGridSN15: TdxDBGridSN
                        Left = 0
                        Top = 0
                        Width = 1083
                        Height = 396
                        Align = alClient
                        TabOrder = 0
                        LookAndFeel.Kind = lfFlat
                        CriteriosPintarCelda = <>
                        object cxGridDBTableView14: TcxGridDBTableView
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
                          NavigatorButtons.Insert.Visible = False
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
                          DataController.DataSource = DSAudienciaSeclo
                          DataController.Summary.DefaultGroupSummaryItems = <>
                          DataController.Summary.FooterSummaryItems = <>
                          DataController.Summary.SummaryGroups = <>
                          OptionsBehavior.FocusCellOnTab = True
                          OptionsBehavior.FocusFirstCellOnNewRecord = True
                          OptionsBehavior.GoToNextCellOnEnter = True
                          OptionsBehavior.FocusCellOnCycle = True
                          OptionsData.Appending = True
                          OptionsData.CancelOnExit = False
                          OptionsData.Deleting = False
                          OptionsData.DeletingConfirmation = False
                          OptionsSelection.InvertSelect = False
                          OptionsView.Navigator = True
                          OptionsView.CellAutoHeight = True
                          OptionsView.GroupByBox = False
                          object cxGridDBTableView14fecha: TcxGridDBColumn
                            Caption = 'Fecha'
                            DataBinding.FieldName = 'fecha'
                            HeaderAlignmentHorz = taCenter
                            HeaderAlignmentVert = vaCenter
                            SortIndex = 0
                            SortOrder = soAscending
                          end
                          object cxGridDBTableView14hora: TcxGridDBColumn
                            Caption = 'Hora'
                            DataBinding.FieldName = 'hora'
                            HeaderAlignmentHorz = taCenter
                            HeaderAlignmentVert = vaCenter
                          end
                          object cxGridDBTableView14direccion: TcxGridDBColumn
                            Caption = 'Direcci'#243'n'
                            DataBinding.FieldName = 'direccion'
                            PropertiesClassName = 'TcxMemoProperties'
                            Properties.MaxLength = 100
                            HeaderAlignmentHorz = taCenter
                            HeaderAlignmentVert = vaCenter
                            Width = 250
                          end
                          object cxGridDBTableView14conciliador: TcxGridDBColumn
                            Caption = 'Conciliador'
                            DataBinding.FieldName = 'conciliador'
                            PropertiesClassName = 'TcxMemoProperties'
                            Properties.MaxLength = 100
                            HeaderAlignmentHorz = taCenter
                            HeaderAlignmentVert = vaCenter
                            Width = 250
                          end
                          object cxGridDBTableView14telefonos: TcxGridDBColumn
                            DataBinding.FieldName = 'telefonos'
                            PropertiesClassName = 'TcxMemoProperties'
                            Properties.MaxLength = 100
                            HeaderAlignmentHorz = taCenter
                            HeaderAlignmentVert = vaCenter
                            Width = 250
                          end
                          object cxGridDBTableView14activos: TcxGridDBColumn
                            Caption = 'Activo'
                            DataBinding.FieldName = 'activo'
                            PropertiesClassName = 'TcxCheckBoxProperties'
                            HeaderAlignmentVert = vaCenter
                            Width = 44
                          end
                        end
                        object cxGridLevel14: TcxGridLevel
                          GridView = cxGridDBTableView14
                        end
                      end
                    end
                    object TabSheet20: TTabSheet
                      Caption = 'Documentaci'#243'n Enviada             '
                      ImageIndex = 1
                      object dxDBGridSN16: TdxDBGridSN
                        Left = 0
                        Top = 0
                        Width = 1083
                        Height = 396
                        Align = alClient
                        TabOrder = 0
                        LookAndFeel.Kind = lfFlat
                        CriteriosPintarCelda = <>
                        object cxGridDBTableView15: TcxGridDBTableView
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
                          NavigatorButtons.Insert.Visible = False
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
                          DataController.DataSource = DSTDocEnvSec
                          DataController.Summary.DefaultGroupSummaryItems = <>
                          DataController.Summary.FooterSummaryItems = <>
                          DataController.Summary.SummaryGroups = <>
                          OptionsBehavior.FocusCellOnTab = True
                          OptionsBehavior.FocusFirstCellOnNewRecord = True
                          OptionsBehavior.GoToNextCellOnEnter = True
                          OptionsBehavior.FocusCellOnCycle = True
                          OptionsData.Appending = True
                          OptionsData.CancelOnExit = False
                          OptionsData.Deleting = False
                          OptionsData.DeletingConfirmation = False
                          OptionsSelection.InvertSelect = False
                          OptionsView.Navigator = True
                          OptionsView.CellAutoHeight = True
                          OptionsView.GroupByBox = False
                          object cxGridDBTableView15fecha_envio: TcxGridDBColumn
                            Caption = 'Enviada'
                            DataBinding.FieldName = 'fecha_envio'
                            HeaderAlignmentHorz = taCenter
                            HeaderAlignmentVert = vaCenter
                            SortIndex = 0
                            SortOrder = soAscending
                            Width = 105
                          end
                          object cxGridDBTableView15documentacion: TcxGridDBColumn
                            Caption = 'Documentaci'#243'n'
                            DataBinding.FieldName = 'documentacion'
                            PropertiesClassName = 'TcxMemoProperties'
                            Properties.MaxLength = 4000
                            GroupSummaryAlignment = taCenter
                            HeaderAlignmentHorz = taCenter
                            Width = 440
                          end
                          object cxGridDBTableView15activo: TcxGridDBColumn
                            Caption = 'Activo'
                            DataBinding.FieldName = 'activo'
                            PropertiesClassName = 'TcxCheckBoxProperties'
                            HeaderAlignmentHorz = taCenter
                            HeaderAlignmentVert = vaCenter
                            Width = 50
                          end
                        end
                        object cxGridLevel15: TcxGridLevel
                          GridView = cxGridDBTableView15
                        end
                      end
                    end
                    object TabSheet33: TTabSheet
                      Caption = 'Rubros Reclamados    '
                      ImageIndex = 4
                      object dxDBGridSN30: TdxDBGridSN
                        Left = 0
                        Top = 0
                        Width = 951
                        Height = 346
                        Align = alClient
                        TabOrder = 0
                        LookAndFeel.Kind = lfFlat
                        CriteriosPintarCelda = <>
                        object cxGridDBTableView29: TcxGridDBTableView
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
                          NavigatorButtons.Insert.Visible = False
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
                          DataController.DataSource = DSTRubroReclamoSeclo
                          DataController.Summary.DefaultGroupSummaryItems = <>
                          DataController.Summary.FooterSummaryItems = <>
                          DataController.Summary.SummaryGroups = <>
                          OptionsBehavior.FocusCellOnTab = True
                          OptionsBehavior.FocusFirstCellOnNewRecord = True
                          OptionsBehavior.GoToNextCellOnEnter = True
                          OptionsBehavior.FocusCellOnCycle = True
                          OptionsData.Appending = True
                          OptionsData.CancelOnExit = False
                          OptionsData.Deleting = False
                          OptionsData.DeletingConfirmation = False
                          OptionsSelection.InvertSelect = False
                          OptionsView.Navigator = True
                          OptionsView.CellAutoHeight = True
                          OptionsView.GroupByBox = False
                          object cxGridDBColumn43: TcxGridDBColumn
                            Caption = 'Rubro Condena'
                            DataBinding.FieldName = 'oid_rubro_condena'
                            PropertiesClassName = 'TcxLookupComboBoxProperties'
                            Properties.KeyFieldNames = 'oid'
                            Properties.ListColumns = <
                              item
                                FieldName = 'descripcion'
                              end>
                            Properties.ListOptions.ShowHeader = False
                            Properties.ListSource = DSRubroCondena
                            HeaderAlignmentHorz = taCenter
                            Width = 669
                          end
                          object cxGridDBColumn44: TcxGridDBColumn
                            Caption = 'Activo'
                            DataBinding.FieldName = 'activo'
                            PropertiesClassName = 'TcxCheckBoxProperties'
                            HeaderAlignmentHorz = taCenter
                            Width = 47
                          end
                        end
                        object cxGridLevel29: TcxGridLevel
                          GridView = cxGridDBTableView29
                        end
                      end
                    end
                    object TabSheet21: TTabSheet
                      Caption = 'Pagos            '
                      ImageIndex = 2
                      object dxDBGridSN17: TdxDBGridSN
                        Left = 0
                        Top = 0
                        Width = 951
                        Height = 346
                        Align = alClient
                        TabOrder = 0
                        LookAndFeel.Kind = lfFlat
                        CriteriosPintarCelda = <>
                        object cxGridDBTableView16: TcxGridDBTableView
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
                          NavigatorButtons.Insert.Visible = False
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
                          DataController.DataSource = DSPagoSeclo
                          DataController.Summary.DefaultGroupSummaryItems = <>
                          DataController.Summary.FooterSummaryItems = <>
                          DataController.Summary.SummaryGroups = <>
                          OptionsBehavior.FocusCellOnTab = True
                          OptionsBehavior.FocusFirstCellOnNewRecord = True
                          OptionsBehavior.GoToNextCellOnEnter = True
                          OptionsBehavior.FocusCellOnCycle = True
                          OptionsData.Appending = True
                          OptionsData.CancelOnExit = False
                          OptionsData.Deleting = False
                          OptionsData.DeletingConfirmation = False
                          OptionsSelection.InvertSelect = False
                          OptionsView.Navigator = True
                          OptionsView.CellAutoHeight = True
                          OptionsView.GroupByBox = False
                          object cxGridDBTableView16fec_pago: TcxGridDBColumn
                            Caption = 'Fec. Pago'
                            DataBinding.FieldName = 'fec_pago'
                            HeaderAlignmentHorz = taCenter
                            SortIndex = 0
                            SortOrder = soAscending
                            Width = 96
                          end
                          object cxGridDBTableView16oid_conc_pago_seclo: TcxGridDBColumn
                            Caption = 'Concepto'
                            DataBinding.FieldName = 'oid_conc_pago_seclo'
                            PropertiesClassName = 'TcxLookupComboBoxProperties'
                            Properties.KeyFieldNames = 'oid'
                            Properties.ListColumns = <
                              item
                                FieldName = 'descripcion'
                              end>
                            Properties.ListOptions.ShowHeader = False
                            Properties.ListSource = DSConceptos
                            HeaderAlignmentHorz = taCenter
                            Width = 159
                          end
                          object cxGridDBTableView16observacion: TcxGridDBColumn
                            Caption = 'Observaci'#243'n'
                            DataBinding.FieldName = 'observacion'
                            PropertiesClassName = 'TcxMemoProperties'
                            Properties.MaxLength = 4000
                            HeaderAlignmentHorz = taCenter
                            Width = 229
                          end
                          object cxGridDBTableView16pago_acuerdo: TcxGridDBColumn
                            Caption = 'Acuerdo'
                            DataBinding.FieldName = 'pago_acuerdo'
                            HeaderAlignmentHorz = taCenter
                            Width = 75
                          end
                          object cxGridDBTableView16pago_letrado: TcxGridDBColumn
                            Caption = 'Letrado'
                            DataBinding.FieldName = 'pago_letrado'
                            HeaderAlignmentHorz = taCenter
                            Width = 75
                          end
                          object cxGridDBTableView16pago_conciliador: TcxGridDBColumn
                            Caption = 'Conciliador'
                            DataBinding.FieldName = 'pago_conciliador'
                            HeaderAlignmentHorz = taCenter
                            Width = 75
                          end
                          object cxGridDBTableView16pago_otros: TcxGridDBColumn
                            Caption = 'Otros'
                            DataBinding.FieldName = 'pago_otros'
                            HeaderAlignmentHorz = taCenter
                            Width = 75
                          end
                          object cxGridDBTableView16activo: TcxGridDBColumn
                            Caption = 'Activo'
                            DataBinding.FieldName = 'activo'
                            PropertiesClassName = 'TcxCheckBoxProperties'
                            GroupSummaryAlignment = taCenter
                            HeaderAlignmentHorz = taCenter
                            Width = 50
                          end
                        end
                        object cxGridLevel16: TcxGridLevel
                          GridView = cxGridDBTableView16
                        end
                      end
                    end
                  end
                end
              end
              object TabSheet25: TTabSheet
                Caption = 'Juicios              '
                ImageIndex = 2
                object Panel14: TPanel
                  Left = 0
                  Top = 0
                  Width = 1113
                  Height = 232
                  Align = alClient
                  BevelOuter = bvNone
                  BorderWidth = 5
                  Caption = 'Panel14'
                  Color = clWindow
                  TabOrder = 0
                  object Splitter2: TSplitter
                    Left = 5
                    Top = 118
                    Width = 1103
                    Height = 3
                    Cursor = crVSplit
                    Align = alTop
                  end
                  object dxDBGridSN21: TdxDBGridSN
                    Left = 5
                    Top = 5
                    Width = 1103
                    Height = 113
                    Align = alTop
                    TabOrder = 0
                    LookAndFeel.Kind = lfFlat
                    CriteriosPintarCelda = <>
                    object cxGridDBTableView20: TcxGridDBTableView
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
                      NavigatorButtons.Insert.Visible = False
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
                      DataController.DataSource = DSJuicio
                      DataController.Summary.DefaultGroupSummaryItems = <>
                      DataController.Summary.FooterSummaryItems = <>
                      DataController.Summary.SummaryGroups = <>
                      OptionsBehavior.FocusCellOnTab = True
                      OptionsBehavior.FocusFirstCellOnNewRecord = True
                      OptionsBehavior.GoToNextCellOnEnter = True
                      OptionsBehavior.FocusCellOnCycle = True
                      OptionsData.Appending = True
                      OptionsData.CancelOnExit = False
                      OptionsData.Deleting = False
                      OptionsData.DeletingConfirmation = False
                      OptionsSelection.InvertSelect = False
                      OptionsView.Navigator = True
                      OptionsView.CellAutoHeight = True
                      OptionsView.GroupByBox = False
                      object cxGridDBTableView20Column13: TcxGridDBColumn
                        Caption = 'Fuero'
                        DataBinding.FieldName = 'oid_fuero'
                        PropertiesClassName = 'TcxLookupComboBoxProperties'
                        Properties.KeyFieldNames = 'oid'
                        Properties.ListColumns = <
                          item
                            FieldName = 'descripcion'
                          end>
                        Properties.ListOptions.ShowHeader = False
                        Properties.ListSource = DSFueros
                        HeaderAlignmentHorz = taCenter
                        Width = 94
                      end
                      object cxGridDBTableView20oid_tipo_reclamo: TcxGridDBColumn
                        Caption = 'Tipo Reclamo'
                        DataBinding.FieldName = 'oid_tipo_reclamo'
                        PropertiesClassName = 'TcxLookupComboBoxProperties'
                        Properties.KeyFieldNames = 'oid'
                        Properties.ListColumns = <
                          item
                            FieldName = 'descripcion'
                          end>
                        Properties.ListOptions.ShowHeader = False
                        Properties.ListSource = DSTiposReclamos
                        HeaderAlignmentHorz = taCenter
                        Width = 128
                      end
                      object cxGridDBTableView20fec_rec_dem: TcxGridDBColumn
                        Caption = 'Fec. Demanda'
                        DataBinding.FieldName = 'fec_rec_dem'
                        HeaderAlignmentHorz = taCenter
                        SortIndex = 0
                        SortOrder = soAscending
                        Width = 98
                      end
                      object cxGridDBTableView20Column4: TcxGridDBColumn
                        Caption = 'Nro. Juzgado'
                        DataBinding.FieldName = 'nro_juzgado'
                        PropertiesClassName = 'TcxButtonEditProperties'
                        Properties.Buttons = <
                          item
                            Default = True
                            Kind = bkEllipsis
                          end>
                        HeaderAlignmentHorz = taCenter
                        Width = 74
                      end
                      object cxGridDBTableView20oid_juzgado: TcxGridDBColumn
                        Caption = 'Juzgado'
                        DataBinding.FieldName = 'nombre_juzgado'
                        PropertiesClassName = 'TcxButtonEditProperties'
                        Properties.Buttons = <
                          item
                            Default = True
                            Kind = bkEllipsis
                          end>
                        Properties.ClickKey = 112
                        HeaderAlignmentHorz = taCenter
                        Options.Editing = False
                        Options.Focusing = False
                        Width = 224
                      end
                      object cxGridDBTableView20nro_expediente: TcxGridDBColumn
                        Caption = 'Nro. Expediente'
                        DataBinding.FieldName = 'nro_expediente'
                        HeaderAlignmentHorz = taCenter
                        Width = 134
                      end
                      object cxGridDBTableView20monto_reclamo: TcxGridDBColumn
                        Caption = 'Monto Reclamo'
                        DataBinding.FieldName = 'monto_reclamo'
                        HeaderAlignmentHorz = taCenter
                        Width = 94
                      end
                      object cxGridDBTableView20prob_resultado: TcxGridDBColumn
                        Caption = 'Resultado Probable'
                        DataBinding.FieldName = 'prob_resultado'
                        PropertiesClassName = 'TcxLookupComboBoxProperties'
                        Properties.KeyFieldNames = 'codigo'
                        Properties.ListColumns = <
                          item
                            FieldName = 'descripcion'
                          end>
                        Properties.ListOptions.ShowHeader = False
                        Properties.ListSource = DSResulProbJuicio
                        HeaderAlignmentHorz = taCenter
                        HeaderAlignmentVert = vaCenter
                        Width = 103
                      end
                      object cxGridDBTableView20porc_prevision: TcxGridDBColumn
                        Caption = '% Prev.'
                        DataBinding.FieldName = 'porc_prevision'
                        HeaderAlignmentHorz = taCenter
                        Width = 54
                      end
                      object cxGridDBTableView20Column1: TcxGridDBColumn
                        Caption = 'Previsi'#243'n'
                        DataBinding.FieldName = 'estimado'
                        HeaderAlignmentHorz = taCenter
                        Width = 70
                      end
                      object cxGridDBTableView20oid_est_procesal: TcxGridDBColumn
                        Caption = 'Etapa Procesal'
                        DataBinding.FieldName = 'oid_est_procesal'
                        PropertiesClassName = 'TcxLookupComboBoxProperties'
                        Properties.KeyFieldNames = 'oid'
                        Properties.ListColumns = <
                          item
                            FieldName = 'descripcion'
                          end>
                        Properties.ListOptions.ShowHeader = False
                        Properties.ListSource = DSEtapaProcesal
                        HeaderAlignmentHorz = taCenter
                        Width = 110
                      end
                      object cxGridDBTableView20oid_est_juicio: TcxGridDBColumn
                        Caption = 'Estado Juicio'
                        DataBinding.FieldName = 'oid_est_juicio'
                        PropertiesClassName = 'TcxLookupComboBoxProperties'
                        Properties.KeyFieldNames = 'oid'
                        Properties.ListColumns = <
                          item
                            FieldName = 'descripcion'
                          end>
                        Properties.ListOptions.ShowHeader = False
                        Properties.ListSource = DSEstadoJuicio
                        HeaderAlignmentHorz = taCenter
                        Width = 101
                      end
                      object cxGridDBTableView20Column7: TcxGridDBColumn
                        Caption = 'Fec. Novedad'
                        DataBinding.FieldName = 'fec_novedad'
                        HeaderAlignmentHorz = taCenter
                        Width = 86
                      end
                      object cxGridDBTableView20monto_acuerdo: TcxGridDBColumn
                        Caption = 'Capital Acu/Conde.'
                        DataBinding.FieldName = 'monto_acuerdo'
                        HeaderAlignmentHorz = taCenter
                        Width = 97
                      end
                      object cxGridDBTableView20Column16: TcxGridDBColumn
                        Caption = 'Inter'#233's Acu/Conde.'
                        DataBinding.FieldName = 'monto_interes'
                        PropertiesClassName = 'TcxButtonEditProperties'
                        Properties.Buttons = <
                          item
                            Default = True
                            Kind = bkEllipsis
                          end>
                        Width = 98
                      end
                      object cxGridDBTableView20monto_honorario: TcxGridDBColumn
                        Caption = 'Monto Conciliador'
                        DataBinding.FieldName = 'monto_honorario'
                        Width = 94
                      end
                      object cxGridDBTableView20Column17: TcxGridDBColumn
                        Caption = '% Letr.'
                        DataBinding.FieldName = 'porc_letrado'
                        Width = 39
                      end
                      object cxGridDBTableView20Column8: TcxGridDBColumn
                        Caption = 'Monto Letrado'
                        DataBinding.FieldName = 'monto_letrado'
                        Width = 78
                      end
                      object cxGridDBTableView20Column18: TcxGridDBColumn
                        Caption = '% Peri.'
                        DataBinding.FieldName = 'porc_perito'
                        Width = 37
                      end
                      object cxGridDBTableView20monto_perito: TcxGridDBColumn
                        Caption = 'Monto Peritos'
                        DataBinding.FieldName = 'monto_perito'
                        HeaderAlignmentHorz = taCenter
                        Width = 84
                      end
                      object cxGridDBTableView20Column19: TcxGridDBColumn
                        Caption = '% T.J.'
                        DataBinding.FieldName = 'porc_tasa_just'
                        Width = 36
                      end
                      object cxGridDBTableView20tasa_justicia: TcxGridDBColumn
                        Caption = 'Tasa Justicia'
                        DataBinding.FieldName = 'tasa_justicia'
                        HeaderAlignmentHorz = taCenter
                        Width = 84
                      end
                      object cxGridDBTableView20Column9: TcxGridDBColumn
                        Caption = 'Total'
                        DataBinding.FieldName = 'total'
                        HeaderAlignmentHorz = taCenter
                        Options.Editing = False
                        Options.Focusing = False
                        Width = 100
                      end
                      object cxGridDBTableView20Column10: TcxGridDBColumn
                        Caption = 'Pagado'
                        DataBinding.FieldName = 'pagado'
                        HeaderAlignmentHorz = taCenter
                        Options.Editing = False
                        Options.Focusing = False
                        Width = 100
                      end
                      object cxGridDBTableView20Column11: TcxGridDBColumn
                        Caption = 'Saldo'
                        DataBinding.FieldName = 'saldo'
                        HeaderAlignmentHorz = taCenter
                        Options.Editing = False
                        Options.Focusing = False
                        Width = 100
                      end
                      object cxGridDBTableView20oid_peri_mens_prev: TcxGridDBColumn
                        Caption = 'Per'#237'.Prev.Finan.'
                        DataBinding.FieldName = 'periodo'
                        HeaderAlignmentHorz = taCenter
                        Width = 96
                      end
                      object cxGridDBTableView20prevision: TcxGridDBColumn
                        Caption = 'Prev.Finan.'
                        DataBinding.FieldName = 'prevision'
                        HeaderAlignmentHorz = taCenter
                        Width = 70
                      end
                      object cxGridDBTableView20oid_abogado: TcxGridDBColumn
                        Caption = 'Abogado'
                        DataBinding.FieldName = 'abogado'
                        PropertiesClassName = 'TcxButtonEditProperties'
                        Properties.Buttons = <
                          item
                            Default = True
                            Kind = bkEllipsis
                          end>
                        Properties.ClickKey = 112
                        HeaderAlignmentHorz = taCenter
                        Width = 200
                      end
                      object cxGridDBTableView20observaciones: TcxGridDBColumn
                        Caption = 'Observaciones'
                        DataBinding.FieldName = 'observaciones'
                        HeaderAlignmentHorz = taCenter
                        Width = 200
                      end
                      object cxGridDBTableView20Column20: TcxGridDBColumn
                        Caption = '1era. Instancia'
                        DataBinding.FieldName = 'primera_instancia'
                        HeaderAlignmentHorz = taCenter
                        Width = 200
                      end
                      object cxGridDBTableView20Column21: TcxGridDBColumn
                        Caption = '2da. Instancia'
                        DataBinding.FieldName = 'segunda_instancia'
                        HeaderAlignmentHorz = taCenter
                        Width = 200
                      end
                      object cxGridDBTableView20Column2: TcxGridDBColumn
                        Caption = 'Caratula'
                        DataBinding.FieldName = 'caratula'
                        HeaderAlignmentHorz = taCenter
                        Width = 182
                      end
                      object cxGridDBTableView20Column3: TcxGridDBColumn
                        Caption = 'Embargo'
                        DataBinding.FieldName = 'embargo'
                        HeaderAlignmentHorz = taCenter
                        Width = 71
                      end
                      object cxGridDBTableView20Column14: TcxGridDBColumn
                        Caption = 'Comp.Seg.Cauci'#243'n'
                        DataBinding.FieldName = 'oid_comp_seg_cau'
                        PropertiesClassName = 'TcxLookupComboBoxProperties'
                        Properties.KeyFieldNames = 'oid'
                        Properties.ListColumns = <
                          item
                            FieldName = 'descripcion'
                          end>
                        Properties.ListOptions.ShowHeader = False
                        Properties.ListSource = DSCompaniaSeguroCaucion
                        Width = 109
                      end
                      object cxGridDBTableView20Column5: TcxGridDBColumn
                        Caption = 'Resul. Juicio'
                        DataBinding.FieldName = 'oid_resul_juicio'
                        PropertiesClassName = 'TcxLookupComboBoxProperties'
                        Properties.KeyFieldNames = 'oid'
                        Properties.ListColumns = <
                          item
                            FieldName = 'descripcion'
                          end>
                        Properties.ListOptions.ShowHeader = False
                        Properties.ListSource = DSResultadosJuicios
                        HeaderAlignmentHorz = taCenter
                        Width = 91
                      end
                      object cxGridDBTableView20Column6: TcxGridDBColumn
                        Caption = 'C'#243'd. Interno'
                        DataBinding.FieldName = 'codigo_interno'
                        HeaderAlignmentHorz = taCenter
                        Width = 150
                      end
                      object cxGridDBTableView20Column12: TcxGridDBColumn
                        Caption = 'Tipo Pericias'
                        DataBinding.FieldName = 'oid_tipo_pericia'
                        PropertiesClassName = 'TcxLookupComboBoxProperties'
                        Properties.Alignment.Horz = taLeftJustify
                        Properties.KeyFieldNames = 'oid'
                        Properties.ListColumns = <
                          item
                            FieldName = 'descripcion'
                          end>
                        Properties.ListOptions.ShowHeader = False
                        Properties.ListSource = DSTiposPericias
                        HeaderAlignmentHorz = taCenter
                        Width = 213
                      end
                      object cxGridDBTableView20Column15: TcxGridDBColumn
                        Caption = '% Incapacidad'
                        DataBinding.FieldName = 'porc_incapacidad'
                        Width = 80
                      end
                      object cxGridDBTableView20activo: TcxGridDBColumn
                        Caption = 'Activo'
                        DataBinding.FieldName = 'activo'
                        PropertiesClassName = 'TcxCheckBoxProperties'
                        HeaderAlignmentHorz = taCenter
                        Width = 49
                      end
                    end
                    object cxGridLevel20: TcxGridLevel
                      GridView = cxGridDBTableView20
                    end
                  end
                  object Panel16: TPanel
                    Left = 5
                    Top = 121
                    Width = 1103
                    Height = 106
                    Align = alClient
                    BevelOuter = bvNone
                    BorderWidth = 5
                    Color = clWindow
                    TabOrder = 1
                    object PageControlSN8: TPageControlSN
                      Left = 5
                      Top = 5
                      Width = 1093
                      Height = 96
                      ActivePage = TabSheet26
                      Align = alClient
                      TabOrder = 0
                      object TabSheet26: TTabSheet
                        Caption = ' Documentaci'#243'n Enviada '
                        object dxDBGridSN22: TdxDBGridSN
                          Left = 0
                          Top = 0
                          Width = 1085
                          Height = 68
                          Align = alClient
                          TabOrder = 0
                          LookAndFeel.Kind = lfFlat
                          CriteriosPintarCelda = <>
                          object cxGridDBTableView21: TcxGridDBTableView
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
                            NavigatorButtons.Insert.Visible = False
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
                            DataController.DataSource = DSDocuEnvJuicio
                            DataController.Summary.DefaultGroupSummaryItems = <>
                            DataController.Summary.FooterSummaryItems = <>
                            DataController.Summary.SummaryGroups = <>
                            OptionsBehavior.FocusCellOnTab = True
                            OptionsBehavior.FocusFirstCellOnNewRecord = True
                            OptionsBehavior.GoToNextCellOnEnter = True
                            OptionsBehavior.FocusCellOnCycle = True
                            OptionsData.Appending = True
                            OptionsData.CancelOnExit = False
                            OptionsData.Deleting = False
                            OptionsData.DeletingConfirmation = False
                            OptionsSelection.InvertSelect = False
                            OptionsView.Navigator = True
                            OptionsView.CellAutoHeight = True
                            OptionsView.GroupByBox = False
                            object cxGridDBTableView21fecha_envio: TcxGridDBColumn
                              Caption = 'Fec. Env'#237'o'
                              DataBinding.FieldName = 'fecha_envio'
                              HeaderAlignmentHorz = taCenter
                              SortIndex = 0
                              SortOrder = soAscending
                              Width = 81
                            end
                            object cxGridDBTableView21documentacion: TcxGridDBColumn
                              Caption = 'Documentaci'#243'n'
                              DataBinding.FieldName = 'documentacion'
                              PropertiesClassName = 'TcxMemoProperties'
                              Properties.MaxLength = 4000
                              HeaderAlignmentHorz = taCenter
                              Width = 720
                            end
                            object cxGridDBTableView21activo: TcxGridDBColumn
                              Caption = 'Activo'
                              DataBinding.FieldName = 'activo'
                              PropertiesClassName = 'TcxCheckBoxProperties'
                              HeaderAlignmentHorz = taCenter
                              Width = 50
                            end
                          end
                          object cxGridLevel21: TcxGridLevel
                            GridView = cxGridDBTableView21
                          end
                        end
                      end
                      object TabSheet27: TTabSheet
                        Caption = ' Empresas Demandadas  '
                        ImageIndex = 1
                        object dxDBGridSN23: TdxDBGridSN
                          Left = 0
                          Top = 0
                          Width = 1214
                          Height = 319
                          Align = alClient
                          TabOrder = 0
                          LookAndFeel.Kind = lfFlat
                          CriteriosPintarCelda = <>
                          object cxGridDBTableView22: TcxGridDBTableView
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
                            NavigatorButtons.Insert.Visible = False
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
                            DataController.DataSource = DSJuicioEmpresa
                            DataController.Summary.DefaultGroupSummaryItems = <>
                            DataController.Summary.FooterSummaryItems = <>
                            DataController.Summary.SummaryGroups = <>
                            OptionsBehavior.FocusCellOnTab = True
                            OptionsBehavior.FocusFirstCellOnNewRecord = True
                            OptionsBehavior.GoToNextCellOnEnter = True
                            OptionsBehavior.FocusCellOnCycle = True
                            OptionsData.Appending = True
                            OptionsData.CancelOnExit = False
                            OptionsData.Deleting = False
                            OptionsData.DeletingConfirmation = False
                            OptionsSelection.InvertSelect = False
                            OptionsView.Navigator = True
                            OptionsView.CellAutoHeight = True
                            OptionsView.GroupByBox = False
                            object cxGridDBColumn25: TcxGridDBColumn
                              Caption = 'Empresa'
                              DataBinding.FieldName = 'cod_val_clasif_emp'
                              PropertiesClassName = 'TcxButtonEditProperties'
                              Properties.Buttons = <
                                item
                                  Default = True
                                  Kind = bkEllipsis
                                end>
                              Properties.ClickKey = 112
                              HeaderAlignmentHorz = taCenter
                              Width = 109
                            end
                            object cxGridDBColumn29: TcxGridDBColumn
                              Caption = 'Raz'#243'n Social'
                              DataBinding.FieldName = 'desc_val_clasif_emp'
                              HeaderAlignmentHorz = taCenter
                              Options.Editing = False
                              Width = 300
                            end
                            object cxGridDBColumn32: TcxGridDBColumn
                              Caption = 'Activo'
                              DataBinding.FieldName = 'activo'
                              PropertiesClassName = 'TcxCheckBoxProperties'
                              HeaderAlignmentHorz = taCenter
                              Width = 58
                            end
                          end
                          object cxGridLevel22: TcxGridLevel
                            GridView = cxGridDBTableView22
                          end
                        end
                      end
                      object TabSheet32: TTabSheet
                        Caption = 'Rubros Reclamados    '
                        ImageIndex = 5
                        object dxDBGridSN29: TdxDBGridSN
                          Left = 0
                          Top = 0
                          Width = 1214
                          Height = 319
                          Align = alClient
                          TabOrder = 0
                          LookAndFeel.Kind = lfFlat
                          CriteriosPintarCelda = <>
                          object cxGridDBTableView28: TcxGridDBTableView
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
                            NavigatorButtons.Insert.Visible = False
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
                            DataController.DataSource = DSTRubroCondenaJuicio
                            DataController.Summary.DefaultGroupSummaryItems = <>
                            DataController.Summary.FooterSummaryItems = <>
                            DataController.Summary.SummaryGroups = <>
                            OptionsBehavior.FocusCellOnTab = True
                            OptionsBehavior.FocusFirstCellOnNewRecord = True
                            OptionsBehavior.GoToNextCellOnEnter = True
                            OptionsBehavior.FocusCellOnCycle = True
                            OptionsData.Appending = True
                            OptionsData.CancelOnExit = False
                            OptionsData.Deleting = False
                            OptionsData.DeletingConfirmation = False
                            OptionsSelection.InvertSelect = False
                            OptionsView.Navigator = True
                            OptionsView.CellAutoHeight = True
                            OptionsView.GroupByBox = False
                            object cxGridDBColumn41: TcxGridDBColumn
                              Caption = 'Rubro Condena'
                              DataBinding.FieldName = 'oid_rubro_condena'
                              PropertiesClassName = 'TcxLookupComboBoxProperties'
                              Properties.KeyFieldNames = 'oid'
                              Properties.ListColumns = <
                                item
                                  FieldName = 'descripcion'
                                end>
                              Properties.ListOptions.ShowHeader = False
                              Properties.ListSource = DSRubroCondena
                              HeaderAlignmentHorz = taCenter
                              Width = 669
                            end
                            object cxGridDBColumn42: TcxGridDBColumn
                              Caption = 'Activo'
                              DataBinding.FieldName = 'activo'
                              PropertiesClassName = 'TcxCheckBoxProperties'
                              HeaderAlignmentHorz = taCenter
                              Width = 47
                            end
                          end
                          object cxGridLevel28: TcxGridLevel
                            GridView = cxGridDBTableView28
                          end
                        end
                      end
                      object TabSheet28: TTabSheet
                        Caption = 'Audiencias'
                        ImageIndex = 2
                        object dxDBGridSN24: TdxDBGridSN
                          Left = 0
                          Top = 0
                          Width = 1214
                          Height = 319
                          Align = alClient
                          TabOrder = 0
                          LookAndFeel.Kind = lfFlat
                          CriteriosPintarCelda = <>
                          object cxGridDBTableView23: TcxGridDBTableView
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
                            NavigatorButtons.Insert.Visible = False
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
                            DataController.DataSource = DSTAudienciaJuicio
                            DataController.Summary.DefaultGroupSummaryItems = <>
                            DataController.Summary.FooterSummaryItems = <>
                            DataController.Summary.SummaryGroups = <>
                            OptionsBehavior.FocusCellOnTab = True
                            OptionsBehavior.FocusFirstCellOnNewRecord = True
                            OptionsBehavior.GoToNextCellOnEnter = True
                            OptionsBehavior.FocusCellOnCycle = True
                            OptionsData.Appending = True
                            OptionsData.CancelOnExit = False
                            OptionsData.Deleting = False
                            OptionsData.DeletingConfirmation = False
                            OptionsSelection.InvertSelect = False
                            OptionsView.Navigator = True
                            OptionsView.CellAutoHeight = True
                            OptionsView.GroupByBox = False
                            object cxGridDBTableView23fecha: TcxGridDBColumn
                              Caption = 'Fecha'
                              DataBinding.FieldName = 'fecha'
                              HeaderAlignmentHorz = taCenter
                              Width = 103
                            end
                            object cxGridDBTableView23hora: TcxGridDBColumn
                              Caption = 'Hora'
                              DataBinding.FieldName = 'hora'
                              HeaderAlignmentHorz = taCenter
                              Width = 89
                            end
                            object cxGridDBTableView23persona: TcxGridDBColumn
                              Caption = 'Persona'
                              DataBinding.FieldName = 'persona'
                              PropertiesClassName = 'TcxMemoProperties'
                              Properties.MaxLength = 4000
                              HeaderAlignmentHorz = taCenter
                              Width = 410
                            end
                            object cxGridDBTableView23oid_tipo_aud: TcxGridDBColumn
                              Caption = 'Tipo audiencia'
                              DataBinding.FieldName = 'oid_tipo_aud'
                              PropertiesClassName = 'TcxLookupComboBoxProperties'
                              Properties.KeyFieldNames = 'oid'
                              Properties.ListColumns = <
                                item
                                  FieldName = 'descripcion'
                                end>
                              Properties.ListOptions.ShowHeader = False
                              Properties.ListSource = DSTiposAudiencias
                              GroupSummaryAlignment = taCenter
                              HeaderAlignmentHorz = taCenter
                              Width = 143
                            end
                            object cxGridDBTableView23activo: TcxGridDBColumn
                              Caption = 'Activo'
                              DataBinding.FieldName = 'activo'
                              PropertiesClassName = 'TcxCheckBoxProperties'
                              HeaderAlignmentHorz = taCenter
                              Width = 49
                            end
                          end
                          object cxGridLevel23: TcxGridLevel
                            GridView = cxGridDBTableView23
                          end
                        end
                      end
                      object TabSheet29: TTabSheet
                        Caption = 'Pagos Juicios'
                        ImageIndex = 3
                        object dxDBGridSN26: TdxDBGridSN
                          Left = 0
                          Top = 0
                          Width = 1214
                          Height = 319
                          Align = alClient
                          TabOrder = 0
                          LookAndFeel.Kind = lfFlat
                          CriteriosPintarCelda = <>
                          object cxGridDBTableView25: TcxGridDBTableView
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
                            NavigatorButtons.Insert.Visible = False
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
                            DataController.DataSource = DSPagoJuicio
                            DataController.Summary.DefaultGroupSummaryItems = <>
                            DataController.Summary.FooterSummaryItems = <>
                            DataController.Summary.SummaryGroups = <>
                            OptionsBehavior.FocusCellOnTab = True
                            OptionsBehavior.FocusFirstCellOnNewRecord = True
                            OptionsBehavior.GoToNextCellOnEnter = True
                            OptionsBehavior.FocusCellOnCycle = True
                            OptionsData.Appending = True
                            OptionsData.CancelOnExit = False
                            OptionsData.Deleting = False
                            OptionsData.DeletingConfirmation = False
                            OptionsSelection.InvertSelect = False
                            OptionsView.Navigator = True
                            OptionsView.CellAutoHeight = True
                            OptionsView.GroupByBox = False
                            object cxGridDBColumn33: TcxGridDBColumn
                              Caption = 'Fec. Pago'
                              DataBinding.FieldName = 'fec_pago'
                              HeaderAlignmentHorz = taCenter
                              SortIndex = 0
                              SortOrder = soAscending
                              Width = 96
                            end
                            object cxGridDBColumn34: TcxGridDBColumn
                              Caption = 'Concepto'
                              DataBinding.FieldName = 'oid_conc_pago_seclo'
                              PropertiesClassName = 'TcxLookupComboBoxProperties'
                              Properties.KeyFieldNames = 'oid'
                              Properties.ListColumns = <
                                item
                                  FieldName = 'descripcion'
                                end>
                              Properties.ListOptions.ShowHeader = False
                              Properties.ListSource = DSConceptos
                              HeaderAlignmentHorz = taCenter
                              Width = 159
                            end
                            object cxGridDBColumn35: TcxGridDBColumn
                              Caption = 'Observaci'#243'n'
                              DataBinding.FieldName = 'observacion'
                              PropertiesClassName = 'TcxMemoProperties'
                              HeaderAlignmentHorz = taCenter
                              Width = 229
                            end
                            object cxGridDBColumn36: TcxGridDBColumn
                              Caption = 'Acuerdo'
                              DataBinding.FieldName = 'pago_acuerdo'
                              HeaderAlignmentHorz = taCenter
                              Width = 75
                            end
                            object cxGridDBColumn37: TcxGridDBColumn
                              Caption = 'Pago Conciliador'
                              DataBinding.FieldName = 'pago_honorario'
                              HeaderAlignmentHorz = taCenter
                              Width = 75
                            end
                            object cxGridDBTableView25Column1: TcxGridDBColumn
                              Caption = 'Pago Letrado'
                              DataBinding.FieldName = 'pago_letrado'
                              HeaderAlignmentHorz = taCenter
                              Width = 76
                            end
                            object cxGridDBColumn38: TcxGridDBColumn
                              Caption = 'Pago Perito'
                              DataBinding.FieldName = 'pago_perito'
                              HeaderAlignmentHorz = taCenter
                              Width = 80
                            end
                            object cxGridDBColumn39: TcxGridDBColumn
                              Caption = 'Pago Tasa Justicia'
                              DataBinding.FieldName = 'pago_tasa_just'
                              HeaderAlignmentHorz = taCenter
                              Width = 113
                            end
                            object cxGridDBColumn40: TcxGridDBColumn
                              Caption = 'Activo'
                              DataBinding.FieldName = 'activo'
                              PropertiesClassName = 'TcxCheckBoxProperties'
                              GroupSummaryAlignment = taCenter
                              HeaderAlignmentHorz = taCenter
                              Width = 50
                            end
                          end
                          object cxGridLevel25: TcxGridLevel
                            GridView = cxGridDBTableView25
                          end
                        end
                      end
                      object TabSheet30: TTabSheet
                        Caption = 'Rubros Condena'
                        ImageIndex = 4
                        object dxDBGridSN27: TdxDBGridSN
                          Left = 0
                          Top = 0
                          Width = 1214
                          Height = 319
                          Align = alClient
                          TabOrder = 0
                          LookAndFeel.Kind = lfFlat
                          CriteriosPintarCelda = <>
                          object cxGridDBTableView26: TcxGridDBTableView
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
                            NavigatorButtons.Insert.Visible = False
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
                            DataController.DataSource = DSJuicioRubroCondena
                            DataController.Summary.DefaultGroupSummaryItems = <>
                            DataController.Summary.FooterSummaryItems = <>
                            DataController.Summary.SummaryGroups = <>
                            OptionsBehavior.FocusCellOnTab = True
                            OptionsBehavior.FocusFirstCellOnNewRecord = True
                            OptionsBehavior.GoToNextCellOnEnter = True
                            OptionsBehavior.FocusCellOnCycle = True
                            OptionsData.Appending = True
                            OptionsData.CancelOnExit = False
                            OptionsData.Deleting = False
                            OptionsData.DeletingConfirmation = False
                            OptionsSelection.InvertSelect = False
                            OptionsView.Navigator = True
                            OptionsView.CellAutoHeight = True
                            OptionsView.GroupByBox = False
                            object cxGridDBTableView26oid_rubro_condena: TcxGridDBColumn
                              Caption = 'Rubro Condena'
                              DataBinding.FieldName = 'oid_rubro_condena'
                              PropertiesClassName = 'TcxLookupComboBoxProperties'
                              Properties.KeyFieldNames = 'oid'
                              Properties.ListColumns = <
                                item
                                  FieldName = 'descripcion'
                                end>
                              Properties.ListOptions.ShowHeader = False
                              Properties.ListSource = DSRubroCondena
                              HeaderAlignmentHorz = taCenter
                              Width = 669
                            end
                            object cxGridDBTableView26activo: TcxGridDBColumn
                              Caption = 'Activo'
                              DataBinding.FieldName = 'activo'
                              PropertiesClassName = 'TcxCheckBoxProperties'
                              HeaderAlignmentHorz = taCenter
                              Width = 47
                            end
                          end
                          object cxGridLevel26: TcxGridLevel
                            GridView = cxGridDBTableView26
                          end
                        end
                      end
                      object TabSheet34: TTabSheet
                        Caption = 'C'#225'lculo de Interes'
                        ImageIndex = 6
                        object dxDBGridSN31: TdxDBGridSN
                          Left = 0
                          Top = 41
                          Width = 1343
                          Height = 250
                          Align = alClient
                          TabOrder = 0
                          LookAndFeel.Kind = lfFlat
                          CriteriosPintarCelda = <>
                          object cxGridDBTableView30: TcxGridDBTableView
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
                            NavigatorButtons.Insert.Visible = False
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
                            DataController.DataSource = DSTCalcInteres
                            DataController.Summary.DefaultGroupSummaryItems = <>
                            DataController.Summary.FooterSummaryItems = <
                              item
                                Format = '###,###,###,##0.00'
                                Kind = skSum
                                Column = cxGridDBTableView30interes
                              end>
                            DataController.Summary.SummaryGroups = <>
                            OptionsBehavior.FocusCellOnTab = True
                            OptionsBehavior.FocusFirstCellOnNewRecord = True
                            OptionsBehavior.GoToNextCellOnEnter = True
                            OptionsBehavior.FocusCellOnCycle = True
                            OptionsData.Appending = True
                            OptionsData.CancelOnExit = False
                            OptionsData.Deleting = False
                            OptionsData.DeletingConfirmation = False
                            OptionsSelection.InvertSelect = False
                            OptionsView.Navigator = True
                            OptionsView.CellAutoHeight = True
                            OptionsView.Footer = True
                            OptionsView.GroupByBox = False
                            object cxGridDBTableView30fec_desde: TcxGridDBColumn
                              Caption = 'Fecha Desde'
                              DataBinding.FieldName = 'fec_desde'
                              SortIndex = 0
                              SortOrder = soAscending
                              Width = 90
                            end
                            object cxGridDBTableView30fec_hasta: TcxGridDBColumn
                              Caption = 'Fecha Hasta'
                              DataBinding.FieldName = 'fec_hasta'
                              Width = 90
                            end
                            object cxGridDBTableView30tipo_tasa: TcxGridDBColumn
                              Caption = 'Tipo Tasa'
                              DataBinding.FieldName = 'tipo_tasa'
                              PropertiesClassName = 'TcxLookupComboBoxProperties'
                              Properties.KeyFieldNames = 'codigo'
                              Properties.ListColumns = <
                                item
                                  FieldName = 'descripcion'
                                end>
                              Properties.ListOptions.ShowHeader = False
                              Properties.ListSource = DSTipoInteres
                              Width = 94
                            end
                            object cxGridDBTableView30porc: TcxGridDBColumn
                              Caption = 'Porc.'
                              DataBinding.FieldName = 'porc'
                              HeaderAlignmentVert = vaCenter
                            end
                            object cxGridDBTableView30interes: TcxGridDBColumn
                              Caption = 'Interes'
                              DataBinding.FieldName = 'interes'
                              Options.Editing = False
                              Options.Focusing = False
                              Width = 94
                            end
                            object cxGridDBTableView30activo: TcxGridDBColumn
                              Caption = 'Activo'
                              DataBinding.FieldName = 'activo'
                              PropertiesClassName = 'TcxCheckBoxProperties'
                            end
                          end
                          object cxGridLevel30: TcxGridLevel
                            GridView = cxGridDBTableView30
                          end
                        end
                        object Panel17: TPanel
                          Left = 0
                          Top = 0
                          Width = 1343
                          Height = 41
                          Align = alTop
                          Color = clWindow
                          TabOrder = 1
                          object BotonCalcInteres: TsnButton
                            Left = 24
                            Top = 7
                            Width = 129
                            Height = 27
                            Caption = 'Calcular Inter'#233's'
                            TabOrder = 0
                            LookAndFeel.Kind = lfOffice11
                          end
                        end
                      end
                    end
                  end
                end
                object Panel15: TPanel
                  Left = 0
                  Top = 232
                  Width = 1113
                  Height = 0
                  Align = alBottom
                  BevelOuter = bvNone
                  Color = clWindow
                  TabOrder = 1
                end
              end
              object TabSheet31: TTabSheet
                Caption = 'Negociaciones/ RRLL/ Obs.'
                ImageIndex = 3
                object dxDBGridSN28: TdxDBGridSN
                  Left = 0
                  Top = 0
                  Width = 1113
                  Height = 232
                  Align = alClient
                  TabOrder = 0
                  LookAndFeel.Kind = lfFlat
                  CriteriosPintarCelda = <>
                  object cxGridDBTableView27: TcxGridDBTableView
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
                    NavigatorButtons.Insert.Visible = False
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
                    DataController.DataSource = DSNegociaciones
                    DataController.Summary.DefaultGroupSummaryItems = <>
                    DataController.Summary.FooterSummaryItems = <>
                    DataController.Summary.SummaryGroups = <>
                    OptionsBehavior.FocusCellOnTab = True
                    OptionsBehavior.FocusFirstCellOnNewRecord = True
                    OptionsBehavior.GoToNextCellOnEnter = True
                    OptionsBehavior.FocusCellOnCycle = True
                    OptionsData.Appending = True
                    OptionsData.CancelOnExit = False
                    OptionsData.Deleting = False
                    OptionsData.DeletingConfirmation = False
                    OptionsSelection.InvertSelect = False
                    OptionsView.Navigator = True
                    OptionsView.CellAutoHeight = True
                    OptionsView.GroupByBox = False
                    object cxGridDBTableView27fecha: TcxGridDBColumn
                      Caption = 'Fecha'
                      DataBinding.FieldName = 'fecha'
                      PropertiesClassName = 'TcxDateEditProperties'
                      HeaderAlignmentHorz = taCenter
                      SortIndex = 0
                      SortOrder = soDescending
                      Width = 112
                    end
                    object cxGridDBTableView27observacion: TcxGridDBColumn
                      Caption = 'Observaci'#243'n'
                      DataBinding.FieldName = 'observacion'
                      PropertiesClassName = 'TcxMemoProperties'
                      Properties.MaxLength = 500
                      Width = 532
                    end
                    object cxGridDBTableView27monto: TcxGridDBColumn
                      Caption = 'Monto'
                      DataBinding.FieldName = 'monto'
                      HeaderAlignmentHorz = taCenter
                      Width = 96
                    end
                    object cxGridDBTableView27activo: TcxGridDBColumn
                      Caption = 'Activo'
                      DataBinding.FieldName = 'activo'
                      PropertiesClassName = 'TcxCheckBoxProperties'
                      Width = 42
                    end
                  end
                  object cxGridLevel27: TcxGridLevel
                    GridView = cxGridDBTableView27
                  end
                end
              end
            end
          end
        end
        object TSObservaciones: TTabSheet
          Caption = 'Observaciones'
          ImageIndex = 11
          object dxDBGridSN25: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 1001
            Height = 562
            Align = alClient
            BorderWidth = 5
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object cxGridDBTableView24: TcxGridDBTableView
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
              NavigatorButtons.Insert.Visible = False
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
              DataController.DataSource = DSObservaciones
              DataController.KeyFieldNames = 'oid_novedad'
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsData.Appending = True
              OptionsData.CancelOnExit = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsSelection.InvertSelect = False
              OptionsView.Navigator = True
              OptionsView.CellAutoHeight = True
              OptionsView.GroupByBox = False
              object cxGridDBTableView24oid_tipo_obs_leg: TcxGridDBColumn
                Caption = 'Origen Observaci'#243'n'
                DataBinding.FieldName = 'oid_tipo_obs_leg'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'oid'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSTiposObservaciones
                HeaderAlignmentHorz = taCenter
                Width = 170
              end
              object cxGridDBTableView24Column2: TcxGridDBColumn
                Caption = 'Pos./Neg./Neu.'
                DataBinding.FieldName = 'pos_neg_neu'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'codigo'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSPosNegNeu
                HeaderAlignmentHorz = taCenter
                Width = 103
              end
              object cxGridDBTableView24fecha: TcxGridDBColumn
                Caption = 'Fecha'
                DataBinding.FieldName = 'fecha'
                PropertiesClassName = 'TcxDateEditProperties'
                HeaderAlignmentHorz = taCenter
                Width = 83
              end
              object cxGridDBTableView24fec_carga: TcxGridDBColumn
                Caption = 'Fecha Carga'
                DataBinding.FieldName = 'fec_carga'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Options.Focusing = False
                Width = 87
              end
              object cxGridDBTableView24observacion: TcxGridDBColumn
                Caption = 'Observaci'#243'n'
                DataBinding.FieldName = 'observacion'
                PropertiesClassName = 'TcxMemoProperties'
                HeaderAlignmentHorz = taCenter
                Width = 299
              end
              object cxGridDBTableView24Column1: TcxGridDBColumn
                Caption = 'Usu. Alta'
                DataBinding.FieldName = 'usu_alta'
                HeaderAlignmentHorz = taCenter
                HeaderAlignmentVert = vaCenter
                Options.Editing = False
                Options.Focusing = False
                Width = 91
              end
              object cxGridDBTableView24activo: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                Width = 40
              end
            end
            object cxGridLevel24: TcxGridLevel
              GridView = cxGridDBTableView24
            end
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerLegajos'
    OperGrabarObjeto = 'SaveLegajos'
    CargaDataSets = <
      item
        DataSet = TLegajos
        TableName = 'TLegajos'
      end
      item
        DataSet = TValoresClasificadores
        TableName = 'TValoresClasificadores'
      end
      item
        DataSet = TClasificadorEntidad
        TableName = 'TClasificadorEntidad'
      end
      item
        DataSet = TValorClaifEntidad
        TableName = 'TValorClaifEntidad'
      end
      item
        DataSet = TTarjetaLegajo
        TableName = 'TTarjetaLegajo'
      end
      item
        DataSet = TTiposTarjetas
        TableName = 'TTiposTarjetas'
      end
      item
        DataSet = TMotAccesosIntermedios
        TableName = 'TMotAccesosIntermedios'
      end
      item
        DataSet = TCatAccInternos
        TableName = 'TCatAccInternos'
      end
      item
        DataSet = TFechaRota
        TableName = 'TFechaRota'
      end
      item
        DataSet = TOcultarSolapasLegajo
        TableName = 'TOcultarSolapasLegajo'
      end
      item
        DataSet = THistPuestos
        TableName = 'THistPuestos'
      end
      item
        DataSet = TSancionesLegajo
        TableName = 'TSancionesLegajo'
      end
      item
        DataSet = TPedidosMedicos
        TableName = 'TPedidosMedicos'
      end
      item
        DataSet = TAtencionMedica
        TableName = 'TAtencionMedica'
      end
      item
        DataSet = TEnfermedadesFam
        TableName = 'TEnfermedadesFam'
      end
      item
        DataSet = TAccidenteLaboral
        TableName = 'TAccidenteLaboral'
      end
      item
        DataSet = TLabelCompetencias
        TableName = 'TLabelCompetencias'
      end
      item
        DataSet = TEvaluaciones
        TableName = 'TEvaluaciones'
      end
      item
        DataSet = TOtrosDatosLeg
        TableName = 'TOtrosDatosLeg'
      end
      item
        DataSet = TCartasDocRemitidas
        TableName = 'TCartasDocRemitidas'
      end
      item
        DataSet = TSeclos
        TableName = 'TSeclos'
      end
      item
        DataSet = TAudienciaSeclo
        TableName = 'TAudienciaSeclo'
      end
      item
        DataSet = TDocEnvSec
        TableName = 'TDocEnvSec'
      end
      item
        DataSet = TPagoSeclo
        TableName = 'TPagoSeclo'
      end
      item
        DataSet = TRequeridos
        TableName = 'TRequeridos'
      end
      item
        DataSet = TLeyendasReporte
        TableName = 'TLeyendasReporte'
      end
      item
        DataSet = TNovedadLegajo
        TableName = 'TNovedadLegajo'
      end
      item
        DataSet = TMotivosNov
        TableName = 'TMotivosNov'
      end
      item
        DataSet = TCategPosibleLeg
        TableName = 'TCategPosibleLeg'
      end
      item
        DataSet = TJuicio
        TableName = 'TJuicio'
      end
      item
        DataSet = TResulProbJuicio
        TableName = 'TResulProbJuicio'
      end
      item
        DataSet = TDocuEnvJuicio
        TableName = 'TDocuEnvJuicio'
      end
      item
        DataSet = TJuicioEmpresa
        TableName = 'TJuicioEmpresa'
      end
      item
        DataSet = TAudienciaJuicio
        TableName = 'TAudienciaJuicio'
      end
      item
        DataSet = TObservaciones
        TableName = 'TObservaciones'
      end
      item
        DataSet = TPosNegNeu
        TableName = 'TPosNegNeu'
      end
      item
        DataSet = TPagoJuicio
        TableName = 'TPagoJuicio'
      end
      item
        DataSet = TJuicioRubroCondena
        TableName = 'TJuicioRubroCondena'
      end
      item
        DataSet = TNegociaciones
        TableName = 'TNegociaciones'
      end
      item
        DataSet = TTiposSeclos
        TableName = 'TTiposSeclos'
      end
      item
        DataSet = TMensEmbargoJuicio
        TableName = 'TMensEmbargoJuicio'
      end
      item
        DataSet = TRubroCondenaJuicio
        TableName = 'TRubroCondenaJuicio'
      end
      item
        DataSet = TRubroReclamoSeclo
        TableName = 'TRubroReclamoSeclo'
      end
      item
        DataSet = TCalcInteres
        TableName = 'TCalcInteres'
      end
      item
        DataSet = TRespCalcInt
        TableName = 'TRespCalcInt'
      end>
    BajaLogica = <
      item
        DataSet = TLegajos
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TLegajos
    DataSetDet1 = TValoresClasificadores
    DataSetDet2 = TTarjetaLegajo
    DataSetDet3 = TMotAccesosIntermedios
    DataSetDet4 = TCatAccInternos
    DataSetDet5 = TFechaRota
    DataSetDet6 = THistPuestos
    DataSetDet7 = TSancionesLegajo
    DataSetDet8 = TPedidosMedicos
    DataSetDet9 = TAtencionMedica
    DataSetDetA = TEnfermedadesFam
    DataSetDetB = TAccidenteLaboral
    DataSetDetC = TEvaluaciones
    DataSetDetD = TCartasDocRemitidas
    DataSetDetE = TSeclos
    DataSetDetF = TAudienciaSeclo
    DataSetDetG = TDocEnvSec
    DataSetDetH = TPagoSeclo
    DataSetDetI = TRequeridos
    DataSetDetJ = TNovedadLegajo
    DataSetDetK = TCategPosibleLeg
    DataSetDetL = TJuicio
    DataSetDetM = TDocuEnvJuicio
    DataSetDetN = TJuicioEmpresa
    DataSetDetO = TAudienciaJuicio
    DataSetDetP = TObservaciones
    DataSetDetQ = TPagoJuicio
    DataSetDetR = TJuicioRubroCondena
    DataSetDetS = TNegociaciones
    DataSetDetT = TRubroCondenaJuicio
    DataSetDetU = TRubroReclamoSeclo
    DataSetDetV = TCalcInteres
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 552
    Top = 16
  end
  object TLegajos: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'nro_legajo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'apellido'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'nombre'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'fec_ingreso'
        DataType = ftDate
      end
      item
        Name = 'fec_retiro'
        DataType = ftDate
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'id_identificacion'
        DataType = ftInteger
      end
      item
        Name = 'cod_grupo_puerta_ingreso'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_grupo_puerta_ingreso'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_grupo_puerta_egreso'
        DataType = ftInteger
      end
      item
        Name = 'cod_grupo_puerta_egreso'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_grupo_puerta_egreso'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_estado'
        DataType = ftInteger
      end
      item
        Name = 'cod_estado'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_estado'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_grupo_puerta_ingreso'
        DataType = ftInteger
      end
      item
        Name = 'oid_perm_semenal'
        DataType = ftInteger
      end
      item
        Name = 'cod_perm_semenal'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_perm_semenal'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'act_anti_pass_back'
        DataType = ftBoolean
      end
      item
        Name = 'fec_ult_paso'
        DataType = ftDate
      end
      item
        Name = 'hor_ult_paso'
        DataType = ftString
        Size = 8
      end
      item
        Name = 'sentido_paso'
        DataType = ftString
        Size = 1
      end
      item
        Name = 'ignorar_prox_apb'
        DataType = ftBoolean
      end
      item
        Name = 'circuito_chequeo'
        DataType = ftBoolean
      end
      item
        Name = 'oid_zona_actual'
        DataType = ftInteger
      end
      item
        Name = 'desc_zona_actual'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'lib_ing_al_predio'
        DataType = ftBoolean
      end
      item
        Name = 'prohibir_acceso'
        DataType = ftBoolean
      end
      item
        Name = 'CUIL'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'SEXO'
        DataType = ftString
        Size = 1
      end
      item
        Name = 'oid_estado_civil'
        DataType = ftInteger
      end
      item
        Name = 'fec_nacimiento'
        DataType = ftDate
      end
      item
        Name = 'oid_tipo_docu'
        DataType = ftInteger
      end
      item
        Name = 'nro_documento'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'telefono'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'telefono_celular'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'oid_clase_sind'
        DataType = ftInteger
      end
      item
        Name = 'fec_ant_rec'
        DataType = ftDate
      end
      item
        Name = 'oid_mot_egreso'
        DataType = ftInteger
      end
      item
        Name = 'fec_venc_prot'
        DataType = ftDate
      end
      item
        Name = 'fec_ing_ute'
        DataType = ftDate
      end
      item
        Name = 'direccion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_grado_legajo'
        DataType = ftInteger
      end
      item
        Name = 'cod_grado_leg'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_grado_leg'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'ant_fec_ingreso'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'edad'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'ant_fec_retiro'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'ant_fec_ing_ute'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'ant_fec_ant_rec'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_est_desa'
        DataType = ftInteger
      end
      item
        Name = 'cod_est_desa'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_est_desa'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'segui_legales'
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
    Left = 544
    Top = 107
    object TLegajosoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TLegajosnro_legajo: TStringField
      FieldName = 'nro_legajo'
      Size = 50
    end
    object TLegajosapellido: TStringField
      FieldName = 'apellido'
      Size = 50
    end
    object TLegajosnombre: TStringField
      FieldName = 'nombre'
      Size = 50
    end
    object TLegajosfec_ingreso: TDateField
      FieldName = 'fec_ingreso'
    end
    object TLegajosfec_retiro: TDateField
      FieldName = 'fec_retiro'
    end
    object TLegajosactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TLegajosid_identificacion: TIntegerField
      FieldName = 'id_identificacion'
    end
    object TLegajoscod_grupo_puerta_ingreso: TStringField
      FieldName = 'cod_grupo_puerta_ingreso'
      Size = 50
    end
    object TLegajosdesc_grupo_puerta_ingreso: TStringField
      FieldName = 'desc_grupo_puerta_ingreso'
      Size = 100
    end
    object TLegajosoid_grupo_puerta_egreso: TIntegerField
      FieldName = 'oid_grupo_puerta_egreso'
    end
    object TLegajoscod_grupo_puerta_egreso: TStringField
      FieldName = 'cod_grupo_puerta_egreso'
      Size = 50
    end
    object TLegajosdesc_grupo_puerta_egreso: TStringField
      FieldName = 'desc_grupo_puerta_egreso'
      Size = 100
    end
    object TLegajosoid_estado: TIntegerField
      FieldName = 'oid_estado'
    end
    object TLegajoscod_estado: TStringField
      FieldName = 'cod_estado'
      Size = 50
    end
    object TLegajosdesc_estado: TStringField
      FieldName = 'desc_estado'
      Size = 100
    end
    object TLegajosoid_grupo_puerta_ingreso: TIntegerField
      FieldName = 'oid_grupo_puerta_ingreso'
    end
    object TLegajosoid_perm_semenal: TIntegerField
      FieldName = 'oid_perm_semenal'
    end
    object TLegajoscod_perm_semenal: TStringField
      FieldName = 'cod_perm_semenal'
      Size = 50
    end
    object TLegajosdesc_perm_semenal: TStringField
      FieldName = 'desc_perm_semenal'
      Size = 100
    end
    object TLegajosact_anti_pass_back: TBooleanField
      FieldName = 'act_anti_pass_back'
    end
    object TLegajosfec_ult_paso: TDateField
      FieldName = 'fec_ult_paso'
    end
    object TLegajoshor_ult_paso: TStringField
      DisplayWidth = 8
      FieldName = 'hor_ult_paso'
      Size = 8
    end
    object TLegajossentido_paso: TStringField
      FieldName = 'sentido_paso'
      Size = 1
    end
    object TLegajosignorar_prox_apb: TBooleanField
      FieldName = 'ignorar_prox_apb'
    end
    object TLegajoscircuito_chequeo: TBooleanField
      FieldName = 'circuito_chequeo'
    end
    object TLegajosoid_zona_actual: TIntegerField
      FieldName = 'oid_zona_actual'
    end
    object TLegajosdesc_zona_actual: TStringField
      FieldName = 'desc_zona_actual'
      Size = 100
    end
    object TLegajoslib_ing_al_predio: TBooleanField
      FieldName = 'lib_ing_al_predio'
    end
    object TLegajosprohibir_acceso: TBooleanField
      FieldName = 'prohibir_acceso'
    end
    object TLegajosCUIL: TStringField
      FieldName = 'CUIL'
      Size = 50
    end
    object TLegajosSEXO: TStringField
      FieldName = 'SEXO'
      Size = 1
    end
    object TLegajosoid_estado_civil: TIntegerField
      FieldName = 'oid_estado_civil'
    end
    object TLegajosfec_nacimiento: TDateField
      FieldName = 'fec_nacimiento'
    end
    object TLegajosoid_tipo_docu: TIntegerField
      FieldName = 'oid_tipo_docu'
    end
    object TLegajosnro_documento: TStringField
      FieldName = 'nro_documento'
      Size = 50
    end
    object TLegajostelefono: TStringField
      FieldName = 'telefono'
      Size = 50
    end
    object TLegajostelefono_celular: TStringField
      FieldName = 'telefono_celular'
      Size = 50
    end
    object TLegajosoid_clase_sind: TIntegerField
      FieldName = 'oid_clase_sind'
    end
    object TLegajosfec_ant_rec: TDateField
      FieldName = 'fec_ant_rec'
    end
    object TLegajosoid_mot_egreso: TIntegerField
      FieldName = 'oid_mot_egreso'
    end
    object TLegajosfec_venc_prot: TDateField
      FieldName = 'fec_venc_prot'
    end
    object TLegajosfec_ing_ute: TDateField
      FieldName = 'fec_ing_ute'
    end
    object TLegajosdireccion: TStringField
      DisplayWidth = 100
      FieldName = 'direccion'
      Size = 100
    end
    object TLegajosoid_grado_legajo: TIntegerField
      FieldName = 'oid_grado_legajo'
    end
    object TLegajoscod_grado_leg: TStringField
      FieldName = 'cod_grado_leg'
      Size = 50
    end
    object TLegajosdesc_grado_leg: TStringField
      FieldName = 'desc_grado_leg'
      Size = 100
    end
    object TLegajosant_fec_ingreso: TStringField
      FieldName = 'ant_fec_ingreso'
      Size = 100
    end
    object TLegajosedad: TStringField
      FieldName = 'edad'
      Size = 100
    end
    object TLegajosant_fec_retiro: TStringField
      FieldName = 'ant_fec_retiro'
      Size = 100
    end
    object TLegajosant_fec_ing_ute: TStringField
      FieldName = 'ant_fec_ing_ute'
      Size = 100
    end
    object TLegajosant_fec_ant_rec: TStringField
      FieldName = 'ant_fec_ant_rec'
      Size = 100
    end
    object TLegajosoid_est_desa: TIntegerField
      FieldName = 'oid_est_desa'
    end
    object TLegajoscod_est_desa: TStringField
      FieldName = 'cod_est_desa'
      Size = 50
    end
    object TLegajosdesc_est_desa: TStringField
      FieldName = 'desc_est_desa'
      Size = 100
    end
    object TLegajossegui_legales: TBooleanField
      DefaultExpression = 'false'
      FieldName = 'segui_legales'
    end
    object TLegajossegui_cartas_docu: TBooleanField
      FieldName = 'segui_cartas_docu'
    end
    object TLegajosoid_tarea_desemp: TIntegerField
      FieldName = 'oid_tarea_desemp'
    end
    object TLegajoscod_tarea_desemp: TStringField
      FieldName = 'cod_tarea_desemp'
      Size = 50
    end
    object TLegajosdesc_tarea_desemp: TStringField
      FieldName = 'desc_tarea_desemp'
      Size = 100
    end
  end
  object DSLegajos: TDataSource [4]
    DataSet = TLegajos
    Left = 576
    Top = 107
  end
  inherited TOidObjSave: TsnTable
    Left = 504
    Top = 64
  end
  inherited TOpcHabPrograma: TsnTable
    Left = 544
    Top = 64
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
        TableName = 'TLegajos'
        FieldName = 'nro_legajo'
        Source.Strings = (
          'begin'
          '  ValidadorLegajo.Value := Sender.AsString;'
          '  ValidadorLegajo.Validar;'
          'end.')
      end
      item
        TableName = 'TValoresClasificadores'
        FieldName = 'cod_valor'
        Source.Strings = (
          'begin'
          
            '   ValidarValorClasifEntidad(TValoresClasificadores.FieldName('#39'o' +
            'id_clasif_ent'#39').AsInteger,'
          '                                           Sender.AsString);'
          'end.')
      end
      item
        TableName = 'TLegajos'
        FieldName = 'cod_grupo_puerta_egreso'
        Source.Strings = (
          'begin'
          '  ValidadorGrupoPuertas1.Value := Sender.AsString;'
          '  ValidadorGrupoPuertas1.Validar();'
          'end.')
      end
      item
        TableName = 'TLegajos'
        FieldName = 'cod_grupo_puerta_ingreso'
        Source.Strings = (
          'begin'
          '  ValidadorGrupoPuertas.Value := Sender.AsString;'
          '  ValidadorGrupoPuertas.Validar();'
          'end.'
          '')
      end
      item
        TableName = 'TLegajos'
        FieldName = 'cod_estado'
        Source.Strings = (
          'begin'
          '  ValidadorEstados.Value := Sender.AsString;'
          '  ValidadorEstados.Validar;'
          'end.')
      end
      item
        TableName = 'TLegajos'
        FieldName = 'cod_perm_semenal'
        Source.Strings = (
          'begin'
          '  ValidadorPlanificacionSemanal.Value := Sender.AsString;'
          '  ValidadorPlanificacionSemanal.Validar;'
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
        TableName = 'TLegajos'
        FieldName = 'cod_grado_leg'
        Source.Strings = (
          'begin'
          '  ValidadorGradoLegajo.Value := Sender.AsString;'
          '  ValidadorGradoLegajo.Validar();'
          'end.')
      end
      item
        TableName = 'THistPuestos'
        FieldName = 'cod_val_clasif_pue'
        Source.Strings = (
          'begin'
          
            '  ValidarValorClasifEntidadPuesto(TOtrosDatosLeg.FieldName('#39'oid_' +
            'clasif_ent_puesto'#39').AsInteger,Sender.AsString);'
          'end.')
      end
      item
        TableName = 'TRequeridos'
        FieldName = 'cod_val_clasif_emp'
        Source.Strings = (
          'begin'
          '  ValidarValorClasifEmpresa(Sender.AsString);'
          'end.')
      end
      item
        TableName = 'TNovedadLegajo'
        FieldName = 'cod_mot_tipo_nov'
        Source.Strings = (
          'begin'
          '  if (trim(Sender.AsString)='#39#39')'
          '     then begin'
          '             TNovedadLegajo.FieldName('#39'oid_mot_tipo_nov'#39').Clear;'
          
            '             TNovedadLegajo.FieldName('#39'desc_mot_tipo_nov'#39').Clear' +
            ';'
          '             end'
          '     else begin'
          '             TMotivosNov.First;'
          
            '             if (not TMotivosNov.Locate('#39'codigo'#39',Sender.AsString' +
            ',[]))'
          
            '                then raiseException(erCustomError,'#39'C'#243'digo de mot' +
            'ivo inexistente.'#39'); '
          
            '             TNovedadLegajo.FieldName('#39'oid_mot_tipo_nov'#39').AsInte' +
            'ger := TMotivosNov.FieldName('#39'oid'#39').AsInteger;'
          
            '             TNovedadLegajo.FieldName('#39'desc_mot_tipo_nov'#39').AsStr' +
            'ing := TMotivosNov.FieldName('#39'descripcion'#39').AsString;'
          '             end;'
          'end.')
      end
      item
        TableName = 'TNovedadLegajo'
        FieldName = 'oid_tipo_novedad'
        Source.Strings = (
          'begin'
          'end.')
      end
      item
        TableName = 'TLegajos'
        FieldName = 'cod_est_desa'
        Source.Strings = (
          'begin'
          '  ValidadorEstDesa.Value := Sender.AsString;'
          '  ValidadorEstDesa.Validar();'
          'end.')
      end
      item
        TableName = 'TCategPosibleLeg'
        FieldName = 'cod_categ_posible'
        Source.Strings = (
          'begin'
          '  ValidarValorClasifEntidadPuesto1(Sender.AsString);'
          'end.')
      end
      item
        TableName = 'TJuicio'
        FieldName = 'nro_juzgado'
        Source.Strings = (
          'begin'
          '  ValidadorJuzgado.Value := Sender.AsString;'
          '  ValidadorJuzgado.Validar();'
          'end.')
      end
      item
        TableName = 'TJuicio'
        FieldName = 'periodo'
        Source.Strings = (
          'begin'
          '  ValidarPeriodo.Value := Sender.AsString;'
          '  ValidarPeriodo.Validar();'
          'end.')
      end
      item
        TableName = 'TJuicio'
        FieldName = 'abogado'
        Source.Strings = (
          'begin'
          '  ValidadorAbogado.Value := Sender.AsString;'
          '  ValidadorAbogado.Validar();'
          'end.')
      end
      item
        TableName = 'TJuicioEmpresa'
        FieldName = 'cod_val_clasif_emp'
        Source.Strings = (
          'begin'
          '  ValidadorEmpresaJuicio.Value := Sender.AsString;'
          '  ValidadorEmpresaJuicio.Validar();'
          'end.')
      end
      item
        TableName = 'THistPuestos'
        FieldName = 'cod_val_clasif_emp'
        Source.Strings = (
          'begin'
          
            '  ValidarValorClasifEntidadEmpHistPue(TOtrosDatosLeg.FieldName('#39 +
            'oid_clasif_ent_empresa'#39').AsInteger,Sender.AsString);'
          'end.')
      end
      item
        TableName = 'THistPuestos'
        FieldName = 'cod_val_clasif_sec'
        Source.Strings = (
          'begin'
          
            '  ValidarValorClasifEntidadSecHistPue(TOtrosDatosLeg.FieldName('#39 +
            'oid_clasif_ent_sector'#39').AsInteger,Sender.AsString);'
          'end.')
      end
      item
        TableName = 'TLegajos'
        FieldName = 'cod_tarea_desemp'
        Source.Strings = (
          'begin'
          '  ValidadorTareaDesemp.Value := Sender.AsString;'
          '  ValidadorTareaDesemp.Validar();'
          'end.')
      end
      item
        TableName = 'TJuicio'
        FieldName = 'porc_letrado'
        Source.Strings = (
          'begin'
          '  TJuicio.desHabilitarEventoOnValidate('#39'monto_letrado'#39');'
          
            '  TJuicio.FieldName('#39'monto_letrado'#39').AsCurrency := varios.redond' +
            'ear('
          '    (TJuicio.FieldName('#39'monto_acuerdo'#39').Ascurrency +  '
          
            '     TJuicio.FieldName('#39'monto_interes'#39').AsCurrency) * (Sender.As' +
            'Currency/100),2);'
          '  TJuicio.HabilitarEventoOnValidate('#39'monto_letrado'#39');'
          'end.')
      end
      item
        TableName = 'TJuicio'
        FieldName = 'monto_letrado'
        Source.Strings = (
          'begin'
          ''
          '  TJuicio.desHabilitarEventoOnValidate('#39'porc_letrado'#39');'
          
            '  TJuicio.FieldName('#39'porc_letrado'#39').AsCurrency := varios.redonde' +
            'ar('
          '     (Sender.AsCurrency /'
          '    (TJuicio.FieldName('#39'monto_acuerdo'#39').Ascurrency +  '
          '     TJuicio.FieldName('#39'monto_interes'#39').AsCurrency))*100,2); '
          '  TJuicio.HabilitarEventoOnValidate('#39'porc_letrado'#39');'
          ''
          'end.')
      end
      item
        TableName = 'TJuicio'
        FieldName = 'porc_perito'
        Source.Strings = (
          'begin'
          '  TJuicio.desHabilitarEventoOnValidate('#39'monto_perito'#39');'
          
            '  TJuicio.FieldName('#39'monto_perito'#39').AsCurrency := varios.redonde' +
            'ar('
          '    (TJuicio.FieldName('#39'monto_acuerdo'#39').Ascurrency +  '
          
            '     TJuicio.FieldName('#39'monto_interes'#39').AsCurrency) * (Sender.As' +
            'Currency/100),2);'
          '  TJuicio.HabilitarEventoOnValidate('#39'monto_perito'#39');'
          'end.'
          '')
      end
      item
        TableName = 'TJuicio'
        FieldName = 'monto_perito'
        Source.Strings = (
          'begin'
          ''
          '  TJuicio.desHabilitarEventoOnValidate('#39'porc_perito'#39');'
          
            '  TJuicio.FieldName('#39'porc_perito'#39').AsCurrency := varios.redondea' +
            'r('
          '     (Sender.AsCurrency /'
          '    (TJuicio.FieldName('#39'monto_acuerdo'#39').Ascurrency +  '
          '     TJuicio.FieldName('#39'monto_interes'#39').AsCurrency))*100,2); '
          '  TJuicio.HabilitarEventoOnValidate('#39'porc_perito'#39');'
          ''
          'end.')
      end
      item
        TableName = 'TJuicio'
        FieldName = 'porc_tasa_just'
        Source.Strings = (
          'begin'
          '  TJuicio.desHabilitarEventoOnValidate('#39'tasa_justicia'#39');'
          
            '  TJuicio.FieldName('#39'tasa_justicia'#39').AsCurrency := varios.redond' +
            'ear('
          '    (TJuicio.FieldName('#39'monto_acuerdo'#39').Ascurrency +  '
          
            '     TJuicio.FieldName('#39'monto_interes'#39').AsCurrency) * (Sender.As' +
            'Currency/100),2);'
          '  TJuicio.HabilitarEventoOnValidate('#39'tasa_justicia'#39');'
          'end.'
          ''
          '')
      end
      item
        TableName = 'TJuicio'
        FieldName = 'tasa_justicia'
        Source.Strings = (
          'begin'
          ''
          '  TJuicio.desHabilitarEventoOnValidate('#39'porc_tasa_just'#39');'
          
            '  TJuicio.FieldName('#39'porc_tasa_just'#39').AsCurrency := varios.redon' +
            'dear('
          '     (Sender.AsCurrency /'
          '    (TJuicio.FieldName('#39'monto_acuerdo'#39').Ascurrency +  '
          '     TJuicio.FieldName('#39'monto_interes'#39').AsCurrency))*100,2); '
          '  TJuicio.HabilitarEventoOnValidate('#39'porc_tasa_just'#39');'
          ''
          'end.')
      end>
    OnChangeField = <
      item
        TableName = 'TNovedadLegajo'
        FieldName = 'oid_tipo_novedad'
        Source.Strings = (
          'begin'
          '  TNovedadLegajo.FieldName('#39'cod_mot_tipo_nov'#39').AsString := '#39#39';'
          'end.')
      end
      item
        TableName = 'TJuicio'
        FieldName = 'porc_prevision'
        Source.Strings = (
          'begin'
          'TJuicio.FieldName('#39'estimado'#39').AsCurrency := '
          '  (TJuicio.FieldName('#39'porc_prevision'#39').AsCurrency/100)*'
          '  TJuicio.FieldName('#39'monto_reclamo'#39').AsCurrency;'
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
      end
      item
        TableName = 'TLegajos'
        Source.Strings = (
          'begin'
          'end.')
      end
      item
        TableName = 'THistPuestos'
        Source.Strings = (
          'begin'
          ''
          '  if (DataSet.FieldName('#39'oid_val_clasif_pue'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Puesto'#39 +
            ');'
          ''
          '  if (DataSet.FieldName('#39'oid_val_clasif_sec'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Sector'#39 +
            ');'
          ''
          '  if (DataSet.FieldName('#39'oid_val_clasif_emp'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Empresa' +
            #39');'
          ''
          ''
          '  if (DataSet.FieldName('#39'fec_desde'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha d' +
            'esde'#39');'
          ''
          'end.')
      end
      item
        TableName = 'TCartasDocRemitidas'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'fecha'#39').IsNull)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la fecha'#39 +
            ');'
          'end.')
      end
      item
        TableName = 'TSeclos'
        Source.Strings = (
          'begin'
          ''
          '  if (DataSet.FieldName('#39'tipo'#39').AsString = '#39#39')'
          
            '       then raiseException(erCustomError,'#39'Debe ingresar el Tipo'#39 +
            ');'
          ''
          '  if (DataSet.FieldName('#39'oid_estado_seclo'#39').AsInteger = 0)'
          
            '       then raiseException(erCustomError,'#39'Debe ingresar el estad' +
            'o del Seclo'#39');'
          'end.')
      end
      item
        TableName = 'TAudienciaSeclo'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'fecha'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha'#39')' +
            ';'
          'end.')
      end
      item
        TableName = 'TPagoSeclo'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'fec_pago'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha d' +
            'e pago.'#39');'
          '  if (DataSet.FieldName('#39'oid_conc_pago_seclo'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el concept' +
            'o de pago.'#39');'
          'end.')
      end
      item
        TableName = 'TRequeridos'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_val_clasif_emp'#39').AsInteger = 0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la empres' +
            'a.'#39');'
          'end.')
      end
      item
        TableName = 'TNovedadLegajo'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_tipo_novedad'#39').AsInteger = 0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el Tipo d' +
            'e Novedad.'#39');'
          '  if (DataSet.FieldName('#39'oid_mot_tipo_nov'#39').AsInteger = 0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el Motivo' +
            ' de la Novedad.'#39');'
          '  if (DataSet.FieldName('#39'fecha'#39').IsNull )'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la fecha.' +
            #39');'
          ''
          'end.')
      end
      item
        TableName = 'TCategPosibleLeg'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_categ_posible'#39').AsInteger = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Categor' +
            #237'a'#39');'
          '  if (DataSet.FieldName('#39'fec_desde'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Fecha d' +
            'esde'#39');'
          '  if (DataSet.FieldName('#39'fec_hasta'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Fecha h' +
            'asta'#39');'
          'end.')
      end
      item
        TableName = 'TDocuEnvJuicio'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'fecha_envio'#39').IsNull)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la fecha ' +
            'de env'#237'o'#39');'
          'end.')
      end
      item
        TableName = 'TJuicioEmpresa'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_val_clasif_emp'#39').AsInteger=0)'
          
            '      then raiseException(erCustomError,'#39'Debe seleccionar la emp' +
            'resa'#39');'
          'end.')
      end
      item
        TableName = 'TObservaciones'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_tipo_obs_leg'#39').AsInteger=0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el Tipo d' +
            'e Observaci'#243'n'#39');'
          '  if (DataSet.FieldName('#39'fecha'#39').IsNull)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la Fecha'#39 +
            ');'
          '  if (Trim(DataSet.FieldName('#39'observacion'#39').AsString)='#39#39')'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la Observ' +
            'aci'#243'n'#39');'
          'end.'
          '')
      end
      item
        TableName = 'TPagoJuicio'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'fec_pago'#39').IsNull)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la fecha ' +
            'de Pago'#39');'
          'end.')
      end
      item
        TableName = 'TJuicioRubroCondena'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_rubro_condena'#39').AsInteger = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe seleccionar el rubr' +
            'o condena'#39');'
          'end.')
      end
      item
        TableName = 'TNegociaciones'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'fecha'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha d' +
            'e Negociaci'#243'n'#39');'
          'end.')
      end
      item
        TableName = 'TJuicio'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_fuero'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el fuero'#39')' +
            ';'
          '  if (DataSet.FieldName('#39'oid_est_juicio'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Estado ' +
            'del Juicio'#39');'
          ''
          'end.')
      end
      item
        TableName = 'TCalcInteres'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'fec_desde'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha d' +
            'esde'#39');'
          '  if (DataSet.FieldName('#39'fec_hasta'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha h' +
            'asta'#39');'
          '  if (DataSet.FieldName('#39'tipo_tasa'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Tipo de' +
            ' Tasa'#39');'
          '  if (DataSet.FieldName('#39'porc'#39').AsCurrency=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Porcent' +
            'aje'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TTarjetaLegajo'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_legajo'#39').AsInteger := TLegajos.FieldNam' +
            'e('#39'oid_legajo'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          
            '  DataSet.FieldName('#39'orden'#39').AsInteger := TTarjetaLegajo.getMaxN' +
            'ro('#39'orden'#39')+1;'
          'end.')
      end
      item
        TableName = 'TFechaRota'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_legajo'#39').AsInteger := TLegajos.FieldNam' +
            'e('#39'oid_legajo'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'THistPuestos'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_legajo'#39').AsInteger := TLegajos.FieldNam' +
            'e('#39'oid_legajo'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TSancionesLegajo'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          
            '  DataSet.FieldName('#39'oid_legajo'#39').AsInteger := TLegajos.FieldNam' +
            'e('#39'oid_legajo'#39').AsInteger;'
          'end.')
      end
      item
        TableName = 'TPedidosMedicos'
        Source.Strings = (
          'begin'
          
            '  TPedidosMedicos.FieldName('#39'oid_legajo'#39').AsInteger := TLegajos.' +
            'FieldName('#39'oid_legajo'#39').AsInteger;'
          '  TPedidosMedicos.FieldName('#39'activo'#39').AsBoolean := True;'
          '  TPedidosMedicos.FieldName('#39'justifica'#39').AsBoolean := False;'
          'end.')
      end
      item
        TableName = 'TAtencionMedica'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_legajo'#39').AsInteger := TLegajos.FieldNam' +
            'e('#39'oid_legajo'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TEnfermedadesFam'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_legajo'#39').AsInteger := TLegajos.FieldNam' +
            'e('#39'oid_legajo'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TAccidenteLaboral'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_legajo'#39').AsInteger := TLegajos.FieldNam' +
            'e('#39'oid_legajo'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TCartasDocRemitidas'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_legajo'#39').AsInteger := TLegajos.FieldNam' +
            'e('#39'oid_legajo'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TSeclos'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_legajo'#39').AsInteger := TLegajos.FieldNam' +
            'e('#39'oid_legajo'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True; '
          'end.')
      end
      item
        TableName = 'TAudienciaSeclo'
        Source.Strings = (
          'begin'
          '   DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          
            '   DataSet.FieldName('#39'oid_seclo'#39').AsInteger := TSeclos.FieldName' +
            '('#39'oid_seclo'#39').AsInteger;'
          'end.')
      end
      item
        TableName = 'TDocEnvSec'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_seclo'#39').AsInteger := TSeclos.FieldName(' +
            #39'oid_seclo'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TPagoSeclo'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_seclo'#39').AsInteger := TSeclos.FieldName(' +
            #39'oid_seclo'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TRequeridos'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_seclo'#39').AsInteger := TSeclos.FieldName(' +
            #39'oid_seclo'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TNovedadLegajo'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_legajo'#39').AsInteger := TLegajos.FieldNam' +
            'e('#39'oid_legajo'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True; '
          'end.')
      end
      item
        TableName = 'TCategPosibleLeg'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_legajo'#39').AsInteger := TLegajos.FieldNam' +
            'e('#39'oid_legajo'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TJuicio'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_legajo'#39').AsInteger := TLegajos.FieldNam' +
            'e('#39'oid_legajo'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TDocuEnvJuicio'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_juicio'#39').AsInteger := TJuicio.FieldName' +
            '('#39'oid_juicio'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TJuicioEmpresa'
        Source.Strings = (
          'begin'
          
            '   DataSet.FieldName('#39'oid_juicio'#39').AsInteger := TJuicio.FieldNam' +
            'e('#39'oid_juicio'#39').AsInteger;'
          '   DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TAudienciaJuicio'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_juicio'#39').AsInteger := TJuicio.FieldName' +
            '('#39'oid_juicio'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TObservaciones'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_legajo'#39').AsInteger := TLegajos.FieldNam' +
            'e('#39'oid_legajo'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TPagoJuicio'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_juicio'#39').AsInteger := TJuicio.FieldName' +
            '('#39'oid_juicio'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TJuicioRubroCondena'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_juicio'#39').AsInteger := TJuicio.FieldName' +
            '('#39'oid_juicio'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TNegociaciones'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_legajo'#39').AsInteger := TLegajos.FieldNam' +
            'e('#39'oid_legajo'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True; '
          'end.')
      end
      item
        TableName = 'TRubroCondenaJuicio'
        Source.Strings = (
          'begin  '
          
            '  DataSet.FieldName('#39'oid_juicio'#39').AsInteger := TJuicio.FieldName' +
            '('#39'oid_juicio'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').Value := True;'
          'end.')
      end
      item
        TableName = 'TRubroReclamoSeclo'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := True;'
          
            '  DataSet.FieldName('#39'oid_seclo'#39').Value := TSeclos.FieldName('#39'oid' +
            '_seclo'#39').AsInteger;'
          'end.')
      end
      item
        TableName = 'TCalcInteres'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_juicio'#39').Value := TJuicio.FieldName('#39'oi' +
            'd_juicio'#39').Value;'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end>
    OnDblClick = <
      item
        CompoName = 'dxDBGridSN12DBBandedTableView1'
        Source.Strings = (
          'begin'
          '  if (Varios.isFuncionSeguridadHabilitada(20017,'#39#39',false)=false)'
          
            '     then raiseException(erCustomError,'#39'No habilitado para visua' +
            'lizar la evaluaci'#243'n'#39');'
          ''
          '  MostrarEvaluacion();'
          'end.')
      end>
    OnPublicVariable = <
      item
        VariableName = 'OPEN_BY_ID'
      end
      item
        VariableName = 'oid_cco'
      end>
    OnCalcFields = <
      item
        TableName = 'TSeclos'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'a_pagar'#39').AsCurrency := '
          '    DataSet.FieldName('#39'monto_acuerdo'#39').AsCurrency +'
          '    DataSet.FieldName('#39'hono_letrado'#39').AsCurrency +'
          '    DataSet.FieldName('#39'hono_conciliado'#39').AsCurrency +'
          '    DataSet.FieldName('#39'otros_hono'#39').AsCurrency;'
          '  DataSet.FieldName('#39'saldo'#39').AsCurrency := '
          
            '      DataSet.FieldName('#39'a_pagar'#39').AsCurrency -  DataSet.FieldNa' +
            'me('#39'pagado'#39').AsCurrency;'
          'end.')
      end
      item
        TableName = 'TJuicio'
        Source.Strings = (
          'begin'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TraerTiposTarjetas();'
          '  TraerSentidos();'
          '  TMotAccInter.loadFromHelp('#39'HelpMotAccInter'#39');'
          '  TCategAccesos.loadFromHelp('#39'HelpCategAccesos'#39');'
          '  cargarSexo();'
          '  inicializarLegajos();  '
          '  cargarTipoInteres();'
          ''
          '  '
          ''
          '  try TEstadoCivil.loadFromHelp('#39'HelpEstadoCivil'#39'); except end;'
          '  try TTipoDocu.loadFromHelp('#39'HelpTipoDocu'#39');  except end;'
          
            '  try TMotivoEgreso.loadFromHelp('#39'HelpMotivoEgreso'#39'); except end' +
            ';'
          '  try TSindicato.loadFromHelp('#39'HelpSindicato'#39'); except end;'
          ''
          
            '  try THelpMotivosSanc.loadFromHelp('#39'HelpMotivosSanc'#39'); except e' +
            'nd;'
          
            '  try THelpMotivosFaltas.loadFromHelp('#39'HelpMotivosFaltas'#39'); exce' +
            'pt end;'
          '  try TAparato.loadFromHelp('#39'HelpAparato'#39'); except end;'
          '  try TEnfermedad.loadFromHelp('#39'HelpEnfermedad'#39'); except end;'
          
            '  try TPrestadorMedico.loadFromHelp('#39'HelpPrestadorMedico'#39'); exce' +
            'pt end;'
          
            '  try TMotVisitaFallida.loadFromHelp('#39'HelpMotivoVisFallida'#39'); ex' +
            'cept end;'
          '  try TMedicos.loadFromHelp('#39'HelpMedicos'#39'); except end;'
          
            '  try TTipoPericias.loadFromHelp('#39'HelpTipoPericias'#39'); except end' +
            ';'
          
            '  try TFormaExtincion.loadFromHelp('#39'HelpFormaExtincion'#39'); except' +
            ' end;'
          '  try TFamiliares.loadFromHelp('#39'HelpFamiliares'#39'); except end;'
          
            '  try TTipoCausaCartaRem.loadFromHelp('#39'HelpTipoCausaCartaRem'#39'); ' +
            'except end;'
          '  try TTipoNovedad.loadFromHelp('#39'HelpTipoNovedad'#39'); except end;'
          '  try TTipoReclamo.loadFromHelp('#39'HelpTipoReclamo'#39'); except end;'
          
            '  try TEstadoReclamo.loadFromHelp('#39'HelpEstadosReclamos'#39'); except' +
            ' end;'
          '  try TConcPago.loadFromHelp('#39'HelpConcPago'#39'); except end;'
          
            '  try TTiposObservaciones.loadFromHelp('#39'HelpTipoObservaciones'#39');' +
            ' except end;'
          '  try TFuero.loadFromHelp('#39'HelpFuero'#39'); except end;'
          '  try TSeclos.setAutoCalcFields(true); except end;'
          '  try TSeclos.setRecalcOnFetch(true); except end;'
          '  try TJuicio.setAutoCalcFields(true); except end;'
          '  try TJuicio.setRecalcOnFetch(true); except end;'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTiposSeclos'#39');'
          '  operacion.execute();'
          ''
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerLeyendasRepEval'#39');'
          '  operacion.execute();'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerMotivosNovLeg'#39');'
          '  operacion.execute();'
          '  TraerResulProb();'
          ''
          '   try'
          ''
          
            '  try TEtapaProcesal.loadFromHelp('#39'HelpEtapaProcesal'#39'); except e' +
            'nd;'
          
            '  try TResultadoJuicio.loadFromHelp('#39'HelpResultadoJuicio'#39'); exce' +
            'pt end;'
          
            '  try TRubroCondena.loadFromHelp('#39'HelpRubroCondena'#39'); except end' +
            ';'
          
            '  try TCompaniasSegCaucion.loadFromHelp('#39'HelpCompaniaSeguroCauci' +
            'on'#39'); except end;'
          
            '  try TEstadoJuicio.loadFromHelp('#39'HelpEstadoJuicio'#39'); except end' +
            ';'
          
            '  try TiposAudiencias.loadFromHelp('#39'HelpTipoAudJuicio'#39'); except ' +
            'end;'
          '  try THelpRankear.loadFromHelp('#39'HelpRankear'#39');  except end;'
          '  try TraerPosNegNeu(); except end;'
          ''
          ''
          '   except'
          '   end;'
          ''
          '  try'
          '  PageControlSN1.setActivePage(0); '
          '  except'
          '  end;'
          'end.')
      end>
    OnAfterTraerObjeto = <
      item
        Source.Strings = (
          'begin'
          '  setLabelEvaluaciones();'
          '  TraerImagenLegajo();  '
          '  TSeclos.first;'
          ''
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerMensSiLegTieneEmbargo'#39');'
          
            '  operacion.AddAtribute('#39'oid_legajo'#39', TLegajos.FieldName('#39'oid_le' +
            'gajo'#39').AsString);'
          '  operacion.execute();'
          ''
          '  if (TMensEmbargoJuicio.Active)'
          '      then begin'
          '              if (not TMensEmbargoJuicio.IsEmpty)'
          
            '                  then mensaje.information(TMensEmbargoJuicio.Fi' +
            'eldName('#39'mensaje'#39').AsString);'
          '              end;'
          ''
          'end.')
      end>
    OnAfterModificar = <
      item
        Source.Strings = (
          'begin'
          '  setSeguridadCampos();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerPosNegNeu();'
          'begin'
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'TraerPosNegObs'#39');'
          ' operacion.execute();'
          'end;'
          ''
          'procedure ValidarValorClasifEmpresa(codigo : string);'
          'begin'
          ''
          '  if (codigo = '#39#39')'
          '     then begin'
          '             TRequeridos.EditRecord;'
          
            '             TRequeridos.FieldName('#39'oid_val_clasif_emp'#39').AsInteg' +
            'er := 0;'
          
            '             TRequeridos.FieldName('#39'desc_val_clasif_emp'#39').AsStri' +
            'ng := '#39#39';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifEntidad'#39');'
          
            '  operacion.addAtribute('#39'oid_clasif_ent'#39',IntToStr(TLeyendasRepor' +
            'te.FieldName('#39'oid_clasif_empresa'#39').AsInteger));'
          '  operacion.addAtribute('#39'codigo'#39',codigo);'
          '  operacion.execute;'
          ''
          '  TRequeridos.EditRecord;'
          '  TRequeridos.FieldName('#39'oid_val_clasif_emp'#39').AsInteger :='
          
            '       TValorClaifEntidad.FieldName('#39'oid_valor_clasif_ent'#39').AsIn' +
            'teger;'
          '  TRequeridos.FieldName('#39'desc_val_clasif_emp'#39').AsString :='
          '      TValorClaifEntidad.FieldName('#39'descripcion'#39').AsString;'
          ''
          'end;'
          ''
          'procedure ValidarValorClasifEmpresaJuicio(codigo : string);'
          'begin'
          ''
          '  if (codigo = '#39#39')'
          '     then begin'
          '             TJuicioEmpresa.EditRecord;'
          
            '             TJuicioEmpresa.FieldName('#39'oid_val_clasif_emp'#39').AsIn' +
            'teger := 0;'
          
            '             TJuicioEmpresa.FieldName('#39'desc_val_clasif_emp'#39').AsS' +
            'tring := '#39#39';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifEntidad'#39');'
          
            '  operacion.addAtribute('#39'oid_clasif_ent'#39',IntToStr(TLeyendasRepor' +
            'te.FieldName('#39'oid_clasif_empresa'#39').AsInteger));'
          '  operacion.addAtribute('#39'codigo'#39',codigo);'
          '  operacion.execute;'
          ''
          '  TJuicioEmpresa.EditRecord;'
          '  TJuicioEmpresa.FieldName('#39'oid_val_clasif_emp'#39').AsInteger :='
          
            '       TValorClaifEntidad.FieldName('#39'oid_valor_clasif_ent'#39').AsIn' +
            'teger;'
          '  TJuicioEmpresa.FieldName('#39'desc_val_clasif_emp'#39').AsString :='
          '      TValorClaifEntidad.FieldName('#39'descripcion'#39').AsString;'
          ''
          'end;'
          ''
          ''
          ''
          'procedure MostrarHelpSectoresHistPue();'
          'begin'
          '   HelpValoresClasifSectorHP.NickName           :=  '#39'su.Legajo'#39';'
          
            '   HelpValoresClasifSectorHP.NroClasificador    :=  TLeyendasRep' +
            'orte.FieldName('#39'nro_clasif_sector'#39').AsInteger;'
          '   HelpValoresClasifSectorHP.Mostrar();'
          'end;'
          ''
          ''
          'procedure MostrarHelpEmpresasHistPue();'
          'begin'
          
            '   HelpValoresClasifEmpresaHP.NickName           :=  '#39'su.Legajo'#39 +
            ';'
          
            '   HelpValoresClasifEmpresaHP.NroClasificador    :=  TLeyendasRe' +
            'porte.FieldName('#39'nro_clasif_empresa'#39').AsInteger;'
          '   HelpValoresClasifEmpresaHP.Mostrar();'
          'end;'
          ''
          'procedure MostrarHelpEmpresas();'
          'begin'
          '   HelpValoresClasifEmpresa.NickName           :=  '#39'su.Legajo'#39';'
          
            '   HelpValoresClasifEmpresa.NroClasificador    :=  TLeyendasRepo' +
            'rte.FieldName('#39'nro_clasif_empresa'#39').AsInteger;'
          '   HelpValoresClasifEmpresa.Mostrar();'
          'end;'
          ''
          'procedure MostrarHelpEmpresasJuicio();'
          'begin'
          
            '   HelpValoresClasifEmpresaJuicio.NickName           :=  '#39'su.Leg' +
            'ajo'#39';'
          
            '   HelpValoresClasifEmpresaJuicio.NroClasificador    :=  TLeyend' +
            'asReporte.FieldName('#39'nro_clasif_empresa'#39').AsInteger;'
          '   HelpValoresClasifEmpresaJuicio.Mostrar();'
          'end;'
          ''
          ''
          ''
          'procedure MostrarHelpPuestos();'
          'begin'
          
            '   HelpValoresClasificadorPuesto.NickName           :=  '#39'su.Lega' +
            'jo'#39';'
          
            '   HelpValoresClasificadorPuesto.NroClasificador    :=  TOtrosDa' +
            'tosLeg.FieldName('#39'nro_clasif_puesto'#39').AsInteger;'
          '   HelpValoresClasificadorPuesto.Mostrar();'
          'end;'
          ''
          'procedure TraerSentidos();'
          'begin'
          '  TSentidos.Close;'
          '  TSentidos.Open;'
          ''
          '  TSentidos.AppendRecord;'
          '  TSentidos.FieldName('#39'sentido'#39').AsString := '#39'E'#39';'
          '  TSentidos.FieldName('#39'descripcion'#39').AsString := '#39'Entrada'#39';'
          '  TSentidos.PostRecord;'
          ''
          '  TSentidos.AppendRecord;'
          '  TSentidos.FieldName('#39'sentido'#39').AsString := '#39'S'#39';'
          '  TSentidos.FieldName('#39'descripcion'#39').AsString := '#39'Salida'#39';'
          '  TSentidos.PostRecord;'
          ''
          '  TSentidos.AppendRecord;'
          '  TSentidos.FieldName('#39'sentido'#39').AsString := '#39'N'#39';'
          '  TSentidos.FieldName('#39'descripcion'#39').AsString := '#39'Sin Paso'#39';'
          '  TSentidos.PostRecord;'
          ''
          'end;'
          ''
          'procedure TraerImagenLegajo();'
          'var'
          '  mensajeError  : string;'
          '  nomTempFile : string;'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'DownLoadImageLegajo'#39');'
          
            '  nomTempFile := operacion.DownLoadFile(TLegajos.FieldName('#39'nro_' +
            'legajo'#39').AsString, mensajeError);'
          '  ImagenLegajo.LoadFromFile(nomTempFile);'
          'end;'
          ''
          'procedure MostrarHelpValoresClasificador();'
          'begin'
          
            '   HelpValoresClasificador.NickName           :=  TValoresClasif' +
            'icadores.FieldName('#39'nickname'#39').AsString;'
          
            '   HelpValoresClasificador.NroClasificador    :=  TValoresClasif' +
            'icadores.FieldName('#39'nro_clasif'#39').AsInteger;'
          '   HelpValoresClasificador.Mostrar();'
          'end;'
          ''
          'procedure inicializarClasif();'
          'begin'
          '  TClasificadorEntidad.First;'
          '  while (not TClasificadorEntidad.EOF) do'
          '    begin'
          ''
          '    TValoresClasificadores.AppendRecord;'
          '    TValoresClasificadores.FieldName('#39'oid_legajo'#39').AsInteger :='
          '       TLegajos.FieldName('#39'oid_legajo'#39').AsInteger;'
          
            '    TValoresClasificadores.FieldName('#39'oid_clasif_ent'#39').AsInteger' +
            ' :='
          
            '      TClasificadorEntidad.FieldName('#39'oid_clasif_ent'#39').AsInteger' +
            ';'
          '    TValoresClasificadores.FieldName('#39'nro_clasif'#39').AsInteger :='
          '       TClasificadorEntidad.FieldName('#39'nro_clasif'#39').AsInteger;'
          
            '    TValoresClasificadores.FieldName('#39'desc_grupo_clasif'#39').AsStri' +
            'ng :='
          
            '       TClasificadorEntidad.FieldName('#39'desc_grupo_clasif'#39').AsStr' +
            'ing;'
          '    TValoresClasificadores.FieldName('#39'nickname'#39').AsString :='
          '      TClasificadorEntidad.FieldName('#39'nickname'#39').AsString;'
          
            '    TValoresClasificadores.FieldName('#39'activo'#39').AsBoolean := True' +
            ';'
          
            '    TValoresClasificadores.FieldName('#39'desc_clasificador'#39').AsStri' +
            'ng :='
          '      TClasificadorEntidad.FieldName('#39'descripcion'#39').AsString;'
          '    TValoresClasificadores.PostRecord;'
          ''
          '    TClasificadorEntidad.Next;'
          '    end;'
          ''
          'end;'
          ''
          'procedure inicializarValoresClasif();'
          'begin'
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerLegajos'#39');'
          '  operacion.addAtribute('#39'inicializarClasificadores'#39','#39#39');'
          '  operacion.execute;'
          ''
          '  inicializarClasif();'
          ''
          'end;'
          ''
          'procedure ValidarValorClasifEntidad(OidClasifEnt : integer ;'
          
            '                                                        codigo :' +
            ' string);'
          'begin'
          ''
          '  if (codigo = '#39#39')'
          '     then begin'
          '             TValoresClasificadores.EditRecord;'
          
            '             TValoresClasificadores.FieldName('#39'oid_val_clasif_en' +
            't'#39').AsInteger := 0;'
          
            '             TValoresClasificadores.FieldName('#39'desc_valor'#39').AsSt' +
            'ring := '#39#39';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifEntidad'#39');'
          
            '  operacion.addAtribute('#39'oid_clasif_ent'#39',IntToStr(OidClasifEnt))' +
            ';'
          '  operacion.addAtribute('#39'codigo'#39',codigo);'
          '  operacion.execute;'
          ''
          '  TValoresClasificadores.EditRecord;'
          
            '  TValoresClasificadores.FieldName('#39'oid_val_clasif_ent'#39').AsInteg' +
            'er :='
          
            '       TValorClaifEntidad.FieldName('#39'oid_valor_clasif_ent'#39').AsIn' +
            'teger;'
          '  TValoresClasificadores.FieldName('#39'desc_valor'#39').AsString :='
          '      TValorClaifEntidad.FieldName('#39'descripcion'#39').AsString;'
          ''
          'end;'
          ''
          'procedure TraerTiposTarjetas();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTiposTarjetas'#39');'
          '  operacion.execute();'
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
          
            '    TMotAccesosIntermedios.FieldName('#39'oid_legajo'#39').AsInteger := ' +
            'TLegajos.FieldName('#39'oid_legajo'#39').AsInteger;'
          
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
          'procedure InicializarAltaAccesosInternos();'
          'var'
          '  secu : integer;'
          'begin'
          ''
          '  secu := 1;'
          ''
          '  TCatAccInternos.Close;'
          '  TCatAccInternos.Open;'
          ''
          '  TCategAccesos.First;'
          '  while (not TCategAccesos.EOF) do'
          '  begin'
          ''
          '    secu := secu + 1;'
          ''
          '    TCatAccInternos.AppendRecord; '
          
            '    TCatAccInternos.FieldName('#39'OID_CAT_ACC_LEG'#39').AsInteger := se' +
            'cu;'
          
            '    TCatAccInternos.FieldName('#39'OID_CATEG_ACCESO'#39').AsInteger := T' +
            'CategAccesos.FieldName('#39'oid'#39').AsInteger;'
          
            '    TCatAccInternos.FieldName('#39'DESC_CATEG_ACCESO'#39').AsString := T' +
            'CategAccesos.FieldName('#39'descripcion'#39').AsString;'
          
            '    TCatAccInternos.FieldName('#39'OID_LEGAJO'#39').AsInteger       := T' +
            'Legajos.FieldName('#39'oid_legajo'#39').AsInteger;'
          '    TCatAccInternos.FieldName('#39'ACTIVO'#39').AsBoolean := false;'
          '    TCatAccInternos.PostRecord;   '
          ''
          '    TCategAccesos.next;'
          '  end;'
          ''
          'end;'
          ''
          'procedure inicializarLegajos();'
          'begin'
          '  '
          '  operacion.inicioOperacion();'
          '  operacion.setOper('#39'InitLegajos'#39');'
          '  operacion.execute();'
          ''
          
            '  if (TOcultarSolapasLegajo.FieldName('#39'ocultar_solapa_tarjetas'#39')' +
            '.AsBoolean)'
          '      then PageControlSN1.setTabVisible('#39'TabSheet2'#39',false);'
          ''
          
            '  if (TOcultarSolapasLegajo.FieldName('#39'ocultar_solapa_con_acc'#39').' +
            'AsBoolean)'
          '      then PageControlSN1.setTabVisible('#39'TabSheet3'#39',false);'
          ''
          
            '  if (TOcultarSolapasLegajo.FieldName('#39'ocultar_solapa_personal'#39')' +
            '.AsBoolean)'
          
            '      then PageControlSN1.setTabVisible('#39'TabSheetPesonal'#39',false)' +
            ';'
          ''
          
            '  if (TOcultarSolapasLegajo.FieldName('#39'ocultar_solapa_empresa'#39').' +
            'AsBoolean)'
          '      then PageControlSN1.setTabVisible('#39'TabSheet4'#39',false);'
          ''
          
            '  if (TOcultarSolapasLegajo.FieldName('#39'ocultar_solapa_sanciones'#39 +
            ').AsBoolean)'
          '      then PageControlSN1.setTabVisible('#39'TabSheet9'#39',false);'
          ''
          
            '  if (TOcultarSolapasLegajo.FieldName('#39'ocultar_solapa_servmed'#39').' +
            'AsBoolean)'
          '      then PageControlSN1.setTabVisible('#39'TabSheet10'#39',false);'
          ''
          
            '  if (TOcultarSolapasLegajo.FieldName('#39'ocultar_solapa_eval'#39').AsB' +
            'oolean)'
          '      then PageControlSN1.setTabVisible('#39'TabSheet15'#39',false);'
          ''
          
            '  if (TOcultarSolapasLegajo.FieldName('#39'ocultar_solapa_legales'#39').' +
            'AsBoolean)'
          '      then PageControlSN1.setTabVisible('#39'TabSheet16'#39',false);'
          ''
          
            '  if (TOcultarSolapasLegajo.FieldName('#39'ocultar_solapa_desarrollo' +
            #39').AsBoolean)'
          '      then PageControlSN1.setTabVisible('#39'TabSheet24'#39',false);'
          ''
          
            '  if (TOcultarSolapasLegajo.FieldName('#39'ocultar_solapa_observacio' +
            'nes'#39').AsBoolean)'
          
            '      then PageControlSN1.setTabVisible('#39'TSObservaciones'#39',false)' +
            ';'
          ''
          ''
          ''
          ''
          '  PageControlSN1.setActivePageName('#39'TabSheet1'#39');'
          '  PageControlSN1.setTabVisible('#39'TabSheet1'#39',true);'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20000,'#39#39',false))'
          '   then PageControlSN1.setTabVisible('#39'TabSheet1'#39',true)'
          '   else PageControlSN1.setTabVisible('#39'TabSheet1'#39',false);'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20002,'#39#39',false))'
          '   then PageControlSN1.setTabVisible('#39'TabSheet2'#39',true)'
          '   else PageControlSN1.setTabVisible('#39'TabSheet2'#39',false);'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20004,'#39#39',false))'
          '   then PageControlSN1.setTabVisible('#39'TabSheet3'#39',true)'
          '   else PageControlSN1.setTabVisible('#39'TabSheet3'#39',false);'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20006,'#39#39',false))'
          '   then PageControlSN1.setTabVisible('#39'TabSheetPesonal'#39',true)'
          '   else PageControlSN1.setTabVisible('#39'TabSheetPesonal'#39',false);'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20008,'#39#39',false))'
          '   then PageControlSN1.setTabVisible('#39'TabSheet4'#39',true)'
          '   else PageControlSN1.setTabVisible('#39'TabSheet4'#39',false);'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20010,'#39#39',false))'
          '   then PageControlSN1.setTabVisible('#39'TabSheet9'#39',true)'
          '   else PageControlSN1.setTabVisible('#39'TabSheet9'#39',false);'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20012,'#39#39',false))'
          '   then PageControlSN1.setTabVisible('#39'TabSheet10'#39',true)'
          '   else PageControlSN1.setTabVisible('#39'TabSheet10'#39',false);'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20014,'#39#39',false))'
          '   then PageControlSN1.setTabVisible('#39'TabSheet15'#39',true)'
          '   else PageControlSN1.setTabVisible('#39'TabSheet15'#39',false);'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20019,'#39#39',false))'
          '   then PageControlSN1.setTabVisible('#39'TabSheet16'#39',true)'
          '   else PageControlSN1.setTabVisible('#39'TabSheet16'#39',false);'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20021,'#39#39',false))'
          '   then PageControlSN1.setTabVisible('#39'TabSheet24'#39',true)'
          '   else PageControlSN1.setTabVisible('#39'TabSheet24'#39',false);'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20022,'#39#39',false))'
          '   then PageControlSN1.setTabVisible('#39'TabSheet23'#39',true)'
          '   else PageControlSN1.setTabVisible('#39'TabSheet23'#39',false);'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20024,'#39#39',false))'
          '   then PageControlSN1.setTabVisible('#39'TSObservaciones'#39',true)'
          '   else PageControlSN1.setTabVisible('#39'TSObservaciones'#39',false);'
          ''
          'end;'
          ''
          'procedure cargarSexo();'
          'begin'
          ''
          '  TSexo.Open;'
          '  TSexo.AppendRecord;'
          '  TSexo.FieldName('#39'codigo'#39').AsString := '#39'M'#39';'
          '  TSexo.FieldName('#39'descripcion'#39').AsString := '#39'Masculino'#39';'
          '  TSexo.PostRecord;'
          ''
          '  TSexo.AppendRecord;'
          '  TSexo.FieldName('#39'codigo'#39').AsString := '#39'F'#39';'
          '  TSexo.FieldName('#39'descripcion'#39').AsString := '#39'Femenino'#39';'
          '  TSexo.PostRecord;'
          ''
          'end;'
          ''
          'procedure setLabelEvaluaciones();'
          'var'
          '  i  : integer;'
          'begin'
          ''
          '  for i:=1 to 50 do'
          '    begin'
          '    dxDBGridSN12.setColumnaVisible('#39'compe_'#39'+ IntToStr(i),false);'
          '    end;'
          '  TLabelCompetencias.First;'
          '  while (not TLabelCompetencias.EOF) do'
          '    begin'
          
            '    dxDBGridSN12.setCaptionColumn('#39'compe_'#39'+ TLabelCompetencias.F' +
            'ieldName('#39'nro'#39').AsString, TLabelCompetencias.FieldName('#39'descripc' +
            'ion'#39').AsString);'
          
            '    dxDBGridSN12.setColumnaVisible('#39'compe_'#39'+ TLabelCompetencias.' +
            'FieldName('#39'nro'#39').AsString,true);'
          '    TLabelCompetencias.next;'
          '    end;'
          ''
          'end;'
          ''
          'procedure MostrarEvaluacion();'
          'begin'
          '   if (TEvaluaciones.IsEmpty) then exit;'
          '  formConsEval.ventana := getVentana();'
          '  formConsEval.setString('#39'OPEN_BY_ID'#39','#39#39');'
          
            '  formConsEval.setString('#39'oid_cco'#39',IntToStr(TEvaluaciones.FieldN' +
            'ame('#39'oid_evaluacion'#39').AsInteger));'
          '  formConsEval.Mostrar(false);'
          'end;'
          ''
          ''
          
            'procedure ValidarValorClasifEntidadPuesto(OidClasifEnt : integer' +
            ' ;'
          
            '                                                        codigo :' +
            ' string);'
          'begin'
          ''
          '  if (codigo = '#39#39')'
          '     then begin'
          '             THistPuestos.EditRecord;'
          
            '             THistPuestos.FieldName('#39'oid_val_clasif_pue'#39').AsInte' +
            'ger := 0;'
          
            '             THistPuestos.FieldName('#39'desc_val_clasif_pue'#39').AsStr' +
            'ing := '#39#39';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifEntidad'#39');'
          
            '  operacion.addAtribute('#39'oid_clasif_ent'#39',IntToStr(OidClasifEnt))' +
            ';'
          '  operacion.addAtribute('#39'codigo'#39',codigo);'
          '  operacion.execute;'
          ''
          '  THistPuestos.EditRecord;'
          '  THistPuestos.FieldName('#39'oid_val_clasif_pue'#39').AsInteger :='
          
            '       TValorClaifEntidad.FieldName('#39'oid_valor_clasif_ent'#39').AsIn' +
            'teger;'
          '  THistPuestos.FieldName('#39'desc_val_clasif_pue'#39').AsString :='
          '      TValorClaifEntidad.FieldName('#39'descripcion'#39').AsString;'
          ''
          'end;'
          ''
          
            'procedure ValidarValorClasifEntidadEmpHistPue(OidClasifEnt : int' +
            'eger ;'
          
            '                                                                ' +
            '           codigo : string);'
          'begin'
          ''
          '  if (codigo = '#39#39')'
          '     then begin'
          '             THistPuestos.EditRecord;'
          
            '             THistPuestos.FieldName('#39'oid_val_clasif_emp'#39').AsInte' +
            'ger := 0;'
          
            '             THistPuestos.FieldName('#39'desc_val_clasif_emp'#39').AsStr' +
            'ing := '#39#39';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifEntidad'#39');'
          
            '  operacion.addAtribute('#39'oid_clasif_ent'#39',IntToStr(OidClasifEnt))' +
            ';'
          '  operacion.addAtribute('#39'codigo'#39',codigo);'
          '  operacion.execute;'
          ''
          '  THistPuestos.EditRecord;'
          '  THistPuestos.FieldName('#39'oid_val_clasif_emp'#39').AsInteger :='
          
            '       TValorClaifEntidad.FieldName('#39'oid_valor_clasif_ent'#39').AsIn' +
            'teger;'
          '  THistPuestos.FieldName('#39'desc_val_clasif_emp'#39').AsString :='
          '      TValorClaifEntidad.FieldName('#39'descripcion'#39').AsString;'
          ''
          'end;'
          ''
          
            'procedure ValidarValorClasifEntidadSecHistPue(OidClasifEnt : int' +
            'eger ;'
          
            '                                                                ' +
            '           codigo : string);'
          'begin'
          ''
          '  if (codigo = '#39#39')'
          '     then begin'
          '             THistPuestos.EditRecord;'
          
            '             THistPuestos.FieldName('#39'oid_val_clasif_sec'#39').AsInte' +
            'ger := 0;'
          
            '             THistPuestos.FieldName('#39'desc_val_clasif_sec'#39').AsStr' +
            'ing := '#39#39';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifEntidad'#39');'
          
            '  operacion.addAtribute('#39'oid_clasif_ent'#39',IntToStr(OidClasifEnt))' +
            ';'
          '  operacion.addAtribute('#39'codigo'#39',codigo);'
          '  operacion.execute;'
          ''
          '  THistPuestos.EditRecord;'
          '  THistPuestos.FieldName('#39'oid_val_clasif_sec'#39').AsInteger :='
          
            '       TValorClaifEntidad.FieldName('#39'oid_valor_clasif_ent'#39').AsIn' +
            'teger;'
          '  THistPuestos.FieldName('#39'desc_val_clasif_sec'#39').AsString :='
          '      TValorClaifEntidad.FieldName('#39'descripcion'#39').AsString;'
          ''
          'end;'
          ''
          ''
          ''
          'procedure setSeguridadCampos();'
          'begin'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20001,'#39#39',false))'
          '   then begin'
          '        end  '
          '   else begin'
          '        dxDBGridSN4.setInserting(false);'
          '        dxDBGridSN4.setAppending(false);'
          #9'dxDBGridSN4.setEditing(false);'
          '        end;'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20003,'#39#39',false))'
          '   then begin'
          '        end'
          '   else begin'
          '        dxDBGridSN1.setInserting(false);'
          '        dxDBGridSN1.setAppending(false);'
          #9'dxDBGridSN1.setEditing(false);        '
          '        end;'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20005,'#39#39',false))'
          '   then begin'
          '        end'
          '   else begin'
          '        snDBEdit2.setReadOnly(true);'
          '        snDBCheckEdit4.setEnable(false);'
          #9'snDBCheckEdit3.setEnable(false);'
          #9'snDBCheckEdit5.setEnable(false);'
          '        srnDBButtonEdit1.setReadOnly(true);'
          '        srnDBButtonEdit2.setReadOnly(true);'
          '        srnDBButtonEdit3.setReadOnly(true);'
          '        srnDBButtonEdit4.setReadOnly(true);'
          '        snDBCheckEdit1.setEnable(false);'
          '        snDBCheckEdit2.setEnable(false);'
          '        snDBEdit7.setReadOnly(true);'
          '        dxDBGridSN5.setInserting(false);'
          '        dxDBGridSN5.setAppending(false);'
          #9'dxDBGridSN5.setEditing(false);        '
          '        dxDBGridSN2.setInserting(false);'
          '        dxDBGridSN2.setAppending(false);'
          #9'dxDBGridSN2.setEditing(false);        '
          '        dxDBGridSN3.setInserting(false);'
          '        dxDBGridSN3.setAppending(false);'
          #9'dxDBGridSN3.setEditing(false);        '
          '        end;'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20007,'#39#39',false))'
          '   then begin'
          '        end '
          '   else begin'
          '        snDBEdit8.setReadOnly(true);'
          '        snDBLookup2.setReadOnly(true);'
          '        snDBEdit9.setReadOnly(true);'
          '        snDBLookup3.setReadOnly(true);'
          '        snDBDateEdit4.setEnable(false);'
          '        snDBLookup4.setReadOnly(true);'
          '        snDBEdit10.setReadOnly(true);'
          '        snDBEdit11.setReadOnly(true);'
          '        snDBEdit12.setReadOnly(true);'
          '        end;'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20009,'#39#39',false))'
          '   then begin'
          '        end'
          '   else begin'
          '        snDBDateEdit5.setEnable(false);'
          '        snDBLookup5.setReadOnly(true);'
          '        snDBLookup6.setReadOnly(true);'
          '        snDBDateEdit6.setEnable(false);'
          '        snDBDateEdit7.setEnable(false);'
          '        srnDBButtonEdit5.setReadOnly(true);'
          '        dxDBGridSN6.setInserting(false);'
          '        dxDBGridSN6.setAppending(false);'
          '        dxDBGridSN6.setEditing(false);'
          '        end;'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20025,'#39#39',false))'
          '   then begin'
          '        end'
          '   else begin'
          '        dxDBGridSN25.setInserting(false);'
          '        dxDBGridSN25.setAppending(false);'
          '        dxDBGridSN25.setEditing(false);'
          '        end;'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20011,'#39#39',false))'
          '   then begin'
          '        end'
          '   else begin'
          '        dxDBGridSN7.setInserting(false);'
          '        dxDBGridSN7.setAppending(false);'
          #9'dxDBGridSN7.setEditing(false);        '
          '        end;'
          ''
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20018,'#39#39',false))'
          '   then begin'
          '           end'
          '   else begin   '
          '          dxDBGridSN13.setInserting(false);'
          '          dxDBGridSN13.setAppending(false);'
          '          dxDBGridSN13.setEditing(false);        '
          ''
          '          dxDBGridSN14.setInserting(false);'
          '          dxDBGridSN14.setAppending(false);'
          '          dxDBGridSN14.setEditing(false);        '
          ''
          '          dxDBGridSN28.setInserting(false);'
          '          dxDBGridSN28.setAppending(false);'
          '          dxDBGridSN28.setEditing(false);        '
          ''
          '          dxDBGridSN21.setInserting(false);'
          '          dxDBGridSN21.setAppending(false);'
          '          dxDBGridSN21.setEditing(false);        '
          ''
          '          dxDBGridSN22.setInserting(false);'
          '          dxDBGridSN22.setAppending(false);'
          '          dxDBGridSN22.setEditing(false);        '
          ''
          '          dxDBGridSN23.setInserting(false);'
          '          dxDBGridSN23.setAppending(false);'
          '          dxDBGridSN23.setEditing(false);        '
          ''
          '          dxDBGridSN24.setInserting(false);'
          '          dxDBGridSN24.setAppending(false);'
          '          dxDBGridSN24.setEditing(false);        '
          ''
          '          dxDBGridSN27.setInserting(false);'
          '          dxDBGridSN27.setAppending(false);'
          '          dxDBGridSN27.setEditing(false);        '
          ''
          '          dxDBGridSN15.setInserting(false);'
          '          dxDBGridSN15.setAppending(false);'
          '          dxDBGridSN15.setEditing(false);        '
          ''
          '          dxDBGridSN16.setInserting(false);'
          '          dxDBGridSN16.setAppending(false);'
          '          dxDBGridSN16.setEditing(false);        '
          ''
          '          dxDBGridSN17.setInserting(false);'
          '          dxDBGridSN17.setAppending(false);'
          '          dxDBGridSN17.setEditing(false);        '
          ''
          '          dxDBGridSN18.setInserting(false);'
          '          dxDBGridSN18.setAppending(false);'
          '          dxDBGridSN18.setEditing(false);        '
          ''
          '          dxDBGridSN31.setInserting(false);'
          '          dxDBGridSN31.setAppending(false);'
          '          dxDBGridSN31.setEditing(false);        '
          ''
          '          end;'
          ''
          ''
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20013,'#39#39',false))'
          '   then begin'
          '        end'
          '   else begin'
          '        dxDBGridSN8.setInserting(false);'
          '        dxDBGridSN8.setAppending(false);'
          #9'dxDBGridSN8.setEditing(false);        '
          ''
          '        dxDBGridSN9.setInserting(false);'
          '        dxDBGridSN9.setAppending(false);'
          #9'dxDBGridSN9.setEditing(false);        '
          ''
          '        dxDBGridSN10.setInserting(false);'
          '        dxDBGridSN10.setAppending(false);'
          #9'dxDBGridSN10.setEditing(false);        '
          ''
          '        dxDBGridSN11.setInserting(false);'
          '        dxDBGridSN11.setAppending(false);'
          #9'dxDBGridSN11.setEditing(false);        '
          '        '
          '      '
          '        end;'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20015,'#39#39',false))'
          '   then begin'
          '        end '
          '   else begin'
          ''
          '        dxDBGridSN12.setInserting(false);'
          '        dxDBGridSN12.setAppending(false);'
          #9'dxDBGridSN12.setEditing(false);        '
          ''
          '        end;'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20016,'#39#39',false))'
          '   then begin'
          '        end '
          '   else begin'
          '          DBECodigo.setReadOnly(true);'
          '          DBEDescripcion.setReadOnly(true);'
          '          snDBEdit1.setReadOnly(true);'
          '          snDBDateEdit1.setEnable(false);'
          '          snDBDateEdit2.setEnable(false);'
          '        end;'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20020,'#39#39',false))'
          '   then begin'
          '        end '
          '   else begin'
          ''
          '        srnDBButtonEdit6.setReadOnly(true);'
          '        dxDBGridSN20.setInserting(false);'
          '        dxDBGridSN20.setAppending(false);'
          '        dxDBGridSN20.setEditing(false);        '
          ''
          '        end;'
          ''
          'if (Varios.isFuncionSeguridadHabilitada(20023,'#39#39',false))'
          '   then begin'
          '        end '
          '   else begin'
          ''
          '        dxDBGridSN19.setInserting(false);'
          '        dxDBGridSN19.setAppending(false);'
          '        dxDBGridSN19.setEditing(false);        '
          ''
          '        end;'
          ''
          ''
          ''
          'end;'
          ''
          'procedure MostrarHelpValoresClasifPuesto();'
          'begin   '
          
            '   HelpValoresClasificadorPuesto1.NickName           :=  '#39'su.Leg' +
            'ajo'#39';'
          
            '   HelpValoresClasificadorPuesto1.NroClasificador    :=  TLeyend' +
            'asReporte.FieldName('#39'nro_clasif_puesto'#39').AsInteger;'
          '   HelpValoresClasificadorPuesto1.Mostrar();'
          'end;'
          ''
          ''
          'procedure ValidarValorClasifEntidadPuesto1(codigo : string);'
          'begin'
          ''
          ' '
          ''
          '  if (codigo = '#39#39')'
          '     then begin'
          '             TCategPosibleLeg.EditRecord;'
          
            '             TCategPosibleLeg.FieldName('#39'oid_categ_posible'#39').AsI' +
            'nteger := 0;'
          
            '             TCategPosibleLeg.FieldName('#39'desc_categ_posible'#39').As' +
            'String := '#39#39';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifEntidad'#39');'
          
            '  operacion.addAtribute('#39'oid_clasif_ent'#39',TLeyendasReporte.FieldN' +
            'ame('#39'oid_clasif_puesto'#39').AsString);'
          '  operacion.addAtribute('#39'codigo'#39',codigo);'
          '  operacion.execute;'
          ''
          '  TCategPosibleLeg.EditRecord;'
          '  TCategPosibleLeg.FieldName('#39'oid_categ_posible'#39').AsInteger :='
          
            '       TValorClaifEntidad.FieldName('#39'oid_valor_clasif_ent'#39').AsIn' +
            'teger;'
          '  TCategPosibleLeg.FieldName('#39'desc_categ_posible'#39').AsString :='
          '      TValorClaifEntidad.FieldName('#39'descripcion'#39').AsString;'
          ''
          'end;'
          ''
          'procedure TraerResulProb();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerResulProbJuicio'#39');'
          ' operacion.execute();'
          'end;'
          ''
          'procedure cargarTipoInteres();'
          'begin'
          ''
          '  TTipoInteres.close;'
          '  TTipoInteres.open;'
          ''
          '  TTipoInteres.appendRecord;'
          '  TTipoInteres.FieldName('#39'codigo'#39').AsString := '#39'ANUAL'#39';'
          '  TTipoInteres.FieldName('#39'descripcion'#39').AsString := '#39'Anual'#39';'
          '  TTipoInteres.postRecord;'
          ''
          '  TTipoInteres.appendRecord;'
          '  TTipoInteres.FieldName('#39'codigo'#39').AsString := '#39'MENSUAL'#39';'
          '  TTipoInteres.FieldName('#39'descripcion'#39').AsString := '#39'Mensual'#39';'
          '  TTipoInteres.postRecord;'
          ''
          'end;'
          ''
          'procedure cargarDSCalcIntParaEnviar();'
          'begin'
          'TEnviarTCalcInteres.close;'
          'TEnviarTCalcInteres.Open;'
          'TCalcInteres.First;'
          'while (not TCalcInteres.eof) do'
          '  begin'
          ''
          '  TEnviarTCalcInteres.AppendRecord;'
          '  TEnviarTCalcInteres.FieldName('#39'oid_calc_int'#39').Value :='
          '     TCalcInteres.FieldName('#39'oid_calc_int'#39').Value;'
          '  TEnviarTCalcInteres.FieldName('#39'oid_juicio'#39').Value :='
          '     TCalcInteres.FieldName('#39'oid_juicio'#39').Value;'
          '  TEnviarTCalcInteres.FieldName('#39'fec_desde'#39').Value :='
          '     TCalcInteres.FieldName('#39'fec_desde'#39').Value;'
          '  TEnviarTCalcInteres.FieldName('#39'fec_hasta'#39').Value :='
          '     TCalcInteres.FieldName('#39'fec_hasta'#39').Value;'
          '  TEnviarTCalcInteres.FieldName('#39'tipo_tasa'#39').Value :='
          '     TCalcInteres.FieldName('#39'tipo_tasa'#39').Value;'
          '  TEnviarTCalcInteres.FieldName('#39'porc'#39').Value :='
          '     TCalcInteres.FieldName('#39'porc'#39').Value;'
          '  TEnviarTCalcInteres.FieldName('#39'interes'#39').Value :='
          '     TCalcInteres.FieldName('#39'interes'#39').Value;'
          '  TEnviarTCalcInteres.FieldName('#39'activo'#39').Value :='
          '     TCalcInteres.FieldName('#39'activo'#39').Value;'
          '  TEnviarTCalcInteres.PostRecord;'
          ''
          '  TCalcInteres.next;'
          '  end;'
          'end; '
          ''
          ''
          'procedure calculadorDeInteresJuicios();'
          'begin'
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'TraerCalcIntJuicio'#39');'
          
            '   operacion.addAtribute('#39'capital'#39', TJuicio.FieldName('#39'monto_acu' +
            'erdo'#39').AsString);'
          '   operacion.addDataSet(TEnviarTCalcInteres.getDataSet()); '
          '   operacion.execute();'
          'end;'
          ''
          ''
          'procedure AsignarInteresJuicio();'
          'begin'
          'TRespCalcInt.First;'
          'while (not TRespCalcInt.eof) do'
          '  begin'
          '  TCalcInteres.First;'
          
            '  if (TCalcInteres.locate('#39'oid_calc_int'#39',TRespCalcInt.FieldName(' +
            #39'oid_calc_int'#39').AsInteger,[]))'
          '      then begin'
          '             TCalcInteres.EditRecord;'
          '             TCalcInteres.FieldName('#39'interes'#39').Value :='
          '                TRespCalcInt.FieldName('#39'interes'#39').Value;'
          '             TCalcInteres.PostRecord; '
          '            end;'#9
          '  TRespCalcInt.next;'
          '  end;'
          'end;'
          ''
          'procedure getTotalInteresAsigAJuicio() ;'
          'var '
          '  total : currency;'
          'begin'
          ''
          '  TCalcInteres.postRecord;  '
          ''
          '  if (TCalcInteres.isEmpty())'
          '      then begin'
          '                TJuicio.EditRecord;'
          '                TJuicio.FieldName('#39'monto_acuerdo'#39').Value := 0;'
          '                exit; '
          '                end;'
          ' '
          ''
          '  total := 0;'
          '  TCalcInteres.First;'
          '  while (not TCalcInteres.Eof()) do'
          '    begin'
          '    total := total + TCalcInteres.FieldName('#39'interes'#39').Value; '
          '    TCalcInteres.next;'
          '  end;'#9
          '  '
          '  TJuicio.EditRecord;'
          '  TJuicio.FieldName('#39'monto_interes'#39').Value := total;'
          ''
          'end;')
      end>
    OnBeforeNuevo = <
      item
        Source.Strings = (
          'begin'
          '  '
          'end.')
      end>
    OnAfterNuevo = <
      item
        Source.Strings = (
          'begin'
          '  inicializarValoresClasif();'
          '  ImagenLegajo.BorrarImagen();'
          '  AltaMotivosEntInter();'
          '  InicializarAltaAccesosInternos();'
          '  setSeguridadCampos();'
          'end.')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonCalcInteres'
        Source.Strings = (
          'begin'
          ''
          '  if (driverABM.isNuevo() or driverABM.isModificar())'
          '     then begin'
          ' '
          
            '             if (mensaje.question('#39'Desea recalcular el inter'#233's?'#39 +
            ')=false) then exit;'
          ''
          '             cargarDSCalcIntParaEnviar();'
          '             calculadorDeInteresJuicios();'
          '             AsignarInteresJuicio();'
          '             getTotalInteresAsigAJuicio();'
          ''
          '             end;'
          ''
          'end.')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'cxGridDBCodValClasif'
        Source.Strings = (
          'begin'
          '  MostrarHelpValoresClasificador();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBTableView5cod_rota'
        Source.Strings = (
          'begin'
          '   HelpRotas.mostrar();'
          'end.')
      end
      item
        ColumnName = 'dxDBGridSN6DBTableView1Column1'
        Source.Strings = (
          'begin'
          '    MostrarHelpPuestos();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBTableView17cod_val_clasif_emp'
        Source.Strings = (
          'begin'
          '  MostrarHelpEmpresas();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBTableView18Column1'
        Source.Strings = (
          'begin'
          ''
          '  TTempMotNov.Close; '
          '  TTempMotNov.Open;'
          ''
          '  TMotivosNov.First;'
          '  while (not TMotivosNov.EOF) do'
          '     begin'
          ''
          '     TTempMotNov.AppendRecord; '
          
            '     TTempMotNov.FieldName('#39'oid'#39').AsInteger := TMotivosNov.Field' +
            'Name('#39'oid'#39').AsInteger;'
          
            '     TTempMotNov.FieldName('#39'codigo'#39').AsString := TMotivosNov.Fie' +
            'ldName('#39'codigo'#39').AsString; '
          
            '     TTempMotNov.FieldName('#39'descripcion'#39').AsString := TMotivosNo' +
            'v.FieldName('#39'descripcion'#39').AsString;'
          '     TTempMotNov.FieldName('#39'activo'#39').AsBoolean :=  true;'
          '     TTempMotNov.PostRecord;'
          ''
          '     TMotivosNov.next;'
          '     end;'
          ''
          '  HelpMotivosNov.getTableHelp().LoadDataSet(TTempMotNov);'
          '  HelpMotivosNov.mostrar();'
          ''
          'end.')
      end
      item
        ColumnName = 'cxGridDBTableView19cod_categ_posible'
        Source.Strings = (
          'begin'
          '  MostrarHelpValoresClasifPuesto();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBTableView20oid_juzgado'
        Source.Strings = (
          'begin'
          '  HelpJuzgados.Mostrar();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBTableView20oid_abogado'
        Source.Strings = (
          'begin'
          '  HelpAbogados.Mostrar();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBColumn25'
        Source.Strings = (
          'begin'
          '  HelpEmpresasJuicio.Mostrar();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBTableView20Column4'
        Source.Strings = (
          'begin'
          '  HelpJuzgados.Mostrar();'
          'end.')
      end
      item
        ColumnName = 'dxDBGridSN6DBTableView1Column3'
        Source.Strings = (
          'begin'
          '  MostrarHelpEmpresasHistPue();'
          'end.')
      end
      item
        ColumnName = 'dxDBGridSN6DBTableView1Column5'
        Source.Strings = (
          'begin'
          '  MostrarHelpSectoresHistPue();'
          'end.')
      end>
    Left = 344
    Top = 115
  end
  inherited SaveArchivo: TSaveDialog
    Left = 384
    Top = 192
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 608
    Top = 336
  end
  inherited ImageListGruposPopUp: TImageList
    Left = 32
    Top = 147
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 112
    Top = 147
  end
  inherited TPathHelp: TsnTable
    Left = 528
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 640
    Top = 83
  end
  object HelpLegajos: TsnHelp
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
    Titulo = 'Legajos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorLegajo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Legajo Existente'
    NroQuery = 0
    Cache = False
    Left = 152
    Top = 147
  end
  object TValoresClasificadores: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_valor_clasif'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'oid_clasif_ent'
        DataType = ftInteger
      end
      item
        Name = 'oid_val_clasif_ent'
        DataType = ftInteger
      end
      item
        Name = 'nro_clasif'
        DataType = ftInteger
      end
      item
        Name = 'desc_grupo_clasif'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'cod_valor'
        DataType = ftString
        Size = 30
      end
      item
        Name = 'desc_valor'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'nickname'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'desc_clasificador'
        DataType = ftString
        Size = 100
      end>
    IndexFieldNames = 'oid_legajo'
    IndexDefs = <
      item
        Name = 'TValoresClasificadoresIndex1'
        Fields = 'oid_legajo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_legajo'
    MasterSource = DSLegajos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 302
    Top = 300
    object TValoresClasificadoresoid_valor_clasif: TIntegerField
      FieldName = 'oid_valor_clasif'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TValoresClasificadoresoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TValoresClasificadoresoid_clasif_ent: TIntegerField
      FieldName = 'oid_clasif_ent'
    end
    object TValoresClasificadoresoid_val_clasif_ent: TIntegerField
      FieldName = 'oid_val_clasif_ent'
    end
    object TValoresClasificadoresnro_clasif: TIntegerField
      FieldName = 'nro_clasif'
    end
    object TValoresClasificadoresdesc_grupo_clasif: TStringField
      FieldName = 'desc_grupo_clasif'
      Size = 100
    end
    object TValoresClasificadorescod_valor: TStringField
      FieldName = 'cod_valor'
      Size = 30
    end
    object TValoresClasificadoresdesc_valor: TStringField
      FieldName = 'desc_valor'
      Size = 100
    end
    object TValoresClasificadoresnickname: TStringField
      FieldName = 'nickname'
      Size = 50
    end
    object TValoresClasificadoresactivo: TBooleanField
      FieldName = 'activo'
    end
    object TValoresClasificadoresdesc_clasificador: TStringField
      FieldName = 'desc_clasificador'
      Size = 100
    end
  end
  object DSValoresClasificadores: TDataSource
    DataSet = TValoresClasificadores
    Left = 334
    Top = 300
  end
  object HelpValoresClasificador: THelpValoresClasificador
    AsignarCampoCodigo = TValoresClasificadorescod_valor
    NroClasificador = 0
    Left = 72
    Top = 145
  end
  object TClasificadorEntidad: TsnTable
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
    Left = 565
    Top = 336
    object TClasificadorEntidadoid_clasif_ent: TIntegerField
      FieldName = 'oid_clasif_ent'
    end
    object TClasificadorEntidadcodigo: TStringField
      FieldName = 'codigo'
    end
    object TClasificadorEntidaddescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
    object TClasificadorEntidadnickname: TStringField
      FieldName = 'nickname'
      Size = 30
    end
    object TClasificadorEntidadobligatorio: TBooleanField
      FieldName = 'obligatorio'
    end
    object TClasificadorEntidadactivo: TBooleanField
      FieldName = 'activo'
    end
    object TClasificadorEntidadnro_clasif: TIntegerField
      FieldName = 'nro_clasif'
    end
    object TClasificadorEntidadoid_grupo_clasif: TIntegerField
      FieldName = 'oid_grupo_clasif'
    end
    object TClasificadorEntidadcod_grupo_clasif: TStringField
      FieldName = 'cod_grupo_clasif'
      Size = 50
    end
    object TClasificadorEntidaddesc_grupo_clasif: TStringField
      FieldName = 'desc_grupo_clasif'
      Size = 100
    end
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
    Left = 462
    Top = 284
    object TValorClaifEntidadoid_valor_clasif_ent: TIntegerField
      FieldName = 'oid_valor_clasif_ent'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TValorClaifEntidadcodigo: TStringField
      FieldName = 'codigo'
      Size = 30
    end
    object TValorClaifEntidaddescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
    object TValorClaifEntidadoid_clasif_entidad: TIntegerField
      FieldName = 'oid_clasif_entidad'
    end
  end
  object TTarjetaLegajo: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_tar_leg'
        DataType = ftInteger
      end
      item
        Name = 'tipo_tarjeta'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'nro_tarjeta'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_legajo'
    IndexDefs = <
      item
        Name = 'TTarjetaLegajoIndex1'
        Fields = 'oid_legajo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_legajo'
    MasterSource = DSLegajos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 496
    Top = 140
    object TTarjetaLegajooid_tar_leg: TIntegerField
      FieldName = 'oid_tar_leg'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TTarjetaLegajotipo_tarjeta: TStringField
      FieldName = 'tipo_tarjeta'
      Size = 10
    end
    object TTarjetaLegajonro_tarjeta: TStringField
      FieldName = 'nro_tarjeta'
      Size = 50
    end
    object TTarjetaLegajooid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TTarjetaLegajoactivo: TBooleanField
      FieldName = 'activo'
    end
    object TTarjetaLegajoorden: TIntegerField
      FieldName = 'orden'
    end
  end
  object DSTarjetaLegajo: TDataSource
    DataSet = TTarjetaLegajo
    Left = 528
    Top = 140
  end
  object TTiposTarjetas: TsnTable
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
    Top = 199
    object TTiposTarjetascodigo: TStringField
      FieldName = 'codigo'
      Size = 10
    end
    object TTiposTarjetasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
  end
  object DSTiposTarjetas: TDataSource
    DataSet = TTiposTarjetas
    Left = 200
    Top = 199
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
        AsignarACampo = TLegajoscod_grupo_puerta_ingreso
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
    Left = 458
    Top = 335
  end
  object ValidadorGrupoPuertas: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Grupo de Puerta Inexistente'
    CampoOID = TLegajosoid_grupo_puerta_ingreso
    CampoDescripcion = TLegajosdesc_grupo_puerta_ingreso
    NroQuery = 0
    Cache = True
    Left = 494
    Top = 335
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
        AsignarACampo = TLegajoscod_grupo_puerta_egreso
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
    Left = 458
    Top = 372
  end
  object ValidadorGrupoPuertas1: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Grupo de Puerta Inexistente'
    CampoOID = TLegajosoid_grupo_puerta_egreso
    CampoDescripcion = TLegajosdesc_grupo_puerta_egreso
    NroQuery = 0
    Cache = True
    Left = 494
    Top = 372
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
        AsignarACampo = TLegajoscod_estado
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
    Titulo = 'Estados'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 458
    Top = 407
  end
  object ValidadorEstados: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.EstadoCIP'
    MensajeException = 'C'#243'digo de Estado Inexistente'
    CampoOID = TLegajosoid_estado
    CampoDescripcion = TLegajosdesc_estado
    NroQuery = 0
    Cache = True
    Left = 494
    Top = 407
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
        AsignarACampo = TLegajoscod_perm_semenal
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
    Left = 458
    Top = 443
  end
  object ValidadorPlanificacionSemanal: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.PermisoSemanalCIP'
    MensajeException = 'C'#243'digo de Planificaci'#243'n Inexistente'
    CampoOID = TLegajosoid_perm_semenal
    CampoDescripcion = TLegajosdesc_perm_semenal
    NroQuery = 0
    Cache = True
    Left = 494
    Top = 443
  end
  object TSentidos: TsnTable
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
    Left = 736
    Top = 330
    object TSentidossentido: TStringField
      FieldName = 'sentido'
      Size = 1
    end
    object TSentidosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSSentidos: TDataSource
    DataSet = TSentidos
    Left = 768
    Top = 330
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
        Name = 'oid_legajo'
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
    IndexFieldNames = 'oid_legajo'
    IndexDefs = <
      item
        Name = 'TMotAccesosIntermediosIndex1'
        Fields = 'oid_legajo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_legajo'
    MasterSource = DSLegajos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 198
    Top = 474
    object TMotAccesosIntermediossecu: TIntegerField
      FieldName = 'secu'
    end
    object TMotAccesosIntermediosoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
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
    Left = 230
    Top = 474
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
    Left = 328
    Top = 343
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
    Left = 358
    Top = 344
  end
  object TCatAccInternos: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'OID_CAT_ACC_LEG'
        DataType = ftInteger
      end
      item
        Name = 'OID_CATEG_ACCESO'
        DataType = ftInteger
      end
      item
        Name = 'DESC_CATEG_ACCESO'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'OID_LEGAJO'
        DataType = ftInteger
      end
      item
        Name = 'ACTIVO'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'OID_LEGAJO'
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterSource = DSLegajos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 568
    Top = 140
    object TCatAccInternosOID_CAT_ACC_LEG: TIntegerField
      FieldName = 'OID_CAT_ACC_LEG'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCatAccInternosOID_CATEG_ACCESO: TIntegerField
      FieldName = 'OID_CATEG_ACCESO'
    end
    object TCatAccInternosDESC_CATEG_ACCESO: TStringField
      FieldName = 'DESC_CATEG_ACCESO'
      Size = 100
    end
    object TCatAccInternosOID_LEGAJO: TIntegerField
      FieldName = 'OID_LEGAJO'
    end
    object TCatAccInternosACTIVO: TBooleanField
      FieldName = 'ACTIVO'
    end
  end
  object DSCatAccInternos: TDataSource
    DataSet = TCatAccInternos
    Left = 600
    Top = 140
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
    Left = 64
    Top = 500
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
    Left = 94
    Top = 501
  end
  object TFechaRota: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_fecha_rota'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
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
      end>
    IndexFieldNames = 'oid_legajo'
    IndexDefs = <
      item
        Name = 'TFechaRotaIndex1'
        Fields = 'oid_legajo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_legajo'
    MasterSource = DSLegajos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 638
    Top = 138
    object TFechaRotaoid_fecha_rota: TIntegerField
      FieldName = 'oid_fecha_rota'
    end
    object TFechaRotaoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
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
  end
  object DSFechaRota: TDataSource
    DataSet = TFechaRota
    Left = 672
    Top = 140
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
    Left = 206
    Top = 570
  end
  object ValidadorRota: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.Rota'
    MensajeException = 'C'#243'digo de Rota Inexistente'
    CampoOID = TFechaRotaoid_rota
    CampoDescripcion = TFechaRotadesc_rota
    NroQuery = 0
    Cache = True
    Left = 242
    Top = 570
  end
  object TOcultarSolapasLegajo: TsnTable
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
    Left = 297
    Top = 364
    object TOcultarSolapasLegajoocultar_solapa_tarjetas: TBooleanField
      FieldName = 'ocultar_solapa_tarjetas'
    end
    object TOcultarSolapasLegajoocultar_solapa_con_acc: TBooleanField
      FieldName = 'ocultar_solapa_con_acc'
    end
    object TOcultarSolapasLegajoocultar_solapa_personal: TBooleanField
      FieldName = 'ocultar_solapa_personal'
    end
    object TOcultarSolapasLegajoocultar_solapa_empresa: TBooleanField
      FieldName = 'ocultar_solapa_empresa'
    end
    object TOcultarSolapasLegajoocultar_solapa_sanciones: TBooleanField
      FieldName = 'ocultar_solapa_sanciones'
    end
    object TOcultarSolapasLegajoocultar_solapa_servmed: TBooleanField
      FieldName = 'ocultar_solapa_servmed'
    end
    object TOcultarSolapasLegajoocultar_solapa_eval: TBooleanField
      FieldName = 'ocultar_solapa_eval'
    end
    object TOcultarSolapasLegajoocultar_solapa_legales: TBooleanField
      FieldName = 'ocultar_solapa_legales'
    end
    object TOcultarSolapasLegajoocultar_solapa_desarrollo: TBooleanField
      FieldName = 'ocultar_solapa_desarrollo'
    end
    object TOcultarSolapasLegajoocultar_solapa_observaciones: TBooleanField
      FieldName = 'ocultar_solapa_observaciones'
    end
  end
  object TSexo: TsnTable
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
    Left = 225
    Top = 332
    object TSexocodigo: TStringField
      FieldName = 'codigo'
      Size = 1
    end
    object TSexodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
  end
  object DSSexo: TDataSource
    DataSet = TSexo
    Left = 257
    Top = 332
  end
  object TEstadoCivil: TsnTable
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
    Left = 64
    Top = 550
    object IntegerField3: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField5: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField6: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpEstadoCivil: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 've.EstadoCivil'
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
    Titulo = 'Estado Civil'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 94
    Top = 551
  end
  object DSEstadoCivil: TDataSource
    DataSet = TEstadoCivil
    Left = 129
    Top = 548
  end
  object TTipoDocu: TsnTable
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
    Left = 64
    Top = 593
    object IntegerField4: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField7: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField8: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpTipoDocu: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 've.TipoDocumento'
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
    Titulo = 'Tipo de Documento'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 94
    Top = 594
  end
  object DSTipoDocu: TDataSource
    DataSet = TTipoDocu
    Left = 129
    Top = 591
  end
  object TSindicato: TsnTable
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
    Left = 64
    Top = 625
    object IntegerField5: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField9: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField10: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpSindicato: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.ClaseSindicato'
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
    Titulo = 'Sindicatos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 94
    Top = 626
  end
  object DSSindicatos: TDataSource
    DataSet = TSindicato
    Left = 129
    Top = 623
  end
  object TMotivoEgreso: TsnTable
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
    Left = 48
    Top = 324
    object IntegerField6: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField11: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField12: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpMotivoEgreso: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.MotivoEgresoEmp'
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
    Titulo = 'Motivos Egresos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 78
    Top = 325
  end
  object DSMotivoEgresos: TDataSource
    DataSet = TMotivoEgreso
    Left = 113
    Top = 322
  end
  object THistPuestos: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_hist_puesto'
        DataType = ftInteger
      end
      item
        Name = 'oid_val_clasif_pue'
        DataType = ftInteger
      end
      item
        Name = 'desc_val_clasif_pue'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'fec_desde'
        DataType = ftDate
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_legajo'
    IndexDefs = <
      item
        Name = 'THistPuestosIndex1'
        Fields = 'oid_legajo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_legajo'
    MasterSource = DSLegajos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 336
    Top = 268
    object THistPuestosoid_hist_puesto: TIntegerField
      FieldName = 'oid_hist_puesto'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object THistPuestosoid_val_clasif_pue: TIntegerField
      FieldName = 'oid_val_clasif_pue'
    end
    object THistPuestoscod_val_clasif_pue: TStringField
      FieldName = 'cod_val_clasif_pue'
      Size = 50
    end
    object THistPuestosdesc_val_clasif_pue: TStringField
      FieldName = 'desc_val_clasif_pue'
      Size = 100
    end
    object THistPuestosfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object THistPuestosoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object THistPuestosactivo: TBooleanField
      FieldName = 'activo'
    end
    object THistPuestosant_fec_desde: TStringField
      FieldName = 'ant_fec_desde'
      Size = 100
    end
    object THistPuestosoid_val_clasif_emp: TIntegerField
      FieldName = 'oid_val_clasif_emp'
    end
    object THistPuestoscod_val_clasif_emp: TStringField
      FieldName = 'cod_val_clasif_emp'
      Size = 50
    end
    object THistPuestosdesc_val_clasif_emp: TStringField
      FieldName = 'desc_val_clasif_emp'
      Size = 100
    end
    object THistPuestosoid_val_clasif_sec: TIntegerField
      FieldName = 'oid_val_clasif_sec'
    end
    object THistPuestoscod_val_clasif_sec: TStringField
      FieldName = 'cod_val_clasif_sec'
      Size = 50
    end
    object THistPuestosdesc_val_clasif_sec: TStringField
      FieldName = 'desc_val_clasif_sec'
      Size = 100
    end
  end
  object DSHistPuestos: TDataSource
    DataSet = THistPuestos
    Left = 360
    Top = 268
  end
  object THelpGradosLeg: TsnTable
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
    Left = 184
    Top = 517
    object IntegerField7: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField13: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField14: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpGradosLeg: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.GradoLegajo'
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
        AsignarACampo = TLegajoscod_grado_leg
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
    Titulo = 'Grados legajo'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 214
    Top = 518
  end
  object DSGradosLegajo: TDataSource
    DataSet = THelpGradosLeg
    Left = 249
    Top = 515
  end
  object ValidadorGradoLegajo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rh.GradoLegajo'
    MensajeException = 'C'#243'digo de Grado Inexistente'
    CampoOID = TLegajosoid_grado_legajo
    CampoDescripcion = TLegajosdesc_grado_leg
    NroQuery = 0
    Cache = True
    Left = 286
    Top = 516
  end
  object TSancionesLegajo: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_sanc_leg'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'oid_mot_falta'
        DataType = ftInteger
      end
      item
        Name = 'oid_mot_sancion'
        DataType = ftInteger
      end
      item
        Name = 'nro_sancion'
        DataType = ftInteger
      end
      item
        Name = 'fecha'
        DataType = ftDate
      end
      item
        Name = 'fec_susp_desde'
        DataType = ftDate
      end
      item
        Name = 'fec_reintegro'
        DataType = ftDate
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_legajo'
    IndexDefs = <
      item
        Name = 'TSancionesLegajoIndex1'
        Fields = 'oid_legajo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_legajo'
    MasterSource = DSLegajos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 216
    Top = 148
    object TSancionesLegajooid_sanc_leg: TIntegerField
      FieldName = 'oid_sanc_leg'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TSancionesLegajooid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TSancionesLegajooid_mot_falta: TIntegerField
      FieldName = 'oid_mot_falta'
    end
    object TSancionesLegajooid_mot_sancion: TIntegerField
      FieldName = 'oid_mot_sancion'
    end
    object TSancionesLegajonro_sancion: TIntegerField
      FieldName = 'nro_sancion'
    end
    object TSancionesLegajofecha: TDateField
      FieldName = 'fecha'
    end
    object TSancionesLegajofec_susp_desde: TDateField
      FieldName = 'fec_susp_desde'
    end
    object TSancionesLegajofec_reintegro: TDateField
      FieldName = 'fec_reintegro'
    end
    object TSancionesLegajoactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSSancionesLegajo: TDataSource
    DataSet = TSancionesLegajo
    Left = 248
    Top = 148
  end
  object THelpMotivosSanc: TsnTable
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
    Left = 336
    Top = 416
    object IntegerField8: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField15: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField16: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpMotivosSanc: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.SancionesRRHH'
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
    Titulo = 'Sanciones'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 366
    Top = 417
  end
  object DSTHelpMotivosSanc: TDataSource
    DataSet = THelpMotivosSanc
    Left = 399
    Top = 417
  end
  object THelpMotivosFaltas: TsnTable
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
    Left = 336
    Top = 451
    object IntegerField9: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField17: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField18: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpMotivosFaltas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.MotivoFaltaRRHH'
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
    Titulo = 'Motivos Faltas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 366
    Top = 452
  end
  object DSHelpMotivosFaltas: TDataSource
    DataSet = THelpMotivosFaltas
    Left = 399
    Top = 452
  end
  object TPedidosMedicos: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_serv_medico'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'tipo_serv_med'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'nro_nov_sist_ext'
        DataType = ftInteger
      end
      item
        Name = 'fec_inicio'
        DataType = ftDate
      end
      item
        Name = 'fec_final'
        DataType = ftDate
      end
      item
        Name = 'dias'
        DataType = ftInteger
      end
      item
        Name = 'oid_mot_vis_fall'
        DataType = ftInteger
      end
      item
        Name = 'oid_aparato'
        DataType = ftInteger
      end
      item
        Name = 'oid_enfermedad'
        DataType = ftInteger
      end
      item
        Name = 'oid_prest_med'
        DataType = ftInteger
      end
      item
        Name = 'sintoma'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'observacion'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'justifica'
        DataType = ftBoolean
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_legajo'
    IndexDefs = <
      item
        Name = 'TPedidosMedicosIndex1'
        Fields = 'oid_legajo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_legajo'
    MasterSource = DSLegajos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 712
    Top = 140
    object TPedidosMedicosoid_serv_medico: TIntegerField
      FieldName = 'oid_serv_medico'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPedidosMedicosoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TPedidosMedicostipo_serv_med: TStringField
      FieldName = 'tipo_serv_med'
    end
    object TPedidosMedicosnro_nov_sist_ext: TIntegerField
      FieldName = 'nro_nov_sist_ext'
    end
    object TPedidosMedicosfec_inicio: TDateField
      FieldName = 'fec_inicio'
    end
    object TPedidosMedicosfec_final: TDateField
      FieldName = 'fec_final'
    end
    object TPedidosMedicosdias: TIntegerField
      FieldName = 'dias'
    end
    object TPedidosMedicosoid_mot_vis_fall: TIntegerField
      FieldName = 'oid_mot_vis_fall'
    end
    object TPedidosMedicosoid_aparato: TIntegerField
      FieldName = 'oid_aparato'
    end
    object TPedidosMedicosoid_enfermedad: TIntegerField
      FieldName = 'oid_enfermedad'
    end
    object TPedidosMedicosoid_prest_med: TIntegerField
      FieldName = 'oid_prest_med'
    end
    object TPedidosMedicossintoma: TStringField
      FieldName = 'sintoma'
      Size = 4000
    end
    object TPedidosMedicosjustifica: TBooleanField
      FieldName = 'justifica'
    end
    object TPedidosMedicosactivo: TBooleanField
      FieldName = 'activo'
    end
    object TPedidosMedicosfec_control: TDateField
      FieldName = 'fec_control'
    end
    object TPedidosMedicosobservacion: TMemoField
      FieldName = 'observacion'
      BlobType = ftMemo
    end
  end
  object DSPedidosMedicos: TDataSource
    DataSet = TPedidosMedicos
    Left = 744
    Top = 140
  end
  object TAparato: TsnTable
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
    Left = 336
    Top = 490
    object IntegerField10: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField19: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField20: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpAparato: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.AparatoRRHH'
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
    Titulo = 'Aparatos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 366
    Top = 491
  end
  object DSAparatos: TDataSource
    DataSet = TAparato
    Left = 399
    Top = 491
  end
  object TEnfermedad: TsnTable
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
    Left = 336
    Top = 525
    object IntegerField11: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField21: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField22: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpEnfermedad: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.EnfermedadRRHH'
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
    Titulo = 'Enfermedades'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 366
    Top = 526
  end
  object DSEnfermedad: TDataSource
    DataSet = TEnfermedad
    Left = 399
    Top = 526
  end
  object TPrestadorMedico: TsnTable
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
    Left = 336
    Top = 559
    object IntegerField12: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField23: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField24: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpPrestadorMedico: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.PrestMedidoRRHH'
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
    Titulo = 'Prestador M'#233'dicos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 366
    Top = 560
  end
  object DSTPrestadorMedico: TDataSource
    DataSet = TPrestadorMedico
    Left = 399
    Top = 560
  end
  object TMotVisitaFallida: TsnTable
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
    Left = 336
    Top = 595
    object IntegerField13: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField25: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField26: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpMotivoVisFallida: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.MotVisFalRRHH'
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
    Titulo = 'Motivo Visita Fallida'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 366
    Top = 596
  end
  object DSTMotVisitaFallida: TDataSource
    DataSet = TMotVisitaFallida
    Left = 399
    Top = 596
  end
  object TAtencionMedica: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_serv_medico'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'tipo_serv_med'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'nro_nov_sist_ext'
        DataType = ftInteger
      end
      item
        Name = 'fec_inicio'
        DataType = ftDate
      end
      item
        Name = 'fec_final'
        DataType = ftDate
      end
      item
        Name = 'dias'
        DataType = ftInteger
      end
      item
        Name = 'oid_mot_vis_fall'
        DataType = ftInteger
      end
      item
        Name = 'oid_aparato'
        DataType = ftInteger
      end
      item
        Name = 'oid_enfermedad'
        DataType = ftInteger
      end
      item
        Name = 'oid_prest_med'
        DataType = ftInteger
      end
      item
        Name = 'sintoma'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'observacion'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'justifica'
        DataType = ftBoolean
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_legajo'
    IndexDefs = <
      item
        Name = 'TPedidosMedicosIndex1'
        Fields = 'oid_legajo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_legajo'
    MasterSource = DSLegajos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 784
    Top = 140
    object TAtencionMedicaoid_ate_med: TIntegerField
      FieldName = 'oid_ate_med'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField15: TIntegerField
      FieldName = 'oid_legajo'
    end
    object StringField27: TStringField
      FieldName = 'tipo_serv_med'
    end
    object IntegerField16: TIntegerField
      FieldName = 'nro_nov_sist_ext'
    end
    object DateField1: TDateField
      FieldName = 'fec_inicio'
    end
    object DateField2: TDateField
      FieldName = 'fec_final'
    end
    object IntegerField17: TIntegerField
      FieldName = 'dias'
    end
    object IntegerField19: TIntegerField
      FieldName = 'oid_aparato'
    end
    object IntegerField20: TIntegerField
      FieldName = 'oid_enfermedad'
    end
    object StringField28: TStringField
      FieldName = 'sintoma'
      Size = 4000
    end
    object StringField29: TStringField
      FieldName = 'observacion'
      Size = 4000
    end
    object BooleanField2: TBooleanField
      FieldName = 'activo'
    end
    object TAtencionMedicafec_ate_med: TDateField
      FieldName = 'fec_ate_med'
    end
    object TAtencionMedicaoid_medico: TIntegerField
      FieldName = 'oid_medico'
    end
    object TAtencionMedicafec_control: TDateField
      FieldName = 'fec_control'
    end
  end
  object DSTAtencionMedica: TDataSource
    DataSet = TAtencionMedica
    Left = 816
    Top = 140
  end
  object TMedicos: TsnTable
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
    Left = 336
    Top = 630
    object IntegerField14: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField30: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField31: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpMedicos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.MedicoRRHH'
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
    Titulo = 'M'#233'dicos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 366
    Top = 631
  end
  object DSMedicos: TDataSource
    DataSet = TMedicos
    Left = 399
    Top = 631
  end
  object TEnfermedadesFam: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_enf_fam'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'tipo_serv_med'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'nro_nov_sist_ext'
        DataType = ftInteger
      end
      item
        Name = 'fec_inicio'
        DataType = ftDate
      end
      item
        Name = 'fec_final'
        DataType = ftDate
      end
      item
        Name = 'dias'
        DataType = ftInteger
      end
      item
        Name = 'oid_aparato'
        DataType = ftInteger
      end
      item
        Name = 'oid_enfermedad'
        DataType = ftInteger
      end
      item
        Name = 'sintoma'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'observacion'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'fec_ate_med'
        DataType = ftDate
      end
      item
        Name = 'oid_medico'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_legajo'
    IndexDefs = <
      item
        Name = 'TPedidosMedicosIndex1'
        Fields = 'oid_legajo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_legajo'
    MasterSource = DSLegajos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 704
    Top = 179
    object TEnfermedadesFamoid_enf_fam: TIntegerField
      FieldName = 'oid_enf_fam'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField21: TIntegerField
      FieldName = 'oid_legajo'
    end
    object StringField32: TStringField
      FieldName = 'tipo_serv_med'
    end
    object IntegerField22: TIntegerField
      FieldName = 'nro_nov_sist_ext'
    end
    object DateField3: TDateField
      FieldName = 'fec_inicio'
    end
    object DateField4: TDateField
      FieldName = 'fec_final'
    end
    object IntegerField23: TIntegerField
      FieldName = 'dias'
    end
    object IntegerField24: TIntegerField
      FieldName = 'oid_aparato'
    end
    object IntegerField25: TIntegerField
      FieldName = 'oid_enfermedad'
    end
    object TEnfermedadesFamoid_familiar: TIntegerField
      FieldName = 'oid_familiar'
    end
    object StringField33: TStringField
      FieldName = 'sintoma'
      Size = 4000
    end
    object StringField34: TStringField
      FieldName = 'observacion'
      Size = 4000
    end
    object BooleanField1: TBooleanField
      FieldName = 'activo'
    end
    object TEnfermedadesFamjustifica: TBooleanField
      FieldName = 'justifica'
    end
  end
  object DSEnfermedadesFam: TDataSource
    DataSet = TEnfermedadesFam
    Left = 736
    Top = 180
  end
  object TFamiliares: TsnTable
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
    Left = 441
    Top = 630
    object IntegerField18: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField35: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField36: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpFamiliares: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.FamiliarRRHH'
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
    Titulo = 'Familiares'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 471
    Top = 631
  end
  object DSFamiliares: TDataSource
    DataSet = TFamiliares
    Left = 504
    Top = 631
  end
  object TAccidenteLaboral: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_enf_fam'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'tipo_serv_med'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'nro_nov_sist_ext'
        DataType = ftInteger
      end
      item
        Name = 'fec_inicio'
        DataType = ftDate
      end
      item
        Name = 'fec_final'
        DataType = ftDate
      end
      item
        Name = 'dias'
        DataType = ftInteger
      end
      item
        Name = 'oid_aparato'
        DataType = ftInteger
      end
      item
        Name = 'oid_enfermedad'
        DataType = ftInteger
      end
      item
        Name = 'sintoma'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'observacion'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'fec_ate_med'
        DataType = ftDate
      end
      item
        Name = 'oid_medico'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_legajo'
    IndexDefs = <
      item
        Name = 'TPedidosMedicosIndex1'
        Fields = 'oid_legajo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_legajo'
    MasterSource = DSLegajos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 782
    Top = 176
    object TAccidenteLaboraloid_acc_lab: TIntegerField
      FieldName = 'oid_acc_lab'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField27: TIntegerField
      FieldName = 'oid_legajo'
    end
    object StringField37: TStringField
      FieldName = 'tipo_serv_med'
    end
    object IntegerField28: TIntegerField
      FieldName = 'nro_nov_sist_ext'
    end
    object DateField5: TDateField
      FieldName = 'fec_inicio'
    end
    object DateField6: TDateField
      FieldName = 'fec_final'
    end
    object IntegerField29: TIntegerField
      FieldName = 'dias'
    end
    object TAccidenteLaboralfec_accidente: TDateField
      FieldName = 'fec_accidente'
    end
    object TAccidenteLaboraldesc_accidente: TStringField
      FieldName = 'desc_accidente'
      Size = 4000
    end
    object IntegerField30: TIntegerField
      FieldName = 'oid_aparato'
    end
    object IntegerField31: TIntegerField
      FieldName = 'oid_enfermedad'
    end
    object StringField38: TStringField
      FieldName = 'sintoma'
      Size = 4000
    end
    object StringField39: TStringField
      FieldName = 'observacion'
      Size = 4000
    end
    object BooleanField3: TBooleanField
      FieldName = 'activo'
    end
    object TAccidenteLaboralfec_control: TDateField
      FieldName = 'fec_control'
    end
  end
  object DSAccidenteLaboral: TDataSource
    DataSet = TAccidenteLaboral
    Left = 816
    Top = 178
  end
  object TLabelCompetencias: TsnTable
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
    Left = 737
    Top = 380
    object TLabelCompetenciasnro: TIntegerField
      FieldName = 'nro'
    end
    object TLabelCompetenciasdescripcion: TStringField
      FieldName = 'descripcion'
    end
  end
  object TEvaluaciones: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_evaluacion'
        DataType = ftInteger
      end
      item
        Name = 'desc_evaluacion'
        DataType = ftString
        Size = 100
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
        Name = 'fec_evaluacion'
        DataType = ftDate
      end
      item
        Name = 'vigente'
        DataType = ftString
        Size = 2
      end
      item
        Name = 'puntaje'
        DataType = ftCurrency
      end
      item
        Name = 'compe_1'
        DataType = ftCurrency
      end
      item
        Name = 'compe_2'
        DataType = ftCurrency
      end
      item
        Name = 'compe_3'
        DataType = ftCurrency
      end
      item
        Name = 'compe_4'
        DataType = ftCurrency
      end
      item
        Name = 'compe_5'
        DataType = ftCurrency
      end
      item
        Name = 'compe_6'
        DataType = ftCurrency
      end
      item
        Name = 'compe_7'
        DataType = ftCurrency
      end
      item
        Name = 'compe_8'
        DataType = ftCurrency
      end
      item
        Name = 'compe_9'
        DataType = ftCurrency
      end
      item
        Name = 'compe_10'
        DataType = ftCurrency
      end
      item
        Name = 'compe_11'
        DataType = ftCurrency
      end
      item
        Name = 'compe_12'
        DataType = ftCurrency
      end
      item
        Name = 'compe_13'
        DataType = ftCurrency
      end
      item
        Name = 'compe_14'
        DataType = ftCurrency
      end
      item
        Name = 'compe_15'
        DataType = ftCurrency
      end
      item
        Name = 'compe_16'
        DataType = ftCurrency
      end
      item
        Name = 'compe_17'
        DataType = ftCurrency
      end
      item
        Name = 'compe_18'
        DataType = ftCurrency
      end
      item
        Name = 'compe_19'
        DataType = ftCurrency
      end
      item
        Name = 'compe_20'
        DataType = ftCurrency
      end
      item
        Name = 'compe_21'
        DataType = ftCurrency
      end
      item
        Name = 'compe_22'
        DataType = ftCurrency
      end
      item
        Name = 'compe_23'
        DataType = ftCurrency
      end
      item
        Name = 'compe_24'
        DataType = ftCurrency
      end
      item
        Name = 'compe_25'
        DataType = ftCurrency
      end
      item
        Name = 'compe_26'
        DataType = ftCurrency
      end
      item
        Name = 'compe_27'
        DataType = ftCurrency
      end
      item
        Name = 'compe_28'
        DataType = ftCurrency
      end
      item
        Name = 'compe_29'
        DataType = ftCurrency
      end
      item
        Name = 'compe_30'
        DataType = ftCurrency
      end
      item
        Name = 'compe_31'
        DataType = ftCurrency
      end
      item
        Name = 'compe_32'
        DataType = ftCurrency
      end
      item
        Name = 'compe_33'
        DataType = ftCurrency
      end
      item
        Name = 'compe_34'
        DataType = ftCurrency
      end
      item
        Name = 'compe_35'
        DataType = ftCurrency
      end
      item
        Name = 'compe_36'
        DataType = ftCurrency
      end
      item
        Name = 'compe_37'
        DataType = ftCurrency
      end
      item
        Name = 'compe_38'
        DataType = ftCurrency
      end
      item
        Name = 'compe_39'
        DataType = ftCurrency
      end
      item
        Name = 'compe_40'
        DataType = ftCurrency
      end
      item
        Name = 'compe_41'
        DataType = ftCurrency
      end
      item
        Name = 'compe_42'
        DataType = ftCurrency
      end
      item
        Name = 'compe_43'
        DataType = ftCurrency
      end
      item
        Name = 'compe_44'
        DataType = ftCurrency
      end
      item
        Name = 'compe_45'
        DataType = ftCurrency
      end
      item
        Name = 'compe_46'
        DataType = ftCurrency
      end
      item
        Name = 'compe_47'
        DataType = ftCurrency
      end
      item
        Name = 'compe_48'
        DataType = ftCurrency
      end
      item
        Name = 'compe_49'
        DataType = ftCurrency
      end
      item
        Name = 'compe_50'
        DataType = ftCurrency
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_legajo'
    IndexDefs = <
      item
        Name = 'TEvaluacionesIndex1'
        Fields = 'oid_legajo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_legajo'
    MasterSource = DSLegajos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 833
    Top = 396
    object TEvaluacionesoid_evaluacion: TIntegerField
      FieldName = 'oid_evaluacion'
    end
    object TEvaluacionesdesc_evaluacion: TStringField
      FieldName = 'desc_evaluacion'
      Size = 1000
    end
    object TEvaluacionesfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TEvaluacionesfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object TEvaluacionesfec_evaluacion: TDateField
      FieldName = 'fec_evaluacion'
    end
    object TEvaluacionesvigente: TStringField
      FieldName = 'vigente'
      Size = 2
    end
    object TEvaluacionespuntaje: TCurrencyField
      FieldName = 'puntaje'
    end
    object TEvaluacionescompe_1: TCurrencyField
      FieldName = 'compe_1'
    end
    object TEvaluacionescompe_2: TCurrencyField
      FieldName = 'compe_2'
    end
    object TEvaluacionescompe_3: TCurrencyField
      FieldName = 'compe_3'
    end
    object TEvaluacionescompe_4: TCurrencyField
      FieldName = 'compe_4'
    end
    object TEvaluacionescompe_5: TCurrencyField
      FieldName = 'compe_5'
    end
    object TEvaluacionescompe_6: TCurrencyField
      FieldName = 'compe_6'
    end
    object TEvaluacionescompe_7: TCurrencyField
      FieldName = 'compe_7'
    end
    object TEvaluacionescompe_8: TCurrencyField
      FieldName = 'compe_8'
    end
    object TEvaluacionescompe_9: TCurrencyField
      FieldName = 'compe_9'
    end
    object TEvaluacionescompe_10: TCurrencyField
      FieldName = 'compe_10'
    end
    object TEvaluacionescompe_11: TCurrencyField
      FieldName = 'compe_11'
    end
    object TEvaluacionescompe_12: TCurrencyField
      FieldName = 'compe_12'
    end
    object TEvaluacionescompe_13: TCurrencyField
      FieldName = 'compe_13'
    end
    object TEvaluacionescompe_14: TCurrencyField
      FieldName = 'compe_14'
    end
    object TEvaluacionescompe_15: TCurrencyField
      FieldName = 'compe_15'
    end
    object TEvaluacionescompe_16: TCurrencyField
      FieldName = 'compe_16'
    end
    object TEvaluacionescompe_17: TCurrencyField
      FieldName = 'compe_17'
    end
    object TEvaluacionescompe_18: TCurrencyField
      FieldName = 'compe_18'
    end
    object TEvaluacionescompe_19: TCurrencyField
      FieldName = 'compe_19'
    end
    object TEvaluacionescompe_20: TCurrencyField
      FieldName = 'compe_20'
    end
    object TEvaluacionescompe_21: TCurrencyField
      FieldName = 'compe_21'
    end
    object TEvaluacionescompe_22: TCurrencyField
      FieldName = 'compe_22'
    end
    object TEvaluacionescompe_23: TCurrencyField
      FieldName = 'compe_23'
    end
    object TEvaluacionescompe_24: TCurrencyField
      FieldName = 'compe_24'
    end
    object TEvaluacionescompe_25: TCurrencyField
      FieldName = 'compe_25'
    end
    object TEvaluacionescompe_26: TCurrencyField
      FieldName = 'compe_26'
    end
    object TEvaluacionescompe_27: TCurrencyField
      FieldName = 'compe_27'
    end
    object TEvaluacionescompe_28: TCurrencyField
      FieldName = 'compe_28'
    end
    object TEvaluacionescompe_29: TCurrencyField
      FieldName = 'compe_29'
    end
    object TEvaluacionescompe_30: TCurrencyField
      FieldName = 'compe_30'
    end
    object TEvaluacionescompe_31: TCurrencyField
      FieldName = 'compe_31'
    end
    object TEvaluacionescompe_32: TCurrencyField
      FieldName = 'compe_32'
    end
    object TEvaluacionescompe_33: TCurrencyField
      FieldName = 'compe_33'
    end
    object TEvaluacionescompe_34: TCurrencyField
      FieldName = 'compe_34'
    end
    object TEvaluacionescompe_35: TCurrencyField
      FieldName = 'compe_35'
    end
    object TEvaluacionescompe_36: TCurrencyField
      FieldName = 'compe_36'
    end
    object TEvaluacionescompe_37: TCurrencyField
      FieldName = 'compe_37'
    end
    object TEvaluacionescompe_38: TCurrencyField
      FieldName = 'compe_38'
    end
    object TEvaluacionescompe_39: TCurrencyField
      FieldName = 'compe_39'
    end
    object TEvaluacionescompe_40: TCurrencyField
      FieldName = 'compe_40'
    end
    object TEvaluacionescompe_41: TCurrencyField
      FieldName = 'compe_41'
    end
    object TEvaluacionescompe_42: TCurrencyField
      FieldName = 'compe_42'
    end
    object TEvaluacionescompe_43: TCurrencyField
      FieldName = 'compe_43'
    end
    object TEvaluacionescompe_44: TCurrencyField
      FieldName = 'compe_44'
    end
    object TEvaluacionescompe_45: TCurrencyField
      FieldName = 'compe_45'
    end
    object TEvaluacionescompe_46: TCurrencyField
      FieldName = 'compe_46'
    end
    object TEvaluacionescompe_47: TCurrencyField
      FieldName = 'compe_47'
    end
    object TEvaluacionescompe_48: TCurrencyField
      FieldName = 'compe_48'
    end
    object TEvaluacionescompe_49: TCurrencyField
      FieldName = 'compe_49'
    end
    object TEvaluacionescompe_50: TCurrencyField
      FieldName = 'compe_50'
    end
    object TEvaluacionesoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TEvaluacionesempresa: TStringField
      FieldName = 'empresa'
      Size = 100
    end
    object TEvaluacionessector: TStringField
      FieldName = 'sector'
      Size = 100
    end
    object TEvaluacionespuesto: TStringField
      FieldName = 'puesto'
      Size = 100
    end
  end
  object DSEvaluaciones: TDataSource
    DataSet = TEvaluaciones
    Left = 865
    Top = 396
  end
  object formConsEval: TFormulario
    AutoLiberar = True
    Nombre = 'TFCargaEvalLeg'
    TipoForm = tipoFormABM
    CreateAlwaysANewForm = True
    Left = 490
    Top = 284
  end
  object TOtrosDatosLeg: TsnTable
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
    Left = 601
    Top = 396
    object TOtrosDatosLegnro_clasif_puesto: TIntegerField
      FieldName = 'nro_clasif_puesto'
    end
    object TOtrosDatosLegoid_clasif_ent_puesto: TIntegerField
      FieldName = 'oid_clasif_ent_puesto'
    end
    object TOtrosDatosLegnro_clasif_empresa: TIntegerField
      FieldName = 'nro_clasif_empresa'
    end
    object TOtrosDatosLegoid_clasif_ent_empresa: TIntegerField
      FieldName = 'oid_clasif_ent_empresa'
    end
    object TOtrosDatosLegnro_clasif_sector: TIntegerField
      FieldName = 'nro_clasif_sector'
    end
    object TOtrosDatosLegoid_clasif_ent_sector: TIntegerField
      FieldName = 'oid_clasif_ent_sector'
    end
  end
  object HelpValoresClasificadorPuesto: THelpValoresClasificador
    AsignarCampoCodigo = THistPuestoscod_val_clasif_pue
    NroClasificador = 0
    Left = 72
    Top = 184
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 681
    Top = 396
  end
  object TCartasDocRemitidas: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_carta_remitida'
        DataType = ftInteger
      end
      item
        Name = 'nro_orden'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'nro_carta_doc'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'fecha'
        DataType = ftDate
      end
      item
        Name = 'oid_tipo_causa'
        DataType = ftInteger
      end
      item
        Name = 'causa'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'recibido'
        DataType = ftDate
      end
      item
        Name = 'observaciones'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_legajo'
    IndexDefs = <
      item
        Name = 'TCartasDocRemitidasIndex1'
        Fields = 'oid_legajo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_legajo'
    MasterSource = DSLegajos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 864
    Top = 140
    object TCartasDocRemitidasoid_carta_remitida: TIntegerField
      FieldName = 'oid_carta_remitida'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCartasDocRemitidasnro_orden: TIntegerField
      FieldName = 'nro_orden'
    end
    object TCartasDocRemitidasoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TCartasDocRemitidasnro_carta_doc: TStringField
      FieldName = 'nro_carta_doc'
      Size = 50
    end
    object TCartasDocRemitidasfecha: TDateField
      FieldName = 'fecha'
    end
    object TCartasDocRemitidasoid_tipo_causa: TIntegerField
      FieldName = 'oid_tipo_causa'
    end
    object TCartasDocRemitidascausa: TStringField
      FieldName = 'causa'
      Size = 4000
    end
    object TCartasDocRemitidasrecibido: TDateField
      FieldName = 'recibido'
    end
    object TCartasDocRemitidasobservaciones: TStringField
      FieldName = 'observaciones'
      Size = 4000
    end
    object TCartasDocRemitidasactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSCartasDocRemitidas: TDataSource
    DataSet = TCartasDocRemitidas
    Left = 896
    Top = 140
  end
  object TTipoCausaCartaRem: TsnTable
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
    Left = 576
    Top = 527
    object IntegerField26: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField40: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField41: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpTipoCausaCartaRem: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.TipoCausaLegales'
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
    Titulo = 'Tipos Causas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 606
    Top = 528
  end
  object DSTTipoCausaCartaRem: TDataSource
    DataSet = TTipoCausaCartaRem
    Left = 639
    Top = 528
  end
  object TSeclos: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_seclo'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'fec_recepcion'
        DataType = ftDate
      end
      item
        Name = 'oid_tipo_reclamo'
        DataType = ftInteger
      end
      item
        Name = 'monto_reclamo'
        DataType = ftCurrency
      end
      item
        Name = 'observaciones'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'oid_estado_seclo'
        DataType = ftInteger
      end
      item
        Name = 'monto_acuerdo'
        DataType = ftCurrency
      end
      item
        Name = 'hono_letrado'
        DataType = ftCurrency
      end
      item
        Name = 'hono_conciliado'
        DataType = ftCurrency
      end
      item
        Name = 'otros_hono'
        DataType = ftCurrency
      end
      item
        Name = 'pagado'
        DataType = ftCurrency
      end
      item
        Name = 'saldado'
        DataType = ftBoolean
      end
      item
        Name = 'codigo_interno'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'tipo'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'oid_forma_exti'
        DataType = ftInteger
      end
      item
        Name = 'fec_novedad'
        DataType = ftDate
      end
      item
        Name = 'causal_acuerdo'
        DataType = ftString
        Size = 100
      end>
    IndexFieldNames = 'oid_legajo'
    IndexDefs = <
      item
        Name = 'TSeclosIndex1'
        Fields = 'oid_legajo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_legajo'
    MasterSource = DSLegajos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 864
    Top = 180
    object TSeclosoid_seclo: TIntegerField
      FieldName = 'oid_seclo'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TSeclosoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TSeclosfec_recepcion: TDateField
      FieldName = 'fec_recepcion'
    end
    object TSeclosoid_tipo_reclamo: TIntegerField
      FieldName = 'oid_tipo_reclamo'
    end
    object TSeclosmonto_reclamo: TCurrencyField
      FieldName = 'monto_reclamo'
      DisplayFormat = '###,###,###,###,##0.00'
    end
    object TSeclosobservaciones: TStringField
      FieldName = 'observaciones'
      Size = 4000
    end
    object TSeclosactivo: TBooleanField
      FieldName = 'activo'
    end
    object TSeclosoid_estado_seclo: TIntegerField
      FieldName = 'oid_estado_seclo'
    end
    object TSeclosmonto_acuerdo: TCurrencyField
      FieldName = 'monto_acuerdo'
      DisplayFormat = '###,###,###,###,###.##'
    end
    object TSecloshono_letrado: TCurrencyField
      FieldName = 'hono_letrado'
      DisplayFormat = '###,###,###,###,###.##'
    end
    object TSecloshono_conciliado: TCurrencyField
      FieldName = 'hono_conciliado'
      DisplayFormat = '###,###,###,###,###.##'
    end
    object TSeclosotros_hono: TCurrencyField
      FieldName = 'otros_hono'
      DisplayFormat = '###,###,###,###,###.##'
    end
    object TSeclospagado: TCurrencyField
      FieldName = 'pagado'
      DisplayFormat = '###,###,###,###.##'
    end
    object TSeclossaldado: TBooleanField
      FieldName = 'saldado'
    end
    object TSeclosa_pagar: TCurrencyField
      FieldKind = fkCalculated
      FieldName = 'a_pagar'
      DisplayFormat = '###,###,###,###.##'
      Calculated = True
    end
    object TSeclossaldo: TCurrencyField
      FieldKind = fkCalculated
      FieldName = 'saldo'
      DisplayFormat = '###,###,###,##0.##'
      Calculated = True
    end
    object TSecloscodigo_interno: TStringField
      FieldName = 'codigo_interno'
      Size = 50
    end
    object TSeclostipo: TStringField
      FieldName = 'tipo'
      Size = 10
    end
    object TSeclosoid_forma_exti: TIntegerField
      FieldName = 'oid_forma_exti'
    end
    object TSeclosfec_novedad: TDateField
      FieldName = 'fec_novedad'
    end
    object TSecloscausal_acuerdo: TStringField
      FieldName = 'causal_acuerdo'
      Size = 100
    end
  end
  object DSSeclos: TDataSource
    DataSet = TSeclos
    Left = 896
    Top = 180
  end
  object TTipoReclamo: TsnTable
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
    Left = 744
    Top = 495
    object IntegerField32: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField42: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField43: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpTipoReclamo: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.TipoReclamoLeg'
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
    Titulo = 'Tipos Reclamos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 774
    Top = 496
  end
  object DSTiposReclamos: TDataSource
    DataSet = TTipoReclamo
    Left = 807
    Top = 496
  end
  object TEstadoReclamo: TsnTable
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
    Left = 744
    Top = 533
    object IntegerField33: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField44: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField45: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpEstadosReclamos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.EstadoSeclo'
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
    Titulo = 'Estados Seclos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 774
    Top = 534
  end
  object DSEstadosSeclos: TDataSource
    DataSet = TEstadoReclamo
    Left = 807
    Top = 534
  end
  object TAudienciaSeclo: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_audiencia'
        DataType = ftInteger
      end
      item
        Name = 'oid_seclo'
        DataType = ftInteger
      end
      item
        Name = 'fecha'
        DataType = ftDate
      end
      item
        Name = 'hora'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'direccion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'conciliador'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'telefonos'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_seclo'
    IndexDefs = <
      item
        Name = 'TAudienciaSecloIndex1'
        Fields = 'oid_seclo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_seclo'
    MasterSource = DSSeclos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 696
    Top = 259
    object TAudienciaSeclooid_audiencia: TIntegerField
      FieldName = 'oid_audiencia'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAudienciaSeclooid_seclo: TIntegerField
      FieldName = 'oid_seclo'
    end
    object TAudienciaSeclofecha: TDateField
      FieldName = 'fecha'
    end
    object TAudienciaSeclohora: TStringField
      FieldName = 'hora'
      Size = 5
    end
    object TAudienciaSeclodireccion: TStringField
      FieldName = 'direccion'
      Size = 100
    end
    object TAudienciaSecloconciliador: TStringField
      FieldName = 'conciliador'
      Size = 100
    end
    object TAudienciaSeclotelefonos: TStringField
      FieldName = 'telefonos'
      Size = 100
    end
    object TAudienciaSecloactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSAudienciaSeclo: TDataSource
    DataSet = TAudienciaSeclo
    Left = 727
    Top = 259
  end
  object TDocEnvSec: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_doc_env_sec'
        DataType = ftInteger
      end
      item
        Name = 'oid_seclo'
        DataType = ftInteger
      end
      item
        Name = 'fecha_envio'
        DataType = ftDate
      end
      item
        Name = 'documentacion'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_seclo'
    IndexDefs = <
      item
        Name = 'TDocEnvSecIndex1'
        Fields = 'oid_seclo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_seclo'
    MasterSource = DSSeclos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 769
    Top = 260
    object TDocEnvSecoid_doc_env_sec: TIntegerField
      FieldName = 'oid_doc_env_sec'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TDocEnvSecoid_seclo: TIntegerField
      FieldName = 'oid_seclo'
    end
    object TDocEnvSecfecha_envio: TDateField
      FieldName = 'fecha_envio'
    end
    object TDocEnvSecdocumentacion: TStringField
      FieldName = 'documentacion'
      Size = 4000
    end
    object TDocEnvSecactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTDocEnvSec: TDataSource
    DataSet = TDocEnvSec
    Left = 801
    Top = 260
  end
  object TPagoSeclo: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_pago_seclo'
        DataType = ftInteger
      end
      item
        Name = 'oid_seclo'
        DataType = ftInteger
      end
      item
        Name = 'fec_pago'
        DataType = ftDate
      end
      item
        Name = 'observacion'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'pago_acuerdo'
        DataType = ftCurrency
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'pago_letrado'
        DataType = ftCurrency
      end
      item
        Name = 'oid_conc_pago_seclo'
        DataType = ftInteger
      end
      item
        Name = 'pago_conciliador'
        DataType = ftCurrency
      end
      item
        Name = 'pago_otros'
        DataType = ftCurrency
      end>
    IndexFieldNames = 'oid_seclo'
    IndexDefs = <
      item
        Name = 'TPagoSecloIndex1'
        Fields = 'oid_seclo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_seclo'
    MasterSource = DSSeclos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 849
    Top = 260
    object TPagoSeclooid_pago_seclo: TIntegerField
      FieldName = 'oid_pago_seclo'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPagoSeclooid_conc_pago_seclo: TIntegerField
      FieldName = 'oid_conc_pago_seclo'
    end
    object TPagoSeclooid_seclo: TIntegerField
      FieldName = 'oid_seclo'
    end
    object TPagoSeclofec_pago: TDateField
      FieldName = 'fec_pago'
    end
    object TPagoSeclopago_acuerdo: TCurrencyField
      FieldName = 'pago_acuerdo'
      DisplayFormat = '###,###,###,###.##'
    end
    object TPagoSeclopago_letrado: TCurrencyField
      FieldName = 'pago_letrado'
      DisplayFormat = '###,###,###,###.##'
    end
    object TPagoSeclopago_conciliador: TCurrencyField
      FieldName = 'pago_conciliador'
      DisplayFormat = '###,###,###,###.##'
    end
    object TPagoSeclopago_otros: TCurrencyField
      FieldName = 'pago_otros'
      DisplayFormat = '###,###,###,###.##'
    end
    object TPagoSecloactivo: TBooleanField
      FieldName = 'activo'
    end
    object TPagoSecloobservacion: TMemoField
      FieldName = 'observacion'
      BlobType = ftMemo
    end
  end
  object DSPagoSeclo: TDataSource
    DataSet = TPagoSeclo
    Left = 881
    Top = 260
  end
  object TConcPago: TsnTable
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
    Left = 744
    Top = 575
    object IntegerField34: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField46: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField47: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpConcPago: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.ConcPagoSeclo'
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
    Titulo = 'Conceptos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 774
    Top = 576
  end
  object DSConceptos: TDataSource
    DataSet = TConcPago
    Left = 807
    Top = 576
  end
  object TRequeridos: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_seclo_reque'
        DataType = ftInteger
      end
      item
        Name = 'oid_seclo'
        DataType = ftInteger
      end
      item
        Name = 'oid_val_clasif_emp'
        DataType = ftInteger
      end
      item
        Name = 'cod_val_clasif_emp'
        DataType = ftString
        Size = 50
      end>
    IndexFieldNames = 'oid_seclo'
    IndexDefs = <
      item
        Name = 'TRequeridosIndex1'
        Fields = 'oid_seclo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_seclo'
    MasterSource = DSSeclos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 609
    Top = 268
    object TRequeridosoid_seclo_reque: TIntegerField
      FieldName = 'oid_seclo_reque'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRequeridosoid_seclo: TIntegerField
      FieldName = 'oid_seclo'
    end
    object TRequeridosoid_val_clasif_emp: TIntegerField
      FieldName = 'oid_val_clasif_emp'
    end
    object TRequeridoscod_val_clasif_emp: TStringField
      FieldName = 'cod_val_clasif_emp'
      Size = 50
    end
    object TRequeridosdesc_val_clasif_emp: TStringField
      FieldName = 'desc_val_clasif_emp'
      Size = 100
    end
    object TRequeridosactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTRequeridos: TDataSource
    DataSet = TRequeridos
    Left = 641
    Top = 268
  end
  object TLeyendasReporte: TsnTable
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
    Left = 944
    Top = 260
    object TLeyendasReporteoid_clasif_empresa: TIntegerField
      FieldName = 'oid_clasif_empresa'
    end
    object TLeyendasReportenro_clasif_empresa: TIntegerField
      FieldName = 'nro_clasif_empresa'
    end
    object TLeyendasReporteoid_clasif_puesto: TIntegerField
      FieldName = 'oid_clasif_puesto'
    end
    object TLeyendasReportenro_clasif_puesto: TIntegerField
      FieldName = 'nro_clasif_puesto'
    end
    object TLeyendasReporteoid_clasif_sector: TIntegerField
      FieldName = 'oid_clasif_sector'
    end
    object TLeyendasReportenro_clasif_sector: TIntegerField
      FieldName = 'nro_clasif_sector'
    end
  end
  object HelpValoresClasifEmpresa: THelpValoresClasificador
    AsignarCampoCodigo = TRequeridoscod_val_clasif_emp
    NroClasificador = 0
    Left = 776
    Top = 97
  end
  object TNovedadLegajo: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_novedad'
        DataType = ftInteger
      end
      item
        Name = 'nro_ext'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_novedad'
        DataType = ftInteger
      end
      item
        Name = 'oid_mot_tipo_nov'
        DataType = ftInteger
      end
      item
        Name = 'fecha'
        DataType = ftDate
      end
      item
        Name = 'hora_desde'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'hora_hasta'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'observacion'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_legajo;orden'
    IndexDefs = <
      item
        Name = 'TNovedadLegajoIndex1'
        Fields = 'oid_legajo;orden'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_legajo'
    MasterSource = DSLegajos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 849
    Top = 332
    object TNovedadLegajooid_novedad: TIntegerField
      FieldName = 'oid_novedad'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TNovedadLegajonro_ext: TIntegerField
      FieldName = 'nro_ext'
    end
    object TNovedadLegajooid_tipo_novedad: TIntegerField
      FieldName = 'oid_tipo_novedad'
    end
    object TNovedadLegajofecha: TDateField
      FieldName = 'fecha'
    end
    object TNovedadLegajohora_desde: TStringField
      FieldName = 'hora_desde'
      Size = 5
    end
    object TNovedadLegajohora_hasta: TStringField
      FieldName = 'hora_hasta'
      Size = 5
    end
    object TNovedadLegajoactivo: TBooleanField
      FieldName = 'activo'
    end
    object TNovedadLegajoobservacion: TStringField
      FieldName = 'observacion'
      Size = 4000
    end
    object TNovedadLegajooid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TNovedadLegajooid_mot_tipo_nov: TIntegerField
      FieldName = 'oid_mot_tipo_nov'
    end
    object TNovedadLegajocod_mot_tipo_nov: TStringField
      FieldName = 'cod_mot_tipo_nov'
      Size = 50
    end
    object TNovedadLegajodesc_mot_tipo_nov: TStringField
      FieldName = 'desc_mot_tipo_nov'
      Size = 100
    end
    object TNovedadLegajoorden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
  end
  object DSNovedadLegajo: TDataSource
    DataSet = TNovedadLegajo
    Left = 881
    Top = 340
  end
  object TTipoNovedad: TsnTable
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
    Left = 441
    Top = 592
    object IntegerField35: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField48: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField49: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpTipoNovedad: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.TipoNovedad'
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
    Titulo = 'Tipos Novedades'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 471
    Top = 593
  end
  object DSTipoNovedad: TDataSource
    DataSet = TTipoNovedad
    Left = 504
    Top = 593
  end
  object TMotivosNov: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_tipo_nov'
        DataType = ftInteger
      end
      item
        Name = 'oid_mot_tipo_nov'
        DataType = ftInteger
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
    IndexFieldNames = 'oid_tipo_nov'
    IndexDefs = <
      item
        Name = 'TMotivosNovIndex1'
        Fields = 'oid_tipo_nov'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_tipo_novedad'
    MasterSource = DSNovedadLegajo
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 873
    Top = 436
    object TMotivosNovoid_tipo_nov: TIntegerField
      FieldName = 'oid_tipo_nov'
    end
    object TMotivosNovoid: TIntegerField
      FieldName = 'oid'
    end
    object TMotivosNovcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TMotivosNovdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TMotivosNovactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSMotivosNov: TDataSource
    DataSet = TMotivosNov
    Left = 905
    Top = 436
  end
  object HelpMotivosNov: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.MotivoTipoNov'
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
        AsignarACampo = TNovedadLegajocod_mot_tipo_nov
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
    Titulo = 'Motivos Novedades'
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 774
    Top = 457
  end
  object TTempMotNov: TsnTable
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
    Left = 873
    Top = 476
    object TTempMotNovoid: TIntegerField
      FieldName = 'oid'
    end
    object TTempMotNovcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTempMotNovdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TTempMotNovactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTTempMotNov: TDataSource
    DataSet = TTempMotNov
    Left = 905
    Top = 476
  end
  object HelpEstadoDesa: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.EstadoDesarrollo'
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
        AsignarACampo = TLegajoscod_est_desa
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
    Titulo = 'Estados Desarrollo'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 205
    Top = 605
  end
  object ValidadorEstDesa: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rh.EstadoDesarrollo'
    MensajeException = 'C'#243'digo de Estado Inexistente'
    CampoOID = TLegajosoid_est_desa
    CampoDescripcion = TLegajosdesc_est_desa
    NroQuery = 0
    Cache = True
    Left = 241
    Top = 605
  end
  object TCategPosibleLeg: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_categ_pos_leg'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'oid_categ_posible'
        DataType = ftInteger
      end
      item
        Name = 'cod_categ_posible'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_categ_posible'
        DataType = ftString
        Size = 100
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
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_legajo'
    IndexDefs = <
      item
        Name = 'TCategPosibleLegIndex1'
        Fields = 'oid_legajo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_legajo'
    MasterSource = DSLegajos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 936
    Top = 140
    object TCategPosibleLegoid_categ_pos_leg: TIntegerField
      FieldName = 'oid_categ_pos_leg'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCategPosibleLegoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TCategPosibleLegoid_categ_posible: TIntegerField
      FieldName = 'oid_categ_posible'
    end
    object TCategPosibleLegcod_categ_posible: TStringField
      FieldName = 'cod_categ_posible'
      Size = 50
    end
    object TCategPosibleLegdesc_categ_posible: TStringField
      FieldName = 'desc_categ_posible'
      Size = 100
    end
    object TCategPosibleLegfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TCategPosibleLegfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object TCategPosibleLegoid_rankear: TIntegerField
      FieldName = 'oid_rankear'
    end
    object TCategPosibleLegactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTCategPosibleLeg: TDataSource
    DataSet = TCategPosibleLeg
    Left = 971
    Top = 140
  end
  object HelpValoresClasifPuesto: THelpValoresClasificador
    NroClasificador = 0
    Left = 64
    Top = 448
  end
  object HelpValoresClasificadorPuesto1: THelpValoresClasificador
    AsignarCampoCodigo = TCategPosibleLegcod_categ_posible
    NroClasificador = 0
    Left = 72
    Top = 216
  end
  object TJuicio: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_juicio'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_reclamo'
        DataType = ftInteger
      end
      item
        Name = 'fec_rec_dem'
        DataType = ftDate
      end
      item
        Name = 'oid_juzgado'
        DataType = ftInteger
      end
      item
        Name = 'nro_juzgado'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'nombre_juzgado'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'nro_expediente'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'monto_reclamo'
        DataType = ftCurrency
      end
      item
        Name = 'prob_resultado'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'porc_prevision'
        DataType = ftCurrency
      end
      item
        Name = 'estimado'
        DataType = ftCurrency
      end
      item
        Name = 'oid_est_procesal'
        DataType = ftInteger
      end
      item
        Name = 'oid_est_juicio'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'monto_acuerdo'
        DataType = ftCurrency
      end
      item
        Name = 'monto_honorario'
        DataType = ftCurrency
      end
      item
        Name = 'monto_perito'
        DataType = ftCurrency
      end
      item
        Name = 'monto_letrado'
        DataType = ftCurrency
      end
      item
        Name = 'tasa_justicia'
        DataType = ftCurrency
      end
      item
        Name = 'fec_pago'
        DataType = ftDate
      end
      item
        Name = 'observaciones'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'oid_peri_mens_prev'
        DataType = ftInteger
      end
      item
        Name = 'prevision'
        DataType = ftCurrency
      end
      item
        Name = 'oid_abogado'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'abogado'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'periodo'
        DataType = ftString
        Size = 7
      end
      item
        Name = 'cbu'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'embargo'
        DataType = ftFloat
      end
      item
        Name = 'oid_resul_juicio'
        DataType = ftInteger
      end
      item
        Name = 'codigo_interno'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'fec_novedad'
        DataType = ftDate
      end
      item
        Name = 'total'
        DataType = ftCurrency
      end
      item
        Name = 'pagado'
        DataType = ftCurrency
      end
      item
        Name = 'saldo'
        DataType = ftCurrency
      end
      item
        Name = 'oid_tipo_pericia'
        DataType = ftInteger
      end
      item
        Name = 'oid_fuero'
        DataType = ftInteger
      end
      item
        Name = 'oid_comp_seg_cau'
        DataType = ftInteger
      end
      item
        Name = 'caratula'
        DataType = ftString
        Size = 250
      end
      item
        Name = 'porc_incapacidad'
        DataType = ftFloat
      end
      item
        Name = 'monto_interes'
        DataType = ftCurrency
      end>
    IndexFieldNames = 'oid_legajo'
    IndexDefs = <
      item
        Name = 'TJuicioIndex1'
        Fields = 'oid_legajo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_legajo'
    MasterSource = DSLegajos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 416
    Top = 140
    object TJuiciooid_juicio: TIntegerField
      FieldName = 'oid_juicio'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TJuiciooid_tipo_reclamo: TIntegerField
      FieldName = 'oid_tipo_reclamo'
    end
    object TJuiciofec_rec_dem: TDateField
      FieldName = 'fec_rec_dem'
    end
    object TJuiciooid_juzgado: TIntegerField
      FieldName = 'oid_juzgado'
    end
    object TJuicionro_juzgado: TStringField
      FieldName = 'nro_juzgado'
      Size = 50
    end
    object TJuicionombre_juzgado: TStringField
      FieldName = 'nombre_juzgado'
      Size = 255
    end
    object TJuicionro_expediente: TStringField
      FieldName = 'nro_expediente'
      Size = 50
    end
    object TJuiciomonto_reclamo: TCurrencyField
      FieldName = 'monto_reclamo'
      DisplayFormat = '###,###,###,###.##'
    end
    object TJuicioprob_resultado: TStringField
      FieldName = 'prob_resultado'
      Size = 10
    end
    object TJuicioporc_prevision: TCurrencyField
      FieldName = 'porc_prevision'
      DisplayFormat = '###,###.##'
    end
    object TJuicioestimado: TCurrencyField
      FieldName = 'estimado'
      DisplayFormat = '###,###,###,###.##'
    end
    object TJuiciooid_est_procesal: TIntegerField
      FieldName = 'oid_est_procesal'
    end
    object TJuiciooid_est_juicio: TIntegerField
      FieldName = 'oid_est_juicio'
    end
    object TJuicioactivo: TBooleanField
      FieldName = 'activo'
    end
    object TJuiciomonto_acuerdo: TCurrencyField
      FieldName = 'monto_acuerdo'
      DisplayFormat = '###,###,###,###.##'
    end
    object TJuiciomonto_honorario: TCurrencyField
      FieldName = 'monto_honorario'
      DisplayFormat = '###,###,###,###.##'
    end
    object TJuiciomonto_perito: TCurrencyField
      FieldName = 'monto_perito'
      DisplayFormat = '###,###,###,###.##'
    end
    object TJuiciomonto_letrado: TCurrencyField
      FieldName = 'monto_letrado'
      DisplayFormat = '###,###,###,###.##'
    end
    object TJuiciotasa_justicia: TCurrencyField
      FieldName = 'tasa_justicia'
      DisplayFormat = '###,###,###,###.##'
    end
    object TJuiciofec_pago: TDateField
      FieldName = 'fec_pago'
    end
    object TJuicioobservaciones: TStringField
      FieldName = 'observaciones'
      Size = 4000
    end
    object TJuiciooid_peri_mens_prev: TIntegerField
      FieldName = 'oid_peri_mens_prev'
    end
    object TJuicioprevision: TCurrencyField
      FieldName = 'prevision'
      DisplayFormat = '###,###,###,###.##'
    end
    object TJuiciooid_abogado: TIntegerField
      FieldName = 'oid_abogado'
    end
    object TJuiciooid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TJuicioabogado: TStringField
      FieldName = 'abogado'
      Size = 100
    end
    object TJuicioperiodo: TStringField
      FieldName = 'periodo'
      Size = 7
    end
    object TJuiciocbu: TStringField
      FieldName = 'cbu'
      Size = 50
    end
    object TJuicioembargo: TFloatField
      FieldName = 'embargo'
    end
    object TJuiciooid_resul_juicio: TIntegerField
      FieldName = 'oid_resul_juicio'
    end
    object TJuiciocodigo_interno: TStringField
      FieldName = 'codigo_interno'
      Size = 50
    end
    object TJuiciofec_novedad: TDateField
      FieldName = 'fec_novedad'
    end
    object TJuiciototal: TCurrencyField
      FieldName = 'total'
      DisplayFormat = '###,###,###,###.##'
    end
    object TJuiciopagado: TCurrencyField
      FieldName = 'pagado'
      DisplayFormat = '###,###,###,###.##'
    end
    object TJuiciosaldo: TCurrencyField
      FieldName = 'saldo'
      DisplayFormat = '###,###,###,###.##'
    end
    object TJuiciooid_tipo_pericia: TIntegerField
      FieldName = 'oid_tipo_pericia'
    end
    object TJuiciooid_fuero: TIntegerField
      FieldName = 'oid_fuero'
    end
    object TJuiciooid_comp_seg_cau: TIntegerField
      FieldName = 'oid_comp_seg_cau'
    end
    object TJuiciocaratula: TStringField
      FieldName = 'caratula'
      Size = 250
    end
    object TJuicioporc_incapacidad: TFloatField
      FieldName = 'porc_incapacidad'
    end
    object TJuiciomonto_interes: TCurrencyField
      FieldName = 'monto_interes'
      DisplayFormat = '###,###,###,###.##'
    end
    object TJuicioporc_perito: TFloatField
      FieldName = 'porc_perito'
    end
    object TJuicioporc_letrado: TFloatField
      FieldName = 'porc_letrado'
    end
    object TJuicioporc_tasa_just: TFloatField
      FieldName = 'porc_tasa_just'
    end
    object TJuicioprimera_instancia: TStringField
      FieldName = 'primera_instancia'
      Size = 4000
    end
    object TJuiciosegunda_instancia: TStringField
      FieldName = 'segunda_instancia'
      Size = 4000
    end
  end
  object DSJuicio: TDataSource
    DataSet = TJuicio
    Left = 448
    Top = 140
  end
  object HelpJuzgados: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.Juzgado'
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
        Longitud = 50
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 50
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = True
        AsignarACampo = TJuicionro_juzgado
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
    Titulo = 'Juzgados'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 458
    Top = 477
  end
  object ValidadorJuzgado: TValidador
    Operacion = Operacion
    NickNameObjLog = 'leg.Juzgado'
    MensajeException = 'C'#243'digo de Juzgado Inexistente'
    CampoOID = TJuiciooid_juzgado
    CampoDescripcion = TJuicionombre_juzgado
    NroQuery = 0
    Cache = True
    Left = 494
    Top = 478
  end
  object TResulProbJuicio: TsnTable
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
    Left = 880
    Top = 563
    object TResulProbJuiciocodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TResulProbJuiciodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSResulProbJuicio: TDataSource
    DataSet = TResulProbJuicio
    Left = 915
    Top = 561
  end
  object TEtapaProcesal: TsnTable
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
    Left = 560
    Top = 634
    object IntegerField36: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField50: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField51: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpEtapaProcesal: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.EstadoProcesal'
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
    Titulo = 'Etapa Procesal'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 590
    Top = 635
  end
  object DSEtapaProcesal: TDataSource
    DataSet = TEtapaProcesal
    Left = 623
    Top = 635
  end
  object TEstadoJuicio: TsnTable
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
    Left = 664
    Top = 637
    object IntegerField37: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField52: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField53: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpEstadoJuicio: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.EstadoJuicio'
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
    Titulo = 'Estado Juicio'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 694
    Top = 638
  end
  object DSEstadoJuicio: TDataSource
    DataSet = TEstadoJuicio
    Left = 727
    Top = 638
  end
  object ValidarPeriodo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'ge.Periodo'
    MensajeException = 'C'#243'digo de Per'#237'odo Inexistente'
    CampoOID = TJuiciooid_peri_mens_prev
    NroQuery = 0
    Cache = True
    Left = 494
    Top = 514
  end
  object HelpAbogados: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.Abogado'
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
        Longitud = 255
        Visible = True
        AsignarACampo = TJuicioabogado
        KeyField = False
        AnchoEnCaracteres = 255
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = False
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
    Titulo = 'Abogados'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 458
    Top = 545
  end
  object ValidadorAbogado: TValidador
    Operacion = Operacion
    NickNameObjLog = 'leg.Abogado'
    MensajeException = 'C'#243'digo de Abogado Inexistente'
    CampoOID = TJuiciooid_abogado
    NroQuery = 0
    Cache = True
    Left = 494
    Top = 546
  end
  object TDocuEnvJuicio: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_doc_env_juicio'
        DataType = ftInteger
      end
      item
        Name = 'oid_juicio'
        DataType = ftInteger
      end
      item
        Name = 'fecha_envio'
        DataType = ftDate
      end
      item
        Name = 'documentacion'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_juicio'
    IndexDefs = <
      item
        Name = 'TDocuEnvJuicioIndex1'
        Fields = 'oid_juicio'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_juicio'
    MasterSource = DSJuicio
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 232
    Top = 244
    object TDocuEnvJuiciooid_doc_env_juicio: TIntegerField
      FieldName = 'oid_doc_env_juicio'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TDocuEnvJuiciooid_juicio: TIntegerField
      FieldName = 'oid_juicio'
    end
    object TDocuEnvJuiciofecha_envio: TDateField
      FieldName = 'fecha_envio'
    end
    object TDocuEnvJuiciodocumentacion: TStringField
      FieldName = 'documentacion'
      Size = 4000
    end
    object TDocuEnvJuicioactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSDocuEnvJuicio: TDataSource
    DataSet = TDocuEnvJuicio
    Left = 256
    Top = 236
  end
  object TJuicioEmpresa: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_jui_emp'
        DataType = ftInteger
      end
      item
        Name = 'oid_juicio'
        DataType = ftInteger
      end
      item
        Name = 'oid_val_clasif_emp'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_juicio'
    IndexDefs = <
      item
        Name = 'TJuicioEmpresaIndex1'
        Fields = 'oid_juicio'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_juicio'
    MasterSource = DSJuicio
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 409
    Top = 283
    object TJuicioEmpresaoid_jui_emp: TIntegerField
      FieldName = 'oid_jui_emp'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TJuicioEmpresaoid_juicio: TIntegerField
      FieldName = 'oid_juicio'
    end
    object TJuicioEmpresaoid_val_clasif_emp: TIntegerField
      FieldName = 'oid_val_clasif_emp'
    end
    object TJuicioEmpresacod_val_clasif_emp: TStringField
      FieldName = 'cod_val_clasif_emp'
      Size = 50
    end
    object TJuicioEmpresadesc_val_clasif_emp: TStringField
      FieldName = 'desc_val_clasif_emp'
      Size = 100
    end
    object TJuicioEmpresaactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSJuicioEmpresa: TDataSource
    DataSet = TJuicioEmpresa
    Left = 441
    Top = 283
  end
  object HelpValoresClasifEmpresaJuicio: THelpValoresClasificador
    AsignarCampoCodigo = TJuicioEmpresacod_val_clasif_emp
    NroClasificador = 0
    Left = 816
    Top = 97
  end
  object TAudienciaJuicio: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_aud_juicio'
        DataType = ftInteger
      end
      item
        Name = 'oid_juicio'
        DataType = ftInteger
      end
      item
        Name = 'fecha'
        DataType = ftDate
      end
      item
        Name = 'hora'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'persona'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_tipo_aud'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_juicio'
    IndexDefs = <
      item
        Name = 'TAudienciaJuicioIndex1'
        Fields = 'oid_juicio'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_juicio'
    MasterSource = DSJuicio
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 504
    Top = 268
    object TAudienciaJuiciooid_aud_juicio: TIntegerField
      FieldName = 'oid_aud_juicio'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAudienciaJuiciooid_juicio: TIntegerField
      FieldName = 'oid_juicio'
    end
    object TAudienciaJuiciofecha: TDateField
      FieldName = 'fecha'
    end
    object TAudienciaJuiciohora: TStringField
      FieldName = 'hora'
      Size = 5
    end
    object TAudienciaJuiciopersona: TStringField
      FieldName = 'persona'
      Size = 100
    end
    object TAudienciaJuiciooid_tipo_aud: TIntegerField
      FieldName = 'oid_tipo_aud'
    end
    object TAudienciaJuicioactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTAudienciaJuicio: TDataSource
    DataSet = TAudienciaJuicio
    Left = 537
    Top = 267
  end
  object TiposAudiencias: TsnTable
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
    Left = 792
    Top = 635
    object IntegerField38: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField54: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField55: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpTipoAudJuicio: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.TipoAudiencia'
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
    Titulo = 'Tipos de Audiencia'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 822
    Top = 636
  end
  object DSTiposAudiencias: TDataSource
    DataSet = TiposAudiencias
    Left = 857
    Top = 634
  end
  object HelpRankear: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.RankearCab'
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
    Titulo = 'Rankear'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 146
    Top = 408
  end
  object THelpRankear: TsnTable
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
    Left = 180
    Top = 404
    object THelpRankearoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object THelpRankearcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object THelpRankeardescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object THelpRankearactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSHelpRankear: TDataSource
    DataSet = THelpRankear
    Left = 213
    Top = 406
  end
  object TObservaciones: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_obs_leg'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_obs_leg'
        DataType = ftInteger
      end
      item
        Name = 'fecha'
        DataType = ftDateTime
      end
      item
        Name = 'fec_carga'
        DataType = ftDate
      end
      item
        Name = 'oid_usu_carga'
        DataType = ftInteger
      end
      item
        Name = 'observacion'
        DataType = ftString
        Size = 1000
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_legajo'
    IndexDefs = <
      item
        Name = 'TObservacionesIndex1'
        Fields = 'oid_legajo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_legajo'
    MasterSource = DSLegajos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 328
    Top = 140
    object TObservacionesoid_obs_leg: TIntegerField
      FieldName = 'oid_obs_leg'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TObservacionesoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TObservacionesoid_tipo_obs_leg: TIntegerField
      FieldName = 'oid_tipo_obs_leg'
    end
    object TObservacionesfecha: TDateTimeField
      FieldName = 'fecha'
    end
    object TObservacionesfec_carga: TDateField
      FieldName = 'fec_carga'
    end
    object TObservacionesoid_usu_carga: TIntegerField
      FieldName = 'oid_usu_carga'
    end
    object TObservacionesobservacion: TStringField
      FieldName = 'observacion'
      Size = 1000
    end
    object TObservacionesactivo: TBooleanField
      FieldName = 'activo'
    end
    object TObservacionesusu_alta: TStringField
      FieldName = 'usu_alta'
      Size = 50
    end
    object TObservacionespos_neg_neu: TStringField
      FieldName = 'pos_neg_neu'
    end
  end
  object DSObservaciones: TDataSource
    DataSet = TObservaciones
    Left = 360
    Top = 141
  end
  object TTiposObservaciones: TsnTable
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
    Left = 576
    Top = 480
    object IntegerField39: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField56: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField57: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpTipoObservaciones: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.TipoObsLeg'
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
    Titulo = 'Tipos de Observaciones'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 606
    Top = 481
  end
  object DSTiposObservaciones: TDataSource
    DataSet = TTiposObservaciones
    Left = 639
    Top = 481
  end
  object TPosNegNeu: TsnTable
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
    Left = 945
    Top = 404
    object TPosNegNeucodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TPosNegNeudescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSPosNegNeu: TDataSource
    DataSet = TPosNegNeu
    Left = 977
    Top = 412
  end
  object HelpValoresClasifEmpresaHP: THelpValoresClasificador
    AsignarCampoCodigo = THistPuestoscod_val_clasif_emp
    NroClasificador = 0
    Left = 720
    Top = 99
  end
  object HelpValoresClasifSectorHP: THelpValoresClasificador
    AsignarCampoCodigo = THistPuestoscod_val_clasif_sec
    NroClasificador = 0
    Left = 677
    Top = 99
  end
  object TResultadoJuicio: TsnTable
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
    Left = 560
    Top = 673
    object IntegerField40: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField58: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField59: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpResultadoJuicio: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.ResultadoJuicio'
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
    Titulo = 'Resultado Juicios'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 590
    Top = 674
  end
  object DSResultadosJuicios: TDataSource
    DataSet = TResultadoJuicio
    Left = 623
    Top = 674
  end
  object TPagoJuicio: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_pago_juicio'
        DataType = ftInteger
      end
      item
        Name = 'fec_pago'
        DataType = ftDate
      end
      item
        Name = 'observacion'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'oid_conc_pago_seclo'
        DataType = ftInteger
      end
      item
        Name = 'pago_acuerdo'
        DataType = ftCurrency
      end
      item
        Name = 'pago_honorario'
        DataType = ftCurrency
      end
      item
        Name = 'pago_perito'
        DataType = ftCurrency
      end
      item
        Name = 'pago_tasa_just'
        DataType = ftCurrency
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'oid_juicio'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_juicio'
    IndexDefs = <
      item
        Name = 'TPagoJuicioIndex1'
        Fields = 'oid_juicio'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_juicio'
    MasterSource = DSJuicio
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 617
    Top = 178
    object TPagoJuiciooid_pago_juicio: TIntegerField
      FieldName = 'oid_pago_juicio'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPagoJuiciofec_pago: TDateField
      FieldName = 'fec_pago'
    end
    object TPagoJuicioobservacion: TStringField
      FieldName = 'observacion'
      Size = 4000
    end
    object TPagoJuiciooid_conc_pago_seclo: TIntegerField
      FieldName = 'oid_conc_pago_seclo'
    end
    object TPagoJuiciopago_acuerdo: TCurrencyField
      FieldName = 'pago_acuerdo'
      DisplayFormat = '###,###,###,###.##'
    end
    object TPagoJuiciopago_honorario: TCurrencyField
      FieldName = 'pago_honorario'
      DisplayFormat = '###,###,###,###.##'
    end
    object TPagoJuiciopago_perito: TCurrencyField
      FieldName = 'pago_perito'
      DisplayFormat = '###,###,###,###.##'
    end
    object TPagoJuiciopago_tasa_just: TCurrencyField
      FieldName = 'pago_tasa_just'
      DisplayFormat = '###,###,###,###.##'
    end
    object TPagoJuicioactivo: TBooleanField
      FieldName = 'activo'
    end
    object TPagoJuiciooid_juicio: TIntegerField
      FieldName = 'oid_juicio'
    end
    object TPagoJuiciopago_letrado: TCurrencyField
      FieldName = 'pago_letrado'
      DisplayFormat = '###,###,###,###.##'
    end
  end
  object DSPagoJuicio: TDataSource
    DataSet = TPagoJuicio
    Left = 649
    Top = 178
  end
  object TRubroCondena: TsnTable
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
    Left = 560
    Top = 708
    object IntegerField41: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField60: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object TRubroCondenadescripcion: TStringField
      FieldName = 'descripcion'
      Size = 255
    end
  end
  object HelpRubroCondena: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.RubroCondena'
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
        Longitud = 255
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 255
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
    Titulo = 'Rubro Condena'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 590
    Top = 709
  end
  object DSRubroCondena: TDataSource
    DataSet = TRubroCondena
    Left = 623
    Top = 709
  end
  object TJuicioRubroCondena: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_jui_rub_cond'
        DataType = ftInteger
      end
      item
        Name = 'oid_juicio'
        DataType = ftInteger
      end
      item
        Name = 'oid_rubro_condena'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_juicio'
    IndexDefs = <
      item
        Name = 'TJuicioRubroCondenaIndex1'
        Fields = 'oid_juicio'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_juicio'
    MasterSource = DSJuicio
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 920
    Top = 84
    object TJuicioRubroCondenaoid_jui_rub_cond: TIntegerField
      FieldName = 'oid_jui_rub_cond'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TJuicioRubroCondenaoid_juicio: TIntegerField
      FieldName = 'oid_juicio'
    end
    object TJuicioRubroCondenaoid_rubro_condena: TIntegerField
      FieldName = 'oid_rubro_condena'
    end
    object TJuicioRubroCondenaactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSJuicioRubroCondena: TDataSource
    DataSet = TJuicioRubroCondena
    Left = 952
    Top = 84
  end
  object HelpEmpresasJuicio: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.EmpresaJuicio'
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
        AsignarACampo = TJuicioEmpresacod_val_clasif_emp
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
    Titulo = 'Empresas Juicios'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 205
    Top = 642
  end
  object ValidadorEmpresaJuicio: TValidador
    Operacion = Operacion
    NickNameObjLog = 'leg.EmpresaJuicio'
    MensajeException = 'C'#243'digo de Empresa Inexistente'
    CampoOID = TJuicioEmpresaoid_val_clasif_emp
    CampoDescripcion = TJuicioEmpresadesc_val_clasif_emp
    NroQuery = 0
    Cache = True
    Left = 241
    Top = 642
  end
  object TNegociaciones: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_negociacion'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'fecha'
        DataType = ftDate
      end
      item
        Name = 'observacion'
        DataType = ftString
        Size = 500
      end
      item
        Name = 'monto'
        DataType = ftCurrency
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_legajo'
    IndexDefs = <
      item
        Name = 'TNegociacionesIndex1'
        Fields = 'oid_legajo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_legajo'
    MasterSource = DSLegajos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 456
    Top = 180
    object TNegociacionesoid_negociacion: TIntegerField
      FieldName = 'oid_negociacion'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TNegociacionesoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TNegociacionesfecha: TDateField
      FieldName = 'fecha'
    end
    object TNegociacionesobservacion: TStringField
      FieldName = 'observacion'
      Size = 500
    end
    object TNegociacionesmonto: TCurrencyField
      FieldName = 'monto'
      DisplayFormat = '###,###,###,##0.00'
    end
    object TNegociacionesactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSNegociaciones: TDataSource
    DataSet = TNegociaciones
    Left = 488
    Top = 180
  end
  object TTipoPericias: TsnTable
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
    Left = 336
    Top = 665
    object IntegerField42: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField61: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField62: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpTipoPericias: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.TipoPericia'
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
    Titulo = 'Tipos Pericias'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 366
    Top = 666
  end
  object DSTiposPericias: TDataSource
    DataSet = TTipoPericias
    Left = 399
    Top = 666
  end
  object TFuero: TsnTable
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
    Left = 576
    Top = 443
    object IntegerField43: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField63: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField64: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpFuero: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.Fuero'
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
    Titulo = 'Fueros'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 606
    Top = 444
  end
  object DSFueros: TDataSource
    DataSet = TFuero
    Left = 639
    Top = 444
  end
  object TTiposSeclos: TsnTable
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
    Left = 140
    Top = 703
    object StringField65: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField66: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTipoSeclo: TDataSource
    DataSet = TTiposSeclos
    Left = 173
    Top = 705
  end
  object TFormaExtincion: TsnTable
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
    Left = 336
    Top = 700
    object IntegerField44: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField67: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object StringField68: TStringField
      FieldName = 'descripcion'
      Size = 30
    end
  end
  object HelpFormaExtincion: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.FormaExtincion'
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
    Titulo = 'Forma Extincion'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 366
    Top = 701
  end
  object DSFormaExtincion: TDataSource
    DataSet = TFormaExtincion
    Left = 399
    Top = 701
  end
  object TMensEmbargoJuicio: TsnTable
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
    Left = 265
    Top = 748
    object TMensEmbargoJuiciomensaje: TStringField
      FieldName = 'mensaje'
      Size = 255
    end
  end
  object TRubroCondenaJuicio: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_rub_cond_jui'
        DataType = ftInteger
      end
      item
        Name = 'oid_rubro_condena'
        DataType = ftInteger
      end
      item
        Name = 'oid_juicio'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_juicio'
    IndexDefs = <
      item
        Name = 'TRubroCondenaJuicioIndex1'
        Fields = 'oid_juicio'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_juicio'
    MasterSource = DSJuicio
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 760
    Top = 52
    object TRubroCondenaJuiciooid_rub_cond_jui: TIntegerField
      FieldName = 'oid_rub_cond_jui'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRubroCondenaJuiciooid_rubro_condena: TIntegerField
      FieldName = 'oid_rubro_condena'
    end
    object TRubroCondenaJuiciooid_juicio: TIntegerField
      FieldName = 'oid_juicio'
    end
    object TRubroCondenaJuicioactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTRubroCondenaJuicio: TDataSource
    DataSet = TRubroCondenaJuicio
    Left = 792
    Top = 51
  end
  object TRubroReclamoSeclo: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_rub_rec_seclo'
        DataType = ftInteger
      end
      item
        Name = 'oid_rubro_condena'
        DataType = ftInteger
      end
      item
        Name = 'oid_seclo'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_seclo'
    IndexDefs = <
      item
        Name = 'TRubroReclamoSecloIndex1'
        Fields = 'oid_seclo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_seclo'
    MasterSource = DSSeclos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 648
    Top = 19
    object TRubroReclamoSeclooid_rub_rec_seclo: TIntegerField
      FieldName = 'oid_rub_rec_seclo'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRubroReclamoSeclooid_rubro_condena: TIntegerField
      FieldName = 'oid_rubro_condena'
    end
    object TRubroReclamoSeclooid_seclo: TIntegerField
      FieldName = 'oid_seclo'
    end
    object TRubroReclamoSecloactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTRubroReclamoSeclo: TDataSource
    DataSet = TRubroReclamoSeclo
    Left = 680
    Top = 19
  end
  object HelpTareaDesemp: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.TareaDesempeneada'
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
        AsignarACampo = TLegajoscod_tarea_desemp
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
    Titulo = 'Tareas Desempe'#241'adas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 205
    Top = 677
  end
  object ValidadorTareaDesemp: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rh.TareaDesempeneada'
    MensajeException = 'C'#243'digo de Tarea Inexistente'
    CampoOID = TLegajosoid_tarea_desemp
    CampoDescripcion = TLegajosdesc_tarea_desemp
    NroQuery = 0
    Cache = True
    Left = 241
    Top = 677
  end
  object TCompaniasSegCaucion: TsnTable
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
    Left = 560
    Top = 747
    object IntegerField45: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField69: TStringField
      DisplayWidth = 100
      FieldName = 'codigo'
      Size = 100
    end
    object StringField70: TStringField
      FieldName = 'descripcion'
      Size = 255
    end
  end
  object HelpCompaniaSeguroCaucion: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.CompaniaSeguro'
    NroHelp = 20
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
        Longitud = 255
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 255
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
    Titulo = 'Compa'#241'ia de Cauci'#243'n'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 590
    Top = 748
  end
  object DSCompaniaSeguroCaucion: TDataSource
    DataSet = TCompaniasSegCaucion
    Left = 623
    Top = 748
  end
  object TCalcInteres: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_calc_int'
        DataType = ftInteger
      end
      item
        Name = 'oid_juicio'
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
        Name = 'tipo_tasa'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'porc'
        DataType = ftFloat
      end
      item
        Name = 'interes'
        DataType = ftFloat
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_juicio'
    IndexDefs = <
      item
        Name = 'TCalcInteresIndex1'
        Fields = 'oid_juicio'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_juicio'
    MasterSource = DSJuicio
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 984
    Top = 20
    object TCalcInteresoid_calc_int: TIntegerField
      FieldName = 'oid_calc_int'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCalcInteresoid_juicio: TIntegerField
      FieldName = 'oid_juicio'
    end
    object TCalcInteresfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TCalcInteresfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object TCalcInterestipo_tasa: TStringField
      FieldName = 'tipo_tasa'
      Size = 10
    end
    object TCalcInteresporc: TFloatField
      FieldName = 'porc'
    end
    object TCalcInteresinteres: TFloatField
      FieldName = 'interes'
    end
    object TCalcInteresactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTCalcInteres: TDataSource
    DataSet = TCalcInteres
    Left = 1016
    Top = 19
  end
  object TTipoInteres: TsnTable
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
    Left = 1040
    Top = 116
    object TTipoInterescodigo: TStringField
      FieldName = 'codigo'
      Size = 10
    end
    object TTipoInteresdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTipoInteres: TDataSource
    DataSet = TTipoInteres
    Left = 1072
    Top = 116
  end
  object TEnviarTCalcInteres: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_calc_int'
        DataType = ftInteger
      end
      item
        Name = 'oid_juicio'
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
        Name = 'tipo_tasa'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'porc'
        DataType = ftFloat
      end
      item
        Name = 'interes'
        DataType = ftFloat
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_juicio'
    IndexDefs = <
      item
        Name = 'TCalcInteresIndex1'
        Fields = 'oid_juicio'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_juicio'
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 984
    Top = 54
    object IntegerField46: TIntegerField
      FieldName = 'oid_calc_int'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField47: TIntegerField
      FieldName = 'oid_juicio'
    end
    object DateField7: TDateField
      FieldName = 'fec_desde'
    end
    object DateField8: TDateField
      FieldName = 'fec_hasta'
    end
    object StringField71: TStringField
      FieldName = 'tipo_tasa'
      Size = 10
    end
    object FloatField1: TFloatField
      FieldName = 'porc'
    end
    object FloatField2: TFloatField
      FieldName = 'interes'
    end
    object BooleanField4: TBooleanField
      FieldName = 'activo'
    end
  end
  object TRespCalcInt: TsnTable
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
    Left = 1048
    Top = 172
    object TRespCalcIntoid_calc_int: TIntegerField
      FieldName = 'oid_calc_int'
    end
    object TRespCalcIntinteres: TCurrencyField
      FieldName = 'interes'
    end
  end
end
