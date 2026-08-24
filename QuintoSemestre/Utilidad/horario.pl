% ==============================================================================
% GESTOR DE HORARIO SEMESTRAL - PROLOG (Termux SWI-Prolog)
% ==============================================================================

:- use_module(library(lists)).
:- use_module(library(system)).
:- use_module(library(readutil)).
:- use_module(library(date)).

% Declaración de predicados dinámicos
:- dynamic tarea/7.        
:- dynamic fijo/5.         
:- dynamic salida_fam/2.   

archivo_datos('datos_horario.pl').

% --- INICIO Y PERSISTENCIA ---

iniciar :-
    cargar_datos,
    writeln('==========================================='),
    writeln('  GESTOR DE HORARIO SEMESTRAL INICIADO'),
    writeln('==========================================='),
    menu.

cargar_datos :-
    archivo_datos(Archivo),
    exists_file(Archivo),
    !,
    consult(Archivo).
cargar_datos. 

guardar_datos :-
    archivo_datos(Archivo),
    tell(Archivo),
    listing(tarea/7),
    listing(fijo/5),
    listing(salida_fam/2),
    told.

% --- MENÚ INTERACTIVO ---

menu :-
    nl, writeln('1. Agregar Horario Fijo (Clases, comidas...)'),
    writeln('2. Agregar Tarea a la Bolsa'),
    writeln('3. Programar Salida Familiar (Bloquear dias)'),
    writeln('4. Generar y Ver Horario'),
    writeln('5. Gestionar Tareas (Completar o Posponer)'),
    writeln('6. Salir y Guardar'),
	writeln('7. Exportar Horario a HTML (NUEVO)'),
    write('Seleccione una opcion (1-7): '), read(Opcion),
    ejecutar(Opcion).

ejecutar(1) :- agregar_fijo, menu.
ejecutar(2) :- agregar_tarea, menu.
ejecutar(3) :- agregar_salida, menu.
ejecutar(4) :- generar_horario, menu.
ejecutar(5) :- gestionar_tareas, menu.
ejecutar(6) :- guardar_datos, writeln('Datos guardados. ¡Hasta pronto!'), !.
ejecutar(7) :- exportar_html, menu.
ejecutar(_) :- writeln('Opcion invalida.'), menu.

% --- INGRESO DE DATOS ---

agregar_fijo :-
    writeln('ID del horario fijo (ej. f1): '), read(ID),
    writeln('Dia de la semana (1=Lun, 7=Dom): '), read(Dia),
    writeln('Hora inicio (HHMM, ej. 1430): '), read(HIni),
    writeln('Hora fin (HHMM, ej. 1600): '), read(HFin),
    writeln('Nombre/Descripcion (entre comillas simples): '), read(Nom),
    hhmm_a_minutos(HIni, MinIni),
    hhmm_a_minutos(HFin, MinFin),
    assertz(fijo(ID, Dia, MinIni, MinFin, Nom)),
    guardar_datos,
    writeln('Horario fijo agregado con exito.').

agregar_tarea :-
    writeln('ID de la tarea (ej. t1): '), read(ID),
    writeln('Nombre de la tarea (entre comillas simples): '), read(Nom),
    writeln('Tiempo estimado en minutos: '), read(TiempoEst),
    writeln('Nivel de esfuerzo (1-10): '), read(Esfuerzo),
    writeln('Fecha limite (formato YYYYMMDD, ej. 20261015): '), read(FechaLim),
    writeln('Hora limite (HHMM, ej. 2359): '), read(HoraLim),
    TiempoSobre is round(TiempoEst * 1.20), 
    hhmm_a_minutos(HoraLim, MinLim),
    assertz(tarea(ID, Nom, TiempoSobre, Esfuerzo, FechaLim, MinLim, pendiente)),
    guardar_datos,
    writeln('Tarea agregada a la bolsa con 20% de tiempo extra.').

agregar_salida :-
    writeln('Fecha inicio SalidaFam (YYYYMMDD): '), read(FIni),
    writeln('Fecha fin SalidaFam (YYYYMMDD): '), read(FFin),
    assertz(salida_fam(FIni, FFin)),
    guardar_datos,
    writeln('Dias bloqueados por Salida Familiar.').

% --- GESTIÓN DE TAREAS (NUEVO) ---

gestionar_tareas :-
    writeln('--- TAREAS PENDIENTES ---'),
    listar_pendientes,
    writeln('Ingrese el ID de la tarea a gestionar (o ''salir'' para cancelar): '), read(ID),
    ( ID == salir -> writeln('Cancelado.')
    ; tarea(ID, Nom, Dur, Esf, FLim, MLim, pendiente) ->
        format('Seleccionada: ~w~n', [Nom]),
        writeln('1. Marcar como Completada'),
        writeln('2. Posponer (Modificar Limite)'),
        writeln('3. Cancelar'),
        write('Opcion: '), read(OpcGest),
        procesar_gestion(OpcGest, ID, Nom, Dur, Esf, FLim, MLim)
    ; writeln('ID no encontrado o la tarea ya esta completada.')
    ).

listar_pendientes :-
    findall(tarea(I, N, D, E, F, M, pendiente), tarea(I, N, D, E, F, M, pendiente), Lista),
    ( Lista == [] -> writeln('No hay tareas pendientes en este momento.')
    ; mostrar_lista_pendientes(Lista)
    ).

mostrar_lista_pendientes([]).
mostrar_lista_pendientes([tarea(I, N, _, _, F, _, _) | T]) :-
    format('ID: ~w | Fecha Limite: ~w | Tarea: ~w~n', [I, F, N]),
    mostrar_lista_pendientes(T).

procesar_gestion(1, ID, Nom, Dur, Esf, FLim, MLim) :-
    retract(tarea(ID, Nom, Dur, Esf, FLim, MLim, pendiente)),
    assertz(tarea(ID, Nom, Dur, Esf, FLim, MLim, completada)),
    guardar_datos,
    writeln('¡Genial! Tarea completada y enviada al historial.').

procesar_gestion(2, ID, Nom, Dur, Esf, FLim, MLim) :-
    writeln('Nueva Fecha limite (YYYYMMDD): '), read(NFecha),
    writeln('Nueva Hora limite (HHMM): '), read(NHora),
    hhmm_a_minutos(NHora, NMin),
    retract(tarea(ID, Nom, Dur, Esf, FLim, MLim, pendiente)),
    assertz(tarea(ID, Nom, Dur, Esf, NFecha, NMin, pendiente)),
    guardar_datos,
    writeln('La tarea ha sido pospuesta con exito y se ha guardado.').

procesar_gestion(_, _, _, _, _, _, _) :-
    writeln('Operacion cancelada. Volviendo al menu.').

% --- LÓGICA DE PRIORIZACIÓN ---

ordenar_tareas(TareasPendientes, TareasOrdenadas) :-
    predsort(comparar_tareas, TareasPendientes, TareasOrdenadas).

comparar_tareas(Delta, tarea(_, _, _, Esf1, F1, H1, _), tarea(_, _, _, Esf2, F2, H2, _)) :-
    (F1 < F2 -> Delta = '<'
    ; F1 > F2 -> Delta = '>'
    ; (H1 < H2 -> Delta = '<'
      ; H1 > H2 -> Delta = '>'
      ; (Esf1 > Esf2 -> Delta = '<'
        ; Esf1 < Esf2 -> Delta = '>'
        ; Delta = '=')
      )
    ).

% --- MOTOR DE GENERACIÓN ---

generar_horario :-
    writeln('--- GENERANDO HORARIO SEMESTRAL ---'),
    findall(tarea(ID, N, D, E, F, M, Est), tarea(ID, N, D, E, F, M, pendiente), Tareas),
    ordenar_tareas(Tareas, TareasOrdenadas),
    get_time(StampActual),
    stamp_date_time(StampActual, DateTime, 'local'),
    date_time_value(date, DateTime, date(Y, Mo, Da)),
    Hoy is (Y * 10000) + (Mo * 100) + Da,
    planificar(TareasOrdenadas, Hoy, 480, Agenda, Advertencias), % 480 = 08:00 AM
    mostrar_agenda(Agenda),
    mostrar_advertencias(Advertencias).

planificar([], _, _, [], []).

planificar([Tarea | RestoTareas], FechaActual, MinutoActual, [Asignacion | RestoAgenda], Advertencias) :-
    Tarea = tarea(ID, Nom, Duracion, Esfuerzo, FechaLim, MinLim, _),
    ( dia_bloqueado(FechaActual) ->
      siguiente_dia(FechaActual, FechaSig),
      planificar([Tarea | RestoTareas], FechaSig, 480, [Asignacion | RestoAgenda], Advertencias)
    ; buscar_hueco(FechaActual, MinutoActual, Duracion, MinutoInicioReal, MinutoFinReal, EspacioDisponible) ->
      verificar_deadline(FechaActual, MinutoFinReal, FechaLim, MinLim, Nom, AdvDeadline),
      ( Duracion =< EspacioDisponible ->
        Asignacion = asignado(Nom, FechaActual, MinutoInicioReal, MinutoFinReal),
        MinutoSiguiente is MinutoFinReal + 30, 
        append(AdvDeadline, AdvResto, Advertencias),
        planificar(RestoTareas, FechaActual, MinutoSiguiente, RestoAgenda, AdvResto)
      ; % SE DIVIDE
        Asignacion = asignado(Nom, FechaActual, MinutoInicioReal, MinutoFinReal),
        DuracionRestante is Duracion - EspacioDisponible,
        DuracionPenalizada is round(DuracionRestante * 1.12),
        TareaRestante = tarea(ID, Nom, DuracionPenalizada, Esfuerzo, FechaLim, MinLim, pendiente),
        siguiente_dia(FechaActual, FechaSig),
        append(AdvDeadline, AdvResto, Advertencias),
        planificar([TareaRestante | RestoTareas], FechaSig, 480, RestoAgenda, AdvResto)
      )
    ; % Si no hay huecos hoy
      siguiente_dia(FechaActual, FechaSig),
      planificar([Tarea | RestoTareas], FechaSig, 480, [Asignacion | RestoAgenda], Advertencias)
    ).

% --- REGLAS AUXILIARES Y HUECOS ---

buscar_hueco(Fecha, MinutoActual, Duracion, MinInicio, MinFin, EspacioDisponible) :-
    MinutoActual < 1320, % Límite de las 22:00
    dia_semana(Fecha, DS),
    ( fijo(_, DS, FijoIni, FijoFin, _) , MinutoActual >= FijoIni , MinutoActual < FijoFin ->
      MinSiguiente is FijoFin,
      buscar_hueco(Fecha, MinSiguiente, Duracion, MinInicio, MinFin, EspacioDisponible)
    ;
      MinInicio = MinutoActual,
      findall(Ini, (fijo(_, DS, Ini, _, _), Ini > MinutoActual), Inicios),
      ( Inicios \= [] ->
        min_list(Inicios, ProxFijoIni),
        EspacioDisponible is ProxFijoIni - MinInicio
      ; EspacioDisponible is 1320 - MinInicio
      ),
      ( EspacioDisponible =< 0 ->
        MinSiguiente is MinInicio + 1,
        buscar_hueco(Fecha, MinSiguiente, Duracion, MinInicio, MinFin, EspacioDisponible)
      ; MinFin is MinInicio + EspacioDisponible
      )
    ).

verificar_deadline(FechaReal, HoraReal, FechaLim, HoraLim, Nom, [Adv]) :-
    ( FechaReal > FechaLim ; (FechaReal == FechaLim, HoraReal > HoraLim) ),
    !,
    atom_concat('SATURACION/IMPOSIBLE: Tarea ', Nom, T1),
    atom_concat(T1, ' sobrepasa su limite estricto.', Adv).
verificar_deadline(_, _, _, _, _, []).

dia_bloqueado(Fecha) :-
    salida_fam(FIni, FFin),
    Fecha >= FIni, Fecha =< FFin.

% Helpers de conversión
hhmm_a_minutos(HHMM, Minutos) :-
    Horas is HHMM // 100, Mins is HHMM mod 100, Minutos is (Horas * 60) + Mins.

minutos_a_hhmm(Minutos, HHMM) :-
    Horas is Minutos // 60, Mins is Minutos mod 60, HHMM is (Horas * 100) + Mins.

% Funciones de calendario reales
siguiente_dia(Fecha, FechaSig) :-
    Y is Fecha // 10000, M is (Fecha // 100) mod 100, D is Fecha mod 100,
    date_time_stamp(date(Y, M, D, 12, 0, 0, 0, -, -), Stamp),
    StampSig is Stamp + 86400.0,
    stamp_date_time(StampSig, DateTime, 'UTC'),
    date_time_value(date, DateTime, date(YS, MS, DS)),
    FechaSig is (YS * 10000) + (MS * 100) + DS.

dia_semana(Fecha, DS) :-
    Y is Fecha // 10000, M is (Fecha // 100) mod 100, D is Fecha mod 100,
    day_of_the_week(date(Y, M, D), DS).

% --- PRESENTACIÓN ---

mostrar_agenda([]).
mostrar_agenda([asignado(Nom, Fecha, MinIni, MinFin) | T]) :-
    minutos_a_hhmm(MinIni, H1), minutos_a_hhmm(MinFin, H2),
    format('~w | ~w - ~w : ~w~n', [Fecha, H1, H2, Nom]),
    mostrar_agenda(T).

mostrar_advertencias([]).
mostrar_advertencias([Adv | T]) :-
    format('!!! ADVERTENCIA: ~w~n', [Adv]),
    mostrar_advertencias(T).
	
	
% --- EXPORTACIÓN A HTML ---

exportar_html :-
    writeln('--- EXPORTANDO A HTML ---'),
    findall(tarea(ID, N, D, E, F, M, Est), tarea(ID, N, D, E, F, M, pendiente), Tareas),
    ordenar_tareas(Tareas, TareasOrdenadas),
    get_time(StampActual),
    stamp_date_time(StampActual, DateTime, 'local'),
    date_time_value(date, DateTime, date(Y, Mo, Da)),
    Hoy is (Y * 10000) + (Mo * 100) + Da,
    planificar(TareasOrdenadas, Hoy, 480, Agenda, Advertencias),
    tell('horario.html'),
    escribir_cabecera_html,
    escribir_agenda_html(Agenda, 0), % 0 es el 'Día Anterior' inicial
    escribir_advertencias_html(Advertencias),
    escribir_pie_html,
    told,
    writeln('¡Exito! Archivo horario.html generado.').

escribir_cabecera_html :-
    writeln('<!DOCTYPE html><html lang="es"><head><meta charset="UTF-8">'),
    writeln('<meta name="viewport" content="width=device-width, initial-scale=1.0">'),
    writeln('<title>Mi Horario Semestral</title>'),
    writeln('<style>'),
    writeln('body { font-family: "Segoe UI", Arial, sans-serif; background: #f0f2f5; padding: 20px; color: #333; }'),
    writeln('.container { max-width: 600px; margin: 0 auto; }'),
    writeln('h1 { text-align: center; color: #1a73e8; }'),
    writeln('.dia { font-size: 1.3em; color: #5f6368; margin-top: 30px; border-bottom: 2px solid #dadce0; padding-bottom: 5px; font-weight: bold; }'),
    writeln('.item { background: #fff; padding: 15px; margin: 10px 0; border-radius: 8px; box-shadow: 0 1px 3px rgba(0,0,0,0.12); border-left: 5px solid #34a853; display: flex; flex-direction: column;}'),
    writeln('.tiempo { font-weight: bold; color: #1a73e8; font-size: 1.1em; margin-bottom: 5px; }'),
    writeln('.tarea { font-size: 1.05em; }'),
    writeln('.adv { background: #fce8e6; border-left: 5px solid #ea4335; padding: 15px; margin: 10px 0; border-radius: 8px; color: #c5221f; font-weight: bold; }'),
    writeln('</style></head><body><div class="container"><h1>📅 Mi Horario</h1>').

escribir_pie_html :-
    writeln('</div></body></html>').

escribir_agenda_html([], _).
escribir_agenda_html([asignado(Nom, Fecha, MinIni, MinFin) | T], DiaAnterior) :-
    ( Fecha \== DiaAnterior ->
      format('<div class="dia">Fecha: ~w</div>~n', [Fecha])
    ; true
    ),
    minutos_a_hhmm(MinIni, H1), minutos_a_hhmm(MinFin, H2),
    format('<div class="item"><span class="tiempo">⏰ ~w - ~w</span><span class="tarea">~w</span></div>~n', [H1, H2, Nom]),
    escribir_agenda_html(T, Fecha).

escribir_advertencias_html([]).
escribir_advertencias_html([Adv | T]) :-
    format('<div class="adv">⚠️ ~w</div>~n', [Adv]),
    escribir_advertencias_html(T).