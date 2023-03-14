inherited FSacarFotoVisita: TFSacarFotoVisita
  Left = 97
  Top = 154
  Width = 644
  Height = 541
  BorderIcons = [biSystemMenu]
  Caption = 'Sacar una Foto'
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 628
    Height = 41
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object BotonSacarFoto: TsnButton
      Left = 24
      Top = 8
      Width = 105
      Height = 25
      Caption = 'Sacar Foto'
      TabOrder = 0
      LookAndFeel.Kind = lfOffice11
    end
    object BotonSalirSinSacarFoto: TsnButton
      Left = 160
      Top = 8
      Width = 105
      Height = 25
      Caption = 'Salir sin sacar Foto'
      TabOrder = 1
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 41
    Width = 628
    Height = 462
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
    object CamaraVideo: TCamaraVideo
      Left = 0
      Top = 0
      Width = 628
      Height = 462
      Align = alClient
      Caption = 'C'#225'mara de Video'
      Color = clWindow
      TabOrder = 0
      CampoFoto = TInputfoto
    end
  end
  inherited TOidObjSave: TsnTable
    Left = 448
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
    OnShow.Strings = (
      'begin'
      '  TInput.close;'
      '  TInput.Open;'
      '  TInput.AppendRecord;'
      'end.')
    OnPublicVariable = <
      item
        VariableName = 'TInput'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  compo.exec('#39'CamaraVideo'#39','#39'encender'#39');'
          'end.')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonSalirSinSacarFoto'
        Source.Strings = (
          'begin'
          '  close;'
          'end.')
      end
      item
        ButtonName = 'BotonSacarFoto'
        Source.Strings = (
          'begin'
          '  DriverEvent.CompoVisual.exec('#39'CamaraVideo'#39','#39'tomarFoto'#39');'
          '  close;'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 472
    Top = 136
  end
  inherited TPathHelp: TsnTable
    Left = 472
    Top = 101
  end
  object TInput: TsnTable
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
    Left = 176
    Top = 137
    object TInputfoto: TBlobField
      FieldName = 'foto'
    end
    object TInputok: TBooleanField
      FieldName = 'ok'
    end
  end
end
