inherited TFEntVisita: TTFEntVisita
  Left = 15
  Top = 134
  Width = 1012
  Height = 748
  Caption = 'Entrada Visitas'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 996
    Height = 143
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 272
      Top = 48
      Width = 101
      Height = 20
      Caption = 'Nro. de Docu.:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label2: TLabel
      Left = 544
      Top = 48
      Width = 34
      Height = 20
      Caption = 'Tipo:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label3: TLabel
      Left = 672
      Top = 48
      Width = 68
      Height = 20
      Caption = 'Empresa:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object ImagenSalir: TImage
      Left = 26
      Top = 7
      Width = 33
      Height = 34
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      Proportional = True
      ShowHint = True
      Transparent = True
    end
    object Label6: TLabel
      Left = 24
      Top = 49
      Width = 53
      Height = 20
      Caption = '&Tarjeta:'
      FocusControl = srnDBButtonEdit3
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label7: TLabel
      Left = 272
      Top = 80
      Width = 89
      Height = 20
      Caption = 'Ape. y Nom.:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label8: TLabel
      Left = 272
      Top = 112
      Width = 50
      Height = 20
      Caption = 'Motivo:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object ImageNuevaVisita: TImage
      Left = 74
      Top = 7
      Width = 33
      Height = 34
      Cursor = crHandPoint
      Hint = 'Nueva Visita'
      ParentShowHint = False
      Proportional = True
      ShowHint = True
      Transparent = True
    end
    object ImageHabIng: TsnImage
      Left = 121
      Top = 7
      Width = 33
      Height = 35
      Cursor = crHandPoint
      Hint = 'Habilitar Ingreso Visita'
      Picture.Data = {
        055449636F6E0000010001002020100000000000E80200001600000028000000
        2000000040000000010004000000000080020000000000000000000000000000
        0000000000000000000080000080000000808000800000008000800080800000
        C0C0C000808080000000FF0000FF000000FFFF00FF000000FF00FF00FFFF0000
        FFFFFF0000000000000000000000000000000000000000000FFFFFFFFFFFFFF0
        0000000000000000F22222222222222F000000000000000F2222222222222222
        F0000000000000F222222222222222222F00000000000F222222222222222222
        22F000000000F2222222222222222222222F0000000F22222222222222222222
        2222F00000F22222222222222222222222222F000F22222FFFFFFF22222FFFFF
        F22222F00F2222FFFFFFFF2222FFFFFFFF2222F00F2222FF2222FF2222FF2222
        FF2222F00F2222FF2222FF2222FF2222FF2222F00F2222FF2222FF2222FF2222
        FF2222F00F2222FF2222FF2222FF2222FF2222F00F2222FF22FFFF2222FF2222
        FF2222F00F2222FF22FFFF2222FF2222FF2222F00F2222FF2222222222FF2222
        FF2222F00F2222FF2222222222FF2222FF2222F00F2222FF2222222222FF2222
        FF2222F00F2222FF2222FF2222FF2222FF2222F00F2222FFFFFFFF2222FFFFFF
        FF2222F00F22222FFFFFFF22222FFFFFF22222F000F222222222222222222222
        22222F00000F222222222222222222222222F0000000F2222222222222222222
        222F000000000F22222222222222222222F00000000000F22222222222222222
        2F0000000000000F2222222222222222F000000000000000F22222222222222F
        00000000000000000FFFFFFFFFFFFFF000000000000000000000000000000000
        00000000FF8001FFFF0000FFFE00007FFC00003FF800001FF000000FE0000007
        C000000380000001000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        80000001C0000003E0000007F000000FF800001FFC00003FFE00007FFF0000FF
        FF8001FF}
    end
    object srnDBButtonEdit1: TsrnDBButtonEdit
      Left = 376
      Top = 44
      DataBinding.DataField = 'nro_documento'
      DataBinding.DataSource = DSEntradaVisita
      ParentFont = False
      Properties.Buttons = <
        item
          Default = True
          Kind = bkEllipsis
        end>
      Properties.CharCase = ecUpperCase
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 1
      Help = HelpVisitas
      Width = 153
    end
    object snDBLookup1: TsnDBLookup
      Left = 584
      Top = 44
      DataBinding.DataField = 'oid_tipo_docu'
      DataBinding.DataSource = DSEntradaVisita
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'codigo'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSTipoDocu
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 2
      Width = 65
    end
    object srnDBButtonEdit2: TsrnDBButtonEdit
      Left = 744
      Top = 44
      DataBinding.DataField = 'empresa'
      DataBinding.DataSource = DSEntradaVisita
      ParentFont = False
      Properties.Buttons = <
        item
          Default = True
          Kind = bkEllipsis
        end>
      Properties.CharCase = ecUpperCase
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 3
      Help = HelpEmpresas
      Width = 233
    end
    object srnDBButtonEdit3: TsrnDBButtonEdit
      Left = 80
      Top = 45
      DataBinding.DataField = 'nro_tarjeta'
      DataBinding.DataSource = DSEntradaVisita
      ParentFont = False
      Properties.Buttons = <
        item
          Default = True
          Kind = bkEllipsis
        end>
      Properties.CharCase = ecUpperCase
      Properties.ClickKey = 112
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      Help = HelpTarjetas
      Width = 185
    end
    object snDBEdit1: TsnDBEdit
      Left = 376
      Top = 76
      DataBinding.DataField = 'ape_y_nom'
      DataBinding.DataSource = DSEntradaVisita
      ParentFont = False
      Properties.CharCase = ecUpperCase
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 4
      Width = 601
    end
    object snButton1: TsnButton
      Left = 24
      Top = 79
      Width = 241
      Height = 33
      Cursor = crHandPoint
      Caption = 'Buscar Visita con Tarjeta'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 6
      LookAndFeel.Kind = lfOffice11
    end
    object snDBLookup4: TsnDBLookup
      Left = 376
      Top = 108
      DataBinding.DataField = 'oid_motivo'
      DataBinding.DataSource = DSEntradaVisita
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSMotivos
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 5
      Width = 353
    end
    object BotonRefrescar: TsnButton
      Left = 768
      Top = 106
      Width = 137
      Height = 33
      Cursor = crHandPoint
      Caption = 'Refrescar'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 7
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 644
    Width = 996
    Height = 66
    Align = alBottom
    Color = clWindow
    TabOrder = 1
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 143
    Width = 996
    Height = 501
    Align = alClient
    Color = clWindow
    TabOrder = 2
    object Panel4: TPanel
      Left = 1
      Top = 1
      Width = 328
      Height = 499
      Align = alLeft
      Color = clWindow
      TabOrder = 0
      object Panel5: TPanel
        Left = 1
        Top = 1
        Width = 326
        Height = 26
        Align = alTop
        BevelOuter = bvNone
        Color = clWindow
        TabOrder = 0
        object LabelSacarFoto: TLabel
          Left = 16
          Top = 0
          Width = 76
          Height = 23
          Cursor = crHandPoint
          Caption = 'Sacar Foto'
          Font.Charset = ANSI_CHARSET
          Font.Color = clBlue
          Font.Height = -19
          Font.Name = 'Arial Narrow'
          Font.Style = [fsUnderline]
          ParentFont = False
        end
      end
      object Panel6: TPanel
        Left = 1
        Top = 27
        Width = 326
        Height = 471
        Align = alClient
        BevelOuter = bvNone
        Color = clWindow
        TabOrder = 1
        object FotoVisita: TsnImage
          Left = 18
          Top = 0
          Width = 286
          Height = 227
          Stretch = True
        end
        object snLabel1: TsnLabel
          Left = 16
          Top = 230
          Width = 289
          Height = 13
          Alignment = taCenter
          AutoSize = False
          Caption = 'Ultimo Ingreso / Egreso del Predio'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clBlue
          Font.Height = -11
          Font.Name = 'MS Sans Serif'
          Font.Style = []
          ParentFont = False
        end
        object snLabel2: TsnLabel
          Left = 16
          Top = 265
          Width = 289
          Height = 13
          Alignment = taCenter
          AutoSize = False
          Caption = 'Zona Actual'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clBlue
          Font.Height = -11
          Font.Name = 'MS Sans Serif'
          Font.Style = []
          ParentFont = False
        end
        object snLabel3: TsnLabel
          Left = 16
          Top = 300
          Width = 289
          Height = 13
          Alignment = taCenter
          AutoSize = False
          Caption = 'Acceso a'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clBlue
          Font.Height = -11
          Font.Name = 'MS Sans Serif'
          Font.Style = []
          ParentFont = False
        end
        object snDBEdit2: TsnDBEdit
          Left = 16
          Top = 242
          TabStop = False
          DataBinding.DataField = 'fec_hor_ent_sal_predio'
          DataBinding.DataSource = DSEntradaVisita
          Properties.Alignment.Horz = taCenter
          Properties.ReadOnly = True
          Style.Edges = []
          TabOrder = 0
          Width = 289
        end
        object snDBEdit3: TsnDBEdit
          Left = 16
          Top = 277
          TabStop = False
          DataBinding.DataField = 'zona_actual'
          DataBinding.DataSource = DSEntradaVisita
          Properties.Alignment.Horz = taCenter
          Properties.ReadOnly = True
          Style.Edges = []
          TabOrder = 1
          Width = 289
        end
        object snDBEdit4: TsnDBEdit
          Left = 16
          Top = 312
          TabStop = False
          DataBinding.DataField = 'categ_acc_int'
          DataBinding.DataSource = DSEntradaVisita
          Properties.Alignment.Horz = taCenter
          Properties.ReadOnly = True
          Style.Edges = []
          TabOrder = 2
          Width = 289
        end
      end
    end
    object Panel7: TPanel
      Left = 329
      Top = 1
      Width = 666
      Height = 499
      Align = alClient
      Color = clWindow
      TabOrder = 1
      object Panel8: TPanel
        Left = 1
        Top = 1
        Width = 664
        Height = 195
        Align = alTop
        Color = clWindow
        TabOrder = 0
        object Label4: TLabel
          Left = 24
          Top = 16
          Width = 56
          Height = 20
          Caption = 'Visita a:'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -16
          Font.Name = 'MS Sans Serif'
          Font.Style = []
          ParentFont = False
        end
        object Label5: TLabel
          Left = 24
          Top = 48
          Width = 63
          Height = 20
          Caption = 'Autoriza:'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -16
          Font.Name = 'MS Sans Serif'
          Font.Style = []
          ParentFont = False
        end
        object snDBLookup2: TsnDBLookup
          Left = 144
          Top = 12
          DataBinding.DataField = 'oid_visita_a'
          DataBinding.DataSource = DSEntradaVisita
          ParentFont = False
          Properties.KeyFieldNames = 'oid'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          Properties.ListSource = DSTVisitaA
          Style.Font.Charset = DEFAULT_CHARSET
          Style.Font.Color = clWindowText
          Style.Font.Height = -16
          Style.Font.Name = 'MS Sans Serif'
          Style.Font.Style = []
          Style.IsFontAssigned = True
          TabOrder = 0
          Width = 393
        end
        object snDBLookup3: TsnDBLookup
          Left = 144
          Top = 44
          DataBinding.DataField = 'oid_autoriza'
          DataBinding.DataSource = DSEntradaVisita
          ParentFont = False
          Properties.KeyFieldNames = 'oid'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          Properties.ListSource = dsTAutoriza
          Style.Font.Charset = DEFAULT_CHARSET
          Style.Font.Color = clWindowText
          Style.Font.Height = -16
          Style.Font.Name = 'MS Sans Serif'
          Style.Font.Style = []
          Style.IsFontAssigned = True
          TabOrder = 1
          Width = 393
        end
        object BotonAsignarTarjeta: TsnButton
          Left = 144
          Top = 89
          Width = 161
          Height = 33
          Cursor = crHandPoint
          Caption = 'Asignar TARJETA'
          Enabled = False
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -16
          Font.Name = 'MS Sans Serif'
          Font.Style = []
          ParentFont = False
          TabOrder = 2
          LookAndFeel.Kind = lfOffice11
        end
        object BotonIngreso: TsnButton
          Left = 24
          Top = 145
          Width = 140
          Height = 33
          Cursor = crHandPoint
          Caption = 'Ingres'#243
          Enabled = False
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -16
          Font.Name = 'MS Sans Serif'
          Font.Style = []
          ParentFont = False
          TabOrder = 3
          LookAndFeel.Kind = lfOffice11
        end
        object BotonDevolvioTarjeta: TsnButton
          Left = 184
          Top = 145
          Width = 140
          Height = 33
          Cursor = crHandPoint
          Caption = 'Devolvi'#243' Tarjeta'
          Enabled = False
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -16
          Font.Name = 'MS Sans Serif'
          Font.Style = []
          ParentFont = False
          TabOrder = 4
          LookAndFeel.Kind = lfOffice11
        end
        object BotonPerdioTarjeta: TsnButton
          Left = 344
          Top = 145
          Width = 140
          Height = 33
          Cursor = crHandPoint
          Caption = 'Perdi'#243' Tarjeta'
          Enabled = False
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -16
          Font.Name = 'MS Sans Serif'
          Font.Style = []
          ParentFont = False
          TabOrder = 5
          LookAndFeel.Kind = lfOffice11
        end
        object BotonEgreso: TsnButton
          Left = 501
          Top = 145
          Width = 140
          Height = 33
          Cursor = crHandPoint
          Caption = 'Egres'#243
          Enabled = False
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -16
          Font.Name = 'MS Sans Serif'
          Font.Style = []
          ParentFont = False
          TabOrder = 6
          LookAndFeel.Kind = lfOffice11
        end
      end
      object Panel9: TPanel
        Left = 1
        Top = 196
        Width = 664
        Height = 302
        Align = alClient
        Color = clWindow
        TabOrder = 1
        object dxDBGridSN1: TdxDBGridSN
          Left = 1
          Top = 1
          Width = 662
          Height = 300
          Align = alClient
          TabOrder = 0
          CriteriosPintarCelda = <>
          object dxDBGridSN1DBTableView1: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSTNovedadesVisita
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsData.CancelOnExit = False
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsData.Inserting = False
            OptionsView.CellAutoHeight = True
            OptionsView.GroupByBox = False
            Styles.Content = cxStyle1
            object dxDBGridSN1DBTableView1novedad: TcxGridDBColumn
              Caption = 'Novedad'
              DataBinding.FieldName = 'novedad'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Styles.Content = cxStyle1
              Styles.Header = cxStyle1
              Width = 504
            end
            object dxDBGridSN1DBTableView1accion: TcxGridDBColumn
              Caption = 'Acci'#243'n'
              DataBinding.FieldName = 'accion'
              PropertiesClassName = 'TcxButtonEditProperties'
              Properties.Buttons = <
                item
                  Default = True
                  Kind = bkEllipsis
                end>
              HeaderAlignmentHorz = taCenter
              Styles.Content = cxStyle1
              Styles.Header = cxStyle1
              Width = 103
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
    CargaDataSets = <
      item
        DataSet = TTarjAsig
        TableName = 'TTarjAsig'
      end
      item
        DataSet = TVisitasPorNroDocu
        TableName = 'TVisitasPorNroDocu'
      end
      item
        DataSet = TExisteEmpExacta
        TableName = 'TExisteEmpExacta'
      end
      item
        DataSet = TEmpresasLike
        TableName = 'TEmpresasLike'
      end
      item
        DataSet = TAsignoTarjA
        TableName = 'TAsignoTarjA'
      end
      item
        DataSet = TBotoneraVisita
        TableName = 'TBotoneraVisita'
      end
      item
        DataSet = TNovedadesVisita
        TableName = 'TNovedadesVisita'
      end>
    Left = 56
    Top = 176
  end
  inherited Operacion: TOperacion
    Left = 96
    Top = 176
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 136
    Top = 176
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 720
    Top = 34
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      '  srnDBButtonEdit3.setFoco();'
      'end.')
    OnValidate = <
      item
        TableName = 'TEntradaVisita'
        FieldName = 'nro_tarjeta'
        Source.Strings = (
          'begin'
          '  if (Trim(Sender.AsString)='#39#39')'
          '     then begin'
          '             TEntradaVisita.Close;'
          '             TEntradaVisita.Open;'
          '             TEntradaVisita.AppendRecord;  '
          '              FotoVisita.BorrarImagen();'
          '              setBotonera();'
          '              srnDBButtonEdit1.setEnable(true);'
          '              snDBLookup1.setEnable(true);'
          '              srnDBButtonEdit1.setFoco();'
          '             end'
          '    else  begin'
          '             ValidarNroTarj(Sender.AsString);'
          
            '            if (TTarjAsig.FieldName('#39'tarj_asig'#39').AsBoolean = fal' +
            'se)'
          '               then begin'
          '                       LimpiarDatos();'
          '                       setBotonera();'
          '                       srnDBButtonEdit1.setEnable(true);'
          '                       snDBLookup1.setEnable(true);'
          '                       srnDBButtonEdit1.setFoco();'
          '                       end'
          '              else  begin'
          '                       srnDBButtonEdit1.setEnable(true);'
          '                       snDBLookup1.setEnable(true);'
          '                       srnDBButtonEdit1.setFoco();'
          
            '                       if (TTarjAsig.FieldName('#39'oid_visita'#39').AsI' +
            'nteger>0)'
          '                           then begin'
          
            '                                    srnDBButtonEdit1.setEnable(f' +
            'alse);'
          
            '                                    snDBLookup1.setEnable(false)' +
            ';'
          '                                    srnDBButtonEdit2.setFoco();'
          
            '                                    VisitasPorOid(TTarjAsig.Fiel' +
            'dName('#39'oid_visita'#39').AsInteger);'
          '                                    setBotonera();'
          '                                    end;'
          '                       end;'
          '            end; '
          'end.')
      end
      item
        TableName = 'TEntradaVisita'
        FieldName = 'nro_documento'
        Source.Strings = (
          'begin'
          '  VisitasPorNroDocu(Sender.AsString);'
          '  if (TVisitasPorNroDocu.IsEmpty())'
          '      then begin'
          '              LimpiarDatosSinNroDocu();'
          '              end'
          '      else if (TVisitasPorNroDocu.count()=1)'
          '                then begin'
          '                        AsignarDatosVisita();'
          '                        TraerImagenVisita();'
          '                        end'
          '                else begin'
          
            '                        FormSelVisita.getDataSet('#39'TVisitasPorNro' +
            'Docu'#39').LoadDataSet(TVisitasPorNroDocu);'
          '                        FormSelVisita.Mostrar(true); '
          
            '                        if (FormSelVisita.getDataSet('#39'TInput'#39').F' +
            'ieldName('#39'acepto'#39').AsBoolean)'
          '                            then begin'
          '                                    TVisitasPorNroDocu.First;'
          
            '                                    TVisitasPorNroDocu.Locate('#39'o' +
            'id_visita'#39',FormSelVisita.getDataSet('#39'TVisitasPorNroDocu'#39').FieldN' +
            'ame('#39'oid_visita'#39').AsInteger,[]);'
          '                                    AsignarDatosVisita();'
          '                                    TraerImagenVisita();'
          '                                    end;'
          '                        end;'
          '   setBotonera();'
          'end.')
      end
      item
        TableName = 'TEntradaVisita'
        FieldName = 'empresa'
        Source.Strings = (
          'begin'
          'end.')
      end>
    OnChangeField = <
      item
        TableName = 'TEntradaVisita'
        FieldName = 'empresa'
        Source.Strings = (
          'begin'
          ' if (Trim(Sender.AsString)<>'#39#39')'
          '     then begin'
          ''
          '             ValidarSiExisteEmpExacta(Sender.AsString);'
          
            '             if (TExisteEmpExacta.FieldName('#39'existe'#39').AsBoolean)' +
            ' then exit;'
          ''
          '             TraerLikeEmpresas(Sender.AsString); '
          '             if (TEmpresasLike.count()>0)'
          '                then begin'
          
            '                        FormBuscarEmpCIP.setString('#39'empresa'#39',Sen' +
            'der.AsString);'
          '                        FormBuscarEmpCIP.Mostrar(true);'
          
            '                        if (FormBuscarEmpCIP.getDataSet('#39'TResult' +
            'ado'#39').FieldName('#39'valor'#39').AsString = '#39'SELECCIONAR'#39')'
          
            '                            then begin                          ' +
            '         '
          '                                    try'
          
            '                                       TEntradaVisita.desHabilit' +
            'arEventoOnChange('#39'empresa'#39');'
          
            '                                       TEntradaVisita.EditRecord' +
            ';'
          
            '                                       TEntradaVisita.FieldName(' +
            #39'empresa'#39').AsString := FormBuscarEmpCIP.getDataSet('#39'TEmpresasLik' +
            'e'#39').FieldName('#39'empresa'#39').AsString;'
          '                                    finally'
          
            '                                       TEntradaVisita.HabilitarE' +
            'ventoOnChange('#39'empresa'#39');'
          '                                    end; '
          ''
          '                                    end;'
          '                        end;'
          '             end;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '    TTipoDocumento.loadFromHelp('#39'HelpTipoDocu'#39');'
          '    TVisitaA.loadFromHelp('#39'HelpVisitaA'#39');'
          '    TAutoriza.loadFromHelp('#39'HelpAutoriza'#39');'
          '    TMotivos.loadFromHelp('#39'HelpMotivo'#39');'
          '    Inicializar();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure RefrescarTarjeta();'
          'begin'
          '  TEntradaVisita.EditRecord;'
          
            '  TEntradaVisita.FieldName('#39'nro_tarjeta'#39').AsInteger := TEntradaV' +
            'isita.FieldName('#39'nro_tarjeta'#39').AsInteger;'
          'end;'
          ''
          'procedure TraerImagenVisita();'
          'var'
          '  mensajeError : string;'
          '  nomTempFile : string;'
          'begin'
          '  if (TEntradaVisita.FieldName('#39'oid_visita'#39').AsInteger>0)'
          '    then begin'
          '            TRY'
          '              operacion.InicioOperacion();'
          '              operacion.setOper('#39'DownLoadFotoVisitaCIP'#39');  '
          
            '              nomTempFile := operacion.DownLoadFile(TEntradaVisi' +
            'ta.FieldName('#39'oid_visita'#39').AsString, mensajeError);'
          '              FotoVisita.LoadFromFile(nomTempFile);'
          '            EXCEPT'
          '            END;'
          '            end'
          '    else FotoVisita.BorrarImagen();'
          'end;'
          ''
          'procedure AsignarDatosVisita();'
          'begin'
          '  TEntradaVisita.EditRecord;'
          
            '  TEntradaVisita.FieldName('#39'oid_tarjeta'#39').AsInteger := TVisitasP' +
            'orNroDocu.FieldName('#39'oid_empresa'#39').AsInteger;'
          
            '  TEntradaVisita.FieldName('#39'empresa'#39').asString := TVisitasPorNro' +
            'Docu.FieldName('#39'empresa'#39').AsString;'
          
            '  TEntradaVisita.FieldName('#39'oid_visita_a'#39').AsInteger := TVisitas' +
            'PorNroDocu.FieldName('#39'oid_visita_a'#39').AsInteger;'
          
            '  TEntradaVisita.FieldName('#39'oid_autoriza'#39').AsInteger := TVisitas' +
            'PorNroDocu.FieldName('#39'oid_autoriza'#39').AsInteger;'
          
            '  TEntradaVisita.FieldName('#39'oid_visita'#39').AsInteger := TVisitasPo' +
            'rNroDocu.FieldName('#39'oid_visita'#39').AsInteger;'
          
            '  TEntradaVisita.FieldName('#39'oid_tipo_docu'#39').AsInteger := TVisita' +
            'sPorNroDocu.FieldName('#39'oid_tipo_docu'#39').AsInteger;'
          
            '  TEntradaVisita.FieldName('#39'asignar'#39').AsBoolean := TVisitasPorNr' +
            'oDocu.FieldName('#39'asignar'#39').AsBoolean;'
          
            '  TEntradaVisita.FieldName('#39'ingresar'#39').AsBoolean := TVisitasPorN' +
            'roDocu.FieldName('#39'ingresar'#39').AsBoolean;'
          
            '  TEntradaVisita.FieldName('#39'devolvio'#39').AsBoolean := TVisitasPorN' +
            'roDocu.FieldName('#39'devolvio'#39').AsBoolean;'
          
            '  TEntradaVisita.FieldName('#39'perdio'#39').AsBoolean := TVisitasPorNro' +
            'Docu.FieldName('#39'perdio'#39').AsBoolean;'
          
            '  TEntradaVisita.FieldName('#39'egreso'#39').AsBoolean := TVisitasPorNro' +
            'Docu.FieldName('#39'egreso'#39').AsBoolean;'
          
            '  TEntradaVisita.FieldName('#39'ape_y_nom'#39').AsString := TVisitasPorN' +
            'roDocu.FieldName('#39'ape_y_nom'#39').AsString;'
          
            '  TEntradaVisita.FieldName('#39'oid_motivo'#39').AsInteger := TVisitasPo' +
            'rNroDocu.FieldName('#39'oid_motivo'#39').AsInteger;'
          
            '  TEntradaVisita.FieldName('#39'fec_hor_ent_sal_predio'#39').AsString :=' +
            ' TVisitasPorNroDocu.FieldName('#39'fec_hor_ent_sal_predio'#39').AsString' +
            ';'
          
            '  TEntradaVisita.FieldName('#39'categ_acc_int'#39').AsString := TVisitas' +
            'PorNroDocu.FieldName('#39'categ_acc_int'#39').AsString;'
          
            '  TEntradaVisita.FieldName('#39'zona_actual'#39').AsString := TVisitasPo' +
            'rNroDocu.FieldName('#39'zona_actual'#39').AsString;'
          'end;'
          ''
          'procedure AsignarDatosVisitaDeTarjeta();'
          'begin'
          ''
          '  TEntradaVisita.desHabilitarEventoOnValidate('#39'nro_documento'#39');'
          '  TEntradaVisita.desHabilitarEventoOnValidate('#39'empresa'#39');'
          '  TEntradaVisita.desHabilitarEventoOnChange('#39'empresa'#39');'
          ''
          '   try'
          ''
          '  TEntradaVisita.EditRecord;'
          
            '  TEntradaVisita.FieldName('#39'oid_tarjeta'#39').AsInteger := TVisitasP' +
            'orNroDocu.FieldName('#39'oid_empresa'#39').AsInteger;'
          
            '  TEntradaVisita.FieldName('#39'empresa'#39').asString := TVisitasPorNro' +
            'Docu.FieldName('#39'empresa'#39').AsString;'
          
            '  TEntradaVisita.FieldName('#39'oid_visita_a'#39').AsInteger := TVisitas' +
            'PorNroDocu.FieldName('#39'oid_visita_a'#39').AsInteger;'
          
            '  TEntradaVisita.FieldName('#39'oid_autoriza'#39').AsInteger := TVisitas' +
            'PorNroDocu.FieldName('#39'oid_autoriza'#39').AsInteger;'
          
            '  TEntradaVisita.FieldName('#39'oid_visita'#39').AsInteger := TVisitasPo' +
            'rNroDocu.FieldName('#39'oid_visita'#39').AsInteger;'
          
            '  TEntradaVisita.FieldName('#39'oid_tipo_docu'#39').AsInteger := TVisita' +
            'sPorNroDocu.FieldName('#39'oid_tipo_docu'#39').AsInteger;'
          
            '  TEntradaVisita.FieldName('#39'asignar'#39').AsBoolean := TVisitasPorNr' +
            'oDocu.FieldName('#39'asignar'#39').AsBoolean;'
          
            '  TEntradaVisita.FieldName('#39'ingresar'#39').AsBoolean := TVisitasPorN' +
            'roDocu.FieldName('#39'ingresar'#39').AsBoolean;'
          
            '  TEntradaVisita.FieldName('#39'devolvio'#39').AsBoolean := TVisitasPorN' +
            'roDocu.FieldName('#39'devolvio'#39').AsBoolean;'
          
            '  TEntradaVisita.FieldName('#39'perdio'#39').AsBoolean := TVisitasPorNro' +
            'Docu.FieldName('#39'perdio'#39').AsBoolean;'
          
            '  TEntradaVisita.FieldName('#39'egreso'#39').AsBoolean := TVisitasPorNro' +
            'Docu.FieldName('#39'egreso'#39').AsBoolean;'
          
            '  TEntradaVisita.FieldName('#39'ape_y_nom'#39').AsString := TVisitasPorN' +
            'roDocu.FieldName('#39'ape_y_nom'#39').AsString;'
          
            '  TEntradaVisita.FieldName('#39'nro_documento'#39').AsString := TVisitas' +
            'PorNroDocu.FieldName('#39'nro_documento'#39').AsString;'
          
            '  TEntradaVisita.FieldName('#39'fec_hor_ent_sal_predio'#39').AsString :=' +
            ' TVisitasPorNroDocu.FieldName('#39'fec_hor_ent_sal_predio'#39').AsString' +
            ';'
          
            '  TEntradaVisita.FieldName('#39'categ_acc_int'#39').AsString := TVisitas' +
            'PorNroDocu.FieldName('#39'categ_acc_int'#39').AsString;'
          
            '  TEntradaVisita.FieldName('#39'zona_actual'#39').AsString := TVisitasPo' +
            'rNroDocu.FieldName('#39'zona_actual'#39').AsString;'
          ''
          '  finally'
          ''
          '  TEntradaVisita.HabilitarEventoOnValidate('#39'nro_documento'#39');'
          '  TEntradaVisita.HabilitarEventoOnValidate('#39'empresa'#39');'
          '  TEntradaVisita.HabilitarEventoOnChange('#39'empresa'#39');'
          ''
          '   end;'
          ''
          'end;'
          ''
          ''
          ''
          'procedure LimpiarDatosSinNroDocu();'
          'begin'
          '  TEntradaVisita.EditRecord;'
          '  TEntradaVisita.FieldName('#39'oid_tarjeta'#39').Clear;'
          '  TEntradaVisita.FieldName('#39'empresa'#39').Clear;'
          '  TEntradaVisita.FieldName('#39'oid_visita_a'#39').Clear;'
          '  TEntradaVisita.FieldName('#39'oid_autoriza'#39').Clear;'
          '  TEntradaVisita.FieldName('#39'oid_visita'#39').Clear;'
          '  TEntradaVisita.FieldName('#39'ape_y_nom'#39').Clear;'
          '  TEntradaVisita.FieldName('#39'oid_motivo'#39').Clear;'
          '  FotoVisita.BorrarImagen();'
          'end;'
          ''
          'procedure LimpiarDatos();'
          'begin'
          '  TEntradaVisita.EditRecord;'
          '  TEntradaVisita.FieldName('#39'nro_documento'#39').Clear;'
          '  TEntradaVisita.FieldName('#39'oid_tipo_docu'#39').Clear;'
          '  TEntradaVisita.FieldName('#39'oid_tarjeta'#39').Clear;'
          '  TEntradaVisita.FieldName('#39'empresa'#39').Clear;'
          '  TEntradaVisita.FieldName('#39'oid_visita_a'#39').Clear;'
          '  TEntradaVisita.FieldName('#39'oid_autoriza'#39').Clear;'
          '  TEntradaVisita.FieldName('#39'oid_visita'#39').Clear;'
          '  TEntradaVisita.FieldName('#39'ape_y_nom'#39').Clear;'
          '  TEntradaVisita.FieldName('#39'oid_motivo'#39').Clear;'
          '  FotoVisita.BorrarImagen();'
          'end;'
          ''
          'procedure validarDatosVisita();'
          'begin'
          
            '  if (Trim(TEntradaVisita.FieldName('#39'nro_documento'#39').AsString)='#39 +
            #39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Nro. de' +
            ' Documento'#39');'
          '  if (TEntradaVisita.FieldName('#39'oid_tipo_docu'#39').AsInteger = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Tipo de' +
            ' Documento'#39');'
          'end;'
          ''
          'procedure Inicializar();'
          'begin'
          '  Varios.setImagen('#39'ImagenSalir'#39',7); '
          '  Varios.setImagen('#39'ImageNuevaVisita'#39',8); '
          '  TEntradaVisita.Close;'
          '  TEntradaVisita.Open;'
          '  TEntradaVisita.AppendRecord;'
          'end;'
          ''
          'procedure AsignarTarjeta();'
          'begin'
          '  validarDatosVisita();'
          '  TEntradaVisita.PostRecord;'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'AsignarTarjVisita'#39');'
          
            '  operacion.AddAtribute('#39'computer_name'#39', varios.getComputerName(' +
            '));'
          '  operacion.AddDataSet(TEntradaVisita.getDataSet());'
          '  operacion.execute(); '
          'end;'
          ''
          'procedure ValidarNroTarj(Tarjeta : string);'
          'begin'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'FuncAltaVisita'#39');'
          '  operacion.AddAtribute('#39'tipo'#39','#39'VALIDAR_NRO_TARJ'#39');'
          '  operacion.AddAtribute('#39'nro_tarjeta'#39', Tarjeta);'
          '  operacion.execute();'
          ''
          '  TEntradaVisita.EditRecord;'
          
            '  TEntradaVisita.FieldName('#39'oid_tarjeta'#39').AsInteger := TTarjAsig' +
            '.FieldName('#39'oid_tarjeta'#39').AsInteger;'
          ''
          'end;'
          ''
          'procedure VisitasPorNroDocu(NroDocu : string);'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'FuncAltaVisita'#39');'
          '  operacion.AddAtribute('#39'tipo'#39','#39'VISITAS_POR_NRODOCU'#39');'
          '  operacion.AddAtribute('#39'nro_documento'#39', NroDocu);'
          '  operacion.execute();'
          'end;'
          ''
          ''
          'procedure AplicarBotones();'
          'begin'
          ''
          '  if (TEntradaVisita.FieldName('#39'asignar'#39').AsBoolean)'
          '     then BotonAsignarTarjeta.setEnable(true)'
          '     else  BotonAsignarTarjeta.setEnable(false);'
          ''
          '  if (TEntradaVisita.FieldName('#39'ingresar'#39').AsBoolean)'
          '     then BotonIngreso.setEnable(true)'
          '     else  BotonIngreso.setEnable(false);'
          ''
          '  if (TEntradaVisita.FieldName('#39'devolvio'#39').AsBoolean)'
          '     then BotonDevolvioTarjeta.setEnable(true)'
          '     else  BotonDevolvioTarjeta.setEnable(false);'
          ''
          '  if (TEntradaVisita.FieldName('#39'perdio'#39').AsBoolean)'
          '     then BotonPerdioTarjeta.setEnable(true)'
          '     else  BotonPerdioTarjeta.setEnable(false);'
          ''
          '  if (TEntradaVisita.FieldName('#39'egreso'#39').AsBoolean)'
          '     then BotonEgreso.setEnable(true)'
          '     else  BotonEgreso.setEnable(false);'
          '  '
          'end;'
          ''
          'procedure TraerLikeEmpresas(Empresa : string);'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerConciEmpCIP'#39');'
          '  operacion.AddAtribute('#39'empresa'#39',Empresa);'
          '  operacion.execute();'
          'end;'
          ''
          'procedure ValidarSiExisteEmpExacta(Empresa : string);'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'ValidarEmpresaCIP'#39');'
          '  operacion.AddAtribute('#39'empresa'#39',Empresa);'
          '  operacion.execute();'
          'end;'
          ''
          'procedure grabarImagenVisita(OidVisita : integer);'
          'var'
          '  mensajeError : string;'
          'begin'
          'TRY'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'UploadImageFotoVisita'#39');'
          '  operacion.UploadFile('
          '        FotoVisita.getDataStream(),'
          '        IntToStr(OidVisita),'
          '        '#39#39','#39#39',true,mensajeError);'
          'EXCEPT'
          'END;'
          'end;'
          ''
          'procedure VisitasPorOid(Oid : integer);'
          'begin'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'FuncAltaVisita'#39');'
          '  operacion.AddAtribute('#39'tipo'#39','#39'VISITAS_POR_NRODOCU'#39');'
          '  operacion.AddAtribute('#39'oid_visita'#39', IntToStr(Oid));'
          '  operacion.execute();'
          ''
          '  AsignarDatosVisitaDeTarjeta();'
          '  TraerImagenVisita();'
          '  AplicarBotones();'
          ''
          'end;'
          ''
          'procedure setBotonera();'
          'begin'
          ''
          'TRY'
          ''
          'operacion.InicioOperacion();'
          'operacion.setOper('#39'FuncAltaVisita'#39');'
          'operacion.AddAtribute('#39'tipo'#39','#39'DETERMINAR_BOTONERA'#39');'
          
            'operacion.AddAtribute('#39'nro_tarjeta'#39', TEntradaVisita.FieldName('#39'n' +
            'ro_tarjeta'#39').AsString);'
          
            'operacion.AddAtribute('#39'oid_tipo_docu'#39', IntToStr(TEntradaVisita.F' +
            'ieldName('#39'oid_tipo_docu'#39').AsInteger));'
          
            'operacion.AddAtribute('#39'nro_documento'#39', TEntradaVisita.FieldName(' +
            #39'nro_documento'#39').AsString);'
          'operacion.execute();'
          ''
          'BotonIngreso.setEnable(false);'
          'BotonDevolvioTarjeta.setEnable(false);'
          'BotonPerdioTarjeta.setEnable(false);'
          'BotonEgreso.setEnable(false);'
          'BotonAsignarTarjeta.setEnable(false);'
          ''
          'if (TBotoneraVisita.IsEmpty) then exit;'
          ''
          'if (TBotoneraVisita.FieldName('#39'ingreso'#39').AsBoolean)'
          '   then BotonIngreso.setEnable(true)'
          '   else BotonIngreso.setEnable(false);'
          ''
          'if (TBotoneraVisita.FieldName('#39'devolvio'#39').AsBoolean)'
          '   then BotonDevolvioTarjeta.setEnable(true)'
          '   else BotonDevolvioTarjeta.setEnable(false);'
          ''
          'if (TBotoneraVisita.FieldName('#39'perdio'#39').AsBoolean)'
          '   then BotonPerdioTarjeta.setEnable(true)'
          '   else BotonPerdioTarjeta.setEnable(false);'
          ''
          'if (TBotoneraVisita.FieldName('#39'egreso'#39').AsBoolean)'
          '   then BotonEgreso.setEnable(true)'
          '   else BotonEgreso.setEnable(false);'
          ''
          'if (TBotoneraVisita.FieldName('#39'asignar'#39').AsBoolean)'
          '   then BotonAsignarTarjeta.setEnable(true)'
          '   else BotonAsignarTarjeta.setEnable(false);'
          ''
          'EXCEPT'
          'END;'
          ''
          'end;'
          ''
          'procedure DevolvioTarjeta();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'DevolvioTarjVisita'#39');'
          
            '  operacion.AddAtribute('#39'nro_tarjeta'#39',TEntradaVisita.FieldName('#39 +
            'nro_tarjeta'#39').AsString);'
          '  operacion.execute();'
          'end;'
          ''
          'procedure PerdioTarjeta();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'PerdioTarjVisita'#39');'
          
            '  operacion.AddAtribute('#39'nro_tarjeta'#39',TEntradaVisita.FieldName('#39 +
            'nro_tarjeta'#39').AsString);'
          '  operacion.execute();'
          'end;'
          ''
          
            'procedure IngresoVisitaManual(nroTarjeta : string ; nombre : str' +
            'ing);'
          'begin'
          '  operacion.inicioOperacion();'
          '  operacion.setOper('#39'IngresoVisitaManual'#39');'
          '  operacion.AddAtribute('#39'nro_tarjeta'#39',nroTarjeta);'
          '  operacion.AddAtribute('#39'nombre_maquina'#39',nombre);'
          '  operacion.execute();'
          'end;'
          ''
          
            'procedure EgresoVisitaManual(nroTarjeta : string ; nombre : stri' +
            'ng);'
          'begin'
          '  operacion.inicioOperacion();'
          '  operacion.setOper('#39'EgresoVisitaManual'#39');'
          '  operacion.AddAtribute('#39'nro_tarjeta'#39',nroTarjeta);'
          '  operacion.AddAtribute('#39'nombre_maquina'#39',nombre);'
          '  operacion.execute();'
          'end;'
          ''
          'procedure validarAltaPermVisita();'
          'begin'
          '  if (TEntradaVisita.FieldName('#39'oid_visita'#39').AsInteger = 0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la Visita' +
            #39');'
          
            '  if (FormularioHabIng.getDataSet('#39'TInput'#39').FieldName('#39'oid_punto' +
            '_acceso'#39').AsInteger<=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Punto d' +
            'e Acceso'#39');'
          
            '  if (FormularioHabIng.getDataSet('#39'TInput'#39').FieldName('#39'fecha'#39').I' +
            'sNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha'#39')' +
            ';'
          
            '  if (Trim(FormularioHabIng.getDataSet('#39'TInput'#39').FieldName('#39'hora' +
            '_desde'#39').AsString)='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la hora de' +
            'sde'#39');'
          
            '  if (Trim(FormularioHabIng.getDataSet('#39'TInput'#39').FieldName('#39'hora' +
            '_hasta'#39').AsString)='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la hora ha' +
            'sta'#39');'
          'end;'
          ''
          'procedure altaPermisoVisita();'
          'begin'
          '  operacion.inicioOperacion();'
          '  operacion.setOper('#39'FuncIngManualVisita'#39');'
          '  operacion.AddAtribute('#39'ALTA_VISITA_MANU'#39','#39#39');'
          
            '  operacion.AddAtribute('#39'oid_visita'#39', TEntradaVisita.FieldName('#39 +
            'oid_visita'#39').AsString);'
          
            '  if (FormularioHabIng.getDataSet('#39'TInput'#39').FieldName('#39'oid_motiv' +
            'o'#39').AsInteger>0)'
          
            '     then operacion.AddAtribute('#39'oid_motivo'#39', FormularioHabIng.g' +
            'etDataSet('#39'TInput'#39').FieldName('#39'oid_motivo'#39').AsString);'
          
            '  operacion.AddAtribute('#39'oid_punto_acceso'#39', FormularioHabIng.get' +
            'DataSet('#39'TInput'#39').FieldName('#39'oid_punto_acceso'#39').AsString);'
          
            '  operacion.AddAtribute('#39'fecha'#39', FormularioHabIng.getDataSet('#39'TI' +
            'nput'#39').FieldName('#39'fecha'#39').AsString); '
          
            '  operacion.AddAtribute('#39'hora_desde'#39', FormularioHabIng.getDataSe' +
            't('#39'TInput'#39').FieldName('#39'hora_desde'#39').AsString); '
          
            '  operacion.AddAtribute('#39'hora_hasta'#39', FormularioHabIng.getDataSe' +
            't('#39'TInput'#39').FieldName('#39'hora_hasta'#39').AsString); '
          
            '  operacion.AddAtribute('#39'observacion'#39', FormularioHabIng.getDataS' +
            'et('#39'TInput'#39').FieldName('#39'observacion'#39').AsString); '
          
            '  if (FormularioHabIng.getDataSet('#39'TInput'#39').FieldName('#39'oid_visit' +
            'a_a'#39').AsInteger > 0)'
          
            '      then operacion.AddAtribute('#39'oid_visita_a'#39', FormularioHabIn' +
            'g.getDataSet('#39'TInput'#39').FieldName('#39'oid_visita_a'#39').AsString); '
          
            '  if (FormularioHabIng.getDataSet('#39'TInput'#39').FieldName('#39'oid_autor' +
            'iza'#39').AsInteger>0)'
          
            '      then operacion.AddAtribute('#39'oid_autoriza'#39', FormularioHabIn' +
            'g.getDataSet('#39'TInput'#39').FieldName('#39'oid_autoriza'#39').AsString); '
          '  operacion.execute();'
          'end;'
          ''
          ''
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'LabelSacarFoto'
        Source.Strings = (
          'begin'
          '  FormSacarFoto.Mostrar(true);'
          
            '  FotoVisita.LoadFromField(FormSacarFoto.getDataSet('#39'TInput'#39').Fi' +
            'eldName('#39'foto'#39'));'
          'end.')
      end
      item
        ButtonName = 'ImagenSalir'
        Source.Strings = (
          'begin'
          '  close();'
          'end.')
      end
      item
        ButtonName = 'BotonAsignarTarjeta'
        Source.Strings = (
          'begin'
          '  TAsignoTarjA.Close;'
          '  TAsignoTarjA.Open;'
          '  AsignarTarjeta();'
          '  if (TAsignoTarjA.FieldName('#39'oid_visita'#39').AsInteger>0)'
          
            '     then grabarImagenVisita(TAsignoTarjA.FieldName('#39'oid_visita'#39 +
            ').AsInteger);'
          '  RefrescarTarjeta();'
          '  setBotonera();  '
          'end.')
      end
      item
        ButtonName = 'snButton1'
        Source.Strings = (
          'begin'
          ''
          '  HelpVisitasConTarj.Mostrar();'
          '  if (HelpVisitasConTarj.Acepto)'
          '     then begin'
          '             TEntradaVisita.EditRecord;'
          
            '             TEntradaVisita.FieldName('#39'nro_tarjeta'#39').AsInteger  ' +
            ':=  StrToInt(HelpVisitasConTarj.TableHelp.FieldName('#39'codigo'#39').As' +
            'String);'
          '              end;'
          ''
          ''
          ''
          'end.')
      end
      item
        ButtonName = 'BotonDevolvioTarjeta'
        Source.Strings = (
          'begin'
          '  DevolvioTarjeta();'
          '  TEntradaVisita.EditRecord;'
          '  TEntradaVisita.FieldName('#39'nro_tarjeta'#39').Clear();'
          '  setBotonera();'
          '  srnDBButtonEdit3.setFoco();'
          'end.')
      end
      item
        ButtonName = 'BotonPerdioTarjeta'
        Source.Strings = (
          'begin'
          
            '  if (mensaje.question('#39'Confirma que la visita *** PERDIO *** la' +
            ' TARJETA?'#39')=false) then exit;'
          '  PerdioTarjeta();'
          ' TEntradaVisita.EditRecord;'
          ' TEntradaVisita.FieldName('#39'nro_tarjeta'#39').Clear();'
          '  setBotonera();'
          '  srnDBButtonEdit3.setFoco();'
          'end.')
      end
      item
        ButtonName = 'BotonRefrescar'
        Source.Strings = (
          'begin'
          '  refrescarTarjeta();'
          'end.')
      end
      item
        ButtonName = 'BotonIngreso'
        Source.Strings = (
          'begin'
          
            '  IngresoVisitaManual(TEntradaVisita.FieldName('#39'nro_tarjeta'#39').As' +
            'String,Varios.getComputerName());'
          ' TEntradaVisita.EditRecord;'
          ' TEntradaVisita.FieldName('#39'nro_tarjeta'#39').Clear();'
          '  setBotonera();'
          '  srnDBButtonEdit3.setFoco();'
          'end.')
      end
      item
        ButtonName = 'BotonEgreso'
        Source.Strings = (
          'begin'
          
            '  EgresoVisitaManual(TEntradaVisita.FieldName('#39'nro_tarjeta'#39').AsS' +
            'tring,Varios.getComputerName());'
          ' TEntradaVisita.EditRecord;'
          
            ' TEntradaVisita.FieldName('#39'nro_tarjeta'#39').AsInteger := TEntradaVi' +
            'sita.FieldName('#39'nro_tarjeta'#39').AsInteger;'
          '  setBotonera();'
          '  srnDBButtonEdit3.setFoco();'
          'end.')
      end
      item
        ButtonName = 'ImageNuevaVisita'
        Source.Strings = (
          'begin'
          '  TEntradaVisita.Close;'
          '  TEntradaVisita.Open;'
          '  TEntradaVisita.AppendRecord; '
          '  srnDBButtonEdit1.setEnable(true);'
          '  snDBLookup1.setEnable(true);'
          '  srnDBButtonEdit3.setFoco();'
          '  FotoVisita.BorrarImagen();'
          '  setBotonera();'
          'end.')
      end
      item
        ButtonName = 'ImageHabIng'
        Source.Strings = (
          'begin'
          '  FormularioHabIng.Mostrar(true);'
          
            '  if (FormularioHabIng.getDataSet('#39'TInput'#39').FieldName('#39'acepto'#39').' +
            'AsBoolean)'
          '     then begin'
          '             validarAltaPermVisita();'
          '             altaPermisoVisita();             '
          '             end;'
          'end.')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'dxDBGridSN1DBTableView1accion'
        Source.Strings = (
          'begin'
          '  if (mensaje.question('#39'Desea eliminar la Novedad.?'#39'))'
          '     then begin'
          '             end; '
          'end.')
      end>
    OnClickButtonEdit = <
      item
        ButtonEdit = 'srnDBButtonEdit1'
        Source.Strings = (
          'begin'
          '  HelpVisitas.Mostrar();'
          'end.')
      end>
    Left = 752
    Top = 35
  end
  inherited SaveArchivo: TSaveDialog
    Top = 208
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Top = 240
  end
  object TEntradaVisita: TsnTable
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
    Left = 384
    Top = 293
    object TEntradaVisitanro_documento: TStringField
      FieldName = 'nro_documento'
      Size = 50
    end
    object TEntradaVisitaoid_tipo_docu: TIntegerField
      FieldName = 'oid_tipo_docu'
    end
    object TEntradaVisitaoid_tarjeta: TIntegerField
      FieldName = 'oid_tarjeta'
    end
    object TEntradaVisitaempresa: TStringField
      FieldName = 'empresa'
      Size = 100
    end
    object TEntradaVisitaoid_visita_a: TIntegerField
      FieldName = 'oid_visita_a'
    end
    object TEntradaVisitaoid_autoriza: TIntegerField
      FieldName = 'oid_autoriza'
    end
    object TEntradaVisitaoid_visita: TIntegerField
      FieldName = 'oid_visita'
    end
    object TEntradaVisitaasignar: TBooleanField
      FieldName = 'asignar'
    end
    object TEntradaVisitaingresar: TBooleanField
      FieldName = 'ingresar'
    end
    object TEntradaVisitadevolvio: TBooleanField
      FieldName = 'devolvio'
    end
    object TEntradaVisitaperdio: TBooleanField
      FieldName = 'perdio'
    end
    object TEntradaVisitaegreso: TBooleanField
      FieldName = 'egreso'
    end
    object TEntradaVisitaape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TEntradaVisitaoid_motivo: TIntegerField
      FieldName = 'oid_motivo'
    end
    object TEntradaVisitafec_hor_ent_sal_predio: TStringField
      FieldName = 'fec_hor_ent_sal_predio'
      Size = 100
    end
    object TEntradaVisitazona_actual: TStringField
      FieldName = 'zona_actual'
      Size = 100
    end
    object TEntradaVisitanro_tarjeta: TIntegerField
      FieldName = 'nro_tarjeta'
    end
    object TEntradaVisitacateg_acc_int: TStringField
      FieldName = 'categ_acc_int'
      Size = 50
    end
  end
  object HelpTipoDocu: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 've.TipoDocumento'
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
    Titulo = 'Tipos de Documentos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 218
    Top = 111
  end
  object TTipoDocumento: TsnTable
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
    Left = 255
    Top = 111
    object TTipoDocumentooid: TIntegerField
      FieldName = 'oid'
    end
    object TTipoDocumentocodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTipoDocumentodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTipoDocu: TDataSource
    DataSet = TTipoDocumento
    Left = 288
    Top = 112
  end
  object DSEntradaVisita: TDataSource
    DataSet = TEntradaVisita
    Left = 416
    Top = 293
  end
  object HelpVisitas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.Visita'
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
        Longitud = 50
        Visible = True
        AsignarACampo = TEntradaVisitanro_documento
        KeyField = False
        AnchoEnCaracteres = 50
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
    Titulo = 'Visitas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 218
    Top = 151
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 784
    Top = 37
  end
  object FormSacarFoto: TFormulario
    Nombre = 'TFSacarFotoVisita'
    CreateAlwaysANewForm = False
    Left = 216
    Top = 195
  end
  object HelpVisitaA: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
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
    Titulo = 'Visita'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 218
    Top = 276
  end
  object TVisitaA: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexFieldNames = 'descripcion'
    IndexDefs = <
      item
        Name = 'TVisitaAIndex1'
        Fields = 'descripcion'
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
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 255
    Top = 276
    object IntegerField1: TIntegerField
      FieldName = 'oid'
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
  object HelpAutoriza: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
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
    Titulo = 'Autorizadores'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 218
    Top = 315
  end
  object TAutoriza: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexFieldNames = 'descripcion'
    IndexDefs = <
      item
        Name = 'TAutorizaIndex1'
        Fields = 'descripcion'
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
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 255
    Top = 315
    object IntegerField2: TIntegerField
      FieldName = 'oid'
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
  object DSTVisitaA: TDataSource
    DataSet = TVisitaA
    Left = 290
    Top = 277
  end
  object dsTAutoriza: TDataSource
    DataSet = TAutoriza
    Left = 290
    Top = 316
  end
  object TTarjAsig: TsnTable
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
    Left = 641
    Top = 254
    object TTarjAsigtarj_asig: TBooleanField
      FieldName = 'tarj_asig'
    end
    object TTarjAsigoid_tarjeta: TIntegerField
      FieldName = 'oid_tarjeta'
    end
    object TTarjAsigoid_visita: TIntegerField
      FieldName = 'oid_visita'
    end
  end
  object TVisitasPorNroDocu: TsnTable
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
    Left = 641
    Top = 286
    object TVisitasPorNroDocuoid_visita: TIntegerField
      FieldName = 'oid_visita'
    end
    object TVisitasPorNroDocuoid_tipo_docu: TIntegerField
      FieldName = 'oid_tipo_docu'
    end
    object TVisitasPorNroDocucod_tipo_docu: TStringField
      FieldName = 'cod_tipo_docu'
    end
    object TVisitasPorNroDocunro_documento: TStringField
      FieldName = 'nro_documento'
      Size = 50
    end
    object TVisitasPorNroDocuoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TVisitasPorNroDocuempresa: TStringField
      FieldName = 'empresa'
      Size = 100
    end
    object TVisitasPorNroDocuoid_visita_a: TIntegerField
      FieldName = 'oid_visita_a'
    end
    object TVisitasPorNroDocuoid_autoriza: TIntegerField
      FieldName = 'oid_autoriza'
    end
    object TVisitasPorNroDocuasignar: TBooleanField
      FieldName = 'asignar'
    end
    object TVisitasPorNroDocuingresar: TBooleanField
      FieldName = 'ingresar'
    end
    object TVisitasPorNroDocudevolvio: TBooleanField
      FieldName = 'devolvio'
    end
    object TVisitasPorNroDocuperdio: TBooleanField
      FieldName = 'perdio'
    end
    object TVisitasPorNroDocuegreso: TBooleanField
      FieldName = 'egreso'
    end
    object TVisitasPorNroDocuape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TVisitasPorNroDocuoid_motivo: TIntegerField
      FieldName = 'oid_motivo'
    end
    object TVisitasPorNroDocufec_hor_ent_sal_predio: TStringField
      FieldName = 'fec_hor_ent_sal_predio'
      Size = 100
    end
    object TVisitasPorNroDocuzona_actual: TStringField
      FieldName = 'zona_actual'
      Size = 100
    end
    object TVisitasPorNroDocucateg_acc_int: TStringField
      FieldName = 'categ_acc_int'
      Size = 100
    end
  end
  object DSVisitasPorNroDocu: TDataSource
    DataSet = TVisitasPorNroDocu
    Left = 673
    Top = 286
  end
  object FormSelVisita: TFormulario
    Nombre = 'TFSelVisita'
    CreateAlwaysANewForm = False
    Left = 216
    Top = 236
  end
  object FormBuscarEmpCIP: TFormulario
    Nombre = 'TFBuscarEmpCIP'
    CreateAlwaysANewForm = False
    Left = 223
    Top = 363
  end
  object TEmpresasLike: TsnTable
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
    Left = 641
    Top = 321
    object TEmpresasLikeoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TEmpresasLikeempresa: TStringField
      FieldName = 'empresa'
      Size = 100
    end
  end
  object TExisteEmpExacta: TsnTable
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
    Left = 641
    Top = 353
    object TExisteEmpExactaexiste: TBooleanField
      FieldName = 'existe'
    end
  end
  object TAsignoTarjA: TsnTable
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
    Left = 593
    Top = 369
    object TAsignoTarjAoid_visita: TIntegerField
      FieldName = 'oid_visita'
    end
  end
  object TBotoneraVisita: TsnTable
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
    Left = 745
    Top = 361
    object TBotoneraVisitaingreso: TBooleanField
      FieldName = 'ingreso'
    end
    object TBotoneraVisitadevolvio: TBooleanField
      FieldName = 'devolvio'
    end
    object TBotoneraVisitaperdio: TBooleanField
      FieldName = 'perdio'
    end
    object TBotoneraVisitaegreso: TBooleanField
      FieldName = 'egreso'
    end
    object TBotoneraVisitaasignar: TBooleanField
      FieldName = 'asignar'
    end
  end
  object HelpVisitasConTarj: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.Visita'
    NroHelp = 104
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
    Titulo = 'Visitas con Tarjetas Asignadas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 223
    Top = 399
  end
  object HelpMotivo: TsnHelp
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
    Titulo = 'Motivos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 226
    Top = 438
  end
  object TMotivos: TsnTable
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
    Left = 263
    Top = 438
    object IntegerField3: TIntegerField
      FieldName = 'oid'
    end
    object StringField5: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField6: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSMotivos: TDataSource
    DataSet = TMotivos
    Left = 296
    Top = 439
  end
  object HelpTarjetas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.TarjetaCIP'
    NroHelp = 104
    Campos = <
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 50
        Visible = True
        AsignarACampo = TEntradaVisitanro_tarjeta
        KeyField = False
        AnchoEnCaracteres = 50
        ActivarFiltro = True
        Sorted = scUp
      end
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
    Titulo = 'Tarjetas para Visitas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 260
    Top = 151
  end
  object HelpEmpresas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.EmpresaCIP'
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
        AsignarACampo = TEntradaVisitaempresa
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 50
        Visible = False
        KeyField = False
        AnchoEnCaracteres = 50
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
    Titulo = 'Empresa'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 895
    Top = 31
  end
  object FormularioHabIng: TFormulario
    Nombre = 'TFHabIngVis'
    CreateAlwaysANewForm = False
    Left = 32
    Top = 115
  end
  object TNovedadesVisita: TsnTable
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
    Left = 362
    Top = 364
    object TNovedadesVisitanovedad: TStringField
      FieldName = 'novedad'
      Size = 1000
    end
    object TNovedadesVisitaaccion: TStringField
      FieldName = 'accion'
      ReadOnly = True
    end
    object TNovedadesVisitaoid_permiso_visita: TIntegerField
      FieldName = 'oid_permiso_visita'
    end
  end
  object DSTNovedadesVisita: TDataSource
    DataSet = TNovedadesVisita
    Left = 394
    Top = 364
  end
  object cxStyleRepository1: TcxStyleRepository
    PixelsPerInch = 96
    object cxStyle1: TcxStyle
      AssignedValues = [svFont]
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
    end
  end
end
