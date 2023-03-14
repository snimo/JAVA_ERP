inherited FTarjetaCIP: TFTarjetaCIP
  Left = 47
  Top = 192
  Width = 856
  Height = 728
  Caption = 'Tarjetas'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 840
    Height = 690
    inherited PPie: TPanel
      Top = 669
      Width = 840
      inherited StatusBarABM: TStatusBar
        Left = 735
      end
      inherited StatusBar2: TStatusBar
        Width = 735
      end
    end
    inherited PMenu: TPanel
      Width = 840
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = dsTTarjetaCIP
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = dsTTarjetaCIP
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpTarjetas
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpTarjetas
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpTarjetas
      end
      inherited Panel2: TPanel
        Left = 799
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = dsTTarjetaCIP
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
      Width = 840
    end
    inherited PCabecera: TPanel
      Width = 840
      Height = 123
      object Label1: TLabel
        Left = 56
        Top = 37
        Width = 72
        Height = 13
        Caption = 'Tipo de Tarjeta'
      end
      object Label2: TLabel
        Left = 56
        Top = 67
        Width = 71
        Height = 13
        Caption = 'Nro. de Tarjeta'
      end
      object Label11: TLabel
        Left = 24
        Top = 6
        Width = 175
        Height = 13
        Caption = 'Datos principales de la Tarjeta'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = 8404992
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold, fsUnderline]
        ParentFont = False
      end
      object Label3: TLabel
        Left = 56
        Top = 98
        Width = 65
        Height = 13
        Caption = 'Grupo Tarjeta'
      end
      object snDBLookup1: TsnDBLookup
        Left = 136
        Top = 33
        DataBinding.DataField = 'tipo_tarjeta'
        DataBinding.DataSource = dsTTarjetaCIP
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposTarjetas
        TabOrder = 0
        Width = 145
      end
      object snDBEdit1: TsnDBEdit
        Left = 136
        Top = 63
        DataBinding.DataField = 'nro_tarjeta'
        DataBinding.DataSource = dsTTarjetaCIP
        Properties.MaxLength = 50
        TabOrder = 1
        Width = 169
      end
      object snDBCheckEdit2: TsnDBCheckEdit
        Left = 332
        Top = 62
        TabStop = False
        Caption = 'Tarjeta Asignada'
        DataBinding.DataField = 'asignada'
        DataBinding.DataSource = dsTTarjetaCIP
        Properties.ReadOnly = True
        Properties.UseAlignmentWhenInplace = True
        TabOrder = 2
        Width = 109
      end
      object snDBLookup2: TsnDBLookup
        Left = 136
        Top = 94
        DataBinding.DataField = 'oid_grupo_tar'
        DataBinding.DataSource = dsTTarjetaCIP
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = dsGruposTarjetas
        TabOrder = 3
        Width = 185
      end
      object snDBCheckEdit3: TsnDBCheckEdit
        Left = 332
        Top = 94
        Caption = 'Tarjeta habilitada para Visitas'
        DataBinding.DataField = 'visita'
        DataBinding.DataSource = dsTTarjetaCIP
        TabOrder = 4
        Width = 172
      end
      object snDBEdit7: TsnDBEdit
        Left = 440
        Top = 62
        DataBinding.DataField = 'tar_asig_a'
        DataBinding.DataSource = dsTTarjetaCIP
        ParentFont = False
        Style.Color = clWindow
        Style.Edges = []
        Style.Font.Charset = DEFAULT_CHARSET
        Style.Font.Color = clNavy
        Style.Font.Height = -11
        Style.Font.Name = 'MS Sans Serif'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 5
        Width = 361
      end
    end
    inherited PCuerpo: TPanel
      Top = 175
      Width = 840
      Height = 494
      BorderWidth = 5
      object PageControlSN1: TPageControlSN
        Left = 5
        Top = 5
        Width = 830
        Height = 484
        ActivePage = TabSheet2
        Align = alClient
        TabOrder = 0
        object TabSheet2: TTabSheet
          Caption = 'Visitas'
          ImageIndex = 1
          object Panel1: TPanel
            Left = 0
            Top = 0
            Width = 822
            Height = 171
            Align = alTop
            Color = clWindow
            TabOrder = 0
            object Label13: TLabel
              Left = 24
              Top = 7
              Width = 241
              Height = 13
              Caption = 'Definici'#243'n de Puertas de Acceso al Predio'
              Font.Charset = DEFAULT_CHARSET
              Font.Color = 8404992
              Font.Height = -11
              Font.Name = 'MS Sans Serif'
              Font.Style = [fsBold, fsUnderline]
              ParentFont = False
            end
            object snLabel1: TsnLabel
              Left = 64
              Top = 32
              Width = 133
              Height = 13
              Caption = 'Puertas de acceso al Predio'
            end
            object snLabel2: TsnLabel
              Left = 64
              Top = 93
              Width = 136
              Height = 13
              Caption = 'Puertas de egreso del Predio'
            end
            object Label14: TLabel
              Left = 24
              Top = 120
              Width = 178
              Height = 13
              Caption = 'Definici'#243'n de Accesos Internos'
              Font.Charset = DEFAULT_CHARSET
              Font.Color = 8404992
              Font.Height = -11
              Font.Name = 'MS Sans Serif'
              Font.Style = [fsBold, fsUnderline]
              ParentFont = False
            end
            object snLabel3: TsnLabel
              Left = 64
              Top = 144
              Width = 106
              Height = 13
              Caption = 'Categor'#237'a de Accesos'
            end
            object snLabel6: TsnLabel
              Left = 64
              Top = 61
              Width = 64
              Height = 13
              Caption = 'Tipo de Visita'
            end
            object srnDBButtonEdit1: TsrnDBButtonEdit
              Left = 205
              Top = 30
              DataBinding.DataField = 'cod_gru_p_ing_vi'
              DataBinding.DataSource = dsTTarjetaCIP
              Properties.Buttons = <
                item
                  Default = True
                  Kind = bkEllipsis
                end>
              Properties.ClickKey = 112
              TabOrder = 0
              Help = HelpGrupoPuertas
              Width = 121
            end
            object snDBEdit3: TsnDBEdit
              Left = 323
              Top = 30
              TabStop = False
              DataBinding.DataField = 'desc_gru_p_ing_vi'
              DataBinding.DataSource = dsTTarjetaCIP
              Properties.ReadOnly = True
              TabOrder = 2
              Width = 382
            end
            object srnDBButtonEdit2: TsrnDBButtonEdit
              Left = 205
              Top = 91
              DataBinding.DataField = 'cod_gru_p_egr_vi'
              DataBinding.DataSource = dsTTarjetaCIP
              Properties.Buttons = <
                item
                  Default = True
                  Kind = bkEllipsis
                end>
              Properties.ClickKey = 112
              TabOrder = 3
              Help = HelpGrupoPuertas1
              Width = 121
            end
            object snDBEdit4: TsnDBEdit
              Left = 323
              Top = 91
              TabStop = False
              DataBinding.DataField = 'desc_gru_p_egr_vi'
              DataBinding.DataSource = dsTTarjetaCIP
              Properties.ReadOnly = True
              TabOrder = 4
              Width = 382
            end
            object srnDBButtonEdit3: TsrnDBButtonEdit
              Left = 205
              Top = 142
              DataBinding.DataField = 'cod_categ_acc_vis'
              DataBinding.DataSource = dsTTarjetaCIP
              Properties.Buttons = <
                item
                  Default = True
                  Kind = bkEllipsis
                end>
              Properties.ClickKey = 112
              TabOrder = 5
              Help = HelpCategAcceso
              Width = 121
            end
            object snDBEdit2: TsnDBEdit
              Left = 323
              Top = 142
              TabStop = False
              DataBinding.DataField = 'desc_categ_acc_vis'
              DataBinding.DataSource = dsTTarjetaCIP
              Properties.ReadOnly = True
              TabOrder = 6
              Width = 382
            end
            object snDBLookup5: TsnDBLookup
              Left = 206
              Top = 60
              DataBinding.DataField = 'tipo_visita'
              DataBinding.DataSource = dsTTarjetaCIP
              Properties.KeyFieldNames = 'codigo'
              Properties.ListColumns = <
                item
                  FieldName = 'descripcion'
                end>
              Properties.ListOptions.ShowHeader = False
              Properties.ListSource = DSTiposVisitas
              TabOrder = 1
              Width = 411
            end
          end
          object Panel3: TPanel
            Left = 0
            Top = 171
            Width = 822
            Height = 285
            Align = alClient
            BorderWidth = 5
            Color = clWindow
            TabOrder = 1
            object PageControlSN2: TPageControlSN
              Left = 6
              Top = 6
              Width = 810
              Height = 273
              ActivePage = TabSheet4
              Align = alClient
              TabOrder = 0
              object TabSheet4: TTabSheet
                Caption = 'Tipo de Visita Diaria'
                ImageIndex = 1
                object snLabel4: TsnLabel
                  Left = 8
                  Top = 16
                  Width = 167
                  Height = 13
                  Caption = 'Tolerancia de Ingreso Visita del d'#237'a'
                end
                object snLabel5: TsnLabel
                  Left = 256
                  Top = 16
                  Width = 36
                  Height = 13
                  Caption = 'minutos'
                end
                object snDBEdit5: TsnDBEdit
                  Left = 189
                  Top = 12
                  DataBinding.DataField = 'tole_ing_vis_min'
                  DataBinding.DataSource = dsTTarjetaCIP
                  TabOrder = 0
                  Width = 60
                end
              end
              object TabSheet5: TTabSheet
                Caption = 'Tipo de Visita por Per'#237'odo'
                ImageIndex = 2
                object Panel4: TPanel
                  Left = 0
                  Top = 0
                  Width = 489
                  Height = 245
                  Align = alLeft
                  Color = clWindow
                  TabOrder = 0
                  object dxDBGridSN5: TdxDBGridSN
                    Left = 1
                    Top = 33
                    Width = 487
                    Height = 211
                    Align = alClient
                    BorderWidth = 5
                    TabOrder = 0
                    LookAndFeel.Kind = lfFlat
                    CriteriosPintarCelda = <>
                    object cxGridDBTableView5: TcxGridDBTableView
                      NavigatorButtons.ConfirmDelete = False
                      DataController.DataSource = DSTRotasFecha
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
                  object Panel6: TPanel
                    Left = 1
                    Top = 1
                    Width = 487
                    Height = 32
                    Align = alTop
                    BevelOuter = bvNone
                    Color = clWindow
                    TabOrder = 1
                    object snLabel8: TsnLabel
                      Left = 16
                      Top = 8
                      Width = 143
                      Height = 13
                      Caption = 'Planificaci'#243'n detallada por d'#237'a'
                    end
                  end
                end
                object Panel5: TPanel
                  Left = 489
                  Top = 0
                  Width = 313
                  Height = 245
                  Align = alClient
                  Color = clWindow
                  TabOrder = 1
                  object snLabel7: TsnLabel
                    Left = 16
                    Top = 8
                    Width = 104
                    Height = 13
                    Caption = 'Planificaci'#243'n Semanal'
                  end
                  object srnDBButtonEdit4: TsrnDBButtonEdit
                    Left = 7
                    Top = 38
                    DataBinding.DataField = 'cod_planif_sem_vis'
                    DataBinding.DataSource = dsTTarjetaCIP
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
                    Left = 125
                    Top = 38
                    TabStop = False
                    DataBinding.DataField = 'desc_planif_sem_vis'
                    DataBinding.DataSource = dsTTarjetaCIP
                    Properties.ReadOnly = True
                    TabOrder = 1
                    Width = 181
                  end
                end
              end
              object TabSheet3: TTabSheet
                Caption = 'Tipo de Documentaci'#243'n requerida'
                object dxDBGridSN4: TdxDBGridSN
                  Left = 0
                  Top = 0
                  Width = 802
                  Height = 245
                  Align = alClient
                  BorderWidth = 5
                  TabOrder = 0
                  LookAndFeel.Kind = lfFlat
                  CriteriosPintarCelda = <>
                  object cxGridDBTableView4: TcxGridDBTableView
                    NavigatorButtons.ConfirmDelete = False
                    DataController.DataSource = DSTDocuReq
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
                    OptionsSelection.InvertSelect = False
                    OptionsView.GroupByBox = False
                    object cxGridDBTableView4oid_tipo_docu: TcxGridDBColumn
                      Caption = 'Tipo de Documentaci'#243'n'
                      DataBinding.FieldName = 'oid_tipo_docu'
                      PropertiesClassName = 'TcxLookupComboBoxProperties'
                      Properties.KeyFieldNames = 'oid'
                      Properties.ListColumns = <
                        item
                          FieldName = 'descripcion'
                        end>
                      Properties.ListOptions.ShowHeader = False
                      Properties.ListSource = DSTipoDocu
                      HeaderAlignmentHorz = taCenter
                      Width = 194
                    end
                    object cxGridDBTableView4activo: TcxGridDBColumn
                      Caption = 'Activo'
                      DataBinding.FieldName = 'activo'
                      PropertiesClassName = 'TcxCheckBoxProperties'
                      HeaderAlignmentHorz = taCenter
                      Width = 47
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
        object TabSheet1: TTabSheet
          Caption = 'Estado de la Tarjeta'
          object Label10: TLabel
            Left = 24
            Top = 16
            Width = 126
            Height = 13
            Caption = 'Vigencia de la Tarjeta'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = 8404992
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = [fsBold, fsUnderline]
            ParentFont = False
          end
          object Label4: TLabel
            Left = 225
            Top = 43
            Width = 52
            Height = 13
            Caption = 'Vig. Desde'
          end
          object Label6: TLabel
            Left = 399
            Top = 43
            Width = 57
            Height = 13
            Caption = 'Hora Desde'
          end
          object Label7: TLabel
            Left = 400
            Top = 75
            Width = 54
            Height = 13
            Caption = 'Hora Hasta'
          end
          object Label5: TLabel
            Left = 226
            Top = 75
            Width = 49
            Height = 13
            Caption = 'Vig. Hasta'
          end
          object Label12: TLabel
            Left = 24
            Top = 88
            Width = 116
            Height = 13
            Caption = 'Estado de la Tarjeta'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = 8404992
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = [fsBold, fsUnderline]
            ParentFont = False
          end
          object Label8: TLabel
            Left = 112
            Top = 126
            Width = 69
            Height = 13
            Caption = 'Estado Tarjeta'
          end
          object Label9: TLabel
            Left = 400
            Top = 126
            Width = 102
            Height = 13
            Caption = 'Motivos Inhabilitaci'#243'n'
          end
          object snDBCheckEdit1: TsnDBCheckEdit
            Left = 108
            Top = 40
            Caption = 'Tiene vigencia'
            DataBinding.DataField = 'tiene_vig'
            DataBinding.DataSource = dsTTarjetaCIP
            TabOrder = 0
            Width = 97
          end
          object snDBDateEdit1: TsnDBDateEdit
            Left = 281
            Top = 39
            DataBinding.DataField = 'vig_desde'
            DataBinding.DataSource = dsTTarjetaCIP
            TabOrder = 1
            ReadOnlyAlways = False
            Width = 105
          end
          object snDBMaskEdit1: TsnDBMaskEdit
            Left = 464
            Top = 39
            DataBinding.DataField = 'hora_desde'
            DataBinding.DataSource = dsTTarjetaCIP
            Properties.EditMask = '!90:00;1;_'
            Properties.MaxLength = 0
            TabOrder = 2
            Width = 49
          end
          object snDBMaskEdit2: TsnDBMaskEdit
            Left = 464
            Top = 71
            DataBinding.DataField = 'hora_hasta'
            DataBinding.DataSource = dsTTarjetaCIP
            Properties.EditMask = '!90:00;1;_'
            Properties.MaxLength = 0
            TabOrder = 3
            Width = 49
          end
          object snDBDateEdit2: TsnDBDateEdit
            Left = 282
            Top = 71
            DataBinding.DataField = 'vig_hasta'
            DataBinding.DataSource = dsTTarjetaCIP
            TabOrder = 4
            ReadOnlyAlways = False
            Width = 105
          end
          object snDBLookup3: TsnDBLookup
            Left = 192
            Top = 122
            DataBinding.DataField = 'estado_tarjeta'
            DataBinding.DataSource = dsTTarjetaCIP
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSTHabTar
            TabOrder = 5
            Width = 193
          end
          object snDBLookup4: TsnDBLookup
            Left = 512
            Top = 122
            DataBinding.DataField = 'oid_mot_baj_tar'
            DataBinding.DataSource = dsTTarjetaCIP
            Properties.KeyFieldNames = 'oid'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSMotivosBaja
            TabOrder = 6
            Width = 188
          end
          object snDBCheckEdit4: TsnDBCheckEdit
            Left = 108
            Top = 160
            Caption = 'Controlar Antipassback?'
            DataBinding.DataField = 'anti_passback'
            DataBinding.DataSource = dsTTarjetaCIP
            TabOrder = 7
            Width = 157
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerTarjetaCIP'
    OperGrabarObjeto = 'SaveTarjetaCIP'
    CargaDataSets = <
      item
        DataSet = TTarjetaCIP
        TableName = 'TTarjetaCIP'
      end
      item
        DataSet = TTiposTarjetas
        TableName = 'TTiposTarjetas'
      end
      item
        DataSet = THabTar
        TableName = 'THabTar'
      end
      item
        DataSet = TDocuReq
        TableName = 'TDocuReq'
      end
      item
        DataSet = TTipoVisita
        TableName = 'TTipoVisita'
      end
      item
        DataSet = TRotasFecha
        TableName = 'TRotasFecha'
      end>
    BajaLogica = <
      item
        DataSet = TTarjetaCIP
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TTarjetaCIP
    DataSetDet1 = TDocuReq
    DataSetDet2 = TRotasFecha
    ControlFocoAlta = snDBLookup1
    ControlFocoModif = snDBLookup1
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TTarjetaCIP: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_tarjeta'
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
        Name = 'oid_grupo_tar'
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
      end
      item
        Name = 'tiene_vig'
        DataType = ftBoolean
      end
      item
        Name = 'vig_desde'
        DataType = ftDate
      end
      item
        Name = 'vig_hasta'
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
        Name = 'asignada'
        DataType = ftBoolean
      end
      item
        Name = 'estado_tarjeta'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'oid_mot_baj_tar'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'oid_visita'
        DataType = ftInteger
      end
      item
        Name = 'oid_cliente'
        DataType = ftInteger
      end
      item
        Name = 'fec_asig'
        DataType = ftDate
      end
      item
        Name = 'hora_asig'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'visita'
        DataType = ftBoolean
      end
      item
        Name = 'oid_gru_p_ing_vi'
        DataType = ftInteger
      end
      item
        Name = 'cod_gru_p_ing_vi'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_gru_p_ing_vi'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_gru_p_egr_vi'
        DataType = ftInteger
      end
      item
        Name = 'cod_gru_p_egr_vi'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_gru_p_egr_vi'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_categ_acc_vis'
        DataType = ftInteger
      end
      item
        Name = 'cod_categ_acc_vis'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_categ_acc_vis'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'tole_ing_vis_min'
        DataType = ftInteger
      end
      item
        Name = 'tipo_visita'
        DataType = ftString
        Size = 20
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
    Left = 704
    Top = 67
    object TTarjetaCIPoid_tarjeta: TIntegerField
      FieldName = 'oid_tarjeta'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TTarjetaCIPtipo_tarjeta: TStringField
      FieldName = 'tipo_tarjeta'
      Size = 10
    end
    object TTarjetaCIPnro_tarjeta: TStringField
      FieldName = 'nro_tarjeta'
      Size = 50
    end
    object TTarjetaCIPoid_grupo_tar: TIntegerField
      FieldName = 'oid_grupo_tar'
    end
    object TTarjetaCIPcodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TTarjetaCIPdescripcion: TStringField
      DisplayWidth = 50
      FieldName = 'descripcion'
      Size = 50
    end
    object TTarjetaCIPactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TTarjetaCIPtiene_vig: TBooleanField
      FieldName = 'tiene_vig'
    end
    object TTarjetaCIPvig_desde: TDateField
      FieldName = 'vig_desde'
    end
    object TTarjetaCIPvig_hasta: TDateField
      FieldName = 'vig_hasta'
    end
    object TTarjetaCIPhora_desde: TStringField
      FieldName = 'hora_desde'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object TTarjetaCIPhora_hasta: TStringField
      FieldName = 'hora_hasta'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object TTarjetaCIPasignada: TBooleanField
      FieldName = 'asignada'
    end
    object TTarjetaCIPestado_tarjeta: TStringField
      FieldName = 'estado_tarjeta'
    end
    object TTarjetaCIPoid_mot_baj_tar: TIntegerField
      FieldName = 'oid_mot_baj_tar'
    end
    object TTarjetaCIPoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TTarjetaCIPoid_visita: TIntegerField
      FieldName = 'oid_visita'
    end
    object TTarjetaCIPoid_cliente: TIntegerField
      FieldName = 'oid_cliente'
    end
    object TTarjetaCIPfec_asig: TDateField
      FieldName = 'fec_asig'
    end
    object TTarjetaCIPhora_asig: TStringField
      FieldName = 'hora_asig'
      Size = 5
    end
    object TTarjetaCIPvisita: TBooleanField
      FieldName = 'visita'
    end
    object TTarjetaCIPoid_gru_p_ing_vi: TIntegerField
      FieldName = 'oid_gru_p_ing_vi'
    end
    object TTarjetaCIPcod_gru_p_ing_vi: TStringField
      FieldName = 'cod_gru_p_ing_vi'
      Size = 50
    end
    object TTarjetaCIPdesc_gru_p_ing_vi: TStringField
      FieldName = 'desc_gru_p_ing_vi'
      Size = 100
    end
    object TTarjetaCIPoid_gru_p_egr_vi: TIntegerField
      FieldName = 'oid_gru_p_egr_vi'
    end
    object TTarjetaCIPcod_gru_p_egr_vi: TStringField
      FieldName = 'cod_gru_p_egr_vi'
      Size = 50
    end
    object TTarjetaCIPdesc_gru_p_egr_vi: TStringField
      FieldName = 'desc_gru_p_egr_vi'
      Size = 100
    end
    object TTarjetaCIPoid_categ_acc_vis: TIntegerField
      FieldName = 'oid_categ_acc_vis'
    end
    object TTarjetaCIPcod_categ_acc_vis: TStringField
      FieldName = 'cod_categ_acc_vis'
      Size = 50
    end
    object TTarjetaCIPdesc_categ_acc_vis: TStringField
      FieldName = 'desc_categ_acc_vis'
      Size = 100
    end
    object TTarjetaCIPtole_ing_vis_min: TIntegerField
      FieldName = 'tole_ing_vis_min'
    end
    object TTarjetaCIPtipo_visita: TStringField
      FieldName = 'tipo_visita'
    end
    object TTarjetaCIPoid_planif_sem_vis: TIntegerField
      FieldName = 'oid_planif_sem_vis'
    end
    object TTarjetaCIPcod_planif_sem_vis: TStringField
      FieldName = 'cod_planif_sem_vis'
      Size = 50
    end
    object TTarjetaCIPdesc_planif_sem_vis: TStringField
      FieldName = 'desc_planif_sem_vis'
      Size = 100
    end
    object TTarjetaCIPanti_passback: TBooleanField
      FieldName = 'anti_passback'
    end
    object TTarjetaCIPtar_asig_a: TStringField
      FieldName = 'tar_asig_a'
      Size = 100
    end
  end
  object dsTTarjetaCIP: TDataSource [4]
    DataSet = TTarjetaCIP
    Left = 736
    Top = 67
  end
  inherited TOidObjSave: TsnTable
    Left = 608
  end
  inherited TOpcHabPrograma: TsnTable
    Top = 16
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 424
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
    Left = 472
    Top = 16
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TTarjetaCIP'
        FieldName = 'nro_tarjeta'
        Source.Strings = (
          'begin'
          '  ValidadorTarjeta.Value := Sender.AsString;'
          '  ValidadorTarjeta.Validar();'
          'end.')
      end
      item
        TableName = 'TTarjetaCIP'
        FieldName = 'cod_gru_p_ing_vi'
        Source.Strings = (
          'begin'
          '  ValidadorGrupoPuertas.Value := Sender.AsString;'
          '  ValidadorGrupoPuertas.Validar();'
          'end.')
      end
      item
        TableName = 'TTarjetaCIP'
        FieldName = 'cod_gru_p_egr_vi'
        Source.Strings = (
          'begin'
          '  ValidadorGrupoPuertas1.Value := Sender.AsString;'
          '  ValidadorGrupoPuertas1.Validar();'
          'end.')
      end
      item
        TableName = 'TTarjetaCIP'
        FieldName = 'cod_categ_acc_vis'
        Source.Strings = (
          'begin'
          '  ValidadorCategAcceso.Value := Sender.AsString;'
          '  ValidadorCategAcceso.Validar();'
          'end.')
      end
      item
        TableName = 'TRotasFecha'
        FieldName = 'cod_rota'
        Source.Strings = (
          'begin'
          '  ValidadorRota.Value := Sender.AsString;'
          '  ValidadorRota.Validar();'
          'end.')
      end
      item
        TableName = 'TTarjetaCIP'
        FieldName = 'cod_planif_sem_vis'
        Source.Strings = (
          'begin'
          '  ValidadorPlanificacionSemanal.Value := Sender.AsString;'
          '  ValidadorPlanificacionSemanal.Validar();'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TDocuReq'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_tipo_docu'#39').AsInteger=0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el Tipo d' +
            'e Documento'#39');'
          'end.')
      end
      item
        TableName = 'TRotasFecha'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'fecha'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha'#39')' +
            ';'
          '  if (DataSet.FieldName('#39'oid_rota'#39').AsInteger = 0)'
          '     then raiseException(erCustomError,'#39'Debe ingresar la rota'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TTarjetaCIP'
        Source.Strings = (
          'begin'
          '  TTarjetaCIP.FieldName('#39'asignada'#39').AsBoolean := False;'
          '  TTarjetaCIP.FieldName('#39'visita'#39').AsBoolean := False;'
          '  TTarjetaCIP.FieldName('#39'tiene_vig'#39').AsBoolean := False;'
          '  TTarjetaCIP.FieldName('#39'activo'#39').AsBoolean := True;'
          '  TTarjetaCIP.FieldName('#39'estado_tarjeta'#39').AsString := '#39'HABI'#39';'
          '  TTarjetaCIP.FieldName('#39'anti_passback'#39').AsBoolean := false;'
          'end.')
      end
      item
        TableName = 'TDocuReq'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          
            '  DataSet.FieldName('#39'oid_tarjeta'#39').AsInteger := TTarjetaCIP.Fiel' +
            'dName('#39'oid_tarjeta'#39').AsInteger;'
          'end.')
      end
      item
        TableName = 'TRotasFecha'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          
            '  DataSet.FieldName('#39'oid_tarjeta'#39').AsInteger := TTarjetaCIP.Fiel' +
            'dName('#39'oid_tarjeta'#39').AsInteger;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin  '
          '  TraerTiposTarjetas();'
          '  TGrupoTarjetas.loadFromHelp('#39'HelpGrupoTarjeta'#39');'
          '  TraerHabilitaciones();'
          '  TMotivosBaja.loadFromHelp('#39'HelpMotivos'#39');'
          '  TTipoDocumentacion.loadFromHelp('#39'HelpTipoDocumentacion'#39');'
          '  TraerTiposVisitas();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerTiposTarjetas();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTiposTarjetas'#39');'
          '  operacion.execute();'
          'end;'
          ''
          'procedure TraerHabilitaciones();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerHabTarjeta'#39');'
          ' operacion.execute();'
          'end;'
          ''
          'procedure TraerTiposVisitas();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTiposVisitas'#39');'
          ' operacion.execute();'
          'end;'
          '')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'cxGridDBTableView5cod_rota'
        Source.Strings = (
          'begin'
          '  HelpRotas.Mostrar();'
          'end.')
      end>
    Left = 488
    Top = 59
  end
  inherited SaveArchivo: TSaveDialog
    Left = 512
    Top = 64
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 592
    Top = 144
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 457
    Top = 56
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 312
    Top = 59
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 608
  end
  object HelpTarjetas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.TarjetaCIP'
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
    Titulo = 'Tarjetas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
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
    Left = 536
    Top = 183
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
    Left = 568
    Top = 187
  end
  object HelpGrupoTarjeta: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoTarjeta'
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
    Titulo = 'Grupos de Tarjetas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 626
    Top = 156
  end
  object TGrupoTarjetas: TsnTable
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
    Top = 201
    object TGrupoTarjetasoid: TIntegerField
      FieldName = 'oid'
    end
    object TGrupoTarjetascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TGrupoTarjetasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object dsGruposTarjetas: TDataSource
    DataSet = TGrupoTarjetas
    Left = 216
    Top = 201
  end
  object THabTar: TsnTable
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
    Left = 408
    Top = 273
    object THabTarcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object THabTardescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTHabTar: TDataSource
    DataSet = THabTar
    Left = 448
    Top = 273
  end
  object HelpMotivos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.MotivoBajaTarjeta'
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
    Titulo = 'Motivos de Baja'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 626
    Top = 191
  end
  object TMotivosBaja: TsnTable
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
    Left = 408
    Top = 308
    object TMotivosBajaoid: TIntegerField
      FieldName = 'oid'
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
  object DSMotivosBaja: TDataSource
    DataSet = TMotivosBaja
    Left = 448
    Top = 308
  end
  object ValidadorTarjeta: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.TarjetaCIP'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Tarjeta duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
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
        AsignarACampo = TTarjetaCIPcod_gru_p_ing_vi
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
    Left = 450
    Top = 215
  end
  object ValidadorGrupoPuertas: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Grupo de Puerta Inexistente'
    CampoOID = TTarjetaCIPoid_gru_p_ing_vi
    CampoDescripcion = TTarjetaCIPdesc_gru_p_ing_vi
    NroQuery = 0
    Cache = True
    Left = 486
    Top = 215
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
        AsignarACampo = TTarjetaCIPcod_gru_p_egr_vi
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
    Left = 450
    Top = 252
  end
  object ValidadorGrupoPuertas1: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Grupo de Puerta Inexistente'
    CampoOID = TTarjetaCIPoid_gru_p_egr_vi
    CampoDescripcion = TTarjetaCIPdesc_gru_p_egr_vi
    NroQuery = 0
    Cache = True
    Left = 486
    Top = 252
  end
  object HelpCategAcceso: TsnHelp
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
        AsignarACampo = TTarjetaCIPcod_categ_acc_vis
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
    Titulo = 'Categor'#237'as de Accesos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 218
    Top = 545
  end
  object ValidadorCategAcceso: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.CategAccesoCIP'
    MensajeException = 'C'#243'digo de Categor'#237'as de Acceso Inexistente'
    CampoOID = TTarjetaCIPoid_categ_acc_vis
    CampoDescripcion = TTarjetaCIPdesc_categ_acc_vis
    NroQuery = 0
    Cache = True
    Left = 262
    Top = 545
  end
  object TDocuReq: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_tipo_docu_req'
        DataType = ftInteger
      end
      item
        Name = 'oid_tarjeta'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_docu'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_tarjeta'
    IndexDefs = <
      item
        Name = 'TDocuReqIndex1'
        Fields = 'oid_tarjeta'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_tarjeta'
    MasterSource = dsTTarjetaCIP
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 664
    Top = 108
    object TDocuReqoid_tipo_docu_req: TIntegerField
      FieldName = 'oid_tipo_docu_req'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TDocuReqoid_tarjeta: TIntegerField
      FieldName = 'oid_tarjeta'
    end
    object TDocuReqoid_tipo_docu: TIntegerField
      FieldName = 'oid_tipo_docu'
    end
    object TDocuReqactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTDocuReq: TDataSource
    DataSet = TDocuReq
    Left = 696
    Top = 108
  end
  object HelpTipoDocumentacion: TsnHelp
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
        AsignarACampo = TTarjetaCIPcod_gru_p_ing_vi
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
    Titulo = 'Tipo Documentaci'#243'n'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 450
    Top = 385
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
    Left = 481
    Top = 386
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
  object DSTipoDocu: TDataSource
    DataSet = TTipoDocumentacion
    Left = 513
    Top = 387
  end
  object TTipoVisita: TsnTable
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
    Left = 753
    Top = 292
    object TTipoVisitacodigo: TStringField
      FieldName = 'codigo'
    end
    object TTipoVisitadescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTiposVisitas: TDataSource
    DataSet = TTipoVisita
    Left = 785
    Top = 292
  end
  object TRotasFecha: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_tarj_rot'
        DataType = ftInteger
      end
      item
        Name = 'oid_tarjeta'
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
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_tarjeta'
    IndexDefs = <
      item
        Name = 'TRotasFechaIndex1'
        Fields = 'oid_tarjeta'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_tarjeta'
    MasterSource = dsTTarjetaCIP
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 744
    Top = 108
    object TRotasFechaoid_tarj_rot: TIntegerField
      FieldName = 'oid_tarj_rot'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRotasFechaoid_tarjeta: TIntegerField
      FieldName = 'oid_tarjeta'
    end
    object TRotasFechafecha: TDateField
      FieldName = 'fecha'
    end
    object TRotasFechaoid_rota: TIntegerField
      FieldName = 'oid_rota'
    end
    object TRotasFechacod_rota: TStringField
      FieldName = 'cod_rota'
      Size = 50
    end
    object TRotasFechadesc_rota: TStringField
      FieldName = 'desc_rota'
      Size = 100
    end
    object TRotasFechaactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTRotasFecha: TDataSource
    DataSet = TRotasFecha
    Left = 776
    Top = 108
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
        AsignarACampo = TRotasFechacod_rota
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
    Left = 214
    Top = 578
  end
  object ValidadorRota: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.Rota'
    MensajeException = 'C'#243'digo de Rota Inexistente'
    CampoOID = TRotasFechaoid_rota
    CampoDescripcion = TRotasFechadesc_rota
    NroQuery = 0
    Cache = True
    Left = 250
    Top = 578
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
        AsignarACampo = TTarjetaCIPcod_planif_sem_vis
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
    CampoOID = TTarjetaCIPoid_planif_sem_vis
    CampoDescripcion = TTarjetaCIPdesc_planif_sem_vis
    NroQuery = 0
    Cache = True
    Left = 486
    Top = 323
  end
end
