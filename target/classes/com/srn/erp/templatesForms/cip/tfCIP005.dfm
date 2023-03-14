inherited FPuerta: TFPuerta
  Left = 35
  Top = 103
  Width = 1028
  Height = 651
  Caption = 'Placa Controladora de Puntos de Acceso'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 1012
    Height = 613
    inherited PPie: TPanel
      Top = 592
      Width = 1012
      inherited StatusBarABM: TStatusBar
        Left = 907
      end
      inherited StatusBar2: TStatusBar
        Width = 907
      end
    end
    inherited PMenu: TPanel
      Width = 1012
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSPuertas
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSPuertas
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpPuertas
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpPuertas
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpPuertas
      end
      inherited Panel2: TPanel
        Left = 971
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSPuertas
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
      Width = 1012
    end
    inherited PCabecera: TPanel
      Width = 1012
      Height = 5
    end
    inherited PCuerpo: TPanel
      Top = 57
      Width = 1012
      Height = 535
      object Label1: TLabel
        Left = 40
        Top = 8
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 280
        Top = 8
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object snLabel1: TsnLabel
        Left = 40
        Top = 88
        Width = 58
        Height = 13
        Caption = 'Direcci'#243'n IP'
      end
      object snLabel2: TsnLabel
        Left = 608
        Top = 88
        Width = 94
        Height = 13
        Caption = 'Identificador Equipo'
      end
      object snLabel15: TsnLabel
        Left = 40
        Top = 120
        Width = 306
        Height = 13
        Caption = 'Intervalo en segundos para enviar mensaje de estado al Servidor'
      end
      object snLabel16: TsnLabel
        Left = 40
        Top = 144
        Width = 295
        Height = 13
        Caption = 'Intervalo en segundos para pedir nuevamente la configuraci'#243'n'
      end
      object snLabel17: TsnLabel
        Left = 40
        Top = 168
        Width = 288
        Height = 13
        Caption = 'Intervalo en segundos para sincronizar la Lista Blanca/Negra'
      end
      object snLabel32: TsnLabel
        Left = 320
        Top = 88
        Width = 31
        Height = 13
        Caption = 'Puerto'
      end
      object snLabel33: TsnLabel
        Left = 432
        Top = 88
        Width = 84
        Height = 13
        Caption = 'Puerto Comandos'
      end
      object snLabel34: TsnLabel
        Left = 464
        Top = 120
        Width = 105
        Height = 13
        Caption = 'Modo Funcionamiento'
      end
      object DBECodigo: TsnDBEdit
        Left = 124
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSPuertas
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBEdit1: TsnDBEdit
        Left = 364
        Top = 4
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSPuertas
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 120
        Top = 32
        Caption = 'Acceso al Predio'
        DataBinding.DataField = 'acceso_al_predio'
        DataBinding.DataSource = DSPuertas
        TabOrder = 2
        Width = 121
      end
      object snDBCheckEdit2: TsnDBCheckEdit
        Left = 232
        Top = 32
        Caption = 'Egreso del Predio'
        DataBinding.DataField = 'egreso_del_predio'
        DataBinding.DataSource = DSPuertas
        TabOrder = 3
        Width = 113
      end
      object snDBEdit2: TsnDBEdit
        Left = 123
        Top = 84
        DataBinding.DataField = 'IP'
        DataBinding.DataSource = DSPuertas
        TabOrder = 6
        Width = 182
      end
      object snDBEdit3: TsnDBEdit
        Left = 718
        Top = 84
        DataBinding.DataField = 'identif_puerta'
        DataBinding.DataSource = DSPuertas
        TabOrder = 9
        Width = 86
      end
      object snDBEdit6: TsnDBEdit
        Left = 363
        Top = 116
        DataBinding.DataField = 'int_status_time'
        DataBinding.DataSource = DSPuertas
        TabOrder = 10
        Width = 86
      end
      object snDBEdit7: TsnDBEdit
        Left = 363
        Top = 140
        DataBinding.DataField = 'int_config_time'
        DataBinding.DataSource = DSPuertas
        TabOrder = 11
        Width = 86
      end
      object snDBEdit8: TsnDBEdit
        Left = 363
        Top = 164
        DataBinding.DataField = 'int_syncrotime'
        DataBinding.DataSource = DSPuertas
        TabOrder = 12
        Width = 86
      end
      object snDBCheckEdit3: TsnDBCheckEdit
        Left = 368
        Top = 32
        Caption = 'Habilitar Punto de Acceso 1'
        DataBinding.DataField = 'hab_punto_acc_1'
        DataBinding.DataSource = DSPuertas
        Properties.ValueChecked = 1
        Properties.ValueUnchecked = 0
        TabOrder = 4
        Width = 161
      end
      object snDBCheckEdit4: TsnDBCheckEdit
        Left = 536
        Top = 32
        Caption = 'Habilitar Punto de Acceso 2'
        DataBinding.DataField = 'hab_punto_acc_2'
        DataBinding.DataSource = DSPuertas
        Properties.ValueChecked = 1
        Properties.ValueUnchecked = 0
        TabOrder = 5
        Width = 161
      end
      object snDBEdit15: TsnDBEdit
        Left = 355
        Top = 84
        DataBinding.DataField = 'puerto'
        DataBinding.DataSource = DSPuertas
        TabOrder = 7
        Width = 62
      end
      object snDBEdit16: TsnDBEdit
        Left = 523
        Top = 84
        DataBinding.DataField = 'puerto_tele'
        DataBinding.DataSource = DSPuertas
        TabOrder = 8
        Width = 62
      end
      object snDBLookup13: TsnDBLookup
        Left = 576
        Top = 117
        DataBinding.DataField = 'mode'
        DataBinding.DataSource = DSPuertas
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTModosFunc
        TabOrder = 13
        Width = 265
      end
      object snDBCheckEdit9: TsnDBCheckEdit
        Left = 573
        Top = 144
        Caption = 'Pedir configuraci'#243'n ante un Evento de Status'
        DataBinding.DataField = 'pedir_config'
        DataBinding.DataSource = DSPuertas
        TabOrder = 14
        Width = 268
      end
      object snDBCheckEdit12: TsnDBCheckEdit
        Left = 573
        Top = 168
        Caption = 'Iniciar Telecomandos al arrancar comunicaci'#243'n'
        DataBinding.DataField = 'iniciar_tele'
        DataBinding.DataSource = DSPuertas
        TabOrder = 15
        Width = 268
      end
      object PageControlSN1: TPageControlSN
        Left = 40
        Top = 192
        Width = 964
        Height = 337
        ActivePage = TabSheet1
        TabOrder = 16
        object TabSheet1: TTabSheet
          Caption = 'Entrada'
          object snLabel3: TsnLabel
            Left = 8
            Top = 5
            Width = 105
            Height = 24
            AutoSize = False
            Caption = '    Entrada'
            Color = clTeal
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clBlack
            Font.Height = -19
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentColor = False
            ParentFont = False
          end
          object snLabel5: TsnLabel
            Left = 8
            Top = 44
            Width = 29
            Height = 13
            Caption = 'Medio'
          end
          object snLabel6: TsnLabel
            Left = 8
            Top = 66
            Width = 119
            Height = 13
            Caption = 'Identificador Pto. Acceso'
          end
          object snLabel7: TsnLabel
            Left = 8
            Top = 90
            Width = 99
            Height = 13
            Caption = 'Identificar Legajo por'
          end
          object snLabel37: TsnLabel
            Left = 286
            Top = 90
            Width = 39
            Height = 13
            Caption = 'Traducir'
          end
          object snLabel8: TsnLabel
            Left = 8
            Top = 113
            Width = 45
            Height = 13
            Caption = 'Protocolo'
          end
          object snLabel13: TsnLabel
            Left = 8
            Top = 136
            Width = 74
            Height = 13
            Caption = 'Modo OFFLINE'
          end
          object snLabel35: TsnLabel
            Left = 247
            Top = 137
            Width = 60
            Height = 13
            Caption = 'Alimentaci'#243'n'
          end
          object snLabel18: TsnLabel
            Left = 424
            Top = 12
            Width = 269
            Height = 13
            Caption = 'Intervalo en Segundos que el punto permanecer'#225' abierto'
          end
          object snLabel19: TsnLabel
            Left = 424
            Top = 25
            Width = 144
            Height = 13
            Caption = 'mientras no se efectue el pase'
          end
          object snLabel22: TsnLabel
            Left = 424
            Top = 40
            Width = 259
            Height = 13
            Caption = 'Tiempo en segundos en que si no se cierra el punto de'
          end
          object snLabel23: TsnLabel
            Left = 424
            Top = 53
            Width = 244
            Height = 13
            Caption = 'acceso, se emitir'#225' un evento y se activar'#225' la alarma'
          end
          object snLabel26: TsnLabel
            Left = 424
            Top = 72
            Width = 164
            Height = 13
            Caption = 'Intervalo para sincronizar el equipo'
          end
          object snLabel28: TsnLabel
            Left = 424
            Top = 92
            Width = 45
            Height = 13
            Caption = 'Direcci'#243'n'
          end
          object snLabel30: TsnLabel
            Left = 424
            Top = 116
            Width = 67
            Height = 13
            Caption = 'Tipo de Punto'
          end
          object snLabel45: TsnLabel
            Left = 8
            Top = 162
            Width = 64
            Height = 13
            Caption = 'Sale de Zona'
          end
          object snLabel46: TsnLabel
            Left = 360
            Top = 162
            Width = 59
            Height = 13
            Caption = 'entra a zona'
          end
          object snDBCheckEdit10: TsnDBCheckEdit
            Left = 133
            Top = 7
            Caption = 'Liberar Entrada Legajo'
            DataBinding.DataField = 'liberar_entrada'
            DataBinding.DataSource = DSPuertas
            Properties.ValueChecked = 'True'
            Properties.ValueUnchecked = 'False'
            TabOrder = 0
            Width = 134
          end
          object snDBLookup1: TsnDBLookup
            Left = 136
            Top = 41
            DataBinding.DataField = 'tipo_medio_ent'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSMediosAcceso
            TabOrder = 4
            Width = 265
          end
          object snDBEdit4: TsnDBEdit
            Left = 136
            Top = 64
            DataBinding.DataField = 'identif_ent'
            DataBinding.DataSource = DSPuertas
            TabOrder = 5
            Width = 86
          end
          object snDBLookup2: TsnDBLookup
            Left = 136
            Top = 87
            DataBinding.DataField = 'identif_leg_ent'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSIdentifLeg
            TabOrder = 6
            Width = 145
          end
          object snDBLookup16: TsnDBLookup
            Left = 328
            Top = 87
            DataBinding.DataField = 'inter_nro_ent'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSInterpretarNro
            TabOrder = 7
            Width = 81
          end
          object snDBLookup3: TsnDBLookup
            Left = 136
            Top = 110
            DataBinding.DataField = 'protocolo_ent'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSProtocolosCIP
            TabOrder = 8
            Width = 273
          end
          object snDBLookup7: TsnDBLookup
            Left = 136
            Top = 133
            DataBinding.DataField = 'modo_off_line_ent'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSModosOFFLine
            TabOrder = 9
            Width = 105
          end
          object snDBLookup14: TsnDBLookup
            Left = 320
            Top = 133
            DataBinding.DataField = 'tipo_alim_lb_ent'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSTiposAlimen
            TabOrder = 10
            Width = 89
          end
          object snDBEdit9: TsnDBEdit
            Left = 704
            Top = 14
            DataBinding.DataField = 'ctimeout_ent'
            DataBinding.DataSource = DSPuertas
            TabOrder = 11
            Width = 86
          end
          object snDBEdit11: TsnDBEdit
            Left = 704
            Top = 41
            DataBinding.DataField = 'otimeout_ent'
            DataBinding.DataSource = DSPuertas
            TabOrder = 12
            Width = 86
          end
          object snDBEdit13: TsnDBEdit
            Left = 704
            Top = 68
            DataBinding.DataField = 'alarmtime_ent'
            DataBinding.DataSource = DSPuertas
            TabOrder = 13
            Width = 86
          end
          object snDBLookup9: TsnDBLookup
            Left = 552
            Top = 89
            DataBinding.DataField = 'dir_pto_ent'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSTDirecciones
            TabOrder = 14
            Width = 238
          end
          object snDBLookup11: TsnDBLookup
            Left = 552
            Top = 112
            DataBinding.DataField = 'tipo_punto_ent'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSTTiposPuntos
            TabOrder = 15
            Width = 237
          end
          object snDBCheckEdit6: TsnDBCheckEdit
            Left = 548
            Top = 135
            Caption = 'Pulsador de Apertura Manual Habilitado'
            DataBinding.DataField = 'penable_ent'
            DataBinding.DataSource = DSPuertas
            Properties.ValueChecked = 1
            Properties.ValueUnchecked = 0
            TabOrder = 16
            Width = 237
          end
          object snDBCheckEdit5: TsnDBCheckEdit
            Left = 421
            Top = 135
            Caption = 'Buz'#243'n Habilitado'
            DataBinding.DataField = 'benable_ent'
            DataBinding.DataSource = DSPuertas
            Properties.ValueChecked = 1
            Properties.ValueUnchecked = 0
            TabOrder = 17
            Width = 121
          end
          object snDBLookup20: TsnDBLookup
            Left = 136
            Top = 159
            DataBinding.DataField = 'entrada_sale_de'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'oid'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSZonas
            TabOrder = 18
            Width = 200
          end
          object snDBLookup21: TsnDBLookup
            Left = 424
            Top = 159
            DataBinding.DataField = 'entrada_entra_a'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'oid'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSZonas
            TabOrder = 19
            Width = 200
          end
          object snDBCheckEdit14: TsnDBCheckEdit
            Left = 133
            Top = 191
            Caption = 'Controlar Antipassback Entrada'
            DataBinding.DataField = 'antipassback_ent'
            DataBinding.DataSource = DSPuertas
            TabOrder = 20
            Width = 188
          end
          object snDBCheckEdit16: TsnDBCheckEdit
            Left = 317
            Top = 191
            Caption = 'Controlar Cacheo a la Entrada'
            DataBinding.DataField = 'cacheo_ent'
            DataBinding.DataSource = DSPuertas
            TabOrder = 21
            Width = 188
          end
          object snDBCheckEdit18: TsnDBCheckEdit
            Left = 509
            Top = 191
            Caption = 'Registrar Ult. Mov. Entrada'
            DataBinding.DataField = 'reg_mov_ult_ent'
            DataBinding.DataSource = DSPuertas
            TabOrder = 22
            Width = 188
          end
          object snDBCheckEdit20: TsnDBCheckEdit
            Left = 269
            Top = 7
            Caption = 'Restringir Entrada Legajo'
            DataBinding.DataField = 'restringir_ent'
            DataBinding.DataSource = DSPuertas
            Properties.ValueChecked = 'True'
            Properties.ValueUnchecked = 'False'
            TabOrder = 1
            Width = 156
          end
          object snDBCheckEdit22: TsnDBCheckEdit
            Left = 269
            Top = 23
            Caption = 'Restringir Entrada Visita'
            DataBinding.DataField = 'restri_ent_vis'
            DataBinding.DataSource = DSPuertas
            Properties.ValueChecked = 'True'
            Properties.ValueUnchecked = 'False'
            TabOrder = 3
            Width = 140
          end
          object snDBCheckEdit23: TsnDBCheckEdit
            Left = 133
            Top = 23
            Caption = 'Liberar Entrada Visita'
            DataBinding.DataField = 'lib_ent_vis'
            DataBinding.DataSource = DSPuertas
            Properties.ValueChecked = 'True'
            Properties.ValueUnchecked = 'False'
            TabOrder = 2
            Width = 134
          end
        end
        object TabSheet2: TTabSheet
          Caption = 'Salida'
          ImageIndex = 1
          object snLabel4: TsnLabel
            Left = 2
            Top = 5
            Width = 105
            Height = 24
            AutoSize = False
            Caption = '    Salida'
            Color = clTeal
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clBlack
            Font.Height = -19
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentColor = False
            ParentFont = False
          end
          object snLabel9: TsnLabel
            Left = 2
            Top = 44
            Width = 29
            Height = 13
            Caption = 'Medio'
          end
          object snLabel10: TsnLabel
            Left = 2
            Top = 66
            Width = 119
            Height = 13
            Caption = 'Identificador Pto. Acceso'
          end
          object snLabel11: TsnLabel
            Left = 2
            Top = 90
            Width = 99
            Height = 13
            Caption = 'Identificar Legajo por'
          end
          object snLabel38: TsnLabel
            Left = 272
            Top = 90
            Width = 39
            Height = 13
            Caption = 'Traducir'
          end
          object snLabel12: TsnLabel
            Left = 2
            Top = 113
            Width = 45
            Height = 13
            Caption = 'Protocolo'
          end
          object snLabel14: TsnLabel
            Left = 2
            Top = 136
            Width = 74
            Height = 13
            Caption = 'Modo OFFLINE'
          end
          object snLabel36: TsnLabel
            Left = 241
            Top = 137
            Width = 60
            Height = 13
            Caption = 'Alimentaci'#243'n'
          end
          object snLabel20: TsnLabel
            Left = 418
            Top = 14
            Width = 269
            Height = 13
            Caption = 'Intervalo en Segundos que el punto permanecer'#225' abierto'
          end
          object snLabel21: TsnLabel
            Left = 418
            Top = 27
            Width = 144
            Height = 13
            Caption = 'mientras no se efectue el pase'
          end
          object snLabel24: TsnLabel
            Left = 418
            Top = 39
            Width = 259
            Height = 13
            Caption = 'Tiempo en segundos en que si no se cierra el punto de'
          end
          object snLabel25: TsnLabel
            Left = 418
            Top = 52
            Width = 244
            Height = 13
            Caption = 'acceso, se emitir'#225' un evento y se activar'#225' la alarma'
          end
          object snLabel27: TsnLabel
            Left = 418
            Top = 71
            Width = 164
            Height = 13
            Caption = 'Intervalo para sincronizar el equipo'
          end
          object snLabel29: TsnLabel
            Left = 418
            Top = 92
            Width = 45
            Height = 13
            Caption = 'Direcci'#243'n'
          end
          object snLabel31: TsnLabel
            Left = 418
            Top = 116
            Width = 67
            Height = 13
            Caption = 'Tipo de Punto'
          end
          object snLabel47: TsnLabel
            Left = 2
            Top = 162
            Width = 64
            Height = 13
            Caption = 'Sale de Zona'
          end
          object snLabel48: TsnLabel
            Left = 354
            Top = 162
            Width = 59
            Height = 13
            Caption = 'entra a zona'
          end
          object snDBCheckEdit11: TsnDBCheckEdit
            Left = 127
            Top = 7
            Caption = 'Liberar Salida Legajo'
            DataBinding.DataField = 'liberar_salida'
            DataBinding.DataSource = DSPuertas
            Properties.ValueChecked = 'True'
            Properties.ValueUnchecked = 'False'
            TabOrder = 0
            Width = 126
          end
          object snDBLookup4: TsnDBLookup
            Left = 130
            Top = 41
            DataBinding.DataField = 'tipo_medio_sal'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSMediosAcceso
            TabOrder = 3
            Width = 265
          end
          object snDBEdit5: TsnDBEdit
            Left = 130
            Top = 64
            DataBinding.DataField = 'identif_sal'
            DataBinding.DataSource = DSPuertas
            TabOrder = 4
            Width = 86
          end
          object snDBLookup5: TsnDBLookup
            Left = 130
            Top = 87
            DataBinding.DataField = 'identif_leg_sal'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSIdentifLeg
            TabOrder = 5
            Width = 129
          end
          object snDBLookup17: TsnDBLookup
            Left = 314
            Top = 87
            DataBinding.DataField = 'inter_nro_sal'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSInterpretarNro
            TabOrder = 6
            Width = 81
          end
          object snDBLookup6: TsnDBLookup
            Left = 130
            Top = 110
            DataBinding.DataField = 'protocolo_sal'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSProtocolosCIP
            TabOrder = 7
            Width = 265
          end
          object snDBLookup8: TsnDBLookup
            Left = 130
            Top = 133
            DataBinding.DataField = 'modo_off_line_sal'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSModosOFFLine
            TabOrder = 8
            Width = 97
          end
          object snDBLookup15: TsnDBLookup
            Left = 306
            Top = 133
            DataBinding.DataField = 'tipo_alim_lb_sal'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSTiposAlimen
            TabOrder = 9
            Width = 89
          end
          object snDBEdit10: TsnDBEdit
            Left = 698
            Top = 14
            DataBinding.DataField = 'ctimeout_sal'
            DataBinding.DataSource = DSPuertas
            TabOrder = 10
            Width = 86
          end
          object snDBEdit12: TsnDBEdit
            Left = 698
            Top = 42
            DataBinding.DataField = 'otimeout_sal'
            DataBinding.DataSource = DSPuertas
            TabOrder = 11
            Width = 86
          end
          object snDBEdit14: TsnDBEdit
            Left = 698
            Top = 68
            DataBinding.DataField = 'alarmtime_sal'
            DataBinding.DataSource = DSPuertas
            TabOrder = 12
            Width = 86
          end
          object snDBLookup10: TsnDBLookup
            Left = 546
            Top = 89
            DataBinding.DataField = 'dir_pto_sal'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSTDirecciones
            TabOrder = 13
            Width = 238
          end
          object snDBLookup12: TsnDBLookup
            Left = 546
            Top = 113
            DataBinding.DataField = 'tipo_punto_sal'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSTTiposPuntos
            TabOrder = 14
            Width = 238
          end
          object snDBCheckEdit8: TsnDBCheckEdit
            Left = 540
            Top = 137
            Caption = 'Pulsador de Apertura Manual Habilitado'
            DataBinding.DataField = 'penable_sal'
            DataBinding.DataSource = DSPuertas
            Properties.ValueChecked = 1
            Properties.ValueUnchecked = 0
            TabOrder = 15
            Width = 237
          end
          object snDBCheckEdit7: TsnDBCheckEdit
            Left = 413
            Top = 137
            Caption = 'Buz'#243'n Habilitado'
            DataBinding.DataField = 'benable_sal'
            DataBinding.DataSource = DSPuertas
            Properties.ValueChecked = 1
            Properties.ValueUnchecked = 0
            TabOrder = 16
            Width = 121
          end
          object snDBLookup22: TsnDBLookup
            Left = 130
            Top = 159
            DataBinding.DataField = 'salida_sale_de'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'oid'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSZonas
            TabOrder = 17
            Width = 200
          end
          object snDBLookup23: TsnDBLookup
            Left = 418
            Top = 159
            DataBinding.DataField = 'salida_entra_a'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'oid'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSZonas
            TabOrder = 18
            Width = 200
          end
          object snDBCheckEdit15: TsnDBCheckEdit
            Left = 129
            Top = 190
            Caption = 'Controlar Antipassback Salida'
            DataBinding.DataField = 'antipassback_sal'
            DataBinding.DataSource = DSPuertas
            TabOrder = 19
            Width = 172
          end
          object snDBCheckEdit17: TsnDBCheckEdit
            Left = 317
            Top = 190
            Caption = 'Controlar Cacheo a la Salida'
            DataBinding.DataField = 'cacheo_sal'
            DataBinding.DataSource = DSPuertas
            TabOrder = 20
            Width = 188
          end
          object snDBCheckEdit19: TsnDBCheckEdit
            Left = 509
            Top = 191
            Caption = 'Registrar Ult. Mov. Salida'
            DataBinding.DataField = 'reg_mov_ult_sal'
            DataBinding.DataSource = DSPuertas
            TabOrder = 21
            Width = 188
          end
          object snDBCheckEdit21: TsnDBCheckEdit
            Left = 263
            Top = 7
            Caption = 'Restringir Salida Legajo'
            DataBinding.DataField = 'restringir_sal'
            DataBinding.DataSource = DSPuertas
            Properties.ValueChecked = 'True'
            Properties.ValueUnchecked = 'False'
            TabOrder = 1
            Width = 121
          end
          object snDBCheckEdit24: TsnDBCheckEdit
            Left = 127
            Top = 23
            Caption = 'Liberar Salida Visita'
            DataBinding.DataField = 'lib_sal_vis'
            DataBinding.DataSource = DSPuertas
            Properties.ValueChecked = 'True'
            Properties.ValueUnchecked = 'False'
            TabOrder = 2
            Width = 126
          end
          object snDBCheckEdit25: TsnDBCheckEdit
            Left = 264
            Top = 23
            Caption = 'Retiene Tarjeta al Salir'
            DataBinding.DataField = 'traga_tarj_sal'
            DataBinding.DataSource = DSPuertas
            Properties.ValueChecked = 'True'
            Properties.ValueUnchecked = 'False'
            TabOrder = 22
            Width = 138
          end
        end
        object TabSheet3: TTabSheet
          Caption = 'Cacheo'
          ImageIndex = 2
          object snLabel39: TsnLabel
            Left = 8
            Top = 38
            Width = 205
            Height = 13
            Caption = 'Avisar del Cacheo a los siguientes Usuarios'
          end
          object snLabel40: TsnLabel
            Left = 339
            Top = 38
            Width = 257
            Height = 13
            Caption = 'Avisar del Cacheo a los siguientes Grupos de Usuarios'
          end
          object snLabel41: TsnLabel
            Left = 8
            Top = 134
            Width = 212
            Height = 13
            Caption = 'Avisar del Cacheo a las Siguientes M'#225'quinas'
          end
          object snLabel42: TsnLabel
            Left = 340
            Top = 134
            Width = 262
            Height = 13
            Caption = 'Avisar del Cacheo a los siguientes Grupos de M'#225'quinas'
          end
          object snLabel43: TsnLabel
            Left = 8
            Top = 10
            Width = 96
            Height = 13
            Caption = 'Cacheo a la entrada'
          end
          object snLabel44: TsnLabel
            Left = 336
            Top = 10
            Width = 87
            Height = 13
            Caption = 'Cacheo a la salida'
          end
          object dxDBGridSN1: TdxDBGridSN
            Left = 8
            Top = 54
            Width = 321
            Height = 73
            TabOrder = 2
            CriteriosPintarCelda = <>
            object dxDBGridSN1DBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSTAvisoUsuario
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoInsertOnNewItemRowFocusing]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object dxDBGridSN1DBTableView1cod_usuario: TcxGridDBColumn
                Caption = 'Usuario'
                DataBinding.FieldName = 'cod_usuario'
                PropertiesClassName = 'TcxButtonEditProperties'
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                HeaderAlignmentHorz = taCenter
                Width = 111
              end
              object dxDBGridSN1DBTableView1desc_usuario: TcxGridDBColumn
                Caption = 'Apellido y Nombre'
                DataBinding.FieldName = 'desc_usuario'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Options.Focusing = False
                Width = 168
              end
              object dxDBGridSN1DBTableView1Column1: TcxGridDBColumn
                Caption = 'A.'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                Width = 20
              end
            end
            object dxDBGridSN1Level1: TcxGridLevel
              GridView = dxDBGridSN1DBTableView1
            end
          end
          object dxDBGridSN2: TdxDBGridSN
            Left = 339
            Top = 54
            Width = 326
            Height = 73
            TabOrder = 3
            CriteriosPintarCelda = <>
            object cxGridDBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSTAvisoGUsuario
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoInsertOnNewItemRowFocusing]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object cxGridDBColumn1: TcxGridDBColumn
                Caption = 'Grupo'
                DataBinding.FieldName = 'cod_grupo_usuario'
                PropertiesClassName = 'TcxButtonEditProperties'
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                HeaderAlignmentHorz = taCenter
                Width = 111
              end
              object cxGridDBColumn2: TcxGridDBColumn
                Caption = 'Nombre'
                DataBinding.FieldName = 'desc_grupo_usuario'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Options.Focusing = False
                Width = 168
              end
              object cxGridDBTableView1Column1: TcxGridDBColumn
                Caption = 'A.'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                Width = 20
              end
            end
            object cxGridLevel1: TcxGridLevel
              GridView = cxGridDBTableView1
            end
          end
          object dxDBGridSN3: TdxDBGridSN
            Left = 8
            Top = 150
            Width = 321
            Height = 81
            TabOrder = 4
            CriteriosPintarCelda = <>
            object cxGridDBTableView2: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSTAvisoMaquina
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoInsertOnNewItemRowFocusing]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object cxGridDBColumn3: TcxGridDBColumn
                Caption = 'M'#225'quina'
                DataBinding.FieldName = 'cod_maquina'
                PropertiesClassName = 'TcxButtonEditProperties'
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                HeaderAlignmentHorz = taCenter
                Width = 111
              end
              object cxGridDBColumn4: TcxGridDBColumn
                Caption = 'Nombre'
                DataBinding.FieldName = 'desc_maquina'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Options.Focusing = False
                Width = 168
              end
              object cxGridDBColumn5: TcxGridDBColumn
                Caption = 'A.'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                Width = 20
              end
            end
            object cxGridLevel2: TcxGridLevel
              GridView = cxGridDBTableView2
            end
          end
          object dxDBGridSN4: TdxDBGridSN
            Left = 340
            Top = 150
            Width = 321
            Height = 81
            TabOrder = 5
            CriteriosPintarCelda = <>
            object cxGridDBTableView3: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSTAvisoGMaquina
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoInsertOnNewItemRowFocusing]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object cxGridDBColumn6: TcxGridDBColumn
                Caption = 'Grupo de M'#225'quina'
                DataBinding.FieldName = 'cod_grupo_maquina'
                PropertiesClassName = 'TcxButtonEditProperties'
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                HeaderAlignmentHorz = taCenter
                Width = 111
              end
              object cxGridDBColumn7: TcxGridDBColumn
                Caption = 'Nombre'
                DataBinding.FieldName = 'desc_grupo_maquina'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Options.Focusing = False
                Width = 168
              end
              object cxGridDBColumn8: TcxGridDBColumn
                Caption = 'A.'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                Width = 20
              end
            end
            object cxGridLevel3: TcxGridLevel
              GridView = cxGridDBTableView3
            end
          end
          object snDBLookup18: TsnDBLookup
            Left = 112
            Top = 6
            DataBinding.DataField = 'ingreso_cacheo'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSTTipoCacheoEntrada
            TabOrder = 0
            Width = 193
          end
          object snDBLookup19: TsnDBLookup
            Left = 432
            Top = 6
            DataBinding.DataField = 'egreso_cacheo'
            DataBinding.DataSource = DSPuertas
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = dsTTipoCacheoSalida
            TabOrder = 1
            Width = 193
          end
        end
        object TabSheet4: TTabSheet
          Caption = 'Avisos Acceso Denegado'
          ImageIndex = 3
          object snLabel49: TsnLabel
            Left = 8
            Top = 134
            Width = 244
            Height = 13
            Caption = 'Avisar acceso denegado a las Siguientes M'#225'quinas'
          end
          object snLabel50: TsnLabel
            Left = 8
            Top = 38
            Width = 237
            Height = 13
            Caption = 'Avisar acceso denegado a los siguientes Usuarios'
          end
          object snLabel51: TsnLabel
            Left = 339
            Top = 38
            Width = 289
            Height = 13
            Caption = 'Avisar acceso denegado a los siguientes Grupos de Usuarios'
          end
          object snLabel52: TsnLabel
            Left = 340
            Top = 134
            Width = 294
            Height = 13
            Caption = 'Avisar acceso denegado a los siguientes Grupos de M'#225'quinas'
          end
          object dxDBGridSN5: TdxDBGridSN
            Left = 8
            Top = 150
            Width = 321
            Height = 81
            TabOrder = 1
            CriteriosPintarCelda = <>
            object cxGridDBTableView4: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSTAvisoMaquinaAD
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoInsertOnNewItemRowFocusing]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object cxGridDBColumn9: TcxGridDBColumn
                Caption = 'M'#225'quina'
                DataBinding.FieldName = 'cod_maquina'
                PropertiesClassName = 'TcxButtonEditProperties'
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                HeaderAlignmentHorz = taCenter
                Width = 111
              end
              object cxGridDBColumn10: TcxGridDBColumn
                Caption = 'Nombre'
                DataBinding.FieldName = 'desc_maquina'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Options.Focusing = False
                Width = 168
              end
              object cxGridDBColumn11: TcxGridDBColumn
                Caption = 'A.'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                Width = 20
              end
            end
            object cxGridLevel4: TcxGridLevel
              GridView = cxGridDBTableView4
            end
          end
          object dxDBGridSN6: TdxDBGridSN
            Left = 8
            Top = 54
            Width = 321
            Height = 73
            TabOrder = 2
            CriteriosPintarCelda = <>
            object cxGridDBTableView5: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSTAvisoUsuarioAD
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoInsertOnNewItemRowFocusing]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object cxGridDBColumn12: TcxGridDBColumn
                Caption = 'Usuario'
                DataBinding.FieldName = 'cod_usuario'
                PropertiesClassName = 'TcxButtonEditProperties'
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                HeaderAlignmentHorz = taCenter
                Width = 111
              end
              object cxGridDBColumn13: TcxGridDBColumn
                Caption = 'Apellido y Nombre'
                DataBinding.FieldName = 'desc_usuario'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Options.Focusing = False
                Width = 168
              end
              object cxGridDBColumn14: TcxGridDBColumn
                Caption = 'A.'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                Width = 20
              end
            end
            object cxGridLevel5: TcxGridLevel
              GridView = cxGridDBTableView5
            end
          end
          object dxDBGridSN7: TdxDBGridSN
            Left = 339
            Top = 54
            Width = 326
            Height = 73
            TabOrder = 3
            CriteriosPintarCelda = <>
            object cxGridDBTableView6: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSTAvisoGUsuarioAD
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoInsertOnNewItemRowFocusing]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object cxGridDBColumn15: TcxGridDBColumn
                Caption = 'Grupo'
                DataBinding.FieldName = 'cod_grupo_usuario'
                PropertiesClassName = 'TcxButtonEditProperties'
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                HeaderAlignmentHorz = taCenter
                Width = 111
              end
              object cxGridDBColumn16: TcxGridDBColumn
                Caption = 'Nombre'
                DataBinding.FieldName = 'desc_grupo_usuario'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Options.Focusing = False
                Width = 168
              end
              object cxGridDBColumn17: TcxGridDBColumn
                Caption = 'A.'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                Width = 20
              end
            end
            object cxGridLevel6: TcxGridLevel
              GridView = cxGridDBTableView6
            end
          end
          object dxDBGridSN8: TdxDBGridSN
            Left = 340
            Top = 150
            Width = 321
            Height = 81
            TabOrder = 4
            CriteriosPintarCelda = <>
            object cxGridDBTableView7: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSTAvisoGMaquinaAD
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoInsertOnNewItemRowFocusing]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object cxGridDBColumn18: TcxGridDBColumn
                Caption = 'Grupo de M'#225'quina'
                DataBinding.FieldName = 'cod_grupo_maquina'
                PropertiesClassName = 'TcxButtonEditProperties'
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                HeaderAlignmentHorz = taCenter
                Width = 111
              end
              object cxGridDBColumn19: TcxGridDBColumn
                Caption = 'Nombre'
                DataBinding.FieldName = 'desc_grupo_maquina'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Options.Focusing = False
                Width = 168
              end
              object cxGridDBColumn20: TcxGridDBColumn
                Caption = 'A.'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                Width = 20
              end
            end
            object cxGridLevel7: TcxGridLevel
              GridView = cxGridDBTableView7
            end
          end
          object snDBCheckEdit13: TsnDBCheckEdit
            Left = 16
            Top = 8
            Caption = 'Activar avisos Acceso Denegado Entrada'
            DataBinding.DataField = 'act_avi_acc_den'
            DataBinding.DataSource = DSPuertas
            TabOrder = 0
            Width = 233
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerPuerta'
    OperGrabarObjeto = 'SavePuerta'
    CargaDataSets = <
      item
        DataSet = TPuertas
        TableName = 'TPuertas'
      end
      item
        DataSet = TMediosAcceso
        TableName = 'TMediosAcceso'
      end
      item
        DataSet = TIdentifLeg
        TableName = 'TIdentifLeg'
      end
      item
        DataSet = TProtocolosCIP
        TableName = 'TProtocolosCIP'
      end
      item
        DataSet = TModosOFFLibe
        TableName = 'TModosOFFLibe'
      end
      item
        DataSet = TDirecciones
        TableName = 'TDirecciones'
      end
      item
        DataSet = TTiposPuntos
        TableName = 'TTiposPuntos'
      end
      item
        DataSet = TModosFunc
        TableName = 'TModosFunc'
      end
      item
        DataSet = TTiposAlimentacion
        TableName = 'TTiposAlimentacion'
      end
      item
        DataSet = TInterpretarNro
        TableName = 'TInterpretarNro'
      end
      item
        DataSet = TAvisoUsuario
        TableName = 'TAvisoUsuario'
      end
      item
        DataSet = TAvisoGUsuario
        TableName = 'TAvisoGUsuario'
      end
      item
        DataSet = TAvisoMaquina
        TableName = 'TAvisoMaquina'
      end
      item
        DataSet = TAvisoGMaquina
        TableName = 'TAvisoGMaquina'
      end
      item
        DataSet = TTipoCacheoEntrada
        TableName = 'TTipoCacheoEntrada'
      end
      item
        DataSet = TTipoCacheoSalida
        TableName = 'TTipoCacheoSalida'
      end
      item
        DataSet = TAvisoUsuarioAD
        TableName = 'TAvisoUsuarioAD'
      end
      item
        DataSet = TAvisoGUsuarioAD
        TableName = 'TAvisoGUsuarioAD'
      end
      item
        DataSet = TAvisoMaquinaAD
        TableName = 'TAvisoMaquinaAD'
      end
      item
        DataSet = TAvisoGMaquinaAD
        TableName = 'TAvisoGMaquinaAD'
      end>
    BajaLogica = <
      item
        DataSet = TPuertas
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TPuertas
    DataSetDet1 = TAvisoUsuario
    DataSetDet2 = TAvisoGUsuario
    DataSetDet3 = TAvisoMaquina
    DataSetDet4 = TAvisoGMaquina
    DataSetDet5 = TAvisoUsuarioAD
    DataSetDet6 = TAvisoGUsuarioAD
    DataSetDet7 = TAvisoMaquinaAD
    DataSetDet8 = TAvisoGMaquinaAD
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TPuertas: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_puerta'
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
        Name = 'acceso_al_predio'
        DataType = ftBoolean
      end
      item
        Name = 'egreso_del_predio'
        DataType = ftBoolean
      end
      item
        Name = 'IP'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'identif_puerta'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'tipo_medio_ent'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'identif_ent'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'identif_leg_ent'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'protocolo_ent'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'modo_func_ent'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'tipo_medio_sal'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'identif_sal'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'identif_leg_sal'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'protocolo_sal'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'modo_func_sal'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'modo_off_line_ent'
        DataType = ftInteger
      end
      item
        Name = 'modo_off_line_sal'
        DataType = ftInteger
      end
      item
        Name = 'int_status_time'
        DataType = ftInteger
      end
      item
        Name = 'int_config_time'
        DataType = ftInteger
      end
      item
        Name = 'int_syncrotime'
        DataType = ftInteger
      end
      item
        Name = 'hab_punto_acc_1'
        DataType = ftInteger
      end
      item
        Name = 'hab_punto_acc_2'
        DataType = ftInteger
      end
      item
        Name = 'ctimeout_ent'
        DataType = ftInteger
      end
      item
        Name = 'ctimeout_sal'
        DataType = ftInteger
      end
      item
        Name = 'otimeout_ent'
        DataType = ftInteger
      end
      item
        Name = 'otimeout_sal'
        DataType = ftInteger
      end
      item
        Name = 'alarmtime_ent'
        DataType = ftInteger
      end
      item
        Name = 'alarmtime_sal'
        DataType = ftInteger
      end
      item
        Name = 'dir_pto_ent'
        DataType = ftInteger
      end
      item
        Name = 'dir_pto_sal'
        DataType = ftInteger
      end
      item
        Name = 'tipo_punto_ent'
        DataType = ftInteger
      end
      item
        Name = 'tipo_punto_sal'
        DataType = ftInteger
      end
      item
        Name = 'benable_ent'
        DataType = ftInteger
      end
      item
        Name = 'benable_sal'
        DataType = ftInteger
      end
      item
        Name = 'penable_ent'
        DataType = ftInteger
      end
      item
        Name = 'penable_sal'
        DataType = ftInteger
      end
      item
        Name = 'mode'
        DataType = ftInteger
      end
      item
        Name = 'puerto'
        DataType = ftInteger
      end
      item
        Name = 'puerto_tele'
        DataType = ftInteger
      end
      item
        Name = 'tipo_alim_lb_ent'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'tipo_alim_lb_sal'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'pedir_config'
        DataType = ftBoolean
      end
      item
        Name = 'liberar_entrada'
        DataType = ftBoolean
      end
      item
        Name = 'liberar_salida'
        DataType = ftBoolean
      end
      item
        Name = 'inter_nro_ent'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'inter_nro_sal'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'iniciar_tele'
        DataType = ftBoolean
      end
      item
        Name = 'ingreso_cacheo'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'egreso_cacheo'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'entrada_sale_de'
        DataType = ftInteger
      end
      item
        Name = 'entrada_entra_a'
        DataType = ftInteger
      end
      item
        Name = 'salida_sale_de'
        DataType = ftInteger
      end
      item
        Name = 'salida_entra_a'
        DataType = ftInteger
      end
      item
        Name = 'reg_mov_ult_accleg'
        DataType = ftBoolean
      end
      item
        Name = 'antipassback_ent'
        DataType = ftBoolean
      end
      item
        Name = 'antipassback_sal'
        DataType = ftBoolean
      end
      item
        Name = 'cacheo_ent'
        DataType = ftBoolean
      end
      item
        Name = 'cacheo_sal'
        DataType = ftBoolean
      end
      item
        Name = 'reg_mov_ult_ent'
        DataType = ftBoolean
      end
      item
        Name = 'reg_mov_ult_sal'
        DataType = ftBoolean
      end
      item
        Name = 'act_avi_acc_den'
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
    object TPuertasoid_puerta: TIntegerField
      FieldName = 'oid_puerta'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPuertascodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TPuertasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
    object TPuertasactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TPuertasacceso_al_predio: TBooleanField
      FieldName = 'acceso_al_predio'
    end
    object TPuertasegreso_del_predio: TBooleanField
      FieldName = 'egreso_del_predio'
    end
    object TPuertasIP: TStringField
      FieldName = 'IP'
      Size = 50
    end
    object TPuertasidentif_puerta: TStringField
      FieldName = 'identif_puerta'
    end
    object TPuertastipo_medio_ent: TStringField
      FieldName = 'tipo_medio_ent'
    end
    object TPuertasidentif_ent: TStringField
      FieldName = 'identif_ent'
    end
    object TPuertasidentif_leg_ent: TStringField
      FieldName = 'identif_leg_ent'
    end
    object TPuertasprotocolo_ent: TStringField
      FieldName = 'protocolo_ent'
    end
    object TPuertasmodo_func_ent: TStringField
      FieldName = 'modo_func_ent'
    end
    object TPuertastipo_medio_sal: TStringField
      FieldName = 'tipo_medio_sal'
    end
    object TPuertasidentif_sal: TStringField
      FieldName = 'identif_sal'
    end
    object TPuertasidentif_leg_sal: TStringField
      FieldName = 'identif_leg_sal'
    end
    object TPuertasprotocolo_sal: TStringField
      FieldName = 'protocolo_sal'
    end
    object TPuertasmodo_func_sal: TStringField
      FieldName = 'modo_func_sal'
    end
    object TPuertasmodo_off_line_ent: TIntegerField
      FieldName = 'modo_off_line_ent'
    end
    object TPuertasmodo_off_line_sal: TIntegerField
      FieldName = 'modo_off_line_sal'
    end
    object TPuertasint_status_time: TIntegerField
      FieldName = 'int_status_time'
    end
    object TPuertasint_config_time: TIntegerField
      FieldName = 'int_config_time'
    end
    object TPuertasint_syncrotime: TIntegerField
      FieldName = 'int_syncrotime'
    end
    object TPuertashab_punto_acc_1: TIntegerField
      FieldName = 'hab_punto_acc_1'
    end
    object TPuertashab_punto_acc_2: TIntegerField
      FieldName = 'hab_punto_acc_2'
    end
    object TPuertasctimeout_ent: TIntegerField
      FieldName = 'ctimeout_ent'
    end
    object TPuertasctimeout_sal: TIntegerField
      FieldName = 'ctimeout_sal'
    end
    object TPuertasotimeout_ent: TIntegerField
      FieldName = 'otimeout_ent'
    end
    object TPuertasotimeout_sal: TIntegerField
      FieldName = 'otimeout_sal'
    end
    object TPuertasalarmtime_ent: TIntegerField
      FieldName = 'alarmtime_ent'
    end
    object TPuertasalarmtime_sal: TIntegerField
      FieldName = 'alarmtime_sal'
    end
    object TPuertasdir_pto_ent: TIntegerField
      FieldName = 'dir_pto_ent'
    end
    object TPuertasdir_pto_sal: TIntegerField
      FieldName = 'dir_pto_sal'
    end
    object TPuertastipo_punto_ent: TIntegerField
      FieldName = 'tipo_punto_ent'
    end
    object TPuertastipo_punto_sal: TIntegerField
      FieldName = 'tipo_punto_sal'
    end
    object TPuertasbenable_ent: TIntegerField
      FieldName = 'benable_ent'
    end
    object TPuertasbenable_sal: TIntegerField
      FieldName = 'benable_sal'
    end
    object TPuertaspenable_ent: TIntegerField
      FieldName = 'penable_ent'
    end
    object TPuertaspenable_sal: TIntegerField
      FieldName = 'penable_sal'
    end
    object TPuertasmode: TIntegerField
      FieldName = 'mode'
    end
    object TPuertaspuerto: TIntegerField
      FieldName = 'puerto'
    end
    object TPuertaspuerto_tele: TIntegerField
      FieldName = 'puerto_tele'
    end
    object TPuertastipo_alim_lb_ent: TStringField
      FieldName = 'tipo_alim_lb_ent'
    end
    object TPuertastipo_alim_lb_sal: TStringField
      FieldName = 'tipo_alim_lb_sal'
    end
    object TPuertaspedir_config: TBooleanField
      FieldName = 'pedir_config'
    end
    object TPuertasliberar_entrada: TBooleanField
      FieldName = 'liberar_entrada'
    end
    object TPuertasliberar_salida: TBooleanField
      FieldName = 'liberar_salida'
    end
    object TPuertasinter_nro_ent: TStringField
      FieldName = 'inter_nro_ent'
    end
    object TPuertasinter_nro_sal: TStringField
      FieldName = 'inter_nro_sal'
    end
    object TPuertasiniciar_tele: TBooleanField
      FieldName = 'iniciar_tele'
    end
    object TPuertasingreso_cacheo: TStringField
      FieldName = 'ingreso_cacheo'
    end
    object TPuertasegreso_cacheo: TStringField
      FieldName = 'egreso_cacheo'
    end
    object TPuertasentrada_sale_de: TIntegerField
      FieldName = 'entrada_sale_de'
    end
    object TPuertasentrada_entra_a: TIntegerField
      FieldName = 'entrada_entra_a'
    end
    object TPuertassalida_sale_de: TIntegerField
      FieldName = 'salida_sale_de'
    end
    object TPuertassalida_entra_a: TIntegerField
      FieldName = 'salida_entra_a'
    end
    object TPuertasreg_mov_ult_accleg: TBooleanField
      FieldName = 'reg_mov_ult_accleg'
    end
    object TPuertasantipassback_ent: TBooleanField
      FieldName = 'antipassback_ent'
    end
    object TPuertasantipassback_sal: TBooleanField
      FieldName = 'antipassback_sal'
    end
    object TPuertascacheo_ent: TBooleanField
      FieldName = 'cacheo_ent'
    end
    object TPuertascacheo_sal: TBooleanField
      FieldName = 'cacheo_sal'
    end
    object TPuertasreg_mov_ult_ent: TBooleanField
      FieldName = 'reg_mov_ult_ent'
    end
    object TPuertasreg_mov_ult_sal: TBooleanField
      FieldName = 'reg_mov_ult_sal'
    end
    object TPuertasact_avi_acc_den: TBooleanField
      FieldName = 'act_avi_acc_den'
    end
    object TPuertasrestringir_ent: TBooleanField
      FieldName = 'restringir_ent'
    end
    object TPuertasrestringir_sal: TBooleanField
      FieldName = 'restringir_sal'
    end
    object TPuertasrestri_ent_vis: TBooleanField
      FieldName = 'restri_ent_vis'
    end
    object TPuertaslib_ent_vis: TBooleanField
      FieldName = 'lib_ent_vis'
    end
    object TPuertaslib_sal_vis: TBooleanField
      FieldName = 'lib_sal_vis'
    end
    object TPuertastraga_tarj_sal: TBooleanField
      FieldName = 'traga_tarj_sal'
    end
  end
  object DSPuertas: TDataSource [4]
    DataSet = TPuertas
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
        TableName = 'TPuertas'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorPuerta.Value := Sender.AsString;'
          '  ValidadorPuerta.Validar;'
          'end.')
      end
      item
        TableName = 'TAvisoUsuario'
        FieldName = 'cod_usuario'
        Source.Strings = (
          'begin'
          '  ValidadorUsuario.Value := Sender.AsString;'
          '  ValidadorUsuario.Validar;'
          'end.')
      end
      item
        TableName = 'TAvisoGUsuario'
        FieldName = 'cod_grupo_usuario'
        Source.Strings = (
          'begin'
          '  ValidadorGrupoUsuario.Value := Sender.AsString;'
          '  ValidadorGrupoUsuario.Validar;'
          'end.')
      end
      item
        TableName = 'TAvisoMaquina'
        FieldName = 'cod_maquina'
        Source.Strings = (
          'begin'
          '  ValidadorMaquina.Value := Sender.AsString;'
          '  ValidadorMaquina.Validar();'
          'end.')
      end
      item
        TableName = 'TAvisoGMaquina'
        FieldName = 'cod_grupo_maquina'
        Source.Strings = (
          'begin'
          '  ValidadorGrupoMaquina.Value := Sender.AsString;'
          '  ValidadorGrupoMaquina.Validar;'
          'end.')
      end
      item
        TableName = 'TAvisoUsuarioAD'
        FieldName = 'cod_usuario'
        Source.Strings = (
          'begin'
          '  ValidadorUsuarioAD.Value := Sender.AsString;'
          '  ValidadorUsuarioAD.Validar();'
          'end.')
      end
      item
        TableName = 'TAvisoGUsuarioAD'
        FieldName = 'cod_grupo_usuario'
        Source.Strings = (
          'begin'
          '  ValidadorGrupoUsuarioAD.Value := Sender.AsString;'
          '  ValidadorGrupoUsuarioAD.Validar();'
          'end.')
      end
      item
        TableName = 'TAvisoMaquinaAD'
        FieldName = 'cod_maquina'
        Source.Strings = (
          'begin'
          '   ValidadorMaquinaAD.Value := Sender.AsString;'
          '   ValidadorMaquinaAD.Validar();'
          'end.')
      end
      item
        TableName = 'TAvisoGMaquinaAD'
        FieldName = 'cod_grupo_maquina'
        Source.Strings = (
          'begin'
          '  ValidadorGrupoMaquinaAD.Value := Sender.AsString;'
          '  ValidadorGrupoMaquinaAD.Validar();'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TPuertas'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'acceso_al_predio'#39').AsBoolean := false;'
          '  DataSet.FieldName('#39'egreso_del_predio'#39').AsBoolean := false;'
          '  DataSet.FieldName('#39'act_avi_acc_den'#39').AsBoolean := false;'
          '  DataSet.FieldName('#39'restri_ent_vis'#39').AsBoolean := false;'
          'end.')
      end
      item
        TableName = 'TAvisoUsuario'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_obj_neg'#39').AsInteger := TPuertas.FieldNa' +
            'me('#39'oid_puerta'#39').AsInteger;'
          '  DataSet.FieldName('#39'Activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TAvisoGUsuario'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_obj_neg'#39').AsInteger := TPuertas.FieldNa' +
            'me('#39'oid_puerta'#39').AsInteger;'
          '  DataSet.FieldName('#39'Activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TAvisoMaquina'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_obj_neg'#39').AsInteger := TPuertas.FieldNa' +
            'me('#39'oid_puerta'#39').AsInteger;'
          '  DataSet.FieldName('#39'Activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TAvisoGMaquina'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_obj_neg'#39').AsInteger := TPuertas.FieldNa' +
            'me('#39'oid_puerta'#39').AsInteger;'
          '  DataSet.FieldName('#39'Activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TAvisoUsuarioAD'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_obj_neg'#39').AsInteger := TPuertas.FieldNa' +
            'me('#39'oid_puerta'#39').AsInteger;'
          '  DataSet.FieldName('#39'Activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TAvisoGUsuarioAD'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_obj_neg'#39').AsInteger := TPuertas.FieldNa' +
            'me('#39'oid_puerta'#39').AsInteger;'
          '  DataSet.FieldName('#39'Activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TAvisoMaquinaAD'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_obj_neg'#39').AsInteger := TPuertas.FieldNa' +
            'me('#39'oid_puerta'#39').AsInteger;'
          '  DataSet.FieldName('#39'Activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TAvisoGMaquinaAD'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_obj_neg'#39').AsInteger := TPuertas.FieldNa' +
            'me('#39'oid_puerta'#39').AsInteger;'
          '  DataSet.FieldName('#39'Activo'#39').AsBoolean := true;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TraerMediosAcceso();'
          '  TraerIdentificadoresDeLeg();'
          '  TraerProtocolos();'
          '  TraerModosOFFLine();'
          '  TraerDirecciones();'
          '  TraerTiposPuntos();'
          '  TraerModosFuncionamiento();'
          '  TraerTiposAlim();'
          '  TraerInterpretarNro();'
          '  TraerTipoCacheoEntSal();'
          '  TZonas.LoadFromHelp('#39'HelpZonas'#39');'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerTiposAlim();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTiposAlimLB'#39');'
          '  operacion.execute();'
          'end;'
          ''
          'procedure TraerMediosAcceso();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerMediosAccesoCIP'#39');'
          '  operacion.execute();'
          'end;'
          ''
          'procedure TraerIdentificadoresDeLeg();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerIdentificadoresDeLeg'#39');'
          '  operacion.execute();'
          'end;'
          ''
          'procedure TraerModosOFFLine();'
          'begin'
          '  operacion.InicioOperacion;'
          '  operacion.setOper('#39'TraerModosOFFLine'#39');'
          ' operacion.execute();'
          'end;'
          ''
          'procedure TraerProtocolos();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerProtocolosCIP'#39');'
          '  operacion.execute();'
          'end;'
          ''
          'procedure TraerDirecciones();'
          'begin'
          '  operacion.inicioOperacion();'
          '  operacion.setOper('#39'TraerDireccionesPtoAccesoCIP'#39');'
          ' operacion.execute();'
          'end;'
          ''
          'procedure TraerTiposPuntos();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTiposPuntosCIP'#39');'
          ' operacion.execute();'
          'end;'
          ''
          'procedure TraerModosFuncionamiento();'
          'begin'
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'TraerModosFuncPlacaCIP'#39');'
          ' operacion.execute();'
          'end;'
          ''
          'procedure TraerInterpretarNro();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerInterpretarNroAValidar'#39');'
          '  operacion.execute();'
          'end;'
          ''
          'procedure TraerTipoCacheoEntSal();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTipoCacheoEntSal'#39');'
          '  operacion.execute();'
          'end;')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'dxDBGridSN1DBTableView1cod_usuario'
        Source.Strings = (
          'begin'
          '  HelpUsuarios.Mostrar();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBColumn1'
        Source.Strings = (
          'begin'
          '  HelpGrupoUsuarios.Mostrar();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBColumn3'
        Source.Strings = (
          'begin'
          '  HelpMaquinas.Mostrar();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBColumn6'
        Source.Strings = (
          'begin'
          '  HelpGrupoMaquinas.Mostrar();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBColumn12'
        Source.Strings = (
          'begin'
          '  HelpUsuariosAD.Mostrar();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBColumn15'
        Source.Strings = (
          'begin'
          '  HelpGrupoUsuariosAD.Mostrar();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBColumn9'
        Source.Strings = (
          'begin'
          '  HelpMaquinasAD.Mostrar();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBColumn18'
        Source.Strings = (
          'begin'
          '  HelpGrupoMaquinasAD.Mostrar();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 312
    Top = 224
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 248
    Top = 123
  end
  inherited TPathHelp: TsnTable
    Left = 400
    Top = 557
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 816
    Top = 43
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
    Titulo = 'Puntos de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorPuerta: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.Puerta'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Punto de Acceso duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
  object TMediosAcceso: TsnTable
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
    Left = 520
    Top = 363
    object TMediosAccesocodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TMediosAccesodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSMediosAcceso: TDataSource
    DataSet = TMediosAcceso
    Left = 552
    Top = 363
  end
  object TIdentifLeg: TsnTable
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
    Left = 408
    Top = 359
    object StringField1: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField2: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSIdentifLeg: TDataSource
    DataSet = TIdentifLeg
    Left = 440
    Top = 359
  end
  object TProtocolosCIP: TsnTable
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
    Left = 520
    Top = 435
    object TProtocolosCIPcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TProtocolosCIPdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSProtocolosCIP: TDataSource
    DataSet = TProtocolosCIP
    Left = 552
    Top = 435
  end
  object TModosOFFLibe: TsnTable
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
    Left = 872
    Top = 83
    object TModosOFFLibecodigo: TIntegerField
      FieldName = 'codigo'
    end
    object TModosOFFLibedescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSModosOFFLine: TDataSource
    DataSet = TModosOFFLibe
    Left = 904
    Top = 83
  end
  object TDirecciones: TsnTable
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
    Left = 408
    Top = 486
    object StringField3: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField4: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTDirecciones: TDataSource
    DataSet = TDirecciones
    Left = 440
    Top = 486
  end
  object TTiposPuntos: TsnTable
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
    Left = 408
    Top = 518
    object StringField5: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField6: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTTiposPuntos: TDataSource
    DataSet = TTiposPuntos
    Left = 440
    Top = 518
  end
  object TModosFunc: TsnTable
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
    Left = 518
    Top = 326
    object StringField7: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField8: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTModosFunc: TDataSource
    DataSet = TModosFunc
    Left = 550
    Top = 326
  end
  object TTiposAlimentacion: TsnTable
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
    Left = 520
    Top = 289
    object TTiposAlimentacioncodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTiposAlimentaciondescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTiposAlimen: TDataSource
    DataSet = TTiposAlimentacion
    Left = 552
    Top = 289
  end
  object TInterpretarNro: TsnTable
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
    Left = 432
    Top = 209
    object TInterpretarNrocodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TInterpretarNrodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSInterpretarNro: TDataSource
    DataSet = TInterpretarNro
    Left = 464
    Top = 209
  end
  object TAvisoUsuario: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_avi_usu'
        DataType = ftInteger
      end
      item
        Name = 'oid_usuario'
        DataType = ftInteger
      end
      item
        Name = 'cod_usuario'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_usuario'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_obj_neg'
        DataType = ftInteger
      end
      item
        Name = 'circuito'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_obj_neg'
    IndexDefs = <
      item
        Name = 'TAvisoUsuarioIndex1'
        Fields = 'oid_obj_neg'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_puerta'
    MasterSource = DSPuertas
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 652
    Top = 321
    object TAvisoUsuariooid_avi_usu: TIntegerField
      FieldName = 'oid_avi_usu'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAvisoUsuariooid_usuario: TIntegerField
      FieldName = 'oid_usuario'
    end
    object TAvisoUsuariocod_usuario: TStringField
      FieldName = 'cod_usuario'
      Size = 50
    end
    object TAvisoUsuariodesc_usuario: TStringField
      FieldName = 'desc_usuario'
      Size = 100
    end
    object TAvisoUsuariooid_obj_neg: TIntegerField
      FieldName = 'oid_obj_neg'
    end
    object TAvisoUsuariocircuito: TStringField
      FieldName = 'circuito'
    end
    object TAvisoUsuarioactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object TAvisoGUsuario: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_avi_gusu'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo_usuario'
        DataType = ftInteger
      end
      item
        Name = 'cod_grupo_usuario'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_grupo_usuario'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_obj_neg'
        DataType = ftInteger
      end
      item
        Name = 'circuito'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_obj_neg'
    IndexDefs = <
      item
        Name = 'TAvisoGUsuarioIndex1'
        Fields = 'oid_obj_neg'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_puerta'
    MasterSource = DSPuertas
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 656
    Top = 361
    object TAvisoGUsuariooid_avi_gusu: TIntegerField
      FieldName = 'oid_avi_gusu'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAvisoGUsuariooid_grupo_usuario: TIntegerField
      FieldName = 'oid_grupo_usuario'
    end
    object TAvisoGUsuariocod_grupo_usuario: TStringField
      FieldName = 'cod_grupo_usuario'
      Size = 50
    end
    object TAvisoGUsuariodesc_grupo_usuario: TStringField
      FieldName = 'desc_grupo_usuario'
      Size = 100
    end
    object TAvisoGUsuariooid_obj_neg: TIntegerField
      FieldName = 'oid_obj_neg'
    end
    object TAvisoGUsuariocircuito: TStringField
      FieldName = 'circuito'
    end
    object TAvisoGUsuarioactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object TAvisoMaquina: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_avi_maq'
        DataType = ftInteger
      end
      item
        Name = 'oid_maquina'
        DataType = ftInteger
      end
      item
        Name = 'cod_maquina'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_maquina'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_obj_neg'
        DataType = ftInteger
      end
      item
        Name = 'circuito'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_obj_neg'
    IndexDefs = <
      item
        Name = 'TAvisoMaquinaIndex1'
        Fields = 'oid_obj_neg'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_puerta'
    MasterSource = DSPuertas
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 660
    Top = 409
    object TAvisoMaquinaoid_avi_maq: TIntegerField
      FieldName = 'oid_avi_maq'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAvisoMaquinaoid_maquina: TIntegerField
      FieldName = 'oid_maquina'
    end
    object TAvisoMaquinacod_maquina: TStringField
      FieldName = 'cod_maquina'
      Size = 50
    end
    object TAvisoMaquinadesc_maquina: TStringField
      FieldName = 'desc_maquina'
      Size = 100
    end
    object TAvisoMaquinaoid_obj_neg: TIntegerField
      FieldName = 'oid_obj_neg'
    end
    object TAvisoMaquinacircuito: TStringField
      FieldName = 'circuito'
    end
    object TAvisoMaquinaactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object TAvisoGMaquina: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_avi_gmaq'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo_maquina'
        DataType = ftInteger
      end
      item
        Name = 'cod_grupo_maquina'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_grupo_maquina'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_obj_neg'
        DataType = ftInteger
      end
      item
        Name = 'circuito'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_obj_neg'
    IndexDefs = <
      item
        Name = 'TAvisoGMaquinaIndex1'
        Fields = 'oid_obj_neg'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_puerta'
    MasterSource = DSPuertas
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 660
    Top = 457
    object TAvisoGMaquinaoid_avi_gmaq: TIntegerField
      FieldName = 'oid_avi_gmaq'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAvisoGMaquinaoid_grupo_maquina: TIntegerField
      FieldName = 'oid_grupo_maquina'
    end
    object TAvisoGMaquinacod_grupo_maquina: TStringField
      FieldName = 'cod_grupo_maquina'
      Size = 50
    end
    object TAvisoGMaquinadesc_grupo_maquina: TStringField
      FieldName = 'desc_grupo_maquina'
      Size = 100
    end
    object TAvisoGMaquinaoid_obj_neg: TIntegerField
      FieldName = 'oid_obj_neg'
    end
    object TAvisoGMaquinacircuito: TStringField
      FieldName = 'circuito'
    end
    object TAvisoGMaquinaactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTAvisoUsuario: TDataSource
    DataSet = TAvisoUsuario
    Left = 684
    Top = 321
  end
  object DSTAvisoGUsuario: TDataSource
    DataSet = TAvisoGUsuario
    Left = 692
    Top = 361
  end
  object DSTAvisoMaquina: TDataSource
    DataSet = TAvisoMaquina
    Left = 692
    Top = 409
  end
  object DSTAvisoGMaquina: TDataSource
    DataSet = TAvisoGMaquina
    Left = 692
    Top = 457
  end
  object HelpUsuarios: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'se.Usuario'
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
        AsignarACampo = TAvisoUsuariocod_usuario
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
    Titulo = 'Usuarios'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 730
    Top = 316
  end
  object ValidadorUsuario: TValidador
    Operacion = Operacion
    NickNameObjLog = 'se.Usuario'
    MensajeException = 'C'#243'digo de Usuario Inexistente'
    CampoOID = TAvisoUsuariooid_usuario
    CampoDescripcion = TAvisoUsuariodesc_usuario
    NroQuery = 0
    Cache = False
    Left = 760
    Top = 315
  end
  object HelpGrupoUsuarios: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'me.GrupoUsuMens'
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
        AsignarACampo = TAvisoGUsuariocod_grupo_usuario
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
    Titulo = 'Grupos de Usuarios'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 730
    Top = 354
  end
  object ValidadorGrupoUsuario: TValidador
    Operacion = Operacion
    NickNameObjLog = 'me.GrupoUsuMens'
    MensajeException = 'C'#243'digo de Grupo de Usuarios Inexistente'
    CampoOID = TAvisoGUsuariooid_grupo_usuario
    CampoDescripcion = TAvisoGUsuariodesc_grupo_usuario
    NroQuery = 0
    Cache = False
    Left = 760
    Top = 353
  end
  object HelpMaquinas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'me.Maquina'
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
        AsignarACampo = TAvisoMaquinacod_maquina
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
    Titulo = 'M'#225'quinas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 730
    Top = 392
  end
  object ValidadorMaquina: TValidador
    Operacion = Operacion
    NickNameObjLog = 'me.Maquina'
    MensajeException = 'C'#243'digo de M'#225'quina Inexistente'
    CampoOID = TAvisoMaquinaoid_maquina
    CampoDescripcion = TAvisoMaquinadesc_maquina
    NroQuery = 0
    Cache = False
    Left = 760
    Top = 391
  end
  object HelpGrupoMaquinas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ge.GrupoMaquina'
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
        AsignarACampo = TAvisoGMaquinacod_grupo_maquina
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
    Titulo = 'Grupos de M'#225'quinas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 730
    Top = 428
  end
  object ValidadorGrupoMaquina: TValidador
    Operacion = Operacion
    NickNameObjLog = 'ge.GrupoMaquina'
    MensajeException = 'C'#243'digo de Grupo de M'#225'quina Inexistente'
    CampoOID = TAvisoGMaquinaoid_grupo_maquina
    CampoDescripcion = TAvisoGMaquinadesc_grupo_maquina
    NroQuery = 0
    Cache = False
    Left = 760
    Top = 427
  end
  object TTipoCacheoEntrada: TsnTable
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
    Top = 193
    object TTipoCacheoEntradacodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTipoCacheoEntradadescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TTipoCacheoSalida: TsnTable
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
    Left = 288
    Top = 193
    object TTipoCacheoSalidacodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTipoCacheoSalidadescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTTipoCacheoEntrada: TDataSource
    DataSet = TTipoCacheoEntrada
    Left = 196
    Top = 193
  end
  object dsTTipoCacheoSalida: TDataSource
    DataSet = TTipoCacheoSalida
    Left = 316
    Top = 193
  end
  object HelpZonas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.ZonaCIP'
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
        AsignarACampo = TAvisoGUsuariocod_grupo_usuario
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
    Titulo = 'Zonas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 64
    Top = 442
  end
  object TZonas: TsnTable
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
    Left = 100
    Top = 441
    object TZonasoid: TIntegerField
      FieldName = 'oid'
    end
    object TZonascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TZonasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSZonas: TDataSource
    DataSet = TZonas
    Left = 132
    Top = 441
  end
  object TAvisoUsuarioAD: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_avi_usu'
        DataType = ftInteger
      end
      item
        Name = 'oid_usuario'
        DataType = ftInteger
      end
      item
        Name = 'cod_usuario'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_usuario'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_obj_neg'
        DataType = ftInteger
      end
      item
        Name = 'circuito'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_obj_neg'
    IndexDefs = <
      item
        Name = 'TAvisoUsuarioIndex1'
        Fields = 'oid_obj_neg'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_puerta'
    MasterSource = DSPuertas
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 796
    Top = 321
    object IntegerField1: TIntegerField
      FieldName = 'oid_avi_usu'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAvisoUsuarioADoid_usuario: TIntegerField
      FieldName = 'oid_usuario'
    end
    object TAvisoUsuarioADcod_usuario: TStringField
      FieldName = 'cod_usuario'
      Size = 50
    end
    object TAvisoUsuarioADdesc_usuario: TStringField
      FieldName = 'desc_usuario'
      Size = 100
    end
    object IntegerField3: TIntegerField
      FieldName = 'oid_obj_neg'
    end
    object StringField11: TStringField
      FieldName = 'circuito'
    end
    object BooleanField1: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTAvisoUsuarioAD: TDataSource
    DataSet = TAvisoUsuarioAD
    Left = 828
    Top = 321
  end
  object TAvisoGUsuarioAD: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_avi_gusu'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo_usuario'
        DataType = ftInteger
      end
      item
        Name = 'cod_grupo_usuario'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_grupo_usuario'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_obj_neg'
        DataType = ftInteger
      end
      item
        Name = 'circuito'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_obj_neg'
    IndexDefs = <
      item
        Name = 'TAvisoGUsuarioIndex1'
        Fields = 'oid_obj_neg'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_puerta'
    MasterSource = DSPuertas
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 800
    Top = 361
    object IntegerField4: TIntegerField
      FieldName = 'oid_avi_gusu'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAvisoGUsuarioADoid_grupo_usuario: TIntegerField
      FieldName = 'oid_grupo_usuario'
    end
    object TAvisoGUsuarioADcod_grupo_usuario: TStringField
      FieldName = 'cod_grupo_usuario'
      Size = 50
    end
    object TAvisoGUsuarioADdesc_grupo_usuario: TStringField
      FieldName = 'desc_grupo_usuario'
      Size = 100
    end
    object IntegerField6: TIntegerField
      FieldName = 'oid_obj_neg'
    end
    object StringField14: TStringField
      FieldName = 'circuito'
    end
    object BooleanField2: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTAvisoGUsuarioAD: TDataSource
    DataSet = TAvisoGUsuarioAD
    Left = 836
    Top = 361
  end
  object TAvisoMaquinaAD: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_avi_maq'
        DataType = ftInteger
      end
      item
        Name = 'oid_maquina'
        DataType = ftInteger
      end
      item
        Name = 'cod_maquina'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_maquina'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_obj_neg'
        DataType = ftInteger
      end
      item
        Name = 'circuito'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_obj_neg'
    IndexDefs = <
      item
        Name = 'TAvisoMaquinaIndex1'
        Fields = 'oid_obj_neg'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_puerta'
    MasterSource = DSPuertas
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 804
    Top = 393
    object IntegerField7: TIntegerField
      FieldName = 'oid_avi_maq'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAvisoMaquinaADoid_maquina: TIntegerField
      FieldName = 'oid_maquina'
    end
    object TAvisoMaquinaADcod_maquina: TStringField
      FieldName = 'cod_maquina'
      Size = 50
    end
    object TAvisoMaquinaADdesc_maquina: TStringField
      FieldName = 'desc_maquina'
      Size = 100
    end
    object IntegerField9: TIntegerField
      FieldName = 'oid_obj_neg'
    end
    object StringField17: TStringField
      FieldName = 'circuito'
    end
    object BooleanField3: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTAvisoMaquinaAD: TDataSource
    DataSet = TAvisoMaquinaAD
    Left = 836
    Top = 393
  end
  object TAvisoGMaquinaAD: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_avi_gmaq'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo_maquina'
        DataType = ftInteger
      end
      item
        Name = 'cod_grupo_maquina'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_grupo_maquina'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_obj_neg'
        DataType = ftInteger
      end
      item
        Name = 'circuito'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_obj_neg'
    IndexDefs = <
      item
        Name = 'TAvisoGMaquinaIndex1'
        Fields = 'oid_obj_neg'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_puerta'
    MasterSource = DSPuertas
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 804
    Top = 433
    object IntegerField10: TIntegerField
      FieldName = 'oid_avi_gmaq'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAvisoGMaquinaADoid_grupo_maquina: TIntegerField
      FieldName = 'oid_grupo_maquina'
    end
    object TAvisoGMaquinaADcod_grupo_maquina: TStringField
      FieldName = 'cod_grupo_maquina'
      Size = 50
    end
    object TAvisoGMaquinaADdesc_grupo_maquina: TStringField
      FieldName = 'desc_grupo_maquina'
      Size = 100
    end
    object IntegerField12: TIntegerField
      FieldName = 'oid_obj_neg'
    end
    object StringField20: TStringField
      FieldName = 'circuito'
    end
    object BooleanField4: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTAvisoGMaquinaAD: TDataSource
    DataSet = TAvisoGMaquinaAD
    Left = 836
    Top = 433
  end
  object HelpUsuariosAD: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'se.Usuario'
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
        AsignarACampo = TAvisoUsuarioADcod_usuario
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
    Titulo = 'Usuarios'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 890
    Top = 316
  end
  object ValidadorUsuarioAD: TValidador
    Operacion = Operacion
    NickNameObjLog = 'se.Usuario'
    MensajeException = 'C'#243'digo de Usuario Inexistente'
    CampoOID = TAvisoUsuarioADoid_usuario
    CampoDescripcion = TAvisoUsuarioADdesc_usuario
    NroQuery = 0
    Cache = False
    Left = 920
    Top = 315
  end
  object HelpGrupoUsuariosAD: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'me.GrupoUsuMens'
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
        AsignarACampo = TAvisoGUsuarioADcod_grupo_usuario
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
    Titulo = 'Grupos de Usuarios'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 893
    Top = 354
  end
  object ValidadorGrupoUsuarioAD: TValidador
    Operacion = Operacion
    NickNameObjLog = 'me.GrupoUsuMens'
    MensajeException = 'C'#243'digo de Grupo de Usuarios Inexistente'
    CampoOID = TAvisoGUsuarioADoid_grupo_usuario
    CampoDescripcion = TAvisoGUsuarioADdesc_grupo_usuario
    NroQuery = 0
    Cache = False
    Left = 923
    Top = 353
  end
  object HelpMaquinasAD: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'me.Maquina'
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
        AsignarACampo = TAvisoMaquinaADcod_maquina
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
    Titulo = 'M'#225'quinas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 894
    Top = 400
  end
  object ValidadorMaquinaAD: TValidador
    Operacion = Operacion
    NickNameObjLog = 'me.Maquina'
    MensajeException = 'C'#243'digo de M'#225'quina Inexistente'
    CampoOID = TAvisoMaquinaADoid_maquina
    CampoDescripcion = TAvisoMaquinaADdesc_maquina
    NroQuery = 0
    Cache = False
    Left = 924
    Top = 399
  end
  object HelpGrupoMaquinasAD: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ge.GrupoMaquina'
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
        AsignarACampo = TAvisoGMaquinaADcod_grupo_maquina
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
    Titulo = 'Grupos de M'#225'quinas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 890
    Top = 437
  end
  object ValidadorGrupoMaquinaAD: TValidador
    Operacion = Operacion
    NickNameObjLog = 'ge.GrupoMaquina'
    MensajeException = 'C'#243'digo de Grupo de M'#225'quina Inexistente'
    CampoOID = TAvisoGMaquinaADoid_grupo_maquina
    CampoDescripcion = TAvisoGMaquinaADdesc_grupo_maquina
    NroQuery = 0
    Cache = False
    Left = 920
    Top = 436
  end
end
