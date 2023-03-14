inherited FTipoNovedad: TFTipoNovedad
  Top = 203
  Width = 749
  Height = 641
  Caption = 'Tipos de Novedades'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 733
    Height = 603
    inherited PPie: TPanel
      Top = 582
      Width = 733
      inherited StatusBarABM: TStatusBar
        Left = 628
      end
      inherited StatusBar2: TStatusBar
        Width = 628
      end
    end
    inherited PMenu: TPanel
      Width = 733
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTTipoNovedad
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTTipoNovedad
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpTiposNov
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpTiposNov
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpTiposNov
      end
      inherited Panel2: TPanel
        Left = 692
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTTipoNovedad
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
      Width = 733
    end
    inherited PCabecera: TPanel
      Top = 146
      Width = 733
      Height = 436
      Align = alClient
      object Panel1: TPanel
        Left = 0
        Top = 0
        Width = 733
        Height = 436
        Align = alClient
        Color = clWindow
        TabOrder = 0
        object dxDBGridSN13: TdxDBGridSN
          Left = 1
          Top = 1
          Width = 731
          Height = 434
          Align = alClient
          BorderWidth = 5
          TabOrder = 0
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
            DataController.DataSource = DSTMotivoTipoNov
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
            object cxGridDBTableView12codigo: TcxGridDBColumn
              Caption = 'C'#243'digo'
              DataBinding.FieldName = 'codigo'
              HeaderAlignmentHorz = taCenter
              Width = 107
            end
            object cxGridDBTableView12descripcion: TcxGridDBColumn
              Caption = 'Descripci'#243'n'
              DataBinding.FieldName = 'descripcion'
              HeaderAlignmentHorz = taCenter
              Width = 359
            end
            object cxGridDBTableView12activo: TcxGridDBColumn
              Caption = 'Activo'
              DataBinding.FieldName = 'activo'
              HeaderAlignmentHorz = taCenter
              Width = 45
            end
            object cxGridDBTableView12Column1: TcxGridDBColumn
              DataBinding.FieldName = 'orden'
              Visible = False
              SortIndex = 0
              SortOrder = soAscending
            end
          end
          object cxGridLevel12: TcxGridLevel
            GridView = cxGridDBTableView12
          end
        end
      end
    end
    inherited PCuerpo: TPanel
      Top = 52
      Width = 733
      Height = 94
      Align = alTop
      object Label1: TLabel
        Left = 24
        Top = 24
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label3: TLabel
        Left = 24
        Top = 56
        Width = 47
        Height = 13
        Caption = 'Definici'#243'n'
      end
      object DBECodigo: TsnDBEdit
        Left = 140
        Top = 20
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTTipoNovedad
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 181
      end
      object snDBEdit1: TsnDBEdit
        Left = 140
        Top = 52
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTTipoNovedad
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 517
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerTipoNovedad'
    OperGrabarObjeto = 'SaveTipoNovedad'
    CargaDataSets = <
      item
        DataSet = TTipoNovedad
        TableName = 'TTipoNovedad'
      end
      item
        DataSet = TMotivoTipoNov
        TableName = 'TMotivoTipoNov'
      end>
    BajaLogica = <
      item
        DataSet = TTipoNovedad
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TTipoNovedad
    DataSetDet1 = TMotivoTipoNov
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TTipoNovedad: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_tipo_novedad'
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
    Left = 648
    Top = 59
    object TTipoNovedadoid_tipo_novedad: TIntegerField
      FieldName = 'oid_tipo_novedad'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TTipoNovedadcodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TTipoNovedaddescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TTipoNovedadactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTTipoNovedad: TDataSource [4]
    DataSet = TTipoNovedad
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
    Left = 344
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
    Left = 456
    Top = 80
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TTipoNovedad'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorTipoNovedad.Value := Sender.AsString;'
          '  ValidadorTipoNovedad.Validar;'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TTipoNovedad'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'codigo'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el c'#243'digo'#39 +
            ');'
          '  if (DataSet.FieldName('#39'descripcion'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Descrip' +
            'ci'#243'n'#39');'
          'end.')
      end
      item
        TableName = 'TMotivoTipoNov'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'codigo'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el C'#243'digo'#39 +
            ');'
          '  if (DataSet.FieldName('#39'descripcion'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Descrip' +
            'ci'#243'n'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TTipoNovedad'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TMotivoTipoNov'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_tipo_nov'#39').AsInteger := TTipoNovedad.Fi' +
            'eldName('#39'oid_tipo_novedad'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end>
    Left = 424
    Top = 83
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 385
    Top = 80
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 464
    Top = 147
  end
  object HelpTiposNov: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.TipoNovedad'
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
    Titulo = 'Tipos Novedades'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorTipoNovedad: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rh.TipoNovedad'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Tipo de Novedad duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
  object TMotivoTipoNov: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_mot_tipo_nov'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_nov'
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
    IndexFieldNames = 'oid_tipo_nov;orden'
    IndexDefs = <
      item
        Name = 'TMotivoTipoNovIndex1'
        Fields = 'oid_tipo_nov;orden'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_tipo_novedad'
    MasterSource = DSTTipoNovedad
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 648
    Top = 106
    object TMotivoTipoNovoid_mot_tipo_nov: TIntegerField
      FieldName = 'oid_mot_tipo_nov'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TMotivoTipoNovoid_tipo_nov: TIntegerField
      FieldName = 'oid_tipo_nov'
    end
    object TMotivoTipoNovcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TMotivoTipoNovdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TMotivoTipoNovactivo: TBooleanField
      FieldName = 'activo'
    end
    object TMotivoTipoNovorden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
  end
  object DSTMotivoTipoNov: TDataSource
    DataSet = TMotivoTipoNov
    Left = 680
    Top = 108
  end
end
