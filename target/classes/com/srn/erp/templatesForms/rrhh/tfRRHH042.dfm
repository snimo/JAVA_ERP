inherited FActuJerarLeg: TFActuJerarLeg
  Caption = 'Actualizaci'#243'n de Jerarqu'#237'as'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    inherited PCabecera: TPanel
      Height = 12
    end
    inherited PCuerpo: TPanel
      Top = 64
      Height = 527
      object Splitter1: TSplitter
        Left = 0
        Top = 121
        Width = 721
        Height = 3
        Cursor = crVSplit
        Align = alTop
      end
      object Splitter2: TSplitter
        Left = 0
        Top = 297
        Width = 721
        Height = 3
        Cursor = crVSplit
        Align = alTop
      end
      object Panel1: TPanel
        Left = 0
        Top = 0
        Width = 721
        Height = 121
        Align = alTop
        Color = clWindow
        TabOrder = 0
        object dxDBGridSN1: TdxDBGridSN
          Left = 1
          Top = 1
          Width = 719
          Height = 119
          Align = alClient
          TabOrder = 0
          CriteriosPintarCelda = <>
          object dxDBGridSN1DBTableView1: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            NavigatorButtons.First.Enabled = False
            NavigatorButtons.First.Visible = False
            NavigatorButtons.PriorPage.Enabled = False
            NavigatorButtons.PriorPage.Visible = False
            NavigatorButtons.Prior.Enabled = False
            NavigatorButtons.Prior.Visible = False
            NavigatorButtons.Next.Enabled = False
            NavigatorButtons.Next.Visible = False
            NavigatorButtons.NextPage.Enabled = False
            NavigatorButtons.NextPage.Visible = False
            NavigatorButtons.Last.Enabled = False
            NavigatorButtons.Last.Visible = False
            NavigatorButtons.Insert.Enabled = False
            NavigatorButtons.Insert.Visible = False
            NavigatorButtons.Append.Visible = True
            NavigatorButtons.Delete.Enabled = False
            NavigatorButtons.Delete.Visible = False
            NavigatorButtons.Edit.Enabled = False
            NavigatorButtons.Edit.Visible = False
            NavigatorButtons.Post.Enabled = False
            NavigatorButtons.Post.Visible = False
            NavigatorButtons.Cancel.Enabled = False
            NavigatorButtons.Cancel.Visible = False
            NavigatorButtons.Refresh.Enabled = False
            NavigatorButtons.Refresh.Visible = False
            NavigatorButtons.SaveBookmark.Enabled = False
            NavigatorButtons.SaveBookmark.Visible = False
            NavigatorButtons.GotoBookmark.Enabled = False
            NavigatorButtons.GotoBookmark.Visible = False
            NavigatorButtons.Filter.Enabled = False
            NavigatorButtons.Filter.Visible = False
            DataController.DataSource = DSEmpresas
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsData.Appending = True
            OptionsData.CancelOnExit = False
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsData.Inserting = False
            OptionsSelection.InvertSelect = False
            OptionsView.Navigator = True
            OptionsView.GroupByBox = False
            object dxDBGridSN1DBTableView1CODIGO: TcxGridDBColumn
              Caption = 'C'#243'digo'
              DataBinding.FieldName = 'CODIGO'
              PropertiesClassName = 'TcxButtonEditProperties'
              Properties.Buttons = <
                item
                  Default = True
                  Kind = bkEllipsis
                end>
              Width = 150
            end
            object dxDBGridSN1DBTableView1DESCRIPCION: TcxGridDBColumn
              Caption = 'Empresas'
              DataBinding.FieldName = 'DESCRIPCION'
              Options.Editing = False
              Width = 424
            end
            object dxDBGridSN1DBTableView1ACTIVO: TcxGridDBColumn
              Caption = 'Activo'
              DataBinding.FieldName = 'ACTIVO'
              PropertiesClassName = 'TcxCheckBoxProperties'
              Width = 66
            end
          end
          object dxDBGridSN1Level1: TcxGridLevel
            GridView = dxDBGridSN1DBTableView1
          end
        end
      end
      object Panel3: TPanel
        Left = 0
        Top = 124
        Width = 721
        Height = 173
        Align = alTop
        Color = clWindow
        TabOrder = 1
        object dxDBGridSN2: TdxDBGridSN
          Left = 1
          Top = 1
          Width = 719
          Height = 171
          Align = alClient
          TabOrder = 0
          CriteriosPintarCelda = <>
          object cxGridDBTableView1: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            NavigatorButtons.First.Enabled = False
            NavigatorButtons.First.Visible = False
            NavigatorButtons.PriorPage.Enabled = False
            NavigatorButtons.PriorPage.Visible = False
            NavigatorButtons.Prior.Enabled = False
            NavigatorButtons.Prior.Visible = False
            NavigatorButtons.Next.Enabled = False
            NavigatorButtons.Next.Visible = False
            NavigatorButtons.NextPage.Enabled = False
            NavigatorButtons.NextPage.Visible = False
            NavigatorButtons.Last.Enabled = False
            NavigatorButtons.Last.Visible = False
            NavigatorButtons.Insert.Enabled = False
            NavigatorButtons.Insert.Visible = False
            NavigatorButtons.Append.Visible = True
            NavigatorButtons.Delete.Enabled = False
            NavigatorButtons.Delete.Visible = False
            NavigatorButtons.Edit.Enabled = False
            NavigatorButtons.Edit.Visible = False
            NavigatorButtons.Post.Enabled = False
            NavigatorButtons.Post.Visible = False
            NavigatorButtons.Cancel.Enabled = False
            NavigatorButtons.Cancel.Visible = False
            NavigatorButtons.Refresh.Enabled = False
            NavigatorButtons.Refresh.Visible = False
            NavigatorButtons.SaveBookmark.Enabled = False
            NavigatorButtons.SaveBookmark.Visible = False
            NavigatorButtons.GotoBookmark.Enabled = False
            NavigatorButtons.GotoBookmark.Visible = False
            NavigatorButtons.Filter.Enabled = False
            NavigatorButtons.Filter.Visible = False
            DataController.DataSource = DSSectores
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsData.Appending = True
            OptionsData.CancelOnExit = False
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsData.Inserting = False
            OptionsSelection.InvertSelect = False
            OptionsView.Navigator = True
            OptionsView.GroupByBox = False
            object cxGridDBColumn1: TcxGridDBColumn
              Caption = 'C'#243'digo'
              DataBinding.FieldName = 'CODIGO'
              PropertiesClassName = 'TcxButtonEditProperties'
              Properties.Buttons = <
                item
                  Default = True
                  Kind = bkEllipsis
                end>
              Width = 150
            end
            object cxGridDBColumn2: TcxGridDBColumn
              Caption = 'Sectores'
              DataBinding.FieldName = 'DESCRIPCION'
              Options.Editing = False
              Width = 424
            end
            object cxGridDBColumn3: TcxGridDBColumn
              Caption = 'Activo'
              DataBinding.FieldName = 'ACTIVO'
              PropertiesClassName = 'TcxCheckBoxProperties'
              Width = 66
            end
          end
          object cxGridLevel1: TcxGridLevel
            GridView = cxGridDBTableView1
          end
        end
      end
      object Panel4: TPanel
        Left = 0
        Top = 300
        Width = 721
        Height = 227
        Align = alClient
        Color = clWindow
        TabOrder = 2
        object dxDBGridSN3: TdxDBGridSN
          Left = 1
          Top = 1
          Width = 719
          Height = 225
          Align = alClient
          TabOrder = 0
          CriteriosPintarCelda = <>
          object cxGridDBTableView2: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            NavigatorButtons.First.Enabled = False
            NavigatorButtons.First.Visible = False
            NavigatorButtons.PriorPage.Enabled = False
            NavigatorButtons.PriorPage.Visible = False
            NavigatorButtons.Prior.Enabled = False
            NavigatorButtons.Prior.Visible = False
            NavigatorButtons.Next.Enabled = False
            NavigatorButtons.Next.Visible = False
            NavigatorButtons.NextPage.Enabled = False
            NavigatorButtons.NextPage.Visible = False
            NavigatorButtons.Last.Enabled = False
            NavigatorButtons.Last.Visible = False
            NavigatorButtons.Insert.Enabled = False
            NavigatorButtons.Insert.Visible = False
            NavigatorButtons.Append.Visible = True
            NavigatorButtons.Delete.Enabled = False
            NavigatorButtons.Delete.Visible = False
            NavigatorButtons.Edit.Enabled = False
            NavigatorButtons.Edit.Visible = False
            NavigatorButtons.Post.Enabled = False
            NavigatorButtons.Post.Visible = False
            NavigatorButtons.Cancel.Enabled = False
            NavigatorButtons.Cancel.Visible = False
            NavigatorButtons.Refresh.Enabled = False
            NavigatorButtons.Refresh.Visible = False
            NavigatorButtons.SaveBookmark.Enabled = False
            NavigatorButtons.SaveBookmark.Visible = False
            NavigatorButtons.GotoBookmark.Enabled = False
            NavigatorButtons.GotoBookmark.Visible = False
            NavigatorButtons.Filter.Enabled = False
            NavigatorButtons.Filter.Visible = False
            DataController.DataSource = dsPuestos
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsData.Appending = True
            OptionsData.CancelOnExit = False
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsData.Inserting = False
            OptionsSelection.InvertSelect = False
            OptionsView.Navigator = True
            OptionsView.GroupByBox = False
            object cxGridDBColumn4: TcxGridDBColumn
              Caption = 'C'#243'digo'
              DataBinding.FieldName = 'CODIGO'
              PropertiesClassName = 'TcxButtonEditProperties'
              Properties.Buttons = <
                item
                  Default = True
                  Kind = bkEllipsis
                end>
              Width = 150
            end
            object cxGridDBColumn5: TcxGridDBColumn
              Caption = 'Puestos'
              DataBinding.FieldName = 'DESCRIPCION'
              Options.Editing = False
              Width = 424
            end
            object cxGridDBColumn6: TcxGridDBColumn
              Caption = 'Activo'
              DataBinding.FieldName = 'ACTIVO'
              PropertiesClassName = 'TcxCheckBoxProperties'
              Width = 66
            end
          end
          object cxGridLevel2: TcxGridLevel
            GridView = cxGridDBTableView2
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperGrabarObjeto = 'SaveJerarDesaLeg'
    CargaDataSets = <
      item
        DataSet = TEmpresas
        TableName = 'TEmpresas'
      end
      item
        DataSet = TSectores
        TableName = 'TSectores'
      end
      item
        DataSet = TPuestos
        TableName = 'TPuestos'
      end
      item
        DataSet = TClasificadores
        TableName = 'TClasificadores'
      end
      item
        DataSet = TValorClaifEntidad
        TableName = 'TValorClaifEntidad'
      end>
    OperHabilitadas = [toOperNuevo]
    DataSetCab = TEmpresas
    DataSetDet1 = TSectores
    DataSetDet2 = TPuestos
    DespuesDeGrabarAlta = asClear
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
        TableName = 'TEmpresas'
        FieldName = 'CODIGO'
        Source.Strings = (
          'begin'
          '  ValidarValorClasifEmpresa(Sender.AsString);'
          'end.')
      end
      item
        TableName = 'TSectores'
        FieldName = 'CODIGO'
        Source.Strings = (
          'begin'
          '  ValidarValorClasifSector(Sender.AsString);'
          'end.')
      end
      item
        TableName = 'TPuestos'
        FieldName = 'CODIGO'
        Source.Strings = (
          'begin'
          '  ValidarValorClasifPuesto(Sender.AsString);'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TEmpresas'
        Source.Strings = (
          'begin'
          '  if (Trim(DataSet.FieldName('#39'codigo'#39').AsString)='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el c'#243'digo'#39 +
            ');'
          '  if (Trim(DataSet.FieldName('#39'descripcion'#39').AsString)='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la descrip' +
            'ci'#243'n de la empresa'#39');'
          'end.')
      end
      item
        TableName = 'TSectores'
        Source.Strings = (
          'begin'
          '  if (Trim(DataSet.FieldName('#39'codigo'#39').AsString)='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el c'#243'digo'#39 +
            ');'
          '  if (Trim(DataSet.FieldName('#39'descripcion'#39').AsString)='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la descrip' +
            'ci'#243'n del sector'#39');'
          'end.'
          '')
      end
      item
        TableName = 'TPuestos'
        Source.Strings = (
          'begin'
          '  if (Trim(DataSet.FieldName('#39'codigo'#39').AsString)='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el c'#243'digo'#39 +
            ');'
          '  if (Trim(DataSet.FieldName('#39'descripcion'#39').AsString)='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la descrip' +
            'ci'#243'n del puesto'#39');'
          'end.'
          '')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TSectores'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          
            '  DataSet.FieldName('#39'OID_ESTRUC_EMP'#39').AsInteger := TEmpresas.Fie' +
            'ldName('#39'OID_ESTRUC_EMP'#39').AsInteger;'
          'end.')
      end
      item
        TableName = 'TPuestos'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'OID_ESTRUC_SEC'#39').AsInteger := TSectores.Fie' +
            'ldName('#39'OID_ESTRUC_SEC'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TEmpresas'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerJerarquias();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerJerarDesaLeg'#39');'
          ' operacion.execute();'
          'end;'
          ''
          'procedure MostrarHelpEmpresa();'
          'begin'
          '  HelpValoresClasificadorEmp.NickName := '#39'su.Legajo'#39';'
          
            '  HelpValoresClasificadorEmp.NroClasificador    :=  TClasificado' +
            'res.FieldName('#39'nro_clasif_emp'#39').AsInteger;'
          '  HelpValoresClasificadorEmp.Mostrar();'
          'end;'
          ''
          ''
          'procedure MostrarHelpSector();'
          'begin'
          '  HelpValoresClasificadorSec.NickName := '#39'su.Legajo'#39';'
          
            '  HelpValoresClasificadorSec.NroClasificador    :=  TClasificado' +
            'res.FieldName('#39'nro_clasif_sec'#39').AsInteger;'
          '  HelpValoresClasificadorSec.Mostrar();'
          'end;'
          ''
          ''
          'procedure MostrarHelpPuesto();'
          'begin'
          '  HelpValoresClasificadorPue.NickName := '#39'su.Legajo'#39';'
          
            '  HelpValoresClasificadorPue.NroClasificador    :=  TClasificado' +
            'res.FieldName('#39'nro_clasif_pue'#39').AsInteger;'
          '  HelpValoresClasificadorPue.Mostrar();'
          'end;'
          ''
          'procedure ValidarValorClasifEmpresa(codigo : string);'
          'begin'
          ''
          '  if (codigo = '#39#39')'
          '     then begin'
          '             TEmpresas.EditRecord;'
          
            '             TEmpresas.FieldName('#39'OID_VAL_CLASIF_EMP'#39').AsInteger' +
            ' := 0;'
          '             TEmpresas.FieldName('#39'descripcion'#39').AsString := '#39#39';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifEntidad'#39');'
          
            '  operacion.addAtribute('#39'oid_clasif_ent'#39',IntToStr(TClasificadore' +
            's.FieldName('#39'oid_clasif_emp'#39').AsInteger));'
          '  operacion.addAtribute('#39'codigo'#39',codigo);'
          '  operacion.execute;'
          ''
          '  TEmpresas.EditRecord;'
          '  TEmpresas.FieldName('#39'OID_VAL_CLASIF_EMP'#39').AsInteger :='
          
            '       TValorClaifEntidad.FieldName('#39'oid_valor_clasif_ent'#39').AsIn' +
            'teger;'
          '  TEmpresas.FieldName('#39'descripcion'#39').AsString :='
          '      TValorClaifEntidad.FieldName('#39'descripcion'#39').AsString;'
          ''
          'end;'
          ''
          'procedure ValidarValorClasifSector(codigo : string);'
          'begin'
          ''
          '  if (codigo = '#39#39')'
          '     then begin'
          '             TSectores.EditRecord;'
          
            '             TSectores.FieldName('#39'OID_VAL_CLASIF_SEC'#39').AsInteger' +
            ' := 0;'
          '             TSectores.FieldName('#39'descripcion'#39').AsString := '#39#39';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifEntidad'#39');'
          
            '  operacion.addAtribute('#39'oid_clasif_ent'#39',IntToStr(TClasificadore' +
            's.FieldName('#39'oid_clasif_sec'#39').AsInteger));'
          '  operacion.addAtribute('#39'codigo'#39',codigo);'
          '  operacion.execute;'
          ''
          '  TSectores.EditRecord;'
          '  TSectores.FieldName('#39'OID_VAL_CLASIF_SEC'#39').AsInteger :='
          
            '       TValorClaifEntidad.FieldName('#39'oid_valor_clasif_ent'#39').AsIn' +
            'teger;'
          '  TSectores.FieldName('#39'descripcion'#39').AsString :='
          '      TValorClaifEntidad.FieldName('#39'descripcion'#39').AsString;'
          ''
          'end;'
          ''
          'procedure ValidarValorClasifPuesto(codigo : string);'
          'begin'
          ''
          '  if (codigo = '#39#39')'
          '     then begin'
          '             TPuestos.EditRecord;'
          
            '             TPuestos.FieldName('#39'OID_VAL_CLASIF_PUE'#39').AsInteger ' +
            ':= 0;'
          '             TPuestos.FieldName('#39'descripcion'#39').AsString := '#39#39';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifEntidad'#39');'
          
            '  operacion.addAtribute('#39'oid_clasif_ent'#39',IntToStr(TClasificadore' +
            's.FieldName('#39'oid_clasif_pue'#39').AsInteger));'
          '  operacion.addAtribute('#39'codigo'#39',codigo);'
          '  operacion.execute;'
          ''
          '  TPuestos.EditRecord;'
          '  TPuestos.FieldName('#39'OID_VAL_CLASIF_PUE'#39').AsInteger :='
          
            '       TValorClaifEntidad.FieldName('#39'oid_valor_clasif_ent'#39').AsIn' +
            'teger;'
          '  TPuestos.FieldName('#39'descripcion'#39').AsString :='
          '      TValorClaifEntidad.FieldName('#39'descripcion'#39').AsString;'
          ''
          'end;'
          ''
          ''
          '')
      end>
    OnAfterNuevo = <
      item
        Source.Strings = (
          'begin'
          '  TraerJerarquias();'
          'end.')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'dxDBGridSN1DBTableView1CODIGO'
        Source.Strings = (
          'begin'
          '  MostrarHelpEmpresa();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBColumn1'
        Source.Strings = (
          'begin'
          '  MostrarHelpSector();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBColumn4'
        Source.Strings = (
          'begin'
          '  MostrarHelpPuesto();'
          'end.'
          '')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object TEmpresas: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'OID_ESTRUC_EMP'
        DataType = ftInteger
      end
      item
        Name = 'OID_VAL_CLASIF_EMP'
        DataType = ftInteger
      end
      item
        Name = 'ACTIVO'
        DataType = ftBoolean
      end
      item
        Name = 'CODIGO'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'DESCRIPCION'
        DataType = ftString
        Size = 255
      end>
    IndexDefs = <
      item
        Name = 'TEmpresasIndex1'
        Fields = 'CODIGO'
        Options = [ixUnique]
      end>
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
    MensajeValorDuplicadoIndice = 'C'#243'digo de Empresa Duplicado'
    Left = 128
    Top = 224
    object TEmpresasOID_ESTRUC_EMP: TIntegerField
      FieldName = 'OID_ESTRUC_EMP'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TEmpresasOID_VAL_CLASIF_EMP: TIntegerField
      FieldName = 'OID_VAL_CLASIF_EMP'
    end
    object TEmpresasACTIVO: TBooleanField
      FieldName = 'ACTIVO'
    end
    object TEmpresasCODIGO: TStringField
      FieldName = 'CODIGO'
      Size = 50
    end
    object TEmpresasDESCRIPCION: TStringField
      FieldName = 'DESCRIPCION'
      Size = 255
    end
  end
  object DSEmpresas: TDataSource
    DataSet = TEmpresas
    Left = 160
    Top = 223
  end
  object TSectores: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'OID_ESTRUC_SEC'
        DataType = ftInteger
      end
      item
        Name = 'OID_ESTRUC_EMP'
        DataType = ftInteger
      end
      item
        Name = 'OID_VAL_CLASIF_SEC'
        DataType = ftInteger
      end
      item
        Name = 'ACTIVO'
        DataType = ftBoolean
      end
      item
        Name = 'CODIGO'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'DESCRIPCION'
        DataType = ftString
        Size = 255
      end>
    IndexFieldNames = 'OID_ESTRUC_EMP'
    IndexDefs = <
      item
        Name = 'TSectoresIndex1'
        Fields = 'OID_ESTRUC_EMP'
      end
      item
        Name = 'TSectoresIndex2'
        Fields = 'OID_ESTRUC_EMP;CODIGO'
        Options = [ixUnique]
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'OID_ESTRUC_EMP'
    MasterSource = DSEmpresas
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'C'#243'digo de Sector Duplicado'
    Left = 128
    Top = 276
    object TSectoresOID_ESTRUC_SEC: TIntegerField
      FieldName = 'OID_ESTRUC_SEC'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TSectoresOID_ESTRUC_EMP: TIntegerField
      FieldName = 'OID_ESTRUC_EMP'
    end
    object TSectoresOID_VAL_CLASIF_SEC: TIntegerField
      FieldName = 'OID_VAL_CLASIF_SEC'
    end
    object TSectoresACTIVO: TBooleanField
      FieldName = 'ACTIVO'
    end
    object TSectoresCODIGO: TStringField
      FieldName = 'CODIGO'
      Size = 50
    end
    object TSectoresDESCRIPCION: TStringField
      FieldName = 'DESCRIPCION'
      Size = 255
    end
  end
  object DSSectores: TDataSource
    DataSet = TSectores
    Left = 160
    Top = 276
  end
  object TPuestos: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'OID_ESTRUC_PUE'
        DataType = ftInteger
      end
      item
        Name = 'OID_ESTRUC_SEC'
        DataType = ftInteger
      end
      item
        Name = 'OID_VAL_CLASIF_PUE'
        DataType = ftInteger
      end
      item
        Name = 'CODIGO'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'DESCRIPCION'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'ACTIVO'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'OID_ESTRUC_SEC'
    IndexDefs = <
      item
        Name = 'TPuestosIndex1'
        Fields = 'OID_ESTRUC_SEC'
      end
      item
        Name = 'TPuestosIndex2'
        Fields = 'OID_ESTRUC_SEC;CODIGO'
        Options = [ixUnique]
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'OID_ESTRUC_SEC'
    MasterSource = DSSectores
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'C'#243'digo de Puesto Duplicado'
    Left = 128
    Top = 324
    object TPuestosOID_ESTRUC_PUE: TIntegerField
      FieldName = 'OID_ESTRUC_PUE'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPuestosOID_ESTRUC_SEC: TIntegerField
      FieldName = 'OID_ESTRUC_SEC'
    end
    object TPuestosOID_VAL_CLASIF_PUE: TIntegerField
      FieldName = 'OID_VAL_CLASIF_PUE'
    end
    object TPuestosCODIGO: TStringField
      FieldName = 'CODIGO'
      Size = 50
    end
    object TPuestosDESCRIPCION: TStringField
      FieldName = 'DESCRIPCION'
      Size = 255
    end
    object TPuestosACTIVO: TBooleanField
      FieldName = 'ACTIVO'
    end
  end
  object dsPuestos: TDataSource
    DataSet = TPuestos
    Left = 160
    Top = 324
  end
  object TClasificadores: TsnTable
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
    Top = 428
    object TClasificadoresnro_clasif_emp: TIntegerField
      FieldName = 'nro_clasif_emp'
    end
    object TClasificadoresnro_clasif_sec: TIntegerField
      FieldName = 'nro_clasif_sec'
    end
    object TClasificadoresnro_clasif_pue: TIntegerField
      FieldName = 'nro_clasif_pue'
    end
    object TClasificadoresoid_clasif_emp: TIntegerField
      FieldName = 'oid_clasif_emp'
    end
    object TClasificadoresoid_clasif_sec: TIntegerField
      FieldName = 'oid_clasif_sec'
    end
    object TClasificadoresoid_clasif_pue: TIntegerField
      FieldName = 'oid_clasif_pue'
    end
  end
  object HelpValoresClasificadorEmp: THelpValoresClasificador
    AsignarCampoCodigo = TEmpresasCODIGO
    NroClasificador = 0
    Left = 72
    Top = 81
  end
  object HelpValoresClasificadorSec: THelpValoresClasificador
    AsignarCampoCodigo = TSectoresCODIGO
    NroClasificador = 0
    Left = 72
    Top = 121
  end
  object HelpValoresClasificadorPue: THelpValoresClasificador
    AsignarCampoCodigo = TPuestosCODIGO
    NroClasificador = 0
    Left = 72
    Top = 162
  end
  object TValorClaifEntidad: TsnTable
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
    Left = 462
    Top = 284
    object TValorClaifEntidadoid_valor_clasif_ent: TIntegerField
      FieldName = 'oid_valor_clasif_ent'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TValorClaifEntidadcodigo: TStringField
      FieldName = 'codigo'
      Size = 30
    end
    object TValorClaifEntidaddescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
    object TValorClaifEntidadoid_clasif_entidad: TIntegerField
      FieldName = 'oid_clasif_entidad'
    end
  end
end
