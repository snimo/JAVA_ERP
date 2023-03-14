inherited FFiltroLegajo: TFFiltroLegajo
  Left = 97
  Top = 98
  Width = 1089
  Height = 791
  Caption = 'Filtros de Legajos'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 1073
    Height = 753
    inherited PPie: TPanel
      Top = 732
      Width = 1073
      inherited StatusBarABM: TStatusBar
        Left = 968
      end
      inherited StatusBar2: TStatusBar
        Width = 968
      end
    end
    inherited PMenu: TPanel
      Width = 1073
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTFiltroLegCab
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTFiltroLegCab
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpFiltrosLeg
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpFiltrosLeg
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpFiltrosLeg
      end
      inherited Panel2: TPanel
        Left = 1032
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTFiltroLegCab
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
      Width = 1073
    end
    inherited PCabecera: TPanel
      Top = 110
      Width = 1073
      Height = 622
      Align = alClient
      object Panel1: TPanel
        Left = 0
        Top = 0
        Width = 1073
        Height = 622
        Align = alClient
        TabOrder = 0
        object Splitter1: TSplitter
          Left = 1
          Top = 448
          Width = 1071
          Height = 3
          Cursor = crVSplit
          Align = alBottom
        end
        object Panel8: TPanel
          Left = 1
          Top = 451
          Width = 1071
          Height = 170
          Align = alBottom
          Color = clWindow
          TabOrder = 0
          object dxDBGridSN5: TdxDBGridSN
            Left = 1
            Top = 1
            Width = 1069
            Height = 168
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
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
              DataController.DataSource = DSPerfilFilLegCab
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsCustomize.ColumnSorting = False
              OptionsData.Appending = True
              OptionsData.CancelOnExit = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsSelection.InvertSelect = False
              OptionsView.Navigator = True
              OptionsView.CellAutoHeight = True
              OptionsView.GroupByBox = False
              object cxGridDBTableView4oid_perfil: TcxGridDBColumn
                Caption = 'Perfil'
                DataBinding.FieldName = 'oid_perfil'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'oid'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSPerfiles
                HeaderAlignmentHorz = taCenter
                Width = 298
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
        object Panel3: TSNScrollBox
          Left = 1
          Top = 1
          Width = 1071
          Height = 447
          HorzScrollBar.Position = 397
          HorzScrollBar.Tracking = True
          Align = alClient
          Color = clWindow
          ParentColor = False
          TabOrder = 1
          object Panel5: TPanel
            Left = -397
            Top = 0
            Width = 244
            Height = 426
            Align = alLeft
            Color = clWindow
            TabOrder = 0
            object dxDBGridSN2: TdxDBGridSN
              Left = 1
              Top = 1
              Width = 242
              Height = 424
              Align = alClient
              TabOrder = 0
              CriteriosPintarCelda = <>
              object cxGridDBTableView1: TcxGridDBTableView
                NavigatorButtons.ConfirmDelete = False
                DataController.DataSource = DSValoresEmpresa
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.IncSearch = True
                OptionsData.CancelOnExit = False
                OptionsData.Deleting = False
                OptionsData.DeletingConfirmation = False
                OptionsData.Inserting = False
                OptionsSelection.InvertSelect = False
                OptionsView.CellAutoHeight = True
                OptionsView.GroupByBox = False
                object cxGridDBTableView1Column1: TcxGridDBColumn
                  Caption = 'C'#243'digo'
                  DataBinding.FieldName = 'codigo'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 46
                end
                object cxGridDBColumn1: TcxGridDBColumn
                  Caption = 'Empresas'
                  DataBinding.FieldName = 'descripcion'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  SortIndex = 0
                  SortOrder = soAscending
                  Width = 140
                end
                object cxGridDBColumn2: TcxGridDBColumn
                  Caption = 'Sel.'
                  DataBinding.FieldName = 'activo'
                  HeaderAlignmentHorz = taCenter
                  Width = 30
                end
              end
              object cxGridLevel1: TcxGridLevel
                GridView = cxGridDBTableView1
              end
            end
          end
          object Panel6: TPanel
            Left = -153
            Top = 0
            Width = 244
            Height = 426
            Align = alLeft
            Color = clWindow
            TabOrder = 1
            object dxDBGridSN3: TdxDBGridSN
              Left = 1
              Top = 1
              Width = 242
              Height = 424
              Align = alClient
              TabOrder = 0
              CriteriosPintarCelda = <>
              object cxGridDBTableView2: TcxGridDBTableView
                NavigatorButtons.ConfirmDelete = False
                DataController.DataSource = DSValoresEstados
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.IncSearch = True
                OptionsData.CancelOnExit = False
                OptionsData.Deleting = False
                OptionsData.DeletingConfirmation = False
                OptionsData.Inserting = False
                OptionsSelection.InvertSelect = False
                OptionsView.CellAutoHeight = True
                OptionsView.GroupByBox = False
                object cxGridDBTableView2Column1: TcxGridDBColumn
                  Caption = 'C'#243'digo'
                  DataBinding.FieldName = 'codigo'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 45
                end
                object cxGridDBColumn3: TcxGridDBColumn
                  Caption = 'Estados'
                  DataBinding.FieldName = 'descripcion'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  SortIndex = 0
                  SortOrder = soAscending
                  Width = 136
                end
                object cxGridDBColumn4: TcxGridDBColumn
                  Caption = 'Sel.'
                  DataBinding.FieldName = 'activo'
                  HeaderAlignmentHorz = taCenter
                  Width = 27
                end
              end
              object cxGridLevel2: TcxGridLevel
                GridView = cxGridDBTableView2
              end
            end
          end
          object Panel7: TPanel
            Left = 91
            Top = 0
            Width = 244
            Height = 426
            Align = alLeft
            Color = clWindow
            TabOrder = 2
            object dxDBGridSN4: TdxDBGridSN
              Left = 1
              Top = 1
              Width = 242
              Height = 424
              Align = alClient
              TabOrder = 0
              CriteriosPintarCelda = <>
              object cxGridDBTableView3: TcxGridDBTableView
                NavigatorButtons.ConfirmDelete = False
                DataController.DataSource = DSValoresSectores
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.IncSearch = True
                OptionsData.CancelOnExit = False
                OptionsData.Deleting = False
                OptionsData.DeletingConfirmation = False
                OptionsData.Inserting = False
                OptionsSelection.InvertSelect = False
                OptionsView.CellAutoHeight = True
                OptionsView.GroupByBox = False
                object cxGridDBTableView3Column1: TcxGridDBColumn
                  Caption = 'C'#243'digo'
                  DataBinding.FieldName = 'codigo'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 44
                end
                object cxGridDBColumn5: TcxGridDBColumn
                  Caption = 'Sectores'
                  DataBinding.FieldName = 'descripcion'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  SortIndex = 0
                  SortOrder = soAscending
                  Width = 138
                end
                object cxGridDBColumn6: TcxGridDBColumn
                  Caption = 'Sel.'
                  DataBinding.FieldName = 'activo'
                  HeaderAlignmentHorz = taCenter
                  Width = 38
                end
              end
              object cxGridLevel3: TcxGridLevel
                GridView = cxGridDBTableView3
              end
            end
          end
          object Panel9: TPanel
            Left = 335
            Top = 0
            Width = 244
            Height = 426
            Align = alLeft
            Color = clWindow
            TabOrder = 3
            object dxDBGridSN6: TdxDBGridSN
              Left = 1
              Top = 1
              Width = 242
              Height = 424
              Align = alClient
              TabOrder = 0
              CriteriosPintarCelda = <>
              object cxGridDBTableView5: TcxGridDBTableView
                NavigatorButtons.ConfirmDelete = False
                DataController.DataSource = DSValoresPuestos
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.IncSearch = True
                OptionsData.CancelOnExit = False
                OptionsData.Deleting = False
                OptionsData.DeletingConfirmation = False
                OptionsData.Inserting = False
                OptionsSelection.InvertSelect = False
                OptionsView.CellAutoHeight = True
                OptionsView.GroupByBox = False
                object cxGridDBColumn7: TcxGridDBColumn
                  Caption = 'C'#243'digo'
                  DataBinding.FieldName = 'codigo'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 46
                end
                object cxGridDBColumn8: TcxGridDBColumn
                  Caption = 'Puestos'
                  DataBinding.FieldName = 'descripcion'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  SortIndex = 0
                  SortOrder = soAscending
                  Width = 148
                end
                object cxGridDBColumn9: TcxGridDBColumn
                  Caption = 'Sel.'
                  DataBinding.FieldName = 'activo'
                  HeaderAlignmentHorz = taCenter
                  Width = 30
                end
              end
              object cxGridLevel5: TcxGridLevel
                GridView = cxGridDBTableView5
              end
            end
          end
          object Panel10: TPanel
            Left = 823
            Top = 0
            Width = 244
            Height = 426
            Align = alLeft
            Color = clWindow
            TabOrder = 4
            object dxDBGridSN7: TdxDBGridSN
              Left = 1
              Top = 1
              Width = 242
              Height = 424
              Align = alClient
              TabOrder = 0
              CriteriosPintarCelda = <>
              object cxGridDBTableView6: TcxGridDBTableView
                NavigatorButtons.ConfirmDelete = False
                DataController.DataSource = DSTValoresTareasDesemp
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.IncSearch = True
                OptionsData.CancelOnExit = False
                OptionsData.Deleting = False
                OptionsData.DeletingConfirmation = False
                OptionsData.Inserting = False
                OptionsSelection.InvertSelect = False
                OptionsView.CellAutoHeight = True
                OptionsView.GroupByBox = False
                object cxGridDBColumn10: TcxGridDBColumn
                  Caption = 'C'#243'digo'
                  DataBinding.FieldName = 'codigo'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 46
                end
                object cxGridDBColumn11: TcxGridDBColumn
                  Caption = 'Tarea Desempe'#241'ana'
                  DataBinding.FieldName = 'descripcion'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  SortIndex = 0
                  SortOrder = soAscending
                  Width = 148
                end
                object cxGridDBColumn12: TcxGridDBColumn
                  Caption = 'Sel.'
                  DataBinding.FieldName = 'activo'
                  HeaderAlignmentHorz = taCenter
                  Width = 30
                end
              end
              object cxGridLevel6: TcxGridLevel
                GridView = cxGridDBTableView6
              end
            end
          end
          object Panel11: TPanel
            Left = 579
            Top = 0
            Width = 244
            Height = 426
            Align = alLeft
            Color = clWindow
            TabOrder = 5
            object dxDBGridSN8: TdxDBGridSN
              Left = 1
              Top = 1
              Width = 242
              Height = 424
              Align = alClient
              TabOrder = 0
              CriteriosPintarCelda = <>
              object cxGridDBTableView7: TcxGridDBTableView
                NavigatorButtons.ConfirmDelete = False
                DataController.DataSource = dsTValoresClasesSind
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.IncSearch = True
                OptionsData.CancelOnExit = False
                OptionsData.Deleting = False
                OptionsData.DeletingConfirmation = False
                OptionsData.Inserting = False
                OptionsSelection.InvertSelect = False
                OptionsView.CellAutoHeight = True
                OptionsView.GroupByBox = False
                object cxGridDBColumn13: TcxGridDBColumn
                  Caption = 'C'#243'digo'
                  DataBinding.FieldName = 'codigo'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 46
                end
                object cxGridDBColumn14: TcxGridDBColumn
                  Caption = 'Clase Sindicato'
                  DataBinding.FieldName = 'descripcion'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  SortIndex = 0
                  SortOrder = soAscending
                  Width = 148
                end
                object cxGridDBColumn15: TcxGridDBColumn
                  Caption = 'Sel.'
                  DataBinding.FieldName = 'activo'
                  HeaderAlignmentHorz = taCenter
                  Width = 30
                end
              end
              object cxGridLevel7: TcxGridLevel
                GridView = cxGridDBTableView7
              end
            end
          end
        end
      end
    end
    inherited PCuerpo: TPanel
      Top = 52
      Width = 1073
      Height = 58
      Align = alTop
      object Label3: TLabel
        Left = 24
        Top = 11
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object snDBEdit1: TsnDBEdit
        Left = 116
        Top = 7
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTFiltroLegCab
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 517
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 112
        Top = 32
        Caption = 'Aplicar sobre consulta de Rotas'
        DataBinding.DataField = 'aplic_cons_rotas'
        DataBinding.DataSource = DSTFiltroLegCab
        Properties.ValueChecked = 'True'
        TabOrder = 1
        Width = 185
      end
      object snDBCheckEdit2: TsnDBCheckEdit
        Left = 336
        Top = 32
        Caption = 'Aplicar sobre Busqueda de Legajos'
        DataBinding.DataField = 'aplic_busq_leg'
        DataBinding.DataSource = DSTFiltroLegCab
        Properties.ValueChecked = 'True'
        TabOrder = 2
        Width = 193
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerFiltroLegCab'
    OperGrabarObjeto = 'SaveFiltroLegCab'
    CargaDataSets = <
      item
        DataSet = TFiltroLegCab
        TableName = 'TFiltroLegCab'
      end
      item
        DataSet = TValoresEmpresa
        TableName = 'TValoresEmpresa'
      end
      item
        DataSet = TValoresEstados
        TableName = 'TValoresEstados'
      end
      item
        DataSet = TValoresSectores
        TableName = 'TValoresSectores'
      end
      item
        DataSet = TValoresPuestos
        TableName = 'TValoresPuestos'
      end
      item
        DataSet = TPerfilFilLegCab
        TableName = 'TPerfilFilLegCab'
      end
      item
        DataSet = TValoresTareasDesemp
        TableName = 'TValoresTareasDesemp'
      end
      item
        DataSet = TValoresClasesSind
        TableName = 'TValoresClasesSind'
      end>
    BajaLogica = <
      item
        DataSet = TFiltroLegCab
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TFiltroLegCab
    DataSetDet1 = TValoresEmpresa
    DataSetDet2 = TValoresEstados
    DataSetDet3 = TValoresSectores
    DataSetDet4 = TValoresPuestos
    DataSetDet5 = TPerfilFilLegCab
    DataSetDet6 = TValoresTareasDesemp
    DataSetDet7 = TValoresClasesSind
    ControlFocoAlta = snDBEdit1
    ControlFocoModif = snDBEdit1
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TFiltroLegCab: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_filtro_cab'
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
        Size = 250
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'aplic_cons_rotas'
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
    Left = 488
    Top = 51
    object TFiltroLegCaboid_filtro_cab: TIntegerField
      FieldName = 'oid_filtro_cab'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TFiltroLegCabcodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
      Size = 50
    end
    object TFiltroLegCabdescripcion: TStringField
      DisplayWidth = 250
      FieldName = 'descripcion'
      Size = 250
    end
    object TFiltroLegCabactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TFiltroLegCabaplic_cons_rotas: TBooleanField
      FieldName = 'aplic_cons_rotas'
    end
    object TFiltroLegCabaplic_busq_leg: TBooleanField
      FieldName = 'aplic_busq_leg'
    end
  end
  object DSTFiltroLegCab: TDataSource [4]
    DataSet = TFiltroLegCab
    Left = 520
    Top = 51
  end
  inherited TOidObjSave: TsnTable
    Left = 608
  end
  inherited TOpcHabPrograma: TsnTable
    Top = 16
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 40
    Top = 80
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 152
    Top = 80
  end
  inherited DriverEvent: TDriverEvent
    OnBeforePost = <
      item
        TableName = 'TFiltroLegCab'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'descripcion'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Descrip' +
            'ci'#243'n'#39');'
          'end.')
      end
      item
        TableName = 'TPerfilFilLegCab'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_perfil'#39').AsInteger=0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el perfil' +
            #39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TFiltroLegCab'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TValoresEmpresa'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          
            '  DataSet.FieldName('#39'oid_filtro_cab'#39').Value := TFiltroLegCab.Fie' +
            'ldName('#39'oid_filtro_cab'#39').Value;'
          'end.')
      end
      item
        TableName = 'TValoresEstados'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          
            '  DataSet.FieldName('#39'oid_filtro_cab'#39').Value := TFiltroLegCab.Fie' +
            'ldName('#39'oid_filtro_cab'#39').Value;'
          'end.')
      end
      item
        TableName = 'TValoresSectores'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          
            '  DataSet.FieldName('#39'oid_filtro_cab'#39').Value := TFiltroLegCab.Fie' +
            'ldName('#39'oid_filtro_cab'#39').Value;'
          'end.')
      end
      item
        TableName = 'TValoresPuestos'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          
            '  DataSet.FieldName('#39'oid_filtro_cab'#39').Value := TFiltroLegCab.Fie' +
            'ldName('#39'oid_filtro_cab'#39').Value;'
          'end.')
      end
      item
        TableName = 'TPerfilFilLegCab'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := True;'
          '  DataSet.FieldName('#39'oid_filtro_cab'#39').AsInteger :='
          '           TFiltroLegCab.FieldName('#39'oid_filtro_cab'#39').AsInteger;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  HelpPerfiles.loadFromHelp('#39'HelpPerfilesFuncionales'#39');'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure llenarDatosFiltro();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerFiltroLegCab'#39');'
          '  operacion.AddAtribute('#39'TRAER_VAL_DATOS_FILTRO'#39','#39#39');'
          
            '  operacion.AddAtribute('#39'oid_filtro'#39',TFiltroLegCab.FieldName('#39'oi' +
            'd_filtro_cab'#39').AsString);'
          '  operacion.execute();'
          'end;'
          ''
          '')
      end>
    OnAfterNuevo = <
      item
        Source.Strings = (
          'begin'
          '  llenarDatosFiltro();'
          'end.')
      end>
    Left = 120
    Top = 83
  end
  inherited SaveArchivo: TSaveDialog
    Top = 216
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 81
    Top = 80
  end
  inherited ImageListGruposPopUp: TImageList
    Left = 176
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 472
    Top = 131
  end
  object HelpFiltrosLeg: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.FiltroLegCab'
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
    Titulo = 'Filtros de Legajos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object TValoresEmpresa: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_val_filtro_det'
        DataType = ftInteger
      end
      item
        Name = 'oid_filtro_cab'
        DataType = ftInteger
      end
      item
        Name = 'oid_valor'
        DataType = ftInteger
      end
      item
        Name = 'tipo'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_filtro_cab'
    IndexDefs = <
      item
        Name = 'TValoresEmpresaIndex1'
        Fields = 'oid_filtro_cab'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_filtro_cab'
    MasterSource = DSTFiltroLegCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 296
    Top = 140
    object TValoresEmpresaoid_val_filtro_det: TIntegerField
      FieldName = 'oid_val_filtro_det'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TValoresEmpresaoid_filtro_cab: TIntegerField
      FieldName = 'oid_filtro_cab'
    end
    object TValoresEmpresaoid_valor: TIntegerField
      FieldName = 'oid_valor'
    end
    object TValoresEmpresatipo: TStringField
      FieldName = 'tipo'
      Size = 10
    end
    object TValoresEmpresadescripcion: TStringField
      FieldName = 'descripcion'
      Size = 255
    end
    object TValoresEmpresaactivo: TBooleanField
      FieldName = 'activo'
    end
    object TValoresEmpresacodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
  end
  object DSTempVarForm: TDataSource
    DataSet = TValoresEmpresa
    Left = 560
    Top = 247
  end
  object DSValoresEmpresa: TDataSource
    DataSet = TValoresEmpresa
    Left = 328
    Top = 140
  end
  object TValoresEstados: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_val_filtro_det'
        DataType = ftInteger
      end
      item
        Name = 'oid_filtro_cab'
        DataType = ftInteger
      end
      item
        Name = 'oid_valor'
        DataType = ftInteger
      end
      item
        Name = 'tipo'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_filtro_cab'
    IndexDefs = <
      item
        Name = 'TValoresEstadosIndex1'
        Fields = 'oid_filtro_cab'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_filtro_cab'
    MasterSource = DSTFiltroLegCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 368
    Top = 140
    object TValoresEstadosoid_val_filtro_det: TIntegerField
      FieldName = 'oid_val_filtro_det'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TValoresEstadosoid_filtro_cab: TIntegerField
      FieldName = 'oid_filtro_cab'
    end
    object TValoresEstadosoid_valor: TIntegerField
      FieldName = 'oid_valor'
    end
    object TValoresEstadostipo: TStringField
      FieldName = 'tipo'
      Size = 10
    end
    object TValoresEstadosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 255
    end
    object TValoresEstadosactivo: TBooleanField
      FieldName = 'activo'
    end
    object TValoresEstadoscodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
  end
  object DSValoresEstados: TDataSource
    DataSet = TValoresEstados
    Left = 400
    Top = 140
  end
  object TValoresSectores: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_val_filtro_det'
        DataType = ftInteger
      end
      item
        Name = 'oid_filtro_cab'
        DataType = ftInteger
      end
      item
        Name = 'oid_valor'
        DataType = ftInteger
      end
      item
        Name = 'tipo'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_filtro_cab'
    IndexDefs = <
      item
        Name = 'TValoresEstadosIndex1'
        Fields = 'oid_filtro_cab'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_filtro_cab'
    MasterSource = DSTFiltroLegCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 446
    Top = 140
    object IntegerField1: TIntegerField
      FieldName = 'oid_val_filtro_det'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField2: TIntegerField
      FieldName = 'oid_filtro_cab'
    end
    object IntegerField3: TIntegerField
      FieldName = 'oid_valor'
    end
    object StringField1: TStringField
      FieldName = 'tipo'
      Size = 10
    end
    object StringField2: TStringField
      FieldName = 'descripcion'
      Size = 255
    end
    object BooleanField1: TBooleanField
      FieldName = 'activo'
    end
    object TValoresSectorescodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
  end
  object DSValoresSectores: TDataSource
    DataSet = TValoresSectores
    Left = 478
    Top = 140
  end
  object TValoresPuestos: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_val_filtro_det'
        DataType = ftInteger
      end
      item
        Name = 'oid_filtro_cab'
        DataType = ftInteger
      end
      item
        Name = 'oid_valor'
        DataType = ftInteger
      end
      item
        Name = 'tipo'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_filtro_cab'
    IndexDefs = <
      item
        Name = 'TValoresEstadosIndex1'
        Fields = 'oid_filtro_cab'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_filtro_cab'
    MasterSource = DSTFiltroLegCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 541
    Top = 92
    object IntegerField4: TIntegerField
      FieldName = 'oid_val_filtro_det'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField5: TIntegerField
      FieldName = 'oid_filtro_cab'
    end
    object IntegerField6: TIntegerField
      FieldName = 'oid_valor'
    end
    object StringField3: TStringField
      FieldName = 'tipo'
      Size = 10
    end
    object StringField4: TStringField
      FieldName = 'descripcion'
      Size = 255
    end
    object BooleanField2: TBooleanField
      FieldName = 'activo'
    end
    object TValoresPuestoscodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
  end
  object DSValoresPuestos: TDataSource
    DataSet = TValoresPuestos
    Left = 573
    Top = 92
  end
  object TPerfilFilLegCab: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_perfil_leg_filtro'
        DataType = ftInteger
      end
      item
        Name = 'oid_filtro_cab'
        DataType = ftInteger
      end
      item
        Name = 'oid_perfil'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_filtro_cab'
    IndexDefs = <
      item
        Name = 'TPerfilFilLegCabIndex1'
        Fields = 'oid_filtro_cab'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_filtro_cab'
    MasterSource = DSTFiltroLegCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 626
    Top = 96
    object TPerfilFilLegCaboid_perfil_leg_filtro: TIntegerField
      FieldName = 'oid_perfil_leg_filtro'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPerfilFilLegCaboid_filtro_cab: TIntegerField
      FieldName = 'oid_filtro_cab'
    end
    object TPerfilFilLegCaboid_perfil: TIntegerField
      FieldName = 'oid_perfil'
    end
    object TPerfilFilLegCabactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSPerfilFilLegCab: TDataSource
    DataSet = TPerfilFilLegCab
    Left = 656
    Top = 97
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
    Left = 570
    Top = 316
  end
  object HelpPerfiles: TsnTable
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
    Left = 604
    Top = 316
    object HelpPerfilesoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object HelpPerfilescodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object HelpPerfilesdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object HelpPerfilesactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSPerfiles: TDataSource
    DataSet = HelpPerfiles
    Left = 642
    Top = 320
  end
  object TValoresTareasDesemp: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_val_filtro_det'
        DataType = ftInteger
      end
      item
        Name = 'oid_filtro_cab'
        DataType = ftInteger
      end
      item
        Name = 'oid_valor'
        DataType = ftInteger
      end
      item
        Name = 'tipo'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 50
      end>
    IndexFieldNames = 'oid_filtro_cab'
    IndexDefs = <
      item
        Name = 'TPerfilFilLegCabIndex1'
        Fields = 'oid_filtro_cab'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_filtro_cab'
    MasterSource = DSTFiltroLegCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 707
    Top = 96
    object TValoresTareasDesempoid_val_filtro_det: TIntegerField
      FieldName = 'oid_val_filtro_det'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TValoresTareasDesempoid_filtro_cab: TIntegerField
      FieldName = 'oid_filtro_cab'
    end
    object TValoresTareasDesempoid_valor: TIntegerField
      FieldName = 'oid_valor'
    end
    object TValoresTareasDesemptipo: TStringField
      FieldName = 'tipo'
      Size = 10
    end
    object TValoresTareasDesempdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 255
    end
    object TValoresTareasDesempactivo: TBooleanField
      FieldName = 'activo'
    end
    object TValoresTareasDesempcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
  end
  object DSTValoresTareasDesemp: TDataSource
    DataSet = TValoresTareasDesemp
    Left = 737
    Top = 97
  end
  object TValoresClasesSind: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_val_filtro_det'
        DataType = ftInteger
      end
      item
        Name = 'oid_filtro_cab'
        DataType = ftInteger
      end
      item
        Name = 'oid_valor'
        DataType = ftInteger
      end
      item
        Name = 'tipo'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 50
      end>
    IndexFieldNames = 'oid_filtro_cab'
    IndexDefs = <
      item
        Name = 'TPerfilFilLegCabIndex1'
        Fields = 'oid_filtro_cab'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_filtro_cab'
    MasterSource = DSTFiltroLegCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 792
    Top = 96
    object IntegerField7: TIntegerField
      FieldName = 'oid_val_filtro_det'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField8: TIntegerField
      FieldName = 'oid_filtro_cab'
    end
    object IntegerField9: TIntegerField
      FieldName = 'oid_valor'
    end
    object StringField5: TStringField
      FieldName = 'tipo'
      Size = 10
    end
    object StringField6: TStringField
      FieldName = 'descripcion'
      Size = 255
    end
    object BooleanField3: TBooleanField
      FieldName = 'activo'
    end
    object StringField7: TStringField
      FieldName = 'codigo'
      Size = 50
    end
  end
  object dsTValoresClasesSind: TDataSource
    DataSet = TValoresClasesSind
    Left = 822
    Top = 97
  end
end
