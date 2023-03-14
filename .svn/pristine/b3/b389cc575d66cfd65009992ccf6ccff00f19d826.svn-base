inherited FMotivoVisita: TFMotivoVisita
  Left = 107
  Top = 155
  Width = 730
  Height = 396
  Caption = 'Motivo Visita'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 714
    Height = 358
    inherited PPie: TPanel
      Top = 337
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
        DataSource = DSTMotivoVisita
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTMotivoVisita
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpMotivos
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpMotivos
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpMotivos
      end
      inherited Panel2: TPanel
        Left = 673
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTMotivoVisita
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
      object snLabel1: TsnLabel
        Left = 16
        Top = 80
        Width = 232
        Height = 13
        Caption = 'Documentaci'#243'n requerida para este tipo de Visita'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlue
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentFont = False
      end
      object DBECodigo: TsnDBEdit
        Left = 156
        Top = 12
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTMotivoVisita
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
        DataBinding.DataSource = DSTMotivoVisita
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 2
        Width = 429
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 307
        Top = 12
        Caption = 'Habilitar en Asignaci'#243'n de Permiso a Visita?'
        DataBinding.DataField = 'hab_en_ing_perm'
        DataBinding.DataSource = DSTMotivoVisita
        TabOrder = 1
        Width = 289
      end
    end
    inherited PCuerpo: TPanel
      Top = 152
      Width = 714
      Height = 185
      object Panel1: TPanel
        Left = 0
        Top = 0
        Width = 714
        Height = 185
        Align = alClient
        BorderWidth = 5
        Color = clWindow
        TabOrder = 0
        object dxDBGridSN1: TdxDBGridSN
          Left = 6
          Top = 6
          Width = 702
          Height = 173
          Align = alClient
          TabOrder = 0
          LookAndFeel.Kind = lfFlat
          CriteriosPintarCelda = <>
          object dxDBGridSN1DBTableView1: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSMotivoVisitaDoc
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsBehavior.AlwaysShowEditor = True
            OptionsCustomize.ColumnFiltering = False
            OptionsData.Appending = True
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsData.Inserting = False
            OptionsSelection.InvertSelect = False
            OptionsView.GroupByBox = False
            object dxDBGridSN1DBTableView1activo: TcxGridDBColumn
              Caption = 'Sel.'
              DataBinding.FieldName = 'activo'
              HeaderAlignmentHorz = taCenter
              Width = 50
            end
            object dxDBGridSN1DBTableView1dias_aviso_venc: TcxGridDBColumn
              Caption = 'D'#237'as Aviso Venc.'
              DataBinding.FieldName = 'dias_aviso_venc'
              HeaderAlignmentHorz = taCenter
              Width = 120
            end
            object dxDBGridSN1DBTableView1desc_motivo: TcxGridDBColumn
              Caption = 'Motivo'
              DataBinding.FieldName = 'desc_motivo'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Options.Focusing = False
              Width = 239
            end
          end
          object dxDBGridSN1Level1: TcxGridLevel
            GridView = dxDBGridSN1DBTableView1
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerMotivoVisita'
    OperGrabarObjeto = 'SaveMotivoVisita'
    CargaDataSets = <
      item
        DataSet = TMotivoVisita
        TableName = 'TMotivoVisita'
      end
      item
        DataSet = TMotivoVisitaDoc
        TableName = 'TMotivoVisitaDoc'
      end
      item
        DataSet = TMotivoVisitaDoc
        TableName = 'TMotivoVisitaDoc'
      end>
    BajaLogica = <
      item
        DataSet = TMotivoVisita
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TMotivoVisita
    DataSetDet1 = TMotivoVisitaDoc
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TMotivoVisita: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_mot_visita'
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
    object TMotivoVisitaoid_mot_visita: TIntegerField
      FieldName = 'oid_mot_visita'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TMotivoVisitacodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TMotivoVisitadescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TMotivoVisitaactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TMotivoVisitahab_en_ing_perm: TBooleanField
      FieldName = 'hab_en_ing_perm'
    end
  end
  object DSTMotivoVisita: TDataSource [4]
    DataSet = TMotivoVisita
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
    Left = 360
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
    Left = 472
    Top = 0
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TMotivoVisita'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorMotivo.Value := Sender.AsString;'
          '  ValidadorMotivo.Validar;'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TMotivoVisitaDoc'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_mot_visita'#39').AsInteger :='
          '            TMotivoVisita.FieldName('#39'oid_mot_visita'#39').AsInteger;'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure nuevoDocumen();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveNuevoMotivo'#39');'
          
            '  operacion.AddAtribute('#39'oid_motivo'#39',IntToStr(TMotivoVisita.Fiel' +
            'dName('#39'oid_mot_visita'#39').AsInteger));'
          '  operacion.execute();'
          'end;')
      end>
    OnAfterNuevo = <
      item
        Source.Strings = (
          'begin'
          '  nuevoDocumen();'
          'end.')
      end>
    Left = 440
    Top = 3
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 401
    Top = 0
  end
  inherited ImageListGruposPopUp: TImageList
    Left = 312
    Top = 67
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 552
    Top = 59
  end
  object HelpMotivos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.MotivoVisita'
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
    Titulo = 'Motivos Visitas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorMotivo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.MotivoVisita'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Motivo duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
  object TMotivoVisitaDoc: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_mot_vis_doc'
        DataType = ftInteger
      end
      item
        Name = 'oid_mot_visita'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_docu'
        DataType = ftInteger
      end
      item
        Name = 'dias_aviso_venc'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'desc_motivo'
        DataType = ftString
        Size = 100
      end>
    IndexFieldNames = 'oid_mot_visita'
    IndexDefs = <
      item
        Name = 'TMotivoVisitaDocIndex1'
        Fields = 'oid_mot_visita'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_mot_visita'
    MasterSource = DSTMotivoVisita
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 632
    Top = 100
    object TMotivoVisitaDocoid_mot_vis_doc: TIntegerField
      FieldName = 'oid_mot_vis_doc'
    end
    object TMotivoVisitaDocoid_mot_visita: TIntegerField
      FieldName = 'oid_mot_visita'
    end
    object TMotivoVisitaDocoid_tipo_docu: TIntegerField
      FieldName = 'oid_tipo_docu'
    end
    object TMotivoVisitaDocdias_aviso_venc: TIntegerField
      FieldName = 'dias_aviso_venc'
    end
    object TMotivoVisitaDocactivo: TBooleanField
      FieldName = 'activo'
    end
    object TMotivoVisitaDocdesc_motivo: TStringField
      FieldName = 'desc_motivo'
      Size = 100
    end
  end
  object DSMotivoVisitaDoc: TDataSource
    DataSet = TMotivoVisitaDoc
    Left = 664
    Top = 100
  end
end
