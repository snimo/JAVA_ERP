inherited FProcImpHipo: TFProcImpHipo
  Top = 312
  Height = 359
  Caption = 'Proceso de Importaci'#243'n del HIPODROMO'
  PixelsPerInch = 96
  TextHeight = 13
  object snLabel1: TsnLabel [0]
    Left = 72
    Top = 14
    Width = 191
    Height = 20
    Caption = 'Proceso de Importaci'#243'n'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clBlue
    Font.Height = -16
    Font.Name = 'MS Sans Serif'
    Font.Style = [fsBold, fsUnderline]
    ParentFont = False
  end
  object snLabel2: TsnLabel [1]
    Left = 40
    Top = 56
    Width = 477
    Height = 20
    Caption = 'Proceso espec'#237'fico desarrollado para  HIPODROMO DE PALERMO'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clBlue
    Font.Height = -16
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object snLabel3: TsnLabel [2]
    Left = 40
    Top = 96
    Width = 698
    Height = 20
    Caption = 
      'Toma la Informaci'#243'n de PAYROLL de la base de Datos MSSQLServer y' +
      ' la pasa a ORACLE donde '
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clBlue
    Font.Height = -16
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object snLabel4: TsnLabel [3]
    Left = 40
    Top = 120
    Width = 516
    Height = 20
    Caption = 'se encuentra instalado el SISTEMA DE CONTROL DE INGRESOS (CIP)'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clBlue
    Font.Height = -16
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object ImageSalir: TImage [4]
    Tag = 7
    Left = 18
    Top = 5
    Width = 32
    Height = 32
    Cursor = crHandPoint
    Hint = 'Salir'
    ParentShowHint = False
    ShowHint = True
  end
  object BotonImportacion: TsnButton [5]
    Left = 440
    Top = 168
    Width = 153
    Height = 73
    Cursor = crHandPoint
    Caption = 'Importaci'#243'n'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -16
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
    TabOrder = 0
    LookAndFeel.Kind = lfOffice11
  end
  object snDBCheckEdit1: TsnDBCheckEdit [6]
    Left = 72
    Top = 168
    Caption = 'Datos del Empleados'
    DataBinding.DataField = 'datos_empleado'
    DataBinding.DataSource = dsInput
    ParentFont = False
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -16
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 1
    Visible = False
    Width = 201
  end
  object snDBCheckEdit2: TsnDBCheckEdit [7]
    Left = 72
    Top = 208
    Caption = 'Planificaci'#243'n de Rotas y Novedades en el CAS'
    DataBinding.DataField = 'planif_rotas'
    DataBinding.DataSource = dsInput
    ParentFont = False
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -16
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 2
    Visible = False
    Width = 353
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
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  varios.setImagen('#39'ImageSalir'#39',7);'
          '  Inicializar();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure ImportarHipodromo();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'HipodromoImportar'#39');'
          '  '
          '  TInput.PostRecord;'
          ''
          '  if (TInput.FieldName('#39'datos_empleado'#39').AsBoolean)'
          '      then operacion.AddAtribute('#39'datos_empleado'#39','#39#39');'
          ''
          '  if (TInput.FieldName('#39'planif_rotas'#39').AsBoolean)'
          '      then operacion.AddAtribute('#39'planif_rotas'#39','#39#39');'
          ''
          '  operacion.AddAtribute('#39'mostrar_errores'#39','#39#39');'
          '  operacion.execute();'
          ''
          'end;'
          ''
          'procedure Inicializar();'
          'begin'
          '  TInput.Close;'
          '  TInput.Open;'
          '  TInput.AppendRecord;'
          '  TInput.FieldName('#39'datos_empleado'#39').AsBoolean := False;'
          '  TInput.FieldName('#39'planif_rotas'#39').AsBoolean := False;'
          'end;'
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonImportacion'
        Source.Strings = (
          'begin'
          '  if (mensaje.question('#39'Desea realizar la Importaci'#243'n?'#39'))'
          '      then begin'
          '              ImportarHipodromo();'
          '              mensaje.information('#39'Importaci'#243'n realizada.'#39');'
          '              end;'
          'end.')
      end
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  close();'
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
    Left = 168
    Top = 224
    object TInputdatos_empleado: TBooleanField
      FieldName = 'datos_empleado'
    end
    object TInputplanif_rotas: TBooleanField
      FieldName = 'planif_rotas'
    end
  end
  object dsInput: TDataSource
    DataSet = TInput
    Left = 200
    Top = 224
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 640
    Top = 185
  end
end
