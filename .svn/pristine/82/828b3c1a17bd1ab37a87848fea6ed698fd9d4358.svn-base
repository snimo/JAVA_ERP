inherited FSubGruCategAccesos: TFSubGruCategAccesos
  Left = 133
  Top = 206
  Width = 730
  Height = 396
  Caption = 'SubGrupos de Categor'#237'as de Accesos'
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
        DataSource = DSTSubGrupoCategAcceso
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTSubGrupoCategAcceso
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpSubGrupoCategAccesos
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpSubGrupoCategAccesos
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpSubGrupoCategAccesos
      end
      inherited Panel2: TPanel
        Left = 673
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTSubGrupoCategAcceso
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
    end
    inherited PCuerpo: TPanel
      Width = 714
      Height = 262
      object Label1: TLabel
        Left = 40
        Top = 8
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
        Top = 88
        Width = 29
        Height = 13
        Caption = 'Orden'
      end
      object Label4: TLabel
        Left = 39
        Top = 128
        Width = 79
        Height = 13
        Caption = 'Grupo Categor'#237'a'
      end
      object DBECodigo: TsnDBEdit
        Left = 156
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTSubGrupoCategAcceso
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
        DataBinding.DataSource = DSTSubGrupoCategAcceso
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object snDBEdit2: TsnDBEdit
        Left = 156
        Top = 84
        DataBinding.DataField = 'orden'
        DataBinding.DataSource = DSTSubGrupoCategAcceso
        TabOrder = 2
        Width = 121
      end
      object DBCodCliente: TsrnDBButtonEdit
        Left = 157
        Top = 124
        Hint = 'F4 Nuevo Cliente'
        DataBinding.DataField = 'cod_grupo_categ'
        DataBinding.DataSource = DSTSubGrupoCategAcceso
        Properties.Buttons = <
          item
            Default = True
            Kind = bkEllipsis
          end>
        Properties.CharCase = ecUpperCase
        Properties.ClickKey = 112
        TabOrder = 3
        Help = HelpGrupoCategorias
        Width = 121
      end
      object snDBEdit3: TsnDBEdit
        Left = 275
        Top = 124
        TabStop = False
        DataBinding.DataField = 'desc_grupo_categ'
        DataBinding.DataSource = DSTSubGrupoCategAcceso
        Properties.ReadOnly = True
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 4
        ReadOnlyAlways = True
        Width = 310
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerSubGrupoCategAcceso'
    OperGrabarObjeto = 'SaveSubGrupoCategAcceso'
    CargaDataSets = <
      item
        DataSet = TSubGrupoCategAcceso
        TableName = 'TSubGrupoCategAcceso'
      end>
    BajaLogica = <
      item
        DataSet = TSubGrupoCategAcceso
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TSubGrupoCategAcceso
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TSubGrupoCategAcceso: TsnTable [3]
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
    Left = 648
    Top = 59
    object TSubGrupoCategAccesooid_sub_grupo: TIntegerField
      FieldName = 'oid_sub_grupo'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TSubGrupoCategAccesocodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TSubGrupoCategAccesodescripcion: TStringField
      DisplayWidth = 50
      FieldName = 'descripcion'
      Size = 50
    end
    object TSubGrupoCategAccesoactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TSubGrupoCategAccesoorden: TIntegerField
      FieldName = 'orden'
    end
    object TSubGrupoCategAccesooid_grupo_categ: TIntegerField
      FieldName = 'oid_grupo_categ'
    end
    object TSubGrupoCategAccesocod_grupo_categ: TStringField
      FieldName = 'cod_grupo_categ'
    end
    object TSubGrupoCategAccesodesc_grupo_categ: TStringField
      FieldName = 'desc_grupo_categ'
      Size = 100
    end
  end
  object DSTSubGrupoCategAcceso: TDataSource [4]
    DataSet = TSubGrupoCategAcceso
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
        TableName = 'TSubGrupoCategAcceso'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorSubGrupoCategorias.Value := Sender.AsString;'
          '  ValidadorSubGrupoCategorias.Validar;'
          'end.')
      end
      item
        TableName = 'TSubGrupoCategAcceso'
        FieldName = 'cod_grupo_categ'
        Source.Strings = (
          'begin'
          '  ValidadorGrupoCategoria.Value := Sender.AsString;'
          '  ValidadorGrupoCategoria.Validar();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object HelpSubGrupoCategAccesos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.SubGrupoCategAcceso'
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
    Titulo = 'SubGrupos de Categor'#237'as de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorSubGrupoCategorias: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.SubGrupoCategAcceso'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de SubGrupo de Categor'#237'as duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
  object HelpGrupoCategorias: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoCategAcceso'
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
        AsignarACampo = TSubGrupoCategAccesocod_grupo_categ
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
    Titulo = 'Grupos de Categor'#237'as'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 458
    Top = 159
  end
  object ValidadorGrupoCategoria: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoCategAcceso'
    MensajeException = 'C'#243'digo de Grupo de Categor'#237'a Inexistente'
    CampoOID = TSubGrupoCategAccesooid_grupo_categ
    CampoDescripcion = TSubGrupoCategAccesodesc_grupo_categ
    NroQuery = 0
    Cache = True
    Left = 494
    Top = 159
  end
end
