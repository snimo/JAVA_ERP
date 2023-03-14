inherited FRecluProceso: TFRecluProceso
  Left = 250
  Top = 0
  Width = 758
  Height = 574
  Caption = 'Procesos'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 742
    Height = 536
    inherited PPie: TPanel
      Top = 515
      Width = 742
      inherited StatusBarABM: TStatusBar
        Left = 637
      end
      inherited StatusBar2: TStatusBar
        Width = 637
      end
    end
    inherited PMenu: TPanel
      Width = 742
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRecluProceso
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRecluProceso
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpGrupoProcesos
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpGrupoProcesos
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpGrupoProcesos
      end
      inherited Panel2: TPanel
        Left = 701
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTRecluProceso
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
      Width = 742
    end
    inherited PCabecera: TPanel
      Width = 742
      Height = 194
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
      object Label3: TLabel
        Left = 40
        Top = 104
        Width = 29
        Height = 13
        Caption = 'Orden'
      end
      object Label4: TLabel
        Left = 40
        Top = 144
        Width = 97
        Height = 13
        Caption = 'Costo Inicio Proceso'
      end
      object DBECodigo: TsnDBEdit
        Left = 148
        Top = 20
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTRecluProceso
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object DBEDescripcion: TsnDBEdit
        Left = 148
        Top = 60
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTRecluProceso
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 273
      end
      object snDBEdit1: TsnDBEdit
        Left = 148
        Top = 100
        DataBinding.DataField = 'orden'
        DataBinding.DataSource = DSTRecluProceso
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 2
        Width = 69
      end
      object snDBEdit2: TsnDBEdit
        Left = 148
        Top = 140
        DataBinding.DataField = 'costo'
        DataBinding.DataSource = DSTRecluProceso
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 3
        Width = 93
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 40
        Top = 176
        Caption = 'Alta Solapa Postulante'
        DataBinding.DataField = 'alta_solapa_postu'
        DataBinding.DataSource = DSTRecluProceso
        TabOrder = 4
        Width = 145
      end
      object snDBCheckEdit2: TsnDBCheckEdit
        Left = 208
        Top = 173
        Caption = 'Visualizar Solapa Postulante'
        DataBinding.DataField = 'visu_solapa_postu'
        DataBinding.DataSource = DSTRecluProceso
        TabOrder = 5
        Width = 169
      end
      object snDBCheckEdit3: TsnDBCheckEdit
        Left = 400
        Top = 172
        Caption = 'Visualizar en consulta de Recepci'#243'n'
        DataBinding.DataField = 'visu_cons_recepcion'
        DataBinding.DataSource = DSTRecluProceso
        TabOrder = 6
        Width = 225
      end
      object snDBCheckEdit4: TsnDBCheckEdit
        Left = 613
        Top = 171
        Caption = 'Alta en B'#250'squeda'
        DataBinding.DataField = 'alta_en_busqueda'
        DataBinding.DataSource = DSTRecluProceso
        TabOrder = 7
        Width = 225
      end
    end
    inherited PCuerpo: TPanel
      Top = 246
      Width = 742
      Height = 269
      BorderWidth = 10
      object dxDBGridSN1: TdxDBGridSN
        Left = 10
        Top = 10
        Width = 722
        Height = 249
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
          DataController.DataSource = DSRecluConcepto
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
          object cxGridDBTableView1descripcion: TcxGridDBColumn
            Caption = 'Tipo de Ex'#225'men'
            DataBinding.FieldName = 'descripcion'
            Width = 334
          end
          object cxGridDBTableView1costo: TcxGridDBColumn
            Caption = 'Costo'
            DataBinding.FieldName = 'costo'
            HeaderAlignmentHorz = taCenter
            Width = 118
          end
          object cxGridDBTableView1Column1: TcxGridDBColumn
            Caption = 'Alta Busq.?'
            DataBinding.FieldName = 'alta_en_busqueda'
            PropertiesClassName = 'TcxCheckBoxProperties'
            Width = 66
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
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerRecluProceso'
    OperGrabarObjeto = 'SaveRecluProceso'
    CargaDataSets = <
      item
        DataSet = TRecluProceso
        TableName = 'TRecluProceso'
      end
      item
        DataSet = TRecluConceptoProceso
        TableName = 'TRecluConceptoProceso'
      end>
    BajaLogica = <
      item
        DataSet = TRecluProceso
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TRecluProceso
    DataSetDet1 = TRecluConceptoProceso
    Left = 512
    Top = 24
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TRecluProceso: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_proceso'
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
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'costo'
        DataType = ftFloat
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
    Left = 640
    Top = 59
    object TRecluProcesooid_proceso: TIntegerField
      FieldName = 'oid_proceso'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRecluProcesocodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TRecluProcesodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TRecluProcesoorden: TIntegerField
      FieldName = 'orden'
    end
    object TRecluProcesocosto: TFloatField
      FieldName = 'costo'
    end
    object TRecluProcesoactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TRecluProcesoalta_solapa_postu: TBooleanField
      FieldName = 'alta_solapa_postu'
    end
    object TRecluProcesovisu_solapa_postu: TBooleanField
      FieldName = 'visu_solapa_postu'
    end
    object TRecluProcesovisu_cons_recepcion: TBooleanField
      FieldName = 'visu_cons_recepcion'
    end
    object TRecluProcesoalta_en_busqueda: TBooleanField
      FieldName = 'alta_en_busqueda'
    end
  end
  object DSTRecluProceso: TDataSource [4]
    DataSet = TRecluProceso
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
        TableName = 'TRecluProceso'
        FieldName = 'codigo'
        Source.Strings = (
          'program validar;'
          'begin'
          '  ValidadorProceso.Value := Sender.AsString;'
          '  ValidadorProceso.Validar();'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TRecluConceptoProceso'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'descripcion'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la descrip' +
            'ci'#243'n del concepto'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TRecluProceso'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end
      item
        TableName = 'TRecluConceptoProceso'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_proceso'#39').Value :=  TRecluProceso.Field' +
            'Name('#39'oid_proceso'#39').Value;'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end>
    Left = 320
  end
  inherited SaveArchivo: TSaveDialog
    Left = 408
    Top = 136
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 280
    Top = 68
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 512
  end
  object HelpGrupoProcesos: TsnHelp
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
    Titulo = 'Procesos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 202
    Top = 68
  end
  object ValidadorProceso: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluProceso'
    WhenRaiseException = teFound
    MensajeException = 'Codigo de Proceso Existente'
    NroQuery = 0
    Cache = False
    Left = 240
    Top = 67
  end
  object TRecluConceptoProceso: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_conc_proceso'
        DataType = ftInteger
      end
      item
        Name = 'oid_proceso'
        DataType = ftInteger
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'costo'
        DataType = ftFloat
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_proceso'
    IndexDefs = <
      item
        Name = 'TRecluConceptoProcesoIndex1'
        Fields = 'oid_proceso'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_proceso'
    MasterSource = DSTRecluProceso
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 616
    Top = 132
    object TRecluConceptoProcesooid_conc_proceso: TIntegerField
      FieldName = 'oid_conc_proceso'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRecluConceptoProcesooid_proceso: TIntegerField
      FieldName = 'oid_proceso'
    end
    object TRecluConceptoProcesodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TRecluConceptoProcesocosto: TFloatField
      FieldName = 'costo'
    end
    object TRecluConceptoProcesoactivo: TBooleanField
      FieldName = 'activo'
    end
    object TRecluConceptoProcesoalta_en_busqueda: TBooleanField
      FieldName = 'alta_en_busqueda'
    end
  end
  object DSRecluConcepto: TDataSource
    DataSet = TRecluConceptoProceso
    Left = 648
    Top = 132
  end
end
