inherited FRecluOperacion: TFRecluOperacion
  Left = 181
  Top = 69
  Width = 770
  Caption = 'Operaci'#243'n'
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
        DataSource = DSTRecluOperacion
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRecluOperacion
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpOperacion
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpOperacion
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpOperacion
      end
      inherited Panel2: TPanel
        Left = 713
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTRecluOperacion
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
      Height = 83
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
      object DBECodigo: TsnDBEdit
        Left = 124
        Top = 20
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTRecluOperacion
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object DBEDescripcion: TsnDBEdit
        Left = 124
        Top = 60
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTRecluOperacion
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 273
      end
    end
    inherited PCuerpo: TPanel
      Top = 135
      Width = 754
      Height = 311
      BorderWidth = 20
      object dxDBGridSN1: TdxDBGridSN
        Left = 20
        Top = 20
        Width = 714
        Height = 271
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
          DataController.DataSource = DSTRecluPermisosOper
          DataController.Summary.DefaultGroupSummaryItems = <>
          DataController.Summary.FooterSummaryItems = <>
          DataController.Summary.SummaryGroups = <>
          OptionsData.Appending = True
          OptionsData.Deleting = False
          OptionsSelection.InvertSelect = False
          OptionsView.Navigator = True
          OptionsView.GroupByBox = False
          object dxDBGridSN1DBTableView1oid_perf_func: TcxGridDBColumn
            Caption = 'Perfil Funcional'
            DataBinding.FieldName = 'oid_perf_func'
            PropertiesClassName = 'TcxLookupComboBoxProperties'
            Properties.KeyFieldNames = 'oid'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSPerfilFuncional
            HeaderAlignmentHorz = taCenter
            Width = 275
          end
          object dxDBGridSN1DBTableView1tipo_oper: TcxGridDBColumn
            Caption = 'Permiso'
            DataBinding.FieldName = 'tipo_oper'
            PropertiesClassName = 'TcxLookupComboBoxProperties'
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSPermisosOperaciones
            HeaderAlignmentHorz = taCenter
            Width = 287
          end
          object dxDBGridSN1DBTableView1activo: TcxGridDBColumn
            Caption = 'Activo'
            DataBinding.FieldName = 'activo'
            HeaderAlignmentHorz = taCenter
            Width = 55
          end
        end
        object dxDBGridSN1Level1: TcxGridLevel
          GridView = dxDBGridSN1DBTableView1
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerRecluOperacion'
    OperGrabarObjeto = 'SaveRecluOperacion'
    CargaDataSets = <
      item
        DataSet = TRecluOperacion
        TableName = 'TRecluOperacion'
      end
      item
        DataSet = TRecluPermisosOper
        TableName = 'TRecluPermisosOper'
      end
      item
        DataSet = TPermisosOperaciones
        TableName = 'TPermisosOperaciones'
      end
      item
        DataSet = TPermisosOperaciones
        TableName = 'TPermisosOperaciones'
      end>
    BajaLogica = <
      item
        DataSet = TRecluOperacion
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TRecluOperacion
    DataSetDet1 = TRecluPermisosOper
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 24
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TRecluOperacion: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_operacion'
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
    object TRecluOperacionoid_operacion: TIntegerField
      FieldName = 'oid_operacion'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRecluOperacioncodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TRecluOperaciondescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TRecluOperacionactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTRecluOperacion: TDataSource [4]
    DataSet = TRecluOperacion
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
        TableName = 'TRecluOperacion'
        FieldName = 'codigo'
        Source.Strings = (
          'program validar;'
          'begin'
          '  ValidadorOperacion.Value := Sender.AsString;'
          '  ValidadorOperacion.Validar();'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TRecluPermisosOper'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'tipo_oper'#39').AsString = '#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Permiso' +
            #39');'
          '  if (DataSet.FieldName('#39'oid_perf_func'#39').AsString = '#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Perfil ' +
            'Funcional'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TRecluOperacion'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end
      item
        TableName = 'TRecluPermisosOper'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          '  DataSet.FieldName('#39'oid_operacion'#39').AsInteger :='
          '    TRecluOperacion.FieldName('#39'oid_operacion'#39').AsInteger;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '   TPerfilFuncional.loadFromHelp('#39'HelpPerfilFuncional'#39');'
          ''
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'TraerRecluPermisosOper'#39');'
          '   operacion.execute();'
          ''
          'end.')
      end>
    Left = 320
  end
  inherited SaveArchivo: TSaveDialog
    Top = 112
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
  object HelpOperacion: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluOperacion'
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
    Titulo = 'Operaci'#243'n'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 202
    Top = 68
  end
  object ValidadorOperacion: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluOperacion'
    WhenRaiseException = teFound
    MensajeException = 'Codigo de Operaci'#243'n Existente'
    NroQuery = 0
    Cache = False
    Left = 240
    Top = 67
  end
  object TRecluPermisosOper: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_oper_hab'
        DataType = ftInteger
      end
      item
        Name = 'oid_operacion'
        DataType = ftInteger
      end
      item
        Name = 'oid_perf_func'
        DataType = ftInteger
      end
      item
        Name = 'tipo_oper'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_operacion'
    IndexDefs = <
      item
        Name = 'TRecluPermisosOperIndex1'
        Fields = 'oid_operacion'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_operacion'
    MasterSource = DSTRecluOperacion
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 640
    Top = 167
    object TRecluPermisosOperoid_oper_hab: TIntegerField
      FieldName = 'oid_oper_hab'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRecluPermisosOperoid_operacion: TIntegerField
      FieldName = 'oid_operacion'
    end
    object TRecluPermisosOperoid_perf_func: TIntegerField
      FieldName = 'oid_perf_func'
    end
    object TRecluPermisosOpertipo_oper: TStringField
      FieldName = 'tipo_oper'
    end
    object TRecluPermisosOperactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTRecluPermisosOper: TDataSource
    DataSet = TRecluPermisosOper
    Left = 672
    Top = 167
  end
  object HelpPerfilFuncional: TsnHelp
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
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 174
    Top = 351
  end
  object TPerfilFuncional: TsnTable
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
  object DSPerfilFuncional: TDataSource
    DataSet = TPerfilFuncional
    Left = 242
    Top = 351
  end
  object TPermisosOperaciones: TsnTable
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
    Left = 400
    Top = 231
    object TPermisosOperacionescodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TPermisosOperacionesdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSPermisosOperaciones: TDataSource
    DataSet = TPermisosOperaciones
    Left = 440
    Top = 231
  end
end
