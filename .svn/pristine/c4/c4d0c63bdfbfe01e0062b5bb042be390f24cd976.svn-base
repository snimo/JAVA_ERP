inherited FRecluPostulante: TFRecluPostulante
  Left = 88
  Top = 0
  Width = 941
  Height = 686
  Align = alClient
  Caption = 'Postulantes'
  Font.Charset = ANSI_CHARSET
  Font.Height = -13
  Font.Name = 'Verdana'
  PixelsPerInch = 96
  TextHeight = 16
  inherited PForm: TPanel
    Width = 925
    Height = 648
    inherited PPie: TPanel
      Top = 627
      Width = 925
      inherited StatusBarABM: TStatusBar
        Left = 820
      end
      inherited StatusBar2: TStatusBar
        Width = 820
      end
    end
    inherited PMenu: TPanel
      Width = 925
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRecluPostulante
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRecluPostulante
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpPostulantes
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpPostulantes
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpPostulantes
      end
      inherited Panel2: TPanel
        Left = 884
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTRecluPostulante
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
      Width = 925
    end
    inherited PCabecera: TPanel
      Width = 925
      Height = 328
      object Label1: TLabel
        Left = 40
        Top = 16
        Width = 106
        Height = 16
        Caption = 'Nro. Documento'
      end
      object Label2: TLabel
        Left = 40
        Top = 48
        Width = 117
        Height = 16
        Caption = 'Apellido y Nombre'
      end
      object Label3: TLabel
        Left = 310
        Top = 16
        Width = 28
        Height = 16
        Caption = 'Tipo'
      end
      object Label4: TLabel
        Left = 40
        Top = 79
        Width = 106
        Height = 16
        Caption = 'Fec. Nacimiento'
      end
      object Label5: TLabel
        Left = 40
        Top = 112
        Width = 60
        Height = 16
        Caption = 'Direcci'#243'n'
      end
      object Label6: TLabel
        Left = 40
        Top = 144
        Width = 61
        Height = 16
        Caption = 'Localidad'
      end
      object Label7: TLabel
        Left = 40
        Top = 176
        Width = 89
        Height = 16
        Caption = 'C'#243'digo Postal'
      end
      object Label8: TLabel
        Left = 40
        Top = 208
        Width = 85
        Height = 16
        Caption = 'Tel'#233'fono Fijo'
      end
      object Label9: TLabel
        Left = 40
        Top = 240
        Width = 106
        Height = 16
        Caption = 'Tel'#233'fono Celular'
      end
      object Label10: TLabel
        Left = 488
        Top = 272
        Width = 79
        Height = 16
        Caption = 'Referido por'
      end
      object Label11: TLabel
        Left = 464
        Top = 48
        Width = 46
        Height = 16
        Caption = 'Genero'
      end
      object Label12: TLabel
        Left = 43
        Top = 272
        Width = 70
        Height = 16
        Caption = 'Es referido'
      end
      object Label13: TLabel
        Left = 272
        Top = 272
        Width = 85
        Height = 16
        Caption = 'Nro. Referido'
      end
      object Foto: TsnImage
        Left = 544
        Top = 80
        Width = 216
        Height = 170
        Stretch = True
      end
      object Label14: TLabel
        Left = 44
        Top = 304
        Width = 46
        Height = 16
        Caption = 'Fuente'
      end
      object Label15: TLabel
        Left = 530
        Top = 16
        Width = 45
        Height = 16
        Caption = 'Estado'
      end
      object Label16: TLabel
        Left = 736
        Top = 16
        Width = 29
        Height = 16
        Caption = 'Fec.'
      end
      object DBECodigo: TsnDBEdit
        Left = 172
        Top = 12
        DataBinding.DataField = 'nro_docu'
        DataBinding.DataSource = DSTRecluPostulante
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 30
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object DBEDescripcion: TsnDBEdit
        Left = 172
        Top = 44
        DataBinding.DataField = 'ape_y_nom'
        DataBinding.DataSource = DSTRecluPostulante
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 4
        Width = 273
      end
      object snDBLookup1: TsnDBLookup
        Left = 343
        Top = 12
        DataBinding.DataField = 'oid_tipo_docu'
        DataBinding.DataSource = DSTRecluPostulante
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTipoDocumentos
        TabOrder = 1
        Width = 185
      end
      object snDBDateEdit1: TsnDBDateEdit
        Left = 172
        Top = 76
        DataBinding.DataField = 'fec_nacimiento'
        DataBinding.DataSource = DSTRecluPostulante
        TabOrder = 6
        ReadOnlyAlways = False
        Width = 121
      end
      object snDBEdit1: TsnDBEdit
        Left = 172
        Top = 108
        DataBinding.DataField = 'direccion'
        DataBinding.DataSource = DSTRecluPostulante
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 7
        Width = 273
      end
      object snDBEdit2: TsnDBEdit
        Left = 172
        Top = 140
        DataBinding.DataField = 'localidad'
        DataBinding.DataSource = DSTRecluPostulante
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 8
        Width = 273
      end
      object snDBEdit3: TsnDBEdit
        Left = 172
        Top = 172
        DataBinding.DataField = 'cod_postal'
        DataBinding.DataSource = DSTRecluPostulante
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 9
        Width = 165
      end
      object snDBEdit4: TsnDBEdit
        Left = 172
        Top = 204
        DataBinding.DataField = 'telefono_fijo'
        DataBinding.DataSource = DSTRecluPostulante
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 10
        Width = 273
      end
      object snDBEdit5: TsnDBEdit
        Left = 172
        Top = 236
        DataBinding.DataField = 'telefono_celular'
        DataBinding.DataSource = DSTRecluPostulante
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 11
        Width = 273
      end
      object snDBEdit6: TsnDBEdit
        Left = 576
        Top = 268
        DataBinding.DataField = 'referido_por'
        DataBinding.DataSource = DSTRecluPostulante
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 14
        Width = 237
      end
      object snDBLookup2: TsnDBLookup
        Left = 520
        Top = 45
        DataBinding.DataField = 'sexo'
        DataBinding.DataSource = DSTRecluPostulante
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSGenerosPostulantes
        TabOrder = 5
        Width = 145
      end
      object snDBLookup3: TsnDBLookup
        Left = 172
        Top = 269
        DataBinding.DataField = 'es_referido'
        DataBinding.DataSource = DSTRecluPostulante
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSSiNo
        TabOrder = 12
        Width = 69
      end
      object snDBEdit7: TsnDBEdit
        Left = 364
        Top = 268
        DataBinding.DataField = 'nro_referido'
        DataBinding.DataSource = DSTRecluPostulante
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 13
        Width = 93
      end
      object BotonElegirImagen: TsnButton
        Left = 764
        Top = 80
        Width = 117
        Height = 25
        Caption = 'Agregar foto ...'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
        TabOrder = 16
        LookAndFeel.Kind = lfOffice11
      end
      object BorrarImagen: TsnButton
        Left = 764
        Top = 112
        Width = 117
        Height = 25
        Caption = 'Borrar Im'#225'gen'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
        TabOrder = 17
        LookAndFeel.Kind = lfOffice11
      end
      object snDBLookup4: TsnDBLookup
        Left = 172
        Top = 301
        DataBinding.DataField = 'oid_fuente'
        DataBinding.DataSource = DSTRecluPostulante
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSRecluFuente
        TabOrder = 15
        Width = 182
      end
      object snDBLookup5: TsnDBLookup
        Left = 576
        Top = 12
        DataBinding.DataField = 'oid_estado_postu'
        DataBinding.DataSource = DSTRecluPostulante
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSEstadoPostulante
        TabOrder = 2
        Width = 153
      end
      object snDBDateEdit2: TsnDBDateEdit
        Left = 776
        Top = 12
        DataBinding.DataField = 'fec_est_postu'
        DataBinding.DataSource = DSTRecluPostulante
        TabOrder = 3
        ReadOnlyAlways = False
        Width = 113
      end
    end
    inherited PCuerpo: TPanel
      Top = 380
      Width = 925
      Height = 247
      BorderWidth = 5
      object PageControlSN1: TPageControlSN
        Left = 5
        Top = 5
        Width = 915
        Height = 237
        ActivePage = TabSheet1
        Align = alClient
        Style = tsFlatButtons
        TabOrder = 0
        object TabSheet1: TTabSheet
          Caption = 'Competencias'
          object dxDBGridSN1: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 907
            Height = 203
            Align = alClient
            TabOrder = 0
            CriteriosPintarCelda = <>
            object cxGridDBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              NavigatorButtons.First.Visible = False
              NavigatorButtons.PriorPage.Visible = False
              NavigatorButtons.Prior.Visible = False
              NavigatorButtons.Next.Visible = False
              NavigatorButtons.NextPage.Visible = False
              NavigatorButtons.Last.Visible = False
              NavigatorButtons.Insert.Visible = False
              NavigatorButtons.Append.Visible = True
              NavigatorButtons.Delete.Visible = False
              NavigatorButtons.Edit.Visible = False
              NavigatorButtons.Post.Visible = False
              NavigatorButtons.Cancel.Visible = False
              NavigatorButtons.Refresh.Visible = False
              NavigatorButtons.SaveBookmark.Visible = False
              NavigatorButtons.GotoBookmark.Visible = False
              NavigatorButtons.Filter.Visible = False
              DataController.DataSource = DSTRecluCompetencia
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
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
              OptionsView.Navigator = True
              OptionsView.CellAutoHeight = True
              OptionsView.GroupByBox = False
              object cxGridDBTableView1oid_competencia: TcxGridDBColumn
                Caption = 'Competencia del Postulante'
                DataBinding.FieldName = 'oid_competencia'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'oid'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSCompetencias
                HeaderAlignmentHorz = taCenter
                Width = 348
              end
              object cxGridDBTableView1activo: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                HeaderAlignmentHorz = taCenter
                Width = 65
              end
              object cxGridDBTableView1Column1: TcxGridDBColumn
                Caption = 'Agrupador'
                DataBinding.FieldName = 'grupo_competencia'
                Visible = False
                GroupIndex = 0
              end
            end
            object cxGridLevel1: TcxGridLevel
              GridView = cxGridDBTableView1
            end
          end
        end
        object TabSheet2: TTabSheet
          Caption = 'Curriculum'
          ImageIndex = 1
          object dxDBGridSN2: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 907
            Height = 203
            Align = alClient
            TabOrder = 0
            CriteriosPintarCelda = <>
            object cxGridDBTableView2: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              NavigatorButtons.First.Visible = False
              NavigatorButtons.PriorPage.Visible = False
              NavigatorButtons.Prior.Visible = False
              NavigatorButtons.Next.Visible = False
              NavigatorButtons.NextPage.Visible = False
              NavigatorButtons.Last.Visible = False
              NavigatorButtons.Insert.Visible = False
              NavigatorButtons.Append.Visible = True
              NavigatorButtons.Delete.Visible = False
              NavigatorButtons.Edit.Visible = False
              NavigatorButtons.Post.Visible = False
              NavigatorButtons.Cancel.Visible = False
              NavigatorButtons.Refresh.Visible = False
              NavigatorButtons.SaveBookmark.Visible = False
              NavigatorButtons.GotoBookmark.Visible = False
              NavigatorButtons.Filter.Visible = False
              DataController.DataSource = DSTRecluCurriculum
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
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
              OptionsView.Navigator = True
              OptionsView.CellAutoHeight = True
              OptionsView.GroupByBox = False
              object cxGridDBTableView2fecha_recepcion: TcxGridDBColumn
                Caption = 'F. Recepci'#243'n'
                DataBinding.FieldName = 'fecha_recepcion'
                HeaderAlignmentHorz = taCenter
                SortIndex = 0
                SortOrder = soDescending
                Width = 125
              end
              object cxGridDBTableView2observacion: TcxGridDBColumn
                Caption = 'Observaci'#243'n'
                DataBinding.FieldName = 'observacion'
                PropertiesClassName = 'TcxMemoProperties'
                Properties.WantTabs = True
                HeaderAlignmentHorz = taCenter
                Width = 362
              end
              object cxGridDBAdjuntar: TcxGridDBColumn
                Caption = 'Adjuntar'
                DataBinding.FieldName = 'nombre_archivo'
                PropertiesClassName = 'TcxButtonEditProperties'
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                HeaderAlignmentHorz = taCenter
                Width = 134
              end
              object cxGridDBTableViewVisualizar: TcxGridDBColumn
                Caption = 'Visualizar'
                DataBinding.FieldName = 'visualizar'
                PropertiesClassName = 'TcxButtonEditProperties'
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                HeaderAlignmentHorz = taCenter
                Width = 93
              end
              object cxGridDBTableView2activo: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                HeaderAlignmentHorz = taCenter
                Width = 62
              end
            end
            object cxGridLevel2: TcxGridLevel
              GridView = cxGridDBTableView2
            end
          end
        end
        object TabSheet3: TTabSheet
          Caption = 'Anotaciones'
          ImageIndex = 2
          object dxDBGridSN3: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 907
            Height = 203
            Align = alClient
            TabOrder = 0
            CriteriosPintarCelda = <>
            object cxGridDBTableView3: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              NavigatorButtons.First.Visible = False
              NavigatorButtons.PriorPage.Visible = False
              NavigatorButtons.Prior.Visible = False
              NavigatorButtons.Next.Visible = False
              NavigatorButtons.NextPage.Visible = False
              NavigatorButtons.Last.Visible = False
              NavigatorButtons.Insert.Visible = False
              NavigatorButtons.Append.Visible = True
              NavigatorButtons.Delete.Visible = False
              NavigatorButtons.Edit.Visible = False
              NavigatorButtons.Post.Visible = False
              NavigatorButtons.Cancel.Visible = False
              NavigatorButtons.Refresh.Visible = False
              NavigatorButtons.SaveBookmark.Visible = False
              NavigatorButtons.GotoBookmark.Visible = False
              NavigatorButtons.Filter.Visible = False
              DataController.DataSource = DSTRecluNovedadPostu
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
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
              OptionsView.Navigator = True
              OptionsView.CellAutoHeight = True
              OptionsView.GroupByBox = False
            end
            object dxDBGridSN3DBBandedTableView1: TcxGridDBBandedTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSTRecluNovedadPostu
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsSelection.InvertSelect = False
              OptionsView.CellAutoHeight = True
              OptionsView.GroupByBox = False
              Bands = <
                item
                  Caption = 'Anotaci'#243'n'
                  Width = 603
                end
                item
                  Caption = 'Excluir Postulaci'#243'n'
                  Width = 202
                end>
              object dxDBGridSN3DBBandedTableView1fecha: TcxGridDBBandedColumn
                Caption = 'Fecha'
                DataBinding.FieldName = 'fecha'
                HeaderAlignmentHorz = taCenter
                Width = 135
                Position.BandIndex = 0
                Position.ColIndex = 0
                Position.RowIndex = 0
              end
              object dxDBGridSN3DBBandedTableView1novedad: TcxGridDBBandedColumn
                Caption = 'Anotaci'#243'n'
                DataBinding.FieldName = 'novedad'
                HeaderAlignmentHorz = taCenter
                Width = 334
                Position.BandIndex = 0
                Position.ColIndex = 1
                Position.RowIndex = 0
              end
              object dxDBGridSN3DBBandedTableView1activo: TcxGridDBBandedColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                HeaderAlignmentHorz = taCenter
                Width = 57
                Position.BandIndex = 0
                Position.ColIndex = 2
                Position.RowIndex = 0
              end
              object dxDBGridSN3DBBandedTableView1exc_fut_postu: TcxGridDBBandedColumn
                Caption = 'Excluir?'
                DataBinding.FieldName = 'exc_fut_postu'
                HeaderAlignmentHorz = taCenter
                Width = 55
                Position.BandIndex = 1
                Position.ColIndex = 0
                Position.RowIndex = 0
              end
              object dxDBGridSN3DBBandedTableView1fec_vigencia: TcxGridDBBandedColumn
                Caption = 'Fec. Vigencia Hasta?'
                DataBinding.FieldName = 'fec_vigencia'
                HeaderAlignmentHorz = taCenter
                Width = 147
                Position.BandIndex = 1
                Position.ColIndex = 1
                Position.RowIndex = 0
              end
            end
            object cxGridLevel3: TcxGridLevel
              GridView = dxDBGridSN3DBBandedTableView1
            end
          end
        end
        object TabSheet4: TTabSheet
          Caption = 'Postulaciones que aplica   '
          ImageIndex = 3
          object dxDBGridSN4: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 907
            Height = 203
            Align = alClient
            TabOrder = 0
            CriteriosPintarCelda = <>
            object cxGridDBTableView4: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              NavigatorButtons.First.Visible = False
              NavigatorButtons.PriorPage.Visible = False
              NavigatorButtons.Prior.Visible = False
              NavigatorButtons.Next.Visible = False
              NavigatorButtons.NextPage.Visible = False
              NavigatorButtons.Last.Visible = False
              NavigatorButtons.Insert.Visible = False
              NavigatorButtons.Append.Visible = True
              NavigatorButtons.Delete.Visible = False
              NavigatorButtons.Edit.Visible = False
              NavigatorButtons.Post.Visible = False
              NavigatorButtons.Cancel.Visible = False
              NavigatorButtons.Refresh.Visible = False
              NavigatorButtons.SaveBookmark.Visible = False
              NavigatorButtons.GotoBookmark.Visible = False
              NavigatorButtons.Filter.Visible = False
              DataController.DataSource = DSTRecluPuestoAplica
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
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
              OptionsView.Navigator = True
              OptionsView.CellAutoHeight = True
              OptionsView.GroupByBox = False
              object cxGridDBTableView4oid_puesto_busqueda: TcxGridDBColumn
                Caption = 'Puesto'
                DataBinding.FieldName = 'nombre_puesto'
                PropertiesClassName = 'TcxButtonEditProperties'
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                HeaderAlignmentHorz = taCenter
                Width = 532
              end
              object cxGridDBTableView4activo: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 59
              end
            end
            object cxGridLevel4: TcxGridLevel
              GridView = cxGridDBTableView4
            end
          end
        end
        object TabSheet5: TTabSheet
          Caption = 'Procesos Varios   '
          ImageIndex = 4
          object dxDBGridSN5: TdxDBGridSN
            Left = 0
            Top = 41
            Width = 907
            Height = 162
            Align = alClient
            TabOrder = 0
            AllowInsert = False
            CriteriosPintarCelda = <>
            object cxGridDBTableView5: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
            end
            object cxGridDBBandedTableView3: TcxGridDBBandedTableView
              NavigatorButtons.ConfirmDelete = False
              NavigatorButtons.First.Visible = False
              NavigatorButtons.PriorPage.Visible = False
              NavigatorButtons.Prior.Visible = False
              NavigatorButtons.Next.Visible = False
              NavigatorButtons.NextPage.Visible = False
              NavigatorButtons.Last.Visible = False
              NavigatorButtons.Insert.Visible = False
              NavigatorButtons.Append.Visible = False
              NavigatorButtons.Delete.Visible = False
              NavigatorButtons.Edit.Visible = False
              NavigatorButtons.Post.Visible = False
              NavigatorButtons.Cancel.Visible = False
              NavigatorButtons.Refresh.Visible = False
              NavigatorButtons.SaveBookmark.Visible = False
              NavigatorButtons.GotoBookmark.Visible = False
              NavigatorButtons.Filter.Visible = False
              DataController.DataSource = DSProcesosCandidatos
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsData.CancelOnExit = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsData.Editing = False
              OptionsData.Inserting = False
              OptionsView.Navigator = True
              OptionsView.CellAutoHeight = True
              OptionsView.GroupByBox = False
              Bands = <
                item
                  Caption = 'Procesos'
                  FixedKind = fkLeft
                  Width = 575
                end
                item
                  Caption = 'Planificado'
                end
                item
                  Caption = 'Resultado'
                end>
              object cxGridDBBandedTableView3proceso: TcxGridDBBandedColumn
                Caption = 'Proceso'
                DataBinding.FieldName = 'oid_proceso'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'oid'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSRecluProceso
                HeaderAlignmentHorz = taCenter
                Width = 268
                Position.BandIndex = 0
                Position.ColIndex = 0
                Position.RowIndex = 0
              end
              object cxGridDBBandedTableView3concepto: TcxGridDBBandedColumn
                Caption = 'Tipo de Examen'
                DataBinding.FieldName = 'concepto'
                PropertiesClassName = 'TcxButtonEditProperties'
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                HeaderAlignmentHorz = taCenter
                Width = 307
                Position.BandIndex = 0
                Position.ColIndex = 1
                Position.RowIndex = 0
              end
              object cxGridDBBandedTableView3estado: TcxGridDBBandedColumn
                Caption = 'Estado'
                DataBinding.FieldName = 'oid_est_proc_sel'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'oid'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSEstadoProceso
                HeaderAlignmentHorz = taCenter
                Width = 102
                Position.BandIndex = 2
                Position.ColIndex = 0
                Position.RowIndex = 0
              end
              object cxGridDBBandedTableView3fecha_planif: TcxGridDBBandedColumn
                Caption = 'Fecha Planif.'
                DataBinding.FieldName = 'fecha_planif'
                HeaderAlignmentHorz = taCenter
                SortIndex = 0
                SortOrder = soDescending
                Width = 117
                Position.BandIndex = 1
                Position.ColIndex = 0
                Position.RowIndex = 0
              end
              object cxGridDBBandedTableView3hora_planif: TcxGridDBBandedColumn
                Caption = 'Horario'
                DataBinding.FieldName = 'hora_planif'
                HeaderAlignmentHorz = taCenter
                Width = 88
                Position.BandIndex = 1
                Position.ColIndex = 1
                Position.RowIndex = 0
              end
              object cxGridDBBandedTableView3persona: TcxGridDBBandedColumn
                Caption = 'Contactar a'
                DataBinding.FieldName = 'persona'
                HeaderAlignmentHorz = taCenter
                Width = 99
                Position.BandIndex = 1
                Position.ColIndex = 2
                Position.RowIndex = 0
              end
              object cxGridDBBandedTableView3observaciones: TcxGridDBBandedColumn
                Caption = 'Comentarios / Observaciones'
                DataBinding.FieldName = 'observaciones'
                Width = 233
                Position.BandIndex = 2
                Position.ColIndex = 1
                Position.RowIndex = 0
              end
              object cxGridDBBandedTableView3Column1: TcxGridDBBandedColumn
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                Position.BandIndex = 2
                Position.ColIndex = 2
                Position.RowIndex = 0
              end
              object cxGridDBBandedTableView3Column2: TcxGridDBBandedColumn
                DataBinding.FieldName = 'titulo'
                Visible = False
                GroupIndex = 0
                SortIndex = 1
                SortOrder = soDescending
                Position.BandIndex = 0
                Position.ColIndex = 2
                Position.RowIndex = 0
                IsCaptionAssigned = True
              end
            end
            object cxGridLevel5: TcxGridLevel
              GridView = cxGridDBBandedTableView3
            end
          end
          object Panel1: TPanel
            Left = 0
            Top = 0
            Width = 907
            Height = 41
            Align = alTop
            Color = clWindow
            TabOrder = 1
            object BotonAgregarProcAlCandi: TsnButton
              Left = 204
              Top = -1
              Width = 106
              Height = 37
              Cursor = crHandPoint
              Hint = 'Nuevo Proceso del Candidato'
              Caption = 'Nuevo'
              TabOrder = 0
              Glyph.Data = {
                42080000424D4208000000000000420000002800000020000000200000000100
                10000300000000080000202E0000202E00000000000000000000007C0000E003
                00001F000000FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FDE77BE779D737C6F3A5FBD73FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                DE7B9D737D675B631A5FF956D952B84E974A97467642B84AB029944EFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7BBE77BD737C6B3B631A5BD852974A5542
                1236D22DF22D353A553E353E763E7642764676467646D94E13369552FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FD85290298F296E258F25AF2DAF29B031F239
                5442B74E754AD031553EB84A974A974A974AB84AB84AFA4E343AB652FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FB74EF235954AB752F85A1A5F5B675D6F7E6F
                BF73BF733B639652F135543EB84E974AB84AB84AB84AD94E343AB652FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FF8561B5FFF7FFF7BDF77DF77BF739F737F6F
                9F6F3C63B7523D67F95AF135543ED94EB84AB84AB84AD952553EB652FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F195BFA5ABF779F6F9E6F7E6F7E6B7E6B7E6B
                9E6F5C67B752FA5A7D6B3A63F139143AD94EB84EB94EDA527642D652FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F195FD956DF779E6F7E6F7E6B7E6B7E6B7D6B
                7D6F3C67B7521A5F3B637E6B1B63123E343ED952D94EFA527646D756FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F185FD952BF777E6F7E6B7E6B7E6B7D6B7D6B
                7E6B3C63B7521A5F3C633C5F9E6B5C6B133E133AF94EFA4E9746B652FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F5A67D8527F6F7E6B7E6B7D6B7D6B7D6B5D67
                5D673C63B7521B5F3C635C675C677E6B5E6B5446343AFA52B84A954AFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F7B6BD9527F6F7E6B7D6B7D6B5D675D675D67
                5C6B3B6397523B637C6B5D675E675D679F6FDF775546343EB94AB64EFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F9C6FD9529E6F7D6B5D675D675D675D675C67
                5C631C5F96523A637C6B3C633C633C635B637C6B7D6B764A553EB64EFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F9C6FD8527D6B7D6B5D675D675C675C673C63
                3C633B63D956D756D756B652B652B752B652964EF95AD95A333AB64AFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F9D73D8525D675D675D675C675C673C633C63
                3B633B631B5FFA5AFA5AF95AD95AF95AF95AFA5AFA5ED856343E964AFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FBD77D8525D675C675C673C633C633C633B63
                3B631B5F1B5F1B5F1B5F1A5FFA5AFA5AFB5AFA5A1A5FD85634427546FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FBD77D8565C675C673C633C633B633B631B5F
                1B5F1B5F1B5F1A5FFA5AFA5AFA5AFA5AF95AD95ADA5AB85654427546DE7BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7BF95A3C5F3C633C633B633B5F1B5F1B5F
                1B5F1A5F1A5FFA5AFA5AFA5AF95AD95AD956D956DA56B9525442754ADE7BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7FF95A3B5F3B633B631B5F1B5F1B5F1B5F
                1A5FFA5AFA5AFA5AFA5AF95AD95AD956D956D956F95AD8563442954ADE7BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FF95A1A5F1B5F1B5F1B5F1B5F1A5FFA5A
                FA5AFA5AFA5AF95AD95AD956D956D956D856D856D856B7525442964ADE7BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3A63FA5A1B5F1B5F1A5FFA5AFA5AFA5A
                FA5AF95AD95AD956D956D956D956D856D856B852B8529852543E7546BD77FF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F195FDA561B5F1A5FFA5AFA5AFA5AFA5A
                F95AD956D956D956D956D856D856D856B852B852B852B752754254429C73FF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3B63D956FA5AFA5AFA5AFA5AF95AD95A
                D956D956D956D856D856D856B852B852B852B852D752B7525546543E9C73FF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3A63B852FB5AFA5AF95AD95AD956D956
                D956D956D856D856B852B852B852B752B752B752B752974E554255429C6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3A63B8523B631A631A5F1A5F1A5F1A5F
                195F195FF95AD95AD956D85AD856D756D752B752974E974E744654427C6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F7C6F55427229B22DD335F435F439143E
                35423642564A764E764E964EB652B652B752B756B752D8563342F2357C6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9C6FB752311D0F1130193019501D5119
                311D511D511D711D7121712192259329B329B32DD32D1536133EF2357C6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9C73F85A353E521D9325B3259325B325
                B325B32593259425932593259325B325B32594257321F5395442333A7B6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FBD77B84AB846563ED62DD629F52DF52D
                D531D52DD52DD52DD52DF52DD529D429D529B525363EB6565446333A7B6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFE7BFA56D94EF952B84A573E38363936
                583A583A383A383637361836183617361636553EB74EF956FA5676465B6BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7BBE77BD73BC735C63BB4A
                9B3EBB469B469B4A5B3E593A57425642984AD952FA52FC565E5F7742185FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FBE77
                BB4A7A3A9B423A3699469C739C6F7B6B5C633B5F3B5F3B5B3B5B97463A63FF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                DE7B3B637846B94EBE77FF7FFF7FFF7FFF7FFF7FFF7FDE7BDD77BE77FF7FFF7F
                FF7FFF7FFF7F}
              LookAndFeel.Kind = lfOffice11
            end
            object BotonModificarProcesoCandidato: TsnButton
              Left = 330
              Top = -1
              Width = 116
              Height = 37
              Cursor = crHandPoint
              Hint = 'Modificar Proceso del Candidato'
              Caption = 'Modificar'
              TabOrder = 1
              Glyph.Data = {
                42080000424D4208000000000000420000002800000020000000200000000100
                10000300000000080000202E0000202E00000000000000000000007C0000E003
                00001F000000FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FBD77
                5A6B9B737D6B7E6FDF7BFF7FFF7FFF7FFF7FDE7BBE77BD737C6FBD77FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F8C31
                630CA6144D4E925A524A3342553E964ED952B84E7646B84AB12D9552FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FDF7BBE739D6F5B673B5FD852AE35
                E71C2500A462657BC66A855EE8456F25343697467646D94EF2359552FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FF95AF231F231CF2990258F29B0299029F13D
                564AEE3D4877897F697FA87F287BAE358F295542B84EFA4E143AB552FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FB74EB02D53427546B74ED856195F5C67D956
                6C566A738C7F4C7F6C7F8C7F2973692D8F2DD0317646FB52343AB652FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FF8563B5FFF7FDF77FF7BFF7BDF77BF735E67
                4B7BAB7F8E7F8E7F8E7FB07F4B7B2008A914CF35D031B94A5642B652FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F185B1A5BDF779F6F9E6F7E6F7E6B7F6B5F63
                326B8D7FB17FB17FB17F8F7FAA7F034E0000A714AE31123A553ED756FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F195FD956DF739E6F7E6F7E6F7E6B7E6B7F67
                17638D7FF47FF57FD27F6E7FED7FEB7FE3490000A814AE35D02DB64EFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FF95ED952BF777E6F7E6B7E6B7E6B7D6B7E6B
                1D5F2F738E77AB56106BF87FD17FCE7FEB7F64560000870C4D293242FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F5A67D8529F737E6B7E6B7E6B7D6B7D6B5D67
                7E671963EE4123042104D15AF87FD27FCE7FEB7F4452000045046D2D5A6BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F7B6BD9529F6F7E6B7D6B7D6B5D675D675D67
                7C6B3D63564A1142640C0000F15EF97FD27FCE7FEB7FA5620000440411427B6F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F9C6FD9529E6F7D6B7D6B5D675D675D675C67
                5C673C5FD8525C67B656C71800006D4EF97FD37FCE7FEC7FA56640100300CF39
                7B73FF7FFF7FFF7FFF7FFF7FFF7F9C73D8527E6B7D6B5D675D675C675C673C63
                3C633B63D856F95EF95A744AA61400009052F97FF37FCE7FED7F056F40102304
                10429C6FFF7FFF7FFF7FFF7FFF7FBD73D8525D675E675D675C675C673C633C63
                3B633B631B5FD95AFA5A1A5FB752092100002C46F97FF47FED7FEB7F2B4A2400
                A510524EFF7FFF7FFF7FFF7FFF7FBD77D8525D675D675C673C633C633C633B63
                3B631B5F1B5F1B5F3B631A5F3C5FD856E81C00002D46F87FF37FFA7FF23DA508
                C5288D65DE77FF7FFF7FFF7FFF7FDD77F8565C675C673C633C633B633B633B5F
                1B5F1B5F1B5F1A5FFA5AFA5AFA5A1C5FF85A4B290000A935BC771B635246B44E
                8D658D6DBD73FF7FFF7FFF7FFF7FDE7BF9563C633C633C633B633B631B5F1B5F
                1B5F1A5F1A5FFA5AFA5AFA5AFA5AD95AFA5AD856534AF041AD31CE35DD775B7F
                4D6DAF59DE77FF7FFF7FFF7FFF7FDE7FF95A3B5F3C633B631B5F1B5F1B5F1B5F
                1A5FFA5AFA5AFA5AFA5AF95AD95AD956D956D9561B5F7B6B0F46524EB8729165
                0C51955AFF7FFF7FFF7FFF7FFF7FFF7FF95A1A5B3B631B5F1B5F1B5F1A5FFA5A
                FA5AFA5AFA5AF95AD95AD95AD956D956D856D856B84E974AD14D6F594E558F4D
                B65EDE77FF7FFF7FFF7FFF7FFF7FFF7F3A5FDA5A1B5F1B5F1A5F1A5FFA5AFA5A
                FA5AF95AD95AD956D956D956D956D856D856D856B8529852344253425A6FBD77
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F1A5FDA561B5F1A5FFA5AFA5AFA5AFA5A
                F95AD956D956D956D956D856D856D856B852B852B852B75275429542FE77FF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3A63D9561A5FFA5AFA5AFA5AF95AD95A
                D956D956D956D856D856D856B852B852B852B852B752B7525546543E9C73FF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3A63B8521B5FFA5AF95AD95AD956D956
                D956D856D856D856B852B852B852B752B752B752B752974E754275427C6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3A63B8523B633A631A631A5F1A5F1A5F
                1A5FF95AD95AD956D956D856D756D756B752974EB74E974E744654427C6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9C6F353E7025912DD331F339143A3542
                764A964E774E98529752B652B756B756B752B752B752D8563342F2357C6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9C73974E1119EF103019301930193019
                5019501D7121712192259229B32DB32DD331F335F435353E133EF2357C6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9C73195B363A52199225B2259325B325
                9221932593259325932593259325B32193219321741DF5355446133A7B6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FBE77B84AB846563ED52DD629D52DF52D
                D42DD52DD52DD52DD529D529D429D529D529B525363EB6565442333A7B6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7BFA56B94EF952984A573A38323836
                583A583A37363736383A3736373217361636353EB752F956D95276427B6BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7BBE77BD73BC735C63BB46
                9B3EBB46BB469B4A5B3E593A573E5642974AD84EFA52FB565E5F77463A67FF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FBD73
                BB4A7B3A9B425A3A994A7C6B7B6B5B675C635C633B5B1B5B3B5797467B6BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                DE7B3C637846B94EBE7BFF7FFF7FFF7FFF7FFF7FFE7FDE7BDD77DE77FF7FFF7F
                FF7FFF7FFF7F}
              LookAndFeel.Kind = lfOffice11
            end
            object BotonEliminarProcesoCandidato: TsnButton
              Left = 466
              Top = -1
              Width = 106
              Height = 37
              Cursor = crHandPoint
              Hint = 'Eliminar Proceso Candidato'
              Caption = 'Eliminar'
              TabOrder = 2
              Glyph.Data = {
                42080000424D4208000000000000420000002800000020000000200000000100
                10000300000000080000202E0000202E00000000000000000000007C0000E003
                00001F000000FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FBD73B55ECE4D4A494A498D45324A9542BD6BFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7B
                BE779D6F9D635D57F049634400480054005800580054004C00282929DE6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FBE779D6F5C6B3A5FF95AB74E9546553E333A
                F131F22D342EC838004821608470637C427C427CA578C6746368004808397B5F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FB7526F216E258F29B02DD02DD12DF239333E
                5446F94AA64800540775087D637C007C007C217C437CC67C6B7D0875004C8434
                BD6FFF7FFF7FFF7FFF7FFF7FFF7FB7525442D75AF95A3B635C6B7E6F9E739E73
                FF77D76A00544A71CE7DE76C6368426C007C217C4270A568086D107629710048
                AD45FF7BFF7FFF7FFF7FFF7FFF7FF8563B63FF7FDF77DF77BF739F737F6FBF6F
                9D6B6350E764EF7D316A9C677B635A5B63682174395F7B637B5F945A107EC66C
                0038395BFF7FFF7FFF7FFF7FFF7FF95EFA56BF739F6F7E6F7E6F7E6B7E6BFF6F
                125E0050317A107E29715A73FF7FFF7BEF55CE5DFF7FFF7FFF73AD69107E317A
                004C8C49FF7FFF7FFF7FFF7FFF7F195FD952DF777E6F7E6F7E6B7E6B7E6BFF6F
                C858635C947EEF7D297D8C6DFF7BFF7FDE73DE73FF7FFF7F52662979107E737E
                425C8444FF77FF7FFF7FFF7FFF7F195FD9529F777E6F7E6B7E6B7E6B9E6FBF6B
                8550C564747ECE7D8C7DE774D672FF7FFF7FFF7FFF7F5A6F4A718C7DEF7D527E
                A5644244BD6FFF7FFF7FFF7FFF7F7B67D8529F6F7E6B7E6B7E6B7D6B9F6B7F63
                844CA564317ECD7DCE7D297DEF6DFF7BFF7FFF7FFF77525E4A79EE7DCE7D317E
                A56442449C6FFF7FFF7FFF7FFF7F7B6FD9529F6F7E6B7D6B7D6B5D677E679F67
                85508364EF7DAD7DAD7D6B75396FFF7FFF7FFF7FFF7F395FAD69CE7DCE7D107E
                84644248BD73FF7FFF7FFF7FFF7F9C6FD9529E6F7D6B5D675D675D677D67BF67
                E8544260EF7DAD7D6A79316AFF7BFF7FDE7B9C77FF7FFF7773568C75CE7DEF7D
                215CC650FF7BFF7FFF7FFF7FFF7F9C73D8527D6B5D675D675D675C673B67BF63
                D1590054CE79AD7DCD6DBD6FFF7FFF7FF76A7366FF7BFF7FDE6B3062CE7DCE7D
                0050CE5DFF7FFF7FFF7FFF7FFF7FBD73D8525D675D675C675C673C633C637D63
                5C634350C668EF7D317239733973396F1877187B186F39733973946E317EC668
                42489C77FF7FFF7FFF7FFF7FFF7FBD77D8565D675C675C673C633C633C633B63
                BF63335A004C4A71527E527ED67A397B9C7F9C7F187FD67A737E937E4A710044
                7366FF7FFF7FFF7FFF7FFF7FFF7FBD77D8525C675C673C633C633B633B631B5F
                1C5FBF5F4B5500504A71747E397FBD7FFF7FDE7F7B7F187F947E4A7100486B59
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7BF9563C5F3C633C633B633B5F1B5F1B5F
                1A5F5C5F5D5B4C5100508464AD75737EB57EB57E527EAD7584680050AD5DFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7FF95A3B5F3B633B631B5F1B5F1B5F1B5F
                1A5FF95A1C5B9F5B335A84500050005C005C005C005C00544248CF49FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FF95A1A5B1B5F1B5F1B5F1B5F1A5FFA5A
                FA5AFA5AF95AF95A5D5B1A5754526E51095129516D5112527542F946DE7BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3A63FA5A1B5F1B5F1A5F1A5FFA5AFA5A
                FA5AF95AD95AD956D956FA563C573C573B571C531C531B4F55425446BD77FF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F1963DA561B5F1A5FFA5AFA5AFA5AFA5A
                F95AD956D956D956D956D856B756D856B852B852B852B752754254429C73FF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3A63D956FA5AFA5AFA5AFA5AF95AD956
                D956D956D956D856D856D856B852B852B852B852B752B7525546543E9C73FF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3963B852FB5AFA5AF95AD95AD956D956
                D956D956D856D856B852B852B852B752B752B752B752974E554274427C6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3A63B8523B631A631A5F1A5F1A5F1A5F
                195F195FF95AD95AD956D85AD856D756D752B752974E974E744654427C6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F7C6F55427229B22DD335F435F439143E
                35423642564A764E764E964EB652B652B752B752B752D8563342F2357C6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9C6FB75231190F1130193019501D5119
                311D511D511D711D7121712192259329B329B331D32D1536333EF2357C6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9C73F85A363E721D932593259325B325
                B325B32593259425932593259425B421B32193257421F5355442133A7B6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FBD77B846B84A7742F52DD629F52DF52D
                D62DD62DD62DD52DD52DD52DD529D529D529B525353EB6565446333E7B6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7BFA56D94EF952B84A573E38363936
                583A583A3836383637363836173617361636563EB74EF956FA5676465B6BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7BBE77BD73BC735C63BB4A
                9B3EBB469B469B465B3E593A57425642984AD952FA52FC565E5F97463A63FF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FBE77
                BB4A7A3A9B423A3699469C739C6F7B6B5C633B5F3B5F3B5B3B5B97467B67FF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                DE7B3B637846B94EBE77FF7FFF7FFF7FFF7FFF7FFF7FDE7BDD77DE77FF7FFF7F
                FF7FFF7FFF7F}
              LookAndFeel.Kind = lfOffice11
            end
            object BotonVerArchivo: TsnButton
              Left = 761
              Top = -1
              Width = 53
              Height = 37
              Cursor = crHandPoint
              Hint = 'Ver Archivo'
              TabOrder = 3
              Glyph.Data = {
                42080000424D4208000000000000420000002800000020000000200000000100
                10000300000000080000202E0000202E00000000000000000000007C0000E003
                00001F000000FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FFF7FFF7F7B73136BFF7FFF7FFF7FFF7FFF7FFF7FFF7FDF7BF2669A7B
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FFF7FFF7F964E0035A76E356BFF7BFF7FFF7FFF7B1567485A0052BB77
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FBD77F75E524A09212035E07A6066AB627A735A6B6B5A6062A072C96AFF7B
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7B7B6FB55ACE3D
                A51821080000000002004529817F607FE076A16A8166E076607F007B106BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FBD7759679352AD350825620C00000000
                000086084D1D543ADA4ECD350173807F607F607F607F607F607F0073546BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7F524E0825420C0000000000004300E910F02DB74A
                7C63DF6FFF7BFF7FFF7F1342C462E07FA07FA07FA07FA07FC07F226B7C6FFF7F
                FF7FFF7FFF7FFF7FFF7FEE410000000043000A11F12DB6425B5BDF6FFF7FFF7F
                FF7FFF7FFF7FFF7F5D67724A6473E07FC07FC07FC07FC07FE07F8277566BDF7B
                FF7FFF7FFF7FFF7FBD7BC70C8E1D1A579D6BDF77FF7FFF7FFF7FFF7FFF7FFF7B
                BE6F5A63744A9129EF3DA877E07FE07FE07FE07FE07FE07FE07FE07F636F566B
                FF7FFF7FFF7FFF7F5A6B122EDF73FF7FFF7FFF7FFF7FDF777C6F3A5F944A113E
                D0356E29CC106B29A677E07FE07FE07FE07FE07FE07FE07FE07FE07FE07F8373
                9873FF7FFF7FFF7F5A675436FF7BFF7F395FB54E3342F1356D294C214C216E25
                902D6F25ED41AE77E67FE37FE17FE07FE07FE07FE07FE07FE07FE07FE27FA377
                E8623467FF7FFF7FDE77D12DD031113A6D214D216D258E29AF2DB02DD131D131
                F1318F298A31CB39ED414C4EA95A8977E17FC07FC07FE07F466F895A8E56B256
                9156F35EFE7FFF7FFF7FF85E2D216F29D135D235D135D135B0318F29D131B131
                8F29D135B23171296F297029EE140A21A77FE07FC07F6477F8623C675C6BBE77
                FF7FFF7FFF7FFF7FFF7FDF7B133AD131F135F135F135D135F135D7567C6F7C6B
                964ED135F235F239F239133A1536AA102856E37FA07FEA6E7F6FFF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FD856B12DF235F235F235B029F95AFF7FFF7FFF7F
                BD73D131D231F235F235F235133AB129A61C2677237F4831F95AFF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FBD73133AF23112361236F13154425B679D735B67
                333ED12D12361236123612361236553EEB108349AB664400EF3DFF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FF856D131333A333A333A1236F231F231B029
                F335333A133A333A333A333A333A543EF22DE624596B901984105A6FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FBD77133A1336343A343A343A1332964A5B67
                DE7B7B6BF2311336343E343A343A343A1336D12DFF7F1A4F0000EF45FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FF8561336543E543E543E1336764AFF7F
                FF7FFF7FD852D229343A543E543E543E553ED12D3963FF7BE904420C5A6BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9D6F553E553A553E553E5542F331D852
                FF7FFF7FFF7FF95634361436543A55427642143A123AFF7F973A01003046FF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FF95A153A7642764276425542343A
                F956DE7BFF7FFF7FBD73FA5A553E143655429746B12D195FFF77E908A5187A6F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FBD73553E56427642764277467642
                353676463B5FDE7BFF7FFF7F9D73F956553A7642353A5442FF7FB73A0000304A
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FF956563E9746974677427642
                7642553A353A76425C6BFF7FFF7FFF7F3B63563E984AF2357C6FFF73A8008418
                9C73FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9D6F974697429746B74AD84E
                1957F9567742763E563E7D6BFF7FFF7FFF7FD94E9742553E7546FF7F33222100
                1867FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F1A5B97429742FA5AFF7F
                FF7FFF7FD94E563A3536FA56FF7FFF7FFF7F3B637742D94EF2315B6F7E5BD019
                DD7BFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9D6FB846B84A98465C67
                FF7FFF7FDF7B5B633B5FDE77FF7FFF7FBE77B94E9846D94E9846D035195FBF6B
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F1A53B946B9469842
                1A577C67BE73FF7FFF7BBE777D6F3B5FB846B846D94AD94A1C57F23184109B77
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F7C6BB94AD94ED94E
                B94AB946B94ADA4ADA4AB94AB846B946D94AD94ED94ED94EDA4EFB52C710724E
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFB56BA4ADA4E
                DA4EDA4ABA4AB946BA46B94ABA4ABA46BA46DA4ADA4ADA4EDA4EFB4EB94A9C73
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F7D6BB946DA4A
                DA4EDA4EFB52FB521B571B5B1B5F3C5F5C637D679D6B9D6F9D6FBE73DF7BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7B7C679D6B
                BE73DE77DF7BDF7BFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FFF7F}
              LookAndFeel.Kind = lfOffice11
            end
            object BotonNuevoSinBusqueda: TsnButton
              Left = 4
              Top = -1
              Width = 181
              Height = 37
              Cursor = crHandPoint
              Hint = 'Nuevo Proceso del Candidato'
              Caption = 'Nuevo Sin B'#250'squeda'
              TabOrder = 4
              Glyph.Data = {
                42080000424D4208000000000000420000002800000020000000200000000100
                10000300000000080000202E0000202E00000000000000000000007C0000E003
                00001F000000FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FDE77BE779D737C6F3A5FBD73FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                DE7B9D737D675B631A5FF956D952B84E974A97467642B84AB029944EFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7BBE77BD737C6B3B631A5BD852974A5542
                1236D22DF22D353A553E353E763E7642764676467646D94E13369552FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FD85290298F296E258F25AF2DAF29B031F239
                5442B74E754AD031553EB84A974A974A974AB84AB84AFA4E343AB652FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FB74EF235954AB752F85A1A5F5B675D6F7E6F
                BF73BF733B639652F135543EB84E974AB84AB84AB84AD94E343AB652FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FF8561B5FFF7FFF7BDF77DF77BF739F737F6F
                9F6F3C63B7523D67F95AF135543ED94EB84AB84AB84AD952553EB652FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F195BFA5ABF779F6F9E6F7E6F7E6B7E6B7E6B
                9E6F5C67B752FA5A7D6B3A63F139143AD94EB84EB94EDA527642D652FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F195FD956DF779E6F7E6F7E6B7E6B7E6B7D6B
                7D6F3C67B7521A5F3B637E6B1B63123E343ED952D94EFA527646D756FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F185FD952BF777E6F7E6B7E6B7E6B7D6B7D6B
                7E6B3C63B7521A5F3C633C5F9E6B5C6B133E133AF94EFA4E9746B652FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F5A67D8527F6F7E6B7E6B7D6B7D6B7D6B5D67
                5D673C63B7521B5F3C635C675C677E6B5E6B5446343AFA52B84A954AFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F7B6BD9527F6F7E6B7D6B7D6B5D675D675D67
                5C6B3B6397523B637C6B5D675E675D679F6FDF775546343EB94AB64EFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F9C6FD9529E6F7D6B5D675D675D675D675C67
                5C631C5F96523A637C6B3C633C633C635B637C6B7D6B764A553EB64EFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F9C6FD8527D6B7D6B5D675D675C675C673C63
                3C633B63D956D756D756B652B652B752B652964EF95AD95A333AB64AFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7F9D73D8525D675D675D675C675C673C633C63
                3B633B631B5FFA5AFA5AF95AD95AF95AF95AFA5AFA5ED856343E964AFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FBD77D8525D675C675C673C633C633C633B63
                3B631B5F1B5F1B5F1B5F1A5FFA5AFA5AFB5AFA5A1A5FD85634427546FF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FBD77D8565C675C673C633C633B633B631B5F
                1B5F1B5F1B5F1A5FFA5AFA5AFA5AFA5AF95AD95ADA5AB85654427546DE7BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7BF95A3C5F3C633C633B633B5F1B5F1B5F
                1B5F1A5F1A5FFA5AFA5AFA5AF95AD95AD956D956DA56B9525442754ADE7BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7FF95A3B5F3B633B631B5F1B5F1B5F1B5F
                1A5FFA5AFA5AFA5AFA5AF95AD95AD956D956D956F95AD8563442954ADE7BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FF95A1A5F1B5F1B5F1B5F1B5F1A5FFA5A
                FA5AFA5AFA5AF95AD95AD956D956D956D856D856D856B7525442964ADE7BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3A63FA5A1B5F1B5F1A5FFA5AFA5AFA5A
                FA5AF95AD95AD956D956D956D956D856D856B852B8529852543E7546BD77FF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F195FDA561B5F1A5FFA5AFA5AFA5AFA5A
                F95AD956D956D956D956D856D856D856B852B852B852B752754254429C73FF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3B63D956FA5AFA5AFA5AFA5AF95AD95A
                D956D956D956D856D856D856B852B852B852B852D752B7525546543E9C73FF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3A63B852FB5AFA5AF95AD95AD956D956
                D956D956D856D856B852B852B852B752B752B752B752974E554255429C6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3A63B8523B631A631A5F1A5F1A5F1A5F
                195F195FF95AD95AD956D85AD856D756D752B752974E974E744654427C6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F7C6F55427229B22DD335F435F439143E
                35423642564A764E764E964EB652B652B752B756B752D8563342F2357C6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9C6FB752311D0F1130193019501D5119
                311D511D511D711D7121712192259329B329B32DD32D1536133EF2357C6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9C73F85A353E521D9325B3259325B325
                B325B32593259425932593259325B325B32594257321F5395442333A7B6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FBD77B84AB846563ED62DD629F52DF52D
                D531D52DD52DD52DD52DF52DD529D429D529B525363EB6565446333A7B6FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFE7BFA56D94EF952B84A573E38363936
                583A583A383A383637361836183617361636553EB74EF956FA5676465B6BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7BBE77BD73BC735C63BB4A
                9B3EBB469B469B4A5B3E593A57425642984AD952FA52FC565E5F7742185FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FBE77
                BB4A7A3A9B423A3699469C739C6F7B6B5C633B5F3B5F3B5B3B5B97463A63FF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                DE7B3B637846B94EBE77FF7FFF7FFF7FFF7FFF7FFF7FDE7BDD77BE77FF7FFF7F
                FF7FFF7FFF7F}
              LookAndFeel.Kind = lfOffice11
            end
            object BotonVerBusqueda: TsnButton
              Left = 588
              Top = -1
              Width = 149
              Height = 37
              Cursor = crHandPoint
              Hint = 'Nueva B'#250'squeda'
              Caption = 'Ver B'#250'squeda'
              TabOrder = 5
              Glyph.Data = {
                42080000424D4208000000000000420000002800000020000000200000000100
                10000300000000080000202E0000202E00000000000000000000007C0000E003
                00001F000000FF7FFF7FFF7FFF7FFF7FFF7FDF77D756F85EDF7BFF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FBC739A6BBB6FBB6F3A6F7C77FF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9D6F0B4680456039AA39B756FF7BFF7F
                FF7FFF7FFF7FFF7FFF7FF34E281EC30DA209C209C209610542152F46DF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FF95EA53D267BA16EE04D6239AB399452
                DF77FF7FFF7FBB6F071E60012012811EC022C022A122631AC0012001155BFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9D730E46B677AF7FE372A36A0052603D
                8835B75E375BA105E111073F45432337C12EC22E043746434A47652260011353
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7B2E4A546FF57F667F47770777C56A
                225AA445800102126C4F4847012FC83A1967F962AC3EE23229476D53241E6001
                9967FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F0E461167F67F687F897F8A7F697B
                6A7F4132E20D6F570B4B083B022FEA42FF7FFF7FCF4AC22E093F0A47705B241A
                0512FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F724ED05EF87F8A7F8A7F8B7FCD7F
                6A6BA005EB3A6F570943294303330A43FF7FDF7FCE4AE43229430A436E532E4F
                80011453FF7FFF7FFF7FFF7FFF7FFF7FFF7F94568D56FA7FAE7FAC7FAD7FEE7F
                A63AC20550570D4BC83AC736A32ECA3EFF7FFF7F8E46A32EE83AC93A0C477057
                02124826FF7FFF7FFF7FFF7FFF7FFF7FFF7FD75A6C52FA7FD07FAD7FAE7FF07F
                642E04124D4FF04E175FF55AD4563763FF7FFF7F3867D456F55AF65EB14A4E4F
                6426E411FE7BFF7FFF7FFF7FFF7FFF7FFF7F3A674C4EFA7FF37FCE7FD07FF27F
                452A04160A47545BFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F165B0A47
                862AE40DDD77FF7FFF7FFF7FFF7FFF7FFF7F7C6FEA45B87BF67FD07FF27FF37F
                652A03122A4711539C739B739B73BC77FF7FFF7FDD779B739B73BC73345B2B4B
                8626E30DDD77FF7FFF7FFF7FFF7FFF7FFF7F5D6744355173F77FD17FD27FF47F
                8736C2094D4F0B47EA42EB46EB42F04EFF7FFF7FD352CC420D4BEC460B476E53
                431E0516FF7FFF7FFF7FFF7FFF7FFF7FBE73AB356656F37FF47FF27FF27FF57F
                2E5B80010A432B4F0A472D4B2E4BF252FF7FDF7FB24E0E4F2F4F2D4B4C4B6D53
                A0058D36FF7FFF7FFF7FFF7FFF7FBF734731244EF47FF47FF37FF37FF37FF47F
                F67F241E03166E572D4B2F4F3153155BFF7FFF7FD456115331532E4B905BA832
                A1059A6FFF7FFF7FFF7FFF7FDF7BCD39E349F27FF57FF37FF37FF37FF37FF37F
                F67F70676001872A6F5730533257F55ABD77DE7B165F11533257725B0B478001
                F13EFF7FFF7FFF7FFF7FFF7B8B35E145F27FF47FF27FF27FF27FF27FF27FF27F
                F27FF57FCA422001662A6F5B746336631763F762365F745F915F0B43A0018011
                0F4ABF77FF7FFF7FFF7B3146A141AD7BF27FF07FF07FF07FF07FF07FF07FF07F
                EF7FF07FF27FC9466001E211CA3A4F53515731574F530C474522800144262B6B
                A245EF3DFF7BFF7FEE41803DCC7FEF7FCD7BCE7BCE7BCE7BCE7BCE7BCE7BCE7B
                CE7BCE7BEF7FF17F8D67462EA001A001E109E10DC0058001E3150A4FF07FAE7F
                296BC24110461963C4418E77F37FCF7BCE7BCD7BCC7BCC7BCD7BCD7BCD7BCE7B
                CD7BCD7BCD7BCD7BEF7FF07F6C67C846853A8536A73A2957EF7FF17FF07FF07F
                8E77696FC341D65AAF5AB67BD47FF57FF67FF67FF47FF27FF07BCD7BCB7BCC7B
                CD7BCD7BCD7BCD7BCD7BCD7FEE7FEF7FEF7FEF7FF17FF17FF07FF07FEE7FEE7F
                CC7F066BA43DBE772F4AA639E7452852AB5A0D677173D47BF47FF77FF57FAD7B
                AB7BAD7BAD7BAD7BAD7BAD7BAD7BAD7BCD7FEE7FCC7FAB77286BA55E4452E349
                A43D85397352FF7FDF7B5B6BF85E9452314A0D46EA3DC73DE7454952DD7FFC7F
                A97BAA7BAB7BAB7BAB7BAB7BAB7B6B73C762034EA3418439A93DED41524E9552
                F85A7D6FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9E731963B656AC396D52FF7F
                D17F887B8B7B8A7B8A7BAB7F8A77076B6239AE35B756F95E9E73FF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FA9391167
                FE7F897B88778A778A77AA7B4973214EAB35DF7BFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FB556A73D
                FE7FD47B66778977897B6977A46242391A5FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F0E42
                F162FF7F6A776677697B076FA045AD39FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F5B67
                E841FC7FD37F64774773835E65353B63FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                AA396C52FF7F6C77E36AA0411042FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                19638635DB7BD57F405643315B6BFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7F94526E52CE7F4035534AFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FDF774F4A054A0D46BF77FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FDE775B67FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
                FF7FFF7FFF7F}
              LookAndFeel.Kind = lfOffice11
            end
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerRecluPostulante'
    OperGrabarObjeto = 'SaveRecluPostulante'
    CargaDataSets = <
      item
        DataSet = TRecluPostulante
        TableName = 'TRecluPostulante'
      end
      item
        DataSet = TGenerosPostulantes
        TableName = 'TGenerosPostulantes'
      end
      item
        DataSet = TRecluCompetencia
        TableName = 'TRecluCompetencia'
      end
      item
        DataSet = TRecluCurriculum
        TableName = 'TRecluCurriculum'
      end
      item
        DataSet = TRecluNovedadPostu
        TableName = 'TRecluNovedadPostu'
      end
      item
        DataSet = TArchivoPostulante
        TableName = 'TArchivoPostulante'
      end
      item
        DataSet = TRecluPuestoAplica
        TableName = 'TRecluPuestoAplica'
      end
      item
        DataSet = TProcesosCandidato
        TableName = 'TProcesosCandidato'
      end>
    BajaLogica = <
      item
        DataSet = TRecluPostulante
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TRecluPostulante
    DataSetDet1 = TRecluCompetencia
    DataSetDet2 = TRecluCurriculum
    DataSetDet3 = TRecluNovedadPostu
    DataSetDet4 = TRecluPuestoAplica
    DataSetDet5 = TProcesosCandidato
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 24
  end
  inherited Operacion: TOperacion
    Left = 544
    Top = 24
  end
  object TRecluPostulante: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_postulante'
        DataType = ftInteger
      end
      item
        Name = 'ape_y_nom'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_tipo_docu'
        DataType = ftInteger
      end
      item
        Name = 'nro_docu'
        DataType = ftString
        Size = 30
      end
      item
        Name = 'oid_convenio'
        DataType = ftInteger
      end
      item
        Name = 'fec_nacimiento'
        DataType = ftDate
      end
      item
        Name = 'telefono_celular'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'localidad'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'direccion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'cod_postal'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'telefono_fijo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'referido_por'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'sexo'
        DataType = ftString
        Size = 1
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
      end
      item
        Name = 'es_referido'
        DataType = ftBoolean
      end
      item
        Name = 'nro_referido'
        DataType = ftInteger
      end
      item
        Name = 'oid_fuente'
        DataType = ftInteger
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
    Left = 600
    Top = 195
    object TRecluPostulanteoid_postulante: TIntegerField
      FieldName = 'oid_postulante'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRecluPostulanteape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TRecluPostulanteoid_tipo_docu: TIntegerField
      FieldName = 'oid_tipo_docu'
    end
    object TRecluPostulantenro_docu: TStringField
      FieldName = 'nro_docu'
      Size = 30
    end
    object TRecluPostulanteoid_convenio: TIntegerField
      FieldName = 'oid_convenio'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRecluPostulantefec_nacimiento: TDateField
      FieldName = 'fec_nacimiento'
    end
    object TRecluPostulantetelefono_celular: TStringField
      FieldName = 'telefono_celular'
      Size = 50
    end
    object TRecluPostulantelocalidad: TStringField
      FieldName = 'localidad'
      Size = 100
    end
    object TRecluPostulantedireccion: TStringField
      FieldName = 'direccion'
      Size = 100
    end
    object TRecluPostulantecod_postal: TStringField
      FieldName = 'cod_postal'
      Size = 50
    end
    object TRecluPostulantetelefono_fijo: TStringField
      FieldName = 'telefono_fijo'
      Size = 50
    end
    object TRecluPostulantereferido_por: TStringField
      FieldName = 'referido_por'
      Size = 100
    end
    object TRecluPostulantesexo: TStringField
      FieldName = 'sexo'
      Size = 1
    end
    object TRecluPostulantecodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TRecluPostulantedescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TRecluPostulanteactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TRecluPostulantees_referido: TBooleanField
      FieldName = 'es_referido'
    end
    object TRecluPostulantenro_referido: TIntegerField
      FieldName = 'nro_referido'
    end
    object TRecluPostulanteoid_fuente: TIntegerField
      FieldName = 'oid_fuente'
    end
    object TRecluPostulanteoid_estado_postu: TIntegerField
      FieldName = 'oid_estado_postu'
    end
    object TRecluPostulantefec_est_postu: TDateField
      FieldName = 'fec_est_postu'
    end
  end
  object DSTRecluPostulante: TDataSource [4]
    DataSet = TRecluPostulante
    Left = 632
    Top = 195
  end
  inherited TOidObjSave: TsnTable
    Left = 608
  end
  inherited TOpcHabPrograma: TsnTable
    Top = 16
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
    Left = 184
    Top = 200
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      '  AplicarSeguridad();'
      'end.')
    OnValidate = <
      item
        TableName = 'TRecluPostulante'
        FieldName = 'nro_docu'
        Source.Strings = (
          'begin'
          '  ValidadorPostulante.Value := Sender.AsString;'
          '  ValidadorPostulante.Validar();'
          'end.')
      end>
    OnChangeField = <
      item
        TableName = 'TProcesosCandidato'
        FieldName = 'oid_proceso'
        Source.Strings = (
          'begin'
          '  TProcesosCandidato.FieldName('#39'oid_conc_proceso'#39').Clear;'
          '  TProcesosCandidato.FieldName('#39'concepto'#39').Clear;'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TRecluCompetencia'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_competencia'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la compete' +
            'ncia'#39');'
          'end.')
      end
      item
        TableName = 'TRecluCurriculum'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'fecha_recepcion'#39').IsNull)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la fecha ' +
            'de Recepci'#243'n'#39');'
          'end.')
      end
      item
        TableName = 'TRecluNovedadPostu'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'fecha'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha d' +
            'e la anotaci'#243'n'#39');'
          ' if (DataSet.FieldName('#39'novedad'#39').AsString='#39#39')'
          
            '    then raiseException(erCustomError,'#39'Debe ingresar la anotaci'#243 +
            'n'#39');'
          ' if (DataSet.FieldName('#39'exc_fut_postu'#39').IsNull)'
          
            '    then raiseException(erCustomError,'#39'Debe ingresar si se debe ' +
            'excluir o no en la postulaci'#243'n'#39');'
          'end.')
      end
      item
        TableName = 'TRecluPuestoAplica'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_puesto_busqueda'#39').AsInteger = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Puesto'#39 +
            ');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TRecluPostulante'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end
      item
        TableName = 'TRecluCompetencia'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_postulante'#39').AsInteger :='
          '        TRecluPostulante.FieldName('#39'oid_postulante'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end
      item
        TableName = 'TRecluCurriculum'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_postulante'#39').AsInteger :='
          '        TRecluPostulante.FieldName('#39'oid_postulante'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          '  DataSet.FieldName('#39'adjuntar'#39').Value := '#39'...'#39';'
          '  DataSet.FieldName('#39'visualizar'#39').Value := '#39'...'#39';'
          
            '  DataSet.FieldName('#39'nro_archivo_cv'#39').AsInteger :=  getNroArchiv' +
            'o();'
          '  '
          'end.')
      end
      item
        TableName = 'TRecluNovedadPostu'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_postulante'#39').Value := TRecluPostulante.' +
            'FieldName('#39'oid_postulante'#39').Value;'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          '  DataSet.FieldName('#39'exc_fut_postu'#39').Value := false;'
          'end.')
      end
      item
        TableName = 'TRecluPuestoAplica'
        Source.Strings = (
          'begin'
          
            '   DataSet.FieldName('#39'oid_postulante'#39').AsInteger := TRecluPostul' +
            'ante.FieldName('#39'oid_postulante'#39').AsInteger;'
          '   DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end
      item
        TableName = 'TProcesosCandidato'
        Source.Strings = (
          'begin'
          '   DataSet.FieldName('#39'activo'#39').Value := true;'
          
            '   DataSet.FieldName('#39'oid_postulante'#39').AsInteger := TRecluPostul' +
            'ante.FieldName('#39'oid_postulante'#39').AsInteger;'
          'end.')
      end>
    OnPublicVariable = <
      item
        VariableName = 'OPEN_BY_ID'
      end
      item
        VariableName = 'oid_cco'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '    TTipoDocumento.loadFromHelp('#39'HelpTipoDocumento'#39');'
          '    TCompetencias.loadFromHelp('#39'HelpCompetencias'#39');'
          '    TRecluFuente.loadFromHelp('#39'HelpFuente'#39');'
          '    TraerGeneros();'
          '    cargarSiNo();'
          '    SeleccionFile.setTipoImagen();'
          '    TRecluProceso.loadFromHelp('#39'HelpProceso'#39');'
          '    TEstadoProceso.loadFromHelp('#39'HelpEstadoProceso'#39');'
          '    TEstadoPostulante.loadFromHelp('#39'HelpEstadoPostulante'#39');'
          'end.')
      end>
    OnAfterTraerObjeto = <
      item
        Source.Strings = (
          'begin'
          '  TraerFoto();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure puedeUtilizarBoton();'
          'begin'
          '  if (DriverABM.isNuevo OR DriverABM.isModificar)'
          
            '      then raiseException(erCustomError,'#39'Para utilizar esta opci' +
            #243'n NO debe encontrar en modo edici'#243'n o alta.'#39');'
          'end;'
          ''
          
            'procedure EliminarProcesoCandidato(OidProcesoCandidato : integer' +
            ');'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveRecluEiminarProcCandi'#39');'
          
            '  operacion.AddAtribute('#39'oid_proceso_candidato'#39',IntToStr(OidProc' +
            'esoCandidato));'
          '  operacion.execute();'
          'end;'
          ''
          ''
          'procedure TraerGeneros();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerRecluGenerosPostu'#39');'
          ' operacion.execute();'
          'end;'
          ''
          'procedure cargarSiNo();'
          'begin'
          '  TSiNo.Close;'
          '  TSiNo.open;'
          ''
          '  TSiNo.AppendRecord;'
          '  TSiNo.FieldName('#39'codigo'#39').Value := true;'
          '  TSiNo.FieldName('#39'descripcion'#39').Value := '#39'SI'#39';'
          '  TSiNo.PostRecord;'
          ''
          '  TSiNo.AppendRecord;'
          '  TSiNo.FieldName('#39'codigo'#39').Value := false;'
          '  TSiNo.FieldName('#39'descripcion'#39').Value := '#39'NO'#39';'
          '  TSiNo.PostRecord;'
          'end;'
          ''
          ''
          'procedure TraerFoto();'
          'var'
          '  mensajeError : string;'
          '  nomTempFile : string;'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'DownloadFotoPostulante'#39');'
          
            '  nomTempFile := operacion.DownLoadFile(TRecluPostulante.FieldNa' +
            'me('#39'oid_postulante'#39').AsString, mensajeError);'
          '  foto.LoadFromFile(nomTempFile);'
          'end;'
          ''
          ''
          'function getNroArchivo() : integer;'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveRecluNewNroArchPostu'#39');'
          '  operacion.execute();'
          
            '  result :=  TArchivoPostulante.FieldName('#39'nro_archivo'#39').AsInteg' +
            'er;'
          'end;'
          ''
          'procedure recargarTiposExamenes();'
          'begin'
          '  HelpTipoExamenes.clearAtributos;'
          
            '  HelpTipoExamenes.addAtributo('#39'oid_proceso'#39',TProcesosCandidato.' +
            'FieldName('#39'oid_proceso'#39').AsString);'
          '  HelpTipoExamenes.Mostrar();'
          'end;'
          ''
          ''
          ''
          'procedure consultaBusqueda();'
          'begin'
          ''
          
            '  if (TProcesosCandidato.FieldName('#39'oid_busqueda_act'#39').AsInteger' +
            ' = 0)'
          
            '      then raiseException(erCustomError,'#39'Debe seleccionar una B'#250 +
            'squeda'#39');'
          ' '
          ' TInput.Close;'
          ' TInput.Open;'
          ' TInput.AppendRecord;'
          
            ' TInput.FieldName('#39'oid_busqueda_act'#39').AsInteger :=  TProcesosCan' +
            'didato.FieldName('#39'oid_busqueda_act'#39').AsInteger;'
          ' TInput.PostRecord;'
          ' '
          '  TInputCompetencias.Close;'
          '  TInputCompetencias.Open;'
          ''
          '  TCompetenciasPostulantes.close;'
          '  TCompetenciasPostulantes.open;'
          ''
          '  TCandidatosEnEstado.close;'
          '  TCandidatosEnEstado.open;'
          ''
          '  TPostulacionesAplica.close;'
          '  TPostulacionesAplica.open;'
          ''
          '  TProcesosEnEstado.close;'
          '  TProcesosEnEstado.open;'
          ''
          '  variable.newVariantArray('#39'parametros'#39',6);'
          
            '  variable.addKeyTableForArray('#39'parametros'#39',0,'#39'TInput'#39','#39'TInput'#39')' +
            ';  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',1,'#39'TInputCompetencia' +
            's'#39','#39'TInputCompetencias'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',2,'#39'TCompetenciasPost' +
            'ulantes'#39','#39'TCompetenciasPostulantes'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',3,'#39'TCandidatosEnEsta' +
            'do'#39','#39'TCandidatosEnEstado'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',4,'#39'TPostulacionesApl' +
            'ica'#39','#39'TPostulacionesAplica'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',5,'#39'TProcesosEnEstado' +
            #39','#39'TProcesosEnEstado'#39');  '
          ''
          '   FormBusqueda.params :=  variable.getValue('#39'parametros'#39');  '
          '   FormBusqueda.ventana := getVentana();'
          '   FormBusqueda.Mostrar(false);'
          ''
          ''
          'end;'
          ''
          ''
          'procedure AplicarSeguridad();'
          'begin'
          ''
          '  if (varios.isFuncionSeguridadHabilitada(1000021,'#39#39',false))'
          '              then BotonNuevoSinBusqueda.setVisible(true)'
          '              else BotonNuevoSinBusqueda.setVisible(false);'
          ''
          '  if (varios.isFuncionSeguridadHabilitada(1000022,'#39#39',false))'
          '              then BotonAgregarProcAlCandi.setVisible(true)'
          '              else BotonAgregarProcAlCandi.setVisible(false);'
          ''
          '  if (varios.isFuncionSeguridadHabilitada(1000023,'#39#39',false))'
          
            '              then BotonModificarProcesoCandidato.setVisible(tru' +
            'e)'
          
            '              else BotonModificarProcesoCandidato.setVisible(fal' +
            'se);'
          ''
          '  if (varios.isFuncionSeguridadHabilitada(1000024,'#39#39',false))'
          
            '              then BotonEliminarProcesoCandidato.setVisible(true' +
            ')'
          
            '              else BotonEliminarProcesoCandidato.setVisible(fals' +
            'e);'
          ''
          '  if (varios.isFuncionSeguridadHabilitada(1000025,'#39#39',false))'
          '              then BotonVerBusqueda.setVisible(true)'
          '              else BotonVerBusqueda.setVisible(false);'
          ''
          '  if (varios.isFuncionSeguridadHabilitada(1000026,'#39#39',false))'
          '              then BotonVerArchivo.setVisible(true)'
          '              else BotonVerArchivo.setVisible(false);'
          ''
          ''
          'end;')
      end>
    OnAfterNuevo = <
      item
        Source.Strings = (
          'begin'
          '  SeleccionFile.clearStream();'
          'end.')
      end>
    OnAfterGrabar = <
      item
        Source.Strings = (
          'var'
          '  mensajeError : string;'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'UploadFotoPostulante'#39');'
          '  operacion.UploadFile('
          '        Foto.getDataStream(),'
          '        TOidObjSave.FieldName('#39'oid'#39').AsString,'
          '        '#39#39','#39#39',true,mensajeError);'
          'end.'
          ''
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonElegirImagen'
        Source.Strings = (
          'begin'
          
            '  if (not (DriverABM.isModificar or DriverABM.isNuevo)) then exi' +
            't;'
          '  if (SeleccionFile.execute())'
          '     then Foto.LoadFromFile(SeleccionFile.getFileName());'
          'end.'
          '')
      end
      item
        ButtonName = 'BorrarImagen'
        Source.Strings = (
          'begin'
          
            '  if (not (DriverABM.isModificar or DriverABM.isNuevo)) then exi' +
            't;'
          '  Foto.LoadFromFile('#39#39#39#39');'
          'end.')
      end
      item
        ButtonName = 'BotonModificarProcesoCandidato'
        Source.Strings = (
          'var'
          '  oidVolver : integer;'
          'begin'
          ''
          '  puedeUtilizarBoton();'
          ''
          '  if (TProcesosCandidato.IsEmpty())'
          
            '     then raiseException(erCustomError,'#39'No se encuentra seleccio' +
            'nado un proceso del candidato.'#39');'
          ''
          ''
          
            '  FormAgregarProcAndi.setInteger('#39'oid_candidato_busq'#39',TProcesosC' +
            'andidato.FieldName('#39'oid_candidato_busq'#39').AsInteger);'
          
            '  FormAgregarProcAndi.setInteger('#39'oid_proceso_sel'#39',TProcesosCand' +
            'idato.FieldName('#39'oid_proceso_sel'#39').AsInteger);'
          
            '  FormAgregarProcAndi.setInteger('#39'oid_postulante'#39',TRecluPostulan' +
            'te.FieldName('#39'oid_postulante'#39').AsInteger);'
          '  FormAgregarProcAndi.Mostrar(true);'
          ''
          
            '  oidVolver := TProcesosCandidato.FieldName('#39'oid_proceso_sel'#39').A' +
            'sInteger;'
          ''
          
            '  DriverABM.buscarObjetoByOid(TRecluPostulante.FieldName('#39'oid_po' +
            'stulante'#39').AsInteger);'
          ''
          '  TProcesosCandidato.locate('#39'oid_proceso_sel'#39',oidVolver,[]);'
          '  dxDBGridSN5.setFoco();'
          ''
          'end.')
      end
      item
        ButtonName = 'BotonEliminarProcesoCandidato'
        Source.Strings = (
          'begin'
          ''
          '  puedeUtilizarBoton();'
          ''
          '  if (TProcesosCandidato.IsEmpty())'
          
            '     then raiseException(erCustomError,'#39'No se encuentra seleccio' +
            'nado un proceso del candidato.'#39');'
          ''
          
            '  if (not mensaje.question('#39'Desea eliminar el Proceso del Candid' +
            'ato?'#39')) then exit;'
          
            '  EliminarProcesoCandidato(TProcesosCandidato.FieldName('#39'oid_pro' +
            'ceso_sel'#39').AsInteger);'
          ''
          
            '  DriverABM.buscarObjetoByOid(TRecluPostulante.FieldName('#39'oid_po' +
            'stulante'#39').AsInteger);'
          ''
          ''
          'end.')
      end
      item
        ButtonName = 'BotonVerArchivo'
        Source.Strings = (
          'var'
          '  nomTempFile : string;'
          '  mensajeError : string;'
          'begin'
          ''
          '  puedeUtilizarBoton();'
          ''
          '  if (TProcesosCandidato.FieldName('#39'nro_archivo'#39').AsInteger = 0)'
          
            '     then raiseException(erCustomError,'#39'No se encuentra archivo ' +
            'adjunto al proceso'#39');'
          ''
          ''
          '  mensajeError := '#39#39';'
          
            '  SaveAdjunto.setFileName(TProcesosCandidato.FieldName('#39'nombre_a' +
            'rchivo'#39').AsString);'
          
            '  SaveAdjunto.setDefaultExt(Varios.getFileExtension(TProcesosCan' +
            'didato.FieldName('#39'nombre_archivo'#39').AsString));'
          '  if (SaveAdjunto.show())'
          '     then begin'
          ''
          '               operacion.InicioOperacion();'
          '               operacion.setOper('#39'DownloadArchProcPostulante'#39');'
          
            '               nomTempFile := operacion.DownLoadFile(TProcesosCa' +
            'ndidato.FieldName('#39'nro_archivo'#39').AsString, mensajeError);       ' +
            '                           '
          
            '               nomTempFile := varios.renombrarArchivo(nomTempFil' +
            'e, SaveAdjunto.getFileName());                        '
          ''
          '               if (varios.abrirArchivo(nomTempFile)=false)'
          
            '                  then mensaje.information('#39'No se encontr'#243' aplic' +
            'aci'#243'n asociada al archivo que se desea abrir'#39');                 ' +
            '       '
          ''
          '               end;'
          'end.'
          ''
          '')
      end
      item
        ButtonName = 'BotonAgregarProcAlCandi'
        Source.Strings = (
          'begin'
          ''
          '  puedeUtilizarBoton();'
          ''
          '  if (TProcesosCandidato.isEmpty())'
          
            '     then raiseException(erCustomError,'#39'Se debe seleccionar un P' +
            'roceso dentro de una B'#250'squeda'#39');'
          ''
          
            '  if (TProcesosCandidato.FieldName('#39'oid_candidato_busq'#39').AsInteg' +
            'er = 0)'
          
            '   then raiseException(erCustomError,'#39'Se debe seleccionar un Pro' +
            'ceso dentro de una B'#250'squeda'#39');'
          ''
          
            '  FormAgregarProcAndi.setInteger('#39'oid_candidato_busq'#39',TProcesosC' +
            'andidato.FieldName('#39'oid_candidato_busq'#39').AsInteger);'
          '  FormAgregarProcAndi.setInteger('#39'oid_proceso_sel'#39',-1);'
          
            '  FormAgregarProcAndi.setInteger('#39'oid_postulante'#39',TRecluPostulan' +
            'te.FieldName('#39'oid_postulante'#39').AsInteger);'
          ''
          '  FormAgregarProcAndi.Mostrar(true);'
          ''
          
            '  DriverABM.buscarObjetoByOid(TRecluPostulante.FieldName('#39'oid_po' +
            'stulante'#39').AsInteger);'
          ''
          'end.')
      end
      item
        ButtonName = 'BotonNuevoSinBusqueda'
        Source.Strings = (
          'begin'
          ''
          '  puedeUtilizarBoton();'
          ''
          '  if (TRecluPostulante.FieldName('#39'oid_postulante'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Se debe seleccionar un p' +
            'ostulante'#39');'
          ''
          
            '  FormAgregarProcAndi.setInteger('#39'oid_postulante'#39',TRecluPostulan' +
            'te.FieldName('#39'oid_postulante'#39').AsInteger);'
          '  FormAgregarProcAndi.setInteger('#39'oid_candidato_busq'#39',-1);'
          '  FormAgregarProcAndi.setInteger('#39'oid_proceso_sel'#39',-1);'
          '  FormAgregarProcAndi.Mostrar(true);'
          ''
          
            '  DriverABM.buscarObjetoByOid(TRecluPostulante.FieldName('#39'oid_po' +
            'stulante'#39').AsInteger);'
          ''
          'end.')
      end
      item
        ButtonName = 'BotonVerBusqueda'
        Source.Strings = (
          'begin'
          ''
          '  puedeUtilizarBoton();'
          ''
          '  consultaBusqueda();'
          ''
          'end.')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'cxGridDBAdjuntar'
        Source.Strings = (
          'var'
          '  mensajeError : string;'
          'begin'
          ''
          
            '  if (not (DriverABM.isNuevo OR DriverABM.isModificar)) then exi' +
            't;'
          ''
          '  if (AdjArchivo1.show())'
          '      then begin'
          ''
          '              TRecluCurriculum.EditRecord;'
          
            '              TRecluCurriculum.FieldName('#39'nombre_archivo'#39').AsStr' +
            'ing := AdjArchivo1.getFile();'
          ''
          
            '              if (TRecluCurriculum.FieldName('#39'nro_archivo_cv'#39').A' +
            'sInteger = 0)'
          '                 then begin'
          
            '                         TRecluCurriculum.FieldName('#39'nro_archivo' +
            '_cv'#39').AsInteger := getNroArchivo();'
          '                         end;'
          ''
          '              operacion.InicioOperacion();'
          '                        operacion.setOper('#39'UploadCVPostulante'#39');'
          '                        operacion.UploadFile('
          '                        AdjArchivo1.getDataStream(),'
          
            '                       TRecluCurriculum.FieldName('#39'nro_archivo_c' +
            'v'#39').AsString,'
          '                        '#39#39','#39#39','
          '                        true,'
          '                        mensajeError);'
          ''
          '              end;'
          '              '
          ''
          'end.')
      end
      item
        ColumnName = 'cxGridDBTableViewVisualizar'
        Source.Strings = (
          'var'
          '  nomTempFile : string;'
          '  mensajeError : string;'
          'begin'
          '  mensajeError := '#39#39';'
          
            '  SaveAdjunto.setFileName(TRecluCurriculum.FieldName('#39'nombre_arc' +
            'hivo'#39').AsString);'
          
            '  SaveAdjunto.setDefaultExt(Varios.getFileExtension(TRecluCurric' +
            'ulum.FieldName('#39'nombre_archivo'#39').AsString));'
          '  if (SaveAdjunto.show())'
          '     then begin'
          ''
          '               operacion.InicioOperacion();'
          '               operacion.setOper('#39'DownloadCVPostulante'#39');'
          
            '               nomTempFile := operacion.DownLoadFile(TRecluCurri' +
            'culum.FieldName('#39'nro_archivo_cv'#39').AsString, mensajeError);      ' +
            '                            '
          
            '               nomTempFile := varios.renombrarArchivo(nomTempFil' +
            'e, SaveAdjunto.getFileName());                        '
          ''
          '               if (varios.abrirArchivo(nomTempFile)=false)'
          
            '                  then mensaje.information('#39'No se encontr'#243' aplic' +
            'aci'#243'n asociada al archivo que se desea abrir'#39');                 ' +
            '       '
          ''
          '               end;'
          'end.')
      end
      item
        ColumnName = 'cxGridDBTableView4oid_puesto_busqueda'
        Source.Strings = (
          'begin'
          '  HelpPuesto.Mostrar();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBBandedTableView3concepto'
        Source.Strings = (
          'begin'
          '  recargarTiposExamenes();'
          'end.')
      end>
    Left = 152
    Top = 203
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 112
    Top = 336
  end
  inherited PopUp: TsnPopUp
    Left = 112
    Top = 204
  end
  inherited TPathHelp: TsnTable
    Left = 552
    Top = 549
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 144
    Top = 339
  end
  object HelpPostulantes: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluPostulante'
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
    Titulo = 'Convenios'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 34
    Top = 204
  end
  object ValidadorPostulante: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluPostulante'
    WhenRaiseException = teFound
    MensajeException = 'Codigo de Postulante Existente'
    NroQuery = 0
    Cache = False
    Left = 72
    Top = 203
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
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 336
    Top = 234
  end
  object TTipoDocumento: TsnTable
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
    Left = 370
    Top = 234
    object IntegerField4: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField9: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField10: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTipoDocumentos: TDataSource
    DataSet = TTipoDocumento
    Left = 404
    Top = 235
  end
  object TGenerosPostulantes: TsnTable
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
    Top = 132
    object TGenerosPostulantescodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TGenerosPostulantesdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSGenerosPostulantes: TDataSource
    DataSet = TGenerosPostulantes
    Left = 592
    Top = 132
  end
  object TRecluCompetencia: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_compe_postu'
        DataType = ftInteger
      end
      item
        Name = 'oid_postulante'
        DataType = ftInteger
      end
      item
        Name = 'oid_competencia'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_postulante'
    IndexDefs = <
      item
        Name = 'TRecluCompetenciaIndex1'
        Fields = 'oid_postulante'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_postulante'
    MasterSource = DSTRecluPostulante
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 520
    Top = 244
    object TRecluCompetenciaoid_compe_postu: TIntegerField
      FieldName = 'oid_compe_postu'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRecluCompetenciaoid_postulante: TIntegerField
      FieldName = 'oid_postulante'
    end
    object TRecluCompetenciaoid_competencia: TIntegerField
      FieldName = 'oid_competencia'
    end
    object TRecluCompetenciagrupo_competencia: TStringField
      FieldName = 'grupo_competencia'
      Size = 100
    end
    object TRecluCompetenciaactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTRecluCompetencia: TDataSource
    DataSet = TRecluCompetencia
    Left = 552
    Top = 244
  end
  object HelpCompetencias: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluCompetencias'
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
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 336
    Top = 279
  end
  object TCompetencias: TsnTable
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
    Left = 370
    Top = 279
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
  object DSCompetencias: TDataSource
    DataSet = TCompetencias
    Left = 404
    Top = 280
  end
  object TRecluCurriculum: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_curriculum'
        DataType = ftInteger
      end
      item
        Name = 'oid_postulante'
        DataType = ftInteger
      end
      item
        Name = 'fecha_recepcion'
        DataType = ftDate
      end
      item
        Name = 'entregado_por'
        DataType = ftString
        Size = 100
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
    IndexFieldNames = 'oid_postulante'
    IndexDefs = <
      item
        Name = 'TRecluCurriculumIndex1'
        Fields = 'oid_postulante'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_postulante'
    MasterSource = DSTRecluPostulante
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 632
    Top = 244
    object TRecluCurriculumoid_curriculum: TIntegerField
      FieldName = 'oid_curriculum'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRecluCurriculumoid_postulante: TIntegerField
      FieldName = 'oid_postulante'
    end
    object TRecluCurriculumfecha_recepcion: TDateField
      FieldName = 'fecha_recepcion'
    end
    object TRecluCurriculumentregado_por: TStringField
      FieldName = 'entregado_por'
      Size = 100
    end
    object TRecluCurriculumobservacion: TStringField
      FieldName = 'observacion'
      Size = 1000
    end
    object TRecluCurriculumadjuntar: TStringField
      FieldName = 'adjuntar'
      Size = 255
    end
    object TRecluCurriculumvisualizar: TStringField
      FieldName = 'visualizar'
      Size = 255
    end
    object TRecluCurriculumnro_archivo_cv: TIntegerField
      FieldName = 'nro_archivo_cv'
    end
    object TRecluCurriculumactivo: TBooleanField
      FieldName = 'activo'
    end
    object TRecluCurriculumnombre_archivo: TStringField
      FieldName = 'nombre_archivo'
      Size = 500
    end
    object TRecluCurriculumpath_archivo: TStringField
      FieldName = 'path_archivo'
      Size = 500
    end
  end
  object DSTRecluCurriculum: TDataSource
    DataSet = TRecluCurriculum
    Left = 672
    Top = 244
  end
  object TSiNo: TsnTable
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
    Left = 296
    Top = 356
    object TSiNocodigo: TBooleanField
      FieldName = 'codigo'
    end
    object TSiNodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 2
    end
  end
  object DSSiNo: TDataSource
    DataSet = TSiNo
    Left = 328
    Top = 356
  end
  object TRecluNovedadPostu: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_nov_postu'
        DataType = ftInteger
      end
      item
        Name = 'oid_postulante'
        DataType = ftInteger
      end
      item
        Name = 'fecha'
        DataType = ftDate
      end
      item
        Name = 'novedad'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'exc_fut_postu'
        DataType = ftBoolean
      end
      item
        Name = 'oid_usuario'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_postulante'
    IndexDefs = <
      item
        Name = 'TRecluNovedadPostuIndex1'
        Fields = 'oid_postulante'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_postulante'
    MasterSource = DSTRecluPostulante
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 481
    Top = 476
    object TRecluNovedadPostuoid_nov_postu: TIntegerField
      FieldName = 'oid_nov_postu'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRecluNovedadPostuoid_postulante: TIntegerField
      FieldName = 'oid_postulante'
    end
    object TRecluNovedadPostufecha: TDateField
      FieldName = 'fecha'
    end
    object TRecluNovedadPostunovedad: TStringField
      FieldName = 'novedad'
      Size = 4000
    end
    object TRecluNovedadPostuexc_fut_postu: TBooleanField
      FieldName = 'exc_fut_postu'
    end
    object TRecluNovedadPostuoid_usuario: TIntegerField
      FieldName = 'oid_usuario'
    end
    object TRecluNovedadPostuactivo: TBooleanField
      FieldName = 'activo'
    end
    object TRecluNovedadPostufec_vigencia: TDateField
      FieldName = 'fec_vigencia'
    end
  end
  object DSTRecluNovedadPostu: TDataSource
    DataSet = TRecluNovedadPostu
    Left = 521
    Top = 476
  end
  object SeleccionFile: TSeleccionFile
    Left = 305
    Top = 214
  end
  object TArchivoPostulante: TsnTable
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
    Left = 305
    Top = 484
    object TArchivoPostulantenro_archivo: TIntegerField
      FieldName = 'nro_archivo'
    end
  end
  object AdjArchivo1: TSNOpenDialog
    Left = 264
    Top = 142
  end
  object SaveAdjunto: TsnSaveDialog
    OptionsEx = [ofExNoPlacesBar]
    Left = 488
    Top = 166
  end
  object varios: TsnVarios
    Operacion = Operacion
    Left = 504
    Top = 102
  end
  object HelpFuente: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluFuente'
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
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 461
    Top = 548
  end
  object TRecluFuente: TsnTable
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
    Left = 503
    Top = 548
    object IntegerField43: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField44: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField45: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSRecluFuente: TDataSource
    DataSet = TRecluFuente
    Left = 601
    Top = 548
  end
  object TRecluPuestoAplica: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_puesto_aplica'
        DataType = ftInteger
      end
      item
        Name = 'oid_postulante'
        DataType = ftInteger
      end
      item
        Name = 'oid_puesto_busqueda'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_postulante'
    IndexDefs = <
      item
        Name = 'TRecluPuestoAplicaIndex1'
        Fields = 'oid_postulante'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_postulante'
    MasterSource = DSTRecluPostulante
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 729
    Top = 247
    object TRecluPuestoAplicaoid_puesto_aplica: TIntegerField
      FieldName = 'oid_puesto_aplica'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRecluPuestoAplicaoid_postulante: TIntegerField
      FieldName = 'oid_postulante'
    end
    object TRecluPuestoAplicaoid_puesto_busqueda: TIntegerField
      FieldName = 'oid_puesto_busqueda'
    end
    object TRecluPuestoAplicaactivo: TBooleanField
      FieldName = 'activo'
    end
    object TRecluPuestoAplicanombre_puesto: TStringField
      FieldName = 'nombre_puesto'
      Size = 100
    end
  end
  object DSTRecluPuestoAplica: TDataSource
    DataSet = TRecluPuestoAplica
    Left = 761
    Top = 247
  end
  object HelpPuesto: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluPuesto'
    NroHelp = 0
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        AsignarACampo = TRecluPuestoAplicaoid_puesto_busqueda
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
        AsignarACampo = TRecluPuestoAplicanombre_puesto
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
    Titulo = 'Puestos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 42
    Top = 457
  end
  object ValidarPuesto: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluPuesto'
    MensajeException = 'C'#243'digo de Puesto Inexistente'
    NroQuery = 0
    Cache = False
    Left = 78
    Top = 457
  end
  object TProcesosCandidato: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_proceso_sel'
        DataType = ftInteger
      end
      item
        Name = 'oid_candidato_busq'
        DataType = ftInteger
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'oid_proceso'
        DataType = ftInteger
      end
      item
        Name = 'proceso'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_conc_proceso'
        DataType = ftInteger
      end
      item
        Name = 'concepto'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'costo'
        DataType = ftFloat
      end
      item
        Name = 'oid_est_proc_sel'
        DataType = ftInteger
      end
      item
        Name = 'estado'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'fecha_planif'
        DataType = ftDate
      end
      item
        Name = 'hora_planif'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'persona'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'observaciones'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'puede_iniciar'
        DataType = ftBoolean
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'oid_postulante'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_postulante'
    IndexDefs = <
      item
        Name = 'TProcesosCandidatoIndex3'
        Fields = 'oid_postulante'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_postulante'
    MasterSource = DSTRecluPostulante
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 804
    Top = 246
    object TProcesosCandidatooid_proceso_sel: TIntegerField
      FieldName = 'oid_proceso_sel'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TProcesosCandidatooid_candidato_busq: TIntegerField
      FieldName = 'oid_candidato_busq'
    end
    object TProcesosCandidatoorden: TIntegerField
      FieldName = 'orden'
    end
    object TProcesosCandidatooid_proceso: TIntegerField
      FieldName = 'oid_proceso'
    end
    object TProcesosCandidatoproceso: TStringField
      FieldName = 'proceso'
      Size = 100
    end
    object TProcesosCandidatooid_conc_proceso: TIntegerField
      FieldName = 'oid_conc_proceso'
    end
    object TProcesosCandidatoconcepto: TStringField
      FieldName = 'concepto'
      Size = 100
    end
    object TProcesosCandidatocosto: TFloatField
      FieldName = 'costo'
    end
    object TProcesosCandidatooid_est_proc_sel: TIntegerField
      FieldName = 'oid_est_proc_sel'
    end
    object TProcesosCandidatoestado: TStringField
      FieldName = 'estado'
      Size = 100
    end
    object TProcesosCandidatofecha_planif: TDateField
      FieldName = 'fecha_planif'
    end
    object TProcesosCandidatohora_planif: TStringField
      FieldName = 'hora_planif'
      Size = 5
    end
    object TProcesosCandidatopersona: TStringField
      FieldName = 'persona'
      Size = 100
    end
    object TProcesosCandidatoobservaciones: TStringField
      FieldName = 'observaciones'
      Size = 4000
    end
    object TProcesosCandidatopuede_iniciar: TBooleanField
      FieldName = 'puede_iniciar'
    end
    object TProcesosCandidatoactivo: TBooleanField
      FieldName = 'activo'
    end
    object TProcesosCandidatooid_postulante: TIntegerField
      FieldName = 'oid_postulante'
    end
    object TProcesosCandidatotitulo: TStringField
      FieldName = 'titulo'
      Size = 255
    end
    object TProcesosCandidatonro_archivo: TIntegerField
      FieldName = 'nro_archivo'
    end
    object TProcesosCandidatooid_busqueda_act: TIntegerField
      FieldName = 'oid_busqueda_act'
    end
    object TProcesosCandidatonombre_archivo: TStringField
      FieldName = 'nombre_archivo'
      Size = 255
    end
  end
  object DSProcesosCandidatos: TDataSource
    DataSet = TProcesosCandidato
    Left = 836
    Top = 246
  end
  object HelpProceso: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluProceso'
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
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 174
    Top = 591
  end
  object TRecluProceso: TsnTable
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
    Left = 208
    Top = 591
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
  object DSRecluProceso: TDataSource
    DataSet = TRecluProceso
    Left = 242
    Top = 591
  end
  object HelpTipoExamenes: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluConceptoProceso'
    NroHelp = 101
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        AsignarACampo = TProcesosCandidatooid_conc_proceso
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
        AsignarACampo = TProcesosCandidatoconcepto
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
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 176
    Top = 496
  end
  object TTiposExamenes: TsnTable
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
    Left = 210
    Top = 496
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
  object DSTiposExamenes: TDataSource
    DataSet = TTiposExamenes
    Left = 244
    Top = 496
  end
  object HelpEstadoProceso: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluEstadoProceso'
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
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 174
    Top = 453
  end
  object TEstadoProceso: TsnTable
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
    Left = 208
    Top = 453
    object IntegerField5: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField7: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField8: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSEstadoProceso: TDataSource
    DataSet = TEstadoProceso
    Left = 242
    Top = 453
  end
  object HelpEstadoPostulante: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluEstadoPostulante'
    NroHelp = 0
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        AsignarACampo = TProcesosCandidatooid_conc_proceso
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
        AsignarACampo = TProcesosCandidatoconcepto
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
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 176
    Top = 535
  end
  object TEstadoPostulante: TsnTable
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
    Left = 210
    Top = 535
    object IntegerField6: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField11: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField12: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSEstadoPostulante: TDataSource
    DataSet = TEstadoPostulante
    Left = 244
    Top = 535
  end
  object FormAgregarProcAndi: TFormulario
    Nombre = 'TFRecluAltaProcCandi'
    CreateAlwaysANewForm = True
    Left = 696
    Top = 379
  end
  object snSaveDialog1: TsnSaveDialog
    OptionsEx = [ofExNoPlacesBar]
    Left = 464
    Top = 246
  end
  object FormConsBusquedas: TFormulario
    Nombre = 'TFRecluBusquedas'
    CreateAlwaysANewForm = True
    Left = 696
    Top = 339
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
    Left = 712
    Top = 134
    object TInputbuscar: TStringField
      FieldName = 'buscar'
      Size = 100
    end
    object TInputoid_operacion: TIntegerField
      FieldName = 'oid_operacion'
    end
    object TInputoid_sector: TIntegerField
      FieldName = 'oid_sector'
    end
    object TInputoid_selector: TIntegerField
      FieldName = 'oid_selector'
    end
    object TInputoid_puesto: TIntegerField
      FieldName = 'oid_puesto'
    end
    object TInputabiertas: TBooleanField
      FieldName = 'abiertas'
    end
    object TInputcerradas: TBooleanField
      FieldName = 'cerradas'
    end
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object TInputcodigo_sexo: TStringField
      FieldName = 'codigo_sexo'
      Size = 10
    end
    object TInputoid_busqueda_act: TIntegerField
      FieldName = 'oid_busqueda_act'
    end
    object TInputoid_postulante: TIntegerField
      FieldName = 'oid_postulante'
    end
    object TInputoid_estado_postulante: TIntegerField
      FieldName = 'oid_estado_postulante'
    end
    object TInputes_referido: TStringField
      FieldName = 'es_referido'
      Size = 2
    end
    object TInputgenero_postulante: TStringField
      FieldName = 'genero_postulante'
    end
  end
  object TInputCompetencias: TsnTable
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
    Left = 752
    Top = 134
    object TInputCompetenciasoid_competencia: TIntegerField
      FieldName = 'oid_competencia'
    end
    object TInputCompetenciasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TCompetenciasPostulantes: TsnTable
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
    Left = 752
    Top = 302
    object TCompetenciasPostulantesoid: TIntegerField
      FieldName = 'oid'
    end
    object TCompetenciasPostulantescodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TCompetenciasPostulantesdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TCompetenciasPostulantesseleccionado: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object TPostulacionesAplica: TsnTable
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
    Left = 848
    Top = 302
    object IntegerField7: TIntegerField
      FieldName = 'oid'
    end
    object StringField13: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField14: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object BooleanField2: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object TProcesosEnEstado: TsnTable
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
    MensajeValorDuplicadoIndice = 'TEstadosProceso'
    Left = 840
    Top = 342
    object IntegerField8: TIntegerField
      FieldName = 'oid'
    end
    object StringField15: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField16: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object BooleanField3: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object TCandidatosEnEstado: TsnTable
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
    Left = 752
    Top = 342
    object IntegerField9: TIntegerField
      FieldName = 'oid'
    end
    object StringField17: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField18: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object BooleanField1: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object FormBusqueda: TFormulario
    AutoLiberar = True
    Nombre = 'TFRecluBusquedas'
    CreateAlwaysANewForm = True
    Left = 698
    Top = 415
  end
end
