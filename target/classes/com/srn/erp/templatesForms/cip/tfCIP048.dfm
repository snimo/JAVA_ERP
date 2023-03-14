inherited FAltaEmpresaCIP: TFAltaEmpresaCIP
  Left = 440
  Top = 377
  Width = 614
  Height = 142
  BorderIcons = []
  Caption = 'Agregar Empresa'
  DragKind = dkDrag
  DragMode = dmManual
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object snLabel1: TsnLabel [0]
    Left = 32
    Top = 32
    Width = 41
    Height = 13
    Caption = 'Empresa'
  end
  object snDBEdit1: TsnDBEdit [1]
    Left = 88
    Top = 28
    DataBinding.DataField = 'empresa'
    DataBinding.DataSource = DSInput
    Properties.MaxLength = 100
    TabOrder = 0
    Width = 473
  end
  object BotonAceptar: TsnButton [2]
    Left = 352
    Top = 64
    Width = 75
    Height = 25
    Cursor = crHandPoint
    Caption = '&Aceptar'
    Default = True
    TabOrder = 1
    LookAndFeel.Kind = lfOffice11
  end
  object BotonCancelar: TsnButton [3]
    Left = 448
    Top = 64
    Width = 75
    Height = 25
    Cursor = crHandPoint
    Caption = '&Cancelar'
    TabOrder = 2
    LookAndFeel.Kind = lfOffice11
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TAltaEmpresa
        TableName = 'TAltaEmpresa'
      end>
    Top = 8
  end
  inherited Operacion: TOperacion
    Top = 8
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Top = 8
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Top = 8
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      '  TInput.Close;'
      '  TInput.Open;'
      '  TInput.AppendRecord;'
      'end.')
    OnPublicVariable = <
      item
        VariableName = 'TInput'
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure validar();'
          'begin'
          '  TInput.PostRecord;'
          '  if (Trim(TInput.FieldName('#39'empresa'#39').AsString)='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la empresa' +
            #39');'
          'end;'
          ''
          'procedure AltaEmpresa(Empresa : string);'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveAltaEmpresaCIP'#39');'
          '  operacion.AddAtribute('#39'empresa'#39',Empresa);'
          '  operacion.execute();'
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonCancelar'
        Source.Strings = (
          'begin'
          '  TInput.EditRecord;'
          '  TInput.FieldName('#39'oid_empresa'#39').Clear;'
          '  close();'
          'end.')
      end
      item
        ButtonName = 'BotonAceptar'
        Source.Strings = (
          'begin'
          '  TAltaEmpresa.Close;'
          '  TAltaEmpresa.Open;'
          '  validar();'
          '  AltaEmpresa(TInput.FieldName('#39'empresa'#39').AsString);'
          ''
          '  if (not TAltaEmpresa.IsEmpty)'
          '     then begin'
          '             TInput.EditRecord;'
          
            '             TInput.FieldName('#39'oid_empresa'#39').AsInteger := TAltaE' +
            'mpresa.FieldName('#39'oid_empresa'#39').AsInteger;'
          '             end'
          '     else begin'
          '             TInput.EditRecord;'
          '             TInput.FieldName('#39'oid_empresa'#39').Clear;'
          '             end; '
          ''
          '  close;'
          'end.')
      end>
    Top = 11
  end
  inherited SaveArchivo: TSaveDialog
    Left = 176
    Top = 8
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
    Left = 96
    Top = 64
    object TInputempresa: TStringField
      FieldName = 'empresa'
      Size = 100
    end
    object TInputoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 128
    Top = 64
  end
  object TAltaEmpresa: TsnTable
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
    Left = 464
    Top = 8
    object TAltaEmpresaoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TAltaEmpresaempresa: TStringField
      FieldName = 'empresa'
      Size = 100
    end
  end
end
