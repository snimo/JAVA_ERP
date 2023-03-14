inherited FMovManualConci: TFMovManualConci
  Left = 116
  Top = 187
  Width = 470
  Height = 340
  BorderIcons = [biSystemMenu]
  Caption = 'Movimientos Manuales'
  DragKind = dkDrag
  DragMode = dmManual
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object snTitulo: TsnLabel [0]
    Left = 16
    Top = 8
    Width = 149
    Height = 16
    Caption = 'T'#237'tulo del Movimiento'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = [fsBold]
    ParentFont = False
  end
  object snLabel2: TsnLabel [1]
    Left = 40
    Top = 40
    Width = 53
    Height = 16
    Caption = 'Terminal'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object snLabel3: TsnLabel [2]
    Left = 40
    Top = 72
    Width = 69
    Height = 16
    Caption = 'Fec. Origen'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object snLabel4: TsnLabel [3]
    Left = 40
    Top = 104
    Width = 65
    Height = 16
    Caption = 'Fec. Cierre'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object snLabel6: TsnLabel [4]
    Left = 40
    Top = 136
    Width = 43
    Height = 16
    Caption = 'Tarjeta'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object snLabel7: TsnLabel [5]
    Left = 40
    Top = 168
    Width = 71
    Height = 16
    Caption = 'Nro. Tarjeta'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object snLabel8: TsnLabel [6]
    Left = 40
    Top = 200
    Width = 26
    Height = 16
    Caption = 'Lote'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object snLabel9: TsnLabel [7]
    Left = 40
    Top = 232
    Width = 39
    Height = 16
    Caption = 'Cupon'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object snLabel10: TsnLabel [8]
    Left = 40
    Top = 264
    Width = 45
    Height = 16
    Caption = 'Importe'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object snLabel1: TsnLabel [9]
    Left = 417
    Top = 53
    Width = 25
    Height = 26
    AutoSize = False
    Color = 14024703
    ParentColor = False
  end
  object snLabel5: TsnLabel [10]
    Left = 317
    Top = 58
    Width = 94
    Height = 13
    Caption = 'Campos obligatorios'
  end
  object snLabel11: TsnLabel [11]
    Left = 317
    Top = 72
    Width = 126
    Height = 13
    Caption = '------------------------------------------'
    Transparent = True
  end
  object snLabel12: TsnLabel [12]
    Left = 317
    Top = 45
    Width = 126
    Height = 13
    Caption = '------------------------------------------'
    Transparent = True
  end
  object snDBLookup1: TsnDBLookup [13]
    Left = 120
    Top = 36
    DataBinding.DataField = 'oid_terminal'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Properties.KeyFieldNames = 'oid'
    Properties.ListColumns = <
      item
        FieldName = 'descripcion'
      end>
    Properties.ListOptions.ShowHeader = False
    Properties.ListSource = DSTerminales
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 0
    Width = 169
  end
  object snDBDateEdit1: TsnDBDateEdit [14]
    Left = 120
    Top = 68
    DataBinding.DataField = 'fec_origen'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 1
    ReadOnlyAlways = False
    Width = 121
  end
  object snDBDateEdit2: TsnDBDateEdit [15]
    Left = 120
    Top = 100
    DataBinding.DataField = 'fec_cierre'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Style.Color = 14024703
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 2
    ReadOnlyAlways = False
    Width = 121
  end
  object snDBLookup3: TsnDBLookup [16]
    Left = 120
    Top = 132
    DataBinding.DataField = 'oid_tarjeta'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Properties.KeyFieldNames = 'oid'
    Properties.ListColumns = <
      item
        FieldName = 'descripcion'
      end>
    Properties.ListOptions.ShowHeader = False
    Properties.ListSource = DSTarjetas
    Style.Color = 14024703
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 3
    Width = 281
  end
  object snDBEdit1: TsnDBEdit [17]
    Left = 120
    Top = 164
    DataBinding.DataField = 'nro_tarjeta'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 4
    Width = 121
  end
  object snDBEdit2: TsnDBEdit [18]
    Left = 120
    Top = 196
    DataBinding.DataField = 'lote'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 5
    Width = 121
  end
  object snDBEdit3: TsnDBEdit [19]
    Left = 120
    Top = 228
    DataBinding.DataField = 'cupon'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 6
    Width = 121
  end
  object snDBEdit4: TsnDBEdit [20]
    Left = 120
    Top = 260
    DataBinding.DataField = 'importe'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Style.Color = 14024703
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 7
    Width = 121
  end
  object BotonAceptar: TsnButton [21]
    Left = 264
    Top = 251
    Width = 75
    Height = 38
    Caption = '&Aceptar'
    TabOrder = 8
    LookAndFeel.Kind = lfOffice11
  end
  object BotonCancelar: TsnButton [22]
    Left = 360
    Top = 251
    Width = 75
    Height = 38
    Caption = 'Cancelar'
    TabOrder = 9
    LookAndFeel.Kind = lfOffice11
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TTipoDebCreConci
        TableName = 'TTipoDebCreConci'
      end
      item
        DataSet = TDetNuevoCuponPOSNET
        TableName = 'TDetNuevoCuponPOSNET'
      end
      item
        DataSet = TInput
        TableName = 'TInput'
      end
      item
        DataSet = TDetNuevoCuponTARJETA
        TableName = 'TDetNuevoCuponTARJETA'
      end
      item
        DataSet = TDetModifCuponPOSNET
        TableName = 'TDetModifCuponPOSNET'
      end
      item
        DataSet = TDetModifCuponTARJETA
        TableName = 'TDetModifCuponTARJETA'
      end
      item
        DataSet = TDetModifCuponTARJETA
        TableName = 'TDetModifCuponTARJETA'
      end>
    Left = 296
    Top = 0
  end
  inherited Operacion: TOperacion
    Left = 464
    Top = 40
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 504
    Top = 40
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 544
    Top = 40
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      ''
      '  snDBLookup1.setFoco(); '
      '  if (variable.getString('#39'tipo'#39') = '#39'ALTA_POSNET'#39')'
      '     then altaPOSNET()'
      '     else  if (variable.getString('#39'tipo'#39') = '#39'BAJA_POSNET'#39')'
      '                then bajaPOSNET()'
      
        '                else  if (variable.getString('#39'tipo'#39') = '#39'ALTA_TAR' +
        'JETA'#39')'
      '                           then altaTARJETA()'
      
        '                else  if (variable.getString('#39'tipo'#39') = '#39'BAJA_TAR' +
        'JETA'#39')'
      '                           then bajaTARJETA()'
      
        '                else  if (variable.getString('#39'tipo'#39') = '#39'MODIF_PO' +
        'SNET'#39')'
      '                           then modifPOSNET()'
      
        '                else  if (variable.getString('#39'tipo'#39') = '#39'MODIF_TA' +
        'RJETA'#39')'
      '                           then modifTARJETA()'
      ''
      'end.')
    OnPublicVariable = <
      item
        VariableName = 'tipo'
      end
      item
        VariableName = 'TDetNuevoCuponPOSNET'
      end
      item
        VariableName = 'oid_empresa'
      end
      item
        VariableName = 'TInput'
      end
      item
        VariableName = 'oid_arch_lote_det'
      end
      item
        VariableName = 'TDetNuevoCuponTARJETA'
      end
      item
        VariableName = 'oid_tar_info_det'
      end
      item
        VariableName = 'TDetModifCuponPOSNET'
      end
      item
        VariableName = 'TDetModifCuponTARJETA'
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure deshabilitarControles();'
          'begin'
          '  snDBLookup1.setReadOnly(true);'
          '  snDBDateEdit1.setEnable(false);'
          '  snDBDateEdit2.setEnable(false);'
          '  snDBLookup3.setReadOnly(true);'
          '  snDBEdit1.setReadOnly(true);'
          '  snDBEdit2.setReadOnly(true);'
          '  snDBEdit3.setReadOnly(true);'
          '  snDBEdit4.setReadOnly(true);'
          'end;'
          ''
          'procedure habilitarControles();'
          'begin'
          '  snDBLookup1.setReadOnly(false);'
          '  snDBDateEdit1.setEnable(true);'
          '  snDBDateEdit2.setEnable(true);'
          '  snDBLookup3.setReadOnly(false);'
          '  snDBEdit1.setReadOnly(false);'
          '  snDBEdit2.setReadOnly(false);'
          '  snDBEdit3.setReadOnly(false);'
          '  snDBEdit4.setReadOnly(false);'
          'end;'
          ''
          'procedure TraerTiposDebCre();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTipoDebCreConci'#39');'
          '  operacion.execute();'
          'end;'
          ''
          'procedure altaPOSNET();'
          'begin'
          '   habilitarControles();'
          '   TInput.Close;'
          '   TInput.Open;'
          '   TInput.AppendRecord;'
          '   snTitulo.setCaption('#39'Nuevo Movimiento CUPON del POSNET'#39');'
          '   TTerminales.LoadFromHelp('#39'HelpTerminales'#39');'
          '   TTarjetas.LoadFromHelp('#39'HelpTarjetas'#39');'
          '   TraerTiposDebCre();'
          'end;'
          ''
          'procedure altaTARJETA();'
          'begin'
          '   habilitarControles();'
          '   TInput.Close;'
          '   TInput.Open;'
          '   TInput.AppendRecord;'
          '   snTitulo.setCaption('#39'Nuevo Movimiento CUPON del TARJETA'#39');'
          '   TTerminales.LoadFromHelp('#39'HelpTerminales'#39');'
          '   TTarjetas.LoadFromHelp('#39'HelpTarjetas'#39');'
          '   TraerTiposDebCre();'
          'end;'
          ''
          ''
          'procedure TraerCuponPOSNET(OidArchLotDet : integer);'
          'begin'
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'TraerCuponPOSNETParaBaja'#39');'
          
            '   operacion.AddAtribute('#39'oid_arch_lote_det'#39',IntToStr(OidArchLot' +
            'Det));'
          '   operacion.execute();'
          'end;'
          ''
          'procedure TraerCuponTARJETA(OidTarInfoDet : integer);'
          'begin'
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'TraerCuponTARJETAParaBaja'#39');'
          
            '   operacion.AddAtribute('#39'oid_tar_info_det'#39',IntToStr(OidTarInfoD' +
            'et));'
          '   operacion.execute();'
          'end;'
          ''
          'procedure modifTARJETA();'
          'begin'
          '   deshabilitarControles();'
          '   TInput.Close;'
          '   TInput.Open;'
          '   TInput.AppendRecord;'
          
            '   snTitulo.setCaption('#39'Modificaci'#243'n Movimiento CUPON de la TARJ' +
            'ETA'#39');'
          '   TTerminales.LoadFromHelp('#39'HelpTerminales'#39');'
          '   TTarjetas.LoadFromHelp('#39'HelpTarjetas'#39');'
          '   TraerTiposDebCre();'
          '   TraerCuponTARJETA(variable.getInteger('#39'oid_tar_info_det'#39'));'
          '   snDBLookup3.setReadOnly(false);'
          'end;'
          ''
          ''
          'procedure modifPOSNET();'
          'begin'
          '   deshabilitarControles();'
          '   TInput.Close;'
          '   TInput.Open;'
          '   TInput.AppendRecord;'
          
            '   snTitulo.setCaption('#39'Modificaci'#243'n Movimiento CUPON del POSNET' +
            #39');'
          '   TTerminales.LoadFromHelp('#39'HelpTerminales'#39');'
          '   TTarjetas.LoadFromHelp('#39'HelpTarjetas'#39');'
          '   TraerTiposDebCre();'
          '   TraerCuponPOSNET(variable.getInteger('#39'oid_arch_lote_det'#39'));'
          '   snDBLookup3.setReadOnly(false);'
          'end;'
          ''
          ''
          'procedure bajaPOSNET();'
          'begin'
          '   deshabilitarControles();'
          '   TInput.Close;'
          '   TInput.Open;'
          '   TInput.AppendRecord;'
          '   snTitulo.setCaption('#39'Baja Movimiento CUPON del POSNET'#39');'
          '   TTerminales.LoadFromHelp('#39'HelpTerminales'#39');'
          '   TTarjetas.LoadFromHelp('#39'HelpTarjetas'#39');'
          '   TraerTiposDebCre();'
          '   TraerCuponPOSNET(variable.getInteger('#39'oid_arch_lote_det'#39'));'
          'end;'
          ''
          'procedure bajaTARJETA();'
          'begin'
          '   deshabilitarControles();'
          '   TInput.Close;'
          '   TInput.Open;'
          '   TInput.AppendRecord;'
          '   snTitulo.setCaption('#39'Baja Movimiento CUPON de TARJETA'#39');'
          '   TTerminales.LoadFromHelp('#39'HelpTerminales'#39');'
          '   TTarjetas.LoadFromHelp('#39'HelpTarjetas'#39');'
          '   TraerTiposDebCre();'
          '   TraerCuponTARJETA(variable.getInteger('#39'oid_tar_info_det'#39'));'
          'end;'
          ''
          ''
          'procedure confirmarAltaTARJETA();'
          'begin'
          ''
          '  if (variable.getInteger('#39'oid_empresa'#39')=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la empresa' +
            #39');'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'AltaMovManuTARJETA'#39');'
          
            '  operacion.addAtribute('#39'oid_empresa'#39',IntToStr(variable.getInteg' +
            'er('#39'oid_empresa'#39'))); '
          '  operacion.AddDataSet(TInput.getDataSet()); '
          '  operacion.execute();'
          ''
          '  if (TDetNuevoCuponTARJETA.IsEmpty)'
          
            '     then raiseException(erCustomError,'#39'No se pudo dar de alta e' +
            'l movimiento.'#39');'
          ''
          '  TInput.EditRecord;'
          '  TInput.FieldName('#39'acepto'#39').AsBoolean := true;'
          '  TInput.PostRecord;'
          ''
          'end;'
          ''
          ''
          ''
          'procedure confirmarAltaPOSNET();'
          'begin'
          ''
          '  if (variable.getInteger('#39'oid_empresa'#39')=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la empresa' +
            #39');'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'AltaMovManuPOSNET'#39');'
          
            '  operacion.addAtribute('#39'oid_empresa'#39',IntToStr(variable.getInteg' +
            'er('#39'oid_empresa'#39'))); '
          '  operacion.AddDataSet(TInput.getDataSet()); '
          '  operacion.execute();'
          ''
          '  if (TDetNuevoCuponPOSNET.IsEmpty)'
          
            '     then raiseException(erCustomError,'#39'No se pudo dar de alta e' +
            'l movimiento.'#39');'
          ''
          '  TInput.EditRecord;'
          '  TInput.FieldName('#39'acepto'#39').AsBoolean := true;'
          '  TInput.PostRecord;'
          ''
          'end;'
          ''
          'procedure confirmarModifPOSNET();'
          'begin'
          ''
          '  if (variable.getInteger('#39'oid_empresa'#39')=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la empresa' +
            #39');  '
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'ModifMovManuPOSNET'#39');'
          
            '  operacion.addAtribute('#39'oid_empresa'#39',IntToStr(variable.getInteg' +
            'er('#39'oid_empresa'#39'))); '
          
            '  operacion.addAtribute('#39'oid_arch_lote_det'#39',TInput.FieldName('#39'oi' +
            'd_arch_lote_det'#39').AsString); '
          '  operacion.AddDataSet(TInput.getDataSet());'
          '  operacion.execute();'
          ''
          '  TInput.EditRecord;'
          '  TInput.FieldName('#39'acepto'#39').AsBoolean := true;'
          '  TInput.PostRecord;'
          ''
          'end;'
          ''
          'procedure confirmarModifTARJETA();'
          'begin'
          ''
          '  if (variable.getInteger('#39'oid_empresa'#39')=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la empresa' +
            #39');  '
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'ModifMovManuTARJETA'#39');'
          
            '  operacion.addAtribute('#39'oid_empresa'#39',IntToStr(variable.getInteg' +
            'er('#39'oid_empresa'#39'))); '
          
            '  operacion.addAtribute('#39'oid_tar_info_det'#39',TInput.FieldName('#39'oid' +
            '_tar_info_det'#39').AsString); '
          '  operacion.AddDataSet(TInput.getDataSet());'
          '  operacion.execute();'
          ''
          '  TInput.EditRecord;'
          '  TInput.FieldName('#39'acepto'#39').AsBoolean := true;'
          '  TInput.PostRecord;'
          ''
          'end;'
          ''
          ''
          'procedure confirmarBajaPOSNET();'
          'begin'
          ''
          '  if (variable.getInteger('#39'oid_empresa'#39')=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la empresa' +
            #39');  '
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'BajaMovManuPOSNET'#39');'
          
            '  operacion.addAtribute('#39'oid_arch_lote_det'#39',TInput.FieldName('#39'oi' +
            'd_arch_lote_det'#39').AsString); '
          '  operacion.execute();'
          ''
          '  TInput.EditRecord;'
          '  TInput.FieldName('#39'acepto'#39').AsBoolean := true;'
          '  TInput.PostRecord;'
          ''
          'end;'
          ''
          ''
          ''
          'procedure confirmarBajaTARJETA();'
          'begin'
          ''
          '  if (variable.getInteger('#39'oid_empresa'#39')=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la empresa' +
            #39');  '
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'BajaMovManuTARJETA'#39');'
          
            '  operacion.addAtribute('#39'oid_tar_info_det'#39',TInput.FieldName('#39'oid' +
            '_tar_info_det'#39').AsString); '
          '  operacion.execute();'
          ''
          '  TInput.EditRecord;'
          '  TInput.FieldName('#39'acepto'#39').AsBoolean := true;'
          '  TInput.PostRecord;'
          ''
          'end;'
          ''
          ''
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonAceptar'
        Source.Strings = (
          'begin'
          '  if (variable.getString('#39'tipo'#39') = '#39'ALTA_POSNET'#39')'
          '     then confirmarAltaPOSNET()'
          '     else if (variable.getString('#39'tipo'#39') = '#39'BAJA_POSNET'#39')    '
          '               then confirmarBajaPOSNET()'
          '     else if (variable.getString('#39'tipo'#39') = '#39'ALTA_TARJETA'#39')    '
          '               then confirmarAltaTARJETA()'
          '     else if (variable.getString('#39'tipo'#39') = '#39'BAJA_TARJETA'#39')    '
          '               then confirmarBajaTARJETA()'
          '     else if (variable.getString('#39'tipo'#39') = '#39'MODIF_POSNET'#39')    '
          '               then confirmarModifPOSNET()'
          '     else if (variable.getString('#39'tipo'#39') = '#39'MODIF_TARJETA'#39')    '
          '               then confirmarModifTARJETA();'
          '  close;'
          'end.')
      end
      item
        ButtonName = 'BotonCancelar'
        Source.Strings = (
          'begin'
          '  TInput.EditRecord;'
          '  TInput.FieldName('#39'acepto'#39').AsBoolean := false;'
          '  TInput.PostRecord;'
          '  close;'
          'end.')
      end>
    Left = 264
    Top = 65535
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 520
    Top = 208
  end
  object TInput: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_terminal'
        DataType = ftInteger
      end
      item
        Name = 'fec_origen'
        DataType = ftDate
      end
      item
        Name = 'fec_cierre'
        DataType = ftDate
      end
      item
        Name = 'tipo'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'oid_tarjeta'
        DataType = ftInteger
      end
      item
        Name = 'nro_tarjeta'
        DataType = ftInteger
      end
      item
        Name = 'lote'
        DataType = ftInteger
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
    Left = 336
    Top = 232
    object TInputoid_tar_info_det: TIntegerField
      FieldName = 'oid_tar_info_det'
    end
    object TInputoid_arch_lote_det: TIntegerField
      FieldName = 'oid_arch_lote_det'
    end
    object TInputoid_terminal: TIntegerField
      FieldName = 'oid_terminal'
    end
    object TInputfec_origen: TDateField
      FieldName = 'fec_origen'
    end
    object TInputfec_cierre: TDateField
      FieldName = 'fec_cierre'
    end
    object TInputtipo: TStringField
      FieldName = 'tipo'
      Size = 10
    end
    object TInputoid_tarjeta: TIntegerField
      FieldName = 'oid_tarjeta'
    end
    object TInputnro_tarjeta: TIntegerField
      FieldName = 'nro_tarjeta'
    end
    object TInputlote: TIntegerField
      FieldName = 'lote'
    end
    object TInputcupon: TIntegerField
      FieldName = 'cupon'
    end
    object TInputimporte: TCurrencyField
      FieldName = 'importe'
    end
    object TInputacepto: TBooleanField
      FieldName = 'acepto'
    end
  end
  object HelpTerminales: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ctar.TerminalConciTar'
    NroHelp = 5
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
    Titulo = 'Terminales'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 170
    Top = 36
  end
  object TTerminales: TsnTable
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
    Left = 202
    Top = 36
    object TTerminalesoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TTerminalescodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTerminalesdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 368
    Top = 232
  end
  object DSTerminales: TDataSource
    DataSet = TTerminales
    Left = 234
    Top = 37
  end
  object TTipoDebCreConci: TsnTable
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
    Left = 320
    Top = 104
    object TTipoDebCreConcicodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTipoDebCreConcidescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTTipoDebCreConci: TDataSource
    DataSet = TTipoDebCreConci
    Left = 352
    Top = 104
  end
  object HelpTarjetas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ctar.TarjetaConciTar'
    NroHelp = 5
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
    Titulo = 'Tarjetas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 170
    Top = 65
  end
  object TTarjetas: TsnTable
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
    Left = 202
    Top = 65
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
  object DSTarjetas: TDataSource
    DataSet = TTarjetas
    Left = 234
    Top = 66
  end
  object TDetNuevoCuponPOSNET: TsnTable
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
    Left = 21
    Top = 46
    object IntegerField9: TIntegerField
      FieldName = 'oid_arch_lote_det'
    end
    object IntegerField10: TIntegerField
      FieldName = 'oid_arch_lote_cab'
    end
    object StringField4: TStringField
      FieldName = 'modo_transmision'
      Size = 3
    end
    object StringField5: TStringField
      FieldName = 'tipo_operacion'
      Size = 11
    end
    object StringField6: TStringField
      FieldName = 'fecha_oper'
      Size = 6
    end
    object StringField7: TStringField
      FieldName = 'hora_oper'
      Size = 6
    end
    object StringField8: TStringField
      FieldName = 'tipo_tarjeta'
      Size = 4
    end
    object StringField9: TStringField
      FieldName = 'tarjeta'
      Size = 11
    end
    object StringField10: TStringField
      FieldName = 'nro_tarjeta'
    end
    object StringField11: TStringField
      FieldName = 'banda_manual'
      Size = 1
    end
    object StringField12: TStringField
      FieldName = 'cod_autoriz'
      Size = 6
    end
    object StringField13: TStringField
      FieldName = 'ticket'
      Size = 4
    end
    object StringField14: TStringField
      FieldName = 'moneda'
      Size = 3
    end
    object FloatField3: TFloatField
      FieldName = 'Monto'
    end
    object StringField15: TStringField
      FieldName = 'tipo_cta_deb'
      Size = 3
    end
    object StringField16: TStringField
      FieldName = 'plan_y_cuota'
      Size = 3
    end
    object StringField17: TStringField
      FieldName = 'cod_comercio'
      Size = 15
    end
    object StringField18: TStringField
      FieldName = 'nro_terminal'
      Size = 8
    end
    object StringField19: TStringField
      FieldName = 'ticket_sec'
      Size = 4
    end
    object StringField20: TStringField
      FieldName = 'codigo_lista'
      Size = 5
    end
    object FloatField4: TFloatField
      FieldName = 'monto_sec'
    end
    object StringField21: TStringField
      FieldName = 'fecha_sec'
      Size = 6
    end
    object StringField22: TStringField
      FieldName = 'factura'
      Size = 16
    end
    object StringField23: TStringField
      FieldName = 'nro_host'
      Size = 1
    end
    object BooleanField6: TBooleanField
      FieldName = 'activo'
    end
    object BooleanField7: TBooleanField
      FieldName = 'presentado'
    end
    object IntegerField11: TIntegerField
      FieldName = 'oid_empresa'
    end
    object IntegerField12: TIntegerField
      FieldName = 'oid_uni_neg'
    end
    object DateField7: TDateField
      FieldName = 'fec_oper_date'
    end
    object DateField8: TDateField
      FieldName = 'fec_cierre'
    end
    object DateField9: TDateField
      FieldName = 'fec_presen_cupon'
    end
    object BooleanField8: TBooleanField
      FieldName = 'conciliado'
    end
    object DateField10: TDateField
      FieldName = 'fec_conciliado'
    end
    object BooleanField9: TBooleanField
      FieldName = 'liquidado'
    end
    object DateField11: TDateField
      FieldName = 'fec_liquidado'
    end
    object BooleanField10: TBooleanField
      FieldName = 'preContabilizado'
    end
    object DateField12: TDateField
      FieldName = 'fecPreContabilizado'
    end
    object BooleanField11: TBooleanField
      FieldName = 'contabilizado'
    end
    object DateField13: TDateField
      FieldName = 'fecContabilizado'
    end
    object IntegerField13: TIntegerField
      FieldName = 'nro_lote'
    end
    object StringField24: TStringField
      FieldName = 'agrupador'
      Size = 50
    end
    object BooleanField12: TBooleanField
      DefaultExpression = 'false'
      FieldName = 'marcar_preconci'
    end
    object IntegerField14: TIntegerField
      FieldName = 'ult_nros_tarj'
    end
    object IntegerField15: TIntegerField
      FieldName = 'nro_conciliacion'
    end
    object BooleanField13: TBooleanField
      FieldName = 'pre_conci'
    end
    object DateField14: TDateField
      FieldName = 'fec_preconci'
    end
    object IntegerField16: TIntegerField
      FieldName = 'nro_conci_aut'
    end
    object StringField25: TStringField
      FieldName = 'preconci_dudoso'
    end
  end
  object TDetNuevoCuponTARJETA: TsnTable
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
    Left = 22
    Top = 101
    object TDetNuevoCuponTARJETAoid_tar_info_det: TIntegerField
      FieldName = 'oid_tar_info_det'
    end
    object TDetNuevoCuponTARJETAoid_tar_info_cab: TIntegerField
      FieldName = 'oid_tar_info_cab'
    end
    object TDetNuevoCuponTARJETAoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TDetNuevoCuponTARJETAtipo_operacion: TStringField
      FieldName = 'tipo_operacion'
    end
    object TDetNuevoCuponTARJETAfec_present: TDateField
      FieldName = 'fec_present'
    end
    object TDetNuevoCuponTARJETAlote: TIntegerField
      FieldName = 'lote'
    end
    object TDetNuevoCuponTARJETAfec_pago: TDateField
      FieldName = 'fec_pago'
    end
    object TDetNuevoCuponTARJETAdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TDetNuevoCuponTARJETAfec_origen: TDateField
      FieldName = 'fec_origen'
    end
    object TDetNuevoCuponTARJETAnro_comprobante: TIntegerField
      FieldName = 'nro_comprobante'
    end
    object TDetNuevoCuponTARJETAnro_tarjeta: TIntegerField
      FieldName = 'nro_tarjeta'
    end
    object TDetNuevoCuponTARJETAplan: TStringField
      FieldName = 'plan'
      Size = 5
    end
    object TDetNuevoCuponTARJETAcuota: TStringField
      FieldName = 'cuota'
      Size = 2
    end
    object TDetNuevoCuponTARJETAmoneda: TStringField
      FieldName = 'moneda'
      Size = 10
    end
    object TDetNuevoCuponTARJETAimporte: TFloatField
      FieldName = 'importe'
    end
    object TDetNuevoCuponTARJETAcomercio: TStringField
      FieldName = 'comercio'
      Size = 50
    end
    object TDetNuevoCuponTARJETAnro_cupon: TIntegerField
      FieldName = 'nro_cupon'
    end
    object TDetNuevoCuponTARJETAtipo_tarjeta: TStringField
      FieldName = 'tipo_tarjeta'
      Size = 10
    end
    object TDetNuevoCuponTARJETAconciliado: TBooleanField
      FieldName = 'conciliado'
    end
    object TDetNuevoCuponTARJETAfec_conciliado: TDateField
      FieldName = 'fec_conciliado'
    end
    object TDetNuevoCuponTARJETAtarjeta: TStringField
      FieldName = 'tarjeta'
      Size = 50
    end
    object TDetNuevoCuponTARJETAactivo: TBooleanField
      FieldName = 'activo'
    end
    object TDetNuevoCuponTARJETAmarcar_preconci: TBooleanField
      DefaultExpression = 'false'
      FieldName = 'marcar_preconci'
    end
    object TDetNuevoCuponTARJETAnro_conciliacion: TIntegerField
      FieldName = 'nro_conciliacion'
    end
    object TDetNuevoCuponTARJETApre_conci: TBooleanField
      FieldName = 'pre_conci'
    end
    object TDetNuevoCuponTARJETAfec_preconci: TDateField
      FieldName = 'fec_preconci'
    end
    object TDetNuevoCuponTARJETAnro_conci_aut: TIntegerField
      FieldName = 'nro_conci_aut'
    end
    object TDetNuevoCuponTARJETApreconci_dudoso: TBooleanField
      FieldName = 'preconci_dudoso'
    end
  end
  object TDetModifCuponPOSNET: TsnTable
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
    Left = 21
    Top = 149
    object IntegerField2: TIntegerField
      FieldName = 'oid_arch_lote_det'
    end
    object IntegerField3: TIntegerField
      FieldName = 'oid_arch_lote_cab'
    end
    object StringField3: TStringField
      FieldName = 'modo_transmision'
      Size = 3
    end
    object StringField26: TStringField
      FieldName = 'tipo_operacion'
      Size = 11
    end
    object StringField27: TStringField
      FieldName = 'fecha_oper'
      Size = 6
    end
    object StringField28: TStringField
      FieldName = 'hora_oper'
      Size = 6
    end
    object StringField29: TStringField
      FieldName = 'tipo_tarjeta'
      Size = 4
    end
    object StringField30: TStringField
      FieldName = 'tarjeta'
      Size = 11
    end
    object StringField31: TStringField
      FieldName = 'nro_tarjeta'
    end
    object StringField32: TStringField
      FieldName = 'banda_manual'
      Size = 1
    end
    object StringField33: TStringField
      FieldName = 'cod_autoriz'
      Size = 6
    end
    object StringField34: TStringField
      FieldName = 'ticket'
      Size = 4
    end
    object StringField35: TStringField
      FieldName = 'moneda'
      Size = 3
    end
    object FloatField1: TFloatField
      FieldName = 'Monto'
    end
    object StringField36: TStringField
      FieldName = 'tipo_cta_deb'
      Size = 3
    end
    object StringField37: TStringField
      FieldName = 'plan_y_cuota'
      Size = 3
    end
    object StringField38: TStringField
      FieldName = 'cod_comercio'
      Size = 15
    end
    object StringField39: TStringField
      FieldName = 'nro_terminal'
      Size = 8
    end
    object StringField40: TStringField
      FieldName = 'ticket_sec'
      Size = 4
    end
    object StringField41: TStringField
      FieldName = 'codigo_lista'
      Size = 5
    end
    object FloatField2: TFloatField
      FieldName = 'monto_sec'
    end
    object StringField42: TStringField
      FieldName = 'fecha_sec'
      Size = 6
    end
    object StringField43: TStringField
      FieldName = 'factura'
      Size = 16
    end
    object StringField44: TStringField
      FieldName = 'nro_host'
      Size = 1
    end
    object BooleanField1: TBooleanField
      FieldName = 'activo'
    end
    object BooleanField2: TBooleanField
      FieldName = 'presentado'
    end
    object IntegerField4: TIntegerField
      FieldName = 'oid_empresa'
    end
    object IntegerField5: TIntegerField
      FieldName = 'oid_uni_neg'
    end
    object DateField1: TDateField
      FieldName = 'fec_oper_date'
    end
    object DateField2: TDateField
      FieldName = 'fec_cierre'
    end
    object DateField3: TDateField
      FieldName = 'fec_presen_cupon'
    end
    object BooleanField3: TBooleanField
      FieldName = 'conciliado'
    end
    object DateField4: TDateField
      FieldName = 'fec_conciliado'
    end
    object BooleanField4: TBooleanField
      FieldName = 'liquidado'
    end
    object DateField5: TDateField
      FieldName = 'fec_liquidado'
    end
    object BooleanField5: TBooleanField
      FieldName = 'preContabilizado'
    end
    object DateField6: TDateField
      FieldName = 'fecPreContabilizado'
    end
    object BooleanField14: TBooleanField
      FieldName = 'contabilizado'
    end
    object DateField15: TDateField
      FieldName = 'fecContabilizado'
    end
    object IntegerField6: TIntegerField
      FieldName = 'nro_lote'
    end
    object StringField45: TStringField
      FieldName = 'agrupador'
      Size = 50
    end
    object BooleanField15: TBooleanField
      DefaultExpression = 'false'
      FieldName = 'marcar_preconci'
    end
    object IntegerField7: TIntegerField
      FieldName = 'ult_nros_tarj'
    end
    object IntegerField8: TIntegerField
      FieldName = 'nro_conciliacion'
    end
    object BooleanField16: TBooleanField
      FieldName = 'pre_conci'
    end
    object DateField16: TDateField
      FieldName = 'fec_preconci'
    end
    object IntegerField17: TIntegerField
      FieldName = 'nro_conci_aut'
    end
    object StringField46: TStringField
      FieldName = 'preconci_dudoso'
    end
  end
  object TDetModifCuponTARJETA: TsnTable
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
    Left = 22
    Top = 196
    object IntegerField18: TIntegerField
      FieldName = 'oid_tar_info_det'
    end
    object IntegerField19: TIntegerField
      FieldName = 'oid_tar_info_cab'
    end
    object IntegerField20: TIntegerField
      FieldName = 'oid_empresa'
    end
    object StringField47: TStringField
      FieldName = 'tipo_operacion'
    end
    object DateField17: TDateField
      FieldName = 'fec_present'
    end
    object IntegerField21: TIntegerField
      FieldName = 'lote'
    end
    object DateField18: TDateField
      FieldName = 'fec_pago'
    end
    object StringField48: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object DateField19: TDateField
      FieldName = 'fec_origen'
    end
    object IntegerField22: TIntegerField
      FieldName = 'nro_comprobante'
    end
    object IntegerField23: TIntegerField
      FieldName = 'nro_tarjeta'
    end
    object StringField49: TStringField
      FieldName = 'plan'
      Size = 5
    end
    object StringField50: TStringField
      FieldName = 'cuota'
      Size = 2
    end
    object StringField51: TStringField
      FieldName = 'moneda'
      Size = 10
    end
    object FloatField5: TFloatField
      FieldName = 'importe'
    end
    object StringField52: TStringField
      FieldName = 'comercio'
      Size = 50
    end
    object IntegerField24: TIntegerField
      FieldName = 'nro_cupon'
    end
    object StringField53: TStringField
      FieldName = 'tipo_tarjeta'
      Size = 10
    end
    object BooleanField17: TBooleanField
      FieldName = 'conciliado'
    end
    object DateField20: TDateField
      FieldName = 'fec_conciliado'
    end
    object StringField54: TStringField
      FieldName = 'tarjeta'
      Size = 50
    end
    object BooleanField18: TBooleanField
      FieldName = 'activo'
    end
    object BooleanField19: TBooleanField
      DefaultExpression = 'false'
      FieldName = 'marcar_preconci'
    end
    object IntegerField25: TIntegerField
      FieldName = 'nro_conciliacion'
    end
    object BooleanField20: TBooleanField
      FieldName = 'pre_conci'
    end
    object DateField21: TDateField
      FieldName = 'fec_preconci'
    end
    object IntegerField26: TIntegerField
      FieldName = 'nro_conci_aut'
    end
    object BooleanField21: TBooleanField
      FieldName = 'preconci_dudoso'
    end
  end
end
