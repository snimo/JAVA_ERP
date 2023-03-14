inherited FDispMovExc: TFDispMovExc
  Left = 205
  Top = 103
  Width = 832
  Height = 677
  Caption = 'Dispositivos M'#243'viles'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 816
    Height = 639
    inherited PPie: TPanel
      Top = 618
      Width = 816
      inherited StatusBarABM: TStatusBar
        Left = 711
      end
      inherited StatusBar2: TStatusBar
        Width = 711
      end
    end
    inherited PMenu: TPanel
      Width = 816
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTDispMovilExc
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTDispMovilExc
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpDispMovil
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpDispMovil
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpDispMovil
      end
      inherited Panel2: TPanel
        Left = 775
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTDispMovilExc
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
      Width = 816
    end
    inherited PCabecera: TPanel
      Width = 816
      Height = 262
      object Label2: TLabel
        Left = 40
        Top = 56
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object Label1: TLabel
        Left = 40
        Top = 16
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object DBECodigo: TsnDBEdit
        Left = 156
        Top = 12
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTDispMovilExc
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBEdit1: TsnDBEdit
        Left = 156
        Top = 52
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTDispMovilExc
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object GroupBox1: TGroupBox
        Left = 32
        Top = 91
        Width = 545
        Height = 170
        Caption = 'Datos Referidos a la Sincronizaci'#243'n'
        TabOrder = 2
        object Label3: TLabel
          Left = 24
          Top = 24
          Width = 87
          Height = 13
          Caption = 'Grupo Importaci'#243'n'
        end
        object Label4: TLabel
          Left = 24
          Top = 56
          Width = 104
          Height = 13
          Caption = 'Fec. Hora. Ult. / Sinc.'
        end
        object Label5: TLabel
          Left = 288
          Top = 56
          Width = 90
          Height = 13
          Caption = 'Ult. Nro. Lote Sinc.'
        end
        object DBProvincia: TsnDBLookup
          Left = 136
          Top = 20
          DataBinding.DataField = 'oid_grupo_imp_exc'
          DataBinding.DataSource = DSTDispMovilExc
          Properties.KeyFieldNames = 'oid'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          Properties.ListSource = DSTGrupoImp
          TabOrder = 0
          Width = 177
        end
        object snDBEdit2: TsnDBEdit
          Left = 137
          Top = 52
          DataBinding.DataField = 'fec_hor_ult_sinc_ol'
          DataBinding.DataSource = DSTDispMovilExc
          Properties.CharCase = ecUpperCase
          Properties.MaxLength = 20
          Properties.ReadOnly = True
          Style.BorderColor = clWindowFrame
          Style.Color = 8454143
          Style.Shadow = False
          TabOrder = 1
          Width = 133
        end
        object snDBEdit3: TsnDBEdit
          Left = 385
          Top = 52
          DataBinding.DataField = 'ult_nro_lote_inf'
          DataBinding.DataSource = DSTDispMovilExc
          Properties.CharCase = ecUpperCase
          Properties.MaxLength = 20
          Properties.ReadOnly = True
          Style.BorderColor = clWindowFrame
          Style.Color = 8454143
          Style.Shadow = False
          TabOrder = 2
          Width = 88
        end
        object snDBCheckEdit1: TsnDBCheckEdit
          Left = 24
          Top = 88
          Caption = 
            'Forzar Sincronizaci'#243'n de todos los Datos en pr'#243'xima Sincronizaci' +
            #243'n'
          DataBinding.DataField = 'forzar_sinc_all'
          DataBinding.DataSource = DSTDispMovilExc
          TabOrder = 3
          Width = 353
        end
        object snDBCheckEdit2: TsnDBCheckEdit
          Left = 24
          Top = 128
          Caption = 'Forzar Siempre la Actualizaci'#243'n de Todos los Datos'
          DataBinding.DataField = 'forzar_siempre_sinc'
          DataBinding.DataSource = DSTDispMovilExc
          TabOrder = 4
          Width = 273
        end
      end
    end
    inherited PCuerpo: TPanel
      Top = 314
      Width = 816
      Height = 304
      object dxDBGridSN3: TdxDBGridSN
        Left = 0
        Top = 41
        Width = 816
        Height = 263
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
          DataController.DataSource = DSLogSincro
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
          object cxGridDBTableView3fecha: TcxGridDBColumn
            Caption = 'Fecha'
            DataBinding.FieldName = 'fecha'
            HeaderAlignmentHorz = taCenter
            Options.Editing = False
            Width = 113
          end
          object cxGridDBTableView3hora: TcxGridDBColumn
            Caption = 'Hora'
            DataBinding.FieldName = 'hora'
            HeaderAlignmentHorz = taCenter
            Options.Editing = False
            Width = 62
          end
          object cxGridDBTableView3grupo_importacion: TcxGridDBColumn
            Caption = 'Grupo Importaci'#243'n'
            DataBinding.FieldName = 'grupo_importacion'
            HeaderAlignmentHorz = taCenter
            Options.Editing = False
            Width = 113
          end
          object cxGridDBTableView3nro_lote: TcxGridDBColumn
            Caption = 'Nro. Lote'
            DataBinding.FieldName = 'nro_lote'
            HeaderAlignmentHorz = taCenter
            Options.Editing = False
            Width = 73
          end
          object cxGridDBTableView3Column1: TcxGridDBColumn
            DataBinding.FieldName = 'oid_log_sincro'
            Visible = False
            SortIndex = 0
            SortOrder = soDescending
          end
        end
        object cxGridLevel3: TcxGridLevel
          GridView = cxGridDBTableView3
        end
      end
      object Panel1: TPanel
        Left = 0
        Top = 0
        Width = 816
        Height = 41
        Align = alTop
        Color = clWindow
        TabOrder = 1
        object Label6: TLabel
          Left = 40
          Top = 12
          Width = 134
          Height = 13
          Caption = 'Ver '#250'ltimas Sincronizaciones'
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerDispMovilExc'
    OperGrabarObjeto = 'SaveDispMovilExc'
    CargaDataSets = <
      item
        DataSet = TDispMovilExc
        TableName = 'TDispMovilExc'
      end
      item
        DataSet = TLogSincro
        TableName = 'TLogSincro'
      end>
    BajaLogica = <
      item
        DataSet = TDispMovilExc
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TDispMovilExc
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 552
    Top = 16
  end
  object TDispMovilExc: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_disp_movil'
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
      end
      item
        Name = 'oid_grupo_imp_exc'
        DataType = ftInteger
      end
      item
        Name = 'fec_hor_ult_sinc_ol'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'forzar_sinc_all'
        DataType = ftBoolean
      end
      item
        Name = 'ult_nro_lote_inf'
        DataType = ftInteger
      end
      item
        Name = 'forzar_siempre_sinc'
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
    object TDispMovilExcoid_disp_movil: TIntegerField
      FieldName = 'oid_disp_movil'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TDispMovilExccodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TDispMovilExcdescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TDispMovilExcactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TDispMovilExcoid_grupo_imp_exc: TIntegerField
      FieldName = 'oid_grupo_imp_exc'
    end
    object TDispMovilExcfec_hor_ult_sinc_ol: TStringField
      FieldName = 'fec_hor_ult_sinc_ol'
      Size = 50
    end
    object TDispMovilExcforzar_sinc_all: TBooleanField
      FieldName = 'forzar_sinc_all'
    end
    object TDispMovilExcult_nro_lote_inf: TIntegerField
      FieldName = 'ult_nro_lote_inf'
    end
    object TDispMovilExcforzar_siempre_sinc: TBooleanField
      FieldName = 'forzar_siempre_sinc'
    end
  end
  object DSTDispMovilExc: TDataSource [4]
    DataSet = TDispMovilExc
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
    Left = 488
    Top = 48
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TDispMovilExc'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorDispositivo.Value := Sender.AsString;'
          '  ValidadorDispositivo.Validar;'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TDispMovilExc'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          '  DataSet.FieldName('#39'forzar_sinc_all'#39').AsBoolean := True;'
          '  DataSet.FieldName('#39'forzar_siempre_sinc'#39').AsBoolean := false;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TGrupoImp.loadFromHelp('#39'HelpGrupoImp'#39');'
          'end.')
      end>
    Left = 728
    Top = 19
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 697
    Top = 16
  end
  object HelpDispMovil: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'exc.DispMovilExc'
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
    Titulo = 'Dispositivos M'#243'viles'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorDispositivo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'exc.DispMovilExc'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Dispositivo duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
  object TGrupoImp: TsnTable
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
    Left = 642
    Top = 169
    object TGrupoImpoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TGrupoImpcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TGrupoImpdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
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
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 610
    Top = 169
  end
  object DSTGrupoImp: TDataSource
    DataSet = TGrupoImp
    Left = 680
    Top = 171
  end
  object TLogSincro: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_log_sincro'
        DataType = ftInteger
      end
      item
        Name = 'oid_disp_movil'
        DataType = ftInteger
      end
      item
        Name = 'fecha'
        DataType = ftDate
      end
      item
        Name = 'hora'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'grupo_importacion'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'nro_lote'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_disp_movil'
    IndexDefs = <
      item
        Name = 'TLogSincroIndex1'
        Fields = 'oid_disp_movil'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_disp_movil'
    MasterSource = DSTDispMovilExc
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 664
    Top = 259
    object TLogSincrooid_log_sincro: TIntegerField
      FieldName = 'oid_log_sincro'
    end
    object TLogSincrooid_disp_movil: TIntegerField
      FieldName = 'oid_disp_movil'
    end
    object TLogSincrofecha: TDateField
      FieldName = 'fecha'
    end
    object TLogSincrohora: TStringField
      FieldName = 'hora'
      Size = 50
    end
    object TLogSincrogrupo_importacion: TStringField
      FieldName = 'grupo_importacion'
      Size = 50
    end
    object TLogSincronro_lote: TIntegerField
      FieldName = 'nro_lote'
    end
  end
  object DSLogSincro: TDataSource
    DataSet = TLogSincro
    Left = 696
    Top = 259
  end
end
