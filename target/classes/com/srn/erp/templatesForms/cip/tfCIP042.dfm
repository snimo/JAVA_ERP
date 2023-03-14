inherited FPlanoCIP: TFPlanoCIP
  Left = 255
  Top = 66
  Width = 730
  Height = 656
  Caption = 'Plano'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 714
    Height = 618
    inherited PPie: TPanel
      Top = 597
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
        DataSource = DSTPlanoCIP
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTPlanoCIP
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpPlanos
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpPlanos
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpPlanos
      end
      inherited Panel2: TPanel
        Left = 673
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTPlanoCIP
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
      Height = 181
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
      object Label5: TLabel
        Left = 40
        Top = 144
        Width = 79
        Height = 13
        Caption = 'Agrupador Plano'
      end
      object DBECodigo: TsnDBEdit
        Left = 156
        Top = 20
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTPlanoCIP
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBEdit1: TsnDBEdit
        Left = 156
        Top = 60
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTPlanoCIP
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object snDBEdit2: TsnDBEdit
        Left = 157
        Top = 100
        DataBinding.DataField = 'orden'
        DataBinding.DataSource = DSTPlanoCIP
        TabOrder = 2
        Width = 121
      end
      object srnDBButtonEdit1: TsrnDBButtonEdit
        Left = 155
        Top = 140
        DataBinding.DataField = 'cod_agrup_plano'
        DataBinding.DataSource = DSTPlanoCIP
        Properties.Buttons = <
          item
            Default = True
            Kind = bkEllipsis
          end>
        TabOrder = 3
        Help = HelpGrupo
        Width = 128
      end
      object snDBEdit4: TsnDBEdit
        Left = 280
        Top = 140
        TabStop = False
        DataBinding.DataField = 'desc_agrup_plano'
        DataBinding.DataSource = DSTPlanoCIP
        TabOrder = 4
        Width = 305
      end
    end
    inherited PCuerpo: TPanel
      Top = 233
      Width = 714
      Height = 364
      object Panel1: TPanel
        Left = 0
        Top = 0
        Width = 714
        Height = 25
        Align = alTop
        BevelOuter = bvNone
        Color = clWindow
        TabOrder = 0
        object Label4: TLabel
          Left = 40
          Top = 8
          Width = 148
          Height = 13
          Caption = 'Puertas que integran el PLANO'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clBlue
          Font.Height = -11
          Font.Name = 'MS Sans Serif'
          Font.Style = [fsUnderline]
          ParentFont = False
        end
      end
      object Panel3: TPanel
        Left = 0
        Top = 25
        Width = 714
        Height = 339
        Align = alClient
        BorderWidth = 10
        Color = clWindow
        TabOrder = 1
        object dxDBGridComponentesAInc: TdxDBGridSN
          Left = 11
          Top = 11
          Width = 692
          Height = 317
          Align = alClient
          TabOrder = 0
          LookAndFeel.Kind = lfFlat
          AllowInsert = False
          CriteriosPintarCelda = <>
          object dxDBGridComponentesAIncDBTableView1: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSPuertaPlano
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsBehavior.FocusCellOnTab = True
            OptionsBehavior.FocusFirstCellOnNewRecord = True
            OptionsBehavior.GoToNextCellOnEnter = True
            OptionsBehavior.FocusCellOnCycle = True
            OptionsCustomize.ColumnFiltering = False
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsData.Inserting = False
            OptionsSelection.InvertSelect = False
            OptionsView.GroupByBox = False
            object dxDBGridComponentesAIncDBTableView1activo: TcxGridDBColumn
              Caption = 'Habilitado'
              DataBinding.FieldName = 'activo'
              HeaderAlignmentHorz = taCenter
              Width = 73
            end
            object dxDBGridComponentesAIncDBTableView1orden: TcxGridDBColumn
              Caption = 'Orden'
              DataBinding.FieldName = 'orden'
              HeaderAlignmentHorz = taCenter
              Width = 51
            end
            object dxDBGridComponentesAIncDBTableView1cod_puerta: TcxGridDBColumn
              Caption = 'Puerta'
              DataBinding.FieldName = 'cod_puerta'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Options.Focusing = False
              Width = 69
            end
            object dxDBGridComponentesAIncDBTableView1desc_puerta: TcxGridDBColumn
              Caption = 'Descripci'#243'n Puerta'
              DataBinding.FieldName = 'desc_puerta'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Options.Focusing = False
              Width = 241
            end
            object dxDBGridComponentesAIncDBTableView1hab_entrada: TcxGridDBColumn
              Caption = 'Entrada Disp.'
              DataBinding.FieldName = 'hab_entrada'
              PropertiesClassName = 'TcxCheckBoxProperties'
              HeaderAlignmentHorz = taCenter
              Width = 102
            end
            object dxDBGridComponentesAIncDBTableView1hab_salida: TcxGridDBColumn
              Caption = 'Salida Disp.'
              DataBinding.FieldName = 'hab_salida'
              PropertiesClassName = 'TcxCheckBoxProperties'
              HeaderAlignmentHorz = taCenter
              Width = 108
            end
          end
          object dxDBGridComponentesAIncLevel1: TcxGridLevel
            GridView = dxDBGridComponentesAIncDBTableView1
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerPlanoCIP'
    OperGrabarObjeto = 'SavePlanoCIP'
    CargaDataSets = <
      item
        DataSet = TPlanoCIP
        TableName = 'TPlanoCIP'
      end
      item
        DataSet = TPuertaPlano
        TableName = 'TPuertaPlano'
      end>
    BajaLogica = <
      item
        DataSet = TPlanoCIP
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TPlanoCIP
    DataSetDet1 = TPuertaPlano
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TPlanoCIP: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_plano'
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
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'oid_agrup_plano'
        DataType = ftInteger
      end
      item
        Name = 'cod_agrup_plano'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_agrup_plano'
        DataType = ftString
        Size = 100
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
    Left = 624
    Top = 59
    object TPlanoCIPoid_plano: TIntegerField
      FieldName = 'oid_plano'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPlanoCIPcodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TPlanoCIPdescripcion: TStringField
      DisplayWidth = 50
      FieldName = 'descripcion'
      Size = 50
    end
    object TPlanoCIPactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TPlanoCIPorden: TIntegerField
      FieldName = 'orden'
    end
    object TPlanoCIPoid_agrup_plano: TIntegerField
      FieldName = 'oid_agrup_plano'
    end
    object TPlanoCIPcod_agrup_plano: TStringField
      FieldName = 'cod_agrup_plano'
      Size = 50
    end
    object TPlanoCIPdesc_agrup_plano: TStringField
      FieldName = 'desc_agrup_plano'
      Size = 100
    end
  end
  object DSTPlanoCIP: TDataSource [4]
    DataSet = TPlanoCIP
    Left = 664
    Top = 59
  end
  inherited TOidObjSave: TsnTable
    Left = 608
  end
  inherited TOpcHabPrograma: TsnTable
    Top = 16
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 280
    Top = 0
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 392
    Top = 0
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TPlanoCIP'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorPlano.Value := Sender.AsString;'
          '  ValidadorPlano.Validar;'
          'end.')
      end
      item
        TableName = 'TPlanoCIP'
        FieldName = 'cod_agrup_plano'
        Source.Strings = (
          'begin'
          '  ValidadorAgrupadorPlano.Value := Sender.AsString;'
          '  ValidadorAgrupadorPlano.Validar();'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TPuertaPlano'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_plano'#39').AsInteger := '
          '    TPlanoCIP.FieldName('#39'oid_plano'#39').AsInteger;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TPuertas.loadFromHelp('#39'HelpPuertas'#39');'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure InicializarAlta();'
          'begin'
          ''
          'TPuertaPlano.Close;'
          'TPuertaPlano.Open;'
          ''
          'TPuertas.First;'
          'while (not TPuertas.EOF) do'
          '  begin'
          ''
          '  TPuertaPlano.AppendRecord;'
          '  TPuertaPlano.FieldName('#39'Orden'#39').AsInteger := 0;'
          
            '  TPuertaPlano.FieldName('#39'oid_plano'#39').AsInteger := TPlanoCIP.Fie' +
            'ldName('#39'oid_plano'#39').AsInteger;'
          
            '  TPuertaPlano.FieldName('#39'oid_puerta'#39').AsInteger := TPuertas.Fie' +
            'ldName('#39'oid_puerta'#39').AsInteger;'
          
            '  TPuertaPlano.FieldName('#39'cod_puerta'#39').AsString := TPuertas.Fiel' +
            'dName('#39'codigo'#39').AsString;'
          
            '  TPuertaPlano.FieldName('#39'desc_puerta'#39').AsString := TPuertas.Fie' +
            'ldName('#39'descripcion'#39').AsString;'
          '  TPuertaPlano.FieldName('#39'hab_entrada'#39').AsBoolean := false;'
          '  TPuertaPlano.FieldName('#39'hab_salida'#39').AsBoolean := false;'
          '  TPuertaPlano.FieldName('#39'activo'#39').AsBoolean := true;  '
          '  TPuertaPlano.PostRecord;'
          ''
          '  TPuertas.next;'
          '  end;'
          ''
          'end;')
      end>
    OnAfterNuevo = <
      item
        Source.Strings = (
          'begin'
          '  InicializarAlta();'
          'end.')
      end>
    Left = 360
    Top = 3
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Top = 224
  end
  inherited PopUp: TsnPopUp
    Left = 321
    Top = 0
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 504
    Top = 91
  end
  object HelpPlanos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.PlanoCIP'
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
    Titulo = 'Planos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorPlano: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.PlanoCIP'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Plano duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
  object ValidadorAgrupadorPlano: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.AgrupadorPlano'
    MensajeException = 'C'#243'digo de Agrupador inexistente'
    CampoOID = TPlanoCIPoid_agrup_plano
    CampoDescripcion = TPlanoCIPdesc_agrup_plano
    NroQuery = 0
    Cache = False
    Left = 168
    Top = 219
  end
  object HelpGrupo: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.AgrupadorPlano'
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
        AsignarACampo = TPlanoCIPcod_agrup_plano
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
    Titulo = 'Agrupadores Planes'
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 202
    Top = 220
  end
  object TPuertaPlano: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_puerta_plano'
        DataType = ftInteger
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'oid_plano'
        DataType = ftInteger
      end
      item
        Name = 'oid_puerta'
        DataType = ftInteger
      end
      item
        Name = 'cod_puerta'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_puerta'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'hab_entrada'
        DataType = ftBoolean
      end
      item
        Name = 'hab_salida'
        DataType = ftBoolean
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_plano'
    IndexDefs = <
      item
        Name = 'TPuertaPlanoIndex1'
        Fields = 'oid_plano'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_plano'
    MasterSource = DSTPlanoCIP
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 624
    Top = 100
    object TPuertaPlanooid_puerta_plano: TIntegerField
      FieldName = 'oid_puerta_plano'
    end
    object TPuertaPlanoorden: TIntegerField
      FieldName = 'orden'
    end
    object TPuertaPlanooid_plano: TIntegerField
      FieldName = 'oid_plano'
    end
    object TPuertaPlanooid_puerta: TIntegerField
      FieldName = 'oid_puerta'
    end
    object TPuertaPlanocod_puerta: TStringField
      FieldName = 'cod_puerta'
      Size = 50
    end
    object TPuertaPlanodesc_puerta: TStringField
      FieldName = 'desc_puerta'
      Size = 100
    end
    object TPuertaPlanohab_entrada: TBooleanField
      FieldName = 'hab_entrada'
    end
    object TPuertaPlanohab_salida: TBooleanField
      FieldName = 'hab_salida'
    end
    object TPuertaPlanoactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSPuertaPlano: TDataSource
    DataSet = TPuertaPlano
    Left = 664
    Top = 100
  end
  object HelpPuertas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.Puerta'
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
    Titulo = 'Puertas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 463
    Top = 342
  end
  object TPuertas: TsnTable
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
    Left = 495
    Top = 342
    object TPuertasoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPuertascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TPuertasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
end
