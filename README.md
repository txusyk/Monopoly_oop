# Monopoly_oop
This is the backup of OOP Monopoly (programmed 2 years ago, on the first year of IT degree)

## Descripción del proyecto

Decidimos elegir Monopoly por la cantidad de opciones que podíamos añadir y la facilidad para combinar diferentes estructuras de datos en un mismo proyecto. Así mismo intentamos seleccionar un proyecto que no fuera demasiado sencillo, pero que pudiera ser adaptado y simplificado en caso de necesidad o requerimiento. Sus principales características son:
	Mantiene la estructura de calles original. Simplificando ciertas operaciones relativas a las rentas o a la gestión de las edificaciones en las propiedades. Otras simplemente adaptándolas a la jugabilidad de la que hemos querido dotar al juego.
	Hay casillas que se pueden comprar y otras neutrales. Al igual que en el juego original.
	Existen varios tableros creados a disposición de los jugadores. Así mismo existe la posibilidad de crear un tablero personalizado desde el ‘Editor de mapas’.
	Se tiene en cuenta los dobles para volver a tirar. Y en caso de 3 dobles seguidos, se envía al jugador a la cárcel.
	Existe la posibilidad, al igual que en el juego original, de edificar sobre Calles de Propiedades siempre que se posean todas las calles del tipo indicado. A diferencia del original, permitimos edificar de forma independiente, siempre que se cumpla la condición anterior mente mencionada.
	Se gestiona la estancia en la cárcel como parte del turno, pero de forma independiente. Manteniendo al jugador hasta que obtenga dobles y salga o bien pague la multa. Dejando en manos del jugador en todo momento la toma de decisión.
  
  ## Planificación
  
  ###Josu:
Diseño: Diseño del diagrama de clases inicial. Diseño de los diagramas de secuencia.
Clases: JugarPartida, Monopoly, CargarFicheros, Condena, Dado, Tablero, ListaJugadores, ListaCartas, TableroGrafico, Jugador, Teclado
jUnits: ListaCartasTest, CartaTest, CartaMovimientoTest, CartaSaldoTest, JugadorTest, ListaCallesTest, ListaJugadoresTest, TableroTest, CondenaTest
###David:
Diseño: Diagramas UML de los objetivos finales y de esta misma entrega.
Clases: Calle, CalleCarcel, CalleCartas, CalleEstaciones, CalleEstandar, CalleImpuestos, CalleSalida, CalleParking, CartaMovimiento, CartaSaldo
jUnits: CalleCarcelTest, CalleEstacionesTest, CalleEstandarTest, CalleImpuestosTest, CalleParkingTest, CalleSalidaTest, CalleServiciosTest, CalleTest
###En común:
Diseño: Los aspectos de diseño han sido revisados y corregidos (rediseñados) en las reuniones de grupo. Redacción de los documentos del proyecto.
Clases: JugarPartida, Monopoly, Condena, CalleEstaciones, CalleEstandar, CalleImpuestos. Han sido revisadas entre los dos dado que son partes troncales del funcionamiento del programa.
jUnits: Las jUnits las hemos considerado en todo momento trabajo personal. Por lo tanto no ha habido trabajo en grupo para hacerlas.
  
  ##JUnits
  
  Se han realizado las jUnits de todas las clases del proyecto excepto: 
CargarFicheros: Es un cargar a medida, si nos diera cualquier problema el tablero no se crearía correctamente y por tanto el jUnit del tablero nos indicaría el fallo.
Monopoly: Es el main. Somos capaces de saber como actúa solo con las respuestas que obtenemos desde consola.
JugarPartida: Ocurre lo mismo que con el main. Nos es mas sencillo debuggear y comprobar por consola que hacer las jUnits de esta clase.

## Conclusiones
Hemos visto que pese a tener un diseño inicial bastante sólido, hemos tenido que hacer infinidad de cambios y adaptaciones para hacerlo funcionar con los criterios que habíamos establecido. Aun así, hemos tenido que adaptar ciertas partes de forma inevitable dado que no obteníamos los resultados que pretendíamos. Así mismo, creemos que nos habría sido mas fácil el trabajo si hubiéramos contado desde un comienzo con un buen diagrama de secuencia (o con uno, al menos).
No es conveniente comenzar a programar sin disponer de un diseño probado y revisado. Hemos tratado de implementar alguna de las clases que han surgido, sin disponer primero de un diseño general y surgen mas dudas y problemas que lo que se consigue solucionar. O bien, queda el código ensuciado a base de replicar código inútil o disponer de métodos que no deberían existir.
Es necesario distribuir correctamente el trabajo. Organizar reuniones semanales para al menos, ponernos al día sobre el trabajo de los compañeros. Y compartir, muy importante compartir código y conocimientos.
Es necesario tener claro si se va a continuar con la asignatura, o si se tiene tiempo suficiente para afrontar el proyecto. Principalmente, para evitar delegar todo el trabajo a tus compañeros.
