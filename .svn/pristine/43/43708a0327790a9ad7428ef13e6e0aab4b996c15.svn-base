inherited FPerfSeguExc: TFPerfSeguExc
  Left = 108
  Top = 175
  Width = 730
  Height = 533
  Caption = 'Perfil Seguridad Excluidos'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 714
    Height = 495
    inherited PPie: TPanel
      Top = 474
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
        DataSource = DSTSeguPerfilExcluido
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTSeguPerfilExcluido
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpPerfiles
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpPerfiles
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpPerfiles
      end
      inherited Panel2: TPanel
        Left = 673
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTSeguPerfilExcluido
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
      Height = 101
      object Label1: TLabel
        Left = 32
        Top = 16
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 32
        Top = 56
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object DBECodigo: TsnDBEdit
        Left = 148
        Top = 12
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTSeguPerfilExcluido
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBEdit1: TsnDBEdit
        Left = 148
        Top = 52
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTSeguPerfilExcluido
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
    end
    inherited PCuerpo: TPanel
      Top = 153
      Width = 714
      Height = 321
      BorderWidth = 5
      object PageControlSN1: TPageControlSN
        Left = 5
        Top = 5
        Width = 704
        Height = 311
        ActivePage = TabSheet1
        Align = alClient
        TabOrder = 0
        object TabSheet1: TTabSheet
          Caption = 'Tipos de Individuos'
          object dxDBDifImportes: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 696
            Height = 283
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
            object dxDBDifImportesDBTableView1: TcxGridDBTableView
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
              NavigatorButtons.Append.Visible = False
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
              DataController.DataSource = DSTTiposIndividuos
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.PostponedSynchronization = False
              OptionsBehavior.AlwaysShowEditor = True
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.CancelOnExit = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsData.Inserting = False
              OptionsSelection.InvertSelect = False
              OptionsView.Navigator = True
              OptionsView.GroupByBox = False
              object dxDBDifImportesDBTableView1tipo_individuo: TcxGridDBColumn
                Caption = 'Tipo de Invididuo'
                DataBinding.FieldName = 'tipo_individuo'
                Options.Editing = False
              end
              object dxDBDifImportesDBTableView1visualiza: TcxGridDBColumn
                Caption = 'Visualiza?'
                DataBinding.FieldName = 'visualiza'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 60
              end
              object dxDBDifImportesDBTableView1alta: TcxGridDBColumn
                Caption = 'Alta?'
                DataBinding.FieldName = 'alta'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 51
              end
              object dxDBDifImportesDBTableView1baja: TcxGridDBColumn
                Caption = 'Baja?'
                DataBinding.FieldName = 'baja'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 47
              end
              object dxDBDifImportesDBTableView1modifica: TcxGridDBColumn
                Caption = 'Modificaci'#243'n?'
                DataBinding.FieldName = 'modifica'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 89
              end
            end
            object dxDBDifImportesLevel1: TcxGridLevel
              GridView = dxDBDifImportesDBTableView1
            end
          end
        end
        object TabSheet2: TTabSheet
          Caption = 'Estados Actuales'
          ImageIndex = 1
          object dxDBGridSN1: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 696
            Height = 283
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
            object cxGridDBTableView1: TcxGridDBTableView
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
              NavigatorButtons.Append.Visible = False
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
              DataController.DataSource = DSEstadosActuales
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.PostponedSynchronization = False
              OptionsBehavior.AlwaysShowEditor = True
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.CancelOnExit = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsData.Inserting = False
              OptionsSelection.InvertSelect = False
              OptionsView.Navigator = True
              OptionsView.GroupByBox = False
              object cxGridDBColumn1: TcxGridDBColumn
                Caption = 'Estado'
                DataBinding.FieldName = 'desc_estado'
                Options.Editing = False
                Width = 303
              end
              object cxGridDBColumn2: TcxGridDBColumn
                Caption = 'Visualiza?'
                DataBinding.FieldName = 'visualiza'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 60
              end
              object cxGridDBColumn3: TcxGridDBColumn
                Caption = 'Alta?'
                DataBinding.FieldName = 'alta'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 51
              end
              object cxGridDBColumn4: TcxGridDBColumn
                Caption = 'Baja?'
                DataBinding.FieldName = 'baja'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 47
              end
              object cxGridDBColumn5: TcxGridDBColumn
                Caption = 'Modificaci'#243'n?'
                DataBinding.FieldName = 'modifica'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 89
              end
            end
            object cxGridLevel1: TcxGridLevel
              GridView = cxGridDBTableView1
            end
          end
        end
        object TabSheet3: TTabSheet
          Caption = 'Peligrosidad'
          ImageIndex = 2
          object dxDBGridSN2: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 696
            Height = 283
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
            object cxGridDBTableView2: TcxGridDBTableView
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
              NavigatorButtons.Append.Visible = False
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
              DataController.DataSource = DSPeligrosidad
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.PostponedSynchronization = False
              OptionsBehavior.AlwaysShowEditor = True
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.CancelOnExit = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsData.Inserting = False
              OptionsSelection.InvertSelect = False
              OptionsView.Navigator = True
              OptionsView.GroupByBox = False
              object cxGridDBColumn6: TcxGridDBColumn
                Caption = 'Peligrosidad'
                DataBinding.FieldName = 'desc_peligrosidad'
                Options.Editing = False
                Width = 303
              end
              object cxGridDBColumn7: TcxGridDBColumn
                Caption = 'Visualiza?'
                DataBinding.FieldName = 'visualiza'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 60
              end
              object cxGridDBColumn8: TcxGridDBColumn
                Caption = 'Alta?'
                DataBinding.FieldName = 'alta'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 51
              end
              object cxGridDBColumn9: TcxGridDBColumn
                Caption = 'Baja?'
                DataBinding.FieldName = 'baja'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 47
              end
              object cxGridDBColumn10: TcxGridDBColumn
                Caption = 'Modificaci'#243'n?'
                DataBinding.FieldName = 'modifica'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 89
              end
            end
            object cxGridLevel2: TcxGridLevel
              GridView = cxGridDBTableView2
            end
          end
        end
        object TabSheet4: TTabSheet
          Caption = 'Predio'
          ImageIndex = 3
          object dxDBGridSN3: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 696
            Height = 283
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
              NavigatorButtons.Append.Visible = False
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
              DataController.DataSource = DSTPredio
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.PostponedSynchronization = False
              OptionsBehavior.AlwaysShowEditor = True
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.CancelOnExit = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsData.Inserting = False
              OptionsSelection.InvertSelect = False
              OptionsView.Navigator = True
              OptionsView.GroupByBox = False
              object cxGridDBColumn11: TcxGridDBColumn
                Caption = 'Predio'
                DataBinding.FieldName = 'desc_predio'
                Options.Editing = False
                Width = 303
              end
              object cxGridDBColumn12: TcxGridDBColumn
                Caption = 'Visualiza?'
                DataBinding.FieldName = 'visualiza'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 60
              end
              object cxGridDBColumn13: TcxGridDBColumn
                Caption = 'Alta?'
                DataBinding.FieldName = 'alta'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 51
              end
              object cxGridDBColumn14: TcxGridDBColumn
                Caption = 'Baja?'
                DataBinding.FieldName = 'baja'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 47
              end
              object cxGridDBColumn15: TcxGridDBColumn
                Caption = 'Modificaci'#243'n?'
                DataBinding.FieldName = 'modifica'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 89
              end
            end
            object cxGridLevel3: TcxGridLevel
              GridView = cxGridDBTableView3
            end
          end
        end
        object TabSheet5: TTabSheet
          Caption = 'Estados a NO incluir que alguna vez tuvo el Cliente'
          ImageIndex = 4
          object dxDBGridSN4: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 696
            Height = 283
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
            object cxGridDBTableView4: TcxGridDBTableView
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
              NavigatorButtons.Append.Visible = False
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
              DataController.DataSource = DSEstadosExcluyentes
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.PostponedSynchronization = False
              OptionsBehavior.AlwaysShowEditor = True
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.CancelOnExit = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsData.Inserting = False
              OptionsSelection.InvertSelect = False
              OptionsView.Navigator = True
              OptionsView.GroupByBox = False
              object cxGridDBColumn16: TcxGridDBColumn
                Caption = 'Estados que aparecieron alguna vez'
                DataBinding.FieldName = 'desc_estado'
                Options.Editing = False
                Width = 303
              end
              object cxGridDBColumn17: TcxGridDBColumn
                Caption = 'Visualiza?'
                DataBinding.FieldName = 'visualiza'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 60
              end
              object cxGridDBColumn18: TcxGridDBColumn
                Caption = 'Alta?'
                DataBinding.FieldName = 'alta'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 51
              end
              object cxGridDBColumn19: TcxGridDBColumn
                Caption = 'Baja?'
                DataBinding.FieldName = 'baja'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 47
              end
              object cxGridDBColumn20: TcxGridDBColumn
                Caption = 'Modificaci'#243'n?'
                DataBinding.FieldName = 'modifica'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 89
              end
            end
            object cxGridLevel4: TcxGridLevel
              Caption = 'Estados a Excluir que aparecieron alguna vez'
              GridView = cxGridDBTableView4
            end
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerSeguPerfilExcluido'
    OperGrabarObjeto = 'SaveSeguPerfilExcluido'
    CargaDataSets = <
      item
        DataSet = TSeguPerfilExcluido
        TableName = 'TSeguPerfilExcluido'
      end
      item
        DataSet = TTiposIndividuos
        TableName = 'TTiposIndividuos'
      end
      item
        DataSet = TEstadosActuales
        TableName = 'TEstadosActuales'
      end
      item
        DataSet = TPeligrosidad
        TableName = 'TPeligrosidad'
      end
      item
        DataSet = TPredio
        TableName = 'TPredio'
      end
      item
        DataSet = TEstadosExcluyentes
        TableName = 'TEstadosExcluyentes'
      end>
    BajaLogica = <
      item
        DataSet = TSeguPerfilExcluido
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TSeguPerfilExcluido
    DataSetDet1 = TTiposIndividuos
    DataSetDet2 = TEstadosActuales
    DataSetDet3 = TPeligrosidad
    DataSetDet4 = TPredio
    DataSetDet5 = TEstadosExcluyentes
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 552
    Top = 16
  end
  object TSeguPerfilExcluido: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_segu_perfil'
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
    object TSeguPerfilExcluidooid_segu_perfil: TIntegerField
      FieldName = 'oid_segu_perfil'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TSeguPerfilExcluidocodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TSeguPerfilExcluidodescripcion: TStringField
      DisplayWidth = 50
      FieldName = 'descripcion'
      Size = 50
    end
    object TSeguPerfilExcluidoactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTSeguPerfilExcluido: TDataSource [4]
    DataSet = TSeguPerfilExcluido
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
    Left = 648
    Top = 136
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TSeguPerfilExcluido'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorPerfil.Value := Sender.AsString;'
          '  ValidadorPerfil.Validar;'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TSeguPerfilExcluido'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end>
    Left = 616
    Top = 139
  end
  inherited SaveArchivo: TSaveDialog
    Left = 400
    Top = 128
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 296
    Top = 272
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 544
    Top = 336
  end
  inherited PopUp: TsnPopUp
    Left = 585
    Top = 136
  end
  object HelpPerfiles: TsnHelp
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
    Titulo = 'Perfiles Seguridad Excluidos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorPerfil: TValidador
    Operacion = Operacion
    NickNameObjLog = 'exc.SeguPerfilExcluido'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Perfil duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
  object TTiposIndividuos: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_segu_tipo_ind'
        DataType = ftInteger
      end
      item
        Name = 'oid_segu_perfil'
        DataType = ftInteger
      end
      item
        Name = 'tipo_individuo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'visualiza'
        DataType = ftBoolean
      end
      item
        Name = 'alta'
        DataType = ftBoolean
      end
      item
        Name = 'baja'
        DataType = ftBoolean
      end
      item
        Name = 'modifica'
        DataType = ftBoolean
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_segu_perfil'
    IndexDefs = <
      item
        Name = 'TTiposIndividuosIndex1'
        Fields = 'oid_segu_perfil'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_segu_perfil'
    MasterSource = DSTSeguPerfilExcluido
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 329
    Top = 222
    object TTiposIndividuosoid_segu_tipo_ind: TIntegerField
      FieldName = 'oid_segu_tipo_ind'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TTiposIndividuosoid_segu_perfil: TIntegerField
      FieldName = 'oid_segu_perfil'
    end
    object TTiposIndividuostipo_individuo: TStringField
      FieldName = 'tipo_individuo'
      Size = 50
    end
    object TTiposIndividuosvisualiza: TBooleanField
      FieldName = 'visualiza'
    end
    object TTiposIndividuosalta: TBooleanField
      FieldName = 'alta'
    end
    object TTiposIndividuosbaja: TBooleanField
      FieldName = 'baja'
    end
    object TTiposIndividuosmodifica: TBooleanField
      FieldName = 'modifica'
    end
    object TTiposIndividuosactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTTiposIndividuos: TDataSource
    DataSet = TTiposIndividuos
    Left = 361
    Top = 222
  end
  object TEstadosActuales: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_segu_tipo_ind'
        DataType = ftInteger
      end
      item
        Name = 'oid_segu_perfil'
        DataType = ftInteger
      end
      item
        Name = 'tipo_individuo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'visualiza'
        DataType = ftBoolean
      end
      item
        Name = 'alta'
        DataType = ftBoolean
      end
      item
        Name = 'baja'
        DataType = ftBoolean
      end
      item
        Name = 'modifica'
        DataType = ftBoolean
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_segu_perfil'
    IndexDefs = <
      item
        Name = 'TTiposIndividuosIndex1'
        Fields = 'oid_segu_perfil'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_segu_perfil'
    MasterSource = DSTSeguPerfilExcluido
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 411
    Top = 222
    object TEstadosActualesoid_segu_est_act: TIntegerField
      FieldName = 'oid_segu_est_act'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField2: TIntegerField
      FieldName = 'oid_segu_perfil'
    end
    object TEstadosActualesoid_estado: TIntegerField
      FieldName = 'oid_estado'
    end
    object TEstadosActualesdesc_estado: TStringField
      FieldName = 'desc_estado'
      Size = 100
    end
    object BooleanField1: TBooleanField
      FieldName = 'visualiza'
    end
    object BooleanField2: TBooleanField
      FieldName = 'alta'
    end
    object BooleanField3: TBooleanField
      FieldName = 'baja'
    end
    object BooleanField4: TBooleanField
      FieldName = 'modifica'
    end
    object BooleanField5: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSEstadosActuales: TDataSource
    DataSet = TEstadosActuales
    Left = 443
    Top = 222
  end
  object TPeligrosidad: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_segu_tipo_ind'
        DataType = ftInteger
      end
      item
        Name = 'oid_segu_perfil'
        DataType = ftInteger
      end
      item
        Name = 'tipo_individuo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'visualiza'
        DataType = ftBoolean
      end
      item
        Name = 'alta'
        DataType = ftBoolean
      end
      item
        Name = 'baja'
        DataType = ftBoolean
      end
      item
        Name = 'modifica'
        DataType = ftBoolean
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_segu_perfil'
    IndexDefs = <
      item
        Name = 'TTiposIndividuosIndex1'
        Fields = 'oid_segu_perfil'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_segu_perfil'
    MasterSource = DSTSeguPerfilExcluido
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 499
    Top = 224
    object TPeligrosidadoid_segu_peligro: TIntegerField
      FieldName = 'oid_segu_peligro'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField3: TIntegerField
      FieldName = 'oid_segu_perfil'
    end
    object TPeligrosidadoid_peligrosidad: TIntegerField
      FieldName = 'oid_peligrosidad'
    end
    object TPeligrosidaddesc_peligrosidad: TStringField
      FieldName = 'desc_peligrosidad'
      Size = 100
    end
    object BooleanField6: TBooleanField
      FieldName = 'visualiza'
    end
    object BooleanField7: TBooleanField
      FieldName = 'alta'
    end
    object BooleanField8: TBooleanField
      FieldName = 'baja'
    end
    object BooleanField9: TBooleanField
      FieldName = 'modifica'
    end
    object BooleanField10: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSPeligrosidad: TDataSource
    DataSet = TPeligrosidad
    Left = 531
    Top = 222
  end
  object TPredio: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_segu_tipo_ind'
        DataType = ftInteger
      end
      item
        Name = 'oid_segu_perfil'
        DataType = ftInteger
      end
      item
        Name = 'tipo_individuo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'visualiza'
        DataType = ftBoolean
      end
      item
        Name = 'alta'
        DataType = ftBoolean
      end
      item
        Name = 'baja'
        DataType = ftBoolean
      end
      item
        Name = 'modifica'
        DataType = ftBoolean
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_segu_perfil'
    IndexDefs = <
      item
        Name = 'TTiposIndividuosIndex1'
        Fields = 'oid_segu_perfil'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_segu_perfil'
    MasterSource = DSTSeguPerfilExcluido
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 587
    Top = 224
    object TPrediooid_segu_predio: TIntegerField
      FieldName = 'oid_segu_predio'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField4: TIntegerField
      FieldName = 'oid_segu_perfil'
    end
    object BooleanField11: TBooleanField
      FieldName = 'visualiza'
    end
    object BooleanField12: TBooleanField
      FieldName = 'alta'
    end
    object BooleanField13: TBooleanField
      FieldName = 'baja'
    end
    object BooleanField14: TBooleanField
      FieldName = 'modifica'
    end
    object BooleanField15: TBooleanField
      FieldName = 'activo'
    end
    object TPrediooid_predio: TIntegerField
      FieldName = 'oid_predio'
    end
    object TPrediodesc_predio: TStringField
      FieldName = 'desc_predio'
      Size = 100
    end
  end
  object DSTPredio: TDataSource
    DataSet = TPredio
    Left = 619
    Top = 222
  end
  object TEstadosExcluyentes: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_segu_tipo_ind'
        DataType = ftInteger
      end
      item
        Name = 'oid_segu_perfil'
        DataType = ftInteger
      end
      item
        Name = 'tipo_individuo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'visualiza'
        DataType = ftBoolean
      end
      item
        Name = 'alta'
        DataType = ftBoolean
      end
      item
        Name = 'baja'
        DataType = ftBoolean
      end
      item
        Name = 'modifica'
        DataType = ftBoolean
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_segu_perfil'
    IndexDefs = <
      item
        Name = 'TTiposIndividuosIndex1'
        Fields = 'oid_segu_perfil'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_segu_perfil'
    MasterSource = DSTSeguPerfilExcluido
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 427
    Top = 295
    object TEstadosExcluyentesoid_segu_excluir: TIntegerField
      FieldName = 'oid_segu_excluir'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField5: TIntegerField
      FieldName = 'oid_segu_perfil'
    end
    object BooleanField16: TBooleanField
      FieldName = 'visualiza'
    end
    object BooleanField17: TBooleanField
      FieldName = 'alta'
    end
    object BooleanField18: TBooleanField
      FieldName = 'baja'
    end
    object BooleanField19: TBooleanField
      FieldName = 'modifica'
    end
    object BooleanField20: TBooleanField
      FieldName = 'activo'
    end
    object TEstadosExcluyentesoid_estado: TIntegerField
      FieldName = 'oid_estado'
    end
    object TEstadosExcluyentesdesc_estado: TStringField
      FieldName = 'desc_estado'
      Size = 100
    end
  end
  object DSEstadosExcluyentes: TDataSource
    DataSet = TEstadosExcluyentes
    Left = 459
    Top = 293
  end
end
