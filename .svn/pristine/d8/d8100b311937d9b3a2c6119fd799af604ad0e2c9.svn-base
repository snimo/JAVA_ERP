inherited FGrupoExcAImportar: TFGrupoExcAImportar
  Left = 108
  Top = 175
  Width = 730
  Height = 527
  Caption = 'Grupo a Importar'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 714
    Height = 489
    inherited PPie: TPanel
      Top = 468
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
        DataSource = DSTGrupoImportacionExcluido
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTGrupoImportacionExcluido
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpGrupoImp
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpGrupoImp
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpGrupoImp
      end
      inherited Panel2: TPanel
        Left = 673
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTGrupoImportacionExcluido
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
      Height = 100
      object Label1: TLabel
        Left = 40
        Top = 16
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 40
        Top = 48
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object Label3: TLabel
        Left = 40
        Top = 80
        Width = 92
        Height = 13
        Caption = 'Tipos de Individuos'
      end
      object DBECodigo: TsnDBEdit
        Left = 156
        Top = 12
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTGrupoImportacionExcluido
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBEdit1: TsnDBEdit
        Left = 156
        Top = 44
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTGrupoImportacionExcluido
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object snDBLookup1: TsnDBLookup
        Left = 156
        Top = 76
        DataBinding.DataField = 'tipo_individuo'
        DataBinding.DataSource = DSTGrupoImportacionExcluido
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposIndividuos
        TabOrder = 2
        Width = 285
      end
    end
    inherited PCuerpo: TPanel
      Top = 152
      Width = 714
      Height = 316
      object Splitter1: TSplitter
        Left = 0
        Top = 293
        Width = 714
        Height = 3
        Cursor = crVSplit
        Align = alTop
      end
      object Panel1: TPanel
        Left = 0
        Top = 0
        Width = 714
        Height = 293
        Align = alTop
        BorderWidth = 5
        Color = clWindow
        TabOrder = 0
        object PageControlSN1: TPageControlSN
          Left = 6
          Top = 6
          Width = 702
          Height = 281
          ActivePage = TabSheet4
          Align = alClient
          TabOrder = 0
          object TabSheet4: TTabSheet
            Caption = 'Estados                   '
            ImageIndex = 3
            object dxDBGridSN3: TdxDBGridSN
              Left = 0
              Top = 0
              Width = 694
              Height = 253
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
                DataController.DataSource = DSTGrupoImportacionSoloEst
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
                OptionsData.Inserting = False
                OptionsSelection.InvertSelect = False
                OptionsView.Navigator = True
                OptionsView.GroupByBox = False
                object cxGridDBColumn1: TcxGridDBColumn
                  Caption = 'Estado'
                  DataBinding.FieldName = 'oid_estado'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'oid'
                  Properties.ListColumns = <
                    item
                      FieldName = 'codigo'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSEstados
                  HeaderAlignmentHorz = taCenter
                  Width = 147
                end
                object cxGridDBColumn3: TcxGridDBColumn
                  Caption = 'Activo'
                  DataBinding.FieldName = 'activo'
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  HeaderAlignmentHorz = taCenter
                  Width = 62
                end
              end
              object cxGridLevel3: TcxGridLevel
                GridView = cxGridDBTableView3
              end
            end
          end
          object TabSheet1: TTabSheet
            BorderWidth = 5
            Caption = 'Peligrosidad en Predio       '
            object dxDBDifImportes: TdxDBGridSN
              Left = 0
              Top = 0
              Width = 684
              Height = 243
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
                DataController.DataSource = DSTGrupoImportacionExcPeli
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
                OptionsData.Inserting = False
                OptionsSelection.InvertSelect = False
                OptionsView.Navigator = True
                OptionsView.GroupByBox = False
                object dxDBDifImportesDBTableView1oid_predio: TcxGridDBColumn
                  Caption = 'Predio'
                  DataBinding.FieldName = 'oid_predio'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'oid'
                  Properties.ListColumns = <
                    item
                      FieldName = 'codigo'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSPredios
                  HeaderAlignmentHorz = taCenter
                  Width = 125
                end
                object dxDBDifImportesDBTableView1oid_peligrosidad: TcxGridDBColumn
                  Caption = 'Peligrosidad'
                  DataBinding.FieldName = 'oid_peligrosidad'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'oid'
                  Properties.ListColumns = <
                    item
                      FieldName = 'descripcion'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSPeligrosidad
                  HeaderAlignmentHorz = taCenter
                  Width = 132
                end
                object dxDBDifImportesDBTableView1activo: TcxGridDBColumn
                  Caption = 'Activo'
                  DataBinding.FieldName = 'activo'
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  HeaderAlignmentHorz = taCenter
                  Width = 62
                end
              end
              object dxDBDifImportesLevel1: TcxGridLevel
                GridView = dxDBDifImportesDBTableView1
              end
            end
          end
          object TabSheet2: TTabSheet
            BorderWidth = 5
            Caption = 'Estados en Predio      '
            ImageIndex = 1
            object dxDBGridSN1: TdxDBGridSN
              Left = 0
              Top = 0
              Width = 684
              Height = 243
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
                DataController.DataSource = DSTGrupoImportacionExcEst
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
                OptionsData.Inserting = False
                OptionsSelection.InvertSelect = False
                OptionsView.Navigator = True
                OptionsView.GroupByBox = False
                object cxGridDBTableView1oid_predio: TcxGridDBColumn
                  Caption = 'Predio'
                  DataBinding.FieldName = 'oid_predio'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'oid'
                  Properties.ListColumns = <
                    item
                      FieldName = 'codigo'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSPredios
                  HeaderAlignmentHorz = taCenter
                  Width = 118
                end
                object cxGridDBTableView1oid_estado: TcxGridDBColumn
                  Caption = 'Estado'
                  DataBinding.FieldName = 'oid_estado'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'oid'
                  Properties.ListColumns = <
                    item
                      FieldName = 'descripcion'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSEstados
                  HeaderAlignmentHorz = taCenter
                  Width = 146
                end
                object cxGridDBTableView1activo: TcxGridDBColumn
                  Caption = 'Activo'
                  DataBinding.FieldName = 'activo'
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  HeaderAlignmentHorz = taCenter
                  Width = 53
                end
              end
              object cxGridLevel1: TcxGridLevel
                GridView = cxGridDBTableView1
              end
            end
          end
          object TabSheet3: TTabSheet
            Caption = 'M'#225'quinas          '
            ImageIndex = 2
            object dxDBGridSN2: TdxDBGridSN
              Left = 0
              Top = 0
              Width = 694
              Height = 253
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
                DataController.DataSource = DSTGrupoImportacionExcMaq
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
                OptionsData.Inserting = False
                OptionsSelection.InvertSelect = False
                OptionsView.Navigator = True
                OptionsView.GroupByBox = False
                object cxGridDBTableView2oid_maquina: TcxGridDBColumn
                  Caption = 'M'#225'quina'
                  DataBinding.FieldName = 'oid_maquina'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'oid'
                  Properties.ListColumns = <
                    item
                      FieldName = 'descripcion'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSMaquinas
                  HeaderAlignmentHorz = taCenter
                  Width = 138
                end
                object cxGridDBTableView2activo: TcxGridDBColumn
                  Caption = 'Activo'
                  DataBinding.FieldName = 'activo'
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  HeaderAlignmentHorz = taCenter
                end
              end
              object cxGridLevel2: TcxGridLevel
                GridView = cxGridDBTableView2
              end
            end
          end
        end
      end
      object Panel3: TPanel
        Left = 0
        Top = 296
        Width = 714
        Height = 20
        Align = alClient
        Color = clWindow
        TabOrder = 1
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerGrupoImportacionExcluido'
    OperGrabarObjeto = 'SaveGrupoImportacionExcluido'
    CargaDataSets = <
      item
        DataSet = TGrupoImportacionExcluido
        TableName = 'TGrupoImportacionExcluido'
      end
      item
        DataSet = TGrupoImportacionExcPeli
        TableName = 'TGrupoImportacionExcPeli'
      end
      item
        DataSet = TGrupoImportacionExcEst
        TableName = 'TGrupoImportacionExcEst'
      end
      item
        DataSet = TTiposIndividuos
        TableName = 'TTiposIndividuos'
      end
      item
        DataSet = TGrupoImportacionExcMaq
        TableName = 'TGrupoImportacionExcMaq'
      end
      item
        DataSet = TGrupoImportacionSoloEst
        TableName = 'TGrupoImportacionSoloEst'
      end>
    BajaLogica = <
      item
        DataSet = TGrupoImportacionExcluido
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TGrupoImportacionExcluido
    DataSetDet1 = TGrupoImportacionExcPeli
    DataSetDet2 = TGrupoImportacionExcEst
    DataSetDet3 = TGrupoImportacionExcMaq
    DataSetDet4 = TGrupoImportacionSoloEst
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 552
    Top = 16
  end
  object TGrupoImportacionExcluido: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo_imp_exc'
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
        Name = 'tipo_individuo'
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
    object TGrupoImportacionExcluidooid_grupo_imp_exc: TIntegerField
      FieldName = 'oid_grupo_imp_exc'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TGrupoImportacionExcluidocodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TGrupoImportacionExcluidodescripcion: TStringField
      DisplayWidth = 50
      FieldName = 'descripcion'
      Size = 50
    end
    object TGrupoImportacionExcluidotipo_individuo: TStringField
      FieldName = 'tipo_individuo'
      Size = 50
    end
    object TGrupoImportacionExcluidoactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTGrupoImportacionExcluido: TDataSource [4]
    DataSet = TGrupoImportacionExcluido
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
    Left = 616
    Top = 216
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TGrupoImportacionExcluido'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorGrupo.Value := Sender.AsString;'
          '  ValidadorGrupo.Validar;'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TGrupoImportacionExcPeli'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_predio'#39').AsInteger = 0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el predio' +
            #39');'
          '  if (DataSet.FieldName('#39'oid_peligrosidad'#39').AsInteger = 0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la peligr' +
            'osidad'#39');'
          'end.')
      end
      item
        TableName = 'TGrupoImportacionExcEst'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_predio'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el predio'#39 +
            ');'
          '  if (DataSet.FieldName('#39'oid_estado'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el estado'#39 +
            ');'
          'end.')
      end
      item
        TableName = 'TGrupoImportacionExcluido'
        Source.Strings = (
          'begin'
          '    if (DataSet.FieldName('#39'codigo'#39').AsString='#39#39')'
          
            '       then raiseException(erCustomError,'#39'Debe ingresar el C'#243'dig' +
            'o'#39');'
          '    if (DataSet.FieldName('#39'descripcion'#39').AsString='#39#39')'
          
            '       then raiseException(erCustomError,'#39'Debe ingresar la descr' +
            'ipci'#243'n'#39');'
          '    if (DataSet.FieldName('#39'tipo_individuo'#39').AsString='#39#39')'
          
            '       then raiseException(erCustomError,'#39'Debe ingresar el Tipo ' +
            'de Individuo'#39');'
          'end.')
      end
      item
        TableName = 'TGrupoImportacionExcMaq'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_maquina'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la m'#225'quina' +
            #39');'
          'end.')
      end
      item
        TableName = 'TGrupoImportacionSoloEst'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_estado'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Estado'#39 +
            ');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TGrupoImportacionExcluido'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TGrupoImportacionExcPeli'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_grupo_imp_exc'#39').AsInteger := TGrupoImpo' +
            'rtacionExcluido.FieldName('#39'oid_grupo_imp_exc'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end
      item
        TableName = 'TGrupoImportacionExcEst'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_grupo_imp_exc'#39').AsInteger := TGrupoImpo' +
            'rtacionExcluido.FieldName('#39'oid_grupo_imp_exc'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end
      item
        TableName = 'TGrupoImportacionExcMaq'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_grupo_imp_exc'#39').AsInteger := TGrupoImpo' +
            'rtacionExcluido.FieldName('#39'oid_grupo_imp_exc'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.'
          '')
      end
      item
        TableName = 'TGrupoImportacionSoloEst'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_grupo_imp_exc'#39').AsInteger := TGrupoImpo' +
            'rtacionExcluido.FieldName('#39'oid_grupo_imp_exc'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          ''
          '  TPredios.loadFromHelp('#39'HelpPredios'#39');'
          '  TPeligrosidad.loadFromHelp('#39'HelpPeligrosidad'#39');'
          '  TEstados.loadFromHelp('#39'HelpEstados'#39');'
          ''
          '   TTiposIndividuos.Close;'
          '   TTiposIndividuos.Open;'
          '  '
          '   TTiposIndividuos.AppendRecord;'
          '   TTiposIndividuos.FieldName('#39'codigo'#39').AsString := '#39'EXTERNO'#39';'
          
            '   TTiposIndividuos.FieldName('#39'descripcion'#39').AsString := '#39'Extern' +
            'o'#39';'
          '   TTiposIndividuos.PostRecord;'
          ''
          '   TTiposIndividuos.AppendRecord;'
          '   TTiposIndividuos.FieldName('#39'codigo'#39').AsString := '#39'EMPLEADO'#39';'
          
            '   TTiposIndividuos.FieldName('#39'descripcion'#39').AsString := '#39'Emplea' +
            'do'#39';'
          '   TTiposIndividuos.PostRecord;'
          ''
          '   TTiposIndividuos.AppendRecord;'
          '   TTiposIndividuos.FieldName('#39'codigo'#39').AsString := '#39'TODOS'#39';'
          
            '   TTiposIndividuos.FieldName('#39'descripcion'#39').AsString := '#39'Todos'#39 +
            ';'
          '   TTiposIndividuos.PostRecord;'
          ''
          '   TMaquinas.loadFromHelp('#39'HelpMaquinas'#39');'
          ''
          'end.'
          '')
      end>
    Left = 584
    Top = 219
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 553
    Top = 216
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 192
    Top = 203
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 376
    Top = 59
  end
  object HelpGrupoImp: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'exc.GrupoImportacionExcluido'
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
    Titulo = 'Grupos Importaci'#243'n'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorGrupo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'exc.GrupoImportacionExcluido'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Grupo duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
  object TGrupoImportacionExcPeli: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo_impo_peli'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo_imp_exc'
        DataType = ftInteger
      end
      item
        Name = 'oid_predio'
        DataType = ftInteger
      end
      item
        Name = 'oid_peligrosidad'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_grupo_imp_exc'
    IndexDefs = <
      item
        Name = 'TGrupoImportacionExcPeliIndex1'
        Fields = 'oid_grupo_imp_exc'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_grupo_imp_exc'
    MasterSource = DSTGrupoImportacionExcluido
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 320
    Top = 100
    object TGrupoImportacionExcPelioid_grupo_impo_peli: TIntegerField
      FieldName = 'oid_grupo_impo_peli'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TGrupoImportacionExcPelioid_grupo_imp_exc: TIntegerField
      FieldName = 'oid_grupo_imp_exc'
    end
    object TGrupoImportacionExcPelioid_predio: TIntegerField
      FieldName = 'oid_predio'
    end
    object TGrupoImportacionExcPelioid_peligrosidad: TIntegerField
      FieldName = 'oid_peligrosidad'
    end
    object TGrupoImportacionExcPeliactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTGrupoImportacionExcPeli: TDataSource
    DataSet = TGrupoImportacionExcPeli
    Left = 352
    Top = 100
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
  object HelpPeligrosidad: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'exc.PeligrosidadExcluido'
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
    Top = 353
  end
  object TPeligrosidad: TsnTable
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
    Top = 353
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
  object DSPeligrosidad: TDataSource
    DataSet = TPeligrosidad
    Left = 232
    Top = 353
  end
  object TGrupoImportacionExcEst: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo_impo_est'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo_imp_exc'
        DataType = ftInteger
      end
      item
        Name = 'oid_predio'
        DataType = ftInteger
      end
      item
        Name = 'oid_estado'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_grupo_imp_exc'
    IndexDefs = <
      item
        Name = 'TGrupoImportacionExcEstIndex1'
        Fields = 'oid_grupo_imp_exc'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_grupo_imp_exc'
    MasterSource = DSTGrupoImportacionExcluido
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 440
    Top = 92
    object TGrupoImportacionExcEstoid_grupo_impo_est: TIntegerField
      FieldName = 'oid_grupo_impo_est'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TGrupoImportacionExcEstoid_grupo_imp_exc: TIntegerField
      FieldName = 'oid_grupo_imp_exc'
    end
    object TGrupoImportacionExcEstoid_predio: TIntegerField
      FieldName = 'oid_predio'
    end
    object TGrupoImportacionExcEstoid_estado: TIntegerField
      FieldName = 'oid_estado'
    end
    object TGrupoImportacionExcEstactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTGrupoImportacionExcEst: TDataSource
    DataSet = TGrupoImportacionExcEst
    Left = 472
    Top = 92
  end
  object HelpEstados: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'exc.EstadoExcluido'
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
    Titulo = 'Estados'
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 170
    Top = 390
  end
  object TEstados: TsnTable
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
    Top = 390
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
  object DSEstados: TDataSource
    DataSet = TEstados
    Left = 232
    Top = 390
  end
  object TTiposIndividuos: TsnTable
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
    Left = 386
    Top = 247
    object TTiposIndividuoscodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTiposIndividuosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTiposIndividuos: TDataSource
    DataSet = TTiposIndividuos
    Left = 418
    Top = 247
  end
  object TGrupoImportacionExcMaq: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo_imp_maq'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo_imp_exc'
        DataType = ftInteger
      end
      item
        Name = 'oid_maquina'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_grupo_imp_exc'
    IndexDefs = <
      item
        Name = 'TGrupoImportacionExcMaqIndex1'
        Fields = 'oid_grupo_imp_exc'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_grupo_imp_exc'
    MasterSource = DSTGrupoImportacionExcluido
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 536
    Top = 92
    object TGrupoImportacionExcMaqoid_grupo_imp_maq: TIntegerField
      FieldName = 'oid_grupo_imp_maq'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TGrupoImportacionExcMaqoid_grupo_imp_exc: TIntegerField
      FieldName = 'oid_grupo_imp_exc'
    end
    object TGrupoImportacionExcMaqoid_maquina: TIntegerField
      FieldName = 'oid_maquina'
    end
    object TGrupoImportacionExcMaqactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTGrupoImportacionExcMaq: TDataSource
    DataSet = TGrupoImportacionExcMaq
    Left = 568
    Top = 92
  end
  object HelpMaquinas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'me.Maquina'
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
    Titulo = 'M'#225'quinas'
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 170
    Top = 277
  end
  object TMaquinas: TsnTable
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
    Top = 277
    object IntegerField4: TIntegerField
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
  object DSMaquinas: TDataSource
    DataSet = TMaquinas
    Left = 232
    Top = 277
  end
  object TGrupoImportacionSoloEst: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo_solo_est'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo_imp_exc'
        DataType = ftInteger
      end
      item
        Name = 'oid_estado'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_grupo_imp_exc'
    IndexDefs = <
      item
        Name = 'TGrupoImportacionSoloEstIndex1'
        Fields = 'oid_grupo_imp_exc'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_grupo_imp_exc'
    MasterSource = DSTGrupoImportacionExcluido
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 624
    Top = 92
    object TGrupoImportacionSoloEstoid_grupo_solo_est: TIntegerField
      FieldName = 'oid_grupo_solo_est'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TGrupoImportacionSoloEstoid_grupo_imp_exc: TIntegerField
      FieldName = 'oid_grupo_imp_exc'
    end
    object TGrupoImportacionSoloEstoid_estado: TIntegerField
      FieldName = 'oid_estado'
    end
    object TGrupoImportacionSoloEstactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTGrupoImportacionSoloEst: TDataSource
    DataSet = TGrupoImportacionSoloEst
    Left = 656
    Top = 92
  end
end
