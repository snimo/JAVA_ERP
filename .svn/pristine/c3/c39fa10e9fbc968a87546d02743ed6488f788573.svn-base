inherited FVisitas: TFVisitas
  Left = 78
  Top = 17
  Width = 778
  Height = 711
  Caption = 'Visitas'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 762
    Height = 673
    inherited PPie: TPanel
      Top = 652
      Width = 762
      inherited StatusBarABM: TStatusBar
        Left = 657
      end
      inherited StatusBar2: TStatusBar
        Width = 657
      end
    end
    inherited PMenu: TPanel
      Width = 762
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTVisitas
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTVisitas
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpVisitas
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpVisitas
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpVisitas
      end
      inherited Panel2: TPanel
        Left = 721
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTVisitas
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
      Width = 762
    end
    inherited PCabecera: TPanel
      Width = 762
      Height = 303
      object Label2: TLabel
        Left = 23
        Top = 64
        Width = 85
        Height = 13
        Caption = 'Apellido y Nombre'
      end
      object Label4: TLabel
        Left = 21
        Top = 34
        Width = 94
        Height = 13
        Caption = 'Tipo de Documento'
      end
      object Label1: TLabel
        Left = 191
        Top = 34
        Width = 23
        Height = 13
        Caption = 'Nro. '
      end
      object snLabel3: TsnLabel
        Left = 23
        Top = 97
        Width = 41
        Height = 13
        Caption = 'Empresa'
      end
      object FotoVisita: TsnImage
        Left = 421
        Top = 3
        Width = 236
        Height = 203
        Stretch = True
      end
      object LabelSacarFoto: TsnLabel
        Left = 422
        Top = 206
        Width = 66
        Height = 16
        Cursor = crHandPoint
        Caption = 'Sacar Foto'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlue
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsUnderline]
        ParentFont = False
      end
      object snLabel4: TsnLabel
        Left = 23
        Top = 148
        Width = 71
        Height = 13
        Caption = 'Nro. de Tarjeta'
      end
      object LabelAdjuntarFoto: TsnLabel
        Left = 500
        Top = 206
        Width = 79
        Height = 16
        Cursor = crHandPoint
        Caption = 'Adjuntar Foto'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlue
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsUnderline]
        ParentFont = False
      end
      object BotonAltaEmpresa: TsnLabel
        Left = 126
        Top = 125
        Width = 87
        Height = 13
        Cursor = crHandPoint
        Caption = '(Agregar Empresa)'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlue
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsUnderline]
        ParentFont = False
      end
      object LabelEliminarFoto: TsnLabel
        Left = 590
        Top = 206
        Width = 48
        Height = 16
        Cursor = crHandPoint
        Caption = 'Eliminar'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlue
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsUnderline]
        ParentFont = False
      end
      object snLabel10: TsnLabel
        Left = 24
        Top = 248
        Width = 72
        Height = 13
        Caption = 'Grupo de Visita'
      end
      object snLabel19: TsnLabel
        Left = 24
        Top = 280
        Width = 60
        Height = 13
        Caption = 'Motivo Visita'
      end
      object DBEDescripcion: TsnDBEdit
        Left = 123
        Top = 60
        DataBinding.DataField = 'ape_y_nom'
        DataBinding.DataSource = DSTVisitas
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 2
        Width = 269
      end
      object DBCodCliente: TsrnDBButtonEdit
        Left = 123
        Top = 29
        Hint = 'F4 Nuevo Cliente'
        DataBinding.DataField = 'cod_tipo_documento'
        DataBinding.DataSource = DSTVisitas
        Properties.Buttons = <
          item
            Default = True
            Kind = bkEllipsis
          end>
        Properties.CharCase = ecUpperCase
        Properties.ClickKey = 112
        TabOrder = 0
        Help = HelpTipoDocumento
        Width = 56
      end
      object snDBEdit5: TsnDBEdit
        Left = 219
        Top = 30
        DataBinding.DataField = 'nro_documento'
        DataBinding.DataSource = DSTVisitas
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 173
      end
      object snDBLookup1: TsnDBLookup
        Left = 123
        Top = 93
        DataBinding.DataField = 'oid_empresa'
        DataBinding.DataSource = DSTVisitas
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSEmrpesasCIP
        TabOrder = 3
        Width = 269
      end
      object srnDBButtonEdit3: TsrnDBButtonEdit
        Left = 123
        Top = 144
        DataBinding.DataField = 'nro_tarjeta'
        DataBinding.DataSource = DSTVisitas
        Properties.Buttons = <
          item
            Default = True
            Kind = bkEllipsis
          end>
        TabOrder = 4
        Help = HelpNroTarjVisNoAsig
        Width = 190
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 20
        Top = 184
        Caption = 'Controlar antipassback?'
        DataBinding.DataField = 'antipass_vis'
        DataBinding.DataSource = DSTVisitas
        TabOrder = 5
        Width = 149
      end
      object snDBCheckEdit2: TsnDBCheckEdit
        Left = 180
        Top = 184
        Caption = 'Ignorar pr'#243'ximo antipassback?'
        DataBinding.DataField = 'ignorar_prox_anti'
        DataBinding.DataSource = DSTVisitas
        TabOrder = 6
        Width = 173
      end
      object srnDBButtonEdit7: TsrnDBButtonEdit
        Left = 125
        Top = 246
        DataBinding.DataField = 'cod_grupo_visita'
        DataBinding.DataSource = DSTVisitas
        Properties.Buttons = <
          item
            Default = True
            Kind = bkEllipsis
          end>
        Properties.ClickKey = 112
        TabOrder = 7
        Help = HelpGrupoVisita
        Width = 121
      end
      object snDBEdit8: TsnDBEdit
        Left = 243
        Top = 246
        TabStop = False
        DataBinding.DataField = 'desc_grupo_visita'
        DataBinding.DataSource = DSTVisitas
        Properties.ReadOnly = True
        TabOrder = 8
        Width = 302
      end
      object srnDBButtonEdit9: TsrnDBButtonEdit
        Left = 125
        Top = 278
        DataBinding.DataField = 'cod_mot_visita'
        DataBinding.DataSource = DSTVisitas
        Properties.Buttons = <
          item
            Default = True
            Kind = bkEllipsis
          end>
        Properties.ClickKey = 112
        TabOrder = 9
        Help = HelpMotivoVisita
        Width = 121
      end
      object snDBEdit10: TsnDBEdit
        Left = 243
        Top = 278
        TabStop = False
        DataBinding.DataField = 'desc_mot_visita'
        DataBinding.DataSource = DSTVisitas
        Properties.ReadOnly = True
        TabOrder = 10
        Width = 302
      end
      object snDBCheckEdit4: TsnDBCheckEdit
        Left = 20
        Top = 214
        Caption = 'Liberar ingreso al Predio'
        DataBinding.DataField = 'lib_acc_al_predio'
        DataBinding.DataSource = DSTVisitas
        TabOrder = 11
        Width = 165
      end
    end
    inherited PCuerpo: TPanel
      Top = 355
      Width = 762
      Height = 297
      BorderWidth = 3
      object PageControlSN1: TPageControlSN
        Left = 3
        Top = 3
        Width = 756
        Height = 291
        ActivePage = TabSheet2
        Align = alClient
        TabOrder = 0
        object TabSheet2: TTabSheet
          Caption = 'Documentaci'#243'n'
          ImageIndex = 2
          object dxDBGridSN1: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 748
            Height = 263
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
        object TabSheet3: TTabSheet
          BorderWidth = 5
          Caption = 'Control de Acceso'
          ImageIndex = 2
          object snDBEdit3: TsnDBEdit
            Left = 291
            Top = 46
            TabStop = False
            DataBinding.DataField = 'desc_grupo_puerta_ingreso'
            DataBinding.DataSource = DSTVisitas
            Properties.ReadOnly = True
            TabOrder = 0
            Width = 302
          end
          object PageControlSN2: TPageControlSN
            Left = 0
            Top = 0
            Width = 738
            Height = 253
            ActivePage = TabSheet4
            Align = alClient
            TabOrder = 1
            object TabSheet4: TTabSheet
              Caption = 'Configuraci'#243'n'
              object snLabel8: TsnLabel
                Left = 24
                Top = 2
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
                Top = 24
                Width = 139
                Height = 13
                Caption = 'Acceso al Predio por puertas:'
              end
              object snLabel2: TsnLabel
                Left = 48
                Top = 48
                Width = 142
                Height = 13
                Caption = 'Egreso del Predio por puertas:'
              end
              object snLabel7: TsnLabel
                Left = 24
                Top = 74
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
                Top = 96
                Width = 37
                Height = 13
                Caption = 'Visita a:'
              end
              object snLabel6: TsnLabel
                Left = 48
                Top = 120
                Width = 69
                Height = 13
                Caption = 'Autoriza Visita:'
              end
              object snLabel14: TsnLabel
                Left = 24
                Top = 139
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
              object snLabel15: TsnLabel
                Left = 199
                Top = 163
                Width = 16
                Height = 13
                Caption = 'Del'
              end
              object snLabel16: TsnLabel
                Left = 351
                Top = 163
                Width = 8
                Height = 13
                Caption = 'al'
              end
              object snLabel17: TsnLabel
                Left = 24
                Top = 186
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
                Top = 208
                Width = 127
                Height = 13
                Caption = 'Categor'#237'a Accesos Interno'
              end
              object snDBEdit4: TsnDBEdit
                Left = 315
                Top = 46
                TabStop = False
                DataBinding.DataField = 'desc_grupo_puerta_egreso'
                DataBinding.DataSource = DSTVisitas
                Properties.ReadOnly = True
                TabOrder = 0
                Width = 302
              end
              object srnDBButtonEdit2: TsrnDBButtonEdit
                Left = 197
                Top = 46
                DataBinding.DataField = 'cod_grupo_puerta_egreso'
                DataBinding.DataSource = DSTVisitas
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
                Top = 22
                DataBinding.DataField = 'cod_grupo_puerta_ingreso'
                DataBinding.DataSource = DSTVisitas
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
                Top = 94
                DataBinding.DataField = 'cod_visita_a'
                DataBinding.DataSource = DSTVisitas
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
              object snDBEdit1: TsnDBEdit
                Left = 315
                Top = 94
                TabStop = False
                DataBinding.DataField = 'desc_visita_a'
                DataBinding.DataSource = DSTVisitas
                Properties.ReadOnly = True
                TabOrder = 4
                Width = 302
              end
              object snDBEdit2: TsnDBEdit
                Left = 315
                Top = 118
                TabStop = False
                DataBinding.DataField = 'desc_autoriza'
                DataBinding.DataSource = DSTVisitas
                Properties.ReadOnly = True
                TabOrder = 5
                Width = 302
              end
              object srnDBButtonEdit5: TsrnDBButtonEdit
                Left = 197
                Top = 118
                DataBinding.DataField = 'cod_autoriza'
                DataBinding.DataSource = DSTVisitas
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
                Top = 22
                TabStop = False
                DataBinding.DataField = 'desc_grupo_puerta_ingreso'
                DataBinding.DataSource = DSTVisitas
                Properties.ReadOnly = True
                TabOrder = 7
                Width = 302
              end
              object snDBCheckEdit3: TsnDBCheckEdit
                Left = 40
                Top = 160
                Caption = 'Aplicar Vigencia'
                DataBinding.DataField = 'aplic_vig'
                DataBinding.DataSource = DSTVisitas
                TabOrder = 8
                Width = 113
              end
              object snDBDateEdit1: TsnDBDateEdit
                Left = 221
                Top = 160
                DataBinding.DataField = 'fec_desde_vig'
                DataBinding.DataSource = DSTVisitas
                TabOrder = 9
                ReadOnlyAlways = False
                Width = 121
              end
              object snDBDateEdit2: TsnDBDateEdit
                Left = 376
                Top = 160
                DataBinding.DataField = 'fec_hasta_vig'
                DataBinding.DataSource = DSTVisitas
                TabOrder = 10
                ReadOnlyAlways = False
                Width = 121
              end
              object srnDBButtonEdit8: TsrnDBButtonEdit
                Left = 197
                Top = 206
                DataBinding.DataField = 'cod_categ_acc_int'
                DataBinding.DataSource = DSTVisitas
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
                Top = 206
                TabStop = False
                DataBinding.DataField = 'desc_categ_acc_int'
                DataBinding.DataSource = DSTVisitas
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
                Width = 730
                Height = 184
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
                Width = 730
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
                  DataBinding.DataField = 'cod_planif_sem'
                  DataBinding.DataSource = DSTVisitas
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
                  DataBinding.DataField = 'desc_planif_sem'
                  DataBinding.DataSource = DSTVisitas
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
                Width = 730
                Height = 248
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
                Width = 730
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
        object TabSheet1: TTabSheet
          Caption = 'Clasificadores'
          object dxDBGridSN4: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 748
            Height = 296
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
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerVisitas'
    OperGrabarObjeto = 'SaveVisitas'
    CargaDataSets = <
      item
        DataSet = TVisitas
        TableName = 'TVisitas'
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
        DataSet = TTiposTarjetas
        TableName = 'TTiposTarjetas'
      end
      item
        DataSet = TDocumentacionVisita
        TableName = 'TDocumentacionVisita'
      end
      item
        DataSet = TTarjetaVisita
        TableName = 'TTarjetaVisita'
      end
      item
        DataSet = TVisitaPorDocu
        TableName = 'TVisitaPorDocu'
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
        DataSet = TVisitas
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TVisitas
    DataSetDet1 = TValoresClasificadores
    DataSetDet2 = TDocumentacionVisita
    DataSetDet3 = TFechaRota
    DataSetDet4 = TMotAccesosIntermedios
    ControlFocoAlta = DBCodCliente
    ControlFocoModif = DBCodCliente
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TVisitas: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_visita'
        DataType = ftInteger
      end
      item
        Name = 'nro_legajo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'oid_grupo_puerta_egreso'
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
        Name = 'oid_tipo_documento'
        DataType = ftInteger
      end
      item
        Name = 'cod_tipo_documento'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_tipo_documento'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'nro_documento'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'oid_grupo_puerta_ingreso'
        DataType = ftInteger
      end
      item
        Name = 'oid_empresa'
        DataType = ftInteger
      end
      item
        Name = 'ape_y_nom'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_tarjeta'
        DataType = ftInteger
      end
      item
        Name = 'nro_tarjeta'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'oid_visita_a'
        DataType = ftInteger
      end
      item
        Name = 'cod_visita_a'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_visita_a'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_autoriza'
        DataType = ftInteger
      end
      item
        Name = 'cod_autoriza'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_autoriza'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'antipass_vis'
        DataType = ftBoolean
      end
      item
        Name = 'ignorar_prox_anti'
        DataType = ftBoolean
      end
      item
        Name = 'oid_planif_sem'
        DataType = ftInteger
      end
      item
        Name = 'cod_planif_sem'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_planif_sem'
        DataType = ftString
        Size = 100
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
    Left = 584
    Top = 107
    object TVisitasoid_visita: TIntegerField
      FieldName = 'oid_visita'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TVisitasnro_legajo: TStringField
      FieldName = 'nro_legajo'
      Size = 50
    end
    object TVisitasactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TVisitasoid_grupo_puerta_egreso: TIntegerField
      FieldName = 'oid_grupo_puerta_egreso'
    end
    object TVisitascod_grupo_puerta_ingreso: TStringField
      FieldName = 'cod_grupo_puerta_ingreso'
      Size = 50
    end
    object TVisitasdesc_grupo_puerta_ingreso: TStringField
      FieldName = 'desc_grupo_puerta_ingreso'
      Size = 100
    end
    object TVisitasoid_grupo_puerta_ingreso: TIntegerField
      FieldName = 'oid_grupo_puerta_ingreso'
    end
    object TVisitascod_grupo_puerta_egreso: TStringField
      FieldName = 'cod_grupo_puerta_egreso'
      Size = 50
    end
    object TVisitasdesc_grupo_puerta_egreso: TStringField
      FieldName = 'desc_grupo_puerta_egreso'
      Size = 100
    end
    object TVisitasoid_tipo_documento: TIntegerField
      FieldName = 'oid_tipo_documento'
    end
    object TVisitascod_tipo_documento: TStringField
      FieldName = 'cod_tipo_documento'
      Size = 50
    end
    object TVisitasdesc_tipo_documento: TStringField
      FieldName = 'desc_tipo_documento'
      Size = 100
    end
    object TVisitasnro_documento: TStringField
      FieldName = 'nro_documento'
      Size = 50
    end
    object TVisitasoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TVisitasape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TVisitasoid_tarjeta: TIntegerField
      FieldName = 'oid_tarjeta'
    end
    object TVisitasnro_tarjeta: TStringField
      FieldName = 'nro_tarjeta'
      Size = 50
    end
    object TVisitasoid_visita_a: TIntegerField
      FieldName = 'oid_visita_a'
    end
    object TVisitascod_visita_a: TStringField
      FieldName = 'cod_visita_a'
      Size = 50
    end
    object TVisitasdesc_visita_a: TStringField
      FieldName = 'desc_visita_a'
      Size = 100
    end
    object TVisitasoid_autoriza: TIntegerField
      FieldName = 'oid_autoriza'
    end
    object TVisitascod_autoriza: TStringField
      FieldName = 'cod_autoriza'
      Size = 50
    end
    object TVisitasdesc_autoriza: TStringField
      FieldName = 'desc_autoriza'
      Size = 100
    end
    object TVisitasantipass_vis: TBooleanField
      FieldName = 'antipass_vis'
    end
    object TVisitasignorar_prox_anti: TBooleanField
      FieldName = 'ignorar_prox_anti'
    end
    object TVisitasoid_planif_sem: TIntegerField
      FieldName = 'oid_planif_sem'
    end
    object TVisitascod_planif_sem: TStringField
      FieldName = 'cod_planif_sem'
      Size = 50
    end
    object TVisitasdesc_planif_sem: TStringField
      FieldName = 'desc_planif_sem'
      Size = 100
    end
    object TVisitasoid_grupo_visita: TIntegerField
      FieldName = 'oid_grupo_visita'
    end
    object TVisitascod_grupo_visita: TStringField
      FieldName = 'cod_grupo_visita'
      Size = 50
    end
    object TVisitasdesc_grupo_visita: TStringField
      FieldName = 'desc_grupo_visita'
      Size = 100
    end
    object TVisitasaplic_vig: TBooleanField
      FieldName = 'aplic_vig'
    end
    object TVisitasfec_desde_vig: TDateField
      FieldName = 'fec_desde_vig'
    end
    object TVisitasfec_hasta_vig: TDateField
      FieldName = 'fec_hasta_vig'
    end
    object TVisitasoid_categ_acc_int: TIntegerField
      FieldName = 'oid_categ_acc_int'
    end
    object TVisitascod_categ_acc_int: TStringField
      FieldName = 'cod_categ_acc_int'
      Size = 50
    end
    object TVisitasdesc_categ_acc_int: TStringField
      FieldName = 'desc_categ_acc_int'
      Size = 100
    end
    object TVisitasoid_mot_visita: TIntegerField
      FieldName = 'oid_mot_visita'
    end
    object TVisitascod_mot_visita: TStringField
      FieldName = 'cod_mot_visita'
      Size = 50
    end
    object TVisitasdesc_mot_visita: TStringField
      FieldName = 'desc_mot_visita'
      Size = 100
    end
    object TVisitaslib_acc_al_predio: TBooleanField
      FieldName = 'lib_acc_al_predio'
    end
  end
  object DSTVisitas: TDataSource [4]
    DataSet = TVisitas
    Left = 616
    Top = 107
  end
  inherited TOidObjSave: TsnTable
    Left = 488
    Top = 64
  end
  inherited TOpcHabPrograma: TsnTable
    Left = 528
    Top = 64
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 352
    Top = 0
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
        TableName = 'TVisitas'
        FieldName = 'cod_grupo_puerta_egreso'
        Source.Strings = (
          'begin'
          '  ValidadorGrupoPuertas1.Value := Sender.AsString;'
          '  ValidadorGrupoPuertas1.Validar();'
          'end.')
      end
      item
        TableName = 'TVisitas'
        FieldName = 'cod_grupo_puerta_ingreso'
        Source.Strings = (
          'begin'
          '  ValidadorGrupoPuertas.Value := Sender.AsString;'
          '  ValidadorGrupoPuertas.Validar();'
          'end.'
          '')
      end
      item
        TableName = 'TVisitas'
        FieldName = 'cod_tipo_documento'
        Source.Strings = (
          'begin'
          ''
          '  ValidadorTipoDocumento.Value := Sender.AsString;'
          '  ValidadorTipoDocumento.Validar;'
          ''
          '  ValidarSiYaExisteVisita();'
          ''
          'end.')
      end
      item
        TableName = 'TVisitas'
        FieldName = 'nro_tarjeta'
        Source.Strings = (
          'begin'
          '  ValidarNroTarjeta(Sender.AsString);'
          'end.')
      end
      item
        TableName = 'TVisitas'
        FieldName = 'nro_documento'
        Source.Strings = (
          'begin'
          '  ValidarSiYaExisteVisita();'
          'end.')
      end
      item
        TableName = 'TVisitas'
        FieldName = 'cod_visita_a'
        Source.Strings = (
          'begin'
          '  ValidadorVisitaA.Value := Sender.AsString;'
          '  ValidadorVisitaA.Validar();'
          'end.')
      end
      item
        TableName = 'TVisitas'
        FieldName = 'cod_autoriza'
        Source.Strings = (
          'begin'
          '  ValidadorAutoriza.Value := Sender.AsString;'
          '  ValidadorAutoriza.Validar();'
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
        TableName = 'TVisitas'
        FieldName = 'cod_planif_sem'
        Source.Strings = (
          'begin'
          '  ValidadorPlanificacionSemanal.Value := Sender.AsString;'
          '  ValidadorPlanificacionSemanal.Validar();'
          'end.')
      end
      item
        TableName = 'TVisitas'
        FieldName = 'cod_grupo_visita'
        Source.Strings = (
          'begin'
          '  ValidadorGrupoVisita.Value := Sender.AsString;'
          '  ValidadorGrupoVisita.Validar();'
          'end.')
      end
      item
        TableName = 'TVisitas'
        FieldName = 'cod_categ_acc_int'
        Source.Strings = (
          'begin'
          '  ValidadorCategAccesoInt.Value := Sender.AsString;'
          '  ValidadorCategAccesoInt.Validar();'
          'end.')
      end
      item
        TableName = 'TVisitas'
        FieldName = 'cod_mot_visita'
        Source.Strings = (
          'begin'
          '  ValidadorMotivoVisita.Value := Sender.AsString;'
          '  ValidadorMotivoVisita.Validar();'
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
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          
            '  DataSet.FieldName('#39'oid_visita'#39').AsInteger :=  TVisitas.FieldNa' +
            'me('#39'oid_visita'#39').AsInteger;'
          'end.')
      end
      item
        TableName = 'TFechaRota'
        Source.Strings = (
          'begin'
          
            ' DataSet.FieldName('#39'oid_visita'#39').AsInteger := TVisitas.FieldName' +
            '('#39'oid_visita'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  SeleccionFile.setTipoImagenJPG();'
          '  TEmpresasCIP.loadFromHelp('#39'HelpEmpresasCIP'#39');'
          '  TTipoDocumentacion.loadFromHelp('#39'HelpTipoDodocumentacion'#39');'
          '  TMotAccInter.loadFromHelp('#39'HelpMotAccInter'#39');'
          '  CargarPresentado();'
          'end.')
      end>
    OnAfterTraerObjeto = <
      item
        Source.Strings = (
          'begin'
          '  TraerImagenVisita();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure ValidarSiYaExisteVisita();'
          'begin'
          '    if ( (TVisitas.FieldName('#39'oid_visita'#39').AsInteger<0) and'
          
            '     (Trim(TVisitas.FieldName('#39'oid_tipo_documento'#39').AsString)<>'#39 +
            #39') and'
          '     (Trim(TVisitas.FieldName('#39'nro_documento'#39').AsString)<>'#39#39'))'
          '     then begin'
          '             operacion.InicioOperacion();'
          '             operacion.setOper('#39'TraerVisitaTipoDocyNro'#39');'
          
            '             operacion.AddAtribute('#39'oid_tipo_docu'#39', TVisitas.Fie' +
            'ldName('#39'oid_tipo_documento'#39').AsString);'
          
            '             operacion.AddAtribute('#39'nro_documento'#39', TVisitas.Fie' +
            'ldName('#39'nro_documento'#39').AsString);'
          '             operacion.execute();'
          '             if (not TVisitaPorDocu.IsEmpty())'
          
            '                then raiseException(erCustomError,'#39'Visita ya ing' +
            'resada.'#39'); '
          '             end;'
          'end;'
          ''
          'procedure TraerImagenVisita();'
          'var'
          '  mensajeError : string;'
          '  nomTempFile : string;'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'DownLoadFotoVisitaCIP'#39');  '
          
            '  nomTempFile := operacion.DownLoadFile(TVisitas.FieldName('#39'oid_' +
            'visita'#39').AsString, mensajeError);'
          '  FotoVisita.LoadFromFile(nomTempFile);'
          'end;'
          ''
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
          'procedure MostrarHelpValoresClasificador();'
          'begin'
          
            '   HelpValoresClasificador.NickName           :=  TValoresClasif' +
            'icadores.FieldName('#39'nickname'#39').AsString;'
          
            '   HelpValoresClasificador.NroClasificador    :=  TValoresClasif' +
            'icadores.FieldName('#39'nro_clasif'#39').AsInteger;'
          '   HelpValoresClasificador.Mostrar();'
          'end;'
          ''
          ''
          'procedure inicializarClasif();'
          'begin'
          '  TClasificadorEntidad.First;'
          '  while (not TClasificadorEntidad.EOF) do'
          '    begin'
          ''
          '    TValoresClasificadores.AppendRecord;'
          '    TValoresClasificadores.FieldName('#39'oid_visita'#39').AsInteger :='
          '       TVisitas.FieldName('#39'oid_visita'#39').AsInteger;'
          
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
          '  operacion.setOper('#39'TraerVisitas'#39');'
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
          'procedure ValidarNroTarjeta(NroTarjeta : string);'
          'begin'
          ''
          '  if (Trim(NroTarjeta)='#39#39')'
          '     then begin'
          '          TVisitas.EditRecord;'
          '          TVisitas.FieldName('#39'oid_tarjeta'#39').Clear; '
          '          exit;'
          '          end;  '
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'ValitarNroTarjetaVisita'#39');'
          '  operacion.AddAtribute('#39'nro_tarjeta'#39',NroTarjeta);'
          '  operacion.execute();'
          ''
          '  if (TTarjetaVisita.IsEmpty())'
          
            '     then raiseException(erCustomError,'#39'Nro. de Tarjeta Inexiste' +
            'nte.'#39');'
          ''
          '  if (TTarjetaVisita.FieldName('#39'activo'#39').AsBoolean=false)'
          
            '     then mensaje.information('#39'ATENCION: La tarjeta seleccionada' +
            ' se encuentra INACTIVA'#39');'
          ''
          '  TVisitas.EditRecord;'
          
            '  TVisitas.FieldName('#39'oid_tarjeta'#39').AsInteger := TTarjetaVisita.' +
            'FieldName('#39'oid_tarjeta'#39').AsInteger;'
          ''
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
            'TVisitas.FieldName('#39'oid_visita'#39').AsInteger;'
          
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
          'end;')
      end>
    OnAfterNuevo = <
      item
        Source.Strings = (
          'begin'
          '  inicializarValoresClasif();'
          '  fotoVisita.BorrarImagen();'
          '  AltaMotivosEntInter();'
          'end.')
      end>
    OnAfterGrabar = <
      item
        Source.Strings = (
          'var'
          '  mensajeError : string;'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'UploadImageFotoVisita'#39');'
          '  operacion.UploadFile('
          '        FotoVisita.getDataStream(),'
          '        TOidObjSave.FieldName('#39'oid'#39').AsString,'
          '        '#39#39','#39#39',true,mensajeError);'
          'end.'
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'LabelSacarFoto'
        Source.Strings = (
          'begin'
          
            '    if ((DriverABM.isModificar=false) and (DriverABM.isNuevo=fal' +
            'se)) then exit;'
          '  FormSacarFoto.Mostrar(true);'
          
            '  FotoVisita.LoadFromField(FormSacarFoto.getDataSet('#39'TInput'#39').Fi' +
            'eldName('#39'foto'#39'));'
          'end.')
      end
      item
        ButtonName = 'LabelAdjuntarFoto'
        Source.Strings = (
          'begin'
          
            '  if ((DriverABM.isModificar=false) and (DriverABM.isNuevo=false' +
            ')) then exit;'
          '  if (SeleccionFile.execute())'
          
            '      then FotoVisita.LoadFromFile(SeleccionFile.getFileName());' +
            ' '
          'end.')
      end
      item
        ButtonName = 'BotonAltaEmpresa'
        Source.Strings = (
          'begin'
          
            '   if ((DriverABM.isModificar=false) and (DriverABM.isNuevo=fals' +
            'e)) then exit;'
          '  formAltaEmpresaCIP.Mostrar(true);'
          
            '  if (formAltaEmpresaCIP.getDataSet('#39'TInput'#39').FieldName('#39'oid_emp' +
            'resa'#39').AsInteger>0)'
          '      then begin'
          ''
          '              TEmpresasCIP.First;'
          ''
          
            '              if (not (TEmpresasCIP.Locate('#39'oid'#39',formAltaEmpresa' +
            'CIP.getDataSet('#39'TInput'#39').FieldName('#39'oid_empresa'#39').AsInteger,[]))' +
            ')'
          '                 then begin'
          '                         TEmpresasCIP.AppendRecord;'
          
            '                         TEmpresasCIP.FieldName('#39'oid'#39').AsInteger' +
            ' := formAltaEmpresaCIP.getDataSet('#39'TInput'#39').FieldName('#39'oid_empre' +
            'sa'#39').AsInteger;'
          
            '                         TEmpresasCIP.FieldName('#39'codigo'#39').AsStri' +
            'ng := '#39#39';'
          
            '                         TEmpresasCIP.FieldName('#39'descripcion'#39').A' +
            'sString := formAltaEmpresaCIP.getDataSet('#39'TInput'#39').FieldName('#39'em' +
            'presa'#39').AsString;'
          '                         TEmpresasCIP.PostRecord;  '
          '                         end;               '
          ''
          
            '              TVisitas.FieldName('#39'oid_empresa'#39').AsInteger := for' +
            'mAltaEmpresaCIP.getDataSet('#39'TInput'#39').FieldName('#39'oid_empresa'#39').As' +
            'Integer;'
          ''
          '              end;'
          '  '
          'end.')
      end
      item
        ButtonName = 'LabelEliminarFoto'
        Source.Strings = (
          'begin'
          
            '   if ((DriverABM.isModificar=false) and (DriverABM.isNuevo=fals' +
            'e)) then exit; '
          '  if (mensaje.question('#39'Confirma Eliminaci'#243'n de foto.?'#39'))'
          '     then FotoVisita.BorrarImagen();'
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
      end>
    Left = 432
    Top = 3
  end
  inherited SaveArchivo: TSaveDialog
    Left = 408
    Top = 112
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 688
    Top = 224
  end
  inherited PopUp: TsnPopUp
    Left = 393
    Top = 0
  end
  inherited ImageListGruposPopUp: TImageList
    Left = 176
    Top = 203
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 64
    Top = 323
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
    Left = 50
    Top = 28
  end
  object ValidadorVisita: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.Visita'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Visita Existente'
    NroQuery = 0
    Cache = False
    Left = 192
    Top = 3
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
        Name = 'oid_visita'
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
    IndexFieldNames = 'oid_visita'
    IndexDefs = <
      item
        Name = 'TValoresClasificadoresIndex1'
        Fields = 'oid_visita'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_visita'
    MasterSource = DSTVisitas
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 374
    Top = 212
    object TValoresClasificadoresoid_valor_clasif: TIntegerField
      FieldName = 'oid_valor_clasif'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TValoresClasificadoresoid_visita: TIntegerField
      FieldName = 'oid_visita'
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
    Left = 406
    Top = 212
  end
  object HelpValoresClasificador: THelpValoresClasificador
    AsignarCampoCodigo = TValoresClasificadorescod_valor
    NroClasificador = 0
    Left = 112
    Top = 185
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
    Left = 653
    Top = 224
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
    Left = 478
    Top = 164
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
    Left = 648
    Top = 359
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
    Left = 680
    Top = 363
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
        AsignarACampo = TVisitascod_grupo_puerta_ingreso
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
    Left = 490
    Top = 303
  end
  object ValidadorGrupoPuertas: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Grupo de Puerta Inexistente'
    CampoOID = TVisitasoid_grupo_puerta_ingreso
    CampoDescripcion = TVisitasdesc_grupo_puerta_ingreso
    NroQuery = 0
    Cache = True
    Left = 526
    Top = 303
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
        AsignarACampo = TVisitascod_grupo_puerta_egreso
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
    Left = 370
    Top = 324
  end
  object ValidadorGrupoPuertas1: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Grupo de Puerta Inexistente'
    CampoOID = TVisitasoid_grupo_puerta_egreso
    CampoDescripcion = TVisitasdesc_grupo_puerta_egreso
    NroQuery = 0
    Cache = True
    Left = 406
    Top = 324
  end
  object HelpTipoDocumento: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 've.TipoDocumento'
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
        AsignarACampo = TVisitascod_tipo_documento
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
    Titulo = 'Tipos de Documentos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 34
    Top = 463
  end
  object ValidadorTipoDocumento: TValidador
    Operacion = Operacion
    NickNameObjLog = 've.TipoDocumento'
    MensajeException = 'C'#243'digo de Tipo de Documento Inexistente'
    CampoOID = TVisitasoid_tipo_documento
    CampoDescripcion = TVisitasdesc_tipo_documento
    NroQuery = 0
    Cache = True
    Left = 70
    Top = 463
  end
  object HelpEmpresasCIP: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.EmpresaCIP'
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
    Titulo = 'Empresas CIP'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 210
    Top = 323
  end
  object TEmpresasCIP: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexFieldNames = 'descripcion'
    IndexDefs = <
      item
        Name = 'TEmpresasCIPIndex1'
        Fields = 'descripcion'
      end>
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
    Left = 240
    Top = 329
    object TEmpresasCIPoid: TIntegerField
      FieldName = 'oid'
    end
    object TEmpresasCIPcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TEmpresasCIPdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 255
    end
  end
  object DSEmrpesasCIP: TDataSource
    DataSet = TEmpresasCIP
    Left = 288
    Top = 345
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
      end>
    IndexFieldNames = 'oid_visita'
    IndexDefs = <
      item
        Name = 'TDocumentacionVisitaIndex1'
        Fields = 'oid_visita'
        Options = [ixDescending]
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_visita'
    MasterSource = DSTVisitas
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 544
    Top = 148
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
  end
  object DSDocumentacionVisita: TDataSource
    DataSet = TDocumentacionVisita
    Left = 576
    Top = 148
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
        AsignarACampo = TVisitascod_grupo_puerta_ingreso
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
    Left = 186
    Top = 459
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
    Left = 219
    Top = 459
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
    Left = 251
    Top = 460
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
  object FormSacarFoto: TFormulario
    Nombre = 'TFSacarFotoVisita'
    CreateAlwaysANewForm = False
    Left = 112
    Top = 467
  end
  object TTarjetaVisita: TsnTable
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
    Left = 383
    Top = 482
    object TTarjetaVisitaoid_tarjeta: TIntegerField
      FieldName = 'oid_tarjeta'
    end
    object TTarjetaVisitanro_tarjeta: TStringField
      FieldName = 'nro_tarjeta'
    end
    object TTarjetaVisitaactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object TVisitaPorDocu: TsnTable
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
    Left = 568
    Top = 362
    object TVisitaPorDocuoid_visita: TIntegerField
      FieldName = 'oid_visita'
    end
    object TVisitaPorDocuape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TVisitaPorDocuoid_tipo_docu: TIntegerField
      FieldName = 'oid_tipo_docu'
    end
    object TVisitaPorDocunro_docu: TStringField
      FieldName = 'nro_docu'
      Size = 50
    end
    object TVisitaPorDocuactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object SeleccionFile: TSeleccionFile
    Left = 505
    Top = 422
  end
  object formAltaEmpresaCIP: TFormulario
    AutoLiberar = True
    Nombre = 'TFAltaEmpresaCIP'
    CreateAlwaysANewForm = True
    Left = 490
    Top = 212
  end
  object HelpNroTarjVisNoAsig: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.TarjetaCIP'
    NroHelp = 102
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
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = True
        AsignarACampo = TVisitasnro_tarjeta
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
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
    Titulo = 'Tarjetas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 370
    Top = 272
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
        AsignarACampo = TVisitascod_visita_a
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
    Left = 90
    Top = 513
  end
  object ValidadorVisitaA: TValidador
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
    MensajeException = 'C'#243'digo de Legajo Inexistente'
    CampoOID = TVisitasoid_visita_a
    CampoDescripcion = TVisitasdesc_visita_a
    NroQuery = 0
    Cache = True
    Left = 126
    Top = 513
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
        AsignarACampo = TVisitascod_autoriza
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
    Left = 18
    Top = 513
  end
  object ValidadorAutoriza: TValidador
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
    MensajeException = 'C'#243'digo de Legajo Inexistente'
    CampoOID = TVisitasoid_autoriza
    CampoDescripcion = TVisitasdesc_autoriza
    NroQuery = 0
    Cache = True
    Left = 54
    Top = 513
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
      end>
    IndexFieldNames = 'oid_visita'
    IndexDefs = <
      item
        Name = 'TFechaRotaIndex1'
        Fields = 'oid_visita'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_visita'
    MasterSource = DSTVisitas
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 638
    Top = 152
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
  end
  object DSTFechaRota: TDataSource
    DataSet = TFechaRota
    Left = 672
    Top = 148
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
    Left = 254
    Top = 522
  end
  object ValidadorRota: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.Rota'
    MensajeException = 'C'#243'digo de Rota Inexistente'
    CampoOID = TFechaRotaoid_rota
    CampoDescripcion = TFechaRotadesc_rota
    NroQuery = 0
    Cache = True
    Left = 290
    Top = 522
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
        AsignarACampo = TVisitascod_planif_sem
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
    Left = 450
    Top = 323
  end
  object ValidadorPlanificacionSemanal: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.PermisoSemanalCIP'
    MensajeException = 'C'#243'digo de Planificaci'#243'n Inexistente'
    CampoOID = TVisitasoid_planif_sem
    CampoDescripcion = TVisitasdesc_planif_sem
    NroQuery = 0
    Cache = True
    Left = 486
    Top = 323
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
      end>
    IndexFieldNames = 'oid_visita'
    IndexDefs = <
      item
        Name = 'TMotAccesosIntermediosIndex1'
        Fields = 'oid_visita'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterSource = DSTVisitas
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 254
    Top = 562
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
  end
  object DSTMotAccesosIntermedios: TDataSource
    DataSet = TMotAccesosIntermedios
    Left = 286
    Top = 562
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
    Left = 96
    Top = 423
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
    Left = 126
    Top = 424
  end
  object HelpGrupoVisita: TsnHelp
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
        AsignarACampo = TVisitascod_grupo_visita
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
    Titulo = 'Grupos de Visitas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 450
    Top = 364
  end
  object ValidadorGrupoVisita: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoVisita'
    MensajeException = 'C'#243'digo de Grupo de Visita Inexistente'
    CampoOID = TVisitasoid_grupo_visita
    CampoDescripcion = TVisitasdesc_grupo_visita
    NroQuery = 0
    Cache = True
    Left = 486
    Top = 364
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
        AsignarACampo = TVisitascod_categ_acc_int
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
    Left = 382
    Top = 538
  end
  object ValidadorCategAccesoInt: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.CategAccesoCIP'
    MensajeException = 'C'#243'digo de Categor'#237'a Inexistente'
    CampoOID = TVisitasoid_categ_acc_int
    CampoDescripcion = TVisitasdesc_categ_acc_int
    NroQuery = 0
    Cache = True
    Left = 418
    Top = 538
  end
  object HelpMotivoVisita: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.MotivoVisita'
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
        AsignarACampo = TVisitascod_mot_visita
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
    Titulo = 'Motivos Visitas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 370
    Top = 400
  end
  object ValidadorMotivoVisita: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.MotivoVisita'
    MensajeException = 'C'#243'digo de Motivo Inexistente'
    CampoOID = TVisitasoid_mot_visita
    CampoDescripcion = TVisitasdesc_mot_visita
    NroQuery = 0
    Cache = True
    Left = 406
    Top = 400
  end
end
