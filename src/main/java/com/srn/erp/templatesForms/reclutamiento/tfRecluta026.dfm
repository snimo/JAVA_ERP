inherited FRecluTipoFormulario: TFRecluTipoFormulario
  Left = 195
  Width = 770
  Caption = 'Tipo de Formularios'
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
        DataSource = DSTRecluTipoFormuProceso
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRecluTipoFormuProceso
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpTipoFormulario
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpTipoFormulario
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpTipoFormulario
      end
      inherited Panel2: TPanel
        Left = 713
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTRecluTipoFormuProceso
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
      Height = 109
      object Label1: TLabel
        Left = 40
        Top = 32
        Width = 33
        Height = 13
        Caption = 'Codigo'
      end
      object Label2: TLabel
        Left = 40
        Top = 72
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object DBECodigo: TsnDBEdit
        Left = 124
        Top = 28
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTRecluTipoFormuProceso
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object DBEDescripcion: TsnDBEdit
        Left = 124
        Top = 68
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTRecluTipoFormuProceso
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 273
      end
    end
    inherited PCuerpo: TPanel
      Top = 161
      Width = 754
      Height = 285
      BorderWidth = 20
      object dxDBGridSN1: TdxDBGridSN
        Left = 20
        Top = 20
        Width = 714
        Height = 245
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
          DataController.DataSource = DSTRecluProcTipoFormu
          DataController.Summary.DefaultGroupSummaryItems = <>
          DataController.Summary.FooterSummaryItems = <>
          DataController.Summary.SummaryGroups = <>
          OptionsData.Appending = True
          OptionsData.Deleting = False
          OptionsView.Navigator = True
          OptionsView.GroupByBox = False
          object dxDBGridSN1DBTableView1oid_proceso: TcxGridDBColumn
            Caption = 'Procesos Habilitados para el Formulario'
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
            Width = 324
          end
          object dxDBGridSN1DBTableView1activo: TcxGridDBColumn
            Caption = 'Activo'
            DataBinding.FieldName = 'activo'
            PropertiesClassName = 'TcxCheckBoxProperties'
            HeaderAlignmentHorz = taCenter
            Width = 65
          end
        end
        object dxDBGridSN1Level1: TcxGridLevel
          GridView = dxDBGridSN1DBTableView1
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerRecluTipoFormuProceso'
    OperGrabarObjeto = 'SaveRecluTipoFormuProceso'
    CargaDataSets = <
      item
        DataSet = TRecluTipoFormuProceso
        TableName = 'TRecluTipoFormuProceso'
      end
      item
        DataSet = TRecluProcTipoFormu
        TableName = 'TRecluProcTipoFormu'
      end>
    BajaLogica = <
      item
        DataSet = TRecluTipoFormuProceso
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TRecluTipoFormuProceso
    DataSetDet1 = TRecluProcTipoFormu
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 24
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TRecluTipoFormuProceso: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_tipo_formu'
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
    Left = 640
    Top = 59
    object TRecluTipoFormuProcesooid_tipo_formu: TIntegerField
      FieldName = 'oid_tipo_formu'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRecluTipoFormuProcesocodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TRecluTipoFormuProcesodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TRecluTipoFormuProcesoactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTRecluTipoFormuProceso: TDataSource [4]
    DataSet = TRecluTipoFormuProceso
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
        TableName = 'TRecluTipoFormuProceso'
        FieldName = 'codigo'
        Source.Strings = (
          'program validar;'
          'begin'
          '  ValidadorTipoFormulario.Value := Sender.AsString;'
          '  ValidadorTipoFormulario.Validar();'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TRecluProcTipoFormu'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_proceso'#39').AsInteger=0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el Proces' +
            'o'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TRecluTipoFormuProceso'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end
      item
        TableName = 'TRecluProcTipoFormu'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_tipo_formu'#39').AsInteger := TRecluTipoFor' +
            'muProceso.FieldName('#39'oid_tipo_formu'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TRecluProceso.loadFromHelp('#39'HelpProceso'#39');'
          'end.')
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
    Left = 520
    Top = 67
  end
  object HelpTipoFormulario: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluTipoFormuProceso'
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
    Titulo = 'Tipos de Formularios'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 202
    Top = 68
  end
  object ValidadorTipoFormulario: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluTipoFormuProceso'
    WhenRaiseException = teFound
    MensajeException = 'Codigo de Tipo de Formulario Existente'
    NroQuery = 0
    Cache = False
    Left = 240
    Top = 67
  end
  object TRecluProcTipoFormu: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_proc_tipo_formu'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_formu'
        DataType = ftInteger
      end
      item
        Name = 'oid_proceso'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_tipo_formu'
    IndexDefs = <
      item
        Name = 'TRecluProcTipoFormuIndex1'
        Fields = 'oid_tipo_formu'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_tipo_formu'
    MasterSource = DSTRecluTipoFormuProceso
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 640
    Top = 147
    object TRecluProcTipoFormuoid_proc_tipo_formu: TIntegerField
      FieldName = 'oid_proc_tipo_formu'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRecluProcTipoFormuoid_tipo_formu: TIntegerField
      FieldName = 'oid_tipo_formu'
    end
    object TRecluProcTipoFormuoid_proceso: TIntegerField
      FieldName = 'oid_proceso'
    end
    object TRecluProcTipoFormuactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTRecluProcTipoFormu: TDataSource
    DataSet = TRecluProcTipoFormu
    Left = 672
    Top = 148
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
    Top = 351
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
    Top = 351
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
    Top = 351
  end
end
