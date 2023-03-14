inherited FNomGrabConsRot: TFNomGrabConsRot
  Left = 209
  Top = 399
  Width = 636
  Height = 169
  BorderIcons = []
  Caption = 'Grabaci'#243'n de la Consulta en Pantalla'
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object snLabel1: TsnLabel [0]
    Left = 24
    Top = 16
    Width = 282
    Height = 16
    Caption = 'Ingrese el nombre de la consulta para grabarla.'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object BotonAceptar: TsnButton [1]
    Left = 280
    Top = 86
    Width = 121
    Height = 33
    Caption = 'Grabar'
    Default = True
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
    TabOrder = 0
    LookAndFeel.Kind = lfOffice11
  end
  object BotonCancelar: TsnButton [2]
    Left = 424
    Top = 86
    Width = 121
    Height = 33
    Caption = 'Cancelar'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
    TabOrder = 1
    LookAndFeel.Kind = lfOffice11
  end
  object snDBEdit1: TsnDBEdit [3]
    Left = 24
    Top = 36
    DataBinding.DataField = 'nombre'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 2
    Width = 497
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
      '  Init();'
      '  snDBEdit1.setFoco();'
      'end.')
    OnPublicVariable = <
      item
        VariableName = 'TInput'
      end
      item
        VariableName = 'TOidObjSave'
      end
      item
        VariableName = 'TOidObjSave'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  Init();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure Init();'
          'begin'
          '  TInput.Close;'
          '  TInput.Open;'
          '  TInput.AppendRecord;'
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonAceptar'
        Source.Strings = (
          'begin'
          ''
          
            '  if (not mensaje.question('#39'Desea grabar la consulta?'#39')) then ex' +
            'it;  '
          ''
          '  TInput.EditRecord;'
          '  TInput.FieldName('#39'Acepto'#39').AsInteger := 1;'
          '  TInput.PostRecord;'
          '  close;'
          'end.')
      end
      item
        ButtonName = 'BotonCancelar'
        Source.Strings = (
          'begin'
          '  TInput.EditRecord;'
          '  TInput.FieldName('#39'Acepto'#39').AsInteger := 0;'
          '  TInput.PostRecord;'
          '  close;'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
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
    Left = 128
    Top = 80
    object TInputnombre: TStringField
      FieldName = 'nombre'
      Size = 100
    end
    object TInputacepto: TIntegerField
      FieldName = 'acepto'
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 160
    Top = 80
  end
end
