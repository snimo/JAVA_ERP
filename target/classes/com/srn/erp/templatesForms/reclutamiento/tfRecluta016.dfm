inherited FEstBusquedaCandi: TFEstBusquedaCandi
  Width = 770
  Caption = 'Estado B'#250'squeda Candidato'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 754
    inherited PPie: TPanel
      Width = 754
      inherited StatusBarABM: TStatusBar
        Left = 649
      end
      inherited StatusBar2: TStatusBar
        Width = 649
      end
    end
    inherited PMenu: TPanel
      Width = 754
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRecluEstCandidatoBusq
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRecluEstCandidatoBusq
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpEstBusqCandidato
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpEstBusqCandidato
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpEstBusqCandidato
      end
      inherited Panel2: TPanel
        Left = 713
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTRecluEstCandidatoBusq
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
      Width = 754
    end
    inherited PCabecera: TPanel
      Width = 754
      Height = 266
      object Label1: TLabel
        Left = 40
        Top = 24
        Width = 33
        Height = 13
        Caption = 'Codigo'
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
        Width = 24
        Height = 13
        Caption = 'Color'
      end
      object Label4: TLabel
        Left = 24
        Top = 240
        Width = 325
        Height = 13
        Caption = 
          'Disparar advertencia si hay alg'#250'n proceso con los siguientes est' +
          'ados'
      end
      object Label5: TLabel
        Left = 40
        Top = 144
        Width = 126
        Height = 13
        Caption = 'Pasar Postulante al estado'
      end
      object Label6: TLabel
        Left = 355
        Top = 211
        Width = 128
        Height = 13
        Caption = 'Al cerrar B'#250'squeda pasar a'
      end
      object DBECodigo: TsnDBEdit
        Left = 180
        Top = 20
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTRecluEstCandidatoBusq
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object DBEDescripcion: TsnDBEdit
        Left = 180
        Top = 60
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTRecluEstCandidatoBusq
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 273
      end
      object snDBLookup1: TsnDBLookup
        Left = 180
        Top = 100
        DataBinding.DataField = 'color'
        DataBinding.DataSource = DSTRecluEstCandidatoBusq
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSColores
        TabOrder = 2
        Width = 277
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 178
        Top = 208
        Caption = 'Puede Cerrar B'#250'squeda?'
        DataBinding.DataField = 'puede_cerrar_busq'
        DataBinding.DataSource = DSTRecluEstCandidatoBusq
        TabOrder = 5
        Width = 169
      end
      object snDBLookup2: TsnDBLookup
        Left = 180
        Top = 140
        DataBinding.DataField = 'oid_estado_postu'
        DataBinding.DataSource = DSTRecluEstCandidatoBusq
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTRecluEstadoPostulantes
        TabOrder = 3
        Width = 277
      end
      object snDBCheckEdit2: TsnDBCheckEdit
        Left = 178
        Top = 176
        Caption = 'Sugerir Cierre?'
        DataBinding.DataField = 'sugerir_cierre'
        DataBinding.DataSource = DSTRecluEstCandidatoBusq
        TabOrder = 4
        Width = 103
      end
      object snDBLookup3: TsnDBLookup
        Left = 496
        Top = 207
        DataBinding.DataField = 'al_cierre_est_busq'
        DataBinding.DataSource = DSTRecluEstCandidatoBusq
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTEstBusq
        TabOrder = 6
        Width = 236
      end
    end
    inherited PCuerpo: TPanel
      Top = 318
      Width = 754
      Height = 128
      BorderWidth = 10
      object dxDBGridSN1: TdxDBGridSN
        Left = 10
        Top = 10
        Width = 734
        Height = 108
        Align = alClient
        TabOrder = 0
        CriteriosPintarCelda = <>
        object dxDBGridSN1DBTableView1: TcxGridDBTableView
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
          DataController.DataSource = DSTRecluWarnEstBusqCandi
          DataController.Summary.DefaultGroupSummaryItems = <>
          DataController.Summary.FooterSummaryItems = <>
          DataController.Summary.SummaryGroups = <>
          OptionsData.Appending = True
          OptionsView.Navigator = True
          OptionsView.GroupByBox = False
          object dxDBGridSN1DBTableView1oid_est_proc_sel: TcxGridDBColumn
            Caption = 'Proceso'
            DataBinding.FieldName = 'oid_est_proc_sel'
            PropertiesClassName = 'TcxLookupComboBoxProperties'
            Properties.KeyFieldNames = 'oid'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSRecluEstadoProceso
            Width = 287
          end
          object dxDBGridSN1DBTableView1activo: TcxGridDBColumn
            Caption = 'Activo'
            DataBinding.FieldName = 'activo'
            HeaderAlignmentHorz = taCenter
            Width = 92
          end
        end
        object dxDBGridSN1Level1: TcxGridLevel
          GridView = dxDBGridSN1DBTableView1
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerRecluEstCandidatoBusq'
    OperGrabarObjeto = 'SaveRecluEstCandidatoBusq'
    CargaDataSets = <
      item
        DataSet = TRecluEstCandidatoBusq
        TableName = 'TRecluEstCandidatoBusq'
      end
      item
        DataSet = TRecluWarnEstBusqCandi
        TableName = 'TRecluWarnEstBusqCandi'
      end>
    BajaLogica = <
      item
        DataSet = TRecluEstCandidatoBusq
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TRecluEstCandidatoBusq
    DataSetDet1 = TRecluWarnEstBusqCandi
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 24
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TRecluEstCandidatoBusq: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_est_cand_busq'
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
        Name = 'color'
        DataType = ftInteger
      end
      item
        Name = 'puede_cerrar_busq'
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
    object TRecluEstCandidatoBusqoid_est_cand_busq: TIntegerField
      FieldName = 'oid_est_cand_busq'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRecluEstCandidatoBusqcodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TRecluEstCandidatoBusqdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TRecluEstCandidatoBusqactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TRecluEstCandidatoBusqcolor: TIntegerField
      FieldName = 'color'
    end
    object TRecluEstCandidatoBusqpuede_cerrar_busq: TBooleanField
      FieldName = 'puede_cerrar_busq'
    end
    object TRecluEstCandidatoBusqoid_estado_postu: TIntegerField
      FieldName = 'oid_estado_postu'
    end
    object TRecluEstCandidatoBusqsugerir_cierre: TBooleanField
      FieldName = 'sugerir_cierre'
    end
    object TRecluEstCandidatoBusqal_cierre_est_busq: TIntegerField
      FieldName = 'al_cierre_est_busq'
    end
  end
  object DSTRecluEstCandidatoBusq: TDataSource [4]
    DataSet = TRecluEstCandidatoBusq
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
        TableName = 'TRecluEstCandidatoBusq'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorEstado.Value := Sender.AsString;'
          '  ValidadorEstado.Validar();'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TRecluWarnEstBusqCandi'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_est_proc_sel'#39').AsInteger=0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el Proces' +
            'o'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TRecluEstCandidatoBusq'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          '  DataSet.FieldName('#39'puede_cerrar_busq'#39').Value := true;'
          '  DataSet.FieldName('#39'sugerir_cierre'#39').Value := false;'
          'end.')
      end
      item
        TableName = 'TRecluWarnEstBusqCandi'
        Source.Strings = (
          'begin'
          '   DataSet.FieldName('#39'activo'#39').Value := true;'
          
            '   DataSet.FieldName('#39'oid_est_cand_busq'#39').AsInteger := TRecluEst' +
            'CandidatoBusq.FieldName('#39'oid_est_cand_busq'#39').AsInteger;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  cargarColores();'
          '  TRecluEstadoProceso.loadFromHelp('#39'HelpEstadoProceso'#39'); '
          '  TRecluEstadoPostulantes.loadFromHelp('#39'HelpEstadoPostulantes'#39');'
          '  TEstBusq.loadFromHelp('#39'HelpEstBusq'#39');'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure cargarColores();'
          'begin'
          ''
          '  TColores.Close;'
          '  TColores.Open;'
          ''
          '  TColores.AppendRecord;'
          '  TColores.FieldName('#39'codigo'#39').AsInteger := 1; '
          '  TColores.FieldName('#39'descripcion'#39').AsString := '#39'Rojo'#39'; '
          '  TColores.PostRecord;'
          ''
          '  TColores.AppendRecord;'
          '  TColores.FieldName('#39'codigo'#39').AsInteger := 2; '
          '  TColores.FieldName('#39'descripcion'#39').AsString := '#39'Verde'#39'; '
          '  TColores.PostRecord;'
          ''
          '  TColores.AppendRecord;'
          '  TColores.FieldName('#39'codigo'#39').AsInteger := 3; '
          '  TColores.FieldName('#39'descripcion'#39').AsString := '#39'Amarillo'#39'; '
          '  TColores.PostRecord;'
          ''
          '  TColores.AppendRecord;'
          '  TColores.FieldName('#39'codigo'#39').AsInteger := 4; '
          '  TColores.FieldName('#39'descripcion'#39').AsString := '#39'Celeste'#39'; '
          '  TColores.PostRecord;'
          ''
          '  TColores.AppendRecord;'
          '  TColores.FieldName('#39'codigo'#39').AsInteger := 5; '
          '  TColores.FieldName('#39'descripcion'#39').AsString := '#39'Gris'#39'; '
          '  TColores.PostRecord;'
          ''
          '  TColores.AppendRecord;'
          '  TColores.FieldName('#39'codigo'#39').AsInteger := 6; '
          '  TColores.FieldName('#39'descripcion'#39').AsString := '#39'Naranja'#39'; '
          '  TColores.PostRecord;'
          ''
          '  TColores.AppendRecord;'
          '  TColores.FieldName('#39'codigo'#39').AsInteger := 7; '
          '  TColores.FieldName('#39'descripcion'#39').AsString := '#39'Marron'#39'; '
          '  TColores.PostRecord;'
          ''
          '  TColores.AppendRecord;'
          '  TColores.FieldName('#39'codigo'#39').AsInteger := 8; '
          '  TColores.FieldName('#39'descripcion'#39').AsString := '#39'Rosa'#39'; '
          '  TColores.PostRecord;'
          ''
          ''
          'end;'
          '')
      end>
    Left = 320
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
    Left = 528
    Top = 83
  end
  object HelpEstBusqCandidato: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluEstCandidatoBusq'
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
    Titulo = 'Estados Candidato B'#250'squeda'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 202
    Top = 68
  end
  object ValidadorEstado: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluEstCandidatoBusq'
    WhenRaiseException = teFound
    MensajeException = 'Codigo de Estado Existente'
    NroQuery = 0
    Cache = False
    Left = 240
    Top = 67
  end
  object TColores: TsnTable
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
    Top = 323
    object TColorescodigo: TIntegerField
      FieldName = 'codigo'
    end
    object TColoresdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSColores: TDataSource
    DataSet = TColores
    Left = 224
    Top = 323
  end
  object TRecluWarnEstBusqCandi: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_warn_est_cand'
        DataType = ftInteger
      end
      item
        Name = 'oid_est_cand_busq'
        DataType = ftInteger
      end
      item
        Name = 'oid_est_proc_sel'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_est_cand_busq'
    IndexDefs = <
      item
        Name = 'TRecluWarnEstBusqCandiIndex1'
        Fields = 'oid_est_cand_busq'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_est_cand_busq'
    MasterSource = DSTRecluEstCandidatoBusq
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 600
    Top = 140
    object TRecluWarnEstBusqCandioid_warn_est_cand: TIntegerField
      FieldName = 'oid_warn_est_cand'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRecluWarnEstBusqCandioid_est_cand_busq: TIntegerField
      FieldName = 'oid_est_cand_busq'
    end
    object TRecluWarnEstBusqCandioid_est_proc_sel: TIntegerField
      FieldName = 'oid_est_proc_sel'
    end
    object TRecluWarnEstBusqCandiactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTRecluWarnEstBusqCandi: TDataSource
    DataSet = TRecluWarnEstBusqCandi
    Left = 640
    Top = 140
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
    Top = 367
  end
  object TRecluEstadoProceso: TsnTable
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
    Top = 367
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
  object DSRecluEstadoProceso: TDataSource
    DataSet = TRecluEstadoProceso
    Left = 242
    Top = 367
  end
  object HelpEstadoPostulantes: TsnHelp
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
    Top = 409
  end
  object TRecluEstadoPostulantes: TsnTable
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
    Top = 409
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
  object DSTRecluEstadoPostulantes: TDataSource
    DataSet = TRecluEstadoPostulantes
    Left = 242
    Top = 409
  end
  object HelpEstBusq: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluEstCandidatoBusq'
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
    Top = 439
  end
  object TEstBusq: TsnTable
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
    Top = 439
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
  object DSTEstBusq: TDataSource
    DataSet = TEstBusq
    Left = 242
    Top = 439
  end
end
